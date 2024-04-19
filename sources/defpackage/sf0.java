package defpackage;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XIndicatorDrawable;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
/* compiled from: XSegmented.java */
/* renamed from: sf0  reason: default package */
/* loaded from: classes.dex */
public class sf0 extends XLinearLayout implements hc0, View.OnClickListener {
    public static final String i = sf0.class.getSimpleName();
    public int d;
    public int[] e;
    public int f;
    public final XIndicatorDrawable g;
    public boolean h;

    /* compiled from: XSegmented.java */
    /* renamed from: sf0$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    @Override // defpackage.hc0
    public boolean a(final View view, tc0 tc0Var) {
        final Double d;
        if (be0.a(3)) {
            be0.a(3, null, "Segmented onVuiElementEvent", null, false);
        }
        if (view == null || (d = (Double) tc0Var.getEventValue(tc0Var)) == null) {
            return false;
        }
        post(new Runnable() { // from class: if0
            @Override // java.lang.Runnable
            public final void run() {
                sf0.this.a(d, view);
            }
        });
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        XIndicatorDrawable xIndicatorDrawable = this.g;
        if (xIndicatorDrawable != null) {
            xIndicatorDrawable.setState(getDrawableState());
        }
    }

    public int getSelection() {
        return this.f;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        if (drawable instanceof XIndicatorDrawable) {
            invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h) {
            return;
        }
        indexOfChild(view);
        a(indexOfChild(view), true, true, false);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            setTitleTextColor(this.d);
            int[] iArr = this.e;
            if (iArr != null && iArr.length == getChildCount()) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.e;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    a(iArr2[i2], null, i2);
                    i2++;
                }
            }
            XIndicatorDrawable xIndicatorDrawable = this.g;
            if (xIndicatorDrawable != null) {
                xIndicatorDrawable.onConfigurationChanged(getResources(), getContext().getTheme());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        XIndicatorDrawable xIndicatorDrawable = this.g;
        if (xIndicatorDrawable != null) {
            xIndicatorDrawable.draw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        XIndicatorDrawable xIndicatorDrawable = this.g;
        if (xIndicatorDrawable != null) {
            xIndicatorDrawable.setBounds(new Rect(i2, i3, i4, i5));
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            a(z, i2);
        }
    }

    public void setSegmentListener(a aVar) {
    }

    public void setSelection(int i2) {
        a(i2, true, false, false);
    }

    public void setTitleTextColor(int i2) {
        this.d = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(getContext().getColorStateList(i2));
            }
        }
    }

    public void setTitleTextSize(float f) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextSize(f);
            }
        }
    }

    public final void t() {
        int i2;
        if (this.g == null || (i2 = this.f) < 0 || i2 >= getChildCount()) {
            return;
        }
        this.g.setEnable(getChildAt(this.f).isEnabled());
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void a(int i2, CharSequence charSequence, int i3) {
        if (getChildCount() > i3) {
            View childAt = getChildAt(i3);
            if (childAt instanceof XImageView) {
                XImageView xImageView = (XImageView) childAt;
                xImageView.setImageDrawable(getContext().getDrawable(i2));
                if (charSequence != null) {
                    xImageView.a(charSequence.toString());
                }
                int[] iArr = this.e;
                if (iArr == null || iArr.length <= i3) {
                    return;
                }
                iArr[i3] = i2;
                return;
            }
            be0.d(i, "setSegmentIcon failed, view is not XImageView");
            return;
        }
        be0.d(i, "setSegmentIcon failed, index > child count");
    }

    public final void a(int i2, boolean z, boolean z2, boolean z3) {
        int i3 = this.f;
        this.f = i2;
        int i4 = this.f;
        if (i4 < 0 || i4 >= getChildCount()) {
            this.f = -1;
        }
        int i5 = 0;
        while (i5 < getChildCount()) {
            getChildAt(i5).setSelected(this.f == i5);
            i5++;
        }
        XIndicatorDrawable xIndicatorDrawable = this.g;
        if (xIndicatorDrawable != null) {
            xIndicatorDrawable.setSelection(getChildCount(), this.f, z);
        }
        t();
        if (i3 != this.f || z3) {
            a((View) this);
        }
    }

    public void a(boolean z, int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            return;
        }
        getChildAt(i2).setEnabled(z);
        t();
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        a(Integer.valueOf(this.f));
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof re0) {
                re0 re0Var = (re0) childAt;
                re0Var.a(i2);
                re0Var.b(str + "_" + i2);
                String str2 = i;
                be0.a(str2, "onBuildVuiElement:" + str);
            }
        }
        return null;
    }

    public /* synthetic */ void a(Double d, View view) {
        if (d.intValue() < getChildCount()) {
            view = getChildAt(d.intValue());
        }
        z90.a(view, 0);
        b(true);
        a(d.intValue(), true, true, false);
        b(false);
    }
}
