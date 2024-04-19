package defpackage;

import java.io.Writer;
/* compiled from: Streams.java */
/* renamed from: dw  reason: default package */
/* loaded from: classes.dex */
public final class dw extends Writer {
    public final Appendable c;
    public final a d = new a();

    /* compiled from: Streams.java */
    /* renamed from: dw$a */
    /* loaded from: classes.dex */
    public static class a implements CharSequence {
        public char[] c;

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.c[i];
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.c.length;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return new String(this.c, i, i2 - i);
        }
    }

    public dw(Appendable appendable) {
        this.c = appendable;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        a aVar = this.d;
        aVar.c = cArr;
        this.c.append(aVar, i, i2 + i);
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.c.append((char) i);
    }
}
