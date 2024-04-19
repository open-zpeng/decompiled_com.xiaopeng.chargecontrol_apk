package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* compiled from: VuiFloatingDrawable.java */
/* renamed from: we0  reason: default package */
/* loaded from: classes.dex */
public class we0 extends Drawable implements Animatable2 {
    public Bitmap c;
    public ArrayList<Animatable2.AnimationCallback> d;
    public boolean e;
    public boolean f;
    public Paint g;
    public PaintFlagsDrawFilter h;
    public Matrix i;
    public AnimatorSet j;
    public ValueAnimator[] k;
    public ValueAnimator l;
    public ValueAnimator m;
    public ArrayList<Animator> n;
    public ValueAnimator.AnimatorUpdateListener o;
    public ValueAnimator.AnimatorUpdateListener p;
    public Animator.AnimatorListener q;

    /* compiled from: VuiFloatingDrawable.java */
    /* renamed from: we0$a */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            we0.this.g.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            we0.this.invalidateSelf();
        }
    }

    /* compiled from: VuiFloatingDrawable.java */
    /* renamed from: we0$b */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            we0 we0Var = we0.this;
            we0Var.i.setScale(floatValue, floatValue, we0Var.c.getWidth() / 2, we0.this.c.getHeight() / 2);
            we0.this.invalidateSelf();
        }
    }

    /* compiled from: VuiFloatingDrawable.java */
    /* renamed from: we0$c */
    /* loaded from: classes.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            we0.this.a("onAnimationEnd ");
            we0.this.stop();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public we0() {
        this.o = new a();
        this.p = new b();
        this.q = new c();
    }

    @Override // android.graphics.drawable.Animatable2
    public void clearAnimationCallbacks() {
        if (this.d != null) {
            this.d = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.e) {
                this.e = false;
                this.f = true;
                ArrayList<Animatable2.AnimationCallback> arrayList = this.d;
                if (arrayList != null) {
                    Iterator<Animatable2.AnimationCallback> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onAnimationStart(this);
                    }
                }
            }
            if (this.f) {
                canvas.setDrawFilter(this.h);
                canvas.translate(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                canvas.drawBitmap(this.c, this.i, this.g);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            return bitmap.getHeight() + 0;
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            return bitmap.getWidth() + 0;
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f;
    }

    @Override // android.graphics.drawable.Animatable2
    public void registerAnimationCallback(Animatable2.AnimationCallback animationCallback) {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        if (this.d.contains(animationCallback)) {
            return;
        }
        this.d.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (!z) {
            be0.a("VuiFloatingDrawable", "setVisible false ");
            stop();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f) {
            stop();
        }
        this.e = true;
        this.g.setAlpha(0);
        for (ValueAnimator valueAnimator : this.k) {
            valueAnimator.addUpdateListener(this.p);
        }
        this.l.addUpdateListener(this.o);
        this.m.addUpdateListener(this.o);
        this.m.addListener(this.q);
        this.j.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.j.cancel();
        ArrayList<Animator> arrayList = this.n;
        if (arrayList != null) {
            Iterator<Animator> it = arrayList.iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next instanceof ValueAnimator) {
                    ((ValueAnimator) next).removeAllUpdateListeners();
                }
                next.removeAllListeners();
            }
        }
        this.i.reset();
        if (this.f) {
            this.f = false;
            be0.a("VuiFloatingDrawable", "postOnAnimationEnd ");
            ArrayList<Animatable2.AnimationCallback> arrayList2 = this.d;
            if (arrayList2 == null) {
                return;
            }
            Iterator<Animatable2.AnimationCallback> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onAnimationEnd(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable2
    public boolean unregisterAnimationCallback(Animatable2.AnimationCallback animationCallback) {
        ArrayList<Animatable2.AnimationCallback> arrayList = this.d;
        if (arrayList == null || !arrayList.remove(animationCallback)) {
            return false;
        }
        if (this.d.isEmpty()) {
            clearAnimationCallbacks();
            return true;
        }
        return true;
    }

    public final void a(String str) {
        be0.a("VuiFloatingDrawable", str);
    }

    public we0(Bitmap bitmap) {
        this.o = new a();
        this.p = new b();
        this.q = new c();
        this.c = bitmap;
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.i = new Matrix();
        int i = 0;
        this.h = new PaintFlagsDrawFilter(0, 3);
        this.l = ValueAnimator.ofInt(0, XLoadingDrawable.ALPHA_MAX);
        this.l.setDuration(500L);
        this.l.setInterpolator(new DecelerateInterpolator());
        this.k = new ValueAnimator[4];
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        while (true) {
            ValueAnimator[] valueAnimatorArr = this.k;
            if (i < valueAnimatorArr.length) {
                if (i % 2 == 0) {
                    valueAnimatorArr[i] = ValueAnimator.ofFloat(1.0f, 1.05f);
                } else {
                    valueAnimatorArr[i] = ValueAnimator.ofFloat(1.05f, 1.0f);
                }
                this.k[i].setDuration(1000L);
                this.k[i].setInterpolator(decelerateInterpolator);
                i++;
            } else {
                this.m = ValueAnimator.ofInt(XLoadingDrawable.ALPHA_MAX, 0);
                this.m.setDuration(250L);
                this.m.setInterpolator(new AccelerateInterpolator());
                this.j = new AnimatorSet();
                this.n = new ArrayList<>();
                this.n.add(this.l);
                this.n.addAll(Arrays.asList(this.k));
                this.n.add(this.m);
                this.j.playSequentially(this.n);
                return;
            }
        }
    }
}
