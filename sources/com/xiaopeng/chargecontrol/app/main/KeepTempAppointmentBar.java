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
import com.xiaopeng.chargecontrol.app.main.KeepTempAppointmentBar;
import com.xiaopeng.speech.vui.model.VuiFeedbackCode;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XSwitch;
import defpackage.fa0;
import defpackage.ly;
import defpackage.my;
import defpackage.r70;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class KeepTempAppointmentBar extends XConstraintLayout implements ma0 {
    public XButton A;
    public boolean B;
    public final int[] C;
    public final jh0 D;
    public d10 E;
    public m10 F;
    public int G;
    public XLinearLayout x;
    public TextView y;
    public XSwitch z;

    public KeepTempAppointmentBar(Context context) {
        this(context, null);
    }

    private void setAppointmentToggleChecked(boolean z) {
        this.B = false;
        this.z.setChecked(z);
        this.B = true;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        w();
        if (this.B) {
            c(z);
        }
        z90.a("MainBottom", compoundButton);
    }

    public /* synthetic */ void b(Object obj) {
        d10 d10Var = this.E;
        if (d10Var != null) {
            d10Var.b(new v30());
        }
    }

    public void c(boolean z) {
        int d = z ? fa0.b.a.d() : 3;
        int[] iArr = this.C;
        x90.b(d, iArr[1], iArr[2]);
    }

    public void d(boolean z) {
        this.A.setText(z ? R.string.keep_temp_stop : R.string.keep_temp_start);
        this.A.a(getResources().getString(z ? R.string.vui_keep_temp_stop : R.string.vui_keep_temp_start));
        z90.a("MainBottom", this.A);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryKeepTempAppointTimeChanged(ly.a aVar) {
        int i;
        int intValue = ((Integer[]) aVar.a)[0].intValue();
        int intValue2 = ((Integer[]) aVar.a)[1].intValue();
        int intValue3 = ((Integer[]) aVar.a)[2].intValue();
        if (intValue != 2 && intValue != 1) {
            i = fa0.b.a.d();
            setAppointmentToggleChecked(false);
        } else {
            setAppointmentToggleChecked(true);
            i = intValue;
        }
        TextView textView = this.y;
        Resources resources = getResources();
        Object[] objArr = new Object[2];
        objArr[0] = i == 2 ? getResources().getString(R.string.everyday) : "";
        objArr[1] = a(intValue2, intValue3);
        textView.setText(resources.getString(R.string.bottom_bar_type_and_time_format, objArr));
        int[] iArr = this.C;
        iArr[0] = intValue;
        iArr[1] = intValue2;
        iArr[2] = intValue3;
        if (intValue != 0) {
            fa0.b.a.a.edit().putInt("keep_temp_appoint_time_repeat_type", intValue).apply();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryKeepTempModeChanged(my.d dVar) {
        this.G = ((Integer) dVar.a).intValue();
        d(((Integer) dVar.a).intValue() == 1);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int[] iArr = this.C;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        TextView textView = this.y;
        Resources resources = getResources();
        Object[] objArr = new Object[2];
        objArr[0] = i == 2 ? getResources().getString(R.string.everyday) : "";
        objArr[1] = a(i2, i3);
        textView.setText(resources.getString(R.string.bottom_bar_type_and_time_format, objArr));
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m10 m10Var;
        super.onDetachedFromWindow();
        iv.e(this);
        this.D.c();
        d10 d10Var = this.E;
        if (d10Var == null || (m10Var = this.F) == null) {
            return;
        }
        d10Var.a(m10Var);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLocalChargeStateChanged(q70 q70Var) {
        setKeepTempEnable(!r70.b.a.e());
    }

    public void setKeepTempEnable(boolean z) {
        this.z.setEnabled(z);
        w();
    }

    public boolean u() {
        return this.G == 1;
    }

    public void v() {
        x90.h(2);
    }

    public final void w() {
        this.x.setEnabled(this.z.isEnabled() && this.z.isChecked());
        this.A.setEnabled(this.z.isEnabled());
    }

    public KeepTempAppointmentBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeepTempAppointmentBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = true;
        this.C = new int[3];
        this.D = new jh0();
        if (getContext() instanceof d10) {
            this.E = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_keep_temp_appointment_bar, this);
        this.x = (XLinearLayout) findViewById(R.id.keep_temp_appointment_time_container);
        this.y = (TextView) findViewById(R.id.keep_temp_appointment_time);
        this.z = (XSwitch) findViewById(R.id.keep_temp_appointment_toggle);
        this.A = (XButton) findViewById(R.id.keep_temp);
        w();
        z90.a(this.A, this.x);
        this.z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r50
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                KeepTempAppointmentBar.this.a(compoundButton, z);
            }
        });
        this.D.c(z90.a(this.x, new rh0() { // from class: p50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                KeepTempAppointmentBar.this.b(obj);
            }
        }));
        this.D.c(z90.a(this.A, new rh0() { // from class: s50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                KeepTempAppointmentBar.this.c(obj);
            }
        }));
    }

    @Override // defpackage.ma0
    public boolean b(View view, tc0 tc0Var) {
        if (view == this.x) {
            this.z.setChecked(true);
            z90.a(view, VuiFeedbackCode.SUCCESS, (int) R.string.vui_fb_set_appointment_time_manually);
            return false;
        } else if (view == this.A) {
            z90.a(view, VuiFeedbackCode.SUCCESS, u() ? R.string.vui_fb_disable_keep_temp : R.string.vui_fb_enable_keep_temp);
            return false;
        } else {
            return false;
        }
    }

    public /* synthetic */ void c(Object obj) {
        if (u()) {
            v();
        } else if (r70.b.a.b() == 2) {
            z90.d(R.string.keep_temp_no_needs_in_charging);
        } else if (this.E != null) {
            m10 m10Var = new m10();
            m10Var.i(R.style.XDialogView);
            m10Var.b(getResources().getString(R.string.keep_temp_start_dialog_title));
            m10Var.a(getResources().getString(R.string.keep_temp_start_dialog_content));
            m10Var.b(getResources().getString(R.string.keep_temp_start_dialog_confirm), new md0() { // from class: q50
                @Override // defpackage.md0
                public final void a(ld0 ld0Var, int i) {
                    x90.h(1);
                }
            });
            m10Var.a(getResources().getString(R.string.cancel), (md0) null);
            d10 d10Var = this.E;
            this.F = m10Var;
            d10Var.b(m10Var);
        }
    }

    public final String a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i < 10 ? jg.a("0", i) : Integer.valueOf(i));
        sb.append(":");
        sb.append(i2 < 10 ? jg.a("0", i2) : Integer.valueOf(i2));
        return sb.toString();
    }
}
