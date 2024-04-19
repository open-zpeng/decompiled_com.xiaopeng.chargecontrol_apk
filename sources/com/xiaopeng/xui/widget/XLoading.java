package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.view.XView;
import java.util.Locale;
/* loaded from: classes.dex */
public class XLoading extends XView {
    public rd0 d;
    public XLoadingDrawable e;
    public boolean f;

    public XLoading(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        rd0 rd0Var;
        rd0 rd0Var2;
        if (this.f && (rd0Var2 = this.d) != null) {
            if (rd0Var2.d == -1) {
                rd0Var2.d = System.currentTimeMillis();
                if (rd0Var2.b == -1) {
                    rd0Var2.b = rd0Var2.d;
                }
            } else {
                throw new RuntimeException("Do you forget to call frameEnd? ");
            }
        }
        super.draw(canvas);
        if (!this.f || (rd0Var = this.d) == null) {
            return;
        }
        if (rd0Var.d != -1) {
            long currentTimeMillis = System.currentTimeMillis();
            rd0Var.c = (currentTimeMillis - rd0Var.d) + rd0Var.c;
            rd0Var.e++;
            if (currentTimeMillis - rd0Var.b > rd0Var.a) {
                StringBuilder sb = new StringBuilder();
                sb.append(rd0Var.e);
                sb.append(" FPS\t\t");
                rd0Var.f = (((float) rd0Var.c) * 1.0f) / rd0Var.e;
                sb.append(String.format(Locale.getDefault(), "%.2f", Float.valueOf(rd0Var.f)));
                sb.append(" ms/f");
                rd0Var.g = sb.toString();
                be0.a(rd0Var.h, rd0Var.g);
                rd0Var.c = 0L;
                rd0Var.e = 0;
                rd0Var.b = currentTimeMillis;
            }
            rd0Var.d = -1L;
            String str = rd0Var.g;
            return;
        }
        throw new RuntimeException("Do you forget to call frameStart? ");
    }

    public float getDelayFactor() {
        return this.e.getDelayFactor();
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e.onConfigurationChanged(getContext(), getResources().getConfiguration());
        this.e.cancelAnimations();
        invalidate();
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.e.onConfigurationChanged(getContext(), configuration);
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.cancelAnimations();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.draw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e.setBounds(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (getLayoutParams().width == -2 && getLayoutParams().height == -2) {
            setMeasuredDimension(216, 216);
        } else if (getLayoutParams().width == -2) {
            setMeasuredDimension(216, size2);
        } else if (getLayoutParams().height == -2) {
            setMeasuredDimension(size, 216);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.e.setVisible(i == 0, true);
    }

    public void setDebug(boolean z) {
        this.f = z;
        this.e.setDebug(z);
    }

    public void setDuration(long j) {
        this.e.setDuration(j);
    }

    public void setType(int i) {
        this.e.setType(i);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.e;
    }

    public XLoading(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, cd0.XLoading_XLarge);
    }

    public XLoading(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, cd0.XLoading_XLarge);
    }

    public XLoading(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = false;
        int i3 = Build.VERSION.SDK_INT;
        this.e = new XLoadingDrawable();
        this.e.setCallback(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, dd0.XLoading, i, i2);
        this.e.setType(obtainStyledAttributes.getInt(dd0.XLoading_loading_type, 3));
        obtainStyledAttributes.recycle();
        if (this.f) {
            this.d = new rd0("XLoading");
        }
    }
}
