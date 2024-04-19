package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.j0;
import defpackage.l1;
import defpackage.z1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: WindowDecorActionBar.java */
/* renamed from: h1  reason: default package */
/* loaded from: classes.dex */
public class h1 extends j0 implements ActionBarOverlayLayout.d {
    public static final Interpolator B = new AccelerateInterpolator();
    public static final Interpolator C = new DecelerateInterpolator();
    public final ia A;
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public s3 e;
    public ActionBarContextView f;
    public View g;
    public g4 h;
    public boolean i;
    public d j;
    public l1 k;
    public l1.a l;
    public boolean m;
    public ArrayList<j0.b> n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public r1 v;
    public boolean w;
    public boolean x;
    public final ga y;
    public final ga z;

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: h1$a */
    /* loaded from: classes.dex */
    public class a extends ha {
        public a() {
        }

        @Override // defpackage.ga
        public void b(View view) {
            View view2;
            h1 h1Var = h1.this;
            if (h1Var.q && (view2 = h1Var.g) != null) {
                view2.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                h1.this.d.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            }
            h1.this.d.setVisibility(8);
            h1.this.d.setTransitioning(false);
            h1 h1Var2 = h1.this;
            h1Var2.v = null;
            l1.a aVar = h1Var2.l;
            if (aVar != null) {
                aVar.a(h1Var2.k);
                h1Var2.k = null;
                h1Var2.l = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = h1.this.c;
            if (actionBarOverlayLayout != null) {
                y9.u(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: h1$b */
    /* loaded from: classes.dex */
    public class b extends ha {
        public b() {
        }

        @Override // defpackage.ga
        public void b(View view) {
            h1 h1Var = h1.this;
            h1Var.v = null;
            h1Var.d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: h1$c */
    /* loaded from: classes.dex */
    public class c implements ia {
        public c() {
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: h1$d */
    /* loaded from: classes.dex */
    public class d extends l1 implements z1.a {
        public final Context e;
        public final z1 f;
        public l1.a g;
        public WeakReference<View> h;

        public d(Context context, l1.a aVar) {
            this.e = context;
            this.g = aVar;
            z1 z1Var = new z1(context);
            z1Var.l = 1;
            this.f = z1Var;
            this.f.a(this);
        }

        @Override // defpackage.l1
        public void a(boolean z) {
            this.d = z;
            h1.this.f.setTitleOptional(z);
        }

        @Override // defpackage.l1
        public void b(CharSequence charSequence) {
            h1.this.f.setTitle(charSequence);
        }

        @Override // defpackage.l1
        public Menu c() {
            return this.f;
        }

        @Override // defpackage.l1
        public MenuInflater d() {
            return new q1(this.e);
        }

        @Override // defpackage.l1
        public CharSequence e() {
            return h1.this.f.getSubtitle();
        }

        @Override // defpackage.l1
        public CharSequence f() {
            return h1.this.f.getTitle();
        }

        @Override // defpackage.l1
        public void g() {
            if (h1.this.j != this) {
                return;
            }
            this.f.k();
            try {
                this.g.a(this, this.f);
            } finally {
                this.f.j();
            }
        }

        @Override // defpackage.l1
        public boolean h() {
            return h1.this.f.c();
        }

        @Override // defpackage.l1
        public void b(int i) {
            b(h1.this.a.getResources().getString(i));
        }

        @Override // defpackage.l1
        public void a() {
            h1 h1Var = h1.this;
            if (h1Var.j != this) {
                return;
            }
            boolean z = h1Var.r;
            boolean z2 = h1Var.s;
            boolean z3 = true;
            if (z || z2) {
                z3 = false;
            }
            if (!z3) {
                h1 h1Var2 = h1.this;
                h1Var2.k = this;
                h1Var2.l = this.g;
            } else {
                this.g.a(this);
            }
            this.g = null;
            h1.this.d(false);
            h1.this.f.a();
            ((p4) h1.this.e).a.sendAccessibilityEvent(32);
            h1 h1Var3 = h1.this;
            h1Var3.c.setHideOnContentScrollEnabled(h1Var3.x);
            h1.this.j = null;
        }

        @Override // defpackage.l1
        public View b() {
            WeakReference<View> weakReference = this.h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // defpackage.l1
        public void a(View view) {
            h1.this.f.setCustomView(view);
            this.h = new WeakReference<>(view);
        }

        @Override // defpackage.l1
        public void a(CharSequence charSequence) {
            h1.this.f.setSubtitle(charSequence);
        }

        @Override // defpackage.l1
        public void a(int i) {
            a(h1.this.a.getResources().getString(i));
        }

        @Override // defpackage.z1.a
        public boolean a(z1 z1Var, MenuItem menuItem) {
            l1.a aVar = this.g;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // defpackage.z1.a
        public void a(z1 z1Var) {
            if (this.g == null) {
                return;
            }
            g();
            h1.this.f.e();
        }
    }

    public h1(Activity activity, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.g = decorView.findViewById(16908290);
    }

    public final void a(View view) {
        s3 wrapper;
        this.c = (ActionBarOverlayLayout) view.findViewById(e0.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(e0.action_bar);
        if (findViewById instanceof s3) {
            wrapper = (s3) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder a2 = jg.a("Can't make a decor toolbar out of ");
            a2.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(a2.toString());
        }
        this.e = wrapper;
        this.f = (ActionBarContextView) view.findViewById(e0.action_context_bar);
        this.d = (ActionBarContainer) view.findViewById(e0.action_bar_container);
        s3 s3Var = this.e;
        if (s3Var != null && this.f != null && this.d != null) {
            this.a = ((p4) s3Var).a();
            boolean z = (((p4) this.e).b & 4) != 0;
            if (z) {
                this.i = true;
            }
            Context context = this.a;
            ((p4) this.e).a((context.getApplicationInfo().targetSdkVersion < 14) || z);
            e(context.getResources().getBoolean(a0.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, i0.ActionBar, z.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(i0.ActionBar_hideOnContentScroll, false)) {
                if (this.c.i()) {
                    this.x = true;
                    this.c.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i0.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                y9.a(this.d, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(h1.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    @Override // defpackage.j0
    public int b() {
        return ((p4) this.e).b;
    }

    @Override // defpackage.j0
    public void c(boolean z) {
        r1 r1Var;
        this.w = z;
        if (z || (r1Var = this.v) == null) {
            return;
        }
        r1Var.a();
    }

    public void d(boolean z) {
        fa a2;
        fa a3;
        if (z) {
            if (!this.t) {
                this.t = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        if (!y9.r(this.d)) {
            if (z) {
                ((p4) this.e).a.setVisibility(4);
                this.f.setVisibility(0);
                return;
            }
            ((p4) this.e).a.setVisibility(0);
            this.f.setVisibility(8);
            return;
        }
        if (z) {
            a3 = ((p4) this.e).a(4, 100L);
            a2 = this.f.a(0, 200L);
        } else {
            a2 = ((p4) this.e).a(0, 200L);
            a3 = this.f.a(8, 100L);
        }
        r1 r1Var = new r1();
        r1Var.a.add(a3);
        View view = a3.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = a2.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        r1Var.a.add(a2);
        r1Var.b();
    }

    public void e() {
    }

    public final void e(boolean z) {
        this.o = z;
        if (!this.o) {
            ((p4) this.e).a((g4) null);
            this.d.setTabContainer(this.h);
        } else {
            this.d.setTabContainer(null);
            ((p4) this.e).a(this.h);
        }
        boolean z2 = true;
        boolean z3 = ((p4) this.e).o == 2;
        g4 g4Var = this.h;
        if (g4Var != null) {
            if (z3) {
                g4Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    y9.u(actionBarOverlayLayout);
                }
            } else {
                g4Var.setVisibility(8);
            }
        }
        ((p4) this.e).a.setCollapsible(!this.o && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
        if (this.o || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    public final void f(boolean z) {
        View view;
        int[] iArr;
        View view2;
        View view3;
        int[] iArr2;
        if (this.t || !(this.r || this.s)) {
            if (this.u) {
                return;
            }
            this.u = true;
            r1 r1Var = this.v;
            if (r1Var != null) {
                r1Var.a();
            }
            this.d.setVisibility(0);
            if (this.p == 0 && (this.w || z)) {
                this.d.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                float f = -this.d.getHeight();
                if (z) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f -= iArr2[1];
                }
                this.d.setTranslationY(f);
                r1 r1Var2 = new r1();
                fa a2 = y9.a(this.d);
                a2.b(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                a2.a(this.A);
                if (!r1Var2.e) {
                    r1Var2.a.add(a2);
                }
                if (this.q && (view3 = this.g) != null) {
                    view3.setTranslationY(f);
                    fa a3 = y9.a(this.g);
                    a3.b(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                    if (!r1Var2.e) {
                        r1Var2.a.add(a3);
                    }
                }
                Interpolator interpolator = C;
                if (!r1Var2.e) {
                    r1Var2.c = interpolator;
                }
                if (!r1Var2.e) {
                    r1Var2.b = 250L;
                }
                ga gaVar = this.z;
                if (!r1Var2.e) {
                    r1Var2.d = gaVar;
                }
                this.v = r1Var2;
                r1Var2.b();
            } else {
                this.d.setAlpha(1.0f);
                this.d.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                if (this.q && (view2 = this.g) != null) {
                    view2.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                }
                this.z.b(null);
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.c;
            if (actionBarOverlayLayout != null) {
                y9.u(actionBarOverlayLayout);
            }
        } else if (this.u) {
            this.u = false;
            r1 r1Var3 = this.v;
            if (r1Var3 != null) {
                r1Var3.a();
            }
            if (this.p == 0 && (this.w || z)) {
                this.d.setAlpha(1.0f);
                this.d.setTransitioning(true);
                r1 r1Var4 = new r1();
                float f2 = -this.d.getHeight();
                if (z) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f2 -= iArr[1];
                }
                fa a4 = y9.a(this.d);
                a4.b(f2);
                a4.a(this.A);
                if (!r1Var4.e) {
                    r1Var4.a.add(a4);
                }
                if (this.q && (view = this.g) != null) {
                    fa a5 = y9.a(view);
                    a5.b(f2);
                    if (!r1Var4.e) {
                        r1Var4.a.add(a5);
                    }
                }
                Interpolator interpolator2 = B;
                if (!r1Var4.e) {
                    r1Var4.c = interpolator2;
                }
                if (!r1Var4.e) {
                    r1Var4.b = 250L;
                }
                ga gaVar2 = this.y;
                if (!r1Var4.e) {
                    r1Var4.d = gaVar2;
                }
                this.v = r1Var4;
                r1Var4.b();
                return;
            }
            this.y.b(null);
        }
    }

    @Override // defpackage.j0
    public void b(boolean z) {
        if (this.i) {
            return;
        }
        int i = z ? 4 : 0;
        p4 p4Var = (p4) this.e;
        int i2 = p4Var.b;
        this.i = true;
        p4Var.a((i & 4) | (i2 & (-5)));
    }

    @Override // defpackage.j0
    public Context c() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(z.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    public h1(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        a(dialog.getWindow().getDecorView());
    }

    @Override // defpackage.j0
    public void a(Configuration configuration) {
        e(this.a.getResources().getBoolean(a0.abc_action_bar_embed_tabs));
    }

    @Override // defpackage.j0
    public void a(boolean z) {
        if (z == this.m) {
            return;
        }
        this.m = z;
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            this.n.get(i).a(z);
        }
    }

    @Override // defpackage.j0
    public void a(CharSequence charSequence) {
        ((p4) this.e).b(charSequence);
    }

    @Override // defpackage.j0
    public l1 a(l1.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.d();
        d dVar2 = new d(this.f.getContext(), aVar);
        dVar2.f.k();
        try {
            if (dVar2.g.b(dVar2, dVar2.f)) {
                this.j = dVar2;
                dVar2.g();
                this.f.a(dVar2);
                d(true);
                this.f.sendAccessibilityEvent(32);
                return dVar2;
            }
            return null;
        } finally {
            dVar2.f.j();
        }
    }

    @Override // defpackage.j0
    public boolean a() {
        s3 s3Var = this.e;
        if (s3Var == null || !((p4) s3Var).a.j()) {
            return false;
        }
        ((p4) this.e).a.c();
        return true;
    }

    @Override // defpackage.j0
    public boolean a(int i, KeyEvent keyEvent) {
        z1 z1Var;
        d dVar = this.j;
        if (dVar == null || (z1Var = dVar.f) == null) {
            return false;
        }
        z1Var.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return z1Var.performShortcut(i, keyEvent, 0);
    }
}
