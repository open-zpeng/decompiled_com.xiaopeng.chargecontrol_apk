package defpackage;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import java.util.List;
/* compiled from: VuiViewScene.java */
/* renamed from: se0  reason: default package */
/* loaded from: classes.dex */
public abstract class se0 implements pe0, jc0 {
    public View g;
    public jc0 i;
    public ic0 c = null;
    public String d = "";
    public hc0 e = null;
    public List<Integer> f = null;
    public Handler h = new Handler();
    public View.OnAttachStateChangeListener j = new a();
    public gc0 k = new gc0() { // from class: oe0
        @Override // defpackage.gc0
        public final void a(View view, qc0 qc0Var) {
            se0.this.a(view, qc0Var);
        }
    };
    public boolean l = false;

    /* compiled from: VuiViewScene.java */
    /* renamed from: se0$a */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (z90.b) {
                se0 se0Var = se0.this;
                ic0 ic0Var = se0Var.c;
                String str = se0Var.d;
                View view2 = se0Var.g;
                if (ic0Var == null || str == null || view2 == null) {
                    return;
                }
                se0Var.a("createVuiScene");
                try {
                    if (se0Var.l) {
                        ic0Var.addVuiSceneListener(str, view2, se0Var, se0Var.k);
                    } else {
                        ic0Var.addVuiSceneListener(str, view2, se0Var);
                    }
                } catch (AbstractMethodError unused) {
                    ic0Var.addVuiSceneListener(str, view2, se0Var);
                }
                ic0Var.enterScene(str, String.valueOf(((bg0) se0Var).c()));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (z90.b) {
                se0 se0Var = se0.this;
                if (se0Var.c != null && se0Var.d != null) {
                    se0Var.a("destroyVuiScene");
                    se0Var.c.exitScene(se0Var.d, String.valueOf(((bg0) se0Var).c()), se0Var);
                    se0Var.c.removeVuiSceneListener(se0Var.d, se0Var);
                    se0Var.c = null;
                }
                if (se0Var.e != null) {
                    se0Var.e = null;
                }
                if (se0Var.i != null) {
                    se0Var.i = null;
                }
            }
        }
    }

    public /* synthetic */ void a() {
        ic0 ic0Var = this.c;
        String str = this.d;
        View view = this.g;
        if (ic0Var == null || str == null || view == null) {
            return;
        }
        bg0 bg0Var = (bg0) this;
        int c = bg0Var.c();
        a("onBuildScene:" + c);
        bg0Var.m.a();
        ic0Var.buildScene(str, view, this.f, this.e, String.valueOf(c), this);
    }

    @Override // defpackage.jc0
    public boolean b(View view, tc0 tc0Var) {
        a("onInterceptVuiEvent");
        if (view == null) {
            return false;
        }
        hc0 hc0Var = this.e;
        if (hc0Var != null) {
            return hc0Var.a(view, tc0Var);
        }
        z90.a(view, 0);
        return false;
    }

    @Override // defpackage.jc0
    public void c(View view, tc0 tc0Var) {
        a("VuiViewScene onVuiEvent");
        if (view == null) {
            return;
        }
        hc0 hc0Var = this.e;
        if (hc0Var != null) {
            hc0Var.a(view, tc0Var);
        } else {
            z90.a(view, 0);
        }
    }

    @Override // defpackage.jc0
    public void onBuildScene() {
        this.h.post(new Runnable() { // from class: ne0
            @Override // java.lang.Runnable
            public final void run() {
                se0.this.a();
            }
        });
    }

    @Override // defpackage.jc0
    public void s() {
        jc0 jc0Var = this.i;
        if (jc0Var != null) {
            jc0Var.s();
        }
    }

    public final void a(String str) {
        StringBuilder a2 = jg.a(" mSceneId ");
        a2.append(this.d);
        a2.append("  ");
        a2.append(str);
        a2.append(" hashcode ");
        a2.append(hashCode());
        a2.append(" name ");
        a2.append(getClass().getSimpleName());
        be0.a("VuiViewScene", a2.toString());
    }

    public /* synthetic */ void a(View view, qc0 qc0Var) {
        ic0 ic0Var = this.c;
        String str = this.d;
        if (ic0Var == null || TextUtils.isEmpty(str) || view == null) {
            return;
        }
        if (qc0.UPDATE_VIEW.equals(qc0Var)) {
            ic0Var.updateScene(str, view);
        } else {
            ic0Var.updateElementAttribute(str, view);
        }
    }
}
