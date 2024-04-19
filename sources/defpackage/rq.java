package defpackage;
/* compiled from: MultiClassKey.java */
/* renamed from: rq  reason: default package */
/* loaded from: classes.dex */
public class rq {
    public Class<?> a;
    public Class<?> b;
    public Class<?> c;

    public rq() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rq.class != obj.getClass()) {
            return false;
        }
        rq rqVar = (rq) obj;
        return this.a.equals(rqVar.a) && this.b.equals(rqVar.b) && sq.b(this.c, rqVar.c);
    }

    public int hashCode() {
        int hashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        Class<?> cls = this.c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder a = jg.a("MultiClassKey{first=");
        a.append(this.a);
        a.append(", second=");
        a.append(this.b);
        a.append('}');
        return a.toString();
    }

    public rq(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }
}
