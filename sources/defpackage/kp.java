package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: ResourceEncoderRegistry.java */
/* renamed from: kp  reason: default package */
/* loaded from: classes.dex */
public class kp {
    public final List<a<?>> a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    /* renamed from: kp$a */
    /* loaded from: classes.dex */
    public static final class a<T> {
        public final Class<T> a;
        public final ei<T> b;

        public a(Class<T> cls, ei<T> eiVar) {
            this.a = cls;
            this.b = eiVar;
        }
    }

    public synchronized <Z> void a(Class<Z> cls, ei<Z> eiVar) {
        this.a.add(new a<>(cls, eiVar));
    }

    public synchronized <Z> void b(Class<Z> cls, ei<Z> eiVar) {
        this.a.add(0, new a<>(cls, eiVar));
    }

    public synchronized <Z> ei<Z> a(Class<Z> cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.a.get(i);
            if (aVar.a.isAssignableFrom(cls)) {
                return (ei<Z>) aVar.b;
            }
        }
        return null;
    }
}
