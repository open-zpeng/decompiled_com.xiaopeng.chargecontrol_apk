package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
/* compiled from: XCompoundButton.java */
/* renamed from: mf0  reason: default package */
/* loaded from: classes.dex */
public class mf0 extends CompoundButton implements re0 {
    public fe0 c;

    public mf0(Context context) {
        this(context, null);
    }

    private void setFromUser(boolean z) {
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        setFromUser(true);
        boolean performClick = super.performClick();
        setFromUser(false);
        return performClick;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        boolean isChecked = isChecked();
        super.setChecked(z);
        if (isChecked != z) {
            a((View) this);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public mf0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public mf0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public mf0(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = fe0.a(this, attributeSet, i, i2);
        a(this, attributeSet);
    }
}
