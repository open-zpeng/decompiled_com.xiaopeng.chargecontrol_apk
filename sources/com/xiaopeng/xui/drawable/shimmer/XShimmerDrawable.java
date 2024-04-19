package com.xiaopeng.xui.drawable.shimmer;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.drawable.shimmer.XShimmer;
import org.xmlpull.v1.XmlPullParser;
@Deprecated
/* loaded from: classes.dex */
public class XShimmerDrawable extends Drawable {
    public XShimmer.Builder mBuilder;
    public XShimmer mShimmer;
    public ValueAnimator mValueAnimator;
    public final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.drawable.shimmer.XShimmerDrawable.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            XShimmerDrawable.this.invalidateSelf();
        }
    };
    public final Paint mShimmerPaint = new Paint();
    public final Rect mDrawRect = new Rect();
    public final Matrix mShaderMatrix = new Matrix();

    public XShimmerDrawable() {
        this.mShimmerPaint.setAntiAlias(true);
    }

    private float offset(float f, float f2, float f3) {
        return jg.a(f2, f, f3, f);
    }

    private void saveShimmerBuilder(XShimmer.Builder builder) {
        this.mBuilder = builder;
    }

    private void updateShader() {
        XShimmer xShimmer;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width == 0 || height == 0 || (xShimmer = this.mShimmer) == null) {
            return;
        }
        int width2 = xShimmer.width(width);
        int height2 = this.mShimmer.height(height);
        XShimmer xShimmer2 = this.mShimmer;
        boolean z = true;
        if (xShimmer2.shape != 1) {
            int i = xShimmer2.direction;
            if (i != 1 && i != 3) {
                z = false;
            }
            if (z) {
                width2 = 0;
            }
            if (!z) {
                height2 = 0;
            }
            float f = height2;
            XShimmer xShimmer3 = this.mShimmer;
            radialGradient = new LinearGradient((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, width2, f, xShimmer3.colors, xShimmer3.positions, Shader.TileMode.CLAMP);
        } else {
            float f2 = height2 / 2.0f;
            float max = (float) (Math.max(width2, height2) / Math.sqrt(2.0d));
            XShimmer xShimmer4 = this.mShimmer;
            radialGradient = new RadialGradient(width2 / 2.0f, f2, max, xShimmer4.colors, xShimmer4.positions, Shader.TileMode.CLAMP);
        }
        this.mShimmerPaint.setShader(radialGradient);
    }

    private void updateValueAnimator() {
        boolean z;
        if (this.mShimmer == null) {
            return;
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            z = valueAnimator.isStarted();
            this.mValueAnimator.cancel();
            this.mValueAnimator.removeAllUpdateListeners();
        } else {
            z = false;
        }
        XShimmer xShimmer = this.mShimmer;
        this.mValueAnimator = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, ((float) (xShimmer.repeatDelay / xShimmer.animationDuration)) + 1.0f);
        this.mValueAnimator.setRepeatMode(this.mShimmer.repeatMode);
        this.mValueAnimator.setRepeatCount(this.mShimmer.repeatCount);
        ValueAnimator valueAnimator2 = this.mValueAnimator;
        XShimmer xShimmer2 = this.mShimmer;
        valueAnimator2.setDuration(xShimmer2.animationDuration + xShimmer2.repeatDelay);
        this.mValueAnimator.addUpdateListener(this.mUpdateListener);
        if (z) {
            this.mValueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float offset;
        float f;
        if (this.mShimmer == null || this.mShimmerPaint.getShader() == null) {
            return;
        }
        float tan = (float) Math.tan(Math.toRadians(this.mShimmer.tilt));
        float width = (this.mDrawRect.width() * tan) + this.mDrawRect.height();
        float height = (tan * this.mDrawRect.height()) + this.mDrawRect.width();
        ValueAnimator valueAnimator = this.mValueAnimator;
        float f2 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i = this.mShimmer.direction;
        if (i == 1) {
            offset = offset(-width, width, animatedFraction);
        } else {
            if (i == 2) {
                f = offset(height, -height, animatedFraction);
            } else if (i != 3) {
                f = offset(-height, height, animatedFraction);
            } else {
                offset = offset(width, -width, animatedFraction);
            }
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setRotate(this.mShimmer.tilt, this.mDrawRect.width() / 2.0f, this.mDrawRect.height() / 2.0f);
            this.mShaderMatrix.postTranslate(f, f2);
            this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
            canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
        }
        f2 = offset;
        f = 0.0f;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.setRotate(this.mShimmer.tilt, this.mDrawRect.width() / 2.0f, this.mDrawRect.height() / 2.0f);
        this.mShaderMatrix.postTranslate(f, f2);
        this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
        canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        XShimmer xShimmer = this.mShimmer;
        return (xShimmer == null || !(xShimmer.clipToChildren || xShimmer.alphaShimmer)) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public void maybeStartShimmer() {
        XShimmer xShimmer;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator == null || valueAnimator.isStarted() || (xShimmer = this.mShimmer) == null || !xShimmer.autoStart || getCallback() == null) {
            return;
        }
        this.mValueAnimator.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDrawRect.set(rect);
        updateShader();
        maybeStartShimmer();
    }

    public XShimmer parseShimmer(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (attributeSet == null) {
            return new XShimmer.AlphaHighlightBuilder().build();
        }
        if (resources != null) {
            if (theme != null) {
                obtainAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XShimmerDrawable, 0, 0);
            } else {
                obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XShimmerDrawable);
            }
            try {
                XShimmer.Builder colorHighlightBuilder = (obtainAttributes.hasValue(dd0.XShimmerDrawable_shimmer_colored) && obtainAttributes.getBoolean(dd0.XShimmerDrawable_shimmer_colored, false)) ? new XShimmer.ColorHighlightBuilder() : new XShimmer.AlphaHighlightBuilder();
                saveShimmerBuilder(colorHighlightBuilder);
                return colorHighlightBuilder.consumeAttributes(obtainAttributes).build();
            } finally {
                obtainAttributes.recycle();
            }
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mBuilder.setHighlightAlpha(i / 255.0f).build();
        setShimmer(this.mBuilder.build());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setColorHighlight(int i, int i2) {
        this.mBuilder.setHighlightColor(i).setBaseColor(i2).build();
        setShimmer(this.mBuilder.build());
    }

    public void setShimmer(XShimmer xShimmer) {
        this.mShimmer = xShimmer;
        if (this.mShimmer != null) {
            updateShader();
            updateValueAnimator();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (!z) {
            stopShimmer();
        } else {
            maybeStartShimmer();
        }
        return super.setVisible(z, z2);
    }

    public void startShimmer() {
        if (this.mValueAnimator == null || isShimmerStarted() || getCallback() == null) {
            return;
        }
        this.mValueAnimator.start();
    }

    public void stopShimmer() {
        if (this.mValueAnimator == null || !isShimmerStarted()) {
            return;
        }
        this.mValueAnimator.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        setShimmer(parseShimmer(resources, attributeSet, theme));
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
