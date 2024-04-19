package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
/* compiled from: JsonWriter.java */
/* renamed from: ix  reason: default package */
/* loaded from: classes.dex */
public class ix implements Closeable, Flushable {
    public static final String[] l = new String[128];
    public static final String[] m;
    public final Writer c;
    public int[] d = new int[32];
    public int e = 0;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            l[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = l;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        m = (String[]) strArr.clone();
        String[] strArr2 = m;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public ix(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        if (writer != null) {
            this.c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final ix a(int i, int i2, char c) {
        int h = h();
        if (h != i2 && h != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.e--;
            if (h == i2) {
                f();
            }
            this.c.write(c);
            return this;
        }
        StringBuilder a = jg.a("Dangling name: ");
        a.append(this.j);
        throw new IllegalStateException(a.toString());
    }

    public ix b() {
        i();
        a();
        a(1);
        this.c.write(91);
        return this;
    }

    public ix c() {
        i();
        a();
        a(3);
        this.c.write(123);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
        int i = this.e;
        if (i <= 1 && (i != 1 || this.d[i - 1] == 7)) {
            this.e = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public ix d() {
        a(1, 2, ']');
        return this;
    }

    public ix e() {
        a(3, 5, '}');
        return this;
    }

    public final void f() {
        if (this.f == null) {
            return;
        }
        this.c.write(10);
        int i = this.e;
        for (int i2 = 1; i2 < i; i2++) {
            this.c.write(this.f);
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.e != 0) {
            this.c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public ix g() {
        if (this.j != null) {
            if (this.k) {
                i();
            } else {
                this.j = null;
                return this;
            }
        }
        a();
        this.c.write("null");
        return this;
    }

    public final int h() {
        int i = this.e;
        if (i != 0) {
            return this.d[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void i() {
        if (this.j != null) {
            int h = h();
            if (h == 5) {
                this.c.write(44);
            } else if (h != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            f();
            b(4);
            b(this.j);
            this.j = null;
        }
    }

    public final void b(int i) {
        this.d[this.e - 1] = i;
    }

    public ix c(String str) {
        if (str == null) {
            return g();
        }
        i();
        a();
        b(str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = defpackage.ix.m
            goto L9
        L7:
            java.lang.String[] r0 = defpackage.ix.l
        L9:
            java.io.Writer r1 = r8.c
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ix.b(java.lang.String):void");
    }

    public final void a(int i) {
        int i2 = this.e;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            this.d = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        iArr2[i3] = i;
    }

    public ix a(String str) {
        if (str != null) {
            if (this.j == null) {
                if (this.e != 0) {
                    this.j = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public ix a(boolean z) {
        i();
        a();
        this.c.write(z ? "true" : "false");
        return this;
    }

    public ix a(Boolean bool) {
        if (bool == null) {
            return g();
        }
        i();
        a();
        this.c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public ix a(long j) {
        i();
        a();
        this.c.write(Long.toString(j));
        return this;
    }

    public ix a(Number number) {
        if (number == null) {
            return g();
        }
        i();
        String obj = number.toString();
        if (!this.h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        a();
        this.c.append((CharSequence) obj);
        return this;
    }

    public final void a() {
        int h = h();
        if (h == 1) {
            b(2);
            f();
        } else if (h == 2) {
            this.c.append(',');
            f();
        } else if (h != 4) {
            if (h != 6) {
                if (h == 7) {
                    if (!this.h) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            b(7);
        } else {
            this.c.append((CharSequence) this.g);
            b(5);
        }
    }
}
