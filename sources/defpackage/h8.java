package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
/* compiled from: WrappedDrawableApi21.java */
/* renamed from: h8  reason: default package */
/* loaded from: classes.dex */
public class h8 extends g8 {
    public static Method j;

    public h8(i8 i8Var, Resources resources) {
        super(i8Var, resources);
        b();
    }

    @Override // defpackage.g8
    public boolean a() {
        int i = Build.VERSION.SDK_INT;
        return false;
    }

    public final void b() {
        if (j == null) {
            try {
                j = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.h.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.h.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.h;
        if (drawable != null && (method = j) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.h.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.h.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.g8, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // defpackage.g8, android.graphics.drawable.Drawable
    public void setTint(int i) {
        int i2 = Build.VERSION.SDK_INT;
        this.h.setTint(i);
    }

    @Override // defpackage.g8, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        int i = Build.VERSION.SDK_INT;
        this.h.setTintList(colorStateList);
    }

    @Override // defpackage.g8, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        int i = Build.VERSION.SDK_INT;
        this.h.setTintMode(mode);
    }
}
