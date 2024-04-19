package defpackage;

import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* renamed from: ew  reason: default package */
/* loaded from: classes.dex */
public class ew extends iw {
    public final /* synthetic */ Method a;
    public final /* synthetic */ Object b;

    public ew(Method method, Object obj) {
        this.a = method;
        this.b = obj;
    }

    @Override // defpackage.iw
    public <T> T a(Class<T> cls) {
        iw.b(cls);
        return (T) this.a.invoke(this.b, cls);
    }
}
