package com.xiaopeng.speech.vui.event;

import android.view.View;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
/* loaded from: classes.dex */
public class ScrollByXEvent extends BaseEvent {
    @Override // com.xiaopeng.speech.vui.event.IVuiEvent
    public <T extends View> T run(T t, sc0 sc0Var) {
        String str;
        ig igVar;
        int extraPage;
        if (t == null || sc0Var == null || sc0Var.getResultActions() == null || sc0Var.getResultActions().isEmpty() || !lc0.SCROLLBYX.c.equals(sc0Var.getResultActions().get(0)) || (str = (String) VuiUtils.getValueByName(sc0Var, VuiConstants.EVENT_VALUE_DIRECTION)) == null) {
            return t;
        }
        boolean z = t instanceof ec0;
        if (z) {
            ((ec0) t).b(true);
        }
        LogUtils.i("ScrollByXEvent run direction:" + str);
        if (sc0Var.type.equals(mc0.VIEWPAGER.c)) {
            if (!(t instanceof ig)) {
                igVar = VuiUtils.findViewPager(t);
            } else {
                igVar = (ig) t;
            }
            if (igVar != null) {
                boolean canScrollHorizontally = igVar.canScrollHorizontally(-1);
                boolean canScrollHorizontally2 = igVar.canScrollHorizontally(1);
                int currentItem = igVar.getCurrentItem();
                if ("left".equals(str)) {
                    int i = currentItem - 1;
                    if (canScrollHorizontally) {
                        igVar.a(i, false);
                    } else if (canScrollHorizontally2 && VuiUtils.getExtraPage(sc0Var) != -1) {
                        igVar.getAdapter();
                        throw null;
                    }
                } else {
                    int i2 = currentItem + 1;
                    if (canScrollHorizontally2) {
                        igVar.a(i2, false);
                    } else if (canScrollHorizontally && (extraPage = VuiUtils.getExtraPage(sc0Var)) != -1) {
                        igVar.a(extraPage, false);
                    }
                }
            }
        } else {
            sc0Var.type.equals(mc0.SCROLLVIEW.c);
        }
        if (z) {
            ((ec0) t).b(false);
        }
        return t;
    }
}
