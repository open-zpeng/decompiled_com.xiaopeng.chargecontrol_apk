package com.xiaopeng.speech.vui.event;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
/* loaded from: classes.dex */
public class ScrollByYEvent extends BaseEvent {
    public EndSmoothScroller mScroller = null;

    @Override // com.xiaopeng.speech.vui.event.IVuiEvent
    public <T extends View> T run(T t, sc0 sc0Var) {
        if (t != null && sc0Var != null && sc0Var.getResultActions() != null && !sc0Var.getResultActions().isEmpty() && lc0.SCROLLBYY.c.equals(sc0Var.getResultActions().get(0))) {
            String str = (String) VuiUtils.getValueByName(sc0Var, VuiConstants.EVENT_VALUE_DIRECTION);
            Double d = (Double) VuiUtils.getValueByName(sc0Var, VuiConstants.EVENT_VALUE_OFFSET);
            if (str != null && d != null) {
                boolean z = t instanceof ec0;
                if (z) {
                    ((ec0) t).b(true);
                }
                boolean equals = "up".equals(str);
                int intValue = d.intValue();
                if (equals) {
                    intValue = -intValue;
                }
                LogUtils.i("ScrollByYEvent", "ScrollByYEvent run value:" + intValue + ",view:" + t);
                if (t instanceof nf) {
                    int height = intValue != 100 ? (int) (intValue * 0.01d * t.getHeight()) : 100;
                    if (height == 0) {
                        ((nf) t).h(0);
                    } else if (height == 100) {
                        nf nfVar = (nf) t;
                        if (nfVar.getAdapter() == null) {
                            return t;
                        }
                        smoothMoveToPosition(nfVar, nfVar.getAdapter().a() - 1);
                    } else {
                        ((nf) t).h(0, height);
                    }
                } else if (t instanceof ScrollView) {
                    int height2 = intValue != 100 ? (int) (intValue * 0.01d * t.getHeight()) : 100;
                    if (height2 == 0) {
                        ((ScrollView) t).fullScroll(33);
                    } else if (height2 == 100) {
                        ((ScrollView) t).fullScroll(130);
                    } else {
                        ((ScrollView) t).smoothScrollBy(0, height2);
                    }
                } else if (t instanceof ListView) {
                    int height3 = intValue != 100 ? (int) (intValue * 0.01d * t.getHeight()) : 100;
                    ListView listView = (ListView) t;
                    if (height3 == 0) {
                        listView.setSelection(listView.getTop());
                    } else if (height3 == 100) {
                        listView.setSelection(listView.getBottom());
                    } else {
                        listView.smoothScrollBy(0, height3);
                    }
                } else {
                    Rect rect = new Rect();
                    t.getGlobalVisibleRect(rect);
                    if (intValue == 0) {
                        t.scrollTo(0, 0);
                    } else if (intValue == 100) {
                        t.scrollTo(0, t.getHeight() - rect.height());
                    } else {
                        int height4 = (int) (intValue * 0.01d * rect.height());
                        if (height4 > 0) {
                            if (rect.height() + t.getScrollY() + height4 >= t.getHeight()) {
                                t.scrollTo(0, t.getHeight() - rect.height());
                                return t;
                            }
                        } else if ((t.getScrollY() + height4) - rect.height() < 0) {
                            t.scrollTo(0, 0);
                            return t;
                        }
                        t.scrollBy(0, height4);
                    }
                }
                if (z) {
                    ((ec0) t).b(false);
                }
            }
        }
        return t;
    }

    public void smoothMoveToPosition(nf nfVar, int i) {
        if (nfVar.getLayoutManager() != null) {
            Log.d("ScrollByYEvent", "smoothMoveToPosition: ===== " + i);
            if (this.mScroller == null) {
                this.mScroller = new EndSmoothScroller(Foo.getContext());
            }
            this.mScroller.setTargetPosition(i);
            nfVar.getLayoutManager().b(this.mScroller);
        }
    }
}
