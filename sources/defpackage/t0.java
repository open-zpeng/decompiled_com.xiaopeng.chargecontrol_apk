package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.l1;
import defpackage.n7;
import java.util.ArrayList;
/* compiled from: AppCompatActivity.java */
/* renamed from: t0  reason: default package */
/* loaded from: classes.dex */
public class t0 extends bc implements u0, n7.a, k0 {
    public v0 p;
    public Resources q;

    public t0() {
        u().a("androidx:appcompat", new r0(this));
        a(new s0(this));
    }

    private void d() {
        getWindow().getDecorView().setTag(pe.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(qe.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(tf.view_tree_saved_state_registry_owner, this);
    }

    @Override // defpackage.u0
    public l1 a(l1.a aVar) {
        return null;
    }

    public void a(Intent intent) {
        int i = Build.VERSION.SDK_INT;
        navigateUpTo(intent);
    }

    @Override // defpackage.u0
    public void a(l1 l1Var) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        k().a(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        w0 w0Var = (w0) k();
        w0Var.K = true;
        int a = w0Var.a(context, w0Var.e());
        Configuration configuration = null;
        if (w0.g0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(w0Var.a(context, a, (Configuration) null));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof n1) {
            try {
                ((n1) context).a(w0Var.a(context, a, (Configuration) null));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (w0.f0) {
            int i = Build.VERSION.SDK_INT;
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                if (configuration3.diff(configuration4) != 0) {
                    float f = configuration3.fontScale;
                    float f2 = configuration4.fontScale;
                    if (f != f2) {
                        configuration.fontScale = f2;
                    }
                    int i2 = configuration3.mcc;
                    int i3 = configuration4.mcc;
                    if (i2 != i3) {
                        configuration.mcc = i3;
                    }
                    int i4 = configuration3.mnc;
                    int i5 = configuration4.mnc;
                    if (i4 != i5) {
                        configuration.mnc = i5;
                    }
                    int i6 = Build.VERSION.SDK_INT;
                    LocaleList locales = configuration3.getLocales();
                    LocaleList locales2 = configuration4.getLocales();
                    if (!locales.equals(locales2)) {
                        configuration.setLocales(locales2);
                        configuration.locale = configuration4.locale;
                    }
                    int i7 = configuration3.touchscreen;
                    int i8 = configuration4.touchscreen;
                    if (i7 != i8) {
                        configuration.touchscreen = i8;
                    }
                    int i9 = configuration3.keyboard;
                    int i10 = configuration4.keyboard;
                    if (i9 != i10) {
                        configuration.keyboard = i10;
                    }
                    int i11 = configuration3.keyboardHidden;
                    int i12 = configuration4.keyboardHidden;
                    if (i11 != i12) {
                        configuration.keyboardHidden = i12;
                    }
                    int i13 = configuration3.navigation;
                    int i14 = configuration4.navigation;
                    if (i13 != i14) {
                        configuration.navigation = i14;
                    }
                    int i15 = configuration3.navigationHidden;
                    int i16 = configuration4.navigationHidden;
                    if (i15 != i16) {
                        configuration.navigationHidden = i16;
                    }
                    int i17 = configuration3.orientation;
                    int i18 = configuration4.orientation;
                    if (i17 != i18) {
                        configuration.orientation = i18;
                    }
                    int i19 = configuration3.screenLayout & 15;
                    int i20 = configuration4.screenLayout & 15;
                    if (i19 != i20) {
                        configuration.screenLayout |= i20;
                    }
                    int i21 = configuration3.screenLayout & ThemeManager.UI_MODE_THEME_MASK;
                    int i22 = configuration4.screenLayout & ThemeManager.UI_MODE_THEME_MASK;
                    if (i21 != i22) {
                        configuration.screenLayout |= i22;
                    }
                    int i23 = configuration3.screenLayout & 48;
                    int i24 = configuration4.screenLayout & 48;
                    if (i23 != i24) {
                        configuration.screenLayout |= i24;
                    }
                    int i25 = configuration3.screenLayout & 768;
                    int i26 = configuration4.screenLayout & 768;
                    if (i25 != i26) {
                        configuration.screenLayout |= i26;
                    }
                    int i27 = Build.VERSION.SDK_INT;
                    int i28 = configuration3.colorMode & 3;
                    int i29 = configuration4.colorMode & 3;
                    if (i28 != i29) {
                        configuration.colorMode |= i29;
                    }
                    int i30 = configuration3.colorMode & 12;
                    int i31 = configuration4.colorMode & 12;
                    if (i30 != i31) {
                        configuration.colorMode |= i31;
                    }
                    int i32 = configuration3.uiMode & 15;
                    int i33 = configuration4.uiMode & 15;
                    if (i32 != i33) {
                        configuration.uiMode |= i33;
                    }
                    int i34 = configuration3.uiMode & 48;
                    int i35 = configuration4.uiMode & 48;
                    if (i34 != i35) {
                        configuration.uiMode |= i35;
                    }
                    int i36 = configuration3.screenWidthDp;
                    int i37 = configuration4.screenWidthDp;
                    if (i36 != i37) {
                        configuration.screenWidthDp = i37;
                    }
                    int i38 = configuration3.screenHeightDp;
                    int i39 = configuration4.screenHeightDp;
                    if (i38 != i39) {
                        configuration.screenHeightDp = i39;
                    }
                    int i40 = configuration3.smallestScreenWidthDp;
                    int i41 = configuration4.smallestScreenWidthDp;
                    if (i40 != i41) {
                        configuration.smallestScreenWidthDp = i41;
                    }
                    int i42 = Build.VERSION.SDK_INT;
                    int i43 = configuration3.densityDpi;
                    int i44 = configuration4.densityDpi;
                    if (i43 != i44) {
                        configuration.densityDpi = i44;
                    }
                }
            }
            Configuration a2 = w0Var.a(context, a, configuration);
            n1 n1Var = new n1(context, h0.Theme_AppCompat_Empty);
            n1Var.a(a2);
            boolean z = false;
            try {
                if (context.getTheme() != null) {
                    z = true;
                }
            } catch (NullPointerException unused3) {
            }
            if (z) {
                Resources.Theme theme = n1Var.getTheme();
                if (Build.VERSION.SDK_INT >= 29) {
                    theme.rebase();
                } else {
                    v7.a(theme);
                }
            }
            context = n1Var;
        }
        super.attachBaseContext(context);
    }

    @Override // defpackage.u0
    public void b(l1 l1Var) {
    }

    public boolean b(Intent intent) {
        int i = Build.VERSION.SDK_INT;
        return shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        l();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // defpackage.g7, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        l();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        w0 w0Var = (w0) k();
        w0Var.g();
        return (T) w0Var.g.findViewById(i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        w0 w0Var = (w0) k();
        if (w0Var.k == null) {
            w0Var.k();
            j0 j0Var = w0Var.j;
            w0Var.k = new q1(j0Var != null ? j0Var.c() : w0Var.f);
        }
        return w0Var.k;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.q == null) {
            q4.a();
        }
        Resources resources = this.q;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        k().b();
    }

    @Override // defpackage.bc
    public void j() {
        k().b();
    }

    public v0 k() {
        if (this.p == null) {
            this.p = v0.a(this, this);
        }
        return this.p;
    }

    public j0 l() {
        w0 w0Var = (w0) k();
        w0Var.k();
        return w0Var.j;
    }

    public void m() {
    }

    public void n() {
    }

    @Deprecated
    public void o() {
    }

    @Override // defpackage.bc, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.q != null) {
            this.q.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        w0 w0Var = (w0) k();
        if (w0Var.B && w0Var.v) {
            w0Var.k();
            j0 j0Var = w0Var.j;
            if (j0Var != null) {
                j0Var.a(configuration);
            }
        }
        w2.a().a(w0Var.f);
        w0Var.a(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        o();
    }

    @Override // defpackage.bc, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k().c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = Build.VERSION.SDK_INT;
        return super.onKeyDown(i, keyEvent);
    }

    @Override // defpackage.bc, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        j0 l = l();
        if (menuItem.getItemId() != 16908332 || l == null || (l.b() & 4) == 0) {
            return false;
        }
        return p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // defpackage.bc, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((w0) k()).g();
    }

    @Override // defpackage.bc, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        w0 w0Var = (w0) k();
        w0Var.k();
        j0 j0Var = w0Var.j;
        if (j0Var != null) {
            j0Var.c(true);
        }
    }

    @Override // defpackage.bc, android.app.Activity
    public void onStart() {
        super.onStart();
        w0 w0Var = (w0) k();
        w0Var.M = true;
        w0Var.d();
    }

    @Override // defpackage.bc, android.app.Activity
    public void onStop() {
        super.onStop();
        w0 w0Var = (w0) k();
        w0Var.M = false;
        w0Var.k();
        j0 j0Var = w0Var.j;
        if (j0Var != null) {
            j0Var.c(false);
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        k().a(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        l();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public boolean p() {
        Intent b = b();
        if (b != null) {
            if (b(b)) {
                n7 n7Var = new n7(this);
                a(n7Var);
                n();
                if (!n7Var.c.isEmpty()) {
                    ArrayList<Intent> arrayList = n7Var.c;
                    Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                    intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                    o7.a(n7Var.d, intentArr, null);
                    try {
                        f7.a(this);
                        return true;
                    } catch (IllegalStateException unused) {
                        finish();
                        return true;
                    }
                }
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            a(b);
            return true;
        }
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        d();
        k().b(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((w0) k()).P = i;
    }

    public void a(n7 n7Var) {
        n7Var.a(this);
    }

    @Override // defpackage.n7.a
    public Intent b() {
        return a.a((Activity) this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        d();
        k().a(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        k().b(view, layoutParams);
    }
}
