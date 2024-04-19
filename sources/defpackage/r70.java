package defpackage;

import android.util.Log;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.fa0;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: LocalStateManager.java */
/* renamed from: r70  reason: default package */
/* loaded from: classes.dex */
public class r70 {
    public int a = -1;
    public int b = -1;
    public int c = 0;

    /* compiled from: LocalStateManager.java */
    /* renamed from: r70$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final r70 a = new r70(null);
    }

    public r70() {
    }

    public final int a() {
        return fa0.b.a.a.getInt("current_charge_status", 0);
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        int i = this.c;
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    public boolean d() {
        return this.c == 0;
    }

    public boolean e() {
        int i = this.c;
        return i == 6 || i == 7 || i == 8 || i == 9;
    }

    public final void f() {
        StringBuilder a2 = jg.a("notifyChargeStateChanged mState =");
        a2.append(this.c);
        LogUtils.i("LocalStateManager", a2.toString());
        iv.c(new q70(this.c));
    }

    public void g() {
        if (jl0.c().a((Class<Object>) q70.class) == null) {
            fa0.b.a.a().putInt("current_charge_status", a()).apply();
            Log.i("LocalStateManager", "getSpCurrentChargeStatus when start" + a());
            f();
        }
        iv.d(this);
    }

    public void h() {
        iv.e(this);
    }

    @tl0(priority = 5, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        this.b = ((Integer) jVar.a).intValue();
        a(this.b, this.a);
    }

    @tl0(priority = 5, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeStatusChanged(my.l lVar) {
        this.a = ((Integer) lVar.a).intValue();
        a(this.b, this.a);
    }

    public final void a(int i, int i2) {
        if (i != -1 && i2 != -1) {
            int i3 = 0;
            if (i != 0) {
                if (i != 3 && i != 5) {
                    if (i == 4 && i2 == 0) {
                        i3 = 6;
                    } else {
                        if (i2 != 16) {
                            switch (i2) {
                                case 0:
                                    i3 = 1;
                                    break;
                                case 1:
                                    i3 = 5;
                                    break;
                                case 2:
                                    i3 = 2;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    i3 = 7;
                                    break;
                                case 6:
                                    i3 = 8;
                                    break;
                                case 7:
                                    i3 = 9;
                                    break;
                                default:
                                    switch (i2) {
                                    }
                            }
                        }
                        i3 = 3;
                    }
                }
                i3 = 4;
            }
            if (i3 == this.c) {
                return;
            }
            StringBuilder a2 = jg.a("checkAndSyncState() called with: gun = [", i, "], charge = [", i2, "], localOld = [");
            a2.append(this.c);
            a2.append("], localNew = [");
            a2.append(i3);
            a2.append("]");
            Log.i("LocalStateManager", a2.toString());
            this.c = i3;
            fa0.b.a.a().putInt("previous_charge_status", a()).putInt("current_charge_status", i3).apply();
            f();
            return;
        }
        Log.i("LocalStateManager", "checkAndSyncState() called with invalid gun or charge status, skipping");
    }

    public /* synthetic */ r70(a aVar) {
    }

    public void a(int i) {
        Log.d("LocalStateManager", "updateElectricityMode: " + i);
        iv.c(new ry(i));
    }
}
