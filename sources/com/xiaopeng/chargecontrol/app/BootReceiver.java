package com.xiaopeng.chargecontrol.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("BootBroadcastReceiver", "onReceive() called with: action = [" + action + "]");
    }
}
