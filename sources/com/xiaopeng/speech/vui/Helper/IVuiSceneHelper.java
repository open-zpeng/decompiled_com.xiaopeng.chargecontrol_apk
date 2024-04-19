package com.xiaopeng.speech.vui.Helper;

import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.constants.Foo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public interface IVuiSceneHelper extends jc0 {
    default void buildScene() {
        if (TextUtils.isEmpty(getSceneId())) {
            return;
        }
        VuiEngine.getInstance(Foo.getContext()).buildScene(getSceneId(), getBuildViews(), getSubSceneList(), isMainScene());
    }

    List<View> getBuildViews();

    String getSceneId();

    default List<String> getSubSceneList() {
        return new ArrayList();
    }

    default boolean isCustomBuildScene() {
        return false;
    }

    default boolean isMainScene() {
        return true;
    }

    @Override // defpackage.jc0
    default void onBuildScene() {
        if (isCustomBuildScene()) {
            return;
        }
        buildScene();
    }
}
