package defpackage;
/* compiled from: DisplayCutoutCompat.java */
/* renamed from: i9  reason: default package */
/* loaded from: classes.dex */
public final class i9 {
    public final Object a;

    public i9(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i9.class != obj.getClass()) {
            return false;
        }
        return a.b(this.a, ((i9) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder a = jg.a("DisplayCutoutCompat{");
        a.append(this.a);
        a.append("}");
        return a.toString();
    }
}
