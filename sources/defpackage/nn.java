package defpackage;

import android.graphics.drawable.Drawable;
/* compiled from: NonOwnedDrawableResource.java */
/* renamed from: nn  reason: default package */
/* loaded from: classes.dex */
public final class nn extends mn<Drawable> {
    public nn(Drawable drawable) {
        super(drawable);
    }

    public static vj<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new nn(drawable);
        }
        return null;
    }

    @Override // defpackage.vj
    public int b() {
        return Math.max(1, this.c.getIntrinsicHeight() * this.c.getIntrinsicWidth() * 4);
    }

    @Override // defpackage.vj
    public Class<Drawable> c() {
        return this.c.getClass();
    }

    @Override // defpackage.vj
    public void d() {
    }
}
