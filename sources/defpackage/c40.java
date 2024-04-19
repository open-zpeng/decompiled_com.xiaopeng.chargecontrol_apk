package defpackage;

import android.os.Bundle;
/* compiled from: DischargeChartDialog.java */
/* renamed from: c40  reason: default package */
/* loaded from: classes.dex */
public class c40 extends m10 {
    @Override // defpackage.m10, androidx.fragment.app.Fragment
    public void d1() {
        super.d1();
        iv.a("P00005", "B001");
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(s1(), s90.DischargeChartDialog);
        e10Var.d(r90.chart_discharging);
        return e10Var.a(new f40(s1())).b((CharSequence) f(r90.close));
    }
}
