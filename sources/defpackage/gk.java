package defpackage;
/* compiled from: ByteArrayAdapter.java */
/* renamed from: gk  reason: default package */
/* loaded from: classes.dex */
public final class gk implements bk<byte[]> {
    @Override // defpackage.bk
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // defpackage.bk
    public String a() {
        return "ByteArrayPool";
    }

    @Override // defpackage.bk
    public int b() {
        return 1;
    }

    @Override // defpackage.bk
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
