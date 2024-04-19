package defpackage;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import defpackage.tx;
/* compiled from: ServerObserver.java */
/* renamed from: ux  reason: default package */
/* loaded from: classes.dex */
public class ux implements IServicePublisher {
    @Publish
    public String a(int i, String str, String str2, String str3) {
        try {
            vx.a("ServerOb", String.format("call-- type:%s , module:%s ,method:%s ,param:%s", Integer.valueOf(i), str, str2, vx.b(str3)));
            tx.b.a.a(i, str, str2, str3, null);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Publish
    public String a(int i, String str, String str2, String str3, byte[] bArr) {
        try {
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = str;
            objArr[2] = str2;
            Object obj = "";
            objArr[3] = str3 == null ? "" : Integer.valueOf(str3.length());
            if (bArr != null) {
                obj = Integer.valueOf(bArr.length);
            }
            objArr[4] = obj;
            vx.a("ServerOb", String.format("callBlob-- type:%s , module:%s ,method:%s ,param:%s ,blob-length:%s", objArr));
            tx.b.a.a(i, str, str2, str3, bArr);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
