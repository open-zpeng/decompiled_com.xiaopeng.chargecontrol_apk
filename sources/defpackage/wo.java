package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: RequestTracker.java */
/* renamed from: wo  reason: default package */
/* loaded from: classes.dex */
public class wo {
    public final Set<np> a = Collections.newSetFromMap(new WeakHashMap());
    public final List<np> b = new ArrayList();
    public boolean c;

    public boolean a(np npVar) {
        boolean z = true;
        if (npVar == null) {
            return true;
        }
        boolean remove = this.a.remove(npVar);
        if (!this.b.remove(npVar) && !remove) {
            z = false;
        }
        if (z) {
            npVar.clear();
        }
        return z;
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
