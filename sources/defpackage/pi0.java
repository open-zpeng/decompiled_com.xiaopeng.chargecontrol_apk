package defpackage;
/* compiled from: MaybeFromSingle.java */
/* renamed from: pi0  reason: default package */
/* loaded from: classes.dex */
public final class pi0<T> extends yg0<T> implements ci0<T> {
    public final eh0<T> a;

    /* compiled from: MaybeFromSingle.java */
    /* renamed from: pi0$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements fh0<T>, kh0 {
        public final zg0<? super T> c;
        public kh0 d;

        public a(zg0<? super T> zg0Var) {
            this.c = zg0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            this.d.a();
            this.d = vh0.DISPOSED;
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.d.b();
        }

        @Override // defpackage.fh0
        public void onError(Throwable th) {
            this.d = vh0.DISPOSED;
            this.c.onError(th);
        }

        @Override // defpackage.fh0
        public void onSubscribe(kh0 kh0Var) {
            if (vh0.a(this.d, kh0Var)) {
                this.d = kh0Var;
                this.c.onSubscribe(this);
            }
        }

        @Override // defpackage.fh0
        public void onSuccess(T t) {
            this.d = vh0.DISPOSED;
            this.c.onSuccess(t);
        }
    }

    public pi0(eh0<T> eh0Var) {
        this.a = eh0Var;
    }

    @Override // defpackage.yg0
    public void b(zg0<? super T> zg0Var) {
        this.a.a(new a(zg0Var));
    }
}
