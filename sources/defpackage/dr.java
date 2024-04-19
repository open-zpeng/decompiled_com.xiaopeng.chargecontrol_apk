package defpackage;

import android.graphics.RectF;
import android.util.Log;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.mr;
import defpackage.nr;
/* compiled from: HorizontalBarChart.java */
/* renamed from: dr  reason: default package */
/* loaded from: classes.dex */
public class dr extends ar {
    public RectF r0;

    @Override // defpackage.br
    public void B() {
        xt xtVar = this.d0;
        nr nrVar = this.W;
        float f = nrVar.H;
        float f2 = nrVar.I;
        mr mrVar = this.k;
        xtVar.a(f, f2, mrVar.I, mrVar.H);
        xt xtVar2 = this.c0;
        nr nrVar2 = this.V;
        float f3 = nrVar2.H;
        float f4 = nrVar2.I;
        mr mrVar2 = this.k;
        xtVar2.a(f3, f4, mrVar2.I, mrVar2.H);
    }

    @Override // defpackage.ar, defpackage.cr
    public is a(float f, float f2) {
        if (this.d == 0) {
            if (this.c) {
                Log.e("MPAndroidChart", "Can't select by touch. No data set.");
                return null;
            }
            return null;
        }
        return getHighlighter().a(f2, f);
    }

    @Override // defpackage.br, defpackage.cr
    public void d() {
        a(this.r0);
        RectF rectF = this.r0;
        float f = rectF.left + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        float f2 = rectF.top + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        float f3 = rectF.right + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        float f4 = rectF.bottom + XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        if (this.V.e()) {
            f2 += this.V.a(this.a0.e);
        }
        if (this.W.e()) {
            f4 += this.W.a(this.b0.e);
        }
        mr mrVar = this.k;
        float f5 = mrVar.L;
        if (mrVar.a) {
            mr.a aVar = mrVar.P;
            if (aVar == mr.a.BOTTOM) {
                f += f5;
            } else {
                if (aVar != mr.a.TOP) {
                    if (aVar == mr.a.BOTH_SIDED) {
                        f += f5;
                    }
                }
                f3 += f5;
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
        A();
        B();
    }

    @Override // defpackage.ar, defpackage.br, defpackage.cr
    public void g() {
        this.t = new tt();
        super.g();
        this.c0 = new yt(this.t);
        this.d0 = new yt(this.t);
        this.r = new it(this, this.u, this.t);
        setHighlighter(new js(this));
        this.a0 = new rt(this.t, this.V, this.c0);
        this.b0 = new rt(this.t, this.W, this.d0);
        this.e0 = new pt(this.t, this.k, this.c0, this);
    }

    @Override // defpackage.br, defpackage.ns
    public float getHighestVisibleX() {
        xt a = a(nr.a.LEFT);
        RectF rectF = this.t.b;
        a.a(rectF.left, rectF.top, this.l0);
        return (float) Math.min(this.k.G, this.l0.c);
    }

    @Override // defpackage.br, defpackage.ns
    public float getLowestVisibleX() {
        xt a = a(nr.a.LEFT);
        RectF rectF = this.t.b;
        a.a(rectF.left, rectF.bottom, this.k0);
        return (float) Math.max(this.k.H, this.k0.c);
    }

    @Override // defpackage.br
    public void setVisibleXRangeMaximum(float f) {
        float f2 = this.k.I / f;
        au auVar = this.t;
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        auVar.e = f2;
        auVar.a(auVar.a, auVar.b);
    }

    @Override // defpackage.br
    public void setVisibleXRangeMinimum(float f) {
        float f2 = this.k.I / f;
        au auVar = this.t;
        if (f2 == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f2 = Float.MAX_VALUE;
        }
        auVar.f = f2;
        auVar.a(auVar.a, auVar.b);
    }
}
