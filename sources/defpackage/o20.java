package defpackage;

import android.util.Log;
import defpackage.g70;
import defpackage.my;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: ChargingPresenter.java */
/* renamed from: o20  reason: default package */
/* loaded from: classes.dex */
public class o20 extends i10<p20> {
    public kh0 b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(p20 p20Var) {
        this.a = p20Var;
        iv.d(this);
        this.b = ah0.a(1L, TimeUnit.SECONDS).b(new sh0() { // from class: l20
            @Override // defpackage.sh0
            public final Object apply(Object obj) {
                Long l = (Long) obj;
                return new v60();
            }
        }).a(hh0.a()).b(new rh0() { // from class: k20
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                o20.this.a((Integer) obj);
            }
        });
    }

    public void b() {
        x90.z();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeCompleteTimeChanged(my.h hVar) {
        int round = Math.round(((Integer) hVar.a).intValue());
        if (round >= a70.a) {
            round = -1;
        }
        ((p20) this.a).b(round);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        StringBuilder a = jg.a("反馈 充电枪状态 = ");
        a.append(jVar.toString());
        Log.i("ChargingTopPresenter", a.toString());
        ((p20) this.a).e(((Integer) jVar.a).intValue());
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onObcFaultPhashLossChanged(my.i0 i0Var) {
        if (a70.c()) {
            return;
        }
        ((p20) this.a).d(((Integer) i0Var.a).intValue() == 1);
    }

    public /* synthetic */ void a(Integer num) {
        boolean z = true;
        ((p20) this.a).f((num.intValue() == 0 && x90.f() == 1) ? false : false);
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.b.a();
        this.a = null;
    }

    public void a(boolean z) {
        if (z) {
            x90.A();
        } else if (g70.a.a.c()) {
            ((oz) x90.s()).r(1);
        } else {
            ((mz) x90.q()).e();
        }
    }
}
