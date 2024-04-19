package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
/* compiled from: Transformer.java */
/* renamed from: xt  reason: default package */
/* loaded from: classes.dex */
public class xt {
    public au c;
    public Matrix a = new Matrix();
    public Matrix b = new Matrix();
    public float[] d = new float[1];
    public Matrix e = new Matrix();
    public float[] f = new float[2];
    public Matrix g = new Matrix();

    public xt(au auVar) {
        new Matrix();
        this.c = auVar;
    }

    public void a(float f, float f2, float f3, float f4) {
        float a = this.c.a() / f2;
        float height = this.c.b.height() / f3;
        if (Float.isInfinite(a)) {
            a = 0.0f;
        }
        if (Float.isInfinite(height)) {
            height = 0.0f;
        }
        this.a.reset();
        this.a.postTranslate(-f, -f4);
        this.a.postScale(a, -height);
    }

    public void b(float[] fArr) {
        this.a.mapPoints(fArr);
        this.c.a.mapPoints(fArr);
        this.b.mapPoints(fArr);
    }

    public void b(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.a.mapRect(rectF);
        this.c.a.mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void a(boolean z) {
        this.b.reset();
        if (!z) {
            Matrix matrix = this.b;
            au auVar = this.c;
            matrix.postTranslate(auVar.b.left, auVar.d - auVar.d());
            return;
        }
        Matrix matrix2 = this.b;
        RectF rectF = this.c.b;
        matrix2.setTranslate(rectF.left, -rectF.top);
        this.b.postScale(1.0f, -1.0f);
    }

    public ut b(float f, float f2) {
        ut a = ut.a(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
        a(f, f2, a);
        return a;
    }

    public void a(Path path) {
        path.transform(this.a);
        path.transform(this.c.a);
        path.transform(this.b);
    }

    public void a(RectF rectF, float f) {
        rectF.top *= f;
        rectF.bottom *= f;
        this.a.mapRect(rectF);
        this.c.a.mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void a(float[] fArr) {
        Matrix matrix = this.e;
        matrix.reset();
        this.b.invert(matrix);
        matrix.mapPoints(fArr);
        this.c.a.invert(matrix);
        matrix.mapPoints(fArr);
        this.a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void a(float f, float f2, ut utVar) {
        float[] fArr = this.f;
        fArr[0] = f;
        fArr[1] = f2;
        a(fArr);
        float[] fArr2 = this.f;
        utVar.b = fArr2[0];
        utVar.c = fArr2[1];
    }

    public ut a(float f, float f2) {
        float[] fArr = this.f;
        fArr[0] = f;
        fArr[1] = f2;
        b(fArr);
        float[] fArr2 = this.f;
        return ut.a(fArr2[0], fArr2[1]);
    }
}
