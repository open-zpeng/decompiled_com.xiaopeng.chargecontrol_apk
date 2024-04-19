package defpackage;

import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* renamed from: kw  reason: default package */
/* loaded from: classes.dex */
public final class kw implements cv {
    public final pv c;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* renamed from: kw$a */
    /* loaded from: classes.dex */
    public static final class a<E> extends bv<Collection<E>> {
        public final bv<E> a;
        public final cw<? extends Collection<E>> b;

        public a(lu luVar, Type type, bv<E> bvVar, cw<? extends Collection<E>> cwVar) {
            this.a = new ww(luVar, bvVar, type);
            this.b = cwVar;
        }

        @Override // defpackage.bv
        public Object read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            Collection<E> a = this.b.a();
            gxVar.a();
            while (gxVar.h()) {
                a.add(this.a.read(gxVar));
            }
            gxVar.e();
            return a;
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Object obj) {
            Collection<E> collection = (Collection) obj;
            if (collection == null) {
                ixVar.g();
                return;
            }
            ixVar.b();
            for (E e : collection) {
                this.a.write(ixVar, e);
            }
            ixVar.d();
        }
    }

    public kw(pv pvVar) {
        this.c = pvVar;
    }

    @Override // defpackage.cv
    public <T> bv<T> a(lu luVar, fx<T> fxVar) {
        Type type = fxVar.b;
        Class<? super T> cls = fxVar.a;
        if (Collection.class.isAssignableFrom(cls)) {
            Type a2 = jv.a(type, (Class<?>) cls);
            return new a(luVar, a2, luVar.a((fx) new fx<>(a2)), this.c.a(fxVar));
        }
        return null;
    }
}
