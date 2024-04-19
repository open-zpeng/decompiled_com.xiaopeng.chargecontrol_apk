package defpackage;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: ov  reason: default package */
/* loaded from: classes.dex */
public class ov<T> implements cw<T> {
    public final iw a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ Type c;

    public ov(pv pvVar, Class cls, Type type) {
        iw hwVar;
        this.b = cls;
        this.c = type;
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            hwVar = new ew(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    hwVar = new fw(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    hwVar = new gw(declaredMethod3);
                }
            } catch (Exception unused3) {
                hwVar = new hw();
            }
        }
        this.a = hwVar;
    }

    @Override // defpackage.cw
    public T a() {
        try {
            return (T) this.a.a(this.b);
        } catch (Exception e) {
            StringBuilder a = jg.a("Unable to invoke no-args constructor for ");
            a.append(this.c);
            a.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(a.toString(), e);
        }
    }
}
