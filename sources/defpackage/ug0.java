package defpackage;

import android.animation.Animator;
/* compiled from: SlideLineView.java */
/* renamed from: ug0  reason: default package */
/* loaded from: classes.dex */
public class ug0 implements Animator.AnimatorListener {
    public final /* synthetic */ vg0 c;

    public ug0(vg0 vg0Var) {
        this.c = vg0Var;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.e.setStrokeWidth(4.0f);
        this.c.k.setMaskFilter(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
