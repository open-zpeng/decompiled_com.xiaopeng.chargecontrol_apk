package defpackage;

import defpackage.dh0;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* renamed from: ck0  reason: default package */
/* loaded from: classes.dex */
public final class ck0 extends dh0 {
    public static final ck0 b = new ck0();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: ck0$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public final Runnable c;
        public final c d;
        public final long e;

        public a(Runnable runnable, c cVar, long j) {
            this.c = runnable;
            this.d = cVar;
            this.e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.f) {
                return;
            }
            long a = this.d.a(TimeUnit.MILLISECONDS);
            long j = this.e;
            if (j > a) {
                try {
                    Thread.sleep(j - a);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    z90.a(e);
                    return;
                }
            }
            if (this.d.f) {
                return;
            }
            this.c.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: ck0$b */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {
        public final Runnable c;
        public final long d;
        public final int e;
        public volatile boolean f;

        public b(Runnable runnable, Long l, int i) {
            this.c = runnable;
            this.d = l.longValue();
            this.e = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            int i = (this.d > bVar2.d ? 1 : (this.d == bVar2.d ? 0 : -1));
            int i2 = i < 0 ? -1 : i > 0 ? 1 : 0;
            if (i2 == 0) {
                int i3 = this.e;
                int i4 = bVar2.e;
                if (i3 < i4) {
                    return -1;
                }
                return i3 > i4 ? 1 : 0;
            }
            return i2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: ck0$c */
    /* loaded from: classes.dex */
    public static final class c extends dh0.c implements kh0 {
        public final PriorityBlockingQueue<b> c = new PriorityBlockingQueue<>();
        public final AtomicInteger d = new AtomicInteger();
        public final AtomicInteger e = new AtomicInteger();
        public volatile boolean f;

        /* compiled from: TrampolineScheduler.java */
        /* renamed from: ck0$c$a */
        /* loaded from: classes.dex */
        public final class a implements Runnable {
            public final b c;

            public a(b bVar) {
                this.c = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.c;
                bVar.f = true;
                c.this.c.remove(bVar);
            }
        }

        @Override // defpackage.dh0.c
        public kh0 a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.f;
        }

        @Override // defpackage.dh0.c
        public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + a(TimeUnit.MILLISECONDS);
            return a(new a(runnable, this, millis), millis);
        }

        public kh0 a(Runnable runnable, long j) {
            if (this.f) {
                return wh0.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.e.incrementAndGet());
            this.c.add(bVar);
            if (this.d.getAndIncrement() == 0) {
                int i = 1;
                while (!this.f) {
                    b poll = this.c.poll();
                    if (poll == null) {
                        i = this.d.addAndGet(-i);
                        if (i == 0) {
                            return wh0.INSTANCE;
                        }
                    } else if (!poll.f) {
                        poll.c.run();
                    }
                }
                this.c.clear();
                return wh0.INSTANCE;
            }
            a aVar = new a(bVar);
            ai0.a(aVar, "run is null");
            return new lh0(aVar);
        }

        @Override // defpackage.kh0
        public void a() {
            this.f = true;
        }
    }

    @Override // defpackage.dh0
    public dh0.c a() {
        return new c();
    }

    @Override // defpackage.dh0
    public kh0 a(Runnable runnable) {
        z90.a(runnable).run();
        return wh0.INSTANCE;
    }

    @Override // defpackage.dh0
    public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            z90.a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            z90.a(e);
        }
        return wh0.INSTANCE;
    }
}
