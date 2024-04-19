package defpackage;

import defpackage.n5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintAnchor.java */
/* renamed from: s5  reason: default package */
/* loaded from: classes.dex */
public class s5 {
    public int b;
    public boolean c;
    public final t5 d;
    public final a e;
    public s5 f;
    public n5 i;
    public HashSet<s5> a = null;
    public int g = 0;
    public int h = Integer.MIN_VALUE;

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: s5$a */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public s5(t5 t5Var, a aVar) {
        this.d = t5Var;
        this.e = aVar;
    }

    public void a(int i, ArrayList<o6> arrayList, o6 o6Var) {
        HashSet<s5> hashSet = this.a;
        if (hashSet != null) {
            Iterator<s5> it = hashSet.iterator();
            while (it.hasNext()) {
                defpackage.a.a(it.next().d, i, arrayList, o6Var);
            }
        }
    }

    public int b() {
        s5 s5Var;
        if (this.d.j0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (s5Var = this.f) == null || s5Var.d.j0 != 8) ? this.g : i;
    }

    public boolean c() {
        s5 s5Var;
        HashSet<s5> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator<s5> it = hashSet.iterator();
        while (it.hasNext()) {
            s5 next = it.next();
            switch (next.e.ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    s5Var = null;
                    break;
                case 1:
                    s5Var = next.d.M;
                    break;
                case 2:
                    s5Var = next.d.N;
                    break;
                case 3:
                    s5Var = next.d.K;
                    break;
                case 4:
                    s5Var = next.d.L;
                    break;
                default:
                    throw new AssertionError(next.e.name());
            }
            if (s5Var.e()) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        HashSet<s5> hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean e() {
        return this.f != null;
    }

    public void f() {
        HashSet<s5> hashSet;
        s5 s5Var = this.f;
        if (s5Var != null && (hashSet = s5Var.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public void g() {
        n5 n5Var = this.i;
        if (n5Var == null) {
            this.i = new n5(n5.a.UNRESTRICTED);
        } else {
            n5Var.a();
        }
    }

    public String toString() {
        return this.d.k0 + ":" + this.e.toString();
    }

    public void a(int i) {
        this.b = i;
        this.c = true;
    }

    public int a() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r4.d.F == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
        if (r8 != defpackage.s5.a.f) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0064, code lost:
        if (r8 != defpackage.s5.a.k) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0081, code lost:
        if (r8 != defpackage.s5.a.j) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(defpackage.s5 r5, int r6, int r7, boolean r8) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != 0) goto L7
            r4.f()
            return r0
        L7:
            if (r8 != 0) goto L87
            s5$a r8 = r5.e
            s5$a r1 = r4.e
            r2 = 0
            if (r8 != r1) goto L21
            s5$a r8 = defpackage.s5.a.BASELINE
            if (r1 != r8) goto L69
            t5 r8 = r5.d
            boolean r8 = r8.F
            if (r8 == 0) goto L67
            t5 r8 = r4.d
            boolean r8 = r8.F
            if (r8 != 0) goto L69
            goto L67
        L21:
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L67;
                case 1: goto L6b;
                case 2: goto L4e;
                case 3: goto L6b;
                case 4: goto L4e;
                case 5: goto L45;
                case 6: goto L34;
                case 7: goto L67;
                case 8: goto L67;
                default: goto L28;
            }
        L28:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            s5$a r6 = r4.e
            java.lang.String r6 = r6.name()
            r5.<init>(r6)
            throw r5
        L34:
            s5$a r1 = defpackage.s5.a.BASELINE
            if (r8 == r1) goto L42
            s5$a r1 = defpackage.s5.a.CENTER_X
            if (r8 == r1) goto L42
            s5$a r1 = defpackage.s5.a.CENTER_Y
            if (r8 == r1) goto L42
            r8 = r0
            goto L43
        L42:
            r8 = r2
        L43:
            r1 = r8
            goto L84
        L45:
            s5$a r1 = defpackage.s5.a.LEFT
            if (r8 == r1) goto L67
            s5$a r1 = defpackage.s5.a.RIGHT
            if (r8 != r1) goto L69
            goto L67
        L4e:
            s5$a r1 = defpackage.s5.a.TOP
            if (r8 == r1) goto L59
            s5$a r1 = defpackage.s5.a.BOTTOM
            if (r8 != r1) goto L57
            goto L59
        L57:
            r1 = r2
            goto L5a
        L59:
            r1 = r0
        L5a:
            t5 r3 = r5.d
            boolean r3 = r3 instanceof defpackage.v5
            if (r3 == 0) goto L84
            if (r1 != 0) goto L69
            s5$a r1 = defpackage.s5.a.CENTER_Y
            if (r8 != r1) goto L67
            goto L69
        L67:
            r1 = r2
            goto L84
        L69:
            r1 = r0
            goto L84
        L6b:
            s5$a r1 = defpackage.s5.a.LEFT
            if (r8 == r1) goto L76
            s5$a r1 = defpackage.s5.a.RIGHT
            if (r8 != r1) goto L74
            goto L76
        L74:
            r1 = r2
            goto L77
        L76:
            r1 = r0
        L77:
            t5 r3 = r5.d
            boolean r3 = r3 instanceof defpackage.v5
            if (r3 == 0) goto L84
            if (r1 != 0) goto L69
            s5$a r1 = defpackage.s5.a.CENTER_X
            if (r8 != r1) goto L67
            goto L69
        L84:
            if (r1 != 0) goto L87
            return r2
        L87:
            r4.f = r5
            s5 r5 = r4.f
            java.util.HashSet<s5> r8 = r5.a
            if (r8 != 0) goto L96
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            r5.a = r8
        L96:
            s5 r5 = r4.f
            java.util.HashSet<s5> r5 = r5.a
            if (r5 == 0) goto L9f
            r5.add(r4)
        L9f:
            r4.g = r6
            r4.h = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s5.a(s5, int, int, boolean):boolean");
    }
}
