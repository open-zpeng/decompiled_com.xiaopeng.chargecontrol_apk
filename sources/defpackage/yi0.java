package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableFlatMap.java */
/* renamed from: yi0  reason: default package */
/* loaded from: classes.dex */
public final class yi0<T, U> extends si0<T, U> {
    public final sh0<? super T, ? extends bh0<? extends U>> d;
    public final boolean e;
    public final int f;
    public final int g;

    /* compiled from: ObservableFlatMap.java */
    /* renamed from: yi0$a */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<kh0> implements ch0<U> {
        public final long c;
        public final b<T, U> d;
        public volatile boolean e;
        public volatile gi0<U> f;
        public int g;

        public a(b<T, U> bVar, long j) {
            this.c = j;
            this.d = bVar;
        }

        public void a() {
            vh0.a(this);
        }

        @Override // defpackage.ch0
        public void onComplete() {
            this.e = true;
            this.d.e();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.d.j.a(th)) {
                b<T, U> bVar = this.d;
                if (!bVar.e) {
                    bVar.d();
                }
                this.e = true;
                this.d.e();
                return;
            }
            z90.a(th);
        }

        @Override // defpackage.ch0
        public void onNext(U u) {
            if (this.g == 0) {
                b<T, U> bVar = this.d;
                if (bVar.get() == 0 && bVar.compareAndSet(0, 1)) {
                    bVar.c.onNext(u);
                    if (bVar.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    gi0 gi0Var = this.f;
                    if (gi0Var == null) {
                        gi0Var = new nj0(bVar.g);
                        this.f = gi0Var;
                    }
                    gi0Var.offer(u);
                    if (bVar.getAndIncrement() != 0) {
                        return;
                    }
                }
                bVar.f();
                return;
            }
            this.d.e();
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.b(this, kh0Var) && (kh0Var instanceof di0)) {
                di0 di0Var = (di0) kh0Var;
                int a = di0Var.a(7);
                if (a == 1) {
                    this.g = a;
                    this.f = di0Var;
                    this.e = true;
                    this.d.e();
                } else if (a == 2) {
                    this.g = a;
                    this.f = di0Var;
                }
            }
        }
    }

    public yi0(bh0<T> bh0Var, sh0<? super T, ? extends bh0<? extends U>> sh0Var, boolean z, int i, int i2) {
        super(bh0Var);
        this.d = sh0Var;
        this.e = z;
        this.f = i;
        this.g = i2;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super U> ch0Var) {
        if (z90.a(this.c, ch0Var, this.d)) {
            return;
        }
        ((ah0) this.c).a(new b(ch0Var, this.d, this.e, this.f, this.g));
    }

    /* compiled from: ObservableFlatMap.java */
    /* renamed from: yi0$b */
    /* loaded from: classes.dex */
    public static final class b<T, U> extends AtomicInteger implements kh0, ch0<T> {
        public static final a<?, ?>[] s = new a[0];
        public static final a<?, ?>[] t = new a[0];
        public final ch0<? super U> c;
        public final sh0<? super T, ? extends bh0<? extends U>> d;
        public final boolean e;
        public final int f;
        public final int g;
        public volatile fi0<U> h;
        public volatile boolean i;
        public final ek0 j = new ek0();
        public volatile boolean k;
        public final AtomicReference<a<?, ?>[]> l;
        public kh0 m;
        public long n;
        public long o;
        public int p;
        public Queue<bh0<? extends U>> q;
        public int r;

        public b(ch0<? super U> ch0Var, sh0<? super T, ? extends bh0<? extends U>> sh0Var, boolean z, int i, int i2) {
            this.c = ch0Var;
            this.d = sh0Var;
            this.e = z;
            this.f = i;
            this.g = i2;
            if (i != Integer.MAX_VALUE) {
                this.q = new ArrayDeque(i);
            }
            this.l = new AtomicReference<>(s);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (decrementAndGet() == 0) goto L49;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v8, types: [gi0] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(defpackage.bh0<? extends U> r8) {
            /*
                r7 = this;
            L0:
                boolean r0 = r8 instanceof java.util.concurrent.Callable
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L8d
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                r0 = 2147483647(0x7fffffff, float:NaN)
                java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L5f
                if (r8 != 0) goto L12
            L11:
                goto L6b
            L12:
                int r3 = r7.get()
                if (r3 != 0) goto L2a
                boolean r3 = r7.compareAndSet(r1, r2)
                if (r3 == 0) goto L2a
                ch0<? super U> r3 = r7.c
                r3.onNext(r8)
                int r8 = r7.decrementAndGet()
                if (r8 != 0) goto L5b
                goto L11
            L2a:
                fi0<U> r3 = r7.h
                if (r3 != 0) goto L42
                int r3 = r7.f
                if (r3 != r0) goto L3a
                nj0 r3 = new nj0
                int r4 = r7.g
                r3.<init>(r4)
                goto L40
            L3a:
                mj0 r4 = new mj0
                r4.<init>(r3)
                r3 = r4
            L40:
                r7.h = r3
            L42:
                boolean r8 = r3.offer(r8)
                if (r8 != 0) goto L53
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r3 = "Scalar queue full?!"
                r8.<init>(r3)
                r7.onError(r8)
                goto L6b
            L53:
                int r8 = r7.getAndIncrement()
                if (r8 == 0) goto L5b
                r8 = r1
                goto L6c
            L5b:
                r7.f()
                goto L6b
            L5f:
                r8 = move-exception
                defpackage.z90.c(r8)
                ek0 r3 = r7.j
                r3.a(r8)
                r7.e()
            L6b:
                r8 = r2
            L6c:
                if (r8 == 0) goto Lc3
                int r8 = r7.f
                if (r8 == r0) goto Lc3
                monitor-enter(r7)
                java.util.Queue<bh0<? extends U>> r8 = r7.q     // Catch: java.lang.Throwable -> L8a
                java.lang.Object r8 = r8.poll()     // Catch: java.lang.Throwable -> L8a
                bh0 r8 = (defpackage.bh0) r8     // Catch: java.lang.Throwable -> L8a
                if (r8 != 0) goto L83
                int r0 = r7.r     // Catch: java.lang.Throwable -> L8a
                int r0 = r0 - r2
                r7.r = r0     // Catch: java.lang.Throwable -> L8a
                r1 = r2
            L83:
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L8a
                if (r1 == 0) goto L0
                r7.e()
                goto Lc3
            L8a:
                r8 = move-exception
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L8a
                throw r8
            L8d:
                yi0$a r0 = new yi0$a
                long r3 = r7.n
                r5 = 1
                long r5 = r5 + r3
                r7.n = r5
                r0.<init>(r7, r3)
            L99:
                java.util.concurrent.atomic.AtomicReference<yi0$a<?, ?>[]> r3 = r7.l
                java.lang.Object r3 = r3.get()
                yi0$a[] r3 = (defpackage.yi0.a[]) r3
                yi0$a<?, ?>[] r4 = defpackage.yi0.b.t
                if (r3 != r4) goto La9
                r0.a()
                goto Lbc
            La9:
                int r4 = r3.length
                int r5 = r4 + 1
                yi0$a[] r5 = new defpackage.yi0.a[r5]
                java.lang.System.arraycopy(r3, r1, r5, r1, r4)
                r5[r4] = r0
                java.util.concurrent.atomic.AtomicReference<yi0$a<?, ?>[]> r4 = r7.l
                boolean r3 = r4.compareAndSet(r3, r5)
                if (r3 == 0) goto L99
                r1 = r2
            Lbc:
                if (r1 == 0) goto Lc3
                ah0 r8 = (defpackage.ah0) r8
                r8.a(r0)
            Lc3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.yi0.b.a(bh0):void");
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.k;
        }

        public boolean c() {
            if (this.k) {
                return true;
            }
            Throwable th = this.j.get();
            if (this.e || th == null) {
                return false;
            }
            d();
            Throwable a = this.j.a();
            if (a != gk0.a) {
                this.c.onError(a);
            }
            return true;
        }

        public boolean d() {
            a<?, ?>[] andSet;
            this.m.a();
            a<?, ?>[] aVarArr = this.l.get();
            a<?, ?>[] aVarArr2 = t;
            if (aVarArr == aVarArr2 || (andSet = this.l.getAndSet(aVarArr2)) == t) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.a();
            }
            return true;
        }

        public void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:129:0x0004, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f() {
            /*
                Method dump skipped, instructions count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.yi0.b.f():void");
        }

        @Override // defpackage.ch0
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            e();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.i) {
                z90.a(th);
            } else if (this.j.a(th)) {
                this.i = true;
                e();
            } else {
                z90.a(th);
            }
        }

        @Override // defpackage.ch0
        public void onNext(T t2) {
            if (this.i) {
                return;
            }
            try {
                bh0<? extends U> apply = this.d.apply(t2);
                ai0.a(apply, "The mapper returned a null ObservableSource");
                bh0<? extends U> bh0Var = apply;
                if (this.f != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.r == this.f) {
                            this.q.offer(bh0Var);
                            return;
                        }
                        this.r++;
                    }
                }
                a(bh0Var);
            } catch (Throwable th) {
                z90.c(th);
                this.m.a();
                onError(th);
            }
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.m, kh0Var)) {
                this.m = kh0Var;
                this.c.onSubscribe(this);
            }
        }

        public void a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.l.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = s;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.l.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // defpackage.kh0
        public void a() {
            Throwable a;
            if (this.k) {
                return;
            }
            this.k = true;
            if (!d() || (a = this.j.a()) == null || a == gk0.a) {
                return;
            }
            z90.a(a);
        }
    }
}
