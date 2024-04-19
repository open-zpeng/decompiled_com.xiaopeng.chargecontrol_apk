package defpackage;

import defpackage.zh0;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MaybeCallbackObserver.java */
/* renamed from: oi0  reason: default package */
/* loaded from: classes.dex */
public final class oi0<T> extends AtomicReference<kh0> implements zg0<T>, kh0, jk0 {
    public final rh0<? super T> c;
    public final rh0<? super Throwable> d;
    public final qh0 e;

    public oi0(rh0<? super T> rh0Var, rh0<? super Throwable> rh0Var2, qh0 qh0Var) {
        this.c = rh0Var;
        this.d = rh0Var2;
        this.e = qh0Var;
    }

    @Override // defpackage.kh0
    public void a() {
        vh0.a((AtomicReference<kh0>) this);
    }

    @Override // defpackage.kh0
    public boolean b() {
        return vh0.a(get());
    }

    @Override // defpackage.zg0
    public void onComplete() {
        lazySet(vh0.DISPOSED);
        try {
            ((zh0.a) this.e).a();
        } catch (Throwable th) {
            z90.c(th);
            z90.a(th);
        }
    }

    @Override // defpackage.zg0
    public void onError(Throwable th) {
        lazySet(vh0.DISPOSED);
        try {
            this.d.accept(th);
        } catch (Throwable th2) {
            z90.c(th2);
            z90.a(new mh0(th, th2));
        }
    }

    @Override // defpackage.zg0
    public void onSubscribe(kh0 kh0Var) {
        vh0.b(this, kh0Var);
    }

    @Override // defpackage.zg0
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
