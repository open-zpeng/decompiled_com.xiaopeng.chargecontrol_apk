package com.xiaopeng.xui.app;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.app.XToast$XToastTextView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes.dex */
public class XToast$XToastTextView extends XTextView {
    public int i;

    public XToast$XToastTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fe0 fe0Var = this.h;
        if (fe0Var == null || ((ge0) fe0Var).b == null) {
            return;
        }
        ((ge0) fe0Var).b.addCallback(new ThemeViewModel.OnCallback() { // from class: jd0
            @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
            public final void onThemeChanged() {
                XToast$XToastTextView.this.w();
            }
        });
    }

    public void setIcon(int i) {
        this.i = i;
        setCompoundDrawablesWithIntrinsicBounds(this.i, 0, 0, 0);
    }

    public /* synthetic */ void w() {
        if (this.i != 0) {
            d("XToast onThemeChanged !!! ");
            setCompoundDrawablesWithIntrinsicBounds(this.i, 0, 0, 0);
        }
    }
}
