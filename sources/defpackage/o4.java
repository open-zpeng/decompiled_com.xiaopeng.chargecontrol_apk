package defpackage;

import android.view.View;
import android.view.Window;
/* compiled from: ToolbarWidgetWrapper.java */
/* renamed from: o4  reason: default package */
/* loaded from: classes.dex */
public class o4 implements View.OnClickListener {
    public final t1 c;
    public final /* synthetic */ p4 d;

    public o4(p4 p4Var) {
        this.d = p4Var;
        this.c = new t1(this.d.a.getContext(), 0, 16908332, 0, this.d.i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p4 p4Var = this.d;
        Window.Callback callback = p4Var.l;
        if (callback == null || !p4Var.m) {
            return;
        }
        callback.onMenuItemSelected(0, this.c);
    }
}
