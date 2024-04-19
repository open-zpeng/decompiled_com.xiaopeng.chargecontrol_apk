package com.xiaopeng.chargecontrol;

import android.util.Log;
import androidx.annotation.Keep;
import com.xiaopeng.lib.apirouter.server.ApplicationId;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
@Keep
@ApplicationId("com.xiaopeng.chargecontrol")
/* loaded from: classes.dex */
public class VuiObserver implements IServicePublisher {
    public static final String TAG = "VuiObserver";

    @Publish
    public String getElementState(String str, String str2) {
        Log.d(TAG, "getElementState() called with: sceneId = [" + str + "], elementId = [" + str2 + "]");
        return z90.b().getElementState(str, str2);
    }

    @Publish
    public void onEvent(String str, String str2) {
        Log.d(TAG, "onEvent() called with: event = [" + str + "], data = [" + str2 + "]");
        z90.b().dispatchVuiEvent(str, str2);
    }
}
