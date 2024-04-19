package defpackage;

import defpackage.nf;
/* compiled from: VuiRecyclerViewScrollListener.java */
/* renamed from: bf0  reason: default package */
/* loaded from: classes.dex */
public class bf0 extends nf.s {
    public qe0 a;

    public bf0(qe0 qe0Var) {
        this.a = null;
        this.a = qe0Var;
    }

    @Override // defpackage.nf.s
    public void onScrollStateChanged(nf nfVar, int i) {
        qe0 qe0Var;
        super.onScrollStateChanged(nfVar, i);
        if (i != 0 || (qe0Var = this.a) == null) {
            return;
        }
        qe0Var.c0();
    }
}
