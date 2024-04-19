package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleObserveOn.java */
/* renamed from: kj0  reason: default package */
/* loaded from: classes.dex */
public final class kj0<T> extends eh0<T> {
    public final eh0<T> a;
    public final dh0 b;

    /* compiled from: SingleObserveOn.java */
    /* renamed from: kj0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<kh0> implements fh0<T>, kh0, Runnable {
        public final fh0<? super T> c;
        public final dh0 d;
        public T e;
        public Throwable f;

        public a(fh0<? super T> fh0Var, dh0 dh0Var) {
            this.c = fh0Var;
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

        @Override // defpackage.fh0
        public void onError(Throwable th) {
            this.f = th;
            vh0.a((AtomicReference<kh0>) this, this.d.a(this));
        }

        @Override // defpackage.fh0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.b(this, kh0Var)) {
                this.c.onSubscribe(this);
            }
        }

        @Override // defpackage.fh0
        public void onSuccess(T t) {
            this.e = t;
            vh0.a((AtomicReference<kh0>) this, this.d.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f;
            if (th != null) {
                this.c.onError(th);
            } else {
                this.c.onSuccess((T) this.e);
            }
        }
    }

    public kj0(eh0<T> eh0Var, dh0 dh0Var) {
        this.a = eh0Var;
        this.b = dh0Var;
    }

    @Override // defpackage.eh0
    public void b(fh0<? super T> fh0Var) {
        this.a.a(new a(fh0Var, this.b));
    }
}
