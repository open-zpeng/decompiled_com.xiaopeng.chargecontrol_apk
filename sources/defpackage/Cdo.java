package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
/* compiled from: BitmapDrawableTranscoder.java */
/* renamed from: do  reason: invalid class name and default package */
/* loaded from: classes.dex */
public class Cdo implements go<Bitmap, BitmapDrawable> {
    public final Resources a;

    public Cdo(Resources resources) {
        a.a(resources, "Argument must not be null");
        this.a = resources;
    }

    @Override // defpackage.go
    public vj<BitmapDrawable> a(vj<Bitmap> vjVar, bi biVar) {
        return an.a(this.a, vjVar);
    }
}
