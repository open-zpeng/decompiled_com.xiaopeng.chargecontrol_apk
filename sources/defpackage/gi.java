package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
/* compiled from: AssetFileDescriptorLocalUriFetcher.java */
/* renamed from: gi  reason: default package */
/* loaded from: classes.dex */
public final class gi extends ri<AssetFileDescriptor> {
    public gi(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // defpackage.ri
    public void a(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    @Override // defpackage.ri
    public AssetFileDescriptor a(Uri uri, ContentResolver contentResolver) {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new FileNotFoundException(jg.a("FileDescriptor is null for: ", uri));
    }

    @Override // defpackage.ji
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
}
