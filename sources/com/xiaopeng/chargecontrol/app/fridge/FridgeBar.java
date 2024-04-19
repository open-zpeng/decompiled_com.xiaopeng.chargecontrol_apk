package com.xiaopeng.chargecontrol.app.fridge;

import android.app.ActivityThread;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.fridge.FridgeBar;
import com.xiaopeng.xuimanager.iot.BaseDevice;
import com.xiaopeng.xuimanager.iot.IDeviceListener;
import com.xiaopeng.xuimanager.iot.IoTManager;
import com.xiaopeng.xuimanager.iot.devices.FridgeDevice;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FridgeBar extends a60 {
    public volatile boolean H;
    public View I;
    public final IoTManager J;
    public jh0 K;
    public BaseDevice L;
    public boolean M;
    public final IDeviceListener N;
    public final Handler O;

    /* loaded from: classes.dex */
    public class a implements IDeviceListener {
        public a() {
        }

        public void onDeviceAdd(List<BaseDevice> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            BaseDevice baseDevice = list.get(0);
            if (baseDevice instanceof FridgeDevice) {
                jb0.a(new b(FridgeBar.this, baseDevice));
            }
        }

        public void onOperationResult(String str, String str2, String str3) {
        }

        public void onPropertiesUpdated(String str, Map<String, String> map) {
            BaseDevice baseDevice = FridgeBar.this.L;
            if (baseDevice == null || !baseDevice.getDeviceId().equals(str)) {
                return;
            }
            FridgeBar.this.f(map.get("error_code"));
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ha0<FridgeBar> {
        public final BaseDevice d;

        public b(FridgeBar fridgeBar, BaseDevice baseDevice) {
            super(fridgeBar);
            this.d = baseDevice;
        }

        @Override // defpackage.ha0
        public void a(FridgeBar fridgeBar) {
            fridgeBar.a(this.d);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ha0<FridgeBar> {
        public c(FridgeBar fridgeBar) {
            super(fridgeBar);
        }

        @Override // defpackage.ha0
        public void a(FridgeBar fridgeBar) {
            fridgeBar.y();
        }
    }

    /* loaded from: classes.dex */
    public static class d extends ha0<FridgeBar> {
        public d(FridgeBar fridgeBar) {
            super(fridgeBar);
        }

        @Override // defpackage.ha0
        public void a(FridgeBar fridgeBar) {
            fridgeBar.z();
        }
    }

    public FridgeBar(Context context) {
        this(context, null);
    }

    public final void f(String str) {
        this.H = (str == null || "-1".equals(str)) ? false : true;
        this.O.post(new Runnable() { // from class: u40
            @Override // java.lang.Runnable
            public final void run() {
                FridgeBar.this.x();
            }
        });
    }

    @Override // defpackage.a60, com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        jb0.a(new c(this));
    }

    @Override // defpackage.a60, com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        jb0.a(new d(this));
        this.K.c();
    }

    @Override // defpackage.a60
    public void u() {
        super.u();
        this.I = findViewById(R.id.open_fridge);
    }

    @Override // defpackage.a60
    public void v() {
        this.x = true;
        super.v();
        if (this.K == null) {
            this.K = new jh0();
        }
        this.K.c(z90.a(this.I, new rh0() { // from class: t40
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                iv.b();
            }
        }));
    }

    @Override // defpackage.a60
    public int w() {
        return R.layout.layout_fridge_bar;
    }

    @Override // defpackage.a60
    public void x() {
        super.x();
        if (this.H) {
            this.z.setText(R.string.fridge_fault);
            this.z.setTextColorResource(R.color.fridge_fault);
            this.I.setEnabled(false);
            z90.a("MainBottom", this.I, this.y);
            return;
        }
        this.z.setText(this.y.isChecked() ? R.string.fridge_power_enable : R.string.fridge_power_disable);
        this.z.setTextColorResource(this.y.isChecked() ? R.color.charging : R.color.sub_title);
        this.I.setEnabled(this.y.isChecked());
        z90.a("MainBottom", this.I, this.y);
    }

    public final void y() {
        synchronized (this.J) {
            if (this.M) {
                this.J.init(ActivityThread.currentApplication());
                this.J.registerListener(this.N);
                this.M = false;
                List device = this.J.getDevice("by_dev_type", "Fridge");
                if (device != null && !device.isEmpty()) {
                    a((BaseDevice) device.get(0));
                }
            }
        }
    }

    public final void z() {
        synchronized (this.J) {
            if (this.M) {
                return;
            }
            if (this.L != null) {
                this.J.unSubscribeNotifications(this.L);
            }
            this.J.unRegisterListener(this.N);
            this.J.reset();
            this.L = null;
            this.M = true;
        }
    }

    public FridgeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FridgeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = IoTManager.getInstance();
        this.M = true;
        this.N = new a();
        this.O = new Handler();
    }

    public final void a(BaseDevice baseDevice) {
        Map deviceProperties;
        synchronized (this.J) {
            this.L = baseDevice;
            this.J.unSubscribeNotifications(baseDevice);
            this.J.subscribeNotifications(baseDevice);
            deviceProperties = this.J.getDeviceProperties(baseDevice);
        }
        if (deviceProperties != null) {
            f((String) deviceProperties.get("error_code"));
        }
    }
}
