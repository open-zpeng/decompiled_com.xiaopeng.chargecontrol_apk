package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import defpackage.uf;
import defpackage.vd;
/* compiled from: FragmentActivity.java */
/* renamed from: zb  reason: default package */
/* loaded from: classes.dex */
public class zb implements uf.b {
    public final /* synthetic */ bc a;

    public zb(bc bcVar) {
        this.a = bcVar;
    }

    @Override // defpackage.uf.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        this.a.g();
        this.a.l.a(vd.a.ON_STOP);
        Parcelable t = this.a.k.a.f.t();
        if (t != null) {
            bundle.putParcelable("android:support:fragments", t);
        }
        return bundle;
    }
}
