package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferEncoder.java */
/* renamed from: cl  reason: default package */
/* loaded from: classes.dex */
public class cl implements xh<ByteBuffer> {
    @Override // defpackage.xh
    public boolean a(ByteBuffer byteBuffer, File file, bi biVar) {
        try {
            jq.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
