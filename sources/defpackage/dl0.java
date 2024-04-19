package defpackage;

import com.bumptech.glide.integration.webp.WebpBitmapFactory;
/* compiled from: Segment.java */
/* renamed from: dl0  reason: default package */
/* loaded from: classes.dex */
public final class dl0 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public dl0 f;
    public dl0 g;

    public dl0() {
        this.a = new byte[WebpBitmapFactory.IN_TEMP_BUFFER_SIZE];
        this.e = true;
    }

    public dl0 a(dl0 dl0Var) {
        dl0Var.g = this;
        dl0Var.f = this.f;
        this.f.g = dl0Var;
        this.f = dl0Var;
        return dl0Var;
    }

    public dl0(dl0 dl0Var) {
        byte[] bArr = dl0Var.a;
        int i = dl0Var.b;
        int i2 = dl0Var.c;
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        dl0Var.d = true;
    }
}
