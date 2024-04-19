package defpackage;
/* compiled from: DeferredScalarDisposable.java */
/* renamed from: li0  reason: default package */
/* loaded from: classes.dex */
public class li0<T> extends ii0<T> {
    public final ch0<? super T> c;
    public T d;

    public li0(ch0<? super T> ch0Var) {
        this.c = ch0Var;
    }

    @Override // defpackage.di0
    public final int a(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    @Override // defpackage.kh0
    public final boolean b() {
        return get() == 4;
    }

    public final void clear() {
        lazySet(32);
        this.d = null;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() {
        if (get() == 16) {
            T t = this.d;
            this.d = null;
            lazySet(32);
            return t;
        }
        return null;
    }

    @Override // defpackage.kh0
    public void a() {
        set(4);
        this.d = null;
    }
}
