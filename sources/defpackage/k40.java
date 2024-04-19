package defpackage;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.libtheme.ThemeManager;
import java.util.concurrent.TimeUnit;
/* compiled from: DischargingFragment.java */
/* renamed from: k40  reason: default package */
/* loaded from: classes.dex */
public class k40 extends b10<m40, l40> implements m40, View.OnClickListener {
    public TextView d0;
    public TextView e0;
    public TextView f0;
    public TextView g0;
    public Button h0;
    public ImageView i0;
    public kh0 j0;
    public DecimalFormat k0 = new DecimalFormat("#.#");

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00, androidx.fragment.app.Fragment
    public void Q0() {
        z90.a(this.j0);
        this.i0.setVisibility(8);
        super.Q0();
    }

    public /* synthetic */ void a(Long l) {
        this.h0.setEnabled(true);
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.h0 = (Button) view.findViewById(R.id.stop_discharge);
        this.h0.setOnClickListener(this);
        this.g0 = (TextView) view.findViewById(R.id.degrees);
        this.d0 = (TextView) view.findViewById(R.id.current);
        this.e0 = (TextView) view.findViewById(R.id.volt);
        this.f0 = (TextView) view.findViewById(R.id.power);
        this.i0 = (ImageView) r1().findViewById(R.id.car_bottom_discharging_anim);
        this.i0.setVisibility(0);
        this.b0.setImageResource(R.drawable.slow_port_discharging);
        this.g0.setText(a(R.string.discharge_supply_format, "--"));
        y1();
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "DischargeDischarging";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.stop_discharge) {
            Log.i("DischargingFragment", "stopDischarge by click");
            ((l40) this.a0).b();
            this.h0.setEnabled(false);
            z90.a(this.j0);
            this.j0 = ah0.a(30L, TimeUnit.SECONDS).a(hh0.a()).b(new rh0() { // from class: j40
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    k40.this.a((Long) obj);
                }
            });
        }
    }

    @Override // defpackage.z00
    public void p(boolean z) {
        super.p(z);
        y1();
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_discharging;
    }

    public final void y1() {
        lg.a(this).a(z90.a(ThemeManager.isNightMode(r1()) ? "discharging_current_anim_night.webp" : "discharging_current_anim.webp")).a(this.i0);
    }

    @Override // defpackage.m40
    public void a(float f) {
        this.g0.setText(a(R.string.discharge_supply_format, f + ""));
    }

    @Override // defpackage.z00
    public l40 v1() {
        return new l40();
    }

    @Override // defpackage.m40
    public void a(float f, float f2, float f3) {
        if (f < 1.0f) {
            this.d0.setText("<1");
            this.f0.setText("--");
        } else {
            this.d0.setText(this.k0.format(f));
            this.f0.setText(this.k0.format(f3));
        }
        this.e0.setText(this.k0.format(f2));
    }
}
