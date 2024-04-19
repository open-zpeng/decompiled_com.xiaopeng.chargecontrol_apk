package defpackage;

import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: BuildInfoUtils.java */
/* renamed from: nb0  reason: default package */
/* loaded from: classes.dex */
public class nb0 {
    public static String a;

    public static String a() {
        int indexOf;
        String b = b();
        return (!TextUtils.isEmpty(b) && (indexOf = b.indexOf("_")) > 1) ? b.substring(indexOf - 1, indexOf) : "4";
    }

    public static String b() {
        String str = a;
        if (str != null) {
            return str;
        }
        a = a("ro.xiaopeng.software");
        if ("unknown".equals(a)) {
            a = a("ro.build.display.id");
        }
        return a;
    }

    public static String a(String str) {
        return SystemProperties.get(str, "unknown");
    }
}
