package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* renamed from: xj0  reason: default package */
/* loaded from: classes.dex */
public final class xj0 extends oj0 implements Callable<Void> {
    public xj0(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.d = Thread.currentThread();
        try {
            this.c.run();
            return null;
        } finally {
            lazySet(oj0.e);
            this.d = null;
        }
    }
}
