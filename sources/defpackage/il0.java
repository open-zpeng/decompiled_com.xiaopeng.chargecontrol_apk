package defpackage;

import java.util.logging.Level;
/* compiled from: BackgroundPoster.java */
/* renamed from: il0  reason: default package */
/* loaded from: classes.dex */
public final class il0 implements Runnable, sl0 {
    public final rl0 c = new rl0();
    public final jl0 d;
    public volatile boolean e;

    public il0(jl0 jl0Var) {
        this.d = jl0Var;
    }

    @Override // defpackage.sl0
    public void a(xl0 xl0Var, Object obj) {
        ql0 a = ql0.a(xl0Var, obj);
        synchronized (this) {
            this.c.a(a);
            if (!this.e) {
                this.e = true;
                this.d.j.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                ql0 a = this.c.a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.c.a();
                        if (a == null) {
                            return;
                        }
                    }
                }
                this.d.a(a);
            } catch (InterruptedException e) {
                nl0 nl0Var = this.d.r;
                Level level = Level.WARNING;
                nl0Var.a(level, Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.e = false;
            }
        }
    }
}
