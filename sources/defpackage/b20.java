package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* compiled from: TravelLncChargeLimitDialog.java */
/* renamed from: b20  reason: default package */
/* loaded from: classes.dex */
public class b20 extends a20 {
    @Override // defpackage.a20, defpackage.u10
    public void c(View view) {
        super.c(view);
        ((ImageView) view.findViewById(o90.limit_bg)).setImageResource(n90.charge_limit_bg_lnc_travel);
        ((ImageView) view.findViewById(o90.limit_bottom_indicator)).setImageResource(n90.charge_limit_bottom_indicator_lnc_travel);
        ((TextView) view.findViewById(o90.limit_label_long_distance)).setVisibility(4);
        this.w0.setClickable(false);
        this.w0.setButtonDrawable(0);
        this.w0.setText(r90.charge_limit_tips_travel);
    }
}
