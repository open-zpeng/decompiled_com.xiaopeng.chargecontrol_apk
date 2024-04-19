package defpackage;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* compiled from: ResourceCacheKey.java */
/* renamed from: xj  reason: default package */
/* loaded from: classes.dex */
public final class xj implements zh {
    public static final pq<Class<?>, byte[]> j = new pq<>(50);
    public final ck b;
    public final zh c;
    public final zh d;
    public final int e;
    public final int f;
    public final Class<?> g;
    public final bi h;
    public final fi<?> i;

    public xj(ck ckVar, zh zhVar, zh zhVar2, int i, int i2, fi<?> fiVar, Class<?> cls, bi biVar) {
        this.b = ckVar;
        this.c = zhVar;
        this.d = zhVar2;
        this.e = i;
        this.f = i2;
        this.i = fiVar;
        this.g = cls;
        this.h = biVar;
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) ((jk) this.b).c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.a(messageDigest);
        this.c.a(messageDigest);
        messageDigest.update(bArr);
        fi<?> fiVar = this.i;
        if (fiVar != null) {
            fiVar.a(messageDigest);
        }
        this.h.a(messageDigest);
        byte[] a = j.a((pq<Class<?>, byte[]>) this.g);
        if (a == null) {
            a = this.g.getName().getBytes(zh.a);
            j.b(this.g, a);
        }
        messageDigest.update(a);
        ((jk) this.b).a((jk) bArr);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof xj) {
            xj xjVar = (xj) obj;
            return this.f == xjVar.f && this.e == xjVar.e && sq.b(this.i, xjVar.i) && this.g.equals(xjVar.g) && this.c.equals(xjVar.c) && this.d.equals(xjVar.d) && this.h.equals(xjVar.h);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        int hashCode = ((((this.d.hashCode() + (this.c.hashCode() * 31)) * 31) + this.e) * 31) + this.f;
        fi<?> fiVar = this.i;
        if (fiVar != null) {
            hashCode = (hashCode * 31) + fiVar.hashCode();
        }
        int hashCode2 = this.g.hashCode();
        return this.h.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder a = jg.a("ResourceCacheKey{sourceKey=");
        a.append(this.c);
        a.append(", signature=");
        a.append(this.d);
        a.append(", width=");
        a.append(this.e);
        a.append(", height=");
        a.append(this.f);
        a.append(", decodedResourceClass=");
        a.append(this.g);
        a.append(", transformation='");
        a.append(this.i);
        a.append('\'');
        a.append(", options=");
        a.append(this.h);
        a.append('}');
        return a.toString();
    }
}
