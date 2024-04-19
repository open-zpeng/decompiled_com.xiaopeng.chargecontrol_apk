package defpackage;

import android.util.Log;
import defpackage.my;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: ChargeFaultPresenter.java */
/* renamed from: x20  reason: default package */
/* loaded from: classes.dex */
public class x20 extends i10<y20> {
    public int b;
    public kh0 c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(y20 y20Var) {
        this.a = y20Var;
        this.b = x90.f();
        int i = this.b;
        if (i != 3 && i != 5) {
            ((y20) this.a).I();
        }
        this.c = ah0.a(200L, TimeUnit.MILLISECONDS).a(hh0.a()).b(new rh0() { // from class: v20
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                x20.this.a((Long) obj);
            }
        });
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void handleChargeStopReasonEvent(my.m mVar) {
        StringBuilder a = jg.a("handleChargeStopReasonEvent() called with: event = [");
        a.append(mVar.a);
        a.append("]");
        Log.d("ChargeFaultPresenter", a.toString());
        int intValue = ((Integer) mVar.a).intValue();
        if (intValue == 2 || intValue == 4) {
            ((y20) this.a).z();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        StringBuilder a = jg.a("onChargeGunStatusChanged() called with: event = [");
        a.append(jVar.a);
        a.append("]");
        Log.d("ChargeFaultPresenter", a.toString());
        int intValue = ((Integer) jVar.a).intValue();
        this.b = intValue;
        if (3 == intValue) {
            ((y20) this.a).K();
        } else if (5 == intValue) {
            ((y20) this.a).D();
        }
    }

    public /* synthetic */ void a(Long l) {
        iv.d(this);
    }

    @Override // defpackage.i10
    public void a() {
        this.c.a();
        if (iv.b(this)) {
            iv.e(this);
        }
        this.a = null;
    }
}
