package defpackage;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
/* compiled from: NotificationCompatJellybean.java */
/* renamed from: j7  reason: default package */
/* loaded from: classes.dex */
public class j7 {
    public static final Object a = new Object();

    public static Bundle a(h7 h7Var) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat a2 = h7Var.a();
        bundle2.putInt("icon", a2 != null ? a2.a() : 0);
        bundle2.putCharSequence("title", h7Var.i);
        bundle2.putParcelable("actionIntent", h7Var.j);
        Bundle bundle3 = h7Var.a;
        if (bundle3 != null) {
            bundle = new Bundle(bundle3);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", h7Var.d);
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(h7Var.c));
        bundle2.putBoolean("showsUserInterface", h7Var.e);
        bundle2.putInt("semanticAction", h7Var.f);
        return bundle2;
    }

    public static Bundle[] a(l7[] l7VarArr) {
        if (l7VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[l7VarArr.length];
        if (l7VarArr.length <= 0) {
            return bundleArr;
        }
        l7 l7Var = l7VarArr[0];
        new Bundle();
        throw null;
    }
}
