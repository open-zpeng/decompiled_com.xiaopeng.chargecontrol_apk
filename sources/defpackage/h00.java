package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
/* compiled from: CarControl.java */
/* renamed from: h00  reason: default package */
/* loaded from: classes.dex */
public final class h00 extends g00 {
    public static final Uri a = Uri.parse("content://com.xiaopeng.carcontrol/quick");
    public static final f00 b = new f00(a, "GET_quick", "PUT_quick");

    public static int a(ContentResolver cr, String name, int def) {
        try {
            return Integer.parseInt(b.a(cr, name));
        } catch (NumberFormatException unused) {
            return def;
        }
    }

    public static boolean b(ContentResolver cr, String name, int value) {
        return b.a(cr, name, Integer.toString(value));
    }

    public static Uri a(String name) {
        return Uri.withAppendedPath(a, name);
    }
}
