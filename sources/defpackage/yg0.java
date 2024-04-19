package defpackage;
/* compiled from: Maybe.java */
/* renamed from: yg0  reason: default package */
/* loaded from: classes.dex */
public abstract class yg0<T> {
    public final yg0<T> a(dh0 dh0Var) {
        ai0.a(dh0Var, "scheduler is null");
        return z90.a(new qi0(this, dh0Var));
    }

    public final yg0<T> b(dh0 dh0Var) {
        ai0.a(dh0Var, "scheduler is null");
        return z90.a(new ri0(this, dh0Var));
    }

    public abstract void b(zg0<? super T> zg0Var);

    public final kh0 a(rh0<? super T> rh0Var) {
        rh0<Throwable> rh0Var2 = zh0.d;
        qh0 qh0Var = zh0.b;
        ai0.a(rh0Var, "onSuccess is null");
        ai0.a(rh0Var2, "onError is null");
        ai0.a(qh0Var, "onComplete is null");
        oi0 oi0Var = new oi0(rh0Var, rh0Var2, qh0Var);
        a(oi0Var);
        return oi0Var;
    }

    public final void a(zg0<? super T> zg0Var) {
        ai0.a(zg0Var, "observer is null");
        ai0.a(zg0Var, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(zg0Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            z90.c(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
