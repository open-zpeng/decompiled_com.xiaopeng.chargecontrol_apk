package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: qv  reason: default package */
/* loaded from: classes.dex */
public class qv<T> implements cw<T> {
    public final /* synthetic */ Constructor a;

    public qv(pv pvVar, Constructor constructor) {
        this.a = constructor;
    }

    @Override // defpackage.cw
    public T a() {
        try {
            return (T) this.a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            StringBuilder a = jg.a("Failed to invoke ");
            a.append(this.a);
            a.append(" with no args");
            throw new RuntimeException(a.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder a2 = jg.a("Failed to invoke ");
            a2.append(this.a);
            a2.append(" with no args");
            throw new RuntimeException(a2.toString(), e3.getTargetException());
        }
    }
}
