package defpackage;

import android.view.View;
import android.widget.ImageView;
import defpackage.y60;
/* compiled from: LfpChargeLimitDialog.java */
/* renamed from: z10  reason: default package */
/* loaded from: classes.dex */
public class z10 extends u10 {
    @Override // defpackage.u10
    public void c(View view) {
        super.c(view);
        ImageView imageView = (ImageView) view.findViewById(o90.limit_bg);
        if (imageView != null) {
            imageView.setImageResource(n90.charge_limit_bg_lfp);
        }
    }

    @Override // defpackage.u10
    public int k(int i) {
        if (i == y60.a.c) {
            return r90.charge_limit_tips_best_lfp;
        }
        return r90.charge_limit_tips_regular_lfp;
    }

    @Override // defpackage.u10
    public int y1() {
        return q90.dialog_charge_limit_settings_lfp;
    }
}
