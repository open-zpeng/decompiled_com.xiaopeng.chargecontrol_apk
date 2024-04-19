package defpackage;

import android.net.Uri;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* compiled from: Pages.java */
/* renamed from: h10  reason: default package */
/* loaded from: classes.dex */
public class h10 {
    public static final Uri a = a("main", "main");
    public static final Uri b;
    public static final Uri c;

    static {
        a("main", "consumption");
        a("main", "charge_chart");
        a("main", "discharge_chart");
        a("main", "charge_limit");
        a("main", "introduction_keep_temp");
        a("main", "introduction_mileage_mode");
        a("sys", "solar_roof");
        a("sys", "trunk_power");
        b = a("main").appendQueryParameter("action", "close").build();
        c = b.buildUpon().appendQueryParameter(VuiConstants.ELEMENT_TYPE, "force").build();
    }

    public static Uri a(String str, String str2) {
        return a(str).appendQueryParameter("page", str2).build();
    }

    public static Uri.Builder a(String str) {
        return new Uri.Builder().scheme("xiaopeng").authority("powercenter").appendPath(str);
    }
}
