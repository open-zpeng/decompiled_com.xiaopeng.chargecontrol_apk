package com.xiaopeng.speech.vui.listener;
/* loaded from: classes.dex */
public interface IUnityVuiSceneListener extends jc0 {
    void checkSubElementsIsInsight(String str);

    void getScrollViewState(String str, String str2);

    @Override // defpackage.jc0
    void onBuildScene();

    void onVuiEvent(String str);
}
