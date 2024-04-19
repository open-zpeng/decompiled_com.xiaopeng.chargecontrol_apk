package defpackage;

import android.app.ActivityThread;
import android.content.SharedPreferences;
import android.util.Log;
/* compiled from: SpUtil.java */
/* renamed from: fa0  reason: default package */
/* loaded from: classes.dex */
public class fa0 {
    public SharedPreferences a = ActivityThread.currentApplication().getSharedPreferences("charge", 0);

    /* compiled from: SpUtil.java */
    /* renamed from: fa0$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final fa0 a = new fa0(null);
    }

    public /* synthetic */ fa0(a aVar) {
    }

    public SharedPreferences.Editor a() {
        return this.a.edit();
    }

    public void b(boolean z) {
        this.a.edit().putBoolean("charge_error_dialog_show", z).apply();
        Log.i("SpUtil", "setChargeErrorDialogShow hasShow = " + z);
    }

    public void c(boolean z) {
        this.a.edit().putBoolean("lfp_first_unfull_charged_hinted", z).apply();
    }

    public int d() {
        return this.a.getInt("keep_temp_appoint_time_repeat_type", 2);
    }

    public long e() {
        return this.a.getLong("lfp_full_charged_time", 0L);
    }

    public int f() {
        return this.a.getInt("previous_charge_status", 0);
    }

    public int g() {
        return this.a.getInt("trunk_power_delay_off_time", 0);
    }

    public boolean h() {
        boolean z = true;
        if (y60.a != 1 && !this.a.getBoolean("battery_protect_mode", true)) {
            z = false;
        }
        Log.i("SpUtil", "isBatteryProtectMode: " + z);
        return z;
    }

    public boolean i() {
        return this.a.getBoolean("lfp_first_unfull_charged_hinted", false);
    }

    public boolean j() {
        return this.a.getBoolean("lfp_unfull_charged", false);
    }

    public void a(int i) {
        Log.i("SpUtil", "setStartChargingSoc soc=" + i);
        this.a.edit().putInt("KEY_START2CHARGE_ELEC", i).apply();
    }

    public int c() {
        return this.a.getInt("electricity_mode", 0);
    }

    public void d(boolean z) {
        this.a.edit().putBoolean("lfp_unfull_charged", z).apply();
    }

    public int b() {
        return this.a.getInt("charge_appointment_time_repeat_type", 2);
    }

    public void a(boolean z) {
        Log.i("SpUtil", "setBatteryProtectMode() called with: enable = [" + z + "]");
        this.a.edit().putBoolean("battery_protect_mode", z).apply();
    }

    public void a(String str) {
        this.a.edit().putString("lfp_unfull_charged_hint_message_id", str).apply();
    }
}
