package defpackage;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferAnimatedBitmapDecoder.java */
/* renamed from: hh  reason: default package */
/* loaded from: classes.dex */
public class hh implements di<ByteBuffer, Bitmap> {
    public final gh a;

    public hh(gh ghVar) {
        this.a = ghVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, bi biVar) {
        return this.a.a(byteBuffer, i, i2);
    }

    @Override // defpackage.di
    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        return this.a.a(byteBuffer, biVar);
    }
}
