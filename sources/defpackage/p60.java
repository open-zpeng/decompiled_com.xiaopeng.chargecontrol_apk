package defpackage;

import android.os.Bundle;
import com.xiaopeng.chargecontrol.R;
/* compiled from: ConsumptionDialog.java */
/* renamed from: p60  reason: default package */
/* loaded from: classes.dex */
public class p60 extends m10 {
    @Override // defpackage.m10, androidx.fragment.app.Fragment
    public void d1() {
        super.d1();
        iv.a("P00003", "B001");
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(s1(), R.style.ConsumptionDialog);
        e10Var.b("ConsumptionDialog");
        e10 a = e10Var.a(new o60(U()));
        a.d(R.string.chart_consumption);
        return a.a(true);
    }
}
