package com.xiaopeng.speech.vui.event;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.R;
import defpackage.nf;
/* loaded from: classes.dex */
public class SetValueEvent extends BaseEvent {
    public int value = -1;
    public String elementId = null;
    public sc0 mVuiElement = null;
    public nf.s mScrollListener = new nf.s() { // from class: com.xiaopeng.speech.vui.event.SetValueEvent.1
        @Override // defpackage.nf.s
        public void onScrollStateChanged(nf nfVar, int i) {
            View d;
            super.onScrollStateChanged(nfVar, i);
            if (i == 0) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) nfVar.getLayoutManager();
                if (linearLayoutManager != null) {
                    int Q = linearLayoutManager.Q();
                    int T = linearLayoutManager.T();
                    if (SetValueEvent.this.value >= Q && SetValueEvent.this.value <= T && (d = linearLayoutManager.d(SetValueEvent.this.value)) != null) {
                        SetValueEvent setValueEvent = SetValueEvent.this;
                        View findActionView = setValueEvent.findActionView(d, setValueEvent.elementId);
                        if (findActionView != null) {
                            if (!TextUtils.isEmpty(SetValueEvent.this.mSceneId)) {
                                sc0 unused = SetValueEvent.this.mVuiElement;
                            }
                            SetValueEvent.this.mSceneId = null;
                            SetValueEvent.this.mVuiElement = null;
                            SetValueEvent.this.performClick(findActionView);
                        }
                    }
                }
                nfVar.b(SetValueEvent.this.mScrollListener);
            }
        }
    };
    public String mSceneId = null;

    /* JADX INFO: Access modifiers changed from: private */
    public View findActionView(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object tag = view.getTag(R.id.executeVirtualId);
        if (tag == null || !str.equals(tag.toString())) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (findActionView(childAt, str) != null) {
                        return childAt;
                    }
                }
            }
            return null;
        }
        return view;
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
        if (z) {
            ((ec0) view).b(false);
        }
        LogUtils.i("ClickEvent run :" + performClick);
        if (performClick) {
            return true;
        }
        if (view.getParent() instanceof ViewRootImpl) {
            return false;
        }
        return performClick((View) view.getParent());
    }

    @Override // com.xiaopeng.speech.vui.event.IVuiEvent
    public <T extends View> T run(T t, sc0 sc0Var) {
        if (t == null) {
            return null;
        }
        if (sc0Var != null) {
            try {
                if (sc0Var.getResultActions() != null && !sc0Var.getResultActions().isEmpty() && mc0.VIRTUALLIST.c.equals(sc0Var.getType())) {
                    this.elementId = sc0Var.getId();
                    Double d = (Double) VuiUtils.getValueByName(sc0Var, "value");
                    if (t instanceof nf) {
                        if (((ec0) t).p() != null) {
                            if (((ec0) t).p().has("isReverse") ? ((ec0) t).p().getBoolean("isReverse") : false) {
                                this.value = d.intValue();
                                if (((ec0) t).p().has(VuiConstants.PROPS_MAXVALUE)) {
                                    this.value = ((ec0) t).p().getInt(VuiConstants.PROPS_MAXVALUE) - this.value;
                                }
                                if (((ec0) t).p().has("hasHeader")) {
                                    this.value = d.intValue() + 1;
                                }
                                LogUtils.d("SetValueEvent", "reverse value:" + this.value);
                            } else {
                                if (((ec0) t).p().has("hasHeader")) {
                                    this.value = d.intValue();
                                } else {
                                    this.value = d.intValue() - 1;
                                }
                                if (((ec0) t).p().has(VuiConstants.PROPS_MINVALUE)) {
                                    this.value = (this.value - ((ec0) t).p().getInt(VuiConstants.PROPS_MINVALUE)) + 1;
                                }
                                LogUtils.d("SetValueEvent", "value:" + this.value);
                            }
                        }
                        nf nfVar = (nf) t;
                        nfVar.a(this.mScrollListener);
                        nfVar.h(this.value);
                    }
                    this.mVuiElement = sc0Var;
                }
            } catch (Exception e) {
                LogUtils.e("SetValueEvent", e.fillInStackTrace());
            }
        }
        return t;
    }

    public void setSceneId(String str) {
        this.mSceneId = str;
    }
}
