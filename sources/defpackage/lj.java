package defpackage;

import defpackage.hj;
import defpackage.pj;
import defpackage.tq;
import defpackage.wq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: EngineJob.java */
/* renamed from: lj  reason: default package */
/* loaded from: classes.dex */
public class lj<R> implements hj.a<R>, tq.d {
    public static final c A = new c();
    public final e c;
    public final wq d;
    public final pj.a e;
    public final c9<lj<?>> f;
    public final c g;
    public final mj h;
    public final zk i;
    public final zk j;
    public final zk k;
    public final zk l;
    public final AtomicInteger m;
    public zh n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public vj<?> s;
    public uh t;
    public boolean u;
    public qj v;
    public boolean w;
    public pj<?> x;
    public hj<R> y;
    public volatile boolean z;

    /* compiled from: EngineJob.java */
    /* renamed from: lj$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final rp c;

        public a(rp rpVar) {
            this.c = rpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sp spVar = (sp) this.c;
            spVar.b.a();
            synchronized (spVar.c) {
                synchronized (lj.this) {
                    if (lj.this.c.a(this.c)) {
                        lj.this.a(this.c);
                    }
                    lj.this.a();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: lj$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final rp c;

        public b(rp rpVar) {
            this.c = rpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sp spVar = (sp) this.c;
            spVar.b.a();
            synchronized (spVar.c) {
                synchronized (lj.this) {
                    if (lj.this.c.a(this.c)) {
                        lj.this.x.e();
                        lj.this.b(this.c);
                        lj.this.c(this.c);
                    }
                    lj.this.a();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: lj$c */
    /* loaded from: classes.dex */
    public static class c {
        public <R> pj<R> a(vj<R> vjVar, boolean z, zh zhVar, pj.a aVar) {
            return new pj<>(vjVar, z, true, zhVar, aVar);
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: lj$d */
    /* loaded from: classes.dex */
    public static final class d {
        public final rp a;
        public final Executor b;

        public d(rp rpVar, Executor executor) {
            this.a = rpVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: lj$e */
    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {
        public final List<d> c;

        public e(List<d> list) {
            this.c = list;
        }

        public static d b(rp rpVar) {
            return new d(rpVar, nq.b);
        }

        public boolean a(rp rpVar) {
            return this.c.contains(b(rpVar));
        }

        public boolean isEmpty() {
            return this.c.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.c.iterator();
        }

        public e a() {
            return new e(new ArrayList(this.c));
        }
    }

    public lj(zk zkVar, zk zkVar2, zk zkVar3, zk zkVar4, mj mjVar, pj.a aVar, c9<lj<?>> c9Var) {
        c cVar = A;
        this.c = new e(new ArrayList(2));
        this.d = new wq.b();
        this.m = new AtomicInteger();
        this.i = zkVar;
        this.j = zkVar2;
        this.k = zkVar3;
        this.l = zkVar4;
        this.h = mjVar;
        this.e = aVar;
        this.f = c9Var;
        this.g = cVar;
    }

    public synchronized lj<R> a(zh zhVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.n = zhVar;
        this.o = z;
        this.p = z2;
        this.q = z3;
        this.r = z4;
        return this;
    }

    public void b(rp rpVar) {
        try {
            ((sp) rpVar).a(this.x, this.t);
        } catch (Throwable th) {
            throw new bj(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r2.m.get() != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c(defpackage.rp r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            wq r0 = r2.d     // Catch: java.lang.Throwable -> L50
            r0.a()     // Catch: java.lang.Throwable -> L50
            lj$e r0 = r2.c     // Catch: java.lang.Throwable -> L50
            java.util.List<lj$d> r0 = r0.c     // Catch: java.lang.Throwable -> L50
            lj$d r3 = defpackage.lj.e.b(r3)     // Catch: java.lang.Throwable -> L50
            r0.remove(r3)     // Catch: java.lang.Throwable -> L50
            lj$e r3 = r2.c     // Catch: java.lang.Throwable -> L50
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L4e
            boolean r3 = r2.c()     // Catch: java.lang.Throwable -> L50
            r0 = 1
            if (r3 == 0) goto L21
            goto L37
        L21:
            r2.z = r0     // Catch: java.lang.Throwable -> L50
            hj<R> r3 = r2.y     // Catch: java.lang.Throwable -> L50
            r3.G = r0     // Catch: java.lang.Throwable -> L50
            fj r3 = r3.E     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L2e
            r3.cancel()     // Catch: java.lang.Throwable -> L50
        L2e:
            mj r3 = r2.h     // Catch: java.lang.Throwable -> L50
            zh r1 = r2.n     // Catch: java.lang.Throwable -> L50
            kj r3 = (defpackage.kj) r3     // Catch: java.lang.Throwable -> L50
            r3.a(r2, r1)     // Catch: java.lang.Throwable -> L50
        L37:
            boolean r3 = r2.u     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L41
            boolean r3 = r2.w     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L40
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 == 0) goto L4e
            java.util.concurrent.atomic.AtomicInteger r3 = r2.m     // Catch: java.lang.Throwable -> L50
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L4e
            r2.g()     // Catch: java.lang.Throwable -> L50
        L4e:
            monitor-exit(r2)
            return
        L50:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj.c(rp):void");
    }

    public void d() {
        synchronized (this) {
            this.d.a();
            if (this.z) {
                g();
            } else if (!this.c.isEmpty()) {
                if (!this.w) {
                    this.w = true;
                    zh zhVar = this.n;
                    e a2 = this.c.a();
                    a(a2.c.size() + 1);
                    ((kj) this.h).a((lj<?>) this, zhVar, (pj<?>) null);
                    Iterator<d> it = a2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.b.execute(new a(next.a));
                    }
                    a();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    @Override // defpackage.tq.d
    public wq e() {
        return this.d;
    }

    public void f() {
        synchronized (this) {
            this.d.a();
            if (this.z) {
                this.s.d();
                g();
            } else if (!this.c.isEmpty()) {
                if (!this.u) {
                    this.x = this.g.a(this.s, this.o, this.n, this.e);
                    this.u = true;
                    e a2 = this.c.a();
                    a(a2.c.size() + 1);
                    ((kj) this.h).a((lj<?>) this, this.n, this.x);
                    Iterator<d> it = a2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.b.execute(new b(next.a));
                    }
                    a();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    public final synchronized void g() {
        if (this.n != null) {
            this.c.c.clear();
            this.n = null;
            this.x = null;
            this.s = null;
            this.w = false;
            this.z = false;
            this.u = false;
            hj<R> hjVar = this.y;
            if (hjVar.i.b(false)) {
                hjVar.g();
            }
            this.y = null;
            this.v = null;
            this.t = null;
            this.f.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final zk b() {
        if (this.p) {
            return this.k;
        }
        return this.q ? this.l : this.j;
    }

    public synchronized void a(hj<R> hjVar) {
        zk zkVar;
        this.y = hjVar;
        if (hjVar.k()) {
            zkVar = this.i;
        } else if (this.p) {
            zkVar = this.k;
        } else {
            zkVar = this.q ? this.l : this.j;
        }
        zkVar.a.execute(hjVar);
    }

    public synchronized void a(rp rpVar, Executor executor) {
        this.d.a();
        this.c.c.add(new d(rpVar, executor));
        boolean z = true;
        if (this.u) {
            a(1);
            executor.execute(new b(rpVar));
        } else if (this.w) {
            a(1);
            executor.execute(new a(rpVar));
        } else {
            if (this.z) {
                z = false;
            }
            defpackage.a.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public final boolean c() {
        return this.w || this.u || this.z;
    }

    public void a(rp rpVar) {
        try {
            ((sp) rpVar).a(this.v, 5);
        } catch (Throwable th) {
            throw new bj(th);
        }
    }

    public synchronized void a(int i) {
        defpackage.a.a(c(), "Not yet complete!");
        if (this.m.getAndAdd(i) == 0 && this.x != null) {
            this.x.e();
        }
    }

    public void a() {
        pj<?> pjVar;
        synchronized (this) {
            this.d.a();
            defpackage.a.a(c(), "Not yet complete!");
            int decrementAndGet = this.m.decrementAndGet();
            defpackage.a.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                pjVar = this.x;
                g();
            } else {
                pjVar = null;
            }
        }
        if (pjVar != null) {
            pjVar.f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(vj<R> vjVar, uh uhVar) {
        synchronized (this) {
            this.s = vjVar;
            this.t = uhVar;
        }
        f();
    }

    public void a(qj qjVar) {
        synchronized (this) {
            this.v = qjVar;
        }
        d();
    }
}
