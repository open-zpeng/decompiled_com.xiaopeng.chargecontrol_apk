package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: RecyclableBufferedInputStream.java */
/* renamed from: cn  reason: default package */
/* loaded from: classes.dex */
public class cn extends FilterInputStream {
    public volatile byte[] c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final ck h;

    /* compiled from: RecyclableBufferedInputStream.java */
    /* renamed from: cn$a */
    /* loaded from: classes.dex */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public cn(InputStream inputStream, ck ckVar) {
        super(inputStream);
        this.f = -1;
        this.h = ckVar;
        this.c = (byte[]) ((jk) ckVar).b(65536, byte[].class);
    }

    public static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.e = this.c.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.c != null && inputStream != null) {
        } else {
            c();
            throw null;
        }
        return (this.d - this.g) + inputStream.available();
    }

    public synchronized void b() {
        if (this.c != null) {
            ((jk) this.h).a((jk) this.c);
            this.c = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c != null) {
            ((jk) this.h).a((jk) this.c);
            this.c = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.e = Math.max(this.e, i);
        this.f = this.g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.c;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.g < this.d || a(inputStream, bArr) != -1) {
                if (bArr != this.c && (bArr = this.c) == null) {
                    c();
                    throw null;
                }
                if (this.d - this.g > 0) {
                    int i = this.g;
                    this.g = i + 1;
                    return bArr[i] & 255;
                }
                return -1;
            }
            return -1;
        }
        c();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.c != null) {
            if (-1 != this.f) {
                this.g = this.f;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.g + " markLimit: " + this.e);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.c;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.d - this.g >= j) {
                    this.g = (int) (this.g + j);
                    return j;
                }
                long j2 = this.d - this.g;
                this.g = this.d;
                if (this.f != -1 && j <= this.e) {
                    if (a(inputStream, bArr) == -1) {
                        return j2;
                    }
                    if (this.d - this.g >= j - j2) {
                        this.g = (int) ((this.g + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + this.d) - this.g;
                    this.g = this.d;
                    return j3;
                }
                return j2 + inputStream.skip(j - j2);
            }
            c();
            throw null;
        }
        c();
        throw null;
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i = this.f;
        if (i != -1) {
            int i2 = this.g - i;
            int i3 = this.e;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.d == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i3) {
                        length = i3;
                    }
                    byte[] bArr2 = (byte[]) ((jk) this.h).b(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.c = bArr2;
                    ((jk) this.h).a((jk) bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                this.g -= this.f;
                this.f = 0;
                this.d = 0;
                int i5 = this.g;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.g;
                if (read > 0) {
                    i6 += read;
                }
                this.d = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f = -1;
            this.g = 0;
            this.d = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.c;
        if (bArr2 == null) {
            c();
            throw null;
        } else if (i2 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.g < this.d) {
                    int i5 = this.d - this.g >= i2 ? i2 : this.d - this.g;
                    System.arraycopy(bArr2, this.g, bArr, i, i5);
                    this.g += i5;
                    if (i5 == i2 || inputStream.available() == 0) {
                        return i5;
                    }
                    i += i5;
                    i3 = i2 - i5;
                } else {
                    i3 = i2;
                }
                while (true) {
                    if (this.f == -1 && i3 >= bArr2.length) {
                        i4 = inputStream.read(bArr, i, i3);
                        if (i4 == -1) {
                            return i3 != i2 ? i2 - i3 : -1;
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    } else {
                        if (bArr2 != this.c && (bArr2 = this.c) == null) {
                            c();
                            throw null;
                        }
                        i4 = this.d - this.g >= i3 ? i3 : this.d - this.g;
                        System.arraycopy(bArr2, this.g, bArr, i, i4);
                        this.g += i4;
                    }
                    i3 -= i4;
                    if (i3 == 0) {
                        return i2;
                    }
                    if (inputStream.available() == 0) {
                        return i2 - i3;
                    }
                    i += i4;
                }
            } else {
                c();
                throw null;
            }
        }
    }
}
