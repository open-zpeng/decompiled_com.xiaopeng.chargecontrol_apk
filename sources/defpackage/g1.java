package defpackage;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
/* compiled from: TwilightManager.java */
/* renamed from: g1  reason: default package */
/* loaded from: classes.dex */
public class g1 {
    public static g1 d;
    public final Context a;
    public final LocationManager b;
    public final a c = new a();

    /* compiled from: TwilightManager.java */
    /* renamed from: g1$a */
    /* loaded from: classes.dex */
    public static class a {
        public boolean a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
    }

    public g1(Context context, LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }

    public final Location a(String str) {
        try {
            if (this.b.isProviderEnabled(str)) {
                return this.b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }
}
