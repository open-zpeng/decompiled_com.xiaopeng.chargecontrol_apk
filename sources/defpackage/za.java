package defpackage;

import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: AutoScrollHelper.java */
/* renamed from: za  reason: default package */
/* loaded from: classes.dex */
public abstract class za implements View.OnTouchListener {
    public static final int t = ViewConfiguration.getTapTimeout();
    public final View e;
    public Runnable f;
    public int i;
    public int j;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final a c = new a();
    public final Interpolator d = new AccelerateInterpolator();
    public float[] g = {XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT};
    public float[] h = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] k = {XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT};
    public float[] l = {XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT};
    public float[] m = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: za$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            za zaVar = za.this;
            if (zaVar.q) {
                if (zaVar.o) {
                    zaVar.o = false;
                    zaVar.c.b();
                }
                a aVar = za.this.c;
                if (!(aVar.i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.i + ((long) aVar.k)) && za.this.b()) {
                    za zaVar2 = za.this;
                    if (zaVar2.p) {
                        zaVar2.p = false;
                        zaVar2.a();
                    }
                    if (aVar.f != 0) {
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        float a = aVar.a(currentAnimationTimeMillis);
                        aVar.f = currentAnimationTimeMillis;
                        float f = ((float) (currentAnimationTimeMillis - aVar.f)) * ((a * 4.0f) + ((-4.0f) * a * a));
                        aVar.g = (int) (aVar.c * f);
                        aVar.h = (int) (f * aVar.d);
                        int i = aVar.g;
                        int i2 = aVar.h;
                        ListView listView = ((bb) za.this).u;
                        int i3 = Build.VERSION.SDK_INT;
                        listView.scrollListBy(i2);
                        y9.a(za.this.e, this);
                        return;
                    }
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                za.this.q = false;
            }
        }
    }

    public za(View view) {
        this.e = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.m;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr[0] = f2;
        fArr[1] = f2;
        float[] fArr2 = this.l;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f3;
        fArr2[1] = f3;
        this.i = 1;
        float[] fArr3 = this.h;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.g;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.k;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.j = t;
        a aVar = this.c;
        aVar.a = 500;
        aVar.b = 500;
    }

    public static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    public static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public za a(boolean z) {
        if (this.r && !z) {
            if (this.o) {
                this.q = false;
            } else {
                this.c.a();
            }
        }
        this.r = z;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b() {
        /*
            r9 = this;
            za$a r0 = r9.c
            float r1 = r0.d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.c
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L53
            r4 = r9
            bb r4 = (defpackage.bb) r4
            android.widget.ListView r4 = r4.u
            int r5 = r4.getCount()
            if (r5 != 0) goto L23
        L21:
            r1 = r3
            goto L51
        L23:
            int r6 = r4.getChildCount()
            int r7 = r4.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L41
            if (r8 < r5) goto L50
            int r6 = r6 - r2
            android.view.View r1 = r4.getChildAt(r6)
            int r1 = r1.getBottom()
            int r4 = r4.getHeight()
            if (r1 > r4) goto L50
            goto L21
        L41:
            if (r1 >= 0) goto L21
            if (r7 > 0) goto L50
            android.view.View r1 = r4.getChildAt(r3)
            int r1 = r1.getTop()
            if (r1 < 0) goto L50
            goto L21
        L50:
            r1 = r2
        L51:
            if (r1 != 0) goto L59
        L53:
            if (r0 == 0) goto L58
            r0 = r9
            bb r0 = (defpackage.bb) r0
        L58:
            r2 = r3
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.b():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.r
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L23
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L27
            r6 = 3
            if (r0 == r6) goto L16
            goto L86
        L16:
            boolean r6 = r5.o
            if (r6 == 0) goto L1d
            r5.q = r1
            goto L86
        L1d:
            za$a r6 = r5.c
            r6.a()
            goto L86
        L23:
            r5.p = r2
            r5.n = r1
        L27:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.e
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.e
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            za$a r7 = r5.c
            r7.c = r0
            r7.d = r6
            boolean r6 = r5.q
            if (r6 != 0) goto L86
            boolean r6 = r5.b()
            if (r6 == 0) goto L86
            java.lang.Runnable r6 = r5.f
            if (r6 != 0) goto L6a
            za$b r6 = new za$b
            r6.<init>()
            r5.f = r6
        L6a:
            r5.q = r2
            r5.o = r2
            boolean r6 = r5.n
            if (r6 != 0) goto L7f
            int r6 = r5.j
            if (r6 <= 0) goto L7f
            android.view.View r7 = r5.e
            java.lang.Runnable r0 = r5.f
            long r3 = (long) r6
            defpackage.y9.a(r7, r0, r3)
            goto L84
        L7f:
            java.lang.Runnable r6 = r5.f
            r6.run()
        L84:
            r5.n = r2
        L86:
            boolean r6 = r5.s
            if (r6 == 0) goto L8f
            boolean r6 = r5.q
            if (r6 == 0) goto L8f
            r1 = r2
        L8f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: za$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public int b;
        public float c;
        public float d;
        public float j;
        public int k;
        public long e = Long.MIN_VALUE;
        public long i = -1;
        public long f = 0;
        public int g = 0;
        public int h = 0;

        public void a() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = za.a((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void b() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public final float a(long j) {
            if (j < this.e) {
                return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            }
            long j2 = this.i;
            if (j2 >= 0 && j >= j2) {
                float f = this.j;
                return (za.a(((float) (j - j2)) / this.k, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f) * f) + (1.0f - f);
            }
            return za.a(((float) (j - this.e)) / this.a, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f) * 0.5f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.g
            r0 = r0[r4]
            float[] r1 = r3.h
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = a(r0, r2, r1)
            float r1 = r3.a(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.a(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L25
            android.view.animation.Interpolator r6 = r3.d
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L2f
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L38
            android.view.animation.Interpolator r6 = r3.d
            float r5 = r6.getInterpolation(r5)
        L2f:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = a(r5, r6, r0)
            goto L39
        L38:
            r5 = r2
        L39:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3e
            return r2
        L3e:
            float[] r0 = r3.k
            r0 = r0[r4]
            float[] r1 = r3.l
            r1 = r1[r4]
            float[] r2 = r3.m
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L53
            float r5 = r5 * r0
            float r4 = a(r5, r1, r4)
            return r4
        L53:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = a(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.a(int, float, float, float):float");
    }

    public final float a(float f, float f2) {
        if (f2 == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
        int i = this.i;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    return 1.0f - (f / f2);
                }
                if (this.q && this.i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            return f / (-f2);
        }
        return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    public void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, 0);
        this.e.onTouchEvent(obtain);
        obtain.recycle();
    }
}
