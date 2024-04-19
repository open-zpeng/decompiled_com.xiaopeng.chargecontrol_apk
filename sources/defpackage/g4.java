package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import defpackage.j0;
import defpackage.x3;
/* compiled from: ScrollingTabContainerView.java */
/* renamed from: g4  reason: default package */
/* loaded from: classes.dex */
public class g4 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public Runnable c;
    public c d;
    public x3 e;
    public Spinner f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: g4$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ View c;

        public a(View view) {
            this.c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            g4.this.smoothScrollTo(this.c.getLeft() - ((g4.this.getWidth() - this.c.getWidth()) / 2), 0);
            g4.this.c = null;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: g4$b */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return g4.this.e.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((d) g4.this.e.getChildAt(i)).d;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                g4 g4Var = g4.this;
                return g4Var.a(((d) g4Var.e.getChildAt(i)).d, true);
            }
            d dVar = (d) view;
            dVar.d = ((d) g4.this.e.getChildAt(i)).d;
            dVar.a();
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: g4$c */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).d.e();
            int childCount = g4.this.e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = g4.this.e.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: g4$d */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {
        public final int[] c;
        public j0.c d;
        public TextView e;
        public ImageView f;
        public View g;

        public d(Context context, j0.c cVar, boolean z) {
            super(context, null, z.actionBarTabStyle);
            Drawable drawable;
            int resourceId;
            this.c = new int[]{16842964};
            this.d = cVar;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, this.c, z.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                    drawable = i1.b(context, resourceId);
                } else {
                    drawable = obtainStyledAttributes.getDrawable(0);
                }
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a() {
            j0.c cVar = this.d;
            View b = cVar.b();
            if (b != null) {
                ViewParent parent = b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b);
                    }
                    addView(b);
                }
                this.g = b;
                TextView textView = this.e;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.g;
            if (view != null) {
                removeView(view);
                this.g = null;
            }
            Drawable c = cVar.c();
            CharSequence d = cVar.d();
            if (c != null) {
                if (this.f == null) {
                    a3 a3Var = new a3(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    a3Var.setLayoutParams(layoutParams);
                    addView(a3Var, 0);
                    this.f = a3Var;
                }
                this.f.setImageDrawable(c);
                this.f.setVisibility(0);
            } else {
                ImageView imageView2 = this.f;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (z) {
                if (this.e == null) {
                    o3 o3Var = new o3(getContext(), null, z.actionBarTabTextStyle);
                    o3Var.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    o3Var.setLayoutParams(layoutParams2);
                    addView(o3Var);
                    this.e = o3Var;
                }
                this.e.setText(d);
                this.e.setVisibility(0);
            } else {
                TextView textView2 = this.e;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.e.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            CharSequence a = z ? null : cVar.a();
            int i = Build.VERSION.SDK_INT;
            setTooltipText(a);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (g4.this.h > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = g4.this.h;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public final boolean a() {
        Spinner spinner = this.f;
        return spinner != null && spinner.getParent() == this;
    }

    public final boolean b() {
        Spinner spinner = this.f;
        if (spinner != null && spinner.getParent() == this) {
            removeView(this.f);
            addView(this.e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.c;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, i0.ActionBar, z.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(i0.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!context.getResources().getBoolean(a0.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(c0.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.i = context.getResources().getDimensionPixelSize(c0.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((d) view).d.e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.e.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.h = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.h = View.MeasureSpec.getSize(i) / 2;
            }
            this.h = Math.min(this.h, this.i);
        } else {
            this.h = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.j, 1073741824);
        if (z2 || !this.g) {
            z = false;
        }
        if (z) {
            this.e.measure(0, makeMeasureSpec);
            if (this.e.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                if (!a()) {
                    if (this.f == null) {
                        k3 k3Var = new k3(getContext(), null, z.actionDropDownStyle);
                        k3Var.setLayoutParams(new x3.a(-2, -1));
                        k3Var.setOnItemSelectedListener(this);
                        this.f = k3Var;
                    }
                    removeView(this.e);
                    addView(this.f, new ViewGroup.LayoutParams(-2, -1));
                    if (this.f.getAdapter() == null) {
                        this.f.setAdapter((SpinnerAdapter) new b());
                    }
                    Runnable runnable = this.c;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.c = null;
                    }
                    this.f.setSelection(this.k);
                }
            } else {
                b();
            }
        } else {
            b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.k);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i) {
        this.j = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.k = i;
        int childCount = this.e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.f;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void a(int i) {
        View childAt = this.e.getChildAt(i);
        Runnable runnable = this.c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.c = new a(childAt);
        post(this.c);
    }

    public d a(j0.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.j));
        } else {
            dVar.setFocusable(true);
            if (this.d == null) {
                this.d = new c();
            }
            dVar.setOnClickListener(this.d);
        }
        return dVar;
    }
}
