package defpackage;

import defpackage.dh0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* renamed from: pj0  reason: default package */
/* loaded from: classes.dex */
public final class pj0 extends dh0 implements zj0 {
    public static final b d;
    public static final vj0 e;
    public static final int f;
    public static final c g;
    public final ThreadFactory b = e;
    public final AtomicReference<b> c = new AtomicReference<>(d);

    /* compiled from: ComputationScheduler.java */
    /* renamed from: pj0$b */
    /* loaded from: classes.dex */
    public static final class b implements zj0 {
        public final int a;
        public final c[] b;
        public long c;

        public b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return pj0.g;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.a();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: pj0$c */
    /* loaded from: classes.dex */
    public static final class c extends tj0 {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        f = availableProcessors;
        g = new c(new vj0("RxComputationShutdown"));
        g.a();
        e = new vj0("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        d = new b(0, e);
        for (c cVar : d.b) {
            cVar.a();
        }
    }

    public pj0() {
        b bVar = new b(f, this.b);
        if (this.c.compareAndSet(d, bVar)) {
            return;
        }
        bVar.b();
    }

    @Override // defpackage.dh0
    public dh0.c a() {
        return new a(this.c.get().a());
    }

    @Override // defpackage.dh0
    public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.c.get().a().b(runnable, j, timeUnit);
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: pj0$a */
    /* loaded from: classes.dex */
    public static final class a extends dh0.c {
        public final xh0 c = new xh0();
        public final jh0 d = new jh0();
        public final xh0 e = new xh0();
        public final c f;
        public volatile boolean g;

        public a(c cVar) {
            this.f = cVar;
            this.e.c(this.c);
            this.e.c(this.d);
        }

        @Override // defpackage.kh0
        public void a() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.e.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.g;
        }

        @Override // defpackage.dh0.c
        public kh0 a(Runnable runnable) {
            if (this.g) {
                return wh0.INSTANCE;
            }
            return this.f.a(runnable, 0L, TimeUnit.MILLISECONDS, this.c);
        }

        @Override // defpackage.dh0.c
        public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.g) {
                return wh0.INSTANCE;
            }
            return this.f.a(runnable, j, timeUnit, this.d);
        }
    }

    @Override // defpackage.dh0
    public kh0 a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.c.get().a().b(runnable, j, j2, timeUnit);
    }
}
