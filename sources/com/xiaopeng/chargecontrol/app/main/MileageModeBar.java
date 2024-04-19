package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.main.MileageModeBar;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XExposedDropdownMenu;
import defpackage.g70;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class MileageModeBar extends XConstraintLayout {
    public XExposedDropdownMenu x;
    public d10 y;
    public m10 z;

    public MileageModeBar(Context context) {
        super(context);
        u();
    }

    public static /* synthetic */ void a(int i, String str) {
        if (i == 0 && g70.a.a.a()) {
            x90.g(0);
        } else if (i == 1) {
            x90.g(1);
        } else {
            x90.g(2);
        }
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
        this.x.setSelection(x90.c(2));
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

    @tl0(threadMode = ThreadMode.MAIN)
    public void onDistanceDisplayModeChanged(my.e0 e0Var) {
        int intValue = ((Integer) e0Var.a).intValue();
        if (this.x.getSelection() != -1) {
            z90.d(intValue == 1 ? R.string.prompt_wltp_selected : intValue == 2 ? R.string.prompt_cltc_selected : R.string.prompt_nedc_selected);
        }
        this.x.setSelection(intValue);
        if (a70.f()) {
            if (intValue == 2) {
                this.x.setSelection(0);
            } else {
                this.x.setSelection(1);
            }
        }
        this.x.setSelection(intValue);
    }

    public final void u() {
        if (getContext() instanceof d10) {
            this.y = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_mileage_mode_bar, this);
        this.x = (XExposedDropdownMenu) findViewById(R.id.distance_display_mode);
        this.x = (XExposedDropdownMenu) findViewById(R.id.distance_display_mode);
        if (a70.f()) {
            this.x.setEntries(getResources().getStringArray(R.array.remaining_distance_display_modes_d55a));
        }
        this.x.setOnItemClickListener(new XExposedDropdownMenu.a() { // from class: w50
            @Override // com.xiaopeng.xui.widget.XExposedDropdownMenu.a
            public final void a(int i, String str) {
                MileageModeBar.a(i, str);
            }
        });
    }

    public MileageModeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u();
    }

    public MileageModeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u();
    }
}
