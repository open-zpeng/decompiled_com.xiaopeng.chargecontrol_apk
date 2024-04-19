package defpackage;

import android.view.View;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: AppCompatDelegateImpl.java */
/* renamed from: a1  reason: default package */
/* loaded from: classes.dex */
public class a1 implements Runnable {
    public final /* synthetic */ w0 c;

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a1$a */
    /* loaded from: classes.dex */
    public class a extends ha {
        public a() {
        }

        @Override // defpackage.ga
        public void b(View view) {
            a1.this.c.q.setAlpha(1.0f);
            a1.this.c.t.a((ga) null);
            a1.this.c.t = null;
        }

        @Override // defpackage.ha, defpackage.ga
        public void c(View view) {
            a1.this.c.q.setVisibility(0);
        }
    }

    public a1(w0 w0Var) {
        this.c = w0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        w0 w0Var = this.c;
        w0Var.r.showAtLocation(w0Var.q, 55, 0, 0);
        this.c.f();
        if (this.c.l()) {
            this.c.q.setAlpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            w0 w0Var2 = this.c;
            fa a2 = y9.a(w0Var2.q);
            a2.a(1.0f);
            w0Var2.t = a2;
            this.c.t.a(new a());
            return;
        }
        this.c.q.setAlpha(1.0f);
        this.c.q.setVisibility(0);
    }
}
