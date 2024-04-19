package defpackage;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import defpackage.qx;
/* compiled from: ClientObserver.java */
/* renamed from: ox  reason: default package */
/* loaded from: classes.dex */
public class ox implements IServicePublisher {
    @Publish
    public void a(int i, String str, String str2, String str3, String str4) {
        try {
            qx.b.a.a(i, str, str2, str3, str4, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Publish
    public void a(int i, String str, String str2, String str3, String str4, byte[] bArr) {
        try {
            qx.b.a.a(i, str, str2, str3, str4, bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
