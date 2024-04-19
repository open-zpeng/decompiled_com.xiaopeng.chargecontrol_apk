package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.xiaopeng.xui.widget.quicksidebar.XQuickSideBarTipsView;
/* compiled from: XQuickSideBarTipsView.java */
/* renamed from: mg0  reason: default package */
/* loaded from: classes.dex */
public class mg0 extends AnimatorListenerAdapter {
    public final /* synthetic */ XQuickSideBarTipsView c;

    public mg0(XQuickSideBarTipsView xQuickSideBarTipsView) {
        this.c = xQuickSideBarTipsView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.setVisibility(4);
        this.c.setAlpha(1.0f);
    }
}
