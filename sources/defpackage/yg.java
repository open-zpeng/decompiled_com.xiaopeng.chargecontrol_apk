package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
/* compiled from: Util.java */
/* renamed from: yg  reason: default package */
/* loaded from: classes.dex */
public final class yg {
    public static final Charset a = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
