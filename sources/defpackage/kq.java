package defpackage;
/* compiled from: CachedHashCodeArrayMap.java */
/* renamed from: kq  reason: default package */
/* loaded from: classes.dex */
public final class kq<K, V> extends y4<K, V> {
    public int k;

    @Override // defpackage.f5
    public V a(int i, V v) {
        this.k = 0;
        int i2 = (i << 1) + 1;
        Object[] objArr = this.d;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    @Override // defpackage.f5, java.util.Map
    public void clear() {
        this.k = 0;
        super.clear();
    }

    @Override // defpackage.f5
    public V d(int i) {
        this.k = 0;
        return (V) super.d(i);
    }

    @Override // defpackage.f5, java.util.Map
    public int hashCode() {
        if (this.k == 0) {
            this.k = super.hashCode();
        }
        return this.k;
    }

    @Override // defpackage.f5, java.util.Map
    public V put(K k, V v) {
        this.k = 0;
        return (V) super.put(k, v);
    }

    @Override // defpackage.f5
    public void a(f5<? extends K, ? extends V> f5Var) {
        this.k = 0;
        super.a((f5) f5Var);
    }
}
