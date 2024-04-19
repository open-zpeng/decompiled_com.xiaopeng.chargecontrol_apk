package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
/* compiled from: CarControl.java */
/* renamed from: f00  reason: default package */
/* loaded from: classes.dex */
public class f00 {
    public final Uri a;
    public final String b;
    public final String c;

    public f00(Uri uri, String getCommand, String setCommand) {
        this.a = uri;
        this.b = getCommand;
        this.c = setCommand;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.ContentResolver r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = " from "
            java.lang.String r1 = "Can't get key "
            java.lang.String r2 = "CarControl"
            java.lang.String r3 = r6.b
            r4 = 0
            if (r3 == 0) goto L1a
            android.net.Uri r5 = r6.a     // Catch: java.lang.Exception -> L1a
            android.os.Bundle r3 = r7.call(r5, r3, r8, r4)     // Catch: java.lang.Exception -> L1a
            if (r3 == 0) goto L1a
            java.lang.String r5 = "value"
            java.lang.String r7 = r3.getString(r5)     // Catch: java.lang.Exception -> L1a
            return r7
        L1a:
            android.net.Uri r3 = r6.a     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            android.net.Uri r3 = android.net.Uri.withAppendedPath(r3, r8)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            android.database.Cursor r7 = r7.query(r3, r4, r4, r4)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r7 != 0) goto L46
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            r3.<init>()     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            r3.append(r1)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            r3.append(r8)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            r3.append(r0)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            android.net.Uri r5 = r6.a     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            r3.append(r5)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            android.util.Log.w(r2, r3)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            if (r7 == 0) goto L45
            r7.close()
        L45:
            return r4
        L46:
            boolean r3 = r7.moveToNext()     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
            if (r3 == 0) goto L51
            r3 = 0
            java.lang.String r4 = r7.getString(r3)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L7c
        L51:
            r7.close()
            return r4
        L55:
            r3 = move-exception
            goto L5c
        L57:
            r8 = move-exception
            r7 = r4
            goto L7d
        L5a:
            r3 = move-exception
            r7 = r4
        L5c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L7c
            r5.append(r1)     // Catch: java.lang.Throwable -> L7c
            r5.append(r8)     // Catch: java.lang.Throwable -> L7c
            r5.append(r0)     // Catch: java.lang.Throwable -> L7c
            android.net.Uri r8 = r6.a     // Catch: java.lang.Throwable -> L7c
            r5.append(r8)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L7c
            android.util.Log.w(r2, r8, r3)     // Catch: java.lang.Throwable -> L7c
            if (r7 == 0) goto L7b
            r7.close()
        L7b:
            return r4
        L7c:
            r8 = move-exception
        L7d:
            if (r7 == 0) goto L82
            r7.close()
        L82:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    public boolean a(ContentResolver resolver, String name, String value) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("value", value);
            resolver.call(this.a, this.c, name, bundle);
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("Can't set key ", name, " in ");
            a.append(this.a);
            Log.w("CarControl", a.toString(), e);
            return false;
        }
    }
}
