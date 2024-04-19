package com.xiaopeng.chargecontrol.app;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.chargecontrol.VuiObserver;
import com.xiaopeng.chargecontrol.app.App;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.apirouter.server.IManifestHandler;
import com.xiaopeng.lib.apirouter.server.IManifestHelper;
import com.xiaopeng.lib.apirouter.server.ManifestHelper_PowerCenterApp;
import com.xiaopeng.lib.framework.configuration.ConfigurationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.xui.drawable.shimmer.XShimmer;
import defpackage.p80;
import defpackage.w90;
/* loaded from: classes.dex */
public class App extends Application implements pd {
    public static /* synthetic */ IManifestHelper[] b() {
        return new IManifestHelper[]{new ManifestHelper_PowerCenterApp()};
    }

    public final void a() {
        Log.i("App", String.format("ApplicationInfo: flavor: %s, versionName: %s, versionCode: %d", "portraitD55", "V1.6.0_20230921135459_Release-D55", 104957));
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        ApiPublisherProvider.addManifestHandler(new IManifestHandler() { // from class: m00
            @Override // com.xiaopeng.lib.apirouter.server.IManifestHandler
            public final IManifestHelper[] getManifestHelpers() {
                return App.b();
            }
        });
    }

    @Override // defpackage.rd
    public void e(zd zdVar) {
        a();
    }

    @Override // android.app.Application
    public void onCreate() {
        String str;
        super.onCreate();
        if (!a70.c()) {
            ApiPublisherProvider.CONTEXT = getApplicationContext();
            z90.b = true;
            z90.b().setLoglevel(LogUtils.LOG_DEBUG_LEVEL);
            z90.b().disableViewVuiMode();
            z90.b().subscribe(getApplicationContext().getPackageName() + "." + VuiObserver.class.getSimpleName());
            z90.a = this;
            XShimmer.msGlobalEnable = false;
            try {
                str = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, "persist.sys.xp.shared_display.enable");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if ("1".equals(str)) {
                z90.c = true;
            }
            getPackageName();
            Log.i("xpui", z90.c + CFCHelper.SIGNAL_CFC_SPLIT + "0.9.9_HEAD_227f2f2_2023/05/06 07:26:59");
        }
        a();
        kl0 b = jl0.b();
        b.d = false;
        b.b = false;
        b.e = false;
        b.a = false;
        b.a();
        z90.g = da0.a;
        p80.b.a.a();
        CarApi.a(getApplicationContext());
        Module.register(oa0.class, new oa0(ActivityThread.currentApplication()));
        startForegroundService(new Intent(this, CoreService.class));
        w90.b.a.a();
        Module.register(ConfigurationModuleEntry.class, new ConfigurationModuleEntry());
        aa0.a().init(this, "com.xiaopeng.chargecontrol");
        he.k.h.a(this);
    }
}
