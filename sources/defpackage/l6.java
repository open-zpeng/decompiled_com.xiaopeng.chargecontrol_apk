package defpackage;

import defpackage.g6;
import defpackage.p6;
import defpackage.s5;
import defpackage.t5;
/* compiled from: HorizontalWidgetRun.java */
/* renamed from: l6  reason: default package */
/* loaded from: classes.dex */
public class l6 extends p6 {
    public static int[] k = new int[2];

    public l6(t5 t5Var) {
        super(t5Var);
        this.h.e = g6.a.LEFT;
        this.i.e = g6.a.RIGHT;
        this.f = 0;
    }

    @Override // defpackage.p6
    public void a() {
        t5 t5Var;
        t5 t5Var2;
        t5 t5Var3;
        int i;
        t5 t5Var4;
        t5 t5Var5 = this.b;
        if (t5Var5.a) {
            this.e.a(t5Var5.i());
        }
        if (!this.e.j) {
            this.d = this.b.f();
            t5.a aVar = this.d;
            if (aVar != t5.a.MATCH_CONSTRAINT) {
                if (aVar == t5.a.MATCH_PARENT && (t5Var4 = this.b.W) != null && (t5Var4.f() == t5.a.FIXED || t5Var4.f() == t5.a.MATCH_PARENT)) {
                    int i2 = (t5Var4.i() - this.b.K.b()) - this.b.M.b();
                    a(this.h, t5Var4.d.h, this.b.K.b());
                    a(this.i, t5Var4.d.i, -this.b.M.b());
                    this.e.a(i2);
                    return;
                } else if (this.d == t5.a.FIXED) {
                    this.e.a(this.b.i());
                }
            }
        } else if (this.d == t5.a.MATCH_PARENT && (t5Var = this.b.W) != null && (t5Var.f() == t5.a.FIXED || t5Var.f() == t5.a.MATCH_PARENT)) {
            a(this.h, t5Var.d.h, this.b.K.b());
            a(this.i, t5Var.d.i, -this.b.M.b());
            return;
        }
        if (this.e.j) {
            t5 t5Var6 = this.b;
            if (t5Var6.a) {
                s5[] s5VarArr = t5Var6.S;
                if (s5VarArr[0].f != null && s5VarArr[1].f != null) {
                    if (t5Var6.l()) {
                        this.h.f = this.b.S[0].b();
                        this.i.f = -this.b.S[1].b();
                        return;
                    }
                    g6 a = a(this.b.S[0]);
                    if (a != null) {
                        g6 g6Var = this.h;
                        int b = this.b.S[0].b();
                        g6Var.l.add(a);
                        g6Var.f = b;
                        a.k.add(g6Var);
                    }
                    g6 a2 = a(this.b.S[1]);
                    if (a2 != null) {
                        g6 g6Var2 = this.i;
                        g6Var2.l.add(a2);
                        g6Var2.f = -this.b.S[1].b();
                        a2.k.add(g6Var2);
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
                t5 t5Var7 = this.b;
                s5[] s5VarArr2 = t5Var7.S;
                if (s5VarArr2[0].f != null) {
                    g6 a3 = a(s5VarArr2[0]);
                    if (a3 != null) {
                        g6 g6Var3 = this.h;
                        int b2 = this.b.S[0].b();
                        g6Var3.l.add(a3);
                        g6Var3.f = b2;
                        a3.k.add(g6Var3);
                        a(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                } else if (s5VarArr2[1].f != null) {
                    g6 a4 = a(s5VarArr2[1]);
                    if (a4 != null) {
                        g6 g6Var4 = this.i;
                        g6Var4.l.add(a4);
                        g6Var4.f = -this.b.S[1].b();
                        a4.k.add(g6Var4);
                        a(this.h, this.i, -this.e.g);
                        return;
                    }
                    return;
                } else if ((t5Var7 instanceof w5) || t5Var7.W == null || t5Var7.a(s5.a.CENTER).f != null) {
                    return;
                } else {
                    t5 t5Var8 = this.b;
                    a(this.h, t5Var8.W.d.h, t5Var8.j());
                    a(this.i, this.h, this.e.g);
                    return;
                }
            }
        }
        if (this.d == t5.a.MATCH_CONSTRAINT && (i = (t5Var3 = this.b).s) != 0) {
            if (i == 2) {
                t5 t5Var9 = t5Var3.W;
                if (t5Var9 != null) {
                    h6 h6Var = t5Var9.e.e;
                    this.e.l.add(h6Var);
                    h6Var.k.add(this.e);
                    h6 h6Var2 = this.e;
                    h6Var2.b = true;
                    h6Var2.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3) {
                if (t5Var3.t == 3) {
                    this.h.a = this;
                    this.i.a = this;
                    n6 n6Var = t5Var3.e;
                    n6Var.h.a = this;
                    n6Var.i.a = this;
                    this.e.a = this;
                    if (t5Var3.m()) {
                        this.e.l.add(this.b.e.e);
                        this.b.e.e.k.add(this.e);
                        n6 n6Var2 = this.b.e;
                        n6Var2.e.a = this;
                        this.e.l.add(n6Var2.h);
                        this.e.l.add(this.b.e.i);
                        this.b.e.h.k.add(this.e);
                        this.b.e.i.k.add(this.e);
                    } else if (this.b.l()) {
                        this.b.e.e.l.add(this.e);
                        this.e.k.add(this.b.e.e);
                    } else {
                        this.b.e.e.l.add(this.e);
                    }
                } else {
                    h6 h6Var3 = t5Var3.e.e;
                    this.e.l.add(h6Var3);
                    h6Var3.k.add(this.e);
                    this.b.e.h.k.add(this.e);
                    this.b.e.i.k.add(this.e);
                    h6 h6Var4 = this.e;
                    h6Var4.b = true;
                    h6Var4.k.add(this.h);
                    this.e.k.add(this.i);
                    this.h.l.add(this.e);
                    this.i.l.add(this.e);
                }
            }
        }
        t5 t5Var10 = this.b;
        s5[] s5VarArr3 = t5Var10.S;
        if (s5VarArr3[0].f != null && s5VarArr3[1].f != null) {
            if (t5Var10.l()) {
                this.h.f = this.b.S[0].b();
                this.i.f = -this.b.S[1].b();
                return;
            }
            g6 a5 = a(this.b.S[0]);
            g6 a6 = a(this.b.S[1]);
            if (a5 != null) {
                a5.k.add(this);
                if (a5.j) {
                    a(this);
                }
            }
            if (a6 != null) {
                a6.k.add(this);
                if (a6.j) {
                    a(this);
                }
            }
            this.j = p6.a.CENTER;
            return;
        }
        t5 t5Var11 = this.b;
        s5[] s5VarArr4 = t5Var11.S;
        if (s5VarArr4[0].f != null) {
            g6 a7 = a(s5VarArr4[0]);
            if (a7 != null) {
                g6 g6Var5 = this.h;
                int b3 = this.b.S[0].b();
                g6Var5.l.add(a7);
                g6Var5.f = b3;
                a7.k.add(g6Var5);
                a(this.i, this.h, 1, this.e);
            }
        } else if (s5VarArr4[1].f != null) {
            g6 a8 = a(s5VarArr4[1]);
            if (a8 != null) {
                g6 g6Var6 = this.i;
                g6Var6.l.add(a8);
                g6Var6.f = -this.b.S[1].b();
                a8.k.add(g6Var6);
                a(this.h, this.i, -1, this.e);
            }
        } else if ((t5Var11 instanceof w5) || (t5Var2 = t5Var11.W) == null) {
        } else {
            a(this.h, t5Var2.d.h, t5Var11.j());
            a(this.i, this.h, 1, this.e);
        }
    }

    @Override // defpackage.p6
    public void b() {
        g6 g6Var = this.h;
        if (g6Var.j) {
            this.b.b0 = g6Var.g;
        }
    }

    @Override // defpackage.p6
    public void c() {
        this.c = null;
        this.h.a();
        this.i.a();
        this.e.a();
        this.g = false;
    }

    @Override // defpackage.p6
    public boolean e() {
        return this.d != t5.a.MATCH_CONSTRAINT || this.b.s == 0;
    }

    public void f() {
        this.g = false;
        this.h.a();
        this.h.j = false;
        this.i.a();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder a = jg.a("HorizontalRun ");
        a.append(this.b.k0);
        return a.toString();
    }

    public final void a(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else if (i5 != 1) {
                return;
            } else {
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6 && i7 <= i7) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i6 > i6 || i9 > i7) {
        } else {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0297, code lost:
        if (r14 != 1) goto L131;
     */
    @Override // defpackage.p6, defpackage.e6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.e6 r17) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l6.a(e6):void");
    }
}
