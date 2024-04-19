package com.xiaopeng.speech.vui.task;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
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
public class UpdateSceneTask extends BaseTask {
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
    public List<String> mainThreadSceneList;
    public String sceneId;
    public long time;
    public SoftReference<View> updateView;
    public List<SoftReference<View>> viewList;
    public TaskWrapper viewWrapper;
    public VuiScene vuiScene;
    public VuiSceneCache vuiSceneCache;

    public UpdateSceneTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.TAG = "VuiEngine_UpdateSceneTask";
        this.vuiScene = null;
        this.elements = new ArrayList();
        this.bizIds = new ArrayList();
        this.time = -1L;
        this.info = null;
        this.isRecyclerView = false;
        this.allIdList = null;
        this.idList = new ArrayList();
        this.vuiSceneCache = null;
        this.mainThreadSceneList = Arrays.asList("MainMusicConcentration");
        this.viewWrapper = taskWrapper;
        this.sceneId = taskWrapper.getSceneId();
        this.viewList = taskWrapper.getViewList();
        this.updateView = taskWrapper.getView();
        this.ids = taskWrapper.getCustomizeIds();
        this.callback = taskWrapper.getElementListener();
    }

    private void buildUpdateView(SoftReference<View> softReference) {
        List<sc0> list = this.elements;
        List<Integer> list2 = this.ids;
        SoftReference<hc0> softReference2 = this.callback;
        List<String> list3 = this.idList;
        long j = this.time;
        List<String> list4 = this.allIdList;
        List<String> list5 = this.bizIds;
        boolean f = (softReference == null || !(softReference.get() instanceof ec0)) ? false : ((ec0) softReference.get()).f();
        boolean z = this.isRecyclerView;
        sc0 buildView = buildView(softReference, list, list2, softReference2, list3, j, list4, list5, null, 0, f, z, z ? null : this.elementChangedListener);
        if (buildView != null && buildView.getId() != null) {
            buildView.setTimestamp(this.time);
            setVuiTag(softReference, buildView.getId());
            sc0 vuiElementById = this.vuiSceneCache.getVuiElementById(this.sceneId, buildView.getId());
            if (vuiElementById != null) {
                if (!buildView.equals(vuiElementById)) {
                    this.elements.add(buildView);
                } else {
                    LogUtils.logDebug(this.TAG, "updateScene element same");
                }
            } else if (isAddToScene(softReference, this.isRecyclerView, this.info)) {
                this.elements.add(buildView);
            }
        }
        int i = 0;
        while (i < this.elements.size()) {
            sc0 sc0Var = this.elements.get(i);
            sc0 vuiElementById2 = this.vuiSceneCache.getVuiElementById(this.sceneId, sc0Var.getId());
            if (vuiElementById2 == null || !sc0Var.equals(vuiElementById2)) {
                i++;
            } else {
                this.elements.remove(sc0Var);
            }
        }
    }

    private void handleUpdateElement() {
        if (this.elements.isEmpty()) {
            return;
        }
        this.vuiScene.setElements(this.elements);
        VuiSceneInfo vuiSceneInfo = this.info;
        boolean isWholeScene = vuiSceneInfo != null ? vuiSceneInfo.isWholeScene() : true;
        VuiSceneManager.instance().setSceneIdList(this.sceneId, this.allIdList);
        if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
            String str = this.TAG;
            StringBuilder a = jg.a("updateScene completed time:");
            a.append(System.currentTimeMillis() - this.time);
            a.append(CFCHelper.SIGNAL_CFC_SPLIT);
            a.append(VuiUtils.vuiUpdateSceneConvertToString(this.vuiScene));
            LogUtils.logDebug(str, a.toString());
        }
        if (Thread.currentThread().isInterrupted()) {
            LogUtils.logInfo(this.TAG, "取消当前任务");
            return;
        }
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (isWholeScene) {
            setWholeSceneCache(this.sceneId, sceneCache, this.elements);
            VuiSceneManager.instance().sendSceneData(1, true, this.vuiScene);
            return;
        }
        if (sceneCache != null) {
            sceneCache.setCache(this.sceneId, sceneCache.getFusionCache(this.sceneId, this.elements, false));
        }
        VuiSceneInfo vuiSceneInfo2 = this.info;
        List<String> wholeSceneId = vuiSceneInfo2 != null ? vuiSceneInfo2.getWholeSceneId() : null;
        int size = wholeSceneId == null ? 0 : wholeSceneId.size();
        String str2 = this.TAG;
        LogUtils.logDebug(str2, "updateScene wholeSceneIds:" + wholeSceneId);
        if (size > 0) {
            String activeWholeSceneId = getActiveWholeSceneId(wholeSceneId);
            if (!TextUtils.isEmpty(activeWholeSceneId)) {
                this.vuiScene = getNewVuiScene(activeWholeSceneId, this.time);
                this.vuiScene.setElements(this.elements);
                setWholeSceneCache(activeWholeSceneId, sceneCache, this.elements);
                VuiSceneManager.instance().sendSceneData(1, true, this.vuiScene);
            }
            for (int i = 0; i < size; i++) {
                String str3 = wholeSceneId.get(i);
                if (!TextUtils.isEmpty(str3) && !VuiUtils.isActiveSceneId(str3)) {
                    this.vuiScene = getNewVuiScene(str3, this.time);
                    this.vuiScene.setElements(this.elements);
                    setWholeSceneCache(str3, sceneCache, this.elements);
                    VuiSceneManager.instance().sendSceneData(1, true, this.vuiScene);
                }
            }
        }
    }

    private boolean isAddToScene(SoftReference<View> softReference, boolean z, VuiSceneInfo vuiSceneInfo) {
        if (softReference != null && softReference.get() != null) {
            View rootView = vuiSceneInfo.getRootView();
            if ("com.xiaopeng.musicradio".equals(VuiSceneManager.instance().getmPackageName())) {
                if (z) {
                    if (isRecyclerViewChild((View) softReference.get().getParent(), rootView)) {
                        String str = this.TAG;
                        LogUtils.logDebug(str, "view:" + softReference + "isRecyclerView," + z + ",rootView:" + rootView + ",ignore addToScene");
                        return false;
                    }
                } else if (isRecyclerViewChild(softReference.get(), rootView)) {
                    String str2 = this.TAG;
                    LogUtils.logDebug(str2, "view:" + softReference + "isRecyclerView," + z + ",rootView:" + rootView + ",ignore addToScene");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNeedUpdate(SoftReference<View> softReference) {
        return softReference == null || softReference.get() == null || !(softReference.get() instanceof nf) || VuiUtils.isActiveSceneId(this.sceneId) || ((nf) softReference.get()).getChildCount() != 0;
    }

    private boolean isRecyclerViewChild(View view, View view2) {
        if (view2 == null || view == null) {
            return false;
        }
        if (view instanceof nf) {
            return true;
        }
        if (view == view2) {
            return false;
        }
        return isRecyclerViewChild((View) view.getParent(), view2);
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
                    if (isNeedUpdate(softReference)) {
                        if (softReference != null && (softReference.get() instanceof nf)) {
                            this.isRecyclerView = true;
                        }
                        String str = this.TAG;
                        LogUtils.logDebug(str, "updateScene updateView" + softReference.get());
                        buildUpdateView(softReference);
                    }
                }
                handleUpdateElement();
            } else if (this.updateView != null) {
                String str2 = this.TAG;
                LogUtils.logDebug(str2, "updateScene updateView" + this.updateView.get());
                if (isNeedUpdate(this.updateView)) {
                    if (this.updateView != null && (this.updateView.get() instanceof nf)) {
                        this.isRecyclerView = true;
                    }
                    String substring = this.sceneId.substring(this.sceneId.lastIndexOf("-") + 1);
                    if (this.isRecyclerView && this.mainThreadSceneList.contains(substring)) {
                        buildUpdateView(this.updateView);
                        handleUpdateElement();
                        return;
                    }
                    buildUpdateView(this.updateView);
                    handleUpdateElement();
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
        updateSceneByElement();
    }

    public List<sc0> build(int i, List<View> list) {
        return build(i, list);
    }
}
