package defpackage;
/* compiled from: ObservableRange.java */
/* renamed from: cj0  reason: default package */
/* loaded from: classes.dex */
public final class cj0 extends ah0<Integer> {
    public final int c;
    public final long d;

    /* compiled from: ObservableRange.java */
    /* renamed from: cj0$a */
    /* loaded from: classes.dex */
    public static final class a extends ii0<Integer> {
        public final ch0<? super Integer> c;
        public final long d;
        public long e;
        public boolean f;

        public a(ch0<? super Integer> ch0Var, long j, long j2) {
            this.c = ch0Var;
            this.e = j;
            this.d = j2;
        }

        @Override // defpackage.kh0
        public void a() {
            set(1);
        }

        @Override // defpackage.kh0
        public boolean b() {
            return get() != 0;
        }

        public void clear() {
            this.e = this.d;
            lazySet(1);
        }

        public boolean isEmpty() {
            return this.e == this.d;
        }

        public Object poll() {
            long j = this.e;
            if (j != this.d) {
                this.e = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }

        @Override // defpackage.di0
        public int a(int i) {
            if ((i & 1) != 0) {
                this.f = true;
                return 1;
            }
            return 0;
        }
    }

    public cj0(int i, int i2) {
        this.c = i;
        this.d = i + i2;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super Integer> ch0Var) {
        a aVar = new a(ch0Var, this.c, this.d);
        ch0Var.onSubscribe(aVar);
        if (aVar.f) {
            return;
        }
        ch0<? super Integer> ch0Var2 = aVar.c;
        long j = aVar.d;
        for (long j2 = aVar.e; j2 != j && aVar.get() == 0; j2++) {
            ch0Var2.onNext(Integer.valueOf((int) j2));
        }
        if (aVar.get() == 0) {
            aVar.lazySet(1);
            ch0Var2.onComplete();
        }
    }
}
