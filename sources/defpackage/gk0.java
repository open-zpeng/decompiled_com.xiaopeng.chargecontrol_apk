package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ExceptionHelper.java */
/* renamed from: gk0  reason: default package */
/* loaded from: classes.dex */
public final class gk0 {
    public static final Throwable a = new a();

    /* compiled from: ExceptionHelper.java */
    /* renamed from: gk0$a */
    /* loaded from: classes.dex */
    public static final class a extends Throwable {
        public a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static RuntimeException a(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new mh0(th2, th)));
        return true;
    }

    public static <T> Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }
}
