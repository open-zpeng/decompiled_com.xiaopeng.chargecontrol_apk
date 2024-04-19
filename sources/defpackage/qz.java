package defpackage;

import android.car.hardware.xpu.CarXpuManager;
import android.content.Context;
import defpackage.ny;
import java.util.Map;
/* compiled from: CarXpuController.java */
/* renamed from: qz  reason: default package */
/* loaded from: classes.dex */
public abstract class qz extends dz<CarXpuManager> implements ny {
    public qz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_xpu";
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        if (a70.m()) {
            map.put(557856789, d00.b(new ny.a()).a());
            map.put(557856790, d00.b(new ny.b()).a());
            map.put(557856775, d00.b(new ny.c()).a());
        }
    }

    public void b(int i) {
        try {
            this.c.setScpSwitchStatus(i);
        } catch (Exception e) {
            StringBuilder a = jg.a("setScpSwitchStatus: ");
            a.append(e.getMessage());
            gb0.b("CarBcmController", a.toString());
        }
    }

    public int a(int i) {
        try {
            return this.c.getScpSwitchStatus();
        } catch (Exception e) {
            StringBuilder a = jg.a("getScpSwitchStatus: ");
            a.append(e.getMessage());
            gb0.b("CarBcmController", a.toString());
            return i;
        }
    }
}
