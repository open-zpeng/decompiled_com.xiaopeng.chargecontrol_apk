package defpackage;

import java.lang.reflect.InvocationTargetException;
/* compiled from: ManifestParser.java */
@Deprecated
/* renamed from: dp  reason: default package */
/* loaded from: classes.dex */
public final class dp {
    public static bp a(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        try {
            try {
                Object newInstance = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof bp) {
                    return (bp) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (IllegalAccessException e) {
                a(cls4, e);
                throw null;
            } catch (InstantiationException e2) {
                a(cls3, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                a(cls2, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                a(cls, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    public static void a(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
