package defpackage;

import defpackage.jb0;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ThreadUtils.java */
/* renamed from: kb0  reason: default package */
/* loaded from: classes.dex */
public class kb0 implements ThreadFactory {
    public final /* synthetic */ jb0.d c;

    public kb0(jb0.d dVar) {
        this.c = dVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadFactory threadFactory = this.c.b;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        Thread newThread = threadFactory.newThread(runnable);
        AtomicLong atomicLong = this.c.c != null ? new AtomicLong(0L) : null;
        String str = this.c.c;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(atomicLong.getAndIncrement())));
        }
        newThread.setDaemon(this.c.a);
        return newThread;
    }
}
