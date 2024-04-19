package defpackage;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import defpackage.fd;
import defpackage.ld;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: qb  reason: default package */
/* loaded from: classes.dex */
public class qb extends ld {

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: qb$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ List c;
        public final /* synthetic */ ld.d d;

        public a(List list, ld.d dVar) {
            this.c = list;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.contains(this.d)) {
                this.c.remove(this.d);
                qb.this.a(this.d);
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: qb$b */
    /* loaded from: classes.dex */
    public static class b extends c {
        public boolean c;
        public boolean d;
        public fc e;

        public b(ld.d dVar, m8 m8Var, boolean z) {
            super(dVar, m8Var);
            this.d = false;
            this.c = z;
        }

        public fc a(Context context) {
            if (this.d) {
                return this.e;
            }
            ld.d dVar = this.a;
            this.e = defpackage.a.a(context, dVar.c, dVar.a == ld.d.c.VISIBLE, this.c);
            this.d = true;
            return this.e;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: qb$c */
    /* loaded from: classes.dex */
    public static class c {
        public final ld.d a;
        public final m8 b;

        public c(ld.d dVar, m8 m8Var) {
            this.a = dVar;
            this.b = m8Var;
        }

        public void a() {
            ld.d dVar = this.a;
            if (dVar.e.remove(this.b) && dVar.e.isEmpty()) {
                dVar.b();
            }
        }

        public boolean b() {
            ld.d.c cVar;
            ld.d.c b = ld.d.c.b(this.a.c.J);
            ld.d.c cVar2 = this.a.a;
            return b == cVar2 || !(b == (cVar = ld.d.c.VISIBLE) || cVar2 == cVar);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: qb$d */
    /* loaded from: classes.dex */
    public static class d extends c {
        public final Object c;
        public final boolean d;
        public final Object e;

        public d(ld.d dVar, m8 m8Var, boolean z, boolean z2) {
            super(dVar, m8Var);
            Object Z;
            Object W;
            boolean O;
            if (dVar.a == ld.d.c.VISIBLE) {
                if (z) {
                    W = dVar.c.o0();
                } else {
                    W = dVar.c.W();
                }
                this.c = W;
                if (z) {
                    O = dVar.c.P();
                } else {
                    O = dVar.c.O();
                }
                this.d = O;
            } else {
                if (z) {
                    Z = dVar.c.q0();
                } else {
                    Z = dVar.c.Z();
                }
                this.c = Z;
                this.d = true;
            }
            if (!z2) {
                this.e = null;
            } else if (z) {
                this.e = dVar.c.s0();
            } else {
                this.e = dVar.c.r0();
            }
        }

        public final gd a(Object obj) {
            if (obj == null) {
                return null;
            }
            gd gdVar = ed.b;
            if (gdVar != null && gdVar.a(obj)) {
                return ed.b;
            }
            gd gdVar2 = ed.c;
            if (gdVar2 != null && gdVar2.a(obj)) {
                return ed.c;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public qb(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v13, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v16 */
    @Override // defpackage.ld
    public void a(List<ld.d> list, boolean z) {
        boolean z2;
        ArrayList arrayList;
        qb qbVar;
        String str;
        ArrayList arrayList2;
        boolean z3;
        String str2;
        ld.d dVar;
        String str3;
        TransitionSet transitionSet;
        Object obj;
        ld.d dVar2;
        View view;
        ld.d dVar3;
        ArrayList<View> arrayList3;
        ArrayList<View> arrayList4;
        Object obj2;
        View view2;
        y4 y4Var;
        ArrayList<View> arrayList5;
        ld.d dVar4;
        ArrayList arrayList6;
        View view3;
        String str4;
        ld.d dVar5;
        ArrayList<View> arrayList7;
        Rect rect;
        fd fdVar;
        TransitionSet transitionSet2;
        int i;
        View view4;
        qb qbVar2;
        View view5;
        ArrayList<ld.d> arrayList8;
        boolean z4;
        boolean z5;
        boolean z6 = z;
        ld.d dVar6 = null;
        ld.d dVar7 = null;
        for (ld.d dVar8 : list) {
            ld.d.c b2 = ld.d.c.b(dVar8.c.J);
            int ordinal = dVar8.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2 && ordinal != 3) {
                    }
                } else if (b2 != ld.d.c.VISIBLE) {
                    dVar7 = dVar8;
                }
            }
            if (b2 == ld.d.c.VISIBLE && dVar6 == null) {
                dVar6 = dVar8;
            }
        }
        ArrayList arrayList9 = new ArrayList();
        ArrayList<d> arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList(list);
        Iterator<ld.d> it = list.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            ld.d next = it.next();
            m8 m8Var = new m8();
            next.c();
            next.e.add(m8Var);
            arrayList9.add(new b(next, m8Var, z6));
            m8 m8Var2 = new m8();
            next.c();
            next.e.add(m8Var2);
            if (z6) {
                if (next != dVar6) {
                    arrayList10.add(new d(next, m8Var2, z6, z2));
                    next.d.add(new a(arrayList11, next));
                }
                z2 = true;
                arrayList10.add(new d(next, m8Var2, z6, z2));
                next.d.add(new a(arrayList11, next));
            } else {
                if (next != dVar7) {
                    arrayList10.add(new d(next, m8Var2, z6, z2));
                    next.d.add(new a(arrayList11, next));
                }
                z2 = true;
                arrayList10.add(new d(next, m8Var2, z6, z2));
                next.d.add(new a(arrayList11, next));
            }
        }
        HashMap hashMap = new HashMap();
        fd fdVar2 = null;
        for (d dVar9 : arrayList10) {
            if (!dVar9.b()) {
                gd a2 = dVar9.a(dVar9.c);
                gd a3 = dVar9.a(dVar9.e);
                if (a2 != null && a3 != null && a2 != a3) {
                    StringBuilder a4 = jg.a("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    a4.append(dVar9.a.c);
                    a4.append(" returned Transition ");
                    a4.append(dVar9.c);
                    a4.append(" which uses a different Transition  type than its shared element transition ");
                    a4.append(dVar9.e);
                    throw new IllegalArgumentException(a4.toString());
                }
                if (a2 == null) {
                    a2 = a3;
                }
                if (fdVar2 == null) {
                    fdVar2 = a2;
                } else if (a2 != null && fdVar2 != a2) {
                    StringBuilder a5 = jg.a("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    a5.append(dVar9.a.c);
                    a5.append(" returned Transition ");
                    a5.append(dVar9.c);
                    a5.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(a5.toString());
                }
            }
        }
        String str5 = "FragmentManager";
        if (fdVar2 == null) {
            for (d dVar10 : arrayList10) {
                hashMap.put(dVar10.a, false);
                dVar10.a();
            }
            z3 = true;
            arrayList = arrayList9;
            arrayList8 = arrayList11;
            qbVar = this;
            str = "FragmentManager";
        } else {
            View view6 = new View(this.a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList12 = new ArrayList<>();
            ArrayList<View> arrayList13 = new ArrayList<>();
            y4 y4Var2 = new y4();
            boolean z7 = false;
            Rect rect3 = rect2;
            ld.d dVar11 = dVar7;
            arrayList = arrayList9;
            TransitionSet transitionSet3 = null;
            View view7 = null;
            View view8 = view6;
            qbVar = this;
            ld.d dVar12 = dVar6;
            fd fdVar3 = fdVar2;
            for (d dVar13 : arrayList10) {
                String str6 = str5;
                ArrayList arrayList14 = arrayList11;
                if (!(dVar13.e != null) || dVar12 == null || dVar11 == null) {
                    y4Var = y4Var2;
                    arrayList5 = arrayList13;
                    dVar4 = dVar6;
                    arrayList6 = arrayList10;
                    view3 = view8;
                    str4 = str6;
                } else {
                    Object b3 = fdVar3.b(dVar13.e);
                    if (b3 == null) {
                        transitionSet2 = null;
                    } else {
                        transitionSet2 = new TransitionSet();
                        transitionSet2.addTransition((Transition) b3);
                    }
                    ArrayList<String> t0 = dVar11.c.t0();
                    ArrayList<String> t02 = dVar12.c.t0();
                    arrayList6 = arrayList10;
                    ArrayList<String> u0 = dVar12.c.u0();
                    HashMap hashMap2 = hashMap;
                    int i2 = 0;
                    while (i2 < u0.size()) {
                        int indexOf = t0.indexOf(u0.get(i2));
                        ArrayList<String> arrayList15 = u0;
                        if (indexOf != -1) {
                            t0.set(indexOf, t02.get(i2));
                        }
                        i2++;
                        u0 = arrayList15;
                    }
                    ArrayList<String> u02 = dVar11.c.u0();
                    if (!z6) {
                        dVar12.c.a0();
                        dVar11.c.X();
                    } else {
                        dVar12.c.X();
                        dVar11.c.a0();
                    }
                    int i3 = 0;
                    for (int size = t0.size(); i3 < size; size = size) {
                        y4Var2.put(t0.get(i3), u02.get(i3));
                        i3++;
                    }
                    y4 y4Var3 = new y4();
                    qbVar.a(y4Var3, dVar12.c.J);
                    e5.a((Map) y4Var3, (Collection<?>) t0);
                    e5.a((Map) y4Var2, (Collection<?>) y4Var3.keySet());
                    y4 y4Var4 = new y4();
                    qbVar.a(y4Var4, dVar11.c.J);
                    e5.a((Map) y4Var4, (Collection<?>) u02);
                    e5.a((Map) y4Var4, (Collection<?>) y4Var2.values());
                    ed.a(y4Var2, y4Var4);
                    qbVar.a(y4Var3, y4Var2.keySet());
                    qbVar.a(y4Var4, y4Var2.values());
                    if (y4Var2.isEmpty()) {
                        arrayList12.clear();
                        arrayList13.clear();
                        transitionSet3 = null;
                        y4Var = y4Var2;
                        arrayList5 = arrayList13;
                        dVar4 = dVar6;
                        view3 = view8;
                        str4 = str6;
                        hashMap = hashMap2;
                    } else {
                        ed.a(dVar11.c, dVar12.c, z6, (y4<String, View>) y4Var3, true);
                        y4Var = y4Var2;
                        arrayList5 = arrayList13;
                        ld.d dVar14 = dVar7;
                        ld.d dVar15 = dVar7;
                        arrayList7 = arrayList12;
                        ld.d dVar16 = dVar6;
                        View view9 = view8;
                        v9.a(qbVar.a, new vb(this, dVar14, dVar6, z, y4Var4));
                        arrayList7.addAll(y4Var3.values());
                        if (t0.isEmpty()) {
                            i = 0;
                            view4 = view7;
                        } else {
                            i = 0;
                            view4 = (View) y4Var3.get(t0.get(0));
                            fdVar3.c(transitionSet2, view4);
                        }
                        arrayList5.addAll(y4Var4.values());
                        if (u02.isEmpty() || (view5 = (View) y4Var4.get(u02.get(i))) == null) {
                            qbVar2 = this;
                            rect = rect3;
                        } else {
                            qbVar2 = this;
                            rect = rect3;
                            v9.a(qbVar2.a, new wb(qbVar2, fdVar3, view5, rect));
                            z7 = true;
                        }
                        view3 = view9;
                        fdVar3.b((Object) transitionSet2, view3, arrayList7);
                        str4 = str6;
                        fdVar = fdVar3;
                        fdVar3.a(transitionSet2, null, null, null, null, transitionSet2, arrayList5);
                        hashMap = hashMap2;
                        dVar4 = dVar16;
                        hashMap.put(dVar4, true);
                        dVar5 = dVar15;
                        hashMap.put(dVar5, true);
                        view7 = view4;
                        qbVar = qbVar2;
                        transitionSet3 = transitionSet2;
                        dVar12 = dVar4;
                        dVar11 = dVar5;
                        view8 = view3;
                        arrayList13 = arrayList5;
                        rect3 = rect;
                        dVar6 = dVar4;
                        arrayList11 = arrayList14;
                        y4Var2 = y4Var;
                        z6 = z;
                        str5 = str4;
                        arrayList10 = arrayList6;
                        ld.d dVar17 = dVar5;
                        fdVar3 = fdVar;
                        arrayList12 = arrayList7;
                        dVar7 = dVar17;
                    }
                }
                rect = rect3;
                ld.d dVar18 = dVar7;
                arrayList7 = arrayList12;
                fdVar = fdVar3;
                dVar5 = dVar18;
                view8 = view3;
                arrayList13 = arrayList5;
                rect3 = rect;
                dVar6 = dVar4;
                arrayList11 = arrayList14;
                y4Var2 = y4Var;
                z6 = z;
                str5 = str4;
                arrayList10 = arrayList6;
                ld.d dVar172 = dVar5;
                fdVar3 = fdVar;
                arrayList12 = arrayList7;
                dVar7 = dVar172;
            }
            Rect rect4 = rect3;
            y4 y4Var5 = y4Var2;
            ArrayList<View> arrayList16 = arrayList13;
            ArrayList<d> arrayList17 = arrayList10;
            ArrayList arrayList18 = arrayList11;
            String str7 = str5;
            View view10 = view8;
            ld.d dVar19 = dVar7;
            ArrayList<View> arrayList19 = arrayList12;
            fd fdVar4 = fdVar3;
            ld.d dVar20 = dVar19;
            ArrayList arrayList20 = new ArrayList();
            Iterator it2 = arrayList17.iterator();
            Object obj3 = null;
            ld.d dVar21 = dVar11;
            Object obj4 = null;
            while (it2.hasNext()) {
                Iterator it3 = it2;
                d dVar22 = (d) it2.next();
                if (dVar22.b()) {
                    dVar = dVar20;
                    hashMap.put(dVar22.a, false);
                    dVar22.a();
                    obj3 = obj3;
                    view = view10;
                    transitionSet = transitionSet3;
                    dVar3 = dVar12;
                    arrayList3 = arrayList16;
                    arrayList4 = arrayList19;
                    str3 = str7;
                    view2 = view7;
                } else {
                    Object obj5 = obj3;
                    dVar = dVar20;
                    Object b4 = fdVar4.b(dVar22.c);
                    ld.d dVar23 = dVar22.a;
                    boolean z8 = transitionSet3 != null && (dVar23 == dVar12 || dVar23 == dVar21);
                    if (b4 == null) {
                        if (!z8) {
                            hashMap.put(dVar23, false);
                            dVar22.a();
                        }
                        obj3 = obj5;
                        view = view10;
                        transitionSet = transitionSet3;
                        dVar3 = dVar12;
                        arrayList3 = arrayList16;
                        arrayList4 = arrayList19;
                        str3 = str7;
                        view2 = view7;
                    } else {
                        str3 = str7;
                        ArrayList<View> arrayList21 = new ArrayList<>();
                        transitionSet = transitionSet3;
                        qbVar.a(arrayList21, dVar23.c.J);
                        if (z8) {
                            if (dVar23 == dVar12) {
                                arrayList21.removeAll(arrayList19);
                            } else {
                                arrayList21.removeAll(arrayList16);
                            }
                        }
                        if (arrayList21.isEmpty()) {
                            ((Transition) b4).addTarget(view10);
                            obj = obj5;
                            view = view10;
                            dVar3 = dVar12;
                            arrayList3 = arrayList16;
                            arrayList4 = arrayList19;
                            dVar2 = dVar23;
                            obj2 = b4;
                        } else {
                            fdVar4.a(b4, arrayList21);
                            obj = obj5;
                            dVar2 = dVar23;
                            view = view10;
                            fdVar4.a(b4, b4, arrayList21, null, null, null, null);
                            if (dVar2.a == ld.d.c.GONE) {
                                arrayList18.remove(dVar2);
                                ArrayList arrayList22 = new ArrayList(arrayList21);
                                arrayList22.remove(dVar2.c.J);
                                arrayList4 = arrayList19;
                                dVar = dVar;
                                arrayList3 = arrayList16;
                                obj2 = b4;
                                dVar3 = dVar12;
                                ((Transition) obj2).addListener(new fd.b(fdVar4, dVar2.c.J, arrayList22));
                                v9.a(qbVar.a, new xb(qbVar, arrayList21));
                            } else {
                                dVar = dVar;
                                dVar3 = dVar12;
                                arrayList3 = arrayList16;
                                arrayList4 = arrayList19;
                                obj2 = b4;
                            }
                        }
                        if (dVar2.a == ld.d.c.VISIBLE) {
                            arrayList20.addAll(arrayList21);
                            if (z7) {
                                fdVar4.a(obj2, rect4);
                            }
                            view2 = view7;
                        } else {
                            view2 = view7;
                            fdVar4.c(obj2, view2);
                        }
                        hashMap.put(dVar2, true);
                        if (dVar22.d) {
                            obj4 = fdVar4.b(obj4, obj2, (Object) null);
                            obj3 = obj;
                        } else {
                            obj3 = fdVar4.b(obj, obj2, (Object) null);
                        }
                    }
                    dVar21 = dVar;
                }
                it2 = it3;
                view7 = view2;
                dVar12 = dVar3;
                arrayList19 = arrayList4;
                arrayList16 = arrayList3;
                str7 = str3;
                transitionSet3 = transitionSet;
                dVar20 = dVar;
                view10 = view;
            }
            ld.d dVar24 = dVar12;
            ArrayList<View> arrayList23 = arrayList16;
            ArrayList<View> arrayList24 = arrayList19;
            String str8 = str7;
            ld.d dVar25 = dVar20;
            TransitionSet transitionSet4 = transitionSet3;
            Object a6 = fdVar4.a(obj4, obj3, transitionSet4);
            for (d dVar26 : arrayList17) {
                if (!dVar26.b()) {
                    Object obj6 = dVar26.c;
                    ld.d dVar27 = dVar26.a;
                    ld.d dVar28 = dVar24;
                    ld.d dVar29 = dVar25;
                    boolean z9 = transitionSet4 != null && (dVar27 == dVar28 || dVar27 == dVar29);
                    if (obj6 == null && !z9) {
                        str2 = str8;
                    } else if (!y9.r(qbVar.a)) {
                        if (oc.c(2)) {
                            StringBuilder a7 = jg.a("SpecialEffectsController: Container ");
                            a7.append(qbVar.a);
                            a7.append(" has not been laid out. Completing operation ");
                            a7.append(dVar27);
                            str2 = str8;
                            Log.v(str2, a7.toString());
                        } else {
                            str2 = str8;
                        }
                        dVar26.a();
                    } else {
                        str2 = str8;
                        fdVar4.a(dVar26.a.c, a6, dVar26.b, new yb(qbVar, dVar26));
                    }
                    str8 = str2;
                    dVar24 = dVar28;
                    dVar25 = dVar29;
                }
            }
            str = str8;
            if (y9.r(qbVar.a)) {
                ed.a(arrayList20, 4);
                ArrayList<String> a8 = fdVar4.a(arrayList23);
                TransitionManager.beginDelayedTransition(qbVar.a, (Transition) a6);
                arrayList2 = arrayList18;
                fdVar4.a(qbVar.a, arrayList24, arrayList23, a8, y4Var5);
                ed.a(arrayList20, 0);
                fdVar4.b((Object) transitionSet4, arrayList24, arrayList23);
                z2 = false;
            } else {
                z2 = false;
                arrayList2 = arrayList18;
            }
            z3 = true;
            arrayList8 = arrayList2;
        }
        boolean containsValue = hashMap.containsValue(Boolean.valueOf(z3));
        ViewGroup viewGroup = qbVar.a;
        Context context = viewGroup.getContext();
        ArrayList arrayList25 = new ArrayList();
        Iterator it4 = arrayList.iterator();
        boolean z10 = z2;
        while (it4.hasNext()) {
            b bVar = (b) it4.next();
            if (bVar.b()) {
                bVar.a();
            } else {
                fc a9 = bVar.a(context);
                if (a9 == null) {
                    bVar.a();
                } else {
                    Animator animator = a9.b;
                    if (animator == null) {
                        arrayList25.add(bVar);
                    } else {
                        ld.d dVar30 = bVar.a;
                        Fragment fragment = dVar30.c;
                        z4 = z3;
                        z5 = z2;
                        if (Boolean.TRUE.equals(hashMap.get(dVar30))) {
                            if (oc.c(2)) {
                                Log.v(str, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            bVar.a();
                            z3 = z4;
                            z2 = z5;
                        } else {
                            boolean z11 = dVar30.a == ld.d.c.GONE ? z4 : z5;
                            if (z11) {
                                arrayList8.remove(dVar30);
                            }
                            View view11 = fragment.J;
                            viewGroup.startViewTransition(view11);
                            animator.addListener(new rb(this, viewGroup, view11, z11, dVar30, bVar));
                            animator.setTarget(view11);
                            animator.start();
                            bVar.b.a(new sb(qbVar, animator));
                            z10 = true;
                            z2 = false;
                            z3 = true;
                            it4 = it4;
                            hashMap = hashMap;
                        }
                    }
                }
            }
            z4 = z3;
            z5 = z2;
            z3 = z4;
            z2 = z5;
        }
        Iterator it5 = arrayList25.iterator();
        while (it5.hasNext()) {
            b bVar2 = (b) it5.next();
            ld.d dVar31 = bVar2.a;
            Fragment fragment2 = dVar31.c;
            if (containsValue) {
                if (oc.c(2)) {
                    Log.v(str, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                bVar2.a();
            } else if (z10) {
                if (oc.c(2)) {
                    Log.v(str, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                bVar2.a();
            } else {
                View view12 = fragment2.J;
                fc a10 = bVar2.a(context);
                defpackage.a.a(a10);
                Animation animation = a10.a;
                defpackage.a.a(animation);
                if (dVar31.a != ld.d.c.REMOVED) {
                    view12.startAnimation(animation);
                    bVar2.a();
                } else {
                    viewGroup.startViewTransition(view12);
                    gc gcVar = new gc(animation, viewGroup, view12);
                    gcVar.setAnimationListener(new tb(qbVar, viewGroup, view12, bVar2));
                    view12.startAnimation(gcVar);
                }
                bVar2.b.a(new ub(qbVar, view12, viewGroup, bVar2));
            }
        }
        for (ld.d dVar32 : arrayList8) {
            dVar32.a.a(dVar32.c.J);
        }
        arrayList8.clear();
    }

    public void a(ld.d dVar) {
        dVar.a.a(dVar.c.J);
    }

    public void a(y4<String, View> y4Var, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = y4Var.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(y9.m(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public void a(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = Build.VERSION.SDK_INT;
            if (viewGroup.isTransitionGroup()) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    a(arrayList, childAt);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void a(Map<String, View> map, View view) {
        String m = y9.m(view);
        if (m != null) {
            map.put(m, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    a(map, childAt);
                }
            }
        }
    }
}
