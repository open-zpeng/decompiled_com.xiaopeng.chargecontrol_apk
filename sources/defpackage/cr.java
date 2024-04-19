package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.tr;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: Chart.java */
/* renamed from: cr  reason: default package */
/* loaded from: classes.dex */
public abstract class cr<T extends tr<? extends ts<? extends vr>>> extends ViewGroup implements os {
    public is[] A;
    public float B;
    public boolean C;
    public ArrayList<Runnable> D;
    public boolean E;
    public boolean c;
    public T d;
    public boolean e;
    public boolean f;
    public float g;
    public ds h;
    public Paint i;
    public Paint j;
    public mr k;
    public boolean l;
    public hr m;
    public jr n;
    public zs o;
    public String p;
    public jt q;
    public ht r;
    public ks s;
    public au t;
    public xq u;
    public float v;
    public float w;
    public float x;
    public float y;
    public boolean z;

    /* compiled from: Chart.java */
    /* renamed from: cr$a */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            cr.this.postInvalidate();
        }
    }

    public cr(Context context) {
        super(context);
        this.c = false;
        this.d = null;
        this.e = true;
        this.f = true;
        this.g = 0.9f;
        this.h = new ds(0);
        this.l = true;
        this.p = "No chart data available.";
        this.t = new au();
        this.v = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.w = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.x = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.y = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.z = false;
        this.B = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.C = true;
        this.D = new ArrayList<>();
        this.E = false;
        g();
    }

    public void a(Canvas canvas) {
        float f;
        float f2;
        hr hrVar = this.m;
        if (hrVar == null || !hrVar.a) {
            return;
        }
        vt vtVar = hrVar.h;
        this.i.setTypeface(hrVar.d);
        this.i.setTextSize(this.m.e);
        this.i.setColor(this.m.f);
        this.i.setTextAlign(this.m.i);
        if (vtVar == null) {
            f = (getWidth() - this.t.e()) - this.m.b;
            f2 = (getHeight() - this.t.d()) - this.m.c;
        } else {
            f = vtVar.b;
            f2 = vtVar.c;
        }
        canvas.drawText(this.m.g, f, f2, this.i);
    }

    public void b(float f, float f2) {
        float max;
        T t = this.d;
        if (t != null && t.b() >= 2) {
            max = Math.abs(f2 - f);
        } else {
            max = Math.max(Math.abs(f), Math.abs(f2));
        }
        float a2 = zt.a(max);
        this.h.a(Float.isInfinite(a2) ? 0 : ((int) Math.ceil(-Math.log10(a2))) + 2);
    }

    public void b(Canvas canvas) {
    }

    public abstract void d();

    public void e() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void f() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public void g() {
        setWillNotDraw(false);
        this.u = new xq(new a());
        zt.a(getContext());
        this.B = zt.a(500.0f);
        this.m = new hr();
        this.n = new jr();
        this.q = new jt(this.t, this.n);
        this.k = new mr();
        this.i = new Paint(1);
        this.j = new Paint(1);
        this.j.setColor(Color.rgb(247, 189, 51));
        this.j.setTextAlign(Paint.Align.CENTER);
        this.j.setTextSize(zt.a(12.0f));
        if (this.c) {
            Log.i("", "Chart.init()");
        }
    }

    public xq getAnimator() {
        return this.u;
    }

    public vt getCenter() {
        return vt.a(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public vt getCenterOfView() {
        return getCenter();
    }

    public vt getCenterOffsets() {
        au auVar = this.t;
        return vt.a(auVar.b.centerX(), auVar.b.centerY());
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.t.b;
    }

    public T getData() {
        return this.d;
    }

    public fs getDefaultValueFormatter() {
        return this.h;
    }

    public hr getDescription() {
        return this.m;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.g;
    }

    public float getExtraBottomOffset() {
        return this.x;
    }

    public float getExtraLeftOffset() {
        return this.y;
    }

    public float getExtraRightOffset() {
        return this.w;
    }

    public float getExtraTopOffset() {
        return this.v;
    }

    public is[] getHighlighted() {
        return this.A;
    }

    public ks getHighlighter() {
        return this.s;
    }

    public ArrayList<Runnable> getJobs() {
        return this.D;
    }

    public jr getLegend() {
        return this.n;
    }

    public jt getLegendRenderer() {
        return this.q;
    }

    public ir getMarker() {
        return null;
    }

    @Deprecated
    public ir getMarkerView() {
        return getMarker();
    }

    @Override // defpackage.os
    public float getMaxHighlightDistance() {
        return this.B;
    }

    public at getOnChartGestureListener() {
        return null;
    }

    public zs getOnTouchListener() {
        return this.o;
    }

    public ht getRenderer() {
        return this.r;
    }

    public au getViewPortHandler() {
        return this.t;
    }

    public mr getXAxis() {
        return this.k;
    }

    public float getXChartMax() {
        return this.k.G;
    }

    public float getXChartMin() {
        return this.k.H;
    }

    public float getXRange() {
        return this.k.I;
    }

    public float getYMax() {
        return this.d.a;
    }

    public float getYMin() {
        return this.d.b;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.e;
    }

    public boolean j() {
        return this.c;
    }

    public abstract void k();

    public boolean l() {
        is[] isVarArr = this.A;
        return (isVarArr == null || isVarArr.length <= 0 || isVarArr[0] == null) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.E) {
            a(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.d == null) {
            if (!TextUtils.isEmpty(this.p)) {
                vt center = getCenter();
                canvas.drawText(this.p, center.b, center.c, this.j);
            }
        } else if (this.z) {
        } else {
            d();
            this.z = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int a2 = (int) zt.a(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(a2, i)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(a2, i2)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.c) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.c) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            au auVar = this.t;
            RectF rectF = auVar.b;
            float f = rectF.left;
            float f2 = rectF.top;
            float e = auVar.e();
            float d = auVar.d();
            auVar.d = i2;
            auVar.c = i;
            auVar.a(f, f2, e, d);
        } else if (this.c) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i + ", height: " + i2);
        }
        k();
        Iterator<Runnable> it = this.D.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.D.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(T t) {
        this.d = t;
        this.z = false;
        if (t == null) {
            return;
        }
        b(t.b, t.a);
        for (T t2 : this.d.i) {
            if ((t2.h == null) || t2.k() == this.h) {
                ds dsVar = this.h;
                if (dsVar != null) {
                    t2.h = dsVar;
                }
            }
        }
        k();
        if (this.c) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(hr hrVar) {
        this.m = hrVar;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.f = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.g = f;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.C = z;
    }

    public void setExtraBottomOffset(float f) {
        this.x = zt.a(f);
    }

    public void setExtraLeftOffset(float f) {
        this.y = zt.a(f);
    }

    public void setExtraRightOffset(float f) {
        this.w = zt.a(f);
    }

    public void setExtraTopOffset(float f) {
        this.v = zt.a(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.e = z;
    }

    public void setHighlighter(hs hsVar) {
        this.s = hsVar;
    }

    public void setLastHighlighted(is[] isVarArr) {
        if (isVarArr != null && isVarArr.length > 0 && isVarArr[0] != null) {
            this.o.e = isVarArr[0];
            return;
        }
        this.o.e = null;
    }

    public void setLogEnabled(boolean z) {
        this.c = z;
    }

    public void setMarker(ir irVar) {
    }

    @Deprecated
    public void setMarkerView(ir irVar) {
        setMarker(irVar);
    }

    public void setMaxHighlightDistance(float f) {
        this.B = zt.a(f);
    }

    public void setNoDataText(String str) {
        this.p = str;
    }

    public void setNoDataTextColor(int i) {
        this.j.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.j.setTypeface(typeface);
    }

    public void setOnChartGestureListener(at atVar) {
    }

    public void setOnChartValueSelectedListener(bt btVar) {
    }

    public void setOnTouchListener(zs zsVar) {
        this.o = zsVar;
    }

    public void setRenderer(ht htVar) {
        if (htVar != null) {
            this.r = htVar;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.l = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.E = z;
    }

    public cr(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = null;
        this.e = true;
        this.f = true;
        this.g = 0.9f;
        this.h = new ds(0);
        this.l = true;
        this.p = "No chart data available.";
        this.t = new au();
        this.v = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.w = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.x = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.y = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.z = false;
        this.B = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.C = true;
        this.D = new ArrayList<>();
        this.E = false;
        g();
    }

    public void a(is isVar, boolean z) {
        if (isVar == null) {
            this.A = null;
        } else {
            if (this.c) {
                StringBuilder a2 = jg.a("Highlighted: ");
                a2.append(isVar.toString());
                Log.i("MPAndroidChart", a2.toString());
            }
            if (this.d.a(isVar) == null) {
                this.A = null;
            } else {
                this.A = new is[]{isVar};
            }
        }
        setLastHighlighted(this.A);
        invalidate();
    }

    public is a(float f, float f2) {
        if (this.d == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        return getHighlighter().a(f, f2);
    }

    public cr(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.d = null;
        this.e = true;
        this.f = true;
        this.g = 0.9f;
        this.h = new ds(0);
        this.l = true;
        this.p = "No chart data available.";
        this.t = new au();
        this.v = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.w = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.x = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.y = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.z = false;
        this.B = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.C = true;
        this.D = new ArrayList<>();
        this.E = false;
        g();
    }

    public void a(float f, float f2, float f3, float f4) {
        setExtraLeftOffset(f);
        setExtraTopOffset(f2);
        setExtraRightOffset(f3);
        setExtraBottomOffset(f4);
    }

    public final void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i < viewGroup.getChildCount()) {
                a(viewGroup.getChildAt(i));
                i++;
            } else {
                viewGroup.removeAllViews();
                return;
            }
        }
    }
}
