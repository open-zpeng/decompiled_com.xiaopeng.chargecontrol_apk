package defpackage;

import android.util.Log;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.speech.vui.VuiEngineImpl;
/* compiled from: ApiRouterSceneService.java */
/* renamed from: xb0  reason: default package */
/* loaded from: classes.dex */
public class xb0 implements IServicePublisher {
    @Publish
    public String a(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = vb0.a;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getElementState(str, str2);
        }
        return null;
    }

    @Publish
    public void b(String str, String str2) {
        Log.i("ApiRouterSceneService", "消息接收 event== " + str + ",data:" + str2);
        VuiEngineImpl vuiEngineImpl = vb0.a;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.dispatchVuiEvent(str, str2);
        }
    }
}
