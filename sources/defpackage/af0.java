package defpackage;

import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: VuiRecyclerViewGlobalLayoutListener.java */
/* renamed from: af0  reason: default package */
/* loaded from: classes.dex */
public class af0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public AtomicInteger c = new AtomicInteger(0);
    public qe0 d;

    public af0(qe0 qe0Var) {
        this.d = null;
        this.d = qe0Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.c.get() <= 0 || this.d == null) {
            return;
        }
        this.c.decrementAndGet();
        this.d.c0();
    }
}
