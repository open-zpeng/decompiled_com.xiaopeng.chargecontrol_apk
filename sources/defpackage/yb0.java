package defpackage;

import android.util.Log;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.speech.vui.VuiEngineImpl;
/* compiled from: ApiRouterUnitySceneService.java */
/* renamed from: yb0  reason: default package */
/* loaded from: classes.dex */
public class yb0 implements IServicePublisher {
    @Publish
    public String a(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = ub0.a;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getElementState(str, str2);
        }
        return null;
    }

    @Publish
    public void b(String str, String str2) {
        Log.i("ApiRouterUnityService", "消息接收 event== " + str + ",data:" + str2);
        VuiEngineImpl vuiEngineImpl = ub0.a;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.dispatchVuiEvent(str, str2);
        }
    }

    @Publish
    public void c(String str, String str2) {
        Log.i("ApiRouterUnityService", "消息接收 event== " + str + ",data:" + str2);
        VuiEngineImpl vuiEngineImpl = ub0.a;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.onVuiQuery(str, str2);
        }
    }
}
