package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import defpackage.eq;
import defpackage.kj;
import defpackage.wq;
import java.util.List;
import java.util.concurrent.Executor;
/* compiled from: SingleRequest.java */
/* renamed from: sp  reason: default package */
/* loaded from: classes.dex */
public final class sp<R> implements np, bq, rp {
    public static final boolean D = Log.isLoggable("Request", 2);
    public int A;
    public boolean B;
    public RuntimeException C;
    public final String a;
    public final wq b;
    public final Object c;
    public final pp<R> d;
    public final op e;
    public final Context f;
    public final ng g;
    public final Object h;
    public final Class<R> i;
    public final lp<?> j;
    public final int k;
    public final int l;
    public final qg m;
    public final cq<R> n;
    public final List<pp<R>> o;
    public final gq<? super R> p;
    public final Executor q;
    public vj<R> r;
    public kj.d s;
    public long t;
    public volatile kj u;
    public a v;
    public Drawable w;
    public Drawable x;
    public Drawable y;
    public int z;

    /* compiled from: SingleRequest.java */
    /* renamed from: sp$a */
    /* loaded from: classes.dex */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public sp(Context context, ng ngVar, Object obj, Object obj2, Class<R> cls, lp<?> lpVar, int i, int i2, qg qgVar, cq<R> cqVar, pp<R> ppVar, List<pp<R>> list, op opVar, kj kjVar, gq<? super R> gqVar, Executor executor) {
        this.a = D ? String.valueOf(super.hashCode()) : null;
        this.b = new wq.b();
        this.c = obj;
        this.f = context;
        this.g = ngVar;
        this.h = obj2;
        this.i = cls;
        this.j = lpVar;
        this.k = i;
        this.l = i2;
        this.m = qgVar;
        this.n = cqVar;
        this.d = ppVar;
        this.o = list;
        this.e = opVar;
        this.u = kjVar;
        this.p = gqVar;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && ngVar.h) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // defpackage.np
    public boolean a() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @Override // defpackage.np
    public boolean b() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.CLEARED;
        }
        return z;
    }

    @Override // defpackage.np
    public void c() {
        synchronized (this.c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[Catch: all -> 0x005a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0011, B:8:0x0013, B:10:0x0025, B:11:0x002a, B:13:0x002e, B:15:0x0034, B:17:0x0038, B:23:0x0044, B:24:0x004d, B:25:0x0051), top: B:32:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.np
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void clear() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.c
            monitor-enter(r0)
            r4.f()     // Catch: java.lang.Throwable -> L5a
            wq r1 = r4.b     // Catch: java.lang.Throwable -> L5a
            r1.a()     // Catch: java.lang.Throwable -> L5a
            sp$a r1 = r4.v     // Catch: java.lang.Throwable -> L5a
            sp$a r2 = defpackage.sp.a.CLEARED     // Catch: java.lang.Throwable -> L5a
            if (r1 != r2) goto L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            return
        L13:
            r4.f()     // Catch: java.lang.Throwable -> L5a
            wq r1 = r4.b     // Catch: java.lang.Throwable -> L5a
            r1.a()     // Catch: java.lang.Throwable -> L5a
            cq<R> r1 = r4.n     // Catch: java.lang.Throwable -> L5a
            r1.a(r4)     // Catch: java.lang.Throwable -> L5a
            kj$d r1 = r4.s     // Catch: java.lang.Throwable -> L5a
            r2 = 0
            if (r1 == 0) goto L2a
            r1.a()     // Catch: java.lang.Throwable -> L5a
            r4.s = r2     // Catch: java.lang.Throwable -> L5a
        L2a:
            vj<R> r1 = r4.r     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L33
            vj<R> r1 = r4.r     // Catch: java.lang.Throwable -> L5a
            r4.r = r2     // Catch: java.lang.Throwable -> L5a
            goto L34
        L33:
            r1 = r2
        L34:
            op r2 = r4.e     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L41
            boolean r2 = r2.f(r4)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L3f
            goto L41
        L3f:
            r2 = 0
            goto L42
        L41:
            r2 = 1
        L42:
            if (r2 == 0) goto L4d
            cq<R> r2 = r4.n     // Catch: java.lang.Throwable -> L5a
            android.graphics.drawable.Drawable r3 = r4.h()     // Catch: java.lang.Throwable -> L5a
            r2.c(r3)     // Catch: java.lang.Throwable -> L5a
        L4d:
            sp$a r2 = defpackage.sp.a.CLEARED     // Catch: java.lang.Throwable -> L5a
            r4.v = r2     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L59
            kj r0 = r4.u
            r0.a(r1)
        L59:
            return
        L5a:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sp.clear():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0088 A[Catch: all -> 0x00b9, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0015, B:8:0x001f, B:9:0x0027, B:13:0x0030, B:14:0x003a, B:16:0x003c, B:18:0x0042, B:20:0x0048, B:21:0x004f, B:23:0x0051, B:25:0x005f, B:27:0x006c, B:29:0x0072, B:40:0x0091, B:42:0x0095, B:43:0x00af, B:31:0x0078, B:33:0x007c, B:39:0x0088, B:26:0x0067, B:45:0x00b1, B:46:0x00b8), top: B:50:0x0003 }] */
    @Override // defpackage.np
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.c
            monitor-enter(r0)
            r4.f()     // Catch: java.lang.Throwable -> Lb9
            wq r1 = r4.b     // Catch: java.lang.Throwable -> Lb9
            r1.a()     // Catch: java.lang.Throwable -> Lb9
            long r1 = defpackage.oq.a()     // Catch: java.lang.Throwable -> Lb9
            r4.t = r1     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object r1 = r4.h     // Catch: java.lang.Throwable -> Lb9
            if (r1 != 0) goto L3c
            int r1 = r4.k     // Catch: java.lang.Throwable -> Lb9
            int r2 = r4.l     // Catch: java.lang.Throwable -> Lb9
            boolean r1 = defpackage.sq.a(r1, r2)     // Catch: java.lang.Throwable -> Lb9
            if (r1 == 0) goto L27
            int r1 = r4.k     // Catch: java.lang.Throwable -> Lb9
            r4.z = r1     // Catch: java.lang.Throwable -> Lb9
            int r1 = r4.l     // Catch: java.lang.Throwable -> Lb9
            r4.A = r1     // Catch: java.lang.Throwable -> Lb9
        L27:
            android.graphics.drawable.Drawable r1 = r4.g()     // Catch: java.lang.Throwable -> Lb9
            if (r1 != 0) goto L2f
            r1 = 5
            goto L30
        L2f:
            r1 = 3
        L30:
            qj r2 = new qj     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb9
            r4.a(r2, r1)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            return
        L3c:
            sp$a r1 = r4.v     // Catch: java.lang.Throwable -> Lb9
            sp$a r2 = defpackage.sp.a.RUNNING     // Catch: java.lang.Throwable -> Lb9
            if (r1 == r2) goto Lb1
            sp$a r1 = r4.v     // Catch: java.lang.Throwable -> Lb9
            sp$a r2 = defpackage.sp.a.COMPLETE     // Catch: java.lang.Throwable -> Lb9
            if (r1 != r2) goto L51
            vj<R> r1 = r4.r     // Catch: java.lang.Throwable -> Lb9
            uh r2 = defpackage.uh.MEMORY_CACHE     // Catch: java.lang.Throwable -> Lb9
            r4.a(r1, r2)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            return
        L51:
            sp$a r1 = defpackage.sp.a.WAITING_FOR_SIZE     // Catch: java.lang.Throwable -> Lb9
            r4.v = r1     // Catch: java.lang.Throwable -> Lb9
            int r1 = r4.k     // Catch: java.lang.Throwable -> Lb9
            int r2 = r4.l     // Catch: java.lang.Throwable -> Lb9
            boolean r1 = defpackage.sq.a(r1, r2)     // Catch: java.lang.Throwable -> Lb9
            if (r1 == 0) goto L67
            int r1 = r4.k     // Catch: java.lang.Throwable -> Lb9
            int r2 = r4.l     // Catch: java.lang.Throwable -> Lb9
            r4.a(r1, r2)     // Catch: java.lang.Throwable -> Lb9
            goto L6c
        L67:
            cq<R> r1 = r4.n     // Catch: java.lang.Throwable -> Lb9
            r1.b(r4)     // Catch: java.lang.Throwable -> Lb9
        L6c:
            sp$a r1 = r4.v     // Catch: java.lang.Throwable -> Lb9
            sp$a r2 = defpackage.sp.a.RUNNING     // Catch: java.lang.Throwable -> Lb9
            if (r1 == r2) goto L78
            sp$a r1 = r4.v     // Catch: java.lang.Throwable -> Lb9
            sp$a r2 = defpackage.sp.a.WAITING_FOR_SIZE     // Catch: java.lang.Throwable -> Lb9
            if (r1 != r2) goto L91
        L78:
            op r1 = r4.e     // Catch: java.lang.Throwable -> Lb9
            if (r1 == 0) goto L85
            boolean r1 = r1.c(r4)     // Catch: java.lang.Throwable -> Lb9
            if (r1 == 0) goto L83
            goto L85
        L83:
            r1 = 0
            goto L86
        L85:
            r1 = 1
        L86:
            if (r1 == 0) goto L91
            cq<R> r1 = r4.n     // Catch: java.lang.Throwable -> Lb9
            android.graphics.drawable.Drawable r2 = r4.h()     // Catch: java.lang.Throwable -> Lb9
            r1.b(r2)     // Catch: java.lang.Throwable -> Lb9
        L91:
            boolean r1 = defpackage.sp.D     // Catch: java.lang.Throwable -> Lb9
            if (r1 == 0) goto Laf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r1.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb9
            long r2 = r4.t     // Catch: java.lang.Throwable -> Lb9
            double r2 = defpackage.oq.a(r2)     // Catch: java.lang.Throwable -> Lb9
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb9
            r4.a(r1)     // Catch: java.lang.Throwable -> Lb9
        Laf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            return
        Lb1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb9
            throw r1     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sp.d():void");
    }

    @Override // defpackage.np
    public boolean e() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    public final void f() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public final Drawable g() {
        int i;
        if (this.y == null) {
            lp<?> lpVar = this.j;
            this.y = lpVar.q;
            if (this.y == null && (i = lpVar.r) > 0) {
                this.y = a(i);
            }
        }
        return this.y;
    }

    public final Drawable h() {
        int i;
        if (this.x == null) {
            lp<?> lpVar = this.j;
            this.x = lpVar.i;
            if (this.x == null && (i = lpVar.j) > 0) {
                this.x = a(i);
            }
        }
        return this.x;
    }

    public final boolean i() {
        op opVar = this.e;
        return opVar == null || !opVar.f().a();
    }

    @Override // defpackage.np
    public boolean isRunning() {
        boolean z;
        synchronized (this.c) {
            z = this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    public final void j() {
        int i;
        op opVar = this.e;
        if (opVar == null || opVar.c(this)) {
            Drawable g = this.h == null ? g() : null;
            if (g == null) {
                if (this.w == null) {
                    lp<?> lpVar = this.j;
                    this.w = lpVar.g;
                    if (this.w == null && (i = lpVar.h) > 0) {
                        this.w = a(i);
                    }
                }
                g = this.w;
            }
            if (g == null) {
                g = h();
            }
            this.n.a(g);
        }
    }

    public final Drawable a(int i) {
        Resources.Theme theme = this.j.w;
        if (theme == null) {
            theme = this.f.getTheme();
        }
        ng ngVar = this.g;
        return ln.a(ngVar, ngVar, i, theme);
    }

    public void a(int i, int i2) {
        Object obj;
        int i3 = i;
        this.b.a();
        Object obj2 = this.c;
        synchronized (obj2) {
            try {
                try {
                    if (D) {
                        a("Got onSizeReady in " + oq.a(this.t));
                    }
                    if (this.v == a.WAITING_FOR_SIZE) {
                        this.v = a.RUNNING;
                        float f = this.j.d;
                        if (i3 != Integer.MIN_VALUE) {
                            i3 = Math.round(i3 * f);
                        }
                        this.z = i3;
                        this.A = i2 == Integer.MIN_VALUE ? i2 : Math.round(f * i2);
                        if (D) {
                            a("finished setup for calling load in " + oq.a(this.t));
                        }
                        obj = obj2;
                        try {
                            this.s = this.u.a(this.g, this.h, this.j.n, this.z, this.A, this.j.u, this.i, this.m, this.j.e, this.j.t, this.j.o, this.j.A, this.j.s, this.j.k, this.j.y, this.j.B, this.j.z, this, this.q);
                            if (this.v != a.RUNNING) {
                                this.s = null;
                            }
                            if (D) {
                                a("finished onSizeReady in " + oq.a(this.t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(vj<?> vjVar, uh uhVar) {
        this.b.a();
        vj<?> vjVar2 = null;
        try {
            try {
                synchronized (this.c) {
                    try {
                        this.s = null;
                        if (vjVar == null) {
                            a(new qj("Expected to receive a Resource<R> with an object of " + this.i + " inside, but instead got null."), 5);
                            return;
                        }
                        Object a2 = vjVar.a();
                        if (a2 != null && this.i.isAssignableFrom(a2.getClass())) {
                            op opVar = this.e;
                            if (!(opVar == null || opVar.d(this))) {
                                this.r = null;
                                this.v = a.COMPLETE;
                                this.u.a(vjVar);
                                return;
                            }
                            a(vjVar, a2, uhVar);
                            return;
                        }
                        this.r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.i);
                        sb.append(" but instead got ");
                        sb.append(a2 != null ? a2.getClass() : "");
                        sb.append("{");
                        sb.append(a2);
                        sb.append("} inside Resource{");
                        sb.append(vjVar);
                        sb.append("}.");
                        sb.append(a2 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        a(new qj(sb.toString()), 5);
                        this.u.a(vjVar);
                    } catch (Throwable th) {
                        th = th;
                        vjVar = null;
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                            vjVar2 = vjVar;
                            if (vjVar2 != null) {
                                this.u.a(vjVar2);
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void a(vj<R> vjVar, R r, uh uhVar) {
        boolean z;
        boolean i = i();
        this.v = a.COMPLETE;
        this.r = vjVar;
        if (this.g.i <= 3) {
            StringBuilder a2 = jg.a("Finished loading ");
            a2.append(r.getClass().getSimpleName());
            a2.append(" from ");
            a2.append(uhVar);
            a2.append(" for ");
            a2.append(this.h);
            a2.append(" with size [");
            a2.append(this.z);
            a2.append("x");
            a2.append(this.A);
            a2.append("] in ");
            a2.append(oq.a(this.t));
            a2.append(" ms");
            Log.d("Glide", a2.toString());
        }
        boolean z2 = true;
        this.B = true;
        try {
            if (this.o != null) {
                z = false;
                for (pp<R> ppVar : this.o) {
                    z |= ppVar.a(r, this.h, this.n, uhVar, i);
                }
            } else {
                z = false;
            }
            if (this.d == null || !this.d.a(r, this.h, this.n, uhVar, i)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.n.a(r, ((eq.a) this.p).a(uhVar, i));
            }
            this.B = false;
            op opVar = this.e;
            if (opVar != null) {
                opVar.e(this);
            }
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    public final void a(qj qjVar, int i) {
        boolean z;
        this.b.a();
        synchronized (this.c) {
            qjVar.a(this.C);
            int i2 = this.g.i;
            if (i2 <= i) {
                Log.w("Glide", "Load failed for " + this.h + " with size [" + this.z + "x" + this.A + "]", qjVar);
                if (i2 <= 4) {
                    qjVar.a("Glide");
                }
            }
            this.s = null;
            this.v = a.FAILED;
            boolean z2 = true;
            this.B = true;
            if (this.o != null) {
                z = false;
                for (pp<R> ppVar : this.o) {
                    z |= ppVar.a(qjVar, this.h, this.n, i());
                }
            } else {
                z = false;
            }
            if (this.d == null || !this.d.a(qjVar, this.h, this.n, i())) {
                z2 = false;
            }
            if (!(z | z2)) {
                j();
            }
            this.B = false;
            op opVar = this.e;
            if (opVar != null) {
                opVar.b(this);
            }
        }
    }

    @Override // defpackage.np
    public boolean a(np npVar) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        lp<?> lpVar;
        qg qgVar;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        lp<?> lpVar2;
        qg qgVar2;
        int size2;
        if (npVar instanceof sp) {
            synchronized (this.c) {
                i = this.k;
                i2 = this.l;
                obj = this.h;
                cls = this.i;
                lpVar = this.j;
                qgVar = this.m;
                size = this.o != null ? this.o.size() : 0;
            }
            sp spVar = (sp) npVar;
            synchronized (spVar.c) {
                i3 = spVar.k;
                i4 = spVar.l;
                obj2 = spVar.h;
                cls2 = spVar.i;
                lpVar2 = spVar.j;
                qgVar2 = spVar.m;
                List<pp<R>> list = spVar.o;
                size2 = list != null ? list.size() : 0;
            }
            return i == i3 && i2 == i4 && sq.a(obj, obj2) && cls.equals(cls2) && lpVar.equals(lpVar2) && qgVar == qgVar2 && size == size2;
        }
        return false;
    }

    public final void a(String str) {
        Log.v("Request", str + " this: " + this.a);
    }
}
