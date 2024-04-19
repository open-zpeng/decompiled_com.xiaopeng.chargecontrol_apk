package defpackage;
/* compiled from: PropertyInfo.java */
/* renamed from: d00  reason: default package */
/* loaded from: classes.dex */
public class d00<T> {
    public final zy<T> a;
    public final e00<T> b;
    public final long c;
    public final boolean d;
    public long e;

    /* compiled from: PropertyInfo.java */
    /* renamed from: d00$b */
    /* loaded from: classes.dex */
    public static class b<T> {
        public final zy<T> a;
        public e00<T> b;
        public long c;
        public boolean d = true;

        public /* synthetic */ b(zy zyVar, a aVar) {
            this.a = zyVar;
        }

        public d00<T> a() {
            return new d00<>(this.a, this.b, this.c, this.d, null);
        }
    }

    public /* synthetic */ d00(zy zyVar, e00 e00Var, long j, boolean z, a aVar) {
        this.a = zyVar;
        this.b = e00Var;
        this.c = j;
        this.d = z;
    }

    public static <T> d00<T> a(zy<T> zyVar, e00<T> e00Var, long j) {
        b b2 = b(zyVar);
        b2.b = e00Var;
        b2.c = j;
        return b2.a();
    }

    public static <T> b<T> b(zy<T> zyVar) {
        return new b<>(zyVar, null);
    }

    public static <T> d00<T> a(zy<T> zyVar, e00<T> e00Var) {
        return a(zyVar, e00Var, 0L);
    }

    public static <T> d00<T> a(zy<T> zyVar) {
        return a(zyVar, null);
    }
}
