package defpackage;
/* compiled from: SerializedObserver.java */
/* renamed from: kk0  reason: default package */
/* loaded from: classes.dex */
public final class kk0<T> implements ch0<T>, kh0 {
    public final ch0<? super T> c;
    public final boolean d = false;
    public kh0 e;
    public boolean f;
    public dk0<Object> g;
    public volatile boolean h;

    public kk0(ch0<? super T> ch0Var) {
        this.c = ch0Var;
    }

    @Override // defpackage.kh0
    public void a() {
        this.e.a();
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this.e.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x004b, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048 A[LOOP:2: B:14:0x0018->B:32:0x0048, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r8 = this;
        L0:
            monitor-enter(r8)
            dk0<java.lang.Object> r0 = r8.g     // Catch: java.lang.Throwable -> L53
            r1 = 0
            if (r0 != 0) goto La
            r8.f = r1     // Catch: java.lang.Throwable -> L53
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L53
            return
        La:
            r2 = 0
            r8.g = r2     // Catch: java.lang.Throwable -> L53
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L53
            ch0<? super T> r2 = r8.c
            java.lang.Object[] r3 = r0.b
            int r0 = r0.a
        L14:
            r4 = 1
            if (r3 == 0) goto L50
            r5 = r1
        L18:
            if (r5 >= r0) goto L4b
            r6 = r3[r5]
            if (r6 != 0) goto L1f
            goto L4b
        L1f:
            hk0 r7 = defpackage.hk0.COMPLETE
            if (r6 != r7) goto L27
            r2.onComplete()
            goto L32
        L27:
            boolean r7 = r6 instanceof defpackage.hk0.b
            if (r7 == 0) goto L34
            hk0$b r6 = (defpackage.hk0.b) r6
            java.lang.Throwable r6 = r6.c
            r2.onError(r6)
        L32:
            r6 = r4
            goto L44
        L34:
            boolean r7 = r6 instanceof defpackage.hk0.a
            if (r7 == 0) goto L40
            hk0$a r6 = (defpackage.hk0.a) r6
            kh0 r6 = r6.c
            r2.onSubscribe(r6)
            goto L43
        L40:
            r2.onNext(r6)
        L43:
            r6 = r1
        L44:
            if (r6 == 0) goto L48
            r1 = r4
            goto L50
        L48:
            int r5 = r5 + 1
            goto L18
        L4b:
            r3 = r3[r0]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            goto L14
        L50:
            if (r1 == 0) goto L0
            return
        L53:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L53
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kk0.c():void");
    }

    @Override // defpackage.ch0
    public void onComplete() {
        if (this.h) {
            return;
        }
        synchronized (this) {
            if (this.h) {
                return;
            }
            if (this.f) {
                dk0<Object> dk0Var = this.g;
                if (dk0Var == null) {
                    dk0Var = new dk0<>(4);
                    this.g = dk0Var;
                }
                dk0Var.a(hk0.COMPLETE);
                return;
            }
            this.h = true;
            this.f = true;
            this.c.onComplete();
        }
    }

    @Override // defpackage.ch0
    public void onError(Throwable th) {
        if (this.h) {
            z90.a(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.h) {
                z = true;
            } else if (this.f) {
                this.h = true;
                dk0<Object> dk0Var = this.g;
                if (dk0Var == null) {
                    dk0Var = new dk0<>(4);
                    this.g = dk0Var;
                }
                Object a = hk0.a(th);
                if (this.d) {
                    dk0Var.a(a);
                } else {
                    dk0Var.b[0] = a;
                }
                return;
            } else {
                this.h = true;
                this.f = true;
            }
            if (z) {
                z90.a(th);
            } else {
                this.c.onError(th);
            }
        }
    }

    @Override // defpackage.ch0
    public void onNext(T t) {
        if (this.h) {
            return;
        }
        if (t == null) {
            this.e.a();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.h) {
                return;
            }
            if (this.f) {
                dk0<Object> dk0Var = this.g;
                if (dk0Var == null) {
                    dk0Var = new dk0<>(4);
                    this.g = dk0Var;
                }
                hk0.a(t);
                dk0Var.a(t);
                return;
            }
            this.f = true;
            this.c.onNext(t);
            c();
        }
    }

    @Override // defpackage.ch0
    public void onSubscribe(kh0 kh0Var) {
        if (vh0.a(this.e, kh0Var)) {
            this.e = kh0Var;
            this.c.onSubscribe(this);
        }
    }
}
