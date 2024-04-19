package defpackage;

import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* renamed from: gw  reason: default package */
/* loaded from: classes.dex */
public class gw extends iw {
    public final /* synthetic */ Method a;

    public gw(Method method) {
        this.a = method;
    }

    @Override // defpackage.iw
    public <T> T a(Class<T> cls) {
        iw.b(cls);
        return (T) this.a.invoke(null, cls, Object.class);
    }
}
