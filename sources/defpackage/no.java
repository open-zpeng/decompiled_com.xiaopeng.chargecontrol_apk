package defpackage;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import defpackage.lo;
import defpackage.ug;
/* compiled from: DefaultConnectivityMonitor.java */
/* renamed from: no  reason: default package */
/* loaded from: classes.dex */
public final class no implements lo {
    public final Context c;
    public final lo.a d;
    public boolean e;
    public boolean f;
    public final BroadcastReceiver g = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* renamed from: no$a */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            no noVar = no.this;
            boolean z = noVar.e;
            noVar.e = noVar.a(context);
            if (z != no.this.e) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    StringBuilder a = jg.a("connectivity changed, isConnected: ");
                    a.append(no.this.e);
                    Log.d("ConnectivityMonitor", a.toString());
                }
                no noVar2 = no.this;
                ((ug.c) noVar2.d).a(noVar2.e);
            }
        }
    }

    public no(Context context, lo.a aVar) {
        this.c = context.getApplicationContext();
        this.d = aVar;
    }

    @Override // defpackage.ro
    public void a() {
        if (this.f) {
            this.c.unregisterReceiver(this.g);
            this.f = false;
        }
    }

    @Override // defpackage.ro
    public void b() {
    }

    @Override // defpackage.ro
    public void onStart() {
        if (this.f) {
            return;
        }
        this.e = a(this.c);
        try {
            this.c.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        defpackage.a.a(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }
}
