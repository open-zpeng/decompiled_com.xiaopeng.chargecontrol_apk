package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import defpackage.ed;
import defpackage.oc;
/* compiled from: FragmentAnim.java */
/* renamed from: ec  reason: default package */
/* loaded from: classes.dex */
public class ec extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Fragment e;
    public final /* synthetic */ ed.a f;
    public final /* synthetic */ m8 g;

    public ec(ViewGroup viewGroup, View view, Fragment fragment, ed.a aVar, m8 m8Var) {
        this.c = viewGroup;
        this.d = view;
        this.e = fragment;
        this.f = aVar;
        this.g = m8Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.endViewTransition(this.d);
        Animator R = this.e.R();
        this.e.a((Animator) null);
        if (R == null || this.c.indexOfChild(this.d) >= 0) {
            return;
        }
        ((oc.d) this.f).a(this.e, this.g);
    }
}
