package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.n5;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: LinearSystem.java */
/* renamed from: k5  reason: default package */
/* loaded from: classes.dex */
public class k5 {
    public static boolean r = false;
    public static int s = 1000;
    public static long t;
    public a d;
    public int f;
    public i5[] g;
    public boolean h;
    public boolean i;
    public boolean[] j;
    public int k;
    public int l;
    public int m;
    public final j5 n;
    public n5[] o;
    public int p;
    public a q;
    public boolean a = false;
    public int b = 0;
    public HashMap<String, n5> c = null;
    public int e = 32;

    /* compiled from: LinearSystem.java */
    /* renamed from: k5$a */
    /* loaded from: classes.dex */
    public interface a {
        n5 a(k5 k5Var, boolean[] zArr);

        void a(n5 n5Var);

        void clear();

        boolean isEmpty();
    }

    public k5() {
        int i = this.e;
        this.f = i;
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = new boolean[i];
        this.k = 1;
        this.l = 0;
        this.m = i;
        this.o = new n5[s];
        this.p = 0;
        this.g = new i5[i];
        f();
        this.n = new j5();
        this.d = new m5(this.n);
        this.q = new i5(this.n);
    }

    public n5 a(Object obj) {
        n5 n5Var = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.f) {
            d();
        }
        if (obj instanceof s5) {
            s5 s5Var = (s5) obj;
            n5Var = s5Var.i;
            if (n5Var == null) {
                s5Var.g();
                n5Var = s5Var.i;
            }
            int i = n5Var.e;
            if (i == -1 || i > this.b || this.n.d[i] == null) {
                if (n5Var.e != -1) {
                    n5Var.a();
                }
                this.b++;
                this.k++;
                int i2 = this.b;
                n5Var.e = i2;
                n5Var.l = n5.a.UNRESTRICTED;
                this.n.d[i2] = n5Var;
            }
        }
        return n5Var;
    }

    public i5 b() {
        i5 a2 = this.n.b.a();
        if (a2 == null) {
            a2 = new i5(this.n);
            t++;
        } else {
            a2.a = null;
            a2.e.clear();
            a2.b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            a2.f = false;
        }
        n5.s++;
        return a2;
    }

    public n5 c() {
        if (this.k + 1 >= this.f) {
            d();
        }
        n5 a2 = a(n5.a.SLACK, (String) null);
        this.b++;
        this.k++;
        int i = this.b;
        a2.e = i;
        this.n.d[i] = a2;
        return a2;
    }

    public final void d() {
        this.e *= 2;
        this.g = (i5[]) Arrays.copyOf(this.g, this.e);
        j5 j5Var = this.n;
        j5Var.d = (n5[]) Arrays.copyOf(j5Var.d, this.e);
        int i = this.e;
        this.j = new boolean[i];
        this.f = i;
        this.m = i;
    }

    public void e() {
        if (this.d.isEmpty()) {
            a();
        } else if (!this.h && !this.i) {
            a(this.d);
        } else {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.l) {
                    z = true;
                    break;
                } else if (!this.g[i].f) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                a(this.d);
            } else {
                a();
            }
        }
    }

    public final void f() {
        for (int i = 0; i < this.l; i++) {
            i5 i5Var = this.g[i];
            if (i5Var != null) {
                this.n.b.a(i5Var);
            }
            this.g[i] = null;
        }
    }

    public void g() {
        j5 j5Var;
        int i = 0;
        while (true) {
            j5Var = this.n;
            n5[] n5VarArr = j5Var.d;
            if (i >= n5VarArr.length) {
                break;
            }
            n5 n5Var = n5VarArr[i];
            if (n5Var != null) {
                n5Var.a();
            }
            i++;
        }
        j5Var.c.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.d, (Object) null);
        HashMap<String, n5> hashMap = this.c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.b = 0;
        this.d.clear();
        this.k = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            i5[] i5VarArr = this.g;
            if (i5VarArr[i2] != null) {
                i5VarArr[i2].c = false;
            }
        }
        f();
        this.l = 0;
        this.q = new i5(this.n);
    }

    public void c(n5 n5Var, n5 n5Var2, int i, int i2) {
        i5 b = b();
        n5 c = c();
        c.g = 0;
        b.b(n5Var, n5Var2, c, i);
        if (i2 != 8) {
            b.e.a(a(i2, (String) null), (int) (b.e.a(c) * (-1.0f)));
        }
        a(b);
    }

    public int b(Object obj) {
        n5 n5Var = ((s5) obj).i;
        if (n5Var != null) {
            return (int) (n5Var.h + 0.5f);
        }
        return 0;
    }

    public final void b(i5 i5Var) {
        int i;
        if (i5Var.f) {
            i5Var.a.a(this, i5Var.b);
        } else {
            i5[] i5VarArr = this.g;
            int i2 = this.l;
            i5VarArr[i2] = i5Var;
            n5 n5Var = i5Var.a;
            n5Var.f = i2;
            this.l = i2 + 1;
            n5Var.a(this, i5Var);
        }
        if (this.a) {
            int i3 = 0;
            while (i3 < this.l) {
                if (this.g[i3] == null) {
                    System.out.println("WTF");
                }
                i5[] i5VarArr2 = this.g;
                if (i5VarArr2[i3] != null && i5VarArr2[i3].f) {
                    i5 i5Var2 = i5VarArr2[i3];
                    i5Var2.a.a(this, i5Var2.b);
                    this.n.b.a(i5Var2);
                    this.g[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.l;
                        if (i4 >= i) {
                            break;
                        }
                        i5[] i5VarArr3 = this.g;
                        int i6 = i4 - 1;
                        i5VarArr3[i6] = i5VarArr3[i4];
                        if (i5VarArr3[i6].a.f == i4) {
                            i5VarArr3[i6].a.f = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.g[i5] = null;
                    }
                    this.l--;
                    i3--;
                }
                i3++;
            }
            this.a = false;
        }
    }

    public n5 a(int i, String str) {
        if (this.k + 1 >= this.f) {
            d();
        }
        n5 a2 = a(n5.a.ERROR, str);
        this.b++;
        this.k++;
        int i2 = this.b;
        a2.e = i2;
        a2.g = i;
        this.n.d[i2] = a2;
        this.d.a(a2);
        return a2;
    }

    public final n5 a(n5.a aVar, String str) {
        n5 a2 = this.n.c.a();
        if (a2 == null) {
            a2 = new n5(aVar);
            a2.l = aVar;
        } else {
            a2.a();
            a2.l = aVar;
        }
        int i = this.p;
        int i2 = s;
        if (i >= i2) {
            s = i2 * 2;
            this.o = (n5[]) Arrays.copyOf(this.o, s);
        }
        n5[] n5VarArr = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        n5VarArr[i3] = a2;
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.i5 r18) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k5.a(i5):void");
    }

    public final int b(a aVar) {
        for (int i = 0; i < this.k; i++) {
            this.j[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.k * 2) {
                return i2;
            }
            i5 i5Var = (i5) aVar;
            n5 n5Var = i5Var.a;
            if (n5Var != null) {
                this.j[n5Var.e] = true;
            }
            n5 a2 = i5Var.a(this, this.j);
            if (a2 != null) {
                boolean[] zArr = this.j;
                int i3 = a2.e;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (a2 != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.l; i5++) {
                    i5 i5Var2 = this.g[i5];
                    if (i5Var2.a.l != n5.a.UNRESTRICTED && !i5Var2.f && i5Var2.e.b(a2)) {
                        float a3 = i5Var2.e.a(a2);
                        if (a3 < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            float f2 = (-i5Var2.b) / a3;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    i5 i5Var3 = this.g[i4];
                    i5Var3.a.f = -1;
                    i5Var3.c(a2);
                    n5 n5Var2 = i5Var3.a;
                    n5Var2.f = i4;
                    n5Var2.a(this, i5Var3);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    public void b(n5 n5Var, n5 n5Var2, int i, int i2) {
        i5 b = b();
        n5 c = c();
        c.g = 0;
        b.a(n5Var, n5Var2, c, i);
        if (i2 != 8) {
            b.e.a(a(i2, (String) null), (int) (b.e.a(c) * (-1.0f)));
        }
        a(b);
    }

    public void a(a aVar) {
        float f;
        int i;
        boolean z;
        int i2 = 0;
        while (true) {
            int i3 = this.l;
            f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            i = 1;
            if (i2 >= i3) {
                z = false;
                break;
            }
            i5[] i5VarArr = this.g;
            if (i5VarArr[i2].a.l != n5.a.UNRESTRICTED && i5VarArr[i2].b < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i4 = 0;
            while (!z2) {
                i4 += i;
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                int i8 = 0;
                while (i7 < this.l) {
                    i5 i5Var = this.g[i7];
                    if (i5Var.a.l != n5.a.UNRESTRICTED && !i5Var.f && i5Var.b < f) {
                        int a2 = i5Var.e.a();
                        int i9 = i8;
                        int i10 = i6;
                        int i11 = i5;
                        int i12 = 0;
                        while (i12 < a2) {
                            n5 b = i5Var.e.b(i12);
                            float a3 = i5Var.e.a(b);
                            if (a3 > f) {
                                int i13 = i9;
                                float f3 = f2;
                                int i14 = i10;
                                int i15 = i11;
                                for (int i16 = 0; i16 < 9; i16++) {
                                    float f4 = b.j[i16] / a3;
                                    if ((f4 < f3 && i16 == i13) || i16 > i13) {
                                        i14 = b.e;
                                        f3 = f4;
                                        i15 = i7;
                                        i13 = i16;
                                    }
                                }
                                i11 = i15;
                                i10 = i14;
                                f2 = f3;
                                i9 = i13;
                            }
                            i12++;
                            f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                        }
                        i5 = i11;
                        i6 = i10;
                        i8 = i9;
                    }
                    i7++;
                    f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                }
                if (i5 != -1) {
                    i5 i5Var2 = this.g[i5];
                    i5Var2.a.f = -1;
                    i5Var2.c(this.n.d[i6]);
                    n5 n5Var = i5Var2.a;
                    n5Var.f = i5;
                    n5Var.a(this, i5Var2);
                } else {
                    z2 = true;
                }
                if (i4 > this.k / 2) {
                    z2 = true;
                }
                f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                i = 1;
            }
        }
        b(aVar);
        a();
    }

    public final void a() {
        for (int i = 0; i < this.l; i++) {
            i5 i5Var = this.g[i];
            i5Var.a.h = i5Var.b;
        }
    }

    public void a(n5 n5Var, n5 n5Var2, int i, float f, n5 n5Var3, n5 n5Var4, int i2, int i3) {
        i5 b = b();
        if (n5Var2 == n5Var3) {
            b.e.a(n5Var, 1.0f);
            b.e.a(n5Var4, 1.0f);
            b.e.a(n5Var2, -2.0f);
        } else if (f == 0.5f) {
            b.e.a(n5Var, 1.0f);
            b.e.a(n5Var2, -1.0f);
            b.e.a(n5Var3, -1.0f);
            b.e.a(n5Var4, 1.0f);
            if (i > 0 || i2 > 0) {
                b.b = (-i) + i2;
            }
        } else if (f <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            b.e.a(n5Var, -1.0f);
            b.e.a(n5Var2, 1.0f);
            b.b = i;
        } else if (f >= 1.0f) {
            b.e.a(n5Var4, -1.0f);
            b.e.a(n5Var3, 1.0f);
            b.b = -i2;
        } else {
            float f2 = 1.0f - f;
            b.e.a(n5Var, f2 * 1.0f);
            b.e.a(n5Var2, f2 * (-1.0f));
            b.e.a(n5Var3, (-1.0f) * f);
            b.e.a(n5Var4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                b.b = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            b.a(this, i3);
        }
        a(b);
    }

    public void a(n5 n5Var, n5 n5Var2, n5 n5Var3, n5 n5Var4, float f, int i) {
        i5 b = b();
        b.a(n5Var, n5Var2, n5Var3, n5Var4, f);
        if (i != 8) {
            b.a(this, i);
        }
        a(b);
    }

    public i5 a(n5 n5Var, n5 n5Var2, int i, int i2) {
        if (i2 == 8 && n5Var2.i && n5Var.f == -1) {
            n5Var.a(this, n5Var2.h + i);
            return null;
        }
        i5 b = b();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            b.b = i;
        }
        if (!z) {
            b.e.a(n5Var, -1.0f);
            b.e.a(n5Var2, 1.0f);
        } else {
            b.e.a(n5Var, 1.0f);
            b.e.a(n5Var2, -1.0f);
        }
        if (i2 != 8) {
            b.a(this, i2);
        }
        a(b);
        return b;
    }

    public void a(n5 n5Var, int i) {
        int i2 = n5Var.f;
        if (i2 == -1) {
            float f = i;
            n5Var.a(this, f);
            for (int i3 = 0; i3 < this.b + 1; i3++) {
                n5 n5Var2 = this.n.d[i3];
                if (n5Var2 != null && n5Var2.p && n5Var2.q == n5Var.e) {
                    n5Var2.a(this, n5Var2.r + f);
                }
            }
        } else if (i2 != -1) {
            i5 i5Var = this.g[i2];
            if (i5Var.f) {
                i5Var.b = i;
            } else if (i5Var.e.a() == 0) {
                i5Var.f = true;
                i5Var.b = i;
            } else {
                i5 b = b();
                if (i < 0) {
                    b.b = i * (-1);
                    b.e.a(n5Var, 1.0f);
                } else {
                    b.b = i;
                    b.e.a(n5Var, -1.0f);
                }
                a(b);
            }
        } else {
            i5 b2 = b();
            b2.a = n5Var;
            float f2 = i;
            n5Var.h = f2;
            b2.b = f2;
            b2.f = true;
            a(b2);
        }
    }
}
