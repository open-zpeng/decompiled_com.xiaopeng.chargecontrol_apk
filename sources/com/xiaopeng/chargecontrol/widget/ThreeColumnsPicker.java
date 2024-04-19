package com.xiaopeng.chargecontrol.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.xiaopeng.chargecontrol.widget.ThreeColumnsPicker;
import com.xiaopeng.xui.widget.XFrameLayout;
import com.xiaopeng.xui.widget.XNumberPicker;
/* loaded from: classes.dex */
public class ThreeColumnsPicker extends XFrameLayout {
    public final LinearLayout d;
    public final XNumberPicker e;
    public final XNumberPicker f;
    public final XNumberPicker g;
    public boolean h;

    /* loaded from: classes.dex */
    public interface a {
    }

    public ThreeColumnsPicker(Context context) {
        this(context, null);
    }

    public void a(int i, int i2, int i3) {
        if ((i == getFirst() && i2 == getSecond() && i3 == getThird()) ? false : true) {
            this.g.setValue(i);
            this.f.setValue(i2);
            this.e.setValue(i3);
        }
    }

    public /* synthetic */ void a(XNumberPicker xNumberPicker, int i, int i2) {
    }

    public int getFirst() {
        return this.g.getValue();
    }

    public int getSecond() {
        return this.f.getValue();
    }

    public int getThird() {
        return this.e.getValue();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.h;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.e.setEnabled(z);
        this.f.setEnabled(z);
        this.g.setEnabled(z);
        this.h = z;
    }

    public void setFirstFormatter(XNumberPicker.c cVar) {
        this.g.setFormatter(cVar);
    }

    public void setFirstMaxValue(int i) {
        this.g.setMaxValue(i);
    }

    public void setFirstMinValue(int i) {
        this.g.setMinValue(i);
    }

    public void setOnValueChangedListener(a aVar) {
    }

    public void setSecondFormatter(XNumberPicker.c cVar) {
        this.f.setFormatter(cVar);
    }

    public void setSecondMaxValue(int i) {
        this.f.setMaxValue(i);
    }

    public void setSecondMinValue(int i) {
        this.f.setMinValue(i);
    }

    public void setSpinnersShown(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    public void setThirdFormatter(XNumberPicker.c cVar) {
        this.e.setFormatter(cVar);
    }

    public void setThirdMaxValue(int i) {
        this.e.setMaxValue(i);
    }

    public void setThirdMinValue(int i) {
        this.e.setMinValue(i);
    }

    public ThreeColumnsPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreeColumnsPicker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ThreeColumnsPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.h = true;
        LayoutInflater.from(context).inflate(q90.three_columns_picker_layout, this);
        XNumberPicker.e eVar = new XNumberPicker.e() { // from class: na0
            @Override // com.xiaopeng.xui.widget.XNumberPicker.e
            public final void a(XNumberPicker xNumberPicker, int i3, int i4) {
                ThreeColumnsPicker.this.a(xNumberPicker, i3, i4);
            }
        };
        this.d = (LinearLayout) findViewById(o90.pickers);
        this.e = (XNumberPicker) findViewById(o90.third);
        this.e.setOnLongPressUpdateInterval(100L);
        this.e.setOnValueChangedListener(eVar);
        this.f = (XNumberPicker) findViewById(o90.second);
        this.f.setOnLongPressUpdateInterval(100L);
        this.f.setOnValueChangedListener(eVar);
        this.g = (XNumberPicker) findViewById(o90.first);
        this.g.setOnLongPressUpdateInterval(100L);
        this.g.setOnValueChangedListener(eVar);
        setSpinnersShown(true);
    }
}
