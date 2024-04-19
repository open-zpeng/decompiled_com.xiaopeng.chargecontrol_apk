package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ObservableFromCallable.java */
/* renamed from: zi0  reason: default package */
/* loaded from: classes.dex */
public final class zi0<T> extends ah0<T> implements Callable<T> {
    public final Callable<? extends T> c;

    public zi0(Callable<? extends T> callable) {
        this.c = callable;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        li0 li0Var = new li0(ch0Var);
        ch0Var.onSubscribe(li0Var);
        if (li0Var.b()) {
            return;
        }
        try {
            T call = this.c.call();
            ai0.a(call, "Callable returned null");
            int i = li0Var.get();
            if ((i & 54) != 0) {
                return;
            }
            ch0<? super T> ch0Var2 = li0Var.c;
            if (i == 8) {
                li0Var.d = call;
                li0Var.lazySet(16);
                ch0Var2.onNext(null);
            } else {
                li0Var.lazySet(2);
                ch0Var2.onNext(call);
            }
            if (li0Var.get() != 4) {
                ch0Var2.onComplete();
            }
        } catch (Throwable th) {
            z90.c(th);
            if (!li0Var.b()) {
                ch0Var.onError(th);
            } else {
                z90.a(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        T call = this.c.call();
        ai0.a(call, "The callable returned a null value");
        return call;
    }
}
