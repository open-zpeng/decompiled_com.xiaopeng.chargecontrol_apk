package defpackage;
/* compiled from: WebpFrameCacheStrategy.java */
/* renamed from: sh  reason: default package */
/* loaded from: classes.dex */
public final class sh {
    public static final sh c;
    public static final sh d;
    public c a;
    public int b;

    /* compiled from: WebpFrameCacheStrategy.java */
    /* renamed from: sh$b */
    /* loaded from: classes.dex */
    public static final class b {
        public c a;
        public int b;

        public sh a() {
            return new sh(this, null);
        }
    }

    /* compiled from: WebpFrameCacheStrategy.java */
    /* renamed from: sh$c */
    /* loaded from: classes.dex */
    public enum c {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    static {
        b bVar = new b();
        bVar.a = c.CACHE_NONE;
        c = bVar.a();
        b bVar2 = new b();
        bVar2.a = c.CACHE_AUTO;
        d = bVar2.a();
        b bVar3 = new b();
        bVar3.a = c.CACHE_ALL;
        bVar3.a();
    }

    public /* synthetic */ sh(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }
}
