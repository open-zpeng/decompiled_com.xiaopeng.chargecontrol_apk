package defpackage;

import defpackage.ki;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: DataRewinderRegistry.java */
/* renamed from: li  reason: default package */
/* loaded from: classes.dex */
public class li {
    public static final ki.a<?> b = new a();
    public final Map<Class<?>, ki.a<?>> a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: li$a */
    /* loaded from: classes.dex */
    public class a implements ki.a<Object> {
        @Override // defpackage.ki.a
        public ki<Object> a(Object obj) {
            return new b(obj);
        }

        @Override // defpackage.ki.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: li$b */
    /* loaded from: classes.dex */
    public static final class b implements ki<Object> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // defpackage.ki
        public Object a() {
            return this.a;
        }

        @Override // defpackage.ki
        public void b() {
        }
    }

    public synchronized <T> ki<T> a(T t) {
        ki.a<?> aVar;
        defpackage.a.a((Object) t, "Argument must not be null");
        aVar = this.a.get(t.getClass());
        if (aVar == null) {
            Iterator<ki.a<?>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ki.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = b;
        }
        return (ki<T>) aVar.a(t);
    }

    public synchronized void a(ki.a<?> aVar) {
        this.a.put(aVar.a(), aVar);
    }
}
