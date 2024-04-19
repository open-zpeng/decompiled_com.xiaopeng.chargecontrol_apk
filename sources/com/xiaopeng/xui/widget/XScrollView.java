package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeViewModel;
/* loaded from: classes.dex */
public class XScrollView extends ScrollView implements re0, hc0 {
    public fe0 c;

    public XScrollView(Context context) {
        super(context);
        a(null, 0, 0);
    }

    public final void a(AttributeSet attributeSet, int i, int i2) {
        if (!isInEditMode()) {
            this.c = fe0.a(this, attributeSet, i, i2, ThemeViewModel.asMaps(ThemeManager.KEY_GLOBAL, ThemeManager.AttributeSet.SCROLLBAR_THUMB_VERTICAL));
        }
        a(this, attributeSet);
    }

    @Override // defpackage.hc0
    public boolean a(View view, tc0 tc0Var) {
        return false;
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
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

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        a(this, qc0.UPDATE_VIEW);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        a(this, qc0.UPDATE_VIEW);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public XScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0, 0);
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        View childAt = getChildAt(0);
        if (childAt != null && getHeight() < childAt.getMeasuredHeight()) {
            c(lc0.SCROLLBYY.c);
        }
        return null;
    }

    public XScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i, 0);
    }

    public XScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(attributeSet, i, i2);
    }
}
