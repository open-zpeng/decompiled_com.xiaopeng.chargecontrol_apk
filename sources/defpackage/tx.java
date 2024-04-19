package defpackage;

import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.apirouter.server.IManifestHandler;
import com.xiaopeng.lib.apirouter.server.IManifestHelper;
import com.xiaopeng.lib.apirouter.server.ManifestHelper_aar;
/* compiled from: IpcServerImpl.java */
/* renamed from: tx  reason: default package */
/* loaded from: classes.dex */
public class tx implements sx {

    /* compiled from: IpcServerImpl.java */
    /* renamed from: tx$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final tx a = new tx(null);
    }

    public /* synthetic */ tx(a aVar) {
        vx.a("IpcSer", "IpcServerImpl");
        ApiPublisherProvider.addManifestHandler(new IManifestHandler() { // from class: rx
            @Override // com.xiaopeng.lib.apirouter.server.IManifestHandler
            public final IManifestHelper[] getManifestHelpers() {
                return tx.a();
            }
        });
    }

    public static /* synthetic */ IManifestHelper[] a() {
        return new IManifestHelper[]{new ManifestHelper_aar()};
    }

    public String a(int i, String str, String str2, String str3, byte[] bArr) {
        return null;
    }
}
