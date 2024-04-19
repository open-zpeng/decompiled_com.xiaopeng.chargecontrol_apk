package com.xiaopeng.xui.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import com.xiaopeng.xui.drawable.XSwitchThumbDrawable;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class XSwitchThumbDrawable extends Drawable {
    public static final int DEFAULT_HEIGHT = 44;
    public static final int DEFAULT_INDICATOR_HEIGHT = 18;
    public static final int DEFAULT_INDICATOR_RADIUS = 3;
    public static final int DEFAULT_INDICATOR_WIDTH = 6;
    public static final int DEFAULT_PADDING = 4;
    public static final int DEFAULT_THUMB_RADIUS = 7;
    public static final int DEFAULT_WIDTH = 44;
    public static final int INDICATOR_COLOR = -14176402;
    public static final long INDICATOR_DURATION = 200;
    public static final String TAG = "XSwitchThumbDrawable";
    public static final int THUMB_COLOR = -1;
    public int mHeight;
    public ValueAnimator mIndicatorAnimator;
    public ColorStateList mIndicatorColors;
    public float mIndicatorPaddingStart;
    public float mIndicatorPaddingTop;
    public int mIndicatorRoundRadius;
    public float mPadding;
    public ColorStateList mThumbColors;
    public int mThumbRoundRadius;
    public int mWidth;
    public final Paint mThumbPaint = new Paint(1);
    public final Paint mIndicatorPaint = new Paint(1);
    public boolean mChecked = false;
    public boolean mEnabled = true;
    public boolean mEnableIndicator = false;
    public float mIndicatorTopOffset = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float mIndicatorStartOffset = XToggleDrawable.LIGHT_RADIUS_DEFAULT;

    public XSwitchThumbDrawable() {
        this.mThumbPaint.setColor(-1);
        this.mThumbPaint.setStyle(Paint.Style.FILL);
        this.mIndicatorPaint.setColor(INDICATOR_COLOR);
        this.mIndicatorPaint.setStyle(Paint.Style.FILL);
    }

    private void initAnimator() {
        final float f = (this.mHeight / 2.0f) - this.mIndicatorPaddingTop;
        this.mIndicatorAnimator = ValueAnimator.ofInt(0, 100);
        this.mIndicatorAnimator.setDuration(200L);
        this.mIndicatorAnimator.setInterpolator(new DecelerateInterpolator());
        this.mIndicatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: qd0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                XSwitchThumbDrawable.this.a(f, valueAnimator);
            }
        });
        this.mIndicatorAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.drawable.XSwitchThumbDrawable.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                Log.d(XSwitchThumbDrawable.TAG, "onAnimationCancel");
                XSwitchThumbDrawable xSwitchThumbDrawable = XSwitchThumbDrawable.this;
                xSwitchThumbDrawable.mEnableIndicator = xSwitchThumbDrawable.mChecked;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Log.d(XSwitchThumbDrawable.TAG, "onAnimationCancel");
                XSwitchThumbDrawable xSwitchThumbDrawable = XSwitchThumbDrawable.this;
                xSwitchThumbDrawable.mEnableIndicator = xSwitchThumbDrawable.mChecked;
            }
        });
    }

    public /* synthetic */ void a(float f, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.mChecked) {
            this.mIndicatorTopOffset = f - Math.round((intValue / 100.0f) * f);
        } else {
            this.mIndicatorTopOffset = Math.round((intValue / 100.0f) * f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        float f = this.mPadding;
        float f2 = bounds.left + f;
        float f3 = bounds.top + f;
        float f4 = bounds.right - f;
        float f5 = bounds.bottom - f;
        int i = this.mThumbRoundRadius;
        canvas.drawRoundRect(f2, f3, f4, f5, i, i, this.mThumbPaint);
        if (this.mEnableIndicator) {
            float f6 = this.mIndicatorPaddingStart;
            float f7 = this.mIndicatorStartOffset;
            float f8 = this.mIndicatorPaddingTop;
            float f9 = this.mIndicatorTopOffset;
            float f10 = (bounds.bottom - f8) - f9;
            int i2 = this.mIndicatorRoundRadius;
            canvas.drawRoundRect(bounds.left + f6 + f7, bounds.top + f8 + f9, (bounds.right - f6) - f7, f10, i2, i2, this.mIndicatorPaint);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        if (theme != null) {
            obtainAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XSwitchThumbDrawable, 0, 0);
        } else {
            obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XSwitchThumbDrawable);
        }
        this.mWidth = obtainAttributes.getDimensionPixelSize(dd0.XSwitchThumbDrawable_switch_thumb_width, 44);
        this.mHeight = obtainAttributes.getDimensionPixelSize(dd0.XSwitchThumbDrawable_switch_thumb_height, 44);
        this.mPadding = obtainAttributes.getDimension(dd0.XSwitchThumbDrawable_switch_thumb_padding, 4.0f);
        this.mThumbRoundRadius = obtainAttributes.getDimensionPixelSize(dd0.XSwitchThumbDrawable_switch_thumb_round_radius, 7);
        this.mIndicatorRoundRadius = obtainAttributes.getDimensionPixelSize(dd0.XSwitchThumbDrawable_switch_thumb_indicator_round_radius, 3);
        float dimension = obtainAttributes.getDimension(dd0.XSwitchThumbDrawable_switch_thumb_indicator_width, 6.0f);
        float dimension2 = obtainAttributes.getDimension(dd0.XSwitchThumbDrawable_switch_thumb_indicator_height, 18.0f);
        this.mIndicatorPaddingStart = Math.round((this.mWidth - dimension) / 2.0f);
        this.mIndicatorPaddingTop = Math.round((this.mHeight - dimension2) / 2.0f);
        this.mIndicatorColors = obtainAttributes.getColorStateList(dd0.XSwitchThumbDrawable_switch_thumb_indicator_color);
        if (this.mIndicatorColors == null) {
            this.mIndicatorColors = ColorStateList.valueOf(INDICATOR_COLOR);
        }
        this.mIndicatorPaint.setColor(this.mIndicatorColors.getDefaultColor());
        this.mThumbColors = obtainAttributes.getColorStateList(dd0.XSwitchThumbDrawable_switch_thumb_color);
        if (this.mThumbColors == null) {
            this.mThumbColors = ColorStateList.valueOf(-1);
        }
        this.mThumbPaint.setColor(this.mThumbColors.getDefaultColor());
        obtainAttributes.recycle();
        initAnimator();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        this.mIndicatorPaint.setColor(this.mIndicatorColors.getColorForState(iArr, INDICATOR_COLOR));
        this.mThumbPaint.setColor(this.mThumbColors.getColorForState(iArr, -1));
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842912) {
                z = true;
            } else if (i == 16842910) {
                z2 = true;
            }
        }
        boolean z3 = this.mChecked != z;
        if (z3) {
            this.mChecked = z;
            this.mEnableIndicator = true;
            if (getBounds().isEmpty()) {
                Log.d(TAG, "onStateChange: checked:" + z + ", ignore animation, bounds:" + getBounds());
            } else {
                Log.d(TAG, "onStateChange: checked:" + z + ", with animation, bounds:" + getBounds());
                ValueAnimator valueAnimator = this.mIndicatorAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.mIndicatorAnimator.start();
                }
            }
        }
        if (this.mEnabled != z2) {
            Log.d(TAG, "onStateChange: enabled:" + z2);
            this.mEnabled = z2;
        }
        return z3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mThumbPaint.setAlpha(i);
        this.mIndicatorPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
