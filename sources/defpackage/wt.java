package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.wt.a;
/* compiled from: ObjectPool.java */
/* renamed from: wt  reason: default package */
/* loaded from: classes.dex */
public class wt<T extends a> {
    public static int g;
    public int a;
    public int b;
    public Object[] c;
    public int d;
    public T e;
    public float f;

    /* compiled from: ObjectPool.java */
    /* renamed from: wt$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        public int a = -1;

        public abstract a a();
    }

    public wt(int i, T t) {
        if (i > 0) {
            this.b = i;
            this.c = new Object[this.b];
            this.d = 0;
            this.e = t;
            this.f = 1.0f;
            b();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized wt a(int i, a aVar) {
        wt wtVar;
        synchronized (wt.class) {
            wtVar = new wt(i, aVar);
            wtVar.a = g;
            g++;
        }
        return wtVar;
    }

    public final void b() {
        float f = this.f;
        int i = this.b;
        int i2 = (int) (i * f);
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > i) {
            i2 = i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.c[i3] = this.e.a();
        }
        this.d = i2 - 1;
    }

    public void a(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f = 0.0f;
        }
        this.f = f;
    }

    public synchronized T a() {
        T t;
        if (this.d == -1 && this.f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            b();
        }
        t = (T) this.c[this.d];
        t.a = -1;
        this.d--;
        return t;
    }

    public synchronized void a(T t) {
        if (t.a != -1) {
            if (t.a == this.a) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            }
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.a + ".  Object cannot belong to two different pool instances simultaneously!");
        }
        this.d++;
        if (this.d >= this.c.length) {
            int i = this.b;
            this.b = i * 2;
            Object[] objArr = new Object[this.b];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = this.c[i2];
            }
            this.c = objArr;
        }
        t.a = this.a;
        this.c[this.d] = t;
    }
}
