package defpackage;

import defpackage.ai;
import java.security.MessageDigest;
/* compiled from: Options.java */
/* renamed from: bi  reason: default package */
/* loaded from: classes.dex */
public final class bi implements zh {
    public final y4<ai<?>, Object> b = new kq();

    public void a(bi biVar) {
        this.b.a((f5<? extends ai<?>, ? extends Object>) biVar.b);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof bi) {
            return this.b.equals(((bi) obj).b);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder a = jg.a("Options{values=");
        a.append(this.b);
        a.append('}');
        return a.toString();
    }

    public <T> bi a(ai<T> aiVar, T t) {
        this.b.put(aiVar, t);
        return this;
    }

    public <T> T a(ai<T> aiVar) {
        if (this.b.a(aiVar) >= 0) {
            return (T) this.b.getOrDefault(aiVar, null);
        }
        return aiVar.a;
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            y4<ai<?>, Object> y4Var = this.b;
            if (i >= y4Var.e) {
                return;
            }
            ai<?> c = y4Var.c(i);
            Object e = this.b.e(i);
            ai.b<?> bVar = c.b;
            if (c.d == null) {
                c.d = c.c.getBytes(zh.a);
            }
            bVar.a(c.d, e, messageDigest);
            i++;
        }
    }
}
