package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.nf;
/* compiled from: FastScroller.java */
/* renamed from: ef  reason: default package */
/* loaded from: classes.dex */
public class ef extends nf.m implements nf.r {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public final int a;
    public final int b;
    public final StateListDrawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public nf s;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];
    public final ValueAnimator z = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f);
    public int A = 0;
    public final Runnable B = new a();
    public final nf.s C = new b();

    /* compiled from: FastScroller.java */
    /* renamed from: ef$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ef efVar = ef.this;
            int i = efVar.A;
            if (i == 1) {
                efVar.z.cancel();
            } else if (i != 2) {
                return;
            }
            efVar.A = 3;
            ValueAnimator valueAnimator = efVar.z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            efVar.z.setDuration(500);
            efVar.z.start();
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: ef$b */
    /* loaded from: classes.dex */
    public class b extends nf.s {
        public b() {
        }

        @Override // defpackage.nf.s
        public void onScrolled(nf nfVar, int i, int i2) {
            ef efVar = ef.this;
            int computeHorizontalScrollOffset = nfVar.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = nfVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = efVar.s.computeVerticalScrollRange();
            int i3 = efVar.r;
            efVar.t = computeVerticalScrollRange - i3 > 0 && i3 >= efVar.a;
            int computeHorizontalScrollRange = efVar.s.computeHorizontalScrollRange();
            int i4 = efVar.q;
            efVar.u = computeHorizontalScrollRange - i4 > 0 && i4 >= efVar.a;
            if (!efVar.t && !efVar.u) {
                if (efVar.v != 0) {
                    efVar.a(0);
                    return;
                }
                return;
            }
            if (efVar.t) {
                float f = i3;
                efVar.l = (int) ((((f / 2.0f) + computeVerticalScrollOffset) * f) / computeVerticalScrollRange);
                efVar.k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (efVar.u) {
                float f2 = computeHorizontalScrollOffset;
                float f3 = i4;
                efVar.o = (int) ((((f3 / 2.0f) + f2) * f3) / computeHorizontalScrollRange);
                efVar.n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            int i5 = efVar.v;
            if (i5 == 0 || i5 == 1) {
                efVar.a(1);
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: ef$c */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public boolean c = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.c) {
                this.c = false;
            } else if (((Float) ef.this.z.getAnimatedValue()).floatValue() == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                ef efVar = ef.this;
                efVar.A = 0;
                efVar.a(0);
            } else {
                ef efVar2 = ef.this;
                efVar2.A = 2;
                efVar2.s.invalidate();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: ef$d */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            ef.this.c.setAlpha(floatValue);
            ef.this.d.setAlpha(floatValue);
            ef.this.s.invalidate();
        }
    }

    public ef(nf nfVar, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i, drawable2.getIntrinsicWidth());
        this.a = i2;
        this.b = i3;
        this.c.setAlpha(XLoadingDrawable.ALPHA_MAX);
        this.d.setAlpha(XLoadingDrawable.ALPHA_MAX);
        this.z.addListener(new c());
        this.z.addUpdateListener(new d());
        nf nfVar2 = this.s;
        if (nfVar2 == nfVar) {
            return;
        }
        if (nfVar2 != null) {
            nfVar2.b((nf.m) this);
            this.s.b((nf.r) this);
            this.s.b(this.C);
            a();
        }
        this.s = nfVar;
        nf nfVar3 = this.s;
        if (nfVar3 != null) {
            nfVar3.a((nf.m) this);
            this.s.a((nf.r) this);
            this.s.a(this.C);
        }
    }

    public void a(int i) {
        if (i == 2 && this.v != 2) {
            this.c.setState(D);
            a();
        }
        if (i == 0) {
            this.s.invalidate();
        } else {
            c();
        }
        if (this.v == 2 && i != 2) {
            this.c.setState(E);
            a();
            this.s.postDelayed(this.B, 1200);
        } else if (i == 1) {
            a();
            this.s.postDelayed(this.B, 1500);
        }
        this.v = i;
    }

    public void a(boolean z) {
    }

    public final boolean b() {
        return y9.h(this.s) == 1;
    }

    public void c() {
        int i = this.A;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.z.cancel();
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }

    public boolean b(float f, float f2) {
        if (y9.h(this.s) == 1) {
            if (f > this.e) {
                return false;
            }
        } else if (f < this.q - this.e) {
            return false;
        }
        int i = this.l;
        int i2 = this.k / 2;
        return f2 >= ((float) (i - i2)) && f2 <= ((float) (i2 + i));
    }

    public final void a() {
        this.s.removeCallbacks(this.B);
    }

    public final int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    public boolean a(float f, float f2) {
        if (f2 >= this.r - this.i) {
            int i = this.o;
            int i2 = this.n;
            if (f >= i - (i2 / 2) && f <= (i2 / 2) + i) {
                return true;
            }
        }
        return false;
    }
}
