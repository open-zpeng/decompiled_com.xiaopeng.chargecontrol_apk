package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* JADX WARN: Incorrect class signature, class is equals to this class: Llh0<Ljava/lang/Runnable;>; */
/* compiled from: RunnableDisposable.java */
/* renamed from: lh0  reason: default package */
/* loaded from: classes.dex */
public final class lh0 extends AtomicReference implements kh0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lh0(Runnable runnable) {
        super(runnable);
        ai0.a(runnable, "value is null");
    }

    @Override // defpackage.kh0
    public final void a() {
        Object andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        ((Runnable) andSet).run();
    }

    @Override // defpackage.kh0
    public final boolean b() {
        return get() == null;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        StringBuilder a = jg.a("RunnableDisposable(disposed=");
        a.append(b());
        a.append(", ");
        a.append(get());
        a.append(")");
        return a.toString();
    }
}
