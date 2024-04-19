package defpackage;

import android.os.Process;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
/* compiled from: AppInfoUtils.java */
/* renamed from: mb0  reason: default package */
/* loaded from: classes.dex */
public class mb0 {
    public static String a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    public static String a() {
        BufferedReader bufferedReader;
        String str = a;
        if (str != null) {
            return str;
        }
        BufferedReader bufferedReader2 = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            a = bufferedReader.readLine().trim();
            z90.b(bufferedReader);
        } catch (Exception e2) {
            e = e2;
            bufferedReader3 = bufferedReader;
            e.printStackTrace();
            a = "";
            z90.b(bufferedReader3);
            bufferedReader2 = a;
            return bufferedReader2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            z90.b((Closeable) bufferedReader2);
            throw th;
        }
        bufferedReader2 = a;
        return bufferedReader2;
    }
}
