package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.c6;
import defpackage.t5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintWidgetContainer.java */
/* renamed from: u5  reason: default package */
/* loaded from: classes.dex */
public class u5 extends a6 {
    public int B0;
    public int C0;
    public int x0;
    public c6 v0 = new c6(this);
    public f6 w0 = new f6(this);
    public c6.b y0 = null;
    public boolean z0 = false;
    public k5 A0 = new k5();
    public int D0 = 0;
    public int E0 = 0;
    public r5[] F0 = new r5[4];
    public r5[] G0 = new r5[4];
    public int H0 = 257;
    public boolean I0 = false;
    public boolean J0 = false;
    public WeakReference<s5> K0 = null;
    public WeakReference<s5> L0 = null;
    public WeakReference<s5> M0 = null;
    public WeakReference<s5> N0 = null;
    public HashSet<t5> O0 = new HashSet<>();
    public c6.a P0 = new c6.a();

    public boolean a(boolean z, int i) {
        boolean z2;
        t5.a aVar;
        f6 f6Var = this.w0;
        boolean z3 = true;
        boolean z4 = z & true;
        t5.a b = f6Var.a.b(0);
        t5.a b2 = f6Var.a.b(1);
        int j = f6Var.a.j();
        int k = f6Var.a.k();
        if (z4 && (b == (aVar = t5.a.WRAP_CONTENT) || b2 == aVar)) {
            Iterator<p6> it = f6Var.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p6 next = it.next();
                if (next.f == i && !next.e()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && b == t5.a.WRAP_CONTENT) {
                    f6Var.a.a(t5.a.FIXED);
                    u5 u5Var = f6Var.a;
                    u5Var.l(f6Var.a(u5Var, 0));
                    u5 u5Var2 = f6Var.a;
                    u5Var2.d.e.a(u5Var2.i());
                }
            } else if (z4 && b2 == t5.a.WRAP_CONTENT) {
                f6Var.a.b(t5.a.FIXED);
                u5 u5Var3 = f6Var.a;
                u5Var3.i(f6Var.a(u5Var3, 1));
                u5 u5Var4 = f6Var.a;
                u5Var4.e.e.a(u5Var4.e());
            }
        }
        if (i == 0) {
            t5.a[] aVarArr = f6Var.a.V;
            if (aVarArr[0] == t5.a.FIXED || aVarArr[0] == t5.a.MATCH_PARENT) {
                int i2 = f6Var.a.i() + j;
                f6Var.a.d.i.a(i2);
                f6Var.a.d.e.a(i2 - j);
                z2 = true;
            }
            z2 = false;
        } else {
            t5.a[] aVarArr2 = f6Var.a.V;
            if (aVarArr2[1] == t5.a.FIXED || aVarArr2[1] == t5.a.MATCH_PARENT) {
                int e = f6Var.a.e() + k;
                f6Var.a.e.i.a(e);
                f6Var.a.e.e.a(e - k);
                z2 = true;
            }
            z2 = false;
        }
        f6Var.b();
        Iterator<p6> it2 = f6Var.e.iterator();
        while (it2.hasNext()) {
            p6 next2 = it2.next();
            if (next2.f == i && (next2.b != f6Var.a || next2.g)) {
                next2.b();
            }
        }
        Iterator<p6> it3 = f6Var.e.iterator();
        while (it3.hasNext()) {
            p6 next3 = it3.next();
            if (next3.f == i && (z2 || next3.b != f6Var.a)) {
                if (!next3.h.j || !next3.i.j || (!(next3 instanceof d6) && !next3.e.j)) {
                    z3 = false;
                    break;
                }
            }
        }
        f6Var.a.a(b);
        f6Var.a.b(b2);
        return z3;
    }

    public void b(s5 s5Var) {
        WeakReference<s5> weakReference = this.L0;
        if (weakReference == null || weakReference.get() == null || s5Var.a() > this.L0.get().a()) {
            this.L0 = new WeakReference<>(s5Var);
        }
    }

    public void c(s5 s5Var) {
        WeakReference<s5> weakReference = this.M0;
        if (weakReference == null || weakReference.get() == null || s5Var.a() > this.M0.get().a()) {
            this.M0 = new WeakReference<>(s5Var);
        }
    }

    public void d(s5 s5Var) {
        WeakReference<s5> weakReference = this.K0;
        if (weakReference == null || weakReference.get() == null || s5Var.a() > this.K0.get().a()) {
            this.K0 = new WeakReference<>(s5Var);
        }
    }

    public boolean m(int i) {
        return (this.H0 & i) == i;
    }

    public void n(int i) {
        this.H0 = i;
        k5.r = m(IInputController.KEYCODE_BACK_BUTTON);
    }

    @Override // defpackage.a6, defpackage.t5
    public void q() {
        this.A0.g();
        this.B0 = 0;
        this.C0 = 0;
        super.q();
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0408 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0620 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0726  */
    /* JADX WARN: Type inference failed for: r11v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v9 */
    @Override // defpackage.a6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s() {
        /*
            Method dump skipped, instructions count: 1846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u5.s():void");
    }

    public void t() {
        this.w0.b = true;
    }

    public boolean b(k5 k5Var) {
        boolean z;
        boolean m = m(64);
        a(k5Var, m);
        int size = this.u0.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            t5 t5Var = this.u0.get(i);
            boolean[] zArr = t5Var.U;
            zArr[0] = false;
            zArr[1] = false;
            if (t5Var instanceof q5) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i2 = 0; i2 < size; i2++) {
                t5 t5Var2 = this.u0.get(i2);
                if (t5Var2 instanceof q5) {
                    q5 q5Var = (q5) t5Var2;
                    for (int i3 = 0; i3 < q5Var.v0; i3++) {
                        t5 t5Var3 = q5Var.u0[i3];
                        if (q5Var.x0 || t5Var3.b()) {
                            int i4 = q5Var.w0;
                            if (i4 == 0 || i4 == 1) {
                                t5Var3.U[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                t5Var3.U[1] = true;
                            }
                        }
                    }
                }
            }
        }
        this.O0.clear();
        for (int i5 = 0; i5 < size; i5++) {
            t5 t5Var4 = this.u0.get(i5);
            if (t5Var4.a()) {
                if (t5Var4 instanceof z5) {
                    this.O0.add(t5Var4);
                } else {
                    t5Var4.a(k5Var, m);
                }
            }
        }
        while (this.O0.size() > 0) {
            int size2 = this.O0.size();
            Iterator<t5> it = this.O0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                z5 z5Var = (z5) it.next();
                HashSet<t5> hashSet = this.O0;
                int i6 = 0;
                while (true) {
                    if (i6 >= z5Var.v0) {
                        z = false;
                        continue;
                        break;
                    } else if (hashSet.contains(z5Var.u0[i6])) {
                        z = true;
                        continue;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z) {
                    z5Var.a(k5Var, m);
                    this.O0.remove(z5Var);
                    break;
                }
            }
            if (size2 == this.O0.size()) {
                Iterator<t5> it2 = this.O0.iterator();
                while (it2.hasNext()) {
                    it2.next().a(k5Var, m);
                }
                this.O0.clear();
            }
        }
        if (k5.r) {
            HashSet<t5> hashSet2 = new HashSet<>();
            for (int i7 = 0; i7 < size; i7++) {
                t5 t5Var5 = this.u0.get(i7);
                if (!t5Var5.a()) {
                    hashSet2.add(t5Var5);
                }
            }
            a(this, k5Var, hashSet2, f() == t5.a.WRAP_CONTENT ? 0 : 1, false);
            Iterator<t5> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                t5 next = it3.next();
                y5.a(this, k5Var, next);
                next.a(k5Var, m);
            }
        } else {
            for (int i8 = 0; i8 < size; i8++) {
                t5 t5Var6 = this.u0.get(i8);
                if (t5Var6 instanceof u5) {
                    t5.a[] aVarArr = t5Var6.V;
                    t5.a aVar = aVarArr[0];
                    t5.a aVar2 = aVarArr[1];
                    if (aVar == t5.a.WRAP_CONTENT) {
                        t5Var6.a(t5.a.FIXED);
                    }
                    if (aVar2 == t5.a.WRAP_CONTENT) {
                        t5Var6.b(t5.a.FIXED);
                    }
                    t5Var6.a(k5Var, m);
                    if (aVar == t5.a.WRAP_CONTENT) {
                        t5Var6.a(aVar);
                    }
                    if (aVar2 == t5.a.WRAP_CONTENT) {
                        t5Var6.b(aVar2);
                    }
                } else {
                    y5.a(this, k5Var, t5Var6);
                    if (!t5Var6.a()) {
                        t5Var6.a(k5Var, m);
                    }
                }
            }
        }
        if (this.D0 > 0) {
            a.a(this, k5Var, (ArrayList<t5>) null, 0);
        }
        if (this.E0 > 0) {
            a.a(this, k5Var, (ArrayList<t5>) null, 1);
        }
        return true;
    }

    public void a(s5 s5Var) {
        WeakReference<s5> weakReference = this.N0;
        if (weakReference == null || weakReference.get() == null || s5Var.a() > this.N0.get().a()) {
            this.N0 = new WeakReference<>(s5Var);
        }
    }

    @Override // defpackage.t5
    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        int size = this.u0.size();
        for (int i = 0; i < size; i++) {
            this.u0.get(i).a(z, z2);
        }
    }

    public static boolean a(t5 t5Var, c6.b bVar, c6.a aVar, int i) {
        int i2;
        int i3;
        if (bVar == null) {
            return false;
        }
        if (t5Var.j0 != 8 && !(t5Var instanceof v5) && !(t5Var instanceof q5)) {
            aVar.a = t5Var.f();
            aVar.b = t5Var.h();
            aVar.c = t5Var.i();
            aVar.d = t5Var.e();
            aVar.i = false;
            aVar.j = i;
            boolean z = aVar.a == t5.a.MATCH_CONSTRAINT;
            boolean z2 = aVar.b == t5.a.MATCH_CONSTRAINT;
            boolean z3 = z && t5Var.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            boolean z4 = z2 && t5Var.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            if (z && t5Var.f(0) && t5Var.s == 0 && !z3) {
                aVar.a = t5.a.WRAP_CONTENT;
                if (z2 && t5Var.t == 0) {
                    aVar.a = t5.a.FIXED;
                }
                z = false;
            }
            if (z2 && t5Var.f(1) && t5Var.t == 0 && !z4) {
                aVar.b = t5.a.WRAP_CONTENT;
                if (z && t5Var.s == 0) {
                    aVar.b = t5.a.FIXED;
                }
                z2 = false;
            }
            if (t5Var.o()) {
                aVar.a = t5.a.FIXED;
                z = false;
            }
            if (t5Var.p()) {
                aVar.b = t5.a.FIXED;
                z2 = false;
            }
            if (z3) {
                if (t5Var.u[0] == 4) {
                    aVar.a = t5.a.FIXED;
                } else if (!z2) {
                    if (aVar.b == t5.a.FIXED) {
                        i3 = aVar.d;
                    } else {
                        aVar.a = t5.a.WRAP_CONTENT;
                        ((ConstraintLayout.b) bVar).a(t5Var, aVar);
                        i3 = aVar.f;
                    }
                    aVar.a = t5.a.FIXED;
                    aVar.c = (int) (t5Var.Z * i3);
                }
            }
            if (z4) {
                if (t5Var.u[1] == 4) {
                    aVar.b = t5.a.FIXED;
                } else if (!z) {
                    if (aVar.a == t5.a.FIXED) {
                        i2 = aVar.c;
                    } else {
                        aVar.b = t5.a.WRAP_CONTENT;
                        ((ConstraintLayout.b) bVar).a(t5Var, aVar);
                        i2 = aVar.e;
                    }
                    aVar.b = t5.a.FIXED;
                    if (t5Var.a0 == -1) {
                        aVar.d = (int) (i2 / t5Var.Z);
                    } else {
                        aVar.d = (int) (t5Var.Z * i2);
                    }
                }
            }
            ((ConstraintLayout.b) bVar).a(t5Var, aVar);
            t5Var.l(aVar.e);
            t5Var.i(aVar.f);
            t5Var.F = aVar.h;
            t5Var.h(aVar.g);
            aVar.j = c6.a.k;
            return aVar.i;
        }
        aVar.e = 0;
        aVar.f = 0;
        return false;
    }

    public void a(t5 t5Var, int i) {
        if (i == 0) {
            int i2 = this.D0 + 1;
            r5[] r5VarArr = this.G0;
            if (i2 >= r5VarArr.length) {
                this.G0 = (r5[]) Arrays.copyOf(r5VarArr, r5VarArr.length * 2);
            }
            this.G0[this.D0] = new r5(t5Var, 0, this.z0);
            this.D0++;
        } else if (i == 1) {
            int i3 = this.E0 + 1;
            r5[] r5VarArr2 = this.F0;
            if (i3 >= r5VarArr2.length) {
                this.F0 = (r5[]) Arrays.copyOf(r5VarArr2, r5VarArr2.length * 2);
            }
            this.F0[this.E0] = new r5(t5Var, 1, this.z0);
            this.E0++;
        }
    }
}
