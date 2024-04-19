package com.xiaopeng.xui.drawable.progress;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class XCircularProgressPgDrawable extends Drawable {
    public static final float PROGRESS_STROKE_WIDTH_DEFAULT = 0.0f;
    public boolean mEnableLight;
    public float mInset;
    public float mLightRadius;
    public int mProgressColor;
    public float mStrokeWidth;
    public Paint mPaint = new Paint();
    public Rect mOutBounds = getBounds();
    public RectF mInnerBounds = new RectF(getBounds());

    public XCircularProgressPgDrawable() {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private void updateAttr(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (theme != null) {
            obtainAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XCircularProgressPgDrawable, 0, 0);
        } else {
            obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XCircularProgressPgDrawable);
        }
        this.mProgressColor = obtainAttributes.getColor(dd0.XCircularProgressPgDrawable_progress_color, resources.getColor(vc0.x_circular_progress_primary_color, theme));
        this.mStrokeWidth = obtainAttributes.getDimension(dd0.XCircularProgressPgDrawable_progress_pg_strokeWidth, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.mEnableLight = obtainAttributes.getBoolean(dd0.XCircularProgressPgDrawable_progress_enable_light, false);
        this.mInset = obtainAttributes.getDimensionPixelSize(dd0.XCircularProgressPgDrawable_progress_pg_inset, 0);
        this.mLightRadius = obtainAttributes.getDimensionPixelOffset(dd0.XCircularProgressPgDrawable_progress_pg_light_radius, 0);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.drawArc(this.mInnerBounds, -90.0f, ((getLevel() * 1.0f) / 10000.0f) * 360.0f, false, this.mPaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        super.inflate(resources, xmlPullParser, attributeSet);
        updateAttr(resources, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mInnerBounds.set(rect);
        if (this.mStrokeWidth == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.mStrokeWidth = (this.mOutBounds.width() * 1.0f) / 10.0f;
        }
        float f = this.mStrokeWidth / 2.0f;
        RectF rectF = this.mInnerBounds;
        float f2 = this.mInset;
        rectF.inset(f2 + f, f2 + f);
        this.mPaint.setColor(this.mProgressColor);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        if (this.mEnableLight) {
            if (this.mLightRadius == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                this.mLightRadius = this.mStrokeWidth;
            }
            sd0 sd0Var = new sd0(this.mPaint);
            sd0.i = this.mLightRadius;
            sd0Var.a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        invalidateSelf();
        return super.onLevelChange(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setInset(float f) {
        this.mInset = f;
    }

    public void setLightRadius(float f) {
        this.mLightRadius = f;
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        updateAttr(resources, attributeSet, theme);
    }
}
