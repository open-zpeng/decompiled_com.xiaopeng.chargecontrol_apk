package defpackage;

import android.net.Uri;
import com.xiaopeng.speech.vui.utils.LogUtils;
/* compiled from: outline */
/* renamed from: jg  reason: default package */
/* loaded from: classes.dex */
public class jg {
    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String a(String str, int i) {
        return str + i;
    }

    public static String a(String str, Uri uri) {
        return str + uri;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static String a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String a(nf nfVar, StringBuilder sb) {
        sb.append(nfVar.E());
        return sb.toString();
    }

    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder a(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void a(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        LogUtils.e(str, sb.toString());
    }

    public static void a(StringBuilder sb, int i, String str, int i2, String str2) {
        sb.append(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
    }

    public static void a(StringBuilder sb, String str, char c, String str2) {
        sb.append(str);
        sb.append(c);
        sb.append(str2);
    }

    public static String b(String str, String str2, String str3) {
        return str + str2 + str3;
    }
}
