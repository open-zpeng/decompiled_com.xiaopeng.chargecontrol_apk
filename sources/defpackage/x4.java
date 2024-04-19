package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* renamed from: x4  reason: default package */
/* loaded from: classes.dex */
public class x4<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> c;
    public c<K, V> d;
    public WeakHashMap<f<K, V>, Boolean> e = new WeakHashMap<>();
    public int f = 0;

    /* compiled from: SafeIterableMap.java */
    /* renamed from: x4$a */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // defpackage.x4.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f;
        }

        @Override // defpackage.x4.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.e;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: x4$b */
    /* loaded from: classes.dex */
    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // defpackage.x4.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.e;
        }

        @Override // defpackage.x4.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: x4$c */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public final K c;
        public final V d;
        public c<K, V> e;
        public c<K, V> f;

        public c(K k, V v) {
            this.c = k;
            this.d = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.c.equals(cVar.c) && this.d.equals(cVar.d);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.d;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.c.hashCode() ^ this.d.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.c + "=" + this.d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: x4$d */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> c;
        public boolean d = true;

        public d() {
        }

        @Override // defpackage.x4.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.c;
            if (cVar == cVar2) {
                this.c = cVar2.f;
                this.d = this.c == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.d) {
                return x4.this.c != null;
            }
            c<K, V> cVar = this.c;
            return (cVar == null || cVar.e == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.d) {
                this.d = false;
                this.c = x4.this.c;
            } else {
                c<K, V> cVar = this.c;
                this.c = cVar != null ? cVar.e : null;
            }
            return this.c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: x4$f */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.c;
        while (cVar != null && !cVar.c.equals(k)) {
            cVar = cVar.e;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.d;
        }
        a(k, v);
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x4) {
            x4 x4Var = (x4) obj;
            if (this.f != x4Var.f) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = x4Var.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.c, this.d);
        this.e.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f--;
        if (!this.e.isEmpty()) {
            for (f<K, V> fVar : this.e.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.f;
        if (cVar != null) {
            cVar.e = a2.e;
        } else {
            this.c = a2.e;
        }
        c<K, V> cVar2 = a2.e;
        if (cVar2 != null) {
            cVar2.f = a2.f;
        } else {
            this.d = a2.f;
        }
        a2.e = null;
        a2.f = null;
        return a2.d;
    }

    public String toString() {
        StringBuilder a2 = jg.a("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            a2.append(it.next().toString());
            if (it.hasNext()) {
                a2.append(", ");
            }
        }
        a2.append("]");
        return a2.toString();
    }

    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f++;
        c<K, V> cVar2 = this.d;
        if (cVar2 == null) {
            this.c = cVar;
            this.d = this.c;
            return cVar;
        }
        cVar2.e = cVar;
        cVar.f = cVar2;
        this.d = cVar;
        return cVar;
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: x4$e */
    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> c;
        public c<K, V> d;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.c = cVar2;
            this.d = cVar;
        }

        @Override // defpackage.x4.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.c == cVar && cVar == this.d) {
                this.d = null;
                this.c = null;
            }
            c<K, V> cVar3 = this.c;
            if (cVar3 == cVar) {
                this.c = b(cVar3);
            }
            c<K, V> cVar4 = this.d;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.c;
                if (cVar4 != cVar5 && cVar5 != null) {
                    cVar2 = c(cVar4);
                }
                this.d = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.d;
            this.d = a();
            return cVar;
        }

        public final c<K, V> a() {
            c<K, V> cVar = this.d;
            c<K, V> cVar2 = this.c;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    public x4<K, V>.d a() {
        x4<K, V>.d dVar = new d();
        this.e.put(dVar, false);
        return dVar;
    }
}
