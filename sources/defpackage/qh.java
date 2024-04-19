package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
/* compiled from: WebpDrawableEncoder.java */
/* renamed from: qh  reason: default package */
/* loaded from: classes.dex */
public class qh implements ei<ph> {
    @Override // defpackage.xh
    public boolean a(Object obj, File file, bi biVar) {
        try {
            jq.a(((ph) ((vj) obj).a()).c.a.a.getData().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("WebpEncoder", 5)) {
                Log.w("WebpEncoder", "Failed to encode WebP drawable data", e);
            }
            return false;
        }
    }

    @Override // defpackage.ei
    public wh a(bi biVar) {
        return wh.SOURCE;
    }
}
