package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: ThemeContextCompat.java */
/* renamed from: p7  reason: default package */
/* loaded from: classes.dex */
public class p7 {
    public static final Object a = new Object();

    public static ColorStateList a(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return context.getColorStateList(i);
    }

    public static Drawable b(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return context.getDrawable(i);
    }
}
