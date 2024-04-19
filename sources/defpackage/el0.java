package defpackage;
/* compiled from: SegmentPool.java */
/* renamed from: el0  reason: default package */
/* loaded from: classes.dex */
public final class el0 {
    public static dl0 a;
    public static long b;

    public static dl0 a() {
        synchronized (el0.class) {
            if (a != null) {
                dl0 dl0Var = a;
                a = dl0Var.f;
                dl0Var.f = null;
                b -= 8192;
                return dl0Var;
            }
            return new dl0();
        }
    }
}
