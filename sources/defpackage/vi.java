package defpackage;

import java.io.File;
/* compiled from: FileService.java */
/* renamed from: vi  reason: default package */
/* loaded from: classes.dex */
public class vi {
    public boolean a(File file) {
        return file.exists();
    }

    public long b(File file) {
        return file.length();
    }

    public File a(String str) {
        return new File(str);
    }
}
