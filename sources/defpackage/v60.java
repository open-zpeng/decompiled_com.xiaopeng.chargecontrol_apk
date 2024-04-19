package defpackage;

import defpackage.gy;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: GunLockStateObservable.java */
/* renamed from: v60  reason: default package */
/* loaded from: classes.dex */
public class v60 extends ah0<Integer> {

    /* compiled from: GunLockStateObservable.java */
    /* renamed from: v60$a */
    /* loaded from: classes.dex */
    public static final class a implements kh0 {
        public volatile boolean c = false;
        public final ch0<? super Integer> d;

        public a(ch0<? super Integer> ch0Var) {
            this.d = ch0Var;
        }

        @Override // defpackage.kh0
        public void a() {
            if (!this.c) {
                iv.e(this);
            }
            this.c = true;
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.c;
        }

        @tl0(sticky = true, threadMode = ThreadMode.MAIN)
        public void onChargeGunLockStatusChanged(gy.a aVar) {
            if (b()) {
                return;
            }
            this.d.onNext(aVar.a);
        }
    }

    @Override // defpackage.ah0
    public void b(ch0<? super Integer> ch0Var) {
        a aVar = new a(ch0Var);
        ch0Var.onSubscribe(aVar);
        iv.d(aVar);
    }
}
