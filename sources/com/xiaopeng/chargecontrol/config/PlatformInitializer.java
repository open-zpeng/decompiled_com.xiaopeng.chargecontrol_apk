package com.xiaopeng.chargecontrol.config;

import android.content.Context;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class PlatformInitializer implements yf<Object> {
    @Override // defpackage.yf
    public Object a(Context context) {
        ApiPublisherProvider.CONTEXT = context.getApplicationContext();
        c70.a(0, q60.class);
        c70.a(1, g30.class);
        c70.a(2, n20.class);
        c70.a(3, s20.class);
        c70.a(4, w20.class);
        c70.a(5, e20.class);
        c70.a(6, q40.class);
        c70.a(7, k40.class);
        c70.a(8, g40.class);
        c70.a(9, n40.class);
        c70.a.add(new j80());
        c70.a.add(new d80());
        if (a70.d()) {
            c70.a.clear();
            c70.a.add(new k80());
            c70.a.add(new d80());
            c70.a.add(new h80());
        }
        c70.a.add(new f80());
        c70.a.add(new e80());
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(context));
        Module.get(IpcModuleEntry.class).get(IIpcService.class);
        return new Object();
    }

    @Override // defpackage.yf
    public List<Class<? extends yf<?>>> a() {
        return Collections.emptyList();
    }
}
