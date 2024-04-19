package defpackage;

import defpackage.dh0;
/* compiled from: ObservableObserveOn.java */
/* renamed from: bj0  reason: default package */
/* loaded from: classes.dex */
public final class bj0<T> extends si0<T, T> {
    public final dh0 d;
    public final boolean e;
    public final int f;

    public bj0(bh0<T> bh0Var, dh0 dh0Var, boolean z, int i) {
        super(bh0Var);
        this.d = dh0Var;
        this.e = z;
        this.f = i;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        dh0 dh0Var = this.d;
        if (dh0Var instanceof ck0) {
            ((ah0) this.c).a(ch0Var);
            return;
        }
        dh0.c a2 = dh0Var.a();
        ((ah0) this.c).a(new a(ch0Var, a2, this.e, this.f));
    }

    /* compiled from: ObservableObserveOn.java */
    /* renamed from: bj0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends ii0<T> implements ch0<T>, Runnable {
        public final ch0<? super T> c;
        public final dh0.c d;
        public final boolean e;
        public final int f;
        public gi0<T> g;
        public kh0 h;
        public Throwable i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;
        public boolean m;

        public a(ch0<? super T> ch0Var, dh0.c cVar, boolean z, int i) {
            this.c = ch0Var;
            this.d = cVar;
            this.e = z;
            this.f = i;
        }

        @Override // defpackage.kh0
        public void a() {
            if (this.k) {
                return;
            }
            this.k = true;
            this.h.a();
            this.d.a();
            if (this.m || getAndIncrement() != 0) {
                return;
            }
            this.g.clear();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.k;
        }

        public void c() {
            if (getAndIncrement() == 0) {
                this.d.a(this);
            }
        }

        public void clear() {
            this.g.clear();
        }

        public boolean isEmpty() {
            return this.g.isEmpty();
        }

        @Override // defpackage.ch0
        public void onComplete() {
            if (this.j) {
                return;
            }
            this.j = true;
            c();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.j) {
                z90.a(th);
                return;
            }
            this.i = th;
            this.j = true;
            c();
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.j) {
                return;
            }
            if (this.l != 2) {
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
                    int a = di0Var.a(7);
                    if (a == 1) {
                        this.l = a;
                        this.g = di0Var;
                        this.j = true;
                        this.c.onSubscribe(this);
                        c();
                        return;
                    } else if (a == 2) {
                        this.l = a;
                        this.g = di0Var;
                        this.c.onSubscribe(this);
                        return;
                    }
                }
                this.g = new nj0(this.f);
                this.c.onSubscribe(this);
            }
        }

        public T poll() {
            return this.g.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.m) {
                int i = 1;
                while (!this.k) {
                    boolean z = this.j;
                    Throwable th = this.i;
                    if (!this.e && z && th != null) {
                        this.k = true;
                        this.c.onError(th);
                        this.d.a();
                        return;
                    }
                    this.c.onNext(null);
                    if (z) {
                        this.k = true;
                        Throwable th2 = this.i;
                        if (th2 != null) {
                            this.c.onError(th2);
                        } else {
                            this.c.onComplete();
                        }
                        this.d.a();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                return;
            }
            gi0<T> gi0Var = this.g;
            ch0<? super T> ch0Var = this.c;
            int i2 = 1;
            while (!a(this.j, gi0Var.isEmpty(), ch0Var)) {
                while (true) {
                    boolean z2 = this.j;
                    try {
                        Object obj = (T) gi0Var.poll();
                        boolean z3 = obj == null;
                        if (a(z2, z3, ch0Var)) {
                            return;
                        }
                        if (z3) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            ch0Var.onNext(obj);
                        }
                    } catch (Throwable th3) {
                        z90.c(th3);
                        this.k = true;
                        this.h.a();
                        gi0Var.clear();
                        ch0Var.onError(th3);
                        this.d.a();
                        return;
                    }
                }
            }
        }

        public boolean a(boolean z, boolean z2, ch0<? super T> ch0Var) {
            if (this.k) {
                this.g.clear();
                return true;
            } else if (z) {
                Throwable th = this.i;
                if (this.e) {
                    if (z2) {
                        this.k = true;
                        if (th != null) {
                            ch0Var.onError(th);
                        } else {
                            ch0Var.onComplete();
                        }
                        this.d.a();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.k = true;
                    this.g.clear();
                    ch0Var.onError(th);
                    this.d.a();
                    return true;
                } else if (z2) {
                    this.k = true;
                    ch0Var.onComplete();
                    this.d.a();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // defpackage.di0
        public int a(int i) {
            if ((i & 2) != 0) {
                this.m = true;
                return 2;
            }
            return 0;
        }
    }
}
