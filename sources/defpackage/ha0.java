package defpackage;

import java.lang.ref.WeakReference;
/* compiled from: WeakRunnable.java */
/* renamed from: ha0  reason: default package */
/* loaded from: classes.dex */
public abstract class ha0<T> implements Runnable {
    public final WeakReference<T> c;

    public ha0(T t) {
        this.c = new WeakReference<>(t);
    }

    public abstract void a(T t);

    @Override // java.lang.Runnable
    public void run() {
        T t = this.c.get();
        if (t == null) {
            return;
        }
        a(t);
    }
}
