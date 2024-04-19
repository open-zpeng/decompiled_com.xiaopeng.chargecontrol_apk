package defpackage;

import android.content.Context;
/* compiled from: StatEventHelper.java */
/* renamed from: cb0  reason: default package */
/* loaded from: classes.dex */
public class cb0 {
    public static volatile cb0 b;
    public xa0 a;

    public cb0(Context context) {
        this.a = new db0(context);
    }

    public static cb0 a() {
        if (b != null) {
            return b;
        }
        throw new IllegalStateException("has not init the StatEventHeler");
    }
}
