package defpackage;

import defpackage.op;
/* compiled from: ThumbnailRequestCoordinator.java */
/* renamed from: tp  reason: default package */
/* loaded from: classes.dex */
public class tp implements op, np {
    public final op a;
    public final Object b;
    public volatile np c;
    public volatile np d;
    public op.a e;
    public op.a f;
    public boolean g;

    public tp(Object obj, op opVar) {
        op.a aVar = op.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.b = obj;
        this.a = opVar;
    }

    @Override // defpackage.op, defpackage.np
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.d.a() || this.c.a();
        }
        return z;
    }

    @Override // defpackage.op
    public void b(np npVar) {
        synchronized (this.b) {
            if (!npVar.equals(this.c)) {
                this.f = op.a.FAILED;
                return;
            }
            this.e = op.a.FAILED;
            if (this.a != null) {
                this.a.b(this);
            }
        }
    }

    @Override // defpackage.op
    public boolean c(np npVar) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            op opVar = this.a;
            z = false;
            if (opVar != null && !opVar.c(this)) {
                z2 = false;
                if (z2 && npVar.equals(this.c) && !a()) {
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

    @Override // defpackage.np
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            this.e = op.a.CLEARED;
            this.f = op.a.CLEARED;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // defpackage.op
    public boolean d(np npVar) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            op opVar = this.a;
            z = false;
            if (opVar != null && !opVar.d(this)) {
                z2 = false;
                if (z2 && (npVar.equals(this.c) || this.e != op.a.SUCCESS)) {
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
    public void e(np npVar) {
        synchronized (this.b) {
            if (npVar.equals(this.d)) {
                this.f = op.a.SUCCESS;
                return;
            }
            this.e = op.a.SUCCESS;
            if (this.a != null) {
                this.a.e(this);
            }
            if (!this.f.c) {
                this.d.clear();
            }
        }
    }

    @Override // defpackage.op
    public boolean f(np npVar) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            op opVar = this.a;
            z = false;
            if (opVar != null && !opVar.f(this)) {
                z2 = false;
                if (z2 && npVar.equals(this.c) && this.e != op.a.PAUSED) {
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

    @Override // defpackage.np
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == op.a.RUNNING;
        }
        return z;
    }

    @Override // defpackage.np
    public boolean a(np npVar) {
        if (npVar instanceof tp) {
            tp tpVar = (tp) npVar;
            if (this.c == null) {
                if (tpVar.c != null) {
                    return false;
                }
            } else if (!this.c.a(tpVar.c)) {
                return false;
            }
            if (this.d == null) {
                if (tpVar.d != null) {
                    return false;
                }
            } else if (!this.d.a(tpVar.d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.np
    public void c() {
        synchronized (this.b) {
            if (!this.f.c) {
                this.f = op.a.PAUSED;
                this.d.c();
            }
            if (!this.e.c) {
                this.e = op.a.PAUSED;
                this.c.c();
            }
        }
    }

    @Override // defpackage.np
    public void d() {
        synchronized (this.b) {
            this.g = true;
            if (this.e != op.a.SUCCESS && this.f != op.a.RUNNING) {
                this.f = op.a.RUNNING;
                this.d.d();
            }
            if (this.g && this.e != op.a.RUNNING) {
                this.e = op.a.RUNNING;
                this.c.d();
            }
            this.g = false;
        }
    }

    @Override // defpackage.op
    public op f() {
        op f;
        synchronized (this.b) {
            f = this.a != null ? this.a.f() : this;
        }
        return f;
    }

    @Override // defpackage.np
    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.e == op.a.CLEARED;
        }
        return z;
    }

    @Override // defpackage.np
    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == op.a.SUCCESS;
        }
        return z;
    }
}
