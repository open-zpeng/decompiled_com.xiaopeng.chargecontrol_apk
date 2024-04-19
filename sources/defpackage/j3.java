package defpackage;

import android.annotation.SuppressLint;
import android.view.View;
import defpackage.k3;
/* compiled from: AppCompatSpinner.java */
/* renamed from: j3  reason: default package */
/* loaded from: classes.dex */
public class j3 extends w3 {
    public final /* synthetic */ k3.d l;
    public final /* synthetic */ k3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(k3 k3Var, View view, k3.d dVar) {
        super(view);
        this.m = k3Var;
        this.l = dVar;
    }

    @Override // defpackage.w3
    public j2 b() {
        return this.l;
    }

    @Override // defpackage.w3
    @SuppressLint({"SyntheticAccessor"})
    public boolean c() {
        if (this.m.getInternalPopup().b()) {
            return true;
        }
        this.m.a();
        return true;
    }
}
