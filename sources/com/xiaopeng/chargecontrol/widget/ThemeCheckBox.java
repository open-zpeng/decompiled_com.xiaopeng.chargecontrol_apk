package com.xiaopeng.chargecontrol.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeManager;
/* loaded from: classes.dex */
public class ThemeCheckBox extends lf0 {
    public ThemeCheckBox(Context context) {
        super(context);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        super.setButtonDrawable(i);
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            ((ge0) fe0Var).b.setThemeAttribute(ThemeManager.AttributeSet.BUTTON, i);
        }
    }

    public ThemeCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ThemeCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
