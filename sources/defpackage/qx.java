package defpackage;

import android.os.Binder;
import android.util.Log;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.apirouter.server.IManifestHandler;
import com.xiaopeng.lib.apirouter.server.IManifestHelper;
import com.xiaopeng.lib.apirouter.server.ManifestHelper_aar;
import defpackage.px;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: IpcImpl.java */
/* renamed from: qx  reason: default package */
/* loaded from: classes.dex */
public class qx implements px {
    public final CopyOnWriteArraySet<px.a> a = new CopyOnWriteArraySet<>();
    public ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();

    /* compiled from: IpcImpl.java */
    /* renamed from: qx$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final qx a = new qx(null);
    }

    public /* synthetic */ qx(a aVar) {
        vx.a("Ipc", "IpcImpl");
        ApiPublisherProvider.addManifestHandler(new IManifestHandler() { // from class: nx
            @Override // com.xiaopeng.lib.apirouter.server.IManifestHandler
            public final IManifestHelper[] getManifestHelpers() {
                return qx.a();
            }
        });
    }

    public static /* synthetic */ IManifestHelper[] a() {
        return new IManifestHelper[]{new ManifestHelper_aar()};
    }

    public void a(int i, String str, String str2, String str3, String str4, byte[] bArr) {
        int i2;
        if (i == 202) {
            int callingPid = Binder.getCallingPid();
            if (this.b.get(str) == null) {
                this.b.put(str, Integer.valueOf(callingPid));
                i2 = 1;
            } else {
                i2 = 2;
            }
            String format = String.format("onReceived--SERVER_NOTIFY_STARTED appId:%s, uid:%s, pid:%s, status:%s, %s", str, Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(callingPid), Integer.valueOf(i2), this.a);
            if (vx.a("Ipc", 4) && vx.a(4)) {
                Log.i(jg.a("aar=", "Ipc"), vx.a(format));
            }
            Iterator<px.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(str, i2);
            }
        } else if (this.b.get(str) == null) {
            this.b.put(str, Integer.valueOf(Binder.getCallingPid()));
        }
    }
}
