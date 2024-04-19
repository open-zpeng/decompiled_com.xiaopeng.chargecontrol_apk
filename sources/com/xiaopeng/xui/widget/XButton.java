package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.widget.XButton;
/* loaded from: classes.dex */
public class XButton extends s2 implements re0 {
    public fe0 e;
    public Rect f;

    public XButton(Context context) {
        super(context);
    }

    public final void a(AttributeSet attributeSet) {
        a(this, attributeSet);
        this.f = z90.a(this, attributeSet);
        fe0 fe0Var = this.e;
        if (fe0Var == null || ((ge0) fe0Var).b == null) {
            return;
        }
        ((ge0) fe0Var).b.setCallback(new ThemeViewModel.OnCallback() { // from class: ef0
            @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
            public final void onThemeChanged() {
                XButton.this.t();
            }
        });
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.e;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.e;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.e;
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

    public /* synthetic */ void t() {
        post(new Runnable() { // from class: df0
            @Override // java.lang.Runnable
            public final void run() {
                XButton.this.u();
            }
        });
    }

    public /* synthetic */ void u() {
        if (this.f != null) {
            d("XButton change theme reset backgroundPadding");
            Rect rect = this.f;
            this.f = z90.a(this, rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public XButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = fe0.a(this, attributeSet);
        a(attributeSet);
    }

    public XButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = fe0.a(this, attributeSet, i);
        a(attributeSet);
    }
}
