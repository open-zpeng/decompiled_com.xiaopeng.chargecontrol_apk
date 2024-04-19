package defpackage;
/* compiled from: ObservableTakeUntilPredicate.java */
/* renamed from: gj0  reason: default package */
/* loaded from: classes.dex */
public final class gj0<T> extends si0<T, T> {
    public final th0<? super T> d;

    /* compiled from: ObservableTakeUntilPredicate.java */
    /* renamed from: gj0$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements ch0<T>, kh0 {
        public final ch0<? super T> c;
        public final th0<? super T> d;
        public kh0 e;
        public boolean f;

        public a(ch0<? super T> ch0Var, th0<? super T> th0Var) {
            this.c = ch0Var;
            this.d = th0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            this.e.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.e.b();
        }

        @Override // defpackage.ch0
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.c.onComplete();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (!this.f) {
                this.f = true;
                this.c.onError(th);
                return;
            }
            z90.a(th);
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            this.c.onNext(t);
            try {
                if (this.d.test(t)) {
                    this.f = true;
                    this.e.a();
                    this.c.onComplete();
                }
            } catch (Throwable th) {
                z90.c(th);
                this.e.a();
                onError(th);
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

    public gj0(bh0<T> bh0Var, th0<? super T> th0Var) {
        super(bh0Var);
        this.d = th0Var;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        ((ah0) this.c).a(new a(ch0Var, this.d));
    }
}
