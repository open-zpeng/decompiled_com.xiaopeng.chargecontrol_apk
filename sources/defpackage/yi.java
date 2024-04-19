package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* compiled from: ThumbnailStreamOpener.java */
/* renamed from: yi  reason: default package */
/* loaded from: classes.dex */
public class yi {
    public static final vi f = new vi();
    public final vi a = f;
    public final xi b;
    public final ck c;
    public final ContentResolver d;
    public final List<ImageHeaderParser> e;

    public yi(List<ImageHeaderParser> list, xi xiVar, ck ckVar, ContentResolver contentResolver) {
        this.b = xiVar;
        this.c = ckVar;
        this.d = contentResolver;
        this.e = list;
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.d.openInputStream(uri);
                int a = a.a(this.e, inputStream, this.c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r3 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3 != null) goto L6;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x001b: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:10:0x001b */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream b(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            r2 = 0
            xi r3 = r7.b     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L2a
            android.database.Cursor r3 = r3.a(r8)     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L2a
            if (r3 == 0) goto L20
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L1a java.lang.SecurityException -> L1e
            if (r4 == 0) goto L20
            java.lang.String r0 = r3.getString(r1)     // Catch: java.lang.Throwable -> L1a java.lang.SecurityException -> L1e
            r3.close()
            goto L4b
        L1a:
            r8 = move-exception
            r2 = r3
            goto La1
        L1e:
            r4 = move-exception
            goto L2d
        L20:
            if (r3 == 0) goto L25
        L22:
            r3.close()
        L25:
            r0 = r2
            goto L4b
        L27:
            r8 = move-exception
            goto La1
        L2a:
            r3 = move-exception
            r4 = r3
            r3 = r2
        L2d:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L1a
            if (r5 == 0) goto L48
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r5.<init>()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r6 = "Failed to query for thumbnail for Uri: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L1a
            r5.append(r8)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L1a
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> L1a
        L48:
            if (r3 == 0) goto L25
            goto L22
        L4b:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L52
            return r2
        L52:
            vi r3 = r7.a
            java.io.File r0 = r3.a(r0)
            vi r3 = r7.a
            boolean r3 = r3.a(r0)
            if (r3 == 0) goto L6d
            r3 = 0
            vi r5 = r7.a
            long r5 = r5.b(r0)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L6d
            r1 = 1
        L6d:
            if (r1 != 0) goto L70
            return r2
        L70:
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
            android.content.ContentResolver r1 = r7.d     // Catch: java.lang.NullPointerException -> L7b
            java.io.InputStream r8 = r1.openInputStream(r0)     // Catch: java.lang.NullPointerException -> L7b
            return r8
        L7b:
            r1 = move-exception
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "NPE opening uri: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r8 = " -> "
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = r3.toString()
            r2.<init>(r8)
            java.lang.Throwable r8 = r2.initCause(r1)
            java.io.FileNotFoundException r8 = (java.io.FileNotFoundException) r8
            throw r8
        La1:
            if (r2 == 0) goto La6
            r2.close()
        La6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yi.b(android.net.Uri):java.io.InputStream");
    }
}
