package defpackage;
/* compiled from: EmptyDisposable.java */
/* renamed from: wh0  reason: default package */
/* loaded from: classes.dex */
public enum wh0 implements di0<Object> {
    INSTANCE,
    NEVER;

    @Override // defpackage.di0
    public int a(int i) {
        return i & 2;
    }

    @Override // defpackage.kh0
    public void a() {
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this == INSTANCE;
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }
}
