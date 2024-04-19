package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;
/* compiled from: FitCenter.java */
/* renamed from: wm  reason: default package */
/* loaded from: classes.dex */
public class wm extends lm {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(zh.a);

    @Override // defpackage.lm
    public Bitmap a(ek ekVar, Bitmap bitmap, int i, int i2) {
        return fn.c(ekVar, bitmap, i, i2);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        return obj instanceof wm;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
