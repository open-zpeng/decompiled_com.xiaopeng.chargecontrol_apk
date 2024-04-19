package defpackage;

import android.util.Log;
import defpackage.ly;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: MainPresenter.java */
/* renamed from: f60  reason: default package */
/* loaded from: classes.dex */
public class f60 extends i10<g60> {
    public int b;
    public int c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(g60 g60Var) {
        this.a = g60Var;
        iv.d(this);
        float c = ((cz) x90.d()).c(-1);
        Log.i("MainPresenter", "vold = " + c);
    }

    public void b() {
        ((g60) this.a).c(this.b);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        int intValue = ((Integer) jVar.a).intValue();
        boolean z = false;
        boolean z2 = intValue == 1 || intValue == 3 || intValue == 4 || intValue == 5;
        if (intValue == 2 || intValue == 3) {
            z = true;
        }
        ((g60) this.a).c(z2);
        ((g60) this.a).d(z2);
        ((g60) this.a).a(z);
        ((g60) this.a).b(z);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeLimitChanged(ly.c cVar) {
        ((g60) this.a).a(((Integer) cVar.a).intValue());
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onRemainingMileageChanged(uy uyVar) {
        int i = uyVar.a;
        Log.d("ttt", "onRemainingMileageChanged: " + i);
        this.b = i;
        ((g60) this.a).c(i);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        this.c = ((Integer) m0Var.a).intValue();
        ((g60) this.a).b(this.c);
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
