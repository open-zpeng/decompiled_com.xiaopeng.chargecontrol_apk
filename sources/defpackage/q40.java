package defpackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.xiaopeng.chargecontrol.R;
/* compiled from: DischargePrepareFragment.java */
/* renamed from: q40  reason: default package */
/* loaded from: classes.dex */
public class q40 extends b10<s40, r40> implements s40, View.OnClickListener {
    public Button d0;

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.d0 = (Button) view.findViewById(R.id.start_discharge);
        this.d0.setOnClickListener(this);
        this.b0.setImageResource(R.drawable.slow_port_discharging);
    }

    @Override // defpackage.s40
    public void c(boolean z) {
        this.d0.setEnabled(z);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "DischargePrepare";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.start_discharge) {
            if (((r40) this.a0).b()) {
                y1();
                return;
            }
            Log.i("DischargePrepareFragmen", "startDischarge by click");
            ((r40) this.a0).d();
        }
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_discharge_prepare;
    }

    public void y1() {
        m10 m10Var = new m10();
        m10Var.b(f(R.string.discharge_error_title));
        m10Var.a(f(R.string.current_elec_too_small_tips));
        m10Var.b(f(R.string.know_it), (md0) null);
        b(m10Var);
    }

    @Override // defpackage.z00
    public r40 v1() {
        return new r40();
    }
}
