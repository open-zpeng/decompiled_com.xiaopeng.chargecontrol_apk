package defpackage;

import android.content.res.Configuration;
import android.view.View;
/* compiled from: XViewPager.java */
/* renamed from: wf0  reason: default package */
/* loaded from: classes.dex */
public class wf0 extends ig implements re0 {
    public fe0 d0;

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // defpackage.ig, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.d0;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.d0;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // defpackage.ig, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.d0;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        a(this, qc0.UPDATE_VIEW);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        a(this, qc0.UPDATE_VIEW);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }
}
