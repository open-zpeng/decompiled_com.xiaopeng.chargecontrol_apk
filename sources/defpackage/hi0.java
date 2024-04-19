package defpackage;
/* compiled from: BasicFuseableObserver.java */
/* renamed from: hi0  reason: default package */
/* loaded from: classes.dex */
public abstract class hi0<T, R> implements ch0<T>, di0<R> {
    public final ch0<? super R> c;
    public kh0 d;
    public di0<T> e;
    public boolean f;
    public int g;

    public hi0(ch0<? super R> ch0Var) {
        this.c = ch0Var;
    }

    @Override // defpackage.kh0
    public void a() {
        this.d.a();
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this.d.b();
    }

    public void clear() {
        this.e.clear();
    }

    public boolean isEmpty() {
        return this.e.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.ch0
    public void onComplete() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.c.onComplete();
    }

    @Override // defpackage.ch0
    public void onError(Throwable th) {
        if (this.f) {
            z90.a(th);
            return;
        }
        this.f = true;
        this.c.onError(th);
    }

    @Override // defpackage.ch0
    public final void onSubscribe(kh0 kh0Var) {
        if (vh0.a(this.d, kh0Var)) {
            this.d = kh0Var;
            if (kh0Var instanceof di0) {
                this.e = (di0) kh0Var;
            }
            this.c.onSubscribe(this);
        }
    }
}
