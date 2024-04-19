package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class ManifestHelper_PowerCenterApp implements IManifestHelper {
    public HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    @Override // com.xiaopeng.lib.apirouter.server.IManifestHelper
    public HashMap<String, Pair<IBinder, String>> getMapping() {
        Pair<IBinder, String> pair = new Pair<>(new ChargecontrolSpeechObserver_Stub(), ChargecontrolSpeechObserver_Manifest.toJsonManifest());
        for (String str : ChargecontrolSpeechObserver_Manifest.getKey()) {
            this.mapping.put(str, pair);
        }
        return this.mapping;
    }
}
