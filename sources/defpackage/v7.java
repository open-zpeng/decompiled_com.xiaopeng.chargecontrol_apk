package defpackage;

import android.content.res.Resources;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ResourcesCompat.java */
/* renamed from: v7  reason: default package */
/* loaded from: classes.dex */
public class v7 {
    public static final Object a = new Object();
    public static Method b;
    public static boolean c;

    public static void a(Resources.Theme theme) {
        synchronized (a) {
            if (!c) {
                try {
                    b = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                    b.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                }
                c = true;
            }
            if (b != null) {
                try {
                    b.invoke(theme, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                    b = null;
                }
            }
        }
    }
}
