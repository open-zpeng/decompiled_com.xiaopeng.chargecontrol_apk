package defpackage;
/* compiled from: Pools.java */
/* renamed from: e9  reason: default package */
/* loaded from: classes.dex */
public class e9<T> extends d9<T> {
    public final Object c;

    public e9(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.d9, defpackage.c9
    public T a() {
        T t;
        synchronized (this.c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // defpackage.d9, defpackage.c9
    public boolean a(T t) {
        boolean a;
        synchronized (this.c) {
            a = super.a(t);
        }
        return a;
    }
}
