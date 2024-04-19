package defpackage;

import android.graphics.Bitmap;
import defpackage.zg;
/* compiled from: GifBitmapProvider.java */
/* renamed from: tn  reason: default package */
/* loaded from: classes.dex */
public final class tn implements zg.a {
    public final ek a;
    public final ck b;

    public tn(ek ekVar, ck ckVar) {
        this.a = ekVar;
        this.b = ckVar;
    }

    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.a.b(i, i2, config);
    }

    public byte[] a(int i) {
        ck ckVar = this.b;
        if (ckVar == null) {
            return new byte[i];
        }
        return (byte[]) ((jk) ckVar).b(i, byte[].class);
    }
}
