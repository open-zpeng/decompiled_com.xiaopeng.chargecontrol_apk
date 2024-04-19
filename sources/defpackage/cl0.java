package defpackage;

import java.io.Serializable;
import java.util.Arrays;
/* compiled from: ByteString.java */
/* renamed from: cl0  reason: default package */
/* loaded from: classes.dex */
public class cl0 implements Serializable, Comparable<cl0> {
    public static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final cl0 g = a(new byte[0]);
    public final byte[] c;
    public transient int d;
    public transient String e;

    public cl0(byte[] bArr) {
        this.c = bArr;
    }

    public static cl0 a(byte... bArr) {
        if (bArr != null) {
            return new cl0((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public int b() {
        return this.c.length;
    }

    public String c() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, gl0.a);
        this.e = str2;
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(defpackage.cl0 r10) {
        /*
            r9 = this;
            cl0 r10 = (defpackage.cl0) r10
            int r0 = r9.b()
            int r1 = r10.b()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L10:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.a(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.a(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L25
            int r4 = r4 + 1
            goto L10
        L25:
            if (r7 >= r8) goto L29
        L27:
            r3 = r5
            goto L31
        L29:
            r3 = r6
            goto L31
        L2b:
            if (r0 != r1) goto L2e
            goto L31
        L2e:
            if (r0 >= r1) goto L29
            goto L27
        L31:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cl0.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cl0) {
            cl0 cl0Var = (cl0) obj;
            int b = cl0Var.b();
            byte[] bArr = this.c;
            if (b == bArr.length && cl0Var.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String c = c();
        int length = c.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = c.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = c.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i == -1) {
            if (this.c.length <= 64) {
                StringBuilder a = jg.a("[hex=");
                a.append(a());
                a.append("]");
                return a.toString();
            }
            StringBuilder a2 = jg.a("[size=");
            a2.append(this.c.length);
            a2.append(" hex=");
            a2.append(a(0, 64).a());
            a2.append("…]");
            return a2.toString();
        }
        String replace = c.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i < c.length()) {
            StringBuilder a3 = jg.a("[size=");
            a3.append(this.c.length);
            a3.append(" text=");
            a3.append(replace);
            a3.append("…]");
            return a3.toString();
        }
        return jg.b("[text=", replace, "]");
    }

    public String a() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static cl0 a(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                byte[] bArr = new byte[str.length() / 2];
                for (int i = 0; i < bArr.length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (a(str.charAt(i2 + 1)) + (a(str.charAt(i2)) << 4));
                }
                return a(bArr);
            }
            throw new IllegalArgumentException(jg.a("Unexpected hex string: ", str));
        }
        throw new IllegalArgumentException("hex == null");
    }

    public static int a(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    public cl0 a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.c;
            if (i2 > bArr.length) {
                StringBuilder a = jg.a("endIndex > length(");
                a.append(this.c.length);
                a.append(")");
                throw new IllegalArgumentException(a.toString());
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.c, i, bArr2, 0, i3);
                return new cl0(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte a(int i) {
        return this.c[i];
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && gl0.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }
}
