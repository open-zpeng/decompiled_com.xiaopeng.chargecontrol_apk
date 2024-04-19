package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: EncoderRegistry.java */
/* renamed from: fp  reason: default package */
/* loaded from: classes.dex */
public class fp {
    public final List<a<?>> a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: fp$a */
    /* loaded from: classes.dex */
    public static final class a<T> {
        public final Class<T> a;
        public final xh<T> b;

        public a(Class<T> cls, xh<T> xhVar) {
            this.a = cls;
            this.b = xhVar;
        }
    }

    public synchronized <T> xh<T> a(Class<T> cls) {
        for (a<?> aVar : this.a) {
            if (aVar.a.isAssignableFrom(cls)) {
                return (xh<T>) aVar.b;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, xh<T> xhVar) {
        this.a.add(new a<>(cls, xhVar));
    }
}
