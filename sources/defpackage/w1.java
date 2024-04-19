package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import defpackage.g2;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CascadingMenuPopup.java */
/* renamed from: w1  reason: default package */
/* loaded from: classes.dex */
public final class w1 extends e2 implements g2, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int D = f0.abc_cascading_menu_item_layout;
    public ViewTreeObserver A;
    public PopupWindow.OnDismissListener B;
    public boolean C;
    public final Context d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final Handler i;
    public View q;
    public View r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public boolean y;
    public g2.a z;
    public final List<z1> j = new ArrayList();
    public final List<d> k = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener l = new a();
    public final View.OnAttachStateChangeListener m = new b();
    public final b4 n = new c();
    public int o = 0;
    public int p = 0;
    public boolean x = false;

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: w1$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!w1.this.b() || w1.this.k.size() <= 0 || w1.this.k.get(0).a.F) {
                return;
            }
            View view = w1.this.r;
            if (view != null && view.isShown()) {
                for (d dVar : w1.this.k) {
                    dVar.a.c();
                }
                return;
            }
            w1.this.dismiss();
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: w1$b */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = w1.this.A;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    w1.this.A = view.getViewTreeObserver();
                }
                w1 w1Var = w1.this;
                w1Var.A.removeGlobalOnLayoutListener(w1Var.l);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: w1$c */
    /* loaded from: classes.dex */
    public class c implements b4 {

        /* compiled from: CascadingMenuPopup.java */
        /* renamed from: w1$c$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ d c;
            public final /* synthetic */ MenuItem d;
            public final /* synthetic */ z1 e;

            public a(d dVar, MenuItem menuItem, z1 z1Var) {
                this.c = dVar;
                this.d = menuItem;
                this.e = z1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.c;
                if (dVar != null) {
                    w1.this.C = true;
                    dVar.b.a(false);
                    w1.this.C = false;
                }
                if (this.d.isEnabled() && this.d.hasSubMenu()) {
                    this.e.a(this.d, 4);
                }
            }
        }

        public c() {
        }

        @Override // defpackage.b4
        public void a(z1 z1Var, MenuItem menuItem) {
            w1.this.i.removeCallbacksAndMessages(null);
            int size = w1.this.k.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (z1Var == w1.this.k.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            w1.this.i.postAtTime(new a(i2 < w1.this.k.size() ? w1.this.k.get(i2) : null, menuItem, z1Var), z1Var, SystemClock.uptimeMillis() + 200);
        }

        @Override // defpackage.b4
        public void b(z1 z1Var, MenuItem menuItem) {
            w1.this.i.removeCallbacksAndMessages(z1Var);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: w1$d */
    /* loaded from: classes.dex */
    public static class d {
        public final c4 a;
        public final z1 b;
        public final int c;

        public d(c4 c4Var, z1 z1Var, int i) {
            this.a = c4Var;
            this.b = z1Var;
            this.c = i;
        }
    }

    public w1(Context context, View view, int i, int i2, boolean z) {
        this.d = context;
        this.q = view;
        this.f = i;
        this.g = i2;
        this.h = z;
        this.s = y9.h(this.q) == 1 ? 0 : 1;
        Resources resources = context.getResources();
        this.e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c0.abc_config_prefDialogWidth));
        this.i = new Handler();
    }

    @Override // defpackage.e2
    public void a(z1 z1Var) {
        z1Var.a(this, this.d);
        if (b()) {
            c(z1Var);
        } else {
            this.j.add(z1Var);
        }
    }

    @Override // defpackage.g2
    public boolean a() {
        return false;
    }

    @Override // defpackage.e2
    public void b(boolean z) {
        this.x = z;
    }

    @Override // defpackage.j2
    public void c() {
        if (b()) {
            return;
        }
        for (z1 z1Var : this.j) {
            c(z1Var);
        }
        this.j.clear();
        this.r = this.q;
        if (this.r != null) {
            boolean z = this.A == null;
            this.A = this.r.getViewTreeObserver();
            if (z) {
                this.A.addOnGlobalLayoutListener(this.l);
            }
            this.r.addOnAttachStateChangeListener(this.m);
        }
    }

    @Override // defpackage.e2
    public boolean d() {
        return false;
    }

    @Override // defpackage.j2
    public void dismiss() {
        int size = this.k.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.k.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.a.b()) {
                    dVar.a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.j2
    public ListView e() {
        if (this.k.isEmpty()) {
            return null;
        }
        List<d> list = this.k;
        return list.get(list.size() - 1).a.e;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.k.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = this.k.get(i);
            if (!dVar.a.b()) {
                break;
            }
            i++;
        }
        if (dVar != null) {
            dVar.b.a(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // defpackage.j2
    public boolean b() {
        return this.k.size() > 0 && this.k.get(0).a.b();
    }

    @Override // defpackage.e2
    public void b(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // defpackage.g2
    public void a(boolean z) {
        for (d dVar : this.k) {
            ListAdapter adapter = dVar.a.e.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((y1) adapter).notifyDataSetChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.z1 r17) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w1.c(z1):void");
    }

    @Override // defpackage.g2
    public void a(g2.a aVar) {
        this.z = aVar;
    }

    @Override // defpackage.g2
    public boolean a(l2 l2Var) {
        for (d dVar : this.k) {
            if (l2Var == dVar.b) {
                dVar.a.e.requestFocus();
                return true;
            }
        }
        if (l2Var.hasVisibleItems()) {
            a((z1) l2Var);
            g2.a aVar = this.z;
            if (aVar != null) {
                aVar.a(l2Var);
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.g2
    public void a(z1 z1Var, boolean z) {
        int size = this.k.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (z1Var == this.k.get(i).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < this.k.size()) {
            this.k.get(i2).b.a(false);
        }
        d remove = this.k.remove(i);
        remove.b.a(this);
        if (this.C) {
            remove.a.a((Object) null);
            remove.a.G.setAnimationStyle(0);
        }
        remove.a.dismiss();
        int size2 = this.k.size();
        if (size2 > 0) {
            this.s = this.k.get(size2 - 1).c;
        } else {
            this.s = y9.h(this.q) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                this.k.get(0).b.a(false);
                return;
            }
            return;
        }
        dismiss();
        g2.a aVar = this.z;
        if (aVar != null) {
            aVar.a(z1Var, true);
        }
        ViewTreeObserver viewTreeObserver = this.A;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.A.removeGlobalOnLayoutListener(this.l);
            }
            this.A = null;
        }
        this.r.removeOnAttachStateChangeListener(this.m);
        this.B.onDismiss();
    }

    @Override // defpackage.e2
    public void a(int i) {
        if (this.o != i) {
            this.o = i;
            this.p = defpackage.a.a(i, y9.h(this.q));
        }
    }

    @Override // defpackage.e2
    public void a(View view) {
        if (this.q != view) {
            this.q = view;
            this.p = defpackage.a.a(this.o, y9.h(this.q));
        }
    }

    @Override // defpackage.e2
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.B = onDismissListener;
    }

    @Override // defpackage.e2
    public void c(int i) {
        this.u = true;
        this.w = i;
    }

    @Override // defpackage.e2
    public void c(boolean z) {
        this.y = z;
    }
}
