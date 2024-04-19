package com.xiaopeng.chargecontrol.app;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.SolarRoofDialogService;
import com.xiaopeng.chargecontrol.widget.ThemeTextView;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.ky;
import java.text.DecimalFormat;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class SolarRoofDialogService extends Service {
    public ld0 c;
    public View d;
    public ThemeTextView e;
    public ThemeTextView f;
    public ThemeTextView g;
    public ImageView h;
    public boolean i;
    public final DecimalFormat j = new DecimalFormat("#.###");
    public final DecimalFormat k = new DecimalFormat("#.#");

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(0);
        a(R.drawable.bg_solar_roof_dialog_new);
    }

    @Override // android.app.Service
    public void onCreate() {
        if (this.c == null) {
            j10 j10Var = new j10(this, this, R.style.SolarRoofDialogStyle);
            j10Var.e.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: o00
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    SolarRoofDialogService.this.a(dialogInterface);
                }
            });
            j10Var.c(2048);
            j10Var.a(R.layout.dialog_solar_roof_new, false);
            j10Var.d(R.string.solar_roof);
            j10Var.a(true);
            this.c = j10Var;
            this.d = this.c.b();
            ld0 ld0Var = this.c;
            ld0Var.a(SolarRoofDialogService.class.getSimpleName() + "_XpDialog", VuiEngine.getInstance(this));
            this.c.a(new ThemeViewModel.OnCallback() { // from class: p00
                @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
                public final void onThemeChanged() {
                    SolarRoofDialogService.this.a();
                }
            });
        }
        this.e = (ThemeTextView) this.d.findViewById(R.id.power);
        this.f = (ThemeTextView) this.d.findViewById(R.id.total_power);
        this.g = (ThemeTextView) this.d.findViewById(R.id.total_energy);
        this.h = (ImageView) this.d.findViewById(R.id.solar_roof_state_img);
        this.e.setText("--");
        this.e.setTextColorResource(R.color.sub_title);
        this.f.setText("--");
        this.f.setTextColorResource(R.color.sub_title);
        this.g.setText("--");
        this.g.setTextColorResource(R.color.sub_title);
        a(R.drawable.bg_solar_roof_dialog_new);
        iv.d(this);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        iv.e(this);
        super.onDestroy();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSolarPowerChanged(ky.a aVar) {
        this.e.setTextColorResource(R.color.title);
        this.e.setText(a(R.string.solar_roof_format_value, ((Float) aVar.a).floatValue(), this.j));
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSolarTotalPowerGenerationChanged(ky.b bVar) {
        this.f.setTextColorResource(R.color.title);
        this.f.setText(a(R.string.solar_roof_format_value, ((Float) bVar.a).floatValue(), this.j));
        this.g.setTextColorResource(R.color.title);
        this.g.setText(a(R.string.solar_roof_format_value, ((Float) bVar.a).floatValue() * 800.0f, this.k));
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSolarWorkingStateChanged(ky.c cVar) {
        this.i = ((Integer) cVar.a).intValue() == 1;
        a(this.i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if ("android.intent.action.showSolarRoofDialog".equals(intent.getAction())) {
            LogUtils.i("SolarRoofDialogService", "ShowSolarRoofDialogService()");
            ld0 ld0Var = this.c;
            if (ld0Var != null) {
                ld0Var.e();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public /* synthetic */ void a() {
        a(this.i);
    }

    public final void a(boolean z) {
        if (this.h == null) {
            return;
        }
        this.h.setVisibility(z ? 0 : 8);
        if (z) {
            lg.c(this).a(this.h);
            lg.c(this).a(z90.a(ThemeManager.isNightMode(getApplicationContext()) ? "solar_roof_night.webp" : "solar_roof.webp")).a(this.h);
            return;
        }
        lg.c(this).a(this.h);
    }

    public final CharSequence a(int i, float f, DecimalFormat decimalFormat) {
        String format = decimalFormat.format(f);
        String string = getString(i, new Object[]{format});
        for (int i2 = 0; i2 < string.length(); i2++) {
            if (!Character.isDigit(string.charAt(i2))) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.solar_roof_decimal_size)), i2, string.length(), 33);
                return spannableStringBuilder;
            }
        }
        return string;
    }

    public final void a(int i) {
        View view = this.d;
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }
}
