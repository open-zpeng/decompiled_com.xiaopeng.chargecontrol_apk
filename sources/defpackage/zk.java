package defpackage;

import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: GlideExecutor.java */
/* renamed from: zk  reason: default package */
/* loaded from: classes.dex */
public final class zk implements ExecutorService {
    public static final long b = TimeUnit.SECONDS.toMillis(10);
    public static volatile int c;
    public final ExecutorService a;

    /* compiled from: GlideExecutor.java */
    /* renamed from: zk$a */
    /* loaded from: classes.dex */
    public static final class a implements ThreadFactory {
        public final String c;
        public final b d;
        public final boolean e;
        public int f;

        /* compiled from: GlideExecutor.java */
        /* renamed from: zk$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0016a extends Thread {
            public C0016a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (a.this.e) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    a.this.d.a(th);
                }
            }
        }

        public a(String str, b bVar, boolean z) {
            this.c = str;
            this.d = bVar;
            this.e = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            C0016a c0016a;
            c0016a = new C0016a(runnable, "glide-" + this.c + "-thread-" + this.f);
            this.f = this.f + 1;
            return c0016a;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: zk$b */
    /* loaded from: classes.dex */
    public interface b {
        public static final b a = new a();
        public static final b b = a;

        /* compiled from: GlideExecutor.java */
        /* renamed from: zk$b$a */
        /* loaded from: classes.dex */
        public class a implements b {
            @Override // defpackage.zk.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        void a(Throwable th);
    }

    public zk(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        if (c == 0) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            int i = Build.VERSION.SDK_INT;
            c = Math.min(4, availableProcessors);
        }
        return c;
    }

    public static zk b() {
        b bVar = b.b;
        if (!TextUtils.isEmpty("disk-cache")) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("disk-cache", bVar, true));
            if (0 != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new zk(threadPoolExecutor);
        }
        throw new IllegalArgumentException(jg.a("Name must be non-null and non-empty, but given: ", "disk-cache"));
    }

    public static zk c() {
        b bVar = b.b;
        int a2 = a();
        if (!TextUtils.isEmpty("source")) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a2, a2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("source", bVar, false));
            if (0 != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new zk(threadPoolExecutor);
        }
        throw new IllegalArgumentException(jg.a("Name must be non-null and non-empty, but given: ", "source"));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(callable);
    }
}
