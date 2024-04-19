package defpackage;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: StreamGifDecoder.java */
/* renamed from: bo  reason: default package */
/* loaded from: classes.dex */
public class bo implements di<InputStream, un> {
    public final List<ImageHeaderParser> a;
    public final di<ByteBuffer, un> b;
    public final ck c;

    public bo(List<ImageHeaderParser> list, di<ByteBuffer, un> diVar, ck ckVar) {
        this.a = list;
        this.b = diVar;
        this.c = ckVar;
    }

    @Override // defpackage.di
    public vj<un> a(InputStream inputStream, int i, int i2, bi biVar) {
        byte[] bArr;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream2.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(bArr), i, i2, biVar);
    }

    @Override // defpackage.di
    public boolean a(InputStream inputStream, bi biVar) {
        return !((Boolean) biVar.a(ao.b)).booleanValue() && a.b(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
