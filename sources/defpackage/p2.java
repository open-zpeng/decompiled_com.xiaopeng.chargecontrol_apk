package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import defpackage.g2;
import defpackage.g9;
import defpackage.h2;
import defpackage.z1;
import java.util.ArrayList;
/* compiled from: ActionMenuPresenter.java */
/* renamed from: p2  reason: default package */
/* loaded from: classes.dex */
public class p2 extends u1 implements g9.a {
    public c A;
    public b B;
    public final f C;
    public int D;
    public d k;
    public Drawable l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public final SparseBooleanArray x;
    public e y;
    public a z;

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: p2$a */
    /* loaded from: classes.dex */
    public class a extends f2 {
        public a(Context context, l2 l2Var, View view) {
            super(context, l2Var, view, false, z.actionOverflowMenuStyle, 0);
            if (!l2Var.C.d()) {
                View view2 = p2.this.k;
                this.f = view2 == null ? (View) p2.this.j : view2;
            }
            a(p2.this.C);
        }

        @Override // defpackage.f2
        public void c() {
            p2 p2Var = p2.this;
            p2Var.z = null;
            p2Var.D = 0;
            super.c();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: p2$b */
    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: p2$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public e c;

        public c(e eVar) {
            this.c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            z1.a aVar;
            z1 z1Var = p2.this.e;
            if (z1Var != null && (aVar = z1Var.e) != null) {
                aVar.a(z1Var);
            }
            View view = (View) p2.this.j;
            if (view != null && view.getWindowToken() != null && this.c.d()) {
                p2.this.y = this.c;
            }
            p2.this.A = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: p2$d */
    /* loaded from: classes.dex */
    public class d extends a3 implements ActionMenuView.a {

        /* compiled from: ActionMenuPresenter.java */
        /* renamed from: p2$d$a */
        /* loaded from: classes.dex */
        public class a extends w3 {
            public a(View view, p2 p2Var) {
                super(view);
            }

            @Override // defpackage.w3
            public j2 b() {
                e eVar = p2.this.y;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // defpackage.w3
            public boolean c() {
                p2.this.f();
                return true;
            }

            @Override // defpackage.w3
            public boolean d() {
                p2 p2Var = p2.this;
                if (p2Var.A != null) {
                    return false;
                }
                p2Var.c();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, z.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            CharSequence contentDescription = getContentDescription();
            int i = Build.VERSION.SDK_INT;
            setTooltipText(contentDescription);
            setOnTouchListener(new a(this, p2.this));
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            p2.this.f();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                int i5 = paddingLeft - max;
                int i6 = paddingTop - max;
                int i7 = paddingLeft + max;
                int i8 = paddingTop + max;
                int i9 = Build.VERSION.SDK_INT;
                background.setHotspotBounds(i5, i6, i7, i8);
            }
            return frame;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean u() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean v() {
            return false;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: p2$e */
    /* loaded from: classes.dex */
    public class e extends f2 {
        public e(Context context, z1 z1Var, View view, boolean z) {
            super(context, z1Var, view, z, z.actionOverflowMenuStyle, 0);
            this.g = 8388613;
            a(p2.this.C);
        }

        @Override // defpackage.f2
        public void c() {
            z1 z1Var = p2.this.e;
            if (z1Var != null) {
                z1Var.a(true);
            }
            p2.this.y = null;
            super.c();
        }
    }

    public p2(Context context) {
        super(context, f0.abc_action_menu_layout, f0.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.C = new f();
    }

    @Override // defpackage.u1, defpackage.g2
    public void a(Context context, z1 z1Var) {
        super.a(context, z1Var);
        Resources resources = context.getResources();
        if (!this.o) {
            int i = Build.VERSION.SDK_INT;
            this.n = true;
        }
        int i2 = 2;
        if (!this.u) {
            this.p = context.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.s) {
            Configuration configuration = context.getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            if (configuration.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960))) {
                i2 = 5;
            } else if (i3 >= 500 || ((i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640))) {
                i2 = 4;
            } else if (i3 >= 360) {
                i2 = 3;
            }
            this.r = i2;
        }
        int i5 = this.p;
        if (this.n) {
            if (this.k == null) {
                this.k = new d(this.c);
                if (this.m) {
                    this.k.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = i5;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean b() {
        return c() | d();
    }

    public boolean c() {
        h2 h2Var;
        c cVar = this.A;
        if (cVar != null && (h2Var = this.j) != null) {
            ((View) h2Var).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.y;
        if (eVar != null) {
            if (eVar.b()) {
                eVar.j.dismiss();
            }
            return true;
        }
        return false;
    }

    public boolean d() {
        a aVar = this.z;
        if (aVar != null) {
            if (aVar.b()) {
                aVar.j.dismiss();
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean e() {
        e eVar = this.y;
        return eVar != null && eVar.b();
    }

    public boolean f() {
        z1 z1Var;
        if (!this.n || e() || (z1Var = this.e) == null || this.j == null || this.A != null) {
            return false;
        }
        z1Var.a();
        if (z1Var.j.isEmpty()) {
            return false;
        }
        this.A = new c(new e(this.d, this.e, this.k, true));
        ((View) this.j).post(this.A);
        return true;
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: p2$f */
    /* loaded from: classes.dex */
    public class f implements g2.a {
        public f() {
        }

        @Override // defpackage.g2.a
        public boolean a(z1 z1Var) {
            p2 p2Var = p2.this;
            if (z1Var == p2Var.e) {
                return false;
            }
            p2Var.D = ((l2) z1Var).C.getItemId();
            g2.a aVar = p2.this.g;
            if (aVar != null) {
                return aVar.a(z1Var);
            }
            return false;
        }

        @Override // defpackage.g2.a
        public void a(z1 z1Var, boolean z) {
            if (z1Var instanceof l2) {
                z1Var.c().a(false);
            }
            g2.a aVar = p2.this.g;
            if (aVar != null) {
                aVar.a(z1Var, z);
            }
        }
    }

    @Override // defpackage.u1
    public View a(c2 c2Var, View view, ViewGroup viewGroup) {
        View actionView = c2Var.getActionView();
        if (actionView == null || c2Var.c()) {
            actionView = super.a(c2Var, view, viewGroup);
        }
        actionView.setVisibility(c2Var.D ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.u1, defpackage.g2
    public void a(boolean z) {
        ArrayList<c2> arrayList;
        super.a(z);
        ((View) this.j).requestLayout();
        z1 z1Var = this.e;
        boolean z2 = false;
        if (z1Var != null) {
            z1Var.a();
            ArrayList<c2> arrayList2 = z1Var.i;
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                g9 g9Var = arrayList2.get(i).B;
            }
        }
        z1 z1Var2 = this.e;
        if (z1Var2 != null) {
            z1Var2.a();
            arrayList = z1Var2.j;
        } else {
            arrayList = null;
        }
        if (this.n && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !arrayList.get(0).D;
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new d(this.c);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.j;
                actionMenuView.addView(this.k, actionMenuView.h());
            }
        } else {
            d dVar = this.k;
            if (dVar != null) {
                ViewParent parent = dVar.getParent();
                h2 h2Var = this.j;
                if (parent == h2Var) {
                    ((ViewGroup) h2Var).removeView(this.k);
                }
            }
        }
        ((ActionMenuView) this.j).setOverflowReserved(this.n);
    }

    @Override // defpackage.u1
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        super.a(viewGroup, i);
        return true;
    }

    @Override // defpackage.u1, defpackage.g2
    public boolean a(l2 l2Var) {
        boolean z = false;
        if (l2Var.hasVisibleItems()) {
            l2 l2Var2 = l2Var;
            while (true) {
                z1 z1Var = l2Var2.B;
                if (z1Var == this.e) {
                    break;
                }
                l2Var2 = (l2) z1Var;
            }
            c2 c2Var = l2Var2.C;
            ViewGroup viewGroup = (ViewGroup) this.j;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof h2.a) && ((h2.a) childAt).getItemData() == c2Var) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view == null) {
                return false;
            }
            l2Var.C.getItemId();
            int size = l2Var.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item = l2Var.getItem(i2);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.z = new a(this.d, l2Var, view);
            a aVar = this.z;
            aVar.h = z;
            e2 e2Var = aVar.j;
            if (e2Var != null) {
                e2Var.b(z);
            }
            if (this.z.d()) {
                super.a(l2Var);
                return true;
            }
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    @Override // defpackage.g2
    public boolean a() {
        ArrayList<c2> arrayList;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        p2 p2Var = this;
        z1 z1Var = p2Var.e;
        View view = null;
        ?? r3 = 0;
        if (z1Var != null) {
            arrayList = z1Var.d();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i5 = p2Var.r;
        int i6 = p2Var.q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) p2Var.j;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        int i9 = i5;
        for (int i10 = 0; i10 < i; i10++) {
            c2 c2Var = arrayList.get(i10);
            if (c2Var.requiresActionButton()) {
                i7++;
            } else if (c2Var.f()) {
                i8++;
            } else {
                z2 = true;
            }
            if (p2Var.v && c2Var.D) {
                i9 = 0;
            }
        }
        if (p2Var.n && (z2 || i8 + i7 > i9)) {
            i9--;
        }
        int i11 = i9 - i7;
        SparseBooleanArray sparseBooleanArray = p2Var.x;
        sparseBooleanArray.clear();
        if (p2Var.t) {
            int i12 = p2Var.w;
            i3 = i6 / i12;
            i2 = i12 + ((i6 % i12) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = 0;
        int i14 = i6;
        int i15 = 0;
        while (i15 < i) {
            c2 c2Var2 = arrayList.get(i15);
            if (c2Var2.requiresActionButton()) {
                View a2 = p2Var.a(c2Var2, view, viewGroup);
                if (p2Var.t) {
                    i3 -= ActionMenuView.b(a2, i2, i3, makeMeasureSpec, r3);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i13 != 0) {
                    measuredWidth = i13;
                }
                int i16 = c2Var2.b;
                if (i16 != 0) {
                    sparseBooleanArray.put(i16, true);
                }
                c2Var2.b(true);
                i13 = measuredWidth;
                z = r3;
                i4 = i;
            } else if (c2Var2.f()) {
                int i17 = c2Var2.b;
                boolean z3 = sparseBooleanArray.get(i17);
                boolean z4 = (i11 > 0 || z3) && i14 > 0 && (!p2Var.t || i3 > 0);
                boolean z5 = z4;
                i4 = i;
                if (z4) {
                    View a3 = p2Var.a(c2Var2, null, viewGroup);
                    if (p2Var.t) {
                        int b2 = ActionMenuView.b(a3, i2, i3, makeMeasureSpec, 0);
                        i3 -= b2;
                        z5 = b2 == 0 ? false : z5;
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = z5 & (!p2Var.t ? i14 + i13 <= 0 : i14 < 0);
                }
                if (z4 && i17 != 0) {
                    sparseBooleanArray.put(i17, true);
                } else if (z3) {
                    sparseBooleanArray.put(i17, false);
                    for (int i18 = 0; i18 < i15; i18++) {
                        c2 c2Var3 = arrayList.get(i18);
                        if (c2Var3.b == i17) {
                            if (c2Var3.d()) {
                                i11++;
                            }
                            c2Var3.b(false);
                        }
                    }
                }
                if (z4) {
                    i11--;
                }
                c2Var2.b(z4);
                z = false;
            } else {
                z = r3;
                i4 = i;
                c2Var2.b(z);
            }
            i15++;
            view = null;
            r3 = z;
            i = i4;
            p2Var = this;
        }
        return true;
    }

    @Override // defpackage.u1, defpackage.g2
    public void a(z1 z1Var, boolean z) {
        b();
        super.a(z1Var, z);
    }
}
