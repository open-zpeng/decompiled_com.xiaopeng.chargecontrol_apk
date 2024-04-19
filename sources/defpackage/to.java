package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: RequestManagerFragment.java */
@Deprecated
/* renamed from: to  reason: default package */
/* loaded from: classes.dex */
public class to extends Fragment {
    public final jo c;
    public final vo d;
    public final Set<to> e;
    public ug f;
    public to g;
    public Fragment h;

    /* compiled from: RequestManagerFragment.java */
    /* renamed from: to$a */
    /* loaded from: classes.dex */
    public class a implements vo {
        public a() {
        }

        @Override // defpackage.vo
        public Set<ug> a() {
            Set<to> a = to.this.a();
            HashSet hashSet = new HashSet(a.size());
            for (to toVar : a) {
                ug ugVar = toVar.f;
                if (ugVar != null) {
                    hashSet.add(ugVar);
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + to.this + "}";
        }
    }

    public to() {
        jo joVar = new jo();
        this.d = new a();
        this.e = new HashSet();
        this.c = joVar;
    }

    @TargetApi(17)
    public Set<to> a() {
        boolean z;
        if (equals(this.g)) {
            return Collections.unmodifiableSet(this.e);
        }
        if (this.g != null) {
            int i = Build.VERSION.SDK_INT;
            HashSet hashSet = new HashSet();
            for (to toVar : this.g.a()) {
                Fragment parentFragment = toVar.getParentFragment();
                Fragment parentFragment2 = getParentFragment();
                while (true) {
                    Fragment parentFragment3 = parentFragment.getParentFragment();
                    if (parentFragment3 == null) {
                        z = false;
                        break;
                    } else if (parentFragment3.equals(parentFragment2)) {
                        z = true;
                        break;
                    } else {
                        parentFragment = parentFragment.getParentFragment();
                    }
                }
                if (z) {
                    hashSet.add(toVar);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    public final void b() {
        to toVar = this.g;
        if (toVar != null) {
            toVar.e.remove(this);
            this.g = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.c.a();
        b();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        b();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.c.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.c.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        int i = Build.VERSION.SDK_INT;
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.h;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    public final void a(Activity activity) {
        b();
        this.g = lg.a(activity).h.b(activity);
        if (equals(this.g)) {
            return;
        }
        this.g.e.add(this);
    }
}
