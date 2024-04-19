package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: ViewPortHandler.java */
/* renamed from: au  reason: default package */
/* loaded from: classes.dex */
public class au {
    public final Matrix a = new Matrix();
    public RectF b = new RectF();
    public float c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float d = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float e = 1.0f;
    public float f = Float.MAX_VALUE;
    public float g = 1.0f;
    public float h = Float.MAX_VALUE;
    public float i = 1.0f;
    public float j = 1.0f;
    public float k = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float l = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float m = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float n = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public Matrix o = new Matrix();
    public final float[] p = new float[9];

    public void a(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, this.c - f3, this.d - f4);
    }

    public boolean b(float f) {
        return this.b.left <= f + 1.0f;
    }

    public boolean c(float f) {
        return this.b.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public float d() {
        return this.d - this.b.bottom;
    }

    public float e() {
        return this.c - this.b.right;
    }

    public boolean f(float f) {
        return d(f) && a(f);
    }

    public void g(float f) {
        this.m = zt.a(f);
    }

    public void h(float f) {
        this.n = zt.a(f);
    }

    public float a() {
        return this.b.width();
    }

    public boolean b() {
        float f = this.i;
        float f2 = this.g;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean c() {
        float f = this.j;
        float f2 = this.e;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean d(float f) {
        return this.b.top <= f;
    }

    public boolean e(float f) {
        return b(f) && c(f);
    }

    public void a(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.a);
        matrix.postScale(f, f2, f3, f4);
    }

    public Matrix a(Matrix matrix, View view, boolean z) {
        this.a.set(matrix);
        a(this.a, this.b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.a);
        return matrix;
    }

    public void a(Matrix matrix, RectF rectF) {
        float f;
        matrix.getValues(this.p);
        float[] fArr = this.p;
        float f2 = fArr[2];
        float f3 = fArr[0];
        float f4 = fArr[5];
        float f5 = fArr[4];
        this.i = Math.min(Math.max(this.g, f3), this.h);
        this.j = Math.min(Math.max(this.e, f5), this.f);
        float f6 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        if (rectF != null) {
            f6 = rectF.width();
            f = rectF.height();
        } else {
            f = 0.0f;
        }
        this.k = Math.min(Math.max(f2, ((this.i - 1.0f) * (-f6)) - this.m), this.m);
        this.l = Math.max(Math.min(f4, ((this.j - 1.0f) * f) + this.n), -this.n);
        float[] fArr2 = this.p;
        fArr2[2] = this.k;
        fArr2[0] = this.i;
        fArr2[5] = this.l;
        fArr2[4] = this.j;
        matrix.setValues(fArr2);
    }

    public boolean a(float f) {
        return this.b.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }
}
