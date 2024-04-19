package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* renamed from: vj0  reason: default package */
/* loaded from: classes.dex */
public final class vj0 extends AtomicLong implements ThreadFactory {
    public final String c;
    public final int d;
    public final boolean e;

    /* compiled from: RxThreadFactory.java */
    /* renamed from: vj0$a */
    /* loaded from: classes.dex */
    public static final class a extends Thread implements uj0 {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public vj0(String str) {
        this.c = str;
        this.d = 5;
        this.e = false;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.c + '-' + incrementAndGet();
        Thread aVar = this.e ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.d);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return jg.a(jg.a("RxThreadFactory["), this.c, "]");
    }

    public vj0(String str, int i) {
        this.c = str;
        this.d = i;
        this.e = false;
    }

    public vj0(String str, int i, boolean z) {
        this.c = str;
        this.d = i;
        this.e = z;
    }
}
