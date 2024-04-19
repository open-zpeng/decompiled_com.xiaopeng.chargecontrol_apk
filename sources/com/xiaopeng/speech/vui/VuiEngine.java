package com.xiaopeng.speech.vui;

import android.content.Context;
import android.view.View;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.observer.VuiLifecycleObserver;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class VuiEngine implements ic0 {
    public static volatile VuiEngine instance;
    public VuiEngineImpl impl;

    public VuiEngine(Context context) {
        this.impl = null;
        if (VuiUtils.canUseVuiFeature() && !VuiConstants.UNITY.equals(context.getApplicationInfo().packageName)) {
            this.impl = new VuiEngineImpl(context, true);
        }
    }

    public static VuiEngine getInstance(Context context) {
        if (instance == null) {
            synchronized (VuiEngine.class) {
                if (instance == null) {
                    instance = new VuiEngine(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public void addSceneElement(View view, String str, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addSceneElement(view, str, str2);
        }
    }

    public void addSceneElementGroup(View view, String str, pc0 pc0Var, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addSceneElementGroup(view, str, pc0Var, jc0Var);
        }
    }

    public void addVuiEventListener(String str, IVuiEventListener iVuiEventListener) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiEventListener(str, iVuiEventListener);
        }
    }

    @Override // defpackage.ic0
    public void addVuiSceneListener(String str, View view, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiSceneListener(str, view, jc0Var, null, true);
        }
    }

    public void buildScene(String str, View view) {
        buildScene(str, view, VuiUtils.getSourceDisplayLocation());
    }

    public VuiScene createVuiScene(String str, long j) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.createVuiScene(str, j);
        }
        return null;
    }

    public void disableChildVuiAttrWhenInvisible(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.disableChildVuiAttrWhenInvisible(view);
        }
    }

    public void disableViewVuiMode() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.disableViewVuiMode();
        }
    }

    public void disableVuiFeature() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.disableVuiFeature();
        }
    }

    public void dispatchVuiEvent(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.dispatchVuiEvent(str, str2);
        }
    }

    public void enableVuiFeature() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.enableVuiFeature();
        }
    }

    public void enterScene(String str, int i) {
        enterScene(str, i, VuiUtils.getSourceDisplayLocation());
    }

    public void exitScene(String str, int i) {
        exitScene(str, i, VuiUtils.getSourceDisplayLocation());
    }

    public String getActiveSceneId() {
        Map<String, String> activeSceneId;
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl == null || (activeSceneId = vuiEngineImpl.getActiveSceneId()) == null) {
            return null;
        }
        return activeSceneId.get(VuiConstants.SCREEN_DISPLAY_LF);
    }

    public String getElementState(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getElementState(str, str2);
        }
        return null;
    }

    public String getRFActiveSceneId() {
        Map<String, String> activeSceneId;
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl == null || (activeSceneId = vuiEngineImpl.getActiveSceneId()) == null) {
            return null;
        }
        return activeSceneId.get(VuiConstants.SCREEN_DISPLAY_RF);
    }

    public String getVuiElementId(String str, int i, String str2) {
        if (str != null) {
            str2 = jg.b(str, "_", str2);
        }
        if (i != -1) {
            return str2 + "_" + i;
        }
        return str2;
    }

    public String getVuiElementTag(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getVuiElementTag(view);
        }
        return null;
    }

    public Boolean getVuiElementVisibleTag(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getVuiElementVisibleTag(view);
        }
        return null;
    }

    public void handleNewRootviewToScene(String str, List<View> list) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.handleNewRootviewToScene(str, list, pc0.LEVEL2);
        }
    }

    public void initScene(vd vdVar, String str, View view, jc0 jc0Var) {
        initScene(vdVar, str, view, jc0Var, null, true, false);
    }

    public boolean isInSpeech() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.isInSpeech();
        }
        return false;
    }

    public boolean isSpeechShowNumber() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.isSpeechShowNumber();
        }
        return false;
    }

    public boolean isVuiFeatureDisabled() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.isVuiFeatureDisabled();
        }
        return true;
    }

    public void removeOtherRootViewFromScene(String str, View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeOtherRootViewFromScene(str, Arrays.asList(view));
        }
    }

    public void removeSceneElementGroup(String str, String str2, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeSceneElementGroup(str, str2, jc0Var);
        }
    }

    public void removeVuiSceneListener(String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeVuiSceneListener(str, null, false);
        }
    }

    public void setCustomDoActionTag(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setCustomDoActionTag(view);
        }
    }

    public void setExecuteVirtualTag(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setExecuteVirtualTag(view, null);
        }
    }

    public void setHasFeedBackTxtByViewDisable(View view, String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setHasFeedBackTxtByViewDisable(view, str);
        }
    }

    public void setLoglevel(int i) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setLoglevel(i);
        }
    }

    public void setProcessName(String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setProcessName(str);
        }
    }

    public void setVirtualResourceNameTag(View view, String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVirtualResourceNameTag(view, str);
        }
    }

    public void setVuiCustomDisableControlTag(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiCustomDisableControlTag(view);
        }
    }

    public void setVuiCustomDisableFeedbackTag(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiCustomDisableFeedbackTag(view);
        }
    }

    public void setVuiElementDefaultAction(View view, String str, Object obj) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiElementDefaultAction(view, str, obj);
        }
    }

    public void setVuiElementTag(View view, String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiElementTag(view, str);
        }
    }

    public void setVuiElementUnStandardSwitch(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiElementDefaultAction(view, lc0.SETCHECK.c, true);
        }
    }

    public void setVuiElementUnSupportTag(View view, boolean z) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiElementUnSupportTag(view, z);
        }
    }

    public void setVuiElementVisibleTag(View view, boolean z) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiElementVisibleTag(view, z);
        }
    }

    public void setVuiLabelUnSupportText(View... viewArr) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiLabelUnSupportText(viewArr);
        }
    }

    public void setVuiStatfulButtonClick(View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setVuiStatefulButtonClick(view);
        }
    }

    public void subscribe(String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.subscribe(str);
        }
    }

    public void subscribeVuiFeature() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.subscribeVuiFeature();
        }
    }

    public void unSubscribe() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.unSubscribe();
        }
    }

    public void unSubscribeVuiFeature() {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.unSubscribeVuiFeature();
        }
    }

    public void updateDisplayLocation(String str, int i) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateDisplayLocation(str, VuiUtils.getDisplayLocation(i));
        }
    }

    @Override // defpackage.ic0
    public void updateElementAttribute(String str, View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateElementAttribute(str, Arrays.asList(view));
        }
    }

    public void updateRecyclerViewItemView(String str, View view, nf nfVar) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateRecyclerViewItemView(str, Arrays.asList(view), nfVar);
        }
    }

    public void updateScene(String str, List<View> list) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateScene(str, list);
        }
    }

    public void vuiFeedback(View view, VuiFeedback vuiFeedback) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.vuiFeedback(view, vuiFeedback);
        }
    }

    public void buildScene(String str, View view, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, (List<Integer>) null, (hc0) null, (List<String>) null, true, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void enterScene(String str, int i, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            if (i == 0) {
                vuiEngineImpl.enterScene(str, VuiUtils.getDisplayLocation(str2), true);
            } else if (i == 2) {
                vuiEngineImpl.enterScene(str, VuiUtils.getDisplayLocation(str2), false);
            }
        }
    }

    public void exitScene(String str, int i, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            if (i == 0) {
                vuiEngineImpl.exitScene(str, VuiUtils.getDisplayLocation(str2), true, null);
            } else if (i == 2) {
                vuiEngineImpl.exitScene(str, VuiUtils.getDisplayLocation(str2), false, null);
            }
        }
    }

    public void initScene(vd vdVar, String str, View view, jc0 jc0Var, gc0 gc0Var) {
        initScene(vdVar, str, view, jc0Var, gc0Var, true, false);
    }

    public void addVuiSceneListener(String str, View view, jc0 jc0Var, boolean z) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiSceneListener(str, view, jc0Var, null, z);
        }
    }

    public void handleNewRootviewToScene(String str, View view) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.handleNewRootviewToScene(str, Arrays.asList(view), pc0.LEVEL2);
        }
    }

    public void initScene(vd vdVar, String str, View view, jc0 jc0Var, gc0 gc0Var, boolean z, boolean z2) {
        vdVar.a(new VuiLifecycleObserver(Foo.getContext(), vdVar, str, view, jc0Var, gc0Var, z, z2));
    }

    public void removeOtherRootViewFromScene(String str, List<View> list) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeOtherRootViewFromScene(str, list);
        }
    }

    @Override // defpackage.ic0
    public void removeVuiSceneListener(String str, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeVuiSceneListener(str, jc0Var, false);
        }
    }

    public void setExecuteVirtualTag(View view, String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setExecuteVirtualTag(view, str);
        }
    }

    public void updateElementAttribute(String str, List<View> list) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateElementAttribute(str, list);
        }
    }

    public void updateRecyclerViewItemView(String str, List<View> list, nf nfVar) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateRecyclerViewItemView(str, list, nfVar);
        }
    }

    @Override // defpackage.ic0
    public void updateScene(String str, View view) {
        if (this.impl != null) {
            if ((view instanceof ec0) && ((ec0) view).d() != null) {
                this.impl.updateScene(str, view);
            } else {
                this.impl.updateScene(str, Arrays.asList(view));
            }
        }
    }

    public void addVuiSceneListener(String str, View view, jc0 jc0Var, gc0 gc0Var, boolean z) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiSceneListener(str, view, jc0Var, gc0Var, z);
        }
    }

    public void buildScene(String str, View view, boolean z) {
        buildScene(str, view, z, VuiUtils.getSourceDisplayLocation());
    }

    public void enterScene(String str) {
        enterScene(str, VuiUtils.getSourceDisplayLocation());
    }

    public void exitScene(String str) {
        exitScene(str, VuiUtils.getSourceDisplayLocation());
    }

    public void handleNewRootviewToScene(String str, View view, pc0 pc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.handleNewRootviewToScene(str, Arrays.asList(view), pc0Var);
        }
    }

    public void removeOtherRootViewFromScene(String str) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeOtherRootViewFromScene(str);
        }
    }

    public void removeVuiSceneListener(String str, boolean z) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeVuiSceneListener(str, null, z);
        }
    }

    public void buildScene(String str, View view, boolean z, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, (List<Integer>) null, (hc0) null, (List<String>) null, z, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    @Override // defpackage.ic0
    public void enterScene(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.enterScene(str, VuiUtils.getDisplayLocation(str2), true);
        }
    }

    public void exitScene(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.exitScene(str, VuiUtils.getDisplayLocation(str2), true, null);
        }
    }

    @Override // defpackage.ic0
    public void addVuiSceneListener(String str, View view, jc0 jc0Var, gc0 gc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiSceneListener(str, view, jc0Var, gc0Var, true);
        }
    }

    public void handleNewRootviewToScene(String str, List<View> list, pc0 pc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.handleNewRootviewToScene(str, list, pc0Var);
        }
    }

    public void removeVuiSceneListener(String str, jc0 jc0Var, boolean z) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeVuiSceneListener(str, jc0Var, z);
        }
    }

    public void updateScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateScene(str, list, list2, hc0Var);
        }
    }

    public void enterScene(String str, boolean z) {
        enterScene(str, z, VuiUtils.getSourceDisplayLocation());
    }

    @Override // defpackage.ic0
    public void exitScene(String str, String str2, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.exitScene(str, VuiUtils.getDisplayLocation(str2), true, jc0Var);
        }
    }

    public void buildScene(String str, View view, ISceneCallbackHandler iSceneCallbackHandler) {
        buildScene(str, view, iSceneCallbackHandler, VuiUtils.getSourceDisplayLocation());
    }

    public void enterScene(String str, boolean z, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.enterScene(str, VuiUtils.getDisplayLocation(str2), z);
        }
    }

    public void updateScene(String str, View view, List<Integer> list, hc0 hc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateScene(str, view, list, hc0Var);
        }
    }

    public void buildScene(String str, View view, ISceneCallbackHandler iSceneCallbackHandler, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, (List<Integer>) null, (hc0) null, (List<String>) null, true, iSceneCallbackHandler, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void exitScene(String str, boolean z) {
        exitScene(str, z, VuiUtils.getSourceDisplayLocation());
    }

    public void exitScene(String str, boolean z, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.exitScene(str, VuiUtils.getDisplayLocation(str2), z, null);
        }
    }

    public void buildScene(String str, View view, List<String> list, boolean z) {
        buildScene(str, view, list, z, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, View view, List<String> list, boolean z, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, (List<Integer>) null, (hc0) null, list, z, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, View view, List<String> list, ISceneCallbackHandler iSceneCallbackHandler) {
        buildScene(str, view, list, iSceneCallbackHandler, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, View view, List<String> list, ISceneCallbackHandler iSceneCallbackHandler, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, (List<Integer>) null, (hc0) null, list, true, iSceneCallbackHandler, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, View view, List<Integer> list, hc0 hc0Var, List<String> list2, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        buildScene(str, view, list, hc0Var, list2, z, iSceneCallbackHandler, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, View view, List<Integer> list, hc0 hc0Var, List<String> list2, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, list, (hc0) null, list2, z, iSceneCallbackHandler, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var, List<String> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        buildScene(str, list, list2, hc0Var, list3, z, iSceneCallbackHandler, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var, List<String> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, list, list2, hc0Var, list3, z, iSceneCallbackHandler, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, List<View> list, List<String> list2, boolean z) {
        buildScene(str, list, list2, z, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, List<View> list, List<String> list2, boolean z, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, list, (List<Integer>) null, (hc0) null, list2, z, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, List<View> list, boolean z) {
        buildScene(str, list, z, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, List<View> list, boolean z, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, list, (List<Integer>) null, (hc0) null, (List<String>) null, z, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, View view, List<Integer> list, hc0 hc0Var) {
        buildScene(str, view, list, hc0Var, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, View view, List<Integer> list, hc0 hc0Var, String str2) {
        buildScene(str, view, list, hc0Var, (List<String>) null, true, (ISceneCallbackHandler) null, str2);
    }

    @Override // defpackage.ic0
    public void buildScene(String str, View view, List<Integer> list, hc0 hc0Var, String str2, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, view, list, hc0Var, (List<String>) null, true, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), jc0Var);
        }
    }

    public void buildScene(String str, List<View> list) {
        buildScene(str, list, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, List<View> list, String str2) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, list, (List<Integer>) null, (hc0) null, (List<String>) null, true, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), (jc0) null);
        }
    }

    public void buildScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var) {
        buildScene(str, list, list2, hc0Var, VuiUtils.getSourceDisplayLocation());
    }

    public void buildScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var, String str2) {
        buildScene(str, list, list2, hc0Var, str2, (jc0) null);
    }

    public void buildScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var, String str2, jc0 jc0Var) {
        VuiEngineImpl vuiEngineImpl = this.impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.buildScene(str, list, list2, hc0Var, (List<String>) null, true, (ISceneCallbackHandler) null, VuiUtils.getDisplayLocation(str2), jc0Var);
        }
    }
}
