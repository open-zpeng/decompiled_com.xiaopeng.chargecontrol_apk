package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: DataBackupHelper.java */
/* renamed from: ua0  reason: default package */
/* loaded from: classes.dex */
public class ua0 {
    public static volatile ua0 a;

    /* compiled from: DataBackupHelper.java */
    /* renamed from: ua0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;

        public a(String str, String str2, Context context) {
            this.c = str;
            this.d = str2;
            this.e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            uu uuVar = new uu();
            uuVar.a("vehicleId", String.valueOf(hb0.e()));
            uuVar.a("message", this.c);
            String str2 = this.c;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str2.getBytes("UTF-8"));
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < digest.length; i++) {
                    if (Integer.toHexString(digest[i] & 255).length() == 1) {
                        stringBuffer.append("0");
                        stringBuffer.append(Integer.toHexString(digest[i] & 255));
                    } else {
                        stringBuffer.append(Integer.toHexString(digest[i] & 255));
                    }
                }
                str = stringBuffer.toString();
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                str = "";
            }
            uuVar.a("md5", str);
            byte[] bytes = new lu().a((ru) uuVar).getBytes();
            ua0.this.c(this.d, this.e);
            ua0.this.b(this.d, this.e);
            ua0.this.a(this.d, bytes, this.e);
        }
    }

    /* compiled from: DataBackupHelper.java */
    /* renamed from: ua0$b */
    /* loaded from: classes.dex */
    public class b implements FilenameFilter {
        public final /* synthetic */ String a;

        public b(ua0 ua0Var, String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && str.endsWith(".log");
        }
    }

    public static ua0 a() {
        if (a == null) {
            synchronized (ua0.class) {
                if (a == null) {
                    a = new ua0();
                }
            }
        }
        return a;
    }

    public final void b(String str, Context context) {
        String a2;
        boolean z;
        StringBuilder a3 = jg.a("/sdcard/Log/", str, "/");
        a3.append(context.getPackageName());
        File file = new File(a3.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list(new b(this, str));
        if (list == null) {
            return;
        }
        Arrays.sort(list);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            int lastIndexOf = str2.lastIndexOf("_");
            String str3 = str2.substring(lastIndexOf - 8, lastIndexOf) + "_000000";
            String a4 = fb0.a(System.currentTimeMillis());
            if (fb0.a(a4.substring(0, 8) + "_000000") - fb0.a(str3) > 604800000) {
                gb0.a("DataBackupHelper", str2 + " EXPIRED!");
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(str2);
                StringBuilder a5 = jg.a("/sdcard/Log/", str, "/");
                a5.append(context.getPackageName());
                a5.append("/");
                a5.append(str2);
                gb0.a("DataBackupHelper", "file: " + str2 + " is expired, deleted " + new File(a5.toString()).delete());
            }
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            String a6 = a((String) arrayList.get(0));
            if (list.length > size) {
                a2 = a(list[size]);
            } else {
                a2 = a((String) arrayList.get(size - 1));
            }
            IDataLog iDataLog = (IDataLog) Module.get(oa0.class).get(IDataLog.class);
            iDataLog.sendStatData(iDataLog.buildStat().setEventName("data_expire").setProperty("startTime", a6).setProperty("endTime", a2).build());
        }
    }

    public final void c(String str, Context context) {
        StringBuilder a2 = jg.a("/sdcard/Log/", str, "/");
        a2.append(context.getPackageName());
        File file = new File(a2.toString());
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public void a(String str, String str2, Context context) {
        jb0.a(0, new a(str2, str, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r7, byte[] r8, android.content.Context r9) {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/sdcard/Log/"
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = defpackage.jg.a(r1, r7, r2)
            java.lang.String r2 = r9.getPackageName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            va0 r1 = new va0
            r1.<init>(r6, r7)
            java.io.File[] r0 = r0.listFiles(r1)
            java.lang.String r1 = "DataBackupHelper"
            if (r0 == 0) goto L5e
            int r2 = r0.length
            if (r2 != 0) goto L29
            goto L5e
        L29:
            java.util.Arrays.sort(r0)
            int r2 = r0.length
            int r2 = r2 + (-1)
            r0 = r0[r2]
            java.lang.String r2 = r0.getName()
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = defpackage.fb0.a(r3)
            java.lang.String r4 = "_"
            int r4 = r3.indexOf(r4)
            r5 = 0
            java.lang.String r3 = r3.substring(r5, r4)
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L59
            long r2 = r0.length()
            r4 = 10485760(0xa00000, double:5.180654E-317)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L67
        L59:
            java.io.File r0 = r6.a(r7, r9)
            goto L67
        L5e:
            java.lang.String r0 = "create a new File"
            defpackage.gb0.a(r1, r0)
            java.io.File r0 = r6.a(r7, r9)
        L67:
            java.lang.String r7 = r0.getPath()
            java.lang.String r9 = ".log"
            java.lang.String r2 = ".zip"
            java.lang.String r7 = r7.replace(r9, r2)
            java.io.File r9 = new java.io.File
            r9.<init>(r7)
            boolean r7 = r9.exists()
            if (r7 == 0) goto L86
            java.lang.String r7 = "zipFile exists, delete .zip and write .log"
            defpackage.gb0.c(r1, r7)
            r9.delete()
        L86:
            r7 = 0
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "rw"
            r9.<init>(r0, r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            long r2 = r9.length()     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            r9.seek(r2)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            r9.write(r8)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            java.lang.String r7 = "\n"
            r9.writeBytes(r7)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            java.io.FileDescriptor r7 = r9.getFD()     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            r7.sync()     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            r7.<init>()     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            java.lang.String r2 = "write "
            r7.append(r2)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            r7.append(r0)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            java.lang.String r0 = " success, data.length:"
            r7.append(r0)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            int r8 = r8.length     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            r7.append(r8)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            defpackage.gb0.c(r1, r7)     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld4
            goto Ld0
        Lc2:
            r7 = move-exception
            goto Lc9
        Lc4:
            r8 = move-exception
            goto Ld7
        Lc6:
            r8 = move-exception
            r9 = r7
            r7 = r8
        Lc9:
            java.lang.String r8 = "write file fail!"
            defpackage.gb0.a(r1, r8, r7)     // Catch: java.lang.Throwable -> Ld4
            if (r9 == 0) goto Ld3
        Ld0:
            r9.close()     // Catch: java.lang.Exception -> Ld3
        Ld3:
            return
        Ld4:
            r7 = move-exception
            r8 = r7
            r7 = r9
        Ld7:
            if (r7 == 0) goto Ldc
            r7.close()     // Catch: java.lang.Exception -> Ldc
        Ldc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua0.a(java.lang.String, byte[], android.content.Context):void");
    }

    public final File a(String str, Context context) {
        String a2 = fb0.a(System.currentTimeMillis());
        StringBuilder a3 = jg.a("/sdcard/Log/", str, "/");
        a3.append(context.getPackageName());
        a3.append("/");
        a3.append(str);
        a3.append("_");
        return new File(jg.a(a3, a2, ".log"));
    }

    public final String a(String str) {
        return str.substring(str.lastIndexOf("_") - 8, str.lastIndexOf("."));
    }
}
