package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* compiled from: Executors.java */
/* renamed from: nq  reason: default package */
/* loaded from: classes.dex */
public final class nq {
    public static final Executor a = new a();
    public static final Executor b = new b();

    /* compiled from: Executors.java */
    /* renamed from: nq$a */
    /* loaded from: classes.dex */
    public class a implements Executor {
        public final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* compiled from: Executors.java */
    /* renamed from: nq$b */
    /* loaded from: classes.dex */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
}
