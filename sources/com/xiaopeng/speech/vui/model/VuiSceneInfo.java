package com.xiaopeng.speech.vui.model;

import android.view.View;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VuiSceneInfo {
    public gc0 elementChangedListener;
    public int state = VuiSceneState.IDLE.getState();
    public View rootView = null;
    public jc0 listener = null;
    public List<String> subSceneList = null;
    public List<String> idList = null;
    public List<String> wholeSceneIds = null;
    public boolean isWholeScene = true;
    public int addSubSceneNum = 0;
    public boolean isContainNotChildrenView = false;
    public List<SoftReference<View>> notChildrenViewList = null;
    public List<String> notChildrenViewIdList = null;
    public String lastUpdateStr = null;
    public String lastAddStr = null;
    public IVuiEventListener eventListener = null;
    public boolean isBuild = false;
    public boolean isBuildComplete = false;

    public gc0 getElementChangedListener() {
        return this.elementChangedListener;
    }

    public IVuiEventListener getEventListener() {
        return this.eventListener;
    }

    public List<String> getIdList() {
        return this.idList;
    }

    public String getLastAddStr() {
        return this.lastAddStr;
    }

    public String getLastUpdateStr() {
        return this.lastUpdateStr;
    }

    public jc0 getListener() {
        return this.listener;
    }

    public List<String> getNotChildrenViewIdList() {
        return this.notChildrenViewIdList;
    }

    public List<SoftReference<View>> getNotChildrenViewList() {
        return this.notChildrenViewList;
    }

    public View getRootView() {
        return this.rootView;
    }

    public int getState() {
        return this.state;
    }

    public List<String> getSubSceneList() {
        return this.subSceneList;
    }

    public List<String> getWholeSceneId() {
        return this.wholeSceneIds;
    }

    public boolean isBuild() {
        return this.isBuild;
    }

    public boolean isBuildComplete() {
        return this.isBuildComplete;
    }

    public boolean isContainNotChildrenView() {
        return this.isContainNotChildrenView;
    }

    public boolean isFull() {
        List<String> list;
        return !this.isWholeScene || (list = this.subSceneList) == null || this.addSubSceneNum == list.size();
    }

    public boolean isWholeScene() {
        return this.isWholeScene;
    }

    public void reset(boolean z) {
        if (z) {
            this.state = VuiSceneState.IDLE.getState();
        }
        this.isContainNotChildrenView = false;
        this.notChildrenViewList = null;
        this.notChildrenViewIdList = null;
        this.addSubSceneNum = 0;
        this.lastUpdateStr = null;
        this.lastAddStr = null;
        this.isBuild = false;
        this.subSceneList = null;
        this.wholeSceneIds = null;
        this.idList = null;
        this.isBuildComplete = false;
        if (z) {
            resetViewInfo();
        }
    }

    public void resetViewInfo() {
        this.rootView = null;
        this.listener = null;
        this.eventListener = null;
        this.elementChangedListener = null;
    }

    public void setBuild(boolean z) {
        this.isBuild = z;
    }

    public void setBuildComplete(boolean z) {
        this.isBuildComplete = z;
    }

    public void setContainNotChildrenView(boolean z) {
        this.isContainNotChildrenView = z;
    }

    public void setElementChangedListener(gc0 gc0Var) {
        this.elementChangedListener = gc0Var;
    }

    public void setEventListener(IVuiEventListener iVuiEventListener) {
        this.eventListener = iVuiEventListener;
    }

    public void setIdList(List<String> list) {
        this.idList = list;
    }

    public void setLastAddStr(String str) {
        this.lastAddStr = str;
    }

    public void setLastUpdateStr(String str) {
        this.lastUpdateStr = str;
    }

    public void setListener(jc0 jc0Var) {
        this.listener = jc0Var;
    }

    public void setNotChildrenViewIdList(List<String> list) {
        this.notChildrenViewIdList = list;
    }

    public void setNotChildrenViewList(List<SoftReference<View>> list) {
        this.notChildrenViewList = list;
    }

    public void setRootView(View view) {
        this.rootView = view;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setSubSceneList(List<String> list) {
        this.subSceneList = list;
    }

    public void setWholeScene(boolean z) {
        this.isWholeScene = z;
    }

    public void setWholeSceneId(String str) {
        if (this.wholeSceneIds == null) {
            this.wholeSceneIds = new ArrayList();
        }
        if (this.wholeSceneIds.contains(str)) {
            return;
        }
        this.wholeSceneIds.add(str);
    }

    public void updateAddSubSceneNum() {
        this.addSubSceneNum++;
    }
}
