package defpackage;

import defpackage.sg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ModelLoaderRegistry.java */
/* renamed from: pl  reason: default package */
/* loaded from: classes.dex */
public class pl {
    public final rl a;
    public final a b;

    /* compiled from: ModelLoaderRegistry.java */
    /* renamed from: pl$a */
    /* loaded from: classes.dex */
    public static class a {
        public final Map<Class<?>, C0010a<?>> a = new HashMap();

        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: pl$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0010a<Model> {
            public final List<nl<Model, ?>> a;

            public C0010a(List<nl<Model, ?>> list) {
                this.a = list;
            }
        }
    }

    public pl(c9<List<Throwable>> c9Var) {
        rl rlVar = new rl(c9Var);
        this.b = new a();
        this.a = rlVar;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ol<? extends Model, ? extends Data> olVar) {
        this.a.a(cls, cls2, olVar);
        this.b.a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized <A> List<nl<A, ?>> b(Class<A> cls) {
        List list;
        a.C0010a<?> c0010a = this.b.a.get(cls);
        list = c0010a == null ? (List<nl<A, ?>>) false : c0010a.a;
        if (list == null) {
            list = (List<nl<A, ?>>) Collections.unmodifiableList(this.a.a(cls));
            if (this.b.a.put(cls, new a.C0010a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
        return (List<nl<A, ?>>) list;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.a.b(cls);
    }

    public <A> List<nl<A, ?>> a(A a2) {
        List<nl<A, ?>> b = b(a2.getClass());
        if (!b.isEmpty()) {
            int size = b.size();
            boolean z = true;
            List<nl<A, ?>> emptyList = Collections.emptyList();
            for (int i = 0; i < size; i++) {
                nl<A, ?> nlVar = b.get(i);
                if (nlVar.a(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i);
                        z = false;
                    }
                    emptyList.add(nlVar);
                }
            }
            if (emptyList.isEmpty()) {
                throw new sg.c(a2, b);
            }
            return emptyList;
        }
        throw new sg.c(a2);
    }
}
