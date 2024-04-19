package defpackage;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import java.util.List;
import java.util.Map;
/* compiled from: Utils.java */
/* renamed from: zb0  reason: default package */
/* loaded from: classes.dex */
public class zb0 {
    public static Boolean a;
    public static Map<String, Boolean> b = new ArrayMap();

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str2.contains(".")) {
            return false;
        }
        String substring = str2.substring(str2.lastIndexOf("."));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(substring);
        return str2.equals(sb.toString());
    }

    public static boolean a() {
        if (a == null) {
            if (TextUtils.isEmpty(VuiUtils.getXpCduType())) {
                a = false;
            } else {
                a = true;
            }
        }
        return a.booleanValue();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (b.containsKey(str)) {
            return b.get(str).booleanValue();
        }
        List<PackageInfo> installedPackages = Foo.getContext().getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            if (installedPackages.get(i).packageName.equalsIgnoreCase(str)) {
                LogUtils.i("Utils", "system contain " + str);
                b.put(str, true);
                return true;
            }
        }
        LogUtils.i("Utils", "system do not contain " + str);
        b.put(str, false);
        return false;
    }
}
