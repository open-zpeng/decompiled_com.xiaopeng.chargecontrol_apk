package com.xiaopeng.speech.vui.task;

import android.view.View;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.VuiSceneManager;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.task.base.BaseTask;
import com.xiaopeng.speech.vui.utils.LogUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RemoveTask extends BaseTask {
    public String TAG;
    public String sceneId;
    public TaskWrapper viewWrapper;

    public RemoveTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.TAG = "VuiEngine_RemoveTask";
        this.viewWrapper = taskWrapper;
        this.sceneId = taskWrapper.getSceneId();
    }

    public List<sc0> build(int i, View view) {
        return build(i, view);
    }

    @Override // com.xiaopeng.speech.vui.task.base.Task
    public void execute() {
        int i;
        RemoveTask removeTask;
        List<SoftReference<View>> list;
        List<String> list2;
        String str;
        boolean z;
        boolean z2;
        gc0 gc0Var;
        RemoveTask removeTask2 = this;
        try {
            String elementGroupId = removeTask2.viewWrapper.getElementGroupId();
            String str2 = CFCHelper.SIGNAL_CFC_SPLIT;
            boolean z3 = true;
            gc0 gc0Var2 = null;
            boolean z4 = false;
            try {
                if (elementGroupId == null) {
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(removeTask2.sceneId);
                    if (sceneInfo != null) {
                        sceneInfo.setLastAddStr(null);
                    }
                    if (removeTask2.viewWrapper.getViewList() == null) {
                        LogUtils.logInfo(removeTask2.TAG, "RemoveTask: sceneId" + removeTask2.sceneId);
                        if (sceneInfo != null && sceneInfo.isContainNotChildrenView()) {
                            List<String> notChildrenViewIdList = sceneInfo.getNotChildrenViewIdList();
                            if (notChildrenViewIdList != null) {
                                for (int i2 = 0; i2 < notChildrenViewIdList.size(); i2++) {
                                    VuiSceneManager.instance().sendSceneData(3, true, removeTask2.sceneId + CFCHelper.SIGNAL_CFC_SPLIT + notChildrenViewIdList.get(i2));
                                }
                            }
                            sceneInfo.setContainNotChildrenView(false);
                            sceneInfo.setNotChildrenViewIdList(null);
                            sceneInfo.setNotChildrenViewList(null);
                        }
                    } else {
                        LogUtils.logDebug(removeTask2.TAG, "RemoveTask: view list" + removeTask2.sceneId);
                        ArrayList arrayList = new ArrayList();
                        long currentTimeMillis = System.currentTimeMillis();
                        List<String> sceneIdList = VuiSceneManager.instance().getSceneIdList(removeTask2.sceneId);
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        if (sceneInfo != null && sceneInfo.isContainNotChildrenView()) {
                            List<String> notChildrenViewIdList2 = sceneInfo.getNotChildrenViewIdList();
                            List<SoftReference<View>> notChildrenViewList = sceneInfo.getNotChildrenViewList();
                            int i3 = 0;
                            RemoveTask removeTask3 = removeTask2;
                            while (i3 < removeTask3.viewWrapper.getViewList().size()) {
                                try {
                                    SoftReference<View> softReference = removeTask3.viewWrapper.getViewList().get(i3);
                                    if (notChildrenViewList.contains(softReference)) {
                                        if (softReference != null) {
                                            if (softReference.get() instanceof ec0) {
                                                i = i3;
                                                List<SoftReference<View>> list3 = notChildrenViewList;
                                                List<String> list4 = notChildrenViewIdList2;
                                                String str3 = str2;
                                                try {
                                                    sc0 buildView = buildView(softReference, arrayList3, null, null, arrayList, currentTimeMillis, sceneIdList, arrayList2, null, 0, softReference.get() instanceof ec0 ? ((ec0) softReference.get()).f() : z4, softReference.get() instanceof nf ? z3 : z4, softReference.get() instanceof nf ? gc0Var2 : sceneInfo.getElementChangedListener());
                                                    if (buildView == null || buildView.getId() == null) {
                                                        removeTask = this;
                                                        list = list3;
                                                        list2 = list4;
                                                        str = str3;
                                                    } else {
                                                        list2 = list4;
                                                        if (list2.contains(buildView.getId())) {
                                                            VuiSceneManager instance = VuiSceneManager.instance();
                                                            StringBuilder sb = new StringBuilder();
                                                            removeTask = this;
                                                            sb.append(removeTask.sceneId);
                                                            str = str3;
                                                            sb.append(str);
                                                            sb.append(buildView.getId());
                                                            z = true;
                                                            instance.sendSceneData(3, true, sb.toString());
                                                            list2.remove(buildView.getId());
                                                            list = list3;
                                                            list.remove(softReference);
                                                            if (!list2.isEmpty() && list.isEmpty()) {
                                                                z2 = false;
                                                                sceneInfo.setContainNotChildrenView(false);
                                                                gc0Var = null;
                                                                sceneInfo.setNotChildrenViewIdList(null);
                                                                sceneInfo.setNotChildrenViewList(null);
                                                            } else {
                                                                z2 = false;
                                                                gc0Var = null;
                                                                sceneInfo.setNotChildrenViewIdList(list2);
                                                                sceneInfo.setNotChildrenViewList(list);
                                                            }
                                                            z4 = z2;
                                                            gc0Var2 = gc0Var;
                                                            removeTask3 = removeTask;
                                                            z3 = z;
                                                            i3 = i + 1;
                                                            notChildrenViewIdList2 = list2;
                                                            removeTask2 = removeTask;
                                                            str2 = str;
                                                            notChildrenViewList = list;
                                                        } else {
                                                            removeTask = this;
                                                            list = list3;
                                                            str = str3;
                                                        }
                                                    }
                                                    z = true;
                                                    if (!list2.isEmpty()) {
                                                    }
                                                    z2 = false;
                                                    gc0Var = null;
                                                    sceneInfo.setNotChildrenViewIdList(list2);
                                                    sceneInfo.setNotChildrenViewList(list);
                                                    z4 = z2;
                                                    gc0Var2 = gc0Var;
                                                    removeTask3 = removeTask;
                                                    z3 = z;
                                                    i3 = i + 1;
                                                    notChildrenViewIdList2 = list2;
                                                    removeTask2 = removeTask;
                                                    str2 = str;
                                                    notChildrenViewList = list;
                                                } catch (Exception e) {
                                                    e = e;
                                                    removeTask2 = this;
                                                    jg.a(e, jg.a("e:"), removeTask2.TAG);
                                                    return;
                                                }
                                            }
                                        }
                                        i = i3;
                                        list = notChildrenViewList;
                                        list2 = notChildrenViewIdList2;
                                        str = str2;
                                        removeTask = removeTask2;
                                        i3 = i + 1;
                                        notChildrenViewIdList2 = list2;
                                        removeTask2 = removeTask;
                                        str2 = str;
                                        notChildrenViewList = list;
                                    }
                                    i = i3;
                                    list = notChildrenViewList;
                                    list2 = notChildrenViewIdList2;
                                    str = str2;
                                    removeTask = removeTask2;
                                    i3 = i + 1;
                                    notChildrenViewIdList2 = list2;
                                    removeTask2 = removeTask;
                                    str2 = str;
                                    notChildrenViewList = list;
                                } catch (Exception e2) {
                                    e = e2;
                                    removeTask2 = removeTask3;
                                    jg.a(e, jg.a("e:"), removeTask2.TAG);
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }
                String str4 = removeTask2.sceneId + "_" + removeTask2.viewWrapper.getElementGroupId();
                LogUtils.logInfo(removeTask2.TAG, "RemoveTask: subSceneid" + str4);
                List<String> sceneIdList2 = VuiSceneManager.instance().getSceneIdList(removeTask2.sceneId);
                List<String> sceneIdList3 = VuiSceneManager.instance().getSceneIdList(str4);
                if (sceneIdList3 != null) {
                    sceneIdList2.removeAll(sceneIdList3);
                    VuiSceneManager.instance().setSceneIdList(removeTask2.sceneId, sceneIdList2);
                    VuiSceneManager.instance().removeSubSceneIds(removeTask2.sceneId, str4);
                    VuiSceneManager.instance().removeVuiSceneListener(str4, false, false, null);
                }
                VuiSceneManager.instance().sendSceneData(3, true, removeTask2.sceneId + CFCHelper.SIGNAL_CFC_SPLIT + removeTask2.viewWrapper.getElementGroupId());
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public List<sc0> build(int i, List<View> list) {
        return build(i, list);
    }
}
