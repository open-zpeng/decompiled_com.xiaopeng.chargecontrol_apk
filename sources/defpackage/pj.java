package defpackage;
/* compiled from: EngineResource.java */
/* renamed from: pj  reason: default package */
/* loaded from: classes.dex */
public class pj<Z> implements vj<Z> {
    public final boolean c;
    public final boolean d;
    public final vj<Z> e;
    public final a f;
    public final zh g;
    public int h;
    public boolean i;

    /* compiled from: EngineResource.java */
    /* renamed from: pj$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    public pj(vj<Z> vjVar, boolean z, boolean z2, zh zhVar, a aVar) {
        defpackage.a.a(vjVar, "Argument must not be null");
        this.e = vjVar;
        this.c = z;
        this.d = z2;
        this.g = zhVar;
        defpackage.a.a(aVar, "Argument must not be null");
        this.f = aVar;
    }

    @Override // defpackage.vj
    public Z a() {
        return this.e.a();
    }

    @Override // defpackage.vj
    public int b() {
        return this.e.b();
    }

    @Override // defpackage.vj
    public Class<Z> c() {
        return this.e.c();
    }

    @Override // defpackage.vj
    public synchronized void d() {
        if (this.h <= 0) {
            if (!this.i) {
                this.i = true;
                if (this.d) {
                    this.e.d();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized void e() {
        if (!this.i) {
            this.h++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public void f() {
        boolean z;
        synchronized (this) {
            if (this.h > 0) {
                z = true;
                int i = this.h - 1;
                this.h = i;
                if (i != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            ((kj) this.f).a(this.g, (pj<?>) this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.c + ", listener=" + this.f + ", key=" + this.g + ", acquired=" + this.h + ", isRecycled=" + this.i + ", resource=" + this.e + '}';
    }
}
