package defpackage;

import android.car.hardware.vcu.CarVcuManager;
import android.content.Context;
import android.util.Log;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.d00;
import defpackage.gy;
import defpackage.my;
import java.util.Map;
/* compiled from: CarVcuController.java */
/* renamed from: oz  reason: default package */
/* loaded from: classes.dex */
public abstract class oz extends dz<CarVcuManager> implements my {
    static {
        a70.i();
    }

    public oz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_vcu";
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        map.put(557847057, d00.a(new my.h0(), c00.a(0, 1022)));
        map.put(557847042, d00.a(new my.m0(), new vy(0, 100)));
        map.put(557847050, d00.a(new my.g()));
        map.put(557847049, d00.a(new my.c()));
        d00.b b = d00.b(new my.g0());
        b.d = true;
        map.put(557847051, b.a());
        map.put(557847084, d00.a(new my.h(), new vy(0, Integer.MAX_VALUE)));
        map.put(559944218, d00.a(new my.t(), new e00() { // from class: yy
            @Override // defpackage.e00
            public final boolean a(Object obj) {
                return c00.a(r1, (Float) obj);
            }
        }));
        d00.b b2 = d00.b(new my.p());
        b2.d = true;
        map.put(559944219, b2.a());
        d00.b b3 = d00.b(new my.s());
        b3.d = true;
        map.put(559944342, b3.a());
        d00.b b4 = d00.b(new my.r());
        b4.d = true;
        map.put(559944343, b4.a());
        d00.b b5 = d00.b(new my.q());
        b5.d = true;
        map.put(559944344, b5.a());
        map.put(557847068, d00.a(new my.f()));
        map.put(557847069, d00.a(new my.k()));
        map.put(557847059, d00.a(new my.m()));
        map.put(557847145, d00.b(new gy.a()).a());
        map.put(557847045, d00.a(new my.k0()));
        map.put(557847195, d00.a(new my.l0()));
        map.put(557847199, d00.a(new my.a0()));
    }

    public float b(float f) {
        try {
            return ((Float) a(my.b.class)).floatValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getAcVolt error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return f;
        }
    }

    public float c(float f) {
        try {
            return this.c.getCltcAvailableDrivingDistanceFloat();
        } catch (Exception e) {
            jg.a(e, jg.a("getCltcRemainingDistanceFloat error: "), "CarVcuController");
            return f;
        }
    }

    public float d(float f) {
        try {
            return ((Float) a(my.v.class)).floatValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getDcCurrent error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return f;
        }
    }

    public float e(float f) {
        try {
            return ((Float) a(my.y.class)).floatValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getDcVolt error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return f;
        }
    }

    public float f(float f) {
        try {
            return this.c.getDynamicAvailableDrivingDistance();
        } catch (Exception e) {
            jg.a(e, jg.a("getDynamicRemainingDistanceFloat error: "), "CarVcuController");
            return f;
        }
    }

    public float g(float f) {
        try {
            float chargeDischargePower = this.c.getChargeDischargePower();
            LogUtils.i("CarVcuController", "getPower = " + chargeDischargePower);
            return chargeDischargePower;
        } catch (Exception e) {
            jg.a(e, jg.a("getPower error:"), "CarVcuController");
            return f;
        }
    }

    public int h(int i) {
        try {
            return this.c.getChargingGunStatus();
        } catch (Exception e) {
            jg.a(e, jg.a("getChargeGunStatus error:"), "CarVcuController");
            return i;
        }
    }

    public int i(int i) {
        try {
            return ((Integer) a(my.k.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getChargeSpeedSlow error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int j(int i) {
        try {
            return this.c.getChargeStatus();
        } catch (Exception e) {
            jg.a(e, jg.a("getChargeStatus error:"), "CarVcuController");
            return i;
        }
    }

    public int k(int i) {
        try {
            return ((Integer) a(my.m.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getChargeStopReason error: ");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int l(int i) {
        try {
            return (int) this.c.getCltcAvailableDrivingDistanceFloat();
        } catch (Exception e) {
            jg.a(e, jg.a("getCltcRemainingDistance error: "), "CarVcuController");
            return i;
        }
    }

    public int m(int i) {
        try {
            return ((Integer) a(my.b0.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getDischargeLimit error: ");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int n(int i) {
        try {
            return this.c.getElectricityPercent();
        } catch (Exception e) {
            jg.a(e, jg.a("getElectricityPercent error:"), "CarVcuController");
            return i;
        }
    }

    public int o(int i) {
        try {
            return this.c.getEnduranceMileageMode();
        } catch (Exception e) {
            jg.a(e, jg.a("getEnduranceMileageMode: "), "CarVcuController");
            return i;
        }
    }

    public int p(int i) {
        try {
            return ((Integer) a(my.h0.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getNedcRemainingDistance error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int q(int i) {
        try {
            return (int) this.c.getWltpAvailableDrivingDistanceFloat();
        } catch (Exception e) {
            jg.a(e, jg.a("getWltpRemainingDistance error: "), "CarVcuController");
            return i;
        }
    }

    public void r(int i) {
        try {
            this.c.setCdcuChargeGunCommand(i);
        } catch (Exception e) {
            jg.a(e, jg.a("setCdcuChargeGunCommand: "), "CarVcuController");
        }
    }

    public boolean s(int i) {
        Log.i("CarVcuController", "设置 放电限值 = " + i);
        try {
            this.c.setDisChargeLimit(i);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setDischargeLimit error: "), "CarVcuController");
            return false;
        }
    }

    public boolean t(int i) {
        try {
            this.c.setEnduranceMileageMode(i);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setEnduranceMileageMode: "), "CarVcuController");
            return false;
        }
    }

    public int b(int i) {
        try {
            return ((Integer) a(my.c.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getBatteryCoolingStatus error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int c(int i) {
        try {
            return this.c.getBatteryKeepTempMode();
        } catch (Exception e) {
            jg.a(e, jg.a("getBatteryKeepTemperatureMode error: "), "CarVcuController");
            return i;
        }
    }

    public int d(int i) {
        try {
            return ((Integer) a(my.f.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getBatteryTooCold error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int e(int i) {
        try {
            return ((Integer) a(my.g.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getBatteryWarmingStatus error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public int f(int i) {
        try {
            return this.c.getCdcuChargeGunStatus();
        } catch (Exception e) {
            jg.a(e, jg.a("getCdcuChargeGunStatus error:"), "CarVcuController");
            return i;
        }
    }

    public float h(float f) {
        try {
            return this.c.getWltpAvailableDrivingDistanceFloat();
        } catch (Exception e) {
            jg.a(e, jg.a("getWltpRemainingDistanceFloat error: "), "CarVcuController");
            return f;
        }
    }

    public int g(int i) {
        try {
            return ((Integer) a(my.h.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getChargeCompleteTime error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return i;
        }
    }

    public boolean b(boolean z) {
        Log.i("CarVcuController", "设置 放电 = " + z);
        try {
            this.c.setDisChargeSw(z ? 1 : 2);
            return true;
        } catch (Exception e) {
            jg.a(e, jg.a("setDischargeSwitch error: "), "CarVcuController");
            return false;
        }
    }

    public float a(float f) {
        try {
            return ((Float) a(my.a.class)).floatValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getAcCurrent error:");
            a.append(e.getMessage());
            LogUtils.e("CarVcuController", a.toString());
            return f;
        }
    }

    public int a(int i) {
        try {
            return this.c.getObcAcVoltageStatus();
        } catch (Exception e) {
            jg.a(e, jg.a("getAcVoltStatus error: "), "CarVcuController");
            return i;
        }
    }
}
