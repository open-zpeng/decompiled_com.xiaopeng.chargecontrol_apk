package defpackage;

import android.util.Log;
import androidx.fragment.app.Fragment;
import defpackage.oc;
import defpackage.xc;
import java.io.PrintWriter;
import java.util.ArrayList;
/* compiled from: BackStackRecord.java */
/* renamed from: ob  reason: default package */
/* loaded from: classes.dex */
public final class ob extends xc implements oc.j, oc.o {
    public final oc q;
    public boolean r;
    public int s;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ob(defpackage.oc r3) {
        /*
            r2 = this;
            kc r0 = r3.m()
            lc<?> r1 = r3.r
            if (r1 == 0) goto Lf
            android.content.Context r1 = r1.d
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L10
        Lf:
            r1 = 0
        L10:
            r2.<init>(r0, r1)
            r0 = -1
            r2.s = r0
            r2.q = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ob.<init>(oc):void");
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.h);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.i != 0 || this.j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.j);
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.l);
            }
        }
        if (this.a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            xc.a aVar = this.a.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder a = jg.a("cmd=");
                    a.append(aVar.a);
                    str2 = a.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    public boolean b(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.a.get(i2).b;
            int i3 = fragment != null ? fragment.z : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            xc.a aVar = this.a.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.o(false);
                fragment.g(this.f);
                fragment.a(this.m, this.n);
            }
            switch (aVar.a) {
                case 1:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment, false);
                    this.q.a(fragment);
                    break;
                case 2:
                default:
                    StringBuilder a = jg.a("Unknown cmd: ");
                    a.append(aVar.a);
                    throw new IllegalArgumentException(a.toString());
                case 3:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.n(fragment);
                    break;
                case 4:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.i(fragment);
                    break;
                case 5:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment, false);
                    this.q.q(fragment);
                    break;
                case 6:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.f(fragment);
                    break;
                case 7:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment, false);
                    this.q.b(fragment);
                    break;
                case 8:
                    this.q.o(fragment);
                    break;
                case 9:
                    this.q.o(null);
                    break;
                case 10:
                    this.q.a(fragment, aVar.h);
                    break;
            }
            if (!this.o) {
                int i2 = aVar.a;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.h != null) {
            sb.append(" ");
            sb.append(this.h);
        }
        sb.append("}");
        return sb.toString();
    }

    public void b(boolean z) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            xc.a aVar = this.a.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.o(true);
                int i = this.f;
                fragment.g(i != 4097 ? i != 4099 ? i != 8194 ? 0 : 4097 : 4099 : 8194);
                fragment.a(this.n, this.m);
            }
            switch (aVar.a) {
                case 1:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment, true);
                    this.q.n(fragment);
                    break;
                case 2:
                default:
                    StringBuilder a = jg.a("Unknown cmd: ");
                    a.append(aVar.a);
                    throw new IllegalArgumentException(a.toString());
                case 3:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment);
                    break;
                case 4:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.q(fragment);
                    break;
                case 5:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment, true);
                    this.q.i(fragment);
                    break;
                case 6:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.b(fragment);
                    break;
                case 7:
                    fragment.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment, true);
                    this.q.f(fragment);
                    break;
                case 8:
                    this.q.o(null);
                    break;
                case 9:
                    this.q.o(fragment);
                    break;
                case 10:
                    this.q.a(fragment, aVar.g);
                    break;
            }
            if (!this.o) {
                int i2 = aVar.a;
            }
        }
    }

    @Override // defpackage.xc
    public void b() {
        if (!this.g) {
            this.q.b((oc.o) this, true);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // defpackage.xc
    public void a(int i, Fragment fragment, String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.u = this.q;
    }

    @Override // defpackage.xc
    public xc a(Fragment fragment) {
        oc ocVar = fragment.u;
        if (ocVar != null && ocVar != this.q) {
            StringBuilder a = jg.a("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            a.append(fragment.toString());
            a.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(a.toString());
        }
        super.a(fragment);
        return this;
    }

    public void a(int i) {
        if (this.g) {
            if (oc.c(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                xc.a aVar = this.a.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.t += i;
                    if (oc.c(2)) {
                        StringBuilder a = jg.a("Bump nesting of ");
                        a.append(aVar.b);
                        a.append(" to ");
                        a.append(aVar.b.t);
                        Log.v("FragmentManager", a.toString());
                    }
                }
            }
        }
    }

    @Override // defpackage.xc
    public int a() {
        return a(true);
    }

    public int a(boolean z) {
        if (!this.r) {
            if (oc.c(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new kd("FragmentManager"));
                a("  ", printWriter, true);
                printWriter.close();
            }
            this.r = true;
            if (this.g) {
                this.s = this.q.i.getAndIncrement();
            } else {
                this.s = -1;
            }
            this.q.a(this, z);
            return this.s;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // defpackage.oc.o
    public boolean a(ArrayList<ob> arrayList, ArrayList<Boolean> arrayList2) {
        if (oc.c(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.g) {
            oc ocVar = this.q;
            if (ocVar.d == null) {
                ocVar.d = new ArrayList<>();
            }
            ocVar.d.add(this);
            return true;
        }
        return true;
    }

    public boolean a(ArrayList<ob> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.a.get(i4).b;
            int i5 = fragment != null ? fragment.z : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    ob obVar = arrayList.get(i6);
                    int size2 = obVar.a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = obVar.a.get(i7).b;
                        if ((fragment2 != null ? fragment2.z : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }
}
