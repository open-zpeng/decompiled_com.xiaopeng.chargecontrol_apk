package defpackage;
/* compiled from: TreeTypeAdapter.java */
/* renamed from: vw  reason: default package */
/* loaded from: classes.dex */
public final class vw<T> extends bv<T> {
    public final yu<T> a;
    public final qu<T> b;
    public final lu c;
    public final fx<T> d;
    public final cv e;
    public final vw<T>.b f = new b(this, null);
    public bv<T> g;

    /* compiled from: TreeTypeAdapter.java */
    /* renamed from: vw$b */
    /* loaded from: classes.dex */
    public final class b implements xu, pu {
        public /* synthetic */ b(vw vwVar, a aVar) {
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    /* renamed from: vw$c */
    /* loaded from: classes.dex */
    public static final class c implements cv {
        public final fx<?> c;
        public final boolean d;
        public final Class<?> e;
        public final yu<?> f;
        public final qu<?> g;

        public c(Object obj, fx<?> fxVar, boolean z, Class<?> cls) {
            this.f = obj instanceof yu ? (yu) obj : null;
            this.g = obj instanceof qu ? (qu) obj : null;
            iv.a((this.f == null && this.g == null) ? false : true);
            this.c = fxVar;
            this.d = z;
            this.e = cls;
        }

        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            boolean isAssignableFrom;
            fx<?> fxVar2 = this.c;
            if (fxVar2 != null) {
                isAssignableFrom = fxVar2.equals(fxVar) || (this.d && this.c.b == fxVar.a);
            } else {
                isAssignableFrom = this.e.isAssignableFrom(fxVar.a);
            }
            if (isAssignableFrom) {
                return new vw(this.f, this.g, luVar, fxVar, this);
            }
            return null;
        }
    }

    public vw(yu<T> yuVar, qu<T> quVar, lu luVar, fx<T> fxVar, cv cvVar) {
        this.a = yuVar;
        this.b = quVar;
        this.c = luVar;
        this.d = fxVar;
        this.e = cvVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    @Override // defpackage.bv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public T read(defpackage.gx r4) {
        /*
            r3 = this;
            qu<T> r0 = r3.b
            if (r0 != 0) goto L1a
            bv<T> r0 = r3.g
            if (r0 == 0) goto L9
            goto L15
        L9:
            lu r0 = r3.c
            cv r1 = r3.e
            fx<T> r2 = r3.d
            bv r0 = r0.a(r1, r2)
            r3.g = r0
        L15:
            java.lang.Object r4 = r0.read(r4)
            return r4
        L1a:
            r4.s()     // Catch: java.lang.NumberFormatException -> L29 java.io.IOException -> L30 defpackage.jx -> L37 java.io.EOFException -> L3e
            r0 = 0
            bv<ru> r1 = defpackage.xw.X     // Catch: java.io.EOFException -> L27 java.lang.NumberFormatException -> L29 java.io.IOException -> L30 defpackage.jx -> L37
            java.lang.Object r4 = r1.read(r4)     // Catch: java.io.EOFException -> L27 java.lang.NumberFormatException -> L29 java.io.IOException -> L30 defpackage.jx -> L37
            ru r4 = (defpackage.ru) r4     // Catch: java.io.EOFException -> L27 java.lang.NumberFormatException -> L29 java.io.IOException -> L30 defpackage.jx -> L37
            goto L44
        L27:
            r4 = move-exception
            goto L40
        L29:
            r4 = move-exception
            zu r0 = new zu
            r0.<init>(r4)
            throw r0
        L30:
            r4 = move-exception
            su r0 = new su
            r0.<init>(r4)
            throw r0
        L37:
            r4 = move-exception
            zu r0 = new zu
            r0.<init>(r4)
            throw r0
        L3e:
            r4 = move-exception
            r0 = 1
        L40:
            if (r0 == 0) goto L59
            tu r4 = defpackage.tu.a
        L44:
            boolean r0 = r4.f()
            if (r0 == 0) goto L4c
            r4 = 0
            return r4
        L4c:
            qu<T> r0 = r3.b
            fx<T> r1 = r3.d
            java.lang.reflect.Type r1 = r1.b
            vw<T>$b r2 = r3.f
            java.lang.Object r4 = r0.a(r4, r1, r2)
            return r4
        L59:
            zu r0 = new zu
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vw.read(gx):java.lang.Object");
    }

    @Override // defpackage.bv
    public void write(ix ixVar, T t) {
        yu<T> yuVar = this.a;
        if (yuVar == null) {
            bv<T> bvVar = this.g;
            if (bvVar == null) {
                bvVar = this.c.a(this.e, this.d);
                this.g = bvVar;
            }
            bvVar.write(ixVar, t);
        } else if (t == null) {
            ixVar.g();
        } else {
            xw.X.write(ixVar, yuVar.a(t, this.d.b, this.f));
        }
    }
}
