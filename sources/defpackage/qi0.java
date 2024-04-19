package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MaybeObserveOn.java */
/* renamed from: qi0  reason: default package */
/* loaded from: classes.dex */
public final class qi0<T> extends ni0<T, T> {
    public final dh0 b;

    /* compiled from: MaybeObserveOn.java */
    /* renamed from: qi0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<kh0> implements zg0<T>, kh0, Runnable {
        public final zg0<? super T> c;
        public final dh0 d;
        public T e;
        public Throwable f;

        public a(zg0<? super T> zg0Var, dh0 dh0Var) {
            this.c = zg0Var;
            this.d = dh0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            vh0.a((AtomicReference<kh0>) this);
        }

        @Override // defpackage.kh0
        public boolean b() {
            return vh0.a(get());
        }

        @Override // defpackage.zg0
        public void onComplete() {
            vh0.a((AtomicReference<kh0>) this, this.d.a(this));
        }

        @Override // defpackage.zg0
        public void onError(Throwable th) {
            this.f = th;
            vh0.a((AtomicReference<kh0>) this, this.d.a(this));
        }

        @Override // defpackage.zg0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.b(this, kh0Var)) {
                this.c.onSubscribe(this);
            }
        }

        @Override // defpackage.zg0
        public void onSuccess(T t) {
            this.e = t;
            vh0.a((AtomicReference<kh0>) this, this.d.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f;
            if (th != null) {
                this.f = null;
                this.c.onError(th);
                return;
            }
            T t = this.e;
            if (t != null) {
                this.e = null;
                this.c.onSuccess(t);
                return;
            }
            this.c.onComplete();
        }
    }

    public qi0(yg0<T> yg0Var, dh0 dh0Var) {
        super(yg0Var);
        this.b = dh0Var;
    }

    @Override // defpackage.yg0
    public void b(zg0<? super T> zg0Var) {
        this.a.a(new a(zg0Var, this.b));
    }
}
