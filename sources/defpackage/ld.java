package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.m8;
import defpackage.oc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* compiled from: SpecialEffectsController.java */
/* renamed from: ld  reason: default package */
/* loaded from: classes.dex */
public abstract class ld {
    public final ViewGroup a;
    public final ArrayList<d> b = new ArrayList<>();
    public final ArrayList<d> c = new ArrayList<>();
    public boolean d = false;
    public boolean e = false;

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: ld$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ c c;

        public a(c cVar) {
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ld.this.b.contains(this.c)) {
                c cVar = this.c;
                cVar.a.a(cVar.c.J);
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: ld$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ c c;

        public b(c cVar) {
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ld.this.b.remove(this.c);
            ld.this.c.remove(this.c);
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: ld$c */
    /* loaded from: classes.dex */
    public static class c extends d {
        public final vc h;

        public c(d.c cVar, d.b bVar, vc vcVar, m8 m8Var) {
            super(cVar, bVar, vcVar.c, m8Var);
            this.h = vcVar;
        }

        @Override // defpackage.ld.d
        public void b() {
            super.b();
            this.h.k();
        }

        @Override // defpackage.ld.d
        public void c() {
            if (this.b == d.b.ADDING) {
                Fragment fragment = this.h.c;
                View findFocus = fragment.J.findFocus();
                if (findFocus != null) {
                    fragment.b(findFocus);
                    if (oc.c(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                    }
                }
                View t1 = this.c.t1();
                if (t1.getParent() == null) {
                    this.h.b();
                    t1.setAlpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                }
                if (t1.getAlpha() == XToggleDrawable.LIGHT_RADIUS_DEFAULT && t1.getVisibility() == 0) {
                    t1.setVisibility(4);
                }
                t1.setAlpha(fragment.n0());
            }
        }
    }

    public ld(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static ld a(ViewGroup viewGroup, oc ocVar) {
        return a(viewGroup, ocVar.p());
    }

    public abstract void a(List<d> list, boolean z);

    public void b(vc vcVar) {
        if (oc.c(2)) {
            StringBuilder a2 = jg.a("SpecialEffectsController: Enqueuing remove operation for fragment ");
            a2.append(vcVar.c);
            Log.v("FragmentManager", a2.toString());
        }
        a(d.c.REMOVED, d.b.REMOVING, vcVar);
    }

    public void c(vc vcVar) {
        if (oc.c(2)) {
            StringBuilder a2 = jg.a("SpecialEffectsController: Enqueuing show operation for fragment ");
            a2.append(vcVar.c);
            Log.v("FragmentManager", a2.toString());
        }
        a(d.c.VISIBLE, d.b.NONE, vcVar);
    }

    public d.b d(vc vcVar) {
        d a2 = a(vcVar.c);
        d dVar = null;
        d.b bVar = a2 != null ? a2.b : null;
        Fragment fragment = vcVar.c;
        Iterator<d> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.c.equals(fragment) && !next.f) {
                dVar = next;
                break;
            }
        }
        return (dVar == null || !(bVar == null || bVar == d.b.NONE)) ? bVar : dVar.b;
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: ld$d */
    /* loaded from: classes.dex */
    public static class d {
        public c a;
        public b b;
        public final Fragment c;
        public final List<Runnable> d = new ArrayList();
        public final HashSet<m8> e = new HashSet<>();
        public boolean f = false;
        public boolean g = false;

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: ld$d$a */
        /* loaded from: classes.dex */
        public class a implements m8.a {
            public a() {
            }

            @Override // defpackage.m8.a
            public void a() {
                d.this.a();
            }
        }

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: ld$d$b */
        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        public d(c cVar, b bVar, Fragment fragment, m8 m8Var) {
            this.a = cVar;
            this.b = bVar;
            this.c = fragment;
            m8Var.a(new a());
        }

        public final void a() {
            if (this.f) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                b();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((m8) it.next()).a();
            }
        }

        public void b() {
            if (this.g) {
                return;
            }
            if (oc.c(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            for (Runnable runnable : this.d) {
                runnable.run();
            }
        }

        public void c() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
        }

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: ld$d$c */
        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c a(int i) {
                if (i != 0) {
                    if (i != 4) {
                        if (i == 8) {
                            return GONE;
                        }
                        throw new IllegalArgumentException(jg.a("Unknown visibility ", i));
                    }
                    return INVISIBLE;
                }
                return VISIBLE;
            }

            public static c b(View view) {
                if (view.getAlpha() == XToggleDrawable.LIGHT_RADIUS_DEFAULT && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return a(view.getVisibility());
            }

            public void a(View view) {
                int ordinal = ordinal();
                if (ordinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (oc.c(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (ordinal == 1) {
                    if (oc.c(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (ordinal == 2) {
                    if (oc.c(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (ordinal != 3) {
                } else {
                    if (oc.c(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        public final void a(c cVar, b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal == 0) {
                if (this.a != c.REMOVED) {
                    if (oc.c(2)) {
                        StringBuilder a2 = jg.a("SpecialEffectsController: For fragment ");
                        a2.append(this.c);
                        a2.append(" mFinalState = ");
                        a2.append(this.a);
                        a2.append(" -> ");
                        a2.append(cVar);
                        a2.append(". ");
                        Log.v("FragmentManager", a2.toString());
                    }
                    this.a = cVar;
                }
            } else if (ordinal == 1) {
                if (this.a == c.REMOVED) {
                    if (oc.c(2)) {
                        StringBuilder a3 = jg.a("SpecialEffectsController: For fragment ");
                        a3.append(this.c);
                        a3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        a3.append(this.b);
                        a3.append(" to ADDING.");
                        Log.v("FragmentManager", a3.toString());
                    }
                    this.a = c.VISIBLE;
                    this.b = b.ADDING;
                }
            } else if (ordinal != 2) {
            } else {
                if (oc.c(2)) {
                    StringBuilder a4 = jg.a("SpecialEffectsController: For fragment ");
                    a4.append(this.c);
                    a4.append(" mFinalState = ");
                    a4.append(this.a);
                    a4.append(" -> REMOVED. mLifecycleImpact  = ");
                    a4.append(this.b);
                    a4.append(" to REMOVING.");
                    Log.v("FragmentManager", a4.toString());
                }
                this.a = c.REMOVED;
                this.b = b.REMOVING;
            }
        }
    }

    public static ld a(ViewGroup viewGroup, md mdVar) {
        Object tag = viewGroup.getTag(mb.special_effects_controller_view_tag);
        if (tag instanceof ld) {
            return (ld) tag;
        }
        ld a2 = ((oc.f) mdVar).a(viewGroup);
        viewGroup.setTag(mb.special_effects_controller_view_tag, a2);
        return a2;
    }

    public void b() {
        String str;
        String str2;
        boolean q = y9.q(this.a);
        synchronized (this.b) {
            d();
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            Iterator it2 = new ArrayList(this.c).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (oc.c(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (q) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(dVar);
                    Log.v("FragmentManager", sb.toString());
                }
                dVar.a();
            }
            Iterator it3 = new ArrayList(this.b).iterator();
            while (it3.hasNext()) {
                d dVar2 = (d) it3.next();
                if (oc.c(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (q) {
                        str = "";
                    } else {
                        str = "Container " + this.a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(dVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                dVar2.a();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            d();
            this.e = false;
            int size = this.b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.b.get(size);
                d.c b2 = d.c.b(dVar.c.J);
                if (dVar.a == d.c.VISIBLE && b2 != d.c.VISIBLE) {
                    this.e = dVar.c.C0();
                    break;
                }
                size--;
            }
        }
    }

    public final d a(Fragment fragment) {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.c.equals(fragment) && !next.f) {
                return next;
            }
        }
        return null;
    }

    public final void d() {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.b == d.b.ADDING) {
                next.a(d.c.a(next.c.t1().getVisibility()), d.b.NONE);
            }
        }
    }

    public void a(d.c cVar, vc vcVar) {
        if (oc.c(2)) {
            StringBuilder a2 = jg.a("SpecialEffectsController: Enqueuing add operation for fragment ");
            a2.append(vcVar.c);
            Log.v("FragmentManager", a2.toString());
        }
        a(cVar, d.b.ADDING, vcVar);
    }

    public void a(vc vcVar) {
        if (oc.c(2)) {
            StringBuilder a2 = jg.a("SpecialEffectsController: Enqueuing hide operation for fragment ");
            a2.append(vcVar.c);
            Log.v("FragmentManager", a2.toString());
        }
        a(d.c.GONE, d.b.NONE, vcVar);
    }

    public final void a(d.c cVar, d.b bVar, vc vcVar) {
        synchronized (this.b) {
            m8 m8Var = new m8();
            d a2 = a(vcVar.c);
            if (a2 != null) {
                a2.a(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, vcVar, m8Var);
            this.b.add(cVar2);
            cVar2.d.add(new a(cVar2));
            cVar2.d.add(new b(cVar2));
        }
    }

    public void a() {
        if (this.e) {
            return;
        }
        if (!y9.q(this.a)) {
            b();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.c);
                this.c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (oc.c(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dVar);
                    }
                    dVar.a();
                    if (!dVar.g) {
                        this.c.add(dVar);
                    }
                }
                d();
                ArrayList arrayList2 = new ArrayList(this.b);
                this.b.clear();
                this.c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).c();
                }
                a(arrayList2, this.d);
                this.d = false;
            }
        }
    }
}
