package defpackage;

import android.view.View;
/* compiled from: ListPopupWindow.java */
/* renamed from: y3  reason: default package */
/* loaded from: classes.dex */
public class y3 implements Runnable {
    public final /* synthetic */ a4 c;

    public y3(a4 a4Var) {
        this.c = a4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.c.u;
        if (view == null || view.getWindowToken() == null) {
            return;
        }
        this.c.c();
    }
}
