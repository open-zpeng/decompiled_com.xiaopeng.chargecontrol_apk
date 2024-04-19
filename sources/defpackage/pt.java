package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.lr;
import defpackage.mr;
import java.util.List;
/* compiled from: XAxisRendererHorizontalBarChart.java */
/* renamed from: pt  reason: default package */
/* loaded from: classes.dex */
public class pt extends ot {
    public Path p;

    public pt(au auVar, mr mrVar, xt xtVar, ar arVar) {
        super(auVar, mrVar, xtVar);
        this.p = new Path();
    }

    @Override // defpackage.ot, defpackage.et
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.a.a() > 10.0f && !this.a.c()) {
            xt xtVar = this.c;
            RectF rectF = this.a.b;
            ut b = xtVar.b(rectF.left, rectF.bottom);
            xt xtVar2 = this.c;
            RectF rectF2 = this.a.b;
            ut b2 = xtVar2.b(rectF2.left, rectF2.top);
            if (z) {
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

    @Override // defpackage.ot
    public RectF b() {
        this.k.set(this.a.b);
        this.k.inset(XToggleDrawable.LIGHT_RADIUS_DEFAULT, -this.b.i);
        return this.k;
    }

    @Override // defpackage.ot
    public void d(Canvas canvas) {
        List<lr> list = this.h.z;
        if (list == null || list.size() <= 0) {
            return;
        }
        float[] fArr = this.l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.p;
        path.reset();
        for (int i = 0; i < list.size(); i++) {
            lr lrVar = list.get(i);
            if (lrVar.a) {
                int save = canvas.save();
                this.m.set(this.a.b);
                this.m.inset(XToggleDrawable.LIGHT_RADIUS_DEFAULT, -lrVar.h);
                canvas.clipRect(this.m);
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setColor(lrVar.i);
                this.g.setStrokeWidth(lrVar.h);
                this.g.setPathEffect(lrVar.l);
                fArr[1] = lrVar.g;
                this.c.b(fArr);
                path.moveTo(this.a.b.left, fArr[1]);
                path.lineTo(this.a.b.right, fArr[1]);
                canvas.drawPath(path, this.g);
                path.reset();
                String str = lrVar.k;
                if (str != null && !str.equals("")) {
                    this.g.setStyle(lrVar.j);
                    this.g.setPathEffect(null);
                    this.g.setColor(lrVar.f);
                    this.g.setStrokeWidth(0.5f);
                    this.g.setTextSize(lrVar.e);
                    float a = zt.a(this.g, str);
                    float a2 = zt.a(4.0f) + lrVar.b;
                    float f = lrVar.h + a + lrVar.c;
                    lr.a aVar = lrVar.m;
                    if (aVar == lr.a.RIGHT_TOP) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, this.a.b.right - a2, (fArr[1] - f) + a, this.g);
                    } else if (aVar == lr.a.RIGHT_BOTTOM) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, this.a.b.right - a2, fArr[1] + f, this.g);
                    } else if (aVar == lr.a.LEFT_TOP) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, this.a.b.left + a2, (fArr[1] - f) + a, this.g);
                    } else {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, this.a.b.left + a2, fArr[1] + f, this.g);
                    }
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // defpackage.ot
    public void b(Canvas canvas) {
        mr mrVar = this.h;
        if (mrVar.u && mrVar.a) {
            this.f.setColor(mrVar.j);
            this.f.setStrokeWidth(this.h.k);
            mr.a aVar = this.h.P;
            if (aVar == mr.a.TOP || aVar == mr.a.TOP_INSIDE || aVar == mr.a.BOTH_SIDED) {
                RectF rectF = this.a.b;
                float f = rectF.right;
                canvas.drawLine(f, rectF.top, f, rectF.bottom, this.f);
            }
            mr.a aVar2 = this.h.P;
            if (aVar2 == mr.a.BOTTOM || aVar2 == mr.a.BOTTOM_INSIDE || aVar2 == mr.a.BOTH_SIDED) {
                RectF rectF2 = this.a.b;
                float f2 = rectF2.left;
                canvas.drawLine(f2, rectF2.top, f2, rectF2.bottom, this.f);
            }
        }
    }

    @Override // defpackage.ot
    public void a() {
        this.e.setTypeface(this.h.d);
        this.e.setTextSize(this.h.e);
        st b = zt.b(this.e, this.h.b());
        float f = b.b;
        mr mrVar = this.h;
        float f2 = b.c;
        st a = zt.a(f, f2, mrVar.N);
        this.h.J = Math.round((int) ((mrVar.b * 3.5f) + f));
        this.h.K = Math.round(f2);
        mr mrVar2 = this.h;
        mrVar2.L = (int) ((mrVar2.b * 3.5f) + a.b);
        mrVar2.M = Math.round(a.c);
        st.d.a((wt<st>) a);
    }

    @Override // defpackage.ot
    public void a(Canvas canvas) {
        mr mrVar = this.h;
        if (mrVar.a && mrVar.v) {
            float f = mrVar.b;
            this.e.setTypeface(mrVar.d);
            this.e.setTextSize(this.h.e);
            this.e.setColor(this.h.f);
            vt a = vt.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            mr.a aVar = this.h.P;
            if (aVar == mr.a.TOP) {
                a.b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                a.c = 0.5f;
                a(canvas, this.a.b.right + f, a);
            } else if (aVar == mr.a.TOP_INSIDE) {
                a.b = 1.0f;
                a.c = 0.5f;
                a(canvas, this.a.b.right - f, a);
            } else if (aVar == mr.a.BOTTOM) {
                a.b = 1.0f;
                a.c = 0.5f;
                a(canvas, this.a.b.left - f, a);
            } else if (aVar == mr.a.BOTTOM_INSIDE) {
                a.b = 1.0f;
                a.c = 0.5f;
                a(canvas, this.a.b.left + f, a);
            } else {
                a.b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                a.c = 0.5f;
                a(canvas, this.a.b.right + f, a);
                a.b = 1.0f;
                a.c = 0.5f;
                a(canvas, this.a.b.left - f, a);
            }
            vt.d.a((wt<vt>) a);
        }
    }

    @Override // defpackage.ot
    public void a(Canvas canvas, float f, vt vtVar) {
        mr mrVar = this.h;
        float f2 = mrVar.N;
        boolean d = mrVar.d();
        float[] fArr = new float[this.h.n * 2];
        for (int i = 0; i < fArr.length; i += 2) {
            if (d) {
                fArr[i + 1] = this.h.m[i / 2];
            } else {
                fArr[i + 1] = this.h.l[i / 2];
            }
        }
        this.c.b(fArr);
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            float f3 = fArr[i2 + 1];
            if (this.a.f(f3)) {
                fs c = this.h.c();
                mr mrVar2 = this.h;
                a(canvas, c.a(mrVar2.l[i2 / 2], mrVar2), f, f3, vtVar, f2);
            }
        }
    }

    @Override // defpackage.ot
    public void a(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(this.a.b.right, f2);
        path.lineTo(this.a.b.left, f2);
        canvas.drawPath(path, this.d);
        path.reset();
    }
}
