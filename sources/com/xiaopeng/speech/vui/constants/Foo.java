package com.xiaopeng.speech.vui.constants;

import android.app.ActivityThread;
import android.content.Context;
/* loaded from: classes.dex */
public class Foo {
    public static Context sContext;

    public static Context getContext() {
        return ActivityThread.currentApplication();
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
