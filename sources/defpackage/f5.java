package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* compiled from: SimpleArrayMap.java */
/* renamed from: f5  reason: default package */
/* loaded from: classes.dex */
public class f5<K, V> {
    public static Object[] f;
    public static int g;
    public static Object[] h;
    public static int i;
    public int[] c = b5.a;
    public Object[] d = b5.c;
    public int e = 0;

    public int a(Object obj, int i2) {
        int i3 = this.e;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a = b5.a(this.c, i3, i2);
            if (a >= 0 && !obj.equals(this.d[a << 1])) {
                int i4 = a + 1;
                while (i4 < i3 && this.c[i4] == i2) {
                    if (obj.equals(this.d[i4 << 1])) {
                        return i4;
                    }
                    i4++;
                }
                for (int i5 = a - 1; i5 >= 0 && this.c[i5] == i2; i5--) {
                    if (obj.equals(this.d[i5 << 1])) {
                        return i5;
                    }
                }
                return ~i4;
            }
            return a;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void b(int i2) {
        int i3 = this.e;
        int[] iArr = this.c;
        if (iArr.length < i2) {
            Object[] objArr = this.d;
            a(i2);
            if (this.e > 0) {
                System.arraycopy(iArr, 0, this.c, 0, i3);
                System.arraycopy(objArr, 0, this.d, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.e != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public K c(int i2) {
        return (K) this.d[i2 << 1];
    }

    public void clear() {
        int i2 = this.e;
        if (i2 > 0) {
            int[] iArr = this.c;
            Object[] objArr = this.d;
            this.c = b5.a;
            this.d = b5.c;
            this.e = 0;
            a(iArr, objArr, i2);
        }
        if (this.e > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i2) {
        int i3;
        Object[] objArr = this.d;
        int i4 = i2 << 1;
        V v = (V) objArr[i4 + 1];
        int i5 = this.e;
        if (i5 <= 1) {
            a(this.c, objArr, i5);
            this.c = b5.a;
            this.d = b5.c;
            i3 = 0;
        } else {
            i3 = i5 - 1;
            int[] iArr = this.c;
            if (iArr.length > 8 && i5 < iArr.length / 3) {
                int i6 = i5 > 8 ? i5 + (i5 >> 1) : 8;
                int[] iArr2 = this.c;
                Object[] objArr2 = this.d;
                a(i6);
                if (i5 != this.e) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.c, 0, i2);
                    System.arraycopy(objArr2, 0, this.d, 0, i4);
                }
                if (i2 < i3) {
                    int i7 = i2 + 1;
                    int i8 = i3 - i2;
                    System.arraycopy(iArr2, i7, this.c, i2, i8);
                    System.arraycopy(objArr2, i7 << 1, this.d, i4, i8 << 1);
                }
            } else {
                if (i2 < i3) {
                    int[] iArr3 = this.c;
                    int i9 = i2 + 1;
                    int i10 = i3 - i2;
                    System.arraycopy(iArr3, i9, iArr3, i2, i10);
                    Object[] objArr3 = this.d;
                    System.arraycopy(objArr3, i9 << 1, objArr3, i4, i10 << 1);
                }
                Object[] objArr4 = this.d;
                int i11 = i3 << 1;
                objArr4[i11] = null;
                objArr4[i11 + 1] = null;
            }
        }
        if (i5 == this.e) {
            this.e = i3;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V e(int i2) {
        return (V) this.d[(i2 << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f5) {
            f5 f5Var = (f5) obj;
            if (this.e != f5Var.e) {
                return false;
            }
            for (int i2 = 0; i2 < this.e; i2++) {
                try {
                    K c = c(i2);
                    V e = e(i2);
                    Object obj2 = f5Var.get(c);
                    if (e == null) {
                        if (obj2 != null || !f5Var.containsKey(c)) {
                            return false;
                        }
                    } else if (!e.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.e != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.e; i3++) {
                try {
                    K c2 = c(i3);
                    V e2 = e(i3);
                    Object obj3 = map.get(c2);
                    if (e2 == null) {
                        if (obj3 != null || !map.containsKey(c2)) {
                            return false;
                        }
                    } else if (!e2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int a = a(obj);
        return a >= 0 ? (V) this.d[(a << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = this.e;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public boolean isEmpty() {
        return this.e <= 0;
    }

    public V put(K k, V v) {
        int i2;
        int a;
        int i3 = this.e;
        if (k == null) {
            a = a();
            i2 = 0;
        } else {
            int hashCode = k.hashCode();
            i2 = hashCode;
            a = a(k, hashCode);
        }
        if (a >= 0) {
            int i4 = (a << 1) + 1;
            Object[] objArr = this.d;
            V v2 = (V) objArr[i4];
            objArr[i4] = v;
            return v2;
        }
        int i5 = ~a;
        if (i3 >= this.c.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.c;
            Object[] objArr2 = this.d;
            a(i6);
            if (i3 == this.e) {
                int[] iArr2 = this.c;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.d, 0, objArr2.length);
                }
                a(iArr, objArr2, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.c;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.e - i5) << 1);
        }
        int i8 = this.e;
        if (i3 == i8) {
            int[] iArr4 = this.c;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.d;
                int i9 = i5 << 1;
                objArr4[i9] = k;
                objArr4[i9 + 1] = v;
                this.e = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V orDefault = getOrDefault(k, null);
        return orDefault == null ? put(k, v) : orDefault;
    }

    public V remove(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            return d(a);
        }
        return null;
    }

    public V replace(K k, V v) {
        int a = a(k);
        if (a >= 0) {
            return a(a, (int) v);
        }
        return null;
    }

    public int size() {
        return this.e;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K c = c(i2);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V e = e(i2);
            if (e != this) {
                sb.append(e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int a = a(obj);
        if (a >= 0) {
            V e = e(a);
            if (obj2 == e || (obj2 != null && obj2.equals(e))) {
                d(a);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean replace(K k, V v, V v2) {
        int a = a(k);
        if (a >= 0) {
            V e = e(a);
            if (e == v || (v != null && v.equals(e))) {
                a(a, (int) v2);
                return true;
            }
            return false;
        }
        return false;
    }

    public int a() {
        int i2 = this.e;
        if (i2 == 0) {
            return -1;
        }
        try {
            int a = b5.a(this.c, i2, 0);
            if (a >= 0 && this.d[a << 1] != null) {
                int i3 = a + 1;
                while (i3 < i2 && this.c[i3] == 0) {
                    if (this.d[i3 << 1] == null) {
                        return i3;
                    }
                    i3++;
                }
                for (int i4 = a - 1; i4 >= 0 && this.c[i4] == 0; i4--) {
                    if (this.d[i4 << 1] == null) {
                        return i4;
                    }
                }
                return ~i3;
            }
            return a;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int b(Object obj) {
        int i2 = this.e * 2;
        Object[] objArr = this.d;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (f5.class) {
                if (h != null) {
                    Object[] objArr = h;
                    this.d = objArr;
                    h = (Object[]) objArr[0];
                    this.c = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    i--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (f5.class) {
                if (f != null) {
                    Object[] objArr2 = f;
                    this.d = objArr2;
                    f = (Object[]) objArr2[0];
                    this.c = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    g--;
                    return;
                }
            }
        }
        this.c = new int[i2];
        this.d = new Object[i2 << 1];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (f5.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (f5.class) {
                if (g < 10) {
                    objArr[0] = f;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f = objArr;
                    g++;
                }
            }
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.d;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public void a(f5<? extends K, ? extends V> f5Var) {
        int i2 = f5Var.e;
        b(this.e + i2);
        if (this.e != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(f5Var.c(i3), f5Var.e(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(f5Var.c, 0, this.c, 0, i2);
            System.arraycopy(f5Var.d, 0, this.d, 0, i2 << 1);
            this.e = i2;
        }
    }
}
