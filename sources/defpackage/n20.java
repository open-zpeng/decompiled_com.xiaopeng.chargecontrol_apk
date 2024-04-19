package defpackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.concurrent.TimeUnit;
/* compiled from: ChargingFragment.java */
/* renamed from: n20  reason: default package */
/* loaded from: classes.dex */
public class n20 extends b10<p20, o20> implements View.OnClickListener, p20 {
    public TextView d0;
    public Button e0;
    public ImageView f0;
    public View g0;
    public TextView h0;
    public TextView i0;
    public TextView j0;
    public TextView k0;
    public XRelativeLayout l0;
    public XButton m0;
    public ImageView n0;
    public TextView o0;
    public ViewPropertyAnimator p0;
    public kh0 q0;
    public jh0 r0 = new jh0();

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00, androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        this.p0.setListener(null);
        this.p0.cancel();
        z90.a(this.q0);
        z90.a(this.r0);
    }

    public /* synthetic */ void a(ld0 ld0Var, int i) {
        Log.i("ChargingFragment", "stopCharge stop by click");
        ((o20) this.a0).b();
        this.e0.setEnabled(false);
        z90.a(this.q0);
        this.q0 = ah0.a(30L, TimeUnit.SECONDS).a(hh0.a()).b(new rh0() { // from class: i20
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                n20.this.a((Long) obj);
            }
        });
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.d0 = (TextView) view.findViewById(R.id.message);
        this.e0 = (Button) view.findViewById(R.id.stop_charge);
        this.g0 = view.findViewById(R.id.time_container);
        this.l0 = (XRelativeLayout) view.findViewById(R.id.lock_gun_tips_container);
        this.m0 = (XButton) view.findViewById(R.id.lock_gun);
        this.l0.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        this.h0 = (XTextView) view.findViewById(R.id.hour);
        this.i0 = (XTextView) view.findViewById(R.id.min);
        this.k0 = (TextView) view.findViewById(R.id.unit_hour);
        this.j0 = (TextView) view.findViewById(R.id.unit_min);
        this.n0 = (ImageView) r1().findViewById(R.id.battery_anim);
        this.o0 = (TextView) view.findViewById(R.id.charging_solwed_tips);
        this.f0 = (ImageView) r1().findViewById(R.id.car_bottom_charging_anim);
        this.f0.setVisibility(0);
        this.r0.c(z90.a(this.e0, new rh0() { // from class: j20
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                n20.this.b(obj);
            }
        }));
        lg.a(this).a(z90.a("battery_charging_loop.webp")).a(this.n0);
        lg.b(U()).a(this).a(z90.a("under_car_charging.webp")).a(this.f0);
        View findViewById = r1().findViewById(R.id.car_background);
        this.p0 = findViewById.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(new m20(this, findViewById));
        this.p0.start();
    }

    @Override // defpackage.p20
    public void d(boolean z) {
        this.o0.setVisibility(z ? 0 : 8);
    }

    @Override // defpackage.p20
    public void e(int i) {
        if (i == 1) {
            this.b0.setImageResource(R.drawable.slow_port_charging);
        } else if (i == 2) {
            this.c0.setImageResource(R.drawable.fast_port_charging);
        }
    }

    @Override // defpackage.p20
    public void f(boolean z) {
        this.l0.setVisibility(z ? 0 : 8);
        z90.a("MainBottom", this.l0);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "ChargeCharging";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lock_gun || id == R.id.lock_gun_tips_container) {
            ((o20) this.a0).a(false);
        }
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_charging;
    }

    @Override // defpackage.z00
    public o20 v1() {
        return new o20();
    }

    public /* synthetic */ void a(Long l) {
        this.e0.setEnabled(true);
    }

    public /* synthetic */ void b(Object obj) {
        m10 m10Var = new m10();
        m10Var.b(f(R.string.dialog_title_confirm_stop_charge));
        m10Var.a(f(R.string.dialog_content_tip_finish_charging));
        m10Var.b(f(R.string.finish_charge), new md0() { // from class: h20
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i) {
                n20.this.a(ld0Var, i);
            }
        });
        m10Var.a(f(R.string.cancel), (md0) null);
        b(m10Var);
    }

    @Override // defpackage.p20
    public void b(int i) {
        Log.i("ChargingFragment", "updateCompleteTime time = " + i);
        if (i < 0) {
            this.d0.setVisibility(0);
            this.g0.setVisibility(8);
            this.d0.setText("- - ：- -");
        } else if (i == 0) {
            this.g0.setVisibility(8);
            this.d0.setVisibility(0);
            this.d0.setText(R.string.rest_time_calculating);
        } else if (i <= 5) {
            this.g0.setVisibility(8);
            this.d0.setVisibility(0);
            this.d0.setText(R.string.charge_going2finish);
        } else if (i <= 60) {
            this.g0.setVisibility(0);
            this.d0.setVisibility(8);
            this.k0.setVisibility(8);
            this.h0.setVisibility(8);
            this.j0.setVisibility(0);
            this.i0.setVisibility(0);
            TextView textView = this.i0;
            textView.setText("" + i);
        } else if (i < 2400) {
            this.g0.setVisibility(0);
            this.d0.setVisibility(8);
            this.h0.setVisibility(0);
            this.k0.setVisibility(0);
            TextView textView2 = this.h0;
            StringBuilder a = jg.a("");
            a.append(i / 60);
            textView2.setText(a.toString());
            int i2 = i % 60;
            if (i2 == 0) {
                this.i0.setVisibility(8);
                this.j0.setVisibility(8);
                return;
            }
            this.i0.setVisibility(0);
            this.j0.setVisibility(0);
            TextView textView3 = this.i0;
            textView3.setText("" + i2);
        } else {
            this.g0.setVisibility(8);
            this.d0.setVisibility(0);
            this.d0.setText(R.string.rest_time_need_more_time_for_charging);
        }
    }
}
