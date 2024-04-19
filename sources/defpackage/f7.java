package defpackage;

import android.app.Activity;
import android.os.Build;
/* compiled from: ActivityCompat.java */
/* renamed from: f7  reason: default package */
/* loaded from: classes.dex */
public class f7 extends o7 {

    /* compiled from: ActivityCompat.java */
    /* renamed from: f7$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: f7$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public static void a(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        activity.finishAffinity();
    }

    public static void b(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        activity.recreate();
    }
}
