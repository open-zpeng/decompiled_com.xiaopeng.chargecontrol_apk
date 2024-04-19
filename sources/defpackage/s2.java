package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
/* compiled from: AppCompatButton.java */
/* renamed from: s2  reason: default package */
/* loaded from: classes.dex */
public class s2 extends Button implements x9, ab, eb {
    public final r2 c;
    public final m3 d;

    public s2(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (ab.a) {
            return super.getAutoSizeMaxTextSize();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.b();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (ab.a) {
            return super.getAutoSizeMinTextSize();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (ab.a) {
            return super.getAutoSizeStepGranularity();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (ab.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m3 m3Var = this.d;
        return m3Var != null ? m3Var.e() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (ab.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.f();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        l4 l4Var = this.d.h;
        if (l4Var != null) {
            return l4Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        l4 l4Var = this.d.h;
        if (l4Var != null) {
            return l4Var.b;
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m3 m3Var = this.d;
        if (m3Var == null || ab.a) {
            return;
        }
        m3Var.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m3 m3Var = this.d;
        if (m3Var == null || ab.a || !m3Var.g()) {
            return;
        }
        this.d.i.a();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (ab.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (ab.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (ab.a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setSupportAllCaps(boolean z) {
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.d.a(colorStateList);
        this.d.a();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.d.a(mode);
        this.d.a();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = ab.a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var == null || z || m3Var.g()) {
            return;
        }
        m3Var.i.a(i, f);
    }

    public s2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z.buttonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k4.a(context);
        i4.a(this, getContext());
        this.c = new r2(this);
        this.c.a(attributeSet, i);
        this.d = new m3(this);
        this.d.a(attributeSet, i);
        this.d.a();
    }
}
