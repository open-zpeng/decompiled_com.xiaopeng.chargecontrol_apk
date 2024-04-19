package defpackage;

import android.os.Process;
import defpackage.pj;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* compiled from: ActiveResources.java */
/* renamed from: zi  reason: default package */
/* loaded from: classes.dex */
public final class zi {
    public final boolean a;
    public final Map<zh, b> b;
    public final ReferenceQueue<pj<?>> c;
    public pj.a d;
    public volatile boolean e;

    /* compiled from: ActiveResources.java */
    /* renamed from: zi$a */
    /* loaded from: classes.dex */
    public class a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: zi$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0015a implements Runnable {
            public final /* synthetic */ Runnable c;

            public RunnableC0015a(a aVar, Runnable runnable) {
                this.c = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.c.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0015a(this, runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    /* renamed from: zi$b */
    /* loaded from: classes.dex */
    public static final class b extends WeakReference<pj<?>> {
        public final zh a;
        public final boolean b;
        public vj<?> c;

        public b(zh zhVar, pj<?> pjVar, ReferenceQueue<? super pj<?>> referenceQueue, boolean z) {
            super(pjVar, referenceQueue);
            vj<?> vjVar;
            defpackage.a.a(zhVar, "Argument must not be null");
            this.a = zhVar;
            if (pjVar.c && z) {
                vjVar = pjVar.e;
                defpackage.a.a(vjVar, "Argument must not be null");
            } else {
                vjVar = null;
            }
            this.c = vjVar;
            this.b = pjVar.c;
        }
    }

    public zi(boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new a());
        this.b = new HashMap();
        this.c = new ReferenceQueue<>();
        this.a = z;
        newSingleThreadExecutor.execute(new aj(this));
    }

    public void a(pj.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.d = aVar;
            }
        }
    }

    public synchronized pj<?> b(zh zhVar) {
        b bVar = this.b.get(zhVar);
        if (bVar == null) {
            return null;
        }
        pj<?> pjVar = bVar.get();
        if (pjVar == null) {
            a(bVar);
        }
        return pjVar;
    }

    public synchronized void a(zh zhVar, pj<?> pjVar) {
        b put = this.b.put(zhVar, new b(zhVar, pjVar, this.c, this.a));
        if (put != null) {
            put.c = null;
            put.clear();
        }
    }

    public synchronized void a(zh zhVar) {
        b remove = this.b.remove(zhVar);
        if (remove != null) {
            remove.c = null;
            remove.clear();
        }
    }

    public void a(b bVar) {
        vj<?> vjVar;
        synchronized (this) {
            this.b.remove(bVar.a);
            if (bVar.b && (vjVar = bVar.c) != null) {
                ((kj) this.d).a(bVar.a, new pj<>(vjVar, true, false, bVar.a, this.d));
            }
        }
    }
}
