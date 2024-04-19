package defpackage;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import java.util.concurrent.TimeUnit;
/* compiled from: ChargeAppointmentFragment.java */
/* renamed from: e20  reason: default package */
/* loaded from: classes.dex */
public class e20 extends b10<g20, f20> implements g20, View.OnClickListener {
    public TextView d0;
    public TextView e0;
    public Button f0;
    public Calendar g0 = Calendar.getInstance();
    public kh0 h0;

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00, androidx.fragment.app.Fragment
    public void Q0() {
        z90.a(this.h0);
        super.Q0();
    }

    public /* synthetic */ void a(Long l) {
        this.f0.setEnabled(true);
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.d0 = (TextView) view.findViewById(R.id.day);
        this.e0 = (TextView) view.findViewById(R.id.time);
        this.f0 = (Button) view.findViewById(R.id.start_charge);
        this.f0.setOnClickListener(this);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "ChargeAppointment";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.start_charge) {
            Log.i("ChargeAppointmentFragment", "startCharge by click");
            this.f0.setEnabled(false);
            ((f20) this.a0).b();
            z90.a(this.h0);
            this.h0 = ah0.a(30L, TimeUnit.SECONDS).a(hh0.a()).b(new rh0() { // from class: c20
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    e20.this.a((Long) obj);
                }
            });
        }
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_charge_appointment;
    }

    @Override // defpackage.g20
    public void a(int i, int i2, int i3) {
        StringBuilder a = jg.a(" ");
        a.append(i2 < 10 ? jg.a("0", i2) : Integer.valueOf(i2));
        a.append(" : ");
        a.append(i3 < 10 ? jg.a("0", i3) : Integer.valueOf(i3));
        this.e0.setText(a.toString());
        this.g0.setTimeInMillis(System.currentTimeMillis());
        if ((i2 * 60) + i3 <= (this.g0.get(11) * 60) + this.g0.get(12)) {
            this.d0.setText(R.string.tomorrow);
        } else {
            this.d0.setText(R.string.today);
        }
    }

    @Override // defpackage.z00
    public f20 v1() {
        return new f20();
    }
}
