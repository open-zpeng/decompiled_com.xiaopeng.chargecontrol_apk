package defpackage;

import defpackage.dh0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* renamed from: tj0  reason: default package */
/* loaded from: classes.dex */
public class tj0 extends dh0.c implements kh0 {
    public final ScheduledExecutorService c;
    public volatile boolean d;

    public tj0(ThreadFactory threadFactory) {
        this.c = ak0.a(threadFactory);
    }

    @Override // defpackage.dh0.c
    public kh0 a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public kh0 b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        xj0 xj0Var = new xj0(z90.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.c.submit(xj0Var);
            } else {
                schedule = this.c.schedule(xj0Var, j, timeUnit);
            }
            xj0Var.a(schedule);
            return xj0Var;
        } catch (RejectedExecutionException e) {
            z90.a(e);
            return wh0.INSTANCE;
        }
    }

    @Override // defpackage.dh0.c
    public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.d) {
            return wh0.INSTANCE;
        }
        return a(runnable, j, timeUnit, (uh0) null);
    }

    public yj0 a(Runnable runnable, long j, TimeUnit timeUnit, uh0 uh0Var) {
        Future<?> schedule;
        yj0 yj0Var = new yj0(z90.a(runnable), uh0Var);
        if (uh0Var == null || uh0Var.c(yj0Var)) {
            try {
                if (j <= 0) {
                    schedule = this.c.submit((Callable) yj0Var);
                } else {
                    schedule = this.c.schedule((Callable) yj0Var, j, timeUnit);
                }
                yj0Var.a(schedule);
            } catch (RejectedExecutionException e) {
                if (uh0Var != null) {
                    uh0Var.b(yj0Var);
                }
                z90.a(e);
            }
            return yj0Var;
        }
        return yj0Var;
    }

    public kh0 b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a = z90.a(runnable);
        if (j2 <= 0) {
            qj0 qj0Var = new qj0(a, this.c);
            try {
                if (j <= 0) {
                    schedule = this.c.submit(qj0Var);
                } else {
                    schedule = this.c.schedule(qj0Var, j, timeUnit);
                }
                qj0Var.a(schedule);
                return qj0Var;
            } catch (RejectedExecutionException e) {
                z90.a(e);
                return wh0.INSTANCE;
            }
        }
        wj0 wj0Var = new wj0(a);
        try {
            wj0Var.a(this.c.scheduleAtFixedRate(wj0Var, j, j2, timeUnit));
            return wj0Var;
        } catch (RejectedExecutionException e2) {
            z90.a(e2);
            return wh0.INSTANCE;
        }
    }

    @Override // defpackage.kh0
    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.c.shutdownNow();
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this.d;
    }
}
