package defpackage;

import android.graphics.Bitmap;
/* compiled from: BitmapPoolAdapter.java */
/* renamed from: fk  reason: default package */
/* loaded from: classes.dex */
public class fk implements ek {
    @Override // defpackage.ek
    public void a() {
    }

    @Override // defpackage.ek
    public void a(int i) {
    }

    @Override // defpackage.ek
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // defpackage.ek
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.ek
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }
}
