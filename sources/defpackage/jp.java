package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ResourceDecoderRegistry.java */
/* renamed from: jp  reason: default package */
/* loaded from: classes.dex */
public class jp {
    public final List<String> a = new ArrayList();
    public final Map<String, List<a<?, ?>>> b = new HashMap();

    /* compiled from: ResourceDecoderRegistry.java */
    /* renamed from: jp$a */
    /* loaded from: classes.dex */
    public static class a<T, R> {
        public final Class<T> a;
        public final Class<R> b;
        public final di<T, R> c;

        public a(Class<T> cls, Class<R> cls2, di<T, R> diVar) {
            this.a = cls;
            this.b = cls2;
            this.c = diVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.a);
        this.a.clear();
        for (String str : list) {
            this.a.add(str);
        }
        for (String str2 : arrayList) {
            if (!list.contains(str2)) {
                this.a.add(str2);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.a) {
            List<a<?, ?>> list = this.b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                        arrayList.add(aVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<di<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.a) {
            List<a<?, ?>> list = this.b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void b(String str, di<T, R> diVar, Class<T> cls, Class<R> cls2) {
        a(str).add(0, new a<>(cls, cls2, diVar));
    }

    public synchronized <T, R> void a(String str, di<T, R> diVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, diVar));
    }

    public final synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        list = this.b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(str, list);
        }
        return list;
    }
}
