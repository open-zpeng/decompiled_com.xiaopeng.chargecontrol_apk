package defpackage;
/* compiled from: Subscription.java */
/* renamed from: xl0  reason: default package */
/* loaded from: classes.dex */
public final class xl0 {
    public final Object a;
    public final vl0 b;
    public volatile boolean c = true;

    public xl0(Object obj, vl0 vl0Var) {
        this.a = obj;
        this.b = vl0Var;
    }

    public boolean equals(Object obj) {
        if (obj instanceof xl0) {
            xl0 xl0Var = (xl0) obj;
            return this.a == xl0Var.a && this.b.equals(xl0Var.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.f.hashCode() + this.a.hashCode();
    }
}
