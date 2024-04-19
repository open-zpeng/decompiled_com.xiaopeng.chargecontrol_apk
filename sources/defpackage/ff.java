package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import defpackage.nf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* compiled from: GapWorker.java */
/* renamed from: ff  reason: default package */
/* loaded from: classes.dex */
public final class ff implements Runnable {
    public static final ThreadLocal<ff> g = new ThreadLocal<>();
    public static Comparator<c> h = new a();
    public long d;
    public long e;
    public ArrayList<nf> c = new ArrayList<>();
    public ArrayList<c> f = new ArrayList<>();

    /* compiled from: GapWorker.java */
    /* renamed from: ff$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<c> {
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
            if (r6.d == null) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r0 != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
            return 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
            return -1;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int compare(defpackage.ff.c r6, defpackage.ff.c r7) {
            /*
                r5 = this;
                ff$c r6 = (defpackage.ff.c) r6
                ff$c r7 = (defpackage.ff.c) r7
                nf r0 = r6.d
                r1 = 0
                r2 = 1
                if (r0 != 0) goto Lc
                r0 = r2
                goto Ld
            Lc:
                r0 = r1
            Ld:
                nf r3 = r7.d
                if (r3 != 0) goto L13
                r3 = r2
                goto L14
            L13:
                r3 = r1
            L14:
                r4 = -1
                if (r0 == r3) goto L1f
                nf r6 = r6.d
                if (r6 != 0) goto L1d
            L1b:
                r1 = r2
                goto L39
            L1d:
                r1 = r4
                goto L39
            L1f:
                boolean r0 = r6.a
                boolean r3 = r7.a
                if (r0 == r3) goto L28
                if (r0 == 0) goto L1b
                goto L1d
            L28:
                int r0 = r7.b
                int r2 = r6.b
                int r0 = r0 - r2
                if (r0 == 0) goto L31
                r1 = r0
                goto L39
            L31:
                int r6 = r6.c
                int r7 = r7.c
                int r6 = r6 - r7
                if (r6 == 0) goto L39
                r1 = r6
            L39:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ff.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    /* compiled from: GapWorker.java */
    /* renamed from: ff$c */
    /* loaded from: classes.dex */
    public static class c {
        public boolean a;
        public int b;
        public int c;
        public nf d;
        public int e;
    }

    public void a(nf nfVar, int i, int i2) {
        if (nfVar.isAttachedToWindow() && this.d == 0) {
            this.d = nfVar.getNanoTime();
            nfVar.post(this);
        }
        b bVar = nfVar.h0;
        bVar.a = i;
        bVar.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            n8.a("RV Prefetch");
            if (this.c.isEmpty()) {
                this.d = 0L;
                int i = Build.VERSION.SDK_INT;
                Trace.endSection();
                return;
            }
            int size = this.c.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                nf nfVar = this.c.get(i2);
                if (nfVar.getWindowVisibility() == 0) {
                    j = Math.max(nfVar.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.d = 0L;
                int i3 = Build.VERSION.SDK_INT;
                Trace.endSection();
                return;
            }
            a(TimeUnit.MILLISECONDS.toNanos(j) + this.e);
            this.d = 0L;
            int i4 = Build.VERSION.SDK_INT;
            Trace.endSection();
        } catch (Throwable th) {
            this.d = 0L;
            n8.a();
            throw th;
        }
    }

    public void a(long j) {
        nf nfVar;
        c cVar;
        int size = this.c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            nf nfVar2 = this.c.get(i2);
            if (nfVar2.getWindowVisibility() == 0) {
                nfVar2.h0.a(nfVar2, false);
                i += nfVar2.h0.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            nf nfVar3 = this.c.get(i4);
            if (nfVar3.getWindowVisibility() == 0) {
                b bVar = nfVar3.h0;
                int abs = Math.abs(bVar.b) + Math.abs(bVar.a);
                int i5 = i3;
                for (int i6 = 0; i6 < bVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        cVar = new c();
                        this.f.add(cVar);
                    } else {
                        cVar = this.f.get(i5);
                    }
                    int i7 = bVar.c[i6 + 1];
                    cVar.a = i7 <= abs;
                    cVar.b = abs;
                    cVar.c = i7;
                    cVar.d = nfVar3;
                    cVar.e = bVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, h);
        for (int i8 = 0; i8 < this.f.size(); i8++) {
            c cVar2 = this.f.get(i8);
            if (cVar2.d == null) {
                return;
            }
            nf.c0 a2 = a(cVar2.d, cVar2.e, cVar2.a ? Long.MAX_VALUE : j);
            if (a2 != null && a2.b != null && a2.g() && !a2.h() && (nfVar = a2.b.get()) != null) {
                if (nfVar.F && nfVar.g.b() != 0) {
                    nfVar.U();
                }
                b bVar2 = nfVar.h0;
                bVar2.a(nfVar, true);
                if (bVar2.d != 0) {
                    try {
                        n8.a("RV Nested Prefetch");
                        nf.z zVar = nfVar.i0;
                        nf.f fVar = nfVar.m;
                        zVar.e = 1;
                        zVar.f = fVar.a();
                        zVar.h = false;
                        zVar.i = false;
                        zVar.j = false;
                        for (int i9 = 0; i9 < bVar2.d * 2; i9 += 2) {
                            a(nfVar, bVar2.c[i9], j);
                        }
                        int i10 = Build.VERSION.SDK_INT;
                        Trace.endSection();
                    } catch (Throwable th) {
                        n8.a();
                        throw th;
                    }
                } else {
                    continue;
                }
            }
            cVar2.a = false;
            cVar2.b = 0;
            cVar2.c = 0;
            cVar2.d = null;
            cVar2.e = 0;
        }
    }

    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    /* renamed from: ff$b */
    /* loaded from: classes.dex */
    public static class b implements nf.n.c {
        public int a;
        public int b;
        public int[] c;
        public int d;

        public void a(nf nfVar, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            nf.n nVar = nfVar.n;
            if (nfVar.m == null || nVar == null || !nVar.x()) {
                return;
            }
            if (z) {
                if (!nfVar.f.c()) {
                    nVar.a(nfVar.m.a(), this);
                }
            } else if (!nfVar.F()) {
                nVar.a(this.a, this.b, nfVar.i0, this);
            }
            int i = this.d;
            if (i > nVar.m) {
                nVar.m = i;
                nVar.n = z;
                nfVar.d.d();
            }
        }

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= iArr.length) {
                    this.c = new int[i3 * 2];
                    System.arraycopy(iArr, 0, this.c, 0, iArr.length);
                }
                int[] iArr2 = this.c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final nf.c0 a(nf nfVar, int i, long j) {
        boolean z;
        int b2 = nfVar.g.b();
        int i2 = 0;
        while (true) {
            if (i2 >= b2) {
                z = false;
                break;
            }
            nf.c0 l = nf.l(nfVar.g.d(i2));
            if (l.c == i && !l.h()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        nf.u uVar = nfVar.d;
        try {
            nfVar.O();
            nf.c0 a2 = uVar.a(i, false, j);
            if (a2 != null) {
                if (a2.g() && !a2.h()) {
                    uVar.a(a2.a);
                } else {
                    uVar.a(a2, false);
                }
            }
            return a2;
        } finally {
            nfVar.c(false);
        }
    }
}
