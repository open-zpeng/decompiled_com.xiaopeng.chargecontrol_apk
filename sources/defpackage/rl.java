package defpackage;

import defpackage.nl;
import defpackage.sg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* compiled from: MultiModelLoaderFactory.java */
/* renamed from: rl  reason: default package */
/* loaded from: classes.dex */
public class rl {
    public static final c e = new c();
    public static final nl<Object, Object> f = new a();
    public final List<b<?, ?>> a;
    public final c b;
    public final Set<b<?, ?>> c;
    public final c9<List<Throwable>> d;

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: rl$a */
    /* loaded from: classes.dex */
    public static class a implements nl<Object, Object> {
        @Override // defpackage.nl
        public nl.a<Object> a(Object obj, int i, int i2, bi biVar) {
            return null;
        }

        @Override // defpackage.nl
        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: rl$b */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {
        public final Class<Model> a;
        public final Class<Data> b;
        public final ol<? extends Model, ? extends Data> c;

        public b(Class<Model> cls, Class<Data> cls2, ol<? extends Model, ? extends Data> olVar) {
            this.a = cls;
            this.b = cls2;
            this.c = olVar;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: rl$c */
    /* loaded from: classes.dex */
    public static class c {
        public <Model, Data> ql<Model, Data> a(List<nl<Model, Data>> list, c9<List<Throwable>> c9Var) {
            return new ql<>(list, c9Var);
        }
    }

    public rl(c9<List<Throwable>> c9Var) {
        c cVar = e;
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = c9Var;
        this.b = cVar;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ol<? extends Model, ? extends Data> olVar) {
        b<?, ?> bVar = new b<>(cls, cls2, olVar);
        List<b<?, ?>> list = this.a;
        list.add(list.size(), bVar);
    }

    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a.isAssignableFrom(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    public synchronized <Model> List<nl<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.c.contains(bVar) && bVar.a.isAssignableFrom(cls)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized <Model, Data> nl<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.a.isAssignableFrom(cls) && bVar.b.isAssignableFrom(cls2)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            } else if (arrayList.size() == 1) {
                return (nl) arrayList.get(0);
            } else if (z) {
                return (nl<Model, Data>) f;
            } else {
                throw new sg.c((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    public final <Model, Data> nl<Model, Data> a(b<?, ?> bVar) {
        nl<Model, Data> nlVar = (nl<Model, Data>) bVar.c.a(this);
        defpackage.a.a(nlVar, "Argument must not be null");
        return nlVar;
    }
}
