package defpackage;

import android.graphics.Bitmap;
/* compiled from: BitmapEncoder.java */
/* renamed from: im  reason: default package */
/* loaded from: classes.dex */
public class im implements ei<Bitmap> {
    public static final ai<Integer> b = ai.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final ai<Bitmap.CompressFormat> c = new ai<>("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, ai.a());
    public final ck a;

    public im(ck ckVar) {
        this.a = ckVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
        if (r6 != null) goto L20;
     */
    @Override // defpackage.xh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.Object r9, java.io.File r10, defpackage.bi r11) {
        /*
            r8 = this;
            vj r9 = (defpackage.vj) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.a()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            ai<android.graphics.Bitmap$CompressFormat> r1 = defpackage.im.c
            java.lang.Object r1 = r11.a(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L15
            goto L20
        L15:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L1e
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L20
        L1e:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L20:
            int r2 = r9.getWidth()
            java.lang.Integer.valueOf(r2)
            int r2 = r9.getHeight()
            java.lang.Integer.valueOf(r2)
            long r2 = defpackage.oq.a()     // Catch: java.lang.Throwable -> Lc9
            ai<java.lang.Integer> r4 = defpackage.im.b     // Catch: java.lang.Throwable -> Lc9
            java.lang.Object r4 = r11.a(r4)     // Catch: java.lang.Throwable -> Lc9
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lc9
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lc9
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            ck r10 = r8.a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            if (r10 == 0) goto L52
            ii r10 = new ii     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            ck r6 = r8.a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r6 = r10
            goto L53
        L52:
            r6 = r7
        L53:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            r6.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            r5 = 1
            goto L72
        L5b:
            r9 = move-exception
            goto Lc3
        L5d:
            r10 = move-exception
            r6 = r7
            goto L64
        L60:
            r9 = move-exception
            r7 = r6
            goto Lc3
        L63:
            r10 = move-exception
        L64:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L70
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch: java.lang.Throwable -> L60
        L70:
            if (r6 == 0) goto L75
        L72:
            r6.close()     // Catch: java.io.IOException -> L75 java.lang.Throwable -> Lc9
        L75:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lc9
            if (r10 == 0) goto Lc2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc9
            r10.<init>()     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r4 = "Compressed with type: "
            r10.append(r4)     // Catch: java.lang.Throwable -> Lc9
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r1 = " of size "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc9
            int r1 = defpackage.sq.a(r9)     // Catch: java.lang.Throwable -> Lc9
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r1 = " in "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc9
            double r1 = defpackage.oq.a(r2)     // Catch: java.lang.Throwable -> Lc9
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r1 = ", options format: "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc9
            ai<android.graphics.Bitmap$CompressFormat> r1 = defpackage.im.c     // Catch: java.lang.Throwable -> Lc9
            java.lang.Object r11 = r11.a(r1)     // Catch: java.lang.Throwable -> Lc9
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc9
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lc9
            r10.append(r9)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> Lc9
            android.util.Log.v(r0, r9)     // Catch: java.lang.Throwable -> Lc9
        Lc2:
            return r5
        Lc3:
            if (r7 == 0) goto Lc8
            r7.close()     // Catch: java.io.IOException -> Lc8 java.lang.Throwable -> Lc9
        Lc8:
            throw r9     // Catch: java.lang.Throwable -> Lc9
        Lc9:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.im.a(java.lang.Object, java.io.File, bi):boolean");
    }

    @Override // defpackage.ei
    public wh a(bi biVar) {
        return wh.TRANSFORMED;
    }
}
