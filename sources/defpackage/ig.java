package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: ViewPager.java */
/* renamed from: ig  reason: default package */
/* loaded from: classes.dex */
public class ig extends ViewGroup {
    public static final int[] a0 = {16842931};
    public static final Comparator<d> b0 = new a();
    public static final i c0 = new i();
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public VelocityTracker H;
    public int I;
    public boolean J;
    public EdgeEffect K;
    public EdgeEffect L;
    public boolean M;
    public boolean N;
    public int O;
    public List<g> P;
    public g Q;
    public g R;
    public List<f> S;
    public int T;
    public ArrayList<View> U;
    public final Runnable V;
    public int W;
    public int c;
    public final ArrayList<d> d;
    public final d e;
    public final Rect f;
    public int g;
    public int h;
    public Parcelable i;
    public ClassLoader j;
    public Scroller k;
    public boolean l;
    public int m;
    public Drawable n;
    public int o;
    public int p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;

    /* compiled from: ViewPager.java */
    /* renamed from: ig$a */
    /* loaded from: classes.dex */
    public static class a implements Comparator<d> {
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return dVar.b - dVar2.b;
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$b */
    /* loaded from: classes.dex */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* compiled from: ViewPager.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: ig$c */
    /* loaded from: classes.dex */
    public @interface c {
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$d */
    /* loaded from: classes.dex */
    public static class d {
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$f */
    /* loaded from: classes.dex */
    public interface f {
        void a(ig igVar, hg hgVar, hg hgVar2);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$g */
    /* loaded from: classes.dex */
    public interface g {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$h */
    /* loaded from: classes.dex */
    public static class h extends jb {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public int e;
        public Parcelable f;
        public ClassLoader g;

        /* compiled from: ViewPager.java */
        /* renamed from: ig$h$a */
        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new h[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder a2 = jg.a("FragmentPager.SavedState{");
            a2.append(Integer.toHexString(System.identityHashCode(this)));
            a2.append(" position=");
            a2.append(this.e);
            a2.append("}");
            return a2.toString();
        }

        @Override // defpackage.jb, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.c, i);
            parcel.writeInt(this.e);
            parcel.writeParcelable(this.f, i);
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? h.class.getClassLoader() : classLoader;
            this.e = parcel.readInt();
            this.f = parcel.readParcelable(classLoader);
            this.g = classLoader;
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$i */
    /* loaded from: classes.dex */
    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            e eVar = (e) view.getLayoutParams();
            e eVar2 = (e) view2.getLayoutParams();
            boolean z = eVar.a;
            if (z != eVar2.a) {
                return z ? 1 : -1;
            }
            return eVar.e - eVar2.e;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.u != z) {
            this.u = z;
        }
    }

    public void a(int i2, boolean z) {
        this.v = false;
        a(i2, z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        d b2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.b == this.g) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d b2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.b == this.g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        e eVar = (e) layoutParams;
        eVar.a |= view.getClass().getAnnotation(c.class) != null;
        if (this.t) {
            if (!eVar.a) {
                eVar.d = true;
                addViewInLayout(view, i2, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i2, layoutParams);
    }

    public d b(View view) {
        if (this.d.size() <= 0) {
            return null;
        }
        Object obj = this.d.get(0).a;
        throw null;
    }

    public final void c(int i2) {
        g gVar = this.Q;
        if (gVar != null) {
            gVar.b(i2);
        }
        List<g> list = this.P;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar2 = this.P.get(i3);
                if (gVar2 != null) {
                    gVar2.b(i2);
                }
            }
        }
        g gVar3 = this.R;
        if (gVar3 != null) {
            gVar3.b(i2);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.l = true;
        if (!this.k.isFinished() && this.k.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.k.getCurrX();
            int currY = this.k.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!e(currX)) {
                    this.k.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            y9.t(this);
            return;
        }
        c(true);
    }

    public d d(int i2) {
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            d dVar = this.d.get(i3);
            if (dVar.b == i2) {
                return dVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        d b2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.b == this.g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        if (getOverScrollMode() != 0) {
            this.K.finish();
            this.L.finish();
        } else {
            if (!this.K.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.q * width);
                this.K.setSize(height, width);
                z = false | this.K.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.L.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.r + 1.0f)) * width2);
                this.L.setSize(height2, width2);
                z |= this.L.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            y9.t(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final boolean e(int i2) {
        if (this.d.size() == 0) {
            if (this.M) {
                return false;
            }
            this.N = false;
            a(0, XToggleDrawable.LIGHT_RADIUS_DEFAULT, 0);
            if (this.N) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        d t = t();
        int clientWidth = getClientWidth();
        int i3 = this.m;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = t.b;
        float f3 = ((i2 / f2) - t.e) / (t.d + (i3 / f2));
        this.N = false;
        a(i5, f3, (int) (i4 * f3));
        if (this.N) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public void f(int i2) {
        int i3 = this.g;
        if (i3 != i2) {
            d(i3);
            this.g = i2;
        }
        y();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public hg getAdapter() {
        return null;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.T == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((e) this.U.get(i3).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.g;
    }

    public int getOffscreenPageLimit() {
        return this.w;
    }

    public int getPageMargin() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.M = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.V);
        Scroller scroller = this.k;
        if (scroller != null && !scroller.isFinished()) {
            this.k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.m <= 0 || this.n == null) {
            return;
        }
        this.d.size();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & XLoadingDrawable.ALPHA_MAX;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.x) {
                    return true;
                }
                if (this.y) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.E = x;
                this.C = x;
                float y = motionEvent.getY();
                this.F = y;
                this.D = y;
                this.G = motionEvent.getPointerId(0);
                this.y = false;
                this.l = true;
                this.k.computeScrollOffset();
                if (this.W == 2 && Math.abs(this.k.getFinalX() - this.k.getCurrX()) > this.I) {
                    this.k.abortAnimation();
                    this.v = false;
                    w();
                    this.x = true;
                    d(true);
                    setScrollState(1);
                } else {
                    c(false);
                    this.x = false;
                }
            } else if (action == 2) {
                int i2 = this.G;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.C;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.F);
                    int i3 = (f2 > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : (f2 == XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 0 : -1));
                    if (i3 != 0) {
                        float f3 = this.C;
                        if (!((f3 < ((float) this.A) && i3 > 0) || (f3 > ((float) (getWidth() - this.A)) && f2 < XToggleDrawable.LIGHT_RADIUS_DEFAULT)) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                            this.C = x2;
                            this.D = y2;
                            this.y = true;
                            return false;
                        }
                    }
                    if (abs > this.B && abs * 0.5f > abs2) {
                        this.x = true;
                        d(true);
                        setScrollState(1);
                        float f4 = this.E;
                        float f5 = this.B;
                        this.C = i3 > 0 ? f4 + f5 : f4 - f5;
                        this.D = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.B) {
                        this.y = true;
                    }
                    if (this.x) {
                        b(x2);
                        throw null;
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (this.H == null) {
                this.H = VelocityTracker.obtain();
            }
            this.H.addMovement(motionEvent);
            return this.x;
        }
        x();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        d b2;
        int max;
        int max2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = paddingBottom;
        int i9 = 0;
        int i10 = paddingTop;
        int i11 = paddingLeft;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a) {
                    int i13 = eVar.b;
                    int i14 = i13 & 7;
                    int i15 = i13 & 112;
                    if (i14 == 1) {
                        max = Math.max((i6 - childAt.getMeasuredWidth()) / 2, i11);
                    } else if (i14 == 3) {
                        max = i11;
                        i11 = childAt.getMeasuredWidth() + i11;
                    } else if (i14 != 5) {
                        max = i11;
                    } else {
                        max = (i6 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i15 == 16) {
                        max2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, i10);
                    } else if (i15 == 48) {
                        max2 = i10;
                        i10 = childAt.getMeasuredHeight() + i10;
                    } else if (i15 != 80) {
                        max2 = i10;
                    } else {
                        max2 = (i7 - i8) - childAt.getMeasuredHeight();
                        i8 += childAt.getMeasuredHeight();
                    }
                    int i16 = max + scrollX;
                    childAt.layout(i16, max2, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + max2);
                    i9++;
                }
            }
        }
        int i17 = (i6 - i11) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                e eVar2 = (e) childAt2.getLayoutParams();
                if (!eVar2.a && (b2 = b(childAt2)) != null) {
                    float f2 = i17;
                    int i19 = ((int) (b2.e * f2)) + i11;
                    if (eVar2.d) {
                        eVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * eVar2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i7 - i10) - i8, 1073741824));
                    }
                    childAt2.layout(i19, i10, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + i10);
                }
            }
        }
        this.o = i10;
        this.p = i7 - i8;
        this.O = i9;
        if (this.M) {
            z2 = false;
            a(this.g, false, 0, false);
        } else {
            z2 = false;
        }
        this.M = z2;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        e eVar;
        e eVar2;
        int i4;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.A = Math.min(measuredWidth / 10, this.z);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = measuredHeight;
        int i6 = paddingLeft;
        int i7 = 0;
        while (true) {
            boolean z = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (eVar2 = (e) childAt.getLayoutParams()) != null && eVar2.a) {
                int i9 = eVar2.b;
                int i10 = i9 & 7;
                int i11 = i9 & 112;
                boolean z2 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i12 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i13 = ((ViewGroup.LayoutParams) eVar2).width;
                if (i13 != -2) {
                    if (i13 == -1) {
                        i13 = i6;
                    }
                    i12 = 1073741824;
                } else {
                    i13 = i6;
                }
                int i14 = ((ViewGroup.LayoutParams) eVar2).height;
                if (i14 == -2) {
                    i14 = i5;
                    i8 = i4;
                } else if (i14 == -1) {
                    i14 = i5;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i12), View.MeasureSpec.makeMeasureSpec(i14, i8));
                if (z2) {
                    i5 -= childAt.getMeasuredHeight();
                } else if (z) {
                    i6 -= childAt.getMeasuredWidth();
                }
            }
            i7++;
        }
        View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        this.s = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        this.t = true;
        w();
        this.t = false;
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8 && ((eVar = (e) childAt2.getLayoutParams()) == null || !eVar.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (i6 * eVar.c), 1073741824), this.s);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        d b2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.b == this.g && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.c);
        this.h = hVar.e;
        this.i = hVar.f;
        this.j = hVar.g;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.e = this.g;
        return hVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.m;
            a(i2, i4, i6, i6);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.J) {
            return true;
        }
        if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() != 0) {
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.t) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(hg hgVar) {
        this.c = 0;
        List<f> list = this.S;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.S.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.S.get(i2).a(this, null, hgVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.v = false;
        a(i2, !this.M, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.w) {
            this.w = i2;
            w();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(g gVar) {
        this.Q = gVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.m;
        this.m = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.W == i2) {
            return;
        }
        this.W = i2;
        g gVar = this.Q;
        if (gVar != null) {
            gVar.a(i2);
        }
        List<g> list = this.P;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar2 = this.P.get(i3);
                if (gVar2 != null) {
                    gVar2.a(i2);
                }
            }
        }
        g gVar3 = this.R;
        if (gVar3 != null) {
            gVar3.a(i2);
        }
    }

    public final d t() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        d dVar = null;
        boolean z = true;
        while (i4 < this.d.size()) {
            d dVar2 = this.d.get(i4);
            if (!z && dVar2.b != (i2 = i3 + 1)) {
                d dVar3 = this.e;
                dVar3.e = f3 + f4 + f2;
                dVar3.b = i2;
                int i5 = dVar3.b;
                throw null;
            }
            f3 = dVar2.e;
            float f5 = dVar2.d + f3 + f2;
            if (!z && scrollX < f3) {
                return dVar;
            }
            if (scrollX < f5 || i4 == this.d.size() - 1) {
                return dVar2;
            }
            i3 = dVar2.b;
            f4 = dVar2.d;
            i4++;
            z = false;
            dVar = dVar2;
        }
        return dVar;
    }

    public boolean u() {
        int i2 = this.g;
        if (i2 > 0) {
            a(i2 - 1, true);
            return true;
        }
        return false;
    }

    public boolean v() {
        return false;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n;
    }

    public void w() {
        f(this.g);
    }

    public final boolean x() {
        this.G = -1;
        this.x = false;
        this.y = false;
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
        this.K.onRelease();
        this.L.onRelease();
        return this.K.isFinished() || this.L.isFinished();
    }

    public final void y() {
        if (this.T != 0) {
            ArrayList<View> arrayList = this.U;
            if (arrayList == null) {
                this.U = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.U.add(getChildAt(i2));
            }
            Collections.sort(this.U, c0);
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: ig$e */
    /* loaded from: classes.dex */
    public static class e extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        public float c;
        public boolean d;
        public int e;
        public int f;

        public e() {
            super(-1, -1);
            this.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ig.a0);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    public void a(int i2, boolean z, boolean z2, int i3) {
        setScrollingCacheEnabled(false);
    }

    public final boolean b(float f2) {
        this.C = f2;
        getScrollX();
        getClientWidth();
        d dVar = this.d.get(0);
        ArrayList<d> arrayList = this.d;
        d dVar2 = arrayList.get(arrayList.size() - 1);
        if (dVar.b != 0) {
            float f3 = dVar.e;
        }
        int i2 = dVar2.b;
        throw null;
    }

    public final void d(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void a(int i2, boolean z, int i3, boolean z2) {
        int i4;
        d d2 = d(i2);
        if (d2 != null) {
            i4 = (int) (Math.max(this.q, Math.min(d2.e, this.r)) * getClientWidth());
        } else {
            i4 = 0;
        }
        if (z) {
            a(i4, 0, i3);
            if (z2) {
                c(i2);
                return;
            }
            return;
        }
        if (z2) {
            c(i2);
        }
        c(false);
        scrollTo(i4, 0);
        e(i4);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(o7.b(getContext(), i2));
    }

    public final void c(boolean z) {
        boolean z2 = this.W == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.k.isFinished()) {
                this.k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.k.getCurrX();
                int currY = this.k.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        e(currX);
                    }
                }
            }
        }
        this.v = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            d dVar = this.d.get(i2);
            if (dVar.c) {
                dVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                y9.a(this, this.V);
            } else {
                this.V.run();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto La
            goto L63
        La:
            if (r0 == 0) goto L64
            android.view.ViewParent r4 = r0.getParent()
        L10:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1d
            if (r4 != r6) goto L18
            r4 = r1
            goto L1e
        L18:
            android.view.ViewParent r4 = r4.getParent()
            goto L10
        L1d:
            r4 = r2
        L1e:
            if (r4 != 0) goto L64
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L34:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L34
        L4d:
            java.lang.String r0 = "arrowScroll tried to find focus based on non-child current focused view "
            java.lang.StringBuilder r0 = defpackage.jg.a(r0)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
        L63:
            r0 = r3
        L64:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lb5
            if (r3 == r0) goto Lb5
            if (r7 != r5) goto L95
            android.graphics.Rect r1 = r6.f
            android.graphics.Rect r1 = r6.a(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f
            android.graphics.Rect r2 = r6.a(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L8f
            if (r1 < r2) goto L8f
            boolean r0 = r6.u()
            goto L93
        L8f:
            boolean r0 = r3.requestFocus()
        L93:
            r2 = r0
            goto Lc8
        L95:
            if (r7 != r4) goto Lc8
            android.graphics.Rect r1 = r6.f
            android.graphics.Rect r1 = r6.a(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f
            android.graphics.Rect r2 = r6.a(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto Lb0
            if (r1 > r2) goto Lb0
            boolean r0 = r6.v()
            goto L93
        Lb0:
            boolean r0 = r3.requestFocus()
            goto L93
        Lb5:
            if (r7 == r5) goto Lc4
            if (r7 != r1) goto Lba
            goto Lc4
        Lba:
            if (r7 == r4) goto Lbf
            r0 = 2
            if (r7 != r0) goto Lc8
        Lbf:
            boolean r2 = r6.v()
            goto Lc8
        Lc4:
            boolean r2 = r6.u()
        Lc8:
            if (r2 == 0) goto Ld1
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ig.b(int):boolean");
    }

    public float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public void a(int i2, int i3, int i4) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.k;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.l ? this.k.getCurrX() : this.k.getStartX();
            this.k.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            c(false);
            w();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        float f2 = clientWidth / 2;
        float a2 = (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / clientWidth)) * f2) + f2;
        int abs = Math.abs(i4);
        if (abs > 0) {
            int min = Math.min(Math.round(Math.abs(a2 / abs) * 1000.0f) * 4, 600);
            this.l = false;
            this.k.startScroll(i5, scrollY, i6, i7, min);
            y9.t(this);
            return;
        }
        throw null;
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.d.isEmpty()) {
            if (!this.k.isFinished()) {
                this.k.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        d d2 = d(this.g);
        int min = (int) ((d2 != null ? Math.min(d2.e, this.r) : XToggleDrawable.LIGHT_RADIUS_DEFAULT) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            c(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.O
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = r1
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            ig$e r9 = (defpackage.ig.e) r9
            boolean r10 = r9.a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            ig$g r0 = r12.Q
            if (r0 == 0) goto L74
            r0.a(r13, r14, r15)
        L74:
            java.util.List<ig$g> r0 = r12.P
            if (r0 == 0) goto L8e
            int r0 = r0.size()
        L7c:
            if (r1 >= r0) goto L8e
            java.util.List<ig$g> r3 = r12.P
            java.lang.Object r3 = r3.get(r1)
            ig$g r3 = (defpackage.ig.g) r3
            if (r3 == 0) goto L8b
            r3.a(r13, r14, r15)
        L8b:
            int r1 = r1 + 1
            goto L7c
        L8e:
            ig$g r0 = r12.R
            if (r0 == 0) goto L95
            r0.a(r13, r14, r15)
        L95:
            r12.N = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ig.a(int, float, int):void");
    }

    public final void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.G) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.C = motionEvent.getX(i2);
            this.G = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean a(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return u();
                }
                return b(17);
            } else if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return v();
                }
                return b(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return b(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return b(1);
                }
            }
        }
        return false;
    }

    public final Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
