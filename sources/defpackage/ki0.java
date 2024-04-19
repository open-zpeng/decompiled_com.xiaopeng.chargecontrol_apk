package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ConsumerSingleObserver.java */
/* renamed from: ki0  reason: default package */
/* loaded from: classes.dex */
public final class ki0<T> extends AtomicReference<kh0> implements fh0<T>, kh0, jk0 {
    public final rh0<? super T> c;
    public final rh0<? super Throwable> d;

    public ki0(rh0<? super T> rh0Var, rh0<? super Throwable> rh0Var2) {
        this.c = rh0Var;
        this.d = rh0Var2;
    }

    @Override // defpackage.kh0
    public void a() {
        vh0.a((AtomicReference<kh0>) this);
    }

    @Override // defpackage.kh0
    public boolean b() {
        return get() == vh0.DISPOSED;
    }

    @Override // defpackage.fh0
    public void onError(Throwable th) {
        lazySet(vh0.DISPOSED);
        try {
            this.d.accept(th);
        } catch (Throwable th2) {
            z90.c(th2);
            z90.a(new mh0(th, th2));
        }
    }

    @Override // defpackage.fh0
    public void onSubscribe(kh0 kh0Var) {
        vh0.b(this, kh0Var);
    }

    @Override // defpackage.fh0
    public void onSuccess(T t) {
        lazySet(vh0.DISPOSED);
        try {
            this.c.accept(t);
        } catch (Throwable th) {
            z90.c(th);
            z90.a(th);
        }
    }
}
