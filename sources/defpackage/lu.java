package defpackage;

import defpackage.xw;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* compiled from: Gson.java */
/* renamed from: lu  reason: default package */
/* loaded from: classes.dex */
public final class lu {
    public static final fx<?> k = new fx<>(Object.class);
    public final ThreadLocal<Map<fx<?>, a<?>>> a;
    public final Map<fx<?>, bv<?>> b;
    public final pv c;
    public final mw d;
    public final List<cv> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    /* compiled from: Gson.java */
    /* renamed from: lu$a */
    /* loaded from: classes.dex */
    public static class a<T> extends bv<T> {
        public bv<T> a;

        @Override // defpackage.bv
        public T read(gx gxVar) {
            bv<T> bvVar = this.a;
            if (bvVar != null) {
                return bvVar.read(gxVar);
            }
            throw new IllegalStateException();
        }

        @Override // defpackage.bv
        public void write(ix ixVar, T t) {
            bv<T> bvVar = this.a;
            if (bvVar != null) {
                bvVar.write(ixVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public lu() {
        this(xv.i, eu.c, Collections.emptyMap(), false, false, false, true, false, false, false, av.c, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public void a(ru ruVar, ix ixVar) {
        boolean z = ixVar.h;
        ixVar.h = true;
        boolean z2 = ixVar.i;
        ixVar.i = this.h;
        boolean z3 = ixVar.k;
        ixVar.k = this.f;
        try {
            try {
                xw.X.write(ixVar, ruVar);
            } catch (IOException e) {
                throw new su(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            ixVar.h = z;
            ixVar.i = z2;
            ixVar.k = z3;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public lu(xv xvVar, fu fuVar, Map<Type, nu<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, av avVar, String str, int i, int i2, List<cv> list, List<cv> list2, List<cv> list3) {
        bv iuVar;
        bv guVar;
        bv huVar;
        this.a = new ThreadLocal<>();
        this.b = new ConcurrentHashMap();
        this.c = new pv(map);
        this.f = z;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(xw.Y);
        arrayList.add(qw.b);
        arrayList.add(xvVar);
        arrayList.addAll(list3);
        arrayList.add(xw.D);
        arrayList.add(xw.m);
        arrayList.add(xw.g);
        arrayList.add(xw.i);
        arrayList.add(xw.k);
        if (avVar == av.c) {
            iuVar = xw.t;
        } else {
            iuVar = new iu();
        }
        arrayList.add(new yw(Long.TYPE, Long.class, iuVar));
        Class cls = Double.TYPE;
        if (z7) {
            guVar = xw.v;
        } else {
            guVar = new gu(this);
        }
        arrayList.add(new yw(cls, Double.class, guVar));
        Class cls2 = Float.TYPE;
        if (z7) {
            huVar = xw.u;
        } else {
            huVar = new hu(this);
        }
        arrayList.add(new yw(cls2, Float.class, huVar));
        arrayList.add(xw.x);
        arrayList.add(xw.o);
        arrayList.add(xw.q);
        arrayList.add(new xw.y(AtomicLong.class, new ju(iuVar).nullSafe()));
        arrayList.add(new xw.y(AtomicLongArray.class, new ku(iuVar).nullSafe()));
        arrayList.add(xw.s);
        arrayList.add(xw.z);
        arrayList.add(xw.F);
        arrayList.add(xw.H);
        arrayList.add(new xw.y(BigDecimal.class, xw.B));
        arrayList.add(new xw.y(BigInteger.class, xw.C));
        arrayList.add(xw.J);
        arrayList.add(xw.L);
        arrayList.add(xw.P);
        arrayList.add(xw.R);
        arrayList.add(xw.W);
        arrayList.add(xw.N);
        arrayList.add(xw.d);
        arrayList.add(lw.b);
        arrayList.add(xw.U);
        arrayList.add(uw.b);
        arrayList.add(tw.b);
        arrayList.add(xw.S);
        arrayList.add(jw.c);
        arrayList.add(xw.b);
        arrayList.add(new kw(this.c));
        arrayList.add(new pw(this.c, z2));
        this.d = new mw(this.c);
        arrayList.add(this.d);
        arrayList.add(xw.Z);
        arrayList.add(new sw(this.c, fuVar, xvVar, this.d));
        this.e = Collections.unmodifiableList(arrayList);
    }

    public void a(Object obj, Type type, ix ixVar) {
        bv a2 = a(new fx(type));
        boolean z = ixVar.h;
        ixVar.h = true;
        boolean z2 = ixVar.i;
        ixVar.i = this.h;
        boolean z3 = ixVar.k;
        ixVar.k = this.f;
        try {
            try {
                a2.write(ixVar, obj);
            } catch (IOException e) {
                throw new su(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            ixVar.h = z;
            ixVar.i = z2;
            ixVar.k = z3;
        }
    }

    public <T> bv<T> a(Class<T> cls) {
        return a((fx) new fx<>(cls));
    }

    public static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public <T> bv<T> a(fx<T> fxVar) {
        bv<T> bvVar = (bv<T>) this.b.get(fxVar == null ? k : fxVar);
        if (bvVar != null) {
            return bvVar;
        }
        Map<fx<?>, a<?>> map = this.a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z = true;
        }
        a<?> aVar = map.get(fxVar);
        if (aVar != null) {
            return aVar;
        }
        try {
            a<?> aVar2 = new a<>();
            map.put(fxVar, aVar2);
            for (cv cvVar : this.e) {
                bv<T> a2 = cvVar.a(this, fxVar);
                if (a2 != null) {
                    if (aVar2.a == null) {
                        aVar2.a = a2;
                        this.b.put(fxVar, a2);
                        return a2;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + fxVar);
        } finally {
            map.remove(fxVar);
            if (z) {
                this.a.remove();
            }
        }
    }

    public <T> bv<T> a(cv cvVar, fx<T> fxVar) {
        if (!this.e.contains(cvVar)) {
            cvVar = this.d;
        }
        boolean z = false;
        for (cv cvVar2 : this.e) {
            if (z) {
                bv<T> a2 = cvVar2.a(this, fxVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (cvVar2 == cvVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + fxVar);
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((ru) tu.a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        try {
            a(obj, type, a(iv.a((Appendable) stringWriter)));
            return stringWriter.toString();
        } catch (IOException e) {
            throw new su(e);
        }
    }

    public String a(ru ruVar) {
        StringWriter stringWriter = new StringWriter();
        try {
            a(ruVar, a(iv.a((Appendable) stringWriter)));
            return stringWriter.toString();
        } catch (IOException e) {
            throw new su(e);
        }
    }

    public ix a(Writer writer) {
        if (this.g) {
            writer.write(")]}'\n");
        }
        ix ixVar = new ix(writer);
        if (this.i) {
            ixVar.f = "  ";
            ixVar.g = ": ";
        }
        ixVar.k = this.f;
        return ixVar;
    }

    public <T> T a(String str, Class<T> cls) {
        Object a2 = a(str, (Type) cls);
        if (cls == Integer.TYPE) {
            cls = (Class<T>) Integer.class;
        } else if (cls == Float.TYPE) {
            cls = (Class<T>) Float.class;
        } else if (cls == Byte.TYPE) {
            cls = (Class<T>) Byte.class;
        } else if (cls == Double.TYPE) {
            cls = (Class<T>) Double.class;
        } else if (cls == Long.TYPE) {
            cls = (Class<T>) Long.class;
        } else if (cls == Character.TYPE) {
            cls = (Class<T>) Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = (Class<T>) Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = (Class<T>) Short.class;
        } else if (cls == Void.TYPE) {
            cls = (Class<T>) Void.class;
        }
        return cls.cast(a2);
    }

    public <T> T a(String str, Type type) {
        T t = null;
        if (str == null) {
            return null;
        }
        gx gxVar = new gx(new StringReader(str));
        gxVar.d = this.j;
        boolean i = gxVar.i();
        boolean z = true;
        gxVar.d = true;
        try {
            try {
                try {
                    gxVar.s();
                    z = false;
                    t = a((fx) new fx<>(type)).read(gxVar);
                } catch (AssertionError e) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                } catch (IllegalStateException e2) {
                    throw new zu(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new zu(e3);
                }
            } catch (IOException e4) {
                throw new zu(e4);
            }
            if (t != null) {
                try {
                    if (gxVar.s() != hx.END_DOCUMENT) {
                        throw new su("JSON document was not fully consumed.");
                    }
                } catch (jx e5) {
                    throw new zu(e5);
                } catch (IOException e6) {
                    throw new su(e6);
                }
            }
            return t;
        } finally {
            gxVar.d = i;
        }
    }
}
