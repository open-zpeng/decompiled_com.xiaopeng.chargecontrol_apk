package defpackage;
/* compiled from: BytesResource.java */
/* renamed from: kn  reason: default package */
/* loaded from: classes.dex */
public class kn implements vj<byte[]> {
    public final byte[] c;

    public kn(byte[] bArr) {
        a.a(bArr, "Argument must not be null");
        this.c = bArr;
    }

    @Override // defpackage.vj
    public byte[] a() {
        return this.c;
    }

    @Override // defpackage.vj
    public int b() {
        return this.c.length;
    }

    @Override // defpackage.vj
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // defpackage.vj
    public void d() {
    }
}
