package defpackage;
/* compiled from: IntegerArrayAdapter.java */
/* renamed from: ik  reason: default package */
/* loaded from: classes.dex */
public final class ik implements bk<int[]> {
    @Override // defpackage.bk
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // defpackage.bk
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // defpackage.bk
    public int b() {
        return 4;
    }

    @Override // defpackage.bk
    public int[] newArray(int i) {
        return new int[i];
    }
}
