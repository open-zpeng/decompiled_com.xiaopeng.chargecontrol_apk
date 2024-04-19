package defpackage;
/* compiled from: OnErrorNotImplementedException.java */
/* renamed from: nh0  reason: default package */
/* loaded from: classes.dex */
public final class nh0 extends RuntimeException {
    public nh0(Throwable th) {
        super("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th == null ? new NullPointerException() : th);
    }
}
