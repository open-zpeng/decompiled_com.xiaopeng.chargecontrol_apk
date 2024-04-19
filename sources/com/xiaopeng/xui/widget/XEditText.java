package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeViewModel;
/* loaded from: classes.dex */
public class XEditText extends x2 implements re0 {
    public fe0 g;

    public XEditText(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    public final void a(AttributeSet attributeSet, int i) {
        if (!isInEditMode()) {
            this.g = fe0.a(this, attributeSet, i, 0, ThemeViewModel.asMaps(ThemeManager.KEY_GLOBAL, ThemeManager.AttributeSet.SCROLLBAR_THUMB_VERTICAL));
        }
        a(this, attributeSet);
        setCustomSelectionActionModeCallback(new nf0(this));
        setCustomInsertionActionModeCallback(new of0(this));
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.g;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.g;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.g;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public XEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i);
    }
}
