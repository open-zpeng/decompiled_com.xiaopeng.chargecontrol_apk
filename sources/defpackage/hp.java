package defpackage;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LoadPathCache.java */
/* renamed from: hp  reason: default package */
/* loaded from: classes.dex */
public class hp {
    public static final tj<?, ?, ?> c = new tj<>(Object.class, Object.class, Object.class, Collections.singletonList(new ij(Object.class, Object.class, Object.class, Collections.emptyList(), new io(), null)), null);
    public final y4<rq, tj<?, ?, ?>> a = new y4<>();
    public final AtomicReference<rq> b = new AtomicReference<>();

    public boolean a(tj<?, ?, ?> tjVar) {
        return c.equals(tjVar);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, tj<?, ?, ?> tjVar) {
        synchronized (this.a) {
            y4<rq, tj<?, ?, ?>> y4Var = this.a;
            rq rqVar = new rq(cls, cls2, cls3);
            if (tjVar == null) {
                tjVar = c;
            }
            y4Var.put(rqVar, tjVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <Data, TResource, Transcode> tj<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        tj<Data, TResource, Transcode> tjVar;
        rq andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new rq();
        }
        andSet.a = cls;
        andSet.b = cls2;
        andSet.c = cls3;
        synchronized (this.a) {
            tjVar = (tj<Data, TResource, Transcode>) this.a.getOrDefault(andSet, null);
        }
        this.b.set(andSet);
        return tjVar;
    }
}
