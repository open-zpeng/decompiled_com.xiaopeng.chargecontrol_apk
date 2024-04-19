package defpackage;
/* compiled from: TypeAdapters.java */
/* renamed from: yw  reason: default package */
/* loaded from: classes.dex */
public class yw implements cv {
    public final /* synthetic */ Class c;
    public final /* synthetic */ Class d;
    public final /* synthetic */ bv e;

    public yw(Class cls, Class cls2, bv bvVar) {
        this.c = cls;
        this.d = cls2;
        this.e = bvVar;
    }

    @Override // defpackage.cv
    public <T> bv<T> a(lu luVar, fx<T> fxVar) {
        Class<? super T> cls = fxVar.a;
        if (cls == this.c || cls == this.d) {
            return this.e;
        }
        return null;
    }

    public String toString() {
        StringBuilder a = jg.a("Factory[type=");
        a.append(this.d.getName());
        a.append("+");
        a.append(this.c.getName());
        a.append(",adapter=");
        a.append(this.e);
        a.append("]");
        return a.toString();
    }
}
