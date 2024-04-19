package defpackage;

import java.util.Comparator;
import java.util.concurrent.Callable;
/* compiled from: Functions.java */
/* renamed from: zh0  reason: default package */
/* loaded from: classes.dex */
public final class zh0 {
    public static final Runnable a = new c();
    public static final qh0 b = new a();
    public static final rh0<Object> c = new b();
    public static final rh0<Throwable> d = new f();

    /* compiled from: Functions.java */
    /* renamed from: zh0$a */
    /* loaded from: classes.dex */
    public static final class a implements qh0 {
        public void a() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: zh0$b */
    /* loaded from: classes.dex */
    public static final class b implements rh0<Object> {
        @Override // defpackage.rh0
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: zh0$c */
    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: zh0$d */
    /* loaded from: classes.dex */
    public static final class d implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: zh0$e */
    /* loaded from: classes.dex */
    public static final class e implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: zh0$f */
    /* loaded from: classes.dex */
    public static final class f implements rh0<Throwable> {
        @Override // defpackage.rh0
        public void accept(Throwable th) {
            z90.a(new nh0(th));
        }
    }
}
