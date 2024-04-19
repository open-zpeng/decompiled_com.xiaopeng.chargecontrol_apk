package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
/* compiled from: GifDrawableEncoder.java */
/* renamed from: vn  reason: default package */
/* loaded from: classes.dex */
public class vn implements ei<un> {
    @Override // defpackage.xh
    public boolean a(Object obj, File file, bi biVar) {
        try {
            jq.a(((un) ((vj) obj).a()).a(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }

    @Override // defpackage.ei
    public wh a(bi biVar) {
        return wh.SOURCE;
    }
}
