package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.t5;
import java.util.ArrayList;
/* compiled from: BasicMeasure.java */
/* renamed from: c6  reason: default package */
/* loaded from: classes.dex */
public class c6 {
    public final ArrayList<t5> a = new ArrayList<>();
    public a b = new a();
    public u5 c;

    /* compiled from: BasicMeasure.java */
    /* renamed from: c6$a */
    /* loaded from: classes.dex */
    public static class a {
        public static int k;
        public t5.a a;
        public t5.a b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: c6$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public c6(u5 u5Var) {
        this.c = u5Var;
    }

    public void a(u5 u5Var) {
        this.a.clear();
        int size = u5Var.u0.size();
        for (int i = 0; i < size; i++) {
            t5 t5Var = u5Var.u0.get(i);
            if (t5Var.f() == t5.a.MATCH_CONSTRAINT || t5Var.h() == t5.a.MATCH_CONSTRAINT) {
                this.a.add(t5Var);
            }
        }
        u5Var.t();
    }

    /* JADX WARN: Removed duplicated region for block: B:234:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x03f8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(defpackage.u5 r21, int r22, int r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 1498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c6.a(u5, int, int, int, int, int):long");
    }

    public final boolean a(b bVar, t5 t5Var, int i) {
        this.b.a = t5Var.f();
        this.b.b = t5Var.h();
        this.b.c = t5Var.i();
        this.b.d = t5Var.e();
        a aVar = this.b;
        aVar.i = false;
        aVar.j = i;
        boolean z = aVar.a == t5.a.MATCH_CONSTRAINT;
        boolean z2 = this.b.b == t5.a.MATCH_CONSTRAINT;
        boolean z3 = z && t5Var.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        boolean z4 = z2 && t5Var.Z > XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        if (z3 && t5Var.u[0] == 4) {
            this.b.a = t5.a.FIXED;
        }
        if (z4 && t5Var.u[1] == 4) {
            this.b.b = t5.a.FIXED;
        }
        ((ConstraintLayout.b) bVar).a(t5Var, this.b);
        t5Var.l(this.b.e);
        t5Var.i(this.b.f);
        a aVar2 = this.b;
        t5Var.F = aVar2.h;
        t5Var.h(aVar2.g);
        a aVar3 = this.b;
        aVar3.j = a.k;
        return aVar3.i;
    }

    public final void a(u5 u5Var, int i, int i2, int i3) {
        int i4 = u5Var.e0;
        int i5 = u5Var.f0;
        u5Var.k(0);
        u5Var.j(0);
        u5Var.X = i2;
        int i6 = u5Var.X;
        int i7 = u5Var.e0;
        if (i6 < i7) {
            u5Var.X = i7;
        }
        u5Var.Y = i3;
        int i8 = u5Var.Y;
        int i9 = u5Var.f0;
        if (i8 < i9) {
            u5Var.Y = i9;
        }
        u5Var.k(i4);
        u5Var.j(i5);
        u5 u5Var2 = this.c;
        u5Var2.x0 = i;
        u5Var2.s();
    }
}
