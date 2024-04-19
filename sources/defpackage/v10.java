package defpackage;

import android.os.Bundle;
import android.view.View;
/* compiled from: ChargeChartDialog.java */
/* renamed from: v10  reason: default package */
/* loaded from: classes.dex */
public class v10 extends m10 {
    @Override // defpackage.m10, androidx.fragment.app.Fragment
    public void d1() {
        super.d1();
        iv.a("P00004", "B001");
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(s1(), s90.ChargeChartDialog);
        e10Var.b("ChargeChartDialog");
        e10Var.d(r90.chart_charge);
        return e10Var.a((View) new y10(s1()), false).b((CharSequence) f(r90.close));
    }
}
