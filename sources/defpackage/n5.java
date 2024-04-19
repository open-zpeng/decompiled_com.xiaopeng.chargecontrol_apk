package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.Arrays;
/* compiled from: SolverVariable.java */
/* renamed from: n5  reason: default package */
/* loaded from: classes.dex */
public class n5 implements Comparable<n5> {
    public static int s = 1;
    public boolean c;
    public String d;
    public float h;
    public a l;
    public int e = -1;
    public int f = -1;
    public int g = 0;
    public boolean i = false;
    public float[] j = new float[9];
    public float[] k = new float[9];
    public i5[] m = new i5[16];
    public int n = 0;
    public int o = 0;
    public boolean p = false;
    public int q = -1;
    public float r = XToggleDrawable.LIGHT_RADIUS_DEFAULT;

    /* compiled from: SolverVariable.java */
    /* renamed from: n5$a */
    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public n5(a aVar) {
        this.l = aVar;
    }

    public final void a(i5 i5Var) {
        int i = 0;
        while (true) {
            int i2 = this.n;
            if (i < i2) {
                if (this.m[i] == i5Var) {
                    return;
                }
                i++;
            } else {
                i5[] i5VarArr = this.m;
                if (i2 >= i5VarArr.length) {
                    this.m = (i5[]) Arrays.copyOf(i5VarArr, i5VarArr.length * 2);
                }
                i5[] i5VarArr2 = this.m;
                int i3 = this.n;
                i5VarArr2[i3] = i5Var;
                this.n = i3 + 1;
                return;
            }
        }
    }

    public final void b(i5 i5Var) {
        int i = this.n;
        int i2 = 0;
        while (i2 < i) {
            if (this.m[i2] == i5Var) {
                while (i2 < i - 1) {
                    i5[] i5VarArr = this.m;
                    int i3 = i2 + 1;
                    i5VarArr[i2] = i5VarArr[i3];
                    i2 = i3;
                }
                this.n--;
                return;
            }
            i2++;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(n5 n5Var) {
        return this.e - n5Var.e;
    }

    public String toString() {
        if (this.d != null) {
            StringBuilder a2 = jg.a("");
            a2.append(this.d);
            return a2.toString();
        }
        StringBuilder a3 = jg.a("");
        a3.append(this.e);
        return a3.toString();
    }

    public final void a(k5 k5Var, i5 i5Var) {
        int i = this.n;
        for (int i2 = 0; i2 < i; i2++) {
            this.m[i2].a(k5Var, i5Var, false);
        }
        this.n = 0;
    }

    public void a(k5 k5Var, float f) {
        this.h = f;
        this.i = true;
        this.p = false;
        this.q = -1;
        this.r = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        int i = this.n;
        this.f = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.m[i2].a(k5Var, this, false);
        }
        this.n = 0;
    }

    public void a() {
        this.d = null;
        this.l = a.UNKNOWN;
        this.g = 0;
        this.e = -1;
        this.f = -1;
        this.h = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.i = false;
        this.p = false;
        this.q = -1;
        this.r = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        int i = this.n;
        for (int i2 = 0; i2 < i; i2++) {
            this.m[i2] = null;
        }
        this.n = 0;
        this.o = 0;
        this.c = false;
        Arrays.fill(this.k, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT);
    }
}
