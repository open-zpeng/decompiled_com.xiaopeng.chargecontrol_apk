package defpackage;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: TargetTracker.java */
/* renamed from: yo  reason: default package */
/* loaded from: classes.dex */
public final class yo implements ro {
    public final Set<cq<?>> c = Collections.newSetFromMap(new WeakHashMap());

    @Override // defpackage.ro
    public void a() {
        for (cq cqVar : sq.a(this.c)) {
            cqVar.a();
        }
    }

    @Override // defpackage.ro
    public void b() {
        for (cq cqVar : sq.a(this.c)) {
            cqVar.b();
        }
    }

    @Override // defpackage.ro
    public void onStart() {
        for (cq cqVar : sq.a(this.c)) {
            cqVar.onStart();
        }
    }
}
