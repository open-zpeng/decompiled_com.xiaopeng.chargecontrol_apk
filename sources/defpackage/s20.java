package defpackage;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.xui.widget.XButton;
/* compiled from: ChargeCompleteFragment.java */
/* renamed from: s20  reason: default package */
/* loaded from: classes.dex */
public class s20 extends b10<u20, t20> implements u20, View.OnClickListener {
    public TextView d0;
    public TextView e0;
    public TextView f0;
    public View g0;
    public XButton h0;

    @Override // defpackage.u20
    public void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i == 0 && j == 0) {
            this.f0.setText(R.string.zeromins);
        } else if (j == 0) {
            this.f0.setText(a(R.string.min_format, Long.valueOf(j2)));
        } else if (i == 0) {
            this.f0.setText(a(R.string.hour_format, Long.valueOf(j)));
        } else {
            this.f0.setText(a(R.string.hour_and_min_format, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.d0 = (TextView) view.findViewById(R.id.charge_period);
        this.e0 = (TextView) view.findViewById(R.id.charge_mileage);
        this.f0 = (TextView) view.findViewById(R.id.charge_total_time);
        this.g0 = view.findViewById(R.id.unlock_gun_tips_container);
        this.h0 = (XButton) view.findViewById(R.id.unlock_gun);
        this.h0.setOnClickListener(this);
    }

    @Override // defpackage.u20
    public void c(int i) {
        if (i == 0) {
            this.e0.setText(f(R.string.zeromilegae));
            return;
        }
        TextView textView = this.e0;
        textView.setText(i + f(R.string.unit_km));
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "ChargeComplete";
    }

    @Override // defpackage.u20
    public void i(boolean z) {
        this.g0.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.unlock_gun) {
            return;
        }
        x90.A();
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_charge_complete;
    }

    @Override // defpackage.z00
    public t20 v1() {
        return new t20();
    }

    @Override // defpackage.u20
    public void b(long j, long j2) {
        String c = fb0.c(j);
        String c2 = fb0.c(j2);
        TextView textView = this.d0;
        textView.setText(c + "-" + c2);
    }
}
