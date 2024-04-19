package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* renamed from: fa  reason: default package */
/* loaded from: classes.dex */
public final class fa {
    public WeakReference<View> a;
    public Runnable b = null;
    public Runnable c = null;
    public int d = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: fa$a */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ ga c;
        public final /* synthetic */ View d;

        public a(fa faVar, ga gaVar, View view) {
            this.c = gaVar;
            this.d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.c.a(this.d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.c.b(this.d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.c.c(this.d);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: fa$b */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ia c;
        public final /* synthetic */ View d;

        public b(fa faVar, ia iaVar, View view) {
            this.c = iaVar;
            this.d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) h1.this.d.getParent()).invalidate();
        }
    }

    public fa(View view) {
        this.a = new WeakReference<>(view);
    }

    public fa a(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public fa b(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public fa a(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void a() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public fa a(ga gaVar) {
        View view = this.a.get();
        if (view != null) {
            int i = Build.VERSION.SDK_INT;
            a(view, gaVar);
        }
        return this;
    }

    public final void a(View view, ga gaVar) {
        if (gaVar != null) {
            view.animate().setListener(new a(this, gaVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public fa a(ia iaVar) {
        View view = this.a.get();
        if (view != null) {
            int i = Build.VERSION.SDK_INT;
            view.animate().setUpdateListener(iaVar != null ? new b(this, iaVar, view) : null);
        }
        return this;
    }
}
