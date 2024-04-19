package defpackage;

import java.util.HashMap;
/* compiled from: LogUtils.java */
/* renamed from: vx  reason: default package */
/* loaded from: classes.dex */
public class vx {
    public static HashMap<String, Integer> a = new HashMap<>();

    public static boolean a(int i) {
        return 4 <= i;
    }

    public static boolean a(String str, int i) {
        Integer num = a.get(str);
        return num == null || i >= num.intValue();
    }

    public static String b(String str) {
        return str == null ? "" : str.length() > 64 ? str.substring(0, 64) : str;
    }

    public static void a(String str, String str2) {
        a(str, 3);
    }

    public static String a(String str) {
        return str + "--" + Thread.currentThread();
    }
}
