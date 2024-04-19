package com.xiaopeng.speech.vui.listener;

import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public interface IXpVuiElementChanged {
    default void onVuiElementChanged(String str, View view) {
    }

    default void onVuiElementChanged(String str, View view, List<sc0> list) {
    }

    default void onVuiElementChanged(String str, View view, String[] strArr, int i) {
    }
}
