package defpackage;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import defpackage.vd;
/* compiled from: SavedStateRegistryController.java */
/* renamed from: vf  reason: default package */
/* loaded from: classes.dex */
public final class vf {
    public final wf a;
    public final uf b = new uf();

    public vf(wf wfVar) {
        this.a = wfVar;
    }

    public void a(Bundle bundle) {
        vd r = this.a.r();
        if (((ae) r).b == vd.b.INITIALIZED) {
            r.a(new Recreator(this.a));
            final uf ufVar = this.b;
            if (!ufVar.c) {
                if (bundle != null) {
                    ufVar.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                r.a(new td() { // from class: androidx.savedstate.SavedStateRegistry$1
                    @Override // defpackage.xd
                    public void a(zd zdVar, vd.a aVar) {
                        if (aVar == vd.a.ON_START) {
                            uf.this.e = true;
                        } else if (aVar == vd.a.ON_STOP) {
                            uf.this.e = false;
                        }
                    }
                });
                ufVar.c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        this.b.a(bundle);
    }
}
