package defpackage;

import android.os.Handler;
import java.util.concurrent.Callable;
/* compiled from: RequestExecutor.java */
/* renamed from: z8  reason: default package */
/* loaded from: classes.dex */
public class z8<T> implements Runnable {
    public Callable<T> c;
    public b9<T> d;
    public Handler e;

    /* compiled from: RequestExecutor.java */
    /* renamed from: z8$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ b9 c;
        public final /* synthetic */ Object d;

        public a(z8 z8Var, b9 b9Var, Object obj) {
            this.c = b9Var;
            this.d = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.c.accept(this.d);
        }
    }

    public z8(Handler handler, Callable<T> callable, b9<T> b9Var) {
        this.c = callable;
        this.d = b9Var;
        this.e = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T t;
        try {
            t = this.c.call();
        } catch (Exception unused) {
            t = null;
        }
        this.e.post(new a(this, this.d, t));
    }
}
