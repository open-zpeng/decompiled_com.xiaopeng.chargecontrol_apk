package defpackage;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* compiled from: UnsafeReflectionAccessor.java */
/* renamed from: ex  reason: default package */
/* loaded from: classes.dex */
public final class ex extends dx {
    public static Class d;
    public final Object b;
    public final Field c;

    public ex() {
        Object obj;
        Field field = null;
        try {
            d = Class.forName("sun.misc.Unsafe");
            Field declaredField = d.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.b = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.c = field;
    }

    @Override // defpackage.dx
    public void a(AccessibleObject accessibleObject) {
        boolean z = false;
        if (this.b != null && this.c != null) {
            try {
                d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.b, accessibleObject, Long.valueOf(((Long) d.getMethod("objectFieldOffset", Field.class).invoke(this.b, this.c)).longValue()), true);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (z) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new su("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }
}
