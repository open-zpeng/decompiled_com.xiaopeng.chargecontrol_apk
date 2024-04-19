package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
/* compiled from: FragmentAnim.java */
/* renamed from: gc  reason: default package */
/* loaded from: classes.dex */
public class gc extends AnimationSet implements Runnable {
    public final ViewGroup c;
    public final View d;
    public boolean e;
    public boolean f;
    public boolean g;

    public gc(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.g = true;
        this.c = viewGroup;
        this.d = view;
        addAnimation(animation);
        this.c.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        this.g = true;
        if (this.e) {
            return !this.f;
        }
        if (!super.getTransformation(j, transformation)) {
            this.e = true;
            v9.a(this.c, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.e && this.g) {
            this.g = false;
            this.c.post(this);
            return;
        }
        this.c.endViewTransition(this.d);
        this.f = true;
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation, float f) {
        this.g = true;
        if (this.e) {
            return !this.f;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.e = true;
            v9.a(this.c, this);
        }
        return true;
    }
}
