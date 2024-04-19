package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
/* compiled from: AppCompatRadioButton.java */
/* renamed from: e3  reason: default package */
/* loaded from: classes.dex */
public class e3 extends RadioButton implements db, x9 {
    public final v2 c;
    public final r2 d;
    public final m3 e;

    public e3(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r2 r2Var = this.d;
        if (r2Var != null) {
            r2Var.a();
        }
        m3 m3Var = this.e;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        v2 v2Var = this.c;
        if (v2Var != null) {
            v2Var.a(compoundPaddingLeft);
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        r2 r2Var = this.d;
        if (r2Var != null) {
            return r2Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        r2 r2Var = this.d;
        if (r2Var != null) {
            return r2Var.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        v2 v2Var = this.c;
        if (v2Var != null) {
            return v2Var.b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        v2 v2Var = this.c;
        if (v2Var != null) {
            return v2Var.c;
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        r2 r2Var = this.d;
        if (r2Var != null) {
            r2Var.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        r2 r2Var = this.d;
        if (r2Var != null) {
            r2Var.a(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        v2 v2Var = this.c;
        if (v2Var != null) {
            if (v2Var.f) {
                v2Var.f = false;
                return;
            }
            v2Var.f = true;
            v2Var.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        r2 r2Var = this.d;
        if (r2Var != null) {
            r2Var.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        r2 r2Var = this.d;
        if (r2Var != null) {
            r2Var.a(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        v2 v2Var = this.c;
        if (v2Var != null) {
            v2Var.b = colorStateList;
            v2Var.d = true;
            v2Var.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        v2 v2Var = this.c;
        if (v2Var != null) {
            v2Var.c = mode;
            v2Var.e = true;
            v2Var.a();
        }
    }

    public e3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z.radioButtonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k4.a(context);
        i4.a(this, getContext());
        this.c = new v2(this);
        this.c.a(attributeSet, i);
        this.d = new r2(this);
        this.d.a(attributeSet, i);
        this.e = new m3(this);
        this.e.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(i1.b(getContext(), i));
    }
}
