package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.i5;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: PriorityGoalRow.java */
/* renamed from: m5  reason: default package */
/* loaded from: classes.dex */
public class m5 extends i5 {
    public int g;
    public n5[] h;
    public n5[] i;
    public int j;
    public b k;

    /* compiled from: PriorityGoalRow.java */
    /* renamed from: m5$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<n5> {
        public a(m5 m5Var) {
        }

        @Override // java.util.Comparator
        public int compare(n5 n5Var, n5 n5Var2) {
            return n5Var.e - n5Var2.e;
        }
    }

    /* compiled from: PriorityGoalRow.java */
    /* renamed from: m5$b */
    /* loaded from: classes.dex */
    public class b {
        public n5 a;

        public b(m5 m5Var) {
        }

        public final boolean a() {
            for (int i = 8; i >= 0; i--) {
                float f = this.a.k[i];
                if (f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    return false;
                }
                if (f < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder a = jg.a(str);
                    a.append(this.a.k[i]);
                    a.append(" ");
                    str = a.toString();
                }
            }
            return str + "] " + this.a;
        }

        public final boolean a(n5 n5Var) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f = n5Var.k[i];
                float f2 = this.a.k[i];
                if (f2 == f) {
                    i--;
                } else if (f2 < f) {
                    return true;
                }
            }
            return false;
        }
    }

    public m5(j5 j5Var) {
        super(j5Var);
        this.g = 128;
        int i = this.g;
        this.h = new n5[i];
        this.i = new n5[i];
        this.j = 0;
        this.k = new b(this);
    }

    @Override // defpackage.i5, defpackage.k5.a
    public n5 a(k5 k5Var, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.j; i2++) {
            n5[] n5VarArr = this.h;
            n5 n5Var = n5VarArr[i2];
            if (!zArr[n5Var.e]) {
                b bVar = this.k;
                bVar.a = n5Var;
                if (i == -1) {
                    if (!bVar.a()) {
                    }
                    i = i2;
                } else {
                    if (!bVar.a(n5VarArr[i])) {
                    }
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.h[i];
    }

    @Override // defpackage.i5, defpackage.k5.a
    public void clear() {
        this.j = 0;
        this.b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    public final void d(n5 n5Var) {
        int i;
        int i2 = this.j + 1;
        n5[] n5VarArr = this.h;
        if (i2 > n5VarArr.length) {
            this.h = (n5[]) Arrays.copyOf(n5VarArr, n5VarArr.length * 2);
            n5[] n5VarArr2 = this.h;
            this.i = (n5[]) Arrays.copyOf(n5VarArr2, n5VarArr2.length * 2);
        }
        n5[] n5VarArr3 = this.h;
        int i3 = this.j;
        n5VarArr3[i3] = n5Var;
        this.j = i3 + 1;
        int i4 = this.j;
        if (i4 > 1 && n5VarArr3[i4 - 1].e > n5Var.e) {
            int i5 = 0;
            while (true) {
                i = this.j;
                if (i5 >= i) {
                    break;
                }
                this.i[i5] = this.h[i5];
                i5++;
            }
            Arrays.sort(this.i, 0, i, new a(this));
            for (int i6 = 0; i6 < this.j; i6++) {
                this.h[i6] = this.i[i6];
            }
        }
        n5Var.c = true;
        n5Var.a(this);
    }

    public final void e(n5 n5Var) {
        int i = 0;
        while (i < this.j) {
            if (this.h[i] == n5Var) {
                while (true) {
                    int i2 = this.j;
                    if (i < i2 - 1) {
                        n5[] n5VarArr = this.h;
                        int i3 = i + 1;
                        n5VarArr[i] = n5VarArr[i3];
                        i = i3;
                    } else {
                        this.j = i2 - 1;
                        n5Var.c = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.i5, defpackage.k5.a
    public boolean isEmpty() {
        return this.j == 0;
    }

    @Override // defpackage.i5
    public String toString() {
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.j; i++) {
            this.k.a = this.h[i];
            StringBuilder a2 = jg.a(str);
            a2.append(this.k);
            a2.append(" ");
            str = a2.toString();
        }
        return str;
    }

    @Override // defpackage.i5, defpackage.k5.a
    public void a(n5 n5Var) {
        b bVar = this.k;
        bVar.a = n5Var;
        Arrays.fill(bVar.a.k, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        n5Var.k[n5Var.g] = 1.0f;
        d(n5Var);
    }

    @Override // defpackage.i5
    public void a(k5 k5Var, i5 i5Var, boolean z) {
        n5 n5Var = i5Var.a;
        if (n5Var == null) {
            return;
        }
        i5.a aVar = i5Var.e;
        int a2 = aVar.a();
        for (int i = 0; i < a2; i++) {
            n5 b2 = aVar.b(i);
            float a3 = aVar.a(i);
            b bVar = this.k;
            bVar.a = b2;
            boolean z2 = true;
            if (bVar.a.c) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = bVar.a.k;
                    fArr[i2] = (n5Var.k[i2] * a3) + fArr[i2];
                    if (Math.abs(fArr[i2]) < 1.0E-4f) {
                        bVar.a.k[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    m5.this.e(bVar.a);
                }
                z2 = false;
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f = n5Var.k[i3];
                    if (f != XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                        float f2 = f * a3;
                        if (Math.abs(f2) < 1.0E-4f) {
                            f2 = 0.0f;
                        }
                        bVar.a.k[i3] = f2;
                    } else {
                        bVar.a.k[i3] = 0.0f;
                    }
                }
            }
            if (z2) {
                d(b2);
            }
            this.b = (i5Var.b * a3) + this.b;
        }
        e(n5Var);
    }
}
