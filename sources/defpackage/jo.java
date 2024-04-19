package defpackage;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: ActivityFragmentLifecycle.java */
/* renamed from: jo  reason: default package */
/* loaded from: classes.dex */
public class jo implements qo {
    public final Set<ro> a = Collections.newSetFromMap(new WeakHashMap());
    public boolean b;
    public boolean c;

    @Override // defpackage.qo
    public void a(ro roVar) {
        this.a.add(roVar);
        if (this.c) {
            roVar.b();
        } else if (this.b) {
            roVar.onStart();
        } else {
            roVar.a();
        }
    }

    @Override // defpackage.qo
    public void b(ro roVar) {
        this.a.remove(roVar);
    }

    public void c() {
        this.b = false;
        for (ro roVar : sq.a(this.a)) {
            roVar.a();
        }
    }

    public void b() {
        this.b = true;
        for (ro roVar : sq.a(this.a)) {
            roVar.onStart();
        }
    }

    public void a() {
        this.c = true;
        for (ro roVar : sq.a(this.a)) {
            roVar.b();
        }
    }
}
