package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* compiled from: ChargingFragment.java */
/* renamed from: m20  reason: default package */
/* loaded from: classes.dex */
public class m20 extends AnimatorListenerAdapter {
    public final /* synthetic */ View c;

    public m20(n20 n20Var, View view) {
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.c.setAlpha(1.0f);
    }
}
