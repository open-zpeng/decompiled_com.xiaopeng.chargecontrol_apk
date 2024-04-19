package defpackage;

import androidx.fragment.app.Fragment;
/* compiled from: FragmentFactory.java */
/* renamed from: kc  reason: default package */
/* loaded from: classes.dex */
public class kc {
    public static final f5<ClassLoader, f5<String, Class<?>>> a = new f5<>();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<?> c(ClassLoader classLoader, String str) {
        f5<String, Class<?>> orDefault = a.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new f5<>();
            a.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 == null) {
            Class<?> cls = Class.forName(str, false, classLoader);
            orDefault.put(str, cls);
            return cls;
        }
        return orDefault2;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.f(jg.b("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.f(jg.b("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }
}
