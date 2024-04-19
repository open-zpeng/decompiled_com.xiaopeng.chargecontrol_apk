package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: LinearLayoutCompat.java */
/* renamed from: x3  reason: default package */
/* loaded from: classes.dex */
public class x3 extends ViewGroup {
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public boolean j;
    public int[] k;
    public int[] l;
    public Drawable m;
    public int n;
    public int o;
    public int p;
    public int q;

    /* compiled from: LinearLayoutCompat.java */
    /* renamed from: x3$a */
    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public x3(Context context) {
        this(context, null);
    }

    public void a(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = r4.a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View a3 = a(i2);
            if (a3 != null && a3.getVisibility() != 8 && b(i2)) {
                a aVar = (a) a3.getLayoutParams();
                if (a2) {
                    left2 = a3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else {
                    left2 = (a3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.n;
                }
                b(canvas, left2);
            }
        }
        if (b(virtualChildCount)) {
            View a4 = a(virtualChildCount - 1);
            if (a4 != null) {
                a aVar2 = (a) a4.getLayoutParams();
                if (a2) {
                    left = a4.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i = this.n;
                    right = left - i;
                } else {
                    right = a4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (a2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.n;
                right = left - i;
            }
            b(canvas, right);
        }
    }

    public void b(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View a2 = a(i);
            if (a2 != null && a2.getVisibility() != 8 && b(i)) {
                a(canvas, (a2.getTop() - ((LinearLayout.LayoutParams) ((a) a2.getLayoutParams())).topMargin) - this.o);
            }
        }
        if (b(virtualChildCount)) {
            View a3 = a(virtualChildCount - 1);
            if (a3 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.o;
            } else {
                bottom = a3.getBottom() + ((LinearLayout.LayoutParams) ((a) a3.getLayoutParams())).bottomMargin;
            }
            a(canvas, bottom);
        }
    }

    public int c() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x3.c(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public int d() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x3.d(int, int):void");
    }

    public int e() {
        return 0;
    }

    public int f() {
        return 0;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.d < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.d;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.d == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i3 = this.e;
            if (this.f == 1 && (i = this.g & 112) != 48) {
                if (i == 16) {
                    i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.h) / 2;
                } else if (i == 80) {
                    i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.h;
                }
            }
            return i3 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.d;
    }

    public Drawable getDividerDrawable() {
        return this.m;
    }

    public int getDividerPadding() {
        return this.q;
    }

    public int getDividerWidth() {
        return this.n;
    }

    public int getGravity() {
        return this.g;
    }

    public int getOrientation() {
        return this.f;
    }

    public int getShowDividers() {
        return this.p;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.m == null) {
            return;
        }
        if (this.f == 1) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f == 1) {
            b(i, i2, i3, i4);
        } else {
            a(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f == 1) {
            d(i, i2);
        } else {
            c(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.c = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.d = i;
            return;
        }
        StringBuilder a2 = jg.a("base aligned child index out of range (0, ");
        a2.append(getChildCount());
        a2.append(")");
        throw new IllegalArgumentException(a2.toString());
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.m) {
            return;
        }
        this.m = drawable;
        if (drawable != null) {
            this.n = drawable.getIntrinsicWidth();
            this.o = drawable.getIntrinsicHeight();
        } else {
            this.n = 0;
            this.o = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.q = i;
    }

    public void setGravity(int i) {
        if (this.g != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.g = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.g;
        if ((8388615 & i3) != i2) {
            this.g = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.j = z;
    }

    public void setOrientation(int i) {
        if (this.f != i) {
            this.f = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.p) {
            requestLayout();
        }
        this.p = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.g;
        if ((i3 & 112) != i2) {
            this.g = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.i = Math.max((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public x3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        int i = this.f;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    public x3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        int resourceId;
        this.c = true;
        this.d = -1;
        this.e = 0;
        this.g = 8388659;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i0.LinearLayoutCompat, i, 0);
        y9.a(this, context, i0.LinearLayoutCompat, attributeSet, obtainStyledAttributes, i, 0);
        int i2 = obtainStyledAttributes.getInt(i0.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(i0.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(i0.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.i = obtainStyledAttributes.getFloat(i0.LinearLayoutCompat_android_weightSum, -1.0f);
        this.d = obtainStyledAttributes.getInt(i0.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.j = obtainStyledAttributes.getBoolean(i0.LinearLayoutCompat_measureWithLargestChild, false);
        int i4 = i0.LinearLayoutCompat_divider;
        if (obtainStyledAttributes.hasValue(i4) && (resourceId = obtainStyledAttributes.getResourceId(i4, 0)) != 0) {
            drawable = i1.b(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(i4);
        }
        setDividerDrawable(drawable);
        this.p = obtainStyledAttributes.getInt(i0.LinearLayoutCompat_showDividers, 0);
        this.q = obtainStyledAttributes.getDimensionPixelSize(i0.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public void b(Canvas canvas, int i) {
        this.m.setBounds(i, getPaddingTop() + this.q, this.n + i, (getHeight() - getPaddingBottom()) - this.q);
        this.m.draw(canvas);
    }

    public void a(Canvas canvas, int i) {
        this.m.setBounds(getPaddingLeft() + this.q, i, (getWidth() - getPaddingRight()) - this.q, this.o + i);
        this.m.draw(canvas);
    }

    public boolean b(int i) {
        if (i == 0) {
            return (this.p & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.p & 4) != 0;
        } else if ((this.p & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public View a(int i) {
        return getChildAt(i);
    }

    public final void a(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View a2 = a(i3);
            if (a2.getVisibility() != 8) {
                a aVar = (a) a2.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i4 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = a2.getMeasuredWidth();
                    measureChildWithMargins(a2, i2, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i4;
                }
            }
        }
    }

    public final void b(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View a2 = a(i3);
            if (a2.getVisibility() != 8) {
                a aVar = (a) a2.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = a2.getMeasuredHeight();
                    measureChildWithMargins(a2, makeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i4;
                }
            }
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            int r0 = r11.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r11.getPaddingRight()
            int r12 = r14 - r12
            int r14 = r14 - r0
            int r1 = r11.getPaddingRight()
            int r14 = r14 - r1
            int r1 = r11.getVirtualChildCount()
            int r2 = r11.g
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L35
            r4 = 80
            if (r3 == r4) goto L2a
            int r13 = r11.getPaddingTop()
            goto L41
        L2a:
            int r3 = r11.getPaddingTop()
            int r3 = r3 + r15
            int r3 = r3 - r13
            int r13 = r11.h
            int r13 = r3 - r13
            goto L41
        L35:
            int r3 = r11.getPaddingTop()
            int r15 = r15 - r13
            int r13 = r11.h
            int r15 = r15 - r13
            int r15 = r15 / 2
            int r13 = r3 + r15
        L41:
            r15 = 0
        L42:
            if (r15 >= r1) goto Lb8
            android.view.View r3 = r11.a(r15)
            r4 = 1
            if (r3 != 0) goto L52
            int r3 = r11.f()
            int r3 = r3 + r13
        L50:
            r13 = r3
            goto Lb6
        L52:
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 == r6) goto Lb6
            int r5 = r3.getMeasuredWidth()
            int r6 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
            x3$a r7 = (defpackage.x3.a) r7
            int r8 = r7.gravity
            if (r8 >= 0) goto L6d
            r8 = r2
        L6d:
            int r9 = defpackage.y9.h(r11)
            int r8 = defpackage.a.a(r8, r9)
            r8 = r8 & 7
            if (r8 == r4) goto L85
            r9 = 5
            if (r8 == r9) goto L80
            int r8 = r7.leftMargin
            int r8 = r8 + r0
            goto L90
        L80:
            int r8 = r12 - r5
            int r9 = r7.rightMargin
            goto L8f
        L85:
            int r8 = r14 - r5
            int r8 = r8 / 2
            int r8 = r8 + r0
            int r9 = r7.leftMargin
            int r8 = r8 + r9
            int r9 = r7.rightMargin
        L8f:
            int r8 = r8 - r9
        L90:
            boolean r9 = r11.b(r15)
            if (r9 == 0) goto L99
            int r9 = r11.o
            int r13 = r13 + r9
        L99:
            int r9 = r7.topMargin
            int r13 = r13 + r9
            int r9 = r11.d()
            int r9 = r9 + r13
            int r5 = r5 + r8
            int r10 = r6 + r9
            r3.layout(r8, r9, r5, r10)
            int r3 = r7.bottomMargin
            int r6 = r6 + r3
            int r3 = r11.e()
            int r3 = r3 + r6
            int r3 = r3 + r13
            int r13 = r11.c()
            int r15 = r15 + r13
            goto L50
        Lb6:
            int r15 = r15 + r4
            goto L42
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x3.b(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x3.a(int, int, int, int):void");
    }
}
