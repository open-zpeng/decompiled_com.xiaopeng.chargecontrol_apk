package defpackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
/* compiled from: DischargeCompleteFragment.java */
/* renamed from: g40  reason: default package */
/* loaded from: classes.dex */
public class g40 extends b10<i40, h40> implements i40, View.OnClickListener {
    public TextView d0;
    public Button e0;

    @Override // defpackage.i40
    public void a(float f) {
        this.d0.setText(a(R.string.discharge_supply_format, f + ""));
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.e0 = (Button) view.findViewById(R.id.start_discharge);
        this.e0.setOnClickListener(this);
        this.d0 = (TextView) view.findViewById(R.id.degrees);
        this.b0.setImageResource(R.drawable.slow_port_discharging);
        this.d0.setText(a(R.string.discharge_supply_format, "--"));
    }

    @Override // defpackage.i40
    public void c(boolean z) {
        this.e0.setEnabled(z);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "DischargeComplete";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.start_discharge) {
            Log.i("DischargeCompleteFragme", "startDischarge by click");
            ((h40) this.a0).c();
        }
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_discharge_complete;
    }

    @Override // defpackage.z00
    public h40 v1() {
        return new h40();
    }
}
