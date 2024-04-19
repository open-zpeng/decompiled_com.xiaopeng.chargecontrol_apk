package defpackage;

import defpackage.bw;
import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* renamed from: uu  reason: default package */
/* loaded from: classes.dex */
public final class uu extends ru {
    public final bw<String, ru> a = new bw<>();

    public void a(String str, ru ruVar) {
        bw<String, ru> bwVar = this.a;
        if (ruVar == null) {
            ruVar = tu.a;
        }
        bwVar.put(str, ruVar);
    }

    public boolean b(String str) {
        return this.a.a(str) != null;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof uu) && ((uu) obj).a.equals(this.a));
    }

    public Set<Map.Entry<String, ru>> h() {
        return this.a.entrySet();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void a(String str, String str2) {
        this.a.put(str, str2 == null ? tu.a : new wu(str2));
    }

    public void a(String str, Number number) {
        this.a.put(str, number == null ? tu.a : new wu(number));
    }

    public void a(String str, Boolean bool) {
        this.a.put(str, bool == null ? tu.a : new wu(bool));
    }

    public ru a(String str) {
        bw.e<String, ru> a = this.a.a(str);
        return a != null ? a.i : null;
    }
}
