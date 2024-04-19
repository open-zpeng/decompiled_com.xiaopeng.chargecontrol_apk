package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* compiled from: AnimatedWebpBitmapDecoder.java */
/* renamed from: gh  reason: default package */
/* loaded from: classes.dex */
public class gh {
    public static final ai<Boolean> d = ai.a("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", false);
    public final ck a;
    public final ek b;
    public final tn c;

    public gh(ck ckVar, ek ekVar) {
        this.a = ckVar;
        this.b = ekVar;
        this.c = new tn(ekVar, ckVar);
    }

    public boolean a(InputStream inputStream, bi biVar) {
        if (((Boolean) biVar.a(d)).booleanValue()) {
            return false;
        }
        return fh.a(fh.a(inputStream, this.a));
    }

    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        if (((Boolean) biVar.a(d)).booleanValue()) {
            return false;
        }
        return fh.a(fh.a(byteBuffer));
    }

    public vj<Bitmap> a(InputStream inputStream, int i, int i2, bi biVar) {
        byte[] a = a.a(inputStream);
        if (a == null) {
            return null;
        }
        return a(ByteBuffer.wrap(a), i, i2);
    }

    public vj a(ByteBuffer byteBuffer, int i, int i2) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        nh nhVar = new nh(this.c, create, byteBuffer, a.a(create.getWidth(), create.getHeight(), i, i2), sh.c);
        try {
            nhVar.c();
            return km.a(nhVar.b(), this.b);
        } finally {
            nhVar.clear();
        }
    }
}
