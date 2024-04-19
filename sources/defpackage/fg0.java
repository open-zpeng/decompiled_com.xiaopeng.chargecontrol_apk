package defpackage;

import android.view.ViewTreeObserver;
/* compiled from: XDialogViewDelegateImpl.java */
/* renamed from: fg0  reason: default package */
/* loaded from: classes.dex */
public class fg0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ boolean c;
    public final /* synthetic */ eg0 d;

    public fg0(eg0 eg0Var, boolean z) {
        this.d = eg0Var;
        this.c = z;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.d.i.getViewTreeObserver().removeOnPreDrawListener(this);
        this.d.a(this.c);
        return true;
    }
}
