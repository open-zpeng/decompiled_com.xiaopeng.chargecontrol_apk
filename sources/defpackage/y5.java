package defpackage;

import defpackage.t5;
/* compiled from: Optimizer.java */
/* renamed from: y5  reason: default package */
/* loaded from: classes.dex */
public class y5 {
    public static boolean[] a = new boolean[3];

    public static void a(u5 u5Var, k5 k5Var, t5 t5Var) {
        t5Var.p = -1;
        t5Var.q = -1;
        if (u5Var.V[0] != t5.a.WRAP_CONTENT && t5Var.V[0] == t5.a.MATCH_PARENT) {
            int i = t5Var.K.g;
            int i2 = u5Var.i() - t5Var.M.g;
            s5 s5Var = t5Var.K;
            s5Var.i = k5Var.a(s5Var);
            s5 s5Var2 = t5Var.M;
            s5Var2.i = k5Var.a(s5Var2);
            k5Var.a(t5Var.K.i, i);
            k5Var.a(t5Var.M.i, i2);
            t5Var.p = 2;
            t5Var.b0 = i;
            t5Var.X = i2 - i;
            int i3 = t5Var.X;
            int i4 = t5Var.e0;
            if (i3 < i4) {
                t5Var.X = i4;
            }
        }
        if (u5Var.V[1] == t5.a.WRAP_CONTENT || t5Var.V[1] != t5.a.MATCH_PARENT) {
            return;
        }
        int i5 = t5Var.L.g;
        int e = u5Var.e() - t5Var.N.g;
        s5 s5Var3 = t5Var.L;
        s5Var3.i = k5Var.a(s5Var3);
        s5 s5Var4 = t5Var.N;
        s5Var4.i = k5Var.a(s5Var4);
        k5Var.a(t5Var.L.i, i5);
        k5Var.a(t5Var.N.i, e);
        if (t5Var.d0 > 0 || t5Var.j0 == 8) {
            s5 s5Var5 = t5Var.O;
            s5Var5.i = k5Var.a(s5Var5);
            k5Var.a(t5Var.O.i, t5Var.d0 + i5);
        }
        t5Var.q = 2;
        t5Var.c0 = i5;
        t5Var.Y = e - i5;
        int i6 = t5Var.Y;
        int i7 = t5Var.f0;
        if (i6 < i7) {
            t5Var.Y = i7;
        }
    }

    public static final boolean a(int i, int i2) {
        return (i & i2) == i2;
    }
}
