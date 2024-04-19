package defpackage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.ed;
import defpackage.vd;
import defpackage.xc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FragmentManager.java */
/* renamed from: oc  reason: default package */
/* loaded from: classes.dex */
public abstract class oc implements tc {
    public t<Object> A;
    public t<String[]> B;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList<ob> I;
    public ArrayList<Boolean> J;
    public ArrayList<Fragment> K;
    public ArrayList<q> L;
    public rc M;
    public boolean b;
    public ArrayList<ob> d;
    public ArrayList<Fragment> e;
    public OnBackPressedDispatcher g;
    public ArrayList<n> l;
    public lc<?> r;
    public hc s;
    public Fragment t;
    public Fragment u;
    public t<Intent> z;
    public final ArrayList<o> a = new ArrayList<>();
    public final wc c = new wc();
    public final mc f = new mc(this);
    public final defpackage.l h = new c(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map<String, Bundle> j = Collections.synchronizedMap(new HashMap());
    public final Map<String, Object> k = Collections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<m8>> m = Collections.synchronizedMap(new HashMap());
    public final ed.a n = new d();
    public final nc o = new nc(this);
    public final CopyOnWriteArrayList<sc> p = new CopyOnWriteArrayList<>();
    public int q = -1;
    public kc v = null;
    public kc w = new e();
    public md x = null;
    public md y = new f(this);
    public ArrayDeque<m> C = new ArrayDeque<>();
    public Runnable N = new g();

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$a */
    /* loaded from: classes.dex */
    public class a implements r<defpackage.q> {
        public a() {
        }

        @Override // defpackage.r
        public void a(defpackage.q qVar) {
            defpackage.q qVar2 = qVar;
            m pollFirst = oc.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.c;
            int i = pollFirst.d;
            Fragment d = oc.this.c.d(str);
            if (d == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            d.a(i, qVar2.c, qVar2.d);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$b */
    /* loaded from: classes.dex */
    public class b implements r<Map<String, Boolean>> {
        public b() {
        }

        @Override // defpackage.r
        @SuppressLint({"SyntheticAccessor"})
        public void a(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            m pollFirst = oc.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.c;
            int i2 = pollFirst.d;
            Fragment d = oc.this.c.d(str);
            if (d == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            d.b1();
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$c */
    /* loaded from: classes.dex */
    public class c extends defpackage.l {
        public c(boolean z) {
            super(z);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$d */
    /* loaded from: classes.dex */
    public class d implements ed.a {
        public d() {
        }

        public void a(Fragment fragment, m8 m8Var) {
            if (m8Var.b()) {
                return;
            }
            oc ocVar = oc.this;
            HashSet<m8> hashSet = ocVar.m.get(fragment);
            if (hashSet != null && hashSet.remove(m8Var) && hashSet.isEmpty()) {
                ocVar.m.remove(fragment);
                if (fragment.c < 5) {
                    ocVar.e(fragment);
                    ocVar.a(fragment, ocVar.q);
                }
            }
        }

        public void b(Fragment fragment, m8 m8Var) {
            oc ocVar = oc.this;
            if (ocVar.m.get(fragment) == null) {
                ocVar.m.put(fragment, new HashSet<>());
            }
            ocVar.m.get(fragment).add(m8Var);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$e */
    /* loaded from: classes.dex */
    public class e extends kc {
        public e() {
        }

        @Override // defpackage.kc
        public Fragment a(ClassLoader classLoader, String str) {
            lc<?> lcVar = oc.this.r;
            return lcVar.a(lcVar.d, str, null);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$f */
    /* loaded from: classes.dex */
    public class f implements md {
        public f(oc ocVar) {
        }

        public ld a(ViewGroup viewGroup) {
            return new qb(viewGroup);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$g */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oc.this.d(true);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$h */
    /* loaded from: classes.dex */
    public class h implements sc {
        public final /* synthetic */ Fragment c;

        public h(oc ocVar, Fragment fragment) {
            this.c = fragment;
        }

        @Override // defpackage.sc
        public void a(oc ocVar, Fragment fragment) {
            this.c.J0();
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$i */
    /* loaded from: classes.dex */
    public class i implements r<defpackage.q> {
        public i() {
        }

        @Override // defpackage.r
        public void a(defpackage.q qVar) {
            defpackage.q qVar2 = qVar;
            m pollFirst = oc.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.c;
            int i = pollFirst.d;
            Fragment d = oc.this.c.d(str);
            if (d == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            d.a(i, qVar2.c, qVar2.d);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$j */
    /* loaded from: classes.dex */
    public interface j {
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$k */
    /* loaded from: classes.dex */
    public static class k extends w<Object, defpackage.q> {
        @Override // defpackage.w
        public defpackage.q a(int i, Intent intent) {
            return new defpackage.q(i, intent);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$l */
    /* loaded from: classes.dex */
    public static abstract class l {
        @Deprecated
        public void a() {
        }

        public abstract void a(oc ocVar, Fragment fragment);

        public abstract void a(oc ocVar, Fragment fragment, View view, Bundle bundle);

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public void h() {
        }

        public void i() {
        }

        public void j() {
        }

        public void k() {
        }

        public void l() {
        }
    }

    /* compiled from: FragmentManager.java */
    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: oc$m */
    /* loaded from: classes.dex */
    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();
        public String c;
        public int d;

        /* compiled from: FragmentManager.java */
        /* renamed from: oc$m$a */
        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<m> {
            @Override // android.os.Parcelable.Creator
            public m createFromParcel(Parcel parcel) {
                return new m(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public m[] newArray(int i) {
                return new m[i];
            }
        }

        public m(Parcel parcel) {
            this.c = parcel.readString();
            this.d = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.c);
            parcel.writeInt(this.d);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$n */
    /* loaded from: classes.dex */
    public interface n {
        void a();
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$o */
    /* loaded from: classes.dex */
    public interface o {
        boolean a(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$p */
    /* loaded from: classes.dex */
    public class p implements o {
        public final String a;
        public final int b;
        public final int c;

        public p(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // defpackage.oc.o
        public boolean a(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = oc.this.u;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.T().s()) {
                return oc.this.a(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: oc$q */
    /* loaded from: classes.dex */
    public static class q implements Fragment.h {
        public final boolean a;
        public final ob b;
        public int c;

        public void a() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.q.n()) {
                fragment.a((Fragment.h) null);
                if (z && fragment.C0()) {
                    fragment.u1();
                }
            }
            ob obVar = this.b;
            obVar.q.a(obVar, this.a, !z, true);
        }
    }

    public static boolean c(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public xc a() {
        return new ob(this);
    }

    public void b(Fragment fragment) {
        if (c(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            if (fragment.n) {
                return;
            }
            this.c.a(fragment);
            if (c(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (k(fragment)) {
                this.D = true;
            }
        }
    }

    public vc d(Fragment fragment) {
        vc e2 = this.c.e(fragment.h);
        if (e2 != null) {
            return e2;
        }
        vc vcVar = new vc(this.o, this.c, fragment);
        vcVar.a(this.r.d.getClassLoader());
        vcVar.e = this.q;
        return vcVar;
    }

    public final void e(Fragment fragment) {
        fragment.i1();
        this.o.i(fragment, false);
        fragment.I = null;
        fragment.J = null;
        fragment.U = null;
        fragment.V.a((ee<zd>) null);
        fragment.q = false;
    }

    public void f(Fragment fragment) {
        if (c(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.C) {
            return;
        }
        fragment.C = true;
        if (fragment.n) {
            if (c(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.c(fragment);
            if (k(fragment)) {
                this.D = true;
            }
            p(fragment);
        }
    }

    public void g() {
        a(5);
    }

    public final ViewGroup h(Fragment fragment) {
        ViewGroup viewGroup = fragment.I;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.z > 0 && this.s.b()) {
            View a2 = this.s.a(fragment.z);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    public void i(Fragment fragment) {
        if (c(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.B) {
            return;
        }
        fragment.B = true;
        fragment.O = true ^ fragment.O;
        p(fragment);
    }

    public final void j() {
        if (this.H) {
            this.H = false;
            v();
        }
    }

    public final void k() {
        for (ld ldVar : c()) {
            ldVar.b();
        }
    }

    public boolean l(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.B0();
    }

    public boolean m(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        oc ocVar = fragment.u;
        return fragment.equals(ocVar.u) && m(ocVar.t);
    }

    public List<Fragment> n() {
        return this.c.d();
    }

    public void o(Fragment fragment) {
        if (fragment != null && (!fragment.equals(a(fragment.h)) || (fragment.v != null && fragment.u != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.u;
        this.u = fragment;
        g(fragment2);
        g(this.u);
    }

    public final void p(Fragment fragment) {
        ViewGroup h2 = h(fragment);
        if (h2 != null) {
            if (fragment.m0() + fragment.l0() + fragment.Y() + fragment.V() > 0) {
                if (h2.getTag(mb.visible_removing_fragment_view_tag) == null) {
                    h2.setTag(mb.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) h2.getTag(mb.visible_removing_fragment_view_tag)).o(fragment.k0());
            }
        }
    }

    public void q(Fragment fragment) {
        if (c(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.B) {
            fragment.B = false;
            fragment.O = !fragment.O;
        }
    }

    public void r() {
        if (this.r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.a(false);
        for (Fragment fragment : this.c.d()) {
            if (fragment != null) {
                fragment.H0();
            }
        }
    }

    public boolean s() {
        d(false);
        c(true);
        Fragment fragment = this.u;
        if (fragment == null || !fragment.T().s()) {
            boolean a2 = a(this.I, this.J, null, -1, 0);
            if (a2) {
                this.b = true;
                try {
                    c(this.I, this.J);
                } finally {
                    b();
                }
            }
            w();
            j();
            this.c.a();
            return a2;
        }
        return true;
    }

    public Parcelable t() {
        int i2;
        int size;
        Iterator<ld> it = c().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ld next = it.next();
            if (next.e) {
                next.e = false;
                next.a();
            }
        }
        k();
        d(true);
        this.E = true;
        this.M.a(true);
        ArrayList<uc> e2 = this.c.e();
        pb[] pbVarArr = null;
        if (e2.isEmpty()) {
            if (c(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> f2 = this.c.f();
        ArrayList<ob> arrayList = this.d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            pbVarArr = new pb[size];
            for (i2 = 0; i2 < size; i2++) {
                pbVarArr[i2] = new pb(this.d.get(i2));
                if (c(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                }
            }
        }
        qc qcVar = new qc();
        qcVar.c = e2;
        qcVar.d = f2;
        qcVar.e = pbVarArr;
        qcVar.f = this.i.get();
        Fragment fragment = this.u;
        if (fragment != null) {
            qcVar.g = fragment.h;
        }
        qcVar.h.addAll(this.j.keySet());
        qcVar.i.addAll(this.j.values());
        qcVar.j = new ArrayList<>(this.C);
        return qcVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.t)));
            sb.append("}");
        } else {
            lc<?> lcVar = this.r;
            if (lcVar != null) {
                sb.append(lcVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        synchronized (this.a) {
            boolean z = (this.L == null || this.L.isEmpty()) ? false : true;
            boolean z2 = this.a.size() == 1;
            if (z || z2) {
                this.r.e.removeCallbacks(this.N);
                this.r.e.post(this.N);
                w();
            }
        }
    }

    public final void v() {
        for (vc vcVar : this.c.b()) {
            Fragment fragment = vcVar.c;
            if (fragment.K) {
                if (this.b) {
                    this.H = true;
                } else {
                    fragment.K = false;
                    vcVar.k();
                }
            }
        }
    }

    public final void w() {
        synchronized (this.a) {
            try {
                boolean z = true;
                if (!this.a.isEmpty()) {
                    this.h.a = true;
                    return;
                }
                defpackage.l lVar = this.h;
                ArrayList<ob> arrayList = this.d;
                if ((arrayList != null ? arrayList.size() : 0) <= 0 || !m(this.t)) {
                    z = false;
                }
                lVar.a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((o) new p(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException(jg.a("Bad id: ", i2));
    }

    public final void c(Fragment fragment) {
        HashSet<m8> hashSet = this.m.get(fragment);
        if (hashSet != null) {
            Iterator<m8> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            e(fragment);
            this.m.remove(fragment);
        }
    }

    public final void g(Fragment fragment) {
        if (fragment == null || !fragment.equals(a(fragment.h))) {
            return;
        }
        fragment.m1();
    }

    public hc l() {
        return this.s;
    }

    public void n(Fragment fragment) {
        if (c(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.t);
        }
        boolean z = !fragment.A0();
        if (!fragment.C || z) {
            this.c.c(fragment);
            if (k(fragment)) {
                this.D = true;
            }
            fragment.o = true;
            p(fragment);
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String a2 = jg.a(str, "    ");
        this.c.a(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.e.get(i2).toString());
            }
        }
        ArrayList<ob> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                ob obVar = this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(obVar.toString());
                obVar.a(a2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            int size3 = this.a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.a.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.s);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public void j(Fragment fragment) {
        if (fragment.n && k(fragment)) {
            this.D = true;
        }
    }

    public final boolean k(Fragment fragment) {
        boolean z;
        if (fragment.F && fragment.G) {
            return true;
        }
        oc ocVar = fragment.w;
        Iterator<Fragment> it = ocVar.c.c().iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Fragment next = it.next();
            if (next != null) {
                z2 = ocVar.k(next);
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        return z;
    }

    public kc m() {
        kc kcVar = this.v;
        if (kcVar != null) {
            return kcVar;
        }
        Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.u.m();
        }
        return this.w;
    }

    public boolean q() {
        return this.E || this.F;
    }

    public void i() {
        this.F = true;
        this.M.a(true);
        a(4);
    }

    public void h() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(7);
    }

    public LayoutInflater.Factory2 o() {
        return this.f;
    }

    public md p() {
        md mdVar = this.x;
        if (mdVar != null) {
            return mdVar;
        }
        Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.u.p();
        }
        return this.y;
    }

    public final void c(boolean z) {
        if (!this.b) {
            if (this.r == null) {
                if (this.G) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (Looper.myLooper() == this.r.e.getLooper()) {
                if (!z && q()) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.I == null) {
                    this.I = new ArrayList<>();
                    this.J = new ArrayList<>();
                }
                this.b = true;
                try {
                    a((ArrayList<ob>) null, (ArrayList<Boolean>) null);
                    return;
                } finally {
                    this.b = false;
                }
            } else {
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public boolean d(boolean z) {
        c(z);
        boolean z2 = false;
        while (b(this.I, this.J)) {
            this.b = true;
            try {
                c(this.I, this.J);
                b();
                z2 = true;
            } catch (Throwable th) {
                b();
                throw th;
            }
        }
        w();
        j();
        this.c.a();
        return z2;
    }

    public void e() {
        this.G = true;
        d(true);
        k();
        a(-1);
        this.r = null;
        this.s = null;
        this.t = null;
        if (this.g != null) {
            Iterator<defpackage.k> it = this.h.b.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.g = null;
        }
        t<Intent> tVar = this.z;
        if (tVar != null) {
            tVar.a();
            this.A.a();
            this.B.a();
        }
    }

    public Fragment b(int i2) {
        wc wcVar = this.c;
        int size = wcVar.a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = wcVar.a.get(size);
                if (fragment != null && fragment.y == i2) {
                    return fragment;
                }
            } else {
                for (vc vcVar : wcVar.b.values()) {
                    if (vcVar != null) {
                        Fragment fragment2 = vcVar.c;
                        if (fragment2.y == i2) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public void f() {
        for (Fragment fragment : this.c.d()) {
            if (fragment != null) {
                fragment.k1();
            }
        }
    }

    public void b(o oVar, boolean z) {
        if (z && (this.r == null || this.G)) {
            return;
        }
        c(z);
        if (oVar.a(this.I, this.J)) {
            this.b = true;
            try {
                c(this.I, this.J);
            } finally {
                b();
            }
        }
        w();
        j();
        this.c.a();
    }

    public void d() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(1);
    }

    public final void b() {
        this.b = false;
        this.J.clear();
        this.I.clear();
    }

    public final void c(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).o) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).o) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public final boolean b(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return false;
            }
            int size = this.a.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= this.a.get(i2).a(arrayList, arrayList2);
            }
            this.a.clear();
            this.r.e.removeCallbacks(this.N);
            return z;
        }
    }

    public void b(boolean z) {
        for (Fragment fragment : this.c.d()) {
            if (fragment != null) {
                fragment.m(z);
            }
        }
    }

    public final Set<ld> c() {
        HashSet hashSet = new HashSet();
        for (vc vcVar : this.c.b()) {
            ViewGroup viewGroup = vcVar.c.I;
            if (viewGroup != null) {
                hashSet.add(ld.a(viewGroup, p()));
            }
        }
        return hashSet;
    }

    public boolean b(Menu menu) {
        boolean z = false;
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.d()) {
            if (fragment != null && l(fragment) && fragment.b(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.d()) {
            if (fragment != null && fragment.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r2 != 5) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oc.a(androidx.fragment.app.Fragment, int):void");
    }

    public void a(Fragment fragment, boolean z) {
        ViewGroup h2 = h(fragment);
        if (h2 == null || !(h2 instanceof ic)) {
            return;
        }
        ((ic) h2).setDrawDisappearingViewsLast(!z);
    }

    public void a(int i2, boolean z) {
        lc<?> lcVar;
        if (this.r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.q) {
            this.q = i2;
            wc wcVar = this.c;
            Iterator<Fragment> it = wcVar.a.iterator();
            while (it.hasNext()) {
                vc vcVar = wcVar.b.get(it.next().h);
                if (vcVar != null) {
                    vcVar.k();
                }
            }
            Iterator<vc> it2 = wcVar.b.values().iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                vc next = it2.next();
                if (next != null) {
                    next.k();
                    Fragment fragment = next.c;
                    if (fragment.o && !fragment.A0()) {
                        z2 = true;
                    }
                    if (z2) {
                        wcVar.b(next);
                    }
                }
            }
            v();
            if (this.D && (lcVar = this.r) != null && this.q == 7) {
                bc.this.j();
                this.D = false;
            }
        }
    }

    public vc a(Fragment fragment) {
        if (c(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        vc d2 = d(fragment);
        fragment.u = this;
        this.c.a(d2);
        if (!fragment.C) {
            this.c.a(fragment);
            fragment.o = false;
            if (fragment.J == null) {
                fragment.O = false;
            }
            if (k(fragment)) {
                this.D = true;
            }
        }
        return d2;
    }

    public Fragment a(String str) {
        return this.c.b(str);
    }

    public void a(o oVar, boolean z) {
        if (!z) {
            if (this.r == null) {
                if (this.G) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (q()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.r == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.a.add(oVar);
            u();
        }
    }

    public final void a(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<q> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            q qVar = this.L.get(i2);
            if (arrayList != null && !qVar.a && (indexOf2 = arrayList.indexOf(qVar.b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.L.remove(i2);
                i2--;
                size--;
                ob obVar = qVar.b;
                obVar.q.a(obVar, qVar.a, false, false);
            } else {
                if ((qVar.c == 0) || (arrayList != null && qVar.b.a(arrayList, 0, arrayList.size()))) {
                    this.L.remove(i2);
                    i2--;
                    size--;
                    if (arrayList != null && !qVar.a && (indexOf = arrayList.indexOf(qVar.b)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                        ob obVar2 = qVar.b;
                        obVar2.q.a(obVar2, qVar.a, false, false);
                    } else {
                        qVar.a();
                    }
                }
            }
            i2++;
        }
    }

    public final void a(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        int i5;
        ArrayList<ob> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        boolean z = arrayList3.get(i2).o;
        ArrayList<Fragment> arrayList5 = this.K;
        if (arrayList5 == null) {
            this.K = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.K.addAll(this.c.d());
        Fragment fragment = this.u;
        boolean z2 = false;
        int i6 = i2;
        while (true) {
            int i7 = 1;
            if (i6 < i3) {
                ob obVar = arrayList3.get(i6);
                int i8 = 3;
                if (!arrayList4.get(i6).booleanValue()) {
                    ArrayList<Fragment> arrayList6 = this.K;
                    Fragment fragment2 = fragment;
                    int i9 = 0;
                    while (i9 < obVar.a.size()) {
                        xc.a aVar = obVar.a.get(i9);
                        int i10 = aVar.a;
                        if (i10 != i7) {
                            if (i10 != 2) {
                                if (i10 == i8 || i10 == 6) {
                                    arrayList6.remove(aVar.b);
                                    Fragment fragment3 = aVar.b;
                                    if (fragment3 == fragment2) {
                                        obVar.a.add(i9, new xc.a(9, fragment3));
                                        i9++;
                                        i4 = 1;
                                        fragment2 = null;
                                    }
                                } else if (i10 == 7) {
                                    i4 = 1;
                                } else if (i10 == 8) {
                                    obVar.a.add(i9, new xc.a(9, fragment2));
                                    i9++;
                                    fragment2 = aVar.b;
                                }
                                i4 = 1;
                            } else {
                                Fragment fragment4 = aVar.b;
                                int i11 = fragment4.z;
                                Fragment fragment5 = fragment2;
                                int i12 = i9;
                                int size = arrayList6.size() - 1;
                                boolean z3 = false;
                                while (size >= 0) {
                                    Fragment fragment6 = arrayList6.get(size);
                                    if (fragment6.z != i11) {
                                        i5 = i11;
                                    } else if (fragment6 == fragment4) {
                                        i5 = i11;
                                        z3 = true;
                                    } else {
                                        if (fragment6 == fragment5) {
                                            i5 = i11;
                                            obVar.a.add(i12, new xc.a(9, fragment6));
                                            i12++;
                                            fragment5 = null;
                                        } else {
                                            i5 = i11;
                                        }
                                        xc.a aVar2 = new xc.a(3, fragment6);
                                        aVar2.c = aVar.c;
                                        aVar2.e = aVar.e;
                                        aVar2.d = aVar.d;
                                        aVar2.f = aVar.f;
                                        obVar.a.add(i12, aVar2);
                                        arrayList6.remove(fragment6);
                                        i12++;
                                    }
                                    size--;
                                    i11 = i5;
                                }
                                if (z3) {
                                    obVar.a.remove(i12);
                                    i9 = i12 - 1;
                                    i4 = 1;
                                } else {
                                    i4 = 1;
                                    aVar.a = 1;
                                    arrayList6.add(fragment4);
                                    i9 = i12;
                                }
                                fragment2 = fragment5;
                            }
                            i9 += i4;
                            i7 = i4;
                            i8 = 3;
                        } else {
                            i4 = i7;
                        }
                        arrayList6.add(aVar.b);
                        i9 += i4;
                        i7 = i4;
                        i8 = 3;
                    }
                    fragment = fragment2;
                } else {
                    int i13 = 1;
                    ArrayList<Fragment> arrayList7 = this.K;
                    int size2 = obVar.a.size() - 1;
                    while (size2 >= 0) {
                        xc.a aVar3 = obVar.a.get(size2);
                        int i14 = aVar3.a;
                        if (i14 != i13) {
                            if (i14 != 3) {
                                switch (i14) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = aVar3.b;
                                        break;
                                    case 10:
                                        aVar3.h = aVar3.g;
                                        break;
                                }
                                size2--;
                                i13 = 1;
                            }
                            arrayList7.add(aVar3.b);
                            size2--;
                            i13 = 1;
                        }
                        arrayList7.remove(aVar3.b);
                        size2--;
                        i13 = 1;
                    }
                }
                z2 = z2 || obVar.g;
                i6++;
                arrayList3 = arrayList;
                arrayList4 = arrayList2;
            } else {
                this.K.clear();
                if (!z && this.q >= 1) {
                    for (int i15 = i2; i15 < i3; i15++) {
                        Iterator<xc.a> it = arrayList.get(i15).a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment7 = it.next().b;
                            if (fragment7 != null && fragment7.u != null) {
                                this.c.a(d(fragment7));
                            }
                        }
                    }
                }
                int i16 = i2;
                while (i16 < i3) {
                    ob obVar2 = arrayList.get(i16);
                    if (arrayList2.get(i16).booleanValue()) {
                        obVar2.a(-1);
                        obVar2.b(i16 == i3 + (-1));
                    } else {
                        obVar2.a(1);
                        obVar2.d();
                    }
                    i16++;
                }
                boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                for (int i17 = i2; i17 < i3; i17++) {
                    ob obVar3 = arrayList.get(i17);
                    if (booleanValue) {
                        for (int size3 = obVar3.a.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment8 = obVar3.a.get(size3).b;
                            if (fragment8 != null) {
                                d(fragment8).k();
                            }
                        }
                    } else {
                        Iterator<xc.a> it2 = obVar3.a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment9 = it2.next().b;
                            if (fragment9 != null) {
                                d(fragment9).k();
                            }
                        }
                    }
                }
                a(this.q, true);
                HashSet<ld> hashSet = new HashSet();
                for (int i18 = i2; i18 < i3; i18++) {
                    Iterator<xc.a> it3 = arrayList.get(i18).a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment10 = it3.next().b;
                        if (fragment10 != null && (viewGroup = fragment10.I) != null) {
                            hashSet.add(ld.a(viewGroup, p()));
                        }
                    }
                }
                for (ld ldVar : hashSet) {
                    ldVar.d = booleanValue;
                    ldVar.c();
                    ldVar.a();
                }
                for (int i19 = i2; i19 < i3; i19++) {
                    ob obVar4 = arrayList.get(i19);
                    if (arrayList2.get(i19).booleanValue() && obVar4.s >= 0) {
                        obVar4.s = -1;
                    }
                    if (obVar4.p != null) {
                        for (int i20 = 0; i20 < obVar4.p.size(); i20++) {
                            obVar4.p.get(i20).run();
                        }
                        obVar4.p = null;
                    }
                }
                if (!z2 || this.l == null) {
                    return;
                }
                for (int i21 = 0; i21 < this.l.size(); i21++) {
                    this.l.get(i21).a();
                }
                return;
            }
        }
    }

    public void a(ob obVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            obVar.b(z3);
        } else {
            obVar.d();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(obVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.q >= 1) {
            ed.a(this.r.d, this.s, arrayList, arrayList2, 0, 1, true, this.n);
        }
        if (z3) {
            a(this.q, true);
        }
        for (Fragment fragment : this.c.c()) {
            if (fragment != null && fragment.J != null && fragment.N && obVar.b(fragment.z)) {
                float f2 = fragment.P;
                if (f2 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    fragment.J.setAlpha(f2);
                }
                if (z3) {
                    fragment.P = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                } else {
                    fragment.P = -1.0f;
                    fragment.N = false;
                }
            }
        }
    }

    public boolean a(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int size;
        ArrayList<ob> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                size = this.d.size() - 1;
                while (size >= 0) {
                    ob obVar = this.d.get(size);
                    if ((str != null && str.equals(obVar.h)) || (i2 >= 0 && i2 == obVar.s)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ob obVar2 = this.d.get(size);
                        if (str == null || !str.equals(obVar2.h)) {
                            if (i2 < 0 || i2 != obVar2.s) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > size; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public void a(Parcelable parcelable) {
        vc vcVar;
        if (parcelable == null) {
            return;
        }
        qc qcVar = (qc) parcelable;
        if (qcVar.c == null) {
            return;
        }
        this.c.b.clear();
        Iterator<uc> it = qcVar.c.iterator();
        while (it.hasNext()) {
            uc next = it.next();
            if (next != null) {
                Fragment b2 = this.M.b(next.d);
                if (b2 != null) {
                    if (c(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + b2);
                    }
                    vcVar = new vc(this.o, this.c, b2, next);
                } else {
                    vcVar = new vc(this.o, this.c, this.r.d.getClassLoader(), m(), next);
                }
                Fragment fragment = vcVar.c;
                fragment.u = this;
                if (c(2)) {
                    StringBuilder a2 = jg.a("restoreSaveState: active (");
                    a2.append(fragment.h);
                    a2.append("): ");
                    a2.append(fragment);
                    Log.v("FragmentManager", a2.toString());
                }
                vcVar.a(this.r.d.getClassLoader());
                this.c.a(vcVar);
                vcVar.e = this.q;
            }
        }
        for (Fragment fragment2 : this.M.c()) {
            if (!this.c.a(fragment2.h)) {
                if (c(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment2 + " that was not found in the set of active Fragments " + qcVar.c);
                }
                this.M.e(fragment2);
                fragment2.u = this;
                vc vcVar2 = new vc(this.o, this.c, fragment2);
                vcVar2.e = 1;
                vcVar2.k();
                fragment2.o = true;
                vcVar2.k();
            }
        }
        wc wcVar = this.c;
        ArrayList<String> arrayList = qcVar.d;
        wcVar.a.clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment b3 = wcVar.b(str);
                if (b3 != null) {
                    if (c(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + b3);
                    }
                    wcVar.a(b3);
                } else {
                    throw new IllegalStateException(jg.b("No instantiated fragment for (", str, ")"));
                }
            }
        }
        pb[] pbVarArr = qcVar.e;
        if (pbVarArr != null) {
            this.d = new ArrayList<>(pbVarArr.length);
            int i2 = 0;
            while (true) {
                pb[] pbVarArr2 = qcVar.e;
                if (i2 >= pbVarArr2.length) {
                    break;
                }
                ob a3 = pbVarArr2[i2].a(this);
                if (c(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a3.s + "): " + a3);
                    PrintWriter printWriter = new PrintWriter(new kd("FragmentManager"));
                    a3.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(a3);
                i2++;
            }
        } else {
            this.d = null;
        }
        this.i.set(qcVar.f);
        String str2 = qcVar.g;
        if (str2 != null) {
            this.u = a(str2);
            g(this.u);
        }
        ArrayList<String> arrayList2 = qcVar.h;
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                Bundle bundle = qcVar.i.get(i3);
                bundle.setClassLoader(this.r.d.getClassLoader());
                this.j.put(arrayList2.get(i3), bundle);
            }
        }
        this.C = new ArrayDeque<>(qcVar.j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void a(lc<?> lcVar, hc hcVar, Fragment fragment) {
        je a2;
        if (this.r == null) {
            this.r = lcVar;
            this.s = hcVar;
            this.t = fragment;
            if (this.t != null) {
                this.p.add(new h(this, fragment));
            } else if (lcVar instanceof sc) {
                this.p.add((sc) lcVar);
            }
            if (this.t != null) {
                w();
            }
            if (lcVar instanceof defpackage.m) {
                defpackage.m mVar = (defpackage.m) lcVar;
                this.g = mVar.t();
                Fragment fragment2 = mVar;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                this.g.a(fragment2, this.h);
            }
            if (fragment != null) {
                this.M = fragment.u.M.c(fragment);
            } else if (lcVar instanceof oe) {
                ne v = ((oe) lcVar).v();
                ke keVar = rc.i;
                String canonicalName = rc.class.getCanonicalName();
                if (canonicalName != null) {
                    String a3 = jg.a("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    je a4 = v.a(a3);
                    if (rc.class.isInstance(a4)) {
                        if (keVar instanceof me) {
                            ((me) keVar).a();
                        }
                    } else {
                        if (keVar instanceof le) {
                            a2 = ((le) keVar).a(a3, rc.class);
                        } else {
                            a2 = keVar.a(rc.class);
                        }
                        a4 = a2;
                        je put = v.a.put(a3, a4);
                        if (put != null) {
                            put.b();
                        }
                    }
                    this.M = (rc) a4;
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.M = new rc(false);
            }
            this.M.a(q());
            this.c.c = this.M;
            lc<?> lcVar2 = this.r;
            if (lcVar2 instanceof v) {
                u a5 = ((v) lcVar2).a();
                String a6 = jg.a("FragmentManager:", fragment != null ? jg.a(new StringBuilder(), fragment.h, ":") : "");
                this.z = a5.a(jg.a(a6, "StartActivityForResult"), new y(), new i());
                this.A = a5.a(jg.a(a6, "StartIntentSenderForResult"), new k(), new a());
                this.B = a5.a(jg.a(a6, "RequestPermissions"), new x(), new b());
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void a(int i2) {
        try {
            this.b = true;
            for (vc vcVar : this.c.b.values()) {
                if (vcVar != null) {
                    vcVar.e = i2;
                }
            }
            a(i2, false);
            for (ld ldVar : c()) {
                ldVar.b();
            }
            this.b = false;
            d(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public void a(boolean z) {
        for (Fragment fragment : this.c.d()) {
            if (fragment != null) {
                fragment.l(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (Fragment fragment : this.c.d()) {
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.d()) {
            if (fragment != null && l(fragment) && fragment.a(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.P0();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.d()) {
            if (fragment != null && fragment.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.q < 1) {
            return;
        }
        for (Fragment fragment : this.c.d()) {
            if (fragment != null) {
                fragment.a(menu);
            }
        }
    }

    public void a(Fragment fragment, vd.b bVar) {
        if (fragment.equals(a(fragment.h)) && (fragment.v == null || fragment.u == this)) {
            fragment.S = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }
}
