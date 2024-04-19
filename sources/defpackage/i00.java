package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
/* compiled from: CarControl.java */
/* renamed from: i00  reason: default package */
/* loaded from: classes.dex */
public final class i00 extends g00 {
    public static final Uri a = Uri.parse("content://com.xiaopeng.carcontrol/system");
    public static final f00 b = new f00(a, "GET_system", "PUT_system");

    public static String a(ContentResolver resolver, String name) {
        return b.a(resolver, name);
    }
}
