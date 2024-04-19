package defpackage;

import java.io.FilterInputStream;
import java.io.InputStream;
/* compiled from: ExifOrientationStream.java */
/* renamed from: mi  reason: default package */
/* loaded from: classes.dex */
public final class mi extends FilterInputStream {
    public static final byte[] e = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    public static final int f = e.length;
    public static final int g = f + 2;
    public final byte c;
    public int d;

    public mi(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.c = (byte) i;
            return;
        }
        throw new IllegalArgumentException(jg.a("Cannot add invalid orientation: ", i));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read;
        int i;
        int i2 = this.d;
        if (i2 < 2 || i2 > (i = g)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.c;
        } else {
            read = e[i2 - 2] & 255;
        }
        if (read != -1) {
            this.d++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.d = (int) (this.d + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.d;
        int i5 = g;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.c;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(e, this.d - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.d += i3;
        }
        return i3;
    }
}
