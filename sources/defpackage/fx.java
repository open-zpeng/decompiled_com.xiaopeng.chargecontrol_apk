package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* renamed from: fx  reason: default package */
/* loaded from: classes.dex */
public class fx<T> {
    public final Class<? super T> a;
    public final Type b;
    public final int c;

    public fx() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            this.b = jv.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.a = (Class<? super T>) jv.d(this.b);
            this.c = this.b.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof fx) && jv.a(this.b, ((fx) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return jv.e(this.b);
    }

    public fx(Type type) {
        if (type != null) {
            this.b = jv.a(type);
            this.a = (Class<? super T>) jv.d(this.b);
            this.c = this.b.hashCode();
            return;
        }
        throw new NullPointerException();
    }
}
