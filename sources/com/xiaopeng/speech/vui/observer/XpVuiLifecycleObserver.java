package com.xiaopeng.speech.vui.observer;

import android.text.TextUtils;
import com.xiaopeng.speech.vui.VuiEngineImpl;
import com.xiaopeng.speech.vui.listener.IXpVuiSceneListener;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.vd;
/* loaded from: classes.dex */
public class XpVuiLifecycleObserver implements yd {
    public static final String TAG = "VuiLifecycleObserver";
    public vd mLifeCycle;
    public IXpVuiSceneListener mListener;
    public String mSceneId;

    public XpVuiLifecycleObserver(String str, IXpVuiSceneListener iXpVuiSceneListener, vd vdVar) {
        this.mSceneId = str;
        this.mListener = iXpVuiSceneListener;
        this.mLifeCycle = vdVar;
    }

    @ge(vd.a.ON_CREATE)
    public void onCreate() {
        StringBuilder a = jg.a("onCreate: ");
        a.append(this.mSceneId);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (TextUtils.isEmpty(this.mSceneId)) {
            return;
        }
        String str = this.mSceneId;
        IXpVuiSceneListener iXpVuiSceneListener = this.mListener;
        VuiEngineImpl vuiEngineImpl = vb0.a;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiSceneListener(str, null, iXpVuiSceneListener, null, true);
        }
        LogUtils.logDebug("XpSpeechEngine", "registerVuiSceneListener:" + str + ",listener:" + iXpVuiSceneListener);
        iXpVuiSceneListener.onInitCompleted(new XpVuiElementChangedObserver());
    }

    @ge(vd.a.ON_DESTROY)
    public void onDestroy() {
        StringBuilder a = jg.a("onDestroy: ");
        a.append(this.mSceneId);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (!TextUtils.isEmpty(this.mSceneId)) {
            String str = this.mSceneId;
            IXpVuiSceneListener iXpVuiSceneListener = this.mListener;
            LogUtils.logDebug("XpSpeechEngine", "unregisterVuiSceneListener:" + str + ",listener:" + iXpVuiSceneListener);
            VuiEngineImpl vuiEngineImpl = vb0.a;
            if (vuiEngineImpl != null) {
                vuiEngineImpl.removeVuiSceneListener(str, iXpVuiSceneListener, false);
            }
        }
        vd vdVar = this.mLifeCycle;
        if (vdVar != null) {
            ae aeVar = (ae) vdVar;
            aeVar.a("removeObserver");
            aeVar.a.remove(this);
        }
    }

    @ge(vd.a.ON_PAUSE)
    public void onPause() {
        StringBuilder a = jg.a("onPause: ");
        a.append(this.mSceneId);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (TextUtils.isEmpty(this.mSceneId)) {
            return;
        }
        String str = this.mSceneId;
        LogUtils.logDebug("XpSpeechEngine", "exitScene:" + str);
        VuiEngineImpl vuiEngineImpl = vb0.a;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.exitScene(str, true);
        }
    }

    @ge(vd.a.ON_RESUME)
    public void onResume() {
        StringBuilder a = jg.a("onResume: ");
        a.append(this.mSceneId);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (TextUtils.isEmpty(this.mSceneId)) {
            return;
        }
        String str = this.mSceneId;
        LogUtils.logDebug("XpSpeechEngine", "enterScene:" + str);
        VuiEngineImpl vuiEngineImpl = vb0.a;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.enterScene(str, true);
        }
    }
}
