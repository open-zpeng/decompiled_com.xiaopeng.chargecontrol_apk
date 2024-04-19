package defpackage;

import android.view.View;
import defpackage.ld;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: vb  reason: default package */
/* loaded from: classes.dex */
public class vb implements Runnable {
    public final /* synthetic */ ld.d c;
    public final /* synthetic */ ld.d d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ y4 f;

    public vb(qb qbVar, ld.d dVar, ld.d dVar2, boolean z, y4 y4Var) {
        this.c = dVar;
        this.d = dVar2;
        this.e = z;
        this.f = y4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        ed.a(this.c.c, this.d.c, this.e, (y4<String, View>) this.f, false);
    }
}
