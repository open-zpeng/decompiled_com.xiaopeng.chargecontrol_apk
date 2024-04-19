package com.xiaopeng.speech.vui.event;

import android.view.View;
import com.xiaopeng.speech.vui.utils.LogUtils;
/* loaded from: classes.dex */
public class ClickEvent extends BaseEvent {
    @Override // com.xiaopeng.speech.vui.event.IVuiEvent
    public <T extends View> T run(T t, sc0 sc0Var) {
        if (t != null) {
            boolean z = t instanceof ec0;
            if (z) {
                ((ec0) t).b(true);
            }
            boolean performClick = t.performClick();
            LogUtils.i("ClickEvent run :" + performClick);
            if (!performClick && z) {
                ((ec0) t).b(false);
            }
        }
        return t;
    }
}
