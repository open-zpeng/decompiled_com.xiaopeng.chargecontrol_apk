package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
/* compiled from: FileDescriptorLocalUriFetcher.java */
/* renamed from: oi  reason: default package */
/* loaded from: classes.dex */
public class oi extends ri<ParcelFileDescriptor> {
    public oi(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // defpackage.ri
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    @Override // defpackage.ri
    public ParcelFileDescriptor a(Uri uri, ContentResolver contentResolver) {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException(jg.a("FileDescriptor is null for: ", uri));
    }

    @Override // defpackage.ji
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
