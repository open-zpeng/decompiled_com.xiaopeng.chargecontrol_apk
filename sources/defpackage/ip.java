package defpackage;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ModelToResourceClassCache.java */
/* renamed from: ip  reason: default package */
/* loaded from: classes.dex */
public class ip {
    public final AtomicReference<rq> a = new AtomicReference<>();
    public final y4<rq, List<Class<?>>> b = new y4<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> orDefault;
        rq andSet = this.a.getAndSet(null);
        if (andSet == null) {
            andSet = new rq(cls, cls2, cls3);
        } else {
            andSet.a = cls;
            andSet.b = cls2;
            andSet.c = cls3;
        }
        synchronized (this.b) {
            orDefault = this.b.getOrDefault(andSet, null);
        }
        this.a.set(andSet);
        return orDefault;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new rq(cls, cls2, cls3), list);
        }
    }
}
