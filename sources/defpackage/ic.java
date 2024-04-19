package defpackage;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
/* compiled from: FragmentContainerView.java */
/* renamed from: ic  reason: default package */
/* loaded from: classes.dex */
public final class ic extends FrameLayout {
    public ArrayList<View> c;
    public ArrayList<View> d;
    public View.OnApplyWindowInsetsListener e;
    public boolean f;

    public ic(Context context, AttributeSet attributeSet, oc ocVar) {
        super(context, attributeSet);
        View view;
        this.f = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nb.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(nb.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(nb.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment b = ocVar.b(id);
        if (classAttribute != null && b == null) {
            if (id <= 0) {
                throw new IllegalStateException(jg.b("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? jg.a(" with tag ", string) : ""));
            }
            Fragment a = ocVar.m().a(context.getClassLoader(), classAttribute);
            a.a(attributeSet, (Bundle) null);
            ob obVar = new ob(ocVar);
            obVar.o = true;
            a.I = this;
            obVar.a(getId(), a, string, 1);
            obVar.b();
        }
        for (vc vcVar : ocVar.c.b()) {
            Fragment fragment = vcVar.c;
            if (fragment.z == getId() && (view = fragment.J) != null && view.getParent() == null) {
                fragment.I = this;
                vcVar.b();
            }
        }
    }

    public final void a(View view) {
        ArrayList<View> arrayList = this.d;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(mb.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(mb.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        ja b;
        ja a = ja.a(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.e;
        if (onApplyWindowInsetsListener != null) {
            b = ja.a(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            b = y9.b(this, a);
        }
        if (!b.a.g()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                y9.a(getChildAt(i), b);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f && this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                super.drawChild(canvas, this.c.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (!this.f || (arrayList = this.c) == null || arrayList.size() <= 0 || !this.c.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.c;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.f = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        int i = Build.VERSION.SDK_INT;
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.e = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(view);
        }
        super.startViewTransition(view);
    }
}
