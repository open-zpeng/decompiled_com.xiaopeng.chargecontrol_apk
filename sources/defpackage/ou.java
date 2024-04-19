package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* renamed from: ou  reason: default package */
/* loaded from: classes.dex */
public final class ou extends ru implements Iterable<ru> {
    public final List<ru> c = new ArrayList();

    public void a(ru ruVar) {
        if (ruVar == null) {
            ruVar = tu.a;
        }
        this.c.add(ruVar);
    }

    @Override // defpackage.ru
    public int b() {
        if (this.c.size() == 1) {
            return this.c.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.ru
    public String d() {
        if (this.c.size() == 1) {
            return this.c.get(0).d();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof ou) && ((ou) obj).c.equals(this.c));
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<ru> iterator() {
        return this.c.iterator();
    }

    @Override // defpackage.ru
    public boolean a() {
        if (this.c.size() == 1) {
            return this.c.get(0).a();
        }
        throw new IllegalStateException();
    }
}
