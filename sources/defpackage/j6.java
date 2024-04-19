package defpackage;
/* compiled from: GuidelineReference.java */
/* renamed from: j6  reason: default package */
/* loaded from: classes.dex */
public class j6 extends p6 {
    public j6(t5 t5Var) {
        super(t5Var);
        t5Var.d.c();
        t5Var.e.c();
        this.f = ((v5) t5Var).y0;
    }

    public final void a(g6 g6Var) {
        this.h.k.add(g6Var);
        g6Var.l.add(this.h);
    }

    @Override // defpackage.p6
    public void b() {
        t5 t5Var = this.b;
        if (((v5) t5Var).y0 == 1) {
            t5Var.b0 = this.h.g;
        } else {
            t5Var.c0 = this.h.g;
        }
    }

    @Override // defpackage.p6
    public void c() {
        this.h.a();
    }

    @Override // defpackage.p6
    public boolean e() {
        return false;
    }

    @Override // defpackage.p6, defpackage.e6
    public void a(e6 e6Var) {
        g6 g6Var = this.h;
        if (g6Var.c && !g6Var.j) {
            this.h.a((int) ((g6Var.l.get(0).g * ((v5) this.b).u0) + 0.5f));
        }
    }

    @Override // defpackage.p6
    public void a() {
        t5 t5Var = this.b;
        v5 v5Var = (v5) t5Var;
        int i = v5Var.v0;
        int i2 = v5Var.w0;
        float f = v5Var.u0;
        if (v5Var.y0 == 1) {
            if (i != -1) {
                this.h.l.add(t5Var.W.d.h);
                this.b.W.d.h.k.add(this.h);
                this.h.f = i;
            } else if (i2 != -1) {
                this.h.l.add(t5Var.W.d.i);
                this.b.W.d.i.k.add(this.h);
                this.h.f = -i2;
            } else {
                g6 g6Var = this.h;
                g6Var.b = true;
                g6Var.l.add(t5Var.W.d.i);
                this.b.W.d.i.k.add(this.h);
            }
            a(this.b.d.h);
            a(this.b.d.i);
            return;
        }
        if (i != -1) {
            this.h.l.add(t5Var.W.e.h);
            this.b.W.e.h.k.add(this.h);
            this.h.f = i;
        } else if (i2 != -1) {
            this.h.l.add(t5Var.W.e.i);
            this.b.W.e.i.k.add(this.h);
            this.h.f = -i2;
        } else {
            g6 g6Var2 = this.h;
            g6Var2.b = true;
            g6Var2.l.add(t5Var.W.e.i);
            this.b.W.e.i.k.add(this.h);
        }
        a(this.b.e.h);
        a(this.b.e.i);
    }
}
