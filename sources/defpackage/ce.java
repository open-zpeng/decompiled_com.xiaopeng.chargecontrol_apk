package defpackage;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Lifecycling.java */
/* renamed from: ce  reason: default package */
/* loaded from: classes.dex */
public class ce {
    public static Map<Class<?>, Integer> a = new HashMap();
    public static Map<Class<?>, List<Constructor<? extends sd>>> b = new HashMap();

    public static xd a(Object obj) {
        boolean z = obj instanceof xd;
        boolean z2 = obj instanceof rd;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((rd) obj, (xd) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((rd) obj, null);
        }
        if (z) {
            return (xd) obj;
        }
        Class<?> cls = obj.getClass();
        if (a(cls) == 2) {
            List<Constructor<? extends sd>> list = b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
            }
            sd[] sdVarArr = new sd[list.size()];
            for (int i = 0; i < list.size(); i++) {
                sdVarArr[i] = a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(sdVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    public static boolean b(Class<?> cls) {
        return cls != null && yd.class.isAssignableFrom(cls);
    }

    public static sd a(Constructor<? extends sd> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static int a(Class<?> cls) {
        Constructor<?> constructor;
        boolean z;
        ArrayList arrayList;
        Integer num = a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            int i2 = 0;
            try {
                Package r3 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r3 != null ? r3.getName() : "";
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String a2 = a(canonicalName);
                if (!name.isEmpty()) {
                    a2 = name + "." + a2;
                }
                constructor = Class.forName(a2).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            if (constructor != null) {
                b.put(cls, Collections.singletonList(constructor));
            } else {
                od odVar = od.c;
                Boolean bool = odVar.b.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    Method[] a3 = odVar.a(cls);
                    int length = a3.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (((ge) a3[i3].getAnnotation(ge.class)) != null) {
                                odVar.a(cls, a3);
                                z = true;
                                break;
                            }
                            i3++;
                        } else {
                            odVar.b.put(cls, false);
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (b(superclass)) {
                        arrayList = a((Class<?>) superclass) != 1 ? new ArrayList(b.get(superclass)) : null;
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length2 = interfaces.length;
                    while (true) {
                        if (i2 < length2) {
                            Class<?> cls2 = interfaces[i2];
                            if (b(cls2)) {
                                if (a(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll(b.get(cls2));
                            }
                            i2++;
                        } else if (arrayList != null) {
                            b.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        a.put(cls, Integer.valueOf(i));
        return i;
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
