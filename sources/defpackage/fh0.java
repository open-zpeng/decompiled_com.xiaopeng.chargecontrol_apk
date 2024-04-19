package defpackage;
/* compiled from: SingleObserver.java */
/* renamed from: fh0  reason: default package */
/* loaded from: classes.dex */
public interface fh0<T> {
    void onError(Throwable th);

    void onSubscribe(kh0 kh0Var);

    void onSuccess(T t);
}
