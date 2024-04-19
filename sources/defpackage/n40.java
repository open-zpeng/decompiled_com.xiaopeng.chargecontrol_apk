package defpackage;

import android.os.Bundle;
import android.view.View;
import com.xiaopeng.chargecontrol.R;
/* compiled from: DischargeFaultFragment.java */
/* renamed from: n40  reason: default package */
/* loaded from: classes.dex */
public class n40 extends b10<p40, o40> implements p40 {
    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.b0.setImageResource(R.drawable.slow_port_fault);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "DischargeFault";
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_discharge_fault;
    }

    @Override // defpackage.z00
    public o40 v1() {
        return new o40();
    }
}
