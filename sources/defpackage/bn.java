package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import defpackage.ym;
/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* renamed from: bn  reason: default package */
/* loaded from: classes.dex */
public final class bn implements di<ParcelFileDescriptor, Bitmap> {
    public final sm a;

    public bn(sm smVar) {
        this.a = smVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, bi biVar) {
        sm smVar = this.a;
        return smVar.a(new ym.b(parcelFileDescriptor, smVar.d, smVar.c), i, i2, biVar, sm.l);
    }

    @Override // defpackage.di
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, bi biVar) {
        this.a.c();
        return true;
    }
}
