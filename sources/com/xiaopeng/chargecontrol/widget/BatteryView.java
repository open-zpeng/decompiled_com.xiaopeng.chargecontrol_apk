package com.xiaopeng.chargecontrol.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.xui.widget.XImageView;
import defpackage.my;
import defpackage.r70;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class BatteryView extends XImageView {
    public static final int[] i = {R.drawable.charge_battery1_2, R.drawable.charge_battery3_4, R.drawable.charge_battery5_6, R.drawable.charge_battery7_8, R.drawable.charge_battery9_10, R.drawable.charge_battery11_12, R.drawable.charge_battery13_14, R.drawable.charge_battery15_16, R.drawable.charge_battery17_18, R.drawable.charge_battery19_20, R.drawable.charge_battery21_22, R.drawable.charge_battery23_24, R.drawable.charge_battery25_26, R.drawable.charge_battery27_28, R.drawable.charge_battery29_30, R.drawable.charge_battery31_32, R.drawable.charge_battery33_34, R.drawable.charge_battery35_36, R.drawable.charge_battery37_38, R.drawable.charge_battery39_40, R.drawable.charge_battery41_42, R.drawable.charge_battery43_44, R.drawable.charge_battery45_46, R.drawable.charge_battery47_48, R.drawable.charge_battery49_50, R.drawable.charge_battery51_52, R.drawable.charge_battery53_54, R.drawable.charge_battery55_56, R.drawable.charge_battery57_58, R.drawable.charge_battery59_60, R.drawable.charge_battery61_62, R.drawable.charge_battery63_64, R.drawable.charge_battery65_66, R.drawable.charge_battery67_68, R.drawable.charge_battery69_70, R.drawable.charge_battery71_72, R.drawable.charge_battery73_74, R.drawable.charge_battery75_76, R.drawable.charge_battery77_78, R.drawable.charge_battery79_80, R.drawable.charge_battery81_82, R.drawable.charge_battery83_84, R.drawable.charge_battery85_86, R.drawable.charge_battery87_88, R.drawable.charge_battery89_90, R.drawable.charge_battery91_92, R.drawable.charge_battery93_94, R.drawable.charge_battery95_96, R.drawable.charge_battery97_98};
    public static final int[] j = {R.drawable.charge_battery_low1_2, R.drawable.charge_battery_low3_4, R.drawable.charge_battery_low5_6, R.drawable.charge_battery_low7_8, R.drawable.charge_battery_low9_10};
    public static final int[] k = {R.drawable.charge_battery0, R.drawable.charge_battery0, R.drawable.charge_battery_medium5_6, R.drawable.charge_battery_medium7_8, R.drawable.charge_battery_medium9_10, R.drawable.charge_battery_medium11_12, R.drawable.charge_battery_medium13_14, R.drawable.charge_battery_medium15_16, R.drawable.charge_battery_medium17_18, R.drawable.charge_battery_medium19_20};
    public int f;
    public boolean g;
    public int h;

    public BatteryView(Context context) {
        this(context, null);
    }

    @Override // com.xiaopeng.xui.widget.XImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeStatusChanged(my.l lVar) {
        int b = r70.b.a.b();
        this.g = b == 2 || b == 7;
        t();
    }

    @Override // com.xiaopeng.xui.widget.XImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iv.e(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onRemainingMileageChanged(uy uyVar) {
        this.h = uyVar.a;
        t();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        this.f = ((Integer) m0Var.a).intValue();
        t();
    }

    public final void t() {
        int[] iArr;
        int i2 = this.f;
        boolean z = this.g;
        int i3 = this.h;
        if (i2 == -1 || i3 == -1) {
            setImageResource(R.drawable.charge_battery0);
        } else if (i2 <= 0) {
            setImageResource(R.drawable.charge_battery0);
        } else if (i2 == 99) {
            setImageResource(R.drawable.charge_battery99);
        } else if (i2 >= 100) {
            setImageResource(R.drawable.charge_battery100);
        } else {
            if (z) {
                iArr = i;
            } else if (i3 <= 30) {
                iArr = j;
            } else if (i3 <= 60) {
                iArr = k;
            } else {
                iArr = i;
            }
            if ((iArr == j && i2 > 10) || (iArr == k && (i2 < 5 || i2 > 20))) {
                StringBuilder a = jg.a("updateBattery: soc out of range. soc = [", i2, "], mileage = [", i3, "], charging = [");
                a.append(z);
                a.append("]");
                Log.w("BatteryView", a.toString());
                iArr = i;
            }
            setImageResource(iArr[(i2 - 1) / 2]);
        }
    }

    public BatteryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BatteryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = -1;
        this.g = false;
        this.h = -1;
        t();
    }
}
