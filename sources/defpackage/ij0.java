package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimer.java */
/* renamed from: ij0  reason: default package */
/* loaded from: classes.dex */
public final class ij0 extends ah0<Long> {
    public final dh0 c;
    public final long d;
    public final TimeUnit e;

    /* compiled from: ObservableTimer.java */
    /* renamed from: ij0$a */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<kh0> implements kh0, Runnable {
        public final ch0<? super Long> c;

        public a(ch0<? super Long> ch0Var) {
            this.c = ch0Var;
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
            this.c.onNext(0L);
            lazySet(wh0.INSTANCE);
            this.c.onComplete();
        }
    }

    public ij0(long j, TimeUnit timeUnit, dh0 dh0Var) {
        this.d = j;
        this.e = timeUnit;
        this.c = dh0Var;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super Long> ch0Var) {
        a aVar = new a(ch0Var);
        ch0Var.onSubscribe(aVar);
        vh0.c(aVar, this.c.a(aVar, this.d, this.e));
    }
}
