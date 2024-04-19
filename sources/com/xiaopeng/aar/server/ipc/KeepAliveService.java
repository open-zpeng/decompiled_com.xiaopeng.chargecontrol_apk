package com.xiaopeng.aar.server.ipc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class KeepAliveService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("Critical", "Critical", 3));
        startForeground(1, new Notification.Builder(this, "Critical").setContentTitle("KeepAliveService").setSmallIcon(mx.x_ic_logo).build());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
