package com.xiaopeng.lib.framework.ipcmodule;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AgentService extends Service {
    public static final String CHANNEL_ID = "XPENG";
    public static final String CHANNEL_NAME = "IPC";
    public static final String CONTENT = "IPC application is running";
    public static final String TAG = "AgentService";
    public static final String TITLE = "Xmart";

    private void startNotification() {
        Bundle bundle;
        Bundle bundle2;
        int i = Build.VERSION.SDK_INT;
        Log.i(TAG, "startNotification");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 3);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).createNotificationChannel(notificationChannel);
        String id = notificationChannel.getId();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Notification notification = new Notification();
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        ArrayList<String> arrayList4 = new ArrayList();
        notification.icon = R.mipmap.icon_notification;
        CharSequence a = i7.a(TITLE);
        CharSequence a2 = i7.a(CONTENT);
        new ArrayList();
        Bundle bundle3 = new Bundle();
        int i2 = Build.VERSION.SDK_INT;
        Notification.Builder builder = new Notification.Builder(this, id);
        Icon icon = null;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(a).setContentText(a2).setContentInfo(null).setContentIntent(null).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        int i3 = Build.VERSION.SDK_INT;
        builder.setSubText(null).setUsesChronometer(false).setPriority(3);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            h7 h7Var = (h7) it.next();
            int i4 = Build.VERSION.SDK_INT;
            IconCompat a3 = h7Var.a();
            int i5 = Build.VERSION.SDK_INT;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(a3 != null ? a3.e() : icon, h7Var.i, h7Var.j);
            l7[] l7VarArr = h7Var.c;
            if (l7VarArr != null) {
                RemoteInput[] remoteInputArr = new RemoteInput[l7VarArr.length];
                if (l7VarArr.length > 0) {
                    l7 l7Var = l7VarArr[0];
                    throw null;
                }
                for (RemoteInput remoteInput : remoteInputArr) {
                    builder2.addRemoteInput(remoteInput);
                }
            }
            Bundle bundle4 = h7Var.a;
            if (bundle4 != null) {
                bundle2 = new Bundle(bundle4);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android.support.allowGeneratedReplies", h7Var.d);
            int i6 = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(h7Var.d);
            bundle2.putInt("android.support.action.semanticAction", h7Var.f);
            int i7 = Build.VERSION.SDK_INT;
            builder2.setSemanticAction(h7Var.f);
            if (Build.VERSION.SDK_INT >= 29) {
                builder2.setContextual(h7Var.g);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", h7Var.b());
            builder2.addExtras(bundle2);
            builder.addAction(builder2.build());
            icon = null;
        }
        int i8 = Build.VERSION.SDK_INT;
        builder.setShowWhen(true);
        int i9 = Build.VERSION.SDK_INT;
        builder.setLocalOnly(false).setGroup(null).setGroupSummary(false).setSortKey(null);
        int i10 = Build.VERSION.SDK_INT;
        builder.setCategory("service").setColor(0).setVisibility(0).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        int i11 = Build.VERSION.SDK_INT;
        if (!arrayList4.isEmpty()) {
            for (String str : arrayList4) {
                builder.addPerson(str);
            }
        }
        if (arrayList3.size() > 0) {
            Bundle bundle5 = new Bundle();
            Bundle bundle6 = bundle5.getBundle("android.car.EXTENSIONS");
            if (bundle6 == null) {
                bundle6 = new Bundle();
            }
            Bundle bundle7 = new Bundle(bundle6);
            Bundle bundle8 = new Bundle();
            for (int i12 = 0; i12 < arrayList3.size(); i12++) {
                bundle8.putBundle(Integer.toString(i12), j7.a((h7) arrayList3.get(i12)));
            }
            bundle6.putBundle("invisible_actions", bundle8);
            bundle7.putBundle("invisible_actions", bundle8);
            if (bundle5 == null) {
                bundle5 = new Bundle();
            }
            bundle = bundle5;
            bundle.putBundle("android.car.EXTENSIONS", bundle6);
            bundle3.putBundle("android.car.EXTENSIONS", bundle7);
        } else {
            bundle = null;
        }
        int i13 = Build.VERSION.SDK_INT;
        int i14 = Build.VERSION.SDK_INT;
        builder.setExtras(bundle).setRemoteInputHistory(null);
        int i15 = Build.VERSION.SDK_INT;
        builder.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(id)) {
            builder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        int i16 = Build.VERSION.SDK_INT;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            builder.addPerson(((k7) it2.next()).a());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setAllowSystemGeneratedContextualActions(true);
            builder.setBubbleMetadata(null);
        }
        int i17 = Build.VERSION.SDK_INT;
        Notification build = builder.build();
        int i18 = Build.VERSION.SDK_INT;
        startForeground(100, build);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.i(TAG, "onCreate");
        startNotification();
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(TAG, "onStartCommand:\t" + i2 + "\tflgs:\t" + i);
        IpcServiceImpl.getInstance().init();
        return super.onStartCommand(intent, i, i2);
    }
}
