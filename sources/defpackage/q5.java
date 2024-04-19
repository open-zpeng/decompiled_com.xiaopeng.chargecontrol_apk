package defpackage;

import defpackage.s5;
import defpackage.t5;
/* compiled from: Barrier.java */
/* renamed from: q5  reason: default package */
/* loaded from: classes.dex */
public class q5 extends x5 {
    public int w0 = 0;
    public boolean x0 = true;
    public int y0 = 0;
    public boolean z0 = false;

    @Override // defpackage.t5
    public void a(k5 k5Var, boolean z) {
        Object[] objArr;
        boolean z2;
        int i;
        int i2;
        s5[] s5VarArr = this.S;
        s5VarArr[0] = this.K;
        s5VarArr[2] = this.L;
        s5VarArr[1] = this.M;
        s5VarArr[3] = this.N;
        int i3 = 0;
        while (true) {
            objArr = this.S;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].i = k5Var.a(objArr[i3]);
            i3++;
        }
        int i4 = this.w0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        s5 s5Var = objArr[i4];
        if (!this.z0) {
            s();
        }
        if (this.z0) {
            this.z0 = false;
            int i5 = this.w0;
            if (i5 == 0 || i5 == 1) {
                k5Var.a(this.K.i, this.b0);
                k5Var.a(this.M.i, this.b0);
                return;
            } else if (i5 == 2 || i5 == 3) {
                k5Var.a(this.L.i, this.c0);
                k5Var.a(this.N.i, this.c0);
                return;
            } else {
                return;
            }
        }
        for (int i6 = 0; i6 < this.v0; i6++) {
            t5 t5Var = this.u0[i6];
            if ((this.x0 || t5Var.b()) && ((((i = this.w0) == 0 || i == 1) && t5Var.f() == t5.a.MATCH_CONSTRAINT && t5Var.K.f != null && t5Var.M.f != null) || (((i2 = this.w0) == 2 || i2 == 3) && t5Var.h() == t5.a.MATCH_CONSTRAINT && t5Var.L.f != null && t5Var.N.f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.K.c() || this.M.c();
        boolean z4 = this.L.c() || this.N.c();
        int i7 = !z2 && ((this.w0 == 0 && z3) || ((this.w0 == 2 && z4) || ((this.w0 == 1 && z3) || (this.w0 == 3 && z4)))) ? 5 : 4;
        for (int i8 = 0; i8 < this.v0; i8++) {
            t5 t5Var2 = this.u0[i8];
            if (this.x0 || t5Var2.b()) {
                n5 a = k5Var.a(t5Var2.S[this.w0]);
                s5[] s5VarArr2 = t5Var2.S;
                int i9 = this.w0;
                s5VarArr2[i9].i = a;
                int i10 = (s5VarArr2[i9].f == null || s5VarArr2[i9].f.d != this) ? 0 : s5VarArr2[i9].g + 0;
                int i11 = this.w0;
                if (i11 != 0 && i11 != 2) {
                    i5 b = k5Var.b();
                    n5 c = k5Var.c();
                    c.g = 0;
                    b.a(s5Var.i, a, c, this.y0 + i10);
                    k5Var.a(b);
                } else {
                    i5 b2 = k5Var.b();
                    n5 c2 = k5Var.c();
                    c2.g = 0;
                    b2.b(s5Var.i, a, c2, this.y0 - i10);
                    k5Var.a(b2);
                }
                k5Var.a(s5Var.i, a, this.y0 + i10, i7);
            }
        }
        int i12 = this.w0;
        if (i12 == 0) {
            k5Var.a(this.M.i, this.K.i, 0, 8);
            k5Var.a(this.K.i, this.W.M.i, 0, 4);
            k5Var.a(this.K.i, this.W.K.i, 0, 0);
        } else if (i12 == 1) {
            k5Var.a(this.K.i, this.M.i, 0, 8);
            k5Var.a(this.K.i, this.W.K.i, 0, 4);
            k5Var.a(this.K.i, this.W.M.i, 0, 0);
        } else if (i12 == 2) {
            k5Var.a(this.N.i, this.L.i, 0, 8);
            k5Var.a(this.L.i, this.W.N.i, 0, 4);
            k5Var.a(this.L.i, this.W.L.i, 0, 0);
        } else if (i12 == 3) {
            k5Var.a(this.L.i, this.N.i, 0, 8);
            k5Var.a(this.L.i, this.W.L.i, 0, 4);
            k5Var.a(this.L.i, this.W.N.i, 0, 0);
        }
    }

    @Override // defpackage.t5
    public boolean b() {
        return true;
    }

    @Override // defpackage.t5
    public boolean o() {
        return this.z0;
    }

    @Override // defpackage.t5
    public boolean p() {
        return this.z0;
    }

    public boolean s() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.v0;
            if (i4 >= i) {
                break;
            }
            t5 t5Var = this.u0[i4];
            if ((this.x0 || t5Var.b()) && ((((i2 = this.w0) == 0 || i2 == 1) && !t5Var.o()) || (((i3 = this.w0) == 2 || i3 == 3) && !t5Var.p()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.v0; i6++) {
            t5 t5Var2 = this.u0[i6];
            if (this.x0 || t5Var2.b()) {
                if (!z2) {
                    int i7 = this.w0;
                    if (i7 == 0) {
                        i5 = t5Var2.a(s5.a.LEFT).a();
                    } else if (i7 == 1) {
                        i5 = t5Var2.a(s5.a.RIGHT).a();
                    } else if (i7 == 2) {
                        i5 = t5Var2.a(s5.a.TOP).a();
                    } else if (i7 == 3) {
                        i5 = t5Var2.a(s5.a.BOTTOM).a();
                    }
                    z2 = true;
                }
                int i8 = this.w0;
                if (i8 == 0) {
                    i5 = Math.min(i5, t5Var2.a(s5.a.LEFT).a());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, t5Var2.a(s5.a.RIGHT).a());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, t5Var2.a(s5.a.TOP).a());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, t5Var2.a(s5.a.BOTTOM).a());
                }
            }
        }
        int i9 = i5 + this.y0;
        int i10 = this.w0;
        if (i10 != 0 && i10 != 1) {
            c(i9, i9);
        } else {
            b(i9, i9);
        }
        this.z0 = true;
        return true;
    }

    public int t() {
        int i = this.w0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // defpackage.t5
    public String toString() {
        String a = jg.a(jg.a("[Barrier] "), this.k0, " {");
        for (int i = 0; i < this.v0; i++) {
            t5 t5Var = this.u0[i];
            if (i > 0) {
                a = jg.a(a, ", ");
            }
            StringBuilder a2 = jg.a(a);
            a2.append(t5Var.k0);
            a = a2.toString();
        }
        return jg.a(a, "}");
    }
}
