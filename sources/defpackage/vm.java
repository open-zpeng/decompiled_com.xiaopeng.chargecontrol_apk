package defpackage;

import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.kb;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* compiled from: ExifInterfaceImageHeaderParser.java */
/* renamed from: vm  reason: default package */
/* loaded from: classes.dex */
public final class vm implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, ck ckVar) {
        kb kbVar = new kb(inputStream);
        kb.b b = kbVar.b("Orientation");
        int i = 1;
        if (b != null) {
            try {
                i = b.b(kbVar.f);
            } catch (NumberFormatException unused) {
            }
        }
        if (i == 0) {
            return -1;
        }
        return i;
    }
}
