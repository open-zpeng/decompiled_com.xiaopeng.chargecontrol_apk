package defpackage;

import android.graphics.Bitmap;
/* compiled from: BitmapResource.java */
/* renamed from: km  reason: default package */
/* loaded from: classes.dex */
public class km implements vj<Bitmap>, rj {
    public final Bitmap c;
    public final ek d;

    public km(Bitmap bitmap, ek ekVar) {
        a.a(bitmap, "Bitmap must not be null");
        this.c = bitmap;
        a.a(ekVar, "BitmapPool must not be null");
        this.d = ekVar;
    }

    public static km a(Bitmap bitmap, ek ekVar) {
        if (bitmap == null) {
            return null;
        }
        return new km(bitmap, ekVar);
    }

    @Override // defpackage.vj
    public int b() {
        return sq.a(this.c);
    }

    @Override // defpackage.vj
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @Override // defpackage.vj
    public void d() {
        this.d.a(this.c);
    }

    @Override // defpackage.rj
    public void e() {
        this.c.prepareToDraw();
    }

    @Override // defpackage.vj
    public Bitmap a() {
        return this.c;
    }
}
