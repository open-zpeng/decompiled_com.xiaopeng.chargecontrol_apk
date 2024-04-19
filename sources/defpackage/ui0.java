package defpackage;

import defpackage.dh0;
import java.util.concurrent.TimeUnit;
/* compiled from: ObservableDelay.java */
/* renamed from: ui0  reason: default package */
/* loaded from: classes.dex */
public final class ui0<T> extends si0<T, T> {
    public final long d;
    public final TimeUnit e;
    public final dh0 f;
    public final boolean g;

    /* compiled from: ObservableDelay.java */
    /* renamed from: ui0$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements ch0<T>, kh0 {
        public final ch0<? super T> c;
        public final long d;
        public final TimeUnit e;
        public final dh0.c f;
        public final boolean g;
        public kh0 h;

        /* compiled from: ObservableDelay.java */
        /* renamed from: ui0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class RunnableC0013a implements Runnable {
            public RunnableC0013a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.c.onComplete();
                } finally {
                    a.this.f.a();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* renamed from: ui0$a$b */
        /* loaded from: classes.dex */
        public final class b implements Runnable {
            public final Throwable c;

            public b(Throwable th) {
                this.c = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.c.onError(this.c);
                } finally {
                    a.this.f.a();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* renamed from: ui0$a$c */
        /* loaded from: classes.dex */
        public final class c implements Runnable {
            public final T c;

            public c(T t) {
                this.c = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c.onNext((T) this.c);
            }
        }

        public a(ch0<? super T> ch0Var, long j, TimeUnit timeUnit, dh0.c cVar, boolean z) {
            this.c = ch0Var;
            this.d = j;
            this.e = timeUnit;
            this.f = cVar;
            this.g = z;
        }

        @Override // defpackage.kh0
        public void a() {
            this.h.a();
            this.f.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.f.b();
        }

        @Override // defpackage.ch0
        public void onComplete() {
            this.f.a(new RunnableC0013a(), this.d, this.e);
        }

        @Override // defpackage.ch0
        public void onError(Throwable th) {
            this.f.a(new b(th), this.g ? this.d : 0L, this.e);
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            this.f.a(new c(t), this.d, this.e);
        }

        @Override // defpackage.ch0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.h, kh0Var)) {
                this.h = kh0Var;
                this.c.onSubscribe(this);
            }
        }
    }

    public ui0(bh0<T> bh0Var, long j, TimeUnit timeUnit, dh0 dh0Var, boolean z) {
        super(bh0Var);
        this.d = j;
        this.e = timeUnit;
        this.f = dh0Var;
        this.g = z;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        kk0 kk0Var = this.g ? ch0Var : new kk0(ch0Var);
        ((ah0) this.c).a(new a(kk0Var, this.d, this.e, this.f.a(), this.g));
    }
}
