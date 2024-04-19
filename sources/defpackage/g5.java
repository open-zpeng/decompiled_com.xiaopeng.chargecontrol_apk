package defpackage;
/* compiled from: SparseArrayCompat.java */
/* renamed from: g5  reason: default package */
/* loaded from: classes.dex */
public class g5<E> implements Cloneable {
    public static final Object g = new Object();
    public boolean c = false;
    public int[] d;
    public Object[] e;
    public int f;

    public g5() {
        int b = b5.b(10);
        this.d = new int[b];
        this.e = new Object[b];
    }

    public E a(int i) {
        return b(i, null);
    }

    public E b(int i, E e) {
        int a = b5.a(this.d, this.f, i);
        if (a >= 0) {
            Object[] objArr = this.e;
            if (objArr[a] != g) {
                return (E) objArr[a];
            }
        }
        return e;
    }

    public void c(int i, E e) {
        int a = b5.a(this.d, this.f, i);
        if (a >= 0) {
            this.e[a] = e;
            return;
        }
        int i2 = ~a;
        if (i2 < this.f) {
            Object[] objArr = this.e;
            if (objArr[i2] == g) {
                this.d[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.c && this.f >= this.d.length) {
            a();
            i2 = ~b5.a(this.d, this.f, i);
        }
        int i3 = this.f;
        if (i3 >= this.d.length) {
            int b = b5.b(i3 + 1);
            int[] iArr = new int[b];
            Object[] objArr2 = new Object[b];
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = iArr;
            this.e = objArr2;
        }
        int i4 = this.f;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.d;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f - i2);
        }
        this.d[i2] = i;
        this.e[i2] = e;
        this.f++;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.c) {
                a();
            }
            sb.append(this.d[i]);
            sb.append('=');
            E b = b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final void a() {
        int i = this.f;
        int[] iArr = this.d;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != g) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.c = false;
        this.f = i2;
    }

    /* renamed from: clone */
    public g5<E> m1clone() {
        try {
            g5<E> g5Var = (g5) super.clone();
            g5Var.d = (int[]) this.d.clone();
            g5Var.e = (Object[]) this.e.clone();
            return g5Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public int b() {
        if (this.c) {
            a();
        }
        return this.f;
    }

    public E b(int i) {
        if (this.c) {
            a();
        }
        return (E) this.e[i];
    }

    public void a(int i, E e) {
        int i2 = this.f;
        if (i2 != 0 && i <= this.d[i2 - 1]) {
            c(i, e);
            return;
        }
        if (this.c && this.f >= this.d.length) {
            a();
        }
        int i3 = this.f;
        if (i3 >= this.d.length) {
            int b = b5.b(i3 + 1);
            int[] iArr = new int[b];
            Object[] objArr = new Object[b];
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.d = iArr;
            this.e = objArr;
        }
        this.d[i3] = i;
        this.e[i3] = e;
        this.f = i3 + 1;
    }
}
