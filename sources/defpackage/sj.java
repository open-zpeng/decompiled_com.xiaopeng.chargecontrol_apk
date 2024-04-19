package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: Jobs.java */
/* renamed from: sj  reason: default package */
/* loaded from: classes.dex */
public final class sj {
    public final Map<zh, lj<?>> a = new HashMap();
    public final Map<zh, lj<?>> b = new HashMap();

    public final Map<zh, lj<?>> a(boolean z) {
        return z ? this.b : this.a;
    }

    public void b(zh zhVar, lj<?> ljVar) {
        Map<zh, lj<?>> a = a(ljVar.r);
        if (ljVar.equals(a.get(zhVar))) {
            a.remove(zhVar);
        }
    }

    public void a(zh zhVar, lj<?> ljVar) {
        a(ljVar.r).put(zhVar, ljVar);
    }
}
