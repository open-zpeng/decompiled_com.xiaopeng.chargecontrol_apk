package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: TranscoderRegistry.java */
/* renamed from: ho  reason: default package */
/* loaded from: classes.dex */
public class ho {
    public final List<a<?, ?>> a = new ArrayList();

    /* compiled from: TranscoderRegistry.java */
    /* renamed from: ho$a */
    /* loaded from: classes.dex */
    public static final class a<Z, R> {
        public final Class<Z> a;
        public final Class<R> b;
        public final go<Z, R> c;

        public a(Class<Z> cls, Class<R> cls2, go<Z, R> goVar) {
            this.a = cls;
            this.b = cls2;
            this.c = goVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, go<Z, R> goVar) {
        this.a.add(new a<>(cls, cls2, goVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> go<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return io.a;
        }
        for (a<?, ?> aVar : this.a) {
            if (aVar.a(cls, cls2)) {
                return (go<Z, R>) aVar.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
