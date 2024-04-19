package defpackage;

import android.animation.ValueAnimator;
/* compiled from: SlideLineView.java */
/* renamed from: tg0  reason: default package */
/* loaded from: classes.dex */
public class tg0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ vg0 c;

    public tg0(vg0 vg0Var) {
        this.c = vg0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.c.invalidate();
    }
}
