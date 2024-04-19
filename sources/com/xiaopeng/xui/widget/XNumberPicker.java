package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.xiaopeng.libtheme.ThemeManager;
import defpackage.ae0;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class XNumberPicker extends XLinearLayout {
    public static final g h0 = new g();
    public int A;
    public int B;
    public int C;
    public int D;
    public final Scroller E;
    public final Scroller F;
    public int G;
    public b H;
    public a I;
    public float J;
    public long K;
    public float L;
    public VelocityTracker M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public final int S;
    public final Drawable T;
    public final Drawable U;
    public final int V;
    public int W;
    public boolean a0;
    public boolean b0;
    public int c0;
    public boolean d;
    public int d0;
    public int e;
    public final f e0;
    public int f;
    public int f0;
    public final int g;
    public boolean g0;
    public final int h;
    public final int i;
    public final int j;
    public int k;
    public final boolean l;
    public final int m;
    public final int n;
    public ColorStateList o;
    public int p;
    public String[] q;
    public int r;
    public int s;
    public int t;
    public e u;
    public c v;
    public long w;
    public final SparseArray<String> x;
    public final int[] y;
    public final Paint z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XNumberPicker.this.performLongClick();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public boolean c;

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XNumberPicker.this.c(this.c);
            XNumberPicker xNumberPicker = XNumberPicker.this;
            xNumberPicker.postDelayed(this, xNumberPicker.w);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        String a(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(XNumberPicker xNumberPicker, int i, int i2);
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public int c;
        public int d;

        public f() {
        }

        public void a() {
            this.d = 0;
            this.c = 0;
            XNumberPicker.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d != 1) {
                return;
            }
            int i = this.c;
            if (i == 1) {
                XNumberPicker xNumberPicker = XNumberPicker.this;
                xNumberPicker.invalidate(0, xNumberPicker.d0, xNumberPicker.getRight(), XNumberPicker.this.getBottom());
            } else if (i != 2) {
            } else {
                XNumberPicker xNumberPicker2 = XNumberPicker.this;
                xNumberPicker2.invalidate(0, 0, xNumberPicker2.getRight(), XNumberPicker.this.c0);
            }
        }
    }

    public XNumberPicker(Context context) {
        this(context, null);
    }

    public static String f(int i) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i));
    }

    public static c getTwoDigitFormatter() {
        return h0;
    }

    public final void b(int i) {
        String str;
        SparseArray<String> sparseArray = this.x;
        if (sparseArray.get(i) != null) {
            return;
        }
        int i2 = this.r;
        if (i < i2 || i > this.s) {
            str = "";
        } else {
            String[] strArr = this.q;
            if (strArr != null) {
                str = strArr[i - i2];
            } else {
                c cVar = this.v;
                str = cVar != null ? cVar.a(i) : f(i);
            }
        }
        sparseArray.put(i, str);
    }

    public final void c(boolean z) {
        if (!a(this.E)) {
            a(this.F);
        }
        this.G = 0;
        if (z) {
            this.E.startScroll(0, 0, 0, -this.A, 300);
        } else {
            this.E.startScroll(0, 0, 0, this.A, 300);
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.E;
        if (scroller.isFinished()) {
            scroller = this.F;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.G == 0) {
            this.G = scroller.getStartY();
        }
        scrollBy(0, currY - this.G);
        this.G = currY;
        if (scroller.isFinished()) {
            if (scroller == this.E) {
                t();
                e(0);
                return;
            }
            return;
        }
        invalidate();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return getHeight();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.D;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return ((this.s - this.r) + 1) * this.A;
    }

    public final void d(int i) {
        e eVar = this.u;
        if (eVar != null) {
            eVar.a(this, i, this.t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            int action = keyEvent.getAction();
            if (action != 0) {
                if (action == 1 && this.f0 == keyCode) {
                    this.f0 = -1;
                    return true;
                }
            } else {
                if (!this.R) {
                    if (keyCode == 20) {
                    }
                }
                requestFocus();
                this.f0 = keyCode;
                v();
                if (this.E.isFinished()) {
                    c(keyCode == 20);
                }
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            v();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            v();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            v();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.T;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
    }

    public final void e(int i) {
        if (this.W == i) {
            return;
        }
        this.W = i;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public CharSequence getDisplayedValueForCurrentSelection() {
        return this.x.get(getValue());
    }

    public String[] getDisplayedValues() {
        return this.q;
    }

    public int getMaxValue() {
        return this.s;
    }

    public int getMinValue() {
        return this.r;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.S;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.t;
    }

    public boolean getWrapSelectorWheel() {
        return this.R;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.T;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            this.o = getContext().getResources().getColorStateList(vc0.x_number_picker_text_color, null);
            postInvalidate();
        }
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        float f2;
        int i3;
        float f3;
        boolean z = !this.g0 || hasFocus();
        int[] iArr = this.y;
        float f4 = this.D;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            String str = this.x.get(iArr[i4]);
            if (z) {
                if (i4 == 2) {
                    this.z.setColor(this.o.getColorForState(LinearLayout.SELECTED_STATE_SET, -16777216));
                    this.z.setTextSize(this.n);
                    int i5 = this.Q;
                    if (i5 == 0) {
                        i3 = this.e;
                    } else if (i5 != 2) {
                        f3 = (getRight() - getLeft()) / 2.0f;
                        canvas.drawText(str, f3, f4, this.z);
                    } else {
                        i3 = (getRight() - getLeft()) - this.e;
                    }
                    f3 = i3;
                    canvas.drawText(str, f3, f4, this.z);
                } else {
                    this.z.setColor(this.o.getDefaultColor());
                    this.z.setTextSize(this.m);
                    int i6 = this.Q;
                    if (i6 == 0) {
                        i2 = this.e;
                    } else if (i6 != 2) {
                        f2 = (getRight() - getLeft()) / 2.0f;
                        canvas.drawText(str, f2, f4, this.z);
                    } else {
                        i2 = (getRight() - getLeft()) - this.e;
                    }
                    f2 = i2;
                    canvas.drawText(str, f2, f4, this.z);
                }
            }
            if (i4 == 1) {
                i = this.B;
            } else {
                i = this.A;
            }
            f4 += i;
        }
        if (!z || (drawable = this.T) == null) {
            return;
        }
        int i7 = this.c0;
        int i8 = this.V + i7;
        drawable.setBounds(0, i7, this.f, i8);
        this.T.draw(canvas);
        int i9 = this.d0;
        int i10 = i9 - this.V;
        this.T.setBounds(0, i10, this.f, i9);
        this.T.draw(canvas);
        Drawable drawable2 = this.U;
        if (drawable2 != null) {
            int i11 = ((i8 * 2) + i10) / 3;
            int i12 = ((i10 * 2) + i8) / 3;
            int i13 = this.Q;
            if (i13 != 0) {
                if (i13 != 2) {
                    return;
                }
                drawable2.setBounds(35, i11, 41, i11 + 6);
                this.U.draw(canvas);
                this.U.setBounds(35, i12 - 6, 41, i12);
                this.U.draw(canvas);
                return;
            }
            int i14 = this.f;
            drawable2.setBounds(i14 - 6, i11, i14, i11 + 6);
            this.U.draw(canvas);
            Drawable drawable3 = this.U;
            int i15 = this.f;
            drawable3.setBounds(i15 - 6, i12 - 6, i15, i12);
            this.U.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && motionEvent.getActionMasked() == 0) {
            v();
            float y = motionEvent.getY();
            this.J = y;
            this.L = y;
            this.K = motionEvent.getEventTime();
            this.a0 = false;
            this.b0 = false;
            float f2 = this.J;
            if (f2 < this.c0) {
                if (this.W == 0) {
                    f fVar = this.e0;
                    fVar.a();
                    fVar.d = 1;
                    fVar.c = 2;
                    XNumberPicker.this.postDelayed(fVar, ViewConfiguration.getTapTimeout());
                }
            } else if (f2 > this.d0 && this.W == 0) {
                f fVar2 = this.e0;
                fVar2.a();
                fVar2.d = 1;
                fVar2.c = 1;
                XNumberPicker.this.postDelayed(fVar2, ViewConfiguration.getTapTimeout());
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.E.isFinished()) {
                this.E.forceFinished(true);
                this.F.forceFinished(true);
                e(0);
            } else if (!this.F.isFinished()) {
                this.E.forceFinished(true);
                this.F.forceFinished(true);
            } else {
                float f3 = this.J;
                if (f3 < this.c0) {
                    a(false, ViewConfiguration.getLongPressTimeout());
                } else if (f3 > this.d0) {
                    a(true, ViewConfiguration.getLongPressTimeout());
                } else {
                    this.b0 = true;
                    a aVar = this.I;
                    if (aVar == null) {
                        this.I = new a();
                    } else {
                        removeCallbacks(aVar);
                    }
                    postDelayed(this.I, ViewConfiguration.getLongPressTimeout());
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            u();
            int[] iArr = this.y;
            this.p = (int) ((((getBottom() - getTop()) - (((iArr.length - 1) * this.m) + this.n)) / iArr.length) + 0.5f);
            int i5 = this.m;
            int i6 = this.p;
            this.A = i5 + i6;
            this.B = this.n + i6;
            this.C = (i5 / 2) + i6;
            this.D = this.C;
            setVerticalFadingEdgeEnabled(true);
            setFadingEdgeLength(((getBottom() - getTop()) - this.m) / 2);
            int height = getHeight();
            int i7 = this.g;
            int i8 = this.V;
            this.c0 = (((height - i7) / 2) - i8) + 5;
            this.d0 = (i8 * 2) + this.c0 + i7;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(a(i, this.k), a(i2, this.i));
        int i3 = this.j;
        int measuredWidth = getMeasuredWidth();
        if (i3 != -1) {
            measuredWidth = LinearLayout.resolveSizeAndState(Math.max(i3, measuredWidth), i, 0);
        }
        this.f = measuredWidth;
        int i4 = this.h;
        int measuredHeight = getMeasuredHeight();
        if (i4 != -1) {
            measuredHeight = LinearLayout.resolveSizeAndState(Math.max(i4, measuredHeight), i2, 0);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (this.M == null) {
                this.M = VelocityTracker.obtain();
            }
            this.M.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked == 2 && !this.a0) {
                    float y = motionEvent.getY();
                    if (this.W != 1) {
                        if (((int) Math.abs(y - this.J)) > this.N) {
                            v();
                            e(1);
                        }
                    } else {
                        scrollBy(0, (int) (y - this.L));
                        invalidate();
                    }
                    this.L = y;
                }
            } else {
                a aVar = this.I;
                if (aVar != null) {
                    removeCallbacks(aVar);
                }
                b bVar = this.H;
                if (bVar != null) {
                    removeCallbacks(bVar);
                }
                this.e0.a();
                VelocityTracker velocityTracker = this.M;
                velocityTracker.computeCurrentVelocity(1000, this.P);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.O) {
                    this.G = 0;
                    if (yVelocity > 0) {
                        this.E.fling(0, 0, 0, yVelocity, 0, 0, 0, Integer.MAX_VALUE);
                    } else {
                        this.E.fling(0, Integer.MAX_VALUE, 0, yVelocity, 0, 0, 0, Integer.MAX_VALUE);
                    }
                    invalidate();
                    e(2);
                } else {
                    int y2 = (int) motionEvent.getY();
                    int abs = (int) Math.abs(y2 - this.J);
                    long eventTime = motionEvent.getEventTime() - this.K;
                    if (abs <= this.N && eventTime < ViewConfiguration.getTapTimeout()) {
                        if (this.b0) {
                            this.b0 = false;
                            performClick();
                        } else {
                            int i = (y2 / this.A) - 2;
                            if (i > 0) {
                                c(true);
                                f fVar = this.e0;
                                fVar.a();
                                fVar.d = 2;
                                fVar.c = 1;
                                XNumberPicker.this.post(fVar);
                            } else if (i < 0) {
                                c(false);
                                f fVar2 = this.e0;
                                fVar2.a();
                                fVar2.d = 2;
                                fVar2.c = 2;
                                XNumberPicker.this.post(fVar2);
                            }
                        }
                    } else {
                        t();
                    }
                    e(0);
                }
                this.M.recycle();
                this.M = null;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return super.performLongClick();
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        int i3;
        int[] iArr = this.y;
        int i4 = this.D;
        if (!this.R && i2 > 0 && iArr[2] <= this.r) {
            this.D = this.C;
        } else if (!this.R && i2 < 0 && iArr[2] >= this.s) {
            this.D = this.C;
        } else {
            this.D += i2;
            while (true) {
                int i5 = this.D;
                int i6 = i5 - this.C;
                int i7 = this.p;
                if (i6 <= i7) {
                    break;
                }
                this.D = i5 - ((i7 * 2) + 1);
                if (iArr.length - 1 >= 0) {
                    System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
                }
                int i8 = iArr[1] - 1;
                if (this.R && i8 < this.r) {
                    i8 = this.s;
                }
                iArr[0] = i8;
                b(i8);
                a(iArr[2], true);
                if (!this.R && iArr[2] <= this.r) {
                    this.D = this.C;
                }
            }
            while (true) {
                i3 = this.D;
                int i9 = i3 - this.C;
                int i10 = this.p;
                if (i9 >= (-i10)) {
                    break;
                }
                this.D = (i10 * 2) + 1 + i3;
                if (iArr.length - 1 >= 0) {
                    System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
                }
                int i11 = iArr[iArr.length - 2] + 1;
                if (this.R && i11 > this.s) {
                    i11 = this.r;
                }
                iArr[iArr.length - 1] = i11;
                b(i11);
                a(iArr[2], true);
                if (!this.R && iArr[2] >= this.s) {
                    this.D = this.C;
                }
            }
            if (i4 != i3) {
                onScrollChanged(0, i3, 0, i4);
            }
        }
    }

    public void setDisplayedValues(String[] strArr) {
        int i;
        if (this.q == strArr) {
            return;
        }
        this.q = strArr;
        u();
        if (this.l) {
            String[] strArr2 = this.q;
            int i2 = 0;
            if (strArr2 == null) {
                float f2 = 0.0f;
                for (int i3 = 0; i3 <= 9; i3++) {
                    float measureText = this.z.measureText(f(i3));
                    if (measureText > f2) {
                        f2 = measureText;
                    }
                }
                for (int i4 = this.s; i4 > 0; i4 /= 10) {
                    i2++;
                }
                i = (int) (i2 * f2);
            } else {
                int length = strArr2.length;
                int length2 = strArr2.length;
                int i5 = 0;
                while (i2 < length2) {
                    float measureText2 = this.z.measureText(strArr2[i2]);
                    if (measureText2 > i5) {
                        i5 = (int) measureText2;
                    }
                    i2++;
                }
                i = i5;
            }
            if (this.k != i) {
                int i6 = this.j;
                if (i > i6) {
                    this.k = i;
                } else {
                    this.k = i6;
                }
                invalidate();
            }
        }
    }

    public void setFormatter(c cVar) {
        if (cVar == this.v) {
            return;
        }
        this.v = cVar;
        u();
    }

    public void setMaxValue(int i) {
        if (this.s == i) {
            return;
        }
        if (i >= 0) {
            this.s = i;
            int i2 = this.s;
            if (i2 < this.t) {
                this.t = i2;
            }
            w();
            invalidate();
            return;
        }
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMinValue(int i) {
        if (this.r == i) {
            return;
        }
        if (i >= 0) {
            this.r = i;
            int i2 = this.r;
            if (i2 > this.t) {
                this.t = i2;
            }
            w();
            invalidate();
            return;
        }
        throw new IllegalArgumentException("minValue must be >= 0");
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.w = j;
    }

    public void setOnScrollListener(d dVar) {
    }

    public void setOnValueChangedListener(e eVar) {
        this.u = eVar;
    }

    public void setValue(int i) {
        a(i, false);
    }

    public void setWrapSelectorWheel(boolean z) {
        this.d = z;
        w();
    }

    public final boolean t() {
        int i = this.C - this.D;
        if (i != 0) {
            this.G = 0;
            int abs = Math.abs(i);
            int i2 = this.A;
            if (abs > i2 / 2) {
                if (i > 0) {
                    i2 = -i2;
                }
                i += i2;
            }
            this.F.startScroll(0, 0, 0, i, 800);
            invalidate();
            return true;
        }
        return false;
    }

    public final void u() {
        this.x.clear();
        int[] iArr = this.y;
        int value = getValue();
        for (int i = 0; i < this.y.length; i++) {
            int i2 = (i - 2) + value;
            if (this.R) {
                i2 = c(i2);
            }
            iArr[i] = i2;
            b(iArr[i]);
        }
    }

    public final void v() {
        b bVar = this.H;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        a aVar = this.I;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        this.e0.a();
    }

    public final void w() {
        boolean z = true;
        if (!((this.s - this.r) + 1 >= this.y.length) || !this.d) {
            z = false;
        }
        this.R = z;
    }

    public XNumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, cd0.XNumberPicker);
    }

    public final boolean a(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.C - ((this.D + finalY) % this.A);
        if (i != 0) {
            int abs = Math.abs(i);
            int i2 = this.A;
            if (abs > i2 / 2) {
                i = i > 0 ? i - i2 : i + i2;
            }
            scrollBy(0, finalY + i);
            return true;
        }
        return false;
    }

    public XNumberPicker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, cd0.XNumberPicker);
    }

    public XNumberPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3;
        int i4;
        this.d = true;
        this.w = 300L;
        this.x = new SparseArray<>();
        this.y = new int[5];
        this.C = Integer.MIN_VALUE;
        this.W = 0;
        this.f0 = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, dd0.XNumberPicker, i, i2);
        this.g0 = obtainStyledAttributes.getBoolean(dd0.XNumberPicker_np_hideWheelUntilFocused, false);
        this.Q = obtainStyledAttributes.getInt(dd0.XNumberPicker_np_textLayout, 1);
        this.S = obtainStyledAttributes.getColor(dd0.XNumberPicker_np_solidColor, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(dd0.XNumberPicker_np_selectionDivider);
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setLayoutDirection(getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
        this.T = drawable;
        this.U = obtainStyledAttributes.getDrawable(dd0.XNumberPicker_np_symbol);
        this.V = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_selectionDividerHeight, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.g = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_selectionDividersDistance, (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics()));
        this.e = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_text_layout_margin, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_internalMinHeight, -1);
        this.i = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_internalMaxHeight, -1);
        int i5 = this.h;
        if (i5 != -1 && (i4 = this.i) != -1 && i5 > i4) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.j = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_internalMinWidth, -1);
        this.k = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_internalMaxWidth, -1);
        int i6 = this.j;
        if (i6 != -1 && (i3 = this.k) != -1 && i6 > i3) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.l = this.k == -1;
        this.m = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_android_textSize, 20);
        this.n = obtainStyledAttributes.getDimensionPixelSize(dd0.XNumberPicker_np_selectedTextSize, 20);
        this.o = obtainStyledAttributes.getColorStateList(dd0.XNumberPicker_android_textColor);
        if (this.o == null) {
            this.o = ColorStateList.valueOf(context.getColor(17170444));
        }
        obtainStyledAttributes.recycle();
        this.e0 = new f();
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.N = viewConfiguration.getScaledTouchSlop();
        this.O = viewConfiguration.getScaledMinimumFlingVelocity();
        this.P = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int i7 = this.Q;
        if (i7 == 0) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else if (i7 == 1) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else if (i7 == 2) {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
        paint.setTextSize(Math.max(this.m, this.n));
        paint.setColor(this.o.getDefaultColor());
        paint.setTypeface(Typeface.create(getResources().getString(bd0.x_font_typeface_medium), 0));
        this.z = paint;
        this.E = new Scroller(getContext(), null, true);
        this.F = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (getFocusable() == 16) {
            setFocusable(1);
            setFocusableInTouchMode(true);
        }
    }

    /* loaded from: classes.dex */
    public static class g implements c {
        public char b;
        public Formatter c;
        public final StringBuilder a = new StringBuilder();
        public final Object[] d = new Object[1];

        public g() {
            a(Locale.getDefault());
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.c
        public String a(int i) {
            Locale locale = Locale.getDefault();
            if (this.b != '0') {
                a(locale);
            }
            this.d[0] = Integer.valueOf(i);
            StringBuilder sb = this.a;
            sb.delete(0, sb.length());
            this.c.format("%02d", this.d);
            return this.c.toString();
        }

        public final void a(Locale locale) {
            this.c = new Formatter(this.a, locale);
            this.b = '0';
        }
    }

    public final int c(int i) {
        int i2 = this.s;
        if (i > i2) {
            int i3 = this.r;
            return (((i - i2) % (i2 - i3)) + i3) - 1;
        }
        int i4 = this.r;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    public final int a(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return i;
                }
                throw new IllegalArgumentException(jg.a("Unknown measure mode: ", mode));
            }
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
    }

    public final void a(int i, boolean z) {
        int min;
        if (this.t == i) {
            return;
        }
        if (this.R) {
            min = c(i);
        } else {
            min = Math.min(Math.max(i, this.r), this.s);
        }
        int i2 = this.t;
        this.t = min;
        if (z) {
            ae0.b.a.b(2);
            d(i2);
        }
        u();
        invalidate();
    }

    public final void a(boolean z, long j) {
        Runnable runnable = this.H;
        if (runnable == null) {
            this.H = new b();
        } else {
            removeCallbacks(runnable);
        }
        b bVar = this.H;
        bVar.c = z;
        postDelayed(bVar, j);
    }
}
