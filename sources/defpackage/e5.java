package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: MapCollections.java */
/* renamed from: e5  reason: default package */
/* loaded from: classes.dex */
public abstract class e5<K, V> {
    public e5<K, V>.b a;
    public e5<K, V>.c b;
    public e5<K, V>.e c;

    /* compiled from: MapCollections.java */
    /* renamed from: e5$a */
    /* loaded from: classes.dex */
    public final class a<T> implements Iterator<T> {
        public final int c;
        public int d;
        public int e;
        public boolean f = false;

        public a(int i) {
            this.c = i;
            this.d = e5.this.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.e < this.d;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) e5.this.a(this.e, this.c);
                this.e++;
                this.f = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f) {
                this.e--;
                this.d--;
                this.f = false;
                e5.this.a(this.e);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: e5$b */
    /* loaded from: classes.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int c = e5.this.c();
            for (Map.Entry<K, V> entry : collection) {
                e5.this.a((e5) entry.getKey(), (K) entry.getValue());
            }
            return c != e5.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e5.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int a = e5.this.a(entry.getKey());
                if (a < 0) {
                    return false;
                }
                return b5.a(e5.this.a(a, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e5.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int c = e5.this.c() - 1; c >= 0; c--) {
                Object a = e5.this.a(c, 0);
                Object a2 = e5.this.a(c, 1);
                i += (a == null ? 0 : a.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e5.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e5.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: e5$c */
    /* loaded from: classes.dex */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e5.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return e5.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Map<K, V> b = e5.this.b();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!b.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e5.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int c = e5.this.c() - 1; c >= 0; c--) {
                Object a = e5.this.a(c, 0);
                i += a == null ? 0 : a.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e5.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a = e5.this.a(obj);
            if (a >= 0) {
                e5.this.a(a);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Map<K, V> b = e5.this.b();
            int size = b.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                b.remove(it.next());
            }
            return size != b.size();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return e5.a((Map) e5.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e5.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return e5.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e5.this.a(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: e5$d */
    /* loaded from: classes.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        public int c;
        public boolean e = false;
        public int d = -1;

        public d() {
            this.c = e5.this.c() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.e) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return b5.a(entry.getKey(), e5.this.a(this.d, 0)) && b5.a(entry.getValue(), e5.this.a(this.d, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.e) {
                return (K) e5.this.a(this.d, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.e) {
                return (V) e5.this.a(this.d, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.e) {
                Object a = e5.this.a(this.d, 0);
                Object a2 = e5.this.a(this.d, 1);
                return (a == null ? 0 : a.hashCode()) ^ (a2 != null ? a2.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                this.d++;
                this.e = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.e) {
                e5.this.a(this.d);
                this.d--;
                this.c--;
                this.e = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.e) {
                return (V) e5.this.a(this.d, (int) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: e5$e */
    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            e5.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return e5.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return e5.this.c() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int b = e5.this.b(obj);
            if (b >= 0) {
                e5.this.a(b);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int c = e5.this.c();
            int i = 0;
            boolean z = false;
            while (i < c) {
                if (collection.contains(e5.this.a(i, 1))) {
                    e5.this.a(i);
                    i--;
                    c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int c = e5.this.c();
            int i = 0;
            boolean z = false;
            while (i < c) {
                if (!collection.contains(e5.this.a(i, 1))) {
                    e5.this.a(i);
                    i--;
                    c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return e5.this.c();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return e5.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e5.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract int a(Object obj);

    public abstract Object a(int i, int i2);

    public abstract V a(int i, V v);

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(K k, V v);

    public abstract int b(Object obj);

    public abstract Map<K, V> b();

    public Object[] b(int i) {
        int c2 = c();
        Object[] objArr = new Object[c2];
        for (int i2 = 0; i2 < c2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public abstract int c();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] a(T[] tArr, int i) {
        int c2 = c();
        if (tArr.length < c2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), c2));
        }
        for (int i2 = 0; i2 < c2; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > c2) {
            tArr[c2] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
