package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import defpackage.oc;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* renamed from: nc  reason: default package */
/* loaded from: classes.dex */
public class nc {
    public final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();
    public final oc b;

    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    /* renamed from: nc$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final oc.l a;
        public final boolean b;

        public a(oc.l lVar, boolean z) {
            this.a = lVar;
            this.b = z;
        }
    }

    public nc(oc ocVar) {
        this.b = ocVar;
    }

    public void a(oc.l lVar) {
        synchronized (this.a) {
            int i = 0;
            int size = this.a.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.a.get(i).a == lVar) {
                    this.a.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    public void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.b(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.c();
            }
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.c(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.h();
            }
        }
    }

    public void d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.d(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.f();
            }
        }
    }

    public void e(Fragment fragment, boolean z) {
        oc ocVar = this.b;
        Context context = ocVar.r.d;
        Fragment fragment2 = ocVar.t;
        if (fragment2 != null) {
            fragment2.j0().o.e(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.g();
            }
        }
    }

    public void f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.f(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.i();
            }
        }
    }

    public void g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.g(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.k();
            }
        }
    }

    public void h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.h(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.l();
            }
        }
    }

    public void i(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.i(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment);
            }
        }
    }

    public void a(Fragment fragment, boolean z) {
        oc ocVar = this.b;
        Context context = ocVar.r.d;
        Fragment fragment2 = ocVar.t;
        if (fragment2 != null) {
            fragment2.j0().o.a(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.b();
            }
        }
    }

    public void b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.b(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.d();
            }
        }
    }

    public void c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.c(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.e();
            }
        }
    }

    public void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.d(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.j();
            }
        }
    }

    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.a(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a();
            }
        }
    }

    public void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.t;
        if (fragment2 != null) {
            fragment2.j0().o.a(fragment, view, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment, view, bundle);
            }
        }
    }
}
