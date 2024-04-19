package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.lr;
import defpackage.nr;
import java.util.List;
/* compiled from: YAxisRendererHorizontalBarChart.java */
/* renamed from: rt  reason: default package */
/* loaded from: classes.dex */
public class rt extends qt {
    public Path r;
    public Path s;
    public float[] t;

    public rt(au auVar, nr nrVar, xt xtVar) {
        super(auVar, nrVar, xtVar);
        this.r = new Path();
        this.s = new Path();
        this.t = new float[4];
        this.g.setTextAlign(Paint.Align.LEFT);
    }

    @Override // defpackage.et
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.a.b.height() > 10.0f && !this.a.b()) {
            xt xtVar = this.c;
            RectF rectF = this.a.b;
            ut b = xtVar.b(rectF.left, rectF.top);
            xt xtVar2 = this.c;
            RectF rectF2 = this.a.b;
            ut b2 = xtVar2.b(rectF2.right, rectF2.top);
            if (!z) {
                f3 = (float) b.b;
                d = b2.b;
            } else {
                f3 = (float) b2.b;
                d = b.b;
            }
            ut.d.a((wt<ut>) b);
            ut.d.a((wt<ut>) b2);
            f = f3;
            f2 = (float) d;
        }
        a(f, f2);
    }

    @Override // defpackage.qt
    public void b(Canvas canvas) {
        float f;
        float f2;
        float f3;
        nr nrVar = this.h;
        if (nrVar.a && nrVar.v) {
            float[] b = b();
            this.e.setTypeface(this.h.d);
            this.e.setTextSize(this.h.e);
            this.e.setColor(this.h.f);
            this.e.setTextAlign(Paint.Align.CENTER);
            float a = zt.a(2.5f);
            float a2 = zt.a(this.e, "Q");
            nr nrVar2 = this.h;
            nr.a aVar = nrVar2.S;
            nr.b bVar = nrVar2.R;
            if (aVar == nr.a.LEFT) {
                if (bVar == nr.b.OUTSIDE_CHART) {
                    f3 = this.a.b.top;
                } else {
                    f3 = this.a.b.top;
                }
                f2 = f3 - a;
            } else {
                if (bVar == nr.b.OUTSIDE_CHART) {
                    f = this.a.b.bottom;
                } else {
                    f = this.a.b.bottom;
                }
                f2 = f + a2 + a;
            }
            a(canvas, f2, b, this.h.c);
        }
    }

    @Override // defpackage.qt
    public void c(Canvas canvas) {
        nr nrVar = this.h;
        if (nrVar.a && nrVar.u) {
            this.f.setColor(nrVar.j);
            this.f.setStrokeWidth(this.h.k);
            if (this.h.S == nr.a.LEFT) {
                RectF rectF = this.a.b;
                float f = rectF.left;
                float f2 = rectF.top;
                canvas.drawLine(f, f2, rectF.right, f2, this.f);
                return;
            }
            RectF rectF2 = this.a.b;
            float f3 = rectF2.left;
            float f4 = rectF2.bottom;
            canvas.drawLine(f3, f4, rectF2.right, f4, this.f);
        }
    }

    @Override // defpackage.qt
    public void e(Canvas canvas) {
        List<lr> list = this.h.z;
        if (list == null || list.size() <= 0) {
            return;
        }
        float[] fArr = this.t;
        float f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        fArr[0] = 0.0f;
        char c = 1;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.s;
        path.reset();
        int i = 0;
        while (i < list.size()) {
            lr lrVar = list.get(i);
            if (lrVar.a) {
                int save = canvas.save();
                this.q.set(this.a.b);
                this.q.inset(-lrVar.h, f);
                canvas.clipRect(this.q);
                float f2 = lrVar.g;
                fArr[0] = f2;
                fArr[2] = f2;
                this.c.b(fArr);
                RectF rectF = this.a.b;
                fArr[c] = rectF.top;
                fArr[3] = rectF.bottom;
                path.moveTo(fArr[0], fArr[c]);
                path.lineTo(fArr[2], fArr[3]);
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setColor(lrVar.i);
                this.g.setPathEffect(lrVar.l);
                this.g.setStrokeWidth(lrVar.h);
                canvas.drawPath(path, this.g);
                path.reset();
                String str = lrVar.k;
                if (str != null && !str.equals("")) {
                    this.g.setStyle(lrVar.j);
                    this.g.setPathEffect(null);
                    this.g.setColor(lrVar.f);
                    this.g.setTypeface(lrVar.d);
                    this.g.setStrokeWidth(0.5f);
                    this.g.setTextSize(lrVar.e);
                    float f3 = lrVar.h + lrVar.b;
                    float a = zt.a(2.0f) + lrVar.c;
                    lr.a aVar = lrVar.m;
                    if (aVar == lr.a.RIGHT_TOP) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, fArr[0] + f3, this.a.b.top + a + zt.a(this.g, str), this.g);
                    } else if (aVar == lr.a.RIGHT_BOTTOM) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, fArr[0] + f3, this.a.b.bottom - a, this.g);
                    } else if (aVar == lr.a.LEFT_TOP) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, fArr[0] - f3, this.a.b.top + a + zt.a(this.g, str), this.g);
                    } else {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, fArr[0] - f3, this.a.b.bottom - a, this.g);
                    }
                }
                canvas.restoreToCount(save);
            }
            i++;
            f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            c = 1;
        }
    }

    @Override // defpackage.qt
    public void a(Canvas canvas, float f, float[] fArr, float f2) {
        this.e.setTypeface(this.h.d);
        this.e.setTextSize(this.h.e);
        this.e.setColor(this.h.f);
        nr nrVar = this.h;
        boolean z = nrVar.K;
        int i = nrVar.n;
        if (!z) {
            i--;
        }
        for (int i2 = !nrVar.J ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(this.h.a(i2), fArr[i2 * 2], f - f2, this.e);
        }
    }

    @Override // defpackage.qt
    public RectF a() {
        this.k.set(this.a.b);
        this.k.inset(-this.b.i, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        return this.k;
    }

    @Override // defpackage.qt
    public float[] b() {
        int length = this.l.length;
        int i = this.h.n;
        if (length != i * 2) {
            this.l = new float[i * 2];
        }
        float[] fArr = this.l;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2] = this.h.l[i2 / 2];
        }
        this.c.b(fArr);
        return fArr;
    }

    @Override // defpackage.qt
    public Path a(Path path, int i, float[] fArr) {
        path.moveTo(fArr[i], this.a.b.top);
        path.lineTo(fArr[i], this.a.b.bottom);
        return path;
    }

    @Override // defpackage.qt
    public void a(Canvas canvas) {
        int save = canvas.save();
        this.n.set(this.a.b);
        this.n.inset(-this.h.O, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        canvas.clipRect(this.q);
        ut a = this.c.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.i.setColor(this.h.N);
        this.i.setStrokeWidth(this.h.O);
        Path path = this.r;
        path.reset();
        path.moveTo(((float) a.b) - 1.0f, this.a.b.top);
        path.lineTo(((float) a.b) - 1.0f, this.a.b.bottom);
        canvas.drawPath(path, this.i);
        canvas.restoreToCount(save);
    }
}
