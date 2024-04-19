package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: TypefaceCompatApi21Impl.java */
/* renamed from: z7  reason: default package */
/* loaded from: classes.dex */
public class z7 extends d8 {
    public static Class<?> b = null;
    public static Constructor<?> c = null;
    public static Method d = null;
    public static Method e = null;
    public static boolean f = false;

    public static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f) {
            return;
        }
        f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        c = constructor;
        b = cls;
        d = method2;
        e = method;
    }

    @Override // defpackage.d8
    public Typeface a(Context context, r7 r7Var, Resources resources, int i) {
        s7[] s7VarArr;
        a();
        try {
            Object newInstance = c.newInstance(new Object[0]);
            for (s7 s7Var : r7Var.a) {
                File a = a.a(context);
                if (a == null) {
                    return null;
                }
                try {
                    if (!a.a(a, resources, s7Var.f)) {
                        return null;
                    }
                    if (!a(newInstance, a.getPath(), s7Var.b, s7Var.c)) {
                        return null;
                    }
                    a.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    a.delete();
                }
            }
            a();
            try {
                Object newInstance2 = Array.newInstance(b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static boolean a(Object obj, String str, int i, boolean z) {
        a();
        try {
            return ((Boolean) d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
