package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleSubscribeOn.java */
/* renamed from: lj0  reason: default package */
/* loaded from: classes.dex */
public final class lj0<T> extends eh0<T> {
    public final eh0<? extends T> a;
    public final dh0 b;

    /* compiled from: SingleSubscribeOn.java */
    /* renamed from: lj0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<kh0> implements fh0<T>, kh0, Runnable {
        public final fh0<? super T> c;
        public final yh0 d = new yh0();
        public final eh0<? extends T> e;

        public a(fh0<? super T> fh0Var, eh0<? extends T> eh0Var) {
            this.c = fh0Var;
            this.e = eh0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            vh0.a((AtomicReference<kh0>) this);
            this.d.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return vh0.a(get());
        }

        @Override // defpackage.fh0
        public void onError(Throwable th) {
            this.c.onError(th);
        }

        @Override // defpackage.fh0
        public void onSubscribe(kh0 kh0Var) {
            vh0.b(this, kh0Var);
        }

        @Override // defpackage.fh0
        public void onSuccess(T t) {
            this.c.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.e.a(this);
        }
    }

    public lj0(eh0<? extends T> eh0Var, dh0 dh0Var) {
        this.a = eh0Var;
        this.b = dh0Var;
    }

    @Override // defpackage.eh0
    public void b(fh0<? super T> fh0Var) {
        a aVar = new a(fh0Var, this.a);
        fh0Var.onSubscribe(aVar);
        aVar.d.a(this.b.a(aVar));
    }
}
