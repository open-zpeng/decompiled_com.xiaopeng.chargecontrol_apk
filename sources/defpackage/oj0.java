package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* renamed from: oj0  reason: default package */
/* loaded from: classes.dex */
public abstract class oj0 extends AtomicReference<Future<?>> implements kh0, lk0 {
    public static final FutureTask<Void> e = new FutureTask<>(zh0.a, null);
    public static final FutureTask<Void> f = new FutureTask<>(zh0.a, null);
    public final Runnable c;
    public Thread d;

    public oj0(Runnable runnable) {
        this.c = runnable;
    }

    @Override // defpackage.kh0
    public final void a() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == e || future == (futureTask = f) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.d != Thread.currentThread());
    }

    @Override // defpackage.kh0
    public final boolean b() {
        Future<?> future = get();
        return future == e || future == f;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == e) {
                return;
            }
            if (future2 == f) {
                future.cancel(this.d != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
