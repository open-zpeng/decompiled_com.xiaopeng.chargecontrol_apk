package defpackage;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FragmentTransitionCompat21.java */
/* renamed from: fd  reason: default package */
/* loaded from: classes.dex */
public class fd extends gd {

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: fd$a */
    /* loaded from: classes.dex */
    public class a extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public a(fd fdVar, Rect rect) {
            this.a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.a;
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: fd$b */
    /* loaded from: classes.dex */
    public class b implements Transition.TransitionListener {
        public final /* synthetic */ View c;
        public final /* synthetic */ ArrayList d;

        public b(fd fdVar, View view, ArrayList arrayList) {
            this.c = view;
            this.d = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.c.setVisibility(8);
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                ((View) this.d.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: fd$c */
    /* loaded from: classes.dex */
    public class c implements Transition.TransitionListener {
        public final /* synthetic */ Object c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ Object g;
        public final /* synthetic */ ArrayList h;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.c = obj;
            this.d = arrayList;
            this.e = obj2;
            this.f = arrayList2;
            this.g = obj3;
            this.h = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.c;
            if (obj != null) {
                fd.this.a(obj, this.d, (ArrayList<View>) null);
            }
            Object obj2 = this.e;
            if (obj2 != null) {
                fd.this.a(obj2, this.f, (ArrayList<View>) null);
            }
            Object obj3 = this.g;
            if (obj3 != null) {
                fd.this.a(obj3, this.h, (ArrayList<View>) null);
            }
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: fd$d */
    /* loaded from: classes.dex */
    public class d implements Transition.TransitionListener {
        public final /* synthetic */ Runnable c;

        public d(fd fdVar, Runnable runnable) {
            this.c = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.c.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: fd$e */
    /* loaded from: classes.dex */
    public class e extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public e(fd fdVar, Rect rect) {
            this.a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.a;
        }
    }

    @Override // defpackage.gd
    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // defpackage.gd
    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // defpackage.gd
    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(this, rect));
        }
    }

    @Override // defpackage.gd
    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                a(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (a(transition) || !gd.a((List) transition.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                transition.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // defpackage.gd
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            int size2 = targets.size();
            if (!gd.a(targets, view2, size2)) {
                if (y9.m(view2) != null) {
                    targets.add(view2);
                }
                for (int i2 = size2; i2 < targets.size(); i2++) {
                    View view3 = targets.get(i2);
                    if (view3 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view3;
                        int childCount = viewGroup.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = viewGroup.getChildAt(i3);
                            if (!gd.a(targets, childAt, size2) && y9.m(childAt) != null) {
                                targets.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        targets.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    public static boolean a(Transition transition) {
        return (gd.a((List) transition.getTargetIds()) && gd.a((List) transition.getTargetNames()) && gd.a((List) transition.getTargetTypes())) ? false : true;
    }

    @Override // defpackage.gd
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(this, view, arrayList));
    }

    @Override // defpackage.gd
    public Object a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // defpackage.gd
    public Object b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // defpackage.gd
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // defpackage.gd
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // defpackage.gd
    public void a(Fragment fragment, Object obj, m8 m8Var, Runnable runnable) {
        ((Transition) obj).addListener(new d(this, runnable));
    }

    @Override // defpackage.gd
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                a((Object) transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
        } else if (!a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // defpackage.gd
    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // defpackage.gd
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // defpackage.gd
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(this, rect));
        }
    }
}
