package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class XTextView extends o3 implements re0 {
    public fe0 h;

    public XTextView(Context context) {
        super(context);
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.h;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.h;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.h;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        a(this, z);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public XTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = fe0.a(this, attributeSet);
        a(this, attributeSet);
    }

    public XTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = fe0.a(this, attributeSet, i);
        a(this, attributeSet);
    }
}
