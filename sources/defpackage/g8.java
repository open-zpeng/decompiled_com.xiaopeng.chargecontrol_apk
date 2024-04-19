package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: WrappedDrawableApi14.java */
/* renamed from: g8  reason: default package */
/* loaded from: classes.dex */
public class g8 extends Drawable implements Drawable.Callback, f8, e8 {
    public static final PorterDuff.Mode i = PorterDuff.Mode.SRC_IN;
    public int c;
    public PorterDuff.Mode d;
    public boolean e;
    public i8 f;
    public boolean g;
    public Drawable h;

    public g8(i8 i8Var, Resources resources) {
        Drawable.ConstantState constantState;
        this.f = i8Var;
        i8 i8Var2 = this.f;
        if (i8Var2 == null || (constantState = i8Var2.b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    public boolean a() {
        return true;
    }

    public final boolean a(int[] iArr) {
        if (a()) {
            i8 i8Var = this.f;
            ColorStateList colorStateList = i8Var.c;
            PorterDuff.Mode mode = i8Var.d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.e || colorForState != this.c || mode != this.d) {
                    setColorFilter(colorForState, mode);
                    this.c = colorForState;
                    this.d = mode;
                    this.e = true;
                    return true;
                }
            } else {
                this.e = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.h.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i8 i8Var = this.f;
        return changingConfigurations | (i8Var != null ? i8Var.getChangingConfigurations() : 0) | this.h.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        i8 i8Var = this.f;
        if (i8Var != null) {
            if (i8Var.b != null) {
                this.f.a = getChangingConfigurations();
                return this.f;
            }
            return null;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.h.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.h.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.a(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.h.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.h.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.h.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.h.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.h.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.h.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.b(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        i8 i8Var;
        ColorStateList colorStateList = (!a() || (i8Var = this.f) == null) ? null : i8Var.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.h.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.h.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.f = new i8(this.f);
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.mutate();
            }
            i8 i8Var = this.f;
            if (i8Var != null) {
                Drawable drawable2 = this.h;
                i8Var.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return a.a(this.h, i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        return this.h.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.h.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.h;
        int i2 = Build.VERSION.SDK_INT;
        drawable.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.h.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.h.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.h.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.h.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.h.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f.c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f.d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.h.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i8 i8Var = this.f;
            if (i8Var != null) {
                i8Var.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
