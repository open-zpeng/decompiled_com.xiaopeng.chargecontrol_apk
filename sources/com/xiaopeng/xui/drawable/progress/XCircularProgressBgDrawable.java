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
public class XCircularProgressBgDrawable extends Drawable {
    public static final float STROKE_WIDTH_DEFAULT = 0.0f;
    public Drawable mIndicatorPause;
    public Drawable mIndicatorPlay;
    public Drawable mIndicatorStart;
    public Drawable mIndicatorStop;
    public float mInset;
    public int mProgressBgColor;
    public float mStrokeWidth;
    public Rect mTmpIndicatorBounds = new Rect();
    public Paint mPaint = new Paint();
    public Rect mOutBounds = getBounds();
    public RectF mInnerBounds = new RectF(getBounds());
    public boolean mShowIndicator = true;
    public boolean mPlayingStop = false;
    public boolean mPlayingPause = false;
    public boolean mPaused = false;
    public boolean mStartDownload = false;

    public XCircularProgressBgDrawable() {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(this.mProgressBgColor);
    }

    private void applyIndicatorBounds(Drawable drawable, Rect rect) {
        if (drawable == null || rect == null) {
            return;
        }
        Rect bounds = getBounds();
        float width = bounds.width();
        float height = bounds.height();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth < width && intrinsicHeight < height) {
            int round = Math.round(((width - intrinsicWidth) / 2.0f) + bounds.left);
            int round2 = Math.round(((height - intrinsicHeight) / 2.0f) + bounds.top);
            rect.set(round, round2, Math.round(intrinsicWidth) + round, Math.round(intrinsicHeight) + round2);
            drawable.setBounds(rect);
            return;
        }
        rect.set(bounds);
        drawable.setBounds(rect);
    }

    private void updateAttr(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (theme != null) {
            obtainAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XCircularProgressBgDrawable, 0, 0);
        } else {
            obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XCircularProgressBgDrawable);
        }
        this.mProgressBgColor = obtainAttributes.getColor(dd0.XCircularProgressBgDrawable_progress_backgroundColor, resources.getColor(vc0.x_circular_progress_circle_bg_color, theme));
        this.mPaint.setColor(this.mProgressBgColor);
        this.mStrokeWidth = obtainAttributes.getDimension(dd0.XCircularProgressBgDrawable_progress_background_strokeWidth, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.mInset = obtainAttributes.getDimensionPixelSize(dd0.XCircularProgressBgDrawable_progress_background_inset, 0);
        this.mIndicatorPlay = obtainAttributes.getDrawable(dd0.XCircularProgressBgDrawable_progress_bg_indicator_play);
        this.mIndicatorPause = obtainAttributes.getDrawable(dd0.XCircularProgressBgDrawable_progress_bg_indicator_pause);
        this.mIndicatorStop = obtainAttributes.getDrawable(dd0.XCircularProgressBgDrawable_progress_bg_indicator_stop);
        this.mIndicatorStart = obtainAttributes.getDrawable(dd0.XCircularProgressBgDrawable_progress_bg_indicator_start);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        int save = canvas.save();
        canvas.drawArc(this.mInnerBounds, XToggleDrawable.LIGHT_RADIUS_DEFAULT, 360.0f, false, this.mPaint);
        canvas.restoreToCount(save);
        if (this.mShowIndicator) {
            if (this.mPlayingStop) {
                Drawable drawable2 = this.mIndicatorStop;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                }
            } else if (this.mPlayingPause) {
                Drawable drawable3 = this.mIndicatorPause;
                if (drawable3 != null) {
                    drawable3.draw(canvas);
                }
            } else if (this.mPaused) {
                Drawable drawable4 = this.mIndicatorPlay;
                if (drawable4 != null) {
                    drawable4.draw(canvas);
                }
            } else if (!this.mStartDownload || (drawable = this.mIndicatorStart) == null) {
            } else {
                drawable.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        updateAttr(resources, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        applyIndicatorBounds(this.mIndicatorPlay, this.mTmpIndicatorBounds);
        applyIndicatorBounds(this.mIndicatorPause, this.mTmpIndicatorBounds);
        applyIndicatorBounds(this.mIndicatorStop, this.mTmpIndicatorBounds);
        applyIndicatorBounds(this.mIndicatorStart, this.mTmpIndicatorBounds);
        if (this.mStrokeWidth == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.mStrokeWidth = (this.mOutBounds.width() * 1.0f) / 10.0f;
        }
        float f = this.mStrokeWidth / 2.0f;
        this.mInnerBounds.set(rect);
        RectF rectF = this.mInnerBounds;
        float f2 = this.mInset;
        rectF.inset(f2 + f, f2 + f);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Drawable drawable = this.mIndicatorPause;
        if (drawable != null) {
            drawable.setState(iArr);
        }
        Drawable drawable2 = this.mIndicatorPlay;
        if (drawable2 != null) {
            drawable2.setState(iArr);
        }
        Drawable drawable3 = this.mIndicatorStart;
        if (drawable3 != null) {
            drawable3.setState(iArr);
        }
        Drawable drawable4 = this.mIndicatorStop;
        if (drawable4 != null) {
            drawable4.setState(iArr);
        }
        int length = iArr.length;
        boolean z5 = false;
        int i = 0;
        boolean z6 = false;
        while (true) {
            if (i >= length) {
                z = false;
                z2 = false;
                z3 = false;
                break;
            }
            int i2 = iArr[i];
            if (i2 == uc0.progress_state_playing_stop) {
                z2 = false;
                z3 = false;
                z = true;
                break;
            } else if (i2 == uc0.progress_state_playing_pause) {
                z = false;
                z3 = false;
                z2 = true;
                break;
            } else if (i2 == uc0.progress_state_paused) {
                z = false;
                z2 = false;
                z3 = true;
                break;
            } else {
                if (i2 == uc0.progress_state_start_download) {
                    z6 = true;
                }
                i++;
            }
        }
        if (z != this.mPlayingStop) {
            this.mPlayingStop = z;
            z4 = true;
        } else {
            z4 = false;
        }
        if (z2 != this.mPlayingPause) {
            this.mPlayingPause = z2;
            z4 = true;
        }
        if (z3 != this.mPaused) {
            this.mPaused = z3;
            z4 = true;
        }
        if (z6 != this.mStartDownload) {
            this.mStartDownload = z6;
            z4 = true;
        }
        if (z4) {
            if (this.mPlayingStop || this.mPlayingPause || this.mPaused || this.mStartDownload) {
                z5 = true;
            }
            this.mShowIndicator = z5;
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setIndicatorPause(Drawable drawable) {
        this.mIndicatorPause = drawable;
    }

    public void setIndicatorPlay(Drawable drawable) {
        this.mIndicatorPlay = drawable;
    }

    public void setIndicatorStart(Drawable drawable) {
        this.mIndicatorStart = drawable;
    }

    public void setIndicatorStop(Drawable drawable) {
        this.mIndicatorStop = drawable;
    }

    public void setInset(float f) {
        this.mInset = f;
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        super.inflate(resources, xmlPullParser, attributeSet);
        updateAttr(resources, attributeSet, null);
    }
}
