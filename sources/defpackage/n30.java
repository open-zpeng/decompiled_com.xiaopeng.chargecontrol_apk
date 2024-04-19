package defpackage;

import android.util.Log;
import defpackage.g70;
import defpackage.my;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: CheckStatePresenter.java */
/* renamed from: n30  reason: default package */
/* loaded from: classes.dex */
public class n30 extends i10<o30> {
    public jh0 b = new jh0();
    public int c = -1;
    public int d;
    public boolean e;
    public boolean f;

    /* compiled from: CheckStatePresenter.java */
    /* renamed from: n30$b */
    /* loaded from: classes.dex */
    public static class b {
        public static n30 a = new n30(null);
    }

    public n30() {
    }

    public static /* synthetic */ boolean c(Long l) {
        float i;
        int p = x90.p();
        int f = x90.f();
        if (f == 1) {
            i = x90.a();
        } else {
            i = f == 2 ? x90.i() : -1.0f;
        }
        return p >= 90 && i != -1.0f && i < 10.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(o30 o30Var) {
        this.a = o30Var;
        this.d = x90.e();
        if (iv.b(this)) {
            return;
        }
        iv.d(this);
    }

    public /* synthetic */ void b(Long l) {
        int b2;
        if (g70.a.a.c()) {
            b2 = ((oz) x90.s()).f(0);
        } else {
            b2 = ((az) x90.c()).b(0);
        }
        int f = x90.f();
        if (b2 == 1 && f == 1) {
            ((o30) this.a).J();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryCooling(my.c cVar) {
        boolean z = false;
        this.e = ((Integer) cVar.a).intValue() == 1;
        int i = this.d;
        if (this.f || this.e) {
            z = true;
        }
        a(i, z);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryTooCold(my.f fVar) {
        int intValue = ((Integer) fVar.a).intValue();
        if (this.c == 0 && intValue == 1) {
            ((o30) this.a).C();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryWarming(my.g gVar) {
        boolean z = false;
        this.f = ((Integer) gVar.a).intValue() == 1;
        int i = this.d;
        if (this.f || this.e) {
            z = true;
        }
        a(i, z);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeCompleteTimeChanged(my.h hVar) {
        this.d = ((Integer) hVar.a).intValue();
        a(this.d, this.f || this.e);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeSpeedSlow(my.k kVar) {
        int intValue = ((Integer) kVar.a).intValue();
        if (this.c == 2 && intValue == 1) {
            ((o30) this.a).y();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        int intValue = ((Integer) m0Var.a).intValue();
        if (this.c == 0 && intValue == 0) {
            ((o30) this.a).F();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onStateChanged(q70 q70Var) {
        int i = q70Var.a;
        if (i == this.c) {
            return;
        }
        this.c = i;
        this.b.c();
        ((o30) this.a).x();
        if (i != 0) {
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    this.b.c(ah0.a(20L, TimeUnit.SECONDS).a(new th0() { // from class: m30
                        @Override // defpackage.th0
                        public final boolean test(Object obj) {
                            return n30.c((Long) obj);
                        }
                    }).a(hh0.a()).b(new rh0() { // from class: l30
                        @Override // defpackage.rh0
                        public final void accept(Object obj) {
                            n30.this.a((Long) obj);
                        }
                    }));
                    int i2 = this.d;
                    if (!this.f && !this.e) {
                        z = false;
                    }
                    a(i2, z);
                    c(((oz) x90.s()).i(0));
                    return;
                } else if (i == 3) {
                    this.b.c(ah0.a(1L, TimeUnit.SECONDS).a(hh0.a()).b(new rh0() { // from class: k30
                        @Override // defpackage.rh0
                        public final void accept(Object obj) {
                            n30.this.b((Long) obj);
                        }
                    }));
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            int f = x90.f();
            int a2 = x90.a(-1);
            int p = x90.p();
            StringBuilder a3 = jg.a("showChargeLimitLessThanSocIfNeeded limit = ", a2, " ,soc = ", p, " ,gun = ");
            a3.append(f);
            Log.i("CheckStatePresenter", a3.toString());
            if (a2 == -1 || a2 >= p) {
                return;
            }
            if (f == 2 || f == 1) {
                ((o30) this.a).E();
                return;
            }
            return;
        }
        a(((oz) x90.s()).d(0));
        b(x90.p());
    }

    public /* synthetic */ n30(a aVar) {
    }

    public final void c(int i) {
        if (this.c == 2 && i == 1) {
            ((o30) this.a).y();
        }
    }

    @Override // defpackage.i10
    public void a() {
        if (iv.b(this)) {
            iv.e(this);
        }
        this.b.c();
        this.a = null;
    }

    public final void b(int i) {
        if (this.c == 0 && i == 0) {
            ((o30) this.a).F();
        }
    }

    public final void a(int i) {
        if (this.c == 0 && i == 1) {
            ((o30) this.a).C();
        }
    }

    public /* synthetic */ void a(Long l) {
        ((o30) this.a).G();
    }

    public final void a(int i, boolean z) {
        if (this.c != 2) {
            return;
        }
        if ((i >= a70.a || i == -1) && z) {
            ((o30) this.a).H();
        }
    }
}
