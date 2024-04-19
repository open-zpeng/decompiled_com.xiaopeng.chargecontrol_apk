package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.lr;
import defpackage.mr;
import java.util.List;
/* compiled from: XAxisRenderer.java */
/* renamed from: ot  reason: default package */
/* loaded from: classes.dex */
public class ot extends et {
    public mr h;
    public Path i;
    public float[] j;
    public RectF k;
    public float[] l;
    public RectF m;
    public float[] n;
    public Path o;

    public ot(au auVar, mr mrVar, xt xtVar) {
        super(auVar, xtVar, mrVar);
        this.i = new Path();
        this.j = new float[2];
        this.k = new RectF();
        this.l = new float[2];
        this.m = new RectF();
        this.n = new float[4];
        this.o = new Path();
        this.h = mrVar;
        this.e.setColor(-16777216);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(zt.a(10.0f));
    }

    @Override // defpackage.et
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.a.a() > 10.0f && !this.a.b()) {
            xt xtVar = this.c;
            RectF rectF = this.a.b;
            ut b = xtVar.b(rectF.left, rectF.top);
            xt xtVar2 = this.c;
            RectF rectF2 = this.a.b;
            ut b2 = xtVar2.b(rectF2.right, rectF2.top);
            if (z) {
                f3 = (float) b2.b;
                d = b.b;
            } else {
                f3 = (float) b.b;
                d = b2.b;
            }
            ut.d.a((wt<ut>) b);
            ut.d.a((wt<ut>) b2);
            f = f3;
            f2 = (float) d;
        }
        super.a(f, f2);
        a();
    }

    public void b(Canvas canvas) {
        mr mrVar = this.h;
        if (mrVar.u && mrVar.a) {
            this.f.setColor(mrVar.j);
            this.f.setStrokeWidth(this.h.k);
            this.f.setPathEffect(this.h.x);
            mr.a aVar = this.h.P;
            if (aVar == mr.a.TOP || aVar == mr.a.TOP_INSIDE || aVar == mr.a.BOTH_SIDED) {
                RectF rectF = this.a.b;
                float f = rectF.left;
                float f2 = rectF.top;
                canvas.drawLine(f, f2, rectF.right, f2, this.f);
            }
            mr.a aVar2 = this.h.P;
            if (aVar2 == mr.a.BOTTOM || aVar2 == mr.a.BOTTOM_INSIDE || aVar2 == mr.a.BOTH_SIDED) {
                RectF rectF2 = this.a.b;
                float f3 = rectF2.left;
                float f4 = rectF2.bottom;
                canvas.drawLine(f3, f4, rectF2.right, f4, this.f);
            }
        }
    }

    public void c(Canvas canvas) {
        mr mrVar = this.h;
        if (mrVar.t && mrVar.a) {
            int save = canvas.save();
            canvas.clipRect(b());
            if (this.j.length != this.b.n * 2) {
                this.j = new float[this.h.n * 2];
            }
            float[] fArr = this.j;
            for (int i = 0; i < fArr.length; i += 2) {
                float[] fArr2 = this.h.l;
                int i2 = i / 2;
                fArr[i] = fArr2[i2];
                fArr[i + 1] = fArr2[i2];
            }
            this.c.b(fArr);
            this.d.setColor(this.h.h);
            this.d.setStrokeWidth(this.h.i);
            this.d.setPathEffect(this.h.y);
            Path path = this.i;
            path.reset();
            for (int i3 = 0; i3 < fArr.length; i3 += 2) {
                a(canvas, fArr[i3], fArr[i3 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void d(Canvas canvas) {
        List<lr> list = this.h.z;
        if (list == null || list.size() <= 0) {
            return;
        }
        float[] fArr = this.l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            lr lrVar = list.get(i);
            if (lrVar.a) {
                int save = canvas.save();
                this.m.set(this.a.b);
                this.m.inset(-lrVar.h, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                canvas.clipRect(this.m);
                fArr[0] = lrVar.g;
                fArr[1] = 0.0f;
                this.c.b(fArr);
                float[] fArr2 = this.n;
                fArr2[0] = fArr[0];
                RectF rectF = this.a.b;
                fArr2[1] = rectF.top;
                fArr2[2] = fArr[0];
                fArr2[3] = rectF.bottom;
                this.o.reset();
                Path path = this.o;
                float[] fArr3 = this.n;
                path.moveTo(fArr3[0], fArr3[1]);
                Path path2 = this.o;
                float[] fArr4 = this.n;
                path2.lineTo(fArr4[2], fArr4[3]);
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setColor(lrVar.i);
                this.g.setStrokeWidth(lrVar.h);
                this.g.setPathEffect(lrVar.l);
                canvas.drawPath(this.o, this.g);
                float f = lrVar.c + 2.0f;
                String str = lrVar.k;
                if (str != null && !str.equals("")) {
                    this.g.setStyle(lrVar.j);
                    this.g.setPathEffect(null);
                    this.g.setColor(lrVar.f);
                    this.g.setStrokeWidth(0.5f);
                    this.g.setTextSize(lrVar.e);
                    float f2 = lrVar.h + lrVar.b;
                    lr.a aVar = lrVar.m;
                    if (aVar == lr.a.RIGHT_TOP) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, fArr[0] + f2, this.a.b.top + f + zt.a(this.g, str), this.g);
                    } else if (aVar == lr.a.RIGHT_BOTTOM) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, fArr[0] + f2, this.a.b.bottom - f, this.g);
                    } else if (aVar == lr.a.LEFT_TOP) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, fArr[0] - f2, this.a.b.top + f + zt.a(this.g, str), this.g);
                    } else {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, fArr[0] - f2, this.a.b.bottom - f, this.g);
                    }
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // defpackage.et
    public void a(float f, float f2) {
        super.a(f, f2);
        a();
    }

    public void a() {
        String b = this.h.b();
        this.e.setTypeface(this.h.d);
        this.e.setTextSize(this.h.e);
        st b2 = zt.b(this.e, b);
        float f = b2.b;
        float a = zt.a(this.e, "Q");
        st a2 = zt.a(f, a, this.h.N);
        this.h.J = Math.round(f);
        this.h.K = Math.round(a);
        this.h.L = Math.round(a2.b);
        this.h.M = Math.round(a2.c);
        st.d.a((wt<st>) a2);
        st.d.a((wt<st>) b2);
    }

    public RectF b() {
        this.k.set(this.a.b);
        this.k.inset(-this.b.i, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        return this.k;
    }

    public void a(Canvas canvas) {
        mr mrVar = this.h;
        if (mrVar.a && mrVar.v) {
            float f = mrVar.c;
            this.e.setTypeface(mrVar.d);
            this.e.setTextSize(this.h.e);
            this.e.setColor(this.h.f);
            vt a = vt.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            mr mrVar2 = this.h;
            mr.a aVar = mrVar2.P;
            if (aVar == mr.a.TOP) {
                a.b = 0.5f;
                a.c = 1.0f;
                a(canvas, this.a.b.top - f, a);
            } else if (aVar == mr.a.TOP_INSIDE) {
                a.b = 0.5f;
                a.c = 1.0f;
                a(canvas, this.a.b.top + f + mrVar2.M, a);
            } else if (aVar == mr.a.BOTTOM) {
                a.b = 0.5f;
                a.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                a(canvas, this.a.b.bottom + f, a);
            } else if (aVar == mr.a.BOTTOM_INSIDE) {
                a.b = 0.5f;
                a.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                a(canvas, (this.a.b.bottom - f) - mrVar2.M, a);
            } else {
                a.b = 0.5f;
                a.c = 1.0f;
                a(canvas, this.a.b.top - f, a);
                a.b = 0.5f;
                a.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                a(canvas, this.a.b.bottom + f, a);
            }
            vt.d.a((wt<vt>) a);
        }
    }

    public void a(Canvas canvas, float f, vt vtVar) {
        float f2;
        mr mrVar = this.h;
        float f3 = mrVar.N;
        boolean d = mrVar.d();
        float[] fArr = new float[this.h.n * 2];
        for (int i = 0; i < fArr.length; i += 2) {
            if (d) {
                fArr[i] = this.h.m[i / 2];
            } else {
                fArr[i] = this.h.l[i / 2];
            }
        }
        this.c.b(fArr);
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            float f4 = fArr[i2];
            if (this.a.e(f4)) {
                fs c = this.h.c();
                mr mrVar2 = this.h;
                int i3 = i2 / 2;
                String a = c.a(mrVar2.l[i3], mrVar2);
                mr mrVar3 = this.h;
                if (mrVar3.O) {
                    int i4 = mrVar3.n;
                    if (i3 == i4 - 1 && i4 > 1) {
                        float c2 = zt.c(this.e, a);
                        if (c2 > this.a.e() * 2.0f && f4 + c2 > this.a.c) {
                            f4 -= c2 / 2.0f;
                        }
                    } else if (i2 == 0) {
                        f2 = (zt.c(this.e, a) / 2.0f) + f4;
                        a(canvas, a, f2, f, vtVar, f3);
                    }
                }
                f2 = f4;
                a(canvas, a, f2, f, vtVar, f3);
            }
        }
    }

    public void a(Canvas canvas, String str, float f, float f2, vt vtVar, float f3) {
        Paint paint = this.e;
        float fontMetrics = paint.getFontMetrics(zt.j);
        paint.getTextBounds(str, 0, str.length(), zt.i);
        float f4 = XToggleDrawable.LIGHT_RADIUS_DEFAULT - zt.i.left;
        float f5 = (-zt.j.ascent) + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f3 != XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            float width = f4 - (zt.i.width() * 0.5f);
            float f6 = f5 - (fontMetrics * 0.5f);
            if (vtVar.b != 0.5f || vtVar.c != 0.5f) {
                st a = zt.a(zt.i.width(), fontMetrics, f3);
                f -= (vtVar.b - 0.5f) * a.b;
                f2 -= (vtVar.c - 0.5f) * a.c;
                st.d.a((wt<st>) a);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.drawText(str, width, f6, paint);
            canvas.restore();
        } else {
            if (vtVar.b != XToggleDrawable.LIGHT_RADIUS_DEFAULT || vtVar.c != XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                f4 -= zt.i.width() * vtVar.b;
                f5 -= fontMetrics * vtVar.c;
            }
            canvas.drawText(str, f4 + f, f5 + f2, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public void a(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(f, this.a.b.bottom);
        path.lineTo(f, this.a.b.top);
        canvas.drawPath(path, this.d);
        path.reset();
    }
}
