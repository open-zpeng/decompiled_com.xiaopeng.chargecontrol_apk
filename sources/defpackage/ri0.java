package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MaybeSubscribeOn.java */
/* renamed from: ri0  reason: default package */
/* loaded from: classes.dex */
public final class ri0<T> extends ni0<T, T> {
    public final dh0 b;

    /* compiled from: MaybeSubscribeOn.java */
    /* renamed from: ri0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<kh0> implements zg0<T>, kh0 {
        public final yh0 c = new yh0();
        public final zg0<? super T> d;

        public a(zg0<? super T> zg0Var) {
            this.d = zg0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            vh0.a((AtomicReference<kh0>) this);
            this.c.a();
        }

        @Override // defpackage.kh0
        public boolean b() {
            return vh0.a(get());
        }

        @Override // defpackage.zg0
        public void onComplete() {
            this.d.onComplete();
        }

        @Override // defpackage.zg0
        public void onError(Throwable th) {
            this.d.onError(th);
        }

        @Override // defpackage.zg0
        public void onSubscribe(kh0 kh0Var) {
            vh0.b(this, kh0Var);
        }

        @Override // defpackage.zg0
        public void onSuccess(T t) {
            this.d.onSuccess(t);
        }
    }

    /* compiled from: MaybeSubscribeOn.java */
    /* renamed from: ri0$b */
    /* loaded from: classes.dex */
    public static final class b<T> implements Runnable {
        public final zg0<? super T> c;
        public final yg0<T> d;

        public b(zg0<? super T> zg0Var, yg0<T> yg0Var) {
            this.c = zg0Var;
            this.d = yg0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d.a(this.c);
        }
    }

    public ri0(yg0<T> yg0Var, dh0 dh0Var) {
        super(yg0Var);
        this.b = dh0Var;
    }

    @Override // defpackage.yg0
    public void b(zg0<? super T> zg0Var) {
        a aVar = new a(zg0Var);
        zg0Var.onSubscribe(aVar);
        aVar.c.a(this.b.a(new b(aVar, this.a)));
    }
}
