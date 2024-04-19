package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ObservableScalarXMap.java */
/* renamed from: ej0  reason: default package */
/* loaded from: classes.dex */
public final class ej0<T, R> extends ah0<R> {
    public final T c;
    public final sh0<? super T, ? extends bh0<? extends R>> d;

    public ej0(T t, sh0<? super T, ? extends bh0<? extends R>> sh0Var) {
        this.c = t;
        this.d = sh0Var;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super R> ch0Var) {
        try {
            bh0<? extends R> apply = this.d.apply((T) this.c);
            ai0.a(apply, "The mapper returned a null ObservableSource");
            bh0<? extends R> bh0Var = apply;
            if (bh0Var instanceof Callable) {
                try {
                    Object call = ((Callable) bh0Var).call();
                    if (call == null) {
                        ch0Var.onSubscribe(wh0.INSTANCE);
                        ch0Var.onComplete();
                        return;
                    }
                    dj0 dj0Var = new dj0(ch0Var, call);
                    ch0Var.onSubscribe(dj0Var);
                    dj0Var.run();
                    return;
                } catch (Throwable th) {
                    z90.c(th);
                    ch0Var.onSubscribe(wh0.INSTANCE);
                    ch0Var.onError(th);
                    return;
                }
            }
            ((ah0) bh0Var).a(ch0Var);
        } catch (Throwable th2) {
            ch0Var.onSubscribe(wh0.INSTANCE);
            ch0Var.onError(th2);
        }
    }
}
