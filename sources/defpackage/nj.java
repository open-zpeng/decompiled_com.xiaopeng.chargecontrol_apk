package defpackage;

import java.security.MessageDigest;
import java.util.Map;
/* compiled from: EngineKey.java */
/* renamed from: nj  reason: default package */
/* loaded from: classes.dex */
public class nj implements zh {
    public final Object b;
    public final int c;
    public final int d;
    public final Class<?> e;
    public final Class<?> f;
    public final zh g;
    public final Map<Class<?>, fi<?>> h;
    public final bi i;
    public int j;

    public nj(Object obj, zh zhVar, int i, int i2, Map<Class<?>, fi<?>> map, Class<?> cls, Class<?> cls2, bi biVar) {
        a.a(obj, "Argument must not be null");
        this.b = obj;
        a.a(zhVar, "Signature must not be null");
        this.g = zhVar;
        this.c = i;
        this.d = i2;
        a.a(map, "Argument must not be null");
        this.h = map;
        a.a(cls, "Resource class must not be null");
        this.e = cls;
        a.a(cls2, "Transcode class must not be null");
        this.f = cls2;
        a.a(biVar, "Argument must not be null");
        this.i = biVar;
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof nj) {
            nj njVar = (nj) obj;
            return this.b.equals(njVar.b) && this.g.equals(njVar.g) && this.d == njVar.d && this.c == njVar.c && this.h.equals(njVar.h) && this.e.equals(njVar.e) && this.f.equals(njVar.f) && this.i.equals(njVar.i);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        if (this.j == 0) {
            this.j = this.b.hashCode();
            this.j = this.g.hashCode() + (this.j * 31);
            this.j = (this.j * 31) + this.c;
            this.j = (this.j * 31) + this.d;
            this.j = this.h.hashCode() + (this.j * 31);
            this.j = this.e.hashCode() + (this.j * 31);
            this.j = this.f.hashCode() + (this.j * 31);
            this.j = this.i.hashCode() + (this.j * 31);
        }
        return this.j;
    }

    public String toString() {
        StringBuilder a = jg.a("EngineKey{model=");
        a.append(this.b);
        a.append(", width=");
        a.append(this.c);
        a.append(", height=");
        a.append(this.d);
        a.append(", resourceClass=");
        a.append(this.e);
        a.append(", transcodeClass=");
        a.append(this.f);
        a.append(", signature=");
        a.append(this.g);
        a.append(", hashCode=");
        a.append(this.j);
        a.append(", transformations=");
        a.append(this.h);
        a.append(", options=");
        a.append(this.i);
        a.append('}');
        return a.toString();
    }
}
