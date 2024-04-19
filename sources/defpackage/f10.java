package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import defpackage.w90;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: PageManager.java */
/* renamed from: f10  reason: default package */
/* loaded from: classes.dex */
public class f10 {

    /* compiled from: PageManager.java */
    /* renamed from: f10$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final f10 a = new f10(null);
    }

    public /* synthetic */ f10(a aVar) {
    }

    public int a(final Uri uri) {
        Callable callable;
        Log.i("PageManager", "openPage() called with: uri = [" + uri + "]");
        if (uri == null) {
            return 1;
        }
        String queryParameter = uri.getQueryParameter("page");
        int i = 0;
        if (uri.getPath() != null && uri.getPath().contains("sys")) {
            if ("solar_roof".equals(queryParameter)) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.showSolarRoofDialog");
                intent.setPackage(ActivityThread.currentApplication().getPackageName());
                intent.setClassName(ActivityThread.currentApplication().getPackageName(), "com.xiaopeng.chargecontrol.app.SolarRoofDialogService");
                ActivityThread.currentApplication().startService(intent);
                return a(ActivityThread.currentApplication(), "com.xiaopeng.chargecontrol.app.SolarRoofDialogService") ? 2 : 0;
            } else if ("trunk_power".equals(queryParameter)) {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.showTrunkPowerDialog");
                intent2.setPackage(ActivityThread.currentApplication().getPackageName());
                intent2.setClassName(ActivityThread.currentApplication().getPackageName(), "com.xiaopeng.chargecontrol.app.TrunkPowerDialogService");
                ActivityThread.currentApplication().startService(intent2);
                return a(ActivityThread.currentApplication(), "com.xiaopeng.chargecontrol.app.TrunkPowerDialogService") ? 2 : 0;
            } else {
                return 1;
            }
        }
        final Activity activity = w90.b.a.a;
        if (activity instanceof g10) {
            ai0.a(new Callable() { // from class: n00
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean valueOf;
                    valueOf = Boolean.valueOf(((g10) activity).a(uri));
                    return valueOf;
                }
            }, "supplier is null");
            return !((Boolean) z90.a((ah0) new zi0(callable)).b(hh0.a()).a()).booleanValue();
        }
        String packageName = ActivityThread.currentApplication().getPackageName();
        Intent intent3 = new Intent(packageName);
        intent3.setAction("android.intent.action.VIEW");
        intent3.addCategory("android.intent.category.DEFAULT");
        intent3.setData(uri);
        List<ResolveInfo> queryIntentActivities = ActivityThread.currentApplication().getPackageManager().queryIntentActivities(intent3, 128);
        if (!queryIntentActivities.isEmpty()) {
            intent3.setClassName(packageName, queryIntentActivities.get(0).activityInfo.targetActivity);
            intent3.setFlags(268435456);
            ActivityThread.currentApplication().startActivity(intent3);
            i = 1;
        }
        return i ^ 1;
    }

    public static boolean a(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(100)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
