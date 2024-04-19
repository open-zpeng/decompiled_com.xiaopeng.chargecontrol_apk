package defpackage;

import android.car.hardware.mcu.CarMcuManager;
import android.content.Context;
import defpackage.jy;
import java.util.Map;
/* compiled from: CarMcuController.java */
/* renamed from: iz  reason: default package */
/* loaded from: classes.dex */
public abstract class iz extends dz<CarMcuManager> implements jy {
    public iz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_mcu";
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        map.put(557847561, d00.a(new jy.b()));
    }

    public int b(int i) {
        try {
            return ((Integer) a(jy.d.class)).intValue();
        } catch (Exception e) {
            StringBuilder a = jg.a("getTrunkPowerOffDelay: ");
            a.append(e.getMessage());
            gb0.b("CarMcuController", a.toString());
            return i;
        }
    }

    public int c(int i) {
        try {
            int trunkPowerStatus = this.c.getTrunkPowerStatus();
            gb0.c("CarMcuController", "getTrunkPowerStatus: " + trunkPowerStatus);
            return trunkPowerStatus;
        } catch (Exception e) {
            StringBuilder a = jg.a("getTrunkPowerStatus: ");
            a.append(e.getMessage());
            gb0.b("CarMcuController", a.toString());
            return i;
        }
    }

    public boolean d(int i) {
        gb0.b("CarMcuController", "sendChargeCompleteTimeToMcu min: " + i);
        try {
            this.c.sendChargeCompleteTimeToMcu(i);
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("sendChargeCompleteTimeToMcu error: ");
            a.append(e.getMessage());
            gb0.b("CarMcuController", a.toString());
            return false;
        }
    }

    public boolean e(int i) {
        gb0.c("CarMcuController", "setTrunkPowerOffDelay() called with: delay = [" + i + "]");
        try {
            this.c.setTrunkPowerOffDelay(i);
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("setTrunkPowerOffDelay: ");
            a.append(e.getMessage());
            gb0.b("CarMcuController", a.toString());
            return false;
        }
    }

    public boolean f(int i) {
        gb0.c("CarMcuController", "setTrunkPowerSwitch() called with: state = [" + i + "]");
        try {
            this.c.setTrunkPowerSw(i);
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("setTrunkPowerSwitch: ");
            a.append(e.getMessage());
            gb0.b("CarMcuController", a.toString());
            return false;
        }
    }

    public int a(int i) {
        try {
            return ((Integer) a(jy.b.class)).intValue();
        } catch (oy unused) {
            return i;
        }
    }
}
