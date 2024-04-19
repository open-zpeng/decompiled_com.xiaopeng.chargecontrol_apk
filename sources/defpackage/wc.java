package defpackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* compiled from: FragmentStore.java */
/* renamed from: wc  reason: default package */
/* loaded from: classes.dex */
public class wc {
    public final ArrayList<Fragment> a = new ArrayList<>();
    public final HashMap<String, vc> b = new HashMap<>();
    public rc c;

    public void a(Fragment fragment) {
        if (!this.a.contains(fragment)) {
            synchronized (this.a) {
                this.a.add(fragment);
            }
            fragment.n = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b(vc vcVar) {
        Fragment fragment = vcVar.c;
        if (fragment.D) {
            this.c.e(fragment);
        }
        if (this.b.put(fragment.h, null) != null && oc.c(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public void c(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.n = false;
    }

    public List<Fragment> d() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public ArrayList<uc> e() {
        ArrayList<uc> arrayList = new ArrayList<>(this.b.size());
        for (vc vcVar : this.b.values()) {
            if (vcVar != null) {
                Fragment fragment = vcVar.c;
                uc ucVar = new uc(fragment);
                if (vcVar.c.c > -1 && ucVar.o == null) {
                    Bundle bundle = new Bundle();
                    vcVar.c.h(bundle);
                    vcVar.a.d(vcVar.c, bundle, false);
                    if (bundle.isEmpty()) {
                        bundle = null;
                    }
                    if (vcVar.c.J != null) {
                        vcVar.n();
                    }
                    if (vcVar.c.e != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", vcVar.c.e);
                    }
                    if (vcVar.c.f != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", vcVar.c.f);
                    }
                    if (!vcVar.c.L) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", vcVar.c.L);
                    }
                    ucVar.o = bundle;
                    if (vcVar.c.k != null) {
                        if (ucVar.o == null) {
                            ucVar.o = new Bundle();
                        }
                        ucVar.o.putString("android:target_state", vcVar.c.k);
                        int i = vcVar.c.l;
                        if (i != 0) {
                            ucVar.o.putInt("android:target_req_state", i);
                        }
                    }
                } else {
                    ucVar.o = vcVar.c.d;
                }
                arrayList.add(ucVar);
                if (oc.c(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + ucVar.o);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> f() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.a.size());
            Iterator<Fragment> it = this.a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.h);
                if (oc.c(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.h + "): " + next);
                }
            }
            return arrayList;
        }
    }

    public List<Fragment> c() {
        ArrayList arrayList = new ArrayList();
        for (vc vcVar : this.b.values()) {
            if (vcVar != null) {
                arrayList.add(vcVar.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public Fragment d(String str) {
        Fragment d;
        for (vc vcVar : this.b.values()) {
            if (vcVar != null && (d = vcVar.c.d(str)) != null) {
                return d;
            }
        }
        return null;
    }

    public List<vc> b() {
        ArrayList arrayList = new ArrayList();
        for (vc vcVar : this.b.values()) {
            if (vcVar != null) {
                arrayList.add(vcVar);
            }
        }
        return arrayList;
    }

    public void a(vc vcVar) {
        Fragment fragment = vcVar.c;
        if (a(fragment.h)) {
            return;
        }
        this.b.put(fragment.h, vcVar);
        if (fragment.E) {
            if (fragment.D) {
                this.c.a(fragment);
            } else {
                this.c.e(fragment);
            }
            fragment.E = false;
        }
        if (oc.c(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public Fragment b(String str) {
        vc vcVar = this.b.get(str);
        if (vcVar != null) {
            return vcVar.c;
        }
        return null;
    }

    public Fragment c(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.a.get(size);
                if (fragment != null && str.equals(fragment.A)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (vc vcVar : this.b.values()) {
                if (vcVar != null) {
                    Fragment fragment2 = vcVar.c;
                    if (str.equals(fragment2.A)) {
                        return fragment2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public int b(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.I;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.a.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = this.a.get(i);
            if (fragment2.I == viewGroup && (view2 = fragment2.J) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.a.size()) {
                return -1;
            }
            Fragment fragment3 = this.a.get(indexOf);
            if (fragment3.I == viewGroup && (view = fragment3.J) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public void a() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public boolean a(String str) {
        return this.b.get(str) != null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String a = jg.a(str, "    ");
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (vc vcVar : this.b.values()) {
                printWriter.print(str);
                if (vcVar != null) {
                    Fragment fragment = vcVar.c;
                    printWriter.println(fragment);
                    fragment.a(a, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.a.get(i).toString());
            }
        }
    }

    public vc e(String str) {
        return this.b.get(str);
    }
}
