package defpackage;
/* compiled from: CallbackException.java */
/* renamed from: bj  reason: default package */
/* loaded from: classes.dex */
public final class bj extends RuntimeException {
    public bj(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
