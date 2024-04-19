package com.xiaopeng.chargecontrol.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
/* loaded from: classes.dex */
public class CoreService extends Service {
    public c10 c;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i("CoreService", "onCreate() called");
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager.getNotificationChannel("Channel:Core") == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("Channel:Core", "Core", 3));
        }
        startForeground(1, new Notification.Builder(this, "Channel:Core").build());
        this.c = new c10();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i("CoreService", "onDestroy() called");
        this.c.a();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
