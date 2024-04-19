package defpackage;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
/* compiled from: BitmapBytesTranscoder.java */
/* renamed from: co  reason: default package */
/* loaded from: classes.dex */
public class co implements go<Bitmap, byte[]> {
    public final Bitmap.CompressFormat a = Bitmap.CompressFormat.JPEG;
    public final int b = 100;

    @Override // defpackage.go
    public vj<byte[]> a(vj<Bitmap> vjVar, bi biVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vjVar.a().compress(this.a, this.b, byteArrayOutputStream);
        vjVar.d();
        return new kn(byteArrayOutputStream.toByteArray());
    }
}
