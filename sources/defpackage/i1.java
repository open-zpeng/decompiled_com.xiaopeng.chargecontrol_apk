package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: i1  reason: default package */
/* loaded from: classes.dex */
public final class i1 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final WeakHashMap<Context, SparseArray<Object>> b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    public static ColorStateList a(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return context.getColorStateList(i);
    }

    public static Drawable b(Context context, int i) {
        return d4.a().b(context, i);
    }
}
