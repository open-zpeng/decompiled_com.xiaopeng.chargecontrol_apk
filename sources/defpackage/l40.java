package defpackage;

import android.util.Log;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: DischargingPresenter.java */
/* renamed from: l40  reason: default package */
/* loaded from: classes.dex */
public class l40 extends i10<m40> {
    public int b;
    public float c;
    public float d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(m40 m40Var) {
        this.a = m40Var;
        this.b = x90.f();
        iv.d(this);
    }

    public void b() {
        x90.a(false);
    }

    @tl0(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        this.b = ((Integer) jVar.a).intValue();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDischargeSocChanged(my.d0 d0Var) {
        StringBuilder a = jg.a("反馈 放电电量 = ");
        a.append(d0Var.toString());
        Log.i("DischargingPresenter", a.toString());
        ((m40) this.a).a(((Float) d0Var.a).floatValue());
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSlowCurrentChanged(my.a aVar) {
        this.c = ((Float) aVar.a).floatValue();
        if (this.b == 4) {
            float f = this.c;
            float f2 = this.d;
            ((m40) this.a).a(f, f2, x90.a(f, f2));
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSlowVoltChanged(my.b bVar) {
        this.d = ((Float) bVar.a).floatValue();
        if (this.b == 4) {
            float f = this.c;
            float f2 = this.d;
            ((m40) this.a).a(f, f2, x90.a(f, f2));
        }
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
