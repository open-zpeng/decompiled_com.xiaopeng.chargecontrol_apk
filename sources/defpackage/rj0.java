package defpackage;

import defpackage.dh0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* renamed from: rj0  reason: default package */
/* loaded from: classes.dex */
public final class rj0 extends dh0 {
    public static final vj0 d;
    public static final vj0 e;
    public static final a i;
    public final ThreadFactory b = d;
    public final AtomicReference<a> c = new AtomicReference<>(i);
    public static final TimeUnit g = TimeUnit.SECONDS;
    public static final long f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
    public static final c h = new c(new vj0("RxCachedThreadSchedulerShutdown"));

    /* compiled from: IoScheduler.java */
    /* renamed from: rj0$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public final long c;
        public final ConcurrentLinkedQueue<c> d;
        public final jh0 e;
        public final ScheduledExecutorService f;
        public final Future<?> g;
        public final ThreadFactory h;

        public a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.c = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.d = new ConcurrentLinkedQueue<>();
            this.e = new jh0();
            this.h = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, rj0.e);
                long j2 = this.c;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f = scheduledExecutorService;
            this.g = scheduledFuture;
        }

        public long a() {
            return System.nanoTime();
        }

        public void b() {
            this.e.a();
            Future<?> future = this.g;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.isEmpty()) {
                return;
            }
            long a = a();
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.e > a) {
                    return;
                }
                if (this.d.remove(next)) {
                    this.e.b(next);
                }
            }
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: rj0$c */
    /* loaded from: classes.dex */
    public static final class c extends tj0 {
        public long e;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.e = 0L;
        }
    }

    static {
        h.a();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        d = new vj0("RxCachedThreadScheduler", max);
        e = new vj0("RxCachedWorkerPoolEvictor", max);
        i = new a(0L, null, d);
        a aVar = i;
        aVar.e.a();
        Future<?> future = aVar.g;
        if (future != null) {
            future.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = aVar.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public rj0() {
        a aVar = new a(f, g, this.b);
        if (this.c.compareAndSet(i, aVar)) {
            return;
        }
        aVar.b();
    }

    @Override // defpackage.dh0
    public dh0.c a() {
        return new b(this.c.get());
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: rj0$b */
    /* loaded from: classes.dex */
    public static final class b extends dh0.c {
        public final a d;
        public final c e;
        public final AtomicBoolean f = new AtomicBoolean();
        public final jh0 c = new jh0();

        public b(a aVar) {
            c cVar;
            this.d = aVar;
            if (!aVar.e.d) {
                while (true) {
                    if (!aVar.d.isEmpty()) {
                        cVar = aVar.d.poll();
                        if (cVar != null) {
                            break;
                        }
                    } else {
                        cVar = new c(aVar.h);
                        aVar.e.c(cVar);
                        break;
                    }
                }
            } else {
                cVar = rj0.h;
            }
            this.e = cVar;
        }

        @Override // defpackage.kh0
        public void a() {
            if (this.f.compareAndSet(false, true)) {
                this.c.a();
                a aVar = this.d;
                c cVar = this.e;
                cVar.e = aVar.a() + aVar.c;
                aVar.d.offer(cVar);
            }
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.f.get();
        }

        @Override // defpackage.dh0.c
        public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.c.d) {
                return wh0.INSTANCE;
            }
            return this.e.a(runnable, j, timeUnit, this.c);
        }
    }
}
