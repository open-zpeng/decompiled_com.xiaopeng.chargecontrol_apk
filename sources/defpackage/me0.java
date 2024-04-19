package defpackage;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* compiled from: XTouchTargetUtils.java */
/* renamed from: me0  reason: default package */
/* loaded from: classes.dex */
public class me0 {
    public static final Rect a = new Rect();

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: me0$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        public a(View view, View view2, int i, int i2, int i3, int i4) {
            this.c = view;
            this.d = view2;
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c.isAttachedToWindow()) {
                StringBuilder a = jg.a("not isAttachedToWindow ");
                a.append(hashCode());
                me0.a(a.toString());
                return;
            }
            this.c.getHitRect(me0.a);
            if (me0.a.width() != 0 && me0.a.height() != 0) {
                Rect rect = new Rect();
                rect.set(me0.a);
                ViewParent parent = this.c.getParent();
                while (parent != this.d) {
                    if (!(parent instanceof View)) {
                        return;
                    }
                    View view = (View) parent;
                    view.getHitRect(me0.a);
                    Rect rect2 = me0.a;
                    rect.offset(rect2.left, rect2.top);
                    parent = view.getParent();
                }
                rect.left -= this.e;
                rect.top -= this.f;
                rect.right += this.g;
                rect.bottom += this.h;
                ke0 ke0Var = new ke0(rect, this.c);
                le0 a2 = me0.a(this.d);
                a2.a(ke0Var);
                this.d.setTouchDelegate(a2);
                this.c.addOnAttachStateChangeListener(new e(ke0Var, a2));
                return;
            }
            StringBuilder a3 = jg.a(" width or height == 0 ");
            a3.append(hashCode());
            a3.toString();
            d dVar = new d(this.d, this.e, this.f, this.g, this.h);
            this.c.addOnLayoutChangeListener(dVar);
            this.c.addOnAttachStateChangeListener(dVar);
        }
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: me0$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final /* synthetic */ View c;
        public final /* synthetic */ ViewGroup d;

        public b(View view, ViewGroup viewGroup) {
            this.c = view;
            this.d = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c.isAttachedToWindow()) {
                StringBuilder a = jg.a(" as not isAttachedToWindow ");
                a.append(hashCode());
                me0.a(a.toString());
            } else if (this.d.getWidth() != 0 && this.d.getHeight() != 0) {
                ke0 ke0Var = new ke0(new Rect(0, 0, this.d.getWidth(), this.d.getHeight()), this.c);
                le0 a2 = me0.a(this.d);
                a2.a(ke0Var);
                this.d.setTouchDelegate(a2);
                this.c.addOnAttachStateChangeListener(new e(ke0Var, a2));
            } else {
                StringBuilder a3 = jg.a(" as width or height == 0 ");
                a3.append(hashCode());
                me0.a(a3.toString());
                c cVar = new c(this.d);
                this.c.addOnLayoutChangeListener(cVar);
                this.c.addOnAttachStateChangeListener(cVar);
            }
        }
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: me0$c */
    /* loaded from: classes.dex */
    public static class c implements View.OnLayoutChangeListener, View.OnAttachStateChangeListener {
        public static int d;
        public ViewGroup c;

        public c(ViewGroup viewGroup) {
            this.c = viewGroup;
            d++;
        }

        public void finalize() {
            super.finalize();
            d--;
            if (d == 0) {
                StringBuilder a = jg.a(" LayoutAttachStateChangeListener2  finalize ");
                a.append(d);
                be0.a("xpui-touch", a.toString());
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                return;
            }
            me0.a(view, this.c);
            this.c = null;
            view.removeOnLayoutChangeListener(this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnLayoutChangeListener(this);
            view.removeOnAttachStateChangeListener(this);
            me0.a(" LayoutAttachStateChangeListener2  onViewDetachedFromWindow ");
        }
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: me0$d */
    /* loaded from: classes.dex */
    public static class d implements View.OnLayoutChangeListener, View.OnAttachStateChangeListener {
        public static int h;
        public View c;
        public int d;
        public int e;
        public int f;
        public int g;

        public d(View view, int i, int i2, int i3, int i4) {
            this.c = view;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            h++;
        }

        public void finalize() {
            super.finalize();
            h--;
            if (h == 0) {
                StringBuilder a = jg.a(" LayoutAttachStateChangeListener  finalize ");
                a.append(h);
                be0.a("xpui-touch", a.toString());
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                return;
            }
            me0.a(view, this.c, this.d, this.e, this.f, this.g);
            this.c = null;
            view.removeOnLayoutChangeListener(this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnLayoutChangeListener(this);
            view.removeOnAttachStateChangeListener(this);
            me0.a(" LayoutAttachStateChangeListener  onViewDetachedFromWindow ");
        }
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: me0$e */
    /* loaded from: classes.dex */
    public static class e implements View.OnAttachStateChangeListener {
        public static int e;
        public ke0 c;
        public le0 d;

        public e(ke0 ke0Var, le0 le0Var) {
            this.c = ke0Var;
            this.d = le0Var;
            e++;
        }

        public void finalize() {
            super.finalize();
            e--;
            if (e == 0) {
                StringBuilder a = jg.a(" MyStateChangeListener finalize ");
                a.append(e);
                be0.a("xpui-touch", a.toString());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            le0 le0Var = this.d;
            ke0 ke0Var = this.c;
            le0Var.a.remove(ke0Var);
            if (ke0Var == le0Var.b) {
                le0Var.b = null;
            }
            StringBuilder a = jg.a("  MyStateChangeListener onViewDetachedFromWindow ");
            a.append(view.hashCode());
            me0.a(a.toString());
            this.d = null;
            this.c = null;
        }
    }

    public static void a(View view, View view2, int i, int i2, int i3, int i4) {
        if (view == null || view2 == null) {
            return;
        }
        view2.post(new a(view, view2, i, i2, i3, i4));
    }

    public static /* synthetic */ void a(String str) {
    }

    public static void a(View view, ViewGroup viewGroup) {
        if (view == null || viewGroup == null) {
            return;
        }
        view.post(new b(view, viewGroup));
    }

    public static le0 a(View view) {
        TouchDelegate touchDelegate = view.getTouchDelegate();
        if (touchDelegate != null) {
            if (touchDelegate instanceof le0) {
                return (le0) touchDelegate;
            }
            le0 le0Var = new le0(view);
            if (touchDelegate instanceof ke0) {
                le0Var.a((ke0) touchDelegate);
            }
            return le0Var;
        }
        return new le0(view);
    }
}
