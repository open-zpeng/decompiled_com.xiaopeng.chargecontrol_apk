package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* compiled from: DrawableImageViewTarget.java */
/* renamed from: yp  reason: default package */
/* loaded from: classes.dex */
public class yp extends zp<Drawable> {
    public yp(ImageView imageView) {
        super(imageView);
    }

    @Override // defpackage.zp
    public void b(Drawable drawable) {
        ((ImageView) this.c).setImageDrawable(drawable);
    }
}
