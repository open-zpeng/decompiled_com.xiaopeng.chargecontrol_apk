package defpackage;

import android.os.Build;
import android.util.Log;
import defpackage.fj;
import defpackage.ij;
import defpackage.kj;
import defpackage.nl;
import defpackage.sg;
import defpackage.tq;
import defpackage.wq;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DecodeJob.java */
/* renamed from: hj  reason: default package */
/* loaded from: classes.dex */
public class hj<R> implements fj.a, Runnable, Comparable<hj<?>>, tq.d {
    public zh A;
    public Object B;
    public uh C;
    public ji<?> D;
    public volatile fj E;
    public volatile boolean F;
    public volatile boolean G;
    public final d f;
    public final c9<hj<?>> g;
    public ng j;
    public zh k;
    public qg l;
    public nj m;
    public int n;
    public int o;
    public jj p;
    public bi q;
    public a<R> r;
    public int s;
    public g t;
    public f u;
    public long v;
    public boolean w;
    public Object x;
    public Thread y;
    public zh z;
    public final gj<R> c = new gj<>();
    public final List<Throwable> d = new ArrayList();
    public final wq e = new wq.b();
    public final c<?> h = new c<>();
    public final e i = new e();

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$a */
    /* loaded from: classes.dex */
    public interface a<R> {
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$b */
    /* loaded from: classes.dex */
    public final class b<Z> implements ij.a<Z> {
        public final uh a;

        public b(uh uhVar) {
            this.a = uhVar;
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$d */
    /* loaded from: classes.dex */
    public interface d {
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$f */
    /* loaded from: classes.dex */
    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$g */
    /* loaded from: classes.dex */
    public enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public hj(d dVar, c9<hj<?>> c9Var) {
        this.f = dVar;
        this.g = c9Var;
    }

    public final g a(g gVar) {
        int ordinal = gVar.ordinal();
        if (ordinal == 0) {
            if (this.p.b()) {
                return g.RESOURCE_CACHE;
            }
            return a(g.RESOURCE_CACHE);
        } else if (ordinal == 1) {
            if (this.p.a()) {
                return g.DATA_CACHE;
            }
            return a(g.DATA_CACHE);
        } else if (ordinal == 2) {
            return this.w ? g.FINISHED : g.SOURCE;
        } else if (ordinal != 3 && ordinal != 5) {
            throw new IllegalArgumentException("Unrecognized stage: " + gVar);
        } else {
            return g.FINISHED;
        }
    }

    @Override // defpackage.fj.a
    public void b() {
        this.u = f.SWITCH_TO_SOURCE_SERVICE;
        ((lj) this.r).b().a.execute(this);
    }

    public final fj c() {
        int ordinal = this.t.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                gj<R> gjVar = this.c;
                return new cj(gjVar.a(), gjVar, this);
            } else if (ordinal != 3) {
                if (ordinal == 5) {
                    return null;
                }
                StringBuilder a2 = jg.a("Unrecognized stage: ");
                a2.append(this.t);
                throw new IllegalStateException(a2.toString());
            } else {
                return new ak(this.c, this);
            }
        }
        return new wj(this.c, this);
    }

    @Override // java.lang.Comparable
    public int compareTo(hj<?> hjVar) {
        hj<?> hjVar2 = hjVar;
        int d2 = d() - hjVar2.d();
        return d2 == 0 ? this.s - hjVar2.s : d2;
    }

    public final int d() {
        return this.l.ordinal();
    }

    @Override // defpackage.tq.d
    public wq e() {
        return this.e;
    }

    public final void f() {
        j();
        ((lj) this.r).a(new qj("Failed to load resource", new ArrayList(this.d)));
        if (this.i.b()) {
            g();
        }
    }

    public final void g() {
        this.i.c();
        c<?> cVar = this.h;
        cVar.a = null;
        cVar.b = null;
        cVar.c = null;
        gj<R> gjVar = this.c;
        gjVar.c = null;
        gjVar.d = null;
        gjVar.n = null;
        gjVar.g = null;
        gjVar.k = null;
        gjVar.i = null;
        gjVar.o = null;
        gjVar.j = null;
        gjVar.p = null;
        gjVar.a.clear();
        gjVar.l = false;
        gjVar.b.clear();
        gjVar.m = false;
        this.F = false;
        this.j = null;
        this.k = null;
        this.q = null;
        this.l = null;
        this.m = null;
        this.r = null;
        this.t = null;
        this.E = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.v = 0L;
        this.G = false;
        this.x = null;
        this.d.clear();
        this.g.a(this);
    }

    public final void h() {
        this.y = Thread.currentThread();
        this.v = oq.a();
        boolean z = false;
        while (!this.G && this.E != null && !(z = this.E.a())) {
            this.t = a(this.t);
            this.E = c();
            if (this.t == g.SOURCE) {
                b();
                return;
            }
        }
        if ((this.t == g.FINISHED || this.G) && !z) {
            f();
        }
    }

    public final void i() {
        int ordinal = this.u.ordinal();
        if (ordinal == 0) {
            this.t = a(g.INITIALIZE);
            this.E = c();
            h();
        } else if (ordinal == 1) {
            h();
        } else if (ordinal == 2) {
            a();
        } else {
            StringBuilder a2 = jg.a("Unrecognized run reason: ");
            a2.append(this.u);
            throw new IllegalStateException(a2.toString());
        }
    }

    public final void j() {
        Throwable th;
        this.e.a();
        if (this.F) {
            if (this.d.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.d;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.F = true;
    }

    public boolean k() {
        g a2 = a(g.INITIALIZE);
        return a2 == g.RESOURCE_CACHE || a2 == g.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        ji<?> jiVar = this.D;
        try {
            try {
                if (this.G) {
                    f();
                    if (jiVar != null) {
                        return;
                    }
                    return;
                }
                i();
                if (jiVar != null) {
                    jiVar.b();
                }
            } finally {
                if (jiVar != null) {
                    jiVar.b();
                }
            }
        } catch (bj e2) {
            throw e2;
        } catch (Throwable th) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.G + ", stage: " + this.t, th);
            }
            if (this.t != g.ENCODE) {
                this.d.add(th);
                f();
            }
            if (!this.G) {
                throw th;
            }
            throw th;
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$e */
    /* loaded from: classes.dex */
    public static class e {
        public boolean a;
        public boolean b;
        public boolean c;

        public synchronized boolean a() {
            this.b = true;
            return a(false);
        }

        public synchronized boolean b(boolean z) {
            this.a = true;
            return a(z);
        }

        public synchronized void c() {
            this.b = false;
            this.a = false;
            this.c = false;
        }

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }

        public synchronized boolean b() {
            this.c = true;
            return a(false);
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: hj$c */
    /* loaded from: classes.dex */
    public static class c<Z> {
        public zh a;
        public ei<Z> b;
        public uj<Z> c;

        public void a(d dVar, bi biVar) {
            try {
                ((kj.c) dVar).a().a(this.a, new ej(this.b, this.c, biVar));
            } finally {
                this.c.f();
            }
        }

        public boolean a() {
            return this.c != null;
        }
    }

    @Override // defpackage.fj.a
    public void a(zh zhVar, Object obj, ji<?> jiVar, uh uhVar, zh zhVar2) {
        zk zkVar;
        this.z = zhVar;
        this.B = obj;
        this.D = jiVar;
        this.C = uhVar;
        this.A = zhVar2;
        if (Thread.currentThread() != this.y) {
            this.u = f.DECODE_DATA;
            lj ljVar = (lj) this.r;
            if (ljVar.p) {
                zkVar = ljVar.k;
            } else {
                zkVar = ljVar.q ? ljVar.l : ljVar.j;
            }
            zkVar.a.execute(this);
            return;
        }
        a();
    }

    @Override // defpackage.fj.a
    public void a(zh zhVar, Exception exc, ji<?> jiVar, uh uhVar) {
        zk zkVar;
        jiVar.b();
        qj qjVar = new qj("Fetching data failed", exc);
        Class<?> a2 = jiVar.a();
        qjVar.d = zhVar;
        qjVar.e = uhVar;
        qjVar.f = a2;
        this.d.add(qjVar);
        if (Thread.currentThread() != this.y) {
            this.u = f.SWITCH_TO_SOURCE_SERVICE;
            lj ljVar = (lj) this.r;
            if (ljVar.p) {
                zkVar = ljVar.k;
            } else {
                zkVar = ljVar.q ? ljVar.l : ljVar.j;
            }
            zkVar.a.execute(this);
            return;
        }
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        vj<R> vjVar;
        uj ujVar;
        vj<R> vjVar2;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.v;
            StringBuilder a2 = jg.a("data: ");
            a2.append(this.B);
            a2.append(", cache key: ");
            a2.append(this.z);
            a2.append(", fetcher: ");
            a2.append(this.D);
            a("Retrieved data", j, a2.toString());
        }
        try {
            vjVar = a(this.D, (ji<?>) this.B, this.C);
        } catch (qj e2) {
            e2.a(this.A, this.C, null);
            this.d.add(e2);
            vjVar = null;
        }
        if (vjVar != null) {
            uh uhVar = this.C;
            if (vjVar instanceof rj) {
                ((rj) vjVar).e();
            }
            if (this.h.a()) {
                vjVar2 = uj.a(vjVar);
                ujVar = vjVar2;
            } else {
                vj<R> vjVar3 = vjVar;
                ujVar = 0;
                vjVar2 = vjVar3;
            }
            j();
            ((lj) this.r).a(vjVar2, uhVar);
            this.t = g.ENCODE;
            try {
                if (this.h.a()) {
                    this.h.a(this.f, this.q);
                }
                if (this.i.a()) {
                    g();
                    return;
                }
                return;
            } finally {
                if (ujVar != 0) {
                    ujVar.f();
                }
            }
        }
        h();
    }

    public final <Data> vj<R> a(ji<?> jiVar, Data data, uh uhVar) {
        if (data == null) {
            return null;
        }
        try {
            long a2 = oq.a();
            vj<R> a3 = a((hj<R>) data, uhVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2, (String) null);
            }
            return a3;
        } finally {
            jiVar.b();
        }
    }

    public final <Data> vj<R> a(Data data, uh uhVar) {
        tj<Data, ?, R> a2 = this.c.a(data.getClass());
        bi biVar = this.q;
        int i = Build.VERSION.SDK_INT;
        boolean z = uhVar == uh.RESOURCE_DISK_CACHE || this.c.r;
        Boolean bool = (Boolean) biVar.a(sm.j);
        if (bool == null || (bool.booleanValue() && !z)) {
            biVar = new bi();
            biVar.a(this.q);
            biVar.a(sm.j, Boolean.valueOf(z));
        }
        bi biVar2 = biVar;
        ki<Data> a3 = this.j.b.e.a((li) data);
        try {
            return a2.a(a3, biVar2, this.n, this.o, new b(uhVar));
        } finally {
            a3.b();
        }
    }

    public final void a(String str, long j, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(oq.a(j));
        sb.append(", load key: ");
        sb.append(this.m);
        sb.append(str2 != null ? jg.a(", ", str2) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    public <Z> vj<Z> a(uh uhVar, vj<Z> vjVar) {
        vj<Z> vjVar2;
        fi<Z> fiVar;
        wh whVar;
        zh djVar;
        Class<?> cls = vjVar.a().getClass();
        ei<Z> eiVar = null;
        if (uhVar != uh.RESOURCE_DISK_CACHE) {
            fi<Z> b2 = this.c.b(cls);
            fiVar = b2;
            vjVar2 = b2.a(this.j, vjVar, this.n, this.o);
        } else {
            vjVar2 = vjVar;
            fiVar = null;
        }
        if (!vjVar.equals(vjVar2)) {
            vjVar.d();
        }
        boolean z = false;
        if (this.c.c.b.d.a(vjVar2.c()) != null) {
            eiVar = this.c.c.b.d.a(vjVar2.c());
            if (eiVar != null) {
                whVar = eiVar.a(this.q);
            } else {
                throw new sg.d(vjVar2.c());
            }
        } else {
            whVar = wh.NONE;
        }
        ei<Z> eiVar2 = eiVar;
        wh whVar2 = whVar;
        gj<R> gjVar = this.c;
        zh zhVar = this.z;
        List<nl.a<?>> c2 = gjVar.c();
        int size = c2.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (c2.get(i).a.equals(zhVar)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (this.p.a(!z, uhVar, whVar2)) {
            if (eiVar2 != null) {
                int ordinal = whVar2.ordinal();
                if (ordinal == 0) {
                    djVar = new dj(this.z, this.k);
                } else if (ordinal == 1) {
                    djVar = new xj(this.c.c.a, this.z, this.k, this.n, this.o, fiVar, cls, this.q);
                } else {
                    throw new IllegalArgumentException("Unknown strategy: " + whVar2);
                }
                uj<Z> a2 = uj.a(vjVar2);
                c<?> cVar = this.h;
                cVar.a = djVar;
                cVar.b = eiVar2;
                cVar.c = a2;
                return a2;
            }
            throw new sg.d(vjVar2.a().getClass());
        }
        return vjVar2;
    }
}
