package com.xiaopeng.chargecontrol.app.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.main.MainActivity;
import com.xiaopeng.chargecontrol.widget.ChargeLimitView;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageView;
import defpackage.nc;
import defpackage.oc;
import defpackage.r70;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class MainActivity extends ja0 implements g60, e60, View.OnClickListener, g10 {
    public ImageButton F;
    public ImageButton G;
    public XButton H;
    public ChargeLimitView I;
    public ImageView J;
    public ImageView K;
    public ImageView L;
    public ImageView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public XImageView Q;
    public ImageView R;
    public TextView S;
    public TextView T;
    public TextView U;
    public f60 V;
    public d60 W;
    public int X;
    public final jh0 E = new jh0();
    public oc.l Y = new a();
    public volatile boolean Z = false;

    public void B() {
        z();
    }

    public /* synthetic */ void b(Object obj) {
        b("tab_usage_normal");
    }

    @Override // defpackage.g60
    @SuppressLint({"SetTextI18n"})
    public void c(int i) {
        String num;
        if (r70.b.a.b() == 0) {
            if (!a70.f() && (i == -1 || x90.o() < 20)) {
                num = "--";
                this.N.setText(num);
                this.T.setText(num);
            }
        }
        num = Integer.toString(i);
        this.N.setText(num);
        this.T.setText(num);
    }

    @Override // defpackage.g60
    public void d(boolean z) {
        this.M.setVisibility(z ? 0 : 4);
    }

    @Override // defpackage.nd0, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.Z = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(int i) {
        Log.d("MainActivity", "updateElectricityMode: " + i);
        this.X = i;
        this.N.setVisibility(i == 0 ? 0 : 4);
        this.S.setVisibility(i == 0 ? 0 : 4);
        this.O.setVisibility(i == 1 ? 0 : 4);
        this.P.setVisibility(i == 1 ? 0 : 4);
        this.Q.setVisibility(i == 1 ? 0 : 4);
        this.T.setVisibility(i == 1 ? 0 : 4);
        this.U.setVisibility(i != 1 ? 4 : 0);
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return "Main";
    }

    @Override // defpackage.ja0
    public boolean isMainScene() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.close) {
            B();
        }
    }

    @Override // defpackage.t0, defpackage.bc, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ThemeManager.setWindowBackgroundResource(configuration, getWindow(), R.drawable.x_bg_app);
        this.V.b();
    }

    @Override // defpackage.ja0, defpackage.a10, defpackage.nd0, defpackage.bc, androidx.activity.ComponentActivity, defpackage.g7, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.F = (ImageButton) findViewById(R.id.close);
        this.G = (ImageButton) findViewById(R.id.help);
        this.H = (XButton) findViewById(R.id.open_solar_roof);
        this.F.setOnClickListener(this);
        this.H.setVisibility((a70.e() || !a70.b()) ? 8 : 0);
        this.E.c(z90.a(this.H, new rh0() { // from class: u50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                MainActivity.this.a(obj);
            }
        }));
        this.E.c(z90.a(this.G, new rh0() { // from class: t50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                MainActivity.this.b(obj);
            }
        }));
        this.I = (ChargeLimitView) findViewById(R.id.battery_limit);
        this.J = (ImageView) findViewById(R.id.charge_gun_fast);
        this.K = (ImageView) findViewById(R.id.charge_port_fast);
        this.L = (ImageView) findViewById(R.id.charge_gun_slow);
        this.M = (ImageView) findViewById(R.id.charge_port_slow);
        this.N = (TextView) findViewById(R.id.mileage);
        this.T = (TextView) findViewById(R.id.mileage_left);
        this.O = (TextView) findViewById(R.id.soc);
        this.P = (TextView) findViewById(R.id.soc_unit);
        this.Q = (XImageView) findViewById(R.id.center_line);
        this.S = (TextView) findViewById(R.id.mileage_unit);
        this.U = (TextView) findViewById(R.id.mileage_unit_left);
        this.R = (ImageView) findViewById(R.id.car_background);
        c(0);
        b(0);
        f().o.a.add(new nc.a(this.Y, false));
        this.V = new f60();
        this.V.a((g60) this);
        this.W = new d60();
        if ("gun".equals(getIntent().getStringExtra("from"))) {
            this.Z = true;
        }
        this.X = x90.l();
        this.N.setVisibility(this.X == 0 ? 0 : 4);
        this.O.setVisibility(this.X == 1 ? 0 : 4);
        this.P.setVisibility(this.X == 1 ? 0 : 4);
        this.Q.setVisibility(this.X == 1 ? 0 : 4);
        this.T.setVisibility(this.X == 1 ? 0 : 4);
        this.U.setVisibility(this.X == 1 ? 0 : 4);
        this.S.setVisibility(this.X != 0 ? 4 : 0);
    }

    @Override // defpackage.ja0, defpackage.a10, defpackage.t0, defpackage.bc, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        oc f = f();
        f.o.a(this.Y);
        this.E.c();
        this.V.a();
        ve0 ve0Var = z90.d;
        if (ve0Var != null) {
            ((xe0) ve0Var).c(1);
        }
    }

    @Override // defpackage.bc, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // defpackage.ja0, defpackage.a10, defpackage.nd0, defpackage.bc, android.app.Activity
    public void onResume() {
        super.onResume();
        if (a(getIntent().getData())) {
            getIntent().setData(null);
        }
    }

    @Override // defpackage.a10, defpackage.t0, defpackage.bc, android.app.Activity
    public void onStart() {
        super.onStart();
        this.W.a((e60) this);
    }

    @Override // defpackage.a10, defpackage.t0, defpackage.bc, android.app.Activity
    public void onStop() {
        this.W.a();
        super.onStop();
    }

    @Override // defpackage.ja0, defpackage.ka0
    public List<View> w() {
        return Collections.singletonList(findViewById(R.id.header));
    }

    public /* synthetic */ void a(Object obj) {
        b((m10) new t60());
    }

    @Override // defpackage.g60
    public void b(boolean z) {
        this.K.setVisibility(z ? 0 : 4);
    }

    @Override // defpackage.g60
    public void a(int i) {
        this.I.setLimit(i);
    }

    @Override // defpackage.g60
    public void b(int i) {
        TextView textView = this.O;
        textView.setText(i + "");
    }

    /* loaded from: classes.dex */
    public class a extends oc.l {
        public a() {
        }

        @Override // defpackage.oc.l
        public void a(oc ocVar, Fragment fragment, View view, Bundle bundle) {
            if (fragment.getClass() == n20.class) {
                MainActivity.this.R.setImageResource(R.drawable.img_light_charging);
            }
        }

        @Override // defpackage.oc.l
        public void a(oc ocVar, Fragment fragment) {
            if (fragment.getClass() == n20.class) {
                MainActivity.this.R.setImageResource(R.drawable.img_light_normal);
            }
        }
    }

    @Override // defpackage.g60
    public void a(boolean z) {
        this.J.setVisibility(z ? 0 : 4);
    }

    @Override // defpackage.ja0, defpackage.jc0
    public boolean b(View view, tc0 tc0Var) {
        ma0 a2 = z90.a(view);
        if (a2 == null || !a2.b(view, tc0Var)) {
            super.b(view, tc0Var);
            return false;
        }
        return true;
    }

    @Override // defpackage.e60
    public void a(Class<? extends Fragment> cls) {
        xc a2 = f().a();
        Fragment c = f().c.c("StageFragment");
        if (c == null || c.getClass() != cls) {
            A();
            Fragment fragment = null;
            try {
                fragment = cls.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                StringBuilder a3 = jg.a("Failed to switch fragment with class = [");
                a3.append(cls.getName());
                a3.append("] error = [");
                a3.append(e.getMessage());
                a3.append("]");
                Log.w("MainActivity", a3.toString());
            }
            if (fragment != null) {
                a2.a(R.id.fragment_container, fragment, "StageFragment");
            }
        }
        try {
            ob obVar = (ob) a2;
            obVar.c();
            obVar.q.b((oc.o) obVar, false);
        } catch (IllegalStateException e2) {
            Log.w("MainActivity", "Failed to commit FragmentTransaction, fallback to commitNowAllowingStateLoss()", e2);
            a2.b();
        }
    }

    public final void b(String str) {
        Fragment c = f().c.c("Charge.XDialogFragment");
        if (c instanceof b50) {
            ((b50) c).e(str);
        } else {
            b((m10) b50.f(str));
        }
    }

    @Override // defpackage.g60
    public void c(boolean z) {
        this.L.setVisibility(z ? 0 : 4);
    }

    @Override // defpackage.g10
    public boolean a(Uri uri) {
        List<String> pathSegments;
        if (!(uri != null && "xiaopeng".equals(uri.getScheme()) && "powercenter".equals(uri.getHost()) && (pathSegments = uri.getPathSegments()) != null && pathSegments.size() >= 1 && "main".equals(pathSegments.get(0)))) {
            Log.w("MainActivity", "navigate: invalid uri = [" + uri + "]");
            return false;
        }
        if ("speech".equals(uri.getQueryParameter("from"))) {
            this.Z = false;
        }
        String queryParameter = uri.getQueryParameter("page");
        if ("consumption".equals(queryParameter)) {
            b((m10) new p60());
            return true;
        } else if ("charge_chart".equals(queryParameter)) {
            b((m10) new v10());
            return true;
        } else if ("discharge_chart".equals(queryParameter)) {
            b((m10) new c40());
            return true;
        } else if ("solar_roof".equals(queryParameter)) {
            b((m10) new t60());
            return true;
        } else if ("fridge".equals(queryParameter)) {
            iv.b();
            return true;
        } else if ("charge_limit".equals(queryParameter)) {
            b(iv.a());
            return true;
        } else {
            if (h10.b.equals(uri)) {
                if (this.Z) {
                    B();
                    return true;
                }
            } else if ("introduction_keep_temp".equals(queryParameter)) {
                b("tab_battery_keep_temp");
                return true;
            } else if ("introduction_mileage_mode".equals(queryParameter)) {
                b("tab_mileage_mode");
                return true;
            } else if (h10.c.equals(uri)) {
                B();
                return true;
            }
            String queryParameter2 = uri.getQueryParameter("page");
            if ("main".equals(queryParameter2)) {
                A();
                String queryParameter3 = uri.getQueryParameter(VuiConstants.ELEMENT_POSITION);
                final View view = null;
                if ("charge_appointment".equals(queryParameter3)) {
                    view = findViewById(R.id.charge_appointment_bar);
                } else if ("keep_temp".equals(queryParameter3)) {
                    view = findViewById(R.id.keep_temp_bar);
                } else if ("trunk_power".equals(queryParameter3)) {
                    view = findViewById(R.id.trunk_power_bar);
                    if (view.getVisibility() != 0) {
                        view = findViewById(R.id.fridge_bar);
                    }
                } else if ("mileage_mode".equals(queryParameter3)) {
                    view = findViewById(R.id.distance_display_mode);
                } else if ("electricity_mode".equals(queryParameter3)) {
                    view = findViewById(R.id.electricity_display_mode);
                }
                if (view != null) {
                    view.post(new Runnable() { // from class: v50
                        @Override // java.lang.Runnable
                        public final void run() {
                            z90.a(view, 1, 0, 0);
                        }
                    });
                    return true;
                }
                return true;
            } else if ("trunk_power_time_dialog".equals(queryParameter2)) {
                View findViewById = findViewById(R.id.trunk_power_config_container);
                if (findViewById != null) {
                    findViewById.performClick();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
