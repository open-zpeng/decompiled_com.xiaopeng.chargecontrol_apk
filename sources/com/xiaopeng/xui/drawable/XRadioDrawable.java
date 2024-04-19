package com.xiaopeng.xui.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class XRadioDrawable extends Drawable {
    public float DIMEN_18;
    public int mBgColor;
    public int mBgDisableColor;
    public int mBgEnableNormalColor;
    public int mBgEnablePressedColor;
    public float mCenterX;
    public float mCenterY;
    public int mCircleColor;
    public int mCircleDisableColor;
    public int mCircleEnableColor;
    public float mHeight;
    public int mInnerColor;
    public int mInnerDisableColor;
    public int mInnerEnableColor;
    public float mInnerRadius;
    public float mLeft;
    public Paint mPaint;
    public float mTop;
    public float mWidth;
    public float DIMEN_16 = 16.0f;
    public float DIMEN_16_5 = 16.5f;
    public float DIMEN_3 = 3.0f;
    public float DIMEN_8 = 8.0f;
    public final int[] stateSpecPress = {16842919};
    public final int[] stateSpecEnable = {16842910};
    public final int[] stateSpecCheck = {16842912};

    private void changeParams() {
        if (StateSet.stateSetMatches(this.stateSpecEnable, getState())) {
            if (StateSet.stateSetMatches(this.stateSpecPress, getState())) {
                this.mBgColor = this.mBgEnablePressedColor;
            } else {
                this.mBgColor = this.mBgEnableNormalColor;
            }
            this.mCircleColor = this.mCircleEnableColor;
            this.mInnerColor = this.mInnerEnableColor;
        } else {
            this.mBgColor = this.mBgDisableColor;
            this.mCircleColor = this.mCircleDisableColor;
            this.mInnerColor = this.mInnerDisableColor;
        }
        updateInnerShape();
    }

    private void inflateAttrs(Resources resources, Resources.Theme theme) {
        this.mPaint = new Paint(1);
        if (resources != null) {
            this.mBgEnableNormalColor = resources.getColor(vc0.x_theme_primary_neutral_normal, theme);
            this.mBgEnablePressedColor = resources.getColor(vc0.x_theme_primary_neutral_pressed, theme);
            this.mBgDisableColor = resources.getColor(vc0.x_theme_primary_neutral_disable, theme);
            this.mCircleEnableColor = resources.getColor(vc0.x_theme_primary_normal, theme);
            this.mCircleDisableColor = resources.getColor(vc0.x_radio_disable_color, theme);
            this.mInnerEnableColor = resources.getColor(vc0.x_radio_inner_color, theme);
            this.mInnerDisableColor = resources.getColor(vc0.x_radio_inner_disable_color, theme);
            this.DIMEN_18 = TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
            this.DIMEN_16 = TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
            this.DIMEN_16_5 = TypedValue.applyDimension(1, 16.5f, resources.getDisplayMetrics());
            this.DIMEN_3 = TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics());
            this.DIMEN_8 = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        }
    }

    private void updateInnerShape() {
        if (!StateSet.stateSetMatches(this.stateSpecCheck, getState())) {
            float f = this.mCenterX;
            float f2 = this.DIMEN_16_5;
            this.mLeft = f - f2;
            this.mWidth = f2 * 2.0f;
            this.mTop = this.mCenterY;
            this.mHeight = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.mInnerRadius = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            return;
        }
        float f3 = this.mCenterX;
        float f4 = this.DIMEN_8;
        this.mLeft = f3 - f4;
        float f5 = this.DIMEN_16;
        this.mWidth = f5;
        this.mTop = this.mCenterY - f4;
        this.mHeight = f5;
        this.mInnerRadius = f4;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mBgColor);
        canvas.drawCircle(this.mCenterX, this.mCenterY, this.DIMEN_18, this.mPaint);
        this.mPaint.setColor(this.mCircleColor);
        if (!StateSet.stateSetMatches(this.stateSpecCheck, getState())) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.DIMEN_3);
            canvas.drawCircle(this.mCenterX, this.mCenterY, this.DIMEN_16_5, this.mPaint);
        } else {
            canvas.drawCircle(this.mCenterX, this.mCenterY, this.DIMEN_18, this.mPaint);
        }
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mInnerColor);
        float f = this.mLeft;
        float f2 = this.mTop;
        float f3 = this.mInnerRadius;
        canvas.drawRoundRect(f, f2, f + this.mWidth, f2 + this.mHeight, f3, f3, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        inflateAttrs(resources, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mCenterX = rect.width() / 2.0f;
        this.mCenterY = rect.height() / 2.0f;
        changeParams();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        changeParams();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflateAttrs(resources, null);
    }
}
