package defpackage;

import java.io.FilterInputStream;
import java.io.InputStream;
/* compiled from: MarkEnforcingInputStream.java */
/* renamed from: qq  reason: default package */
/* loaded from: classes.dex */
public class qq extends FilterInputStream {
    public int c;

    public qq(InputStream inputStream) {
        super(inputStream);
        this.c = Integer.MIN_VALUE;
    }

    public final long a(long j) {
        int i = this.c;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.c;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    public final void b(long j) {
        int i = this.c;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.c = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.c = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.c = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long a = a(j);
        if (a == -1) {
            return 0L;
        }
        long skip = super.skip(a);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int a = (int) a(i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        b(read);
        return read;
    }
}
