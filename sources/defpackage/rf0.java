package defpackage;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RadioGroup;
/* compiled from: XRadioGroup.java */
/* renamed from: rf0  reason: default package */
/* loaded from: classes.dex */
public class rf0 extends RadioGroup implements re0 {
    public fe0 c;

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.c;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.c;
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
