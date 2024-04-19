package defpackage;

import android.view.View;
/* compiled from: XDialogViewDelegateImpl.java */
/* renamed from: dg0  reason: default package */
/* loaded from: classes.dex */
public class dg0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ eg0 c;

    public dg0(eg0 eg0Var) {
        this.c = eg0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.c.b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        zf0 zf0Var = this.c.t;
        if (zf0Var != null) {
            zf0Var.a();
        }
    }
}
