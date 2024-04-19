package defpackage;

import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* renamed from: xg  reason: default package */
/* loaded from: classes.dex */
public class xg implements Closeable {
    public final InputStream c;
    public final Charset d;
    public byte[] e;
    public int f;
    public int g;

    /* compiled from: StrictLineReader.java */
    /* renamed from: xg$a */
    /* loaded from: classes.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i <= 0 || ((ByteArrayOutputStream) this).buf[i + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i - 1, xg.this.d.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public xg(InputStream inputStream, Charset charset) {
        if (inputStream != null && charset != null) {
            if (charset.equals(yg.a)) {
                this.c = inputStream;
                this.d = charset;
                this.e = new byte[WebpBitmapFactory.IN_TEMP_BUFFER_SIZE];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new NullPointerException();
    }

    public final void a() {
        InputStream inputStream = this.c;
        byte[] bArr = this.e;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f = 0;
            this.g = read;
            return;
        }
        throw new EOFException();
    }

    public String b() {
        int i;
        int i2;
        synchronized (this.c) {
            if (this.e != null) {
                if (this.f >= this.g) {
                    a();
                }
                for (int i3 = this.f; i3 != this.g; i3++) {
                    if (this.e[i3] == 10) {
                        if (i3 != this.f) {
                            i2 = i3 - 1;
                            if (this.e[i2] == 13) {
                                String str = new String(this.e, this.f, i2 - this.f, this.d.name());
                                this.f = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.e, this.f, i2 - this.f, this.d.name());
                        this.f = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.g - this.f) + 80);
                loop1: while (true) {
                    aVar.write(this.e, this.f, this.g - this.f);
                    this.g = -1;
                    a();
                    i = this.f;
                    while (i != this.g) {
                        if (this.e[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f) {
                    aVar.write(this.e, this.f, i - this.f);
                }
                this.f = i + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.c) {
            if (this.e != null) {
                this.e = null;
                this.c.close();
            }
        }
    }
}
