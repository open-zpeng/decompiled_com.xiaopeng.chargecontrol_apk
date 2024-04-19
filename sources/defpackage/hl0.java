package defpackage;
/* compiled from: AsyncPoster.java */
/* renamed from: hl0  reason: default package */
/* loaded from: classes.dex */
public class hl0 implements Runnable, sl0 {
    public final rl0 c = new rl0();
    public final jl0 d;

    public hl0(jl0 jl0Var) {
        this.d = jl0Var;
    }

    @Override // defpackage.sl0
    public void a(xl0 xl0Var, Object obj) {
        this.c.a(ql0.a(xl0Var, obj));
        this.d.j.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        ql0 a = this.c.a();
        if (a != null) {
            this.d.a(a);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
