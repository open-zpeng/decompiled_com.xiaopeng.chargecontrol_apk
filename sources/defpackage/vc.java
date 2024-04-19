package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.ld;
import defpackage.vd;
/* compiled from: FragmentStateManager.java */
/* renamed from: vc  reason: default package */
/* loaded from: classes.dex */
public class vc {
    public final nc a;
    public final wc b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    /* compiled from: FragmentStateManager.java */
    /* renamed from: vc$a */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View c;

        public a(vc vcVar, View view) {
            this.c = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.c.removeOnAttachStateChangeListener(this);
            y9.u(this.c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public vc(nc ncVar, wc wcVar, Fragment fragment) {
        this.a = ncVar;
        this.b = wcVar;
        this.c = fragment;
    }

    public void a(ClassLoader classLoader) {
        Bundle bundle = this.c.d;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.c;
        fragment.e = fragment.d.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.c;
        fragment2.f = fragment2.d.getBundle("android:view_registry_state");
        Fragment fragment3 = this.c;
        fragment3.k = fragment3.d.getString("android:target_state");
        Fragment fragment4 = this.c;
        if (fragment4.k != null) {
            fragment4.l = fragment4.d.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.c;
        Boolean bool = fragment5.g;
        if (bool != null) {
            fragment5.L = bool.booleanValue();
            this.c.g = null;
        } else {
            fragment5.L = fragment5.d.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.c;
        if (fragment6.L) {
            return;
        }
        fragment6.K = true;
    }

    public void b() {
        int b = this.b.b(this.c);
        Fragment fragment = this.c;
        fragment.I.addView(fragment.J, b);
    }

    public void c() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("moveto ATTACHED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.j;
        vc vcVar = null;
        if (fragment2 != null) {
            vc e = this.b.e(fragment2.h);
            if (e != null) {
                Fragment fragment3 = this.c;
                fragment3.k = fragment3.j.h;
                fragment3.j = null;
                vcVar = e;
            } else {
                StringBuilder a3 = jg.a("Fragment ");
                a3.append(this.c);
                a3.append(" declared target fragment ");
                a3.append(this.c.j);
                a3.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(a3.toString());
            }
        } else {
            String str = fragment.k;
            if (str != null && (vcVar = this.b.e(str)) == null) {
                StringBuilder a4 = jg.a("Fragment ");
                a4.append(this.c);
                a4.append(" declared target fragment ");
                throw new IllegalStateException(jg.a(a4, this.c.k, " that does not belong to this FragmentManager!"));
            }
        }
        if (vcVar != null) {
            vcVar.k();
        }
        Fragment fragment4 = this.c;
        oc ocVar = fragment4.u;
        fragment4.v = ocVar.r;
        fragment4.x = ocVar.t;
        this.a.e(fragment4, false);
        this.c.g1();
        this.a.a(this.c, false);
    }

    public int d() {
        Fragment fragment = this.c;
        if (fragment.u == null) {
            return fragment.c;
        }
        int i = this.e;
        int ordinal = fragment.S.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        Fragment fragment2 = this.c;
        if (fragment2.p) {
            if (fragment2.q) {
                i = Math.max(this.e, 2);
                View view = this.c.J;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, fragment2.c) : Math.min(i, 1);
            }
        }
        if (!this.c.n) {
            i = Math.min(i, 1);
        }
        Fragment fragment3 = this.c;
        ViewGroup viewGroup = fragment3.I;
        ld.d.b d = viewGroup != null ? ld.a(viewGroup, fragment3.j0()).d(this) : null;
        if (d == ld.d.b.ADDING) {
            i = Math.min(i, 6);
        } else if (d == ld.d.b.REMOVING) {
            i = Math.max(i, 3);
        } else {
            Fragment fragment4 = this.c;
            if (fragment4.o) {
                if (fragment4.A0()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, -1);
                }
            }
        }
        Fragment fragment5 = this.c;
        if (fragment5.K && fragment5.c < 5) {
            i = Math.min(i, 4);
        }
        if (oc.c(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i + " for " + this.c);
        }
        return i;
    }

    public void e() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("moveto CREATED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        Fragment fragment = this.c;
        if (!fragment.R) {
            this.a.c(fragment, fragment.d, false);
            Fragment fragment2 = this.c;
            fragment2.f(fragment2.d);
            nc ncVar = this.a;
            Fragment fragment3 = this.c;
            ncVar.b(fragment3, fragment3.d, false);
            return;
        }
        fragment.i(fragment.d);
        this.c.c = 1;
    }

    public void f() {
        String str;
        if (this.c.p) {
            return;
        }
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("moveto CREATE_VIEW: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        Fragment fragment = this.c;
        LayoutInflater g = fragment.g(fragment.d);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.c;
        ViewGroup viewGroup2 = fragment2.I;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment2.z;
            if (i != 0) {
                if (i != -1) {
                    viewGroup = (ViewGroup) fragment2.u.s.a(i);
                    if (viewGroup == null) {
                        Fragment fragment3 = this.c;
                        if (!fragment3.r) {
                            try {
                                str = fragment3.p0().getResourceName(this.c.z);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            StringBuilder a3 = jg.a("No view found for id 0x");
                            a3.append(Integer.toHexString(this.c.z));
                            a3.append(" (");
                            a3.append(str);
                            a3.append(") for fragment ");
                            a3.append(this.c);
                            throw new IllegalArgumentException(a3.toString());
                        }
                    }
                } else {
                    StringBuilder a4 = jg.a("Cannot create fragment ");
                    a4.append(this.c);
                    a4.append(" for a container view with no id");
                    throw new IllegalArgumentException(a4.toString());
                }
            }
        }
        Fragment fragment4 = this.c;
        fragment4.I = viewGroup;
        fragment4.b(g, viewGroup, fragment4.d);
        View view = this.c.J;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.c;
            fragment5.J.setTag(mb.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.c;
            if (fragment6.B) {
                fragment6.J.setVisibility(8);
            }
            if (y9.q(this.c.J)) {
                View view2 = this.c.J;
                int i2 = Build.VERSION.SDK_INT;
                view2.requestApplyInsets();
            } else {
                View view3 = this.c.J;
                view3.addOnAttachStateChangeListener(new a(this, view3));
            }
            this.c.q1();
            nc ncVar = this.a;
            Fragment fragment7 = this.c;
            ncVar.a(fragment7, fragment7.J, fragment7.d, false);
            int visibility = this.c.J.getVisibility();
            this.c.b(this.c.J.getAlpha());
            Fragment fragment8 = this.c;
            if (fragment8.I != null && visibility == 0) {
                View findFocus = fragment8.J.findFocus();
                if (findFocus != null) {
                    this.c.b(findFocus);
                    if (oc.c(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c);
                    }
                }
                this.c.J.setAlpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            }
        }
        this.c.c = 2;
    }

    public void g() {
        Fragment b;
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("movefrom CREATED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        Fragment fragment = this.c;
        boolean z = true;
        boolean z2 = fragment.o && !fragment.A0();
        if (z2 || this.b.c.f(this.c)) {
            lc<?> lcVar = this.c.v;
            if (lcVar instanceof oe) {
                z = this.b.c.d();
            } else {
                Context context = lcVar.d;
                if (context instanceof Activity) {
                    z = true ^ ((Activity) context).isChangingConfigurations();
                }
            }
            if (z2 || z) {
                this.b.c.b(this.c);
            }
            this.c.h1();
            this.a.b(this.c, false);
            for (vc vcVar : this.b.b()) {
                if (vcVar != null) {
                    Fragment fragment2 = vcVar.c;
                    if (this.c.h.equals(fragment2.k)) {
                        fragment2.j = this.c;
                        fragment2.k = null;
                    }
                }
            }
            Fragment fragment3 = this.c;
            String str = fragment3.k;
            if (str != null) {
                fragment3.j = this.b.b(str);
            }
            this.b.b(this);
            return;
        }
        String str2 = this.c.k;
        if (str2 != null && (b = this.b.b(str2)) != null && b.D) {
            this.c.j = b;
        }
        this.c.c = 0;
    }

    public void h() {
        View view;
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("movefrom CREATE_VIEW: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.I;
        if (viewGroup != null && (view = fragment.J) != null) {
            viewGroup.removeView(view);
        }
        this.c.i1();
        this.a.i(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.I = null;
        fragment2.J = null;
        fragment2.U = null;
        fragment2.V.a((ee<zd>) null);
        this.c.q = false;
    }

    public void i() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("movefrom ATTACHED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        this.c.j1();
        boolean z = false;
        this.a.c(this.c, false);
        Fragment fragment = this.c;
        fragment.c = -1;
        fragment.v = null;
        fragment.x = null;
        fragment.u = null;
        if (fragment.o && !fragment.A0()) {
            z = true;
        }
        if (z || this.b.c.f(this.c)) {
            if (oc.c(3)) {
                StringBuilder a3 = jg.a("initState called for fragment: ");
                a3.append(this.c);
                Log.d("FragmentManager", a3.toString());
            }
            this.c.x0();
        }
    }

    public void j() {
        Fragment fragment = this.c;
        if (fragment.p && fragment.q && !fragment.s) {
            if (oc.c(3)) {
                StringBuilder a2 = jg.a("moveto CREATE_VIEW: ");
                a2.append(this.c);
                Log.d("FragmentManager", a2.toString());
            }
            Fragment fragment2 = this.c;
            fragment2.b(fragment2.g(fragment2.d), null, this.c.d);
            View view = this.c.J;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.J.setTag(mb.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.B) {
                    fragment4.J.setVisibility(8);
                }
                this.c.q1();
                nc ncVar = this.a;
                Fragment fragment5 = this.c;
                ncVar.a(fragment5, fragment5.J, fragment5.d, false);
                this.c.c = 2;
            }
        }
    }

    public void k() {
        if (this.d) {
            if (oc.c(2)) {
                StringBuilder a2 = jg.a("Ignoring re-entrant call to moveToExpectedState() for ");
                a2.append(this.c);
                Log.v("FragmentManager", a2.toString());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int d = d();
                if (d != this.c.c) {
                    if (d > this.c.c) {
                        switch (this.c.c + 1) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                if (this.c.J != null && this.c.I != null) {
                                    ld.a(this.c.I, this.c.j0()).a(ld.d.c.a(this.c.J.getVisibility()), this);
                                }
                                this.c.c = 4;
                                continue;
                            case 5:
                                o();
                                continue;
                            case 6:
                                this.c.c = 6;
                                continue;
                            case 7:
                                m();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (this.c.c - 1) {
                            case -1:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                this.c.c = 1;
                                continue;
                            case 2:
                                this.c.q = false;
                                this.c.c = 2;
                                continue;
                            case 3:
                                if (oc.c(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                                }
                                if (this.c.J != null && this.c.e == null) {
                                    n();
                                }
                                if (this.c.J != null && this.c.I != null) {
                                    ld.a(this.c.I, this.c.j0()).b(this);
                                }
                                this.c.c = 3;
                                continue;
                            case 4:
                                p();
                                continue;
                            case 5:
                                this.c.c = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                } else {
                    if (this.c.O) {
                        if (this.c.J != null && this.c.I != null) {
                            ld a3 = ld.a(this.c.I, this.c.j0());
                            if (this.c.B) {
                                a3.a(this);
                            } else {
                                a3.c(this);
                            }
                        }
                        if (this.c.u != null) {
                            this.c.u.j(this.c);
                        }
                        this.c.O = false;
                        Fragment fragment = this.c;
                        boolean z = this.c.B;
                        fragment.S0();
                    }
                    return;
                }
            }
        } finally {
            this.d = false;
        }
    }

    public void l() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("movefrom RESUMED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        this.c.l1();
        this.a.d(this.c, false);
    }

    public void m() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("moveto RESUMED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        View b0 = this.c.b0();
        if (b0 != null) {
            boolean z = true;
            if (b0 != this.c.J) {
                ViewParent parent = b0.getParent();
                while (true) {
                    if (parent == null) {
                        z = false;
                        break;
                    } else if (parent == this.c.J) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            if (z) {
                boolean requestFocus = b0.requestFocus();
                if (oc.c(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestFocus: Restoring focused view ");
                    sb.append(b0);
                    sb.append(" ");
                    sb.append(requestFocus ? "succeeded" : "failed");
                    sb.append(" on Fragment ");
                    sb.append(this.c);
                    sb.append(" resulting in focused view ");
                    sb.append(this.c.J.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            }
        }
        this.c.b((View) null);
        this.c.n1();
        this.a.f(this.c, false);
        Fragment fragment = this.c;
        fragment.d = null;
        fragment.e = null;
        fragment.f = null;
    }

    public void n() {
        if (this.c.J == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.c.J.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.c.e = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.c.U.e.b.a(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.c.f = bundle;
    }

    public void o() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("moveto STARTED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        this.c.o1();
        this.a.g(this.c, false);
    }

    public void p() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("movefrom STARTED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        this.c.p1();
        this.a.h(this.c, false);
    }

    public vc(nc ncVar, wc wcVar, ClassLoader classLoader, kc kcVar, uc ucVar) {
        this.a = ncVar;
        this.b = wcVar;
        this.c = kcVar.a(classLoader, ucVar.c);
        Bundle bundle = ucVar.l;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.c.k(ucVar.l);
        Fragment fragment = this.c;
        fragment.h = ucVar.d;
        fragment.p = ucVar.e;
        fragment.r = true;
        fragment.y = ucVar.f;
        fragment.z = ucVar.g;
        fragment.A = ucVar.h;
        fragment.D = ucVar.i;
        fragment.o = ucVar.j;
        fragment.C = ucVar.k;
        fragment.B = ucVar.m;
        fragment.S = vd.b.values()[ucVar.n];
        Bundle bundle2 = ucVar.o;
        if (bundle2 != null) {
            this.c.d = bundle2;
        } else {
            this.c.d = new Bundle();
        }
        if (oc.c(2)) {
            StringBuilder a2 = jg.a("Instantiated fragment ");
            a2.append(this.c);
            Log.v("FragmentManager", a2.toString());
        }
    }

    public void a() {
        if (oc.c(3)) {
            StringBuilder a2 = jg.a("moveto ACTIVITY_CREATED: ");
            a2.append(this.c);
            Log.d("FragmentManager", a2.toString());
        }
        Fragment fragment = this.c;
        fragment.e(fragment.d);
        nc ncVar = this.a;
        Fragment fragment2 = this.c;
        ncVar.a(fragment2, fragment2.d, false);
    }

    public vc(nc ncVar, wc wcVar, Fragment fragment, uc ucVar) {
        this.a = ncVar;
        this.b = wcVar;
        this.c = fragment;
        Fragment fragment2 = this.c;
        fragment2.e = null;
        fragment2.f = null;
        fragment2.t = 0;
        fragment2.q = false;
        fragment2.n = false;
        Fragment fragment3 = fragment2.j;
        fragment2.k = fragment3 != null ? fragment3.h : null;
        Fragment fragment4 = this.c;
        fragment4.j = null;
        Bundle bundle = ucVar.o;
        if (bundle != null) {
            fragment4.d = bundle;
        } else {
            fragment4.d = new Bundle();
        }
    }
}
