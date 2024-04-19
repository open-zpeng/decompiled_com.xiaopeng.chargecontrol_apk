package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: HorizontalBarBuffer.java */
/* renamed from: zq  reason: default package */
/* loaded from: classes.dex */
public class zq extends yq {
    public zq(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    @Override // defpackage.yq
    public void a(qs qsVar) {
        float f;
        float abs;
        float f2;
        float f3;
        ur urVar = (ur) qsVar;
        float n = urVar.n() * this.c;
        float f4 = this.g / 2.0f;
        for (int i = 0; i < n; i++) {
            pr prVar = (pr) urVar.d(i);
            if (prVar != null) {
                float f5 = prVar.f;
                float f6 = prVar.c;
                float[] fArr = prVar.g;
                if (this.e && fArr != null) {
                    float f7 = -prVar.i;
                    float f8 = 0.0f;
                    int i2 = 0;
                    while (i2 < fArr.length) {
                        float f9 = fArr[i2];
                        if (f9 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            f2 = f9 + f8;
                            abs = f7;
                            f7 = f8;
                            f8 = f2;
                        } else {
                            float abs2 = Math.abs(f9) + f7;
                            abs = Math.abs(f9) + f7;
                            f2 = abs2;
                        }
                        float f10 = f5 - f4;
                        float f11 = f5 + f4;
                        if (this.f) {
                            float f12 = f7 >= f2 ? f7 : f2;
                            if (f7 > f2) {
                                f7 = f2;
                            }
                            float f13 = f7;
                            f7 = f12;
                            f3 = f13;
                        } else {
                            f3 = f7 >= f2 ? f7 : f2;
                            if (f7 > f2) {
                                f7 = f2;
                            }
                        }
                        float f14 = this.d;
                        a(f7 * f14, f11, f3 * f14, f10);
                        i2++;
                        f7 = abs;
                    }
                } else {
                    float f15 = f5 - f4;
                    float f16 = f5 + f4;
                    if (this.f) {
                        float f17 = f6 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f6 : 0.0f;
                        if (f6 <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            f6 = f17;
                            f = f6;
                        } else {
                            f6 = f17;
                            f = 0.0f;
                        }
                    } else {
                        f = f6 >= XToggleDrawable.LIGHT_RADIUS_DEFAULT ? f6 : 0.0f;
                        if (f6 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            f6 = 0.0f;
                        }
                    }
                    if (f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                        f *= this.d;
                    } else {
                        f6 *= this.d;
                    }
                    a(f6, f16, f, f15);
                }
            }
        }
        this.a = 0;
    }
}
