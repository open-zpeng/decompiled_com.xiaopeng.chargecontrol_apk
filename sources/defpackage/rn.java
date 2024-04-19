package defpackage;

import java.io.File;
/* JADX WARN: Incorrect class signature, class is equals to this class: Lrn<Ljava/io/File;>; */
/* compiled from: FileResource.java */
/* renamed from: rn  reason: default package */
/* loaded from: classes.dex */
public class rn implements vj {
    public final T c;

    /* JADX WARN: Multi-variable type inference failed */
    public rn(File file) {
        a.a(file, "Argument must not be null");
        this.c = file;
    }

    @Override // defpackage.vj
    public final Object a() {
        return this.c;
    }

    @Override // defpackage.vj
    public final int b() {
        return 1;
    }

    @Override // defpackage.vj
    public Class c() {
        return this.c.getClass();
    }

    @Override // defpackage.vj
    public void d() {
    }
}
