package defpackage;

import defpackage.zh0;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* renamed from: mi0  reason: default package */
/* loaded from: classes.dex */
public final class mi0<T> extends AtomicReference<kh0> implements ch0<T>, kh0, jk0 {
    public final rh0<? super T> c;
    public final rh0<? super Throwable> d;
    public final qh0 e;
    public final rh0<? super kh0> f;

    public mi0(rh0<? super T> rh0Var, rh0<? super Throwable> rh0Var2, qh0 qh0Var, rh0<? super kh0> rh0Var3) {
        this.c = rh0Var;
        this.d = rh0Var2;
        this.e = qh0Var;
        this.f = rh0Var3;
    }

    @Override // defpackage.kh0
    public void a() {
        vh0.a((AtomicReference<kh0>) this);
    }

    @Override // defpackage.kh0
    public boolean b() {
        return get() == vh0.DISPOSED;
    }

    @Override // defpackage.ch0
    public void onComplete() {
        if (b()) {
            return;
        }
        lazySet(vh0.DISPOSED);
        try {
            ((zh0.a) this.e).a();
        } catch (Throwable th) {
            z90.c(th);
            z90.a(th);
        }
    }

    @Override // defpackage.ch0
    public void onError(Throwable th) {
        if (!b()) {
            lazySet(vh0.DISPOSED);
            try {
                this.d.accept(th);
                return;
            } catch (Throwable th2) {
                z90.c(th2);
                z90.a(new mh0(th, th2));
                return;
            }
        }
        z90.a(th);
    }

    @Override // defpackage.ch0
    public void onNext(T t) {
        if (b()) {
            return;
        }
        try {
            this.c.accept(t);
        } catch (Throwable th) {
            z90.c(th);
            get().a();
            onError(th);
        }
    }

    @Override // defpackage.ch0
    public void onSubscribe(kh0 kh0Var) {
        if (vh0.b(this, kh0Var)) {
            try {
                this.f.accept(this);
            } catch (Throwable th) {
                z90.c(th);
                kh0Var.a();
                onError(th);
            }
        }
    }
}
