package com.xiaopeng.chargecontrol.chart;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.DashPathEffect;
import android.util.AttributeSet;
import com.xiaopeng.chargecontrol.chart.ChartView;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.mr;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ChartView extends er {
    public final List<vr> n0;
    public final wr o0;
    public final xr p0;
    public final List<vr> q0;
    public final xr r0;

    public ChartView(Context context) {
        super(context);
        this.n0 = new ArrayList();
        this.o0 = new wr();
        this.p0 = new xr(this.n0, null);
        this.q0 = new ArrayList(1);
        this.r0 = new xr(this.q0, null);
        E();
    }

    public void C() {
        this.n0.clear();
        this.q0.clear();
        this.p0.l();
        invalidate();
    }

    public final void D() {
        getXAxis().j = a(l90.chart_axis_line_x);
        getXAxis().f = a(l90.chart_axis_text);
        getXAxis().h = a(l90.chart_grid_line);
        getAxisLeft().f = a(l90.chart_axis_text);
        getAxisLeft().h = a(l90.chart_grid_line);
        for (lr lrVar : getAxisLeft().z) {
            lrVar.i = a(l90.chart_dash_line);
        }
        for (lr lrVar2 : getXAxis().z) {
            lrVar2.i = a(l90.chart_dash_line);
        }
    }

    public final void E() {
        getDescription().a = false;
        setTouchEnabled(false);
        setDragEnabled(false);
        setScaleEnabled(false);
        a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, 8.0f);
        getXAxis().d(1.0f);
        getXAxis().a(getResources().getInteger(p90.chart_axis_size));
        getXAxis().t = false;
        getXAxis().b(6);
        getXAxis().P = mr.a.BOTTOM;
        getXAxis().c(8.0f);
        getXAxis().O = true;
        getAxisLeft().u = false;
        getAxisLeft().d(1.0f);
        getAxisLeft().a(getResources().getInteger(p90.chart_axis_size));
        getAxisLeft().t = true;
        getAxisLeft().b(5);
        getAxisLeft().b(20.0f);
        getAxisRight().u = false;
        getAxisRight().t = false;
        xr xrVar = this.p0;
        xrVar.o = false;
        xrVar.G = true;
        xrVar.n = false;
        xrVar.P = false;
        xrVar.c(a(l90.chart_line));
        this.p0.l = ee0.a(2.0f);
        this.p0.D = getResources().getDrawable(n90.chart_under_line, getContext().getTheme());
        this.p0.a(new es() { // from class: w60
            @Override // defpackage.es
            public final float a(us usVar, ps psVar) {
                return ChartView.this.a(usVar, psVar);
            }
        });
        xr xrVar2 = this.p0;
        xrVar2.y = false;
        xrVar2.z = false;
        xr xrVar3 = this.r0;
        xrVar3.G = false;
        xrVar3.P = true;
        xrVar3.n = false;
        xrVar3.c(0);
        xr xrVar4 = this.r0;
        int a = a(l90.chart_circle_outer);
        if (xrVar4.I == null) {
            xrVar4.I = new ArrayList();
        }
        xrVar4.I.clear();
        xrVar4.I.add(Integer.valueOf(a));
        this.r0.d(15.0f);
        this.r0.J = a(l90.chart_circle_inner);
        this.r0.c(9.0f);
        xr xrVar5 = this.r0;
        xrVar5.y = false;
        xrVar5.z = false;
        this.o0.a((wr) this.p0);
        this.o0.a((wr) this.r0);
        setData(this.o0);
        getLegend().a = false;
        D();
    }

    public /* synthetic */ float a(us usVar, ps psVar) {
        return getAxisLeft().H;
    }

    public lr b(float f) {
        lr c = c(f);
        getAxisLeft().a(c);
        this.p0.l();
        invalidate();
        return c;
    }

    public final lr c(float f) {
        lr lrVar = new lr(f);
        lrVar.i = a(l90.chart_dash_line);
        lrVar.h = zt.a(3.0f);
        lrVar.l = new DashPathEffect(new float[]{4.0f, 7.0f}, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        return lrVar;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            D();
            ir marker = getMarker();
            if (marker instanceof x60) {
                ((x60) marker).a(configuration);
            }
            invalidate();
        }
    }

    public void setEntries(List<vr> list) {
        this.n0.clear();
        this.n0.addAll(list);
        this.q0.clear();
        if (!list.isEmpty()) {
            this.q0.add(list.get(list.size() - 1));
        }
        this.p0.l();
        invalidate();
    }

    public final int a(int i) {
        return getResources().getColor(i, getContext().getTheme());
    }

    public lr a(float f) {
        lr c = c(f);
        getXAxis().a(c);
        return c;
    }

    public void b(lr lrVar) {
        getAxisLeft().z.remove(lrVar);
    }

    public void a(lr lrVar) {
        getXAxis().z.remove(lrVar);
    }

    public ChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n0 = new ArrayList();
        this.o0 = new wr();
        this.p0 = new xr(this.n0, null);
        this.q0 = new ArrayList(1);
        this.r0 = new xr(this.q0, null);
        E();
    }

    public ChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n0 = new ArrayList();
        this.o0 = new wr();
        this.p0 = new xr(this.n0, null);
        this.q0 = new ArrayList(1);
        this.r0 = new xr(this.q0, null);
        E();
    }
}
