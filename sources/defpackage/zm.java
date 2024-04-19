package defpackage;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.InputStream;
/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* renamed from: zm  reason: default package */
/* loaded from: classes.dex */
public final class zm implements di<InputStream, Bitmap> {
    public final jm a = new jm();

    @Override // defpackage.di
    public vj<Bitmap> a(InputStream inputStream, int i, int i2, bi biVar) {
        return this.a.a(ImageDecoder.createSource(jq.a(inputStream)), i, i2, biVar);
    }

    @Override // defpackage.di
    public boolean a(InputStream inputStream, bi biVar) {
        return true;
    }
}
