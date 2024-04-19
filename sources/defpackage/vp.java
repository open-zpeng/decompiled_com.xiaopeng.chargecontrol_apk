package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* compiled from: BitmapImageViewTarget.java */
/* renamed from: vp  reason: default package */
/* loaded from: classes.dex */
public class vp extends zp<Bitmap> {
    public vp(ImageView imageView) {
        super(imageView);
    }

    @Override // defpackage.zp
    public void b(Bitmap bitmap) {
        ((ImageView) this.c).setImageBitmap(bitmap);
    }
}
