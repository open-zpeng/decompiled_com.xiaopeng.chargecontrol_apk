package defpackage;

import android.car.hardware.icm.CarIcmManager;
import android.content.Context;
import defpackage.iy;
import java.util.Map;
/* compiled from: CarIcmController.java */
/* renamed from: gz  reason: default package */
/* loaded from: classes.dex */
public abstract class gz extends dz<CarIcmManager> implements iy {
    public gz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public final String a() {
        return "xp_icm";
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        map.put(557848078, d00.a(new iy.a()));
    }

    public float a(float f) {
        try {
            return this.c.getDriveTotalMileage();
        } catch (Exception e) {
            jg.a(e, jg.a("getDriveTotalMileage error:"), "CarIcmController");
            return f;
        }
    }

    public void a(String str) {
        try {
            this.c.sendRandisDisplayType(str);
        } catch (Exception e) {
            jg.a(e, jg.a("sendRandisDisplayType error:"), "CarIcmController");
        }
    }
}
