package defpackage;

import android.os.Looper;
import defpackage.nl0;
import defpackage.ol0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
/* compiled from: EventBus.java */
/* renamed from: jl0  reason: default package */
/* loaded from: classes.dex */
public class jl0 {
    public static volatile jl0 s;
    public static final kl0 t = new kl0();
    public static final Map<Class<?>, List<Class<?>>> u = new HashMap();
    public final Map<Class<?>, CopyOnWriteArrayList<xl0>> a;
    public final Map<Object, List<Class<?>>> b;
    public final Map<Class<?>, Object> c;
    public final ThreadLocal<b> d;
    public final ol0 e;
    public final sl0 f;
    public final il0 g;
    public final hl0 h;
    public final wl0 i;
    public final ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final nl0 r;

    /* compiled from: EventBus.java */
    /* renamed from: jl0$a */
    /* loaded from: classes.dex */
    public class a extends ThreadLocal<b> {
        public a(jl0 jl0Var) {
        }

        @Override // java.lang.ThreadLocal
        public b initialValue() {
            return new b();
        }
    }

    /* compiled from: EventBus.java */
    /* renamed from: jl0$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final List<Object> a = new ArrayList();
        public boolean b;
        public boolean c;
        public xl0 d;
        public Object e;
        public boolean f;
    }

    public jl0() {
        this(t);
    }

    public static kl0 b() {
        return new kl0();
    }

    public static jl0 c() {
        jl0 jl0Var = s;
        if (jl0Var == null) {
            synchronized (jl0.class) {
                jl0Var = s;
                if (jl0Var == null) {
                    jl0Var = new jl0(t);
                    s = jl0Var;
                }
            }
        }
        return jl0Var;
    }

    public final void a(Object obj, vl0 vl0Var) {
        Object value;
        Class<?> cls = vl0Var.c;
        xl0 xl0Var = new xl0(obj, vl0Var);
        CopyOnWriteArrayList<xl0> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(xl0Var)) {
            StringBuilder a2 = jg.a("Subscriber ");
            a2.append(obj.getClass());
            a2.append(" already registered to event ");
            a2.append(cls);
            throw new ll0(a2.toString());
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || vl0Var.d > copyOnWriteArrayList.get(i).b.d) {
                copyOnWriteArrayList.add(i, xl0Var);
                break;
            }
        }
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (vl0Var.e) {
            if (this.p) {
                for (Map.Entry<Class<?>, Object> entry : this.c.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey()) && (value = entry.getValue()) != null) {
                        a(xl0Var, value, a());
                    }
                }
                return;
            }
            Object obj2 = this.c.get(cls);
            if (obj2 != null) {
                a(xl0Var, obj2, a());
            }
        }
    }

    public void d(Object obj) {
        List<vl0> a2 = this.i.a(obj.getClass());
        synchronized (this) {
            for (vl0 vl0Var : a2) {
                a(obj, vl0Var);
            }
        }
    }

    public synchronized void e(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                CopyOnWriteArrayList<xl0> copyOnWriteArrayList = this.a.get(cls);
                if (copyOnWriteArrayList != null) {
                    int size = copyOnWriteArrayList.size();
                    int i = 0;
                    while (i < size) {
                        xl0 xl0Var = copyOnWriteArrayList.get(i);
                        if (xl0Var.a == obj) {
                            xl0Var.c = false;
                            copyOnWriteArrayList.remove(i);
                            i--;
                            size--;
                        }
                        i++;
                    }
                }
            }
            this.b.remove(obj);
        } else {
            this.r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public String toString() {
        StringBuilder a2 = jg.a("EventBus[indexCount=");
        a2.append(this.q);
        a2.append(", eventInheritance=");
        a2.append(this.p);
        a2.append("]");
        return a2.toString();
    }

    public jl0(kl0 kl0Var) {
        Looper looper;
        Looper looper2;
        this.d = new a(this);
        nl0 nl0Var = kl0Var.k;
        if (nl0Var == null) {
            if (yl0.a()) {
                try {
                    looper2 = Looper.getMainLooper();
                } catch (RuntimeException unused) {
                    looper2 = null;
                }
                if (looper2 != null) {
                    nl0Var = new yl0("EventBus");
                }
            }
            nl0Var = new nl0.a();
        }
        this.r = nl0Var;
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        ol0 ol0Var = kl0Var.l;
        if (ol0Var == null) {
            if (yl0.a()) {
                try {
                    looper = Looper.getMainLooper();
                } catch (RuntimeException unused2) {
                    looper = null;
                }
                if (looper != null) {
                    ol0Var = new ol0.a(looper);
                }
            }
            ol0Var = null;
        }
        this.e = ol0Var;
        ol0 ol0Var2 = this.e;
        this.f = ol0Var2 != null ? ((ol0.a) ol0Var2).a(this) : null;
        this.g = new il0(this);
        this.h = new hl0(this);
        List<am0> list = kl0Var.j;
        this.q = list != null ? list.size() : 0;
        this.i = new wl0(kl0Var.j, kl0Var.h, kl0Var.g);
        this.l = kl0Var.a;
        this.m = kl0Var.b;
        this.n = kl0Var.c;
        this.o = kl0Var.d;
        this.k = kl0Var.e;
        this.p = kl0Var.f;
        this.j = kl0Var.i;
    }

    public void b(Object obj) {
        b bVar = this.d.get();
        List<Object> list = bVar.a;
        list.add(obj);
        if (bVar.b) {
            return;
        }
        bVar.c = a();
        bVar.b = true;
        if (bVar.f) {
            throw new ll0("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                a(list.remove(0), bVar);
            } finally {
                bVar.b = false;
                bVar.c = false;
            }
        }
    }

    public void c(Object obj) {
        synchronized (this.c) {
            this.c.put(obj.getClass(), obj);
        }
        b(obj);
    }

    public static List<Class<?>> c(Class<?> cls) {
        List<Class<?>> list;
        synchronized (u) {
            list = u.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                u.put(cls, list);
            }
        }
        return list;
    }

    public boolean b(Class<?> cls) {
        CopyOnWriteArrayList<xl0> copyOnWriteArrayList;
        List<Class<?>> c = c(cls);
        if (c != null) {
            int size = c.size();
            for (int i = 0; i < size; i++) {
                Class<?> cls2 = c.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = this.a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        ol0 ol0Var = this.e;
        if (ol0Var != null) {
            if (!(((ol0.a) ol0Var).a == Looper.myLooper())) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean a(Object obj) {
        return this.b.containsKey(obj);
    }

    public <T> T a(Class<T> cls) {
        T cast;
        synchronized (this.c) {
            cast = cls.cast(this.c.get(cls));
        }
        return cast;
    }

    public final void a(Object obj, b bVar) {
        boolean a2;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List<Class<?>> c = c(cls);
            int size = c.size();
            a2 = false;
            for (int i = 0; i < size; i++) {
                a2 |= a(obj, bVar, c.get(i));
            }
        } else {
            a2 = a(obj, bVar, cls);
        }
        if (a2) {
            return;
        }
        if (this.m) {
            this.r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == pl0.class || cls == ul0.class) {
            return;
        }
        b(new pl0(this, obj));
    }

    public final boolean a(Object obj, b bVar, Class<?> cls) {
        CopyOnWriteArrayList<xl0> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<xl0> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            xl0 next = it.next();
            bVar.e = obj;
            bVar.d = next;
            try {
                a(next, obj, bVar.c);
                if (bVar.f) {
                    return true;
                }
            } finally {
                bVar.e = null;
                bVar.d = null;
                bVar.f = false;
            }
        }
        return true;
    }

    public final void a(xl0 xl0Var, Object obj, boolean z) {
        int ordinal = xl0Var.b.b.ordinal();
        if (ordinal == 0) {
            a(xl0Var, obj);
        } else if (ordinal == 1) {
            if (z) {
                a(xl0Var, obj);
            } else {
                this.f.a(xl0Var, obj);
            }
        } else if (ordinal == 2) {
            sl0 sl0Var = this.f;
            if (sl0Var != null) {
                sl0Var.a(xl0Var, obj);
            } else {
                a(xl0Var, obj);
            }
        } else if (ordinal == 3) {
            if (z) {
                this.g.a(xl0Var, obj);
            } else {
                a(xl0Var, obj);
            }
        } else if (ordinal == 4) {
            this.h.a(xl0Var, obj);
        } else {
            StringBuilder a2 = jg.a("Unknown thread mode: ");
            a2.append(xl0Var.b.b);
            throw new IllegalStateException(a2.toString());
        }
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public void a(ql0 ql0Var) {
        Object obj = ql0Var.a;
        xl0 xl0Var = ql0Var.b;
        ql0.a(ql0Var);
        if (xl0Var.c) {
            a(xl0Var, obj);
        }
    }

    public void a(xl0 xl0Var, Object obj) {
        try {
            xl0Var.b.a.invoke(xl0Var.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof ul0) {
                if (this.l) {
                    nl0 nl0Var = this.r;
                    Level level = Level.SEVERE;
                    StringBuilder a2 = jg.a("SubscriberExceptionEvent subscriber ");
                    a2.append(xl0Var.a.getClass());
                    a2.append(" threw an exception");
                    nl0Var.a(level, a2.toString(), cause);
                    ul0 ul0Var = (ul0) obj;
                    nl0 nl0Var2 = this.r;
                    Level level2 = Level.SEVERE;
                    StringBuilder a3 = jg.a("Initial event ");
                    a3.append(ul0Var.b);
                    a3.append(" caused exception in ");
                    a3.append(ul0Var.c);
                    nl0Var2.a(level2, a3.toString(), ul0Var.a);
                }
            } else if (!this.k) {
                if (this.l) {
                    nl0 nl0Var3 = this.r;
                    Level level3 = Level.SEVERE;
                    StringBuilder a4 = jg.a("Could not dispatch event: ");
                    a4.append(obj.getClass());
                    a4.append(" to subscribing class ");
                    a4.append(xl0Var.a.getClass());
                    nl0Var3.a(level3, a4.toString(), cause);
                }
                if (this.n) {
                    b(new ul0(this, cause, obj, xl0Var.a));
                }
            } else {
                throw new ll0("Invoking subscriber failed", cause);
            }
        }
    }
}
