package com.xiaopeng.xui.drawable;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.xiaopeng.xui.drawable.XIndicatorDrawable;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public final class XIndicatorDrawable extends Drawable {
    public static final int INDICATOR_TYPE_LINE = 1;
    public static final int INDICATOR_TYPE_RECT = 0;
    public static final String TAG = XIndicatorDrawable.class.getSimpleName();
    public float mAnimIndicatorEnd;
    public float mAnimIndicatorStart;
    public BlurMaskFilter mBlurMaskFilter;
    public ColorStateList mColorStateList;
    public int mDefaultColor;
    public int mIndicatorColorRes;
    public int mIndicatorCount;
    public float mIndicatorEnd;
    public float mIndicatorEndAnimSpeed;
    public float mIndicatorEndDistance;
    public float mIndicatorHeight;
    public float mIndicatorPaddingBottom;
    public float mIndicatorPercent;
    public float mIndicatorRadius;
    public final RectF mIndicatorRect;
    public float mIndicatorStart;
    public float mIndicatorStartAnimSpeed;
    public float mIndicatorStartDistance;
    public OnAnimationListener mOnAnimationListener;
    public final ValueAnimator mValueAnimator;
    public int mIndicatorType = 0;
    public int mCurrentSelection = -1;
    public boolean mEnable = true;
    public final Paint mPaint = new Paint(1);

    /* loaded from: classes.dex */
    public interface OnAnimationListener {
        void onEnd();

        void onStart();
    }

    public XIndicatorDrawable() {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mIndicatorRect = new RectF();
        this.mValueAnimator = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f);
        this.mValueAnimator.setDuration(500L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: od0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                XIndicatorDrawable.this.a(valueAnimator);
            }
        });
        this.mValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mValueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.xui.drawable.XIndicatorDrawable.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                XIndicatorDrawable xIndicatorDrawable = XIndicatorDrawable.this;
                xIndicatorDrawable.mAnimIndicatorStart = xIndicatorDrawable.mIndicatorStart;
                XIndicatorDrawable xIndicatorDrawable2 = XIndicatorDrawable.this;
                xIndicatorDrawable2.mAnimIndicatorEnd = xIndicatorDrawable2.mIndicatorEnd;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (XIndicatorDrawable.this.mOnAnimationListener != null) {
                    XIndicatorDrawable.this.mOnAnimationListener.onEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (XIndicatorDrawable.this.mOnAnimationListener != null) {
                    XIndicatorDrawable.this.mOnAnimationListener.onStart();
                }
            }
        });
    }

    private float dp(Resources resources, int i) {
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    private void setPaintColor() {
        ColorStateList colorStateList;
        Paint paint = this.mPaint;
        if (paint == null || (colorStateList = this.mColorStateList) == null) {
            return;
        }
        if (this.mEnable) {
            paint.setColor(colorStateList.getColorForState(getState(), this.mDefaultColor));
        } else {
            paint.setColor(colorStateList.getColorForState(StateSet.WILD_CARD, this.mDefaultColor));
        }
    }

    private void startAnimation() {
        if (this.mAnimIndicatorStart <= this.mIndicatorStart && this.mAnimIndicatorEnd <= this.mIndicatorEnd) {
            this.mIndicatorStartAnimSpeed = 2.0f;
            this.mIndicatorEndAnimSpeed = 1.0f;
        } else if (this.mAnimIndicatorStart >= this.mIndicatorStart && this.mAnimIndicatorEnd >= this.mIndicatorEnd) {
            this.mIndicatorStartAnimSpeed = 1.0f;
            this.mIndicatorEndAnimSpeed = 2.0f;
        } else {
            this.mIndicatorStartAnimSpeed = 1.0f;
            this.mIndicatorEndAnimSpeed = 1.0f;
        }
        this.mIndicatorStartDistance = this.mAnimIndicatorStart - this.mIndicatorStart;
        this.mIndicatorEndDistance = this.mAnimIndicatorEnd - this.mIndicatorEnd;
        this.mValueAnimator.start();
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = this.mIndicatorStartAnimSpeed * floatValue;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.mIndicatorStart = this.mAnimIndicatorStart - ((1.0f - f) * this.mIndicatorStartDistance);
        float f2 = floatValue * this.mIndicatorEndAnimSpeed;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.mIndicatorEnd = this.mAnimIndicatorEnd - ((1.0f - f2) * this.mIndicatorEndDistance);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!isVisible() || this.mCurrentSelection == -1) {
            return;
        }
        RectF rectF = this.mIndicatorRect;
        rectF.left = this.mIndicatorStart;
        rectF.right = this.mIndicatorEnd;
        if (this.mIndicatorType == 1) {
            this.mPaint.setMaskFilter(this.mBlurMaskFilter);
        } else {
            this.mPaint.setMaskFilter(null);
        }
        RectF rectF2 = this.mIndicatorRect;
        float f = this.mIndicatorRadius;
        canvas.drawRoundRect(rectF2, f, f, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflateAttrs(resources, attributeSet, null);
        super.inflate(resources, xmlPullParser, attributeSet);
    }

    public void inflateAttrs(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (resources == null || attributeSet == null) {
            return;
        }
        if (theme != null) {
            obtainAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XSegmented, 0, 0);
        } else {
            obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XSegmented);
        }
        this.mIndicatorColorRes = obtainAttributes.getResourceId(dd0.XSegmented_segment_indicator_color, vc0.x_segment_indicator_color);
        this.mIndicatorType = obtainAttributes.getInt(dd0.XSegmented_segment_indicator_type, 0);
        onConfigurationChanged(resources, theme);
        if (this.mIndicatorType == 1) {
            this.mIndicatorPercent = obtainAttributes.getFloat(dd0.XSegmented_segment_line_width_percent, 1.0f);
            this.mIndicatorHeight = dp(resources, 4);
            this.mIndicatorPaddingBottom = obtainAttributes.getDimension(dd0.XSegmented_segment_line_padding_bottom, dp(resources, 6));
            if (this.mIndicatorPercent > 1.0f) {
                this.mIndicatorPercent = 1.0f;
            }
        }
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mIndicatorType == 1) {
            this.mIndicatorRect.bottom = rect.height() - this.mIndicatorPaddingBottom;
            RectF rectF = this.mIndicatorRect;
            rectF.top = rectF.bottom - this.mIndicatorHeight;
        } else {
            RectF rectF2 = this.mIndicatorRect;
            rectF2.top = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            rectF2.bottom = rect.height();
        }
        this.mIndicatorRadius = this.mIndicatorRect.height() / 2.0f;
        setSelection(this.mIndicatorCount, this.mCurrentSelection, false);
    }

    public void onConfigurationChanged(Resources resources, Resources.Theme theme) {
        this.mColorStateList = resources.getColorStateList(this.mIndicatorColorRes, theme);
        this.mDefaultColor = resources.getColor(vc0.x_segment_indicator_color, theme);
        setPaintColor();
        Configuration configuration = resources.getConfiguration();
        boolean z = false;
        if (configuration != null && (configuration.uiMode & 48) == 32) {
            z = true;
        }
        if (z && this.mIndicatorType == 1) {
            this.mBlurMaskFilter = new BlurMaskFilter(dp(resources, 4), BlurMaskFilter.Blur.SOLID);
        } else {
            this.mBlurMaskFilter = null;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        super.onStateChange(iArr);
        setPaintColor();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setEnable(boolean z) {
        if (z != this.mEnable) {
            this.mEnable = z;
            setPaintColor();
            invalidateSelf();
        }
    }

    public void setOnAnimationListener(OnAnimationListener onAnimationListener) {
        this.mOnAnimationListener = onAnimationListener;
    }

    public void setSelection(int i, int i2, boolean z) {
        this.mIndicatorCount = i;
        this.mCurrentSelection = i2;
        Rect bounds = getBounds();
        if (this.mIndicatorCount <= this.mCurrentSelection || bounds.width() <= 0) {
            return;
        }
        if (this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        float width = bounds.width();
        if (this.mIndicatorCount != 0) {
            width = bounds.width() / this.mIndicatorCount;
        }
        this.mAnimIndicatorStart = this.mCurrentSelection * width;
        float f = this.mAnimIndicatorStart;
        this.mAnimIndicatorEnd = f + width;
        if (this.mIndicatorType == 1) {
            float f2 = ((1.0f - this.mIndicatorPercent) * width) / 2.0f;
            this.mAnimIndicatorStart = f + f2;
            this.mAnimIndicatorEnd -= f2;
        }
        if (this.mIndicatorStart == this.mAnimIndicatorStart && this.mIndicatorEnd == this.mAnimIndicatorEnd) {
            return;
        }
        if (z) {
            startAnimation();
            return;
        }
        this.mIndicatorStart = this.mAnimIndicatorStart;
        this.mIndicatorEnd = this.mAnimIndicatorEnd;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        inflateAttrs(resources, attributeSet, theme);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
