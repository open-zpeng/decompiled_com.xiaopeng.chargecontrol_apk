package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class XConstraintLayout extends ConstraintLayout implements re0 {
    public fe0 w;

    public XConstraintLayout(Context context) {
        this(context, null);
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.w;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.w;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.w;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        a(this, qc0.UPDATE_VIEW);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        a(this, qc0.UPDATE_VIEW);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        a(this, z);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public XConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = fe0.a(this, attributeSet, i, 0);
        a(this, attributeSet);
    }
}
