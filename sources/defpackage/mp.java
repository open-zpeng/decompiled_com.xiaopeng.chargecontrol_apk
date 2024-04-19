package defpackage;

import defpackage.op;
/* compiled from: ErrorRequestCoordinator.java */
/* renamed from: mp  reason: default package */
/* loaded from: classes.dex */
public final class mp implements op, np {
    public final Object a;
    public final op b;
    public volatile np c;
    public volatile np d;
    public op.a e;
    public op.a f;

    public mp(Object obj, op opVar) {
        op.a aVar = op.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.a = obj;
        this.b = opVar;
    }

    @Override // defpackage.np
    public boolean a(np npVar) {
        if (npVar instanceof mp) {
            mp mpVar = (mp) npVar;
            return this.c.a(mpVar.c) && this.d.a(mpVar.d);
        }
        return false;
    }

    @Override // defpackage.np
    public boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.e == op.a.CLEARED && this.f == op.a.CLEARED;
        }
        return z;
    }

    @Override // defpackage.np
    public void c() {
        synchronized (this.a) {
            if (this.e == op.a.RUNNING) {
                this.e = op.a.PAUSED;
                this.c.c();
            }
            if (this.f == op.a.RUNNING) {
                this.f = op.a.PAUSED;
                this.d.c();
            }
        }
    }

    @Override // defpackage.np
    public void clear() {
        synchronized (this.a) {
            this.e = op.a.CLEARED;
            this.c.clear();
            if (this.f != op.a.CLEARED) {
                this.f = op.a.CLEARED;
                this.d.clear();
            }
        }
    }

    @Override // defpackage.np
    public void d() {
        synchronized (this.a) {
            if (this.e != op.a.RUNNING) {
                this.e = op.a.RUNNING;
                this.c.d();
            }
        }
    }

    @Override // defpackage.np
    public boolean e() {
        boolean z;
        synchronized (this.a) {
            z = this.e == op.a.SUCCESS || this.f == op.a.SUCCESS;
        }
        return z;
    }

    @Override // defpackage.op
    public boolean f(np npVar) {
        boolean z;
        boolean z2;
        synchronized (this.a) {
            op opVar = this.b;
            z = false;
            if (opVar != null && !opVar.f(this)) {
                z2 = false;
                if (z2 && g(npVar)) {
                    z = true;
                }
            }
            z2 = true;
            if (z2) {
                z = true;
            }
        }
        return z;
    }

    public final boolean g(np npVar) {
        return npVar.equals(this.c) || (this.e == op.a.FAILED && npVar.equals(this.d));
    }

    @Override // defpackage.np
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            z = this.e == op.a.RUNNING || this.f == op.a.RUNNING;
        }
        return z;
    }

    @Override // defpackage.op, defpackage.np
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.c.a() || this.d.a();
        }
        return z;
    }

    @Override // defpackage.op
    public void b(np npVar) {
        synchronized (this.a) {
            if (!npVar.equals(this.d)) {
                this.e = op.a.FAILED;
                if (this.f != op.a.RUNNING) {
                    this.f = op.a.RUNNING;
                    this.d.d();
                }
                return;
            }
            this.f = op.a.FAILED;
            if (this.b != null) {
                this.b.b(this);
            }
        }
    }

    @Override // defpackage.op
    public void e(np npVar) {
        synchronized (this.a) {
            if (npVar.equals(this.c)) {
                this.e = op.a.SUCCESS;
            } else if (npVar.equals(this.d)) {
                this.f = op.a.SUCCESS;
            }
            if (this.b != null) {
                this.b.e(this);
            }
        }
    }

    @Override // defpackage.op
    public op f() {
        op f;
        synchronized (this.a) {
            f = this.b != null ? this.b.f() : this;
        }
        return f;
    }

    @Override // defpackage.op
    public boolean d(np npVar) {
        boolean z;
        boolean z2;
        synchronized (this.a) {
            op opVar = this.b;
            z = false;
            if (opVar != null && !opVar.d(this)) {
                z2 = false;
                if (z2 && g(npVar)) {
                    z = true;
                }
            }
            z2 = true;
            if (z2) {
                z = true;
            }
        }
        return z;
    }

    @Override // defpackage.op
    public boolean c(np npVar) {
        boolean z;
        boolean z2;
        synchronized (this.a) {
            op opVar = this.b;
            z = false;
            if (opVar != null && !opVar.c(this)) {
                z2 = false;
                if (z2 && g(npVar)) {
                    z = true;
                }
            }
            z2 = true;
            if (z2) {
                z = true;
            }
        }
        return z;
    }
}
