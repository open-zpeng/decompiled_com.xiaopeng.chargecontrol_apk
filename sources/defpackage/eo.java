package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
/* compiled from: DrawableBytesTranscoder.java */
/* renamed from: eo  reason: default package */
/* loaded from: classes.dex */
public final class eo implements go<Drawable, byte[]> {
    public final ek a;
    public final go<Bitmap, byte[]> b;
    public final go<un, byte[]> c;

    public eo(ek ekVar, go<Bitmap, byte[]> goVar, go<un, byte[]> goVar2) {
        this.a = ekVar;
        this.b = goVar;
        this.c = goVar2;
    }

    @Override // defpackage.go
    public vj<byte[]> a(vj<Drawable> vjVar, bi biVar) {
        Drawable a = vjVar.a();
        if (a instanceof BitmapDrawable) {
            return this.b.a(km.a(((BitmapDrawable) a).getBitmap(), this.a), biVar);
        }
        if (a instanceof un) {
            return this.c.a(vjVar, biVar);
        }
        return null;
    }
}
