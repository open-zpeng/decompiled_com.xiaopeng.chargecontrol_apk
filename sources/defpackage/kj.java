package defpackage;

import android.util.Log;
import com.xiaopeng.lib.framework.configuration.BuildConfig;
import defpackage.hj;
import defpackage.ok;
import defpackage.pj;
import defpackage.tq;
import defpackage.wk;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: Engine.java */
/* renamed from: kj  reason: default package */
/* loaded from: classes.dex */
public class kj implements mj, wk.a, pj.a {
    public static final boolean i = Log.isLoggable("Engine", 2);
    public final sj a;
    public final oj b;
    public final wk c;
    public final b d;
    public final yj e;
    public final c f;
    public final a g;
    public final zi h;

    /* compiled from: Engine.java */
    /* renamed from: kj$a */
    /* loaded from: classes.dex */
    public static class a {
        public final hj.d a;
        public final c9<hj<?>> b = tq.a(BuildConfig.VERSION_CODE, new C0009a());
        public int c;

        /* compiled from: Engine.java */
        /* renamed from: kj$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0009a implements tq.b<hj<?>> {
            public C0009a() {
            }

            @Override // defpackage.tq.b
            public hj<?> a() {
                a aVar = a.this;
                return new hj<>(aVar.a, aVar.b);
            }
        }

        public a(hj.d dVar) {
            this.a = dVar;
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: kj$b */
    /* loaded from: classes.dex */
    public static class b {
        public final zk a;
        public final zk b;
        public final zk c;
        public final zk d;
        public final mj e;
        public final pj.a f;
        public final c9<lj<?>> g = tq.a(BuildConfig.VERSION_CODE, new a());

        /* compiled from: Engine.java */
        /* renamed from: kj$b$a */
        /* loaded from: classes.dex */
        public class a implements tq.b<lj<?>> {
            public a() {
            }

            @Override // defpackage.tq.b
            public lj<?> a() {
                b bVar = b.this;
                return new lj<>(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        public b(zk zkVar, zk zkVar2, zk zkVar3, zk zkVar4, mj mjVar, pj.a aVar) {
            this.a = zkVar;
            this.b = zkVar2;
            this.c = zkVar3;
            this.d = zkVar4;
            this.e = mjVar;
            this.f = aVar;
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: kj$c */
    /* loaded from: classes.dex */
    public static class c implements hj.d {
        public final ok.a a;
        public volatile ok b;

        public c(ok.a aVar) {
            this.a = aVar;
        }

        public ok a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        rk rkVar = (rk) this.a;
                        tk tkVar = (tk) rkVar.b;
                        File cacheDir = tkVar.a.getCacheDir();
                        sk skVar = null;
                        if (cacheDir == null) {
                            cacheDir = null;
                        } else {
                            String str = tkVar.b;
                            if (str != null) {
                                cacheDir = new File(cacheDir, str);
                            }
                        }
                        if (cacheDir != null && (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory()))) {
                            skVar = new sk(cacheDir, rkVar.a);
                        }
                        this.b = skVar;
                    }
                    if (this.b == null) {
                        this.b = new pk();
                    }
                }
            }
            return this.b;
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: kj$d */
    /* loaded from: classes.dex */
    public class d {
        public final lj<?> a;
        public final rp b;

        public d(rp rpVar, lj<?> ljVar) {
            this.b = rpVar;
            this.a = ljVar;
        }

        public void a() {
            synchronized (kj.this) {
                this.a.c(this.b);
            }
        }
    }

    public kj(wk wkVar, ok.a aVar, zk zkVar, zk zkVar2, zk zkVar3, zk zkVar4, boolean z) {
        this.c = wkVar;
        this.f = new c(aVar);
        zi ziVar = new zi(z);
        this.h = ziVar;
        ziVar.a(this);
        this.b = new oj();
        this.a = new sj();
        this.d = new b(zkVar, zkVar2, zkVar3, zkVar4, this, this);
        this.g = new a(this.f);
        this.e = new yj();
        ((vk) wkVar).d = this;
    }

    public synchronized void a(lj<?> ljVar, zh zhVar, pj<?> pjVar) {
        if (pjVar != null) {
            if (pjVar.c) {
                this.h.a(zhVar, pjVar);
            }
        }
        this.a.b(zhVar, ljVar);
    }

    public <R> d a(ng ngVar, Object obj, zh zhVar, int i2, int i3, Class<?> cls, Class<R> cls2, qg qgVar, jj jjVar, Map<Class<?>, fi<?>> map, boolean z, boolean z2, bi biVar, boolean z3, boolean z4, boolean z5, boolean z6, rp rpVar, Executor executor) {
        long a2 = i ? oq.a() : 0L;
        nj a3 = this.b.a(obj, zhVar, i2, i3, map, cls, cls2, biVar);
        synchronized (this) {
            pj<?> a4 = a(a3, z3, a2);
            if (a4 == null) {
                return a(ngVar, obj, zhVar, i2, i3, cls, cls2, qgVar, jjVar, map, z, z2, biVar, z3, z4, z5, z6, rpVar, executor, a3, a2);
            }
            ((sp) rpVar).a(a4, uh.MEMORY_CACHE);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d a(ng ngVar, Object obj, zh zhVar, int i2, int i3, Class<?> cls, Class<R> cls2, qg qgVar, jj jjVar, Map<Class<?>, fi<?>> map, boolean z, boolean z2, bi biVar, boolean z3, boolean z4, boolean z5, boolean z6, rp rpVar, Executor executor, nj njVar, long j) {
        sj sjVar = this.a;
        lj<?> ljVar = (z6 ? sjVar.b : sjVar.a).get(njVar);
        if (ljVar != null) {
            ljVar.a(rpVar, executor);
            if (i) {
                a("Added to existing load", j, njVar);
            }
            return new d(rpVar, ljVar);
        }
        lj<?> a2 = this.d.g.a();
        defpackage.a.a(a2, "Argument must not be null");
        a2.a(njVar, z3, z4, z5, z6);
        a aVar = this.g;
        hj<?> a3 = aVar.b.a();
        defpackage.a.a(a3, "Argument must not be null");
        int i4 = aVar.c;
        aVar.c = i4 + 1;
        gj<?> gjVar = a3.c;
        hj.d dVar = a3.f;
        gjVar.c = ngVar;
        gjVar.d = obj;
        gjVar.n = zhVar;
        gjVar.e = i2;
        gjVar.f = i3;
        gjVar.p = jjVar;
        gjVar.g = cls;
        gjVar.h = dVar;
        gjVar.k = cls2;
        gjVar.o = qgVar;
        gjVar.i = biVar;
        gjVar.j = map;
        gjVar.q = z;
        gjVar.r = z2;
        a3.j = ngVar;
        a3.k = zhVar;
        a3.l = qgVar;
        a3.m = njVar;
        a3.n = i2;
        a3.o = i3;
        a3.p = jjVar;
        a3.w = z6;
        a3.q = biVar;
        a3.r = a2;
        a3.s = i4;
        a3.u = hj.f.INITIALIZE;
        a3.x = obj;
        this.a.a(njVar, a2);
        a2.a(rpVar, executor);
        a2.a(a3);
        if (i) {
            a("Started new load", j, njVar);
        }
        return new d(rpVar, a2);
    }

    public static void a(String str, long j, zh zhVar) {
        Log.v("Engine", str + " in " + oq.a(j) + "ms, key: " + zhVar);
    }

    public final pj<?> a(nj njVar, boolean z, long j) {
        pj<?> pjVar;
        if (z) {
            pj<?> b2 = this.h.b(njVar);
            if (b2 != null) {
                b2.e();
            }
            if (b2 != null) {
                if (i) {
                    a("Loaded resource from active resources", j, njVar);
                }
                return b2;
            }
            vj a2 = ((vk) this.c).a((zh) njVar);
            if (a2 == null) {
                pjVar = null;
            } else if (a2 instanceof pj) {
                pjVar = (pj) a2;
            } else {
                pjVar = new pj<>(a2, true, true, njVar, this);
            }
            if (pjVar != null) {
                pjVar.e();
                this.h.a(njVar, pjVar);
            }
            if (pjVar != null) {
                if (i) {
                    a("Loaded resource from cache", j, njVar);
                }
                return pjVar;
            }
            return null;
        }
        return null;
    }

    public void a(vj<?> vjVar) {
        if (vjVar instanceof pj) {
            ((pj) vjVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public synchronized void a(lj<?> ljVar, zh zhVar) {
        this.a.b(zhVar, ljVar);
    }

    public void a(zh zhVar, pj<?> pjVar) {
        this.h.a(zhVar);
        if (pjVar.c) {
            ((vk) this.c).a2(zhVar, (vj) pjVar);
        } else {
            this.e.a(pjVar, false);
        }
    }
}
