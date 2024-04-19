package defpackage;

import defpackage.s5;
import defpackage.t5;
/* compiled from: Guideline.java */
/* renamed from: v5  reason: default package */
/* loaded from: classes.dex */
public class v5 extends t5 {
    public float u0 = -1.0f;
    public int v0 = -1;
    public int w0 = -1;
    public s5 x0 = this.L;
    public int y0 = 0;
    public boolean z0;

    public v5() {
        this.T.clear();
        this.T.add(this.x0);
        int length = this.S.length;
        for (int i = 0; i < length; i++) {
            this.S[i] = this.x0;
        }
    }

    @Override // defpackage.t5
    public s5 a(s5.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.y0 == 1) {
                    return this.x0;
                }
                break;
            case 2:
            case 4:
                if (this.y0 == 0) {
                    return this.x0;
                }
                break;
        }
        return null;
    }

    @Override // defpackage.t5
    public void b(k5 k5Var, boolean z) {
        if (this.W == null) {
            return;
        }
        int b = k5Var.b(this.x0);
        if (this.y0 == 1) {
            this.b0 = b;
            this.c0 = 0;
            i(this.W.e());
            l(0);
            return;
        }
        this.b0 = 0;
        this.c0 = b;
        l(this.W.i());
        i(0);
    }

    @Override // defpackage.t5
    public boolean b() {
        return true;
    }

    public void m(int i) {
        s5 s5Var = this.x0;
        s5Var.b = i;
        s5Var.c = true;
        this.z0 = true;
    }

    public void n(int i) {
        if (this.y0 == i) {
            return;
        }
        this.y0 = i;
        this.T.clear();
        if (this.y0 == 1) {
            this.x0 = this.K;
        } else {
            this.x0 = this.L;
        }
        this.T.add(this.x0);
        int length = this.S.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.S[i2] = this.x0;
        }
    }

    @Override // defpackage.t5
    public boolean o() {
        return this.z0;
    }

    @Override // defpackage.t5
    public boolean p() {
        return this.z0;
    }

    @Override // defpackage.t5
    public void a(k5 k5Var, boolean z) {
        u5 u5Var = (u5) this.W;
        if (u5Var == null) {
            return;
        }
        Object a = u5Var.a(s5.a.LEFT);
        Object a2 = u5Var.a(s5.a.RIGHT);
        t5 t5Var = this.W;
        boolean z2 = t5Var != null && t5Var.V[0] == t5.a.WRAP_CONTENT;
        if (this.y0 == 0) {
            a = u5Var.a(s5.a.TOP);
            a2 = u5Var.a(s5.a.BOTTOM);
            t5 t5Var2 = this.W;
            z2 = t5Var2 != null && t5Var2.V[1] == t5.a.WRAP_CONTENT;
        }
        if (this.z0) {
            s5 s5Var = this.x0;
            if (s5Var.c) {
                n5 a3 = k5Var.a(s5Var);
                k5Var.a(a3, this.x0.a());
                if (this.v0 != -1) {
                    if (z2) {
                        k5Var.b(k5Var.a(a2), a3, 0, 5);
                    }
                } else if (this.w0 != -1 && z2) {
                    n5 a4 = k5Var.a(a2);
                    k5Var.b(a3, k5Var.a(a), 0, 5);
                    k5Var.b(a4, a3, 0, 5);
                }
                this.z0 = false;
                return;
            }
        }
        if (this.v0 != -1) {
            n5 a5 = k5Var.a(this.x0);
            k5Var.a(a5, k5Var.a(a), this.v0, 8);
            if (z2) {
                k5Var.b(k5Var.a(a2), a5, 0, 5);
            }
        } else if (this.w0 != -1) {
            n5 a6 = k5Var.a(this.x0);
            n5 a7 = k5Var.a(a2);
            k5Var.a(a6, a7, -this.w0, 8);
            if (z2) {
                k5Var.b(a6, k5Var.a(a), 0, 5);
                k5Var.b(a7, a6, 0, 5);
            }
        } else if (this.u0 != -1.0f) {
            n5 a8 = k5Var.a(this.x0);
            n5 a9 = k5Var.a(a2);
            float f = this.u0;
            i5 b = k5Var.b();
            b.e.a(a8, -1.0f);
            b.e.a(a9, f);
            k5Var.a(b);
        }
    }
}
