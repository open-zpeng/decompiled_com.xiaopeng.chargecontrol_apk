package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: Scheduler.java */
/* renamed from: dh0  reason: default package */
/* loaded from: classes.dex */
public abstract class dh0 {
    public static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    /* renamed from: dh0$a */
    /* loaded from: classes.dex */
    public static final class a implements kh0, Runnable, lk0 {
        public final Runnable c;
        public final c d;
        public Thread e;

        public a(Runnable runnable, c cVar) {
            this.c = runnable;
            this.d = cVar;
        }

        @Override // defpackage.kh0
        public void a() {
            if (this.e == Thread.currentThread()) {
                c cVar = this.d;
                if (cVar instanceof tj0) {
                    tj0 tj0Var = (tj0) cVar;
                    if (tj0Var.d) {
                        return;
                    }
                    tj0Var.d = true;
                    tj0Var.c.shutdown();
                    return;
                }
            }
            this.d.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.d.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.e = Thread.currentThread();
            try {
                this.c.run();
            } finally {
                a();
                this.e = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: dh0$b */
    /* loaded from: classes.dex */
    public static final class b implements kh0, Runnable, lk0 {
        public final Runnable c;
        public final c d;
        public volatile boolean e;

        public b(Runnable runnable, c cVar) {
            this.c = runnable;
            this.d = cVar;
        }

        @Override // defpackage.kh0
        public void a() {
            this.e = true;
            this.d.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e) {
                return;
            }
            try {
                this.c.run();
            } catch (Throwable th) {
                z90.c(th);
                this.d.a();
                throw gk0.a(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: dh0$c */
    /* loaded from: classes.dex */
    public static abstract class c implements kh0 {

        /* compiled from: Scheduler.java */
        /* renamed from: dh0$c$a */
        /* loaded from: classes.dex */
        public final class a implements Runnable, lk0 {
            public final Runnable c;
            public final yh0 d;
            public final long e;
            public long f;
            public long g;
            public long h;

            public a(long j, Runnable runnable, long j2, yh0 yh0Var, long j3) {
                this.c = runnable;
                this.d = yh0Var;
                this.e = j3;
                this.g = j2;
                this.h = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.c.run();
                if (this.d.b()) {
                    return;
                }
                long a = c.this.a(TimeUnit.NANOSECONDS);
                long j2 = dh0.a;
                long j3 = this.g;
                if (a + j2 >= j3) {
                    long j4 = this.e;
                    if (a < j3 + j4 + j2) {
                        long j5 = this.h;
                        long j6 = this.f + 1;
                        this.f = j6;
                        j = (j6 * j4) + j5;
                        this.g = a;
                        this.d.a(c.this.a(this, j - a, TimeUnit.NANOSECONDS));
                    }
                }
                long j7 = this.e;
                j = a + j7;
                long j8 = this.f + 1;
                this.f = j8;
                this.h = j - (j7 * j8);
                this.g = a;
                this.d.a(c.this.a(this, j - a, TimeUnit.NANOSECONDS));
            }
        }

        public kh0 a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract kh0 a(Runnable runnable, long j, TimeUnit timeUnit);

        public kh0 a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            yh0 yh0Var = new yh0();
            yh0 yh0Var2 = new yh0(yh0Var);
            Runnable a2 = z90.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a3 = a(TimeUnit.NANOSECONDS);
            kh0 a4 = a(new a(timeUnit.toNanos(j) + a3, a2, a3, yh0Var2, nanos), j, timeUnit);
            if (a4 == wh0.INSTANCE) {
                return a4;
            }
            vh0.a((AtomicReference<kh0>) yh0Var, a4);
            return yh0Var2;
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public abstract c a();

    public kh0 a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(z90.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    public kh0 a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(z90.a(runnable), a2);
        kh0 a3 = a2.a(bVar, j, j2, timeUnit);
        return a3 == wh0.INSTANCE ? a3 : bVar;
    }
}
