package defpackage;

import android.graphics.Paint;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: YAxis.java */
/* renamed from: nr  reason: default package */
/* loaded from: classes.dex */
public class nr extends fr {
    public a S;
    public boolean J = true;
    public boolean K = true;
    public boolean L = false;
    public boolean M = false;
    public int N = -7829368;
    public float O = 1.0f;
    public float P = 10.0f;
    public float Q = 10.0f;
    public b R = b.OUTSIDE_CHART;
    public float T = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float U = Float.POSITIVE_INFINITY;

    /* compiled from: YAxis.java */
    /* renamed from: nr$a */
    /* loaded from: classes.dex */
    public enum a {
        LEFT,
        RIGHT
    }

    /* compiled from: YAxis.java */
    /* renamed from: nr$b */
    /* loaded from: classes.dex */
    public enum b {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public nr(a aVar) {
        this.S = aVar;
        this.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    public float a(Paint paint) {
        paint.setTextSize(this.e);
        return (this.c * 2.0f) + zt.a(paint, b());
    }

    public float b(Paint paint) {
        paint.setTextSize(this.e);
        float c = (this.b * 2.0f) + zt.c(paint, b());
        float f = this.T;
        float f2 = this.U;
        if (f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f = zt.a(f);
        }
        if (f2 > XToggleDrawable.LIGHT_RADIUS_DEFAULT && f2 != Float.POSITIVE_INFINITY) {
            f2 = zt.a(f2);
        }
        if (f2 <= XLoadingDrawable.DEFAULT_RADIANS) {
            f2 = c;
        }
        return Math.max(f, Math.min(c, f2));
    }

    public boolean e() {
        return this.a && this.v && this.R == b.OUTSIDE_CHART;
    }

    @Override // defpackage.fr
    public void a(float f, float f2) {
        if (Math.abs(f2 - f) == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        float abs = Math.abs(f2 - f);
        this.H = this.E ? this.H : f - ((abs / 100.0f) * this.Q);
        this.G = this.F ? this.G : ((abs / 100.0f) * this.P) + f2;
        this.I = Math.abs(this.H - this.G);
    }
}
