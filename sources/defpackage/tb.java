package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import defpackage.qb;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: tb  reason: default package */
/* loaded from: classes.dex */
public class tb implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ qb.b c;

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: tb$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tb tbVar = tb.this;
            tbVar.a.endViewTransition(tbVar.b);
            tb.this.c.a();
        }
    }

    public tb(qb qbVar, ViewGroup viewGroup, View view, qb.b bVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
