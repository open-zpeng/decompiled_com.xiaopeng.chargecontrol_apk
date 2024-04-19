package defpackage;
/* compiled from: StateVerifier.java */
/* renamed from: wq  reason: default package */
/* loaded from: classes.dex */
public abstract class wq {

    /* compiled from: StateVerifier.java */
    /* renamed from: wq$b */
    /* loaded from: classes.dex */
    public static class b extends wq {
        public volatile boolean a;

        public b() {
            super(null);
        }

        @Override // defpackage.wq
        public void a() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public /* synthetic */ wq(a aVar) {
    }

    public abstract void a();
}
