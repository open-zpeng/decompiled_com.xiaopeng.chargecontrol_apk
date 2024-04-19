package com.xiaopeng.xui.drawable.ripple;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class XRippleDrawable extends Drawable {
    public static final String TAG = XRippleDrawable.class.getSimpleName();
    public boolean mIsTouchDown;
    public float mDownX = -1.0f;
    public float mDownY = -1.0f;
    public int[] stateSpecPress = new int[2];
    public XRipple mRipple = new XRipple();

    public XRippleDrawable() {
        int[] iArr = this.stateSpecPress;
        iArr[0] = 16842919;
        iArr[1] = 16842910;
    }

    private void inflateAttrs(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (resources == null || attributeSet == null) {
            return;
        }
        if (theme != null) {
            obtainAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XRippleDrawable, 0, 0);
        } else {
            obtainAttributes = resources.obtainAttributes(attributeSet, dd0.XRippleDrawable);
        }
        int color = obtainAttributes.getColor(dd0.XRippleDrawable_rippleBackgroundColor, 0);
        int color2 = obtainAttributes.getColor(dd0.XRippleDrawable_rippleColor, resources.getColor(vc0.x_ripple_default_color, theme));
        boolean z = obtainAttributes.getBoolean(dd0.XRippleDrawable_rippleSupportScale, false);
        int i = obtainAttributes.getInt(dd0.XRippleDrawable_rippleDuration, resources.getInteger(zc0.x_ripple_default_anim));
        this.mRipple.setRippleRadius(obtainAttributes.getDimensionPixelSize(dd0.XRippleDrawable_rippleRadius, 0));
        this.mRipple.setRippleColor(color2);
        this.mRipple.setRippleBackgroundColor(color);
        this.mRipple.setSupportScale(z);
        long j = i;
        this.mRipple.setPressDuration(j);
        this.mRipple.setUpDuration(j);
        obtainAttributes.recycle();
    }

    private void initRipple(Rect rect) {
        this.mRipple.setCallback(getCallback());
        this.mRipple.setRippleRect(new RectF(rect.left, rect.top, rect.right, rect.bottom));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        XRipple xRipple = this.mRipple;
        if (xRipple != null) {
            xRipple.drawRipple(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public XRipple getXRipple() {
        return this.mRipple;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflateAttrs(resources, attributeSet, null);
        super.inflate(resources, xmlPullParser, attributeSet);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        initRipple(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (iArr != null && this.mRipple != null) {
            if (StateSet.stateSetMatches(this.stateSpecPress, iArr) && !this.mIsTouchDown) {
                float f = this.mDownX;
                if (f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    float f2 = this.mDownY;
                    if (f2 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                        this.mIsTouchDown = true;
                        this.mRipple.pressDown(f, f2);
                    }
                }
            }
            if (this.mIsTouchDown) {
                this.mIsTouchDown = false;
                this.mRipple.pressUp();
            }
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
        this.mDownX = f;
        this.mDownY = f2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        XRipple xRipple = this.mRipple;
        if (xRipple != null && visible) {
            xRipple.setVisible(z);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        inflateAttrs(resources, attributeSet, theme);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
