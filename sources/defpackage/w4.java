package defpackage;

import defpackage.x4;
import java.util.HashMap;
/* compiled from: FastSafeIterableMap.java */
/* renamed from: w4  reason: default package */
/* loaded from: classes.dex */
public class w4<K, V> extends x4<K, V> {
    public HashMap<K, x4.c<K, V>> g = new HashMap<>();

    @Override // defpackage.x4
    public x4.c<K, V> a(K k) {
        return this.g.get(k);
    }

    @Override // defpackage.x4
    public V b(K k, V v) {
        x4.c<K, V> cVar = this.g.get(k);
        if (cVar != null) {
            return cVar.d;
        }
        this.g.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.g.containsKey(k);
    }

    @Override // defpackage.x4
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.g.remove(k);
        return v;
    }
}
