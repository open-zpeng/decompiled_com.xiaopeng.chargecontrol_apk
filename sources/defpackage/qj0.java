package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: InstantPeriodicTask.java */
/* renamed from: qj0  reason: default package */
/* loaded from: classes.dex */
public final class qj0 implements Callable<Void>, kh0 {
    public static final FutureTask<Void> h = new FutureTask<>(zh0.a, null);
    public final Runnable c;
    public final ExecutorService f;
    public Thread g;
    public final AtomicReference<Future<?>> e = new AtomicReference<>();
    public final AtomicReference<Future<?>> d = new AtomicReference<>();

    public qj0(Runnable runnable, ExecutorService executorService) {
        this.c = runnable;
        this.f = executorService;
    }

    @Override // defpackage.kh0
    public void a() {
        Future<?> andSet = this.e.getAndSet(h);
        if (andSet != null && andSet != h) {
            andSet.cancel(this.g != Thread.currentThread());
        }
        Future<?> andSet2 = this.d.getAndSet(h);
        if (andSet2 == null || andSet2 == h) {
            return;
        }
        andSet2.cancel(this.g != Thread.currentThread());
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this.e.get() == h;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.g = Thread.currentThread();
        try {
            this.c.run();
            Future<?> submit = this.f.submit(this);
            while (true) {
                Future<?> future = this.d.get();
                if (future == h) {
                    submit.cancel(this.g != Thread.currentThread());
                } else if (this.d.compareAndSet(future, submit)) {
                    break;
                }
            }
            this.g = null;
        } catch (Throwable th) {
            this.g = null;
            z90.a(th);
        }
        return null;
    }

    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.e.get();
            if (future2 == h) {
                future.cancel(this.g != Thread.currentThread());
                return;
            }
        } while (!this.e.compareAndSet(future2, future));
    }
}
