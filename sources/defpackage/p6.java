package defpackage;

import defpackage.t5;
/* compiled from: WidgetRun.java */
/* renamed from: p6  reason: default package */
/* loaded from: classes.dex */
public abstract class p6 implements e6 {
    public int a;
    public t5 b;
    public m6 c;
    public t5.a d;
    public h6 e = new h6(this);
    public int f = 0;
    public boolean g = false;
    public g6 h = new g6(this);
    public g6 i = new g6(this);
    public a j = a.NONE;

    /* compiled from: WidgetRun.java */
    /* renamed from: p6$a */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public p6(t5 t5Var) {
        this.b = t5Var;
    }

    public final g6 a(s5 s5Var) {
        s5 s5Var2 = s5Var.f;
        if (s5Var2 == null) {
            return null;
        }
        t5 t5Var = s5Var2.d;
        int ordinal = s5Var2.e.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal != 5) {
                            return null;
                        }
                        return t5Var.e.k;
                    }
                    return t5Var.e.i;
                }
                return t5Var.d.i;
            }
            return t5Var.e.h;
        }
        return t5Var.d.h;
    }

    public abstract void a();

    @Override // defpackage.e6
    public void a(e6 e6Var) {
    }

    public abstract void b();

    public abstract void c();

    public long d() {
        h6 h6Var = this.e;
        if (h6Var.j) {
            return h6Var.g;
        }
        return 0L;
    }

    public abstract boolean e();

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        if (r4.a == 3) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.s5 r11, defpackage.s5 r12, int r13) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p6.a(s5, s5, int):void");
    }

    public final int a(int i, int i2) {
        int max;
        if (i2 == 0) {
            t5 t5Var = this.b;
            int i3 = t5Var.w;
            max = Math.max(t5Var.v, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            t5 t5Var2 = this.b;
            int i4 = t5Var2.z;
            max = Math.max(t5Var2.y, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public final g6 a(s5 s5Var, int i) {
        s5 s5Var2 = s5Var.f;
        if (s5Var2 == null) {
            return null;
        }
        t5 t5Var = s5Var2.d;
        p6 p6Var = i == 0 ? t5Var.d : t5Var.e;
        int ordinal = s5Var.f.e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return p6Var.h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return p6Var.i;
        }
        return null;
    }

    public final void a(g6 g6Var, g6 g6Var2, int i) {
        g6Var.l.add(g6Var2);
        g6Var.f = i;
        g6Var2.k.add(g6Var);
    }

    public final void a(g6 g6Var, g6 g6Var2, int i, h6 h6Var) {
        g6Var.l.add(g6Var2);
        g6Var.l.add(this.e);
        g6Var.h = i;
        g6Var.i = h6Var;
        g6Var2.k.add(g6Var);
        h6Var.k.add(g6Var);
    }
}
