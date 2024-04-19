package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.main.ChargeAppointmentBar;
import com.xiaopeng.speech.vui.model.VuiFeedbackCode;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XSwitch;
import defpackage.fa0;
import defpackage.ly;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class ChargeAppointmentBar extends XConstraintLayout implements ma0 {
    public boolean A;
    public final int[] B;
    public kh0 C;
    public d10 D;
    public m10 E;
    public XLinearLayout x;
    public TextView y;
    public XSwitch z;

    public ChargeAppointmentBar(Context context) {
        this(context, null);
    }

    private void setChargeAppointmentToggleChecked(boolean z) {
        this.A = false;
        this.z.setChecked(z);
        this.A = true;
    }

    private void setChargeAppointmentToggleEnable(boolean z) {
        this.z.setEnabled(z);
        u();
    }

    public final void a(int i, int i2, int i3) {
        if (i != 2 && i != 1) {
            i = fa0.b.a.b();
            setChargeAppointmentToggleChecked(false);
        } else {
            setChargeAppointmentToggleChecked(true);
        }
        TextView textView = this.y;
        Resources resources = getResources();
        Object[] objArr = new Object[2];
        objArr[0] = i == 2 ? getResources().getString(R.string.everyday) : "";
        StringBuilder sb = new StringBuilder();
        sb.append(i2 < 10 ? jg.a("0", i2) : Integer.valueOf(i2));
        sb.append(":");
        sb.append(i3 < 10 ? jg.a("0", i3) : Integer.valueOf(i3));
        objArr[1] = sb.toString();
        textView.setText(resources.getString(R.string.bottom_bar_type_and_time_format, objArr));
    }

    public /* synthetic */ void b(Object obj) {
        d10 d10Var = this.D;
        if (d10Var != null) {
            u30 u30Var = new u30();
            this.E = u30Var;
            d10Var.b(u30Var);
        }
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeAppointmentTimeChanged(ly.b bVar) {
        int intValue = ((Integer[]) bVar.a)[0].intValue();
        int intValue2 = ((Integer[]) bVar.a)[1].intValue();
        int intValue3 = ((Integer[]) bVar.a)[2].intValue();
        a(intValue, intValue2, intValue3);
        int[] iArr = this.B;
        iArr[0] = intValue;
        iArr[1] = intValue2;
        iArr[2] = intValue3;
        if (intValue != 0) {
            fa0.b.a.a.edit().putInt("charge_appointment_time_repeat_type", intValue).apply();
        }
    }

    @tl0(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        if (((Integer) jVar.a).intValue() == 0) {
            setChargeAppointmentToggleEnable(true);
        } else {
            setChargeAppointmentToggleEnable(x90.g() == 1);
        }
    }

    @tl0(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeStatusChanged(my.l lVar) {
        if (((Integer) lVar.a).intValue() == 1) {
            setChargeAppointmentToggleEnable(true);
        } else {
            setChargeAppointmentToggleEnable(x90.f() == 0);
        }
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int[] iArr = this.B;
        a(iArr[0], iArr[1], iArr[2]);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m10 m10Var;
        super.onDetachedFromWindow();
        iv.e(this);
        z90.a(this.C);
        d10 d10Var = this.D;
        if (d10Var == null || (m10Var = this.E) == null) {
            return;
        }
        d10Var.a(m10Var);
    }

    public final void u() {
        this.x.setEnabled(this.z.isEnabled() && this.z.isChecked());
    }

    public ChargeAppointmentBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChargeAppointmentBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A = true;
        this.B = new int[3];
        if (getContext() instanceof d10) {
            this.D = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_charge_appointment_bar, this);
        this.x = (XLinearLayout) findViewById(R.id.charge_appointment_time_container);
        this.y = (TextView) findViewById(R.id.charge_appointment_time);
        this.z = (XSwitch) findViewById(R.id.charge_appointment_toggle);
        u();
        z90.a(this.z);
        if (!a70.c()) {
            z90.a(this.x);
        }
        this.z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i50
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ChargeAppointmentBar.this.a(compoundButton, z);
            }
        });
        this.C = z90.a(this.x, new rh0() { // from class: j50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                ChargeAppointmentBar.this.b(obj);
            }
        });
    }

    @Override // defpackage.ma0
    public boolean b(View view, tc0 tc0Var) {
        if (view == this.x) {
            this.z.setChecked(true);
            z90.a(view, VuiFeedbackCode.SUCCESS, (int) R.string.vui_fb_set_appointment_time_manually);
            return false;
        }
        return false;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        z90.a("MainBottom", compoundButton);
        u();
        if (this.A) {
            int b = z ? fa0.b.a.b() : 3;
            int[] iArr = this.B;
            x90.a(b, iArr[1], iArr[2]);
        }
    }
}
