package defpackage;

import androidx.fragment.app.Fragment;
import defpackage.ed;
import defpackage.oc;
/* compiled from: FragmentTransition.java */
/* renamed from: ad  reason: default package */
/* loaded from: classes.dex */
public class ad implements Runnable {
    public final /* synthetic */ ed.a c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ m8 e;

    public ad(ed.a aVar, Fragment fragment, m8 m8Var) {
        this.c = aVar;
        this.d = fragment;
        this.e = m8Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((oc.d) this.c).a(this.d, this.e);
    }
}
