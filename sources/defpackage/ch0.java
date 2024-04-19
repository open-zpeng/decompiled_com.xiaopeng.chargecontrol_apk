package defpackage;
/* compiled from: Observer.java */
/* renamed from: ch0  reason: default package */
/* loaded from: classes.dex */
public interface ch0<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(kh0 kh0Var);
}
