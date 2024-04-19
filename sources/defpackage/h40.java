package defpackage;

import android.util.Log;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: DischargeCompletePresenter.java */
/* renamed from: h40  reason: default package */
/* loaded from: classes.dex */
public class h40 extends i10<i40> {
    public int b = -1;
    public int c = -1;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(i40 i40Var) {
        this.a = i40Var;
        iv.d(this);
    }

    public final void b() {
        int i;
        int i2 = this.c;
        if (i2 == -1 || (i = this.b) == -1) {
            return;
        }
        ((i40) this.a).c(i < i2);
    }

    public void c() {
        x90.a(true);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDischargeLimitChanged(my.b0 b0Var) {
        this.b = ((Integer) b0Var.a).intValue();
        b();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDischargeSocChanged(my.d0 d0Var) {
        StringBuilder a = jg.a("反馈 放电电量 = ");
        a.append(d0Var.toString());
        Log.i("DischargeCompletePresen", a.toString());
        ((i40) this.a).a(((Float) d0Var.a).floatValue());
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        this.c = ((Integer) m0Var.a).intValue();
        b();
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
