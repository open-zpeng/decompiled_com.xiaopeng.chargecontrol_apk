package defpackage;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferBitmapWebpDecoder.java */
/* renamed from: ih  reason: default package */
/* loaded from: classes.dex */
public class ih implements di<ByteBuffer, Bitmap> {
    public final oh a;

    public ih(oh ohVar) {
        this.a = ohVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, bi biVar) {
        return this.a.a(jq.b(byteBuffer), i, i2, biVar);
    }

    @Override // defpackage.di
    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        return this.a.a(byteBuffer, biVar);
    }
}
