package defpackage;

import android.car.hardware.spc.CarSpcManager;
import android.content.Context;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.ky;
/* compiled from: CarSpcController.java */
/* renamed from: kz  reason: default package */
/* loaded from: classes.dex */
public abstract class kz extends dz<CarSpcManager> implements ky {
    public kz(Context context) {
        super(context);
    }

    public int a(int i) {
        try {
            return ((Integer) a(ky.c.class)).intValue();
        } catch (oy e) {
            StringBuilder a = jg.a("getSolarWorkState error: ");
            a.append(e.getMessage());
            LogUtils.e("CarSpcController", a.toString());
            return i;
        }
    }

    @Override // defpackage.dz
    public String a() {
        return "xp_spc";
    }
}
