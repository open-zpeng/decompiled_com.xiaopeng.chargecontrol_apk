package defpackage;

import defpackage.tq;
import defpackage.wq;
/* compiled from: LockedResource.java */
/* renamed from: uj  reason: default package */
/* loaded from: classes.dex */
public final class uj<Z> implements vj<Z>, tq.d {
    public static final c9<uj<?>> g = tq.a(20, new a());
    public final wq c = new wq.b();
    public vj<Z> d;
    public boolean e;
    public boolean f;

    /* compiled from: LockedResource.java */
    /* renamed from: uj$a */
    /* loaded from: classes.dex */
    public class a implements tq.b<uj<?>> {
        @Override // defpackage.tq.b
        public uj<?> a() {
            return new uj<>();
        }
    }

    public static <Z> uj<Z> a(vj<Z> vjVar) {
        uj<Z> ujVar = (uj<Z>) g.a();
        defpackage.a.a(ujVar, "Argument must not be null");
        ujVar.f = false;
        ujVar.e = true;
        ujVar.d = vjVar;
        return ujVar;
    }

    @Override // defpackage.vj
    public int b() {
        return this.d.b();
    }

    @Override // defpackage.vj
    public Class<Z> c() {
        return this.d.c();
    }

    @Override // defpackage.vj
    public synchronized void d() {
        this.c.a();
        this.f = true;
        if (!this.e) {
            this.d.d();
            this.d = null;
            g.a(this);
        }
    }

    @Override // defpackage.tq.d
    public wq e() {
        return this.c;
    }

    public synchronized void f() {
        this.c.a();
        if (this.e) {
            this.e = false;
            if (this.f) {
                d();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // defpackage.vj
    public Z a() {
        return this.d.a();
    }
}
