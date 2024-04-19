package defpackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: SubscriberMethodFinder.java */
/* renamed from: wl0  reason: default package */
/* loaded from: classes.dex */
public class wl0 {
    public static final Map<Class<?>, List<vl0>> d = new ConcurrentHashMap();
    public static final a[] e = new a[4];
    public List<am0> a;
    public final boolean b;
    public final boolean c;

    public wl0(List<am0> list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.c = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r0.e == r0.g.c().b()) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<defpackage.vl0> a(java.lang.Class<?> r8) {
        /*
            r7 = this;
            java.util.Map<java.lang.Class<?>, java.util.List<vl0>> r0 = defpackage.wl0.d
            java.lang.Object r0 = r0.get(r8)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto Lb
            return r0
        Lb:
            boolean r0 = r7.c
            if (r0 == 0) goto L27
            wl0$a r0 = r7.a()
            r0.a(r8)
        L16:
            java.lang.Class<?> r1 = r0.e
            if (r1 == 0) goto L21
            r7.a(r0)
            r0.a()
            goto L16
        L21:
            java.util.List r0 = r7.b(r0)
            goto L95
        L27:
            wl0$a r0 = r7.a()
            r0.a(r8)
        L2e:
            java.lang.Class<?> r1 = r0.e
            if (r1 == 0) goto L91
            zl0 r1 = r0.g
            if (r1 == 0) goto L4b
            zl0 r1 = r1.c()
            if (r1 == 0) goto L4b
            zl0 r1 = r0.g
            zl0 r1 = r1.c()
            java.lang.Class<?> r2 = r0.e
            java.lang.Class r1 = r1.b()
            if (r2 != r1) goto L4b
            goto L67
        L4b:
            java.util.List<am0> r1 = r7.a
            if (r1 == 0) goto L67
            java.util.Iterator r1 = r1.iterator()
        L53:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L67
            java.lang.Object r2 = r1.next()
            am0 r2 = (defpackage.am0) r2
            java.lang.Class<?> r3 = r0.e
            zl0 r2 = r2.a(r3)
            if (r2 == 0) goto L53
        L67:
            r1 = 0
            r0.g = r1
            zl0 r1 = r0.g
            if (r1 == 0) goto L8a
            vl0[] r1 = r1.a()
            int r2 = r1.length
            r3 = 0
        L74:
            if (r3 >= r2) goto L8d
            r4 = r1[r3]
            java.lang.reflect.Method r5 = r4.a
            java.lang.Class<?> r6 = r4.c
            boolean r5 = r0.a(r5, r6)
            if (r5 == 0) goto L87
            java.util.List<vl0> r5 = r0.a
            r5.add(r4)
        L87:
            int r3 = r3 + 1
            goto L74
        L8a:
            r7.a(r0)
        L8d:
            r0.a()
            goto L2e
        L91:
            java.util.List r0 = r7.b(r0)
        L95:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto La1
            java.util.Map<java.lang.Class<?>, java.util.List<vl0>> r1 = defpackage.wl0.d
            r1.put(r8, r0)
            return r0
        La1:
            ll0 r0 = new ll0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Subscriber "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " and its super classes have no public methods with the @Subscribe annotation"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wl0.a(java.lang.Class):java.util.List");
    }

    public final List<vl0> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.a.clear();
        aVar.b.clear();
        aVar.c.clear();
        int i = 0;
        aVar.d.setLength(0);
        aVar.e = null;
        aVar.f = false;
        synchronized (e) {
            while (true) {
                if (i >= 4) {
                    break;
                } else if (e[i] == null) {
                    e[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    /* compiled from: SubscriberMethodFinder.java */
    /* renamed from: wl0$a */
    /* loaded from: classes.dex */
    public static class a {
        public final List<vl0> a = new ArrayList();
        public final Map<Class, Object> b = new HashMap();
        public final Map<String, Class> c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class<?> e;
        public boolean f;
        public zl0 g;

        public void a(Class<?> cls) {
            this.e = cls;
            this.f = false;
        }

        public final boolean b(Method method, Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(sb2, put);
            return false;
        }

        public boolean a(Method method, Class<?> cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public void a() {
            if (this.f) {
                this.e = null;
                return;
            }
            this.e = this.e.getSuperclass();
            String name = this.e.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.e = null;
            }
        }
    }

    public final a a() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                a aVar = e[i];
                if (aVar != null) {
                    e[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    public final void a(a aVar) {
        String a2;
        Method[] methods;
        try {
            try {
                methods = aVar.e.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = aVar.e.getMethods();
                aVar.f = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        tl0 tl0Var = (tl0) method.getAnnotation(tl0.class);
                        if (tl0Var != null) {
                            Class<?> cls = parameterTypes[0];
                            if (aVar.a(method, cls)) {
                                aVar.a.add(new vl0(method, cls, tl0Var.threadMode(), tl0Var.priority(), tl0Var.sticky()));
                            }
                        }
                    } else if (this.b && method.isAnnotationPresent(tl0.class)) {
                        StringBuilder a3 = jg.a("@Subscribe method ", method.getDeclaringClass().getName() + "." + method.getName(), "must have exactly 1 parameter but has ");
                        a3.append(parameterTypes.length);
                        throw new ll0(a3.toString());
                    }
                } else if (this.b && method.isAnnotationPresent(tl0.class)) {
                    throw new ll0(jg.a(method.getDeclaringClass().getName() + "." + method.getName(), " is a illegal @Subscribe method: must be public, non-static, and non-abstract"));
                }
            }
        } catch (LinkageError e2) {
            StringBuilder a4 = jg.a("Could not inspect methods of ");
            a4.append(aVar.e.getName());
            String sb = a4.toString();
            if (this.c) {
                a2 = jg.a(sb, ". Please consider using EventBus annotation processor to avoid reflection.");
            } else {
                a2 = jg.a(sb, ". Please make this class visible to EventBus annotation processor to avoid reflection.");
            }
            throw new ll0(a2, e2);
        }
    }
}
