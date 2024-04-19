package defpackage;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.chart.ChartView;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XTabLayout;
import defpackage.c90;
import defpackage.fa0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;
/* compiled from: ConsumptionChart.java */
/* renamed from: o60 */
/* loaded from: classes.dex */
public class o60 extends l60 implements la0 {
    public static final float[] L = {2.5f, 20.0f, 100.0f};
    public float A;
    public int[] B;
    public List<List<Float>> C;
    public XTabLayout D;
    public TextView E;
    public TextView F;
    public TextView G;
    public int H;
    public String I;
    public float[] J;
    public lr K;

    public o60(Context context) {
        super(context);
        float[] fArr = L;
        this.A = fArr[0];
        this.B = new int[fArr.length];
        this.C = Arrays.asList(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        this.H = 0;
        this.J = new float[]{82.3f, 82.3f, 82.3f};
        Arrays.fill(this.B, -1);
        this.D = (XTabLayout) findViewById(R.id.chart_consumption_tabs);
        this.E = (TextView) findViewById(R.id.chart_consumption_average);
        this.F = (TextView) findViewById(R.id.chart_consumption_local_average);
        this.G = (TextView) findViewById(R.id.chart_consumption_local_average_label);
        this.J[0] = c90.h().d();
        this.J[1] = c90.b.a.c();
        this.J[2] = c90.b.a.b();
        this.A = fa0.b.a.a.getFloat("consumption_max_mileage", L[0]);
        this.D.setOnTabChangeListener(new m60(this));
        this.y.getXAxis().t = true;
        this.y.getAxisLeft().t = true;
        this.y.getXAxis().e(this.A);
        this.y.getXAxis().a(new n60(this));
        mr xAxis = this.y.getXAxis();
        xAxis.b(this.y.getXAxis().a());
        xAxis.s = true;
        int i = 0;
        while (true) {
            float[] fArr2 = L;
            if (i >= fArr2.length) {
                return;
            }
            if (this.A == fArr2[i]) {
                this.D.f(i);
                if (i == 0) {
                    a(0, false);
                    return;
                }
                return;
            }
            i++;
        }
    }

    private void setMaxMileage(float f) {
        this.A = f;
        this.y.C();
        this.y.getXAxis().e(this.A);
        ChartView chartView = this.y;
        chartView.setData(chartView.getData());
        c(this.C.get(this.D.getSelectedTabIndex()));
    }

    @Override // defpackage.l60, defpackage.g90
    public void b(List<Float> list) {
        int[] iArr;
        int i = 0;
        while (true) {
            iArr = this.B;
            if (i >= iArr.length) {
                break;
            }
            int i2 = iArr[i] + 1;
            iArr[i] = i2;
            int i3 = (int) (L[i] / 10.0f);
            if (i3 <= 0) {
                i3 = 1;
            }
            if (i2 % i3 == 0) {
                this.B[i] = 0;
                this.C.set(i, list);
            }
            i++;
        }
        if (iArr[this.D.getSelectedTabIndex()] != 0) {
            return;
        }
        c(list);
    }

    public final void c(List<Float> list) {
        List<Float> subList = list.subList((int) Math.max((list.size() - (this.A * 10.0f)) - 1.0f, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT), list.size());
        int i = (int) (this.A / 10.0f);
        if (i <= 0) {
            i = 1;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < subList.size(); i2 += i) {
            arrayList.add(new vr(i2 * 0.1f, subList.get(i2).floatValue()));
        }
        this.y.setEntries(arrayList);
        if (a70.f() || a70.e()) {
            return;
        }
        double orElse = subList.stream().mapToDouble(new ToDoubleFunction() { // from class: j60
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double floatValue;
                Float f = (Float) obj;
                return floatValue;
            }
        }).average().orElse(XLoadingDrawable.DEFAULT_RADIANS);
        this.F.setText(getResources().getString(R.string.chart_consumption_average_format, this.x.format(orElse)));
        b((float) orElse);
    }

    @Override // defpackage.la0
    public void e(String str) {
        this.I = str;
    }

    public final void f(String str) {
        this.E.setText(getResources().getString(R.string.chart_consumption_average_format, str));
    }

    @Override // defpackage.l60, com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        float a = c90.b.a.a();
        f(a == -1.0f ? "--" : this.x.format(a));
    }

    public void u() {
        Log.d("chart", "removeAverageLine: ");
        lr lrVar = this.K;
        if (lrVar != null) {
            this.y.b(lrVar);
        }
    }

    @Override // defpackage.l60, defpackage.g90
    public void a(float f, int i) {
        this.J[i] = f;
        Log.i("ConsumptionChart", this.J.toString() + " ,mSelectedTabIndex:" + this.H + "    Float:" + f);
        if (i == this.H) {
            if (a70.f() || a70.e()) {
                if (f == 82.3f) {
                    this.F.setText("--");
                    u();
                    return;
                }
                this.F.setText(getResources().getString(R.string.chart_consumption_average_format, this.x.format(f)));
                b(f);
            }
        }
    }

    public void b(float f) {
        Log.d("chart", "updateAverageLine: " + f);
        lr lrVar = this.K;
        if (lrVar != null) {
            this.y.b(lrVar);
        }
        this.K = this.y.b(f);
    }

    @Override // defpackage.l60, defpackage.g90
    public void a(float f) {
        f(this.x.format(f));
    }

    public final void a(int i, boolean z) {
        this.G.setText(getResources().getString(R.string.chart_consumption_local_average_label_format, this.D.d(i)));
        setMaxMileage(L[i]);
        this.H = i;
        if (a70.f() || a70.e()) {
            if (this.J[this.H] == 82.3f) {
                this.F.setText("--");
                u();
            } else {
                this.F.setText(getResources().getString(R.string.chart_consumption_average_format, this.x.format(this.J[this.H])));
                b(this.J[this.H]);
            }
        }
        if (z) {
            fa0.b.a.a.edit().putFloat("consumption_max_mileage", this.A).apply();
        }
        if (this.I != null) {
            z90.b().updateScene(this.I, this.D);
        }
    }
}
