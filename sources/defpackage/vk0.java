package defpackage;

import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import java.io.Closeable;
/* compiled from: ResponseBody.java */
/* renamed from: vk0  reason: default package */
/* loaded from: classes.dex */
public abstract class vk0 implements Closeable {
    public static vk0 a(byte[] bArr) {
        dl0 dl0Var;
        zk0 zk0Var = new zk0();
        if (bArr != null) {
            int i = 0;
            int length = bArr.length;
            long j = length;
            gl0.a(bArr.length, 0, j);
            int i2 = length + 0;
            while (i < i2) {
                dl0 dl0Var2 = zk0Var.c;
                if (dl0Var2 == null) {
                    zk0Var.c = el0.a();
                    dl0Var = zk0Var.c;
                    dl0Var.g = dl0Var;
                    dl0Var.f = dl0Var;
                } else {
                    dl0Var = dl0Var2.g;
                    if (dl0Var.c + 1 > 8192 || !dl0Var.e) {
                        dl0 a = el0.a();
                        a.g = dl0Var;
                        a.f = dl0Var.f;
                        dl0Var.f.g = a;
                        dl0Var.f = a;
                        dl0Var = a;
                    }
                }
                int min = Math.min(i2 - i, WebpBitmapFactory.IN_TEMP_BUFFER_SIZE - dl0Var.c);
                System.arraycopy(bArr, i, dl0Var.a, dl0Var.c, min);
                i += min;
                dl0Var.c += min;
            }
            zk0Var.d += j;
            return new uk0(bArr.length, zk0Var);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        yk0.a(((uk0) this).c);
    }
}
