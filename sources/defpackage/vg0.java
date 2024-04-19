package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.view.XView;
/* compiled from: SlideLineView.java */
/* renamed from: vg0  reason: default package */
/* loaded from: classes.dex */
public class vg0 extends XView {
    public boolean d;
    public Paint e;
    public int f;
    public int g;
    public ValueAnimator h;
    public int i;
    public int j;
    public Paint k;
    public boolean l;
    public float m;
    public float n;
    public float o;

    /* compiled from: SlideLineView.java */
    /* renamed from: vg0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vg0.this.invalidate();
        }
    }

    public vg0(Context context, boolean z, int i) {
        super(context, null, 0, i);
        this.f = 671088640;
        this.g = -1;
        this.i = 671088640;
        this.j = -15301639;
        this.l = ThemeManager.isNightMode(getContext());
        this.m = 1.0f;
        setLayerType(1, null);
        a((AttributeSet) null, i);
        this.d = z;
    }

    public final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        Context context = getContext();
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, dd0.SlideLineView, 0, i);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(i, dd0.SlideLineView);
        }
        this.i = obtainStyledAttributes.getColor(dd0.SlideLineView_slider_line_un_select, this.i);
        this.j = obtainStyledAttributes.getColor(dd0.SlideLineView_slider_line_select, this.j);
        obtainStyledAttributes.recycle();
        if (this.e == null) {
            this.e = new Paint(1);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setStrokeCap(Paint.Cap.ROUND);
            this.e.setStrokeWidth(4.0f);
        }
        this.e.setColor(this.j);
        if (this.k == null) {
            this.k = new Paint(1);
            this.k.setStyle(Paint.Style.FILL);
            this.k.setStrokeCap(Paint.Cap.ROUND);
            this.k.setStrokeWidth(4.0f);
            this.k.setColor(4);
        }
        if (this.h == null) {
            this.h = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 2.0f, 1.0f);
            this.h.setDuration(800L);
            this.h.addUpdateListener(new tg0(this));
            this.h.setInterpolator(new DecelerateInterpolator());
            this.h.addListener(new ug0(this));
        }
        setEnabled(true);
        invalidate();
    }

    public void c(boolean z) {
        this.d = z;
        this.e.setStrokeWidth(z ? 2.0f : 4.0f);
        if (z) {
            if (this.l) {
                this.k.setColor(this.j);
            } else {
                this.k.setColor(this.g);
            }
            this.k.setMaskFilter(new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.NORMAL));
        }
        if (!z) {
            this.h.cancel();
        } else {
            this.h.start();
        }
        invalidate();
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.l = ThemeManager.isNightMode(getContext());
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.l = ThemeManager.isNightMode(getContext());
        postDelayed(new a(), 500L);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d) {
            if (this.l) {
                this.e.setColor(this.j);
                this.k.setColor(this.j);
                float f = this.n;
                float f2 = this.m;
                float f3 = f - (f2 * 3.2258065f);
                float f4 = f + (3.2258065f * f2);
                float f5 = this.o;
                float f6 = (f2 * 5.0f) + f5;
                float f7 = f5 - (f2 * 5.0f);
                canvas.drawLine(f3, f6, f4, f7, this.e);
                canvas.drawLine(f3, f6, f4, f7, this.k);
                return;
            }
            this.e.setColor(this.g);
            this.k.setColor(this.g);
            canvas.drawCircle(this.n, this.o, this.m * 2.0f, this.e);
            canvas.drawCircle(this.n, this.o, this.m * 2.0f, this.k);
        } else if (this.l) {
            this.e.setColor(this.i);
            float f8 = this.n;
            float f9 = this.o;
            canvas.drawLine(f8 - 3.2258065f, f9 + 5.0f, f8 + 3.2258065f, f9 - 5.0f, this.e);
        } else {
            this.e.setColor(this.f);
            canvas.drawCircle(this.n, this.o, 2.0f, this.e);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(22, 40);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n = getWidth() / 2.0f;
        this.o = getHeight() / 2.0f;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.i = z ? 671088640 : 503316480;
        this.j = z ? this.j | (-1291845632) : this.j & 1291845631;
        invalidate();
    }
}
