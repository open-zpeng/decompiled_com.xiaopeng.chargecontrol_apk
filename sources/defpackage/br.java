package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.jr;
import defpackage.mr;
import defpackage.nr;
import defpackage.qr;
import defpackage.ur;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: BarLineChartBase.java */
@SuppressLint({"RtlHardcoded"})
/* renamed from: br  reason: default package */
/* loaded from: classes.dex */
public abstract class br<T extends qr<? extends rs<? extends vr>>> extends cr<T> implements ns {
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Paint O;
    public Paint P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public float T;
    public boolean U;
    public nr V;
    public nr W;
    public qt a0;
    public qt b0;
    public xt c0;
    public xt d0;
    public ot e0;
    public long f0;
    public long g0;
    public RectF h0;
    public Matrix i0;
    public boolean j0;
    public ut k0;
    public ut l0;
    public float[] m0;

    public br(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = 100;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 15.0f;
        this.U = false;
        this.f0 = 0L;
        this.g0 = 0L;
        this.h0 = new RectF();
        this.i0 = new Matrix();
        new Matrix();
        this.j0 = false;
        this.k0 = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        this.l0 = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        this.m0 = new float[2];
    }

    public void A() {
        this.d0.a(this.W.L);
        this.c0.a(this.V.L);
    }

    public void B() {
        if (this.c) {
            StringBuilder a = jg.a("Preparing Value-Px Matrix, xmin: ");
            a.append(this.k.H);
            a.append(", xmax: ");
            a.append(this.k.G);
            a.append(", xdelta: ");
            a.append(this.k.I);
            Log.i("MPAndroidChart", a.toString());
        }
        xt xtVar = this.d0;
        mr mrVar = this.k;
        float f = mrVar.H;
        float f2 = mrVar.I;
        nr nrVar = this.W;
        xtVar.a(f, f2, nrVar.I, nrVar.H);
        xt xtVar2 = this.c0;
        mr mrVar2 = this.k;
        float f3 = mrVar2.H;
        float f4 = mrVar2.I;
        nr nrVar2 = this.V;
        xtVar2.a(f3, f4, nrVar2.I, nrVar2.H);
    }

    public void a(RectF rectF) {
        rectF.left = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        rectF.right = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        rectF.top = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        rectF.bottom = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        jr jrVar = this.n;
        if (jrVar == null || !jrVar.a || jrVar.m) {
            return;
        }
        int ordinal = jrVar.l.ordinal();
        if (ordinal == 0) {
            int ordinal2 = this.n.k.ordinal();
            if (ordinal2 == 0) {
                float f = rectF.top;
                jr jrVar2 = this.n;
                rectF.top = Math.min(jrVar2.y, this.t.d * jrVar2.w) + this.n.c + f;
            } else if (ordinal2 != 2) {
            } else {
                float f2 = rectF.bottom;
                jr jrVar3 = this.n;
                rectF.bottom = Math.min(jrVar3.y, this.t.d * jrVar3.w) + this.n.c + f2;
            }
        } else if (ordinal != 1) {
        } else {
            int ordinal3 = this.n.j.ordinal();
            if (ordinal3 == 0) {
                float f3 = rectF.left;
                jr jrVar4 = this.n;
                rectF.left = Math.min(jrVar4.x, this.t.c * jrVar4.w) + this.n.b + f3;
            } else if (ordinal3 != 1) {
                if (ordinal3 != 2) {
                    return;
                }
                float f4 = rectF.right;
                jr jrVar5 = this.n;
                rectF.right = Math.min(jrVar5.x, this.t.c * jrVar5.w) + this.n.b + f4;
            } else {
                int ordinal4 = this.n.k.ordinal();
                if (ordinal4 == 0) {
                    float f5 = rectF.top;
                    jr jrVar6 = this.n;
                    rectF.top = Math.min(jrVar6.y, this.t.d * jrVar6.w) + this.n.c + f5;
                } else if (ordinal4 != 2) {
                } else {
                    float f6 = rectF.bottom;
                    jr jrVar7 = this.n;
                    rectF.bottom = Math.min(jrVar7.y, this.t.d * jrVar7.w) + this.n.c + f6;
                }
            }
        }
    }

    public void b(float f, float f2, float f3, float f4) {
        this.t.a(f, f2, f3, -f4, this.i0);
        this.t.a(this.i0, this, false);
        d();
        postInvalidate();
    }

    public void c(Canvas canvas) {
        if (this.Q) {
            canvas.drawRect(this.t.b, this.O);
        }
        if (this.R) {
            canvas.drawRect(this.t.b, this.P);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        zs zsVar = this.o;
        if (zsVar instanceof ys) {
            ys ysVar = (ys) zsVar;
            vt vtVar = ysVar.s;
            float f = vtVar.b;
            float f2 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            if (f == XToggleDrawable.LIGHT_RADIUS_DEFAULT && vtVar.c == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            vt vtVar2 = ysVar.s;
            vtVar2.b = ((br) ysVar.g).getDragDecelerationFrictionCoef() * vtVar2.b;
            vt vtVar3 = ysVar.s;
            vtVar3.c = ((br) ysVar.g).getDragDecelerationFrictionCoef() * vtVar3.c;
            float f3 = ((float) (currentAnimationTimeMillis - ysVar.q)) / 1000.0f;
            vt vtVar4 = ysVar.s;
            float f4 = vtVar4.b * f3;
            float f5 = vtVar4.c * f3;
            vt vtVar5 = ysVar.r;
            vtVar5.b += f4;
            vtVar5.c += f5;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, vtVar5.b, vtVar5.c, 0);
            float f6 = ((br) ysVar.g).t() ? ysVar.r.b - ysVar.j.b : 0.0f;
            if (((br) ysVar.g).u()) {
                f2 = ysVar.r.c - ysVar.j.c;
            }
            ysVar.a(obtain, f6, f2);
            obtain.recycle();
            au viewPortHandler = ((br) ysVar.g).getViewPortHandler();
            Matrix matrix = ysVar.h;
            viewPortHandler.a(matrix, ysVar.g, false);
            ysVar.h = matrix;
            ysVar.q = currentAnimationTimeMillis;
            if (Math.abs(ysVar.s.b) < 0.01d && Math.abs(ysVar.s.c) < 0.01d) {
                ((br) ysVar.g).d();
                ((br) ysVar.g).postInvalidate();
                ysVar.b();
                return;
            }
            zt.a(ysVar.g);
        }
    }

    @Override // defpackage.cr
    public void d() {
        if (!this.j0) {
            a(this.h0);
            RectF rectF = this.h0;
            float f = rectF.left + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            float f2 = rectF.top + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            float f3 = rectF.right + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            float f4 = rectF.bottom + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            if (this.V.e()) {
                f += this.V.b(this.a0.e);
            }
            if (this.W.e()) {
                f3 += this.W.b(this.b0.e);
            }
            mr mrVar = this.k;
            if (mrVar.a && mrVar.v) {
                float f5 = mrVar.M + mrVar.c;
                mr.a aVar = mrVar.P;
                if (aVar == mr.a.BOTTOM) {
                    f4 += f5;
                } else {
                    if (aVar != mr.a.TOP) {
                        if (aVar == mr.a.BOTH_SIDED) {
                            f4 += f5;
                        }
                    }
                    f2 += f5;
                }
            }
            float extraTopOffset = getExtraTopOffset() + f2;
            float extraRightOffset = getExtraRightOffset() + f3;
            float extraBottomOffset = getExtraBottomOffset() + f4;
            float extraLeftOffset = getExtraLeftOffset() + f;
            float a = zt.a(this.T);
            this.t.a(Math.max(a, extraLeftOffset), Math.max(a, extraTopOffset), Math.max(a, extraRightOffset), Math.max(a, extraBottomOffset));
            if (this.c) {
                Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.t.b.toString());
                Log.i("MPAndroidChart", sb.toString());
            }
        }
        A();
        B();
    }

    @Override // defpackage.cr
    public void g() {
        super.g();
        this.V = new nr(nr.a.LEFT);
        this.W = new nr(nr.a.RIGHT);
        this.c0 = new xt(this.t);
        this.d0 = new xt(this.t);
        this.a0 = new qt(this.t, this.V, this.c0);
        this.b0 = new qt(this.t, this.W, this.d0);
        this.e0 = new ot(this.t, this.k, this.c0);
        setHighlighter(new hs(this));
        this.o = new ys(this, this.t.a, 3.0f);
        this.O = new Paint();
        this.O.setStyle(Paint.Style.FILL);
        this.O.setColor(Color.rgb(240, 240, 240));
        this.P = new Paint();
        this.P.setStyle(Paint.Style.STROKE);
        this.P.setColor(-16777216);
        this.P.setStrokeWidth(zt.a(1.0f));
    }

    public nr getAxisLeft() {
        return this.V;
    }

    public nr getAxisRight() {
        return this.W;
    }

    @Override // defpackage.cr, defpackage.os, defpackage.ns
    public /* bridge */ /* synthetic */ qr getData() {
        return (qr) super.getData();
    }

    public ct getDrawListener() {
        return null;
    }

    @Override // defpackage.ns
    public float getHighestVisibleX() {
        xt a = a(nr.a.LEFT);
        RectF rectF = this.t.b;
        a.a(rectF.right, rectF.bottom, this.l0);
        return (float) Math.min(this.k.G, this.l0.b);
    }

    @Override // defpackage.ns
    public float getLowestVisibleX() {
        xt a = a(nr.a.LEFT);
        RectF rectF = this.t.b;
        a.a(rectF.left, rectF.bottom, this.k0);
        return (float) Math.max(this.k.H, this.k0.b);
    }

    @Override // defpackage.os
    public int getMaxVisibleCount() {
        return this.F;
    }

    public float getMinOffset() {
        return this.T;
    }

    public qt getRendererLeftYAxis() {
        return this.a0;
    }

    public qt getRendererRightYAxis() {
        return this.b0;
    }

    public ot getRendererXAxis() {
        return this.e0;
    }

    @Override // android.view.View
    public float getScaleX() {
        au auVar = this.t;
        if (auVar == null) {
            return 1.0f;
        }
        return auVar.i;
    }

    @Override // android.view.View
    public float getScaleY() {
        au auVar = this.t;
        if (auVar == null) {
            return 1.0f;
        }
        return auVar.j;
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // defpackage.os
    public float getYChartMax() {
        return Math.max(this.V.G, this.W.G);
    }

    @Override // defpackage.os
    public float getYChartMin() {
        return Math.min(this.V.H, this.W.H);
    }

    @Override // defpackage.cr
    public void k() {
        Paint paint;
        float f;
        float f2;
        float f3;
        if (this.d == 0) {
            if (this.c) {
                Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.c) {
            Log.i("MPAndroidChart", "Preparing...");
        }
        ht htVar = this.r;
        if (htVar != null) {
            htVar.a();
        }
        n();
        qt qtVar = this.a0;
        nr nrVar = this.V;
        qtVar.a(nrVar.H, nrVar.G, nrVar.L);
        qt qtVar2 = this.b0;
        nr nrVar2 = this.W;
        qtVar2.a(nrVar2.H, nrVar2.G, nrVar2.L);
        ot otVar = this.e0;
        mr mrVar = this.k;
        int i = 0;
        otVar.a(mrVar.H, mrVar.G, false);
        if (this.n != null) {
            jt jtVar = this.q;
            tr trVar = this.d;
            if (!jtVar.d.i) {
                jtVar.e.clear();
                tr trVar2 = trVar;
                int i2 = 0;
                while (i2 < trVar.a()) {
                    ts a = trVar2.a(i2);
                    rr rrVar = (rr) a;
                    List<Integer> list = rrVar.a;
                    int n = ((ur) a).n();
                    if (a instanceof qs) {
                        qs qsVar = (qs) a;
                        if (qsVar.h()) {
                            String[] i3 = qsVar.i();
                            int i4 = i;
                            while (i4 < list.size() && i4 < qsVar.d()) {
                                jtVar.e.add(new kr(i3[i4 % i3.length], rrVar.j, rrVar.k, rrVar.l, rrVar.m, list.get(i4).intValue()));
                                i4++;
                                trVar2 = trVar2;
                            }
                            tr trVar3 = trVar2;
                            if (((rr) qsVar).e != null) {
                                jtVar.e.add(new kr(rrVar.e, jr.b.NONE, Float.NaN, Float.NaN, null, 1122867));
                            }
                            trVar2 = trVar3;
                            i2++;
                            i = 0;
                        }
                    }
                    if (a instanceof xs) {
                        xs xsVar = (xs) a;
                        for (int i5 = 0; i5 < list.size() && i5 < n; i5++) {
                            jtVar.e.add(new kr(((as) ((ur) xsVar).d(i5)).g, rrVar.j, rrVar.k, rrVar.l, rrVar.m, list.get(i5).intValue()));
                        }
                        if (((rr) xsVar).e != null) {
                            jtVar.e.add(new kr(rrVar.e, jr.b.NONE, Float.NaN, Float.NaN, null, 1122867));
                        }
                    } else {
                        if (a instanceof ss) {
                            ss ssVar = (ss) a;
                            if (ssVar.b() != 1122867) {
                                int b = ssVar.b();
                                int a2 = ssVar.a();
                                jtVar.e.add(new kr(null, rrVar.j, rrVar.k, rrVar.l, rrVar.m, b));
                                jtVar.e.add(new kr(rrVar.e, rrVar.j, rrVar.k, rrVar.l, rrVar.m, a2));
                            }
                        }
                        int i6 = 0;
                        while (i6 < list.size() && i6 < n) {
                            jtVar.e.add(new kr((i6 >= list.size() - 1 || i6 >= n + (-1)) ? ((rr) trVar.a(i2)).e : null, rrVar.j, rrVar.k, rrVar.l, rrVar.m, list.get(i6).intValue()));
                            i6++;
                        }
                    }
                    trVar2 = trVar;
                    i2++;
                    i = 0;
                }
                if (jtVar.d.a() != null) {
                    Collections.addAll(jtVar.e, jtVar.d.a());
                }
                jtVar.d.a(jtVar.e);
            }
            Typeface typeface = jtVar.d.d;
            if (typeface != null) {
                jtVar.b.setTypeface(typeface);
            }
            jtVar.b.setTextSize(jtVar.d.e);
            jtVar.b.setColor(jtVar.d.f);
            jr jrVar = jtVar.d;
            Paint paint2 = jtVar.b;
            au auVar = jtVar.a;
            float a3 = zt.a(jrVar.p);
            float a4 = zt.a(jrVar.v);
            float a5 = zt.a(jrVar.u);
            float a6 = zt.a(jrVar.s);
            float a7 = zt.a(jrVar.t);
            boolean z = jrVar.z;
            kr[] krVarArr = jrVar.g;
            int length = krVarArr.length;
            zt.a(jrVar.u);
            kr[] krVarArr2 = jrVar.g;
            int length2 = krVarArr2.length;
            int i7 = 0;
            float f4 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            float f5 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            while (i7 < length2) {
                kr krVar = krVarArr2[i7];
                float f6 = a3;
                float a8 = zt.a(Float.isNaN(krVar.c) ? jrVar.p : krVar.c);
                if (a8 > f4) {
                    f4 = a8;
                }
                String str = krVar.a;
                if (str != null) {
                    float measureText = (int) paint2.measureText(str);
                    if (measureText > f5) {
                        f5 = measureText;
                    }
                }
                i7++;
                a3 = f6;
            }
            float f7 = a3;
            kr[] krVarArr3 = jrVar.g;
            float f8 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            for (kr krVar2 : krVarArr3) {
                String str2 = krVar2.a;
                if (str2 != null) {
                    float a9 = zt.a(paint2, str2);
                    if (a9 > f8) {
                        f8 = a9;
                    }
                }
            }
            int ordinal = jrVar.l.ordinal();
            if (ordinal == 0) {
                float a10 = zt.a(paint2);
                float b2 = zt.b(paint2, zt.e) + a7;
                float a11 = auVar.a() * jrVar.w;
                jrVar.B.clear();
                jrVar.A.clear();
                jrVar.C.clear();
                int i8 = 0;
                float f9 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                int i9 = -1;
                float f10 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                float f11 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                while (i8 < length) {
                    kr krVar3 = krVarArr[i8];
                    float f12 = a6;
                    kr[] krVarArr4 = krVarArr;
                    boolean z2 = krVar3.b != jr.b.NONE;
                    float a12 = Float.isNaN(krVar3.c) ? f7 : zt.a(krVar3.c);
                    String str3 = krVar3.a;
                    float f13 = b2;
                    float f14 = f9;
                    jrVar.B.add(false);
                    float f15 = i9 == -1 ? XToggleDrawable.LIGHT_RADIUS_DEFAULT : f10 + a4;
                    if (str3 != null) {
                        jrVar.A.add(zt.b(paint2, str3));
                        f = f15 + (z2 ? a5 + a12 : XToggleDrawable.LIGHT_RADIUS_DEFAULT) + jrVar.A.get(i8).b;
                        paint = paint2;
                    } else {
                        paint = paint2;
                        jrVar.A.add(st.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT));
                        if (!z2) {
                            a12 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                        }
                        f = f15 + a12;
                        if (i9 == -1) {
                            i9 = i8;
                        }
                    }
                    f10 = f;
                    if (str3 != null || i8 == length - 1) {
                        float f16 = f11;
                        int i10 = (f16 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f16 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1));
                        float f17 = i10 == 0 ? 0.0f : f12;
                        if (!z || i10 == 0 || a11 - f16 >= f17 + f10) {
                            f2 = f14;
                            f3 = f16 + f17 + f10;
                        } else {
                            jrVar.C.add(st.a(f16, a10));
                            float max = Math.max(f14, f16);
                            jrVar.B.set(i9 > -1 ? i9 : i8, true);
                            f2 = max;
                            f3 = f10;
                        }
                        if (i8 == length - 1) {
                            jrVar.C.add(st.a(f3, a10));
                            f2 = Math.max(f2, f3);
                        }
                        f11 = f3;
                        f9 = f2;
                    } else {
                        f9 = f14;
                    }
                    if (str3 != null) {
                        i9 = -1;
                    }
                    i8++;
                    a6 = f12;
                    krVarArr = krVarArr4;
                    b2 = f13;
                    paint2 = paint;
                }
                float f18 = b2;
                jrVar.x = f9;
                jrVar.y = (f18 * (jrVar.C.size() == 0 ? 0 : jrVar.C.size() - 1)) + (a10 * jrVar.C.size());
            } else if (ordinal == 1) {
                float a13 = zt.a(paint2);
                float f19 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                float f20 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                boolean z3 = false;
                float f21 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                for (int i11 = 0; i11 < length; i11++) {
                    kr krVar4 = krVarArr[i11];
                    boolean z4 = krVar4.b != jr.b.NONE;
                    float a14 = Float.isNaN(krVar4.c) ? f7 : zt.a(krVar4.c);
                    String str4 = krVar4.a;
                    if (!z3) {
                        f21 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                    }
                    if (z4) {
                        if (z3) {
                            f21 += a4;
                        }
                        f21 += a14;
                    }
                    if (str4 != null) {
                        if (z4 && !z3) {
                            f21 += a5;
                        } else if (z3) {
                            f19 = Math.max(f19, f21);
                            f20 += a13 + a7;
                            z3 = false;
                            f21 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                        }
                        f21 += (int) paint2.measureText(str4);
                        if (i11 < length - 1) {
                            f20 = a13 + a7 + f20;
                        }
                    } else {
                        f21 += a14;
                        if (i11 < length - 1) {
                            f21 += a4;
                        }
                        z3 = true;
                    }
                    f19 = Math.max(f19, f21);
                }
                jrVar.x = f19;
                jrVar.y = f20;
            }
            jrVar.y += jrVar.c;
            jrVar.x += jrVar.b;
        }
        d();
    }

    public void m() {
        ts tsVar;
        ts tsVar2;
        float lowestVisibleX = getLowestVisibleX();
        float highestVisibleX = getHighestVisibleX();
        qr qrVar = (qr) this.d;
        for (T t : qrVar.i) {
            List<T> list = t.s;
            if (list != 0 && !list.isEmpty()) {
                t.t = -3.4028235E38f;
                t.u = Float.MAX_VALUE;
                int b = t.b(highestVisibleX, Float.NaN, ur.a.UP);
                for (int b2 = t.b(lowestVisibleX, Float.NaN, ur.a.DOWN); b2 <= b; b2++) {
                    t.a((ur) ((vr) t.s.get(b2)));
                }
            }
        }
        List<T> list2 = qrVar.i;
        if (list2 != 0) {
            qrVar.a = -3.4028235E38f;
            qrVar.b = Float.MAX_VALUE;
            qrVar.c = -3.4028235E38f;
            qrVar.d = Float.MAX_VALUE;
            for (T t2 : list2) {
                qrVar.b((qr) t2);
            }
            qrVar.e = -3.4028235E38f;
            qrVar.f = Float.MAX_VALUE;
            qrVar.g = -3.4028235E38f;
            qrVar.h = Float.MAX_VALUE;
            Iterator it = qrVar.i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    tsVar = null;
                    break;
                }
                tsVar = (ts) it.next();
                if (((rr) tsVar).f == nr.a.LEFT) {
                    break;
                }
            }
            if (tsVar != null) {
                ur urVar = (ur) tsVar;
                qrVar.e = urVar.t;
                qrVar.f = urVar.u;
                for (Object obj : qrVar.i) {
                    if (((rr) obj).f == nr.a.LEFT) {
                        ur urVar2 = (ur) obj;
                        float f = urVar2.u;
                        if (f < qrVar.f) {
                            qrVar.f = f;
                        }
                        float f2 = urVar2.t;
                        if (f2 > qrVar.e) {
                            qrVar.e = f2;
                        }
                    }
                }
            }
            Iterator it2 = qrVar.i.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    tsVar2 = null;
                    break;
                }
                tsVar2 = (ts) it2.next();
                if (((rr) tsVar2).f == nr.a.RIGHT) {
                    break;
                }
            }
            if (tsVar2 != null) {
                ur urVar3 = (ur) tsVar2;
                qrVar.g = urVar3.t;
                qrVar.h = urVar3.u;
                for (Object obj2 : qrVar.i) {
                    if (((rr) obj2).f == nr.a.RIGHT) {
                        ur urVar4 = (ur) obj2;
                        float f3 = urVar4.u;
                        if (f3 < qrVar.h) {
                            qrVar.h = f3;
                        }
                        float f4 = urVar4.t;
                        if (f4 > qrVar.g) {
                            qrVar.g = f4;
                        }
                    }
                }
            }
        }
        mr mrVar = this.k;
        T t3 = this.d;
        mrVar.a(((qr) t3).d, ((qr) t3).c);
        nr nrVar = this.V;
        if (nrVar.a) {
            nrVar.a(((qr) this.d).b(nr.a.LEFT), ((qr) this.d).a(nr.a.LEFT));
        }
        nr nrVar2 = this.W;
        if (nrVar2.a) {
            nrVar2.a(((qr) this.d).b(nr.a.RIGHT), ((qr) this.d).a(nr.a.RIGHT));
        }
        d();
    }

    public void n() {
        mr mrVar = this.k;
        T t = this.d;
        mrVar.a(((qr) t).d, ((qr) t).c);
        this.V.a(((qr) this.d).b(nr.a.LEFT), ((qr) this.d).a(nr.a.LEFT));
        this.W.a(((qr) this.d).b(nr.a.RIGHT), ((qr) this.d).a(nr.a.RIGHT));
    }

    public boolean o() {
        au auVar = this.t;
        return auVar.m <= XToggleDrawable.LIGHT_RADIUS_DEFAULT && auVar.n <= XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03a6  */
    @Override // defpackage.cr, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r35) {
        /*
            Method dump skipped, instructions count: 1335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.br.onDraw(android.graphics.Canvas):void");
    }

    @Override // defpackage.cr, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.m0;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.U) {
            RectF rectF = this.t.b;
            fArr[0] = rectF.left;
            fArr[1] = rectF.top;
            a(nr.a.LEFT).a(this.m0);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.U) {
            a(nr.a.LEFT).b(this.m0);
            au auVar = this.t;
            float[] fArr2 = this.m0;
            Matrix matrix = auVar.o;
            matrix.reset();
            matrix.set(auVar.a);
            float f = fArr2[0];
            RectF rectF2 = auVar.b;
            matrix.postTranslate(-(f - rectF2.left), -(fArr2[1] - rectF2.top));
            auVar.a(matrix, this, true);
            return;
        }
        au auVar2 = this.t;
        auVar2.a(auVar2.a, this, true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        zs zsVar = this.o;
        if (zsVar == null || this.d == 0 || !this.l) {
            return false;
        }
        return zsVar.onTouch(this, motionEvent);
    }

    public boolean p() {
        return this.V.L || this.W.L;
    }

    public boolean q() {
        return this.S;
    }

    public boolean r() {
        return this.I;
    }

    public boolean s() {
        return this.K || this.L;
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.G = z;
    }

    public void setBorderColor(int i) {
        this.P.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.P.setStrokeWidth(zt.a(f));
    }

    public void setClipValuesToContent(boolean z) {
        this.S = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.I = z;
    }

    public void setDragEnabled(boolean z) {
        this.K = z;
        this.L = z;
    }

    public void setDragOffsetX(float f) {
        this.t.g(f);
    }

    public void setDragOffsetY(float f) {
        this.t.h(f);
    }

    public void setDragXEnabled(boolean z) {
        this.K = z;
    }

    public void setDragYEnabled(boolean z) {
        this.L = z;
    }

    public void setDrawBorders(boolean z) {
        this.R = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.Q = z;
    }

    public void setGridBackgroundColor(int i) {
        this.O.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.J = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.U = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.F = i;
    }

    public void setMinOffset(float f) {
        this.T = f;
    }

    public void setOnDrawListener(ct ctVar) {
    }

    public void setPinchZoom(boolean z) {
        this.H = z;
    }

    public void setRendererLeftYAxis(qt qtVar) {
        this.a0 = qtVar;
    }

    public void setRendererRightYAxis(qt qtVar) {
        this.b0 = qtVar;
    }

    public void setScaleEnabled(boolean z) {
        this.M = z;
        this.N = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.M = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.N = z;
    }

    public void setVisibleXRangeMaximum(float f) {
        float f2 = this.k.I / f;
        au auVar = this.t;
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        auVar.g = f2;
        auVar.a(auVar.a, auVar.b);
    }

    public void setVisibleXRangeMinimum(float f) {
        float f2 = this.k.I / f;
        au auVar = this.t;
        if (f2 == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f2 = Float.MAX_VALUE;
        }
        auVar.h = f2;
        auVar.a(auVar.a, auVar.b);
    }

    public void setXAxisRenderer(ot otVar) {
        this.e0 = otVar;
    }

    public boolean t() {
        return this.K;
    }

    public boolean u() {
        return this.L;
    }

    public boolean v() {
        au auVar = this.t;
        return auVar.b() && auVar.c();
    }

    public boolean w() {
        return this.J;
    }

    public boolean x() {
        return this.H;
    }

    public boolean y() {
        return this.M;
    }

    public boolean z() {
        return this.N;
    }

    @Override // defpackage.ns
    public boolean b(nr.a aVar) {
        return c(aVar).L;
    }

    public rs c(float f, float f2) {
        is a = a(f, f2);
        if (a != null) {
            return (rs) ((qr) this.d).a(a.f);
        }
        return null;
    }

    public nr c(nr.a aVar) {
        if (aVar == nr.a.LEFT) {
            return this.V;
        }
        return this.W;
    }

    public br(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 100;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 15.0f;
        this.U = false;
        this.f0 = 0L;
        this.g0 = 0L;
        this.h0 = new RectF();
        this.i0 = new Matrix();
        new Matrix();
        this.j0 = false;
        this.k0 = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        this.l0 = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        this.m0 = new float[2];
    }

    public br(Context context) {
        super(context);
        this.F = 100;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 15.0f;
        this.U = false;
        this.f0 = 0L;
        this.g0 = 0L;
        this.h0 = new RectF();
        this.i0 = new Matrix();
        new Matrix();
        this.j0 = false;
        this.k0 = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        this.l0 = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        this.m0 = new float[2];
    }

    @Override // defpackage.ns
    public xt a(nr.a aVar) {
        if (aVar == nr.a.LEFT) {
            return this.c0;
        }
        return this.d0;
    }
}
