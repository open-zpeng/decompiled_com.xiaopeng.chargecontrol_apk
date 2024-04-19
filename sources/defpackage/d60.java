package defpackage;

import android.util.SparseArray;
import java.util.Objects;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: FragmentPresenter.java */
/* renamed from: d60  reason: default package */
/* loaded from: classes.dex */
public class d60 extends i10<e60> {
    public final SparseArray<b70> b = c70.b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(e60 e60Var) {
        this.a = e60Var;
        iv.d(this);
    }

    @tl0(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void onStateChanged(q70 q70Var) {
        b70 b70Var = this.b.get(q70Var.a);
        if (b70Var != null) {
            if (a70.c()) {
                Objects.requireNonNull(b70Var.b, "FragmentConfig.sibling must not be null in D21 platform");
            }
            ((e60) this.a).a(b70Var.a);
        }
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
