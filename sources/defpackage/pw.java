package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
/* compiled from: MapTypeAdapterFactory.java */
/* renamed from: pw  reason: default package */
/* loaded from: classes.dex */
public final class pw implements cv {
    public final pv c;
    public final boolean d;

    /* compiled from: MapTypeAdapterFactory.java */
    /* renamed from: pw$a */
    /* loaded from: classes.dex */
    public final class a<K, V> extends bv<Map<K, V>> {
        public final bv<K> a;
        public final bv<V> b;
        public final cw<? extends Map<K, V>> c;

        public a(lu luVar, Type type, bv<K> bvVar, Type type2, bv<V> bvVar2, cw<? extends Map<K, V>> cwVar) {
            this.a = new ww(luVar, bvVar, type);
            this.b = new ww(luVar, bvVar2, type2);
            this.c = cwVar;
        }

        @Override // defpackage.bv
        public Object read(gx gxVar) {
            hx s = gxVar.s();
            if (s == hx.NULL) {
                gxVar.p();
                return null;
            }
            Map<K, V> a = this.c.a();
            if (s == hx.BEGIN_ARRAY) {
                gxVar.a();
                while (gxVar.h()) {
                    gxVar.a();
                    K read = this.a.read(gxVar);
                    if (a.put(read, this.b.read(gxVar)) == null) {
                        gxVar.e();
                    } else {
                        throw new zu("duplicate key: " + read);
                    }
                }
                gxVar.e();
            } else {
                gxVar.b();
                while (gxVar.h()) {
                    zv.a.a(gxVar);
                    K read2 = this.a.read(gxVar);
                    if (a.put(read2, this.b.read(gxVar)) != null) {
                        throw new zu("duplicate key: " + read2);
                    }
                }
                gxVar.f();
            }
            return a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.bv
        public void write(ix ixVar, Object obj) {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                ixVar.g();
            } else if (!pw.this.d) {
                ixVar.c();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    ixVar.a(String.valueOf(entry.getKey()));
                    this.b.write(ixVar, entry.getValue());
                }
                ixVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    ru jsonTree = this.a.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z |= jsonTree.e() || (jsonTree instanceof uu);
                }
                if (z) {
                    ixVar.b();
                    int size = arrayList.size();
                    while (i < size) {
                        ixVar.b();
                        xw.X.write(ixVar, (ru) arrayList.get(i));
                        this.b.write(ixVar, arrayList2.get(i));
                        ixVar.d();
                        i++;
                    }
                    ixVar.d();
                    return;
                }
                ixVar.c();
                int size2 = arrayList.size();
                while (i < size2) {
                    ru ruVar = (ru) arrayList.get(i);
                    if (ruVar.g()) {
                        wu c = ruVar.c();
                        Object obj2 = c.a;
                        if (obj2 instanceof Number) {
                            str = String.valueOf(c.h());
                        } else if (obj2 instanceof Boolean) {
                            str = Boolean.toString(c.a());
                        } else if (c.i()) {
                            str = c.d();
                        } else {
                            throw new AssertionError();
                        }
                    } else if (!(ruVar instanceof tu)) {
                        throw new AssertionError();
                    } else {
                        str = "null";
                    }
                    ixVar.a(str);
                    this.b.write(ixVar, arrayList2.get(i));
                    i++;
                }
                ixVar.e();
            }
        }
    }

    public pw(pv pvVar, boolean z) {
        this.c = pvVar;
        this.d = z;
    }

    @Override // defpackage.cv
    public <T> bv<T> a(lu luVar, fx<T> fxVar) {
        Type[] actualTypeArguments;
        bv<Boolean> bvVar;
        Type type = fxVar.b;
        if (Map.class.isAssignableFrom(fxVar.a)) {
            Class<?> d = jv.d(type);
            if (type == Properties.class) {
                actualTypeArguments = new Type[]{String.class, String.class};
            } else {
                Type b = jv.b(type, d, Map.class);
                actualTypeArguments = b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments() : new Type[]{Object.class, Object.class};
            }
            Type type2 = actualTypeArguments[0];
            if (type2 != Boolean.TYPE && type2 != Boolean.class) {
                bvVar = luVar.a((fx) new fx<>(type2));
            } else {
                bvVar = xw.f;
            }
            return new a(luVar, actualTypeArguments[0], bvVar, actualTypeArguments[1], luVar.a((fx) new fx<>(actualTypeArguments[1])), this.c.a(fxVar));
        }
        return null;
    }
}
