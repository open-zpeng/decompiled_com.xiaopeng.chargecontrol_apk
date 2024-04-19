package com.xiaopeng.speech.vui.task;

import android.view.View;
import com.xiaopeng.speech.vui.ISceneCallbackHandler;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.task.TaskDispatcher;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TaskWrapper {
    public List<Integer> customizeIds;
    public String displayLocation;
    public String elementGroupId;
    public SoftReference<hc0> elementListener;
    public boolean isContainNotChildrenView;
    public boolean isWholeScene;
    public jc0 listener;
    public ISceneCallbackHandler mSceneCallbackHandler;
    public String parentElementId;
    public pc0 priority;
    public SoftReference<nf> recyclerView;
    public String sceneId;
    public List<String> subSceneIds;
    public TaskDispatcher.TaskType taskType;
    public String vid;
    public SoftReference<View> view;
    public List<SoftReference<View>> viewList;

    public TaskWrapper() {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
    }

    private void revertViewListToSoftReference(List<View> list) {
        if (list != null) {
            this.viewList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                this.viewList.add(new SoftReference<>(list.get(i)));
            }
        }
    }

    public List<Integer> getCustomizeIds() {
        return this.customizeIds;
    }

    public String getDisplayLocation() {
        return this.displayLocation;
    }

    public String getElementGroupId() {
        return this.elementGroupId;
    }

    public SoftReference<hc0> getElementListener() {
        return this.elementListener;
    }

    public jc0 getListener() {
        return this.listener;
    }

    public String getParentElementId() {
        return this.parentElementId;
    }

    public pc0 getPriority() {
        return this.priority;
    }

    public SoftReference<nf> getRecyclerView() {
        return this.recyclerView;
    }

    public ISceneCallbackHandler getSceneCallbackHandler() {
        return this.mSceneCallbackHandler;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public List<String> getSubSceneIds() {
        return this.subSceneIds;
    }

    public TaskDispatcher.TaskType getTaskType() {
        return this.taskType;
    }

    public String getVid() {
        return this.vid;
    }

    public SoftReference<View> getView() {
        return this.view;
    }

    public List<SoftReference<View>> getViewList() {
        return this.viewList;
    }

    public boolean isContainNotChildrenView() {
        return this.isContainNotChildrenView;
    }

    public boolean isWholeScene() {
        return this.isWholeScene;
    }

    public void setCustomizeIds(List<Integer> list) {
        this.customizeIds = list;
    }

    public void setDisplayLocation(String str) {
        this.displayLocation = str;
    }

    public void setElementGroupId(String str) {
        this.elementGroupId = str;
    }

    public void setElementListener(hc0 hc0Var) {
        this.elementListener = new SoftReference<>(hc0Var);
    }

    public void setListener(jc0 jc0Var) {
        this.listener = jc0Var;
    }

    public void setParentElementId(String str) {
        this.parentElementId = str;
    }

    public void setPriority(pc0 pc0Var) {
        this.priority = pc0Var;
    }

    public void setReturnCallBack(ISceneCallbackHandler iSceneCallbackHandler) {
        this.mSceneCallbackHandler = iSceneCallbackHandler;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setTaskType(TaskDispatcher.TaskType taskType) {
        this.taskType = taskType;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setView(View view) {
        this.view = new SoftReference<>(view);
    }

    public TaskWrapper(String str, TaskDispatcher.TaskType taskType, List<View> list) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = str;
        this.taskType = taskType;
        revertViewListToSoftReference(list);
    }

    public TaskWrapper(String str, TaskDispatcher.TaskType taskType, List<View> list, nf nfVar) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = str;
        this.taskType = taskType;
        revertViewListToSoftReference(list);
        this.recyclerView = new SoftReference<>(nfVar);
    }

    public TaskWrapper(String str, TaskDispatcher.TaskType taskType, View view) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = str;
        this.taskType = taskType;
        this.view = new SoftReference<>(view);
    }

    public TaskWrapper(String str, TaskDispatcher.TaskType taskType, View view, nf nfVar) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = str;
        this.taskType = taskType;
        this.view = new SoftReference<>(view);
        this.recyclerView = new SoftReference<>(nfVar);
    }

    public TaskWrapper(View view, int i, String str, TaskDispatcher.TaskType taskType) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = str;
        this.taskType = taskType;
        this.view = new SoftReference<>(view);
        this.vid = String.valueOf(i);
    }

    public TaskWrapper(View view, int i, String str, TaskDispatcher.TaskType taskType, nf nfVar) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.sceneId = str;
        this.taskType = taskType;
        this.view = new SoftReference<>(view);
        this.vid = String.valueOf(i);
        this.recyclerView = new SoftReference<>(nfVar);
    }

    public TaskWrapper(String str, pc0 pc0Var, TaskDispatcher.TaskType taskType, List<View> list, boolean z) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        revertViewListToSoftReference(list);
        this.sceneId = str;
        this.priority = pc0Var;
        this.taskType = taskType;
        this.isContainNotChildrenView = z;
    }

    public TaskWrapper(View view, String str, int i, TaskDispatcher.TaskType taskType, pc0 pc0Var, jc0 jc0Var) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = String.valueOf(i);
        this.taskType = taskType;
        this.priority = pc0Var;
        this.listener = jc0Var;
    }

    public TaskWrapper(View view, String str, int i, TaskDispatcher.TaskType taskType, String str2) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = String.valueOf(i);
        this.taskType = taskType;
        this.parentElementId = str2;
    }

    public TaskWrapper(View view, String str, int i, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = String.valueOf(i);
        this.taskType = taskType;
        this.customizeIds = list;
        this.elementListener = new SoftReference<>(hc0Var);
    }

    public TaskWrapper(View view, String str, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.taskType = taskType;
        this.customizeIds = list;
        this.elementListener = new SoftReference<>(hc0Var);
    }

    public TaskWrapper(List<View> list, String str, TaskDispatcher.TaskType taskType, List<Integer> list2, hc0 hc0Var) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        revertViewListToSoftReference(list);
        this.sceneId = str;
        this.taskType = taskType;
        this.elementListener = new SoftReference<>(hc0Var);
        this.customizeIds = list2;
    }

    public TaskWrapper(View view, String str, int i, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var, List<String> list2, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = String.valueOf(i);
        this.taskType = taskType;
        this.customizeIds = list;
        this.elementListener = new SoftReference<>(hc0Var);
        this.subSceneIds = list2;
        this.isWholeScene = z;
        this.mSceneCallbackHandler = iSceneCallbackHandler;
    }

    public TaskWrapper(View view, String str, int i, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var, List<String> list2, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = String.valueOf(i);
        this.taskType = taskType;
        this.customizeIds = list;
        this.elementListener = new SoftReference<>(hc0Var);
        this.subSceneIds = list2;
        this.isWholeScene = z;
        this.mSceneCallbackHandler = iSceneCallbackHandler;
        this.displayLocation = str2;
    }

    public TaskWrapper(View view, String str, int i, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var, List<String> list2, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2, jc0 jc0Var) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = String.valueOf(i);
        this.taskType = taskType;
        this.customizeIds = list;
        this.elementListener = new SoftReference<>(hc0Var);
        this.subSceneIds = list2;
        this.isWholeScene = z;
        this.mSceneCallbackHandler = iSceneCallbackHandler;
        this.displayLocation = str2;
        this.listener = jc0Var;
    }

    public TaskWrapper(List<View> list, String str, TaskDispatcher.TaskType taskType, List<Integer> list2, hc0 hc0Var, List<String> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        revertViewListToSoftReference(list);
        this.sceneId = str;
        this.vid = String.valueOf(this.vid);
        this.taskType = taskType;
        this.customizeIds = list2;
        this.elementListener = new SoftReference<>(hc0Var);
        this.subSceneIds = list3;
        this.isWholeScene = z;
        this.mSceneCallbackHandler = iSceneCallbackHandler;
    }

    public TaskWrapper(List<View> list, String str, TaskDispatcher.TaskType taskType, List<Integer> list2, hc0 hc0Var, List<String> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        revertViewListToSoftReference(list);
        this.sceneId = str;
        this.vid = String.valueOf(this.vid);
        this.taskType = taskType;
        this.customizeIds = list2;
        this.elementListener = new SoftReference<>(hc0Var);
        this.subSceneIds = list3;
        this.isWholeScene = z;
        this.mSceneCallbackHandler = iSceneCallbackHandler;
        this.displayLocation = str2;
    }

    public TaskWrapper(List<View> list, String str, TaskDispatcher.TaskType taskType, List<Integer> list2, hc0 hc0Var, List<String> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2, jc0 jc0Var) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        revertViewListToSoftReference(list);
        this.sceneId = str;
        this.vid = String.valueOf(this.vid);
        this.taskType = taskType;
        this.customizeIds = list2;
        this.elementListener = new SoftReference<>(hc0Var);
        this.subSceneIds = list3;
        this.isWholeScene = z;
        this.mSceneCallbackHandler = iSceneCallbackHandler;
        this.displayLocation = str2;
        this.listener = jc0Var;
    }

    public TaskWrapper(View view, String str, TaskDispatcher.TaskType taskType, jc0 jc0Var, String str2) {
        this.isWholeScene = true;
        this.isContainNotChildrenView = false;
        this.displayLocation = VuiConstants.SCREEN_DISPLAY_LF;
        this.view = new SoftReference<>(view);
        this.sceneId = str;
        this.vid = str2;
        this.listener = jc0Var;
        this.taskType = taskType;
        this.elementGroupId = str2;
    }
}
