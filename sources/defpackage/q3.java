package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;
/* compiled from: AppCompatToggleButton.java */
/* renamed from: q3  reason: default package */
/* loaded from: classes.dex */
public class q3 extends ToggleButton implements x9 {
    public final r2 c;
    public final m3 d;

    public q3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842827);
        i4.a(this, getContext());
        this.c = new r2(this);
        this.c.a(attributeSet, 16842827);
        this.d = new m3(this);
        this.d.a(attributeSet, 16842827);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
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

    @Override // android.widget.ToggleButton, android.view.View
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
}
