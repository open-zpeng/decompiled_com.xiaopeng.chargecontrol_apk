package com.xiaopeng.chargecontrol.app.main;

import android.os.Bundle;
import android.view.View;
import com.xiaopeng.chargecontrol.R;
/* loaded from: classes.dex */
public class BottomFragment extends ia0<c60, b60> implements c60 {
    public View b0;
    public View c0;
    public View d0;
    public View e0;
    public final jh0 f0 = new jh0();

    @Override // defpackage.c60
    public void A() {
        this.b0.setVisibility(8);
        this.c0.setVisibility(0);
        z90.a(getSceneId(), this.b0, this.c0);
    }

    @Override // defpackage.c60
    public void B() {
        this.b0.setVisibility(0);
        this.c0.setVisibility(8);
        z90.a(getSceneId(), this.b0, this.c0);
    }

    @Override // defpackage.ia0, defpackage.z00, androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        this.f0.c();
    }

    @Override // defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.b0 = view.findViewById(R.id.charge_limit_bar);
        this.c0 = view.findViewById(R.id.discharge_limit_bar);
        if (a70.c()) {
            return;
        }
        this.d0 = view.findViewById(R.id.fridge_bar);
        this.e0 = view.findViewById(R.id.trunk_power_bar);
    }

    @Override // defpackage.c60
    public void g(boolean z) {
        if (this.d0 != null) {
            this.d0.setVisibility(z ? 0 : 8);
            z90.a(getSceneId(), this.d0);
        }
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "MainBottom";
    }

    @Override // defpackage.c60
    public void h(boolean z) {
        View view = this.e0;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            z90.a(getSceneId(), this.e0);
        }
    }

    @Override // defpackage.ia0
    public boolean isMainScene() {
        return false;
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_bottom;
    }

    @Override // defpackage.z00
    public b60 v1() {
        return new b60();
    }

    @Override // defpackage.ia0, defpackage.jc0
    public boolean b(View view, tc0 tc0Var) {
        ma0 a = z90.a(view);
        if (a == null || !a.b(view, tc0Var)) {
            super.b(view, tc0Var);
            return false;
        }
        return true;
    }
}
