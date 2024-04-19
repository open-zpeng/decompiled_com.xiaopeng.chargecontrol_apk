package defpackage;
/* compiled from: ScheduledDirectPeriodicTask.java */
/* renamed from: wj0  reason: default package */
/* loaded from: classes.dex */
public final class wj0 extends oj0 implements Runnable {
    public wj0(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d = Thread.currentThread();
        try {
            this.c.run();
            this.d = null;
        } catch (Throwable th) {
            this.d = null;
            lazySet(oj0.e);
            z90.a(th);
        }
    }
}
