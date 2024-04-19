package defpackage;
/* compiled from: PendingPostQueue.java */
/* renamed from: rl0  reason: default package */
/* loaded from: classes.dex */
public final class rl0 {
    public ql0 a;
    public ql0 b;

    public synchronized void a(ql0 ql0Var) {
        try {
            if (ql0Var != null) {
                if (this.b != null) {
                    this.b.c = ql0Var;
                    this.b = ql0Var;
                } else if (this.a == null) {
                    this.b = ql0Var;
                    this.a = ql0Var;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ql0 a() {
        ql0 ql0Var;
        ql0Var = this.a;
        if (this.a != null) {
            this.a = this.a.c;
            if (this.a == null) {
                this.b = null;
            }
        }
        return ql0Var;
    }

    public synchronized ql0 a(int i) {
        if (this.a == null) {
            wait(i);
        }
        return a();
    }
}
