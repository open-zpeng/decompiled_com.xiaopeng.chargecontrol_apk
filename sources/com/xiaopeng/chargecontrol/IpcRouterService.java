package com.xiaopeng.chargecontrol;

import android.util.Log;
import androidx.annotation.Keep;
import com.xiaopeng.lib.apirouter.server.ApplicationId;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
@Keep
@ApplicationId("com.xiaopeng.chargecontrol")
/* loaded from: classes.dex */
public class IpcRouterService implements IServicePublisher {
    @Publish
    public void onReceiverData(int i, String str) {
        Log.i("OpenApiService", "接收消息中心推送 id=" + i + "bundle = " + str);
        k00 k00Var = new k00(i, str);
        if (jl0.c().b(k00.class)) {
            jl0.c().b(k00Var);
        } else {
            jl0.c().c(k00Var);
        }
    }
}
