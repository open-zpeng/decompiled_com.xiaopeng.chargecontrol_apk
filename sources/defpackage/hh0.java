package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* renamed from: hh0  reason: default package */
/* loaded from: classes.dex */
public final class hh0 {
    public static final dh0 a;

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: hh0$a */
    /* loaded from: classes.dex */
    public static class a implements Callable<dh0> {
        @Override // java.util.concurrent.Callable
        public dh0 call() {
            return b.a;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: hh0$b */
    /* loaded from: classes.dex */
    public static final class b {
        public static final dh0 a = new ih0(new Handler(Looper.getMainLooper()), false);
    }

    static {
        dh0 call;
        a aVar = new a();
        sh0<Callable<dh0>, dh0> sh0Var = z90.e;
        if (sh0Var == null) {
            try {
                call = aVar.call();
                if (call == null) {
                    throw new NullPointerException("Scheduler Callable returned null");
                }
            } catch (Throwable th) {
                z90.b(th);
                throw null;
            }
        } else {
            call = (dh0) z90.a((sh0<a, Object>) sh0Var, aVar);
            if (call == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
        }
        a = call;
    }

    public static dh0 a() {
        dh0 dh0Var = a;
        if (dh0Var != null) {
            sh0<dh0, dh0> sh0Var = z90.f;
            return sh0Var == null ? dh0Var : (dh0) z90.a(sh0Var, dh0Var);
        }
        throw new NullPointerException("scheduler == null");
    }
}
