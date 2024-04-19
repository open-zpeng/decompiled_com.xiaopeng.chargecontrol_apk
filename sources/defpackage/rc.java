package defpackage;

import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* compiled from: FragmentManagerViewModel.java */
/* renamed from: rc  reason: default package */
/* loaded from: classes.dex */
public final class rc extends je {
    public static final ke i = new a();
    public final boolean e;
    public final HashMap<String, Fragment> b = new HashMap<>();
    public final HashMap<String, rc> c = new HashMap<>();
    public final HashMap<String, ne> d = new HashMap<>();
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;

    /* compiled from: FragmentManagerViewModel.java */
    /* renamed from: rc$a */
    /* loaded from: classes.dex */
    public class a implements ke {
        @Override // defpackage.ke
        public <T extends je> T a(Class<T> cls) {
            return new rc(true);
        }
    }

    public rc(boolean z) {
        this.e = z;
    }

    public void a(boolean z) {
        this.h = z;
    }

    @Override // defpackage.je
    public void b() {
        if (oc.c(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    public Collection<Fragment> c() {
        return new ArrayList(this.b.values());
    }

    public boolean d() {
        return this.f;
    }

    public void e(Fragment fragment) {
        if (this.h) {
            if (oc.c(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.b.remove(fragment.h) != null) && oc.c(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rc.class != obj.getClass()) {
            return false;
        }
        rc rcVar = (rc) obj;
        return this.b.equals(rcVar.b) && this.c.equals(rcVar.c) && this.d.equals(rcVar.d);
    }

    public boolean f(Fragment fragment) {
        if (this.b.containsKey(fragment.h)) {
            if (this.e) {
                return this.f;
            }
            return !this.g;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.c.hashCode();
        return this.d.hashCode() + ((hashCode + (this.b.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public void a(Fragment fragment) {
        if (this.h) {
            if (oc.c(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.b.containsKey(fragment.h)) {
        } else {
            this.b.put(fragment.h, fragment);
            if (oc.c(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public rc c(Fragment fragment) {
        rc rcVar = this.c.get(fragment.h);
        if (rcVar == null) {
            rc rcVar2 = new rc(this.e);
            this.c.put(fragment.h, rcVar2);
            return rcVar2;
        }
        return rcVar;
    }

    public ne d(Fragment fragment) {
        ne neVar = this.d.get(fragment.h);
        if (neVar == null) {
            ne neVar2 = new ne();
            this.d.put(fragment.h, neVar2);
            return neVar2;
        }
        return neVar;
    }

    public Fragment b(String str) {
        return this.b.get(str);
    }

    public void b(Fragment fragment) {
        if (oc.c(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        rc rcVar = this.c.get(fragment.h);
        if (rcVar != null) {
            rcVar.b();
            this.c.remove(fragment.h);
        }
        ne neVar = this.d.get(fragment.h);
        if (neVar != null) {
            neVar.a();
            this.d.remove(fragment.h);
        }
    }
}
