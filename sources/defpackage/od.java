package defpackage;

import defpackage.vd;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ClassesInfoCache.java */
@Deprecated
/* renamed from: od  reason: default package */
/* loaded from: classes.dex */
public final class od {
    public static od c = new od();
    public final Map<Class<?>, a> a = new HashMap();
    public final Map<Class<?>, Boolean> b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* renamed from: od$a */
    /* loaded from: classes.dex */
    public static class a {
        public final Map<vd.a, List<b>> a = new HashMap();
        public final Map<b, vd.a> b;

        public a(Map<b, vd.a> map) {
            this.b = map;
            for (Map.Entry<b, vd.a> entry : map.entrySet()) {
                vd.a value = entry.getValue();
                List<b> list = this.a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void a(List<b> list, zd zdVar, vd.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(zdVar, aVar, obj);
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* renamed from: od$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;
        public final Method b;

        public b(int i, Method method) {
            this.a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        public void a(zd zdVar, vd.a aVar, Object obj) {
            try {
                int i = this.a;
                if (i == 0) {
                    this.b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.b.invoke(obj, zdVar);
                } else if (i != 2) {
                } else {
                    this.b.invoke(obj, zdVar, aVar);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
            }
            return false;
        }

        public int hashCode() {
            return this.b.getName().hashCode() + (this.a * 31);
        }
    }

    public final Method[] a(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public a b(Class<?> cls) {
        a aVar = this.a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public final void a(Map<b, vd.a> map, b bVar, vd.a aVar, Class<?> cls) {
        vd.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.b;
        StringBuilder a2 = jg.a("Method ");
        a2.append(method.getName());
        a2.append(" in ");
        a2.append(cls.getName());
        a2.append(" already declared with different @OnLifecycleEvent value: previous value ");
        a2.append(aVar2);
        a2.append(", new value ");
        a2.append(aVar);
        throw new IllegalArgumentException(a2.toString());
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i;
        a b2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b2 = b(superclass)) != null) {
            hashMap.putAll(b2.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, vd.a> entry : b(cls2).b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            ge geVar = (ge) method.getAnnotation(ge.class);
            if (geVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(zd.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                vd.a value = geVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(vd.a.class)) {
                        if (value != vd.a.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.a.put(cls, aVar);
        this.b.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
