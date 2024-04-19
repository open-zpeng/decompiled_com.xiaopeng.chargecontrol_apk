package com.xiaopeng.xui.drawable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class XLoadingDrawable extends Drawable {
    public static final int ALPHA_MAX = 255;
    public static final int ALPHA_MIN = 92;
    public static final int COUNT_LARGE = 5;
    public static final int COUNT_MEDIUM = 5;
    public static final int COUNT_SMALL = 3;
    public static final int COUNT_XLARGE = 7;
    public static final float DEFAULT_DEGREE = 25.0f;
    public static final long DEFAULT_DURATION = 1000;
    public static final float DEFAULT_MASK_FILTER = 2.0f;
    public static final double DEFAULT_RADIANS = Math.toRadians(25.0d);
    public static final float DEFAULT_RECT_RADIUS = 1.0f;
    public static final float MAX_HEIGHT_LARGE = 34.0f;
    public static final float MAX_HEIGHT_MEDIUM = 22.0f;
    public static final float MAX_HEIGHT_SMALL = 16.0f;
    public static final float MAX_HEIGHT_XLARGE = 50.0f;
    public static final float MIN_HEIGHT_LARGE = 12.0f;
    public static final float MIN_HEIGHT_MEDIUM = 8.0f;
    public static final float MIN_HEIGHT_SMALL = 4.0f;
    public static final float MIN_HEIGHT_XLARGE = 10.0f;
    public static final String TAG = "xpui-XLoadingDrawable";
    public static final int TYPE_LARGE = 2;
    public static final int TYPE_MEDIUM = 1;
    public static final int TYPE_SMALL = 0;
    public static final int TYPE_XLARGE = 3;
    public static final float WIDTH_LARGE = 6.0f;
    public static final float WIDTH_MEDIUM = 4.0f;
    public static final float WIDTH_SMALL = 4.0f;
    public static final float WIDTH_XLARGE = 6.0f;
    public static final float X_SPACING_LARGE = 8.0f;
    public static final float X_SPACING_MEDIUM = 5.0f;
    public static final float X_SPACING_SMALL = 5.0f;
    public static final float X_SPACING_XLARGE = 19.0f;
    public boolean isAmStarted;
    public int[] mAlphas;
    public ValueAnimator[] mAnimations;
    public float mCenterX;
    public float mCenterY;
    public int mColor;
    public int mCount;
    public float mDelayFactor;
    public final MaskFilter mMaskFilter;
    public float[] mRectHeights;
    public float[] mRectTopXs;
    public float[] mRectTopYs;
    public float mRectWidth;
    public float mSpacingX;
    public float maxHeight;
    public float minHeight;
    public int mColorId = vc0.x_theme_text_01;
    public final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    public long mDuration = 1000;
    public boolean isDebug = false;
    public final Paint mPaint = new Paint();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Type {
    }

    public XLoadingDrawable() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mMaskFilter = new BlurMaskFilter(2.0f, BlurMaskFilter.Blur.SOLID);
    }

    private void initParams() {
        if (this.mCount == 0) {
            be0.b(TAG, "You must setType or config loading_type first");
        }
        if (this.mCenterX == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.mCenterX = getIntrinsicWidth() * 0.5f;
            this.mCenterY = getIntrinsicHeight() * 0.5f;
            int i = this.mCount;
            this.mRectTopXs = new float[i];
            float f = this.mCenterX - (((i >> 1) * this.mSpacingX) + ((i * this.mRectWidth) * 0.5f));
            for (int i2 = 0; i2 < this.mCount; i2++) {
                this.mRectTopXs[i2] = ((this.mSpacingX + this.mRectWidth) * i2) + f;
            }
        }
    }

    private void makeAnimations() {
        final int i = this.mCount;
        this.mAnimations = new ValueAnimator[i];
        this.mRectHeights = new float[i];
        this.mRectTopYs = new float[i];
        this.mAlphas = new int[i];
        for (final int i2 = 0; i2 < i; i2++) {
            this.mAnimations[i2] = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            this.mAnimations[i2].setRepeatCount(-1);
            this.mAnimations[i2].setRepeatMode(2);
            this.mAnimations[i2].setDuration(this.mDuration);
            this.mAnimations[i2].setInterpolator(this.mInterpolator);
            this.mAnimations[i2].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: pd0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XLoadingDrawable.this.a(i2, i, valueAnimator);
                }
            });
        }
    }

    private void setBlurEffect(Resources resources) {
        if (this.mPaint == null || this.mMaskFilter == null) {
            return;
        }
        Configuration configuration = resources.getConfiguration();
        boolean z = false;
        if (configuration != null && (configuration.uiMode & 48) == 32) {
            z = true;
        }
        if (z) {
            this.mPaint.setMaskFilter(this.mMaskFilter);
        } else {
            this.mPaint.setMaskFilter(null);
        }
    }

    private void startAnimations() {
        makeAnimations();
        int i = 0;
        while (i < this.mCount) {
            int i2 = i + 1;
            this.mAnimations[i].setCurrentFraction(1.0f - (this.mDelayFactor * i2));
            this.mAnimations[i].start();
            i = i2;
        }
        this.isAmStarted = true;
    }

    public /* synthetic */ void a(int i, int i2, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mAlphas[i] = ((int) (163.0f * floatValue)) + 92;
        float[] fArr = this.mRectHeights;
        float f = this.minHeight;
        fArr[i] = jg.a(this.maxHeight, f, floatValue, f);
        int i3 = i2 - 1;
        this.mRectTopYs[i] = ((this.mSpacingX + this.mRectWidth) * ((i3 * 0.5f) - i) * ((float) Math.tan(DEFAULT_RADIANS))) + (this.mCenterY - (fArr[i] * 0.5f));
        if (i == i3) {
            invalidateSelf();
        }
    }

    public void cancelAnimations() {
        ValueAnimator[] valueAnimatorArr = this.mAnimations;
        if (valueAnimatorArr != null) {
            for (ValueAnimator valueAnimator : valueAnimatorArr) {
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
            }
        }
        this.isAmStarted = false;
        this.mAnimations = null;
        this.mCenterX = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        initParams();
        if (!this.isAmStarted && isVisible()) {
            startAnimations();
            return;
        }
        if (this.isDebug) {
            this.mPaint.setColor(-65536);
            canvas.drawLine(XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.mCenterY, getIntrinsicWidth(), this.mCenterY, this.mPaint);
            float f = this.mCenterX;
            canvas.drawLine(f, XToggleDrawable.LIGHT_RADIUS_DEFAULT, f, getIntrinsicHeight(), this.mPaint);
        }
        canvas.rotate(25.0f, this.mCenterX, this.mCenterY);
        for (int i = 0; i < this.mCount; i++) {
            this.mPaint.setColor(this.mColor);
            this.mPaint.setAlpha(this.mAlphas[i]);
            float[] fArr = this.mRectTopXs;
            float f2 = fArr[i];
            float[] fArr2 = this.mRectTopYs;
            canvas.drawRoundRect(f2, fArr2[i], this.mRectWidth + fArr[i], fArr2[i] + this.mRectHeights[i], 1.0f, 1.0f, this.mPaint);
        }
    }

    public float getDelayFactor() {
        return this.mDelayFactor;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().bottom - getBounds().top;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().right - getBounds().left;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XLoadingDrawable);
        this.mColorId = obtainAttributes.getResourceId(dd0.XLoadingDrawable_loading_color, vc0.x_theme_text_01);
        this.mColor = resources.getColor(this.mColorId, theme);
        setType(obtainAttributes.getInt(dd0.XLoadingDrawable_loading_type, 3));
        obtainAttributes.recycle();
        setBlurEffect(resources);
    }

    public void onConfigurationChanged(Context context, Configuration configuration) {
        this.mColor = context.getResources().getColor(this.mColorId, context.getTheme());
        setBlurEffect(context.getResources());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public void setDuration(long j) {
        cancelAnimations();
        this.mDuration = j;
        invalidateSelf();
    }

    public void setType(int i) {
        cancelAnimations();
        if (i == 0) {
            this.mCount = 3;
            this.mRectWidth = 4.0f;
            this.mSpacingX = 5.0f;
            this.maxHeight = 16.0f;
            this.minHeight = 4.0f;
        } else if (i == 1) {
            this.mCount = 5;
            this.mRectWidth = 4.0f;
            this.mSpacingX = 5.0f;
            this.maxHeight = 22.0f;
            this.minHeight = 8.0f;
        } else if (i != 2) {
            this.mCount = 7;
            this.mRectWidth = 6.0f;
            this.mSpacingX = 19.0f;
            this.maxHeight = 50.0f;
            this.minHeight = 10.0f;
        } else {
            this.mCount = 5;
            this.mRectWidth = 6.0f;
            this.mSpacingX = 8.0f;
            this.maxHeight = 34.0f;
            this.minHeight = 12.0f;
        }
        this.mDelayFactor = 0.5f / (this.mCount - 1);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (!z) {
            cancelAnimations();
        }
        return super.setVisible(z, z2);
    }
}
