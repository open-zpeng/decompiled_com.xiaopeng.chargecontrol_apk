package defpackage;

import java.util.concurrent.Callable;
/* compiled from: Single.java */
/* renamed from: eh0  reason: default package */
/* loaded from: classes.dex */
public abstract class eh0<T> {
    public static <T> eh0<T> a(Callable<? extends T> callable) {
        ai0.a(callable, "callable is null");
        return z90.a(new jj0(callable));
    }

    public final eh0<T> b(dh0 dh0Var) {
        ai0.a(dh0Var, "scheduler is null");
        return z90.a(new lj0(this, dh0Var));
    }

    public abstract void b(fh0<? super T> fh0Var);

    public final eh0<T> a(dh0 dh0Var) {
        ai0.a(dh0Var, "scheduler is null");
        return z90.a(new kj0(this, dh0Var));
    }

    public final kh0 a(rh0<? super T> rh0Var) {
        rh0<Throwable> rh0Var2 = zh0.d;
        ai0.a(rh0Var, "onSuccess is null");
        ai0.a(rh0Var2, "onError is null");
        ki0 ki0Var = new ki0(rh0Var, rh0Var2);
        a(ki0Var);
        return ki0Var;
    }

    public final void a(fh0<? super T> fh0Var) {
        ai0.a(fh0Var, "observer is null");
        ai0.a(fh0Var, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(fh0Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            z90.c(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final yg0<T> a() {
        if (this instanceof bi0) {
            return ((bi0) this).a();
        }
        return z90.a(new pi0(this));
    }
}
