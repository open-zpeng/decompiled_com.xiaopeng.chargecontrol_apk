package defpackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* compiled from: ViewModelStore.java */
/* renamed from: ne  reason: default package */
/* loaded from: classes.dex */
public class ne {
    public final HashMap<String, je> a = new HashMap<>();

    public final je a(String str) {
        return this.a.get(str);
    }

    public Set<String> b() {
        return new HashSet(this.a.keySet());
    }

    public final void a() {
        for (je jeVar : this.a.values()) {
            jeVar.a();
        }
        this.a.clear();
    }
}
