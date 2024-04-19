package defpackage;

import android.graphics.Bitmap;
import defpackage.sm;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamBitmapDecoder.java */
/* renamed from: en  reason: default package */
/* loaded from: classes.dex */
public class en implements di<InputStream, Bitmap> {
    public final sm a;
    public final ck b;

    /* compiled from: StreamBitmapDecoder.java */
    /* renamed from: en$a */
    /* loaded from: classes.dex */
    public static class a implements sm.b {
        public final cn a;
        public final mq b;

        public a(cn cnVar, mq mqVar) {
            this.a = cnVar;
            this.b = mqVar;
        }

        @Override // defpackage.sm.b
        public void a() {
            this.a.a();
        }

        @Override // defpackage.sm.b
        public void a(ek ekVar, Bitmap bitmap) {
            IOException iOException = this.b.d;
            if (iOException != null) {
                if (bitmap != null) {
                    ekVar.a(bitmap);
                }
                throw iOException;
            }
        }
    }

    public en(sm smVar, ck ckVar) {
        this.a = smVar;
        this.b = ckVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(InputStream inputStream, int i, int i2, bi biVar) {
        boolean z;
        cn cnVar;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof cn) {
            cnVar = (cn) inputStream2;
            z = false;
        } else {
            z = true;
            cnVar = new cn(inputStream2, this.b);
        }
        mq a2 = mq.a(cnVar);
        try {
            return this.a.a(new qq(a2), i, i2, biVar, new a(cnVar, a2));
        } finally {
            a2.a();
            if (z) {
                cnVar.b();
            }
        }
    }

    @Override // defpackage.di
    public boolean a(InputStream inputStream, bi biVar) {
        this.a.a();
        return true;
    }
}
