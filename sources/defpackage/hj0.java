package defpackage;

import defpackage.dh0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableThrottleFirstTimed.java */
/* renamed from: hj0  reason: default package */
/* loaded from: classes.dex */
public final class hj0<T> extends si0<T, T> {
    public final long d;
    public final TimeUnit e;
    public final dh0 f;

    /* compiled from: ObservableThrottleFirstTimed.java */
    /* renamed from: hj0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<kh0> implements ch0<T>, kh0, Runnable {
        public final ch0<? super T> c;
        public final long d;
        public final TimeUnit e;
        public final dh0.c f;
        public kh0 g;
        public volatile boolean h;
        public boolean i;

        public a(ch0<? super T> ch0Var, long j, TimeUnit timeUnit, dh0.c cVar) {
            this.c = ch0Var;
            this.d = j;
            this.e = timeUnit;
            this.f = cVar;
        }

        @Override // defpackage.kh0
        public void a() {
            this.g.a();
            this.f.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.f.b();
        }

        @Override // defpackage.ch0
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.c.onComplete();
            this.f.a();
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            if (this.i) {
                z90.a(th);
                return;
            }
            this.i = true;
            this.c.onError(th);
            this.f.a();
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.h || this.i) {
                return;
            }
            this.h = true;
            this.c.onNext(t);
            kh0 kh0Var = get();
            if (kh0Var != null) {
                kh0Var.a();
            }
            vh0.a((AtomicReference<kh0>) this, this.f.a(this, this.d, this.e));
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.g, kh0Var)) {
                this.g = kh0Var;
                this.c.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.h = false;
        }
    }

    public hj0(bh0<T> bh0Var, long j, TimeUnit timeUnit, dh0 dh0Var) {
        super(bh0Var);
        this.d = j;
        this.e = timeUnit;
        this.f = dh0Var;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        ((ah0) this.c).a(new a(new kk0(ch0Var), this.d, this.e, this.f.a()));
    }
}
