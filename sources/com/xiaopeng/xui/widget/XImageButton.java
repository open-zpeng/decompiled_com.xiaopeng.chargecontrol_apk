package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.widget.XImageButton;
/* loaded from: classes.dex */
public class XImageButton extends y2 implements re0 {
    public fe0 e;
    public Rect f;

    public XImageButton(Context context) {
        super(context);
    }

    public final void a(AttributeSet attributeSet) {
        a(this, attributeSet);
        this.f = z90.a(this, attributeSet);
        fe0 fe0Var = this.e;
        if (fe0Var == null || ((ge0) fe0Var).b == null) {
            return;
        }
        ((ge0) fe0Var).b.setCallback(new ThemeViewModel.OnCallback() { // from class: ff0
            @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
            public final void onThemeChanged() {
                XImageButton.this.t();
            }
        });
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.e;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.e;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.e;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // defpackage.y2, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        fe0 fe0Var = this.e;
        if (fe0Var == null || ((ge0) fe0Var).b == null) {
            return;
        }
        ((ge0) fe0Var).b.setImageResource(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        a(this, z);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public /* synthetic */ void t() {
        post(new Runnable() { // from class: gf0
            @Override // java.lang.Runnable
            public final void run() {
                XImageButton.this.u();
            }
        });
    }

    public /* synthetic */ void u() {
        if (this.f != null) {
            d("XImageButton change theme reset backgroundPadding");
            Rect rect = this.f;
            this.f = z90.a(this, rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public XImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = fe0.a(this, attributeSet);
        a(attributeSet);
    }

    public XImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = fe0.a(this, attributeSet, i);
        a(attributeSet);
    }
}
