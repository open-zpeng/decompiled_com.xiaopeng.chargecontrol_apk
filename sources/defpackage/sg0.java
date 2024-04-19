package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: IndicatorDrawable.java */
/* renamed from: sg0  reason: default package */
/* loaded from: classes.dex */
public class sg0 extends Drawable implements Drawable.Callback {
    public int d;
    public Drawable e;
    public float f;
    public int i;
    public int j;
    public final Rect k;
    public final Paint c = new Paint(1);
    public String g = "";
    public boolean h = true;

    public sg0() {
        float f = this.f;
        this.k = new Rect((int) (f - 28.0f), 10, (int) (f + 28.0f), 60);
        this.c.setTextSize(24.0f);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setTextAlign(Paint.Align.CENTER);
        this.c.setColor(this.h ? -1 : 1560281087);
    }

    public void a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null) {
            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, dd0.XSlider, 0, i);
        } else {
            obtainStyledAttributes = theme.obtainStyledAttributes(i, dd0.XSlider);
        }
        if (obtainStyledAttributes.hasValueOrEmpty(dd0.XSlider_slider_text_tag_bg)) {
            this.d = obtainStyledAttributes.getResourceId(dd0.XSlider_slider_text_tag_bg, 0);
        }
        a(resources, theme);
        setBounds(this.k);
        obtainStyledAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        String str = this.g;
        Rect rect = this.k;
        canvas.drawText(str, (rect.left + rect.right) / 2.0f, 42.0f, this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.e;
        return drawable != null && drawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        int length = iArr.length;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (iArr[i] == 16842910) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (this.h != z) {
            this.h = z;
            this.c.setColor(z ? -1 : 1560281087);
            be0.a("IndicatorDrawable", "onStateChange, isEnabled:" + z);
            z2 = true;
        }
        Drawable drawable = this.e;
        return (drawable == null || !drawable.isStateful()) ? z2 : z2 | this.e.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void a(Resources resources, Resources.Theme theme) {
        Drawable a = a.a(resources, this.d, theme);
        be0.a("IndicatorDrawable", "refreshUI, newBg:" + a + ", oldBg:" + this.e);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        if (a != null) {
            a.setCallback(this);
            a.setState(getState());
            a.setLevel(getLevel());
            a.setBounds(getBounds());
        }
        this.e = a;
        invalidateSelf();
    }

    public void a(float f, String str, int i) {
        this.g = str;
        this.f = f;
        this.i = (int) this.c.measureText(str);
        this.j = i;
        int max = Math.max(this.i + 50, 56);
        float f2 = this.f;
        float f3 = max / 2.0f;
        int i2 = this.j;
        float f4 = (i2 - f2) - f3;
        if (f2 - f3 < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            Rect rect = this.k;
            rect.left = 0;
            rect.right = max;
        } else if (f4 < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            Rect rect2 = this.k;
            rect2.left = i2 - max;
            rect2.right = i2;
        } else {
            Rect rect3 = this.k;
            float f5 = max / 2;
            rect3.left = (int) (f2 - f5);
            rect3.right = (int) (f2 + f5);
        }
        setBounds(this.k);
        invalidateSelf();
    }
}
