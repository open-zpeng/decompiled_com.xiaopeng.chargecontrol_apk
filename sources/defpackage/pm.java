package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;
/* compiled from: CenterInside.java */
/* renamed from: pm  reason: default package */
/* loaded from: classes.dex */
public class pm extends lm {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(zh.a);

    @Override // defpackage.lm
    public Bitmap a(ek ekVar, Bitmap bitmap, int i, int i2) {
        return fn.b(ekVar, bitmap, i, i2);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        return obj instanceof pm;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterInside".hashCode();
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
