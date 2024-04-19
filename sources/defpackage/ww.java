package defpackage;

import defpackage.sw;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* renamed from: ww  reason: default package */
/* loaded from: classes.dex */
public final class ww<T> extends bv<T> {
    public final lu a;
    public final bv<T> b;
    public final Type c;

    public ww(lu luVar, bv<T> bvVar, Type type) {
        this.a = luVar;
        this.b = bvVar;
        this.c = type;
    }

    @Override // defpackage.bv
    public T read(gx gxVar) {
        return this.b.read(gxVar);
    }

    @Override // defpackage.bv
    public void write(ix ixVar, T t) {
        bv<T> bvVar = this.b;
        Type type = this.c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.c) {
            bvVar = this.a.a((fx) new fx<>(type));
            if (bvVar instanceof sw.a) {
                bv<T> bvVar2 = this.b;
                if (!(bvVar2 instanceof sw.a)) {
                    bvVar = bvVar2;
                }
            }
        }
        bvVar.write(ixVar, t);
    }
}
