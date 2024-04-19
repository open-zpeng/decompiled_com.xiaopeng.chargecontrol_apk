package defpackage;

import android.graphics.Paint;
import android.graphics.RectF;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
/* compiled from: AxisRenderer.java */
/* renamed from: et  reason: default package */
/* loaded from: classes.dex */
public abstract class et extends nt {
    public fr b;
    public xt c;
    public Paint d;
    public Paint e;
    public Paint f;
    public Paint g;

    public et(au auVar, xt xtVar, fr frVar) {
        super(auVar);
        this.c = xtVar;
        this.b = frVar;
        if (this.a != null) {
            this.e = new Paint(1);
            this.d = new Paint();
            this.d.setColor(-7829368);
            this.d.setStrokeWidth(1.0f);
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setAlpha(90);
            this.f = new Paint();
            this.f.setColor(-16777216);
            this.f.setStrokeWidth(1.0f);
            this.f.setStyle(Paint.Style.STROKE);
            this.g = new Paint(1);
            this.g.setStyle(Paint.Style.STROKE);
        }
    }

    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        au auVar = this.a;
        if (auVar != null && auVar.a() > 10.0f && !this.a.c()) {
            xt xtVar = this.c;
            RectF rectF = this.a.b;
            ut b = xtVar.b(rectF.left, rectF.top);
            xt xtVar2 = this.c;
            RectF rectF2 = this.a.b;
            ut b2 = xtVar2.b(rectF2.left, rectF2.bottom);
            if (!z) {
                f3 = (float) b2.c;
                d = b.c;
            } else {
                f3 = (float) b.c;
                d = b2.c;
            }
            ut.d.a((wt<ut>) b);
            ut.d.a((wt<ut>) b2);
            f = f3;
            f2 = (float) d;
        }
        a(f, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(float f, float f2) {
        double floor;
        int i = this.b.p;
        double abs = Math.abs(f2 - f);
        if (i != 0 && abs > XLoadingDrawable.DEFAULT_RADIANS && !Double.isInfinite(abs)) {
            double a = zt.a(abs / i);
            fr frVar = this.b;
            if (frVar.r) {
                float f3 = frVar.q;
                if (a < f3) {
                    a = f3;
                }
            }
            double a2 = zt.a(Math.pow(10.0d, (int) Math.log10(a)));
            if (((int) (a / a2)) > 5) {
                a = Math.floor(a2 * 10.0d);
            }
            ?? d = this.b.d();
            fr frVar2 = this.b;
            if (frVar2.s) {
                a = ((float) abs) / (i - 1);
                frVar2.n = i;
                if (frVar2.l.length < i) {
                    frVar2.l = new float[i];
                }
                float f4 = f;
                for (int i2 = 0; i2 < i; i2++) {
                    this.b.l[i2] = f4;
                    f4 = (float) (f4 + a);
                }
            } else {
                int i3 = (a > XLoadingDrawable.DEFAULT_RADIANS ? 1 : (a == XLoadingDrawable.DEFAULT_RADIANS ? 0 : -1));
                double ceil = i3 == 0 ? XLoadingDrawable.DEFAULT_RADIANS : Math.ceil(f / a) * a;
                if (this.b.d()) {
                    ceil -= a;
                }
                if (i3 == 0) {
                    floor = XLoadingDrawable.DEFAULT_RADIANS;
                } else {
                    floor = Math.floor(f2 / a) * a;
                    if (floor != Double.POSITIVE_INFINITY) {
                        double d2 = floor + XLoadingDrawable.DEFAULT_RADIANS;
                        floor = Double.longBitsToDouble(Double.doubleToRawLongBits(d2) + (d2 >= XLoadingDrawable.DEFAULT_RADIANS ? 1L : -1L));
                    }
                }
                if (i3 != 0) {
                    double d3 = ceil;
                    d = d;
                    while (d3 <= floor) {
                        d3 += a;
                        d++;
                    }
                }
                i = d;
                fr frVar3 = this.b;
                frVar3.n = i;
                if (frVar3.l.length < i) {
                    frVar3.l = new float[i];
                }
                for (int i4 = 0; i4 < i; i4++) {
                    if (ceil == XLoadingDrawable.DEFAULT_RADIANS) {
                        ceil = 0.0d;
                    }
                    this.b.l[i4] = (float) ceil;
                    ceil += a;
                }
            }
            if (a < 1.0d) {
                this.b.o = (int) Math.ceil(-Math.log10(a));
            } else {
                this.b.o = 0;
            }
            if (this.b.d()) {
                fr frVar4 = this.b;
                if (frVar4.m.length < i) {
                    frVar4.m = new float[i];
                }
                float f5 = ((float) a) / 2.0f;
                for (int i5 = 0; i5 < i; i5++) {
                    fr frVar5 = this.b;
                    frVar5.m[i5] = frVar5.l[i5] + f5;
                }
                return;
            }
            return;
        }
        fr frVar6 = this.b;
        frVar6.l = new float[0];
        frVar6.m = new float[0];
        frVar6.n = 0;
    }
}
