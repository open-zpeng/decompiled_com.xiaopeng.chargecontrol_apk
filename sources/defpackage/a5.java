package defpackage;

import defpackage.e5;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* compiled from: ArraySet.java */
/* renamed from: a5  reason: default package */
/* loaded from: classes.dex */
public final class a5<E> implements Collection<E>, Set<E> {
    public static final int[] g = new int[0];
    public static final Object[] h = new Object[0];
    public static Object[] i;
    public static int j;
    public static Object[] k;
    public static int l;
    public int[] c;
    public Object[] d;
    public int e;
    public e5<E, E> f;

    public a5() {
        this(0);
    }

    public final int a(Object obj, int i2) {
        int i3 = this.e;
        if (i3 == 0) {
            return -1;
        }
        int a = b5.a(this.c, i3, i2);
        if (a >= 0 && !obj.equals(this.d[a])) {
            int i4 = a + 1;
            while (i4 < i3 && this.c[i4] == i2) {
                if (obj.equals(this.d[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a - 1; i5 >= 0 && this.c[i5] == i2; i5--) {
                if (obj.equals(this.d[i5])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int a;
        if (e == null) {
            a = a();
            i2 = 0;
        } else {
            int hashCode = e.hashCode();
            i2 = hashCode;
            a = a(e, hashCode);
        }
        if (a >= 0) {
            return false;
        }
        int i3 = ~a;
        int i4 = this.e;
        if (i4 >= this.c.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.c;
            Object[] objArr = this.d;
            a(i5);
            int[] iArr2 = this.c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.d, 0, objArr.length);
            }
            a(iArr, objArr, this.e);
        }
        int i6 = this.e;
        if (i3 < i6) {
            int[] iArr3 = this.c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, i3, objArr2, i7, this.e - i3);
        }
        this.c[i3] = i2;
        this.d[i3] = e;
        this.e++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.e;
        int[] iArr = this.c;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.d;
            a(size);
            int i2 = this.e;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.c, 0, i2);
                System.arraycopy(objArr, 0, this.d, 0, this.e);
            }
            a(iArr, objArr, this.e);
        }
        for (E e : collection) {
            z |= add(e);
        }
        return z;
    }

    public E b(int i2) {
        Object[] objArr = this.d;
        E e = (E) objArr[i2];
        int i3 = this.e;
        if (i3 <= 1) {
            a(this.c, objArr, i3);
            this.c = g;
            this.d = h;
            this.e = 0;
        } else {
            int[] iArr = this.c;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                int i4 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = this.c;
                Object[] objArr2 = this.d;
                a(i4);
                this.e--;
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.c, 0, i2);
                    System.arraycopy(objArr2, 0, this.d, 0, i2);
                }
                int i5 = this.e;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, this.c, i2, i5 - i2);
                    System.arraycopy(objArr2, i6, this.d, i2, this.e - i2);
                }
            } else {
                this.e--;
                int i7 = this.e;
                if (i2 < i7) {
                    int[] iArr3 = this.c;
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, iArr3, i2, i7 - i2);
                    Object[] objArr3 = this.d;
                    System.arraycopy(objArr3, i8, objArr3, i2, this.e - i2);
                }
                this.d[this.e] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.e;
        if (i2 != 0) {
            a(this.c, this.d, i2);
            this.c = g;
            this.d = h;
            this.e = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.e != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.e; i2++) {
                try {
                    if (!set.contains(this.d[i2])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.c;
        int i2 = this.e;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.e <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        if (this.f == null) {
            this.f = new z4(this);
        }
        e5<E, E> e5Var = this.f;
        if (e5Var.b == null) {
            e5Var.b = new e5.c();
        }
        return e5Var.b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            b(a);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.e - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.d[i2])) {
                b(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.e;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.e;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.d, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.d[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public a5(int i2) {
        if (i2 == 0) {
            this.c = g;
            this.d = h;
        } else {
            a(i2);
        }
        this.e = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.e) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.e));
        }
        System.arraycopy(this.d, 0, tArr, 0, this.e);
        int length = tArr.length;
        int i2 = this.e;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public final int a() {
        int i2 = this.e;
        if (i2 == 0) {
            return -1;
        }
        int a = b5.a(this.c, i2, 0);
        if (a >= 0 && this.d[a] != null) {
            int i3 = a + 1;
            while (i3 < i2 && this.c[i3] == 0) {
                if (this.d[i3] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a - 1; i4 >= 0 && this.c[i4] == 0; i4--) {
                if (this.d[i4] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (a5.class) {
                if (k != null) {
                    Object[] objArr = k;
                    this.d = objArr;
                    k = (Object[]) objArr[0];
                    this.c = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    l--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (a5.class) {
                if (i != null) {
                    Object[] objArr2 = i;
                    this.d = objArr2;
                    i = (Object[]) objArr2[0];
                    this.c = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    j--;
                    return;
                }
            }
        }
        this.c = new int[i2];
        this.d = new Object[i2];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (a5.class) {
                if (l < 10) {
                    objArr[0] = k;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    k = objArr;
                    l++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a5.class) {
                if (j < 10) {
                    objArr[0] = i;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    i = objArr;
                    j++;
                }
            }
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }
}
