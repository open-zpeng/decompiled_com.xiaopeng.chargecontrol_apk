package com.xiaopeng.speech.vui.cache;

import android.text.TextUtils;
import com.xiaopeng.speech.vui.utils.LogUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class VuiSceneBuildCache extends VuiSceneCache {
    public ConcurrentMap<String, String> displayLocations = new ConcurrentHashMap();

    public VuiSceneBuildCache() {
        this.mUploadedMap = new ConcurrentHashMap();
        this.mPre = "build_";
    }

    @Override // com.xiaopeng.speech.vui.cache.VuiSceneCache
    public synchronized String getDisplayCache(String str) {
        return this.displayLocations.get(str);
    }

    public void removeDisplayLocation(String str) {
        if (this.displayLocations.containsKey(str)) {
            this.displayLocations.remove(str);
        }
    }

    public void setDisplayLocation(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogUtils.e("VuiSceneBuildCache", "sceneId is null");
        } else if (TextUtils.isEmpty(str2)) {
            LogUtils.e("VuiSceneBuildCache", "displayLocation is null");
        } else {
            LogUtils.d("VuiSceneBuildCache", "sceneid:" + str + ",displayLocation:" + str2);
            this.displayLocations.put(str, str2);
        }
    }
}
