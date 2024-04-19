package defpackage;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
/* renamed from: nm  reason: default package */
/* loaded from: classes.dex */
public final class nm implements di<ByteBuffer, Bitmap> {
    public final jm a = new jm();

    @Override // defpackage.di
    public vj<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, bi biVar) {
        return this.a.a(ImageDecoder.createSource(byteBuffer), i, i2, biVar);
    }

    @Override // defpackage.di
    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        return true;
    }
}
