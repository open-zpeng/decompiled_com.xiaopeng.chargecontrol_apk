package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.g6;
import defpackage.p6;
import defpackage.s5;
import defpackage.t5;
/* compiled from: VerticalWidgetRun.java */
/* renamed from: n6  reason: default package */
/* loaded from: classes.dex */
public class n6 extends p6 {
    public g6 k;
    public h6 l;

    public n6(t5 t5Var) {
        super(t5Var);
        this.k = new g6(this);
        this.l = null;
        this.h.e = g6.a.TOP;
        this.i.e = g6.a.BOTTOM;
        this.k.e = g6.a.BASELINE;
        this.f = 1;
    }

    @Override // defpackage.p6, defpackage.e6
    public void a(e6 e6Var) {
        h6 h6Var;
        float f;
        float f2;
        float f3;
        int i;
        int ordinal = this.j.ordinal();
        if (ordinal != 1 && ordinal != 2 && ordinal == 3) {
            t5 t5Var = this.b;
            a(t5Var.L, t5Var.N, 1);
            return;
        }
        h6 h6Var2 = this.e;
        if (h6Var2.c && !h6Var2.j && this.d == t5.a.MATCH_CONSTRAINT) {
            t5 t5Var2 = this.b;
            int i2 = t5Var2.t;
            if (i2 == 2) {
                t5 t5Var3 = t5Var2.W;
                if (t5Var3 != null) {
                    if (t5Var3.e.e.j) {
                        h6Var2.a((int) ((h6Var.g * t5Var2.A) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                h6 h6Var3 = t5Var2.d.e;
                if (h6Var3.j) {
                    int i3 = t5Var2.a0;
                    if (i3 == -1) {
                        f = h6Var3.g;
                        f2 = t5Var2.Z;
                    } else if (i3 == 0) {
                        f3 = h6Var3.g * t5Var2.Z;
                        i = (int) (f3 + 0.5f);
                        this.e.a(i);
                    } else if (i3 == 1) {
                        f = h6Var3.g;
                        f2 = t5Var2.Z;
                    } else {
                        i = 0;
                        this.e.a(i);
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    this.e.a(i);
                }
            }
        }
        g6 g6Var = this.h;
        if (g6Var.c) {
            g6 g6Var2 = this.i;
            if (g6Var2.c) {
                if (g6Var.j && g6Var2.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == t5.a.MATCH_CONSTRAINT) {
                    t5 t5Var4 = this.b;
                    if (t5Var4.s == 0 && !t5Var4.m()) {
                        int i4 = this.h.l.get(0).g;
                        g6 g6Var3 = this.h;
                        int i5 = i4 + g6Var3.f;
                        int i6 = this.i.l.get(0).g + this.i.f;
                        g6Var3.a(i5);
                        this.i.a(i6);
                        this.e.a(i6 - i5);
                        return;
                    }
                }
                if (!this.e.j && this.d == t5.a.MATCH_CONSTRAINT && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    int i7 = (this.i.l.get(0).g + this.i.f) - (this.h.l.get(0).g + this.h.f);
                    h6 h6Var4 = this.e;
                    int i8 = h6Var4.m;
                    if (i7 < i8) {
                        h6Var4.a(i7);
                    } else {
                        h6Var4.a(i8);
                    }
                }
                if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    g6 g6Var4 = this.h.l.get(0);
                    g6 g6Var5 = this.i.l.get(0);
                    int i9 = g6Var4.g;
                    int i10 = this.h.f + i9;
                    int i11 = g6Var5.g;
                    int i12 = this.i.f + i11;
                    float f4 = this.b.h0;
                    if (g6Var4 == g6Var5) {
                        f4 = 0.5f;
                    } else {
                        i9 = i10;
                        i11 = i12;
                    }
                    this.h.a((int) ((((i11 - i9) - this.e.g) * f4) + i9 + 0.5f));
                    this.i.a(this.h.g + this.e.g);
                }
            }
        }
    }

    @Override // defpackage.p6
    public void b() {
        g6 g6Var = this.h;
        if (g6Var.j) {
            this.b.c0 = g6Var.g;
        }
    }

    @Override // defpackage.p6
    public void c() {
        this.c = null;
        this.h.a();
        this.i.a();
        this.k.a();
        this.e.a();
        this.g = false;
    }

    @Override // defpackage.p6
    public boolean e() {
        return this.d != t5.a.MATCH_CONSTRAINT || this.b.t == 0;
    }

    public void f() {
        this.g = false;
        this.h.a();
        this.h.j = false;
        this.i.a();
        this.i.j = false;
        this.k.a();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder a = jg.a("VerticalRun ");
        a.append(this.b.k0);
        return a.toString();
    }

    @Override // defpackage.p6
    public void a() {
        t5 t5Var;
        t5 t5Var2;
        t5 t5Var3;
        t5 t5Var4 = this.b;
        if (t5Var4.a) {
            this.e.a(t5Var4.e());
        }
        if (!this.e.j) {
            this.d = this.b.h();
            if (this.b.F) {
                this.l = new b6(this);
            }
            t5.a aVar = this.d;
            if (aVar != t5.a.MATCH_CONSTRAINT) {
                if (aVar == t5.a.MATCH_PARENT && (t5Var3 = this.b.W) != null && t5Var3.h() == t5.a.FIXED) {
                    int e = (t5Var3.e() - this.b.L.b()) - this.b.N.b();
                    a(this.h, t5Var3.e.h, this.b.L.b());
                    a(this.i, t5Var3.e.i, -this.b.N.b());
                    this.e.a(e);
                    return;
                } else if (this.d == t5.a.FIXED) {
                    this.e.a(this.b.e());
                }
            }
        } else if (this.d == t5.a.MATCH_PARENT && (t5Var = this.b.W) != null && t5Var.h() == t5.a.FIXED) {
            a(this.h, t5Var.e.h, this.b.L.b());
            a(this.i, t5Var.e.i, -this.b.N.b());
            return;
        }
        if (this.e.j) {
            t5 t5Var5 = this.b;
            if (t5Var5.a) {
                s5[] s5VarArr = t5Var5.S;
                if (s5VarArr[2].f != null && s5VarArr[3].f != null) {
                    if (t5Var5.m()) {
                        this.h.f = this.b.S[2].b();
                        this.i.f = -this.b.S[3].b();
                    } else {
                        g6 a = a(this.b.S[2]);
                        if (a != null) {
                            g6 g6Var = this.h;
                            int b = this.b.S[2].b();
                            g6Var.l.add(a);
                            g6Var.f = b;
                            a.k.add(g6Var);
                        }
                        g6 a2 = a(this.b.S[3]);
                        if (a2 != null) {
                            g6 g6Var2 = this.i;
                            g6Var2.l.add(a2);
                            g6Var2.f = -this.b.S[3].b();
                            a2.k.add(g6Var2);
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    t5 t5Var6 = this.b;
                    if (t5Var6.F) {
                        a(this.k, this.h, t5Var6.d0);
                        return;
                    }
                    return;
                }
                t5 t5Var7 = this.b;
                s5[] s5VarArr2 = t5Var7.S;
                if (s5VarArr2[2].f != null) {
                    g6 a3 = a(s5VarArr2[2]);
                    if (a3 != null) {
                        g6 g6Var3 = this.h;
                        int b2 = this.b.S[2].b();
                        g6Var3.l.add(a3);
                        g6Var3.f = b2;
                        a3.k.add(g6Var3);
                        a(this.i, this.h, this.e.g);
                        t5 t5Var8 = this.b;
                        if (t5Var8.F) {
                            a(this.k, this.h, t5Var8.d0);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (s5VarArr2[3].f != null) {
                    g6 a4 = a(s5VarArr2[3]);
                    if (a4 != null) {
                        g6 g6Var4 = this.i;
                        g6Var4.l.add(a4);
                        g6Var4.f = -this.b.S[3].b();
                        a4.k.add(g6Var4);
                        a(this.h, this.i, -this.e.g);
                    }
                    t5 t5Var9 = this.b;
                    if (t5Var9.F) {
                        a(this.k, this.h, t5Var9.d0);
                        return;
                    }
                    return;
                } else if (s5VarArr2[4].f != null) {
                    g6 a5 = a(s5VarArr2[4]);
                    if (a5 != null) {
                        g6 g6Var5 = this.k;
                        g6Var5.l.add(a5);
                        g6Var5.f = 0;
                        a5.k.add(g6Var5);
                        a(this.h, this.k, -this.b.d0);
                        a(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                } else if ((t5Var7 instanceof w5) || t5Var7.W == null || t5Var7.a(s5.a.CENTER).f != null) {
                    return;
                } else {
                    t5 t5Var10 = this.b;
                    a(this.h, t5Var10.W.e.h, t5Var10.k());
                    a(this.i, this.h, this.e.g);
                    t5 t5Var11 = this.b;
                    if (t5Var11.F) {
                        a(this.k, this.h, t5Var11.d0);
                        return;
                    }
                    return;
                }
            }
        }
        h6 h6Var = this.e;
        if (!h6Var.j && this.d == t5.a.MATCH_CONSTRAINT) {
            t5 t5Var12 = this.b;
            int i = t5Var12.t;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3 && !t5Var12.m()) {
                        t5 t5Var13 = this.b;
                        if (t5Var13.s != 3) {
                            h6 h6Var2 = t5Var13.d.e;
                            this.e.l.add(h6Var2);
                            h6Var2.k.add(this.e);
                            h6 h6Var3 = this.e;
                            h6Var3.b = true;
                            h6Var3.k.add(this.h);
                            this.e.k.add(this.i);
                        }
                    }
                } else {
                    t5 t5Var14 = t5Var12.W;
                    if (t5Var14 != null) {
                        h6 h6Var4 = t5Var14.e.e;
                        h6Var.l.add(h6Var4);
                        h6Var4.k.add(this.e);
                        h6 h6Var5 = this.e;
                        h6Var5.b = true;
                        h6Var5.k.add(this.h);
                        this.e.k.add(this.i);
                    }
                }
            }
        } else {
            h6 h6Var6 = this.e;
            h6Var6.k.add(this);
            if (h6Var6.j) {
                a(this);
            }
        }
        t5 t5Var15 = this.b;
        s5[] s5VarArr3 = t5Var15.S;
        if (s5VarArr3[2].f != null && s5VarArr3[3].f != null) {
            if (t5Var15.m()) {
                this.h.f = this.b.S[2].b();
                this.i.f = -this.b.S[3].b();
            } else {
                g6 a6 = a(this.b.S[2]);
                g6 a7 = a(this.b.S[3]);
                if (a6 != null) {
                    a6.k.add(this);
                    if (a6.j) {
                        a(this);
                    }
                }
                if (a7 != null) {
                    a7.k.add(this);
                    if (a7.j) {
                        a(this);
                    }
                }
                this.j = p6.a.CENTER;
            }
            if (this.b.F) {
                a(this.k, this.h, 1, this.l);
            }
        } else {
            t5 t5Var16 = this.b;
            s5[] s5VarArr4 = t5Var16.S;
            if (s5VarArr4[2].f != null) {
                g6 a8 = a(s5VarArr4[2]);
                if (a8 != null) {
                    g6 g6Var6 = this.h;
                    int b3 = this.b.S[2].b();
                    g6Var6.l.add(a8);
                    g6Var6.f = b3;
                    a8.k.add(g6Var6);
                    a(this.i, this.h, 1, this.e);
                    if (this.b.F) {
                        a(this.k, this.h, 1, this.l);
                    }
                    t5.a aVar2 = this.d;
                    t5.a aVar3 = t5.a.MATCH_CONSTRAINT;
                    if (aVar2 == aVar3) {
                        t5 t5Var17 = this.b;
                        if (t5Var17.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            l6 l6Var = t5Var17.d;
                            if (l6Var.d == aVar3) {
                                l6Var.e.k.add(this.e);
                                this.e.l.add(this.b.d.e);
                                this.e.a = this;
                            }
                        }
                    }
                }
            } else if (s5VarArr4[3].f != null) {
                g6 a9 = a(s5VarArr4[3]);
                if (a9 != null) {
                    g6 g6Var7 = this.i;
                    g6Var7.l.add(a9);
                    g6Var7.f = -this.b.S[3].b();
                    a9.k.add(g6Var7);
                    a(this.h, this.i, -1, this.e);
                    if (this.b.F) {
                        a(this.k, this.h, 1, this.l);
                    }
                }
            } else if (s5VarArr4[4].f != null) {
                g6 a10 = a(s5VarArr4[4]);
                if (a10 != null) {
                    g6 g6Var8 = this.k;
                    g6Var8.l.add(a10);
                    g6Var8.f = 0;
                    a10.k.add(g6Var8);
                    a(this.h, this.k, -1, this.l);
                    a(this.i, this.h, 1, this.e);
                }
            } else if (!(t5Var16 instanceof w5) && (t5Var2 = t5Var16.W) != null) {
                a(this.h, t5Var2.e.h, t5Var16.k());
                a(this.i, this.h, 1, this.e);
                if (this.b.F) {
                    a(this.k, this.h, 1, this.l);
                }
                t5.a aVar4 = this.d;
                t5.a aVar5 = t5.a.MATCH_CONSTRAINT;
                if (aVar4 == aVar5) {
                    t5 t5Var18 = this.b;
                    if (t5Var18.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                        l6 l6Var2 = t5Var18.d;
                        if (l6Var2.d == aVar5) {
                            l6Var2.e.k.add(this.e);
                            this.e.l.add(this.b.d.e);
                            this.e.a = this;
                        }
                    }
                }
            }
        }
        if (this.e.l.size() == 0) {
            this.e.c = true;
        }
    }
}
