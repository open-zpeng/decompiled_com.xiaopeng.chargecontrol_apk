package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.List;
/* compiled from: BarChartRenderer.java */
/* renamed from: ft  reason: default package */
/* loaded from: classes.dex */
public class ft extends gt {
    public ms g;
    public RectF h;
    public yq[] i;
    public Paint j;
    public Paint k;
    public RectF l;

    public ft(ms msVar, xq xqVar, au auVar) {
        super(xqVar, auVar);
        this.h = new RectF();
        this.l = new RectF();
        this.g = msVar;
        this.d = new Paint(1);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(Color.rgb(0, 0, 0));
        this.d.setAlpha(120);
        this.j = new Paint(1);
        this.j.setStyle(Paint.Style.FILL);
        this.k = new Paint(1);
        this.k.setStyle(Paint.Style.STROKE);
    }

    @Override // defpackage.ht
    public void a() {
        or barData = this.g.getBarData();
        this.i = new yq[barData.a()];
        for (int i = 0; i < this.i.length; i++) {
            qs qsVar = (qs) barData.a(i);
            this.i[i] = new yq(((ur) qsVar).n() * 4 * (qsVar.h() ? qsVar.d() : 1), barData.a(), qsVar.h());
        }
    }

    @Override // defpackage.ht
    public void b(Canvas canvas) {
    }

    @Override // defpackage.ht
    public void c(Canvas canvas) {
        List list;
        float f;
        boolean z;
        int i;
        vt vtVar;
        float f2;
        qs qsVar;
        float f3;
        float[] fArr;
        int i2;
        float[] fArr2;
        float f4;
        float f5;
        float f6;
        pr prVar;
        vt vtVar2;
        int i3;
        List list2;
        float f7;
        int i4;
        vt vtVar3;
        fs fsVar;
        yq yqVar;
        boolean z2;
        float f8;
        pr prVar2;
        float f9;
        if (a(this.g)) {
            List list3 = this.g.getBarData().i;
            float a = zt.a(4.5f);
            boolean b = this.g.b();
            int i5 = 0;
            while (i5 < this.g.getBarData().a()) {
                qs qsVar2 = (qs) list3.get(i5);
                if (b(qsVar2)) {
                    a(qsVar2);
                    rr rrVar = (rr) qsVar2;
                    boolean b2 = this.g.b(rrVar.f);
                    float a2 = zt.a(this.e, "8");
                    float f10 = b ? -a : a2 + a;
                    float f11 = b ? a2 + a : -a;
                    if (b2) {
                        f10 = (-f10) - a2;
                        f11 = (-f11) - a2;
                    }
                    float f12 = f10;
                    float f13 = f11;
                    yq yqVar2 = this.i[i5];
                    float f14 = this.b.a;
                    fs k = rrVar.k();
                    vt a3 = vt.a(rrVar.p);
                    a3.b = zt.a(a3.b);
                    a3.c = zt.a(a3.c);
                    if (qsVar2.h()) {
                        list = list3;
                        f = a;
                        z = b;
                        i = i5;
                        vtVar = a3;
                        xt a4 = this.g.a(rrVar.f);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            ur urVar = (ur) qsVar2;
                            if (i6 >= urVar.n() * this.b.b) {
                                break;
                            }
                            pr prVar3 = (pr) urVar.d(i6);
                            float[] fArr3 = prVar3.g;
                            float[] fArr4 = yqVar2.b;
                            float f15 = (fArr4[i7] + fArr4[i7 + 2]) / 2.0f;
                            int b3 = rrVar.b(i6);
                            if (fArr3 == null) {
                                if (!this.a.c(f15)) {
                                    break;
                                }
                                int i8 = i7 + 1;
                                if (this.a.f(yqVar2.b[i8]) && this.a.b(f15)) {
                                    if (rrVar.n) {
                                        String a5 = k.a(prVar3);
                                        float f16 = yqVar2.b[i8];
                                        float f17 = prVar3.c >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f12 : f13;
                                        f6 = f15;
                                        qsVar = qsVar2;
                                        fArr = fArr3;
                                        f2 = f14;
                                        f3 = f12;
                                        prVar = prVar3;
                                        a(canvas, a5, f6, f16 + f17, b3);
                                    } else {
                                        f6 = f15;
                                        f2 = f14;
                                        qsVar = qsVar2;
                                        f3 = f12;
                                        fArr = fArr3;
                                        prVar = prVar3;
                                    }
                                    Drawable drawable = prVar.e;
                                    if (drawable != null && rrVar.o) {
                                        zt.a(canvas, drawable, (int) (vtVar.b + f6), (int) (yqVar2.b[i8] + (prVar.c >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f3 : f13) + vtVar.c), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                    }
                                } else {
                                    f2 = f14;
                                    qsVar = qsVar2;
                                    f3 = f12;
                                    qsVar2 = qsVar;
                                    f12 = f3;
                                    f14 = f2;
                                }
                            } else {
                                f2 = f14;
                                qsVar = qsVar2;
                                f3 = f12;
                                fArr = fArr3;
                                float f18 = f15;
                                float[] fArr5 = new float[fArr.length * 2];
                                float f19 = -prVar3.i;
                                float f20 = 0.0f;
                                int i9 = 0;
                                int i10 = 0;
                                while (i9 < fArr5.length) {
                                    float f21 = fArr[i10];
                                    int i11 = (f21 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f21 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1));
                                    if (i11 != 0 || (f20 != XToggleDrawable.LIGHT_RADIUS_DEFAULT && f19 != XToggleDrawable.LIGHT_RADIUS_DEFAULT)) {
                                        if (i11 >= 0) {
                                            f21 = f20 + f21;
                                            f20 = f21;
                                        } else {
                                            float f22 = f19;
                                            f19 -= f21;
                                            f21 = f22;
                                        }
                                    }
                                    fArr5[i9 + 1] = f21 * f2;
                                    i9 += 2;
                                    i10++;
                                }
                                a4.b(fArr5);
                                int i12 = 0;
                                while (i12 < fArr5.length) {
                                    float f23 = fArr[i12 / 2];
                                    float f24 = fArr5[i12 + 1] + (((f23 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f23 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1)) == 0 && (f19 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f19 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1)) == 0 && (f20 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f20 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1)) > 0) || (f23 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f23 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1)) < 0 ? f13 : f3);
                                    if (!this.a.c(f18)) {
                                        break;
                                    }
                                    if (this.a.f(f24) && this.a.b(f18)) {
                                        if (rrVar.n) {
                                            f5 = f24;
                                            i2 = i12;
                                            fArr2 = fArr5;
                                            f4 = f18;
                                            a(canvas, k.a(f23), f18, f5, b3);
                                        } else {
                                            f5 = f24;
                                            i2 = i12;
                                            fArr2 = fArr5;
                                            f4 = f18;
                                        }
                                        Drawable drawable2 = prVar3.e;
                                        if (drawable2 != null && rrVar.o) {
                                            zt.a(canvas, drawable2, (int) (f4 + vtVar.b), (int) (f5 + vtVar.c), drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = i12;
                                        fArr2 = fArr5;
                                        f4 = f18;
                                    }
                                    i12 = i2 + 2;
                                    fArr5 = fArr2;
                                    f18 = f4;
                                }
                            }
                            i7 = fArr == null ? i7 + 4 : (fArr.length * 4) + i7;
                            i6++;
                            qsVar2 = qsVar;
                            f12 = f3;
                            f14 = f2;
                        }
                    } else {
                        int i13 = 0;
                        while (true) {
                            float[] fArr6 = yqVar2.b;
                            vtVar2 = a3;
                            if (i13 >= fArr6.length * this.b.b) {
                                break;
                            }
                            float f25 = (fArr6[i13] + fArr6[i13 + 2]) / 2.0f;
                            if (!this.a.c(f25)) {
                                break;
                            }
                            int i14 = i13 + 1;
                            if (this.a.f(yqVar2.b[i14]) && this.a.b(f25)) {
                                int i15 = i13 / 4;
                                pr prVar4 = (pr) ((ur) qsVar2).d(i15);
                                float f26 = prVar4.c;
                                list2 = list3;
                                if (rrVar.n) {
                                    String a6 = k.a(prVar4);
                                    if (f26 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                                        f8 = f26;
                                        f9 = yqVar2.b[i14] + f12;
                                    } else {
                                        f8 = f26;
                                        f9 = yqVar2.b[i13 + 3] + f13;
                                    }
                                    f7 = a;
                                    vtVar3 = vtVar2;
                                    z2 = b;
                                    prVar2 = prVar4;
                                    fsVar = k;
                                    i3 = i13;
                                    i4 = i5;
                                    yqVar = yqVar2;
                                    a(canvas, a6, f25, f9, rrVar.b(i15));
                                } else {
                                    f8 = f26;
                                    fsVar = k;
                                    i3 = i13;
                                    f7 = a;
                                    i4 = i5;
                                    vtVar3 = vtVar2;
                                    yqVar = yqVar2;
                                    z2 = b;
                                    prVar2 = prVar4;
                                }
                                Drawable drawable3 = prVar2.e;
                                if (drawable3 != null && rrVar.o) {
                                    zt.a(canvas, drawable3, (int) (f25 + vtVar3.b), (int) ((f8 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? yqVar.b[i14] + f12 : yqVar.b[i3 + 3] + f13) + vtVar3.c), drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
                                }
                            } else {
                                i3 = i13;
                                list2 = list3;
                                f7 = a;
                                i4 = i5;
                                vtVar3 = vtVar2;
                                fsVar = k;
                                yqVar = yqVar2;
                                z2 = b;
                            }
                            i13 = i3 + 4;
                            k = fsVar;
                            a3 = vtVar3;
                            yqVar2 = yqVar;
                            b = z2;
                            list3 = list2;
                            i5 = i4;
                            a = f7;
                        }
                        list = list3;
                        f = a;
                        i = i5;
                        vtVar = vtVar2;
                        z = b;
                    }
                    vt.d.a((wt<vt>) vtVar);
                } else {
                    list = list3;
                    f = a;
                    z = b;
                    i = i5;
                }
                i5 = i + 1;
                b = z;
                list3 = list;
                a = f;
            }
        }
    }

    @Override // defpackage.ht
    public void a(Canvas canvas) {
        or barData = this.g.getBarData();
        for (int i = 0; i < barData.a(); i++) {
            qs qsVar = (qs) barData.a(i);
            if (((rr) qsVar).r) {
                a(canvas, qsVar, i);
            }
        }
    }

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
                RectF rectF = this.l;
                rectF.left = f4 - f3;
                rectF.right = f4 + f3;
                a.a.mapRect(rectF);
                a.c.a.mapRect(rectF);
                a.b.mapRect(rectF);
                if (this.a.b(this.l.right)) {
                    if (!this.a.c(this.l.left)) {
                        break;
                    }
                    RectF rectF2 = this.l;
                    RectF rectF3 = this.a.b;
                    rectF2.top = rectF3.top;
                    rectF2.bottom = rectF3.bottom;
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
            int i4 = i2 + 2;
            if (this.a.b(fArr[i4])) {
                if (!this.a.c(yqVar.b[i2])) {
                    return;
                }
                if (!z2) {
                    this.c.setColor(rrVar.a(i2 / 4));
                }
                dt dtVar = rrVar.b;
                if (dtVar != null) {
                    Paint paint = this.c;
                    float[] fArr2 = yqVar.b;
                    paint.setShader(new LinearGradient(fArr2[i2], fArr2[i2 + 3], fArr2[i2], fArr2[i2 + 1], dtVar.a, dtVar.b, Shader.TileMode.MIRROR));
                }
                List<dt> list = rrVar.c;
                if (list != null) {
                    Paint paint2 = this.c;
                    float[] fArr3 = yqVar.b;
                    float f5 = fArr3[i2];
                    float f6 = fArr3[i2 + 3];
                    float f7 = fArr3[i2];
                    float f8 = fArr3[i2 + 1];
                    int i5 = i2 / 4;
                    int i6 = list.get(i5 % list.size()).a;
                    List<dt> list2 = rrVar.c;
                    paint2.setShader(new LinearGradient(f5, f6, f7, f8, i6, list2.get(i5 % list2.size()).b, Shader.TileMode.MIRROR));
                }
                float[] fArr4 = yqVar.b;
                int i7 = i2 + 1;
                int i8 = i2 + 3;
                canvas.drawRect(fArr4[i2], fArr4[i7], fArr4[i4], fArr4[i8], this.c);
                if (z) {
                    float[] fArr5 = yqVar.b;
                    canvas.drawRect(fArr5[i2], fArr5[i7], fArr5[i4], fArr5[i8], this.k);
                }
            }
            i2 += 4;
        }
    }

    public void a(float f, float f2, float f3, float f4, xt xtVar) {
        this.h.set(f - f4, f2, f + f4, f3);
        xtVar.a(this.h, this.b.a);
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.e.setColor(i);
        canvas.drawText(str, f, f2, this.e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        if ((r2.g != null) != false) goto L15;
     */
    @Override // defpackage.ht
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.graphics.Canvas r15, defpackage.is[] r16) {
        /*
            r14 = this;
            r6 = r14
            r7 = r16
            ms r0 = r6.g
            or r8 = r0.getBarData()
            int r9 = r7.length
            r10 = 0
            r11 = r10
        Lc:
            if (r11 >= r9) goto La2
            r12 = r7[r11]
            int r0 = r12.f
            ts r0 = r8.a(r0)
            qs r0 = (defpackage.qs) r0
            if (r0 == 0) goto L9d
            r1 = r0
            rr r1 = (defpackage.rr) r1
            boolean r2 = r1.g
            if (r2 != 0) goto L23
            goto L9d
        L23:
            float r2 = r12.a
            float r3 = r12.b
            r4 = r0
            ur r4 = (defpackage.ur) r4
            vr r2 = r4.a(r2, r3)
            pr r2 = (defpackage.pr) r2
            boolean r3 = r14.a(r2, r0)
            if (r3 != 0) goto L38
            goto L9d
        L38:
            ms r3 = r6.g
            nr$a r1 = r1.f
            xt r5 = r3.a(r1)
            android.graphics.Paint r1 = r6.d
            r3 = r0
            zr r3 = (defpackage.zr) r3
            int r3 = r3.x
            r1.setColor(r3)
            android.graphics.Paint r1 = r6.d
            int r0 = r0.f()
            r1.setAlpha(r0)
            int r0 = r12.g
            r1 = 1
            if (r0 < 0) goto L62
            float[] r0 = r2.g
            if (r0 == 0) goto L5e
            r0 = r1
            goto L5f
        L5e:
            r0 = r10
        L5f:
            if (r0 == 0) goto L62
            goto L63
        L62:
            r1 = r10
        L63:
            if (r1 == 0) goto L7b
            ms r0 = r6.g
            boolean r0 = r0.c()
            if (r0 == 0) goto L73
            float r0 = r2.j
            float r1 = r2.i
            float r1 = -r1
            goto L7e
        L73:
            ls[] r0 = r2.h
            int r1 = r12.g
            r0 = r0[r1]
            r0 = 0
            throw r0
        L7b:
            float r0 = r2.c
            r1 = 0
        L7e:
            r3 = r0
            r4 = r1
            float r1 = r2.f
            float r0 = r8.j
            r2 = 1073741824(0x40000000, float:2.0)
            float r13 = r0 / r2
            r0 = r14
            r2 = r3
            r3 = r4
            r4 = r13
            r0.a(r1, r2, r3, r4, r5)
            android.graphics.RectF r0 = r6.h
            r14.a(r12, r0)
            android.graphics.RectF r0 = r6.h
            android.graphics.Paint r1 = r6.d
            r2 = r15
            r15.drawRect(r0, r1)
            goto L9e
        L9d:
            r2 = r15
        L9e:
            int r11 = r11 + 1
            goto Lc
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ft.a(android.graphics.Canvas, is[]):void");
    }

    public void a(is isVar, RectF rectF) {
        float centerX = rectF.centerX();
        float f = rectF.top;
        isVar.i = centerX;
        isVar.j = f;
    }
}
