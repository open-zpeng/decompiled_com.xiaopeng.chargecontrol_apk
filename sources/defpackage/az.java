package defpackage;

import android.car.hardware.bcm.CarBcmManager;
import android.content.Context;
import defpackage.d00;
import defpackage.gy;
import java.util.Map;
/* compiled from: CarBcmController.java */
/* renamed from: az  reason: default package */
/* loaded from: classes.dex */
public abstract class az extends dz<CarBcmManager> implements gy {
    public az(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_bcm";
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        if (a70.i() || !a70.m()) {
            d00.b b = d00.b(new gy.a());
            b.d = false;
            map.put(557849677, b.a());
        }
    }

    public boolean b(boolean z) {
        try {
            this.c.setChargePortUnlock(z ? 1 : 2, 1);
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("openChargePort: ");
            a.append(e.getMessage());
            gb0.b("CarBcmController", a.toString());
            return false;
        }
    }

    public int b(int i) {
        try {
            return this.c.getChargeGunLockSt();
        } catch (Exception unused) {
            return i;
        }
    }

    public int a(int i) {
        try {
            return this.c.getAtwsState();
        } catch (Exception e) {
            StringBuilder a = jg.a("getAtwsState: ");
            a.append(e.getMessage());
            gb0.b("CarBcmController", a.toString());
            return i;
        }
    }
}
