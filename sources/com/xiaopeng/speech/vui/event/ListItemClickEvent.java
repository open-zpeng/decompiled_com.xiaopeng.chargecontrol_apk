package com.xiaopeng.speech.vui.event;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewRootImpl;
import android.widget.ListView;
import com.xiaopeng.speech.vui.utils.LogUtils;
/* loaded from: classes.dex */
public class ListItemClickEvent extends BaseEvent {
    public sc0 params;

    private View getListView(View view) {
        return ((view instanceof ListView) || (view instanceof nf) || (view.getParent() instanceof ViewRootImpl)) ? view : getListView((View) view.getParent());
    }

    public String getPositionByViewId(int i, sc0 sc0Var) {
        if (sc0Var == null || TextUtils.isEmpty(sc0Var.getId())) {
            return "0";
        }
        String[] split = sc0Var.getId().split("_");
        return (split.length != 2 || split[1] == null) ? "0" : split[1];
    }

    public boolean performClick(View view) {
        if (view == null) {
            return false;
        }
        boolean z = view instanceof ec0;
        if (z) {
            ((ec0) view).b(true);
        }
        boolean performClick = view.performClick();
        LogUtils.i("ClickEvent run :" + performClick);
        if (z) {
            ((ec0) view).b(false);
        }
        if (performClick) {
            return true;
        }
        if (z) {
            ((ec0) view).b(false);
        }
        if (view.getParent() instanceof ViewRootImpl) {
            return false;
        }
        return performClick((View) view.getParent());
    }

    @Override // com.xiaopeng.speech.vui.event.IVuiEvent
    public <T extends View> T run(T t, sc0 sc0Var) {
        this.params = this.params;
        if (!performClick(t)) {
            boolean z = getListView(t) instanceof ListView;
        }
        return t;
    }
}
