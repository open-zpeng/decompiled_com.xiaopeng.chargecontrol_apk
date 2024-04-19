package defpackage;

import android.view.View;
import android.widget.TextView;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.xui.widget.XTextView;
/* compiled from: LncChargeLimitDialog.java */
/* renamed from: a20  reason: default package */
/* loaded from: classes.dex */
public class a20 extends u10 {
    public static final int A0 = ee0.a(10.0f);
    public TextView y0;
    public XTextView z0;

    public final void A1() {
        float left = this.z0.getLeft();
        float right = this.t0.getRight();
        if (this.y0.getRight() + A0 >= this.s0.getLeft()) {
            this.y0.setVisibility(4);
        } else {
            this.y0.setVisibility(0);
        }
        if (right + A0 >= left) {
            this.z0.setVisibility(4);
        } else {
            this.z0.setVisibility(0);
        }
    }

    @Override // defpackage.u10
    public void c(View view) {
        super.c(view);
        this.y0 = (TextView) view.findViewById(o90.limit_min);
        this.z0 = (XTextView) view.findViewById(o90.limit_best);
        VuiUtils.addCanVoiceControlProp(this.z0);
    }

    @Override // defpackage.u10
    public void m(int i) {
        super.m(i);
        this.x0.b(new Runnable() { // from class: s10
            @Override // java.lang.Runnable
            public final void run() {
                a20.this.A1();
            }
        });
    }

    @Override // defpackage.u10
    public int y1() {
        return q90.dialog_charge_limit_settings_lnc;
    }
}
