package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.List;
/* compiled from: HorizontalBarChartRenderer.java */
/* renamed from: it  reason: default package */
/* loaded from: classes.dex */
public class it extends ft {
    public RectF m;

    public it(ms msVar, xq xqVar, au auVar) {
        super(msVar, xqVar, auVar);
        this.m = new RectF();
        this.e.setTextAlign(Paint.Align.LEFT);
    }

    @Override // defpackage.ft, defpackage.ht
    public void a() {
        or barData = this.g.getBarData();
        this.i = new zq[barData.a()];
        for (int i = 0; i < this.i.length; i++) {
            qs qsVar = (qs) barData.a(i);
            this.i[i] = new zq(((ur) qsVar).n() * 4 * (qsVar.h() ? qsVar.d() : 1), barData.a(), qsVar.h());
        }
    }

    @Override // defpackage.ft, defpackage.ht
    public void c(Canvas canvas) {
        List list;
        boolean z;
        int i;
        vt vtVar;
        float f;
        qs qsVar;
        float[] fArr;
        xt xtVar;
        fs fsVar;
        int i2;
        int i3;
        float[] fArr2;
        int i4;
        pr prVar;
        float f2;
        float f3;
        yq yqVar;
        fs fsVar2;
        boolean z2;
        int i5;
        boolean z3;
        vt vtVar2;
        int i6;
        float f4;
        float f5;
        if (a(this.g)) {
            List list2 = this.g.getBarData().i;
            float a = zt.a(5.0f);
            boolean b = this.g.b();
            int i7 = 0;
            while (i7 < this.g.getBarData().a()) {
                qs qsVar2 = (qs) list2.get(i7);
                if (b(qsVar2)) {
                    rr rrVar = (rr) qsVar2;
                    boolean b2 = this.g.b(rrVar.f);
                    a(qsVar2);
                    float a2 = zt.a(this.e, "10") / 2.0f;
                    fs k = rrVar.k();
                    yq yqVar2 = this.i[i7];
                    float f6 = this.b.a;
                    vt a3 = vt.a(rrVar.p);
                    a3.b = zt.a(a3.b);
                    a3.c = zt.a(a3.c);
                    if (qsVar2.h()) {
                        fs fsVar3 = k;
                        list = list2;
                        z = b;
                        i = i7;
                        vtVar = a3;
                        xt a4 = this.g.a(rrVar.f);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            ur urVar = (ur) qsVar2;
                            if (i8 >= urVar.n() * this.b.b) {
                                break;
                            }
                            pr prVar2 = (pr) urVar.d(i8);
                            int b3 = rrVar.b(i8);
                            float[] fArr3 = prVar2.g;
                            if (fArr3 == null) {
                                int i10 = i9 + 1;
                                if (!this.a.d(yqVar2.b[i10])) {
                                    break;
                                } else if (this.a.e(yqVar2.b[i9]) && this.a.a(yqVar2.b[i10])) {
                                    String a5 = fsVar3.a(prVar2);
                                    float c = zt.c(this.e, a5);
                                    float f7 = z ? a : -(c + a);
                                    float f8 = f6;
                                    float f9 = z ? -(c + a) : a;
                                    if (b2) {
                                        f7 = (-f7) - c;
                                        f9 = (-f9) - c;
                                    }
                                    if (rrVar.n) {
                                        float f10 = yqVar2.b[i9 + 2];
                                        f2 = f7;
                                        float f11 = prVar2.c >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f2 : f9;
                                        f3 = f9;
                                        this.e.setColor(b3);
                                        canvas.drawText(a5, f10 + f11, yqVar2.b[i10] + a2, this.e);
                                    } else {
                                        f2 = f7;
                                        f3 = f9;
                                    }
                                    Drawable drawable = prVar2.e;
                                    if (drawable == null || !rrVar.o) {
                                        qsVar = qsVar2;
                                        fArr = fArr3;
                                        f = f8;
                                    } else {
                                        float f12 = yqVar2.b[i9 + 2];
                                        if (prVar2.c < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                                            f2 = f3;
                                        }
                                        qsVar = qsVar2;
                                        fArr = fArr3;
                                        f = f8;
                                        zt.a(canvas, drawable, (int) (f12 + f2 + vtVar.b), (int) (yqVar2.b[i10] + vtVar.c), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                f = f6;
                                qsVar = qsVar2;
                                fArr = fArr3;
                                float[] fArr4 = new float[fArr.length * 2];
                                float f13 = -prVar2.i;
                                float f14 = 0.0f;
                                int i11 = 0;
                                int i12 = 0;
                                while (i11 < fArr4.length) {
                                    float f15 = fArr[i12];
                                    int i13 = (f15 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f15 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1));
                                    if (i13 != 0 || (f14 != XToggleDrawable.LIGHT_RADIUS_DEFAULT && f13 != XToggleDrawable.LIGHT_RADIUS_DEFAULT)) {
                                        if (i13 >= 0) {
                                            f15 = f14 + f15;
                                            f14 = f15;
                                        } else {
                                            float f16 = f13;
                                            f13 -= f15;
                                            f15 = f16;
                                        }
                                    }
                                    fArr4[i11] = f15 * f;
                                    i11 += 2;
                                    i12++;
                                }
                                a4.b(fArr4);
                                int i14 = 0;
                                while (i14 < fArr4.length) {
                                    float f17 = fArr[i14 / 2];
                                    String a6 = fsVar3.a(f17);
                                    xtVar = a4;
                                    float c2 = zt.c(this.e, a6);
                                    fsVar = fsVar3;
                                    float f18 = z ? a : -(c2 + a);
                                    i2 = i8;
                                    float f19 = z ? -(c2 + a) : a;
                                    if (b2) {
                                        f18 = (-f18) - c2;
                                        f19 = (-f19) - c2;
                                    }
                                    boolean z4 = (f17 == XToggleDrawable.LIGHT_RADIUS_DEFAULT && f13 == XToggleDrawable.LIGHT_RADIUS_DEFAULT && f14 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) || f17 < XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                                    float f20 = fArr4[i14];
                                    if (z4) {
                                        f18 = f19;
                                    }
                                    float f21 = f20 + f18;
                                    float[] fArr5 = yqVar2.b;
                                    float f22 = (fArr5[i9 + 1] + fArr5[i9 + 3]) / 2.0f;
                                    if (!this.a.d(f22)) {
                                        break;
                                    }
                                    if (this.a.e(f21) && this.a.a(f22)) {
                                        if (rrVar.n) {
                                            this.e.setColor(b3);
                                            canvas.drawText(a6, f21, f22 + a2, this.e);
                                        }
                                        Drawable drawable2 = prVar2.e;
                                        if (drawable2 != null && rrVar.o) {
                                            i3 = i14;
                                            fArr2 = fArr4;
                                            i4 = b3;
                                            prVar = prVar2;
                                            zt.a(canvas, drawable2, (int) (f21 + vtVar.b), (int) (f22 + vtVar.c), drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                            i14 = i3 + 2;
                                            fArr4 = fArr2;
                                            b3 = i4;
                                            prVar2 = prVar;
                                            a4 = xtVar;
                                            fsVar3 = fsVar;
                                            i8 = i2;
                                        }
                                    }
                                    i3 = i14;
                                    fArr2 = fArr4;
                                    i4 = b3;
                                    prVar = prVar2;
                                    i14 = i3 + 2;
                                    fArr4 = fArr2;
                                    b3 = i4;
                                    prVar2 = prVar;
                                    a4 = xtVar;
                                    fsVar3 = fsVar;
                                    i8 = i2;
                                }
                            }
                            xtVar = a4;
                            fsVar = fsVar3;
                            i2 = i8;
                            i9 = fArr == null ? i9 + 4 : (fArr.length * 4) + i9;
                            i8 = i2 + 1;
                            f6 = f;
                            qsVar2 = qsVar;
                            a4 = xtVar;
                            fsVar3 = fsVar;
                        }
                    } else {
                        int i15 = 0;
                        while (true) {
                            float[] fArr6 = yqVar2.b;
                            list = list2;
                            if (i15 >= fArr6.length * this.b.b) {
                                break;
                            }
                            int i16 = i15 + 1;
                            float f23 = (fArr6[i16] + fArr6[i15 + 3]) / 2.0f;
                            if (!this.a.d(fArr6[i16])) {
                                break;
                            }
                            if (this.a.e(yqVar2.b[i15]) && this.a.a(yqVar2.b[i16])) {
                                pr prVar3 = (pr) ((ur) qsVar2).d(i15 / 4);
                                float f24 = prVar3.c;
                                String a7 = k.a(prVar3);
                                fs fsVar4 = k;
                                float c3 = zt.c(this.e, a7);
                                i5 = i7;
                                float f25 = b ? a : -(c3 + a);
                                z2 = b;
                                float f26 = b ? -(c3 + a) : a;
                                if (b2) {
                                    f25 = (-f25) - c3;
                                    f26 = (-f26) - c3;
                                }
                                if (rrVar.n) {
                                    float f27 = yqVar2.b[i15 + 2] + (f24 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f25 : f26);
                                    f4 = f26;
                                    f5 = f25;
                                    z3 = b2;
                                    this.e.setColor(rrVar.b(i15 / 2));
                                    canvas.drawText(a7, f27, f23 + a2, this.e);
                                } else {
                                    f4 = f26;
                                    f5 = f25;
                                    z3 = b2;
                                }
                                Drawable drawable3 = prVar3.e;
                                if (drawable3 == null || !rrVar.o) {
                                    vtVar2 = a3;
                                    i6 = i15;
                                    yqVar = yqVar2;
                                    fsVar2 = fsVar4;
                                } else {
                                    float f28 = yqVar2.b[i15 + 2];
                                    if (f24 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                                        f4 = f5;
                                    }
                                    vtVar2 = a3;
                                    i6 = i15;
                                    yqVar = yqVar2;
                                    fsVar2 = fsVar4;
                                    zt.a(canvas, drawable3, (int) (f28 + f4 + a3.b), (int) (f23 + a3.c), drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
                                }
                            } else {
                                yqVar = yqVar2;
                                fsVar2 = k;
                                z2 = b;
                                i5 = i7;
                                z3 = b2;
                                vtVar2 = a3;
                                i6 = i15;
                            }
                            i15 = i6 + 4;
                            yqVar2 = yqVar;
                            k = fsVar2;
                            a3 = vtVar2;
                            list2 = list;
                            i7 = i5;
                            b = z2;
                            b2 = z3;
                        }
                        vtVar = a3;
                        z = b;
                        i = i7;
                    }
                    vt.d.a((wt<vt>) vtVar);
                } else {
                    list = list2;
                    z = b;
                    i = i7;
                }
                i7 = i + 1;
                list2 = list;
                b = z;
            }
        }
    }

    @Override // defpackage.ft
    public void a(Canvas canvas, qs qsVar, int i) {
        xt a = this.g.a(((rr) qsVar).f);
        this.k.setColor(qsVar.e());
        this.k.setStrokeWidth(zt.a(qsVar.g()));
        int i2 = 0;
        boolean z = qsVar.g() > XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        xq xqVar = this.b;
        float f = xqVar.b;
        float f2 = xqVar.a;
        if (this.g.a()) {
            this.j.setColor(qsVar.c());
            float f3 = this.g.getBarData().j / 2.0f;
            ur urVar = (ur) qsVar;
            int min = Math.min((int) Math.ceil(urVar.n() * f), urVar.n());
            for (int i3 = 0; i3 < min; i3++) {
                float f4 = ((pr) urVar.d(i3)).f;
                RectF rectF = this.m;
                rectF.top = f4 - f3;
                rectF.bottom = f4 + f3;
                a.a.mapRect(rectF);
                a.c.a.mapRect(rectF);
                a.b.mapRect(rectF);
                if (this.a.d(this.m.bottom)) {
                    if (!this.a.a(this.m.top)) {
                        break;
                    }
                    RectF rectF2 = this.m;
                    RectF rectF3 = this.a.b;
                    rectF2.left = rectF3.left;
                    rectF2.right = rectF3.right;
                    canvas.drawRect(rectF2, this.j);
                }
            }
        }
        yq yqVar = this.i[i];
        yqVar.c = f;
        yqVar.d = f2;
        rr rrVar = (rr) qsVar;
        yqVar.f = this.g.b(rrVar.f);
        yqVar.g = this.g.getBarData().j;
        yqVar.a(qsVar);
        a.b(yqVar.b);
        boolean z2 = rrVar.a.size() == 1;
        if (z2) {
            this.c.setColor(rrVar.j());
        }
        while (true) {
            float[] fArr = yqVar.b;
            if (i2 >= fArr.length) {
                return;
            }
            int i4 = i2 + 3;
            if (!this.a.d(fArr[i4])) {
                return;
            }
            int i5 = i2 + 1;
            if (this.a.a(yqVar.b[i5])) {
                if (!z2) {
                    this.c.setColor(rrVar.a(i2 / 4));
                }
                float[] fArr2 = yqVar.b;
                int i6 = i2 + 2;
                canvas.drawRect(fArr2[i2], fArr2[i5], fArr2[i6], fArr2[i4], this.c);
                if (z) {
                    float[] fArr3 = yqVar.b;
                    canvas.drawRect(fArr3[i2], fArr3[i5], fArr3[i6], fArr3[i4], this.k);
                }
            }
            i2 += 4;
        }
    }

    @Override // defpackage.ft
    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.e.setColor(i);
        canvas.drawText(str, f, f2, this.e);
    }

    @Override // defpackage.ft
    public void a(float f, float f2, float f3, float f4, xt xtVar) {
        this.h.set(f2, f - f4, f3, f + f4);
        xtVar.b(this.h, this.b.a);
    }

    @Override // defpackage.ft
    public void a(is isVar, RectF rectF) {
        float centerY = rectF.centerY();
        float f = rectF.right;
        isVar.i = centerY;
        isVar.j = f;
    }

    @Override // defpackage.ht
    public boolean a(os osVar) {
        return ((float) osVar.getData().b()) < this.a.j * ((float) osVar.getMaxVisibleCount());
    }
}
