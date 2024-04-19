package defpackage;

import android.content.Context;
import android.util.Log;
/* compiled from: CarBmsControllerCompat.java */
/* renamed from: cz  reason: default package */
/* loaded from: classes.dex */
public class cz extends dz implements hy {
    public cz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_bms";
    }

    @Override // defpackage.hy
    public boolean a(boolean z) {
        try {
            return this.c.getBatteryChargeStatus() == 2;
        } catch (Exception e) {
            StringBuilder a = jg.a("isFullCharged error:");
            a.append(e.getMessage());
            Log.e("CarBmsController", a.toString());
            return z;
        }
    }

    public float b(int i) {
        try {
            return this.c.getDcCurrent();
        } catch (Exception e) {
            jg.a(e, jg.a("getDcCurrent error:"), "CarBmsController");
            return i;
        }
    }

    public float c(int i) {
        try {
            return this.c.getDcVolt();
        } catch (Exception e) {
            jg.a(e, jg.a("getDcVolt error:"), "CarBmsController");
            return i;
        }
    }

    public int a(int i) {
        try {
            return this.c.getBatteryType();
        } catch (Exception e) {
            jg.a(e, jg.a("getBatteryType error:"), "CarBmsController");
            return i;
        }
    }
}
