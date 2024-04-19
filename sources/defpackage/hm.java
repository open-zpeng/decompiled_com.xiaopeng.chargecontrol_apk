package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;
/* compiled from: BitmapDrawableEncoder.java */
/* renamed from: hm  reason: default package */
/* loaded from: classes.dex */
public class hm implements ei<BitmapDrawable> {
    public final ek a;
    public final ei<Bitmap> b;

    public hm(ek ekVar, ei<Bitmap> eiVar) {
        this.a = ekVar;
        this.b = eiVar;
    }

    @Override // defpackage.xh
    public boolean a(Object obj, File file, bi biVar) {
        return this.b.a(new km(((BitmapDrawable) ((vj) obj).a()).getBitmap(), this.a), file, biVar);
    }

    @Override // defpackage.ei
    public wh a(bi biVar) {
        return this.b.a(biVar);
    }
}
