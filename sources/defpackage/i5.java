package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.k5;
import defpackage.n5;
import java.util.ArrayList;
/* compiled from: ArrayRow.java */
/* renamed from: i5  reason: default package */
/* loaded from: classes.dex */
public class i5 implements k5.a {
    public boolean c;
    public a e;
    public n5 a = null;
    public float b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public ArrayList<n5> d = new ArrayList<>();
    public boolean f = false;

    /* compiled from: ArrayRow.java */
    /* renamed from: i5$a */
    /* loaded from: classes.dex */
    public interface a {
        float a(int i);

        float a(i5 i5Var, boolean z);

        float a(n5 n5Var);

        float a(n5 n5Var, boolean z);

        int a();

        void a(float f);

        void a(n5 n5Var, float f);

        void a(n5 n5Var, float f, boolean z);

        n5 b(int i);

        void b();

        boolean b(n5 n5Var);

        void clear();
    }

    public i5() {
    }

    public i5 a(n5 n5Var, n5 n5Var2, n5 n5Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.e.a(n5Var, -1.0f);
            this.e.a(n5Var2, 1.0f);
            this.e.a(n5Var3, 1.0f);
        } else {
            this.e.a(n5Var, 1.0f);
            this.e.a(n5Var2, -1.0f);
            this.e.a(n5Var3, -1.0f);
        }
        return this;
    }

    public i5 b(n5 n5Var, n5 n5Var2, n5 n5Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.e.a(n5Var, -1.0f);
            this.e.a(n5Var2, 1.0f);
            this.e.a(n5Var3, -1.0f);
        } else {
            this.e.a(n5Var, 1.0f);
            this.e.a(n5Var2, -1.0f);
            this.e.a(n5Var3, 1.0f);
        }
        return this;
    }

    public void c(n5 n5Var) {
        n5 n5Var2 = this.a;
        if (n5Var2 != null) {
            this.e.a(n5Var2, -1.0f);
            this.a.f = -1;
            this.a = null;
        }
        float a2 = this.e.a(n5Var, true) * (-1.0f);
        this.a = n5Var;
        if (a2 == 1.0f) {
            return;
        }
        this.b /= a2;
        this.e.a(a2);
    }

    @Override // defpackage.k5.a
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    @Override // defpackage.k5.a
    public boolean isEmpty() {
        return this.a == null && this.b == XToggleDrawable.LIGHT_RADIUS_DEFAULT && this.e.a() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            n5 r0 = r10.a
            java.lang.String r1 = ""
            if (r0 != 0) goto Ld
            java.lang.String r0 = "0"
            java.lang.String r0 = defpackage.jg.a(r1, r0)
            goto L1a
        Ld:
            java.lang.StringBuilder r0 = defpackage.jg.a(r1)
            n5 r1 = r10.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L1a:
            java.lang.String r1 = " = "
            java.lang.String r0 = defpackage.jg.a(r0, r1)
            float r1 = r10.b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L38
            java.lang.StringBuilder r0 = defpackage.jg.a(r0)
            float r1 = r10.b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L39
        L38:
            r1 = r3
        L39:
            i5$a r5 = r10.e
            int r5 = r5.a()
        L3f:
            if (r3 >= r5) goto L9e
            i5$a r6 = r10.e
            n5 r6 = r6.b(r3)
            if (r6 != 0) goto L4a
            goto L9b
        L4a:
            i5$a r7 = r10.e
            float r7 = r7.a(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L55
            goto L9b
        L55:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L68
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L78
            java.lang.String r1 = "- "
            java.lang.String r0 = defpackage.jg.a(r0, r1)
            goto L77
        L68:
            if (r8 <= 0) goto L71
            java.lang.String r1 = " + "
            java.lang.String r0 = defpackage.jg.a(r0, r1)
            goto L78
        L71:
            java.lang.String r1 = " - "
            java.lang.String r0 = defpackage.jg.a(r0, r1)
        L77:
            float r7 = r7 * r9
        L78:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L83
            java.lang.String r0 = defpackage.jg.a(r0, r6)
            goto L9a
        L83:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L9a:
            r1 = r4
        L9b:
            int r3 = r3 + 1
            goto L3f
        L9e:
            if (r1 != 0) goto La6
            java.lang.String r1 = "0.0"
            java.lang.String r0 = defpackage.jg.a(r0, r1)
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i5.toString():java.lang.String");
    }

    public i5(j5 j5Var) {
        this.e = new h5(this, j5Var);
    }

    public i5 a(k5 k5Var, int i) {
        this.e.a(k5Var.a(i, "ep"), 1.0f);
        this.e.a(k5Var.a(i, "em"), -1.0f);
        return this;
    }

    public i5 b(n5 n5Var, n5 n5Var2, n5 n5Var3, n5 n5Var4, float f) {
        this.e.a(n5Var3, 0.5f);
        this.e.a(n5Var4, 0.5f);
        this.e.a(n5Var, -0.5f);
        this.e.a(n5Var2, -0.5f);
        this.b = -f;
        return this;
    }

    public i5 a(n5 n5Var, n5 n5Var2, n5 n5Var3, n5 n5Var4, float f) {
        this.e.a(n5Var, -1.0f);
        this.e.a(n5Var2, 1.0f);
        this.e.a(n5Var3, f);
        this.e.a(n5Var4, -f);
        return this;
    }

    public final boolean b(n5 n5Var) {
        return n5Var.o <= 1;
    }

    public void a(k5 k5Var, i5 i5Var, boolean z) {
        float a2 = this.e.a(i5Var, z);
        this.b = (i5Var.b * a2) + this.b;
        if (z) {
            i5Var.a.b(this);
        }
        if (this.a == null || this.e.a() != 0) {
            return;
        }
        this.f = true;
        k5Var.a = true;
    }

    public void a(k5 k5Var, n5 n5Var, boolean z) {
        if (n5Var == null || !n5Var.i) {
            return;
        }
        float a2 = this.e.a(n5Var);
        this.b = (n5Var.h * a2) + this.b;
        this.e.a(n5Var, z);
        if (z) {
            n5Var.b(this);
        }
        if (this.e.a() == 0) {
            this.f = true;
            k5Var.a = true;
        }
    }

    public final n5 a(boolean[] zArr, n5 n5Var) {
        n5.a aVar;
        int a2 = this.e.a();
        n5 n5Var2 = null;
        float f = 0.0f;
        for (int i = 0; i < a2; i++) {
            float a3 = this.e.a(i);
            if (a3 < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                n5 b = this.e.b(i);
                if ((zArr == null || !zArr[b.e]) && b != n5Var && (((aVar = b.l) == n5.a.SLACK || aVar == n5.a.ERROR) && a3 < f)) {
                    f = a3;
                    n5Var2 = b;
                }
            }
        }
        return n5Var2;
    }

    @Override // defpackage.k5.a
    public n5 a(k5 k5Var, boolean[] zArr) {
        return a(zArr, (n5) null);
    }

    public void a(k5.a aVar) {
        if (aVar instanceof i5) {
            i5 i5Var = (i5) aVar;
            this.a = null;
            this.e.clear();
            for (int i = 0; i < i5Var.e.a(); i++) {
                this.e.a(i5Var.e.b(i), i5Var.e.a(i), true);
            }
        }
    }

    @Override // defpackage.k5.a
    public void a(n5 n5Var) {
        int i = n5Var.g;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.e.a(n5Var, f);
    }
}
