package defpackage;

import android.view.View;
import android.view.ViewGroup;
import defpackage.m8;
import defpackage.qb;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: ub  reason: default package */
/* loaded from: classes.dex */
public class ub implements m8.a {
    public final /* synthetic */ View a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ qb.b c;

    public ub(qb qbVar, View view, ViewGroup viewGroup, qb.b bVar) {
        this.a = view;
        this.b = viewGroup;
        this.c = bVar;
    }

    @Override // defpackage.m8.a
    public void a() {
        this.a.clearAnimation();
        this.b.endViewTransition(this.a);
        this.c.a();
    }
}
