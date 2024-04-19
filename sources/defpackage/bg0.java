package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import defpackage.eg0;
/* compiled from: XDialogView.java */
/* renamed from: bg0  reason: default package */
/* loaded from: classes.dex */
public class bg0 extends se0 {
    public cg0 m;
    public gg0 n;

    public bg0(Context context, int i) {
        this.m = new eg0(this, context, i);
        eg0.b bVar = ((eg0) this.m).c;
        a("initVui");
        if (z90.b) {
            View view = this.g;
            if (view != null) {
                view.removeOnAttachStateChangeListener(this.j);
            }
            this.g = bVar;
            bVar.addOnAttachStateChangeListener(this.j);
        }
    }

    public ViewGroup b() {
        return ((eg0) this.m).c;
    }

    public int c() {
        gg0 gg0Var = this.n;
        if (gg0Var == null) {
            return 0;
        }
        return ((kd0) gg0Var).a.c();
    }
}
