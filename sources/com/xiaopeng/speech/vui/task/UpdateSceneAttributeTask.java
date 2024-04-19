package com.xiaopeng.speech.vui.task;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.speech.vui.VuiSceneManager;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.task.base.BaseTask;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateSceneAttributeTask extends BaseTask {
    public String TAG;
    public String sceneId;
    public SoftReference<View> updateView;
    public List<SoftReference<View>> viewList;
    public TaskWrapper viewWrapper;

    public UpdateSceneAttributeTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.TAG = "VuiEngine_UpdateSceneAttributeTask";
        this.viewWrapper = taskWrapper;
        this.sceneId = taskWrapper.getSceneId();
        this.updateView = taskWrapper.getView();
        this.viewList = taskWrapper.getViewList();
    }

    private sc0 buildElement(VuiSceneCache vuiSceneCache, SoftReference<View> softReference, long j) {
        sc0 a;
        String elementId = getElementId(softReference);
        if (TextUtils.isEmpty(elementId)) {
            return null;
        }
        sc0 vuiElementById = vuiSceneCache.getVuiElementById(this.sceneId, elementId);
        if (vuiElementById == null) {
            LogUtils.e(this.TAG, "缓存中没有此元素");
            return null;
        } else if (softReference == null || !(softReference.get() instanceof hc0) || (a = ((hc0) softReference.get()).a(elementId, this)) == null) {
            sc0 buildVuiElementAttr = buildVuiElementAttr(softReference);
            if (buildVuiElementAttr == null || softReference == null) {
                return null;
            }
            buildVuiElementAttr.setId(elementId);
            ec0 ec0Var = (ec0) softReference.get();
            if (ec0Var == null) {
                return null;
            }
            JSONObject p = ec0Var.p();
            if (p != null) {
                if (mc0.STATEFULBUTTON.c.equals(buildVuiElementAttr.getType())) {
                    createElementByProps(softReference, buildVuiElementAttr, p, j, false, false);
                } else if (p.keys().hasNext()) {
                    buildVuiElementAttr.setProps((uu) this.mGson.a(p.toString(), (Class<Object>) uu.class));
                }
            }
            if (vuiElementById.isLayoutLoadable() != null && vuiElementById.isLayoutLoadable().booleanValue()) {
                buildVuiElementAttr.setLayoutLoadable(true);
            }
            buildVuiElementAttr.setTimestamp(j);
            if (buildVuiElementAttr.equals(vuiElementById)) {
                LogUtils.logDebug(this.TAG, "updateScene same");
                return null;
            }
            if (!mc0.STATEFULBUTTON.c.equals(buildVuiElementAttr.getType()) && vuiElementById.getElements() != null && vuiElementById.getElements().size() > 0) {
                buildVuiElementAttr.setElements(vuiElementById.getElements());
            }
            return buildVuiElementAttr;
        } else {
            return a;
        }
    }

    private String getElementId(SoftReference<View> softReference) {
        if (softReference == null || softReference.get() == null || !(softReference.get() instanceof ec0)) {
            return null;
        }
        String str = (String) softReference.get().getTag(R.id.vuiElementId);
        if (TextUtils.isEmpty(str)) {
            if (softReference.get().getTag() != null && (softReference.get().getTag() instanceof String)) {
                String str2 = (String) softReference.get().getTag();
                if (str2.startsWith("4657")) {
                    return str2;
                }
            }
            String g = ((ec0) softReference.get()).g();
            if (TextUtils.isEmpty(g)) {
                LogUtils.e(this.TAG, "update 元素的属性时必须是build过的元素");
                return null;
            }
            return g;
        }
        return str;
    }

    private void setWholeSceneCache(String str, VuiSceneCache vuiSceneCache, List<sc0> list) {
        if (vuiSceneCache != null) {
            List<sc0> fusionCache = vuiSceneCache.getFusionCache(str, list, false);
            vuiSceneCache.setCache(str, fusionCache);
            if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                return;
            }
            VuiScene newVuiScene = getNewVuiScene(str, System.currentTimeMillis());
            newVuiScene.setElements(fusionCache);
            String str2 = this.TAG;
            StringBuilder a = jg.a("updateSceneTask full_scene_info");
            a.append(VuiUtils.vuiSceneConvertToString(newVuiScene));
            LogUtils.logDebug(str2, a.toString());
        }
    }

    private void updateScene() {
        try {
            if ((this.updateView == null && this.viewList == null) || TextUtils.isEmpty(this.sceneId) || !VuiSceneManager.instance().canUpdateScene(this.sceneId)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            ArrayList arrayList = new ArrayList();
            if (this.updateView != null) {
                LogUtils.d(this.TAG, "updateView：" + this.updateView.get());
                sc0 buildElement = buildElement(sceneCache, this.updateView, currentTimeMillis);
                if (buildElement != null) {
                    arrayList.add(buildElement);
                }
            } else if (this.viewList != null) {
                for (int i = 0; i < this.viewList.size(); i++) {
                    sc0 buildElement2 = buildElement(sceneCache, this.viewList.get(i), currentTimeMillis);
                    if (buildElement2 != null) {
                        arrayList.add(buildElement2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                VuiScene newVuiScene = getNewVuiScene(this.sceneId, currentTimeMillis);
                newVuiScene.setElements(arrayList);
                VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(this.sceneId);
                boolean isWholeScene = sceneInfo != null ? sceneInfo.isWholeScene() : true;
                VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                if (isWholeScene) {
                    setWholeSceneCache(this.sceneId, sceneCache2, arrayList);
                    VuiSceneManager.instance().sendSceneData(1, true, newVuiScene);
                    return;
                }
                if (sceneCache2 != null) {
                    sceneCache2.setCache(this.sceneId, sceneCache2.getFusionCache(this.sceneId, arrayList, true));
                }
                List<String> wholeSceneId = sceneInfo != null ? sceneInfo.getWholeSceneId() : null;
                int size = wholeSceneId == null ? 0 : wholeSceneId.size();
                LogUtils.logDebug(this.TAG, "UpdateSceneAttributeTask wholeSceneIds:" + wholeSceneId);
                if (size > 0) {
                    String activeWholeSceneId = getActiveWholeSceneId(wholeSceneId);
                    if (!TextUtils.isEmpty(activeWholeSceneId)) {
                        VuiScene newVuiScene2 = getNewVuiScene(activeWholeSceneId, currentTimeMillis);
                        newVuiScene2.setElements(arrayList);
                        setWholeSceneCache(activeWholeSceneId, sceneCache2, arrayList);
                        VuiSceneManager.instance().sendSceneData(1, true, newVuiScene2);
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = wholeSceneId.get(i2);
                        if (!VuiUtils.isActiveSceneId(str)) {
                            VuiScene newVuiScene3 = getNewVuiScene(str, currentTimeMillis);
                            newVuiScene3.setElements(arrayList);
                            setWholeSceneCache(str, sceneCache2, arrayList);
                            VuiSceneManager.instance().sendSceneData(1, true, newVuiScene3);
                        }
                    }
                }
            }
        } catch (Exception e) {
            jg.a(e, jg.a("e:"), this.TAG);
        }
    }

    public List<sc0> build(int i, View view) {
        return build(i, view);
    }

    @Override // com.xiaopeng.speech.vui.task.base.Task
    public void execute() {
        updateScene();
    }

    public List<sc0> build(int i, List<View> list) {
        return build(i, list);
    }
}
