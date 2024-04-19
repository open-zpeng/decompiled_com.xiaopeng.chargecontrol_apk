package defpackage;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
/* compiled from: FileDescriptorAssetPathFetcher.java */
/* renamed from: ni  reason: default package */
/* loaded from: classes.dex */
public class ni extends hi<ParcelFileDescriptor> {
    public ni(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.hi
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    @Override // defpackage.hi
    public ParcelFileDescriptor a(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    @Override // defpackage.ji
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
