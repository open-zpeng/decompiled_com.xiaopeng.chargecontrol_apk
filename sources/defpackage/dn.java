package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
/* compiled from: ResourceBitmapDecoder.java */
/* renamed from: dn  reason: default package */
/* loaded from: classes.dex */
public class dn implements di<Uri, Bitmap> {
    public final on a;
    public final ek b;

    public dn(on onVar, ek ekVar) {
        this.a = onVar;
        this.b = ekVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(Uri uri, int i, int i2, bi biVar) {
        vj a = this.a.a(uri);
        if (a == null) {
            return null;
        }
        return tm.a(this.b, (Drawable) a.a(), i, i2);
    }

    @Override // defpackage.di
    public boolean a(Uri uri, bi biVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
