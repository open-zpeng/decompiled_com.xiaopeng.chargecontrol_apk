package defpackage;

import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* compiled from: FragmentTransition.java */
/* renamed from: ed  reason: default package */
/* loaded from: classes.dex */
public class ed {
    public static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final gd b;
    public static final gd c;

    /* compiled from: FragmentTransition.java */
    /* renamed from: ed$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: ed$b */
    /* loaded from: classes.dex */
    public static class b {
        public Fragment a;
        public boolean b;
        public ob c;
        public Fragment d;
        public boolean e;
        public ob f;
    }

    static {
        gd gdVar;
        int i = Build.VERSION.SDK_INT;
        b = new fd();
        try {
            gdVar = (gd) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            gdVar = null;
        }
        c = gdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0434 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r39, defpackage.hc r40, java.util.ArrayList<defpackage.ob> r41, java.util.ArrayList<java.lang.Boolean> r42, int r43, int r44, boolean r45, defpackage.ed.a r46) {
        /*
            Method dump skipped, instructions count: 1095
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ed.a(android.content.Context, hc, java.util.ArrayList, java.util.ArrayList, int, int, boolean, ed$a):void");
    }

    public static Object b(gd gdVar, Fragment fragment, boolean z) {
        Object Z;
        if (fragment == null) {
            return null;
        }
        if (z) {
            Z = fragment.q0();
        } else {
            Z = fragment.Z();
        }
        return gdVar.b(Z);
    }

    public static y4<String, View> b(gd gdVar, y4<String, String> y4Var, Object obj, b bVar) {
        ArrayList<String> arrayList;
        if (!y4Var.isEmpty() && obj != null) {
            Fragment fragment = bVar.d;
            y4<String, View> y4Var2 = new y4<>();
            gdVar.a((Map<String, View>) y4Var2, fragment.t1());
            ob obVar = bVar.f;
            if (bVar.e) {
                fragment.X();
                arrayList = obVar.n;
            } else {
                fragment.a0();
                arrayList = obVar.m;
            }
            if (arrayList != null) {
                e5.a((Map) y4Var2, (Collection<?>) arrayList);
            }
            e5.a((Map) y4Var, (Collection<?>) y4Var2.keySet());
            return y4Var2;
        }
        y4Var.clear();
        return null;
    }

    public static gd a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object Z = fragment.Z();
            if (Z != null) {
                arrayList.add(Z);
            }
            Object q0 = fragment.q0();
            if (q0 != null) {
                arrayList.add(q0);
            }
            Object s0 = fragment.s0();
            if (s0 != null) {
                arrayList.add(s0);
            }
        }
        if (fragment2 != null) {
            Object W = fragment2.W();
            if (W != null) {
                arrayList.add(W);
            }
            Object o0 = fragment2.o0();
            if (o0 != null) {
                arrayList.add(o0);
            }
            Object r0 = fragment2.r0();
            if (r0 != null) {
                arrayList.add(r0);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        gd gdVar = b;
        if (gdVar != null && a(gdVar, arrayList)) {
            return b;
        }
        gd gdVar2 = c;
        if (gdVar2 != null && a(gdVar2, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static boolean a(gd gdVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!gdVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static Object a(gd gdVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object r0;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            r0 = fragment2.s0();
        } else {
            r0 = fragment.r0();
        }
        Object b2 = gdVar.b(r0);
        fd fdVar = (fd) gdVar;
        if (b2 == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) b2);
        return transitionSet;
    }

    public static Object a(gd gdVar, Fragment fragment, boolean z) {
        Object W;
        if (fragment == null) {
            return null;
        }
        if (z) {
            W = fragment.o0();
        } else {
            W = fragment.W();
        }
        return gdVar.b(W);
    }

    public static void a(ArrayList<View> arrayList, y4<String, View> y4Var, Collection<String> collection) {
        for (int i = y4Var.e - 1; i >= 0; i--) {
            View e = y4Var.e(i);
            if (collection.contains(y9.m(e))) {
                arrayList.add(e);
            }
        }
    }

    public static void a(y4<String, String> y4Var, y4<String, View> y4Var2) {
        for (int i = y4Var.e - 1; i >= 0; i--) {
            if (!y4Var2.containsKey(y4Var.e(i))) {
                y4Var.d(i);
            }
        }
    }

    public static y4<String, View> a(gd gdVar, y4<String, String> y4Var, Object obj, b bVar) {
        ArrayList<String> arrayList;
        Fragment fragment = bVar.a;
        View w0 = fragment.w0();
        if (!y4Var.isEmpty() && obj != null && w0 != null) {
            y4<String, View> y4Var2 = new y4<>();
            gdVar.a((Map<String, View>) y4Var2, w0);
            ob obVar = bVar.c;
            if (bVar.b) {
                fragment.a0();
                arrayList = obVar.m;
            } else {
                fragment.X();
                arrayList = obVar.n;
            }
            if (arrayList != null) {
                e5.a((Map) y4Var2, (Collection<?>) arrayList);
                e5.a((Map) y4Var2, (Collection<?>) y4Var.values());
            }
            a(y4Var, y4Var2);
            return y4Var2;
        }
        y4Var.clear();
        return null;
    }

    public static View a(y4<String, View> y4Var, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        ob obVar = bVar.c;
        if (obj == null || y4Var == null || (arrayList = obVar.m) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = obVar.m.get(0);
        } else {
            str = obVar.n.get(0);
        }
        return y4Var.get(str);
    }

    public static void a(gd gdVar, Object obj, Object obj2, y4<String, View> y4Var, boolean z, ob obVar) {
        String str;
        ArrayList<String> arrayList = obVar.m;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = obVar.n.get(0);
        } else {
            str = obVar.m.get(0);
        }
        View view = y4Var.get(str);
        gdVar.c(obj, view);
        if (obj2 != null) {
            gdVar.c(obj2, view);
        }
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z, y4<String, View> y4Var, boolean z2) {
        if (z) {
            fragment2.X();
        } else {
            fragment.X();
        }
    }

    public static ArrayList<View> a(gd gdVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View w0 = fragment.w0();
            if (w0 != null) {
                gdVar.a(arrayList2, w0);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            gdVar.a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    public static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    public static Object a(gd gdVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.P();
        } else {
            z2 = fragment.O();
        }
        if (z2) {
            return gdVar.b(obj2, obj, obj3);
        }
        return gdVar.a(obj2, obj, obj3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0039, code lost:
        if (r0.n != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0077, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0088, code lost:
        if (r0.B == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008a, code lost:
        r9 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00e5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.ob r8, defpackage.xc.a r9, android.util.SparseArray<defpackage.ed.b> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ed.a(ob, xc$a, android.util.SparseArray, boolean, boolean):void");
    }
}
