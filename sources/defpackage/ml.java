package defpackage;

import java.util.Queue;
/* compiled from: ModelCache.java */
/* renamed from: ml  reason: default package */
/* loaded from: classes.dex */
public class ml<A, B> {
    public final pq<b<A>, B> a;

    /* compiled from: ModelCache.java */
    /* renamed from: ml$a */
    /* loaded from: classes.dex */
    public class a extends pq<b<A>, B> {
        public a(ml mlVar, long j) {
            super(j);
        }

        @Override // defpackage.pq
        public void a(Object obj, Object obj2) {
            ((b) obj).a();
        }
    }

    public ml(long j) {
        this.a = new a(this, j);
    }

    public B a(A a2, int i, int i2) {
        b<A> a3 = b.a(a2, i, i2);
        B a4 = this.a.a((pq<b<A>, B>) a3);
        a3.a();
        return a4;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.a.b(b.a(a2, i, i2), b2);
    }

    /* compiled from: ModelCache.java */
    /* renamed from: ml$b */
    /* loaded from: classes.dex */
    public static final class b<A> {
        public static final Queue<b<?>> d = sq.a(0);
        public int a;
        public int b;
        public A c;

        public static <A> b<A> a(A a, int i, int i2) {
            b<A> bVar;
            synchronized (d) {
                bVar = (b<A>) d.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.c = a;
            bVar.b = i;
            bVar.a = i2;
            return bVar;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c);
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + (((this.a * 31) + this.b) * 31);
        }

        public void a() {
            synchronized (d) {
                d.offer(this);
            }
        }
    }
}
