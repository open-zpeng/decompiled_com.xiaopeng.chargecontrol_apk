package defpackage;
/* compiled from: Pools.java */
/* renamed from: d9  reason: default package */
/* loaded from: classes.dex */
public class d9<T> implements c9<T> {
    public final Object[] a;
    public int b;

    public d9(int i) {
        if (i > 0) {
            this.a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // defpackage.c9
    public T a() {
        int i = this.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            return t;
        }
        return null;
    }

    @Override // defpackage.c9
    public boolean a(T t) {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.b) {
                z = false;
                break;
            } else if (this.a[i] == t) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            int i2 = this.b;
            Object[] objArr = this.a;
            if (i2 < objArr.length) {
                objArr[i2] = t;
                this.b = i2 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
