package defpackage;

import android.util.Log;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.fa0;
import defpackage.g70;
import defpackage.r70;
import defpackage.y60;
import java.util.HashMap;
import java.util.Objects;
/* compiled from: CarHelper.java */
/* renamed from: x90  reason: default package */
/* loaded from: classes.dex */
public class x90 {
    public static void A() {
        if (g70.a.a.c()) {
            ((oz) s()).r(0);
        } else {
            ((mz) q()).f();
        }
    }

    public static int a(int i) {
        return ((mz) q()).a(i);
    }

    public static int b(int i) {
        return ((oz) s()).m(i);
    }

    public static int c(int i) {
        return ((oz) s()).o(i);
    }

    public static void d(int i) {
        fa0 fa0Var = fa0.b.a;
        fa0Var.a.edit().putInt("electricity_mode", i).apply();
        r70.b.a.a(fa0Var.a.getInt("electricity_mode", 0));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            hashMap.put("\"enable\"", "\"1\"");
            hashMap.put("\"msgtype\"", "\"1\"");
            hashMap2.put("\"RandisDisplayType\"", "\"" + i + "\"");
            hashMap.put("\"randiscontent\"", hashMap2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String replace = hashMap.toString().replace("=", ":");
        Log.d("CarHelper", "sendRandisDisplayType: " + replace);
        ((gz) Objects.requireNonNull(CarApi.e().c.get("xp_icm"))).a(replace);
    }

    public static void e(int i) {
        if (i < y60.a.a || i > y60.a.b || a(-1) == i || !((mz) q()).c(i)) {
            return;
        }
        iv.a("P00001", "B006");
    }

    public static void f(int i) {
        if (i >= 20 && i < p()) {
            if (b(-1) == i || !((oz) s()).s(i)) {
                return;
            }
            iv.a("P00001", "B011");
            return;
        }
        Log.w("CarHelper", "setDischargeLimit() invalid called with: limit = [" + i + "]");
    }

    public static int g() {
        return ((oz) s()).j(15);
    }

    public static int h() {
        if (a70.c()) {
            return -1;
        }
        return ((oz) s()).l(-1);
    }

    public static float i() {
        float d = ((oz) s()).d(-1.0f);
        return d == -1.0f ? ((cz) d()).b(-1) : d;
    }

    public static float j() {
        float e = ((oz) s()).e(-1.0f);
        return e == -1.0f ? ((cz) d()).c(-1) : e;
    }

    public static int k() {
        if (y90.b()) {
            if (a70.i() || a70.j()) {
                return (int) ((oz) s()).f(-1.0f);
            }
            return -1;
        }
        return -1;
    }

    public static int l() {
        return fa0.b.a.c();
    }

    public static jy m() {
        return CarApi.e().c();
    }

    public static int n() {
        return ((oz) s()).p(-1);
    }

    public static int o() {
        if (c(2) == 0) {
            return n();
        }
        if (c(2) == 1) {
            return t();
        }
        if (c(2) == 2) {
            return h();
        }
        return k();
    }

    public static int p() {
        int n = ((oz) s()).n(-1);
        LogUtils.i("CarHelper", "soc = " + n);
        return n;
    }

    public static ly q() {
        return (ly) Objects.requireNonNull(CarApi.e().c.get("xp_tbox"));
    }

    public static int r() {
        return ((iz) m()).c(0);
    }

    public static my s() {
        return CarApi.e().d();
    }

    public static int t() {
        return ((oz) s()).q(-1);
    }

    public static ny u() {
        return (ny) Objects.requireNonNull(CarApi.e().c.get("xp_xpu"));
    }

    public static boolean v() {
        int f = f();
        return f == 2 || f == 1;
    }

    public static boolean w() {
        return g() == 2;
    }

    public static boolean x() {
        return r() == 1;
    }

    public static void y() {
        ((nz) q()).b(f() == 1);
    }

    public static void z() {
        int f = f();
        if (f == 1) {
            ((nz) q()).c(true);
            A();
        } else if (f == 2) {
            ((nz) q()).c(false);
        }
    }

    public static float a() {
        return ((oz) s()).a(-1.0f);
    }

    public static float b() {
        return ((oz) s()).b(-1.0f);
    }

    public static gy c() {
        return (gy) Objects.requireNonNull(CarApi.e().c.get("xp_bcm"));
    }

    public static void g(int i) {
        Log.d("CarHelper", "setEnduranceMileageMode: " + i);
        ((oz) s()).t(i);
    }

    public static void a(int i, int i2, int i3) {
        StringBuilder a = jg.a("setChargeAppointmentTime Flag = ", i, "   hour = ", i2, "   min = ");
        a.append(i3);
        LogUtils.i("CarHelper", a.toString());
        LogUtils.i("CarHelper", "setChargeAppointmentTime");
        ((mz) q()).c(new int[]{i, i2, i3});
    }

    public static void b(int i, int i2, int i3) {
        StringBuilder a = jg.a("setKeepTemperatureAppointTime Flag = ", i, "   hour = ", i2, "   min = ");
        a.append(i3);
        LogUtils.i("CarHelper", a.toString());
        ((mz) q()).a(i, i2, i3);
    }

    public static void h(int i) {
        Log.d("CarHelper", "setKeepTemperature: " + i);
        ((mz) q()).b(i);
    }

    public static void i(int i) {
        if (((iz) m()).e(i)) {
            fa0.b.a.a.edit().putInt("trunk_power_delay_off_time", i).apply();
        }
    }

    public static void b(boolean z) {
        ((iz) m()).f(z ? 1 : 0);
    }

    public static int e() {
        return ((oz) s()).g(-1);
    }

    public static void a(boolean z) {
        ((oz) s()).b(z);
    }

    public static int f() {
        return ((oz) s()).h(0);
    }

    public static float a(float f, float f2) {
        float f3;
        StringBuilder a = jg.a("getPower() getAcVoltStatus:");
        a.append(((oz) s()).a(1));
        Log.i("CarHelper", a.toString());
        if (f() == 1 && ((oz) s()).a(1) == 3) {
            Log.i("CarHelper", "1.732");
            f3 = 1.732f;
        } else {
            f3 = 1.0f;
        }
        return ((f3 * f) * f2) / 1000.0f;
    }

    public static float a(float f) {
        try {
            return ((gz) ((iy) Objects.requireNonNull(CarApi.e().c.get("xp_icm")))).a(-1.0f);
        } catch (Exception e) {
            jg.a(e, jg.a("getDriveTotalMileage error: "), "CarHelper");
            return f;
        }
    }

    public static hy d() {
        return (hy) Objects.requireNonNull(CarApi.e().c.get("xp_bms"));
    }
}
