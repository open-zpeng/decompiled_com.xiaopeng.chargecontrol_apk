package defpackage;

import com.xiaopeng.xui.widget.XTabLayout;
/* compiled from: XTabLayout.java */
/* renamed from: tf0  reason: default package */
/* loaded from: classes.dex */
public class tf0 implements Runnable {
    public final /* synthetic */ boolean c;
    public final /* synthetic */ uf0 d;

    /* compiled from: XTabLayout.java */
    /* renamed from: tf0$a */
    /* loaded from: classes.dex */
    public class a implements XTabLayout.g {
        public a() {
        }

        @Override // com.xiaopeng.xui.widget.XTabLayout.g
        public void onEnd() {
            tf0 tf0Var = tf0.this;
            XTabLayout xTabLayout = tf0Var.d.c;
            XTabLayout.h hVar = xTabLayout.S;
            if (hVar != null) {
                int i = xTabLayout.K;
                boolean z = tf0Var.c;
                ((m60) hVar).a.a(i, false);
            }
        }

        @Override // com.xiaopeng.xui.widget.XTabLayout.g
        public void onStart() {
            tf0 tf0Var = tf0.this;
            XTabLayout xTabLayout = tf0Var.d.c;
            XTabLayout.h hVar = xTabLayout.S;
            if (hVar != null) {
                ((XTabLayout.i) hVar).b(xTabLayout, xTabLayout.K, tf0Var.c, false);
            }
        }
    }

    public tf0(uf0 uf0Var, boolean z) {
        this.d = uf0Var;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.c.a(true, (XTabLayout.g) new a());
    }
}
