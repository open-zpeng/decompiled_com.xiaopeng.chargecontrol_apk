package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ld;
import defpackage.qb;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: rb  reason: default package */
/* loaded from: classes.dex */
public class rb extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ View d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ ld.d f;
    public final /* synthetic */ qb.b g;

    public rb(qb qbVar, ViewGroup viewGroup, View view, boolean z, ld.d dVar, qb.b bVar) {
        this.c = viewGroup;
        this.d = view;
        this.e = z;
        this.f = dVar;
        this.g = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.endViewTransition(this.d);
        if (this.e) {
            this.f.a.a(this.d);
        }
        this.g.a();
    }
}
