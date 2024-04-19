package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* compiled from: ImageViewTargetFactory.java */
/* renamed from: aq  reason: default package */
/* loaded from: classes.dex */
public class aq {
    public <Z> dq<ImageView, Z> a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new vp(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new yp(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
