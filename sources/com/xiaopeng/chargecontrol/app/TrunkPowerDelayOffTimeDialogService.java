package com.xiaopeng.chargecontrol.app;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.TrunkPowerDelayOffTimeDialogService;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.fa0;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class TrunkPowerDelayOffTimeDialogService extends Service {
    public static final int[] h = {0, 1, 3, 6, 12, 24};
    public ld0 c;
    public XNumberPicker d;
    public XTextView e;
    public XTextView f;
    public View g;

    public /* synthetic */ void a(ld0 ld0Var, int i) {
        int i2 = h[this.d.getValue()];
        x90.i(i2 != -1 ? (int) TimeUnit.HOURS.toMinutes(i2) : 65535);
        if (a70.a()) {
            iv.a("P10143", "B001", VuiConstants.ELEMENT_TYPE, Integer.valueOf(this.d.getValue() + 1));
        } else {
            iv.a("P10142", "B002", VuiConstants.ELEMENT_TYPE, Integer.valueOf(this.d.getValue() + 1));
        }
    }

    public /* synthetic */ String b(int i) {
        return MessageFormat.format(getResources().getText(R.string.trunk_power_configs).toString(), Integer.valueOf(h[i]));
    }

    public final void c(int i) {
        XTextView xTextView = this.e;
        if (xTextView != null) {
            xTextView.setVisibility(i == 0 ? 4 : 0);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.c == null) {
            ld0 b = new ld0(this, R.style.TrunkPowerDialogTheme, null).c(2048).b(false);
            b.e.setCanceledOnTouchOutside(true);
            ld0 a = b.a(R.layout.dialog_power_supply, false).a(R.string.confirm, new md0() { // from class: r00
                @Override // defpackage.md0
                public final void a(ld0 ld0Var, int i) {
                    TrunkPowerDelayOffTimeDialogService.this.a(ld0Var, i);
                }
            });
            a.e.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: q00
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TrunkPowerDelayOffTimeDialogService.this.a(dialogInterface);
                }
            });
            this.c = a.a(R.string.cancel);
            ld0 ld0Var = this.c;
            ld0Var.a(TrunkPowerDelayOffTimeDialogService.class.getSimpleName() + "_XpDialog", z90.b());
            this.c.a(new k10(this));
            this.g = this.c.b();
        }
        this.f = (XTextView) this.g.findViewById(R.id.title);
        this.d = (XNumberPicker) this.g.findViewById(R.id.delay_picker);
        this.e = (XTextView) this.g.findViewById(R.id.option_tips);
        this.d.setFormatter(new XNumberPicker.c() { // from class: t00
            @Override // com.xiaopeng.xui.widget.XNumberPicker.c
            public final String a(int i) {
                return TrunkPowerDelayOffTimeDialogService.this.b(i);
            }
        });
        this.d.setMinValue(0);
        this.d.setMaxValue(h.length - 1);
        this.d.setWrapSelectorWheel(false);
        int b2 = ((iz) CarApi.e().c()).b(fa0.b.a.g());
        int hours = b2 != 65535 ? (int) TimeUnit.MINUTES.toHours(b2) : -1;
        this.d.setValue(a(hours));
        c(a(hours));
        this.d.setOnValueChangedListener(new XNumberPicker.e() { // from class: s00
            @Override // com.xiaopeng.xui.widget.XNumberPicker.e
            public final void a(XNumberPicker xNumberPicker, int i, int i2) {
                TrunkPowerDelayOffTimeDialogService.this.a(xNumberPicker, i, i2);
            }
        });
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if ("android.intent.action.showTrunkPowerDelayOffTimeDialog".equals(intent.getAction()) && this.c != null) {
            this.f.setText(a70.a() ? R.string.dialog_trunk_power_fridge_title : R.string.dialog_trunk_power_title);
            this.e.setText(a70.a() ? R.string.dialog_trunk_power_option_fridge_tips : R.string.dialog_trunk_power_option_tips);
            this.c.e();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        stopSelf();
    }

    public /* synthetic */ void a(XNumberPicker xNumberPicker, int i, int i2) {
        XTextView xTextView = this.e;
        if (xTextView != null) {
            xTextView.setVisibility(i2 == 0 ? 4 : 0);
        }
    }

    public final int a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = h;
            if (i2 >= iArr.length) {
                return 0;
            }
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
    }
}
