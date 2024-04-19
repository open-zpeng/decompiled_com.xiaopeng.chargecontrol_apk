package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.ViewConfiguration;
/* compiled from: ViewConfigurationCompat.java */
/* renamed from: ea  reason: default package */
/* loaded from: classes.dex */
public final class ea {
    static {
        int i = Build.VERSION.SDK_INT;
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        int i = Build.VERSION.SDK_INT;
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static boolean b(ViewConfiguration viewConfiguration, Context context) {
        int i = Build.VERSION.SDK_INT;
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
