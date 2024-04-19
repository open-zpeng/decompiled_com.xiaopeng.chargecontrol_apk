package defpackage;

import android.view.View;
/* compiled from: AppCompatDelegateImpl.java */
/* renamed from: b1  reason: default package */
/* loaded from: classes.dex */
public class b1 extends ha {
    public final /* synthetic */ w0 a;

    public b1(w0 w0Var) {
        this.a = w0Var;
    }

    @Override // defpackage.ga
    public void b(View view) {
        this.a.q.setAlpha(1.0f);
        this.a.t.a((ga) null);
        this.a.t = null;
    }

    @Override // defpackage.ha, defpackage.ga
    public void c(View view) {
        this.a.q.setVisibility(0);
        this.a.q.sendAccessibilityEvent(32);
        if (this.a.q.getParent() instanceof View) {
            y9.u((View) this.a.q.getParent());
        }
    }
}
