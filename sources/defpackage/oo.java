package defpackage;

import android.content.Context;
import android.util.Log;
import defpackage.lo;
/* compiled from: DefaultConnectivityMonitorFactory.java */
/* renamed from: oo  reason: default package */
/* loaded from: classes.dex */
public class oo implements mo {
    public lo a(Context context, lo.a aVar) {
        boolean z = o7.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        if (z) {
            return new no(context, aVar);
        }
        return new so();
    }
}
