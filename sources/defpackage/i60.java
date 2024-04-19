package defpackage;

import android.app.ActivityThread;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.chargecontrol.R;
/* compiled from: TrunkPowerLowBatteryDialog.java */
/* renamed from: i60  reason: default package */
/* loaded from: classes.dex */
public class i60 extends m10 {
    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.a(layoutInflater, viewGroup, bundle);
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(ActivityThread.currentApplication(), u60.XDialogView);
        e10Var.c(2048);
        e10Var.d(R.string.toast_trunk_power_hint);
        e10Var.g(R.string.toast_trunk_power_low_battery);
        e10Var.b(R.string.know_it);
        return e10Var;
    }
}
