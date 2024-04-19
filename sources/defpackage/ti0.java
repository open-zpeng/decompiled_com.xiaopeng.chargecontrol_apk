package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableConcatMap.java */
/* renamed from: ti0  reason: default package */
/* loaded from: classes.dex */
public final class ti0<T, U> extends si0<T, U> {
    public final sh0<? super T, ? extends bh0<? extends U>> d;
    public final int e;
    public final fk0 f;

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: ti0$a */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends AtomicInteger implements ch0<T>, kh0 {
        public final ch0<? super R> c;
        public final sh0<? super T, ? extends bh0<? extends R>> d;
        public final int e;
        public final ek0 f = new ek0();
        public final C0011a<R> g;
        public final boolean h;
        public gi0<T> i;
        public kh0 j;
        public volatile boolean k;
        public volatile boolean l;
        public volatile boolean m;
        public int n;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: ti0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0011a<R> extends AtomicReference<kh0> implements ch0<R> {
            public final ch0<? super R> c;
            public final a<?, R> d;

            public C0011a(ch0<? super R> ch0Var, a<?, R> aVar) {
                this.c = ch0Var;
                this.d = aVar;
            }

            public void a() {
                vh0.a(this);
            }

            @Override // defpackage.ch0
            public void onComplete() {
                a<?, R> aVar = this.d;
                aVar.k = false;
                aVar.c();
            }

            @Override // defpackage.ch0
            public void onError(Throwable th) {
                a<?, R> aVar = this.d;
                if (aVar.f.a(th)) {
                    if (!aVar.h) {
                        aVar.j.a();
                    }
                    aVar.k = false;
                    aVar.c();
                    return;
                }
                z90.a(th);
            }

            @Override // defpackage.ch0
            public void onNext(R r) {
                this.c.onNext(r);
            }

            @Override // defpackage.ch0
            public void onSubscribe(kh0 kh0Var) {
                vh0.a(this, kh0Var);
            }
        }

        public a(ch0<? super R> ch0Var, sh0<? super T, ? extends bh0<? extends R>> sh0Var, int i, boolean z) {
            this.c = ch0Var;
            this.d = sh0Var;
            this.e = i;
            this.h = z;
            this.g = new C0011a<>(ch0Var, this);
        }

        @Override // defpackage.kh0
        public void a() {
            this.m = true;
            this.j.a();
            this.g.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.m;
        }

        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            ch0<? super R> ch0Var = this.c;
            gi0<T> gi0Var = this.i;
            ek0 ek0Var = this.f;
            while (true) {
                if (!this.k) {
                    if (this.m) {
                        gi0Var.clear();
                        return;
                    } else if (!this.h && ek0Var.get() != null) {
                        gi0Var.clear();
                        this.m = true;
                        ch0Var.onError(gk0.a(ek0Var));
                        return;
                    } else {
                        boolean z = this.l;
                        try {
                            T poll = gi0Var.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.m = true;
                                Throwable a = ek0Var.a();
                                if (a != null) {
                                    ch0Var.onError(a);
                                    return;
                                } else {
                                    ch0Var.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    bh0<? extends R> apply = this.d.apply(poll);
                                    ai0.a(apply, "The mapper returned a null ObservableSource");
                                    bh0<? extends R> bh0Var = apply;
                                    if (bh0Var instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) bh0Var).call();
                                            if (obj != 0 && !this.m) {
                                                ch0Var.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            z90.c(th);
                                            ek0Var.a(th);
                                        }
                                    } else {
                                        this.k = true;
                                        ((ah0) bh0Var).a(this.g);
                                    }
                                } catch (Throwable th2) {
                                    z90.c(th2);
                                    this.m = true;
                                    this.j.a();
                                    gi0Var.clear();
                                    ek0Var.a(th2);
                                    ch0Var.onError(gk0.a(ek0Var));
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            z90.c(th3);
                            this.m = true;
                            this.j.a();
                            ek0Var.a(th3);
                            ch0Var.onError(gk0.a(ek0Var));
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // defpackage.ch0
        public void onComplete() {
            this.l = true;
            c();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.f.a(th)) {
                this.l = true;
                c();
                return;
            }
            z90.a(th);
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.n == 0) {
                this.i.offer(t);
            }
            c();
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.j, kh0Var)) {
                this.j = kh0Var;
                if (kh0Var instanceof di0) {
                    di0 di0Var = (di0) kh0Var;
                    int a = di0Var.a(3);
                    if (a == 1) {
                        this.n = a;
                        this.i = di0Var;
                        this.l = true;
                        this.c.onSubscribe(this);
                        c();
                        return;
                    } else if (a == 2) {
                        this.n = a;
                        this.i = di0Var;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.i = new nj0(this.e);
                this.c.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: ti0$b */
    /* loaded from: classes.dex */
    public static final class b<T, U> extends AtomicInteger implements ch0<T>, kh0 {
        public final ch0<? super U> c;
        public final sh0<? super T, ? extends bh0<? extends U>> d;
        public final a<U> e;
        public final int f;
        public gi0<T> g;
        public kh0 h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: ti0$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> extends AtomicReference<kh0> implements ch0<U> {
            public final ch0<? super U> c;
            public final b<?, ?> d;

            public a(ch0<? super U> ch0Var, b<?, ?> bVar) {
                this.c = ch0Var;
                this.d = bVar;
            }

            public void a() {
                vh0.a(this);
            }

            @Override // defpackage.ch0
            public void onComplete() {
                b<?, ?> bVar = this.d;
                bVar.i = false;
                bVar.c();
            }

            @Override // defpackage.ch0
            public void onError(Throwable th) {
                this.d.a();
                this.c.onError(th);
            }

            @Override // defpackage.ch0
            public void onNext(U u) {
                this.c.onNext(u);
            }

            @Override // defpackage.ch0
            public void onSubscribe(kh0 kh0Var) {
                vh0.a(this, kh0Var);
            }
        }

        public b(ch0<? super U> ch0Var, sh0<? super T, ? extends bh0<? extends U>> sh0Var, int i) {
            this.c = ch0Var;
            this.d = sh0Var;
            this.f = i;
            this.e = new a<>(ch0Var, this);
        }

        @Override // defpackage.kh0
        public void a() {
            this.j = true;
            this.e.a();
            this.h.a();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.j;
        }

        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.j) {
                if (!this.i) {
                    boolean z = this.k;
                    try {
                        T poll = this.g.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.j = true;
                            this.c.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                bh0<? extends U> apply = this.d.apply(poll);
                                ai0.a(apply, "The mapper returned a null ObservableSource");
                                bh0<? extends U> bh0Var = apply;
                                this.i = true;
                                ((ah0) bh0Var).a(this.e);
                            } catch (Throwable th) {
                                z90.c(th);
                                a();
                                this.g.clear();
                                this.c.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        z90.c(th2);
                        a();
                        this.g.clear();
                        this.c.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.g.clear();
        }

        @Override // defpackage.ch0
        public void onComplete() {
            if (this.k) {
                return;
            }
            this.k = true;
            c();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.k) {
                z90.a(th);
                return;
            }
            this.k = true;
            a();
            this.c.onError(th);
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.k) {
                return;
            }
            if (this.l == 0) {
                this.g.offer(t);
            }
            c();
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.h, kh0Var)) {
                this.h = kh0Var;
                if (kh0Var instanceof di0) {
                    di0 di0Var = (di0) kh0Var;
                    int a2 = di0Var.a(3);
                    if (a2 == 1) {
                        this.l = a2;
                        this.g = di0Var;
                        this.k = true;
                        this.c.onSubscribe(this);
                        c();
                        return;
                    } else if (a2 == 2) {
                        this.l = a2;
                        this.g = di0Var;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.g = new nj0(this.f);
                this.c.onSubscribe(this);
            }
        }
    }

    public ti0(bh0<T> bh0Var, sh0<? super T, ? extends bh0<? extends U>> sh0Var, int i, fk0 fk0Var) {
        super(bh0Var);
        this.d = sh0Var;
        this.f = fk0Var;
        this.e = Math.max(8, i);
    }

    @Override // defpackage.ah0
    public void b(ch0<? super U> ch0Var) {
        if (z90.a(this.c, ch0Var, this.d)) {
            return;
        }
        fk0 fk0Var = this.f;
        if (fk0Var == fk0.IMMEDIATE) {
            ((ah0) this.c).a(new b(new kk0(ch0Var), this.d, this.e));
            return;
        }
        ((ah0) this.c).a(new a(ch0Var, this.d, this.e, fk0Var == fk0.END));
    }
}
