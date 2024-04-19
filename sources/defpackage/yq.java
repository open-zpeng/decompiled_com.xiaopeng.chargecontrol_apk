package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
/* JADX WARN: Incorrect class signature, class is equals to this class: Lyq<Lqs;>; */
/* compiled from: BarBuffer.java */
/* renamed from: yq  reason: default package */
/* loaded from: classes.dex */
public class yq {
    public int a;
    public final float[] b;
    public boolean e;
    public float c = 1.0f;
    public float d = 1.0f;
    public boolean f = false;
    public float g = 1.0f;

    public yq(int i, int i2, boolean z) {
        this.a = 0;
        this.a = 0;
        this.b = new float[i];
        this.e = false;
        this.e = z;
    }

    public void a(float f, float f2, float f3, float f4) {
        float[] fArr = this.b;
        int i = this.a;
        this.a = i + 1;
        fArr[i] = f;
        int i2 = this.a;
        this.a = i2 + 1;
        fArr[i2] = f2;
        int i3 = this.a;
        this.a = i3 + 1;
        fArr[i3] = f3;
        int i4 = this.a;
        this.a = i4 + 1;
        fArr[i4] = f4;
    }

    public void a(qs qsVar) {
        float f;
        float f2;
        float f3;
        float f4;
        ur urVar = (ur) qsVar;
        float n = urVar.n() * this.c;
        float f5 = this.g / 2.0f;
        for (int i = 0; i < n; i++) {
            pr prVar = (pr) urVar.d(i);
            if (prVar != null) {
                float f6 = prVar.f;
                float f7 = prVar.c;
                float[] fArr = prVar.g;
                if (this.e && fArr != null) {
                    float f8 = -prVar.i;
                    float f9 = 0.0f;
                    int i2 = 0;
                    while (i2 < fArr.length) {
                        float f10 = fArr[i2];
                        int i3 = (f10 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f10 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1));
                        if (i3 == 0 && (f9 == XToggleDrawable.LIGHT_RADIUS_DEFAULT || f8 == XToggleDrawable.LIGHT_RADIUS_DEFAULT)) {
                            f3 = f8;
                            f2 = f9;
                            f9 = f10;
                        } else if (i3 >= 0) {
                            f10 += f9;
                            f3 = f8;
                            f2 = f10;
                        } else {
                            float abs = Math.abs(f10) + f8;
                            float abs2 = Math.abs(f10) + f8;
                            float f11 = f8;
                            f2 = f9;
                            f9 = f11;
                            f3 = abs2;
                            f10 = abs;
                        }
                        float f12 = f6 - f5;
                        float f13 = f6 + f5;
                        if (this.f) {
                            float f14 = f9 >= f10 ? f9 : f10;
                            if (f9 > f10) {
                                f9 = f10;
                            }
                            float f15 = f9;
                            f9 = f14;
                            f4 = f15;
                        } else {
                            f4 = f9 >= f10 ? f9 : f10;
                            if (f9 > f10) {
                                f9 = f10;
                            }
                        }
                        float f16 = this.d;
                        a(f12, f4 * f16, f13, f9 * f16);
                        i2++;
                        f9 = f2;
                        f8 = f3;
                    }
                } else {
                    float f17 = f6 - f5;
                    float f18 = f6 + f5;
                    if (this.f) {
                        float f19 = f7 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f7 : 0.0f;
                        if (f7 <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            f7 = f19;
                            f = f7;
                        } else {
                            f7 = f19;
                            f = 0.0f;
                        }
                    } else {
                        f = f7 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f7 : 0.0f;
                        if (f7 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            f7 = 0.0f;
                        }
                    }
                    if (f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                        f *= this.d;
                    } else {
                        f7 *= this.d;
                    }
                    a(f17, f, f18, f7);
                }
            }
        }
        this.a = 0;
    }
}
