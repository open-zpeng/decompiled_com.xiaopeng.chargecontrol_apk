package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* compiled from: AbsSlider.java */
/* renamed from: rg0  reason: default package */
/* loaded from: classes.dex */
public abstract class rg0 extends vf0 implements hc0 {
    public int A;
    public int B;
    public int C;
    public Drawable D;
    public int E;
    public boolean F;
    public float G;
    public float H;
    public boolean I;
    public float J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public sg0 P;
    public int Q;
    public float R;
    public Paint S;
    public LinearGradient T;
    public int U;
    public int V;
    public int W;
    public int a0;
    public final Paint d;
    public final Paint e;
    public int f;
    public String g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public float o;
    public DecimalFormat p;
    public float q;
    public float r;
    public float s;
    public String t;
    public Paint u;
    public boolean v;
    public int w;
    public float x;
    public boolean y;
    public int z;

    public rg0(Context context) {
        this(context, null);
    }

    public final int a(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null) {
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, dd0.XSlider, 0, i);
        } else {
            obtainStyledAttributes = getContext().obtainStyledAttributes(i, dd0.XSlider);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_bg_color)) {
            this.L = obtainStyledAttributes.getColor(dd0.XSlider_slider_bg_color, this.L);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_bg_line_color)) {
            this.K = obtainStyledAttributes.getColor(dd0.XSlider_slider_bg_line_color, this.K);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_background)) {
            this.Q = obtainStyledAttributes.getColor(dd0.XSlider_slider_background, 0);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_hide_pop)) {
            this.F = obtainStyledAttributes.getBoolean(dd0.XSlider_slider_hide_pop, false);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_dismiss_pop)) {
            this.y = obtainStyledAttributes.getBoolean(dd0.XSlider_slider_dismiss_pop, false);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_item_count)) {
            this.U = obtainStyledAttributes.getInteger(dd0.XSlider_slider_item_count, 30);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_orientation)) {
            this.W = obtainStyledAttributes.getInt(dd0.XSlider_slider_orientation, 0);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_thumb)) {
            this.C = obtainStyledAttributes.getResourceId(dd0.XSlider_slider_thumb, 0);
            if (this.C != 0) {
                this.D = o7.b(getContext(), this.C);
            } else {
                this.D = null;
            }
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_progress_color_start)) {
            this.B = obtainStyledAttributes.getColor(dd0.XSlider_slider_progress_color_start, this.B);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_progress_color_end)) {
            this.A = obtainStyledAttributes.getColor(dd0.XSlider_slider_progress_color_end, this.A);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_tickMarkStyle)) {
            this.a0 = obtainStyledAttributes.getResourceId(dd0.XSlider_slider_tickMarkStyle, cd0.XSliderLine);
        }
        obtainStyledAttributes.recycle();
        if (this.U < 3) {
            this.U = 3;
        }
        if (this.y) {
            this.F = true;
            this.R = 32.0f;
        }
        if (!this.F) {
            this.V = 40;
        } else {
            this.V = 0;
        }
        if (this.S == null) {
            this.S = new Paint(1);
            this.S.setStyle(Paint.Style.FILL);
            this.S.setColor(this.L);
        }
        if (this.u == null) {
            this.u = new Paint(1);
            this.u.setStyle(Paint.Style.FILL);
            this.u.setStrokeCap(Paint.Cap.ROUND);
            this.u.setStrokeWidth(12.0f);
            this.u.setColor(this.O);
        }
        this.T = new LinearGradient(16.0f, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.w, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, new int[]{this.B, this.A}, (float[]) null, Shader.TileMode.CLAMP);
        this.d.setShader(this.T);
        if (this.W == 1) {
            setMinimumWidth(0);
            setMinimumHeight(80);
        } else {
            setMinimumWidth(80);
            setMinimumHeight(0);
        }
        setBackground(new ColorDrawable(this.Q));
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof vg0) {
                ((vg0) childAt).a((AttributeSet) null, this.a0);
            }
        }
        invalidate();
        if (this.F) {
            return;
        }
        this.P = new sg0();
        this.P.a(getResources(), getContext().getTheme(), attributeSet, i);
        this.P.setState(getDrawableState());
        this.P.setCallback(this);
        this.P.a(t(), getPopString(), getSliderLength());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        if (this.W == 1) {
            canvas.translate(XToggleDrawable.LIGHT_RADIUS_DEFAULT, getHeight());
            canvas.rotate(270.0f);
        }
        super.dispatchDraw(canvas);
        float t = t();
        if (t == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            return;
        }
        float heightExIndicator = getHeightExIndicator() / 2.0f;
        sg0 sg0Var = this.P;
        if (sg0Var != null) {
            sg0Var.draw(canvas);
        }
        if (isEnabled()) {
            Drawable drawable = this.D;
            if (drawable != null) {
                float intrinsicWidth = t - (this.D.getIntrinsicWidth() / 2.0f);
                float intrinsicHeight = heightExIndicator - (drawable.getIntrinsicHeight() / 2.0f);
                Drawable drawable2 = this.D;
                drawable2.setBounds((int) intrinsicWidth, (int) intrinsicHeight, (int) (intrinsicWidth + drawable2.getIntrinsicWidth()), (int) (intrinsicHeight + this.D.getIntrinsicHeight()));
                this.D.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        sg0 sg0Var = this.P;
        if (sg0Var != null && sg0Var.isStateful() && sg0Var.setState(drawableState)) {
            invalidateDrawable(sg0Var);
        }
        Drawable drawable = this.D;
        if (drawable != null && drawable.isStateful() && this.D.setState(drawableState)) {
            invalidateDrawable(this.D);
        }
    }

    public float getHeightExIndicator() {
        return getSliderThickness() + this.V;
    }

    public float getIndicatorValue() {
        return (this.q + this.h) * this.E;
    }

    public int getOrientation() {
        return this.W;
    }

    public String getPopString() {
        if (this.g == null) {
            this.g = "";
        }
        if (this.t == null) {
            this.t = "";
        }
        if (this.p == null) {
            if (this.E == 1) {
                return this.t + (this.h + ((int) this.q)) + this.g;
            }
            return this.t + getIndicatorValue() + this.g;
        }
        return this.t + this.p.format((this.h + this.q) * this.E) + this.g;
    }

    public float getProgressViewLength() {
        return this.o;
    }

    public int getSliderLength() {
        return this.W == 1 ? getHeight() : getWidth();
    }

    public int getSliderThickness() {
        return this.W == 1 ? getWidth() : getHeight();
    }

    public float getWidthExIndicator() {
        return getSliderLength();
    }

    @Override // defpackage.vf0, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.v = ThemeManager.isNightMode(getContext());
    }

    @Override // defpackage.vf0, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!isInEditMode()) {
            this.v = ThemeManager.isNightMode(getContext());
            if (ThemeManager.isThemeChanged(configuration)) {
                sg0 sg0Var = this.P;
                if (sg0Var != null) {
                    sg0Var.a(getResources(), getContext().getTheme());
                }
                if (this.C != 0) {
                    this.D = o7.b(getContext(), this.C);
                }
            }
        }
        invalidate();
    }

    @Override // defpackage.vf0, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        if (this.W == 1) {
            canvas.translate(XToggleDrawable.LIGHT_RADIUS_DEFAULT, getHeight());
            canvas.rotate(270.0f);
        }
        super.onDraw(canvas);
        float heightExIndicator = (getHeightExIndicator() / 2.0f) - this.n;
        float widthExIndicator = getWidthExIndicator();
        float heightExIndicator2 = (getHeightExIndicator() / 2.0f) + this.n;
        if (this.v) {
            this.S.setColor(this.L);
            canvas.drawRoundRect(XToggleDrawable.LIGHT_RADIUS_DEFAULT, heightExIndicator, widthExIndicator, heightExIndicator2, 16.0f, 16.0f, this.S);
        } else {
            if (isEnabled()) {
                this.e.setColor(this.z);
                canvas.drawRoundRect(XToggleDrawable.LIGHT_RADIUS_DEFAULT, heightExIndicator, widthExIndicator, heightExIndicator2, 16.0f, 16.0f, this.e);
            } else {
                this.S.setColor(this.M);
                canvas.drawRoundRect(XToggleDrawable.LIGHT_RADIUS_DEFAULT, heightExIndicator, widthExIndicator, heightExIndicator2, 16.0f, 16.0f, this.S);
            }
            if (isEnabled()) {
                canvas.drawRoundRect(XToggleDrawable.LIGHT_RADIUS_DEFAULT, heightExIndicator, t() + 9.0f + 7.0f, heightExIndicator2, 16.0f, 16.0f, this.d);
            } else {
                this.S.setColor(this.N);
                canvas.drawRoundRect(XToggleDrawable.LIGHT_RADIUS_DEFAULT, heightExIndicator, t() + 9.0f + 7.0f, heightExIndicator2, 16.0f, 16.0f, this.S);
            }
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float sliderLength = (getSliderLength() - 36) / (getChildCount() - 1);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            float f = (i5 * sliderLength) + 18.0f;
            getChildAt(i5).layout((int) (f - 10.0f), (((int) getHeightExIndicator()) / 2) - 20, (int) (f + 10.0f), (((int) getHeightExIndicator()) / 2) + 20);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        super.onMeasure(i, i2);
        if (this.W == 1) {
            measuredWidth = (int) this.R;
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                r1 = getMeasuredHeight();
            }
        } else {
            measuredWidth = View.MeasureSpec.getMode(i) != Integer.MIN_VALUE ? getMeasuredWidth() : 644;
            r1 = (int) this.R;
        }
        setMeasuredDimension(measuredWidth, r1);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setPadding(0, 0, 0, 0);
        if (this.W != 0) {
            i = i2;
        }
        this.w = i - 32;
        this.x = this.w / (this.U - 1);
        int i5 = this.i;
        int i6 = this.h;
        this.o = (Math.abs((i5 - i6) / (this.j - i6)) * this.w) + 16.0f;
        for (int i7 = 0; i7 < this.U; i7++) {
            addView(new vg0(getContext(), this.o > (this.x * ((float) i7)) + 16.0f, this.a0));
        }
        this.T = new LinearGradient(16.0f, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.w, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, new int[]{this.B, this.A}, (float[]) null, Shader.TileMode.CLAMP);
        this.d.setShader(this.T);
        sg0 sg0Var = this.P;
        if (sg0Var != null) {
            sg0Var.a(t(), getPopString(), getSliderLength());
        }
        invalidate();
    }

    public void setAccuracy(float f) {
        this.s = f;
    }

    public void setAlphaByEnable(boolean z) {
        this.L = a(this.L, z ? 92 : this.f);
        this.M = a(this.M, z ? 92 : this.f);
        this.N = a(this.N, z ? XLoadingDrawable.ALPHA_MAX : this.f);
    }

    public void setStyle(int i) {
        a((AttributeSet) null, i);
    }

    public float t() {
        int i;
        int i2;
        if (this.o < 16.0f) {
            return 16.0f;
        }
        int sliderLength = getSliderLength() - 16;
        int i3 = this.l;
        int i4 = 0;
        if (i3 != Integer.MIN_VALUE && (i = this.h) < (i2 = this.j) && i <= i3 && i3 <= i2) {
            i4 = ((i2 - i3) * this.w) / (i2 - i);
        }
        float f = sliderLength - i4;
        float f2 = this.o;
        return f2 > f ? f : f2;
    }

    public void u() {
        invalidate();
        sg0 sg0Var = this.P;
        if (sg0Var != null) {
            sg0Var.a(t(), getPopString(), getSliderLength());
        }
    }

    public ViewGroup v() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return viewGroup;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        sg0 sg0Var;
        Drawable drawable2 = this.D;
        return (drawable2 != null && drawable == drawable2) || ((sg0Var = this.P) != null && drawable == sg0Var) || super.verifyDrawable(drawable);
    }

    public void w() {
        if (this.E == 1) {
            return;
        }
        float f = this.w / (this.j - this.h);
        this.o = (((int) ((this.o - 16.0f) / f)) * f) + 16.0f;
    }

    public rg0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public rg0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public rg0(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.f = 40;
        this.i = -1;
        this.l = Integer.MIN_VALUE;
        this.m = 32.0f;
        this.n = this.m / 2.0f;
        this.s = 1.0f;
        this.y = false;
        this.z = 1555808977;
        this.A = -12871169;
        this.B = -12860929;
        this.E = 1;
        this.F = false;
        this.K = -15945223;
        this.L = 1543503872;
        this.M = 1560281087;
        this.N = -12871169;
        this.O = -1;
        this.Q = 0;
        this.R = 100.0f;
        this.U = 30;
        this.W = 0;
        this.a0 = cd0.XSliderLine;
        this.J = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, dd0.XSlider, i, i2);
        this.g = obtainStyledAttributes.getString(dd0.XSlider_slider_unit);
        this.h = obtainStyledAttributes.getInteger(dd0.XSlider_slider_start_index, 0);
        this.E = obtainStyledAttributes.getInteger(dd0.XSlider_slider_step, 1);
        this.i = obtainStyledAttributes.getInteger(dd0.XSlider_slider_init_index, -1);
        this.j = obtainStyledAttributes.getInteger(dd0.XSlider_slider_end_index, 100);
        this.l = obtainStyledAttributes.getInteger(dd0.XSlider_slider_upper_limit, Integer.MIN_VALUE);
        this.k = obtainStyledAttributes.getInteger(dd0.XSlider_slider_index_decimal, 0);
        this.t = obtainStyledAttributes.getString(dd0.XSlider_slider_unit_prefix);
        this.s = obtainStyledAttributes.getFloat(dd0.XSlider_slider_accuracy, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        obtainStyledAttributes.recycle();
        if (this.i == -1) {
            this.i = Math.min(this.h, this.j);
        }
        int i3 = this.i;
        int i4 = this.h;
        this.q = i3 - i4;
        if (this.j != i4) {
            int i5 = this.k;
            this.p = i5 == 0 ? null : i5 == 1 ? new DecimalFormat("0.0") : new DecimalFormat("0.00");
            DecimalFormat decimalFormat = this.p;
            if (decimalFormat != null) {
                decimalFormat.setRoundingMode(RoundingMode.DOWN);
            }
            if (this.s == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                int i6 = this.k;
                this.s = i6 != 0 ? i6 == 1 ? 0.1f : 0.01f : 1.0f;
            }
            a(attributeSet, i2);
            if (isInEditMode()) {
                return;
            }
            this.v = ThemeManager.isNightMode(getContext());
            return;
        }
        throw new RuntimeException("startIndex = endIndex!!! please check the xml");
    }
}
