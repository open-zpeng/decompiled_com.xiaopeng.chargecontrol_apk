package defpackage;

import android.graphics.Bitmap;
import java.io.InputStream;
/* compiled from: StreamAnimatedBitmapDecoder.java */
/* renamed from: kh  reason: default package */
/* loaded from: classes.dex */
public class kh implements di<InputStream, Bitmap> {
    public final gh a;

    public kh(gh ghVar) {
        this.a = ghVar;
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
