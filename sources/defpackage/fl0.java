package defpackage;

import java.util.Arrays;
/* compiled from: SegmentedByteString.java */
/* renamed from: fl0  reason: default package */
/* loaded from: classes.dex */
public final class fl0 extends cl0 {
    public final transient byte[][] h;
    public final transient int[] i;

    public fl0(zk0 zk0Var, int i) {
        super(null);
        gl0.a(zk0Var.d, 0L, i);
        int i2 = 0;
        dl0 dl0Var = zk0Var.c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = dl0Var.c;
            int i6 = dl0Var.b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                dl0Var = dl0Var.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.h = new byte[i4];
        this.i = new int[i4 * 2];
        dl0 dl0Var2 = zk0Var.c;
        int i7 = 0;
        while (i2 < i) {
            this.h[i7] = dl0Var2.a;
            i2 += dl0Var2.c - dl0Var2.b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.i;
            iArr[i7] = i2;
            iArr[this.h.length + i7] = dl0Var2.b;
            dl0Var2.d = true;
            i7++;
            dl0Var2 = dl0Var2.f;
        }
    }

    @Override // defpackage.cl0
    public String a() {
        return d().a();
    }

    public final int b(int i) {
        int binarySearch = Arrays.binarySearch(this.i, 0, this.h.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // defpackage.cl0
    public String c() {
        return d().c();
    }

    public final cl0 d() {
        int[] iArr = this.i;
        byte[][] bArr = this.h;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.i;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.h[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return new cl0(bArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.cl0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 != r11) goto L4
            return r0
        L4:
            boolean r1 = r12 instanceof defpackage.cl0
            r2 = 0
            if (r1 == 0) goto L5d
            cl0 r12 = (defpackage.cl0) r12
            int r1 = r12.b()
            int r3 = r11.b()
            if (r1 != r3) goto L5d
            int r1 = r11.b()
            int r3 = r11.b()
            int r3 = r3 - r1
            if (r3 >= 0) goto L22
        L20:
            r12 = r2
            goto L5a
        L22:
            int r3 = r11.b(r2)
            r4 = r2
            r5 = r4
        L28:
            if (r1 <= 0) goto L59
            if (r3 != 0) goto L2e
            r6 = r2
            goto L34
        L2e:
            int[] r6 = r11.i
            int r7 = r3 + (-1)
            r6 = r6[r7]
        L34:
            int[] r7 = r11.i
            r7 = r7[r3]
            int r7 = r7 - r6
            int r7 = r7 + r6
            int r7 = r7 - r4
            int r7 = java.lang.Math.min(r1, r7)
            int[] r8 = r11.i
            byte[][] r9 = r11.h
            int r10 = r9.length
            int r10 = r10 + r3
            r8 = r8[r10]
            int r6 = r4 - r6
            int r6 = r6 + r8
            r8 = r9[r3]
            boolean r6 = r12.a(r5, r8, r6, r7)
            if (r6 != 0) goto L53
            goto L20
        L53:
            int r4 = r4 + r7
            int r5 = r5 + r7
            int r1 = r1 - r7
            int r3 = r3 + 1
            goto L28
        L59:
            r12 = r0
        L5a:
            if (r12 == 0) goto L5d
            goto L5e
        L5d:
            r0 = r2
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fl0.equals(java.lang.Object):boolean");
    }

    @Override // defpackage.cl0
    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.h.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.h[i2];
            int[] iArr = this.i;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.d = i3;
        return i3;
    }

    @Override // defpackage.cl0
    public String toString() {
        return d().toString();
    }

    @Override // defpackage.cl0
    public cl0 a(int i, int i2) {
        return d().a(i, i2);
    }

    @Override // defpackage.cl0
    public int b() {
        return this.i[this.h.length - 1];
    }

    @Override // defpackage.cl0
    public byte a(int i) {
        gl0.a(this.i[this.h.length - 1], i, 1L);
        int b = b(i);
        int i2 = b == 0 ? 0 : this.i[b - 1];
        int[] iArr = this.i;
        byte[][] bArr = this.h;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    @Override // defpackage.cl0
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > b() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.i[b - 1];
            int min = Math.min(i3, ((this.i[b] - i4) + i4) - i);
            int[] iArr = this.i;
            byte[][] bArr2 = this.h;
            if (!gl0.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }
}
