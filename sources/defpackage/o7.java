package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
/* compiled from: ContextCompat.java */
/* renamed from: o7  reason: default package */
/* loaded from: classes.dex */
public class o7 {
    public static final Object a = new Object();

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static Drawable b(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return context.getDrawable(i);
    }

    public static int a(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return context.getColor(i);
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
