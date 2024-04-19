package defpackage;

import defpackage.dh0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableIntervalRange.java */
/* renamed from: aj0  reason: default package */
/* loaded from: classes.dex */
public final class aj0 extends ah0<Long> {
    public final dh0 c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final TimeUnit h;

    /* compiled from: ObservableIntervalRange.java */
    /* renamed from: aj0$a */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<kh0> implements kh0, Runnable {
        public final ch0<? super Long> c;
        public final long d;
        public long e;

        public a(ch0<? super Long> ch0Var, long j, long j2) {
            this.c = ch0Var;
            this.e = j;
            this.d = j2;
        }

        @Override // defpackage.kh0
        public void a() {
            vh0.a((AtomicReference<kh0>) this);
        }

        @Override // defpackage.kh0
        public boolean b() {
            return get() == vh0.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b()) {
                return;
            }
            long j = this.e;
            this.c.onNext(Long.valueOf(j));
            if (j == this.d) {
                vh0.a((AtomicReference<kh0>) this);
                this.c.onComplete();
                return;
            }
            this.e = j + 1;
        }
    }

    public aj0(long j, long j2, long j3, long j4, TimeUnit timeUnit, dh0 dh0Var) {
        this.f = j3;
        this.g = j4;
        this.h = timeUnit;
        this.c = dh0Var;
        this.d = j;
        this.e = j2;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super Long> ch0Var) {
        a aVar = new a(ch0Var, this.d, this.e);
        ch0Var.onSubscribe(aVar);
        dh0 dh0Var = this.c;
        if (dh0Var instanceof ck0) {
            dh0.c a2 = dh0Var.a();
            vh0.b(aVar, a2);
            a2.a(aVar, this.f, this.g, this.h);
            return;
        }
        vh0.b(aVar, dh0Var.a(aVar, this.f, this.g, this.h));
    }
}
