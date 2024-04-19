package defpackage;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.chart.ChartView;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XConstraintLayout;
import defpackage.fa0;
import defpackage.ly;
import defpackage.my;
import defpackage.y60;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: ChargePowerChart.java */
/* renamed from: y10  reason: default package */
/* loaded from: classes.dex */
public class y10 extends XConstraintLayout implements h90 {
    public ChartView A;
    public lr B;
    public int C;
    public int D;
    public kh0 E;
    public DecimalFormat x;
    public TextView y;
    public TextView z;

    public y10(Context context) {
        super(context);
        this.x = new DecimalFormat("#.#");
        LayoutInflater.from(getContext()).inflate(q90.layout_chart_charge, this);
        TextView textView = (TextView) findViewById(o90.chart_x_label);
        TextView textView2 = (TextView) findViewById(o90.chart_y_label);
        this.y = (TextView) findViewById(o90.chart_current);
        this.z = (TextView) findViewById(o90.chart_volt);
        this.A = (ChartView) findViewById(o90.chart);
        int i = x90.g() == 2 ? 0 : 8;
        this.y.setVisibility(i);
        this.z.setVisibility(i);
        findViewById(o90.chart_current_icon).setVisibility(i);
        findViewById(o90.chart_volt_icon).setVisibility(i);
        textView.setText(r90.chart_label_soc);
        textView2.setText(r90.chart_label_power);
        this.z.setText(getResources().getString(r90.chart_volt_format, "--"));
        this.y.setText(getResources().getString(r90.chart_current_format, "--"));
        int i2 = fa0.b.a.a.getInt("KEY_START2CHARGE_ELEC", -1);
        Log.e("ChargePowerChart", "startSoc =" + i2);
        if (i2 == -1) {
            Log.e("ChargePowerChart", "startSoc == -1");
            i2 = x90.p();
        }
        this.D = d(i2);
        int e = e(i2);
        mr xAxis = this.A.getXAxis();
        xAxis.b(((y60.a.b - d(i2)) / e) + 1);
        xAxis.s = true;
        this.A.getXAxis().f(this.D);
        this.A.getXAxis().e(y60.a.b);
        this.A.getAxisLeft().f(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.A.getAxisLeft().e(x90.f() == 2 ? 100.0f : 12.0f);
        this.A.getAxisLeft().b(5);
    }

    public static /* synthetic */ vr a(j90 j90Var) {
        return new vr(j90Var.a, j90Var.b);
    }

    private void setCurrent(float f) {
        this.y.setText(getResources().getString(r90.chart_current_format, this.x.format(f)));
    }

    private void setVolt(float f) {
        this.z.setText(getResources().getString(r90.chart_volt_format, this.x.format(f)));
    }

    public final int d(int i) {
        int i2;
        int e = e(i);
        return (e == 1 || (i2 = i % e) == 0) ? i : i - i2;
    }

    public final int e(int i) {
        if (i >= 92) {
            return 1;
        }
        if (i >= 60) {
            return 5;
        }
        return i >= 20 ? 10 : 20;
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float f;
        float f2;
        super.onAttachedToWindow();
        iv.d(this);
        c90.h().a(this);
        int f3 = x90.f();
        if (f3 == 1) {
            f = x90.a();
            f2 = x90.b();
        } else if (f3 == 2) {
            f = x90.i();
            f2 = x90.j();
        } else {
            f = -1.0f;
            f2 = -1.0f;
        }
        if (f != -1.0f) {
            setCurrent(f);
        }
        if (f2 != -1.0f) {
            setVolt(f2);
        }
        z90.a(this.E);
        this.E = c90.h().e().c().b(mk0.b()).a(hh0.a()).a(new rh0() { // from class: t10
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                y10.this.a((List) obj);
            }
        });
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunChanged(my.j jVar) {
        this.C = ((Integer) jVar.a).intValue();
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c90.h().c(this);
        iv.e(this);
        z90.a(this.E);
        super.onDetachedFromWindow();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onFastCurrentChanged(my.v vVar) {
        float floatValue = ((Float) vVar.a).floatValue();
        if (this.C == 2) {
            setCurrent(floatValue);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onFastVoltChanged(my.y yVar) {
        float floatValue = ((Float) yVar.a).floatValue();
        if (this.C == 2) {
            setVolt(floatValue);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLimitChanged(ly.c cVar) {
        lr lrVar = this.B;
        if (lrVar != null) {
            this.A.a(lrVar);
        }
        this.B = this.A.a(((Integer) cVar.a).intValue());
        this.A.invalidate();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSlowCurrentChanged(my.a aVar) {
        float floatValue = ((Float) aVar.a).floatValue();
        if (this.C == 1) {
            setCurrent(floatValue);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSlowVoltChanged(my.b bVar) {
        float floatValue = ((Float) bVar.a).floatValue();
        if (this.C == 1) {
            setVolt(floatValue);
        }
    }

    @Override // defpackage.h90
    public void a(List<j90> list) {
        List<vr> list2 = (List) list.stream().map(new Function() { // from class: r10
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return y10.a((j90) obj);
            }
        }).collect(Collectors.toList());
        if (!list.isEmpty() && list2.get(0).b() != this.D) {
            list2.add(0, new vr(this.A.getXAxis().H, this.A.getAxisLeft().H));
        }
        StringBuilder a = jg.a("onPowerDataChanged entriesSize =");
        a.append(list2.size());
        LogUtils.i("ChargePowerChart", a.toString());
        this.A.setEntries(list2);
    }
}
