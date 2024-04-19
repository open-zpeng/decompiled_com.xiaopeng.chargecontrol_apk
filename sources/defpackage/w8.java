package defpackage;

import android.net.Uri;
/* compiled from: FontsContractCompat.java */
/* renamed from: w8  reason: default package */
/* loaded from: classes.dex */
public class w8 {
    public final Uri a;
    public final int b;
    public final int c;
    public final boolean d;
    public final int e;

    @Deprecated
    public w8(Uri uri, int i, int i2, boolean z, int i3) {
        if (uri != null) {
            this.a = uri;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
            return;
        }
        throw new NullPointerException();
    }

    public int a() {
        return this.e;
    }
}
