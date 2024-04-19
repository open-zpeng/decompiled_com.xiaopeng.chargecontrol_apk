package defpackage;

import android.content.res.AssetManager;
import java.io.InputStream;
/* compiled from: StreamAssetPathFetcher.java */
/* renamed from: ti  reason: default package */
/* loaded from: classes.dex */
public class ti extends hi<InputStream> {
    public ti(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.hi
    public void a(InputStream inputStream) {
        inputStream.close();
    }

    @Override // defpackage.hi
    public InputStream a(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }

    @Override // defpackage.ji
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
