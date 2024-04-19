package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultTaskExecutor.java */
/* renamed from: u4  reason: default package */
/* loaded from: classes.dex */
public class u4 extends v4 {
    public final Object a = new Object();
    public final ExecutorService b = Executors.newFixedThreadPool(4, new a(this));
    public volatile Handler c;

    /* compiled from: DefaultTaskExecutor.java */
    /* renamed from: u4$a */
    /* loaded from: classes.dex */
    public class a implements ThreadFactory {
        public final AtomicInteger c = new AtomicInteger(0);

        public a(u4 u4Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.c.getAndIncrement())));
            return thread;
        }
    }

    @Override // defpackage.v4
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // defpackage.v4
    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    Looper mainLooper = Looper.getMainLooper();
                    int i = Build.VERSION.SDK_INT;
                    this.c = Handler.createAsync(mainLooper);
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // defpackage.v4
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
