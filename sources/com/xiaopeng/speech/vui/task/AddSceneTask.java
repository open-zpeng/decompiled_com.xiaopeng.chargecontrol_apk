package com.xiaopeng.speech.vui.task;

import android.os.Build;
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
public class AddSceneTask extends BaseTask {
    public String TAG;
    public TaskWrapper viewWrapper;

    public AddSceneTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.TAG = "VuiEngine_AddSceneTask";
        this.viewWrapper = taskWrapper;
    }

    private void addNotChildViewToScene(List<SoftReference<View>> list, String str, pc0 pc0Var) {
        AddSceneTask addSceneTask;
        VuiScene newVuiScene;
        int i;
        VuiSceneInfo vuiSceneInfo;
        VuiScene vuiScene;
        long j;
        String str2;
        VuiSceneCache vuiSceneCache;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str3;
        boolean z;
        AddSceneTask addSceneTask2 = this;
        List<SoftReference<View>> list2 = list;
        String str4 = str;
        String str5 = "user";
        if (list2 == null || str4 == null) {
            return;
        }
        try {
            if (VuiSceneManager.instance().canUpdateScene(str4)) {
                ArrayList arrayList3 = new ArrayList();
                long currentTimeMillis = System.currentTimeMillis();
                VuiScene newVuiScene2 = addSceneTask2.getNewVuiScene(str4, currentTimeMillis);
                ArrayList arrayList4 = new ArrayList();
                List<String> sceneIdList = VuiSceneManager.instance().getSceneIdList(str4);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(str4);
                if (sceneInfo == null) {
                    return;
                }
                gc0 elementChangedListener = sceneInfo.getElementChangedListener();
                sceneInfo.setContainNotChildrenView(true);
                ArrayList arrayList7 = new ArrayList();
                VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                boolean z2 = false;
                int i2 = 0;
                String str6 = str4;
                AddSceneTask addSceneTask3 = addSceneTask2;
                while (i2 < list.size()) {
                    try {
                        SoftReference<View> softReference = list2.get(i2);
                        if (softReference != null && (softReference.get() instanceof ec0)) {
                            z = softReference.get() instanceof nf ? true : z2;
                            i = i2;
                            VuiSceneCache vuiSceneCache2 = sceneCache;
                            ArrayList arrayList8 = arrayList7;
                            ArrayList arrayList9 = arrayList6;
                            vuiSceneInfo = sceneInfo;
                            ArrayList arrayList10 = arrayList4;
                            vuiScene = newVuiScene2;
                            long j2 = currentTimeMillis;
                            str2 = str5;
                            try {
                                sc0 buildView = buildView(softReference, arrayList4, null, null, arrayList3, currentTimeMillis, sceneIdList, arrayList5, null, 0, softReference.get() instanceof ec0 ? ((ec0) softReference.get()).f() : false, z, z ? null : elementChangedListener);
                                if (buildView == null || buildView.getId() == null) {
                                    addSceneTask = this;
                                    str3 = str;
                                    vuiSceneCache = vuiSceneCache2;
                                    arrayList = arrayList8;
                                    arrayList2 = arrayList9;
                                    arrayList4 = arrayList10;
                                    j = j2;
                                } else {
                                    j = j2;
                                    buildView.setTimestamp(j);
                                    addSceneTask = this;
                                    try {
                                        addSceneTask.setVuiTag(softReference, buildView.getId());
                                        str3 = str;
                                        vuiSceneCache = vuiSceneCache2;
                                        sc0 vuiElementById = vuiSceneCache.getVuiElementById(str3, buildView.getId());
                                        if (vuiElementById == null || !buildView.equals(vuiElementById)) {
                                            arrayList4 = arrayList10;
                                            arrayList4.add(buildView);
                                            arrayList = arrayList8;
                                            arrayList.add(softReference);
                                            arrayList2 = arrayList9;
                                            arrayList2.add(buildView.getId());
                                        } else {
                                            arrayList = arrayList8;
                                            arrayList2 = arrayList9;
                                            arrayList4 = arrayList10;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        addSceneTask3 = addSceneTask;
                                        jg.a(e, jg.a("addNotChildViewToScene e:"), addSceneTask3.TAG);
                                        return;
                                    }
                                }
                                addSceneTask3 = addSceneTask;
                                str6 = str3;
                                z2 = z;
                                addSceneTask2 = addSceneTask;
                                str4 = str3;
                                sceneCache = vuiSceneCache;
                                sceneInfo = vuiSceneInfo;
                                str5 = str2;
                                list2 = list;
                                arrayList6 = arrayList2;
                                arrayList7 = arrayList;
                                newVuiScene2 = vuiScene;
                                i2 = i + 1;
                                currentTimeMillis = j;
                            } catch (Exception e2) {
                                e = e2;
                                addSceneTask = this;
                            }
                        }
                        i = i2;
                        vuiSceneInfo = sceneInfo;
                        vuiScene = newVuiScene2;
                        j = currentTimeMillis;
                        str2 = str5;
                        vuiSceneCache = sceneCache;
                        arrayList = arrayList7;
                        arrayList2 = arrayList6;
                        str3 = str4;
                        addSceneTask = addSceneTask2;
                        z = z2;
                        z2 = z;
                        addSceneTask2 = addSceneTask;
                        str4 = str3;
                        sceneCache = vuiSceneCache;
                        sceneInfo = vuiSceneInfo;
                        str5 = str2;
                        list2 = list;
                        arrayList6 = arrayList2;
                        arrayList7 = arrayList;
                        newVuiScene2 = vuiScene;
                        i2 = i + 1;
                        currentTimeMillis = j;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                VuiSceneInfo vuiSceneInfo2 = sceneInfo;
                VuiScene vuiScene2 = newVuiScene2;
                long j3 = currentTimeMillis;
                String str7 = str5;
                VuiSceneCache vuiSceneCache3 = sceneCache;
                ArrayList arrayList11 = arrayList7;
                ArrayList arrayList12 = arrayList6;
                int i3 = 0;
                while (i3 < arrayList4.size()) {
                    try {
                        sc0 sc0Var = arrayList4.get(i3);
                        sc0 vuiElementById2 = vuiSceneCache3.getVuiElementById(str6, sc0Var.getId());
                        if (vuiElementById2 == null || !sc0Var.equals(vuiElementById2)) {
                            i3++;
                        } else {
                            arrayList4.remove(sc0Var);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        jg.a(e, jg.a("addNotChildViewToScene e:"), addSceneTask3.TAG);
                        return;
                    }
                }
                if (arrayList4.size() > 0) {
                    vuiScene2.setElements(arrayList4);
                    if (!str7.equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                        LogUtils.logDebug(addSceneTask3.TAG, "addNotChildViewToScene completed time:" + (System.currentTimeMillis() - j3) + CFCHelper.SIGNAL_CFC_SPLIT + VuiUtils.vuiUpdateSceneConvertToString(vuiScene2));
                    }
                    if (vuiSceneInfo2.getNotChildrenViewList() != null && vuiSceneInfo2.getNotChildrenViewIdList() != null) {
                        ArrayList arrayList13 = new ArrayList();
                        if (arrayList11.size() < vuiSceneInfo2.getNotChildrenViewList().size()) {
                            for (int i4 = 0; i4 < vuiSceneInfo2.getNotChildrenViewIdList().size(); i4++) {
                                String str8 = vuiSceneInfo2.getNotChildrenViewIdList().get(i4);
                                if (!arrayList12.contains(str8)) {
                                    arrayList13.add(str8);
                                    VuiSceneManager.instance().sendSceneData(3, true, str6 + CFCHelper.SIGNAL_CFC_SPLIT + str8);
                                }
                            }
                        }
                        if (arrayList13.size() == vuiSceneInfo2.getNotChildrenViewIdList().size()) {
                            VuiSceneManager.instance().sendSceneData(2, true, vuiScene2);
                        } else {
                            VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                            if (sceneCache2 != null) {
                                List<sc0> fusionCache = sceneCache2.getFusionCache(str6, arrayList4, false);
                                sceneCache2.setCache(str6, fusionCache);
                                if (!str7.equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                                    addSceneTask3.getNewVuiScene(str6, System.currentTimeMillis()).setElements(fusionCache);
                                    LogUtils.logDebug(addSceneTask3.TAG, "addNotChildViewToScene full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene));
                                }
                            }
                            VuiSceneManager.instance().sendSceneData(1, true, vuiScene2);
                        }
                        vuiSceneInfo2.setNotChildrenViewList(arrayList11);
                        vuiSceneInfo2.setNotChildrenViewIdList(arrayList12);
                        return;
                    }
                    vuiSceneInfo2.setNotChildrenViewList(arrayList11);
                    vuiSceneInfo2.setNotChildrenViewIdList(arrayList12);
                    VuiSceneManager.instance().sendSceneData(2, true, vuiScene2);
                }
            }
        } catch (Exception e5) {
            e = e5;
            addSceneTask = addSceneTask2;
        }
    }

    public void addSceneElement(SoftReference<View> softReference, String str, String str2) {
        VuiSceneInfo sceneInfo;
        ArrayList arrayList;
        long j;
        ArrayList arrayList2 = new ArrayList();
        if ((softReference instanceof ec0) && VuiSceneManager.instance().canUpdateScene(str2) && (sceneInfo = VuiSceneManager.instance().getSceneInfo(str2)) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            VuiScene newVuiScene = getNewVuiScene(str2, currentTimeMillis);
            ArrayList arrayList3 = new ArrayList();
            List<String> sceneIdList = VuiSceneManager.instance().getSceneIdList(str2);
            ArrayList arrayList4 = new ArrayList();
            boolean z = false;
            boolean f = (softReference == null || !(softReference.get() instanceof ec0)) ? false : ((ec0) softReference.get()).f();
            if (softReference != null && (softReference.get() instanceof nf)) {
                z = true;
            }
            sc0 buildView = buildView(softReference, arrayList3, null, null, arrayList2, currentTimeMillis, sceneIdList, arrayList4, null, 0, f, z, (softReference == null || !(softReference.get() instanceof nf)) ? sceneInfo.getElementChangedListener() : null);
            if (buildView == null || buildView.getId() == null) {
                arrayList = arrayList3;
                j = currentTimeMillis;
            } else {
                j = currentTimeMillis;
                buildView.setTimestamp(j);
                arrayList = arrayList3;
                arrayList.add(buildView);
            }
            newVuiScene.setElements(arrayList);
            VuiSceneManager.instance().setSceneIdList(str2, sceneIdList);
            if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                String str3 = this.TAG;
                StringBuilder a = jg.a("addSceneElement:");
                a.append(VuiUtils.vuiSceneConvertToString(newVuiScene));
                a.append("time:");
                a.append(System.currentTimeMillis() - j);
                LogUtils.logDebug(str3, a.toString());
            }
            VuiSceneManager.instance().addSceneElement(newVuiScene, str);
        }
    }

    public void addSceneElementGroup(SoftReference<View> softReference, String str, pc0 pc0Var, jc0 jc0Var) {
        AddSceneTask addSceneTask;
        VuiSceneInfo sceneInfo;
        String str2;
        ArrayList arrayList;
        long j;
        try {
            ArrayList arrayList2 = new ArrayList();
            if (!(softReference instanceof ec0) || !VuiSceneManager.instance().canUpdateScene(str) || (sceneInfo = VuiSceneManager.instance().getSceneInfo(str)) == null) {
                return;
            }
            ((ec0) softReference).a(pc0Var);
            long currentTimeMillis = System.currentTimeMillis();
            VuiScene newVuiScene = getNewVuiScene(str, currentTimeMillis);
            ArrayList arrayList3 = new ArrayList();
            List<String> sceneIdList = VuiSceneManager.instance().getSceneIdList(str);
            ArrayList arrayList4 = new ArrayList();
            VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            try {
                sc0 buildView = buildView(softReference, arrayList3, null, null, arrayList2, currentTimeMillis, sceneIdList, arrayList4, null, 0, (softReference == null || !(softReference.get() instanceof ec0)) ? false : ((ec0) softReference.get()).f(), softReference != null && (softReference.get() instanceof nf), (softReference == null || !(softReference.get() instanceof nf)) ? sceneInfo.getElementChangedListener() : null);
                if (buildView == null || buildView.getId() == null) {
                    addSceneTask = this;
                    str2 = str;
                    arrayList = arrayList3;
                    j = currentTimeMillis;
                } else {
                    j = currentTimeMillis;
                    buildView.setTimestamp(j);
                    addSceneTask = this;
                    try {
                        addSceneTask.setVuiTag(softReference, buildView.getId());
                        str2 = str;
                        sc0 vuiElementById = sceneCache.getVuiElementById(str2, buildView.getId());
                        if (vuiElementById != null) {
                            if (buildView.equals(vuiElementById)) {
                                LogUtils.logDebug(addSceneTask.TAG, "addNotChildViewToScene element same");
                                arrayList = arrayList3;
                            } else {
                                arrayList = arrayList3;
                                arrayList.add(buildView);
                            }
                        } else {
                            arrayList = arrayList3;
                            arrayList.add(buildView);
                        }
                    } catch (Exception e) {
                        e = e;
                        jg.a(e, jg.a("addSceneElementGroup e:"), addSceneTask.TAG);
                        return;
                    }
                }
                if (arrayList.size() > 0) {
                    newVuiScene.setElements(arrayList);
                    LogUtils.logInfo(addSceneTask.TAG, "addSceneElementGroup completed time:" + (System.currentTimeMillis() - j));
                    if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                        LogUtils.logDebug(addSceneTask.TAG, "addSceneElementGroup:" + VuiUtils.vuiUpdateSceneConvertToString(newVuiScene));
                    }
                    String str3 = str2 + "_" + ((softReference == null || softReference.get() == null) ? -1 : softReference.get().getId());
                    VuiSceneManager.instance().setSceneIdList(str3, arrayList2);
                    VuiSceneManager.instance().addSubSceneIds(str2, Arrays.asList(str3));
                    if (softReference != null && softReference.get() != null && jc0Var != null) {
                        VuiSceneManager.instance().setSceneIdList(str2, sceneIdList);
                        VuiSceneManager.instance().addVuiSceneListener(str3, softReference.get(), jc0Var, null, true);
                    }
                    VuiSceneManager.instance().sendSceneData(2, true, newVuiScene);
                }
            } catch (Exception e2) {
                e = e2;
                addSceneTask = this;
            }
        } catch (Exception e3) {
            e = e3;
            addSceneTask = this;
        }
    }

    public List<sc0> build(int i, View view) {
        return build(i, view);
    }

    @Override // com.xiaopeng.speech.vui.task.base.Task
    public void execute() {
        if (this.viewWrapper.isContainNotChildrenView()) {
            addNotChildViewToScene(this.viewWrapper.getViewList(), this.viewWrapper.getSceneId(), this.viewWrapper.getPriority());
        } else if (this.viewWrapper.getPriority() != null) {
            addSceneElementGroup(this.viewWrapper.getView(), this.viewWrapper.getSceneId(), this.viewWrapper.getPriority(), this.viewWrapper.getListener());
        } else {
            addSceneElement(this.viewWrapper.getView(), this.viewWrapper.getParentElementId(), this.viewWrapper.getSceneId());
        }
    }

    public List<sc0> build(int i, List<View> list) {
        return build(i, list);
    }
}
