package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ContentLengthInputStream.java */
/* renamed from: lq  reason: default package */
/* loaded from: classes.dex */
public final class lq extends FilterInputStream {
    public final long c;
    public int d;

    public lq(InputStream inputStream, long j) {
        super(inputStream);
        this.c = j;
    }

    public final int a(int i) {
        if (i >= 0) {
            this.d += i;
        } else if (this.c - this.d > 0) {
            StringBuilder a = jg.a("Failed to read all expected data, expected: ");
            a.append(this.c);
            a.append(", but read: ");
            a.append(this.d);
            throw new IOException(a.toString());
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.c - this.d, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        read = super.read(bArr, i, i2);
        a(read);
        return read;
    }
}
