package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.icu.text.DecimalFormat;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.chart.ChartView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XConstraintLayout;
import defpackage.fa0;
import defpackage.my;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: DischargePowerChart.java */
/* renamed from: f40  reason: default package */
/* loaded from: classes.dex */
public class f40 extends XConstraintLayout implements h90 {
    public ChartView A;
    public int B;
    public kh0 C;
    public int D;
    public int E;
    public int F;
    public List<vr> G;
    public xr H;
    public DecimalFormat x;
    public TextView y;
    public TextView z;

    public f40(Context context) {
        super(context);
        this.x = new DecimalFormat("#.#");
        this.G = new ArrayList();
        this.H = new xr(this.G, null);
        LayoutInflater.from(getContext()).inflate(q90.layout_chart_charge, this);
        TextView textView = (TextView) findViewById(o90.chart_x_label);
        TextView textView2 = (TextView) findViewById(o90.chart_y_label);
        this.y = (TextView) findViewById(o90.chart_current);
        this.z = (TextView) findViewById(o90.chart_volt);
        this.A = (ChartView) findViewById(o90.chart);
        int i = x90.g() == 5 ? 0 : 8;
        this.y.setVisibility(i);
        this.z.setVisibility(i);
        findViewById(o90.chart_current_icon).setVisibility(i);
        findViewById(o90.chart_volt_icon).setVisibility(i);
        textView.setText(r90.chart_label_soc);
        textView2.setText(r90.chart_label_power);
        this.z.setText(getResources().getString(r90.chart_volt_format, "--"));
        this.y.setText(getResources().getString(r90.chart_current_format, "--"));
        int i2 = fa0.b.a.a.getInt("KEY_START2DISCHARGE_ELEC", -1);
        i2 = i2 == -1 ? x90.p() : i2;
        this.D = d(i2);
        this.F = ((d(i2) - 20) / e(i2)) + 1;
        this.E = e(i2);
        mr xAxis = this.A.getXAxis();
        xAxis.b(this.F);
        xAxis.s = true;
        this.A.getXAxis().f(20.0f);
        this.A.getXAxis().e(this.D);
        this.A.getXAxis().a(new e40(this));
        this.A.getAxisLeft().f(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.A.getAxisLeft().e(8.0f);
        this.A.getAxisLeft().b(5);
        int b = x90.b(100);
        this.A.a(f(b));
        this.H.a(false);
        xr xrVar = this.H;
        xrVar.G = true;
        xrVar.n = false;
        xrVar.P = false;
        xrVar.c(0);
        this.H.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.H.a(getResources().getDrawable(n90.chart_limit, getContext().getTheme()));
        this.H.a(new es() { // from class: z30
            @Override // defpackage.es
            public final float a(us usVar, ps psVar) {
                return f40.this.a(usVar, psVar);
            }
        });
        xr xrVar2 = this.H;
        xrVar2.y = false;
        xrVar2.z = false;
        this.G.add(new vr(f(b), this.A.getAxisLeft().G));
        this.G.add(new vr(this.A.getXAxis().G, this.A.getAxisLeft().G));
        ((wr) this.A.getData()).a((wr) this.H);
    }

    private void setCurrent(float f) {
        TextView textView = this.y;
        Resources resources = getResources();
        int i = r90.chart_current_format;
        Object[] objArr = new Object[1];
        objArr[0] = f < 1.0f ? "<1" : this.x.format(f);
        textView.setText(resources.getString(i, objArr));
    }

    private void setVolt(float f) {
        this.z.setText(getResources().getString(r90.chart_volt_format, this.x.format(f)));
    }

    public /* synthetic */ float a(us usVar, ps psVar) {
        return this.A.getAxisLeft().H;
    }

    public final int d(int i) {
        int i2;
        int e = e(i);
        return (e == 1 || (i2 = (i + (-20)) % e) == 0) ? i : (i + e) - i2;
    }

    public final int e(int i) {
        if (i <= 27) {
            return 1;
        }
        return i <= 55 ? 5 : 10;
    }

    public final int f(int i) {
        return (this.D - i) + 20;
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
        c90.h().b(this);
        float a = x90.a();
        if (a != -1.0f) {
            setCurrent(a);
        }
        float b = x90.b();
        if (b != -1.0f) {
            setVolt(b);
        }
        z90.a(this.C);
        this.C = c90.h().e().e().b(mk0.b()).a(hh0.a()).a(new rh0() { // from class: a40
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                f40.this.a((List) obj);
            }
        });
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunChanged(my.j jVar) {
        this.B = ((Integer) jVar.a).intValue();
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c90.h().d(this);
        iv.e(this);
        z90.a(this.C);
        super.onDetachedFromWindow();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSlowCurrentChanged(my.a aVar) {
        float floatValue = ((Float) aVar.a).floatValue();
        if (this.B == 4) {
            setCurrent(floatValue);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSlowVoltChanged(my.b bVar) {
        float floatValue = ((Float) bVar.a).floatValue();
        if (this.B == 4) {
            setVolt(floatValue);
        }
    }

    @Override // defpackage.h90
    public void a(List<j90> list) {
        List<vr> list2 = (List) list.stream().map(new Function() { // from class: y30
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return f40.this.a((j90) obj);
            }
        }).collect(Collectors.toList());
        if (!list.isEmpty()) {
            vr vrVar = list2.get(0);
            if (vrVar.b() != this.D) {
                list2.add(0, new vr(vrVar.b(), this.A.getAxisLeft().H));
                list2.add(0, new vr(this.A.getXAxis().H, this.A.getAxisLeft().H));
            }
        }
        this.A.setEntries(list2);
    }

    public /* synthetic */ vr a(j90 j90Var) {
        return new vr(f(j90Var.a), j90Var.b);
    }
}
