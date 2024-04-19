package defpackage;

import android.car.Car;
import android.os.SystemProperties;
/* compiled from: CarStatusUtils.java */
/* renamed from: y90  reason: default package */
/* loaded from: classes.dex */
public class y90 {
    public static Boolean a;

    public static String a() {
        try {
            return Car.getXpCduType();
        } catch (Exception e) {
            gb0.b("CarVersionUtil", "can not get XpCduType error = " + e);
            return "";
        }
    }

    public static boolean b() {
        if (a == null) {
            String str = "";
            try {
                String str2 = SystemProperties.get("ro.xiaopeng.software", "");
                str = (str2 == null || str2.isEmpty()) ? str2 : str2.substring(7, 9);
            } catch (Exception e) {
                gb0.b("CarVersionUtil", "can not get getRegion error = " + e);
            }
            a = Boolean.valueOf("EU".equals(str));
        }
        return a.booleanValue();
    }
}
