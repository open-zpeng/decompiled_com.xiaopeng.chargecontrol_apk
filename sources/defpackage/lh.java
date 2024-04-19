package defpackage;

import android.graphics.Bitmap;
import java.io.InputStream;
/* compiled from: StreamBitmapWebpDecoder.java */
/* renamed from: lh  reason: default package */
/* loaded from: classes.dex */
public class lh implements di<InputStream, Bitmap> {
    public final oh a;

    public lh(oh ohVar, ck ckVar) {
        this.a = ohVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(InputStream inputStream, int i, int i2, bi biVar) {
        return this.a.a(inputStream, i, i2, biVar);
    }

    @Override // defpackage.di
    public boolean a(InputStream inputStream, bi biVar) {
        return this.a.a(inputStream, biVar);
    }
}
