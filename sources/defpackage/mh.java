package defpackage;

import java.io.InputStream;
import java.nio.ByteBuffer;
/* compiled from: StreamWebpDecoder.java */
/* renamed from: mh  reason: default package */
/* loaded from: classes.dex */
public class mh implements di<InputStream, ph> {
    public static final ai<Boolean> c = ai.a("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", false);
    public final di<ByteBuffer, ph> a;
    public final ck b;

    public mh(di<ByteBuffer, ph> diVar, ck ckVar) {
        this.a = diVar;
        this.b = ckVar;
    }

    @Override // defpackage.di
    public boolean a(InputStream inputStream, bi biVar) {
        InputStream inputStream2 = inputStream;
        if (((Boolean) biVar.a(c)).booleanValue()) {
            return false;
        }
        return fh.a(fh.a(inputStream2, this.b));
    }

    @Override // defpackage.di
    public vj<ph> a(InputStream inputStream, int i, int i2, bi biVar) {
        byte[] a = a.a(inputStream);
        if (a == null) {
            return null;
        }
        return this.a.a(ByteBuffer.wrap(a), i, i2, biVar);
    }
}
