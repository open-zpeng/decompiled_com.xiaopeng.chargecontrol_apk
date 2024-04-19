package defpackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.xiaopeng.chargecontrol.R;
import defpackage.fa0;
/* compiled from: ChargeFaultFragment.java */
/* renamed from: w20  reason: default package */
/* loaded from: classes.dex */
public class w20 extends b10<y20, x20> implements y20 {
    public ImageView d0;
    public ImageView e0;

    @Override // defpackage.y20
    public void D() {
        Log.i("ChargeFaultFragment", "showDischargingLowPowerObcFault() called");
        a(R.string.charge_gun_action_error_title, R.string.charge_gun_action_error_advise);
    }

    @Override // defpackage.y20
    public void I() {
        Log.i("ChargeFaultFragment", "showChargeFault() called");
        a(R.string.charge_error, R.string.error_tips2);
    }

    @Override // defpackage.y20
    public void K() {
        Log.i("ChargeFaultFragment", "showFastAndSlowChargeGunLinkFault() called");
        a(R.string.input_fast_slow_gun_same_time, R.string.charge_gun_error2);
    }

    public final void a(int i, int i2) {
        if (fa0.b.a.a.getBoolean("charge_error_dialog_show", false)) {
            Log.i("ChargeFaultFragment", "showErrorTipsDialog: dialog has been shown, skip");
            return;
        }
        m10 m10Var = new m10();
        m10Var.b(f(i));
        m10Var.a(f(i2));
        m10Var.b(f(R.string.know_it), (md0) null);
        b(m10Var);
        fa0.b.a.b(true);
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.d0 = (ImageView) r1().findViewById(R.id.charge_port_slow);
        this.e0 = (ImageView) r1().findViewById(R.id.charge_port_fast);
        this.d0.setImageResource(R.drawable.slow_port_fault);
        this.e0.setImageResource(R.drawable.fast_port_fault);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "ChargeFault";
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_charge_fault;
    }

    @Override // defpackage.y20
    public void z() {
        Log.i("ChargeFaultFragment", "showChargingPileFault() called");
        a(R.string.charge_station_error_title, R.string.charge_station_error_tips2);
    }

    @Override // defpackage.z00
    public x20 v1() {
        return new x20();
    }
}
