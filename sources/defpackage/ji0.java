package defpackage;

import java.util.concurrent.CountDownLatch;
/* JADX WARN: Incorrect class signature, class is equals to this class: <T:Ljava/lang/Object;>Lji0<TT;>; */
/* compiled from: BlockingFirstObserver.java */
/* renamed from: ji0  reason: default package */
/* loaded from: classes.dex */
public final class ji0<T> extends CountDownLatch implements ch0, kh0 {
    public T c;
    public Throwable d;
    public kh0 e;
    public volatile boolean f;

    public ji0() {
        super(1);
    }

    @Override // defpackage.kh0
    public final void a() {
        this.f = true;
        kh0 kh0Var = this.e;
        if (kh0Var != null) {
            kh0Var.a();
        }
    }

    @Override // defpackage.kh0
    public final boolean b() {
        return this.f;
    }

    @Override // defpackage.ch0
    public final void onComplete() {
        countDown();
    }

    @Override // defpackage.ch0
    public void onError(Throwable th) {
        if (this.c == null) {
            this.d = th;
        }
        countDown();
    }

    @Override // defpackage.ch0
    public void onNext(T t) {
        if (this.c == null) {
            this.c = t;
            this.e.a();
            countDown();
        }
    }

    @Override // defpackage.ch0
    public final void onSubscribe(kh0 kh0Var) {
        this.e = kh0Var;
        if (this.f) {
            kh0Var.a();
        }
    }
}
