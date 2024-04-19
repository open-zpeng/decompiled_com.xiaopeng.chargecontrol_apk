package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* renamed from: fj0  reason: default package */
/* loaded from: classes.dex */
public final class fj0<T> extends si0<T, T> {
    public final dh0 d;

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: fj0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<kh0> implements ch0<T>, kh0 {
        public final ch0<? super T> c;
        public final AtomicReference<kh0> d = new AtomicReference<>();

        public a(ch0<? super T> ch0Var) {
            this.c = ch0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            vh0.a(this.d);
            vh0.a((AtomicReference<kh0>) this);
        }

        @Override // defpackage.kh0
        public boolean b() {
            return vh0.a(get());
        }

        @Override // defpackage.ch0
        public void onComplete() {
            this.c.onComplete();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            this.c.onError(th);
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            this.c.onNext(t);
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            vh0.b(this.d, kh0Var);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: fj0$b */
    /* loaded from: classes.dex */
    public final class b implements Runnable {
        public final a<T> c;

        public b(a<T> aVar) {
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ah0) fj0.this.c).a(this.c);
        }
    }

    public fj0(bh0<T> bh0Var, dh0 dh0Var) {
        super(bh0Var);
        this.d = dh0Var;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        a aVar = new a(ch0Var);
        ch0Var.onSubscribe(aVar);
        vh0.b(aVar, this.d.a(new b(aVar)));
    }
}
