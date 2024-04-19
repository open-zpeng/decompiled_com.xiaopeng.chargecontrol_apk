package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import defpackage.nd0;
/* compiled from: BasePanelActivity.java */
@SuppressLint({"Registered"})
/* renamed from: a10  reason: default package */
/* loaded from: classes.dex */
public class a10 extends nd0 implements d10 {
    public final String D = getClass().getSimpleName();

    public void A() {
        a("Charge.XDialogFragment");
    }

    public void a(m10 m10Var, String str) {
        Fragment c = f().c.c(str);
        if (c != null) {
            ((m10) c).v1();
        }
        m10Var.a(f(), str);
    }

    @Override // defpackage.d10
    public void b(m10 m10Var) {
        a(m10Var, "Charge.XDialogFragment");
    }

    @Override // defpackage.nd0, defpackage.bc, androidx.activity.ComponentActivity, defpackage.g7, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = this.D;
        Log.i(str, "onCreate() called with: savedInstanceState = [" + bundle + "]");
    }

    @Override // defpackage.t0, defpackage.bc, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.i(this.D, "onDestroy() called");
    }

    @Override // defpackage.nd0, defpackage.bc, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.i(this.D, "onPause() called");
    }

    @Override // defpackage.nd0, defpackage.t0, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (getResources().getConfiguration().orientation == 2) {
            nd0.d x = x();
            x.f = 8388659;
            x.a();
        } else {
            nd0.d x2 = x();
            x2.f = 17;
            x2.a();
        }
        d(0);
        setFinishOnTouchOutside(false);
        h(true);
        g(true);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        Log.i(this.D, "onRestart() called");
    }

    @Override // defpackage.nd0, defpackage.bc, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.i(this.D, "onResume() called");
    }

    @Override // defpackage.t0, defpackage.bc, android.app.Activity
    public void onStart() {
        super.onStart();
        Log.i(this.D, "onStart() called");
    }

    @Override // defpackage.t0, defpackage.bc, android.app.Activity
    public void onStop() {
        super.onStop();
        Log.i(this.D, "onStop() called");
    }

    @Override // defpackage.d10
    public void a(m10 m10Var) {
        a((Fragment) m10Var);
    }

    public void a(String str) {
        a(f().c.c(str));
    }

    public void a(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        xc a = f().a();
        a.a(fragment);
        a.a();
    }
}
