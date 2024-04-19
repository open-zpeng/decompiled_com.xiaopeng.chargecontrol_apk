package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: XLightPaint.java */
/* renamed from: sd0  reason: default package */
/* loaded from: classes.dex */
public class sd0 {
    public static float i = 200.0f;
    public LightingColorFilter a;
    public BlurMaskFilter b;
    public Paint c;
    public int d = -1;
    public int e = XLoadingDrawable.ALPHA_MAX;
    public int f = 0;
    public float g = 1.0f;
    public int h = 0;

    public sd0(Paint paint) {
        this.c = paint;
    }

    public void a(float f) {
        i = f;
    }

    public void a() {
        float f = i;
        float f2 = this.g;
        float f3 = f * f2;
        int i2 = this.f;
        if (i2 > 0) {
            int i3 = (int) (f2 * i2);
            this.a = new LightingColorFilter(-1, Color.argb(this.e, i3, i3, i3));
            this.c.setColorFilter(this.a);
        }
        int i4 = this.h;
        if (i4 == 0) {
            if (f3 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                this.b = new BlurMaskFilter(f3, BlurMaskFilter.Blur.SOLID);
                this.c.setMaskFilter(this.b);
                return;
            }
            this.c.setMaskFilter(null);
        } else if (i4 == 1) {
            int i5 = this.d;
            if (i5 != -1) {
                this.c.setShadowLayer(f3, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, i5);
                return;
            }
            throw new IllegalArgumentException("Please set light color.");
        }
    }
}
