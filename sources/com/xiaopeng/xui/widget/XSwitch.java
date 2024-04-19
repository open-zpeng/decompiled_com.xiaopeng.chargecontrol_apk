package com.xiaopeng.xui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.ae0;
/* loaded from: classes.dex */
public class XSwitch extends mf0 implements ValueAnimator.AnimatorUpdateListener {
    public float A;
    public float A0;
    public float B;
    public Shader B0;
    public float C;
    public int C0;
    public final float D;
    public int D0;
    public float E;
    public int E0;
    public float F;
    public int F0;
    public float G;
    public Shader G0;
    public final float H;
    public int H0;
    public final float I;
    public int I0;
    public final float J;
    public int J0;
    public final float K;
    public int K0;
    public int L;
    public int L0;
    public int M;
    public int M0;
    public int N;
    public int N0;
    public int O;
    public float O0;
    public int P;
    public float P0;
    public int Q;
    public float Q0;
    public int R;
    public float R0;
    public int S;
    public float S0;
    public int T;
    public int T0;
    public int U;
    public ValueAnimator U0;
    public int V;
    public int V0;
    public int W;
    public b W0;
    public boolean X0;
    public ArgbEvaluator Y0;
    public boolean Z0;
    public int a0;
    public boolean a1;
    public int b0;
    public float b1;
    public int c0;
    public Paint d;
    public int d0;
    public Paint e;
    public Shader e0;
    public float f;
    public int f0;
    public BlurMaskFilter g;
    public int g0;
    public Xfermode h;
    public int h0;
    public float i;
    public int i0;
    public final float j;
    public int j0;
    public final float k;
    public int k0;
    public float l;
    public int l0;
    public float m;
    public int m0;
    public float n;
    public int n0;
    public final float o;
    public int o0;
    public float p;
    public int p0;
    public float q;
    public int q0;
    public final float r;
    public Shader r0;
    public float s;
    public final float s0;
    public float t;
    public final float t0;
    public float u;
    public float u0;
    public float v;
    public float v0;
    public float w;
    public float w0;
    public final float x;
    public float x0;
    public float y;
    public int y0;
    public float z;
    public float z0;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            XSwitch.this.U0.removeAllUpdateListeners();
            XSwitch.this.U0.removeAllListeners();
            XSwitch.this.U0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            XSwitch.this.U0.removeAllUpdateListeners();
            XSwitch.this.U0.removeAllListeners();
            XSwitch.this.U0 = null;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        default boolean a() {
            return false;
        }

        boolean a(View view, boolean z);
    }

    public XSwitch(Context context) {
        this(context, null);
    }

    public final void a(int i, int i2) {
        this.e0 = new LinearGradient((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.l, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.n, i, i2, Shader.TileMode.CLAMP);
    }

    public final void b(int i, int i2) {
        this.B0 = new LinearGradient((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.q, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.v, i, i2, Shader.TileMode.CLAMP);
    }

    public final void c(int i, int i2) {
        this.r0 = new LinearGradient((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.q, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.v, i, i2, Shader.TileMode.CLAMP);
    }

    public final void d(int i) {
        this.U0 = ValueAnimator.ofInt(this.V0, i);
        this.U0.setDuration(Math.abs(i - this.V0));
        this.U0.addUpdateListener(this);
        this.U0.addListener(new a());
        this.U0.start();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.V0 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.b1 = (this.V0 - 200) / 300.0f;
        y();
    }

    @Override // defpackage.mf0, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Z0 && this.a1 != w()) {
            this.Z0 = false;
            v();
        }
        x();
        t();
    }

    @Override // defpackage.mf0, android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            v();
        }
    }

    @Override // defpackage.mf0, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.U0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.Z0 = true;
        this.a1 = w();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getVisibility() == 8) {
            return;
        }
        this.d.setStyle(Paint.Style.FILL);
        this.d.setShader(this.e0);
        float f = this.m;
        float f2 = this.l;
        float f3 = this.p;
        float f4 = this.n;
        float f5 = this.o;
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, this.d);
        int saveLayer = canvas.saveLayer(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, getWidth(), getHeight(), this.d);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setShader(this.r0);
        float f6 = this.z0;
        if (f6 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.d.setShadowLayer(f6, XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.A0, this.y0);
        }
        float f7 = this.t;
        float f8 = this.i;
        float f9 = this.u;
        float f10 = this.r;
        canvas.drawRoundRect(f7 + f8, this.s, this.w + f8, f9, f10, f10, this.d);
        this.d.clearShadowLayer();
        this.d.setXfermode(this.h);
        this.d.setMaskFilter(this.g);
        this.d.setShader(this.B0);
        float f11 = this.t;
        float f12 = this.i;
        float f13 = this.u;
        float f14 = this.r;
        canvas.drawRoundRect(f11 + f12, this.s, this.w + f12, f13, f14, f14, this.d);
        canvas.restoreToCount(saveLayer);
        this.d.setMaskFilter(null);
        this.d.setXfermode(null);
        this.d.clearShadowLayer();
        this.d.setStyle(Paint.Style.FILL);
        this.d.setShader(this.G0);
        float f15 = this.y;
        float f16 = this.i;
        float f17 = this.A;
        float f18 = this.x;
        canvas.drawRoundRect(f15 + f16, this.z, this.B + f16, f17, f18, f18, this.d);
        this.e.setColor(this.N0);
        float f19 = this.O0;
        if (f19 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.e.setShadowLayer(f19, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.N0);
        }
        int saveLayer2 = canvas.saveLayer(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, getWidth(), getHeight(), this.d);
        float f20 = this.P0;
        float f21 = this.R0;
        float f22 = this.K;
        canvas.drawRoundRect(f20, f21, f20 + this.Q0, f21 + this.S0, f22, f22, this.e);
        this.e.clearShadowLayer();
        if (isEnabled()) {
            this.e.setColor(this.T0);
            this.e.setXfermode(this.h);
            this.e.setMaskFilter(this.g);
            float f23 = this.P0;
            float f24 = this.R0;
            float f25 = this.K;
            canvas.drawRoundRect(f23, f24, f23 + this.Q0, f24 + this.S0, f25, f25, this.e);
        }
        canvas.restoreToCount(saveLayer2);
        this.e.setMaskFilter(null);
        this.e.setXfermode(null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.l = (((getHeight() - getPaddingTop()) - c(50)) / 2.0f) + getPaddingTop();
        this.n = c(50) + this.l;
        float f = this.l;
        float f2 = this.j;
        this.q = f + f2;
        this.s = this.q + f2;
        float f3 = this.s;
        this.u = (this.r * 2.0f) + f3;
        this.v = this.u + f2;
        this.z = f3 + f2;
        float f4 = this.z;
        this.A = (this.x * 2.0f) + f4;
        this.C = ((this.n - f) / 2.0f) + f;
        this.G = c(8) + f4;
        this.m = c(7) + getPaddingLeft();
        this.p = c(90) + this.m;
        this.t = c(4) + this.m;
        float f5 = this.t;
        this.w = (this.r * 2.0f) + f5;
        this.y = f5 + this.j;
        float f6 = this.y;
        this.B = (this.x * 2.0f) + f6;
        this.E = c(10) + f6;
        this.F = c(46) + this.E;
        t();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // defpackage.mf0, android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        b bVar = this.W0;
        if (bVar == null || !bVar.a()) {
            return super.performClick();
        }
        return false;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        ValueAnimator valueAnimator = this.U0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.U0.cancel();
        }
        x();
    }

    public void setCheckSoundEnable(boolean z) {
        this.X0 = z;
    }

    @Override // defpackage.mf0, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        b bVar = this.W0;
        if (bVar == null || !bVar.a(this, z)) {
            boolean isChecked = isChecked();
            if (isChecked != z && isPressed() && this.X0) {
                ae0.b.a.b(z ? 3 : 4);
            }
            super.setChecked(z);
            if (!isAttachedToWindow() || getWidth() == 0) {
                x();
                t();
            } else if (isChecked != z) {
                ValueAnimator valueAnimator = this.U0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.U0.cancel();
                }
                if (z) {
                    d(700);
                } else {
                    d(0);
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        t();
    }

    public void setOnInterceptListener(b bVar) {
        this.W0 = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        t();
    }

    public final void t() {
        int i;
        int i2;
        if (isEnabled()) {
            if (isPressed()) {
                this.c0 = this.R;
                this.d0 = this.S;
                this.a0 = this.N;
                this.b0 = this.O;
            } else {
                this.c0 = this.P;
                this.d0 = this.Q;
                this.a0 = this.L;
                this.b0 = this.M;
            }
            this.n0 = this.f0;
            this.o0 = this.g0;
            this.p0 = this.h0;
            this.q0 = this.i0;
            this.f = 1.0f;
            i = this.C0;
            i2 = this.D0;
            this.L0 = this.H0;
            this.M0 = this.I0;
        } else {
            this.c0 = this.V;
            this.d0 = this.W;
            this.a0 = this.T;
            this.b0 = this.U;
            this.n0 = this.j0;
            this.o0 = this.k0;
            this.p0 = this.l0;
            this.q0 = this.m0;
            this.f = 0.36f;
            i = this.E0;
            i2 = this.F0;
            this.L0 = this.J0;
            this.M0 = this.K0;
        }
        this.G0 = new LinearGradient((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.z, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.A, i, i2, Shader.TileMode.CLAMP);
        if (w()) {
            this.u0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.v0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.w0 = this.t0;
            this.x0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.O0 = this.k;
        } else {
            float f = this.s0;
            this.u0 = f;
            this.v0 = f;
            this.w0 = f;
            this.x0 = f;
            this.O0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
        y();
    }

    public final void u() {
        setClickable(true);
        this.d = new Paint(1);
        this.d.setStrokeWidth(c(4));
        this.e = new Paint(1);
        this.h = new PorterDuffXfermode(PorterDuff.Mode.ADD);
        this.g = new BlurMaskFilter(c(8), BlurMaskFilter.Blur.NORMAL);
        setButtonDrawable(xc0.x_switch_drawable);
        setBackgroundColor(b(17170445));
        setGravity(16);
        v();
        setSoundEffectsEnabled(false);
        this.Y0 = new ArgbEvaluator();
    }

    public final void v() {
        this.a1 = w();
        this.L = b(vc0.x_switch_bg_off_enable_normal_start_color);
        this.M = b(vc0.x_switch_bg_off_enable_normal_end_color);
        this.N = b(vc0.x_switch_bg_off_enable_pressed_start_color);
        this.O = b(vc0.x_switch_bg_off_enable_pressed_end_color);
        this.P = b(vc0.x_switch_bg_on_enable_normal_start_color);
        this.Q = b(vc0.x_switch_bg_on_enable_normal_end_color);
        this.R = b(vc0.x_switch_bg_on_enable_pressed_start_color);
        this.S = b(vc0.x_switch_bg_on_enable_pressed_end_color);
        this.T = b(vc0.x_switch_bg_off_disable_start_color);
        this.U = b(vc0.x_switch_bg_off_disable_end_color);
        this.V = b(vc0.x_switch_bg_on_disable_start_color);
        this.W = b(vc0.x_switch_bg_on_disable_end_color);
        this.f0 = b(vc0.x_switch_circle_out_off_enable_start_color);
        this.g0 = b(vc0.x_switch_circle_out_off_enable_end_color);
        this.h0 = b(vc0.x_switch_circle_out_on_enable_start_color);
        this.i0 = b(vc0.x_switch_circle_out_on_enable_end_color);
        this.j0 = b(vc0.x_switch_circle_out_off_disable_start_color);
        this.k0 = b(vc0.x_switch_circle_out_off_disable_end_color);
        this.l0 = b(vc0.x_switch_circle_out_on_disable_start_color);
        this.m0 = b(vc0.x_switch_circle_out_on_disable_end_color);
        this.y0 = b(vc0.x_switch_circle_out_shadow_color);
        this.C0 = b(vc0.x_switch_circle_inner_enable_start_color);
        this.D0 = b(vc0.x_switch_circle_inner_enable_end_color);
        this.E0 = b(vc0.x_switch_circle_inner_disable_start_color);
        this.F0 = b(vc0.x_switch_circle_inner_disable_end_color);
        this.H0 = b(vc0.x_switch_vertical_off_enable_color);
        this.I0 = b(vc0.x_switch_vertical_on_enable_color);
        this.J0 = b(vc0.x_switch_vertical_off_disable_color);
        this.K0 = b(vc0.x_switch_vertical_on_disable_color);
        t();
    }

    public final boolean w() {
        if (isInEditMode()) {
            return true;
        }
        return ThemeManager.isNightMode(getContext());
    }

    public final void x() {
        if (isChecked()) {
            this.V0 = 700;
        } else {
            this.V0 = 0;
        }
    }

    public final void y() {
        int i = this.V0;
        if (i <= 200) {
            a(this.a0, this.b0);
        } else if (i <= 500) {
            a(a(this.a0, this.c0, this.b1), a(this.b0, this.d0, this.b1));
        } else {
            a(this.c0, this.d0);
        }
        int i2 = this.V0;
        if (i2 <= 200) {
            c(this.n0, this.o0);
            this.z0 = this.u0;
            this.A0 = this.v0;
            float f = (this.f * this.V0) / 200.0f;
            b(a(f, this.n0), a(f, this.o0));
        } else if (i2 <= 500) {
            int a2 = a(this.n0, this.p0, this.b1);
            int a3 = a(this.o0, this.q0, this.b1);
            c(a2, a3);
            float f2 = this.w0 - this.u0;
            float f3 = this.b1;
            this.z0 = f2 * f3;
            this.A0 = (this.x0 - this.v0) * f3;
            b(a(this.f, a2), a(this.f, a3));
        } else {
            c(this.p0, this.q0);
            this.z0 = this.w0;
            this.A0 = this.x0;
            float f4 = this.f;
            float f5 = f4 - ((((this.V0 - 300) - 200) * f4) / 200.0f);
            b(a(f5, this.p0), a(f5, this.q0));
        }
        int i3 = this.V0;
        if (i3 <= 200) {
            this.i = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        } else if (i3 <= 500) {
            this.i = this.D * this.b1;
        } else {
            this.i = this.D;
        }
        int i4 = this.V0;
        if (i4 <= 200) {
            this.N0 = this.L0;
            this.P0 = this.E;
            this.R0 = this.C;
            this.Q0 = this.H;
            this.S0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.T0 = a((this.f * i4) / 200.0f, this.N0);
        } else if (i4 <= 500) {
            this.N0 = a(this.L0, this.M0, this.b1);
            float f6 = ((this.V0 - 200) - 120) / 180.0f;
            if (f6 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                float f7 = this.E;
                this.P0 = jg.a(this.F, f7, f6, f7);
                float f8 = this.C;
                this.R0 = f8 - ((f8 - this.G) * f6);
                float f9 = this.H;
                this.Q0 = f9 - ((f9 - this.I) * f6);
                this.S0 = this.J * f6;
            }
            this.T0 = a(this.f, this.N0);
        } else {
            this.N0 = this.M0;
            this.P0 = this.F;
            this.R0 = this.G;
            this.Q0 = this.I;
            this.S0 = this.J;
            float f10 = this.f;
            this.T0 = a(f10 - ((((i4 - 300) - 200) * f10) / 200.0f), this.N0);
        }
        invalidate();
    }

    public XSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = c(2);
        this.k = c(6);
        this.l = getResources().getDimension(wc0.x_switch_padding_top);
        this.m = getResources().getDimension(wc0.x_switch_padding_start);
        this.n = c(50) + this.l;
        this.o = c(25);
        this.p = c(90) + this.m;
        this.q = this.l + this.j;
        this.r = c(21);
        this.s = this.q + this.j;
        this.t = c(4) + this.m;
        float f = this.s;
        float f2 = this.r;
        this.u = (f2 * 2.0f) + f;
        this.v = this.u + this.j;
        this.w = (f2 * 2.0f) + this.t;
        this.x = c(19);
        float f3 = this.t;
        float f4 = this.j;
        this.y = f3 + f4;
        this.z = this.s + f4;
        float f5 = this.z;
        float f6 = this.x;
        this.A = (f6 * 2.0f) + f5;
        this.B = (f6 * 2.0f) + this.y;
        float f7 = this.n;
        float f8 = this.l;
        this.C = ((f7 - f8) / 2.0f) + f8;
        this.D = c(40);
        this.E = c(10) + this.y;
        this.F = c(46) + this.E;
        this.G = c(8) + this.z;
        this.H = c(18);
        this.I = c(6);
        this.J = c(22);
        this.K = c(3);
        this.s0 = c(5);
        this.t0 = this.k;
        this.X0 = true;
        this.Z0 = true;
        u();
    }

    public final int a(float f, int i) {
        return Color.argb((int) (f * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public final int b(int i) {
        return getResources().getColor(i, getContext().getTheme());
    }

    public final float c(int i) {
        return TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    public final int a(int i, int i2, float f) {
        return ((Integer) this.Y0.evaluate(f, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }

    public XSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = c(2);
        this.k = c(6);
        this.l = getResources().getDimension(wc0.x_switch_padding_top);
        this.m = getResources().getDimension(wc0.x_switch_padding_start);
        this.n = c(50) + this.l;
        this.o = c(25);
        this.p = c(90) + this.m;
        this.q = this.l + this.j;
        this.r = c(21);
        this.s = this.q + this.j;
        this.t = c(4) + this.m;
        float f = this.s;
        float f2 = this.r;
        this.u = (f2 * 2.0f) + f;
        this.v = this.u + this.j;
        this.w = (f2 * 2.0f) + this.t;
        this.x = c(19);
        float f3 = this.t;
        float f4 = this.j;
        this.y = f3 + f4;
        this.z = this.s + f4;
        float f5 = this.z;
        float f6 = this.x;
        this.A = (f6 * 2.0f) + f5;
        this.B = (f6 * 2.0f) + this.y;
        float f7 = this.n;
        float f8 = this.l;
        this.C = ((f7 - f8) / 2.0f) + f8;
        this.D = c(40);
        this.E = c(10) + this.y;
        this.F = c(46) + this.E;
        this.G = c(8) + this.z;
        this.H = c(18);
        this.I = c(6);
        this.J = c(22);
        this.K = c(3);
        this.s0 = c(5);
        this.t0 = this.k;
        this.X0 = true;
        this.Z0 = true;
        u();
    }

    public XSwitch(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.j = c(2);
        this.k = c(6);
        this.l = getResources().getDimension(wc0.x_switch_padding_top);
        this.m = getResources().getDimension(wc0.x_switch_padding_start);
        this.n = c(50) + this.l;
        this.o = c(25);
        this.p = c(90) + this.m;
        this.q = this.l + this.j;
        this.r = c(21);
        this.s = this.q + this.j;
        this.t = c(4) + this.m;
        float f = this.s;
        float f2 = this.r;
        this.u = (f2 * 2.0f) + f;
        this.v = this.u + this.j;
        this.w = (f2 * 2.0f) + this.t;
        this.x = c(19);
        float f3 = this.t;
        float f4 = this.j;
        this.y = f3 + f4;
        this.z = this.s + f4;
        float f5 = this.z;
        float f6 = this.x;
        this.A = (f6 * 2.0f) + f5;
        this.B = (f6 * 2.0f) + this.y;
        float f7 = this.n;
        float f8 = this.l;
        this.C = ((f7 - f8) / 2.0f) + f8;
        this.D = c(40);
        this.E = c(10) + this.y;
        this.F = c(46) + this.E;
        this.G = c(8) + this.z;
        this.H = c(18);
        this.I = c(6);
        this.J = c(22);
        this.K = c(3);
        this.s0 = c(5);
        this.t0 = this.k;
        this.X0 = true;
        this.Z0 = true;
        u();
    }
}
