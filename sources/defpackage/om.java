package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;
/* compiled from: CenterCrop.java */
/* renamed from: om  reason: default package */
/* loaded from: classes.dex */
public class om extends lm {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(zh.a);

    @Override // defpackage.lm
    public Bitmap a(ek ekVar, Bitmap bitmap, int i, int i2) {
        return fn.a(ekVar, bitmap, i, i2);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        return obj instanceof om;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterCrop".hashCode();
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
