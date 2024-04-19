package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* compiled from: ZipUtils.java */
/* renamed from: lb0  reason: default package */
/* loaded from: classes.dex */
public class lb0 {
    public static void a(ZipOutputStream zipOutputStream, File file, String str, boolean z) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (!file.isDirectory()) {
                byte[] bArr = new byte[4096];
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    z90.b(bufferedInputStream2);
                    z90.b(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    z90.b(bufferedInputStream2);
                    z90.b(fileInputStream);
                    throw th;
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        a(zipOutputStream, file2, str + file.getName() + "/", z);
                    }
                } else if (!z) {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getAbsolutePath() + "/"));
                    zipOutputStream.closeEntry();
                }
                fileInputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        z90.b(bufferedInputStream2);
        z90.b(fileInputStream);
    }

    public static File a(String str, List<String> list, boolean z) {
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                zipOutputStream = new ZipOutputStream(fileOutputStream);
                try {
                    for (String str2 : list) {
                        File file2 = new File(str2);
                        String parent = file2.getParent();
                        if (parent == null) {
                            parent = "";
                        }
                        a(zipOutputStream, file2, parent + "/", z);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    z90.b(zipOutputStream);
                    z90.b(fileOutputStream);
                    return new File(str);
                } catch (Throwable th) {
                    th = th;
                    z90.b(zipOutputStream);
                    z90.b(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            zipOutputStream = null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            if (byteArray != null && byteArray.length != 0) {
                return Base64.encodeToString(byteArray, 2);
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
