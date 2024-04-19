package defpackage;

import java.lang.reflect.Modifier;
/* compiled from: UnsafeAllocator.java */
/* renamed from: iw  reason: default package */
/* loaded from: classes.dex */
public abstract class iw {
    public static void b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                StringBuilder a = jg.a("Abstract class can't be instantiated! Class name: ");
                a.append(cls.getName());
                throw new UnsupportedOperationException(a.toString());
            }
            return;
        }
        StringBuilder a2 = jg.a("Interface can't be instantiated! Interface name: ");
        a2.append(cls.getName());
        throw new UnsupportedOperationException(a2.toString());
    }

    public abstract <T> T a(Class<T> cls);
}
