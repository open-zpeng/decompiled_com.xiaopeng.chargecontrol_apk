package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
/* compiled from: TintContextWrapper.java */
/* renamed from: k4  reason: default package */
/* loaded from: classes.dex */
public class k4 extends ContextWrapper {
    public static final Object a = new Object();

    public static Context a(Context context) {
        if (!(context instanceof k4) && !(context.getResources() instanceof m4) && !(context.getResources() instanceof q4)) {
            int i = Build.VERSION.SDK_INT;
            q4.a();
        }
        return context;
    }
}
