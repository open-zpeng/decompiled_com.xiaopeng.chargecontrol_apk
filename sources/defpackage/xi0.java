package defpackage;
/* compiled from: ObservableFilter.java */
/* renamed from: xi0  reason: default package */
/* loaded from: classes.dex */
public final class xi0<T> extends si0<T, T> {
    public final th0<? super T> d;

    /* compiled from: ObservableFilter.java */
    /* renamed from: xi0$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends hi0<T, T> {
        public final th0<? super T> h;

        public a(ch0<? super T> ch0Var, th0<? super T> th0Var) {
            super(ch0Var);
            this.h = th0Var;
        }

        @Override // defpackage.di0
        public int a(int i) {
            di0<T> di0Var = this.e;
            if (di0Var == null || (i & 4) != 0) {
                return 0;
            }
            int a = di0Var.a(i);
            if (a != 0) {
                this.g = a;
                return a;
            }
            return a;
        }

        @Override // defpackage.ch0
        public void onNext(T t) {
            if (this.g == 0) {
                try {
                    if (this.h.test(t)) {
                        this.c.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    z90.c(th);
                    this.d.a();
                    onError(th);
                    return;
                }
            }
            this.c.onNext(null);
        }

        public T poll() {
            T poll;
            do {
                poll = this.e.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.h.test(poll));
            return poll;
        }
    }

    public xi0(bh0<T> bh0Var, th0<? super T> th0Var) {
        super(bh0Var);
        this.d = th0Var;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super T> ch0Var) {
        ((ah0) this.c).a(new a(ch0Var, this.d));
    }
}
