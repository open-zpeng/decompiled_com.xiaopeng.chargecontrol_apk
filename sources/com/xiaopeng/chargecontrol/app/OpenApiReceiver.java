package com.xiaopeng.chargecontrol.app;

import android.app.ActivityThread;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes.dex */
public class OpenApiReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("OpenApiReceiver", "onReceive() called with: action = [" + action + "]");
        if ("android.intent.action.showSolarRoofDialog".equals(action)) {
            Intent intent2 = new Intent(ActivityThread.currentApplication(), SolarRoofDialogService.class);
            intent2.setAction("android.intent.action.showSolarRoofDialog");
            intent2.setPackage("com.xiaopeng.chargecontrol");
            ActivityThread.currentApplication().startService(intent2);
        } else if ("android.intent.action.showTrunkPowerDelayOffTimeDialog".equals(action)) {
            String stringExtra = intent.getStringExtra("from");
            Intent intent3 = new Intent(ActivityThread.currentApplication(), TrunkPowerDelayOffTimeDialogService.class);
            intent3.setAction("android.intent.action.showTrunkPowerDelayOffTimeDialog");
            intent3.setPackage("com.xiaopeng.chargecontrol");
            intent3.putExtra("from", stringExtra);
            ActivityThread.currentApplication().startService(intent3);
        } else if ("android.intent.action.showTrunkPowerDialog".equals(action)) {
            Intent intent4 = new Intent(ActivityThread.currentApplication(), TrunkPowerDialogService.class);
            intent4.setAction("android.intent.action.showTrunkPowerDelayOffTimeDialog");
            intent4.setPackage("com.xiaopeng.chargecontrol");
            ActivityThread.currentApplication().startService(intent4);
        }
    }
}
