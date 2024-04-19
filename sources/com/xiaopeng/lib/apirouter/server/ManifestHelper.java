package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class ManifestHelper {
    public static HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    static {
        Pair<IBinder, String> pair = new Pair<>(new IpcRouterService_Stub(), IpcRouterService_Manifest.toJsonManifest());
        for (String str : IpcRouterService_Manifest.getKey()) {
            mapping.put(str, pair);
        }
        Pair<IBinder, String> pair2 = new Pair<>(new VuiObserver_Stub(), VuiObserver_Manifest.toJsonManifest());
        for (String str2 : VuiObserver_Manifest.getKey()) {
            mapping.put(str2, pair2);
        }
        Pair<IBinder, String> pair3 = new Pair<>(new OpenApiService_Stub(), OpenApiService_Manifest.toJsonManifest());
        for (String str3 : OpenApiService_Manifest.getKey()) {
            mapping.put(str3, pair3);
        }
    }
}
