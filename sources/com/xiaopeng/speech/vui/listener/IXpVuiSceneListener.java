package com.xiaopeng.speech.vui.listener;

import com.xiaopeng.speech.vui.observer.XpVuiElementChangedObserver;
/* loaded from: classes.dex */
public interface IXpVuiSceneListener extends jc0 {
    default Object getElementState(String str) {
        return null;
    }

    @Override // defpackage.jc0
    void onBuildScene();

    void onExcuteCommand(String str);

    void onInitCompleted(XpVuiElementChangedObserver xpVuiElementChangedObserver);

    @Override // defpackage.jc0
    void onVuiEvent(tc0 tc0Var);
}
