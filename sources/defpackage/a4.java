package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* compiled from: ListPopupWindow.java */
/* renamed from: a4  reason: default package */
/* loaded from: classes.dex */
public class a4 implements j2 {
    public static Method H;
    public static Method I;
    public final Handler C;
    public Rect E;
    public boolean F;
    public PopupWindow G;
    public Context c;
    public ListAdapter d;
    public u3 e;
    public int h;
    public int i;
    public boolean k;
    public boolean l;
    public boolean m;
    public View r;
    public DataSetObserver t;
    public View u;
    public Drawable v;
    public AdapterView.OnItemClickListener w;
    public AdapterView.OnItemSelectedListener x;
    public int f = -2;
    public int g = -2;
    public int j = 1002;
    public int n = 0;
    public boolean o = false;
    public boolean p = false;
    public int q = Integer.MAX_VALUE;
    public int s = 0;
    public final e y = new e();
    public final d z = new d();
    public final c A = new c();
    public final a B = new a();
    public final Rect D = new Rect();

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a4$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u3 u3Var = a4.this.e;
            if (u3Var != null) {
                u3Var.setListSelectionHidden(true);
                u3Var.requestLayout();
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a4$b */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (a4.this.b()) {
                a4.this.c();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a4.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a4$c */
    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if ((a4.this.G.getInputMethodMode() == 2) || a4.this.G.getContentView() == null) {
                    return;
                }
                a4 a4Var = a4.this;
                a4Var.C.removeCallbacks(a4Var.y);
                a4.this.y.run();
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a4$d */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = a4.this.G) != null && popupWindow.isShowing() && x >= 0 && x < a4.this.G.getWidth() && y >= 0 && y < a4.this.G.getHeight()) {
                a4 a4Var = a4.this;
                a4Var.C.postDelayed(a4Var.y, 250L);
                return false;
            } else if (action == 1) {
                a4 a4Var2 = a4.this;
                a4Var2.C.removeCallbacks(a4Var2.y);
                return false;
            } else {
                return false;
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a4$e */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u3 u3Var = a4.this.e;
            if (u3Var == null || !y9.q(u3Var) || a4.this.e.getCount() <= a4.this.e.getChildCount()) {
                return;
            }
            int childCount = a4.this.e.getChildCount();
            a4 a4Var = a4.this;
            if (childCount <= a4Var.q) {
                a4Var.G.setInputMethodMode(2);
                a4.this.c();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        int i = Build.VERSION.SDK_INT;
    }

    public a4(Context context, AttributeSet attributeSet, int i, int i2) {
        this.c = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i0.ListPopupWindow, i, i2);
        this.h = obtainStyledAttributes.getDimensionPixelOffset(i0.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.i = obtainStyledAttributes.getDimensionPixelOffset(i0.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.i != 0) {
            this.k = true;
        }
        obtainStyledAttributes.recycle();
        this.G = new c3(context, attributeSet, i, i2);
        this.G.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.t;
        if (dataSetObserver == null) {
            this.t = new b();
        } else {
            ListAdapter listAdapter2 = this.d;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.d = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.t);
        }
        u3 u3Var = this.e;
        if (u3Var != null) {
            u3Var.setAdapter(this.d);
        }
    }

    @Override // defpackage.j2
    public boolean b() {
        return this.G.isShowing();
    }

    public void c(int i) {
        this.h = i;
    }

    public Drawable d() {
        return this.G.getBackground();
    }

    @Override // defpackage.j2
    public void dismiss() {
        this.G.dismiss();
        View view = this.r;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.r);
            }
        }
        this.G.setContentView(null);
        this.e = null;
        this.C.removeCallbacks(this.y);
    }

    @Override // defpackage.j2
    public ListView e() {
        return this.e;
    }

    public int f() {
        if (this.k) {
            return this.i;
        }
        return 0;
    }

    public final void b(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = H;
            if (method != null) {
                try {
                    method.invoke(this.G, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.G.setIsClippedToScreen(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.j2
    public void c() {
        int i;
        int i2;
        int i3;
        u3 u3Var;
        int makeMeasureSpec;
        int i4;
        boolean z = false;
        if (this.e == null) {
            Context context = this.c;
            new y3(this);
            this.e = a(context, !this.F);
            Drawable drawable = this.v;
            if (drawable != null) {
                this.e.setSelector(drawable);
            }
            this.e.setAdapter(this.d);
            this.e.setOnItemClickListener(this.w);
            this.e.setFocusable(true);
            this.e.setFocusableInTouchMode(true);
            this.e.setOnItemSelectedListener(new z3(this));
            this.e.setOnScrollListener(this.A);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.x;
            if (onItemSelectedListener != null) {
                this.e.setOnItemSelectedListener(onItemSelectedListener);
            }
            u3 u3Var2 = this.e;
            View view = this.r;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.s;
                if (i5 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(u3Var2, layoutParams);
                } else if (i5 != 1) {
                    StringBuilder a2 = jg.a("Invalid hint position ");
                    a2.append(this.s);
                    Log.e("ListPopupWindow", a2.toString());
                } else {
                    linearLayout.addView(u3Var2, layoutParams);
                    linearLayout.addView(view);
                }
                int i6 = this.g;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = layoutParams2.bottomMargin + view.getMeasuredHeight() + layoutParams2.topMargin;
                u3Var2 = linearLayout;
            } else {
                i = 0;
            }
            this.G.setContentView(u3Var2);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.G.getContentView();
            View view2 = this.r;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i7 = rect.top;
            i2 = rect.bottom + i7;
            if (!this.k) {
                this.i = -i7;
            }
        } else {
            this.D.setEmpty();
            i2 = 0;
        }
        boolean z2 = this.G.getInputMethodMode() == 2;
        View view3 = this.u;
        int i8 = this.i;
        int i9 = Build.VERSION.SDK_INT;
        int maxAvailableHeight = this.G.getMaxAvailableHeight(view3, i8, z2);
        if (this.o || this.f == -1) {
            i3 = maxAvailableHeight + i2;
        } else {
            int i10 = this.g;
            if (i10 == -2) {
                int i11 = this.c.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.D;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - (rect2.left + rect2.right), Integer.MIN_VALUE);
            } else if (i10 != -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
            } else {
                int i12 = this.c.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.D;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - (rect3.left + rect3.right), 1073741824);
            }
            int a3 = this.e.a(makeMeasureSpec, maxAvailableHeight - i, -1);
            if (a3 > 0) {
                i += this.e.getPaddingBottom() + this.e.getPaddingTop() + i2;
            }
            i3 = a3 + i;
        }
        boolean z3 = this.G.getInputMethodMode() == 2;
        PopupWindow popupWindow = this.G;
        int i13 = this.j;
        int i14 = Build.VERSION.SDK_INT;
        popupWindow.setWindowLayoutType(i13);
        if (this.G.isShowing()) {
            if (y9.q(this.u)) {
                int i15 = this.g;
                if (i15 == -1) {
                    i15 = -1;
                } else if (i15 == -2) {
                    i15 = this.u.getWidth();
                }
                int i16 = this.f;
                if (i16 == -1) {
                    if (!z3) {
                        i3 = -1;
                    }
                    if (z3) {
                        this.G.setWidth(this.g == -1 ? -1 : 0);
                        this.G.setHeight(0);
                    } else {
                        this.G.setWidth(this.g == -1 ? -1 : 0);
                        this.G.setHeight(-1);
                    }
                } else if (i16 != -2) {
                    i3 = i16;
                }
                PopupWindow popupWindow2 = this.G;
                if (!this.p && !this.o) {
                    z = true;
                }
                popupWindow2.setOutsideTouchable(z);
                this.G.update(this.u, this.h, this.i, i15 < 0 ? -1 : i15, i3 < 0 ? -1 : i3);
                return;
            }
            return;
        }
        int i17 = this.g;
        if (i17 == -1) {
            i17 = -1;
        } else if (i17 == -2) {
            i17 = this.u.getWidth();
        }
        int i18 = this.f;
        if (i18 == -1) {
            i3 = -1;
        } else if (i18 != -2) {
            i3 = i18;
        }
        this.G.setWidth(i17);
        this.G.setHeight(i3);
        b(true);
        this.G.setOutsideTouchable((this.p || this.o) ? false : true);
        this.G.setTouchInterceptor(this.z);
        if (this.m) {
            PopupWindow popupWindow3 = this.G;
            boolean z4 = this.l;
            int i19 = Build.VERSION.SDK_INT;
            popupWindow3.setOverlapAnchor(z4);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.G, this.E);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.G.setEpicenterBounds(this.E);
        }
        PopupWindow popupWindow4 = this.G;
        View view4 = this.u;
        int i20 = this.h;
        int i21 = this.i;
        int i22 = this.n;
        int i23 = Build.VERSION.SDK_INT;
        popupWindow4.showAsDropDown(view4, i20, i21, i22);
        this.e.setSelection(-1);
        if ((!this.F || this.e.isInTouchMode()) && (u3Var = this.e) != null) {
            u3Var.setListSelectionHidden(true);
            u3Var.requestLayout();
        }
        if (this.F) {
            return;
        }
        this.C.post(this.B);
    }

    public void d(int i) {
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            this.g = rect.left + rect.right + i;
            return;
        }
        this.g = i;
    }

    public void a(boolean z) {
        this.F = z;
        this.G.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.i = i;
        this.k = true;
    }

    public void a(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public u3 a(Context context, boolean z) {
        return new u3(context, z);
    }
}
