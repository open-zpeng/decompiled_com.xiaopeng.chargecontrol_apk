package defpackage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.xiaopeng.libtheme.ThemeManager;
import defpackage.i10;
/* compiled from: BaseFragment.java */
/* renamed from: z00  reason: default package */
/* loaded from: classes.dex */
public abstract class z00<V, P extends i10<V>> extends Fragment implements d10 {
    public P a0;

    @Override // androidx.fragment.app.Fragment
    public void Q0() {
        this.a0.a();
        this.H = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int w1 = w1();
        if (w1 == 0) {
            return null;
        }
        return layoutInflater.inflate(w1, viewGroup, false);
    }

    public void b(View view, Bundle bundle) {
    }

    @Override // defpackage.d10
    public void b(m10 m10Var) {
        a(m10Var, true);
    }

    public void e(String str) {
        a(T().c.c(str));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.H = true;
        if (ThemeManager.isThemeChanged(configuration)) {
            p(ThemeManager.isNightMode(s1()));
        }
    }

    public void p(boolean z) {
    }

    public abstract P v1();

    public int w1() {
        return 0;
    }

    public void x1() {
        e("Charge.XDialogFragment");
    }

    @Override // androidx.fragment.app.Fragment
    public final void a(View view, Bundle bundle) {
        b(view, bundle);
        this.a0 = v1();
        this.a0.a(this);
    }

    public void a(m10 m10Var, boolean z) {
        a(m10Var, "Charge.XDialogFragment", z);
    }

    public void a(m10 m10Var, String str, boolean z) {
        Fragment c = T().c.c(str);
        if (c != null) {
            if (!z) {
                return;
            }
            ((m10) c).v1();
        }
        m10Var.b(T(), str);
    }

    @Override // defpackage.d10
    public void a(m10 m10Var) {
        a((Fragment) m10Var);
    }

    public void a(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        xc a = T().a();
        a.a(fragment);
        a.a();
    }
}
