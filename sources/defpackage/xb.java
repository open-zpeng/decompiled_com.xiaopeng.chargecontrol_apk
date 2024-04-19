package defpackage;

import java.util.ArrayList;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: xb  reason: default package */
/* loaded from: classes.dex */
public class xb implements Runnable {
    public final /* synthetic */ ArrayList c;

    public xb(qb qbVar, ArrayList arrayList) {
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        ed.a(this.c, 4);
    }
}
