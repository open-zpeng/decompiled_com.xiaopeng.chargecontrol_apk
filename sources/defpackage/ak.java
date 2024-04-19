package defpackage;

import android.util.Log;
import defpackage.fj;
import defpackage.nl;
import defpackage.sg;
import java.util.Collections;
import java.util.List;
/* compiled from: SourceGenerator.java */
/* renamed from: ak  reason: default package */
/* loaded from: classes.dex */
public class ak implements fj, fj.a {
    public final gj<?> c;
    public final fj.a d;
    public int e;
    public cj f;
    public Object g;
    public volatile nl.a<?> h;
    public dj i;

    public ak(gj<?> gjVar, fj.a aVar) {
        this.c = gjVar;
        this.d = aVar;
    }

    @Override // defpackage.fj
    public boolean a() {
        Object obj = this.g;
        if (obj != null) {
            this.g = null;
            long a = oq.a();
            try {
                xh a2 = this.c.c.b.b.a(obj.getClass());
                if (a2 != null) {
                    ej ejVar = new ej(a2, obj, this.c.i);
                    this.i = new dj(this.h.a, this.c.n);
                    this.c.b().a(this.i, ejVar);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.i + ", data: " + obj + ", encoder: " + a2 + ", duration: " + oq.a(a));
                    }
                    this.h.c.b();
                    this.f = new cj(Collections.singletonList(this.h.a), this.c, this);
                } else {
                    throw new sg.e(obj.getClass());
                }
            } catch (Throwable th) {
                this.h.c.b();
                throw th;
            }
        }
        cj cjVar = this.f;
        if (cjVar == null || !cjVar.a()) {
            this.f = null;
            this.h = null;
            boolean z = false;
            while (!z) {
                if (!(this.e < this.c.c().size())) {
                    break;
                }
                List<nl.a<?>> c = this.c.c();
                int i = this.e;
                this.e = i + 1;
                this.h = c.get(i);
                if (this.h != null && (this.c.p.a(this.h.c.c()) || this.c.c(this.h.c.a()))) {
                    this.h.c.a(this.c.o, new zj(this, this.h));
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // defpackage.fj.a
    public void b() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.fj
    public void cancel() {
        nl.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // defpackage.fj.a
    public void a(zh zhVar, Object obj, ji<?> jiVar, uh uhVar, zh zhVar2) {
        this.d.a(zhVar, obj, jiVar, this.h.c.c(), zhVar);
    }

    @Override // defpackage.fj.a
    public void a(zh zhVar, Exception exc, ji<?> jiVar, uh uhVar) {
        this.d.a(zhVar, exc, jiVar, this.h.c.c());
    }
}
