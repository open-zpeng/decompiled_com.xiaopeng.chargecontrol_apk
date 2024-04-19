package defpackage;

import defpackage.dh0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* renamed from: bk0  reason: default package */
/* loaded from: classes.dex */
public final class bk0 extends dh0 {
    public static final vj0 c;
    public static final ScheduledExecutorService d = Executors.newScheduledThreadPool(0);
    public final AtomicReference<ScheduledExecutorService> b;

    static {
        d.shutdown();
        c = new vj0("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public bk0() {
        vj0 vj0Var = c;
        this.b = new AtomicReference<>();
        this.b.lazySet(ak0.a(vj0Var));
    }

    @Override // defpackage.dh0
    public dh0.c a() {
        return new a(this.b.get());
    }

    @Override // defpackage.dh0
    public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        xj0 xj0Var = new xj0(z90.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.b.get().submit(xj0Var);
            } else {
                schedule = this.b.get().schedule(xj0Var, j, timeUnit);
            }
            xj0Var.a(schedule);
            return xj0Var;
        } catch (RejectedExecutionException e) {
            z90.a(e);
            return wh0.INSTANCE;
        }
    }

    @Override // defpackage.dh0
    public kh0 a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a2 = z90.a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.b.get();
            qj0 qj0Var = new qj0(a2, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(qj0Var);
                } else {
                    schedule = scheduledExecutorService.schedule(qj0Var, j, timeUnit);
                }
                qj0Var.a(schedule);
                return qj0Var;
            } catch (RejectedExecutionException e) {
                z90.a(e);
                return wh0.INSTANCE;
            }
        }
        wj0 wj0Var = new wj0(a2);
        try {
            wj0Var.a(this.b.get().scheduleAtFixedRate(wj0Var, j, j2, timeUnit));
            return wj0Var;
        } catch (RejectedExecutionException e2) {
            z90.a(e2);
            return wh0.INSTANCE;
        }
    }

    /* compiled from: SingleScheduler.java */
    /* renamed from: bk0$a */
    /* loaded from: classes.dex */
    public static final class a extends dh0.c {
        public final ScheduledExecutorService c;
        public final jh0 d = new jh0();
        public volatile boolean e;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.c = scheduledExecutorService;
        }

        @Override // defpackage.dh0.c
        public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.e) {
                return wh0.INSTANCE;
            }
            yj0 yj0Var = new yj0(z90.a(runnable), this.d);
            this.d.c(yj0Var);
            try {
                if (j <= 0) {
                    schedule = this.c.submit((Callable) yj0Var);
                } else {
                    schedule = this.c.schedule((Callable) yj0Var, j, timeUnit);
                }
                yj0Var.a(schedule);
                return yj0Var;
            } catch (RejectedExecutionException e) {
                a();
                z90.a(e);
                return wh0.INSTANCE;
            }
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.e;
        }

        @Override // defpackage.kh0
        public void a() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.d.a();
        }
    }
}
