package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.c6;
import defpackage.t5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: DependencyGraph.java */
/* renamed from: f6  reason: default package */
/* loaded from: classes.dex */
public class f6 {
    public u5 a;
    public u5 d;
    public c6.b f;
    public c6.a g;
    public ArrayList<m6> h;
    public boolean b = true;
    public boolean c = true;
    public ArrayList<p6> e = new ArrayList<>();

    public f6(u5 u5Var) {
        new ArrayList();
        this.f = null;
        this.g = new c6.a();
        this.h = new ArrayList<>();
        this.a = u5Var;
        this.d = u5Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(defpackage.u5 r17, int r18) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f6.a(u5, int):int");
    }

    public void b() {
        h6 h6Var;
        Iterator<t5> it = this.a.u0.iterator();
        while (it.hasNext()) {
            t5 next = it.next();
            if (!next.a) {
                t5.a[] aVarArr = next.V;
                boolean z = false;
                t5.a aVar = aVarArr[0];
                t5.a aVar2 = aVarArr[1];
                int i = next.s;
                int i2 = next.t;
                boolean z2 = aVar == t5.a.WRAP_CONTENT || (aVar == t5.a.MATCH_CONSTRAINT && i == 1);
                if (aVar2 == t5.a.WRAP_CONTENT || (aVar2 == t5.a.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                h6 h6Var2 = next.d.e;
                boolean z3 = h6Var2.j;
                h6 h6Var3 = next.e.e;
                boolean z4 = h6Var3.j;
                if (z3 && z4) {
                    t5.a aVar3 = t5.a.FIXED;
                    a(next, aVar3, h6Var2.g, aVar3, h6Var3.g);
                    next.a = true;
                } else if (z3 && z) {
                    a(next, t5.a.FIXED, next.d.e.g, t5.a.WRAP_CONTENT, next.e.e.g);
                    if (aVar2 == t5.a.MATCH_CONSTRAINT) {
                        next.e.e.m = next.e();
                    } else {
                        next.e.e.a(next.e());
                        next.a = true;
                    }
                } else if (z4 && z2) {
                    a(next, t5.a.WRAP_CONTENT, next.d.e.g, t5.a.FIXED, next.e.e.g);
                    if (aVar == t5.a.MATCH_CONSTRAINT) {
                        next.d.e.m = next.i();
                    } else {
                        next.d.e.a(next.i());
                        next.a = true;
                    }
                }
                if (next.a && (h6Var = next.e.l) != null) {
                    h6Var.a(next.d0);
                }
            }
        }
    }

    public final void a(t5 t5Var, t5.a aVar, int i, t5.a aVar2, int i2) {
        c6.a aVar3 = this.g;
        aVar3.a = aVar;
        aVar3.b = aVar2;
        aVar3.c = i;
        aVar3.d = i2;
        ((ConstraintLayout.b) this.f).a(t5Var, aVar3);
        t5Var.l(this.g.e);
        t5Var.i(this.g.f);
        c6.a aVar4 = this.g;
        t5Var.F = aVar4.h;
        t5Var.h(aVar4.g);
    }

    public final boolean a(u5 u5Var) {
        int i;
        t5.a aVar;
        int i2;
        int i3;
        Iterator<t5> it = u5Var.u0.iterator();
        while (it.hasNext()) {
            t5 next = it.next();
            t5.a[] aVarArr = next.V;
            t5.a aVar2 = aVarArr[0];
            t5.a aVar3 = aVarArr[1];
            if (next.j0 == 8) {
                next.a = true;
            } else {
                if (next.x < 1.0f && aVar2 == t5.a.MATCH_CONSTRAINT) {
                    next.s = 2;
                }
                if (next.A < 1.0f && aVar3 == t5.a.MATCH_CONSTRAINT) {
                    next.t = 2;
                }
                if (next.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    if (aVar2 == t5.a.MATCH_CONSTRAINT && (aVar3 == t5.a.WRAP_CONTENT || aVar3 == t5.a.FIXED)) {
                        next.s = 3;
                    } else if (aVar3 == t5.a.MATCH_CONSTRAINT && (aVar2 == t5.a.WRAP_CONTENT || aVar2 == t5.a.FIXED)) {
                        next.t = 3;
                    } else {
                        t5.a aVar4 = t5.a.MATCH_CONSTRAINT;
                        if (aVar2 == aVar4 && aVar3 == aVar4) {
                            if (next.s == 0) {
                                next.s = 3;
                            }
                            if (next.t == 0) {
                                next.t = 3;
                            }
                        }
                    }
                }
                if (aVar2 == t5.a.MATCH_CONSTRAINT && next.s == 1 && (next.K.f == null || next.M.f == null)) {
                    aVar2 = t5.a.WRAP_CONTENT;
                }
                t5.a aVar5 = aVar2;
                if (aVar3 == t5.a.MATCH_CONSTRAINT && next.t == 1 && (next.L.f == null || next.N.f == null)) {
                    aVar3 = t5.a.WRAP_CONTENT;
                }
                t5.a aVar6 = aVar3;
                l6 l6Var = next.d;
                l6Var.d = aVar5;
                l6Var.a = next.s;
                n6 n6Var = next.e;
                n6Var.d = aVar6;
                n6Var.a = next.t;
                if ((aVar5 != t5.a.MATCH_PARENT && aVar5 != t5.a.FIXED && aVar5 != t5.a.WRAP_CONTENT) || (aVar6 != t5.a.MATCH_PARENT && aVar6 != t5.a.FIXED && aVar6 != t5.a.WRAP_CONTENT)) {
                    if (aVar5 == t5.a.MATCH_CONSTRAINT && (aVar6 == t5.a.WRAP_CONTENT || aVar6 == t5.a.FIXED)) {
                        int i4 = next.s;
                        if (i4 == 3) {
                            t5.a aVar7 = t5.a.WRAP_CONTENT;
                            if (aVar6 == aVar7) {
                                a(next, aVar7, 0, aVar7, 0);
                            }
                            int e = next.e();
                            t5.a aVar8 = t5.a.FIXED;
                            a(next, aVar8, (int) ((e * next.Z) + 0.5f), aVar8, e);
                            next.d.e.a(next.i());
                            next.e.e.a(next.e());
                            next.a = true;
                        } else if (i4 == 1) {
                            a(next, t5.a.WRAP_CONTENT, 0, aVar6, 0);
                            next.d.e.m = next.i();
                        } else if (i4 == 2) {
                            t5.a[] aVarArr2 = u5Var.V;
                            if (aVarArr2[0] == t5.a.FIXED || aVarArr2[0] == t5.a.MATCH_PARENT) {
                                a(next, t5.a.FIXED, (int) ((next.x * u5Var.i()) + 0.5f), aVar6, next.e());
                                next.d.e.a(next.i());
                                next.e.e.a(next.e());
                                next.a = true;
                            }
                        } else {
                            s5[] s5VarArr = next.S;
                            if (s5VarArr[0].f == null || s5VarArr[1].f == null) {
                                a(next, t5.a.WRAP_CONTENT, 0, aVar6, 0);
                                next.d.e.a(next.i());
                                next.e.e.a(next.e());
                                next.a = true;
                            }
                        }
                    }
                    if (aVar6 == t5.a.MATCH_CONSTRAINT && (aVar5 == t5.a.WRAP_CONTENT || aVar5 == t5.a.FIXED)) {
                        int i5 = next.t;
                        if (i5 == 3) {
                            t5.a aVar9 = t5.a.WRAP_CONTENT;
                            if (aVar5 == aVar9) {
                                a(next, aVar9, 0, aVar9, 0);
                            }
                            int i6 = next.i();
                            float f = next.Z;
                            if (next.a0 == -1) {
                                f = 1.0f / f;
                            }
                            t5.a aVar10 = t5.a.FIXED;
                            a(next, aVar10, i6, aVar10, (int) ((i6 * f) + 0.5f));
                            next.d.e.a(next.i());
                            next.e.e.a(next.e());
                            next.a = true;
                        } else if (i5 == 1) {
                            a(next, aVar5, 0, t5.a.WRAP_CONTENT, 0);
                            next.e.e.m = next.e();
                        } else if (i5 == 2) {
                            t5.a[] aVarArr3 = u5Var.V;
                            if (aVarArr3[1] == t5.a.FIXED || aVarArr3[1] == t5.a.MATCH_PARENT) {
                                a(next, aVar5, next.i(), t5.a.FIXED, (int) ((next.A * u5Var.e()) + 0.5f));
                                next.d.e.a(next.i());
                                next.e.e.a(next.e());
                                next.a = true;
                            }
                        } else {
                            s5[] s5VarArr2 = next.S;
                            if (s5VarArr2[2].f == null || s5VarArr2[3].f == null) {
                                a(next, t5.a.WRAP_CONTENT, 0, aVar6, 0);
                                next.d.e.a(next.i());
                                next.e.e.a(next.e());
                                next.a = true;
                            }
                        }
                    }
                    t5.a aVar11 = t5.a.MATCH_CONSTRAINT;
                    if (aVar5 == aVar11 && aVar6 == aVar11) {
                        int i7 = next.s;
                        if (i7 == 1 || (i3 = next.t) == 1) {
                            t5.a aVar12 = t5.a.WRAP_CONTENT;
                            a(next, aVar12, 0, aVar12, 0);
                            next.d.e.m = next.i();
                            next.e.e.m = next.e();
                        } else if (i3 == 2 && i7 == 2) {
                            t5.a[] aVarArr4 = u5Var.V;
                            t5.a aVar13 = aVarArr4[0];
                            t5.a aVar14 = t5.a.FIXED;
                            if (aVar13 == aVar14 && aVarArr4[1] == aVar14) {
                                float f2 = next.x;
                                float f3 = next.A;
                                t5.a aVar15 = t5.a.FIXED;
                                a(next, aVar15, (int) ((f2 * u5Var.i()) + 0.5f), aVar15, (int) ((f3 * u5Var.e()) + 0.5f));
                                next.d.e.a(next.i());
                                next.e.e.a(next.e());
                                next.a = true;
                            }
                        }
                    }
                } else {
                    int i8 = next.i();
                    if (aVar5 == t5.a.MATCH_PARENT) {
                        i = (u5Var.i() - next.K.g) - next.M.g;
                        aVar5 = t5.a.FIXED;
                    } else {
                        i = i8;
                    }
                    int e2 = next.e();
                    if (aVar6 == t5.a.MATCH_PARENT) {
                        i2 = (u5Var.e() - next.L.g) - next.N.g;
                        aVar = t5.a.FIXED;
                    } else {
                        aVar = aVar6;
                        i2 = e2;
                    }
                    a(next, aVar5, i, aVar, i2);
                    next.d.e.a(next.i());
                    next.e.e.a(next.e());
                    next.a = true;
                }
            }
        }
        return false;
    }

    public void a() {
        ArrayList<p6> arrayList = this.e;
        arrayList.clear();
        this.d.d.c();
        this.d.e.c();
        arrayList.add(this.d.d);
        arrayList.add(this.d.e);
        Iterator<t5> it = this.d.u0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            t5 next = it.next();
            if (next instanceof v5) {
                arrayList.add(new j6(next));
            } else {
                if (next.l()) {
                    if (next.b == null) {
                        next.b = new d6(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.b);
                } else {
                    arrayList.add(next.d);
                }
                if (next.m()) {
                    if (next.c == null) {
                        next.c = new d6(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.c);
                } else {
                    arrayList.add(next.e);
                }
                if (next instanceof x5) {
                    arrayList.add(new k6(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p6> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
        Iterator<p6> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p6 next2 = it3.next();
            if (next2.b != this.d) {
                next2.a();
            }
        }
        this.h.clear();
        m6.d = 0;
        a(this.a.d, 0, this.h);
        a(this.a.e, 1, this.h);
        this.b = false;
    }

    public final void a(g6 g6Var, int i, int i2, g6 g6Var2, ArrayList<m6> arrayList, m6 m6Var) {
        p6 p6Var = g6Var.d;
        if (p6Var.c == null) {
            u5 u5Var = this.a;
            if (p6Var == u5Var.d || p6Var == u5Var.e) {
                return;
            }
            if (m6Var == null) {
                m6Var = new m6(p6Var, i2);
                arrayList.add(m6Var);
            }
            p6Var.c = m6Var;
            m6Var.c.add(p6Var);
            for (e6 e6Var : p6Var.h.k) {
                if (e6Var instanceof g6) {
                    a((g6) e6Var, i, 0, g6Var2, arrayList, m6Var);
                }
            }
            for (e6 e6Var2 : p6Var.i.k) {
                if (e6Var2 instanceof g6) {
                    a((g6) e6Var2, i, 1, g6Var2, arrayList, m6Var);
                }
            }
            if (i == 1 && (p6Var instanceof n6)) {
                for (e6 e6Var3 : ((n6) p6Var).k.k) {
                    if (e6Var3 instanceof g6) {
                        a((g6) e6Var3, i, 2, g6Var2, arrayList, m6Var);
                    }
                }
            }
            for (g6 g6Var3 : p6Var.h.l) {
                if (g6Var3 == g6Var2) {
                    m6Var.a = true;
                }
                a(g6Var3, i, 0, g6Var2, arrayList, m6Var);
            }
            for (g6 g6Var4 : p6Var.i.l) {
                if (g6Var4 == g6Var2) {
                    m6Var.a = true;
                }
                a(g6Var4, i, 1, g6Var2, arrayList, m6Var);
            }
            if (i == 1 && (p6Var instanceof n6)) {
                for (g6 g6Var5 : ((n6) p6Var).k.l) {
                    a(g6Var5, i, 2, g6Var2, arrayList, m6Var);
                }
            }
        }
    }

    public final void a(p6 p6Var, int i, ArrayList<m6> arrayList) {
        for (e6 e6Var : p6Var.h.k) {
            if (e6Var instanceof g6) {
                a((g6) e6Var, i, 0, p6Var.i, arrayList, null);
            } else if (e6Var instanceof p6) {
                a(((p6) e6Var).h, i, 0, p6Var.i, arrayList, null);
            }
        }
        for (e6 e6Var2 : p6Var.i.k) {
            if (e6Var2 instanceof g6) {
                a((g6) e6Var2, i, 1, p6Var.h, arrayList, null);
            } else if (e6Var2 instanceof p6) {
                a(((p6) e6Var2).i, i, 1, p6Var.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (e6 e6Var3 : ((n6) p6Var).k.k) {
                if (e6Var3 instanceof g6) {
                    a((g6) e6Var3, i, 2, null, arrayList, null);
                }
            }
        }
    }
}
