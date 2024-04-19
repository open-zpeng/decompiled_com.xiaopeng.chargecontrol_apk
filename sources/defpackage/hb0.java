package defpackage;

import android.os.Build;
import android.os.SystemProperties;
/* compiled from: SystemPropertyUtil.java */
/* renamed from: hb0  reason: default package */
/* loaded from: classes.dex */
public class hb0 {
    static {
        StringBuilder a = jg.a("persist.sys.mqtt.comm_url");
        a.append(nb0.a());
        a.toString();
        String str = "persist.sys.mqtt.url" + nb0.a();
        String str2 = "persist.sys.mqtt.user" + nb0.a();
        String str3 = "persist.sys.mqtt.pass" + nb0.a();
        String str4 = "persist.sys.mqtt.id" + nb0.a();
    }

    public static long a() {
        return SystemProperties.getLong("persist.sys.account_uid", -1L);
    }

    public static String b() {
        return SystemProperties.get("sys.xiaopeng.dbc_ver", "");
    }

    public static String c() {
        int i = Build.VERSION.SDK_INT;
        return SystemProperties.get("persist.sys.mcu.hardwareId");
    }

    public static String d() {
        return SystemProperties.get("ro.xiaopeng.software");
    }

    public static int e() {
        return SystemProperties.getInt("persist.sys.vehicle_id", -1);
    }
}
