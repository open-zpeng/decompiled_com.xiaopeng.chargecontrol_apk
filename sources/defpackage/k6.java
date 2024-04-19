package defpackage;

import defpackage.g6;
/* compiled from: HelperReferences.java */
/* renamed from: k6  reason: default package */
/* loaded from: classes.dex */
public class k6 extends p6 {
    public k6(t5 t5Var) {
        super(t5Var);
    }

    public final void a(g6 g6Var) {
        this.h.k.add(g6Var);
        g6Var.l.add(this.h);
    }

    @Override // defpackage.p6
    public void b() {
        t5 t5Var = this.b;
        if (t5Var instanceof q5) {
            int i = ((q5) t5Var).w0;
            if (i != 0 && i != 1) {
                t5Var.c0 = this.h.g;
                return;
            }
            this.b.b0 = this.h.g;
        }
    }

    @Override // defpackage.p6
    public void c() {
        this.c = null;
        this.h.a();
    }

    @Override // defpackage.p6
    public boolean e() {
        return false;
    }

    @Override // defpackage.p6
    public void a() {
        t5 t5Var = this.b;
        if (t5Var instanceof q5) {
            g6 g6Var = this.h;
            g6Var.b = true;
            q5 q5Var = (q5) t5Var;
            int i = q5Var.w0;
            boolean z = q5Var.x0;
            int i2 = 0;
            if (i == 0) {
                g6Var.e = g6.a.LEFT;
                while (i2 < q5Var.v0) {
                    t5 t5Var2 = q5Var.u0[i2];
                    if (z || t5Var2.j0 != 8) {
                        g6 g6Var2 = t5Var2.d.h;
                        g6Var2.k.add(this.h);
                        this.h.l.add(g6Var2);
                    }
                    i2++;
                }
                a(this.b.d.h);
                a(this.b.d.i);
            } else if (i == 1) {
                g6Var.e = g6.a.RIGHT;
                while (i2 < q5Var.v0) {
                    t5 t5Var3 = q5Var.u0[i2];
                    if (z || t5Var3.j0 != 8) {
                        g6 g6Var3 = t5Var3.d.i;
                        g6Var3.k.add(this.h);
                        this.h.l.add(g6Var3);
                    }
                    i2++;
                }
                a(this.b.d.h);
                a(this.b.d.i);
            } else if (i == 2) {
                g6Var.e = g6.a.TOP;
                while (i2 < q5Var.v0) {
                    t5 t5Var4 = q5Var.u0[i2];
                    if (z || t5Var4.j0 != 8) {
                        g6 g6Var4 = t5Var4.e.h;
                        g6Var4.k.add(this.h);
                        this.h.l.add(g6Var4);
                    }
                    i2++;
                }
                a(this.b.e.h);
                a(this.b.e.i);
            } else if (i != 3) {
            } else {
                g6Var.e = g6.a.BOTTOM;
                while (i2 < q5Var.v0) {
                    t5 t5Var5 = q5Var.u0[i2];
                    if (z || t5Var5.j0 != 8) {
                        g6 g6Var5 = t5Var5.e.i;
                        g6Var5.k.add(this.h);
                        this.h.l.add(g6Var5);
                    }
                    i2++;
                }
                a(this.b.e.h);
                a(this.b.e.i);
            }
        }
    }

    @Override // defpackage.p6, defpackage.e6
    public void a(e6 e6Var) {
        q5 q5Var = (q5) this.b;
        int i = q5Var.w0;
        int i2 = 0;
        int i3 = -1;
        for (g6 g6Var : this.h.l) {
            int i4 = g6Var.g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i != 0 && i != 2) {
            this.h.a(i2 + q5Var.y0);
        } else {
            this.h.a(i3 + q5Var.y0);
        }
    }
}
