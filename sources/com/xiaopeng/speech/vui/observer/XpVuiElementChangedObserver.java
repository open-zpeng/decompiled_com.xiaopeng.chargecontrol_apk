package com.xiaopeng.speech.vui.observer;

import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.speech.vui.VuiEngineImpl;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.listener.IXpVuiElementChanged;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class XpVuiElementChangedObserver implements IXpVuiElementChanged {
    public jc0 mListener;

    public XpVuiElementChangedObserver(jc0 jc0Var) {
        this.mListener = null;
        this.mListener = jc0Var;
    }

    @Override // com.xiaopeng.speech.vui.listener.IXpVuiElementChanged
    public void onVuiElementChanged(String str, View view) {
        onVuiElementChanged(str, view, null, null, -1);
    }

    @Override // com.xiaopeng.speech.vui.listener.IXpVuiElementChanged
    public void onVuiElementChanged(String str, View view, String[] strArr, int i) {
        onVuiElementChanged(str, view, null, strArr, i);
    }

    @Override // com.xiaopeng.speech.vui.listener.IXpVuiElementChanged
    public void onVuiElementChanged(String str, View view, List<sc0> list) {
        onVuiElementChanged(str, view, list, null, -1);
    }

    public XpVuiElementChangedObserver() {
        this.mListener = null;
    }

    private void onVuiElementChanged(String str, View view, List<sc0> list, String[] strArr, int i) {
        LogUtils.logDebug("XpVuiElementChangedObserver", "onVuiElementChanged:" + str + ",elementList:" + list);
        if (this.mListener != null && !TextUtils.isEmpty(str)) {
            str = this.mListener.toString() + "-" + str;
        }
        if (view != null) {
            StringBuilder a = jg.a("");
            a.append(view.getId());
            String sb = a.toString();
            VuiEngineImpl vuiEngineImpl = vb0.a;
            sc0 vuiElement = vuiEngineImpl != null ? vuiEngineImpl.getVuiElement(str, sb) : null;
            if (vuiElement != null) {
                if (!mc0.RADIOBUTTON.c.equals(vuiElement.getType()) && !mc0.CHECKBOX.c.equals(vuiElement.getType())) {
                    if (mc0.RECYCLEVIEW.c.equals(vuiElement.getType())) {
                        VuiUtils.addScrollProps(vuiElement, view);
                        vuiElement.setElements(list);
                    } else if (mc0.STATEFULBUTTON.c.equals(vuiElement.getType())) {
                        VuiUtils.setStatefulButtonValues(i, strArr, vuiElement);
                    }
                } else {
                    VuiUtils.setValueAttribute(view, vuiElement);
                }
                vuiElement.setVisible(view.getVisibility() != 0 ? false : null);
                if (vb0.a != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(vuiElement);
                    vb0.a.setUpdateElements(str, arrayList);
                    return;
                }
                return;
            }
            VuiEngineImpl vuiEngineImpl2 = vb0.a;
            if (vuiEngineImpl2 != null) {
                vuiEngineImpl2.setBuildElements(str, list);
                return;
            }
            return;
        }
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (sceneCache != null) {
            List<sc0> cache = sceneCache.getCache(VuiEngineImpl.mSceneIdPrefix + "-" + str);
            if (cache != null && !cache.isEmpty()) {
                VuiEngineImpl vuiEngineImpl3 = vb0.a;
                if (vuiEngineImpl3 != null) {
                    vuiEngineImpl3.setUpdateElements(str, list);
                    return;
                }
                return;
            }
            LogUtils.logInfo("XpVuiElementChangedObserver", "cacheList is empty");
            VuiEngineImpl vuiEngineImpl4 = vb0.a;
            if (vuiEngineImpl4 != null) {
                vuiEngineImpl4.setBuildElements(str, list);
            }
        }
    }
}
