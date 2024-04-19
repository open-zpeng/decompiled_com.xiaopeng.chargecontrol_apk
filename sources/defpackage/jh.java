package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpImage;
import defpackage.ph;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferWebpDecoder.java */
/* renamed from: jh  reason: default package */
/* loaded from: classes.dex */
public class jh implements di<ByteBuffer, ph> {
    public static final ai<Boolean> d = ai.a("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", false);
    public final Context a;
    public final ek b;
    public final tn c;

    public jh(Context context, ck ckVar, ek ekVar) {
        this.a = context.getApplicationContext();
        this.b = ekVar;
        this.c = new tn(ekVar, ckVar);
    }

    @Override // defpackage.di
    public vj<ph> a(ByteBuffer byteBuffer, int i, int i2, bi biVar) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int remaining = byteBuffer2.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer2.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        nh nhVar = new nh(this.c, create, byteBuffer2, a.a(create.getWidth(), create.getHeight(), i, i2), (sh) biVar.a(th.r));
        nhVar.c();
        Bitmap b = nhVar.b();
        if (b == null) {
            return null;
        }
        Context context = this.a;
        return new rh(new ph(new ph.a(this.b, new th(lg.a(context), nhVar, i, i2, (fm) fm.b, b))));
    }

    @Override // defpackage.di
    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (((Boolean) biVar.a(d)).booleanValue()) {
            return false;
        }
        return fh.a(fh.a(byteBuffer2));
    }
}
