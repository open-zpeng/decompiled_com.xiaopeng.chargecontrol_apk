package defpackage;

import java.security.MessageDigest;
/* compiled from: DataCacheKey.java */
/* renamed from: dj  reason: default package */
/* loaded from: classes.dex */
public final class dj implements zh {
    public final zh b;
    public final zh c;

    public dj(zh zhVar, zh zhVar2) {
        this.b = zhVar;
        this.c = zhVar2;
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof dj) {
            dj djVar = (dj) obj;
            return this.b.equals(djVar.b) && this.c.equals(djVar.c);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a = jg.a("DataCacheKey{sourceKey=");
        a.append(this.b);
        a.append(", signature=");
        a.append(this.c);
        a.append('}');
        return a.toString();
    }
}
