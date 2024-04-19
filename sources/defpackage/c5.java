package defpackage;
/* compiled from: LongSparseArray.java */
/* renamed from: c5  reason: default package */
/* loaded from: classes.dex */
public class c5<E> implements Cloneable {
    public static final Object g = new Object();
    public boolean c = false;
    public long[] d;
    public Object[] e;
    public int f;

    public c5() {
        int c = b5.c(10);
        this.d = new long[c];
        this.e = new Object[c];
    }

    public E a(long j) {
        return a(j, null);
    }

    public final void b() {
        int i = this.f;
        long[] jArr = this.d;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != g) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.c = false;
        this.f = i2;
    }

    public String toString() {
        if (this.c) {
            b();
        }
        int i = this.f;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            if (this.c) {
                b();
            }
            sb.append(this.d[i2]);
            sb.append('=');
            if (this.c) {
                b();
            }
            Object obj = this.e[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E a(long j, E e) {
        int a = b5.a(this.d, this.f, j);
        if (a >= 0) {
            Object[] objArr = this.e;
            if (objArr[a] != g) {
                return (E) objArr[a];
            }
        }
        return e;
    }

    /* renamed from: clone */
    public c5<E> m0clone() {
        try {
            c5<E> c5Var = (c5) super.clone();
            c5Var.d = (long[]) this.d.clone();
            c5Var.e = (Object[]) this.e.clone();
            return c5Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void a() {
        int i = this.f;
        Object[] objArr = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f = 0;
        this.c = false;
    }

    public void b(long j, E e) {
        int a = b5.a(this.d, this.f, j);
        if (a >= 0) {
            this.e[a] = e;
            return;
        }
        int i = ~a;
        if (i < this.f) {
            Object[] objArr = this.e;
            if (objArr[i] == g) {
                this.d[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.c && this.f >= this.d.length) {
            b();
            i = ~b5.a(this.d, this.f, j);
        }
        int i2 = this.f;
        if (i2 >= this.d.length) {
            int c = b5.c(i2 + 1);
            long[] jArr = new long[c];
            Object[] objArr2 = new Object[c];
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = jArr;
            this.e = objArr2;
        }
        int i3 = this.f;
        if (i3 - i != 0) {
            long[] jArr3 = this.d;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i, objArr4, i4, this.f - i);
        }
        this.d[i] = j;
        this.e[i] = e;
        this.f++;
    }
}
