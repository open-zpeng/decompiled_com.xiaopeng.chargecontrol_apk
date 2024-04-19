package defpackage;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
/* compiled from: XDialogViewDelegate.java */
/* renamed from: cg0  reason: default package */
/* loaded from: classes.dex */
public abstract class cg0 {
    public bg0 a;
    public Context b;

    public cg0(bg0 bg0Var, Context context, int i) {
        this.a = bg0Var;
        this.b = new ContextThemeWrapper(context, i <= 0 ? cd0.XDialogView : i);
    }

    public abstract void a();

    public abstract void a(View view, boolean z);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i, KeyEvent keyEvent);

    public abstract void b(CharSequence charSequence);
}
