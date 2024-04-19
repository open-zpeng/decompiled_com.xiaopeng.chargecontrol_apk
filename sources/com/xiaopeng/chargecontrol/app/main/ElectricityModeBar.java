package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.main.ElectricityModeBar;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XExposedDropdownMenu;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class ElectricityModeBar extends XConstraintLayout {
    public XExposedDropdownMenu x;
    public d10 y;
    public m10 z;

    public ElectricityModeBar(Context context) {
        super(context);
        u();
    }

    public /* synthetic */ void a(int i, String str) {
        if (i == 0) {
            x90.d(0);
        } else if (i == 1) {
            x90.d(1);
        }
        ((MainActivity) getContext()).e(i);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m10 m10Var;
        super.onDetachedFromWindow();
        iv.e(this);
        d10 d10Var = this.y;
        if (d10Var == null || (m10Var = this.z) == null) {
            return;
        }
        d10Var.a(m10Var);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onElectricityChangedBySpeech(ry ryVar) {
        int intValue = Integer.valueOf(ryVar.a).intValue();
        Log.d("ElectricityModeBar", "onElectricityChangedBySpeech: " + intValue);
        this.x.setSelection(intValue);
        ((MainActivity) getContext()).e(intValue);
    }

    public final void u() {
        if (getContext() instanceof d10) {
            this.y = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_electricity_mode_bar, this);
        this.x = (XExposedDropdownMenu) findViewById(R.id.electricity_display_mode);
        this.x.setSelection(x90.l());
        this.x.setOnItemClickListener(new XExposedDropdownMenu.a() { // from class: o50
            @Override // com.xiaopeng.xui.widget.XExposedDropdownMenu.a
            public final void a(int i, String str) {
                ElectricityModeBar.this.a(i, str);
            }
        });
    }

    public ElectricityModeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u();
    }

    public ElectricityModeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u();
    }
}
