package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableScalarXMap.java */
/* renamed from: dj0  reason: default package */
/* loaded from: classes.dex */
public final class dj0<T> extends AtomicInteger implements di0<T>, Runnable {
    public final ch0<? super T> c;
    public final T d;

    public dj0(ch0<? super T> ch0Var, T t) {
        this.c = ch0Var;
        this.d = t;
    }

    @Override // defpackage.kh0
    public void a() {
        set(3);
    }

    @Override // defpackage.kh0
    public boolean b() {
        return get() == 3;
    }

    public void clear() {
        lazySet(3);
    }

    public boolean isEmpty() {
        return get() != 1;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() == 1) {
            lazySet(3);
            return this.d;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            this.c.onNext((T) this.d);
            if (get() == 2) {
                lazySet(3);
                this.c.onComplete();
            }
        }
    }

    @Override // defpackage.di0
    public int a(int i) {
        if ((i & 1) != 0) {
            lazySet(1);
            return 1;
        }
        return 0;
    }
}
