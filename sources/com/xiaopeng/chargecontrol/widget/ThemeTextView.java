package com.xiaopeng.chargecontrol.widget;

import android.app.ActivityThread;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeViewModel;
/* loaded from: classes.dex */
public class ThemeTextView extends o3 implements re0 {
    public ThemeViewModel h;

    public ThemeTextView(Context context) {
        this(context, null);
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h.onAttachedToWindow(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h.onConfigurationChanged(this, configuration);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h.onDetachedFromWindow(this);
    }

    @Override // defpackage.o3, android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_START, i);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_TOP, i2);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_END, i3);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_BOTTOM, i4);
    }

    @Override // defpackage.o3, android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_LEFT, i);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_TOP, i2);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_RIGHT, i3);
        this.h.setThemeAttribute(ThemeManager.AttributeSet.DRAWABLE_BOTTOM, i4);
    }

    public void setTextColorResource(int i) {
        int color = ActivityThread.currentApplication().getColor(i);
        this.h.setTextColor(i);
        setTextColor(color);
    }

    public ThemeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThemeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = ThemeViewModel.create(context, attributeSet, i, 0, null);
        a(mc0.TEXTVIEW);
    }
}
