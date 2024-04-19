package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.g2;
/* compiled from: StandardMenuPopup.java */
/* renamed from: k2  reason: default package */
/* loaded from: classes.dex */
public final class k2 extends e2 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, g2, View.OnKeyListener {
    public static final int x = f0.abc_popup_menu_item_layout;
    public final Context d;
    public final z1 e;
    public final y1 f;
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final c4 k;
    public PopupWindow.OnDismissListener n;
    public View o;
    public View p;
    public g2.a q;
    public ViewTreeObserver r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean w;
    public final ViewTreeObserver.OnGlobalLayoutListener l = new a();
    public final View.OnAttachStateChangeListener m = new b();
    public int v = 0;

    /* compiled from: StandardMenuPopup.java */
    /* renamed from: k2$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (k2.this.b()) {
                k2 k2Var = k2.this;
                if (k2Var.k.F) {
                    return;
                }
                View view = k2Var.p;
                if (view != null && view.isShown()) {
                    k2.this.k.c();
                } else {
                    k2.this.dismiss();
                }
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    /* renamed from: k2$b */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = k2.this.r;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    k2.this.r = view.getViewTreeObserver();
                }
                k2 k2Var = k2.this;
                k2Var.r.removeGlobalOnLayoutListener(k2Var.l);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public k2(Context context, z1 z1Var, View view, int i, int i2, boolean z) {
        this.d = context;
        this.e = z1Var;
        this.g = z;
        this.f = new y1(z1Var, LayoutInflater.from(context), this.g, x);
        this.i = i;
        this.j = i2;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c0.abc_config_prefDialogWidth));
        this.o = view;
        this.k = new c4(this.d, null, this.i, this.j);
        z1Var.a(this, context);
    }

    @Override // defpackage.e2
    public void a(int i) {
        this.v = i;
    }

    @Override // defpackage.e2
    public void a(z1 z1Var) {
    }

    @Override // defpackage.g2
    public boolean a() {
        return false;
    }

    @Override // defpackage.e2
    public void b(boolean z) {
        this.f.e = z;
    }

    @Override // defpackage.j2
    public void c() {
        View view;
        boolean z = true;
        if (!b()) {
            if (this.s || (view = this.o) == null) {
                z = false;
            } else {
                this.p = view;
                this.k.G.setOnDismissListener(this);
                c4 c4Var = this.k;
                c4Var.w = this;
                c4Var.a(true);
                View view2 = this.p;
                boolean z2 = this.r == null;
                this.r = view2.getViewTreeObserver();
                if (z2) {
                    this.r.addOnGlobalLayoutListener(this.l);
                }
                view2.addOnAttachStateChangeListener(this.m);
                c4 c4Var2 = this.k;
                c4Var2.u = view2;
                c4Var2.n = this.v;
                if (!this.t) {
                    this.u = e2.a(this.f, null, this.d, this.h);
                    this.t = true;
                }
                this.k.d(this.u);
                this.k.G.setInputMethodMode(2);
                this.k.a(f());
                this.k.c();
                u3 u3Var = this.k.e;
                u3Var.setOnKeyListener(this);
                if (this.w && this.e.n != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.d).inflate(f0.abc_popup_menu_header_item_layout, (ViewGroup) u3Var, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.e.n);
                    }
                    frameLayout.setEnabled(false);
                    u3Var.addHeaderView(frameLayout, null, false);
                }
                this.k.a((ListAdapter) this.f);
                this.k.c();
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // defpackage.j2
    public void dismiss() {
        if (b()) {
            this.k.dismiss();
        }
    }

    @Override // defpackage.j2
    public ListView e() {
        return this.k.e;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.s = true;
        this.e.a(true);
        ViewTreeObserver viewTreeObserver = this.r;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.r = this.p.getViewTreeObserver();
            }
            this.r.removeGlobalOnLayoutListener(this.l);
            this.r = null;
        }
        this.p.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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

    @Override // defpackage.g2
    public void a(boolean z) {
        this.t = false;
        y1 y1Var = this.f;
        if (y1Var != null) {
            y1Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.j2
    public boolean b() {
        return !this.s && this.k.b();
    }

    @Override // defpackage.e2
    public void b(int i) {
        this.k.h = i;
    }

    @Override // defpackage.g2
    public void a(g2.a aVar) {
        this.q = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    @Override // defpackage.g2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(defpackage.l2 r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L72
            f2 r0 = new f2
            android.content.Context r3 = r9.d
            android.view.View r5 = r9.p
            boolean r6 = r9.g
            int r7 = r9.i
            int r8 = r9.j
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            g2$a r2 = r9.q
            r0.a(r2)
            boolean r2 = defpackage.e2.b(r10)
            r0.h = r2
            e2 r3 = r0.j
            if (r3 == 0) goto L2a
            r3.b(r2)
        L2a:
            android.widget.PopupWindow$OnDismissListener r2 = r9.n
            r0.k = r2
            r2 = 0
            r9.n = r2
            z1 r2 = r9.e
            r2.a(r1)
            c4 r2 = r9.k
            int r3 = r2.h
            int r2 = r2.f()
            int r4 = r9.v
            android.view.View r5 = r9.o
            int r5 = defpackage.y9.h(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L56
            android.view.View r4 = r9.o
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L56:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L5e
            goto L67
        L5e:
            android.view.View r4 = r0.f
            if (r4 != 0) goto L64
            r0 = r1
            goto L68
        L64:
            r0.a(r3, r2, r5, r5)
        L67:
            r0 = r5
        L68:
            if (r0 == 0) goto L72
            g2$a r0 = r9.q
            if (r0 == 0) goto L71
            r0.a(r10)
        L71:
            return r5
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k2.a(l2):boolean");
    }

    @Override // defpackage.g2
    public void a(z1 z1Var, boolean z) {
        if (z1Var != this.e) {
            return;
        }
        dismiss();
        g2.a aVar = this.q;
        if (aVar != null) {
            aVar.a(z1Var, z);
        }
    }

    @Override // defpackage.e2
    public void a(View view) {
        this.o = view;
    }

    @Override // defpackage.e2
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // defpackage.e2
    public void c(int i) {
        c4 c4Var = this.k;
        c4Var.i = i;
        c4Var.k = true;
    }

    @Override // defpackage.e2
    public void c(boolean z) {
        this.w = z;
    }
}
