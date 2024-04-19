package defpackage;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* renamed from: bw  reason: default package */
/* loaded from: classes.dex */
public final class bw<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> j = new a();
    public Comparator<? super K> c;
    public e<K, V> d;
    public int e;
    public int f;
    public final e<K, V> g;
    public bw<K, V>.b h;
    public bw<K, V>.c i;

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: bw$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: bw$b */
    /* loaded from: classes.dex */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: bw$b$a */
        /* loaded from: classes.dex */
        public class a extends bw<K, V>.d<Map.Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            bw.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && bw.this.a((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> a2;
            if ((obj instanceof Map.Entry) && (a2 = bw.this.a((Map.Entry) obj)) != null) {
                bw.this.b(a2, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return bw.this.e;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: bw$c */
    /* loaded from: classes.dex */
    public final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: bw$c$a */
        /* loaded from: classes.dex */
        public class a extends bw<K, V>.d<K> {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().h;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            bw.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return bw.this.a(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            bw bwVar = bw.this;
            e<K, V> a2 = bwVar.a(obj);
            if (a2 != null) {
                bwVar.b(a2, true);
            }
            return a2 != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return bw.this.e;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: bw$d */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {
        public e<K, V> c;
        public e<K, V> d;
        public int e;

        public d() {
            bw bwVar = bw.this;
            this.c = bwVar.g.f;
            this.d = null;
            this.e = bwVar.f;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.c;
            bw bwVar = bw.this;
            if (eVar != bwVar.g) {
                if (bwVar.f == this.e) {
                    this.c = eVar.f;
                    this.d = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c != bw.this.g;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.d;
            if (eVar != null) {
                bw.this.b(eVar, true);
                this.d = null;
                this.e = bw.this.f;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public bw() {
        Comparator<Comparable> comparator = j;
        this.e = 0;
        this.f = 0;
        this.g = new e<>();
        this.c = comparator == null ? j : comparator;
    }

    public e<K, V> a(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.c;
        e<K, V> eVar2 = this.d;
        if (eVar2 != null) {
            Comparable comparable = comparator == j ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(eVar2.h);
                } else {
                    i = comparator.compare(k, (K) eVar2.h);
                }
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.d : eVar2.e;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.g;
            if (eVar2 == null) {
                if (comparator == j && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k, eVar4, eVar4.g);
                this.d = eVar;
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.g);
                if (i < 0) {
                    eVar2.d = eVar;
                } else {
                    eVar2.e = eVar;
                }
                a((e) eVar2, true);
            }
            this.e++;
            this.f++;
            return eVar;
        }
        return null;
    }

    public void b(e<K, V> eVar, boolean z) {
        e<K, V> eVar2;
        int i;
        e<K, V> eVar3;
        if (z) {
            e<K, V> eVar4 = eVar.g;
            eVar4.f = eVar.f;
            eVar.f.g = eVar4;
        }
        e<K, V> eVar5 = eVar.d;
        e<K, V> eVar6 = eVar.e;
        e<K, V> eVar7 = eVar.c;
        int i2 = 0;
        if (eVar5 != null && eVar6 != null) {
            if (eVar5.j > eVar6.j) {
                e<K, V> eVar8 = eVar5.e;
                while (true) {
                    e<K, V> eVar9 = eVar8;
                    eVar3 = eVar5;
                    eVar5 = eVar9;
                    if (eVar5 == null) {
                        break;
                    }
                    eVar8 = eVar5.e;
                }
                eVar2 = eVar3;
            } else {
                e<K, V> eVar10 = eVar6.d;
                while (true) {
                    e<K, V> eVar11 = eVar6;
                    eVar6 = eVar10;
                    eVar2 = eVar11;
                    if (eVar6 == null) {
                        break;
                    }
                    eVar10 = eVar6.d;
                }
            }
            b(eVar2, false);
            e<K, V> eVar12 = eVar.d;
            if (eVar12 != null) {
                i = eVar12.j;
                eVar2.d = eVar12;
                eVar12.c = eVar2;
                eVar.d = null;
            } else {
                i = 0;
            }
            e<K, V> eVar13 = eVar.e;
            if (eVar13 != null) {
                i2 = eVar13.j;
                eVar2.e = eVar13;
                eVar13.c = eVar2;
                eVar.e = null;
            }
            eVar2.j = Math.max(i, i2) + 1;
            a(eVar, eVar2);
            return;
        }
        if (eVar5 != null) {
            a(eVar, eVar5);
            eVar.d = null;
        } else if (eVar6 != null) {
            a(eVar, eVar6);
            eVar.e = null;
        } else {
            a(eVar, (e) null);
        }
        a((e) eVar7, false);
        this.e--;
        this.f++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.d = null;
        this.e = 0;
        this.f++;
        e<K, V> eVar = this.g;
        eVar.g = eVar;
        eVar.f = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        bw<K, V>.b bVar = this.h;
        if (bVar != null) {
            return bVar;
        }
        bw<K, V>.b bVar2 = new b();
        this.h = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        bw<K, V>.c cVar = this.i;
        if (cVar != null) {
            return cVar;
        }
        bw<K, V>.c cVar2 = new c();
        this.i = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            e<K, V> a2 = a((bw<K, V>) k, true);
            V v2 = a2.i;
            a2.i = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            b(a2, true);
        }
        if (a2 != null) {
            return a2.i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.e;
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: bw$e */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {
        public e<K, V> c;
        public e<K, V> d;
        public e<K, V> e;
        public e<K, V> f;
        public e<K, V> g;
        public final K h;
        public V i;
        public int j;

        public e() {
            this.h = null;
            this.g = this;
            this.f = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.h;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.i;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.i;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.h;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.i;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.i;
            this.i = v;
            return v2;
        }

        public String toString() {
            return this.h + "=" + this.i;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.c = eVar;
            this.h = k;
            this.j = 1;
            this.f = eVar2;
            this.g = eVar3;
            eVar3.f = this;
            eVar2.g = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return a((bw<K, V>) obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if ((r3 == r5 || (r3 != null && r3.equals(r5))) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.bw.e<K, V> a(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            bw$e r0 = r4.a(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L23
            V r3 = r0.i
            java.lang.Object r5 = r5.getValue()
            if (r3 == r5) goto L1f
            if (r3 == 0) goto L1d
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L1d
            goto L1f
        L1d:
            r5 = r2
            goto L20
        L1f:
            r5 = r1
        L20:
            if (r5 == 0) goto L23
            goto L24
        L23:
            r1 = r2
        L24:
            if (r1 == 0) goto L27
            goto L28
        L27:
            r0 = 0
        L28:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bw.a(java.util.Map$Entry):bw$e");
    }

    public final void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.c;
        eVar.c = null;
        if (eVar2 != null) {
            eVar2.c = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.d == eVar) {
                eVar3.d = eVar2;
                return;
            } else {
                eVar3.e = eVar2;
                return;
            }
        }
        this.d = eVar2;
    }

    public final void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.d;
            e<K, V> eVar3 = eVar.e;
            int i = eVar2 != null ? eVar2.j : 0;
            int i2 = eVar3 != null ? eVar3.j : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.d;
                e<K, V> eVar5 = eVar3.e;
                int i4 = (eVar4 != null ? eVar4.j : 0) - (eVar5 != null ? eVar5.j : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    b(eVar3);
                    a((e) eVar);
                } else {
                    a((e) eVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.d;
                e<K, V> eVar7 = eVar2.e;
                int i5 = (eVar6 != null ? eVar6.j : 0) - (eVar7 != null ? eVar7.j : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    a((e) eVar2);
                    b(eVar);
                } else {
                    b(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.j = i + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.j = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.c;
        }
    }

    public final void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.d;
        e<K, V> eVar3 = eVar.e;
        e<K, V> eVar4 = eVar2.d;
        e<K, V> eVar5 = eVar2.e;
        eVar.d = eVar5;
        if (eVar5 != null) {
            eVar5.c = eVar;
        }
        a(eVar, eVar2);
        eVar2.e = eVar;
        eVar.c = eVar2;
        eVar.j = Math.max(eVar3 != null ? eVar3.j : 0, eVar5 != null ? eVar5.j : 0) + 1;
        eVar2.j = Math.max(eVar.j, eVar4 != null ? eVar4.j : 0) + 1;
    }

    public final void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.d;
        e<K, V> eVar3 = eVar.e;
        e<K, V> eVar4 = eVar3.d;
        e<K, V> eVar5 = eVar3.e;
        eVar.e = eVar4;
        if (eVar4 != null) {
            eVar4.c = eVar;
        }
        a(eVar, eVar3);
        eVar3.d = eVar;
        eVar.c = eVar3;
        eVar.j = Math.max(eVar2 != null ? eVar2.j : 0, eVar4 != null ? eVar4.j : 0) + 1;
        eVar3.j = Math.max(eVar.j, eVar5 != null ? eVar5.j : 0) + 1;
    }
}
