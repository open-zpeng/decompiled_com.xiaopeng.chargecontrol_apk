package defpackage;

import java.io.OutputStream;
/* compiled from: BufferedOutputStream.java */
/* renamed from: ii  reason: default package */
/* loaded from: classes.dex */
public final class ii extends OutputStream {
    public final OutputStream c;
    public byte[] d;
    public ck e;
    public int f;

    public ii(OutputStream outputStream, ck ckVar) {
        this.c = outputStream;
        this.e = ckVar;
        this.d = (byte[]) ((jk) ckVar).b(65536, byte[].class);
    }

    public final void a() {
        int i = this.f;
        byte[] bArr = this.d;
        if (i != bArr.length || i <= 0) {
            return;
        }
        this.c.write(bArr, 0, i);
        this.f = 0;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.c.close();
            byte[] bArr = this.d;
            if (bArr != null) {
                ((jk) this.e).a((jk) bArr);
                this.d = null;
            }
        } catch (Throwable th) {
            this.c.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        int i = this.f;
        if (i > 0) {
            this.c.write(this.d, 0, i);
            this.f = 0;
        }
        this.c.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.d;
        int i2 = this.f;
        this.f = i2 + 1;
        bArr[i2] = (byte) i;
        a();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f == 0 && i4 >= this.d.length) {
                this.c.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.d.length - this.f);
            System.arraycopy(bArr, i5, this.d, this.f, min);
            this.f += min;
            i3 += min;
            a();
        } while (i3 < i2);
    }
}
