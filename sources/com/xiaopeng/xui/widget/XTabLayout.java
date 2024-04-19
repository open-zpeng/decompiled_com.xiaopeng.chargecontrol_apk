package com.xiaopeng.xui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XTabLayout;
@Deprecated
/* loaded from: classes.dex */
public class XTabLayout extends XLinearLayout implements hc0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public float J;
    public int K;
    public int L;
    public ValueAnimator M;
    public boolean N;
    public int O;
    public CharSequence[] P;
    public int[] Q;
    public CharSequence[] R;
    public h S;
    public View.OnClickListener T;
    public boolean U;
    public boolean V;
    public int d;
    public boolean e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public int k;
    public float l;
    public int m;
    public int n;
    public float o;
    public boolean p;
    public Paint q;
    public Paint r;
    public Paint s;
    public Paint t;
    public float u;
    public float v;
    public float w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ValueAnimator valueAnimator = XTabLayout.this.M;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                XTabLayout xTabLayout = XTabLayout.this;
                xTabLayout.a(xTabLayout.indexOfChild(view), true, true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements g {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public b(boolean z, View view, boolean z2, int i) {
            this.a = z;
            this.b = view;
            this.c = z2;
            this.d = i;
        }

        @Override // com.xiaopeng.xui.widget.XTabLayout.g
        public void onEnd() {
            h hVar;
            if (this.a && (hVar = XTabLayout.this.S) != null) {
                if (this.b == null) {
                    o60.a(((m60) hVar).a, -1, this.c);
                } else {
                    o60.a(((m60) hVar).a, this.d, this.c);
                }
            }
            XTabLayout xTabLayout = XTabLayout.this;
            xTabLayout.a((View) xTabLayout);
        }

        @Override // com.xiaopeng.xui.widget.XTabLayout.g
        public void onStart() {
            XTabLayout xTabLayout;
            h hVar;
            if (!this.a || (hVar = (xTabLayout = XTabLayout.this).S) == null) {
                return;
            }
            if (this.b == null) {
                ((i) hVar).b(xTabLayout, -1, true, this.c);
            } else {
                ((i) hVar).b(xTabLayout, this.d, true, this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i;
            int i2;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float min = Math.min(floatValue, XTabLayout.this.J);
            XTabLayout xTabLayout = XTabLayout.this;
            float f = xTabLayout.J;
            float f2 = min / f;
            if (floatValue < f) {
                float f3 = xTabLayout.u;
                xTabLayout.w = (int) (f3 - ((f3 - xTabLayout.v) * (floatValue / f)));
            } else {
                float f4 = xTabLayout.u;
                xTabLayout.w = (int) (((f4 - xTabLayout.v) * (((floatValue - f) / (1.0f - f)) - 1.0f)) + f4);
            }
            XTabLayout xTabLayout2 = XTabLayout.this;
            int i3 = xTabLayout2.B;
            int i4 = xTabLayout2.x;
            if (i3 > i4) {
                double pow = Math.pow(floatValue, 1.048d);
                XTabLayout xTabLayout3 = XTabLayout.this;
                xTabLayout2.F = (int) ((pow * (xTabLayout3.B - xTabLayout3.x)) + i4);
                xTabLayout3.H = (int) (((xTabLayout3.D - i2) * f2) + xTabLayout3.y);
            } else {
                xTabLayout2.F = (int) (((i3 - i4) * f2) + i4);
                double pow2 = Math.pow(floatValue, 1.048d);
                XTabLayout xTabLayout4 = XTabLayout.this;
                xTabLayout2.H = (int) ((pow2 * (xTabLayout4.D - xTabLayout4.y)) + xTabLayout2.y);
            }
            XTabLayout xTabLayout5 = XTabLayout.this;
            int i5 = xTabLayout5.C;
            int i6 = xTabLayout5.z;
            if (i5 > i6) {
                double pow3 = Math.pow(floatValue, 4.648d);
                XTabLayout xTabLayout6 = XTabLayout.this;
                xTabLayout5.G = (int) ((pow3 * (xTabLayout6.C - xTabLayout6.z)) + i6);
                xTabLayout6.I = (int) ((f2 * (xTabLayout6.E - i)) + xTabLayout6.A);
            } else {
                xTabLayout5.G = (int) ((f2 * (i5 - i6)) + i6);
                double d = xTabLayout5.A;
                double pow4 = Math.pow(floatValue, 4.648d);
                XTabLayout xTabLayout7 = XTabLayout.this;
                xTabLayout5.I = (int) ((pow4 * (xTabLayout7.E - xTabLayout7.A)) + d);
            }
            XTabLayout.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            XTabLayout.this.t();
            XTabLayout.this.invalidate();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ g c;

        public e(g gVar) {
            this.c = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            XTabLayout.this.M.removeListener(this);
            g gVar = this.c;
            if (gVar != null) {
                gVar.onEnd();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g gVar = this.c;
            if (gVar != null) {
                gVar.onStart();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XTabLayout.this.a(false, (g) null);
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void onEnd();

        void onStart();
    }

    /* loaded from: classes.dex */
    public interface h {
    }

    /* loaded from: classes.dex */
    public static abstract class i implements h {
        public boolean a(XTabLayout xTabLayout, int i, boolean z, boolean z2) {
            return false;
        }

        public void b(XTabLayout xTabLayout, int i, boolean z, boolean z2) {
        }
    }

    public XTabLayout(Context context) {
        this(context, null);
    }

    private void getIndicatorPosition() {
        int i2;
        int selectedTabIndex = getSelectedTabIndex();
        int i3 = 0;
        if (selectedTabIndex < 0) {
            this.B = 0;
            this.D = 0;
            this.C = 0;
            this.E = 0;
            return;
        }
        if (selectedTabIndex < 0 || getWidth() <= 0) {
            i2 = 0;
        } else if (this.L == 2) {
            int width = (getWidth() - (this.d * 2)) / getTabCount();
            i2 = c(width) + (selectedTabIndex * width) + this.d;
        } else {
            i2 = ((getWidth() / getTabCount()) * selectedTabIndex) + 0;
        }
        this.B = i2;
        if (selectedTabIndex >= 0 && getWidth() > 0) {
            if (this.L == 2) {
                int width2 = (getWidth() - (this.d * 2)) / getTabCount();
                i3 = this.d + (((selectedTabIndex + 1) * width2) - c(width2));
            } else {
                i3 = 0 + ((selectedTabIndex + 1) * (getWidth() / getTabCount()));
            }
        }
        this.D = i3;
        this.C = this.B;
        this.E = this.D;
    }

    private View getSelectView() {
        return getChildAt(this.K);
    }

    public int b(int i2) {
        return (int) TypedValue.applyDimension(1, i2, getResources().getDisplayMetrics());
    }

    public final int c(int i2) {
        float f2;
        float f3 = this.g;
        if (f3 != XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f2 = (i2 - f3) / 2.0f;
        } else {
            f2 = i2 * ((1.0f - this.h) / 2.0f);
        }
        return (int) f2;
    }

    public CharSequence d(int i2) {
        return getChildAt(i2) instanceof TextView ? ((TextView) getChildAt(i2)).getText() : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i2 = this.L;
        int i3 = XLoadingDrawable.ALPHA_MAX;
        if (i2 == 1) {
            if (!u()) {
                this.q.setMaskFilter(null);
            }
            Paint paint = this.q;
            if (!e(this.K)) {
                i3 = 92;
            }
            paint.setAlpha(i3);
            float height = (getHeight() * 1.0f) / 2.0f;
            float height2 = getHeight() >> 1;
            int i4 = this.F;
            int i5 = this.H;
            if (i4 < i5) {
                canvas.drawRoundRect(i4, height2 - height, i5, height2 + height, height, height, this.q);
            } else {
                canvas.drawRoundRect(i5, height2 - height, i4, height2 + height, height, height, this.q);
            }
        } else if (i2 == 2) {
            if (u()) {
                this.q.setMaskFilter(new BlurMaskFilter(this.l, BlurMaskFilter.Blur.SOLID));
                this.s.setMaskFilter(new BlurMaskFilter(this.o, BlurMaskFilter.Blur.SOLID));
            } else {
                this.q.setMaskFilter(null);
                this.s.setMaskFilter(null);
            }
            this.q.setAlpha(e(this.K) ? 255 : 92);
            Paint paint2 = this.s;
            if (!e(this.K)) {
                i3 = 92;
            }
            paint2.setAlpha(i3);
            float f2 = this.w / 2.0f;
            float height3 = getHeight() - this.i;
            if (this.G < this.I) {
                canvas.drawRoundRect(this.G, height3 - Math.max(this.w, 1.0f), this.I, height3, f2, f2, this.s);
            } else {
                canvas.drawRoundRect(this.I, height3 - Math.max(this.w, 1.0f), this.G, height3, f2, f2, this.s);
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean e(int i2) {
        int childCount = getChildCount();
        View childAt = getChildAt(i2);
        if (i2 >= childCount || childAt == null) {
            return false;
        }
        return childAt.isEnabled();
    }

    public void f(int i2) {
        a(i2, true);
    }

    public int getSelectedTabIndex() {
        return this.K;
    }

    public int getTabCount() {
        return getChildCount();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.U || this.V == u()) {
            return;
        }
        this.U = false;
        setStyle(u() ? 2 : 1);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            setStyle(u() ? 2 : 1);
        }
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.U = true;
        this.V = u();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new f());
    }

    public void setAllTabClickable(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setClickable(z);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(z);
        }
        int i3 = Build.VERSION.SDK_INT;
        int i4 = z ? XLoadingDrawable.ALPHA_MAX : 92;
        this.q.setAlpha(i4);
        this.r.setAlpha(i4);
        this.s.setAlpha(i4);
        this.t.setAlpha(i4);
        invalidate();
    }

    public void setIndicatorAnimatorEnable(boolean z) {
        this.e = z;
    }

    public void setOnTabChangeListener(h hVar) {
        this.S = hVar;
    }

    @Override // android.view.View
    public void setSoundEffectsEnabled(boolean z) {
        super.setSoundEffectsEnabled(z);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setSoundEffectsEnabled(z);
            }
        }
    }

    public void setStyle(int i2) {
        int[] iArr;
        this.V = u();
        if (!this.p) {
            i2 = 1;
        }
        this.L = i2;
        if (this.N) {
            this.L = 2;
        }
        if (this.L == 2) {
            int i3 = this.d;
            setPadding(i3, 0, i3, 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
        if (this.O > 0) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(getResources().getColorStateList(this.O, getContext().getTheme()));
                } else if ((childAt instanceof ImageView) && (iArr = this.Q) != null && iArr.length > i4) {
                    ((ImageView) childAt).setImageResource(iArr[i4]);
                }
            }
        }
        this.q.setColor(getContext().getColor(this.j));
        this.s.setColor(getContext().getColor(this.m));
        a(false, (g) null);
    }

    public final void t() {
        this.x = this.B;
        this.y = this.D;
        this.z = this.C;
        this.A = this.E;
        int i2 = this.x;
        this.F = i2;
        this.H = this.y;
        this.G = i2;
        this.I = this.A;
    }

    public final boolean u() {
        if (isInEditMode()) {
            return false;
        }
        return ThemeManager.isNightMode(getContext());
    }

    public XTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XTabLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public int a(CharSequence charSequence, int i2) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(ad0.x_tab_layout_title_view, (ViewGroup) this, false);
        textView.setText(charSequence);
        if (this.O > 0) {
            textView.setTextColor(getResources().getColorStateList(this.O, getContext().getTheme()));
        }
        textView.setTextSize(0, this.f);
        textView.setTag(Boolean.valueOf(i2 == this.K));
        int i3 = this.K;
        if (i2 <= i3) {
            this.K = i3 + 1;
        }
        textView.setSoundEffectsEnabled(isSoundEffectsEnabled());
        addView(textView, i2);
        return i2;
    }

    public XTabLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3 == 0 ? cd0.XTabLayoutAppearance : i3);
        this.q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = new Paint(1);
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0.6f;
        this.K = -1;
        this.L = 2;
        this.T = new a();
        this.U = true;
        int i4 = Build.VERSION.SDK_INT;
        getContext().getTheme();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, dd0.XTabLayout, i2 == 0 ? cd0.XTabLayoutAppearance : i2, cd0.XTabLayoutAppearance);
        this.P = obtainStyledAttributes.getTextArray(dd0.XTabLayout_titles);
        this.f = obtainStyledAttributes.getDimension(dd0.XTabLayout_titleTextSize, 35.0f);
        int i5 = dd0.XTabLayout_titleTextSize;
        obtainStyledAttributes.getColorStateList(dd0.XTabLayout_titleTextColorStateList);
        int integer = obtainStyledAttributes.getInteger(dd0.XTabLayout_selectTab, 0);
        this.g = obtainStyledAttributes.getDimension(dd0.XTabLayout_indicatorWidth, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.h = obtainStyledAttributes.getFraction(dd0.XTabLayout_indicatorWidthPercent, 1, 1, 0.7f);
        this.u = obtainStyledAttributes.getDimension(dd0.XTabLayout_indicatorMaxHeight, b(4));
        this.v = obtainStyledAttributes.getDimension(dd0.XTabLayout_indicatorMinHeight, b(2));
        this.w = this.u;
        this.i = obtainStyledAttributes.getDimension(dd0.XTabLayout_indicatorMarginBottom, b(6));
        this.j = obtainStyledAttributes.getResourceId(dd0.XTabLayout_indicatorColor, vc0.x_theme_primary_normal);
        obtainStyledAttributes.getColor(dd0.XTabLayout_indicatorColorFrom, -1);
        obtainStyledAttributes.getColor(dd0.XTabLayout_indicatorColorTo, -1);
        this.k = obtainStyledAttributes.getColor(dd0.XTabLayout_indicatorShadowColor, -15880455);
        this.l = obtainStyledAttributes.getDimension(dd0.XTabLayout_indicatorShadowRadius, b(4));
        this.m = obtainStyledAttributes.getResourceId(dd0.XTabLayout_indicatorColor2, vc0.x_table_indicator_color);
        this.n = obtainStyledAttributes.getColor(dd0.XTabLayout_indicatorShadowColor2, -15880455);
        this.o = obtainStyledAttributes.getDimension(dd0.XTabLayout_indicatorShadowRadius2, b(4));
        this.e = obtainStyledAttributes.getBoolean(dd0.XTabLayout_indicatorAnimatorEnable, true);
        this.O = obtainStyledAttributes.getResourceId(dd0.XTabLayout_titleTextColorStateList, -1);
        this.N = obtainStyledAttributes.getBoolean(dd0.XTabLayout_tabsBarStyle, false);
        obtainStyledAttributes.getBoolean(dd0.XTabLayout_tabCustomBackground, false);
        this.d = obtainStyledAttributes.getDimensionPixelSize(dd0.XTabLayout_tabPaddingNight, b(40));
        this.p = obtainStyledAttributes.getBoolean(dd0.XTabLayout_indicatorDayNightDiff, false);
        int resourceId = obtainStyledAttributes.getResourceId(dd0.XTabLayout_tabLayoutIcons, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            this.Q = new int[obtainTypedArray.length()];
            for (int i6 = 0; i6 < obtainTypedArray.length(); i6++) {
                this.Q[i6] = obtainTypedArray.getResourceId(i6, 0);
            }
            obtainTypedArray.recycle();
        }
        this.R = obtainStyledAttributes.getTextArray(dd0.XTabLayout_tabLayoutVuiLabels);
        setGravity(17);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        this.q.setStrokeWidth(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.q.setColor(getContext().getColor(this.j));
        this.r.setStrokeWidth(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.r.setColor(this.k);
        int i7 = Build.VERSION.SDK_INT;
        this.s.setStrokeWidth(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.s.setColor(getContext().getColor(this.m));
        this.t.setStrokeWidth(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.t.setColor(this.n);
        int i8 = Build.VERSION.SDK_INT;
        CharSequence[] charSequenceArr = this.P;
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence charSequence : charSequenceArr) {
                a(charSequence);
            }
        } else {
            int[] iArr = this.Q;
            if (iArr != null && iArr.length > 0) {
                int i9 = 0;
                while (i9 < this.Q.length) {
                    CharSequence[] charSequenceArr2 = this.R;
                    a(this.Q[i9], (charSequenceArr2 == null || charSequenceArr2.length <= i9) ? "" : charSequenceArr2[i9].toString());
                    i9++;
                }
            }
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            getChildAt(i10).setOnClickListener(this.T);
        }
        setOnHierarchyChangeListener(new uf0(this));
        a(integer, false, false);
        setStyle(u() ? 2 : 1);
    }

    public int a(int i2, int i3, String str) {
        XImageView xImageView = new XImageView(getContext());
        xImageView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        xImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        xImageView.setImageResource(i2);
        xImageView.a(mc0.TEXTVIEW);
        xImageView.a(str);
        xImageView.setTag(Boolean.valueOf(i3 == this.K));
        int i4 = this.K;
        if (i3 <= i4) {
            this.K = i4 + 1;
        }
        xImageView.setSoundEffectsEnabled(isSoundEffectsEnabled());
        addView(xImageView, i3);
        return i3;
    }

    public int a(CharSequence charSequence) {
        return a(charSequence, getChildCount());
    }

    public int a(int i2, String str) {
        return a(i2, getChildCount(), str);
    }

    public final void a(int i2, boolean z, boolean z2) {
        boolean z3;
        if (i2 >= getTabCount() || i2 < 0 || i2 == this.K) {
            return;
        }
        h hVar = this.S;
        if (hVar != null) {
            ((i) hVar).a(this, i2, true, z2);
        }
        View childAt = getChildAt(i2);
        View selectView = getSelectView();
        if (childAt != selectView) {
            if (childAt != null) {
                childAt.setSelected(true);
            }
            if (selectView != null) {
                selectView.setSelected(false);
            }
            this.K = i2;
            z3 = true;
        } else {
            z3 = false;
        }
        a(z, new b(z3, childAt, z2, i2));
    }

    public final void a(boolean z, g gVar) {
        if (getTabCount() <= 0) {
            return;
        }
        boolean z2 = z && this.e;
        getIndicatorPosition();
        if (z2) {
            if (this.M == null) {
                this.M = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f);
                this.M.setDuration(300L);
                this.M.addUpdateListener(new c());
                this.M.addListener(new d());
                this.M.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            this.M.addListener(new e(gVar));
            this.M.start();
            return;
        }
        t();
        if (gVar != null) {
            gVar.onStart();
            gVar.onEnd();
        }
        invalidate();
    }

    public void a(int i2, boolean z) {
        a(i2, z, false);
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        a(Integer.valueOf(this.K));
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof re0) {
                re0 re0Var = (re0) childAt;
                re0Var.a(i2);
                re0Var.b(str + "_" + i2);
                StringBuilder sb = new StringBuilder();
                sb.append("onBuildVuiElement:");
                sb.append(str);
                d(sb.toString());
            }
        }
        return null;
    }

    @Override // defpackage.hc0
    public boolean a(final View view, tc0 tc0Var) {
        final Double d2;
        d("tablayout onVuiElementEvent");
        if (view == null || (d2 = (Double) tc0Var.getEventValue(tc0Var)) == null) {
            return false;
        }
        post(new Runnable() { // from class: jf0
            @Override // java.lang.Runnable
            public final void run() {
                XTabLayout.this.a(d2, view);
            }
        });
        return true;
    }

    public /* synthetic */ void a(Double d2, View view) {
        if (d2.intValue() < getChildCount()) {
            z90.a(getChildAt(d2.intValue()), 0);
        } else {
            z90.a(view, 0);
        }
        b(true);
        a(d2.intValue(), true, true);
        b(false);
    }
}
