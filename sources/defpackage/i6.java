package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.c6;
import defpackage.s5;
import defpackage.t5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: Direct.java */
/* renamed from: i6  reason: default package */
/* loaded from: classes.dex */
public class i6 {
    public static c6.a a = new c6.a();
    public static int b;
    public static int c;

    public static void a(u5 u5Var, c6.b bVar) {
        t5.a f = u5Var.f();
        t5.a h = u5Var.h();
        b = 0;
        c = 0;
        u5Var.r();
        ArrayList<t5> arrayList = u5Var.u0;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).r();
        }
        boolean z = u5Var.z0;
        if (f == t5.a.FIXED) {
            u5Var.b(0, u5Var.i());
        } else {
            s5 s5Var = u5Var.K;
            s5Var.b = 0;
            s5Var.c = true;
            u5Var.b0 = 0;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            t5 t5Var = arrayList.get(i2);
            if (t5Var instanceof v5) {
                v5 v5Var = (v5) t5Var;
                if (v5Var.y0 == 1) {
                    int i3 = v5Var.v0;
                    if (i3 != -1) {
                        v5Var.m(i3);
                    } else if (v5Var.w0 != -1 && u5Var.o()) {
                        v5Var.m(u5Var.i() - v5Var.w0);
                    } else if (u5Var.o()) {
                        v5Var.m((int) ((v5Var.u0 * u5Var.i()) + 0.5f));
                    }
                    z2 = true;
                }
            } else if ((t5Var instanceof q5) && ((q5) t5Var).t() == 0) {
                z3 = true;
            }
        }
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                t5 t5Var2 = arrayList.get(i4);
                if (t5Var2 instanceof v5) {
                    v5 v5Var2 = (v5) t5Var2;
                    if (v5Var2.y0 == 1) {
                        a(0, v5Var2, bVar, z);
                    }
                }
            }
        }
        a(0, u5Var, bVar, z);
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                t5 t5Var3 = arrayList.get(i5);
                if (t5Var3 instanceof q5) {
                    q5 q5Var = (q5) t5Var3;
                    if (q5Var.t() == 0 && q5Var.s()) {
                        a(1, q5Var, bVar, z);
                    }
                }
            }
        }
        if (h == t5.a.FIXED) {
            u5Var.c(0, u5Var.e());
        } else {
            s5 s5Var2 = u5Var.L;
            s5Var2.b = 0;
            s5Var2.c = true;
            u5Var.c0 = 0;
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            t5 t5Var4 = arrayList.get(i6);
            if (t5Var4 instanceof v5) {
                v5 v5Var3 = (v5) t5Var4;
                if (v5Var3.y0 == 0) {
                    int i7 = v5Var3.v0;
                    if (i7 != -1) {
                        v5Var3.m(i7);
                    } else if (v5Var3.w0 != -1 && u5Var.p()) {
                        v5Var3.m(u5Var.e() - v5Var3.w0);
                    } else if (u5Var.p()) {
                        v5Var3.m((int) ((v5Var3.u0 * u5Var.e()) + 0.5f));
                    }
                    z4 = true;
                }
            } else if ((t5Var4 instanceof q5) && ((q5) t5Var4).t() == 1) {
                z5 = true;
            }
        }
        if (z4) {
            for (int i8 = 0; i8 < size; i8++) {
                t5 t5Var5 = arrayList.get(i8);
                if (t5Var5 instanceof v5) {
                    v5 v5Var4 = (v5) t5Var5;
                    if (v5Var4.y0 == 0) {
                        a(1, v5Var4, bVar);
                    }
                }
            }
        }
        a(0, u5Var, bVar);
        if (z5) {
            for (int i9 = 0; i9 < size; i9++) {
                t5 t5Var6 = arrayList.get(i9);
                if (t5Var6 instanceof q5) {
                    q5 q5Var2 = (q5) t5Var6;
                    if (q5Var2.t() == 1 && q5Var2.s()) {
                        a(1, q5Var2, bVar);
                    }
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            t5 t5Var7 = arrayList.get(i10);
            if (t5Var7.n() && a(t5Var7)) {
                u5.a(t5Var7, bVar, a, c6.a.k);
                if (t5Var7 instanceof v5) {
                    if (((v5) t5Var7).y0 == 0) {
                        a(0, t5Var7, bVar);
                    } else {
                        a(0, t5Var7, bVar, z);
                    }
                } else {
                    a(0, t5Var7, bVar, z);
                    a(0, t5Var7, bVar);
                }
            }
        }
    }

    public static void a(int i, t5 t5Var, c6.b bVar, boolean z) {
        s5 s5Var;
        s5 s5Var2;
        s5 s5Var3;
        s5 s5Var4;
        s5 s5Var5;
        if (t5Var.n) {
            return;
        }
        b++;
        if (!(t5Var instanceof u5) && t5Var.n() && a(t5Var)) {
            u5.a(t5Var, bVar, new c6.a(), c6.a.k);
        }
        s5 a2 = t5Var.a(s5.a.LEFT);
        s5 a3 = t5Var.a(s5.a.RIGHT);
        int a4 = a2.a();
        int a5 = a3.a();
        HashSet<s5> hashSet = a2.a;
        if (hashSet != null && a2.c) {
            Iterator<s5> it = hashSet.iterator();
            while (it.hasNext()) {
                s5 next = it.next();
                t5 t5Var2 = next.d;
                int i2 = i + 1;
                boolean a6 = a(t5Var2);
                if (t5Var2.n() && a6) {
                    u5.a(t5Var2, bVar, new c6.a(), c6.a.k);
                }
                if (t5Var2.f() == t5.a.MATCH_CONSTRAINT && !a6) {
                    if (t5Var2.f() == t5.a.MATCH_CONSTRAINT && t5Var2.w >= 0 && t5Var2.v >= 0 && (t5Var2.j0 == 8 || (t5Var2.s == 0 && t5Var2.Z == XToggleDrawable.LIGHT_RADIUS_DEFAULT))) {
                        if (!t5Var2.l() && !t5Var2.H) {
                            if (((next == t5Var2.K && (s5Var5 = t5Var2.M.f) != null && s5Var5.c) || (next == t5Var2.M && (s5Var4 = t5Var2.K.f) != null && s5Var4.c)) && !t5Var2.l()) {
                                a(i2, t5Var, bVar, t5Var2, z);
                            }
                        }
                    }
                } else if (!t5Var2.n()) {
                    s5 s5Var6 = t5Var2.K;
                    if (next == s5Var6 && t5Var2.M.f == null) {
                        int b2 = s5Var6.b() + a4;
                        t5Var2.b(b2, t5Var2.i() + b2);
                        a(i2, t5Var2, bVar, z);
                    } else {
                        s5 s5Var7 = t5Var2.M;
                        if (next == s5Var7 && t5Var2.K.f == null) {
                            int b3 = a4 - s5Var7.b();
                            t5Var2.b(b3 - t5Var2.i(), b3);
                            a(i2, t5Var2, bVar, z);
                        } else if (next == t5Var2.K && (s5Var3 = t5Var2.M.f) != null && s5Var3.c && !t5Var2.l()) {
                            a(i2, bVar, t5Var2, z);
                        }
                    }
                }
            }
        }
        if (t5Var instanceof v5) {
            return;
        }
        HashSet<s5> hashSet2 = a3.a;
        if (hashSet2 != null && a3.c) {
            Iterator<s5> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                s5 next2 = it2.next();
                t5 t5Var3 = next2.d;
                int i3 = i + 1;
                boolean a7 = a(t5Var3);
                if (t5Var3.n() && a7) {
                    u5.a(t5Var3, bVar, new c6.a(), c6.a.k);
                }
                boolean z2 = (next2 == t5Var3.K && (s5Var2 = t5Var3.M.f) != null && s5Var2.c) || (next2 == t5Var3.M && (s5Var = t5Var3.K.f) != null && s5Var.c);
                if (t5Var3.f() == t5.a.MATCH_CONSTRAINT && !a7) {
                    if (t5Var3.f() == t5.a.MATCH_CONSTRAINT && t5Var3.w >= 0 && t5Var3.v >= 0 && (t5Var3.j0 == 8 || (t5Var3.s == 0 && t5Var3.Z == XToggleDrawable.LIGHT_RADIUS_DEFAULT))) {
                        if (!t5Var3.l() && !t5Var3.H && z2 && !t5Var3.l()) {
                            a(i3, t5Var, bVar, t5Var3, z);
                        }
                    }
                } else if (!t5Var3.n()) {
                    s5 s5Var8 = t5Var3.K;
                    if (next2 == s5Var8 && t5Var3.M.f == null) {
                        int b4 = s5Var8.b() + a5;
                        t5Var3.b(b4, t5Var3.i() + b4);
                        a(i3, t5Var3, bVar, z);
                    } else {
                        s5 s5Var9 = t5Var3.M;
                        if (next2 == s5Var9 && t5Var3.K.f == null) {
                            int b5 = a5 - s5Var9.b();
                            t5Var3.b(b5 - t5Var3.i(), b5);
                            a(i3, t5Var3, bVar, z);
                        } else if (z2 && !t5Var3.l()) {
                            a(i3, bVar, t5Var3, z);
                        }
                    }
                }
            }
        }
        t5Var.n = true;
    }

    public static void a(int i, t5 t5Var, c6.b bVar) {
        s5 s5Var;
        s5 s5Var2;
        s5 s5Var3;
        s5 s5Var4;
        s5 s5Var5;
        if (t5Var.o) {
            return;
        }
        c++;
        if (!(t5Var instanceof u5) && t5Var.n() && a(t5Var)) {
            u5.a(t5Var, bVar, new c6.a(), c6.a.k);
        }
        s5 a2 = t5Var.a(s5.a.TOP);
        s5 a3 = t5Var.a(s5.a.BOTTOM);
        int a4 = a2.a();
        int a5 = a3.a();
        HashSet<s5> hashSet = a2.a;
        if (hashSet != null && a2.c) {
            Iterator<s5> it = hashSet.iterator();
            while (it.hasNext()) {
                s5 next = it.next();
                t5 t5Var2 = next.d;
                int i2 = i + 1;
                boolean a6 = a(t5Var2);
                if (t5Var2.n() && a6) {
                    u5.a(t5Var2, bVar, new c6.a(), c6.a.k);
                }
                if (t5Var2.h() == t5.a.MATCH_CONSTRAINT && !a6) {
                    if (t5Var2.h() == t5.a.MATCH_CONSTRAINT && t5Var2.z >= 0 && t5Var2.y >= 0 && (t5Var2.j0 == 8 || (t5Var2.t == 0 && t5Var2.Z == XToggleDrawable.LIGHT_RADIUS_DEFAULT))) {
                        if (!t5Var2.m() && !t5Var2.H) {
                            if (((next == t5Var2.L && (s5Var5 = t5Var2.N.f) != null && s5Var5.c) || (next == t5Var2.N && (s5Var4 = t5Var2.L.f) != null && s5Var4.c)) && !t5Var2.m()) {
                                a(i2, t5Var, bVar, t5Var2);
                            }
                        }
                    }
                } else if (!t5Var2.n()) {
                    s5 s5Var6 = t5Var2.L;
                    if (next == s5Var6 && t5Var2.N.f == null) {
                        int b2 = s5Var6.b() + a4;
                        t5Var2.c(b2, t5Var2.e() + b2);
                        a(i2, t5Var2, bVar);
                    } else {
                        s5 s5Var7 = t5Var2.N;
                        if (next == s5Var7 && s5Var7.f == null) {
                            int b3 = a4 - s5Var7.b();
                            t5Var2.c(b3 - t5Var2.e(), b3);
                            a(i2, t5Var2, bVar);
                        } else if (next == t5Var2.L && (s5Var3 = t5Var2.N.f) != null && s5Var3.c) {
                            a(i2, bVar, t5Var2);
                        }
                    }
                }
            }
        }
        if (t5Var instanceof v5) {
            return;
        }
        HashSet<s5> hashSet2 = a3.a;
        if (hashSet2 != null && a3.c) {
            Iterator<s5> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                s5 next2 = it2.next();
                t5 t5Var3 = next2.d;
                int i3 = i + 1;
                boolean a7 = a(t5Var3);
                if (t5Var3.n() && a7) {
                    u5.a(t5Var3, bVar, new c6.a(), c6.a.k);
                }
                boolean z = (next2 == t5Var3.L && (s5Var2 = t5Var3.N.f) != null && s5Var2.c) || (next2 == t5Var3.N && (s5Var = t5Var3.L.f) != null && s5Var.c);
                if (t5Var3.h() == t5.a.MATCH_CONSTRAINT && !a7) {
                    if (t5Var3.h() == t5.a.MATCH_CONSTRAINT && t5Var3.z >= 0 && t5Var3.y >= 0 && (t5Var3.j0 == 8 || (t5Var3.t == 0 && t5Var3.Z == XToggleDrawable.LIGHT_RADIUS_DEFAULT))) {
                        if (!t5Var3.m() && !t5Var3.H && z && !t5Var3.m()) {
                            a(i3, t5Var, bVar, t5Var3);
                        }
                    }
                } else if (!t5Var3.n()) {
                    s5 s5Var8 = t5Var3.L;
                    if (next2 == s5Var8 && t5Var3.N.f == null) {
                        int b4 = s5Var8.b() + a5;
                        t5Var3.c(b4, t5Var3.e() + b4);
                        a(i3, t5Var3, bVar);
                    } else {
                        s5 s5Var9 = t5Var3.N;
                        if (next2 == s5Var9 && t5Var3.L.f == null) {
                            int b5 = a5 - s5Var9.b();
                            t5Var3.c(b5 - t5Var3.e(), b5);
                            a(i3, t5Var3, bVar);
                        } else if (z && !t5Var3.m()) {
                            a(i3, bVar, t5Var3);
                        }
                    }
                }
            }
        }
        s5 a8 = t5Var.a(s5.a.BASELINE);
        if (a8.a != null && a8.c) {
            int a9 = a8.a();
            Iterator<s5> it3 = a8.a.iterator();
            while (it3.hasNext()) {
                s5 next3 = it3.next();
                t5 t5Var4 = next3.d;
                int i4 = i + 1;
                boolean a10 = a(t5Var4);
                if (t5Var4.n() && a10) {
                    u5.a(t5Var4, bVar, new c6.a(), c6.a.k);
                }
                if (t5Var4.h() != t5.a.MATCH_CONSTRAINT || a10) {
                    if (!t5Var4.n() && next3 == t5Var4.O) {
                        int b6 = next3.b() + a9;
                        if (t5Var4.F) {
                            int i5 = b6 - t5Var4.d0;
                            int i6 = t5Var4.Y + i5;
                            t5Var4.c0 = i5;
                            t5Var4.L.a(i5);
                            t5Var4.N.a(i6);
                            s5 s5Var10 = t5Var4.O;
                            s5Var10.b = b6;
                            s5Var10.c = true;
                            t5Var4.m = true;
                        }
                        a(i4, t5Var4, bVar);
                    }
                }
            }
        }
        t5Var.o = true;
    }

    public static boolean a(t5 t5Var) {
        t5.a f = t5Var.f();
        t5.a h = t5Var.h();
        t5 t5Var2 = t5Var.W;
        u5 u5Var = t5Var2 != null ? (u5) t5Var2 : null;
        if (u5Var != null) {
            u5Var.f();
            t5.a aVar = t5.a.FIXED;
        }
        if (u5Var != null) {
            u5Var.h();
            t5.a aVar2 = t5.a.FIXED;
        }
        boolean z = f == t5.a.FIXED || t5Var.o() || f == t5.a.WRAP_CONTENT || (f == t5.a.MATCH_CONSTRAINT && t5Var.s == 0 && t5Var.Z == XToggleDrawable.LIGHT_RADIUS_DEFAULT && t5Var.f(0)) || (f == t5.a.MATCH_CONSTRAINT && t5Var.s == 1 && t5Var.a(0, t5Var.i()));
        boolean z2 = h == t5.a.FIXED || t5Var.p() || h == t5.a.WRAP_CONTENT || (h == t5.a.MATCH_CONSTRAINT && t5Var.t == 0 && t5Var.Z == XToggleDrawable.LIGHT_RADIUS_DEFAULT && t5Var.f(1)) || (f == t5.a.MATCH_CONSTRAINT && t5Var.t == 1 && t5Var.a(1, t5Var.e()));
        if (t5Var.Z <= XToggleDrawable.LIGHT_RADIUS_DEFAULT || !(z || z2)) {
            return z && z2;
        }
        return true;
    }

    public static void a(int i, c6.b bVar, t5 t5Var, boolean z) {
        float f = t5Var.g0;
        int a2 = t5Var.K.f.a();
        int a3 = t5Var.M.f.a();
        int b2 = t5Var.K.b() + a2;
        int b3 = a3 - t5Var.M.b();
        if (a2 == a3) {
            f = 0.5f;
        } else {
            a2 = b2;
            a3 = b3;
        }
        int i2 = t5Var.i();
        int i3 = (a3 - a2) - i2;
        if (a2 > a3) {
            i3 = (a2 - a3) - i2;
        }
        int i4 = ((int) (i3 > 0 ? (f * i3) + 0.5f : f * i3)) + a2;
        int i5 = i4 + i2;
        if (a2 > a3) {
            i5 = i4 - i2;
        }
        t5Var.b(i4, i5);
        a(i + 1, t5Var, bVar, z);
    }

    public static void a(int i, t5 t5Var, c6.b bVar, t5 t5Var2, boolean z) {
        int i2;
        float f = t5Var2.g0;
        int b2 = t5Var2.K.b() + t5Var2.K.f.a();
        int a2 = t5Var2.M.f.a() - t5Var2.M.b();
        if (a2 >= b2) {
            int i3 = t5Var2.i();
            if (t5Var2.j0 != 8) {
                int i4 = t5Var2.s;
                if (i4 == 2) {
                    if (t5Var instanceof u5) {
                        i2 = t5Var.i();
                    } else {
                        i2 = t5Var.W.i();
                    }
                    i3 = (int) (t5Var2.g0 * 0.5f * i2);
                } else if (i4 == 0) {
                    i3 = a2 - b2;
                }
                i3 = Math.max(t5Var2.v, i3);
                int i5 = t5Var2.w;
                if (i5 > 0) {
                    i3 = Math.min(i5, i3);
                }
            }
            int i6 = b2 + ((int) ((f * ((a2 - b2) - i3)) + 0.5f));
            t5Var2.b(i6, i3 + i6);
            a(i + 1, t5Var2, bVar, z);
        }
    }

    public static void a(int i, c6.b bVar, t5 t5Var) {
        float f = t5Var.h0;
        int a2 = t5Var.L.f.a();
        int a3 = t5Var.N.f.a();
        int b2 = t5Var.L.b() + a2;
        int b3 = a3 - t5Var.N.b();
        if (a2 == a3) {
            f = 0.5f;
        } else {
            a2 = b2;
            a3 = b3;
        }
        int e = t5Var.e();
        int i2 = (a3 - a2) - e;
        if (a2 > a3) {
            i2 = (a2 - a3) - e;
        }
        int i3 = (int) (i2 > 0 ? (f * i2) + 0.5f : f * i2);
        int i4 = a2 + i3;
        int i5 = i4 + e;
        if (a2 > a3) {
            i4 = a2 - i3;
            i5 = i4 - e;
        }
        t5Var.c(i4, i5);
        a(i + 1, t5Var, bVar);
    }

    public static void a(int i, t5 t5Var, c6.b bVar, t5 t5Var2) {
        int e;
        float f = t5Var2.h0;
        int b2 = t5Var2.L.b() + t5Var2.L.f.a();
        int a2 = t5Var2.N.f.a() - t5Var2.N.b();
        if (a2 >= b2) {
            int e2 = t5Var2.e();
            if (t5Var2.j0 != 8) {
                int i2 = t5Var2.t;
                if (i2 == 2) {
                    if (t5Var instanceof u5) {
                        e = t5Var.e();
                    } else {
                        e = t5Var.W.e();
                    }
                    e2 = (int) (f * 0.5f * e);
                } else if (i2 == 0) {
                    e2 = a2 - b2;
                }
                e2 = Math.max(t5Var2.y, e2);
                int i3 = t5Var2.z;
                if (i3 > 0) {
                    e2 = Math.min(i3, e2);
                }
            }
            int i4 = b2 + ((int) ((f * ((a2 - b2) - e2)) + 0.5f));
            t5Var2.c(i4, e2 + i4);
            a(i + 1, t5Var2, bVar);
        }
    }
}
