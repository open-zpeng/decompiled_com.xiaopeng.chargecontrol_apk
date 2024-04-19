package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
/* compiled from: ConstructorConstructor.java */
/* renamed from: pv  reason: default package */
/* loaded from: classes.dex */
public final class pv {
    public final Map<Type, nu<?>> a;
    public final dx b = dx.a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: pv$a */
    /* loaded from: classes.dex */
    public class a<T> implements cw<T> {
        public final /* synthetic */ nu a;
        public final /* synthetic */ Type b;

        public a(pv pvVar, nu nuVar, Type type) {
            this.a = nuVar;
            this.b = type;
        }

        @Override // defpackage.cw
        public T a() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: pv$b */
    /* loaded from: classes.dex */
    public class b<T> implements cw<T> {
        public final /* synthetic */ nu a;
        public final /* synthetic */ Type b;

        public b(pv pvVar, nu nuVar, Type type) {
            this.a = nuVar;
            this.b = type;
        }

        @Override // defpackage.cw
        public T a() {
            return (T) this.a.a(this.b);
        }
    }

    public pv(Map<Type, nu<?>> map) {
        this.a = map;
    }

    public <T> cw<T> a(fx<T> fxVar) {
        qv qvVar;
        Type type = fxVar.b;
        Class<? super T> cls = fxVar.a;
        nu<?> nuVar = this.a.get(type);
        if (nuVar != null) {
            return new a(this, nuVar, type);
        }
        nu<?> nuVar2 = this.a.get(cls);
        if (nuVar2 != null) {
            return new b(this, nuVar2, type);
        }
        cw<T> cwVar = null;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.a(declaredConstructor);
            }
            qvVar = new qv(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            qvVar = null;
        }
        if (qvVar != null) {
            return qvVar;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                cwVar = new rv<>(this);
            } else if (EnumSet.class.isAssignableFrom(cls)) {
                cwVar = new sv<>(this, type);
            } else if (Set.class.isAssignableFrom(cls)) {
                cwVar = new tv<>(this);
            } else if (Queue.class.isAssignableFrom(cls)) {
                cwVar = new uv<>(this);
            } else {
                cwVar = new vv<>(this);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                cwVar = new wv<>(this);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                cwVar = new kv<>(this);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                cwVar = new lv<>(this);
            } else {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 != null) {
                        Type a2 = jv.a(type2);
                        Class<?> d = jv.d(a2);
                        a2.hashCode();
                        if (!String.class.isAssignableFrom(d)) {
                            cwVar = new mv<>(this);
                        }
                    } else {
                        throw new NullPointerException();
                    }
                }
                cwVar = new nv<>(this);
            }
        }
        return cwVar != null ? cwVar : new ov(this, cls, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
