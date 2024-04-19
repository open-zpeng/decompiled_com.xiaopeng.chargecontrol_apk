package defpackage;

import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: DischargePreparePresenter.java */
/* renamed from: r40  reason: default package */
/* loaded from: classes.dex */
public class r40 extends i10<s40> {
    public int b = -1;
    public int c = -1;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(s40 s40Var) {
        this.a = s40Var;
        iv.d(this);
    }

    public boolean b() {
        return this.c <= 20;
    }

    public final void c() {
        int i;
        int i2 = this.c;
        if (i2 == -1 || (i = this.b) == -1) {
            return;
        }
        ((s40) this.a).c(i < i2);
    }

    public void d() {
        x90.a(true);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDischargeLimitChanged(my.b0 b0Var) {
        this.b = ((Integer) b0Var.a).intValue();
        c();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        this.c = ((Integer) m0Var.a).intValue();
        c();
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
