package defpackage;

import java.util.Comparator;
/* compiled from: FontProvider.java */
/* renamed from: r8  reason: default package */
/* loaded from: classes.dex */
public class r8 {
    public static final Comparator<byte[]> a = new a();

    /* compiled from: FontProvider.java */
    /* renamed from: r8$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                i = bArr3.length;
                i2 = bArr4.length;
            } else {
                for (int i3 = 0; i3 < bArr3.length; i3++) {
                    if (bArr3[i3] != bArr4[i3]) {
                        i = bArr3[i3];
                        i2 = bArr4[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[LOOP:1: B:15:0x004d->B:30:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0096 A[EDGE_INSN: B:80:0x0096->B:32:0x0096 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.v8 a(android.content.Context r20, defpackage.s8 r21, android.os.CancellationSignal r22) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r8.a(android.content.Context, s8, android.os.CancellationSignal):v8");
    }
}
