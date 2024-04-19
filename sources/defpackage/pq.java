package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: LruCache.java */
/* renamed from: pq  reason: default package */
/* loaded from: classes.dex */
public class pq<T, Y> {
    public final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    public long b;
    public long c;

    public pq(long j) {
        this.b = j;
    }

    public synchronized Y a(T t) {
        return this.a.get(t);
    }

    public void a(T t, Y y) {
    }

    public int b(Y y) {
        return 1;
    }

    public synchronized long b() {
        return this.b;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.a.remove(t);
        if (remove != null) {
            this.c -= b(remove);
        }
        return remove;
    }

    public void a() {
        a(0L);
    }

    public synchronized Y b(T t, Y y) {
        long b = b(y);
        if (b >= this.b) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.c += b;
        }
        Y put = this.a.put(t, y);
        if (put != null) {
            this.c -= b(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        a(this.b);
        return put;
    }

    public synchronized void a(long j) {
        while (this.c > j) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.c -= b(value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }
}
