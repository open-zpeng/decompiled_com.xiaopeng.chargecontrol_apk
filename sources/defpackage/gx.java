package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
/* compiled from: JsonReader.java */
/* renamed from: gx  reason: default package */
/* loaded from: classes.dex */
public class gx implements Closeable {
    public static final char[] r = ")]}'\n".toCharArray();
    public final Reader c;
    public long k;
    public int l;
    public String m;
    public int o;
    public String[] p;
    public int[] q;
    public boolean d = false;
    public final char[] e = new char[1024];
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int[] n = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: gx$a */
    /* loaded from: classes.dex */
    public class a extends zv {
        @Override // defpackage.zv
        public void a(gx gxVar) {
            if (gxVar instanceof nw) {
                ((nw) gxVar).y();
                return;
            }
            int i = gxVar.j;
            if (i == 0) {
                i = gxVar.d();
            }
            if (i == 13) {
                gxVar.j = 9;
            } else if (i == 12) {
                gxVar.j = 8;
            } else if (i == 14) {
                gxVar.j = 10;
            } else {
                StringBuilder a = jg.a("Expected a name but was ");
                a.append(gxVar.s());
                a.append(gxVar.j());
                throw new IllegalStateException(a.toString());
            }
        }
    }

    static {
        zv.a = new a();
    }

    public gx(Reader reader) {
        this.o = 0;
        int[] iArr = this.n;
        int i = this.o;
        this.o = i + 1;
        iArr[i] = 6;
        this.p = new String[32];
        this.q = new int[32];
        if (reader != null) {
            this.c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public void a() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 3) {
            b(1);
            this.q[this.o - 1] = 0;
            this.j = 0;
            return;
        }
        StringBuilder a2 = jg.a("Expected BEGIN_ARRAY but was ");
        a2.append(s());
        a2.append(j());
        throw new IllegalStateException(a2.toString());
    }

    public void b() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 1) {
            b(3);
            this.j = 0;
            return;
        }
        StringBuilder a2 = jg.a("Expected BEGIN_OBJECT but was ");
        a2.append(s());
        a2.append(j());
        throw new IllegalStateException(a2.toString());
    }

    public final void c(char c) {
        char[] cArr = this.e;
        do {
            int i = this.f;
            int i2 = this.g;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f = i3;
                    t();
                    i = this.f;
                    i2 = this.g;
                } else {
                    if (c2 == '\n') {
                        this.h++;
                        this.i = i3;
                    }
                    i = i3;
                }
            }
            this.f = i;
        } while (a(1));
        a("Unterminated string");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.j = 0;
        this.n[0] = 8;
        this.o = 1;
        this.c.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x0219, code lost:
        if (a(r4) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x021b, code lost:
        if (r14 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x021d, code lost:
        if (r15 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0223, code lost:
        if (r10 != Long.MIN_VALUE) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0225, code lost:
        if (r16 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x022b, code lost:
        if (r10 != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x022d, code lost:
        if (r16 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x022f, code lost:
        if (r16 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0232, code lost:
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0233, code lost:
        r20.k = r10;
        r20.f += r3;
        r4 = 15;
        r20.j = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x023f, code lost:
        if (r14 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0242, code lost:
        if (r14 == 4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0245, code lost:
        if (r14 != 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0247, code lost:
        r20.l = r3;
        r4 = 16;
        r20.j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x024d, code lost:
        r17 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x017b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0276 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0277  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d() {
        /*
            Method dump skipped, instructions count: 827
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gx.d():int");
    }

    public void e() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 4) {
            this.o--;
            int[] iArr = this.q;
            int i2 = this.o - 1;
            iArr[i2] = iArr[i2] + 1;
            this.j = 0;
            return;
        }
        StringBuilder a2 = jg.a("Expected END_ARRAY but was ");
        a2.append(s());
        a2.append(j());
        throw new IllegalStateException(a2.toString());
    }

    public void f() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 2) {
            this.o--;
            String[] strArr = this.p;
            int i2 = this.o;
            strArr[i2] = null;
            int[] iArr = this.q;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.j = 0;
            return;
        }
        StringBuilder a2 = jg.a("Expected END_OBJECT but was ");
        a2.append(s());
        a2.append(j());
        throw new IllegalStateException(a2.toString());
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.o;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.n[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.q[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.p;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    public boolean h() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean i() {
        return this.d;
    }

    public String j() {
        StringBuilder a2 = jg.a(" at line ", this.h + 1, " column ", (this.f - this.i) + 1, " path ");
        a2.append(g());
        return a2.toString();
    }

    public boolean k() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 5) {
            this.j = 0;
            int[] iArr = this.q;
            int i2 = this.o - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.j = 0;
            int[] iArr2 = this.q;
            int i3 = this.o - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder a2 = jg.a("Expected a boolean but was ");
            a2.append(s());
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
    }

    public double l() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 15) {
            this.j = 0;
            int[] iArr = this.q;
            int i2 = this.o - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.k;
        }
        if (i == 16) {
            this.m = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else if (i == 8 || i == 9) {
            this.m = b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.m = r();
        } else if (i != 11) {
            StringBuilder a2 = jg.a("Expected a double but was ");
            a2.append(s());
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        this.j = 11;
        double parseDouble = Double.parseDouble(this.m);
        if (!this.d && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new jx("JSON forbids NaN and infinities: " + parseDouble + j());
        }
        this.m = null;
        this.j = 0;
        int[] iArr2 = this.q;
        int i3 = this.o - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public int m() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 15) {
            long j = this.k;
            int i2 = (int) j;
            if (j == i2) {
                this.j = 0;
                int[] iArr = this.q;
                int i3 = this.o - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            StringBuilder a2 = jg.a("Expected an int but was ");
            a2.append(this.k);
            a2.append(j());
            throw new NumberFormatException(a2.toString());
        }
        if (i == 16) {
            this.m = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else if (i != 8 && i != 9 && i != 10) {
            StringBuilder a3 = jg.a("Expected an int but was ");
            a3.append(s());
            a3.append(j());
            throw new IllegalStateException(a3.toString());
        } else {
            if (i == 10) {
                this.m = r();
            } else {
                this.m = b(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.m);
                this.j = 0;
                int[] iArr2 = this.q;
                int i4 = this.o - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.j = 11;
        double parseDouble = Double.parseDouble(this.m);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.m = null;
            this.j = 0;
            int[] iArr3 = this.q;
            int i6 = this.o - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        StringBuilder a4 = jg.a("Expected an int but was ");
        a4.append(this.m);
        a4.append(j());
        throw new NumberFormatException(a4.toString());
    }

    public long n() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 15) {
            this.j = 0;
            int[] iArr = this.q;
            int i2 = this.o - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.k;
        }
        if (i == 16) {
            this.m = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else if (i != 8 && i != 9 && i != 10) {
            StringBuilder a2 = jg.a("Expected a long but was ");
            a2.append(s());
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        } else {
            if (i == 10) {
                this.m = r();
            } else {
                this.m = b(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.m);
                this.j = 0;
                int[] iArr2 = this.q;
                int i3 = this.o - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.j = 11;
        double parseDouble = Double.parseDouble(this.m);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.m = null;
            this.j = 0;
            int[] iArr3 = this.q;
            int i4 = this.o - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        StringBuilder a3 = jg.a("Expected a long but was ");
        a3.append(this.m);
        a3.append(j());
        throw new NumberFormatException(a3.toString());
    }

    public String o() {
        String b;
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 14) {
            b = r();
        } else if (i == 12) {
            b = b('\'');
        } else if (i == 13) {
            b = b('\"');
        } else {
            StringBuilder a2 = jg.a("Expected a name but was ");
            a2.append(s());
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        this.j = 0;
        this.p[this.o - 1] = b;
        return b;
    }

    public void p() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 7) {
            this.j = 0;
            int[] iArr = this.q;
            int i2 = this.o - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        StringBuilder a2 = jg.a("Expected null but was ");
        a2.append(s());
        a2.append(j());
        throw new IllegalStateException(a2.toString());
    }

    public String q() {
        String str;
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        if (i == 10) {
            str = r();
        } else if (i == 8) {
            str = b('\'');
        } else if (i == 9) {
            str = b('\"');
        } else if (i == 11) {
            str = this.m;
            this.m = null;
        } else if (i == 15) {
            str = Long.toString(this.k);
        } else if (i == 16) {
            str = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else {
            StringBuilder a2 = jg.a("Expected a string but was ");
            a2.append(s());
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        this.j = 0;
        int[] iArr = this.q;
        int i2 = this.o - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
        c();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String r() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = r0
        L4:
            int r3 = r6.f
            int r4 = r3 + r1
            int r5 = r6.g
            if (r4 >= r5) goto L4f
            char[] r4 = r6.e
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5d
            r4 = 10
            if (r3 == r4) goto L5d
            r4 = 12
            if (r3 == r4) goto L5d
            r4 = 13
            if (r3 == r4) goto L5d
            r4 = 32
            if (r3 == r4) goto L5d
            r4 = 35
            if (r3 == r4) goto L4b
            r4 = 44
            if (r3 == r4) goto L5d
            r4 = 47
            if (r3 == r4) goto L4b
            r4 = 61
            if (r3 == r4) goto L4b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5d
            r4 = 58
            if (r3 == r4) goto L5d
            r4 = 59
            if (r3 == r4) goto L4b
            switch(r3) {
                case 91: goto L5d;
                case 92: goto L4b;
                case 93: goto L5d;
                default: goto L48;
            }
        L48:
            int r1 = r1 + 1
            goto L4
        L4b:
            r6.c()
            goto L5d
        L4f:
            char[] r3 = r6.e
            int r3 = r3.length
            if (r1 >= r3) goto L5f
            int r3 = r1 + 1
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L5d
            goto L4
        L5d:
            r0 = r1
            goto L7f
        L5f:
            if (r2 != 0) goto L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L6c:
            char[] r3 = r6.e
            int r4 = r6.f
            r2.append(r3, r4, r1)
            int r3 = r6.f
            int r3 = r3 + r1
            r6.f = r3
            r1 = 1
            boolean r1 = r6.a(r1)
            if (r1 != 0) goto L3
        L7f:
            if (r2 != 0) goto L8b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.e
            int r3 = r6.f
            r1.<init>(r2, r3, r0)
            goto L96
        L8b:
            char[] r1 = r6.e
            int r3 = r6.f
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L96:
            int r2 = r6.f
            int r2 = r2 + r0
            r6.f = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gx.r():java.lang.String");
    }

    public hx s() {
        int i = this.j;
        if (i == 0) {
            i = d();
        }
        switch (i) {
            case 1:
                return hx.BEGIN_OBJECT;
            case 2:
                return hx.END_OBJECT;
            case 3:
                return hx.BEGIN_ARRAY;
            case 4:
                return hx.END_ARRAY;
            case 5:
            case 6:
                return hx.BOOLEAN;
            case 7:
                return hx.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return hx.STRING;
            case 12:
            case 13:
            case 14:
                return hx.NAME;
            case 15:
            case 16:
                return hx.NUMBER;
            case 17:
                return hx.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final char t() {
        int i;
        int i2;
        if (this.f == this.g && !a(1)) {
            a("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.e;
        int i3 = this.f;
        this.f = i3 + 1;
        char c = cArr[i3];
        if (c == '\n') {
            this.h++;
            this.i = this.f;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c != 'b') {
                if (c != 'f') {
                    if (c != 'n') {
                        if (c != 'r') {
                            if (c != 't') {
                                if (c == 'u') {
                                    if (this.f + 4 > this.g && !a(4)) {
                                        a("Unterminated escape sequence");
                                        throw null;
                                    }
                                    char c2 = 0;
                                    int i4 = this.f;
                                    int i5 = i4 + 4;
                                    while (i4 < i5) {
                                        char c3 = this.e[i4];
                                        char c4 = (char) (c2 << 4);
                                        if (c3 < '0' || c3 > '9') {
                                            if (c3 >= 'a' && c3 <= 'f') {
                                                i = c3 - 'a';
                                            } else if (c3 < 'A' || c3 > 'F') {
                                                StringBuilder a2 = jg.a("\\u");
                                                a2.append(new String(this.e, this.f, 4));
                                                throw new NumberFormatException(a2.toString());
                                            } else {
                                                i = c3 - 'A';
                                            }
                                            i2 = i + 10;
                                        } else {
                                            i2 = c3 - '0';
                                        }
                                        c2 = (char) (i2 + c4);
                                        i4++;
                                    }
                                    this.f += 4;
                                    return c2;
                                }
                                a("Invalid escape sequence");
                                throw null;
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c;
    }

    public String toString() {
        return getClass().getSimpleName() + j();
    }

    public final void u() {
        char c;
        do {
            if (this.f >= this.g && !a(1)) {
                return;
            }
            char[] cArr = this.e;
            int i = this.f;
            this.f = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.h++;
                this.i = this.f;
                return;
            }
        } while (c != '\r');
    }

    public void v() {
        int i = 0;
        do {
            int i2 = this.j;
            if (i2 == 0) {
                i2 = d();
            }
            if (i2 == 3) {
                b(1);
            } else if (i2 == 1) {
                b(3);
            } else {
                if (i2 == 4) {
                    this.o--;
                } else if (i2 == 2) {
                    this.o--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        do {
                            int i3 = 0;
                            while (true) {
                                int i4 = this.f + i3;
                                if (i4 < this.g) {
                                    char c = this.e[i4];
                                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                                        if (c != '#') {
                                            if (c != ',') {
                                                if (c != '/' && c != '=') {
                                                    if (c != '{' && c != '}' && c != ':') {
                                                        if (c != ';') {
                                                            switch (c) {
                                                                case '[':
                                                                case ']':
                                                                    break;
                                                                case '\\':
                                                                    break;
                                                                default:
                                                                    i3++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    this.f = i4;
                                }
                            }
                            c();
                            this.f += i3;
                        } while (a(1));
                    } else if (i2 == 8 || i2 == 12) {
                        c('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        c('\"');
                    } else if (i2 == 16) {
                        this.f += this.l;
                    }
                    this.j = 0;
                }
                i--;
                this.j = 0;
            }
            i++;
            this.j = 0;
        } while (i != 0);
        int[] iArr = this.q;
        int i5 = this.o;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.p[i5 - 1] = "null";
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r2 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r5) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r2.append(r0, r5, r3 - r5);
        r10.f = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(char r11) {
        /*
            r10 = this;
            char[] r0 = r10.e
            r1 = 0
            r2 = r1
        L4:
            int r3 = r10.f
            int r4 = r10.g
        L8:
            r5 = r3
        L9:
            r6 = 16
            r7 = 1
            if (r3 >= r4) goto L5c
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L28
            r10.f = r8
            int r8 = r8 - r5
            int r8 = r8 - r7
            if (r2 != 0) goto L20
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r5, r8)
            return r11
        L20:
            r2.append(r0, r5, r8)
            java.lang.String r11 = r2.toString()
            return r11
        L28:
            r9 = 92
            if (r3 != r9) goto L4f
            r10.f = r8
            int r8 = r8 - r5
            int r8 = r8 - r7
            if (r2 != 0) goto L40
            int r2 = r8 + 1
            int r2 = r2 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r3.<init>(r2)
            r2 = r3
        L40:
            r2.append(r0, r5, r8)
            char r3 = r10.t()
            r2.append(r3)
            int r3 = r10.f
            int r4 = r10.g
            goto L8
        L4f:
            r6 = 10
            if (r3 != r6) goto L5a
            int r3 = r10.h
            int r3 = r3 + r7
            r10.h = r3
            r10.i = r8
        L5a:
            r3 = r8
            goto L9
        L5c:
            if (r2 != 0) goto L6c
            int r2 = r3 - r5
            int r2 = r2 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r4.<init>(r2)
            r2 = r4
        L6c:
            int r4 = r3 - r5
            r2.append(r0, r5, r4)
            r10.f = r3
            boolean r3 = r10.a(r7)
            if (r3 == 0) goto L7a
            goto L4
        L7a:
            java.lang.String r11 = "Unterminated string"
            r10.a(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gx.b(char):java.lang.String");
    }

    public final boolean a(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    public final boolean a(int i) {
        int i2;
        char[] cArr = this.e;
        int i3 = this.i;
        int i4 = this.f;
        this.i = i3 - i4;
        int i5 = this.g;
        if (i5 != i4) {
            this.g = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            Reader reader = this.c;
            int i6 = this.g;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.g += read;
            if (this.h == 0 && (i2 = this.i) == 0 && this.g > 0 && cArr[0] == 65279) {
                this.f++;
                this.i = i2 + 1;
                i++;
            }
        } while (this.g < i);
        return true;
    }

    public final void c() {
        if (this.d) {
            return;
        }
        a("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final int a(boolean z) {
        char[] cArr = this.e;
        int i = this.f;
        int i2 = this.g;
        while (true) {
            boolean z2 = true;
            if (i == i2) {
                this.f = i;
                if (!a(1)) {
                    if (z) {
                        StringBuilder a2 = jg.a("End of input");
                        a2.append(j());
                        throw new EOFException(a2.toString());
                    }
                    return -1;
                }
                i = this.f;
                i2 = this.g;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.h++;
                this.i = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f = i3;
                    if (i3 == i2) {
                        this.f--;
                        boolean a3 = a(2);
                        this.f++;
                        if (!a3) {
                            return c;
                        }
                    }
                    c();
                    int i4 = this.f;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.f = i4 + 1;
                        while (true) {
                            if (this.f + 2 > this.g && !a(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.e;
                            int i5 = this.f;
                            if (cArr2[i5] != '\n') {
                                for (int i6 = 0; i6 < 2; i6++) {
                                    if (this.e[this.f + i6] != "*/".charAt(i6)) {
                                        break;
                                    }
                                }
                                break;
                            }
                            this.h++;
                            this.i = i5 + 1;
                            this.f++;
                        }
                        if (z2) {
                            i = this.f + 2;
                            i2 = this.g;
                        } else {
                            a("Unterminated comment");
                            throw null;
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.f = i4 + 1;
                        u();
                        i = this.f;
                        i2 = this.g;
                    }
                } else if (c == '#') {
                    this.f = i3;
                    c();
                    u();
                    i = this.f;
                    i2 = this.g;
                } else {
                    this.f = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    public final void b(int i) {
        int i2 = this.o;
        int[] iArr = this.n;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.n = Arrays.copyOf(iArr, i3);
            this.q = Arrays.copyOf(this.q, i3);
            this.p = (String[]) Arrays.copyOf(this.p, i3);
        }
        int[] iArr2 = this.n;
        int i4 = this.o;
        this.o = i4 + 1;
        iArr2[i4] = i;
    }

    public final IOException a(String str) {
        StringBuilder a2 = jg.a(str);
        a2.append(j());
        throw new jx(a2.toString());
    }
}
