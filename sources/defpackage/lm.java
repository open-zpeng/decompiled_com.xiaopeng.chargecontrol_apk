package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
/* compiled from: BitmapTransformation.java */
/* renamed from: lm  reason: default package */
/* loaded from: classes.dex */
public abstract class lm implements fi<Bitmap> {
    public abstract Bitmap a(ek ekVar, Bitmap bitmap, int i, int i2);

    @Override // defpackage.fi
    public final vj<Bitmap> a(Context context, vj<Bitmap> vjVar, int i, int i2) {
        if (sq.a(i, i2)) {
            ek ekVar = lg.a(context).c;
            Bitmap a = vjVar.a();
            if (i == Integer.MIN_VALUE) {
                i = a.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = a.getHeight();
            }
            Bitmap a2 = a(ekVar, a, i, i2);
            return a.equals(a2) ? vjVar : km.a(a2, ekVar);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
