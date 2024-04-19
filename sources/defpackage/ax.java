package defpackage;
/* compiled from: TypeAdapters.java */
/* renamed from: ax  reason: default package */
/* loaded from: classes.dex */
public class ax implements cv {
    public final /* synthetic */ Class c;
    public final /* synthetic */ bv d;

    /* JADX INFO: Add missing generic type declarations: [T1] */
    /* compiled from: TypeAdapters.java */
    /* renamed from: ax$a */
    /* loaded from: classes.dex */
    public class a<T1> extends bv<T1> {
        public final /* synthetic */ Class a;

        public a(Class cls) {
            this.a = cls;
        }

        @Override // defpackage.bv
        public T1 read(gx gxVar) {
            T1 t1 = (T1) ax.this.d.read(gxVar);
            if (t1 == null || this.a.isInstance(t1)) {
                return t1;
            }
            StringBuilder a = jg.a("Expected a ");
            a.append(this.a.getName());
            a.append(" but was ");
            a.append(t1.getClass().getName());
            throw new zu(a.toString());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, T1 t1) {
            ax.this.d.write(ixVar, t1);
        }
    }

    public ax(Class cls, bv bvVar) {
        this.c = cls;
        this.d = bvVar;
    }

    @Override // defpackage.cv
    public <T2> bv<T2> a(lu luVar, fx<T2> fxVar) {
        Class<? super T2> cls = fxVar.a;
        if (this.c.isAssignableFrom(cls)) {
            return new a(cls);
        }
        return null;
    }

    public String toString() {
        StringBuilder a2 = jg.a("Factory[typeHierarchy=");
        a2.append(this.c.getName());
        a2.append(",adapter=");
        a2.append(this.d);
        a2.append("]");
        return a2.toString();
    }
}
