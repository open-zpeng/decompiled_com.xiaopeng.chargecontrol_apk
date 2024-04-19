package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
/* compiled from: XDialogFragment.java */
/* renamed from: m10  reason: default package */
/* loaded from: classes.dex */
public class m10 extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public int a0 = u60.XDialogView;
    public boolean b0 = true;
    public boolean c0 = true;
    public int d0 = -1;
    public e10 e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;
    public CharSequence i0;
    public CharSequence j0;
    public CharSequence k0;
    public CharSequence l0;
    public int m0;
    public View n0;
    public md0 o0;
    public md0 p0;
    public boolean q0;

    @Override // androidx.fragment.app.Fragment
    public void Q0() {
        this.H = true;
        e10 e10Var = this.e0;
        if (e10Var != null) {
            this.f0 = true;
            e10Var.a();
            this.e0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void R0() {
        this.H = true;
        if (this.h0 || this.g0) {
            return;
        }
        this.g0 = true;
    }

    public void a(oc ocVar, String str) {
        this.g0 = false;
        this.h0 = true;
        xc a = ocVar.a();
        a.a(0, this, str, 1);
        a.a();
    }

    public void b(oc ocVar, String str) {
        this.g0 = false;
        this.h0 = true;
        xc a = ocVar.a();
        a.a(0, this, str, 1);
        a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater c(Bundle bundle) {
        if (!this.c0) {
            return super.c(bundle);
        }
        this.e0 = l(bundle);
        e10 e10Var = this.e0;
        if (e10Var != null) {
            return (LayoutInflater) e10Var.e.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) U().getSystemService("layout_inflater");
    }

    @Override // androidx.fragment.app.Fragment
    public void d(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.d(bundle);
        e10 e10Var = this.e0;
        if (e10Var != null && (onSaveInstanceState = e10Var.e.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.a0;
        if (i != 0) {
            bundle.putInt("android:theme", i);
        }
        boolean z = this.b0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.c0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i2 = this.d0;
        if (i2 != -1) {
            bundle.putInt("android:backStackId", i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void d1() {
        this.H = true;
        e10 e10Var = this.e0;
        if (e10Var != null) {
            this.f0 = false;
            if (!this.q0) {
                e10Var.e();
            } else {
                v1();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void e1() {
        this.H = true;
        e10 e10Var = this.e0;
        if (e10Var != null) {
            e10Var.e.hide();
        }
    }

    public <T extends View> T h(int i) {
        return (T) w1().b().findViewById(i);
    }

    public void i(int i) {
        this.a0 = i;
    }

    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(r1(), this.a0);
        e10Var.c(this.i0);
        CharSequence charSequence = this.j0;
        eg0 eg0Var = (eg0) e10Var.d.m;
        eg0Var.d();
        ag0 ag0Var = eg0Var.k;
        ag0Var.d.setText(charSequence);
        ag0Var.u();
        CharSequence charSequence2 = this.k0;
        md0 md0Var = this.o0;
        e10Var.b(charSequence2);
        e10Var.a(md0Var);
        e10Var.a(this.l0, this.p0);
        View view = this.n0;
        if (view != null) {
            e10Var.a(view);
        } else {
            int i = this.m0;
            if (i != 0) {
                e10Var.e(i);
            }
        }
        return e10Var;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f0) {
            return;
        }
        p(true);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
    }

    public void p(boolean z) {
        if (this.g0) {
            return;
        }
        this.g0 = true;
        this.h0 = false;
        e10 e10Var = this.e0;
        if (e10Var != null) {
            e10Var.a();
        }
        this.f0 = true;
        if (this.d0 >= 0) {
            c0().a(this.d0, 1);
            this.d0 = -1;
            return;
        }
        xc a = c0().a();
        a.a(this);
        if (z) {
            a.a();
        } else {
            ((ob) a).a(false);
        }
    }

    public void v1() {
        p(false);
    }

    public e10 w1() {
        return this.e0;
    }

    public void a(CharSequence charSequence) {
        this.j0 = charSequence;
        if (this.e0 != null) {
            eg0 eg0Var = (eg0) w1().d.m;
            eg0Var.d();
            ag0 ag0Var = eg0Var.k;
            ag0Var.d.setText(charSequence);
            ag0Var.u();
        }
    }

    public void b(CharSequence charSequence) {
        this.i0 = charSequence;
        if (this.e0 != null) {
            w1().c(this.i0);
        }
    }

    public void b(CharSequence charSequence, md0 md0Var) {
        this.k0 = charSequence;
        this.o0 = md0Var;
        if (this.e0 != null) {
            e10 w1 = w1();
            w1.b(charSequence);
            w1.a(md0Var);
        }
    }

    public void a(CharSequence charSequence, md0 md0Var) {
        this.l0 = charSequence;
        this.p0 = md0Var;
        if (this.e0 != null) {
            w1().a(charSequence, md0Var);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b(Bundle bundle) {
        int i;
        super.b(bundle);
        try {
            i = ((Integer) getClass().getField("mContainerId").get(this)).intValue();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            i = 0;
        }
        this.c0 = i == 0;
        if (bundle != null) {
            this.q0 = true;
            this.a0 = bundle.getInt("android:theme", 0);
            this.b0 = bundle.getBoolean("android:cancelable", true);
            this.c0 = bundle.getBoolean("android:showsDialog", this.c0);
            this.d0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        if (this.h0) {
            return;
        }
        this.g0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        Bundle bundle2;
        super.a(bundle);
        if (this.c0) {
            View w0 = w0();
            if (w0 != null) {
                if (w0.getParent() == null) {
                    this.e0.a(w0);
                } else {
                    throw new IllegalStateException("XDialogFragment can not be attached to a container view");
                }
            }
            bc r1 = r1();
            if (r1 != null) {
                this.e0.e.setOwnerActivity(r1);
            }
            this.e0.e.setCancelable(this.b0);
            this.e0.e.setOnShowListener(this);
            this.e0.e.setOnCancelListener(this);
            this.e0.e.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.e0.e.onRestoreInstanceState(bundle2);
        }
    }
}
