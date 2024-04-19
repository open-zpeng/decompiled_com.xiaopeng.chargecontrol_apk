package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckBox;
/* compiled from: AppCompatCheckBox.java */
/* renamed from: t2  reason: default package */
/* loaded from: classes.dex */
public class t2 extends CheckBox implements db, x9 {
    public final v2 c;
    public final r2 d;
    public final m3 e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t2(android.content.Context r2, android.util.AttributeSet r3) {
        /*
            r1 = this;
            int r0 = defpackage.z.checkboxStyle
            defpackage.k4.a(r2)
            r1.<init>(r2, r3, r0)
            android.content.Context r2 = r1.getContext()
            defpackage.i4.a(r1, r2)
            v2 r2 = new v2
            r2.<init>(r1)
            r1.c = r2
            v2 r2 = r1.c
            r2.a(r3, r0)
            r2 r2 = new r2
            r2.<init>(r1)
            r1.d = r2
            r2 r2 = r1.d
            r2.a(r3, r0)
            m3 r2 = new m3
            r2.<init>(r1)
            r1.e = r2
            m3 r2 = r1.e
            r2.a(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t2.<init>(android.content.Context, android.util.AttributeSet):void");
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(i1.b(getContext(), i));
    }
}
