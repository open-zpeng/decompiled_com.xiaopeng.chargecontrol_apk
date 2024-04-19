package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeViewModel;
/* loaded from: classes.dex */
public class XRecyclerView extends qe0 {
    public fe0 b1;

    public XRecyclerView(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    public final void a(AttributeSet attributeSet, int i) {
        if (isInEditMode()) {
            return;
        }
        this.b1 = fe0.a(this, attributeSet, i, 0, ThemeViewModel.asMaps(ThemeManager.KEY_GLOBAL, ThemeManager.AttributeSet.SCROLLBAR_THUMB_VERTICAL));
    }

    @Override // defpackage.qe0, defpackage.nf, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.b1;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.b1;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // defpackage.qe0, defpackage.nf, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.b1;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i);
    }
}
