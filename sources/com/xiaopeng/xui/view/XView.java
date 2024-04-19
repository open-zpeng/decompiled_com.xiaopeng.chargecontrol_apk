package com.xiaopeng.xui.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class XView extends View implements re0 {
    public fe0 c;

    public XView(Context context) {
        this(context, null);
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
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

    public XView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public XView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = fe0.a(this, attributeSet, i, i2);
        a(this, attributeSet);
    }
}
