package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import defpackage.f7;
import defpackage.vd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: FragmentActivity.java */
/* renamed from: bc  reason: default package */
/* loaded from: classes.dex */
public class bc extends ComponentActivity implements f7.a, f7.b {
    public final jc k;
    public final ae l;
    public boolean m;
    public boolean n;
    public boolean o;

    /* compiled from: FragmentActivity.java */
    /* renamed from: bc$a */
    /* loaded from: classes.dex */
    public class a extends lc<bc> implements oe, m, v, sc {
        public a() {
            super(bc.this);
        }

        @Override // defpackage.sc
        public void a(oc ocVar, Fragment fragment) {
            bc.this.h();
        }

        @Override // defpackage.hc
        public boolean b() {
            Window window = bc.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // defpackage.zd
        public vd r() {
            return bc.this.l;
        }

        @Override // defpackage.m
        public OnBackPressedDispatcher t() {
            return bc.this.t();
        }

        @Override // defpackage.oe
        public ne v() {
            return bc.this.v();
        }

        @Override // defpackage.hc
        public View a(int i) {
            return bc.this.findViewById(i);
        }

        @Override // defpackage.v
        public u a() {
            return bc.this.a();
        }
    }

    public bc() {
        a aVar = new a();
        defpackage.a.a(aVar, (Object) "callbacks == null");
        this.k = new jc(aVar);
        this.l = new ae(this);
        this.o = true;
        u().a("android:support:fragments", new zb(this));
        a(new ac(this));
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.k.a.f.o().onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.m);
        printWriter.print(" mResumed=");
        printWriter.print(this.n);
        printWriter.print(" mStopped=");
        printWriter.print(this.o);
        if (getApplication() != null) {
            ((se) re.a(this)).b.a(str2, fileDescriptor, printWriter, strArr);
        }
        this.k.a.f.a(str, fileDescriptor, printWriter, strArr);
    }

    public oc f() {
        return this.k.a.f;
    }

    public void g() {
        do {
        } while (a(f(), vd.b.CREATED));
    }

    @Deprecated
    public void h() {
    }

    public void i() {
        this.l.a(vd.a.ON_RESUME);
        this.k.a.f.h();
    }

    @Deprecated
    public void j() {
        invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.k.a();
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.k.a();
        super.onConfigurationChanged(configuration);
        this.k.a.f.a(configuration);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.g7, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l.a(vd.a.ON_CREATE);
        this.k.a.f.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
            jc jcVar = this.k;
            return onCreatePanelMenu | jcVar.a.f.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.k.a.f.e();
        this.l.a(vd.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.k.a.f.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.k.a.f.a(menuItem);
        }
        return this.k.a.f.b(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.k.a.f.a(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.k.a();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.k.a.f.a(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.n = false;
        this.k.a.f.g();
        this.l.a(vd.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.k.a.f.b(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return a(view, menu) | this.k.a.f.b(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.k.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.k.a();
        super.onResume();
        this.n = true;
        this.k.a.f.d(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.k.a();
        super.onStart();
        this.o = false;
        if (!this.m) {
            this.m = true;
            oc ocVar = this.k.a.f;
            ocVar.E = false;
            ocVar.F = false;
            ocVar.M.a(false);
            ocVar.a(4);
        }
        this.k.a.f.d(true);
        this.l.a(vd.a.ON_START);
        oc ocVar2 = this.k.a.f;
        ocVar2.E = false;
        ocVar2.F = false;
        ocVar2.M.a(false);
        ocVar2.a(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.k.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.o = true;
        g();
        this.k.a.f.i();
        this.l.a(vd.a.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a(null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    @Deprecated
    public boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public static boolean a(oc ocVar, vd.b bVar) {
        boolean z = false;
        for (Fragment fragment : ocVar.n()) {
            if (fragment != null) {
                if (fragment.d0() != null) {
                    z |= a(fragment.T(), bVar);
                }
                jd jdVar = fragment.U;
                if (jdVar != null) {
                    jdVar.a();
                    if (jdVar.d.b.a(vd.b.STARTED)) {
                        ae aeVar = fragment.U.d;
                        aeVar.a("setCurrentState");
                        aeVar.a(bVar);
                        z = true;
                    }
                }
                if (fragment.T.b.a(vd.b.STARTED)) {
                    ae aeVar2 = fragment.T;
                    aeVar2.a("setCurrentState");
                    aeVar2.a(bVar);
                    z = true;
                }
            }
        }
        return z;
    }
}
