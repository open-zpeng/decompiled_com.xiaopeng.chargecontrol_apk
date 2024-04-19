package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* compiled from: ExceptionCatchingInputStream.java */
/* renamed from: mq  reason: default package */
/* loaded from: classes.dex */
public class mq extends InputStream {
    public static final Queue<mq> e = sq.a(0);
    public InputStream c;
    public IOException d;

    public static mq a(InputStream inputStream) {
        mq poll;
        synchronized (e) {
            poll = e.poll();
        }
        if (poll == null) {
            poll = new mq();
        }
        poll.c = inputStream;
        return poll;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.c.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.c.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.c.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.c.read(bArr);
        } catch (IOException e2) {
            this.d = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.c.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.c.skip(j);
        } catch (IOException e2) {
            this.d = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.c.read(bArr, i, i2);
        } catch (IOException e2) {
            this.d = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.c.read();
        } catch (IOException e2) {
            this.d = e2;
            return -1;
        }
    }

    public void a() {
        this.d = null;
        this.c = null;
        synchronized (e) {
            e.offer(this);
        }
    }
}
