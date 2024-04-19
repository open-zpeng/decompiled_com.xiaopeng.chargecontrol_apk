package defpackage;

import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* renamed from: fw  reason: default package */
/* loaded from: classes.dex */
public class fw extends iw {
    public final /* synthetic */ Method a;
    public final /* synthetic */ int b;

    public fw(Method method, int i) {
        this.a = method;
        this.b = i;
    }

    @Override // defpackage.iw
    public <T> T a(Class<T> cls) {
        iw.b(cls);
        return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
    }
}
