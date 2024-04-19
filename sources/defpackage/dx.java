package defpackage;

import java.lang.reflect.AccessibleObject;
/* compiled from: ReflectionAccessor.java */
/* renamed from: dx  reason: default package */
/* loaded from: classes.dex */
public abstract class dx {
    public static final dx a;

    static {
        a = yv.a < 9 ? new cx() : new ex();
    }

    public abstract void a(AccessibleObject accessibleObject);
}
