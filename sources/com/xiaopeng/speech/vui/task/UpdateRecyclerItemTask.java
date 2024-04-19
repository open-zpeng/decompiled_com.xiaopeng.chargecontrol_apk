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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class UpdateRecyclerItemTask extends BaseTask {
    public String TAG;
    public List<String> allIdList;
    public List<String> bizIds;
    public SoftReference<hc0> callback;
    public gc0 elementChangedListener;
    public List<sc0> elements;
    public List<String> idList;
    public List<Integer> ids;
    public VuiSceneInfo info;
    public boolean isRecyclerView;
    public SoftReference<nf> recyclerView;
    public String sceneId;
    public long time;
    public SoftReference<View> updateView;
    public List<SoftReference<View>> viewList;
    public TaskWrapper viewWrapper;
    public VuiScene vuiScene;
    public VuiSceneCache vuiSceneCache;

    public UpdateRecyclerItemTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.TAG = "VuiEngine_UpdateSceneTask";
        this.vuiScene = null;
        this.elements = new ArrayList();
        this.bizIds = new ArrayList();
        this.time = -1L;
        this.info = null;
        this.isRecyclerView = true;
        this.allIdList = null;
        this.idList = new ArrayList();
        this.vuiSceneCache = null;
        this.viewWrapper = taskWrapper;
        this.sceneId = taskWrapper.getSceneId();
        this.viewList = taskWrapper.getViewList();
        this.updateView = taskWrapper.getView();
        this.ids = taskWrapper.getCustomizeIds();
        this.callback = taskWrapper.getElementListener();
        this.recyclerView = taskWrapper.getRecyclerView();
    }

    private void buildUpdateView(SoftReference<View> softReference) {
        SoftReference<nf> softReference2 = this.recyclerView;
        sc0 buildView = buildView(softReference, this.elements, this.ids, this.callback, this.idList, this.time, this.allIdList, this.bizIds, null, 0, softReference2 != null && softReference2.get() != null && (this.recyclerView.get() instanceof ec0) && ((ec0) this.recyclerView.get()).f(), this.isRecyclerView, null);
        if (buildView == null || buildView.getId() == null) {
            return;
        }
        buildView.setTimestamp(this.time);
        setVuiTag(softReference, buildView.getId());
        sc0 vuiElementById = this.vuiSceneCache.getVuiElementById(this.sceneId, buildView.getId());
        if (vuiElementById != null) {
            if (!VuiUtils.vuiElementGroupConvertToString(Arrays.asList(vuiElementById)).equals(VuiUtils.vuiElementGroupConvertToString(Arrays.asList(buildView)))) {
                this.elements.add(buildView);
            } else {
                LogUtils.logInfo(this.TAG, "updateScene element same");
            }
        }
    }

    private void handleUpdateElement() {
        if (this.elements.isEmpty()) {
            return;
        }
        this.vuiScene.setElements(this.elements);
        String vuiUpdateSceneConvertToString = VuiUtils.vuiUpdateSceneConvertToString(this.vuiScene);
        VuiSceneInfo vuiSceneInfo = this.info;
        boolean isWholeScene = vuiSceneInfo != null ? vuiSceneInfo.isWholeScene() : true;
        VuiSceneManager.instance().setSceneIdList(this.sceneId, this.allIdList);
        String str = this.TAG;
        StringBuilder a = jg.a("updateScene completed time:");
        a.append(System.currentTimeMillis() - this.time);
        LogUtils.logInfo(str, a.toString());
        String str2 = this.TAG;
        LogUtils.logDebug(str2, "updateScene:" + vuiUpdateSceneConvertToString);
        if (Thread.currentThread().isInterrupted()) {
            LogUtils.logInfo(this.TAG, "取消当前任务");
            return;
        }
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (isWholeScene) {
            VuiSceneManager.instance().sendSceneData(1, true, this.vuiScene);
            setWholeSceneCache(this.sceneId, sceneCache, this.elements);
            return;
        }
        if (sceneCache != null) {
            sceneCache.setCache(this.sceneId, sceneCache.getFusionCache(this.sceneId, this.elements, false));
        }
        VuiSceneInfo vuiSceneInfo2 = this.info;
        List<String> wholeSceneId = vuiSceneInfo2 != null ? vuiSceneInfo2.getWholeSceneId() : null;
        int size = wholeSceneId == null ? 0 : wholeSceneId.size();
        String str3 = this.TAG;
        LogUtils.logDebug(str3, "updateScene wholeSceneIds:" + wholeSceneId);
        if (size > 0) {
            String activeWholeSceneId = getActiveWholeSceneId(wholeSceneId);
            if (!TextUtils.isEmpty(activeWholeSceneId)) {
                this.vuiScene = getNewVuiScene(activeWholeSceneId, this.time);
                this.vuiScene.setElements(this.elements);
                VuiSceneManager.instance().sendSceneData(1, true, this.vuiScene);
                setWholeSceneCache(activeWholeSceneId, sceneCache, this.elements);
            }
            for (int i = 0; i < size; i++) {
                String str4 = wholeSceneId.get(i);
                if (!VuiUtils.isActiveSceneId(str4)) {
                    this.vuiScene = getNewVuiScene(str4, this.time);
                    this.vuiScene.setElements(this.elements);
                    VuiSceneManager.instance().sendSceneData(1, true, this.vuiScene);
                    setWholeSceneCache(str4, sceneCache, this.elements);
                }
            }
        }
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
            StringBuilder a = jg.a("updateSceneTask build cache");
            a.append(VuiUtils.vuiSceneConvertToString(newVuiScene));
            LogUtils.logDebug(str2, a.toString());
        }
    }

    private void updateSceneByElement() {
        try {
            if ((this.viewList == null && this.updateView == null) || TextUtils.isEmpty(this.sceneId) || !VuiSceneManager.instance().canUpdateScene(this.sceneId)) {
                return;
            }
            this.time = System.currentTimeMillis();
            this.vuiScene = getNewVuiScene(this.sceneId, this.time);
            this.allIdList = VuiSceneManager.instance().getSceneIdList(this.sceneId);
            this.info = VuiSceneManager.instance().getSceneInfo(this.sceneId);
            this.vuiSceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            if (this.info == null) {
                return;
            }
            this.elementChangedListener = this.info.getElementChangedListener();
            if (this.viewList != null) {
                int size = this.viewList.size();
                if (size == 0) {
                    return;
                }
                for (int i = 0; i < size; i++) {
                    SoftReference<View> softReference = this.viewList.get(i);
                    String str = this.TAG;
                    LogUtils.logInfo(str, "updateScene updateView" + softReference.get());
                    buildUpdateView(softReference);
                }
                handleUpdateElement();
            } else if (this.updateView != null) {
                String str2 = this.TAG;
                LogUtils.logInfo(str2, "updateScene updateView" + this.updateView.get());
                buildUpdateView(this.updateView);
                handleUpdateElement();
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
        updateSceneByElement();
    }

    public List<sc0> build(int i, List<View> list) {
        return build(i, list);
    }
}
