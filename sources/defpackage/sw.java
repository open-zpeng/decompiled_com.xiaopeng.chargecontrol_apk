package defpackage;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: sw  reason: default package */
/* loaded from: classes.dex */
public final class sw implements cv {
    public final pv c;
    public final fu d;
    public final xv e;
    public final mw f;
    public final dx g = dx.a;

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: sw$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends bv<T> {
        public final cw<T> a;
        public final Map<String, b> b;

        public a(cw<T> cwVar, Map<String, b> map) {
            this.a = cwVar;
            this.b = map;
        }

        @Override // defpackage.bv
        public T read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            T a = this.a.a();
            try {
                gxVar.b();
                while (gxVar.h()) {
                    b bVar = this.b.get(gxVar.o());
                    if (bVar != null && bVar.c) {
                        rw rwVar = (rw) bVar;
                        Object read = rwVar.f.read(gxVar);
                        if (read != null || !rwVar.i) {
                            rwVar.d.set(a, read);
                        }
                    }
                    gxVar.v();
                }
                gxVar.f();
                return a;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new zu(e2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
            r7.a(r1.a);
            r1 = (defpackage.rw) r1;
            r2 = r1.d.get(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
            if (r1.e == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
            r1 = r1.f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
            r1 = new defpackage.ww(r1.g, r1.f, r1.h.b);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
            r1.write(r7, r2);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v7, types: [bv] */
        /* JADX WARN: Type inference failed for: r1v8, types: [bv] */
        @Override // defpackage.bv
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void write(defpackage.ix r7, T r8) {
            /*
                r6 = this;
                if (r8 != 0) goto L6
                r7.g()
                return
            L6:
                r7.c()
                java.util.Map<java.lang.String, sw$b> r0 = r6.b     // Catch: java.lang.IllegalAccessException -> L5d
                java.util.Collection r0 = r0.values()     // Catch: java.lang.IllegalAccessException -> L5d
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.IllegalAccessException -> L5d
            L13:
                boolean r1 = r0.hasNext()     // Catch: java.lang.IllegalAccessException -> L5d
                if (r1 == 0) goto L59
                java.lang.Object r1 = r0.next()     // Catch: java.lang.IllegalAccessException -> L5d
                sw$b r1 = (defpackage.sw.b) r1     // Catch: java.lang.IllegalAccessException -> L5d
                r2 = r1
                rw r2 = (defpackage.rw) r2     // Catch: java.lang.IllegalAccessException -> L5d
                boolean r3 = r2.b     // Catch: java.lang.IllegalAccessException -> L5d
                r4 = 0
                if (r3 != 0) goto L28
                goto L31
            L28:
                java.lang.reflect.Field r2 = r2.d     // Catch: java.lang.IllegalAccessException -> L5d
                java.lang.Object r2 = r2.get(r8)     // Catch: java.lang.IllegalAccessException -> L5d
                if (r2 == r8) goto L31
                r4 = 1
            L31:
                if (r4 == 0) goto L13
                java.lang.String r2 = r1.a     // Catch: java.lang.IllegalAccessException -> L5d
                r7.a(r2)     // Catch: java.lang.IllegalAccessException -> L5d
                rw r1 = (defpackage.rw) r1     // Catch: java.lang.IllegalAccessException -> L5d
                java.lang.reflect.Field r2 = r1.d     // Catch: java.lang.IllegalAccessException -> L5d
                java.lang.Object r2 = r2.get(r8)     // Catch: java.lang.IllegalAccessException -> L5d
                boolean r3 = r1.e     // Catch: java.lang.IllegalAccessException -> L5d
                if (r3 == 0) goto L47
                bv r1 = r1.f     // Catch: java.lang.IllegalAccessException -> L5d
                goto L55
            L47:
                ww r3 = new ww     // Catch: java.lang.IllegalAccessException -> L5d
                lu r4 = r1.g     // Catch: java.lang.IllegalAccessException -> L5d
                bv r5 = r1.f     // Catch: java.lang.IllegalAccessException -> L5d
                fx r1 = r1.h     // Catch: java.lang.IllegalAccessException -> L5d
                java.lang.reflect.Type r1 = r1.b     // Catch: java.lang.IllegalAccessException -> L5d
                r3.<init>(r4, r5, r1)     // Catch: java.lang.IllegalAccessException -> L5d
                r1 = r3
            L55:
                r1.write(r7, r2)     // Catch: java.lang.IllegalAccessException -> L5d
                goto L13
            L59:
                r7.e()
                return
            L5d:
                r7 = move-exception
                java.lang.AssertionError r8 = new java.lang.AssertionError
                r8.<init>(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.sw.a.write(ix, java.lang.Object):void");
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: sw$b */
    /* loaded from: classes.dex */
    public static abstract class b {
        public final String a;
        public final boolean b;
        public final boolean c;

        public b(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }
    }

    public sw(pv pvVar, fu fuVar, xv xvVar, mw mwVar) {
        this.c = pvVar;
        this.d = fuVar;
        this.e = xvVar;
        this.f = mwVar;
    }

    public boolean a(Field field, boolean z) {
        boolean z2;
        dv dvVar;
        xv xvVar = this.e;
        Class<?> type = field.getType();
        if (xvVar.a(type) || xvVar.a(type, z)) {
            return false;
        }
        if ((xvVar.d & field.getModifiers()) != 0 || ((xvVar.c != -1.0d && !xvVar.a((gv) field.getAnnotation(gv.class), (hv) field.getAnnotation(hv.class))) || field.isSynthetic() || ((xvVar.f && ((dvVar = (dv) field.getAnnotation(dv.class)) == null || (!z ? dvVar.deserialize() : dvVar.serialize()))) || ((!xvVar.e && xvVar.c(field.getType())) || xvVar.b(field.getType()))))) {
            z2 = true;
            break;
        }
        List<cu> list = z ? xvVar.g : xvVar.h;
        if (!list.isEmpty()) {
            du duVar = new du(field);
            for (cu cuVar : list) {
                if (cuVar.shouldSkipField(duVar)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return !z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    @Override // defpackage.cv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> defpackage.bv<T> a(defpackage.lu r35, defpackage.fx<T> r36) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sw.a(lu, fx):bv");
    }
}
