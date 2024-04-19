package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* compiled from: ThreadUtils.java */
/* renamed from: jb0  reason: default package */
/* loaded from: classes.dex */
public class jb0 {
    public static ConcurrentHashMap<Object, c> a;
    public static Handler b;
    public static volatile HandlerThread c;
    public static Handler d;
    public static volatile HandlerThread e;
    public static Handler f;

    /* compiled from: ThreadUtils.java */
    /* renamed from: jb0$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ Runnable c;
        public final /* synthetic */ Runnable d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Looper f;

        public a(Runnable runnable, Runnable runnable2, boolean z, Looper looper) {
            this.c = runnable;
            this.d = runnable2;
            this.e = z;
            this.f = looper;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.d != null) {
                if (!this.e && this.f != jb0.b.getLooper()) {
                    new Handler(this.f).post(this.d);
                } else {
                    jb0.b.post(this.d);
                }
            }
            StringBuilder a = jg.a("remove task: ");
            a.append(this.c);
            gb0.a("ThreadUtils", a.toString());
            jb0.a.remove(this.c);
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: jb0$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Looper e;
        public final /* synthetic */ Handler f;
        public final /* synthetic */ Runnable g;

        /* compiled from: ThreadUtils.java */
        /* renamed from: jb0$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c.run();
                b bVar = b.this;
                bVar.f.post(bVar.g);
            }
        }

        /* compiled from: ThreadUtils.java */
        /* renamed from: jb0$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0008b implements Runnable {
            public RunnableC0008b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c.run();
                b bVar = b.this;
                bVar.f.post(bVar.g);
            }
        }

        public b(Runnable runnable, boolean z, Looper looper, Handler handler, Runnable runnable2) {
            this.c = runnable;
            this.d = z;
            this.e = looper;
            this.f = handler;
            this.g = runnable2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c != null) {
                if (!this.d && this.e != jb0.b.getLooper()) {
                    new Handler(this.e).post(new RunnableC0008b());
                    return;
                } else {
                    jb0.b.post(new a());
                    return;
                }
            }
            this.g.run();
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: jb0$c */
    /* loaded from: classes.dex */
    public static class c {
        public Runnable a;
        public Integer b;

        public c(Runnable runnable, Integer num) {
            this.a = runnable;
            this.b = num;
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: jb0$d */
    /* loaded from: classes.dex */
    public static class d {
        public boolean a = false;
        public ThreadFactory b;
        public String c;

        public /* synthetic */ d(ib0 ib0Var) {
        }
    }

    static {
        d dVar = new d(null);
        dVar.c = "order-%d";
        dVar.a = false;
        Executors.newFixedThreadPool(4, new kb0(dVar));
        a = new ConcurrentHashMap<>();
    }

    public static Looper a(int i) {
        if (i == 0) {
            a();
            return c.getLooper();
        } else if (i == 1) {
            b();
            return b.getLooper();
        } else if (i == 2) {
            c();
            return f.getLooper();
        } else {
            throw new IllegalArgumentException(jg.a("invalid threadType:", i));
        }
    }

    public static void b(Runnable runnable) {
        c remove;
        Runnable runnable2;
        Handler handler;
        if (runnable == null || (remove = a.remove(runnable)) == null || (runnable2 = remove.a) == null) {
            return;
        }
        int intValue = remove.b.intValue();
        if (intValue == 0) {
            Handler handler2 = d;
            if (handler2 != null) {
                handler2.removeCallbacks(runnable2);
            }
        } else if (intValue != 1) {
            if (intValue == 2 && (handler = f) != null) {
                handler.removeCallbacks(runnable2);
            }
        } else {
            Handler handler3 = b;
            if (handler3 != null) {
                handler3.removeCallbacks(runnable2);
            }
        }
    }

    public static synchronized void c() {
        synchronized (jb0.class) {
            if (e == null) {
                e = new HandlerThread("NormalHandler", 0);
                e.start();
                f = new Handler(e.getLooper());
            }
        }
    }

    public static void a(int i, Runnable runnable) {
        a(i, null, runnable, null, false, 0L);
    }

    public static void a(int i, Runnable runnable, long j) {
        a(i, null, runnable, null, false, j);
    }

    public static void a(Runnable runnable) {
        a(0, null, runnable, null, false, 0L);
    }

    public static synchronized void b() {
        synchronized (jb0.class) {
            if (b == null) {
                b = new Handler(Looper.getMainLooper());
            }
        }
    }

    public static void a(int i, Runnable runnable, Runnable runnable2, Runnable runnable3, boolean z, long j) {
        Handler handler;
        if (runnable2 == null) {
            return;
        }
        if (b == null) {
            b();
        }
        if (i == 0) {
            if (c == null) {
                a();
            }
            handler = d;
        } else if (i == 1) {
            handler = b;
        } else if (i != 2) {
            handler = b;
        } else {
            if (e == null) {
                c();
            }
            handler = f;
        }
        if (handler == null) {
            handler = b;
        }
        Looper looper = null;
        if (!z && (looper = Looper.myLooper()) == null) {
            looper = b.getLooper();
        }
        Looper looper2 = looper;
        a aVar = new a(runnable2, runnable3, z, looper2);
        b bVar = new b(runnable, z, looper2, handler, aVar);
        if (runnable == null) {
            a.put(runnable2, new c(bVar, Integer.valueOf(i)));
        } else {
            a.put(runnable2, new c(aVar, Integer.valueOf(i)));
        }
        gb0.a("ThreadUtils", "put task: " + runnable2);
        handler.postDelayed(bVar, j);
    }

    public static synchronized void a() {
        synchronized (jb0.class) {
            if (c == null) {
                c = new HandlerThread("BackgroundHandler", 10);
                c.start();
                d = new Handler(c.getLooper());
            }
        }
    }
}
