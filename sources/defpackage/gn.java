package defpackage;

import android.graphics.Bitmap;
/* compiled from: UnitBitmapDecoder.java */
/* renamed from: gn  reason: default package */
/* loaded from: classes.dex */
public final class gn implements di<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder.java */
    /* renamed from: gn$a */
    /* loaded from: classes.dex */
    public static final class a implements vj<Bitmap> {
        public final Bitmap c;

        public a(Bitmap bitmap) {
            this.c = bitmap;
        }

        @Override // defpackage.vj
        public Bitmap a() {
            return this.c;
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
        }
    }

    @Override // defpackage.di
    public vj<Bitmap> a(Bitmap bitmap, int i, int i2, bi biVar) {
        return new a(bitmap);
    }

    @Override // defpackage.di
    public boolean a(Bitmap bitmap, bi biVar) {
        return true;
    }
}
