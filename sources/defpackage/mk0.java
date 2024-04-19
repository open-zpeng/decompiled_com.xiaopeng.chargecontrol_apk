package defpackage;

import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* renamed from: mk0  reason: default package */
/* loaded from: classes.dex */
public final class mk0 {
    public static final dh0 a;
    public static final dh0 b;

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static final dh0 a = new pj0();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$b */
    /* loaded from: classes.dex */
    public static final class b implements Callable<dh0> {
        @Override // java.util.concurrent.Callable
        public dh0 call() {
            return a.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$c */
    /* loaded from: classes.dex */
    public static final class c implements Callable<dh0> {
        @Override // java.util.concurrent.Callable
        public dh0 call() {
            return d.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$d */
    /* loaded from: classes.dex */
    public static final class d {
        public static final dh0 a = new rj0();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$e */
    /* loaded from: classes.dex */
    public static final class e {
        public static final dh0 a = new sj0();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$f */
    /* loaded from: classes.dex */
    public static final class f implements Callable<dh0> {
        @Override // java.util.concurrent.Callable
        public dh0 call() {
            return e.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$g */
    /* loaded from: classes.dex */
    public static final class g {
        public static final dh0 a = new bk0();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: mk0$h */
    /* loaded from: classes.dex */
    public static final class h implements Callable<dh0> {
        @Override // java.util.concurrent.Callable
        public dh0 call() {
            return g.a;
        }
    }

    static {
        dh0 a2;
        dh0 a3;
        h hVar = new h();
        ai0.a(hVar, "Scheduler Callable can't be null");
        sh0<? super Callable<dh0>, ? extends dh0> sh0Var = z90.j;
        if (sh0Var == null) {
            z90.a(hVar);
        } else {
            z90.a(sh0Var, (Callable<dh0>) hVar);
        }
        b bVar = new b();
        ai0.a(bVar, "Scheduler Callable can't be null");
        sh0<? super Callable<dh0>, ? extends dh0> sh0Var2 = z90.i;
        if (sh0Var2 == null) {
            a2 = z90.a(bVar);
        } else {
            a2 = z90.a(sh0Var2, (Callable<dh0>) bVar);
        }
        a = a2;
        c cVar = new c();
        ai0.a(cVar, "Scheduler Callable can't be null");
        sh0<? super Callable<dh0>, ? extends dh0> sh0Var3 = z90.k;
        if (sh0Var3 == null) {
            a3 = z90.a(cVar);
        } else {
            a3 = z90.a(sh0Var3, (Callable<dh0>) cVar);
        }
        b = a3;
        ck0 ck0Var = ck0.b;
        f fVar = new f();
        ai0.a(fVar, "Scheduler Callable can't be null");
        sh0<? super Callable<dh0>, ? extends dh0> sh0Var4 = z90.l;
        if (sh0Var4 == null) {
            z90.a(fVar);
        } else {
            z90.a(sh0Var4, (Callable<dh0>) fVar);
        }
    }

    public static dh0 a() {
        dh0 dh0Var = a;
        sh0<? super dh0, ? extends dh0> sh0Var = z90.m;
        return sh0Var == null ? dh0Var : (dh0) z90.b(sh0Var, dh0Var);
    }

    public static dh0 b() {
        dh0 dh0Var = b;
        sh0<? super dh0, ? extends dh0> sh0Var = z90.n;
        return sh0Var == null ? dh0Var : (dh0) z90.b(sh0Var, dh0Var);
    }
}
