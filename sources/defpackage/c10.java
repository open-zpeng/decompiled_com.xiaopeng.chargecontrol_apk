package defpackage;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.speech.EmergencyTtsEngine;
import defpackage.fa0;
import defpackage.ly;
import defpackage.my;
import defpackage.o80;
import defpackage.p80;
import defpackage.r70;
import defpackage.w90;
import defpackage.y60;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: CorePresenter.java */
/* renamed from: c10  reason: default package */
/* loaded from: classes.dex */
public class c10 {
    public final g80 a;
    public boolean b = false;
    public w10 c = x10.a();

    public c10() {
        iv.d(this);
        r70.b.a.g();
        c90.h().f();
        o80.b.a.o();
        this.a = new g80();
        this.a.start();
    }

    public void a() {
        Log.i("CorePresenter", "releaseResource");
        r70.b.a.h();
        iv.e(this);
        c90.h().g();
        this.a.stop();
    }

    @tl0(sticky = true, threadMode = ThreadMode.ASYNC)
    public void onBatteryOverHeating(my.e eVar) {
        if (((Integer) eVar.a).intValue() == 1) {
            p80 p80Var = p80.b.a;
            long millis = TimeUnit.MINUTES.toMillis(10L);
            EmergencyTtsEngine emergencyTtsEngine = p80Var.e;
            CharSequence text = emergencyTtsEngine.a.getText(R.string.battery_over_heat);
            emergencyTtsEngine.g = SystemClock.uptimeMillis();
            emergencyTtsEngine.h = millis;
            emergencyTtsEngine.i = text;
            emergencyTtsEngine.a(text);
            return;
        }
        p80 p80Var2 = p80.b.a;
        EmergencyTtsEngine emergencyTtsEngine2 = p80Var2.e;
        emergencyTtsEngine2.j = null;
        emergencyTtsEngine2.g = 0L;
        emergencyTtsEngine2.h = 0L;
        emergencyTtsEngine2.i = null;
        emergencyTtsEngine2.b.removeCallbacks(emergencyTtsEngine2.f);
        p80Var2.a.stop();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onCarConnectStateChanged(ey eyVar) {
        if (fa0.b.a.a.getBoolean("launch_first_time", true) && eyVar.a) {
            Log.i("CorePresenter", "Connected to car service and it is first time startup, reset the car configuration.");
            x90.a(3, 0, 0);
            x90.b(3, 7, 0);
            x90.e(y60.a.c);
            x90.f(20);
            if (x90.o() >= 40 && !x90.x()) {
                Log.i("CorePresenter", "默认开启后备箱电源");
                x90.b(true);
            }
            if (!a70.e() && !a70.d()) {
                if (a70.f()) {
                    x90.g(2);
                }
            } else {
                x90.g(0);
            }
            if (y90.b() && (a70.e() || a70.d())) {
                x90.g(1);
            }
            x90.i(0);
            fa0.b.a.a.edit().putBoolean("launch_first_time", false).apply();
        }
    }

    @tl0(priority = 3, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        if (((Integer) jVar.a).intValue() == 0) {
            fa0.b.a.b(false);
            return;
        }
        w90 w90Var = w90.b.a;
        Application currentApplication = ActivityThread.currentApplication();
        l00 l00Var = new Consumer() { // from class: l00
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                iv.a((Intent) obj);
            }
        };
        if (w90Var.b()) {
            return;
        }
        Intent launchIntentForPackage = currentApplication.getPackageManager().getLaunchIntentForPackage(currentApplication.getPackageName());
        if (l00Var != null) {
            l00Var.accept(launchIntentForPackage);
        }
        currentApplication.startActivity(launchIntentForPackage);
        Log.i("ActivityHelper", "startMainActivity: bring activity on top");
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeLimitChanged(ly.c cVar) {
        if (y60.a()) {
            int intValue = ((Integer) cVar.a).intValue();
            int i = y60.a.c;
            if (intValue > i) {
                x90.e(i);
            }
        }
    }

    @tl0(priority = 3, sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeStatusChanged(my.l lVar) {
        if (4 == ((Integer) lVar.a).intValue() && ((az) x90.c()).a(-1) != 0 && 1 == x90.f()) {
            Log.i("CorePresenter", "解锁充电枪");
            x90.A();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onIgStatusChanged(qy qyVar) {
        if (1 == qyVar.a) {
            int i = y60.a.c;
            if (this.c.a() && !x90.v()) {
                Log.i("CorePresenter", "Resetting charge limit value to " + i);
                x90.e(i);
            }
            if (y90.b()) {
                x90.g(1);
            }
        }
    }

    @tl0(priority = 3, sticky = true, threadMode = ThreadMode.MAIN)
    public void onStateChanged(q70 q70Var) {
        int i = q70Var.a;
        boolean z = this.b;
        this.b = i == 2;
        if (i == 2) {
            if (fa0.b.a.f() == 2) {
                return;
            }
            iv.a("P00001", "B005");
            long currentTimeMillis = System.currentTimeMillis();
            fa0.b.a.a.edit().putLong("chargeStartTime", currentTimeMillis).apply();
            int n = x90.n();
            int t = x90.t();
            int h = x90.h();
            int k = x90.k();
            fa0.b.a.a().putInt("startMileage", n).putInt("charging_started_mileage_nedc", n).putInt("charging_started_mileage_wltp", t).putInt("charging_started_mileage_cltc", h).putInt("charging_started_mileage_dyminic", k).apply();
            StringBuilder sb = new StringBuilder();
            sb.append("Start charging, time = [");
            sb.append(currentTimeMillis);
            sb.append("], NEDC = [");
            jg.a(sb, n, "], WLTP = [", t, "], CLTC = [");
            sb.append(h);
            sb.append("] dymanic = [");
            sb.append(k);
            sb.append("]");
            Log.i("CorePresenter", sb.toString());
        } else if (i != 3) {
        } else {
            if (!z) {
                Log.i("CorePresenter", "onChargeComplete: not in charge loop, skipping");
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            fa0.b.a.a.edit().putLong("chargeCompleteTime", currentTimeMillis2).apply();
            fa0.b.a.a.edit().putInt("completeMileage", Math.max(x90.o(), 0)).apply();
            int n2 = x90.n();
            int t2 = x90.t();
            fa0.b.a.a().putInt("completeMileage", n2).putInt("charging_finished_mileage_nedc", n2).putInt("charging_finished_mileage_wltp", t2).putInt("charging_finished_mileage_cltc", x90.h()).putInt("charging_finished_mileage_dyminic", x90.k()).apply();
            Log.i("CorePresenter", "Charging complete, time = [" + currentTimeMillis2 + "], NEDC = [" + n2 + "], WLTP = [" + t2 + "]");
        }
    }
}
