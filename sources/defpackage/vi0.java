package defpackage;

import defpackage.zh0;
/* compiled from: ObservableDoOnEach.java */
/* renamed from: vi0  reason: default package */
/* loaded from: classes.dex */
public final class vi0<T> extends si0<T, T> {
    public final rh0<? super T> d;
    public final rh0<? super Throwable> e;
    public final qh0 f;
    public final qh0 g;

    /* compiled from: ObservableDoOnEach.java */
    /* renamed from: vi0$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements ch0<T>, kh0 {
        public final ch0<? super T> c;
        public final rh0<? super T> d;
        public final rh0<? super Throwable> e;
        public final qh0 f;
        public final qh0 g;
        public kh0 h;
        public boolean i;

        public a(ch0<? super T> ch0Var, rh0<? super T> rh0Var, rh0<? super Throwable> rh0Var2, qh0 qh0Var, qh0 qh0Var2) {
            this.c = ch0Var;
            this.d = rh0Var;
            this.e = rh0Var2;
            this.f = qh0Var;
            this.g = qh0Var2;
        }

        @Override // defpackage.kh0
        public void a() {
            this.h.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.h.b();
        }

        @Override // defpackage.ch0
        public void onComplete() {
            if (this.i) {
                return;
            }
            try {
                ((zh0.a) this.f).a();
                this.i = true;
                this.c.onComplete();
                try {
                    ((zh0.a) this.g).a();
                } catch (Throwable th) {
                    z90.c(th);
                    z90.a(th);
                }
            } catch (Throwable th2) {
                z90.c(th2);
                onError(th2);
            }
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.i) {
                z90.a(th);
                return;
            }
            this.i = true;
            try {
                this.e.accept(th);
            } catch (Throwable th2) {
                z90.c(th2);
                th = new mh0(th, th2);
            }
            this.c.onError(th);
            try {
                ((zh0.a) this.g).a();
            } catch (Throwable th3) {
                z90.c(th3);
                z90.a(th3);
            }
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            try {
                this.d.accept(t);
                this.c.onNext(t);
            } catch (Throwable th) {
                z90.c(th);
                this.h.a();
                onError(th);
            }
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.h, kh0Var)) {
                this.h = kh0Var;
                this.c.onSubscribe(this);
            }
        }
    }

    public vi0(bh0<T> bh0Var, rh0<? super T> rh0Var, rh0<? super Throwable> rh0Var2, qh0 qh0Var, qh0 qh0Var2) {
        super(bh0Var);
        this.d = rh0Var;
        this.e = rh0Var2;
        this.f = qh0Var;
        this.g = qh0Var2;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        ((ah0) this.c).a(new a(ch0Var, this.d, this.e, this.f, this.g));
    }
}
