package defpackage;

import defpackage.mk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GroupedLinkedMap.java */
/* renamed from: hk  reason: default package */
/* loaded from: classes.dex */
public class hk<K extends mk, V> {
    public final a<K, V> a = new a<>(null);
    public final Map<K, a<K, V>> b = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    /* renamed from: hk$a */
    /* loaded from: classes.dex */
    public static class a<K, V> {
        public final K a;
        public List<V> b;
        public a<K, V> c;
        public a<K, V> d;

        public a() {
            this(null);
        }

        public V a() {
            List<V> list = this.b;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.b.remove(size - 1);
            }
            return null;
        }

        public a(K k) {
            this.d = this;
            this.c = this;
            this.a = k;
        }
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            a<K, V> aVar2 = aVar.d;
            aVar2.c = aVar.c;
            aVar.c.d = aVar2;
            a<K, V> aVar3 = this.a;
            aVar.d = aVar3.d;
            aVar.c = aVar3;
            a(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        if (aVar.b == null) {
            aVar.b = new ArrayList();
        }
        aVar.b.add(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.c; !aVar.equals(this.a); aVar = aVar.c) {
            z = true;
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            List<V> list = aVar.b;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        a<K, V> aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
        a<K, V> aVar3 = this.a;
        aVar.d = aVar3;
        aVar.c = aVar3.c;
        aVar.c.d = aVar;
        aVar.d.c = aVar;
        return aVar.a();
    }

    public V a() {
        for (a aVar = this.a.d; !aVar.equals(this.a); aVar = aVar.d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            a<K, V> aVar2 = aVar.d;
            aVar2.c = aVar.c;
            aVar.c.d = aVar2;
            this.b.remove(aVar.a);
            ((mk) aVar.a).a();
        }
        return null;
    }

    public static <K, V> void a(a<K, V> aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }
}
