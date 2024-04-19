package com.xiaopeng.speech.vui.task;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.speech.vui.VuiSceneManager;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.task.base.BaseTask;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.SceneMergeUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class BuildSceneTask extends BaseTask {
    public String TAG;
    public List<String> bizIds;
    public gc0 elementChangedListener;
    public List<sc0> elements;
    public VuiSceneInfo info;
    public boolean isWholeScene;
    public List<String> mIdList;
    public List<String> mainThreadSceneList;
    public SoftReference<View> rootView;
    public String sceneId;
    public List<SoftReference<View>> viewList;
    public TaskWrapper viewWrapper;

    public BuildSceneTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.isWholeScene = true;
        this.TAG = "VuiEngine_BuildSceneTask";
        this.mIdList = new ArrayList();
        this.elements = new ArrayList();
        this.mainThreadSceneList = Arrays.asList("MainNetRadioConcentration", "MainProgramEditorChoice", "MainMusicConcentration", "MainMineCollect", "MainMineHistory", "MainMineVip", "MainMinePlaylist");
        this.info = null;
        this.bizIds = new ArrayList();
        this.elementChangedListener = null;
        this.viewWrapper = taskWrapper;
        this.rootView = taskWrapper.getView();
        this.viewList = taskWrapper.getViewList();
        this.sceneId = taskWrapper.getSceneId();
        this.isWholeScene = taskWrapper.isWholeScene();
    }

    private void addVuiElementChangedListener() {
        if ("com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || this.elementChangedListener == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.offer(this.rootView);
        while (!linkedList.isEmpty()) {
            SoftReference softReference = (SoftReference) linkedList.poll();
            String str = (softReference == null || softReference.get() == null) ? null : (String) ((View) softReference.get()).getTag(R.id.vuiElementId);
            if (str != null && this.mIdList.contains(str) && (softReference.get() instanceof ec0)) {
                ec0 ec0Var = (ec0) softReference.get();
                if (ec0Var.g() == null) {
                    ec0Var.b(str);
                }
                ec0Var.a(this.elementChangedListener);
            } else if (softReference != null && softReference.get() != null && (softReference instanceof ec0)) {
                String str2 = (String) ((View) softReference.get()).getTag();
                ec0 ec0Var2 = (ec0) softReference.get();
                if (str2 != null && str2.startsWith("4657")) {
                    ec0Var2.a(this.elementChangedListener);
                }
            }
            if (softReference != null && !(softReference.get() instanceof nf) && (softReference.get() instanceof ViewGroup)) {
                SoftReference softReference2 = new SoftReference((ViewGroup) softReference.get());
                for (int i = 0; softReference2.get() != null && i < ((ViewGroup) softReference2.get()).getChildCount(); i++) {
                    linkedList.offer(new SoftReference(((ViewGroup) softReference2.get()).getChildAt(i)));
                }
            }
        }
    }

    private void buildSubScenes(List<String> list) {
        int size = list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                jc0 vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str);
                if (vuiSceneListener != null) {
                    vuiSceneListener.onBuildScene();
                }
                VuiSceneManager.instance().setWholeSceneId(str, this.sceneId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildView(long j) {
        VuiSceneInfo vuiSceneInfo;
        if (!this.isWholeScene && (vuiSceneInfo = this.info) != null && vuiSceneInfo.isBuildComplete()) {
            VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            if (sceneCache != null) {
                this.elements = sceneCache.getCache(this.sceneId);
                return;
            }
            return;
        }
        SoftReference<View> findRecyclerView = VuiUtils.findRecyclerView(this.rootView);
        SoftReference<View> softReference = this.rootView;
        List<sc0> list = this.elements;
        List<Integer> customizeIds = this.viewWrapper.getCustomizeIds();
        SoftReference<hc0> elementListener = this.viewWrapper.getElementListener();
        List<String> list2 = this.mIdList;
        List<String> list3 = this.bizIds;
        SoftReference<View> softReference2 = this.rootView;
        boolean f = (softReference2 == null || !(softReference2.get() instanceof ec0)) ? false : ((ec0) this.rootView.get()).f();
        SoftReference<View> softReference3 = this.rootView;
        sc0 buildView = buildView(softReference, list, customizeIds, elementListener, list2, j, null, list3, null, 0, f, softReference3 != null && (softReference3.get() instanceof nf), findRecyclerView == null ? this.elementChangedListener : null);
        if (this.elements.size() == 0 && buildView != null && buildView.getId() != null) {
            buildView.setTimestamp(j);
            buildView.setVisible(null);
            this.elements.add(buildView);
            setVuiTag(this.rootView, buildView.getId());
        }
        if (findRecyclerView == null || findRecyclerView.equals(this.rootView)) {
            return;
        }
        addVuiElementChangedListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBuildElement(long j) {
        VuiSceneInfo vuiSceneInfo;
        VuiSceneInfo vuiSceneInfo2;
        VuiSceneManager.instance().setSceneIdList(this.sceneId, this.mIdList);
        List<String> subSceneIds = this.viewWrapper.getSubSceneIds();
        ArrayList arrayList = new ArrayList();
        if (subSceneIds != null) {
            int size = subSceneIds.size();
            for (int i = 0; i < size; i++) {
                String str = subSceneIds.get(i);
                if (VuiSceneManager.instance().getVuiSceneListener(str) == null) {
                    VuiSceneInfo vuiSceneInfo3 = this.info;
                    if (vuiSceneInfo3 != null) {
                        vuiSceneInfo3.updateAddSubSceneNum();
                    }
                    VuiSceneManager.instance().initSubSceneInfo(str, this.sceneId);
                } else {
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (sceneCache != null) {
                        List<sc0> cache = sceneCache.getCache(str);
                        if (cache != null) {
                            this.elements.addAll(i, cache);
                            VuiSceneInfo vuiSceneInfo4 = this.info;
                            if (vuiSceneInfo4 != null) {
                                vuiSceneInfo4.updateAddSubSceneNum();
                            }
                            VuiSceneManager.instance().setWholeSceneId(str, this.sceneId);
                        } else {
                            arrayList.add(str);
                        }
                    } else {
                        arrayList.add(str);
                    }
                }
            }
            VuiSceneManager.instance().addSubSceneIds(this.sceneId, subSceneIds);
        }
        VuiSceneManager.instance().setIsWholeScene(this.sceneId, this.isWholeScene);
        if (this.elements.size() > 0) {
            VuiScene newVuiScene = getNewVuiScene(this.sceneId, j);
            newVuiScene.setElements(this.elements);
            VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            String str2 = this.TAG;
            StringBuilder a = jg.a("buildScene completed:");
            a.append(this.sceneId);
            a.append(",time:");
            a.append(System.currentTimeMillis() - j);
            a.append(this.isWholeScene ? "full scene build completed" : "");
            LogUtils.logInfo(str2, a.toString());
            if (this.isWholeScene && (vuiSceneInfo2 = this.info) != null && vuiSceneInfo2.isFull()) {
                setWholeSceneCache(this.sceneId, sceneCache2, this.elements);
                VuiSceneInfo vuiSceneInfo5 = this.info;
                if (vuiSceneInfo5 != null) {
                    vuiSceneInfo5.setBuildComplete(true);
                }
                VuiSceneManager.instance().sendSceneData(0, false, newVuiScene);
            } else {
                if (!this.isWholeScene && (vuiSceneInfo = this.info) != null && !vuiSceneInfo.isBuildComplete()) {
                    if (sceneCache2 != null) {
                        sceneCache2.setCache(this.sceneId, this.elements);
                    }
                    this.info.setBuildComplete(true);
                } else if (this.isWholeScene) {
                    setWholeSceneCache(this.sceneId, sceneCache2, this.elements);
                }
                VuiSceneInfo vuiSceneInfo6 = this.info;
                List<String> wholeSceneId = vuiSceneInfo6 != null ? vuiSceneInfo6.getWholeSceneId() : null;
                if (wholeSceneId != null) {
                    int size2 = wholeSceneId.size();
                    VuiScene vuiScene = newVuiScene;
                    for (int i2 = 0; i2 < size2; i2++) {
                        String str3 = wholeSceneId.get(i2);
                        VuiSceneCache sceneCache3 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                        VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(str3);
                        if (sceneInfo != null && sceneInfo.isFull()) {
                            vuiScene = getNewVuiScene(str3, j);
                            vuiScene.setElements(this.elements);
                            setSubSceneElementToCache(str3, sceneCache3, this.elements);
                            LogUtils.logInfo(this.TAG, "main scene update");
                            VuiSceneManager.instance().sendSceneData(1, true, vuiScene);
                        } else if (sceneInfo != null && !sceneInfo.isFull()) {
                            sceneInfo.updateAddSubSceneNum();
                            List<sc0> subSceneElementToCache = setSubSceneElementToCache(str3, sceneCache3, this.elements);
                            if (sceneInfo.isFull()) {
                                sceneInfo.setBuildComplete(true);
                                LogUtils.logInfo(this.TAG, str3 + " full scene build completed ");
                                if (VuiUtils.isActiveSceneId(str3)) {
                                    vuiScene = getNewVuiScene(str3, j);
                                    vuiScene.setElements(subSceneElementToCache);
                                    VuiSceneManager.instance().sendSceneData(0, false, vuiScene);
                                }
                            }
                        }
                    }
                    newVuiScene = vuiScene;
                }
                buildSubScenes(arrayList);
            }
            if (this.viewWrapper.getSceneCallbackHandler() != null) {
                this.viewWrapper.getSceneCallbackHandler().onBuildFinished(newVuiScene);
            }
        } else if (this.isWholeScene && arrayList.size() > 0) {
            buildSubScenes(arrayList);
        } else {
            LogUtils.e(this.TAG, "请确认此场景是否包含支持VUI操作的控件");
        }
    }

    private List<sc0> setSubSceneElementToCache(String str, VuiSceneCache vuiSceneCache, List<sc0> list) {
        List<sc0> cache = vuiSceneCache.getCache(str);
        if (cache == null) {
            cache = new ArrayList<>();
        }
        if (cache.contains(list.get(0))) {
            return cache;
        }
        List<sc0> merge = SceneMergeUtils.merge(cache, list, false);
        vuiSceneCache.setCache(str, merge);
        if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL && !VuiUtils.isActiveSceneId(str)) {
            VuiScene newVuiScene = getNewVuiScene(str, System.currentTimeMillis());
            newVuiScene.setElements(merge);
            String str2 = this.TAG;
            StringBuilder a = jg.a("buildScene full_scene_info:");
            a.append(VuiUtils.vuiSceneConvertToString(newVuiScene));
            LogUtils.logDebug(str2, a.toString());
        }
        return merge;
    }

    private void setWholeSceneCache(String str, VuiSceneCache vuiSceneCache, List<sc0> list) {
        if (vuiSceneCache != null) {
            vuiSceneCache.setCache(str, vuiSceneCache.getUpdateFusionCache(str, list, false));
        }
    }

    public List<sc0> build(int i, View view) {
        return build(i, view);
    }

    @Override // com.xiaopeng.speech.vui.task.base.Task
    public void execute() {
        BuildSceneTask buildSceneTask;
        long j;
        BuildSceneTask buildSceneTask2 = this;
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            if (!buildSceneTask2.isWholeScene || VuiUtils.isActiveSceneId(buildSceneTask2.sceneId)) {
                String str = buildSceneTask2.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("buildScene-------------- sceneId:");
                sb.append(buildSceneTask2.sceneId);
                sb.append(",view:");
                sb.append(buildSceneTask2.rootView != null ? buildSceneTask2.rootView.get() : null);
                sb.append(",viewList:");
                sb.append(buildSceneTask2.viewList);
                LogUtils.logDebug(str, sb.toString());
                buildSceneTask2.info = VuiSceneManager.instance().getSceneInfo(buildSceneTask2.sceneId);
                boolean z = true;
                String substring = buildSceneTask2.sceneId.substring(buildSceneTask2.sceneId.lastIndexOf("-") + 1);
                if (buildSceneTask2.wrapper.getListener() != null && buildSceneTask2.info != null && buildSceneTask2.info.getListener() != null && !buildSceneTask2.wrapper.getListener().equals(buildSceneTask2.info.getListener())) {
                    LogUtils.w(buildSceneTask2.TAG, "要build的场景和目前持有的场景数据不一致");
                    return;
                }
                if (buildSceneTask2.info != null) {
                    buildSceneTask2.info.setBuild(true);
                    buildSceneTask2.elementChangedListener = buildSceneTask2.info.getElementChangedListener();
                }
                VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                if (vuiSceneBuildCache != null) {
                    vuiSceneBuildCache.setDisplayLocation(buildSceneTask2.sceneId, buildSceneTask2.wrapper.getDisplayLocation());
                }
                if (buildSceneTask2.rootView != null && buildSceneTask2.rootView.get() != null) {
                    if (buildSceneTask2.mainThreadSceneList.contains(substring)) {
                        if (VuiUtils.findRecyclerView(buildSceneTask2.rootView) != null && buildSceneTask2.isWholeScene) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.xiaopeng.speech.vui.task.BuildSceneTask.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BuildSceneTask.this.buildView(currentTimeMillis);
                                    BuildSceneTask.this.handleBuildElement(currentTimeMillis);
                                }
                            });
                        } else {
                            buildSceneTask2.buildView(currentTimeMillis);
                            buildSceneTask2.handleBuildElement(currentTimeMillis);
                        }
                    } else {
                        buildSceneTask2.buildView(currentTimeMillis);
                        buildSceneTask2.handleBuildElement(currentTimeMillis);
                    }
                } else if (buildSceneTask2.viewList != null) {
                    int i = 0;
                    while (i < buildSceneTask2.viewList.size()) {
                        SoftReference<View> softReference = buildSceneTask2.viewList.get(i);
                        LogUtils.logDebug(buildSceneTask2.TAG, "buildScene-------------- sceneId:" + buildSceneTask2.sceneId + ",第" + i + "个View" + softReference);
                        int i2 = i;
                        boolean z2 = z;
                        long j2 = currentTimeMillis;
                        try {
                            sc0 buildView = buildView(softReference, buildSceneTask2.elements, buildSceneTask2.viewWrapper.getCustomizeIds(), buildSceneTask2.viewWrapper.getElementListener(), buildSceneTask2.mIdList, currentTimeMillis, null, buildSceneTask2.bizIds, null, 0, (softReference == null || !(softReference.get() instanceof ec0)) ? false : ((ec0) softReference.get()).f(), (softReference == null || !(softReference.get() instanceof nf)) ? false : z, (softReference == null || !(softReference.get() instanceof nf)) ? buildSceneTask2.elementChangedListener : null);
                            if (buildView == null || buildView.getId() == null) {
                                buildSceneTask = this;
                                j = j2;
                            } else {
                                j = j2;
                                buildView.setTimestamp(j);
                                buildSceneTask = this;
                                try {
                                    buildSceneTask.elements.add(buildView);
                                    buildSceneTask.setVuiTag(softReference, buildView.getId());
                                } catch (Exception e) {
                                    e = e;
                                    jg.a(e, jg.a("e:"), buildSceneTask.TAG);
                                    return;
                                }
                            }
                            i = i2 + 1;
                            currentTimeMillis = j;
                            buildSceneTask2 = buildSceneTask;
                            z = z2;
                        } catch (Exception e2) {
                            e = e2;
                            buildSceneTask = this;
                            jg.a(e, jg.a("e:"), buildSceneTask.TAG);
                            return;
                        }
                    }
                    buildSceneTask = buildSceneTask2;
                    buildSceneTask.handleBuildElement(currentTimeMillis);
                }
            }
        } catch (Exception e3) {
            e = e3;
            buildSceneTask = buildSceneTask2;
        }
    }

    public List<sc0> build(int i, List<View> list) {
        return build(i, list);
    }
}
