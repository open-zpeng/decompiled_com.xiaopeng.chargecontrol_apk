package com.xiaopeng.speech.vui.actor;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class VuiEventHandler extends Handler {
    public static volatile VuiEventHandler instance;

    public VuiEventHandler() {
        super(Looper.getMainLooper());
    }

    public static VuiEventHandler getInstance() {
        if (instance == null) {
            synchronized (VuiEventHandler.class) {
                if (instance == null) {
                    instance = new VuiEventHandler();
                }
            }
        }
        return instance;
    }

    public void runMain(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        instance.post(runnable);
    }
}
