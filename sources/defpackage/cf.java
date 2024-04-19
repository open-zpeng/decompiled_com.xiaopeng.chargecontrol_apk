package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import defpackage.nf;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: cf  reason: default package */
/* loaded from: classes.dex */
public class cf extends AnimatorListenerAdapter {
    public final /* synthetic */ nf.c0 c;
    public final /* synthetic */ ViewPropertyAnimator d;
    public final /* synthetic */ View e;
    public final /* synthetic */ df f;

    public cf(df dfVar, nf.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f = dfVar;
        this.c = c0Var;
        this.d = viewPropertyAnimator;
        this.e = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.d.setListener(null);
        this.e.setAlpha(1.0f);
        this.f.a(this.c);
        this.f.q.remove(this.c);
        this.f.f();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f.f(this.c);
    }
}
