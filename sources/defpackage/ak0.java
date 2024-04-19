package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SchedulerPoolFactory.java */
/* renamed from: ak0  reason: default package */
/* loaded from: classes.dex */
public final class ak0 {
    public static final boolean a;
    public static final int b;
    public static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: ak0$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(ak0.d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    ak0.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[LOOP:0: B:19:0x003b->B:25:0x0068, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            defpackage.ak0.c = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            defpackage.ak0.d = r0
            java.lang.String r0 = "rx2.purge-enabled"
            r1 = 1
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L18
            goto L1f
        L18:
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L1f
            goto L20
        L1f:
            r0 = r1
        L20:
            defpackage.ak0.a = r0
            boolean r0 = defpackage.ak0.a
            java.lang.String r2 = "rx2.purge-period-seconds"
            if (r0 == 0) goto L34
            java.lang.String r0 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L34
            if (r0 != 0) goto L2f
            goto L34
        L2f:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L34
            goto L35
        L34:
            r0 = r1
        L35:
            defpackage.ak0.b = r0
            boolean r0 = defpackage.ak0.a
            if (r0 == 0) goto L6c
        L3b:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> r0 = defpackage.ak0.c
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ScheduledExecutorService r0 = (java.util.concurrent.ScheduledExecutorService) r0
            if (r0 == 0) goto L46
            goto L6c
        L46:
            vj0 r2 = new vj0
            java.lang.String r3 = "RxSchedulerPurge"
            r2.<init>(r3)
            java.util.concurrent.ScheduledExecutorService r4 = java.util.concurrent.Executors.newScheduledThreadPool(r1, r2)
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> r2 = defpackage.ak0.c
            boolean r0 = r2.compareAndSet(r0, r4)
            if (r0 == 0) goto L68
            ak0$a r5 = new ak0$a
            r5.<init>()
            int r0 = defpackage.ak0.b
            long r8 = (long) r0
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS
            r6 = r8
            r4.scheduleAtFixedRate(r5, r6, r8, r10)
            goto L6c
        L68:
            r4.shutdownNow()
            goto L3b
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ak0.<clinit>():void");
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
