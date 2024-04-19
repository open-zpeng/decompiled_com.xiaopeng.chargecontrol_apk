package defpackage;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* renamed from: jw  reason: default package */
/* loaded from: classes.dex */
public final class jw<E> extends bv<Object> {
    public static final cv c = new a();
    public final Class<E> a;
    public final bv<E> b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: jw$a */
    /* loaded from: classes.dex */
    public class a implements cv {
        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            Type type = fxVar.b;
            if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                Type c = jv.c(type);
                return new jw(luVar, luVar.a((fx) new fx<>(c)), jv.d(c));
            }
            return null;
        }
    }

    public jw(lu luVar, bv<E> bvVar, Class<E> cls) {
        this.b = new ww(luVar, bvVar, cls);
        this.a = cls;
    }

    @Override // defpackage.bv
    public Object read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        gxVar.a();
        while (gxVar.h()) {
            arrayList.add(this.b.read(gxVar));
        }
        gxVar.e();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.bv
    public void write(ix ixVar, Object obj) {
        if (obj == null) {
            ixVar.g();
            return;
        }
        ixVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.write(ixVar, Array.get(obj, i));
        }
        ixVar.d();
    }
}
