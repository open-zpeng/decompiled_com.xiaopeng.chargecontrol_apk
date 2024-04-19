package defpackage;

import android.app.ActivityThread;
import android.os.SystemProperties;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import defpackage.g70;
/* compiled from: Config.java */
/* renamed from: a70  reason: default package */
/* loaded from: classes.dex */
public class a70 {
    public static final int a;

    static {
        if (!e() && !f()) {
            if (!h() && !d() && !c()) {
                a = 2047;
                return;
            } else {
                a = 2555;
                return;
            }
        }
        a = 2040;
    }

    public static boolean a() {
        return "1".equals(SystemProperties.get("persist.sys.xiaopeng.refrigerator", "0"));
    }

    public static boolean b() {
        return "1".equals(SystemProperties.get("persist.sys.xiaopeng.SPC", "0"));
    }

    public static boolean c() {
        return y90.a().equals(VuiUtils.CAR_PLATFORM_Q2);
    }

    public static boolean d() {
        return y90.a().equals(VuiUtils.CAR_PLATFORM_Q6);
    }

    public static boolean e() {
        return y90.a().equals(VuiUtils.CAR_PLATFORM_Q3);
    }

    public static boolean f() {
        return y90.a().equals("Q3A");
    }

    public static boolean g() {
        return ActivityThread.currentApplication().getResources().getConfiguration().orientation == 1;
    }

    public static boolean h() {
        return y90.a().equals(VuiUtils.CAR_PLATFORM_Q1);
    }

    public static boolean i() {
        return y90.a().equals(VuiUtils.CAR_PLATFORM_Q8);
    }

    public static boolean j() {
        return y90.a().equals(VuiUtils.CAR_PLATFORM_Q7);
    }

    public static boolean k() {
        return ActivityThread.currentApplication().getResources().getConfiguration().orientation != 1;
    }

    public static boolean l() {
        return j() || i() || y90.a().equals("Q9") || y90.a().equals("QB");
    }

    public static boolean m() {
        return g70.a.a.b();
    }
}
