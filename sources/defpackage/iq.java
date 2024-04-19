package defpackage;

import java.security.MessageDigest;
/* compiled from: ObjectKey.java */
/* renamed from: iq  reason: default package */
/* loaded from: classes.dex */
public final class iq implements zh {
    public final Object b;

    public iq(Object obj) {
        a.a(obj, "Argument must not be null");
        this.b = obj;
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(zh.a));
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof iq) {
            return this.b.equals(((iq) obj).b);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder a = jg.a("ObjectKey{object=");
        a.append(this.b);
        a.append('}');
        return a.toString();
    }
}
