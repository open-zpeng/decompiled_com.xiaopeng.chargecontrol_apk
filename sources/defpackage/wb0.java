package defpackage;

import android.util.Log;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
/* compiled from: ApiRouterOverallService.java */
/* renamed from: wb0  reason: default package */
/* loaded from: classes.dex */
public class wb0 implements IServicePublisher {
    @Publish
    public void a(String str, String str2) {
        Log.d("ApiRouterOverallService", "消息接收 event== " + str + ",data:" + str2);
        ac0.b().a(str, str2);
    }

    @Publish
    public void a(String str, String str2, String str3) {
        Log.d("ApiRouterOverallService", "消息接收 event== " + str + ",data:" + str2);
        ac0.b().a(str, str2, str3);
    }
}
