package com.xiaopeng.chargecontrol.app.check;

import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.check.CheckStateFragment;
import defpackage.n30;
/* loaded from: classes.dex */
public class CheckStateFragment extends z00<o30, n30> implements o30 {
    @Override // defpackage.o30
    public void C() {
        if (a70.g()) {
            h(R.string.prompt_battery_temperature_low);
        }
    }

    @Override // defpackage.o30
    public void E() {
        m10 m10Var = new m10();
        m10Var.b(f(R.string.electri_beyond_charge_limit_title));
        m10Var.a(f(R.string.electri_beyond_charge_limit));
        m10Var.b(f(R.string.change_charge_limit), new md0() { // from class: j30
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i) {
                CheckStateFragment.this.a(ld0Var, i);
            }
        });
        if (!a70.g()) {
            m10Var.a(f(R.string.cancel), (md0) null);
            iv.a("P00007", "B001");
        }
        b(m10Var);
    }

    @Override // defpackage.o30
    public void F() {
        h(R.string.prompt_battery_zero);
    }

    @Override // defpackage.o30
    public void G() {
        h(R.string.prompt_charge_slow_cause_battery_trickle_charge);
    }

    @Override // defpackage.o30
    public void H() {
        h(R.string.prompt_charge_slow_cause_battery_warming_or_cooling);
    }

    @Override // defpackage.o30
    public void J() {
        if (a70.g()) {
            h(R.string.dynamic_state_can_not_release_gun_detail);
        }
    }

    public /* synthetic */ void a(ld0 ld0Var, int i) {
        b(iv.a());
    }

    public final void h(int i) {
        z90.d(i);
        if (a70.g()) {
            return;
        }
        iv.a("P00006", "B001");
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_check_state;
    }

    @Override // defpackage.o30
    public void x() {
        x1();
    }

    @Override // defpackage.o30
    public void y() {
        h(R.string.prompt_charge_slow_cause_air_conditioning);
    }

    @Override // defpackage.z00
    public n30 v1() {
        return n30.b.a;
    }
}
