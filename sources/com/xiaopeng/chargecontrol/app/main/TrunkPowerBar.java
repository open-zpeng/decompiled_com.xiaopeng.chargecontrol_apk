package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaopeng.chargecontrol.R;
/* loaded from: classes.dex */
public class TrunkPowerBar extends a60 {
    public TrunkPowerBar(Context context) {
        super(context);
    }

    @Override // defpackage.a60
    public int w() {
        return R.layout.layout_trunk_power_bar;
    }

    @Override // defpackage.a60
    public void x() {
        super.x();
        this.z.setTextColorResource(this.y.isChecked() ? R.color.charging : R.color.sub_title);
        this.z.setText(this.y.isChecked() ? R.string.trunk_power_enable : R.string.trunk_power_disable);
        z90.a("MainBottom", this.y);
    }

    public TrunkPowerBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrunkPowerBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
