package com.xiaopeng.speech.vui.model;

import android.text.TextUtils;
import com.xiaopeng.speech.vui.VuiSceneManager;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
/* loaded from: classes.dex */
public class VuiScene {
    public String appVersion;
    public String displayLocation;
    public List<sc0> elements;
    public String packageName;
    public String sceneId;
    public long timestamp;
    public String vuiVersion;

    /* loaded from: classes.dex */
    public static class Builder {
        public long timestamp;
        public String sceneId = null;
        public String packageName = null;
        public String appVersion = null;

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public VuiScene build() {
            return new VuiScene(this);
        }

        public Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder sceneId(String str) {
            this.sceneId = str;
            return this;
        }

        public Builder timestamp(long j) {
            this.timestamp = j;
            return this;
        }
    }

    public String getDisplayLocation() {
        return this.displayLocation;
    }

    public List<sc0> getElements() {
        return this.elements;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public String getVersion() {
        return this.appVersion;
    }

    public String getVuiVersion() {
        return this.vuiVersion;
    }

    public void publish() {
        VuiSceneManager.instance().buildScene(this, true, true);
    }

    public void setDisplayLocation(String str) {
        this.displayLocation = str;
    }

    public void setElements(List<sc0> list) {
        this.elements = list;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setVersion(String str) {
        this.appVersion = str;
    }

    public void setVuiVersion(String str) {
        this.vuiVersion = str;
    }

    public String toString() {
        StringBuilder a = jg.a("VuiScene{sceneId='");
        jg.a(a, this.sceneId, '\'', ", elements=");
        a.append(this.elements);
        a.append(", packageName='");
        jg.a(a, this.packageName, '\'', ", appVersion='");
        jg.a(a, this.appVersion, '\'', ", timestamp=");
        a.append(this.timestamp);
        a.append('}');
        return a.toString();
    }

    public VuiScene(Builder builder) {
        this.sceneId = null;
        this.elements = null;
        this.packageName = null;
        this.appVersion = null;
        this.vuiVersion = "2.0";
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = builder.sceneId;
        this.packageName = builder.packageName;
        this.appVersion = builder.appVersion;
        this.timestamp = builder.timestamp;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (vuiSceneBuildCache != null) {
            String displayCache = vuiSceneBuildCache.getDisplayCache(this.sceneId);
            if (TextUtils.isEmpty(displayCache)) {
                return;
            }
            this.displayLocation = displayCache;
        }
    }

    public VuiScene() {
        this.sceneId = null;
        this.elements = null;
        this.packageName = null;
        this.appVersion = null;
        this.vuiVersion = "2.0";
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
    }
}
