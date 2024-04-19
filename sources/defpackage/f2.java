package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import defpackage.g2;
/* compiled from: MenuPopupHelper.java */
/* renamed from: f2  reason: default package */
/* loaded from: classes.dex */
public class f2 implements b2 {
    public final Context a;
    public final z1 b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public boolean h;
    public g2.a i;
    public e2 j;
    public PopupWindow.OnDismissListener k;
    public int g = 8388611;
    public final PopupWindow.OnDismissListener l = new a();

    /* compiled from: MenuPopupHelper.java */
    /* renamed from: f2$a */
    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            f2.this.c();
        }
    }

    public f2(Context context, z1 z1Var, View view, boolean z, int i, int i2) {
        this.a = context;
        this.b = z1Var;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public e2 a() {
        e2 k2Var;
        if (this.j == null) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            int i = Build.VERSION.SDK_INT;
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(c0.abc_cascading_menus_min_smallest_width)) {
                k2Var = new w1(this.a, this.f, this.d, this.e, this.c);
            } else {
                k2Var = new k2(this.a, this.b, this.f, this.d, this.e, this.c);
            }
            k2Var.a(this.b);
            k2Var.a(this.l);
            k2Var.a(this.f);
            k2Var.a(this.i);
            k2Var.b(this.h);
            k2Var.a(this.g);
            this.j = k2Var;
        }
        return this.j;
    }

    public boolean b() {
        e2 e2Var = this.j;
        return e2Var != null && e2Var.b();
    }

    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean d() {
        if (b()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public final void a(int i, int i2, boolean z, boolean z2) {
        e2 a2 = a();
        a2.c(z2);
        if (z) {
            if ((defpackage.a.a(this.g, y9.h(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            a2.b(i);
            a2.c(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.c = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        a2.c();
    }

    public void a(g2.a aVar) {
        this.i = aVar;
        e2 e2Var = this.j;
        if (e2Var != null) {
            e2Var.a(aVar);
        }
    }
}
