package defpackage;
/* compiled from: OpenHashSet.java */
/* renamed from: ik0  reason: default package */
/* loaded from: classes.dex */
public final class ik0<T> {
    public final float a = 0.75f;
    public int b;
    public int c;
    public int d;
    public T[] e;

    public ik0() {
        int c = z90.c(16);
        this.b = c - 1;
        this.d = (int) (0.75f * c);
        this.e = (T[]) new Object[c];
    }

    public static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a = a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                t2 = tArr[a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            T[] tArr2 = this.e;
            int length = tArr2.length;
            int i3 = length << 1;
            int i4 = i3 - 1;
            T[] tArr3 = (T[]) new Object[i3];
            int i5 = this.c;
            while (true) {
                int i6 = i5 - 1;
                if (i5 == 0) {
                    break;
                }
                do {
                    length--;
                } while (tArr2[length] == null);
                int a2 = a(tArr2[length].hashCode()) & i4;
                if (tArr3[a2] != null) {
                    do {
                        a2 = (a2 + 1) & i4;
                    } while (tArr3[a2] != null);
                }
                tArr3[a2] = tArr2[length];
                i5 = i6;
            }
            this.b = i4;
            this.d = (int) (i3 * this.a);
            this.e = tArr3;
        }
        return true;
    }

    public boolean a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a = a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < a && a <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }
}
