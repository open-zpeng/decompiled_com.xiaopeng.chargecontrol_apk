package defpackage;

import defpackage.r70;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: BottomPresenter.java */
/* renamed from: b60  reason: default package */
/* loaded from: classes.dex */
public class b60 extends i10<c60> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(c60 c60Var) {
        this.a = c60Var;
        iv.d(this);
        if (!a70.e() && !a70.f()) {
            boolean a = a70.a();
            ((c60) this.a).g(a);
            ((c60) this.a).h(!a);
            return;
        }
        ((c60) this.a).g(false);
        ((c60) this.a).h(false);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLocalChargeStatusChanged(q70 q70Var) {
        if (r70.b.a.e()) {
            ((c60) this.a).A();
        } else {
            ((c60) this.a).B();
        }
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
