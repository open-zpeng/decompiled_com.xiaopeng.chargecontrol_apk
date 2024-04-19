package com.xiaopeng.chargecontrol;

import android.app.ActivityThread;
import android.util.Log;
import androidx.annotation.Keep;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.lib.apirouter.server.ApplicationId;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.xuimanager.iot.BaseDevice;
import com.xiaopeng.xuimanager.iot.IoTManager;
import defpackage.f10;
import defpackage.fa0;
import defpackage.w90;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
@Keep
@ApplicationId("com.xiaopeng.chargecontrol")
/* loaded from: classes.dex */
public class OpenApiService implements IServicePublisher {
    public static String TAG = "OpenApiService";
    public final IoTManager mIot = IoTManager.getInstance();
    public boolean mIotInited = false;

    @Publish
    public int getFridgeSwitchStatus() {
        Map deviceProperties;
        String str;
        if (!this.mIotInited) {
            this.mIot.init(ActivityThread.currentApplication());
            this.mIotInited = true;
        }
        List device = this.mIot.getDevice("by_dev_type", "Fridge");
        boolean z = false;
        if (device != null && (deviceProperties = this.mIot.getDeviceProperties((BaseDevice) device.get(0))) != null && (str = (String) deviceProperties.get("error_code")) != null && !"-1".equals(str)) {
            z = true;
        }
        if (z) {
            return -1;
        }
        return x90.r();
    }

    @Publish
    public int getSolarWorkSt() {
        return ((kz) Objects.requireNonNull(CarApi.e().c.get("xp_spc"))).a(-1);
    }

    @Publish
    public String getTrunkPowerDelayOffTime() {
        int g = fa0.b.a.g();
        return MessageFormat.format("{0,choice,-1#长期开启|0#锁车即断电|0<锁车{0}小时后}", Integer.valueOf(g == 65535 ? -1 : (int) TimeUnit.MINUTES.toHours(g)));
    }

    @Publish
    public int getTrunkPowerSwitchStatus() {
        return x90.r();
    }

    @Publish
    public boolean hasFridge() {
        return a70.a();
    }

    @Publish
    public boolean hasSolarRoof() {
        return a70.b();
    }

    @Publish
    public void onReceiverData(int i, String str) {
        k00 k00Var = new k00(i, str);
        if (jl0.c().b(k00.class)) {
            jl0.c().b(k00Var);
        } else {
            jl0.c().c(k00Var);
        }
    }

    @Publish
    public boolean setFridgeSwitchStatus(boolean z) {
        String str = TAG;
        Log.i(str, "setFridgeSwitchStatus on = " + z);
        if (z && x90.n() < 40) {
            jb0.a(1, null, new Runnable() { // from class: j00
                @Override // java.lang.Runnable
                public final void run() {
                    z90.a((CharSequence) "续航较低，不支持开启尾箱电源");
                }
            }, null, false, 0L);
            return false;
        }
        int r = x90.r();
        String str2 = TAG;
        Log.i(str2, "setFridgeSwitchStatus  status= " + r);
        if (r == 1) {
            x90.b(false);
            return true;
        } else if (r != 2) {
            x90.b(true);
            x90.i(fa0.b.a.g());
            return true;
        } else {
            return false;
        }
    }

    @Publish
    public boolean tryClosePanel() {
        return a70.m() || !w90.b.a.b() || f10.b.a.a(h10.b) == 0;
    }
}
