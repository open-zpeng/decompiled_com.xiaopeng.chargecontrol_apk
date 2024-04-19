package com.xiaopeng.chargecontrol.app;

import android.app.ActivityThread;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.TrunkPowerDialogService;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XSwitch;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.fa0;
import defpackage.jy;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class TrunkPowerDialogService extends Service {
    public boolean c = true;
    public XSwitch d;
    public XImageView e;
    public XLinearLayout f;
    public XTextView g;
    public kh0 h;
    public ld0 i;
    public ld0 j;
    public View k;

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        stopSelf();
    }

    /* renamed from: b */
    public final void a() {
        boolean isChecked = this.d.isChecked();
        boolean z = true;
        this.f.setEnabled(this.d.isEnabled() && isChecked);
        if (!this.d.isEnabled() || !isChecked) {
            z = false;
        }
        if (z) {
            lg.c(this).a(this.e);
            lg.c(this).a(z90.a(ThemeManager.isNightMode(getApplicationContext()) ? "trunk_power_night.webp" : "trunk_power.webp")).a((ImageView) this.e);
        } else {
            lg.c(this).a(this.e);
        }
        LogUtils.i("TrunkPowerDialogService", "updateView checked:" + isChecked + ",isEnabled:" + this.f.isEnabled());
    }

    public void c() {
        a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(0);
        if (a70.e()) {
            a(R.drawable.bg_trunk_power);
        } else if (a70.f()) {
            a(R.drawable.bg_trunk_power_new);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        if (this.i == null) {
            l10 l10Var = new l10(this, ActivityThread.currentApplication(), R.style.SolarRoofDialogStyle);
            l10Var.e.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: x00
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TrunkPowerDialogService.this.a(dialogInterface);
                }
            });
            l10Var.c(2048);
            l10Var.a(R.layout.dialog_trunk_power_new, false);
            l10Var.d(R.string.trunk_power_label);
            l10Var.a(true);
            this.i = l10Var;
            this.k = this.i.b();
            ld0 ld0Var = this.i;
            ld0Var.a(TrunkPowerDialogService.class.getSimpleName() + "_XpDialog", VuiEngine.getInstance(this));
            this.i.a(new ThemeViewModel.OnCallback() { // from class: v00
                @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
                public final void onThemeChanged() {
                    TrunkPowerDialogService.this.a();
                }
            });
        }
        this.e = (XImageView) this.k.findViewById(R.id.trunk_power_working);
        this.d = (XSwitch) this.k.findViewById(R.id.trunk_power_toggle);
        this.g = (XTextView) this.k.findViewById(R.id.trunk_power_config);
        this.f = (XLinearLayout) this.k.findViewById(R.id.trunk_power_config_container);
        if (a70.e()) {
            a(R.drawable.bg_trunk_power);
        } else if (a70.f()) {
            a(R.drawable.bg_trunk_power_new);
        }
        this.d.setCheckSoundEnable(true);
        this.d.setOnInterceptListener(new XSwitch.b() { // from class: u00
            @Override // com.xiaopeng.xui.widget.XSwitch.b
            public final boolean a(View view, boolean z) {
                return TrunkPowerDialogService.this.a(view, z);
            }
        });
        this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: y00
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TrunkPowerDialogService.this.a(compoundButton, z);
            }
        });
        this.h = z90.a(this.f, new rh0() { // from class: w00
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                TrunkPowerDialogService.this.a(obj);
            }
        });
        c();
        iv.d(this);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        iv.e(this);
        z90.a(this.h);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if ("android.intent.action.showTrunkPowerDialog".equals(intent.getAction())) {
            LogUtils.i("TrunkPowerDialogService", "showTrunkPowerDialogService()");
            ld0 ld0Var = this.i;
            if (ld0Var != null) {
                ld0Var.e();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onTrunkPowerOffDelayChanged(jy.d dVar) {
        int intValue = ((Integer) dVar.a).intValue();
        this.g.setText(MessageFormat.format(getResources().getText(R.string.trunk_power_configs).toString(), Integer.valueOf(intValue == 65535 ? -1 : (int) TimeUnit.MINUTES.toHours(intValue))));
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onTrunkPowerStateChanged(jy.e eVar) {
        int intValue = ((Integer) eVar.a).intValue();
        boolean z = intValue != 2;
        this.d.setEnabled(z);
        if (!z) {
            c();
        } else if (intValue != 3) {
            boolean z2 = intValue == 1;
            this.c = false;
            this.d.setPressed(true);
            this.d.setChecked(z2);
            this.c = true;
        }
    }

    public /* synthetic */ boolean a(View view, boolean z) {
        if (this.c) {
            if (z && x90.o() < 40) {
                e10 e10Var = new e10(ActivityThread.currentApplication(), u60.XDialogView);
                e10Var.c(2048);
                e10Var.g(R.string.toast_trunk_power_low_battery);
                e10Var.b(R.string.know_it);
                ld0 ld0Var = this.j;
                if (ld0Var != null) {
                    ld0Var.a();
                }
                this.j = e10Var;
                e10Var.f(2048);
                e10Var.e();
                return true;
            }
            int r = x90.r();
            if (r == 1) {
                x90.b(false);
                iv.a("P10142", "B001", VuiConstants.ELEMENT_TYPE, 2);
                return true;
            } else if (r != 2) {
                x90.b(true);
                iv.a("P10142", "B001", VuiConstants.ELEMENT_TYPE, 1);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        c();
        if (z) {
            x90.i(fa0.b.a.g());
        }
    }

    public /* synthetic */ void a(Object obj) {
        LogUtils.i("TrunkPowerDialogService", "onclick mConfigContainer()");
        Intent intent = new Intent();
        intent.setClassName(ActivityThread.currentApplication().getPackageName(), "com.xiaopeng.chargecontrol.app.TrunkPowerDelayOffTimeDialogService");
        intent.setAction("android.intent.action.showTrunkPowerDelayOffTimeDialog");
        intent.setPackage("com.xiaopeng.chargecontrol");
        intent.putExtra("from", "fridge");
        startService(intent);
    }

    public final void a(int i) {
        View view = this.k;
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }
}
