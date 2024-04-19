package defpackage;

import java.util.concurrent.Callable;
/* compiled from: SingleFromCallable.java */
/* renamed from: jj0  reason: default package */
/* loaded from: classes.dex */
public final class jj0<T> extends eh0<T> {
    public final Callable<? extends T> a;

    public jj0(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // defpackage.eh0
    public void b(fh0<? super T> fh0Var) {
        kh0 a = z90.a();
        fh0Var.onSubscribe(a);
        if (a.b()) {
            return;
        }
        try {
            Object obj = (T) this.a.call();
            ai0.a(obj, "The callable returned a null value");
            if (a.b()) {
                return;
            }
            fh0Var.onSuccess(obj);
        } catch (Throwable th) {
            z90.c(th);
            if (!a.b()) {
                fh0Var.onError(th);
            } else {
                z90.a(th);
            }
        }
    }
}
