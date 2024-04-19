package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: XAppCompatRadioButton.java */
/* renamed from: kf0  reason: default package */
/* loaded from: classes.dex */
public class kf0 extends e3 implements re0 {
    public fe0 f;

    public kf0(Context context) {
        super(context);
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.f;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.f;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.f;
        if (fe0Var != null) {
            fe0Var.b();
        }
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

    public kf0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = fe0.a(this, attributeSet);
        a(this, attributeSet);
    }

    public kf0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = fe0.a(this, attributeSet, i);
        a(this, attributeSet);
    }
}
