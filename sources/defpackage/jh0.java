package defpackage;

import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* renamed from: jh0  reason: default package */
/* loaded from: classes.dex */
public final class jh0 implements kh0, uh0 {
    public ik0<kh0> c;
    public volatile boolean d;

    @Override // defpackage.kh0
    public void a() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            ik0<kh0> ik0Var = this.c;
            this.c = null;
            a(ik0Var);
        }
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this.d;
    }

    @Override // defpackage.uh0
    public boolean c(kh0 kh0Var) {
        ai0.a(kh0Var, "disposable is null");
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    ik0<kh0> ik0Var = this.c;
                    if (ik0Var == null) {
                        ik0Var = new ik0<>();
                        this.c = ik0Var;
                    }
                    ik0Var.a((ik0<kh0>) kh0Var);
                    return true;
                }
            }
        }
        kh0Var.a();
        return false;
    }

    @Override // defpackage.uh0
    public boolean b(kh0 kh0Var) {
        if (a(kh0Var)) {
            kh0Var.a();
            return true;
        }
        return false;
    }

    public void a(ik0<kh0> ik0Var) {
        kh0[] kh0VarArr;
        if (ik0Var == null) {
            return;
        }
        ArrayList arrayList = null;
        for (kh0 kh0Var : ik0Var.e) {
            if (kh0Var instanceof kh0) {
                try {
                    kh0Var.a();
                } catch (Throwable th) {
                    z90.c(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw gk0.a((Throwable) arrayList.get(0));
            }
            throw new mh0(arrayList);
        }
    }

    public void c() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            ik0<kh0> ik0Var = this.c;
            this.c = null;
            a(ik0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049 A[Catch: all -> 0x004d, DONT_GENERATE, TryCatch #0 {, blocks: (B:6:0x000c, B:8:0x0010, B:10:0x0012, B:12:0x0016, B:27:0x0049, B:15:0x002a, B:17:0x0030, B:19:0x0035, B:22:0x003c, B:24:0x0042, B:29:0x004b), top: B:34:0x000c }] */
    @Override // defpackage.uh0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(defpackage.kh0 r8) {
        /*
            r7 = this;
            java.lang.String r0 = "disposables is null"
            defpackage.ai0.a(r8, r0)
            boolean r0 = r7.d
            r1 = 0
            if (r0 == 0) goto Lb
            return r1
        Lb:
            monitor-enter(r7)
            boolean r0 = r7.d     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L12
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4d
            return r1
        L12:
            ik0<kh0> r0 = r7.c     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
            T[] r2 = r0.e     // Catch: java.lang.Throwable -> L4d
            int r3 = r0.b     // Catch: java.lang.Throwable -> L4d
            int r4 = r8.hashCode()     // Catch: java.lang.Throwable -> L4d
            int r4 = defpackage.ik0.a(r4)     // Catch: java.lang.Throwable -> L4d
            r4 = r4 & r3
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L4d
            r6 = 1
            if (r5 != 0) goto L2a
        L28:
            r8 = r1
            goto L46
        L2a:
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Throwable -> L4d
            if (r5 == 0) goto L35
            r0.a(r4, r2, r3)     // Catch: java.lang.Throwable -> L4d
        L33:
            r8 = r6
            goto L46
        L35:
            int r4 = r4 + r6
            r4 = r4 & r3
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L4d
            if (r5 != 0) goto L3c
            goto L28
        L3c:
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Throwable -> L4d
            if (r5 == 0) goto L35
            r0.a(r4, r2, r3)     // Catch: java.lang.Throwable -> L4d
            goto L33
        L46:
            if (r8 != 0) goto L49
            goto L4b
        L49:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4d
            return r6
        L4b:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4d
            return r1
        L4d:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4d
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jh0.a(kh0):boolean");
    }
}
