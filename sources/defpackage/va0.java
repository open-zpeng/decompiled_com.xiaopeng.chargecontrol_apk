package defpackage;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: DataBackupHelper.java */
/* renamed from: va0  reason: default package */
/* loaded from: classes.dex */
public class va0 implements FilenameFilter {
    public final /* synthetic */ String a;

    public va0(ua0 ua0Var, String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.contains(this.a) && str.contains(".log");
    }
}
