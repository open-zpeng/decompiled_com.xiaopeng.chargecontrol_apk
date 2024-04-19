package defpackage;

import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* renamed from: xv  reason: default package */
/* loaded from: classes.dex */
public final class xv implements cv, Cloneable {
    public static final xv i = new xv();
    public boolean f;
    public double c = -1.0d;
    public int d = 136;
    public boolean e = true;
    public List<cu> g = Collections.emptyList();
    public List<cu> h = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* renamed from: xv$a */
    /* loaded from: classes.dex */
    public class a<T> extends bv<T> {
        public bv<T> a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ lu d;
        public final /* synthetic */ fx e;

        public a(boolean z, boolean z2, lu luVar, fx fxVar) {
            this.b = z;
            this.c = z2;
            this.d = luVar;
            this.e = fxVar;
        }

        @Override // defpackage.bv
        public T read(gx gxVar) {
            if (this.b) {
                gxVar.v();
                return null;
            }
            bv<T> bvVar = this.a;
            if (bvVar == null) {
                bvVar = this.d.a(xv.this, this.e);
                this.a = bvVar;
            }
            return bvVar.read(gxVar);
        }

        @Override // defpackage.bv
        public void write(ix ixVar, T t) {
            if (this.c) {
                ixVar.g();
                return;
            }
            bv<T> bvVar = this.a;
            if (bvVar == null) {
                bvVar = this.d.a(xv.this, this.e);
                this.a = bvVar;
            }
            bvVar.write(ixVar, t);
        }
    }

    @Override // defpackage.cv
    public <T> bv<T> a(lu luVar, fx<T> fxVar) {
        Class<? super T> cls = fxVar.a;
        boolean a2 = a(cls);
        boolean z = a2 || a((Class<?>) cls, true);
        boolean z2 = a2 || a((Class<?>) cls, false);
        if (z || z2) {
            return new a(z2, z, luVar, fxVar);
        }
        return null;
    }

    public final boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public final boolean c(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: clone  reason: collision with other method in class */
    public xv m5clone() {
        try {
            return (xv) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Object clone() {
        try {
            return (xv) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean a(Class<?> cls) {
        if (this.c == -1.0d || a((gv) cls.getAnnotation(gv.class), (hv) cls.getAnnotation(hv.class))) {
            return (!this.e && c(cls)) || b(cls);
        }
        return true;
    }

    public final boolean a(Class<?> cls, boolean z) {
        for (cu cuVar : z ? this.g : this.h) {
            if (cuVar.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(gv gvVar, hv hvVar) {
        if (gvVar == null || gvVar.value() <= this.c) {
            return hvVar == null || (hvVar.value() > this.c ? 1 : (hvVar.value() == this.c ? 0 : -1)) > 0;
        }
        return false;
    }
}
