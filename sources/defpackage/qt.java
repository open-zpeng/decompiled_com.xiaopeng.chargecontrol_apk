package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.lr;
import defpackage.nr;
import java.util.List;
/* compiled from: YAxisRenderer.java */
/* renamed from: qt  reason: default package */
/* loaded from: classes.dex */
public class qt extends et {
    public nr h;
    public Paint i;
    public Path j;
    public RectF k;
    public float[] l;
    public Path m;
    public RectF n;
    public Path o;
    public float[] p;
    public RectF q;

    public qt(au auVar, nr nrVar, xt xtVar) {
        super(auVar, xtVar, nrVar);
        this.j = new Path();
        this.k = new RectF();
        this.l = new float[2];
        this.m = new Path();
        this.n = new RectF();
        this.o = new Path();
        this.p = new float[2];
        this.q = new RectF();
        this.h = nrVar;
        if (this.a != null) {
            this.e.setColor(-16777216);
            this.e.setTextSize(zt.a(10.0f));
            this.i = new Paint(1);
            this.i.setColor(-7829368);
            this.i.setStrokeWidth(1.0f);
            this.i.setStyle(Paint.Style.STROKE);
        }
    }

    public void a(Canvas canvas, float f, float[] fArr, float f2) {
        nr nrVar = this.h;
        boolean z = nrVar.K;
        int i = nrVar.n;
        if (!z) {
            i--;
        }
        for (int i2 = !nrVar.J ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(this.h.a(i2), f, fArr[(i2 * 2) + 1] + f2, this.e);
        }
    }

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
            float f4 = this.h.b;
            nr nrVar2 = this.h;
            float a = (zt.a(this.e, "A") / 2.5f) + nrVar2.c;
            nr.a aVar = nrVar2.S;
            nr.b bVar = nrVar2.R;
            if (aVar == nr.a.LEFT) {
                if (bVar == nr.b.OUTSIDE_CHART) {
                    this.e.setTextAlign(Paint.Align.RIGHT);
                    f = this.a.b.left;
                    f3 = f - f4;
                } else {
                    this.e.setTextAlign(Paint.Align.LEFT);
                    f2 = this.a.b.left;
                    f3 = f2 + f4;
                }
            } else if (bVar == nr.b.OUTSIDE_CHART) {
                this.e.setTextAlign(Paint.Align.LEFT);
                f2 = this.a.b.right;
                f3 = f2 + f4;
            } else {
                this.e.setTextAlign(Paint.Align.RIGHT);
                f = this.a.b.right;
                f3 = f - f4;
            }
            a(canvas, f3, b, a);
        }
    }

    public void c(Canvas canvas) {
        nr nrVar = this.h;
        if (nrVar.a && nrVar.u) {
            this.f.setColor(nrVar.j);
            this.f.setStrokeWidth(this.h.k);
            if (this.h.S == nr.a.LEFT) {
                RectF rectF = this.a.b;
                float f = rectF.left;
                canvas.drawLine(f, rectF.top, f, rectF.bottom, this.f);
                return;
            }
            RectF rectF2 = this.a.b;
            float f2 = rectF2.right;
            canvas.drawLine(f2, rectF2.top, f2, rectF2.bottom, this.f);
        }
    }

    public void d(Canvas canvas) {
        nr nrVar = this.h;
        if (nrVar.a) {
            if (nrVar.t) {
                int save = canvas.save();
                canvas.clipRect(a());
                float[] b = b();
                this.d.setColor(this.h.h);
                this.d.setStrokeWidth(this.h.i);
                this.d.setPathEffect(this.h.y);
                Path path = this.j;
                path.reset();
                for (int i = 0; i < b.length; i += 2) {
                    canvas.drawPath(a(path, i, b), this.d);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.h.M) {
                a(canvas);
            }
        }
    }

    public void e(Canvas canvas) {
        List<lr> list = this.h.z;
        if (list == null || list.size() <= 0) {
            return;
        }
        float[] fArr = this.p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.o;
        path.reset();
        for (int i = 0; i < list.size(); i++) {
            lr lrVar = list.get(i);
            if (lrVar.a) {
                int save = canvas.save();
                this.q.set(this.a.b);
                this.q.inset(XToggleDrawable.LIGHT_RADIUS_DEFAULT, -lrVar.h);
                canvas.clipRect(this.q);
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
                    this.g.setTypeface(lrVar.d);
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

    public RectF a() {
        this.k.set(this.a.b);
        this.k.inset(XToggleDrawable.LIGHT_RADIUS_DEFAULT, -this.b.i);
        return this.k;
    }

    public Path a(Path path, int i, float[] fArr) {
        int i2 = i + 1;
        path.moveTo(this.a.b.left, fArr[i2]);
        path.lineTo(this.a.b.right, fArr[i2]);
        return path;
    }

    public void a(Canvas canvas) {
        int save = canvas.save();
        this.n.set(this.a.b);
        this.n.inset(XToggleDrawable.LIGHT_RADIUS_DEFAULT, -this.h.O);
        canvas.clipRect(this.n);
        ut a = this.c.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.i.setColor(this.h.N);
        this.i.setStrokeWidth(this.h.O);
        Path path = this.m;
        path.reset();
        path.moveTo(this.a.b.left, (float) a.c);
        path.lineTo(this.a.b.right, (float) a.c);
        canvas.drawPath(path, this.i);
        canvas.restoreToCount(save);
    }

    public float[] b() {
        int length = this.l.length;
        int i = this.h.n;
        if (length != i * 2) {
            this.l = new float[i * 2];
        }
        float[] fArr = this.l;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2 + 1] = this.h.l[i2 / 2];
        }
        this.c.b(fArr);
        return fArr;
    }
}
