package defpackage;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: SupportRequestManagerFragment.java */
/* renamed from: xo  reason: default package */
/* loaded from: classes.dex */
public class xo extends Fragment {
    public final jo a0;
    public final vo b0;
    public final Set<xo> c0;
    public xo d0;
    public ug e0;
    public Fragment f0;

    /* compiled from: SupportRequestManagerFragment.java */
    /* renamed from: xo$a */
    /* loaded from: classes.dex */
    public class a implements vo {
        public a() {
        }

        @Override // defpackage.vo
        public Set<ug> a() {
            Set<xo> v1 = xo.this.v1();
            HashSet hashSet = new HashSet(v1.size());
            for (xo xoVar : v1) {
                if (xoVar.y1() != null) {
                    hashSet.add(xoVar.y1());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + xo.this + "}";
        }
    }

    public xo() {
        jo joVar = new jo();
        this.b0 = new a();
        this.c0 = new HashSet();
        this.a0 = joVar;
    }

    public final void A1() {
        xo xoVar = this.d0;
        if (xoVar != null) {
            xoVar.c0.remove(this);
            this.d0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void O0() {
        super.O0();
        this.a0.a();
        A1();
    }

    @Override // androidx.fragment.app.Fragment
    public void R0() {
        this.H = true;
        this.f0 = null;
        A1();
    }

    public void a(ug ugVar) {
        this.e0 = ugVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void d1() {
        this.H = true;
        this.a0.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void e1() {
        this.H = true;
        this.a0.c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + x1() + "}";
    }

    public Set<xo> v1() {
        boolean z;
        xo xoVar = this.d0;
        if (xoVar == null) {
            return Collections.emptySet();
        }
        if (equals(xoVar)) {
            return Collections.unmodifiableSet(this.c0);
        }
        HashSet hashSet = new HashSet();
        for (xo xoVar2 : this.d0.v1()) {
            Fragment x1 = xoVar2.x1();
            Fragment x12 = x1();
            while (true) {
                Fragment i0 = x1.i0();
                if (i0 == null) {
                    z = false;
                    break;
                } else if (i0.equals(x12)) {
                    z = true;
                    break;
                } else {
                    x1 = x1.i0();
                }
            }
            if (z) {
                hashSet.add(xoVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public jo w1() {
        return this.a0;
    }

    public final Fragment x1() {
        Fragment i0 = i0();
        return i0 != null ? i0 : this.f0;
    }

    public ug y1() {
        return this.e0;
    }

    public vo z1() {
        return this.b0;
    }

    public void a(Fragment fragment) {
        this.f0 = fragment;
        if (fragment == null || fragment.U() == null) {
            return;
        }
        Fragment fragment2 = fragment;
        while (fragment2.i0() != null) {
            fragment2 = fragment2.i0();
        }
        oc c0 = fragment2.c0();
        if (c0 == null) {
            return;
        }
        a(fragment.U(), c0);
    }

    public final void a(Context context, oc ocVar) {
        A1();
        this.d0 = lg.a(context).h.a(context, ocVar);
        if (equals(this.d0)) {
            return;
        }
        this.d0.c0.add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        Fragment fragment = this;
        while (fragment.i0() != null) {
            fragment = fragment.i0();
        }
        oc c0 = fragment.c0();
        if (c0 == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            a(U(), c0);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }
}
