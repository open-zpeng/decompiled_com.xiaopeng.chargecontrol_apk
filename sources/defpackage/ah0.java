package defpackage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* renamed from: ah0  reason: default package */
/* loaded from: classes.dex */
public abstract class ah0<T> implements bh0<T> {
    public static int b() {
        return xg0.a;
    }

    public static <T> ah0<T> c() {
        return z90.a(wi0.c);
    }

    public final ah0<T> a(rh0<? super T> rh0Var) {
        rh0<Object> rh0Var2 = zh0.c;
        qh0 qh0Var = zh0.b;
        ai0.a(rh0Var, "onNext is null");
        ai0.a(rh0Var2, "onError is null");
        ai0.a(qh0Var, "onComplete is null");
        ai0.a(qh0Var, "onAfterTerminate is null");
        return z90.a(new vi0(this, rh0Var, rh0Var2, qh0Var, qh0Var));
    }

    public abstract void b(ch0<? super T> ch0Var);

    public final <R> ah0<R> b(sh0<? super T, ? extends bh0<? extends R>> sh0Var) {
        int b = b();
        ai0.a(sh0Var, "mapper is null");
        ai0.a(Integer.MAX_VALUE, "maxConcurrency");
        ai0.a(b, "bufferSize");
        if (this instanceof ei0) {
            Object call = ((ei0) this).call();
            if (call == null) {
                return c();
            }
            return z90.a(call, sh0Var);
        }
        return z90.a(new yi0(this, sh0Var, false, Integer.MAX_VALUE, b));
    }

    public final ah0<T> a(dh0 dh0Var) {
        int i = xg0.a;
        ai0.a(dh0Var, "scheduler is null");
        ai0.a(i, "bufferSize");
        return z90.a(new bj0(this, dh0Var, false, i));
    }

    public final kh0 b(rh0<? super T> rh0Var) {
        rh0<Throwable> rh0Var2 = zh0.d;
        qh0 qh0Var = zh0.b;
        rh0<Object> rh0Var3 = zh0.c;
        ai0.a(rh0Var, "onNext is null");
        ai0.a(rh0Var2, "onError is null");
        ai0.a(qh0Var, "onComplete is null");
        ai0.a(rh0Var3, "onSubscribe is null");
        mi0 mi0Var = new mi0(rh0Var, rh0Var2, qh0Var, rh0Var3);
        a(mi0Var);
        return mi0Var;
    }

    public static ah0<Long> a(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        dh0 a = mk0.a();
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        } else if (i == 0) {
            return c().a(j3, timeUnit, a);
        } else {
            long j5 = (j2 - 1) + j;
            if (j > 0 && j5 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            ai0.a(timeUnit, "unit is null");
            ai0.a(a, "scheduler is null");
            return z90.a(new aj0(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, a));
        }
    }

    public static ah0<Long> a(long j, TimeUnit timeUnit) {
        dh0 a = mk0.a();
        ai0.a(timeUnit, "unit is null");
        ai0.a(a, "scheduler is null");
        return z90.a(new ij0(Math.max(j, 0L), timeUnit, a));
    }

    public final ah0<T> b(dh0 dh0Var) {
        ai0.a(dh0Var, "scheduler is null");
        return z90.a(new fj0(this, dh0Var));
    }

    public final ah0<T> b(th0<? super T> th0Var) {
        ai0.a(th0Var, "stopPredicate is null");
        return z90.a(new gj0(this, th0Var));
    }

    public final T a() {
        ji0 ji0Var = new ji0();
        a(ji0Var);
        if (ji0Var.getCount() != 0) {
            try {
                ji0Var.await();
            } catch (InterruptedException e) {
                ji0Var.a();
                throw gk0.a(e);
            }
        }
        Throwable th = ji0Var.d;
        if (th == null) {
            T t = ji0Var.c;
            if (t != null) {
                return t;
            }
            throw new NoSuchElementException();
        }
        throw gk0.a(th);
    }

    public final <R> ah0<R> a(sh0<? super T, ? extends bh0<? extends R>> sh0Var) {
        ai0.a(sh0Var, "mapper is null");
        ai0.a(2, "prefetch");
        if (this instanceof ei0) {
            Object call = ((ei0) this).call();
            if (call == null) {
                return c();
            }
            return z90.a(call, sh0Var);
        }
        return z90.a(new ti0(this, sh0Var, 2, fk0.IMMEDIATE));
    }

    public final ah0<T> a(long j, TimeUnit timeUnit, dh0 dh0Var) {
        ai0.a(timeUnit, "unit is null");
        ai0.a(dh0Var, "scheduler is null");
        return z90.a(new ui0(this, j, timeUnit, dh0Var, false));
    }

    public final ah0<T> a(th0<? super T> th0Var) {
        ai0.a(th0Var, "predicate is null");
        return z90.a(new xi0(this, th0Var));
    }

    public final void a(ch0<? super T> ch0Var) {
        ai0.a(ch0Var, "observer is null");
        try {
            ai0.a(ch0Var, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(ch0Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            z90.c(th);
            z90.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
