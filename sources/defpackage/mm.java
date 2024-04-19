package defpackage;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferBitmapDecoder.java */
/* renamed from: mm  reason: default package */
/* loaded from: classes.dex */
public class mm implements di<ByteBuffer, Bitmap> {
    public final sm a;

    public mm(sm smVar) {
        this.a = smVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, bi biVar) {
        return this.a.a(jq.b(byteBuffer), i, i2, biVar, sm.l);
    }

    @Override // defpackage.di
    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        this.a.b();
        return true;
    }
}
