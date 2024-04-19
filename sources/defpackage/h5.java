package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.i5;
import java.util.Arrays;
/* compiled from: ArrayLinkedVariables.java */
/* renamed from: h5  reason: default package */
/* loaded from: classes.dex */
public class h5 implements i5.a {
    public static float l = 0.001f;
    public final i5 b;
    public final j5 c;
    public int[] f;
    public int[] g;
    public float[] h;
    public int i;
    public int j;
    public boolean k;
    public int a = 0;
    public int d = 8;
    public n5 e = null;

    public h5(i5 i5Var, j5 j5Var) {
        int i = this.d;
        this.f = new int[i];
        this.g = new int[i];
        this.h = new float[i];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.b = i5Var;
        this.c = j5Var;
    }

    @Override // defpackage.i5.a
    public final void a(n5 n5Var, float f) {
        if (f == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            a(n5Var, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i2 = this.i;
            fArr[i2] = f;
            this.f[i2] = n5Var.e;
            this.g[i2] = -1;
            n5Var.o++;
            n5Var.a(this.b);
            this.a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.a; i5++) {
            int[] iArr2 = this.f;
            int i6 = iArr2[i];
            int i7 = n5Var.e;
            if (i6 == i7) {
                this.h[i] = f;
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.g[i];
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr3 = this.f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f;
        if (i8 >= iArr4.length && this.a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            this.d *= 2;
            this.k = false;
            this.j = i8 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i8] = n5Var.e;
        this.h[i8] = f;
        if (i4 != -1) {
            int[] iArr7 = this.g;
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            this.g[i8] = this.i;
            this.i = i8;
        }
        n5Var.o++;
        n5Var.a(this.b);
        this.a++;
        if (!this.k) {
            this.j++;
        }
        if (this.a >= this.f.length) {
            this.k = true;
        }
        int i11 = this.j;
        int[] iArr8 = this.f;
        if (i11 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    @Override // defpackage.i5.a
    public boolean b(n5 n5Var) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            if (this.f[i] == n5Var.e) {
                return true;
            }
            i = this.g[i];
        }
        return false;
    }

    @Override // defpackage.i5.a
    public final void clear() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            n5 n5Var = this.c.d[this.f[i]];
            if (n5Var != null) {
                n5Var.b(this.b);
            }
            i = this.g[i];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.a = 0;
    }

    public String toString() {
        int i = this.i;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            StringBuilder a = jg.a(jg.a(str, " -> "));
            a.append(this.h[i]);
            a.append(" : ");
            StringBuilder a2 = jg.a(a.toString());
            a2.append(this.c.d[this.f[i]]);
            str = a2.toString();
            i = this.g[i];
        }
        return str;
    }

    @Override // defpackage.i5.a
    public void b() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.g[i];
        }
    }

    @Override // defpackage.i5.a
    public n5 b(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return this.c.d[this.f[i2]];
            }
            i2 = this.g[i2];
        }
        return null;
    }

    @Override // defpackage.i5.a
    public void a(n5 n5Var, float f, boolean z) {
        float f2 = l;
        if (f <= (-f2) || f >= f2) {
            int i = this.i;
            if (i == -1) {
                this.i = 0;
                float[] fArr = this.h;
                int i2 = this.i;
                fArr[i2] = f;
                this.f[i2] = n5Var.e;
                this.g[i2] = -1;
                n5Var.o++;
                n5Var.a(this.b);
                this.a++;
                if (this.k) {
                    return;
                }
                this.j++;
                int i3 = this.j;
                int[] iArr = this.f;
                if (i3 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i4 = -1;
            for (int i5 = 0; i != -1 && i5 < this.a; i5++) {
                int[] iArr2 = this.f;
                int i6 = iArr2[i];
                int i7 = n5Var.e;
                if (i6 == i7) {
                    float f3 = this.h[i] + f;
                    float f4 = l;
                    if (f3 > (-f4) && f3 < f4) {
                        f3 = 0.0f;
                    }
                    this.h[i] = f3;
                    if (f3 == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                        if (i == this.i) {
                            this.i = this.g[i];
                        } else {
                            int[] iArr3 = this.g;
                            iArr3[i4] = iArr3[i];
                        }
                        if (z) {
                            n5Var.b(this.b);
                        }
                        if (this.k) {
                            this.j = i;
                        }
                        n5Var.o--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i] < i7) {
                    i4 = i;
                }
                i = this.g[i];
            }
            int i8 = this.j;
            int i9 = i8 + 1;
            if (this.k) {
                int[] iArr4 = this.f;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f;
            if (i8 >= iArr5.length && this.a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.f;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                this.d *= 2;
                this.k = false;
                this.j = i8 - 1;
                this.h = Arrays.copyOf(this.h, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i8] = n5Var.e;
            this.h[i8] = f;
            if (i4 != -1) {
                int[] iArr8 = this.g;
                iArr8[i8] = iArr8[i4];
                iArr8[i4] = i8;
            } else {
                this.g[i8] = this.i;
                this.i = i8;
            }
            n5Var.o++;
            n5Var.a(this.b);
            this.a++;
            if (!this.k) {
                this.j++;
            }
            int i11 = this.j;
            int[] iArr9 = this.f;
            if (i11 >= iArr9.length) {
                this.k = true;
                this.j = iArr9.length - 1;
            }
        }
    }

    @Override // defpackage.i5.a
    public float a(i5 i5Var, boolean z) {
        float a = a(i5Var.a);
        a(i5Var.a, z);
        i5.a aVar = i5Var.e;
        int a2 = aVar.a();
        for (int i = 0; i < a2; i++) {
            n5 b = aVar.b(i);
            a(b, aVar.a(b) * a, z);
        }
        return a;
    }

    @Override // defpackage.i5.a
    public final float a(n5 n5Var, boolean z) {
        if (this.e == n5Var) {
            this.e = null;
        }
        int i = this.i;
        if (i == -1) {
            return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.a) {
            if (this.f[i] == n5Var.e) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    int[] iArr = this.g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    n5Var.b(this.b);
                }
                n5Var.o--;
                this.a--;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i2++;
            i3 = i;
            i = this.g[i];
        }
        return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    @Override // defpackage.i5.a
    public void a(float f) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f;
            i = this.g[i];
        }
    }

    @Override // defpackage.i5.a
    public int a() {
        return this.a;
    }

    @Override // defpackage.i5.a
    public float a(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
        }
        return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    @Override // defpackage.i5.a
    public final float a(n5 n5Var) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            if (this.f[i] == n5Var.e) {
                return this.h[i];
            }
            i = this.g[i];
        }
        return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }
}
