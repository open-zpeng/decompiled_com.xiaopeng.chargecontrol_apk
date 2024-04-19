package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.s5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintWidget.java */
/* renamed from: t5  reason: default package */
/* loaded from: classes.dex */
public class t5 {
    public static float t0 = 0.5f;
    public float A;
    public int B;
    public float C;
    public int[] D;
    public float E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public s5 K;
    public s5 L;
    public s5 M;
    public s5 N;
    public s5 O;
    public s5 P;
    public s5 Q;
    public s5 R;
    public s5[] S;
    public ArrayList<s5> T;
    public boolean[] U;
    public a[] V;
    public t5 W;
    public int X;
    public int Y;
    public float Z;
    public int a0;
    public d6 b;
    public int b0;
    public d6 c;
    public int c0;
    public int d0;
    public int e0;
    public int f0;
    public float g0;
    public float h0;
    public Object i0;
    public int j0;
    public String k0;
    public boolean l;
    public String l0;
    public boolean m;
    public int m0;
    public boolean n;
    public int n0;
    public boolean o;
    public float[] o0;
    public int p;
    public t5[] p0;
    public int q;
    public t5[] q0;
    public int r;
    public int r0;
    public int s;
    public int s0;
    public int t;
    public int[] u;
    public int v;
    public int w;
    public float x;
    public int y;
    public int z;
    public boolean a = false;
    public l6 d = null;
    public n6 e = null;
    public boolean[] f = {true, true};
    public boolean g = true;
    public boolean h = false;
    public boolean i = true;
    public int j = -1;
    public int k = -1;

    /* compiled from: ConstraintWidget.java */
    /* renamed from: t5$a */
    /* loaded from: classes.dex */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public t5() {
        new p5(this);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = new int[2];
        this.v = 0;
        this.w = 0;
        this.x = 1.0f;
        this.y = 0;
        this.z = 0;
        this.A = 1.0f;
        this.B = -1;
        this.C = 1.0f;
        this.D = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.E = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.F = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = new s5(this, s5.a.LEFT);
        this.L = new s5(this, s5.a.TOP);
        this.M = new s5(this, s5.a.RIGHT);
        this.N = new s5(this, s5.a.BOTTOM);
        this.O = new s5(this, s5.a.BASELINE);
        this.P = new s5(this, s5.a.CENTER_X);
        this.Q = new s5(this, s5.a.CENTER_Y);
        this.R = new s5(this, s5.a.CENTER);
        this.S = new s5[]{this.K, this.M, this.L, this.N, this.O, this.R};
        this.T = new ArrayList<>();
        this.U = new boolean[2];
        a aVar = a.FIXED;
        this.V = new a[]{aVar, aVar};
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.Z = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.a0 = -1;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        float f = t0;
        this.g0 = f;
        this.h0 = f;
        this.j0 = 0;
        this.k0 = null;
        this.l0 = null;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = new float[]{-1.0f, -1.0f};
        this.p0 = new t5[]{null, null};
        this.q0 = new t5[]{null, null};
        this.r0 = -1;
        this.s0 = -1;
        this.T.add(this.K);
        this.T.add(this.L);
        this.T.add(this.M);
        this.T.add(this.N);
        this.T.add(this.P);
        this.T.add(this.Q);
        this.T.add(this.R);
        this.T.add(this.O);
    }

    public boolean a(int i, int i2) {
        s5 s5Var;
        s5 s5Var2;
        if (i == 0) {
            s5 s5Var3 = this.K.f;
            if (s5Var3 != null && s5Var3.c && (s5Var2 = this.M.f) != null && s5Var2.c) {
                return (s5Var2.a() - this.M.b()) - (this.K.b() + this.K.f.a()) >= i2;
            }
        } else {
            s5 s5Var4 = this.L.f;
            if (s5Var4 != null && s5Var4.c && (s5Var = this.N.f) != null && s5Var.c) {
                return (s5Var.a() - this.N.b()) - (this.L.b() + this.L.f.a()) >= i2;
            }
        }
        return false;
    }

    public void b(int i, int i2) {
        if (this.l) {
            return;
        }
        s5 s5Var = this.K;
        s5Var.b = i;
        s5Var.c = true;
        s5 s5Var2 = this.M;
        s5Var2.b = i2;
        s5Var2.c = true;
        this.b0 = i;
        this.X = i2 - i;
        this.l = true;
    }

    public void c(int i, int i2) {
        if (this.m) {
            return;
        }
        s5 s5Var = this.L;
        s5Var.b = i;
        s5Var.c = true;
        s5 s5Var2 = this.N;
        s5Var2.b = i2;
        s5Var2.c = true;
        this.c0 = i;
        this.Y = i2 - i;
        if (this.F) {
            this.O.a(i + this.d0);
        }
        this.m = true;
    }

    public int d() {
        return k() + this.Y;
    }

    public p6 e(int i) {
        if (i == 0) {
            return this.d;
        }
        if (i == 1) {
            return this.e;
        }
        return null;
    }

    public boolean f(int i) {
        if (i == 0) {
            return (this.K.f != null ? 1 : 0) + (this.M.f != null ? 1 : 0) < 2;
        }
        return ((this.L.f != null ? 1 : 0) + (this.N.f != null ? 1 : 0)) + (this.O.f != null ? 1 : 0) < 2;
    }

    public int g() {
        return j() + this.X;
    }

    public void h(int i) {
        this.d0 = i;
        this.F = i > 0;
    }

    public int i() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public int j() {
        t5 t5Var = this.W;
        if (t5Var != null && (t5Var instanceof u5)) {
            return ((u5) t5Var).B0 + this.b0;
        }
        return this.b0;
    }

    public int k() {
        t5 t5Var = this.W;
        if (t5Var != null && (t5Var instanceof u5)) {
            return ((u5) t5Var).C0 + this.c0;
        }
        return this.c0;
    }

    public void l(int i) {
        this.X = i;
        int i2 = this.X;
        int i3 = this.e0;
        if (i2 < i3) {
            this.X = i3;
        }
    }

    public boolean m() {
        s5 s5Var = this.L;
        s5 s5Var2 = s5Var.f;
        if (s5Var2 == null || s5Var2.f != s5Var) {
            s5 s5Var3 = this.N;
            s5 s5Var4 = s5Var3.f;
            return s5Var4 != null && s5Var4.f == s5Var3;
        }
        return true;
    }

    public boolean n() {
        return this.g && this.j0 != 8;
    }

    public boolean o() {
        return this.l || (this.K.c && this.M.c);
    }

    public boolean p() {
        return this.m || (this.L.c && this.N.c);
    }

    public void q() {
        this.K.f();
        this.L.f();
        this.M.f();
        this.N.f();
        this.O.f();
        this.P.f();
        this.Q.f();
        this.R.f();
        this.W = null;
        this.E = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.X = 0;
        this.Y = 0;
        this.Z = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.a0 = -1;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        float f = t0;
        this.g0 = f;
        this.h0 = f;
        a[] aVarArr = this.V;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.i0 = null;
        this.j0 = 0;
        this.l0 = null;
        this.m0 = 0;
        this.n0 = 0;
        float[] fArr = this.o0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.p = -1;
        this.q = -1;
        int[] iArr = this.D;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.s = 0;
        this.t = 0;
        this.x = 1.0f;
        this.A = 1.0f;
        this.w = Integer.MAX_VALUE;
        this.z = Integer.MAX_VALUE;
        this.v = 0;
        this.y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.H = false;
        boolean[] zArr2 = this.U;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr2 = this.u;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.j = -1;
        this.k = -1;
    }

    public void r() {
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            s5 s5Var = this.T.get(i);
            s5Var.c = false;
            s5Var.b = 0;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l0 != null ? jg.a(jg.a("type: "), this.l0, " ") : "");
        sb.append(this.k0 != null ? jg.a(jg.a("id: "), this.k0, " ") : "");
        sb.append("(");
        sb.append(this.b0);
        sb.append(", ");
        sb.append(this.c0);
        sb.append(") - (");
        sb.append(this.X);
        sb.append(" x ");
        sb.append(this.Y);
        sb.append(")");
        return sb.toString();
    }

    public t5 d(int i) {
        s5 s5Var;
        s5 s5Var2;
        if (i != 0) {
            if (i == 1 && (s5Var2 = (s5Var = this.L).f) != null && s5Var2.f == s5Var) {
                return s5Var2.d;
            }
            return null;
        }
        s5 s5Var3 = this.K;
        s5 s5Var4 = s5Var3.f;
        if (s5Var4 == null || s5Var4.f != s5Var3) {
            return null;
        }
        return s5Var4.d;
    }

    public final boolean g(int i) {
        int i2 = i * 2;
        s5[] s5VarArr = this.S;
        if (s5VarArr[i2].f != null && s5VarArr[i2].f.f != s5VarArr[i2]) {
            int i3 = i2 + 1;
            if (s5VarArr[i3].f != null && s5VarArr[i3].f.f == s5VarArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public int e() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public a f() {
        return this.V[0];
    }

    public a h() {
        return this.V[1];
    }

    public void i(int i) {
        this.Y = i;
        int i2 = this.Y;
        int i3 = this.f0;
        if (i2 < i3) {
            this.Y = i3;
        }
    }

    public void j(int i) {
        if (i < 0) {
            this.f0 = 0;
        } else {
            this.f0 = i;
        }
    }

    public void k(int i) {
        if (i < 0) {
            this.e0 = 0;
        } else {
            this.e0 = i;
        }
    }

    public boolean l() {
        s5 s5Var = this.K;
        s5 s5Var2 = s5Var.f;
        if (s5Var2 == null || s5Var2.f != s5Var) {
            s5 s5Var3 = this.M;
            s5 s5Var4 = s5Var3.f;
            return s5Var4 != null && s5Var4.f == s5Var3;
        }
        return true;
    }

    public boolean b() {
        return this.j0 != 8;
    }

    public a b(int i) {
        if (i == 0) {
            return f();
        }
        if (i == 1) {
            return h();
        }
        return null;
    }

    public void a(j5 j5Var) {
        this.K.g();
        this.L.g();
        this.M.g();
        this.N.g();
        this.O.g();
        this.R.g();
        this.P.g();
        this.Q.g();
    }

    public void c() {
        if (this.d == null) {
            this.d = new l6(this);
        }
        if (this.e == null) {
            this.e = new n6(this);
        }
    }

    public void b(a aVar) {
        this.V[1] = aVar;
    }

    public void b(k5 k5Var, boolean z) {
        int i;
        int i2;
        n6 n6Var;
        l6 l6Var;
        int b = k5Var.b(this.K);
        int b2 = k5Var.b(this.L);
        int b3 = k5Var.b(this.M);
        int b4 = k5Var.b(this.N);
        if (z && (l6Var = this.d) != null) {
            g6 g6Var = l6Var.h;
            if (g6Var.j) {
                g6 g6Var2 = l6Var.i;
                if (g6Var2.j) {
                    b = g6Var.g;
                    b3 = g6Var2.g;
                }
            }
        }
        if (z && (n6Var = this.e) != null) {
            g6 g6Var3 = n6Var.h;
            if (g6Var3.j) {
                g6 g6Var4 = n6Var.i;
                if (g6Var4.j) {
                    b2 = g6Var3.g;
                    b4 = g6Var4.g;
                }
            }
        }
        int i3 = b4 - b2;
        if (b3 - b < 0 || i3 < 0 || b == Integer.MIN_VALUE || b == Integer.MAX_VALUE || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE) {
            b4 = 0;
            b = 0;
            b2 = 0;
            b3 = 0;
        }
        int i4 = b3 - b;
        int i5 = b4 - b2;
        this.b0 = b;
        this.c0 = b2;
        if (this.j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        if (this.V[0] != a.FIXED || i4 >= (i = this.X)) {
            i = i4;
        }
        if (this.V[1] == a.FIXED && i5 < (i2 = this.Y)) {
            i5 = i2;
        }
        this.X = i;
        this.Y = i5;
        int i6 = this.Y;
        int i7 = this.f0;
        if (i6 < i7) {
            this.Y = i7;
        }
        int i8 = this.X;
        int i9 = this.e0;
        if (i8 < i9) {
            this.X = i9;
        }
        int i10 = this.w;
        if (i10 > 0 && this.V[0] == a.MATCH_CONSTRAINT) {
            this.X = Math.min(this.X, i10);
        }
        int i11 = this.z;
        if (i11 > 0 && this.V[1] == a.MATCH_CONSTRAINT) {
            this.Y = Math.min(this.Y, i11);
        }
        int i12 = this.X;
        if (i != i12) {
            this.j = i12;
        }
        int i13 = this.Y;
        if (i5 != i13) {
            this.k = i13;
        }
    }

    public t5 c(int i) {
        s5 s5Var;
        s5 s5Var2;
        if (i != 0) {
            if (i == 1 && (s5Var2 = (s5Var = this.N).f) != null && s5Var2.f == s5Var) {
                return s5Var2.d;
            }
            return null;
        }
        s5 s5Var3 = this.M;
        s5 s5Var4 = s5Var3.f;
        if (s5Var4 == null || s5Var4.f != s5Var3) {
            return null;
        }
        return s5Var4.d;
    }

    public void a(k5 k5Var) {
        k5Var.a(this.K);
        k5Var.a(this.L);
        k5Var.a(this.M);
        k5Var.a(this.N);
        if (this.d0 > 0) {
            k5Var.a(this.O);
        }
    }

    public float a(int i) {
        if (i == 0) {
            return this.g0;
        }
        if (i == 1) {
            return this.h0;
        }
        return -1.0f;
    }

    public void a(s5.a aVar, t5 t5Var, s5.a aVar2, int i, int i2) {
        a(aVar).a(t5Var.a(aVar2), i, i2, true);
    }

    public s5 a(s5.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.K;
            case 2:
                return this.L;
            case 3:
                return this.M;
            case 4:
                return this.N;
            case 5:
                return this.O;
            case 6:
                return this.R;
            case 7:
                return this.P;
            case 8:
                return this.Q;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public void a(a aVar) {
        this.V[0] = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0168  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.k5 r51, boolean r52) {
        /*
            Method dump skipped, instructions count: 1804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t5.a(k5, boolean):void");
    }

    public boolean a() {
        return (this instanceof z5) || (this instanceof v5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:267:0x043e, code lost:
        if ((r3 instanceof defpackage.q5) != false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0569, code lost:
        if (r1[r17] == r3) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x04e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x04fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x053a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:385:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:388:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.k5 r38, boolean r39, boolean r40, boolean r41, boolean r42, defpackage.n5 r43, defpackage.n5 r44, defpackage.t5.a r45, boolean r46, defpackage.s5 r47, defpackage.s5 r48, int r49, int r50, int r51, int r52, float r53, boolean r54, boolean r55, boolean r56, boolean r57, boolean r58, int r59, int r60, int r61, int r62, float r63, boolean r64) {
        /*
            Method dump skipped, instructions count: 1399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t5.a(k5, boolean, boolean, boolean, boolean, n5, n5, t5$a, boolean, s5, s5, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void a(boolean z, boolean z2) {
        int i;
        int i2;
        l6 l6Var = this.d;
        boolean z3 = z & l6Var.g;
        n6 n6Var = this.e;
        boolean z4 = z2 & n6Var.g;
        int i3 = l6Var.h.g;
        int i4 = n6Var.h.g;
        int i5 = l6Var.i.g;
        int i6 = n6Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.b0 = i3;
        }
        if (z4) {
            this.c0 = i4;
        }
        if (this.j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        if (z3) {
            if (this.V[0] != a.FIXED || i8 >= (i2 = this.X)) {
                i2 = i8;
            }
            this.X = i2;
            int i10 = this.X;
            int i11 = this.e0;
            if (i10 < i11) {
                this.X = i11;
            }
        }
        if (z4) {
            if (this.V[1] != a.FIXED || i9 >= (i = this.Y)) {
                i = i9;
            }
            this.Y = i;
            int i12 = this.Y;
            int i13 = this.f0;
            if (i12 < i13) {
                this.Y = i13;
            }
        }
    }

    public void a(u5 u5Var, k5 k5Var, HashSet<t5> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            y5.a(u5Var, k5Var, this);
            hashSet.remove(this);
            a(k5Var, u5Var.m(64));
        }
        if (i == 0) {
            HashSet<s5> hashSet2 = this.K.a;
            if (hashSet2 != null) {
                Iterator<s5> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().d.a(u5Var, k5Var, hashSet, i, true);
                }
            }
            HashSet<s5> hashSet3 = this.M.a;
            if (hashSet3 != null) {
                Iterator<s5> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().d.a(u5Var, k5Var, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<s5> hashSet4 = this.L.a;
        if (hashSet4 != null) {
            Iterator<s5> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().d.a(u5Var, k5Var, hashSet, i, true);
            }
        }
        HashSet<s5> hashSet5 = this.N.a;
        if (hashSet5 != null) {
            Iterator<s5> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().d.a(u5Var, k5Var, hashSet, i, true);
            }
        }
        HashSet<s5> hashSet6 = this.O.a;
        if (hashSet6 != null) {
            Iterator<s5> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().d.a(u5Var, k5Var, hashSet, i, true);
            }
        }
    }
}
