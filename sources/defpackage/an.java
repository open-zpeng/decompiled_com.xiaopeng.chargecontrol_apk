package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
/* compiled from: LazyBitmapDrawableResource.java */
/* renamed from: an  reason: default package */
/* loaded from: classes.dex */
public final class an implements vj<BitmapDrawable>, rj {
    public final Resources c;
    public final vj<Bitmap> d;

    public an(Resources resources, vj<Bitmap> vjVar) {
        a.a(resources, "Argument must not be null");
        this.c = resources;
        a.a(vjVar, "Argument must not be null");
        this.d = vjVar;
    }

    public static vj<BitmapDrawable> a(Resources resources, vj<Bitmap> vjVar) {
        if (vjVar == null) {
            return null;
        }
        return new an(resources, vjVar);
    }

    @Override // defpackage.vj
    public int b() {
        return this.d.b();
    }

    @Override // defpackage.vj
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @Override // defpackage.vj
    public void d() {
        this.d.d();
    }

    @Override // defpackage.rj
    public void e() {
        vj<Bitmap> vjVar = this.d;
        if (vjVar instanceof rj) {
            ((rj) vjVar).e();
        }
    }

    @Override // defpackage.vj
    public BitmapDrawable a() {
        return new BitmapDrawable(this.c, this.d.a());
    }
}
