package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* renamed from: vh0  reason: default package */
/* loaded from: classes.dex */
public enum vh0 implements kh0 {
    DISPOSED;

    public static boolean a(kh0 kh0Var) {
        return kh0Var == DISPOSED;
    }

    public static boolean b(AtomicReference<kh0> atomicReference, kh0 kh0Var) {
        ai0.a(kh0Var, "d is null");
        if (atomicReference.compareAndSet(null, kh0Var)) {
            return true;
        }
        kh0Var.a();
        if (atomicReference.get() != DISPOSED) {
            z90.a(new oh0("Disposable already set!"));
            return false;
        }
        return false;
    }

    public static boolean c(AtomicReference<kh0> atomicReference, kh0 kh0Var) {
        if (atomicReference.compareAndSet(null, kh0Var)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            kh0Var.a();
            return false;
        }
        return false;
    }

    @Override // defpackage.kh0
    public void a() {
    }

    @Override // defpackage.kh0
    public boolean b() {
        return true;
    }

    public static boolean a(AtomicReference<kh0> atomicReference, kh0 kh0Var) {
        kh0 kh0Var2;
        do {
            kh0Var2 = atomicReference.get();
            if (kh0Var2 == DISPOSED) {
                if (kh0Var != null) {
                    kh0Var.a();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(kh0Var2, kh0Var));
        return true;
    }

    public static boolean a(AtomicReference<kh0> atomicReference) {
        kh0 andSet;
        kh0 kh0Var = atomicReference.get();
        vh0 vh0Var = DISPOSED;
        if (kh0Var == vh0Var || (andSet = atomicReference.getAndSet(vh0Var)) == vh0Var) {
            return false;
        }
        if (andSet != null) {
            andSet.a();
            return true;
        }
        return true;
    }

    public static boolean a(kh0 kh0Var, kh0 kh0Var2) {
        if (kh0Var2 == null) {
            z90.a(new NullPointerException("next is null"));
            return false;
        } else if (kh0Var != null) {
            kh0Var2.a();
            z90.a(new oh0("Disposable already set!"));
            return false;
        } else {
            return true;
        }
    }
}
