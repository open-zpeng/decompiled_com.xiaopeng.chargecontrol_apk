package defpackage;
/* compiled from: MaybeObserver.java */
/* renamed from: zg0  reason: default package */
/* loaded from: classes.dex */
public interface zg0<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(kh0 kh0Var);

    void onSuccess(T t);
}
