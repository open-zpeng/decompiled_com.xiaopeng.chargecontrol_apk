package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaopeng.libtheme.ThemeManager;
import defpackage.xe0;
/* compiled from: VuiFloatingView.java */
@SuppressLint({"ViewConstructor"})
/* renamed from: ye0  reason: default package */
/* loaded from: classes.dex */
public class ye0 extends FrameLayout {
    public Context c;
    public ImageView d;
    public Drawable e;
    public we0 f;
    public AnimatedImageDrawable g;
    public int h;
    public c i;
    public boolean j;
    public boolean k;
    public AlphaAnimation l;
    public b m;
    public Animatable2.AnimationCallback n;

    /* compiled from: VuiFloatingView.java */
    /* renamed from: ye0$a */
    /* loaded from: classes.dex */
    public class a extends Animatable2.AnimationCallback {
        public a() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            b bVar = ye0.this.m;
            if (bVar != null) {
                xe0.a aVar = (xe0.a) bVar;
                xe0.this.a("onAnimationEnd ");
                xe0.this.d(aVar.a);
            }
            ye0.this.e();
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
            b bVar = ye0.this.m;
            if (bVar != null) {
                xe0.this.a("onAnimationStart ");
            }
        }
    }

    /* compiled from: VuiFloatingView.java */
    /* renamed from: ye0$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: VuiFloatingView.java */
    /* renamed from: ye0$c */
    /* loaded from: classes.dex */
    public interface c {
        void a(int i);
    }

    public ye0(Context context, int i) {
        super(context);
        this.k = true;
        this.n = new a();
        this.c = context;
        this.h = i;
        this.d = (ImageView) LayoutInflater.from(this.c).inflate(ad0.vui_floating, this).findViewById(yc0.floating_view);
        ze0.a();
    }

    public void a(int i, int i2) {
        int i3 = ee0.a().widthPixels;
        int i4 = ee0.a().heightPixels;
        int visibleWidth = getVisibleWidth();
        int visibleHeight = getVisibleHeight();
        if (i >= 0) {
            int i5 = i + visibleWidth;
            i = i5 > i3 ? i5 - i3 : 0;
        }
        if (i2 >= 0) {
            int i6 = i2 + visibleHeight;
            i2 = i6 > i4 ? i6 - i4 : 0;
        }
        this.d.setX(i);
        this.d.setY(i2);
        be0.a("VuiFloatingView", "setLocation x " + i + " , y " + i2);
    }

    public void b() {
        this.k = true;
    }

    public void c() {
        AnimatedImageDrawable animatedImageDrawable = this.g;
        if (animatedImageDrawable != null) {
            if (!animatedImageDrawable.isRunning()) {
                this.g.start();
            }
            AlphaAnimation alphaAnimation = this.l;
            if (alphaAnimation != null) {
                this.d.startAnimation(alphaAnimation);
            }
        }
        we0 we0Var = this.f;
        if (we0Var != null) {
            we0Var.start();
        }
    }

    public void d() {
        AnimatedImageDrawable animatedImageDrawable = this.g;
        if (animatedImageDrawable != null && animatedImageDrawable.isRunning()) {
            this.g.stop();
        }
        AlphaAnimation alphaAnimation = this.l;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        we0 we0Var = this.f;
        if (we0Var != null) {
            we0Var.stop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        c cVar;
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 4) && (cVar = this.i) != null) {
            cVar.a(this.h);
            if (this.g != null) {
                b();
                return true;
            }
            return true;
        }
        return true;
    }

    public void e() {
        this.m = null;
        AnimatedImageDrawable animatedImageDrawable = this.g;
        if (animatedImageDrawable != null) {
            animatedImageDrawable.unregisterAnimationCallback(this.n);
        }
        we0 we0Var = this.f;
        if (we0Var != null) {
            we0Var.unregisterAnimationCallback(this.n);
        }
    }

    public int getVisibleHeight() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    public int getVisibleWidth() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder a2 = jg.a("onAttachedToWindow type : ");
        a2.append(this.h);
        be0.c("VuiFloatingView", a2.toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder a2 = jg.a("onDetachedFromWindow type : ");
        a2.append(this.h);
        be0.a("VuiFloatingView", a2.toString());
    }

    public void setOnTouchListener(c cVar) {
        this.i = cVar;
    }

    public void a() {
        if (ze0.b(this.h)) {
            boolean isNightMode = ThemeManager.isNightMode(getContext());
            if (this.j != isNightMode || this.k) {
                a(ze0.a(this.c, this.h, isNightMode));
                be0.a("VuiFloatingView", "checkAnimatorDrawable isNight " + isNightMode + " ,mNeedReLoadDrawable " + this.k);
                this.j = isNightMode;
                this.k = false;
            }
        } else if (this.k) {
            a(ze0.a(this.c, this.h, false));
            be0.a("VuiFloatingView", "checkAnimatorDrawable mNeedReLoadDrawable " + this.k);
            this.k = false;
        }
    }

    @SuppressLint({"NewApi"})
    public final void a(Drawable drawable) {
        if (drawable == null) {
            be0.b("VuiFloatingView", "refreshAnimatorDrawable drawable is null");
            return;
        }
        this.d.setImageDrawable(drawable);
        this.e = drawable;
        if (drawable instanceof AnimatedImageDrawable) {
            this.g = (AnimatedImageDrawable) drawable;
            this.g.setRepeatCount(0);
        } else if (drawable instanceof we0) {
            this.f = (we0) drawable;
        } else {
            be0.b("VuiFloatingView", "refreshAnimatorDrawable drawable is not AnimatedImageDrawable");
        }
    }

    public void a(b bVar) {
        this.m = bVar;
        AnimatedImageDrawable animatedImageDrawable = this.g;
        if (animatedImageDrawable != null) {
            animatedImageDrawable.unregisterAnimationCallback(this.n);
            this.g.registerAnimationCallback(this.n);
        }
        we0 we0Var = this.f;
        if (we0Var != null) {
            we0Var.registerAnimationCallback(this.n);
        }
    }
}
