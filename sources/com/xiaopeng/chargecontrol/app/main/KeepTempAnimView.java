package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaopeng.libtheme.ThemeManager;
import defpackage.my;
import defpackage.r70;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class KeepTempAnimView extends a3 {
    public int e;

    public KeepTempAnimView(Context context) {
        super(context);
    }

    public final void c(boolean z) {
        if (z) {
            lg.a(this).a(z90.a(ThemeManager.isNightMode(getContext()) ? "battery_keep_temp_night.webp" : "battery_keep_temp.webp")).a((ImageView) this);
        } else {
            lg.a(this).a(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryKeepTempModeChanged(my.d dVar) {
        this.e = ((Integer) dVar.a).intValue();
        t();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c(this.e == 1);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iv.e(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLocalChargeStatusChanged(q70 q70Var) {
        t();
    }

    public final void t() {
        boolean z = true;
        c((this.e != 1 || r70.b.a.b() == 2 || r70.b.a.e()) ? false : false);
    }

    public KeepTempAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeepTempAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
