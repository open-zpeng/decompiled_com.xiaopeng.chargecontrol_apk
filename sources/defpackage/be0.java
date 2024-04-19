package defpackage;

import android.util.Log;
/* compiled from: XLogUtils.java */
/* renamed from: be0  reason: default package */
/* loaded from: classes.dex */
public class be0 {
    public static b a = new a();

    /* compiled from: XLogUtils.java */
    /* renamed from: be0$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        public void a(int i, String str, String str2, String str3) {
            if (i == 2) {
                Log.v(str2, str);
            } else if (i == 3) {
                Log.d(str2, str);
            } else if (i == 4) {
                Log.i(str2, str);
            } else if (i == 5) {
                Log.w(str2, str);
            } else if (i != 6) {
            } else {
                Log.e(str2, str);
            }
        }
    }

    /* compiled from: XLogUtils.java */
    /* renamed from: be0$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public static void a(Object obj, String str) {
        if (a(3)) {
            a(3, obj, str, null, false);
        }
    }

    public static boolean a(int i) {
        return 4 <= i;
    }

    public static void b(Object obj, String str) {
        if (a(6)) {
            a(6, obj, str, null, false);
        }
    }

    public static void c(Object obj, String str) {
        if (a(4)) {
            a(4, obj, str, null, false);
        }
    }

    public static void d(Object obj, String str) {
        if (a(5)) {
            a(5, obj, str, null, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r6, java.lang.Object r7, java.lang.String r8, java.lang.Throwable r9, boolean r10) {
        /*
            r0 = 0
            if (r10 == 0) goto L1e
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            int r2 = r1.length
            r3 = 4
            if (r2 <= r3) goto L12
            r1 = r1[r3]
            goto L13
        L12:
            r1 = r0
        L13:
            if (r1 == 0) goto L1e
            java.lang.String r2 = r1.getFileName()
            int r1 = r1.getLineNumber()
            goto L20
        L1e:
            r1 = 0
            r2 = r0
        L20:
            java.lang.String r3 = "xpui"
            if (r10 != 0) goto L26
            if (r9 == 0) goto L77
        L26:
            java.lang.StringBuilder r8 = defpackage.jg.a(r8)
            if (r10 == 0) goto L65
            java.lang.String r10 = " (T:"
            r8.append(r10)
            java.lang.Thread r10 = java.lang.Thread.currentThread()
            long r4 = r10.getId()
            r8.append(r4)
            java.lang.String r10 = ")"
            r8.append(r10)
            java.lang.String r4 = "(C:"
            r8.append(r4)
            r8.append(r3)
            r8.append(r10)
            java.lang.String r4 = "at ("
            r8.append(r4)
            if (r2 != 0) goto L56
            java.lang.String r4 = ""
            goto L57
        L56:
            r4 = r2
        L57:
            r8.append(r4)
            java.lang.String r4 = ":"
            r8.append(r4)
            r8.append(r1)
            r8.append(r10)
        L65:
            if (r9 == 0) goto L73
            r10 = 10
            r8.append(r10)
            java.lang.String r9 = android.util.Log.getStackTraceString(r9)
            r8.append(r9)
        L73:
            java.lang.String r8 = r8.toString()
        L77:
            if (r7 != 0) goto L7b
            r7 = r0
            goto L91
        L7b:
            boolean r9 = r7 instanceof java.lang.String
            if (r9 == 0) goto L82
            java.lang.String r7 = (java.lang.String) r7
            goto L91
        L82:
            boolean r9 = r7 instanceof java.lang.Class
            if (r9 == 0) goto L89
            java.lang.Class r7 = (java.lang.Class) r7
            goto L8d
        L89:
            java.lang.Class r7 = r7.getClass()
        L8d:
            java.lang.String r7 = r7.getSimpleName()
        L91:
            if (r7 != 0) goto L9c
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 == 0) goto L9b
            r7 = r3
            goto L9c
        L9b:
            r7 = r2
        L9c:
            be0$b r9 = defpackage.be0.a
            be0$a r9 = (defpackage.be0.a) r9
            r9.a(r6, r8, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.be0.a(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }
}
