package defpackage;

import android.car.hardware.tbox.CarTboxManager;
import android.content.Context;
import android.util.Log;
import defpackage.d00;
import defpackage.ly;
import java.util.Arrays;
import java.util.Map;
/* compiled from: CarTBoxController.java */
/* renamed from: mz  reason: default package */
/* loaded from: classes.dex */
public abstract class mz extends dz<CarTboxManager> implements ly {
    public mz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_tbox";
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        d00.b b = d00.b(new ly.c());
        b.d = true;
        map.put(557846561, b.a());
    }

    public int[] b(int[] iArr) {
        try {
            return this.c.getChargeAppointTime();
        } catch (Exception e) {
            jg.a(e, jg.a("getChargeAppointTime error:"), "TBoxController");
            return iArr;
        }
    }

    public boolean c(int i) {
        Log.i("TBoxController", "设置 充电限值 = " + i);
        try {
            this.c.setTboxChargeLimitValue(i);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setTBoxChargeLimitValue: "), "TBoxController");
            return false;
        }
    }

    public boolean e() {
        Log.i("TBoxController", "锁充电枪");
        try {
            this.c.setChargeGunLock();
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setChargeGunLock: "), "TBoxController");
            return false;
        }
    }

    public boolean f() {
        Log.i("TBoxController", "解锁充电枪");
        try {
            this.c.setChargeGunUnlock();
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setChargeGunUnlock: "), "TBoxController");
            return false;
        }
    }

    public boolean b(int i) {
        try {
            Log.i("TBoxController", "setBatteryKeepTemperature() request = " + i);
            this.c.setBatteryKeepTempSwitch(i);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setBatteryKeepTemperature error: "), "TBoxController");
            return false;
        }
    }

    public int a(int i) {
        try {
            return this.c.getTboxChargeLimitValue();
        } catch (Exception e) {
            jg.a(e, jg.a("getTBoxChargeLimitValue error: "), "TBoxController");
            return i;
        }
    }

    public boolean c(int[] iArr) {
        StringBuilder a = jg.a("setChargeAppointTime() called with: data = ");
        a.append(Arrays.toString(iArr));
        Log.i("TBoxController", a.toString());
        try {
            this.c.setChargeAppointTime(iArr);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setChargeAppointTime error: "), "TBoxController");
            return false;
        }
    }

    public int[] a(int[] iArr) {
        try {
            return this.c.getBatteryKeepTempAppointTime();
        } catch (Exception e) {
            jg.a(e, jg.a("getBatteryKeepTemperatureAppointTime error: "), "TBoxController");
            return iArr;
        }
    }

    public boolean a(int i, int i2, int i3) {
        StringBuilder a = jg.a("setBatteryKeepTemperatureAppointTime() called with: flag = [", i, "], hour = [", i2, "], min = [");
        a.append(i3);
        a.append("]");
        Log.i("TBoxController", a.toString());
        try {
            this.c.setBatteryKeepTempAppointTime(i, i2, i3);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setBatteryKeepTemperatureAppointTime error: "), "TBoxController");
            return false;
        }
    }
}
