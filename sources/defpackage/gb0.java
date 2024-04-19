package defpackage;

import android.app.ActivityThread;
import android.util.Log;
/* compiled from: LogUtils.java */
/* renamed from: gb0  reason: default package */
/* loaded from: classes.dex */
public class gb0 {
    public static String a;
    public static b b;
    public static boolean c;
    public static boolean d;

    /* compiled from: LogUtils.java */
    /* renamed from: gb0$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        public void a(int i, String str, String str2, String str3) {
            if (i == 2) {
                Log.v(str2, str);
            } else if (i == 3) {
                Log.d(str2, str);
                String str4 = "DEBUG: " + str;
            } else if (i == 4) {
                Log.i(str2, str);
                String str5 = "INFO: " + str;
            } else if (i == 5) {
                Log.w(str2, str);
                String str6 = "WARN: " + str;
            } else if (i != 6) {
            } else {
                Log.e(str2, str);
                String str7 = "ERROR: " + str;
            }
        }
    }

    /* compiled from: LogUtils.java */
    /* renamed from: gb0$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    static {
        String[] split = ActivityThread.currentApplication().getPackageName().split("\\.");
        a = split[split.length - 1];
        b = new a();
        c = true;
        d = false;
    }

    public static boolean a(int i) {
        return 2 <= i && c;
    }

    public static void b(Object obj, String str) {
        if (a(6)) {
            a(6, obj, str, null, d);
        }
    }

    public static void c(Object obj, String str) {
        if (a(4)) {
            a(4, obj, str, null, d);
        }
    }

    public static void d(Object obj, String str) {
        if (a(2)) {
            a(2, obj, str, null, d);
        }
    }

    public static void a(Object obj, String str) {
        if (a(3)) {
            a(3, obj, str, null, d);
        }
    }

    public static void a(Object obj, String str, Throwable th) {
        if (a(5)) {
            a(5, obj, str, th, d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r5, java.lang.Object r6, java.lang.String r7, java.lang.Throwable r8, boolean r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L20
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            if (r1 == 0) goto L14
            int r2 = r1.length
            r3 = 4
            if (r2 <= r3) goto L14
            r1 = r1[r3]
            goto L15
        L14:
            r1 = r0
        L15:
            if (r1 == 0) goto L20
            java.lang.String r2 = r1.getFileName()
            int r1 = r1.getLineNumber()
            goto L22
        L20:
            r1 = 0
            r2 = r0
        L22:
            if (r9 != 0) goto L26
            if (r8 == 0) goto L7d
        L26:
            java.lang.StringBuilder r7 = defpackage.jg.a(r7)
            if (r9 == 0) goto L6b
            java.lang.String r9 = " (T:"
            r7.append(r9)
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            long r3 = r9.getId()
            r7.append(r3)
            java.lang.String r9 = ")"
            r7.append(r9)
            java.lang.String r3 = defpackage.gb0.a
            if (r3 == 0) goto L52
            java.lang.String r3 = "(C:"
            r7.append(r3)
            java.lang.String r3 = defpackage.gb0.a
            r7.append(r3)
            r7.append(r9)
        L52:
            java.lang.String r3 = "at ("
            r7.append(r3)
            if (r2 != 0) goto L5c
            java.lang.String r3 = ""
            goto L5d
        L5c:
            r3 = r2
        L5d:
            r7.append(r3)
            java.lang.String r3 = ":"
            r7.append(r3)
            r7.append(r1)
            r7.append(r9)
        L6b:
            if (r8 == 0) goto L79
            r9 = 10
            r7.append(r9)
            java.lang.String r8 = android.util.Log.getStackTraceString(r8)
            r7.append(r8)
        L79:
            java.lang.String r7 = r7.toString()
        L7d:
            if (r6 != 0) goto L81
            r6 = r0
            goto L9b
        L81:
            boolean r8 = r6 instanceof java.lang.String
            if (r8 == 0) goto L88
            java.lang.String r6 = (java.lang.String) r6
            goto L9b
        L88:
            boolean r8 = r6 instanceof java.lang.Class
            if (r8 == 0) goto L93
            java.lang.Class r6 = (java.lang.Class) r6
            java.lang.String r6 = r6.getSimpleName()
            goto L9b
        L93:
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getSimpleName()
        L9b:
            if (r6 != 0) goto La6
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto La7
            java.lang.String r2 = defpackage.gb0.a
            goto La7
        La6:
            r2 = r6
        La7:
            gb0$b r6 = defpackage.gb0.b
            gb0$a r6 = (defpackage.gb0.a) r6
            r6.a(r5, r7, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gb0.a(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }
}
