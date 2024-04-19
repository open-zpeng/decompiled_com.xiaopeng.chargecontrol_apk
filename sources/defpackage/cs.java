package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: DefaultFillFormatter.java */
/* renamed from: cs  reason: default package */
/* loaded from: classes.dex */
public class cs implements es {
    @Override // defpackage.es
    public float a(us usVar, ps psVar) {
        float yChartMax = psVar.getYChartMax();
        float yChartMin = psVar.getYChartMin();
        wr lineData = psVar.getLineData();
        if (((ur) usVar).t <= XToggleDrawable.LIGHT_RADIUS_DEFAULT || ((ur) usVar).u >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            if (lineData.a > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                yChartMax = 0.0f;
            }
            if (lineData.b < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                yChartMin = 0.0f;
            }
            return ((ur) usVar).u >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? yChartMin : yChartMax;
        }
        return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }
}
