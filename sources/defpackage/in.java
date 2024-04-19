package defpackage;

import android.media.MediaDataSource;
import defpackage.hn;
import java.nio.ByteBuffer;
/* compiled from: VideoDecoder.java */
/* renamed from: in  reason: default package */
/* loaded from: classes.dex */
public class in extends MediaDataSource {
    public final /* synthetic */ ByteBuffer c;

    public in(hn.d dVar, ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return this.c.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.c.limit()) {
            return -1;
        }
        this.c.position((int) j);
        int min = Math.min(i2, this.c.remaining());
        this.c.get(bArr, i, min);
        return min;
    }
}
