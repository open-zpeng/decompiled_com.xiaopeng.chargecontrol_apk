package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentContainer.java */
/* renamed from: hc  reason: default package */
/* loaded from: classes.dex */
public abstract class hc {
    public abstract View a(int i);

    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.a(context, str, bundle);
    }

    public abstract boolean b();
}
