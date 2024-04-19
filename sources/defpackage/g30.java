package defpackage;

import android.app.ActivityThread;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
/* compiled from: ChargePrepareFragment.java */
/* renamed from: g30  reason: default package */
/* loaded from: classes.dex */
public class g30 extends b10<i30, h30> implements i30 {
    public TextView d0;
    public TextView e0;
    public TextView f0;

    @Override // defpackage.i30
    public void a(String str, String str2) {
        this.d0.setText(str);
        this.e0.setText(str2);
    }

    @Override // defpackage.b10, defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.d0 = (TextView) view.findViewById(R.id.title);
        this.e0 = (TextView) view.findViewById(R.id.message);
        this.f0 = (TextView) view.findViewById(R.id.heat_management_remaining_time);
    }

    @Override // defpackage.i30
    public void d(int i) {
        int i2 = i == 1 ? R.string.charge_prepare_tips4 : i >= 39 ? R.string.charge_prepare_tips5 : 0;
        if (i2 != 0) {
            this.e0.setText(ActivityThread.currentApplication().getString(i2));
        }
    }

    @Override // defpackage.i30
    public void e(boolean z) {
        if (z) {
            this.f0.setVisibility(0);
            this.e0.setVisibility(8);
            return;
        }
        this.f0.setVisibility(8);
        this.e0.setVisibility(0);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "ChargePrepare";
    }

    @Override // defpackage.i30
    public void j(boolean z) {
        if (z) {
            this.d0.setText(ActivityThread.currentApplication().getString(R.string.charge_prepare_tips2));
            this.e0.setText(ActivityThread.currentApplication().getString(R.string.charge_prepare_tips4));
            return;
        }
        this.d0.setText(ActivityThread.currentApplication().getString(R.string.title_charge_prepare_check_fault));
        this.e0.setText(ActivityThread.currentApplication().getString(R.string.charge_prepare_tips6));
    }

    @Override // defpackage.z00
    public int w1() {
        return R.layout.fragment_charge_prepare;
    }

    @Override // defpackage.z00
    public h30 v1() {
        return new h30();
    }

    @Override // defpackage.i30
    public void a(boolean z, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(f(z ? R.string.charge_prepare_warming : R.string.charge_prepare_cooling));
        if (j <= 0) {
            sb.append(f(R.string.rest_time_calculating));
        } else if (j <= 5) {
            sb.append(f(z ? R.string.charge_prepare_warming_finish_quickly : R.string.charge_prepare_cooling_finish_quickly));
        } else if (j < 60) {
            sb.append(f(R.string.charge_prepare_remaining));
            sb.append(a(R.string.charge_prepare_min_format, Long.valueOf(j)));
        } else if (j < 2400) {
            sb.append(f(R.string.charge_prepare_remaining));
            sb.append(a(R.string.charge_prepare_hour_format, Long.valueOf(j / 60)));
            long j2 = j % 60;
            if (j2 != 0) {
                sb.append(" ");
                sb.append(a(R.string.charge_prepare_min_format, Long.valueOf(j2)));
            }
        } else {
            sb.append(f(R.string.charge_prepare_heat_management_takes_long_time));
        }
        this.f0.setText(sb);
    }
}
