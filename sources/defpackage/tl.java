package defpackage;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamEncoder.java */
/* renamed from: tl  reason: default package */
/* loaded from: classes.dex */
public class tl implements xh<InputStream> {
    public final ck a;

    public tl(ck ckVar) {
        this.a = ckVar;
    }

    @Override // defpackage.xh
    public boolean a(InputStream inputStream, File file, bi biVar) {
        FileOutputStream fileOutputStream;
        InputStream inputStream2 = inputStream;
        byte[] bArr = (byte[]) ((jk) this.a).b(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (IOException e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            ((jk) this.a).a((jk) bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            ((jk) this.a).a((jk) bArr);
                            throw th;
                        }
                    }
                    fileOutputStream.close();
                    z = true;
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
        ((jk) this.a).a((jk) bArr);
        return z;
    }
}
