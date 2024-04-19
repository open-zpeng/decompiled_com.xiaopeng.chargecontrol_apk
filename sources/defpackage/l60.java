package defpackage;

import android.app.Activity;
import android.content.Context;
import android.icu.text.DecimalFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.main.MainActivity;
import com.xiaopeng.chargecontrol.chart.ChartView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XConstraintLayout;
import defpackage.w90;
import java.util.List;
/* compiled from: AbsConsumptionChart.java */
/* renamed from: l60  reason: default package */
/* loaded from: classes.dex */
public abstract class l60 extends XConstraintLayout implements g90 {
    public DecimalFormat x;
    public ChartView y;
    public kh0 z;

    public l60(Context context) {
        super(context);
        this.x = new DecimalFormat("#.#");
        LayoutInflater.from(getContext()).inflate(R.layout.layout_chart_consumption, this);
        this.y = (ChartView) findViewById(R.id.chart);
        ((TextView) findViewById(R.id.chart_x_label)).setText(R.string.chart_label_mileage);
        ((TextView) findViewById(R.id.chart_y_label)).setText(R.string.chart_label_consumption);
        this.y.getXAxis().f(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.y.getXAxis().e(100.0f);
        this.y.getAxisLeft().f(-20.0f);
        this.y.getAxisLeft().e(60.0f);
    }

    @Override // defpackage.g90
    public void a(float f) {
    }

    @Override // defpackage.g90
    public void a(float f, int i) {
    }

    @Override // defpackage.g90
    public void b(List<Float> list) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Activity activity = w90.b.a.a;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).q();
        }
        return dispatchTouchEvent;
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c90.h().a(this);
        z90.a(this.z);
        this.z = c90.h().e().d().b(mk0.b()).a(hh0.a()).a(new rh0() { // from class: k60
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                l60.this.b((List) obj);
            }
        });
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c90.h().b(this);
        z90.a(this.z);
        super.onDetachedFromWindow();
    }
}
