package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
/* compiled from: BitmapDrawableDecoder.java */
/* renamed from: gm  reason: default package */
/* loaded from: classes.dex */
public class gm<DataType> implements di<DataType, BitmapDrawable> {
    public final di<DataType, Bitmap> a;
    public final Resources b;

    public gm(Resources resources, di<DataType, Bitmap> diVar) {
        a.a(resources, "Argument must not be null");
        this.b = resources;
        a.a(diVar, "Argument must not be null");
        this.a = diVar;
    }

    @Override // defpackage.di
    public boolean a(DataType datatype, bi biVar) {
        return this.a.a(datatype, biVar);
    }

    @Override // defpackage.di
    public vj<BitmapDrawable> a(DataType datatype, int i, int i2, bi biVar) {
        return an.a(this.b, this.a.a(datatype, i, i2, biVar));
    }
}
