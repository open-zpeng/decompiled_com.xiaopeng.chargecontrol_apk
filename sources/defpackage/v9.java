package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: OneShotPreDrawListener.java */
/* renamed from: v9  reason: default package */
/* loaded from: classes.dex */
public final class v9 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View c;
    public ViewTreeObserver d;
    public final Runnable e;

    public v9(View view, Runnable runnable) {
        this.c = view;
        this.d = view.getViewTreeObserver();
        this.e = runnable;
    }

    public static v9 a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                v9 v9Var = new v9(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(v9Var);
                view.addOnAttachStateChangeListener(v9Var);
                return v9Var;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.e.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.d = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.d.isAlive()) {
            this.d.removeOnPreDrawListener(this);
        } else {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.c.removeOnAttachStateChangeListener(this);
    }
}
