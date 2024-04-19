package defpackage;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* compiled from: LruArrayPool.java */
/* renamed from: jk  reason: default package */
/* loaded from: classes.dex */
public final class jk implements ck {
    public final hk<a, Object> a = new hk<>();
    public final b b = new b();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
    public final Map<Class<?>, bk<?>> d = new HashMap();
    public final int e;
    public int f;

    /* compiled from: LruArrayPool.java */
    /* renamed from: jk$a */
    /* loaded from: classes.dex */
    public static final class a implements mk {
        public final b a;
        public int b;
        public Class<?> c;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // defpackage.mk
        public void a() {
            this.a.a(this);
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.b == aVar.b && this.c == aVar.c;
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class<?> cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            StringBuilder a = jg.a("Key{size=");
            a.append(this.b);
            a.append("array=");
            a.append(this.c);
            a.append('}');
            return a.toString();
        }
    }

    public jk(int i) {
        this.e = i;
    }

    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        a((jk) t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0047, B:19:0x003a), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0047, B:19:0x003a), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0047, B:19:0x003a), top: B:26:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized <T> T b(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.b(r7)     // Catch: java.lang.Throwable -> L4d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2c
            int r3 = r5.f     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L20
            int r4 = r5.e     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 / r3
            r3 = 2
            if (r4 < r3) goto L1e
            goto L20
        L1e:
            r3 = r2
            goto L21
        L20:
            r3 = r1
        L21:
            if (r3 != 0) goto L2d
            int r3 = r0.intValue()     // Catch: java.lang.Throwable -> L4d
            int r4 = r6 * 8
            if (r3 > r4) goto L2c
            goto L2d
        L2c:
            r1 = r2
        L2d:
            if (r1 == 0) goto L3a
            jk$b r6 = r5.b     // Catch: java.lang.Throwable -> L4d
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L4d
            jk$a r6 = r6.a(r0, r7)     // Catch: java.lang.Throwable -> L4d
            goto L47
        L3a:
            jk$b r0 = r5.b     // Catch: java.lang.Throwable -> L4d
            mk r0 = r0.b()     // Catch: java.lang.Throwable -> L4d
            jk$a r0 = (defpackage.jk.a) r0     // Catch: java.lang.Throwable -> L4d
            r0.b = r6     // Catch: java.lang.Throwable -> L4d
            r0.c = r7     // Catch: java.lang.Throwable -> L4d
            r6 = r0
        L47:
            java.lang.Object r6 = r5.a(r6, r7)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r5)
            return r6
        L4d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jk.b(int, java.lang.Class):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized <T> T c(int i, Class<T> cls) {
        a b2;
        b2 = this.b.b();
        b2.b = i;
        b2.c = cls;
        return (T) a(b2, (Class<Object>) cls);
    }

    public synchronized <T> void a(T t) {
        Class<?> cls = t.getClass();
        bk<T> a2 = a((Class) cls);
        int a3 = a2.a(t);
        int b2 = a2.b() * a3;
        int i = 1;
        if (b2 <= this.e / 2) {
            a a4 = this.b.a(a3, cls);
            this.a.a(a4, t);
            NavigableMap<Integer, Integer> b3 = b(cls);
            Integer num = (Integer) b3.get(Integer.valueOf(a4.b));
            Integer valueOf = Integer.valueOf(a4.b);
            if (num != null) {
                i = 1 + num.intValue();
            }
            b3.put(valueOf, Integer.valueOf(i));
            this.f += b2;
            a(this.e);
        }
    }

    /* compiled from: LruArrayPool.java */
    /* renamed from: jk$b */
    /* loaded from: classes.dex */
    public static final class b extends dk<a> {
        public a a(int i, Class<?> cls) {
            a b = b();
            b.b = i;
            b.c = cls;
            return b;
        }

        @Override // defpackage.dk
        public a a() {
            return new a(this);
        }
    }

    public synchronized void b(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                a(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    public final <T> T a(a aVar, Class<T> cls) {
        bk<T> a2 = a((Class) cls);
        T t = (T) this.a.a((hk<a, Object>) aVar);
        if (t != null) {
            this.f -= a2.b() * a2.a(t);
            a(a2.a(t), (Class<?>) cls);
        }
        if (t == null) {
            if (Log.isLoggable(a2.a(), 2)) {
                String a3 = a2.a();
                StringBuilder a4 = jg.a("Allocated ");
                a4.append(aVar.b);
                a4.append(" bytes");
                Log.v(a3, a4.toString());
            }
            return a2.newArray(aVar.b);
        }
        return t;
    }

    public synchronized void a() {
        a(0);
    }

    public final void a(int i) {
        while (this.f > i) {
            Object a2 = this.a.a();
            defpackage.a.a(a2, "Argument must not be null");
            bk a3 = a((Class) a2.getClass());
            this.f -= a3.b() * a3.a(a2);
            a(a3.a(a2), a2.getClass());
            if (Log.isLoggable(a3.a(), 2)) {
                String a4 = a3.a();
                StringBuilder a5 = jg.a("evicted: ");
                a5.append(a3.a(a2));
                Log.v(a4, a5.toString());
            }
        }
    }

    public final void a(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> b2 = b(cls);
        Integer num = (Integer) b2.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                b2.remove(Integer.valueOf(i));
                return;
            } else {
                b2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public final <T> bk<T> a(Class<T> cls) {
        ik ikVar = (bk<T>) this.d.get(cls);
        if (ikVar == null) {
            if (cls.equals(int[].class)) {
                ikVar = new ik();
            } else if (cls.equals(byte[].class)) {
                ikVar = new gk();
            } else {
                StringBuilder a2 = jg.a("No array pool found for: ");
                a2.append(cls.getSimpleName());
                throw new IllegalArgumentException(a2.toString());
            }
            this.d.put(cls, ikVar);
        }
        return ikVar;
    }
}
