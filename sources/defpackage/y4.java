package defpackage;

import defpackage.e5;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* renamed from: y4  reason: default package */
/* loaded from: classes.dex */
public class y4<K, V> extends f5<K, V> implements Map<K, V> {
    public e5<K, V> j;

    /* compiled from: ArrayMap.java */
    /* renamed from: y4$a */
    /* loaded from: classes.dex */
    public class a extends e5<K, V> {
        public a() {
        }

        @Override // defpackage.e5
        public Object a(int i, int i2) {
            return y4.this.d[(i << 1) + i2];
        }

        @Override // defpackage.e5
        public int b(Object obj) {
            return y4.this.b(obj);
        }

        @Override // defpackage.e5
        public int c() {
            return y4.this.e;
        }

        @Override // defpackage.e5
        public int a(Object obj) {
            return y4.this.a(obj);
        }

        @Override // defpackage.e5
        public Map<K, V> b() {
            return y4.this;
        }

        @Override // defpackage.e5
        public void a(K k, V v) {
            y4.this.put(k, v);
        }

        @Override // defpackage.e5
        public V a(int i, V v) {
            return y4.this.a(i, (int) v);
        }

        @Override // defpackage.e5
        public void a(int i) {
            y4.this.d(i);
        }

        @Override // defpackage.e5
        public void a() {
            y4.this.clear();
        }
    }

    public final e5<K, V> b() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e5<K, V> b = b();
        if (b.a == null) {
            b.a = new e5.b();
        }
        return b.a;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        e5<K, V> b = b();
        if (b.b == null) {
            b.b = new e5.c();
        }
        return b.b;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.e);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        e5<K, V> b = b();
        if (b.c == null) {
            b.c = new e5.e();
        }
        return b.c;
    }
}
