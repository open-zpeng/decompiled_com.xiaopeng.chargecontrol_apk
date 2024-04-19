package defpackage;

import defpackage.qb;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: yb  reason: default package */
/* loaded from: classes.dex */
public class yb implements Runnable {
    public final /* synthetic */ qb.d c;

    public yb(qb qbVar, qb.d dVar) {
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a();
    }
}
