package com.xiaopeng.speech.vui.cache;

import android.text.TextUtils;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.utils.SceneMergeUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class VuiSceneCache {
    public String TAG = "VuiSceneCache";
    public ConcurrentMap<String, Boolean> mUploadedMap = null;
    public String mPre = null;
    public String BUILD_PRE = "build_";
    public String UPDATE_PRE = "update_";
    public String REMOVE_PRE = "remove_";
    public ConcurrentMap<String, List<sc0>> buildElementsMap = new ConcurrentHashMap();
    public ConcurrentMap<String, List<sc0>> updateElementsMap = new ConcurrentHashMap();
    public ConcurrentMap<String, List<String>> removeElementsMap = new ConcurrentHashMap();

    private sc0 findNode(sc0 sc0Var, String str) {
        if (sc0Var != null && !TextUtils.isEmpty(str)) {
            if (str.equals(sc0Var.getId())) {
                return sc0Var;
            }
            List<sc0> elements = sc0Var.getElements();
            if (elements != null) {
                for (sc0 sc0Var2 : elements) {
                    sc0 findNode = findNode(sc0Var2, str);
                    if (findNode != null) {
                        return findNode;
                    }
                }
            }
        }
        return null;
    }

    private sc0 getTagetElement(List<sc0> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            return null;
        }
        sc0 sc0Var = new sc0();
        sc0Var.setElements(list);
        sc0Var.setId("ab123");
        return findNode(sc0Var, str);
    }

    public synchronized List<sc0> addElementGroupToCache(String str, List<sc0> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            List<sc0> cache = getCache(str);
            if (cache != null) {
                cache.addAll(list);
            }
            return cache;
        }
        return null;
    }

    public synchronized List<sc0> getCache(String str) {
        if (str == null) {
            return null;
        }
        if (this.BUILD_PRE.equals(this.mPre)) {
            if (this.buildElementsMap != null && this.buildElementsMap.containsKey(str)) {
                return this.buildElementsMap.get(str);
            }
        } else if (this.UPDATE_PRE.equals(this.mPre) && this.updateElementsMap != null && this.updateElementsMap.containsKey(str)) {
            return this.updateElementsMap.get(str);
        }
        return null;
    }

    public synchronized String getDisplayCache(String str) {
        return "";
    }

    public synchronized List<sc0> getFusionCache(String str, List<sc0> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            List<sc0> cache = getCache(str);
            if (cache != null) {
                return SceneMergeUtils.merge(cache, list, z);
            }
            return list;
        }
        return null;
    }

    public int getFusionType(String str) {
        List<String> removeCache;
        List<sc0> cache;
        if (str == null) {
            return VuiSceneCacheFactory.CacheType.DEFAULT.getType();
        }
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (sceneCache != null && !sceneCache.getUploadedState(str)) {
            return VuiSceneCacheFactory.CacheType.BUILD.getType();
        }
        VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
        if (sceneCache2 != null && (cache = sceneCache2.getCache(str)) != null && !cache.isEmpty()) {
            return VuiSceneCacheFactory.CacheType.UPDATE.getType();
        }
        VuiSceneCache sceneCache3 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.REMOVE.getType());
        if (sceneCache3 != null && (removeCache = ((VuiSceneRemoveCache) sceneCache3).getRemoveCache(str)) != null && !removeCache.isEmpty()) {
            return VuiSceneCacheFactory.CacheType.REMOVE.getType();
        }
        VuiSceneCache sceneCache4 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION.getType());
        if (sceneCache4 != null && !TextUtils.isEmpty(sceneCache4.getDisplayCache(str))) {
            return VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION.getType();
        }
        return VuiSceneCacheFactory.CacheType.DEFAULT.getType();
    }

    public synchronized List<sc0> getUpdateFusionCache(String str, List<sc0> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            List<sc0> cache = getCache(str);
            if (cache != null) {
                return SceneMergeUtils.updateMerge(cache, list, z);
            }
            return list;
        }
        return null;
    }

    public boolean getUploadedState(String str) {
        ConcurrentMap<String, Boolean> concurrentMap;
        Boolean bool;
        if (str == null || (concurrentMap = this.mUploadedMap) == null || !concurrentMap.containsKey(str) || (bool = this.mUploadedMap.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public sc0 getVuiElementById(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getTagetElement(getCache(str), str2);
    }

    public void removeCache(String str) {
        if (str == null) {
            return;
        }
        if (this.BUILD_PRE.equals(this.mPre)) {
            if (this.buildElementsMap.containsKey(str)) {
                this.buildElementsMap.remove(str);
            }
        } else if (this.UPDATE_PRE.equals(this.mPre)) {
            if (this.updateElementsMap.containsKey(str)) {
                this.updateElementsMap.remove(str);
            }
        } else if (this.REMOVE_PRE.equals(this.mPre) && this.removeElementsMap.containsKey(str)) {
            this.removeElementsMap.remove(str);
        }
    }

    public synchronized List<sc0> removeElementFromCache(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<sc0> cache = getCache(str);
            if (cache != null) {
                SceneMergeUtils.removeElementById(cache, Arrays.asList(str2.split(CFCHelper.SIGNAL_CFC_SPLIT)));
            }
            return cache;
        }
        return null;
    }

    public void removeUploadState(String str) {
        ConcurrentMap<String, Boolean> concurrentMap;
        if (str == null || (concurrentMap = this.mUploadedMap) == null || !concurrentMap.containsKey(str)) {
            return;
        }
        this.mUploadedMap.remove(str);
    }

    public synchronized void setCache(String str, String str2) {
    }

    public void setUploadedState(String str, boolean z) {
        ConcurrentMap<String, Boolean> concurrentMap;
        if (str == null || (concurrentMap = this.mUploadedMap) == null) {
            return;
        }
        concurrentMap.put(str, Boolean.valueOf(z));
    }

    public synchronized void setCache(String str, List<sc0> list) {
        if (list == null && str == null) {
            return;
        }
        if (this.BUILD_PRE.equals(this.mPre)) {
            if (this.buildElementsMap != null) {
                this.buildElementsMap.put(str, list);
            }
        } else if (this.UPDATE_PRE.equals(this.mPre) && this.updateElementsMap != null) {
            this.updateElementsMap.put(str, list);
        }
    }
}
