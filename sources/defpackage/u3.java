package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
/* compiled from: DropDownListView.java */
/* renamed from: u3  reason: default package */
/* loaded from: classes.dex */
public class u3 extends ListView {
    public final Rect c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Field i;
    public a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public fa n;
    public bb o;
    public b p;

    /* compiled from: DropDownListView.java */
    /* renamed from: u3$a */
    /* loaded from: classes.dex */
    public static class a extends j1 {
        public boolean d;

        public a(Drawable drawable) {
            super(drawable);
            this.d = true;
        }

        @Override // defpackage.j1, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.d) {
                this.c.draw(canvas);
            }
        }

        @Override // defpackage.j1, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.d) {
                Drawable drawable = this.c;
                int i = Build.VERSION.SDK_INT;
                drawable.setHotspot(f, f2);
            }
        }

        @Override // defpackage.j1, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.d) {
                Drawable drawable = this.c;
                int i5 = Build.VERSION.SDK_INT;
                drawable.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // defpackage.j1, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.d) {
                return this.c.setState(iArr);
            }
            return false;
        }

        @Override // defpackage.j1, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.d) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: u3$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u3 u3Var = u3.this;
            u3Var.p = null;
            u3Var.drawableStateChanged();
        }
    }

    public u3(Context context, boolean z) {
        super(context, null, z.dropDownListViewStyle);
        this.c = new Rect();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.l = z;
        setCacheColorHint(0);
        try {
            this.i = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.i.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.d = z;
        }
    }

    public int a(int i, int i2, int i3) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i4 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        View view = null;
        while (i6 < count) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            if (i9 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i6 > 0) {
                i5 += dividerHeight;
            }
            i5 += view.getMeasuredHeight();
            if (i5 >= i2) {
                return (i3 < 0 || i6 <= i3 || i8 <= 0 || i5 == i2) ? i2 : i8;
            }
            if (i3 >= 0 && i6 >= i3) {
                i8 = i5;
            }
            i6++;
        }
        return i5;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.c.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.c);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.p != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.l || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.l || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.l || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.l && this.k) || super.isInTouchMode();
    }

    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z) {
                    min = Math.max(0, i);
                    while (min < count && !adapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i, count - 1);
                    while (min >= 0 && !adapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            } else if (i >= 0 && i < count) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.p = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.p == null) {
            this.p = new b();
            b bVar = this.p;
            u3.this.post(bVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.h = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.p;
        if (bVar != null) {
            u3 u3Var = u3.this;
            u3Var.p = null;
            u3Var.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.k = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.j = drawable != null ? new a(drawable) : null;
        super.setSelector(this.j);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.d = rect.left;
        this.e = rect.top;
        this.f = rect.right;
        this.g = rect.bottom;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0130 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u3.a(android.view.MotionEvent, int):boolean");
    }

    public final void a() {
        Drawable selector = getSelector();
        if (selector != null && this.m && isPressed()) {
            selector.setState(getDrawableState());
        }
    }
}
