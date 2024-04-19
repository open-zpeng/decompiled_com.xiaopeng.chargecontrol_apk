package defpackage;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import defpackage.lo;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: RequestManager.java */
/* renamed from: ug  reason: default package */
/* loaded from: classes.dex */
public class ug implements ComponentCallbacks2, ro, pg<tg<Drawable>> {
    public static final qp o;
    public final lg c;
    public final Context d;
    public final qo e;
    public final wo f;
    public final vo g;
    public final yo h;
    public final Runnable i;
    public final Handler j;
    public final lo k;
    public final CopyOnWriteArrayList<pp<Object>> l;
    public qp m;
    public boolean n;

    /* compiled from: RequestManager.java */
    /* renamed from: ug$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ug ugVar = ug.this;
            ugVar.e.a(ugVar);
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: ug$b */
    /* loaded from: classes.dex */
    public static class b extends xp<View, Object> {
        public b(View view) {
            super(view);
        }

        @Override // defpackage.cq
        public void a(Drawable drawable) {
        }

        @Override // defpackage.cq
        public void a(Object obj, fq<? super Object> fqVar) {
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: ug$c */
    /* loaded from: classes.dex */
    public class c implements lo.a {
        public final wo a;

        public c(wo woVar) {
            this.a = woVar;
        }

        public void a(boolean z) {
            if (z) {
                synchronized (ug.this) {
                    wo woVar = this.a;
                    for (np npVar : sq.a(woVar.a)) {
                        if (!npVar.e() && !npVar.b()) {
                            npVar.clear();
                            if (!woVar.c) {
                                npVar.d();
                            } else {
                                woVar.b.add(npVar);
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        qp a2 = new qp().a(Bitmap.class);
        a2.v = true;
        o = a2;
        new qp().a(un.class).v = true;
        qp.b(jj.b).a(qg.LOW).a(true);
    }

    public ug(lg lgVar, qo qoVar, vo voVar, Context context) {
        wo woVar = new wo();
        mo moVar = lgVar.i;
        this.h = new yo();
        this.i = new a();
        this.j = new Handler(Looper.getMainLooper());
        this.c = lgVar;
        this.e = qoVar;
        this.g = voVar;
        this.f = woVar;
        this.d = context;
        this.k = ((oo) moVar).a(context.getApplicationContext(), new c(woVar));
        if (sq.b()) {
            this.j.post(this.i);
        } else {
            qoVar.a(this);
        }
        qoVar.a(this.k);
        this.l = new CopyOnWriteArrayList<>(lgVar.e.e);
        a(lgVar.e.a());
        lgVar.a(this);
    }

    public synchronized void a(qp qpVar) {
        qp clone = qpVar.clone();
        if (clone.v && !clone.x) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        clone.x = true;
        clone.v = true;
        this.m = clone;
    }

    @Override // defpackage.ro
    public synchronized void b() {
        this.h.b();
        for (cq<?> cqVar : sq.a(this.h.c)) {
            a(cqVar);
        }
        this.h.c.clear();
        wo woVar = this.f;
        for (np npVar : sq.a(woVar.a)) {
            woVar.a(npVar);
        }
        woVar.b.clear();
        this.e.b(this);
        this.e.b(this.k);
        this.j.removeCallbacks(this.i);
        this.c.b(this);
    }

    public tg<Bitmap> d() {
        return new tg(this.c, this, Bitmap.class, this.d).a((lp<?>) o);
    }

    public synchronized qp e() {
        return this.m;
    }

    public synchronized void f() {
        wo woVar = this.f;
        woVar.c = true;
        for (np npVar : sq.a(woVar.a)) {
            if (npVar.isRunning() || npVar.e()) {
                npVar.clear();
                woVar.b.add(npVar);
            }
        }
    }

    public synchronized void g() {
        f();
        for (ug ugVar : this.g.a()) {
            ugVar.f();
        }
    }

    public synchronized void h() {
        wo woVar = this.f;
        woVar.c = true;
        for (np npVar : sq.a(woVar.a)) {
            if (npVar.isRunning()) {
                npVar.c();
                woVar.b.add(npVar);
            }
        }
    }

    public synchronized void i() {
        wo woVar = this.f;
        woVar.c = false;
        for (np npVar : sq.a(woVar.a)) {
            if (!npVar.e() && !npVar.isRunning()) {
                npVar.d();
            }
        }
        woVar.b.clear();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // defpackage.ro
    public synchronized void onStart() {
        i();
        this.h.onStart();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.n) {
            g();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f + ", treeNode=" + this.g + "}";
    }

    @Override // defpackage.ro
    public synchronized void a() {
        h();
        this.h.a();
    }

    public tg<Drawable> a(Uri uri) {
        tg<Drawable> a2 = a(Drawable.class);
        a2.b(uri);
        return a2;
    }

    public <ResourceType> tg<ResourceType> a(Class<ResourceType> cls) {
        return new tg<>(this.c, this, cls, this.d);
    }

    public void a(View view) {
        a(new b(view));
    }

    public void a(cq<?> cqVar) {
        if (cqVar == null) {
            return;
        }
        boolean b2 = b(cqVar);
        np c2 = cqVar.c();
        if (b2 || this.c.a(cqVar) || c2 == null) {
            return;
        }
        cqVar.a((np) null);
        c2.clear();
    }

    public synchronized boolean b(cq<?> cqVar) {
        np c2 = cqVar.c();
        if (c2 == null) {
            return true;
        }
        if (this.f.a(c2)) {
            this.h.c.remove(cqVar);
            cqVar.a((np) null);
            return true;
        }
        return false;
    }

    public synchronized void a(cq<?> cqVar, np npVar) {
        this.h.c.add(cqVar);
        wo woVar = this.f;
        woVar.a.add(npVar);
        if (!woVar.c) {
            npVar.d();
        } else {
            npVar.clear();
            if (Log.isLoggable("RequestTracker", 2)) {
                Log.v("RequestTracker", "Paused, delaying request");
            }
            woVar.b.add(npVar);
        }
    }
}
