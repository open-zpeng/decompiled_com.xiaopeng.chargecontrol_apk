package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: ScheduledRunnable.java */
/* renamed from: yj0  reason: default package */
/* loaded from: classes.dex */
public final class yj0 extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, kh0 {
    public static final Object d = new Object();
    public static final Object e = new Object();
    public static final Object f = new Object();
    public static final Object g = new Object();
    public final Runnable c;

    public yj0(Runnable runnable, uh0 uh0Var) {
        super(3);
        this.c = runnable;
        lazySet(0, uh0Var);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == g) {
                return;
            }
            if (obj == e) {
                future.cancel(false);
                return;
            } else if (obj == f) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // defpackage.kh0
    public boolean b() {
        Object obj = get(0);
        return obj == d || obj == g;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.c.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != d) {
                    ((uh0) obj4).a(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != e) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj5, g));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != d && compareAndSet(0, obj4, g) && obj4 != null) {
            ((uh0) obj4).a(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != e || obj5 == f) {
                return;
            }
        } while (!compareAndSet(1, obj5, g));
    }

    @Override // defpackage.kh0
    public void a() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = get(1);
            if (obj3 == g || obj3 == e || obj3 == f) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj3, z ? f : e)) {
                if (obj3 != null) {
                    ((Future) obj3).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == g || obj == (obj2 = d) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((uh0) obj).a(this);
    }
}
