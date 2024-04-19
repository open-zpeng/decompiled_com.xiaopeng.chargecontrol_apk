package defpackage;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
/* compiled from: LogTime.java */
/* renamed from: oq  reason: default package */
/* loaded from: classes.dex */
public final class oq {
    public static final double a;

    static {
        int i = Build.VERSION.SDK_INT;
        a = 1.0d / Math.pow(10.0d, 6.0d);
    }

    @TargetApi(17)
    public static long a() {
        int i = Build.VERSION.SDK_INT;
        return SystemClock.elapsedRealtimeNanos();
    }

    public static double a(long j) {
        return (a() - j) * a;
    }
}
