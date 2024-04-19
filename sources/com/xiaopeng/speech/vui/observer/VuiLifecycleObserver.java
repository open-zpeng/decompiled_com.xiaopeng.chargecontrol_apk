package com.xiaopeng.speech.vui.observer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.vd;
/* loaded from: classes.dex */
public class VuiLifecycleObserver implements yd {
    public static final String TAG = "VuiLifecycleObserver";
    public Context mContext;
    public gc0 mElementChangedListener;
    public boolean mKeepCache;
    public vd mLifeCycle;
    public jc0 mListener;
    public boolean mNeedBuild;
    public View mRootView;
    public String mSceneId;

    public VuiLifecycleObserver(Context context, vd vdVar, String str, View view, jc0 jc0Var, gc0 gc0Var, boolean z, boolean z2) {
        this.mSceneId = str;
        this.mListener = jc0Var;
        this.mContext = context;
        this.mLifeCycle = vdVar;
        this.mRootView = view;
        this.mElementChangedListener = gc0Var;
        this.mKeepCache = z2;
        this.mNeedBuild = z;
    }

    @ge(vd.a.ON_CREATE)
    public void onCreate() {
        StringBuilder a = jg.a("onCreate: ");
        a.append(this.mSceneId);
        a.append(",rootView:");
        a.append(this.mRootView);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (this.mContext == null || TextUtils.isEmpty(this.mSceneId) || this.mRootView == null) {
            return;
        }
        VuiEngine.getInstance(this.mContext).addVuiSceneListener(this.mSceneId, this.mRootView, this.mListener, this.mElementChangedListener, this.mNeedBuild);
    }

    @ge(vd.a.ON_DESTROY)
    public void onDestroy() {
        StringBuilder a = jg.a("onDestroy: ");
        a.append(this.mSceneId);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (this.mContext != null && !TextUtils.isEmpty(this.mSceneId)) {
            VuiEngine.getInstance(this.mContext).removeVuiSceneListener(this.mSceneId, this.mListener, this.mKeepCache);
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
        if (this.mContext == null || TextUtils.isEmpty(this.mSceneId) || this.mSceneId.contains("Local") || this.mSceneId.contains("local")) {
            return;
        }
        VuiEngine.getInstance(this.mContext).exitScene(this.mSceneId);
    }

    @ge(vd.a.ON_RESUME)
    public void onResume() {
        StringBuilder a = jg.a("onResume: ");
        a.append(this.mSceneId);
        LogUtils.d("VuiLifecycleObserver", a.toString());
        if (this.mContext == null || TextUtils.isEmpty(this.mSceneId) || this.mSceneId.contains("Local") || this.mSceneId.contains("local")) {
            return;
        }
        VuiEngine.getInstance(this.mContext).enterScene(this.mSceneId);
    }
}
