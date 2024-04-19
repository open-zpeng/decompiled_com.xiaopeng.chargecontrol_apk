package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.nf;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: df  reason: default package */
/* loaded from: classes.dex */
public class df extends qf {
    public static TimeInterpolator s;
    public ArrayList<nf.c0> h = new ArrayList<>();
    public ArrayList<nf.c0> i = new ArrayList<>();
    public ArrayList<f> j = new ArrayList<>();
    public ArrayList<e> k = new ArrayList<>();
    public ArrayList<ArrayList<nf.c0>> l = new ArrayList<>();
    public ArrayList<ArrayList<f>> m = new ArrayList<>();
    public ArrayList<ArrayList<e>> n = new ArrayList<>();
    public ArrayList<nf.c0> o = new ArrayList<>();
    public ArrayList<nf.c0> p = new ArrayList<>();
    public ArrayList<nf.c0> q = new ArrayList<>();
    public ArrayList<nf.c0> r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: df$a */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ nf.c0 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ ViewPropertyAnimator e;

        public a(nf.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.c = c0Var;
            this.d = view;
            this.e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.d.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(null);
            df.this.a(this.c);
            df.this.o.remove(this.c);
            df.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            df.this.d(this.c);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: df$b */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ nf.c0 c;
        public final /* synthetic */ int d;
        public final /* synthetic */ View e;
        public final /* synthetic */ int f;
        public final /* synthetic */ ViewPropertyAnimator g;

        public b(nf.c0 c0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.c = c0Var;
            this.d = i;
            this.e = view;
            this.f = i2;
            this.g = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.d != 0) {
                this.e.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            }
            if (this.f != 0) {
                this.e.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.g.setListener(null);
            df.this.a(this.c);
            df.this.p.remove(this.c);
            df.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            df.this.e(this.c);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: df$c */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ e c;
        public final /* synthetic */ ViewPropertyAnimator d;
        public final /* synthetic */ View e;

        public c(e eVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.c = eVar;
            this.d = viewPropertyAnimator;
            this.e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.d.setListener(null);
            this.e.setAlpha(1.0f);
            this.e.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            this.e.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            df.this.a(this.c.a, true);
            df.this.r.remove(this.c.a);
            df.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            df.this.b(this.c.a, true);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: df$d */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ e c;
        public final /* synthetic */ ViewPropertyAnimator d;
        public final /* synthetic */ View e;

        public d(e eVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.c = eVar;
            this.d = viewPropertyAnimator;
            this.e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.d.setListener(null);
            this.e.setAlpha(1.0f);
            this.e.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            this.e.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            df.this.a(this.c.b, false);
            df.this.r.remove(this.c.b);
            df.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            df.this.b(this.c.b, false);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: df$e */
    /* loaded from: classes.dex */
    public static class e {
        public nf.c0 a;
        public nf.c0 b;
        public int c;
        public int d;
        public int e;
        public int f;

        public e(nf.c0 c0Var, nf.c0 c0Var2, int i, int i2, int i3, int i4) {
            this.a = c0Var;
            this.b = c0Var2;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            StringBuilder a = jg.a("ChangeInfo{oldHolder=");
            a.append(this.a);
            a.append(", newHolder=");
            a.append(this.b);
            a.append(", fromX=");
            a.append(this.c);
            a.append(", fromY=");
            a.append(this.d);
            a.append(", toX=");
            a.append(this.e);
            a.append(", toY=");
            a.append(this.f);
            a.append('}');
            return a.toString();
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: df$f */
    /* loaded from: classes.dex */
    public static class f {
        public nf.c0 a;
        public int b;
        public int c;
        public int d;
        public int e;

        public f(nf.c0 c0Var, int i, int i2, int i3, int i4) {
            this.a = c0Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    @Override // defpackage.qf
    public boolean a(nf.c0 c0Var, int i, int i2, int i3, int i4) {
        View view = c0Var.a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) c0Var.a.getTranslationY());
        h(c0Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            a(c0Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.j.add(new f(c0Var, translationX, translationY, i3, i4));
        return true;
    }

    public void b(nf.c0 c0Var, int i, int i2, int i3, int i4) {
        View view = c0Var.a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        }
        if (i6 != 0) {
            view.animate().translationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        }
        ViewPropertyAnimator animate = view.animate();
        this.p.add(c0Var);
        animate.setDuration(this.e).setListener(new b(c0Var, i5, view, i6, animate)).start();
    }

    @Override // defpackage.nf.k
    public boolean d() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public void f() {
        if (d()) {
            return;
        }
        a();
    }

    public void g(nf.c0 c0Var) {
        View view = c0Var.a;
        ViewPropertyAnimator animate = view.animate();
        this.o.add(c0Var);
        animate.alpha(1.0f).setDuration(this.c).setListener(new a(c0Var, view, animate)).start();
    }

    public final void h(nf.c0 c0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        c0Var.a.animate().setInterpolator(s);
        b(c0Var);
    }

    public void a(e eVar) {
        nf.c0 c0Var = eVar.a;
        View view = c0Var == null ? null : c0Var.a;
        nf.c0 c0Var2 = eVar.b;
        View view2 = c0Var2 != null ? c0Var2.a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(this.f);
            this.r.add(eVar.a);
            duration.translationX(eVar.e - eVar.c);
            duration.translationY(eVar.f - eVar.d);
            duration.alpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT).setListener(new c(eVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.r.add(eVar.b);
            animate.translationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT).translationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT).setDuration(this.f).alpha(1.0f).setListener(new d(eVar, animate, view2)).start();
        }
    }

    @Override // defpackage.nf.k
    public void b(nf.c0 c0Var) {
        View view = c0Var.a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).a == c0Var) {
                view.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                view.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                a(c0Var);
                this.j.remove(size);
            }
        }
        a(this.k, c0Var);
        if (this.h.remove(c0Var)) {
            view.setAlpha(1.0f);
            a(c0Var);
        }
        if (this.i.remove(c0Var)) {
            view.setAlpha(1.0f);
            a(c0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList<e> arrayList = this.n.get(size2);
            a(arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList<f> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).a == c0Var) {
                    view.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                    view.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                    a(c0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList<nf.c0> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                a(c0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(c0Var);
        this.o.remove(c0Var);
        this.r.remove(c0Var);
        this.p.remove(c0Var);
        f();
    }

    public final void a(List<e> list, nf.c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            e eVar = list.get(size);
            if (a(eVar, c0Var) && eVar.a == null && eVar.b == null) {
                list.remove(eVar);
            }
        }
    }

    public final boolean a(e eVar, nf.c0 c0Var) {
        if (eVar.b == c0Var) {
            eVar.b = null;
        } else if (eVar.a != c0Var) {
            return false;
        } else {
            eVar.a = null;
        }
        c0Var.a.setAlpha(1.0f);
        c0Var.a.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        c0Var.a.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        nf.k.b bVar = this.a;
        if (bVar != null) {
            ((nf.l) bVar).a(c0Var);
            return true;
        }
        return true;
    }

    public void a(List<nf.c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).a.animate().cancel();
        }
    }

    @Override // defpackage.nf.k
    public boolean a(nf.c0 c0Var, List<Object> list) {
        return !list.isEmpty() || super.a(c0Var, list);
    }

    @Override // defpackage.nf.k
    public void b() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            f fVar = this.j.get(size);
            View view = fVar.a.a;
            view.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            view.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            a(fVar.a);
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            a(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            nf.c0 c0Var = this.i.get(size3);
            c0Var.a.setAlpha(1.0f);
            nf.k.b bVar = this.a;
            if (bVar != null) {
                ((nf.l) bVar).a(c0Var);
            }
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            e eVar = this.k.get(size4);
            nf.c0 c0Var2 = eVar.a;
            if (c0Var2 != null) {
                a(eVar, c0Var2);
            }
            nf.c0 c0Var3 = eVar.b;
            if (c0Var3 != null) {
                a(eVar, c0Var3);
            }
        }
        this.k.clear();
        if (!d()) {
            return;
        }
        int size5 = this.m.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<f> arrayList = this.m.get(size5);
            int size6 = arrayList.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    f fVar2 = arrayList.get(size6);
                    View view2 = fVar2.a.a;
                    view2.setTranslationY(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                    view2.setTranslationX(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                    a(fVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
        }
        int size7 = this.l.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<nf.c0> arrayList2 = this.l.get(size7);
            int size8 = arrayList2.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    nf.c0 c0Var4 = arrayList2.get(size8);
                    c0Var4.a.setAlpha(1.0f);
                    nf.k.b bVar2 = this.a;
                    if (bVar2 != null) {
                        ((nf.l) bVar2).a(c0Var4);
                    }
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
        }
        int size9 = this.n.size();
        while (true) {
            size9--;
            if (size9 >= 0) {
                ArrayList<e> arrayList3 = this.n.get(size9);
                int size10 = arrayList3.size();
                while (true) {
                    size10--;
                    if (size10 >= 0) {
                        e eVar2 = arrayList3.get(size10);
                        nf.c0 c0Var5 = eVar2.a;
                        if (c0Var5 != null) {
                            a(eVar2, c0Var5);
                        }
                        nf.c0 c0Var6 = eVar2.b;
                        if (c0Var6 != null) {
                            a(eVar2, c0Var6);
                        }
                        if (arrayList3.isEmpty()) {
                            this.n.remove(arrayList3);
                        }
                    }
                }
            } else {
                a(this.q);
                a(this.p);
                a(this.o);
                a(this.r);
                a();
                return;
            }
        }
    }
}
