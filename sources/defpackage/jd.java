package defpackage;

import androidx.fragment.app.Fragment;
import defpackage.vd;
/* compiled from: FragmentViewLifecycleOwner.java */
/* renamed from: jd  reason: default package */
/* loaded from: classes.dex */
public class jd implements ud, wf, oe {
    public final ne c;
    public ae d = null;
    public vf e = null;

    public jd(Fragment fragment, ne neVar) {
        this.c = neVar;
    }

    public void a() {
        if (this.d == null) {
            this.d = new ae(this);
            this.e = new vf(this);
        }
    }

    @Override // defpackage.zd
    public vd r() {
        a();
        return this.d;
    }

    @Override // defpackage.wf
    public uf u() {
        a();
        return this.e.b;
    }

    @Override // defpackage.oe
    public ne v() {
        a();
        return this.c;
    }

    public void a(vd.a aVar) {
        ae aeVar = this.d;
        aeVar.a("handleLifecycleEvent");
        aeVar.a(aVar.a());
    }
}
