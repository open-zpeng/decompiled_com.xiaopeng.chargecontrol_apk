package com.xiaopeng.speech.vui;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.policy.DecorView;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.cache.VuiDisplayLocationInfoCache;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.listener.IUnityVuiSceneListener;
import com.xiaopeng.speech.vui.listener.IUnityVuiStateListener;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.model.VuiSceneState;
import com.xiaopeng.speech.vui.task.TaskDispatcher;
import com.xiaopeng.speech.vui.task.TaskWrapper;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.SceneMergeUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.BuildConfig;
import com.xiaopeng.speech.vui.vuiengine.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VuiEngineImpl {
    public static final String TAG = "VuiEngine";
    public static final String VUI_SCENE_TAG = "PopPanel";
    public EventDispatcher eventDispatcher;
    public Context mContext;
    public Handler mDispatherHandler;
    public HandlerThread mDispatherThread;
    public Handler mHandler;
    public String mPackageName;
    public String mPackageVersion;
    public Resources mResources;
    public HandlerThread mThread;
    public TaskDispatcher taskStructure;
    public static final ConcurrentMap<String, String> mActiveSceneIds = new ConcurrentHashMap();
    public static String mSceneIdPrefix = null;
    public static ConcurrentSkipListSet<String> mLeftPopPanelStack = new ConcurrentSkipListSet<>();
    public static ConcurrentSkipListSet<String> mRightPopPanelStack = new ConcurrentSkipListSet<>();
    public List<String> mainThreadSceneList = Arrays.asList("MainMusicConcentration");
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public List<String> mEnterSceneIds = Collections.synchronizedList(new ArrayList());
    public Handler mainHandler = new Handler(Looper.getMainLooper());
    public List<String> mLFEnterSceneStack = new ArrayList();
    public List<String> mRFEnterSceneStack = new ArrayList();
    public List<String> mBackNaviSceneStack = new ArrayList();
    public UpdateElementAttrRun mUpdateElementAttrRun = null;
    public UpdateSceneRun mUpdateSceneRun = null;
    public List<IUnityVuiStateListener> vuiStateListeners = new ArrayList();
    public Map<String, String> querySceneIdMap = new HashMap();

    /* loaded from: classes.dex */
    public class UpdateElementAttrRun implements Runnable {
        public String sceneId;
        public List<View> updateViews;

        public UpdateElementAttrRun() {
        }

        public String getSceneId() {
            return this.sceneId;
        }

        public List<View> getUpdateViews() {
            return this.updateViews;
        }

        @Override // java.lang.Runnable
        public void run() {
            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateElementAttrRun);
            VuiEngineImpl.this.mUpdateElementAttrRun = null;
            String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(this.sceneId);
            if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                StringBuilder a = jg.a("updateSceneElementAttribute:");
                a.append(this.sceneId);
                LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATEATTRIBUTE, this.updateViews));
            }
        }

        public void setSceneId(String str) {
            this.sceneId = str;
        }

        public void setUpdateViews(List<View> list) {
            this.updateViews = list;
        }
    }

    /* loaded from: classes.dex */
    public class UpdateSceneRun implements Runnable {
        public String sceneId;
        public List<View> updateViews;

        public UpdateSceneRun() {
        }

        public String getSceneId() {
            return this.sceneId;
        }

        public List<View> getUpdateViews() {
            return this.updateViews;
        }

        @Override // java.lang.Runnable
        public void run() {
            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateSceneRun);
            VuiEngineImpl.this.mUpdateSceneRun = null;
            String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(this.sceneId);
            if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                StringBuilder a = jg.a("updateScene:");
                a.append(this.sceneId);
                LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, this.updateViews));
            }
        }

        public void setSceneId(String str) {
            this.sceneId = str;
        }

        public void setUpdateViews(List<View> list) {
            this.updateViews = list;
        }
    }

    public VuiEngineImpl(Context context, boolean z) {
        LogUtils.logInfo(TAG, BuildConfig.BUILD_VERSION);
        if (VuiUtils.canUseVuiFeature()) {
            this.mContext = context;
            Foo.setContext(this.mContext);
            lazyInitThread();
            this.mResources = this.mContext.getResources();
            this.mPackageName = context.getApplicationInfo().packageName;
            VuiSceneManager.instance().setmPackageName(this.mPackageName);
            VuiSceneManager.instance().setContext(this.mContext);
            VuiSceneManager.instance().setEngine(this);
            this.eventDispatcher = new EventDispatcher(this.mContext, z);
            this.taskStructure = new TaskDispatcher();
            try {
                this.mPackageVersion = context.getPackageManager().getPackageInfo(this.mPackageName, 0).versionName;
                VuiSceneManager.instance().setmPackageVersion(this.mPackageVersion);
                mSceneIdPrefix = this.mPackageName + "-" + this.mPackageVersion;
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder();
                sb.append("VuiEngine init e:");
                jg.a(e, sb, TAG);
            }
        }
    }

    private void checkScrollSubViewIsInsight(String str, JSONArray jSONArray) {
        if (str == null || jSONArray == null || VuiUtils.cannotUpload()) {
            return;
        }
        try {
            IUnityVuiSceneListener iUnityVuiSceneListener = (IUnityVuiSceneListener) VuiSceneManager.instance().getVuiSceneListener(str);
            if (iUnityVuiSceneListener == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("scrollViewId");
                    JSONArray jSONArray2 = new JSONArray();
                    if (jSONObject.has(optString)) {
                        jSONArray2 = jSONObject.getJSONArray(optString);
                    }
                    jSONArray2.put(optJSONObject.optString("elementId"));
                    jSONObject.put(optString, jSONArray2);
                }
            }
            LogUtils.i(TAG, "checkScrollSubViewIsInsight:" + jSONObject.toString());
            if (jSONObject.length() > 0) {
                iUnityVuiSceneListener.checkSubElementsIsInsight(jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext(String str) {
        View findViewById;
        View rootView = VuiSceneManager.instance().getRootView(str);
        if (rootView != null) {
            Context context = rootView.getContext();
            if (rootView instanceof DecorView) {
                return context;
            }
            if (context != null && (context instanceof ContextWrapper)) {
                context = getDialogOwnContext(context);
            }
            return (context == null || !(context instanceof Application) || "com.xiaopeng.musicradio".equals(this.mPackageName) || (findViewById = rootView.findViewById(16908290)) == null || !(findViewById instanceof ViewGroup)) ? context : getDialogOwnContext(((ViewGroup) findViewById).getChildAt(0).getContext());
        }
        return null;
    }

    private Context getDialogOwnContext(Context context) {
        if ((context instanceof Activity) || (context instanceof Service) || (context instanceof Application)) {
            return context;
        }
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return getDialogOwnContext(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VuiScene getNewVuiScene(String str, long j) {
        return new VuiScene.Builder().sceneId(str).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(j).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a6, code lost:
        if (r5.equals(r11) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
        if (r0 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ac, code lost:
        if (r0 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handlerEnterScene(java.lang.String r9, boolean r10, java.lang.String r11) {
        /*
            r8 = this;
            com.xiaopeng.speech.vui.VuiSceneManager r0 = com.xiaopeng.speech.vui.VuiSceneManager.instance()
            java.lang.String r1 = r8.mPackageName
            java.lang.String r10 = r0.enterScene(r9, r1, r10, r11)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handlerEnterScene result:"
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "VuiEngine"
            com.xiaopeng.speech.vui.utils.LogUtils.i(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto Lcc
            com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory r0 = com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory.instance()
            com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory$CacheType r2 = com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory.CacheType.BUILD
            int r2 = r2.getType()
            com.xiaopeng.speech.vui.cache.VuiSceneCache r0 = r0.getSceneCache(r2)
            com.xiaopeng.speech.vui.cache.VuiSceneBuildCache r0 = (com.xiaopeng.speech.vui.cache.VuiSceneBuildCache) r0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L49
            java.lang.String r4 = r0.getDisplayCache(r9)
            boolean r4 = r11.equals(r4)
            if (r4 != 0) goto L49
            r0.setDisplayLocation(r9, r11)
            r0 = r2
            goto L4a
        L49:
            r0 = r3
        L4a:
            com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory r4 = com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory.instance()
            com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory$CacheType r5 = com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION
            int r5 = r5.getType()
            com.xiaopeng.speech.vui.cache.VuiSceneCache r4 = r4.getSceneCache(r5)
            com.xiaopeng.speech.vui.cache.VuiDisplayLocationInfoCache r4 = (com.xiaopeng.speech.vui.cache.VuiDisplayLocationInfoCache) r4
            if (r4 == 0) goto Lac
            java.lang.String r5 = r4.getDisplayCache(r9)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "sceneId:"
            r6.append(r7)
            r6.append(r9)
            java.lang.String r7 = "displayLocationCacheInfo:"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r7 = ",displayLocation:"
            r6.append(r7)
            r6.append(r11)
            java.lang.String r7 = ",enterNewScene:"
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.xiaopeng.speech.vui.utils.LogUtils.d(r1, r6)
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto La9
            boolean r0 = r5.equals(r11)
            if (r0 != 0) goto La2
            boolean r0 = r4.isSending()
            if (r0 != 0) goto La2
            r4.removeDisplayCache(r9)
            goto Lb0
        La2:
            boolean r11 = r5.equals(r11)
            if (r11 == 0) goto Laf
            goto Lb0
        La9:
            if (r0 != 0) goto Laf
            goto Lb0
        Lac:
            if (r0 != 0) goto Laf
            goto Lb0
        Laf:
            r3 = r2
        Lb0:
            if (r3 == 0) goto Lcc
            com.xiaopeng.speech.vui.VuiSceneManager r11 = com.xiaopeng.speech.vui.VuiSceneManager.instance()
            boolean r11 = r11.canUpdateScene(r9)
            if (r11 == 0) goto Lcc
            long r0 = java.lang.System.currentTimeMillis()
            com.xiaopeng.speech.vui.model.VuiScene r11 = r8.getNewVuiScene(r9, r0)
            com.xiaopeng.speech.vui.VuiSceneManager r0 = com.xiaopeng.speech.vui.VuiSceneManager.instance()
            r1 = 5
            r0.sendSceneData(r1, r2, r11)
        Lcc:
            boolean r11 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()
            if (r11 == 0) goto Ld3
            return
        Ld3:
            com.xiaopeng.speech.vui.VuiSceneManager r11 = com.xiaopeng.speech.vui.VuiSceneManager.instance()
            jc0 r9 = r11.getVuiSceneListener(r9)
            if (r9 == 0) goto Led
            if (r10 != 0) goto Le3
            r9.onBuildScene()
            goto Led
        Le3:
            android.os.Handler r10 = r8.mHandler
            com.xiaopeng.speech.vui.VuiEngineImpl$2 r11 = new com.xiaopeng.speech.vui.VuiEngineImpl$2
            r11.<init>()
            r10.post(r11)
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.VuiEngineImpl.handlerEnterScene(java.lang.String, boolean, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChangeActiveScene(String str, Context context, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            jc0 vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str2);
            if (!TextUtils.isEmpty(str2) && (str2.endsWith("Dialog") || str2.endsWith("dialog"))) {
                list.add(i, str);
                return false;
            }
            if (vuiSceneListener instanceof Dialog) {
                Context context2 = getContext(str2);
                LogUtils.logDebug(TAG, "enterScene stackContext:" + context2);
                if (context2 != null && (context2.equals(context) || ((context instanceof Activity) && ((context2 instanceof Service) || (context2 instanceof Application))))) {
                    LogUtils.logInfo(TAG, "enterScene has same context:" + i);
                    list.add(i, str);
                    return false;
                }
            }
        }
        return true;
    }

    private void lazyInitThread() {
        if (this.mThread == null) {
            this.mThread = new HandlerThread("VuiEngine-Thread");
            this.mThread.start();
            this.mHandler = new Handler(this.mThread.getLooper());
        }
        if (this.mDispatherThread == null) {
            this.mDispatherThread = new HandlerThread("VuiEngine-Disptcher-Thread");
            this.mDispatherThread.start();
            this.mDispatherHandler = new Handler(this.mDispatherThread.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVuiStateChanged() {
        final jc0 vuiSceneListener;
        final jc0 vuiSceneListener2;
        try {
            List<String> list = this.mLFEnterSceneStack;
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str) && (vuiSceneListener2 = VuiSceneManager.instance().getVuiSceneListener(str)) != null) {
                    this.mainHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.21
                        @Override // java.lang.Runnable
                        public void run() {
                            vuiSceneListener2.s();
                        }
                    });
                }
            }
            List<String> list2 = this.mRFEnterSceneStack;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                String str2 = list2.get(i2);
                if (!TextUtils.isEmpty(str2) && (vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str2)) != null) {
                    this.mainHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.22
                        @Override // java.lang.Runnable
                        public void run() {
                            vuiSceneListener.s();
                        }
                    });
                }
            }
        } catch (Exception unused) {
            LogUtils.e(TAG, "sendVuiStateChangedEvent error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVuiStateChangedEvent(boolean z) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        updateListIndexState();
        onVuiStateChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMainSceneBuildElements(VuiSceneInfo vuiSceneInfo, VuiScene vuiScene) {
        if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
            StringBuilder a = jg.a("BuildSceneTask full_scene_info");
            a.append(VuiUtils.vuiSceneConvertToString(vuiScene));
            LogUtils.logDebug(TAG, a.toString());
        }
        if (vuiSceneInfo != null) {
            vuiSceneInfo.setBuild(true);
            vuiSceneInfo.setBuildComplete(true);
        }
        VuiSceneManager.instance().sendSceneData(0, false, vuiScene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<sc0> setSubSceneElementToCache(String str, VuiSceneCache vuiSceneCache, List<sc0> list) {
        List<sc0> cache = vuiSceneCache.getCache(str);
        if (cache == null) {
            cache = new ArrayList<>();
        }
        if (cache.contains(list.get(0))) {
            return cache;
        }
        List<sc0> merge = SceneMergeUtils.merge(cache, list, false);
        vuiSceneCache.setCache(str, merge);
        if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL && !VuiUtils.isActiveSceneId(str)) {
            VuiScene newVuiScene = getNewVuiScene(str, System.currentTimeMillis());
            newVuiScene.setElements(merge);
            LogUtils.logDebug(TAG, "buildScene full_scene_info:" + VuiUtils.vuiSceneConvertToString(newVuiScene));
        }
        return merge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWholeSceneCache(String str, VuiSceneCache vuiSceneCache, List<sc0> list) {
        if (vuiSceneCache != null) {
            List<sc0> fusionCache = vuiSceneCache.getFusionCache(str, list, false);
            vuiSceneCache.setCache(str, fusionCache);
            if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                return;
            }
            VuiScene newVuiScene = getNewVuiScene(str, System.currentTimeMillis());
            newVuiScene.setElements(fusionCache);
            LogUtils.logDebug(TAG, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, String str2, jc0 jc0Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TaskWrapper((View) null, str, taskType, jc0Var, str2));
        return arrayList;
    }

    public void addDupVuiSceneListener(String str, View view, jc0 jc0Var, gc0 gc0Var, boolean z) {
        addVuiSceneListener(str, view, jc0Var, gc0Var, z, true);
    }

    public void addSceneElement(final View view, final String str, final String str2) {
        Handler handler;
        if (VuiUtils.cannotUpload() || view == null || str2 == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.17
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    StringBuilder a = jg.a("addSceneElement:");
                    a.append(str2);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, str, (pc0) null, (jc0) null, view));
                }
            }
        });
    }

    public void addSceneElementGroup(final View view, final String str, final pc0 pc0Var, final jc0 jc0Var) {
        Handler handler;
        if (VuiUtils.cannotUpload() || view == null || str == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.16
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    StringBuilder a = jg.a("addSceneElementGroup:");
                    a.append(str);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, (String) null, pc0Var, jc0Var, view));
                }
            }
        });
    }

    public void addVuiEventListener(final String str, final IVuiEventListener iVuiEventListener) {
        Handler handler;
        if (!VuiUtils.canUseVuiFeature() || (handler = this.mHandler) == null || str == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.29
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder a = jg.a("addVuiEventListener :");
                a.append(str);
                LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                VuiSceneManager.instance().addVuiEventListener(VuiEngineImpl.this.getSceneUnqiueId(str), iVuiEventListener);
            }
        });
    }

    public void addVuiSceneListener(String str, View view, jc0 jc0Var, gc0 gc0Var, boolean z) {
        addVuiSceneListener(str, view, jc0Var, gc0Var, z, false);
    }

    public void addVuiStateChangeListener(IUnityVuiStateListener iUnityVuiStateListener) {
        if (this.vuiStateListeners.contains(iUnityVuiStateListener)) {
            return;
        }
        this.vuiStateListeners.add(iUnityVuiStateListener);
    }

    public void buildScene(String str, View view, List<Integer> list, hc0 hc0Var, List<String> list2, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        buildScene(str, view, list, hc0Var, list2, z, iSceneCallbackHandler, VuiConstants.SCREEN_DISPLAY_LF, (jc0) null);
    }

    public VuiScene createVuiScene(String str, long j) {
        return new VuiScene.Builder().sceneId(getSceneUnqiueId(str)).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(j).build();
    }

    public void disableChildVuiAttrWhenInvisible(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.disableChildVuiAttrsWhenInvisible, true);
    }

    public void disableViewVuiMode() {
        LogUtils.logInfo(TAG, "user disable view's vui mode");
        VuiUtils.userDisableViewMode();
    }

    public void disableVuiFeature() {
        LogUtils.logInfo(TAG, "user disable feature");
        VuiUtils.userSetFeatureState(true);
    }

    public void dispatchVuiEvent(final String str, final String str2) {
        Handler handler = this.mDispatherHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.20
            @Override // java.lang.Runnable
            public void run() {
                if (VuiUtils.canUseVuiFeature()) {
                    StringBuilder a = jg.a("dispatchVuiEvent:");
                    a.append(str);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    if (str.equals(VuiConstants.VUI_FEATURE_DISABLE)) {
                        VuiUtils.disableVuiFeature();
                        VuiSceneManager.instance().setFeatureState(false);
                        LogUtils.logInfo(VuiEngineImpl.TAG, "disableVuiFeature:" + VuiEngineImpl.this.vuiStateListeners.size());
                        if (VuiEngineImpl.this.isInSpeech()) {
                            if (VuiEngineImpl.this.vuiStateListeners != null) {
                                for (int i = 0; i < VuiEngineImpl.this.vuiStateListeners.size(); i++) {
                                    IUnityVuiStateListener iUnityVuiStateListener = (IUnityVuiStateListener) VuiEngineImpl.this.vuiStateListeners.get(i);
                                    if (iUnityVuiStateListener != null) {
                                        iUnityVuiStateListener.onHideVuiListIndex();
                                    }
                                }
                            }
                            VuiEngineImpl.this.onVuiStateChanged();
                        }
                    } else if (str.equals(VuiConstants.VUI_FEATURE_ENABLE)) {
                        VuiUtils.enableVuiFeature();
                        VuiSceneManager.instance().setFeatureState(true);
                        LogUtils.logInfo(VuiEngineImpl.TAG, "enableVuiFeature:");
                    } else if (str.equals(VuiConstants.DM_START_EVENT)) {
                        VuiSceneManager.instance().setInSpeech(true);
                        VuiEngineImpl.this.sendVuiStateChangedEvent(true);
                    } else if (str.equals(VuiConstants.DM_END_EVENT)) {
                        VuiSceneManager.instance().setInSpeech(false);
                        VuiEngineImpl.this.sendVuiStateChangedEvent(false);
                    } else if (!str.equals(VuiConstants.REBUILD_EVENT) && !str.equals(VuiConstants.SCENE_REBUILD_EVENT)) {
                        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str2)) {
                            return;
                        }
                        try {
                            VuiEngineImpl.this.eventDispatcher.dispatch(str, str2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else if (!VuiUtils.cannotUpload() && !TextUtils.isEmpty(str2) && VuiUtils.getPackageNameFromSceneId(str2).equals(VuiEngineImpl.this.mPackageName)) {
                        List<sc0> cache = ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).getCache(str2);
                        if (cache != null && !cache.isEmpty()) {
                            VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(str2, System.currentTimeMillis());
                            newVuiScene.setElements(cache);
                            VuiSceneCacheFactory.instance().removeAllCache(str2);
                            VuiSceneManager.instance().sendSceneData(0, true, newVuiScene);
                            return;
                        }
                        jc0 vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str2);
                        if (vuiSceneListener != null) {
                            vuiSceneListener.onBuildScene();
                        }
                    }
                }
            }
        });
    }

    public void enableVuiFeature() {
        LogUtils.logInfo(TAG, "user enable feature");
        VuiUtils.userSetFeatureState(false);
    }

    public void enterDupScene(String str, boolean z, jc0 jc0Var) {
        if (jc0Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        enterScene(jc0Var.toString() + "-" + str, z);
    }

    public void enterScene(String str, boolean z) {
        enterScene(str, VuiUtils.getSourceDisplayLocation(), z);
    }

    public void exitDupScene(String str, boolean z, jc0 jc0Var) {
        if (jc0Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        exitScene(jc0Var.toString() + "-" + str, z);
    }

    public void exitScene(String str, boolean z) {
        exitScene(str, VuiUtils.getSourceDisplayLocation(), z, null);
    }

    public Map<String, String> getActiveSceneId() {
        return mActiveSceneIds;
    }

    public String getActiveWholeSceneId(List<String> list) {
        if (list == null) {
            return "";
        }
        String str = mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF);
        String str2 = mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF);
        return (TextUtils.isEmpty(str) || !list.contains(str)) ? (TextUtils.isEmpty(str2) || !list.contains(str2)) ? "" : str2 : str;
    }

    public String getElementState(String str, String str2) {
        if (VuiUtils.cannotUpload()) {
            return null;
        }
        LogUtils.logDebug(TAG, "getElementState:" + str + ",elementId:" + str2);
        if (getJSONType(str2)) {
            return VuiSceneManager.instance().checkScrollSubViewIsVisible(str, str2);
        }
        return VuiSceneManager.instance().getElementState(str, str2);
    }

    public boolean getJSONType(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith("}")) {
                return true;
            }
            if (trim.startsWith("[") && trim.endsWith("]")) {
                return true;
            }
        }
        return false;
    }

    public String getSceneUnqiueId(String str) {
        return mSceneIdPrefix + "-" + str;
    }

    public sc0 getVuiElement(String str, String str2) {
        VuiSceneCache sceneCache;
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())) == null) {
            return null;
        }
        return sceneCache.getVuiElementById(getSceneUnqiueId(str), str2);
    }

    public String getVuiElementId(String str, int i, String str2) {
        if (str != null) {
            str2 = jg.b(str, "_", str2);
        }
        if (i != -1) {
            return str2 + "_" + i;
        }
        return str2;
    }

    public String getVuiElementTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return null;
        }
        String str = (String) view.getTag();
        if (str.startsWith("4657")) {
            return str;
        }
        return null;
    }

    public Boolean getVuiElementVisibleTag(View view) {
        Boolean bool;
        if (!VuiUtils.canUseVuiFeature() || view == null || (bool = (Boolean) view.getTag(R.id.vuiElementVisible)) == null) {
            return null;
        }
        return bool;
    }

    public VuiScene getVuiScene(String str) {
        List<sc0> cache;
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str)) {
            return null;
        }
        VuiScene createVuiScene = createVuiScene(str, System.currentTimeMillis());
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (sceneCache != null && (cache = sceneCache.getCache(createVuiScene.getSceneId())) != null && cache.isEmpty()) {
            createVuiScene.setElements(cache);
        }
        return createVuiScene;
    }

    public void handleNewRootviewToScene(final String str, final List<View> list, final pc0 pc0Var) {
        Handler handler;
        if (VuiUtils.cannotUpload() || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.13
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (list == null || (str2 = str) == null) {
                    return;
                }
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    StringBuilder a = jg.a("handleNewRootviewToScene:");
                    a.append(str);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, pc0Var, TaskDispatcher.TaskType.ADD, (List<View>) list, true));
                }
            }
        });
    }

    public void init(String str) {
        subscribe(this.mPackageName + "." + str);
    }

    public boolean isInSpeech() {
        return VuiSceneManager.instance().isInSpeech();
    }

    public boolean isSpeechShowNumber() {
        if (VuiUtils.cannotUpload()) {
            return false;
        }
        return VuiSceneManager.instance().isInSpeech();
    }

    public boolean isVuiFeatureDisabled() {
        return VuiUtils.cannotUpload();
    }

    public void onVuiQuery(String str, String str2) {
        IUnityVuiSceneListener iUnityVuiSceneListener;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(VuiConstants.SCENE_ID, "");
            if (VuiUtils.is3DApp(VuiUtils.getPackageNameFromSceneId(optString))) {
                if ("vui.scrollview.childview.visible".equals(str)) {
                    checkScrollSubViewIsInsight(optString, jSONObject.optJSONArray(VuiConstants.SCENE_ELEMENTS));
                } else if ("vui.element.scroll.state".equals(str)) {
                    String optString2 = jSONObject.optString("elementId", "");
                    String optString3 = jSONObject.optString(VuiConstants.EVENT_VALUE_DIRECTION, "");
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(optString);
                    if (sceneInfo != null) {
                        List<String> subSceneList = sceneInfo.getSubSceneList();
                        LogUtils.logInfo(TAG, "subSceneIds:" + subSceneList);
                        if (subSceneList != null) {
                            for (int i = 0; i < subSceneList.size(); i++) {
                                String str3 = subSceneList.get(i);
                                if (((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).getVuiElementById(str3, optString2) != null && (iUnityVuiSceneListener = (IUnityVuiSceneListener) VuiSceneManager.instance().getVuiSceneListener(str3)) != null) {
                                    this.querySceneIdMap.put(str3, optString);
                                    iUnityVuiSceneListener.getScrollViewState(optString2, optString3);
                                    return;
                                }
                            }
                        }
                    }
                    IUnityVuiSceneListener iUnityVuiSceneListener2 = (IUnityVuiSceneListener) VuiSceneManager.instance().getVuiSceneListener(optString);
                    if (iUnityVuiSceneListener2 != null) {
                        iUnityVuiSceneListener2.getScrollViewState(optString2, optString3);
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void onVuiQueryCallBack(String str, String str2, String str3) {
        LogUtils.d(TAG, "onVuiQueryCallBack:" + str + ",event:" + str2);
        String sceneUnqiueId = getSceneUnqiueId(str);
        if (this.querySceneIdMap.containsKey(sceneUnqiueId)) {
            this.querySceneIdMap.remove(sceneUnqiueId);
            sceneUnqiueId = this.querySceneIdMap.get(sceneUnqiueId);
        }
        if (getJSONType(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                jSONObject.put(VuiConstants.SCENE_ID, sceneUnqiueId);
                VuiSceneManager.instance().onVuiQueryCallBack(sceneUnqiueId, str2, jSONObject.toString());
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        VuiSceneManager.instance().onVuiQueryCallBack(sceneUnqiueId, str2, str3);
    }

    public void removeDupVuiSceneListener(String str, jc0 jc0Var, boolean z) {
        if (jc0Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        removeVuiSceneListener(jc0Var.toString() + "-" + str, jc0Var, z);
    }

    public void removeOtherRootViewFromScene(final String str, final List<View> list) {
        Handler handler;
        if (VuiUtils.cannotUpload() || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.14
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null) {
                    return;
                }
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    StringBuilder a = jg.a("removeOtherRootViewFromScene:");
                    a.append(str);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.REMOVE, list));
                }
            }
        });
    }

    public void removeSceneElementGroup(final String str, final String str2, final jc0 jc0Var) {
        Handler handler;
        if (VuiUtils.cannotUpload() || str2 == null || str == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.18
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    StringBuilder a = jg.a("removeSceneElementGroup:");
                    a.append(str2);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.REMOVE, str, jc0Var));
                }
            }
        });
    }

    public void removeVuiElement(final String str, final String str2) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.19
            @Override // java.lang.Runnable
            public void run() {
                if (VuiSceneManager.instance().canUpdateScene(VuiEngineImpl.this.getSceneUnqiueId(str))) {
                    StringBuilder a = jg.a("removeVuiElement:");
                    a.append(str);
                    a.append(",elementId:");
                    a.append(str2);
                    LogUtils.logInfo(VuiEngineImpl.TAG, a.toString());
                    VuiSceneManager instance = VuiSceneManager.instance();
                    instance.sendSceneData(3, true, str + CFCHelper.SIGNAL_CFC_SPLIT + str2);
                }
            }
        });
    }

    public void removeVuiSceneListener(final String str, final jc0 jc0Var, final boolean z) {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.28
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 == null) {
                        return;
                    }
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                    boolean z2 = false;
                    if (sceneInfo != null && sceneInfo.isWholeScene()) {
                        z2 = true;
                    }
                    if (jc0Var != null && sceneInfo != null && sceneInfo.getListener() != null && !jc0Var.equals(sceneInfo.getListener())) {
                        LogUtils.w(VuiEngineImpl.TAG, "要销毁的场景和目前持有的场景数据不一致");
                        return;
                    }
                    if (!VuiEngineImpl.mActiveSceneIds.containsValue(sceneUnqiueId)) {
                        if (VuiEngineImpl.this.mLFEnterSceneStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.this.mLFEnterSceneStack.remove(sceneUnqiueId);
                        } else if (VuiEngineImpl.this.mRFEnterSceneStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.this.mRFEnterSceneStack.remove(sceneUnqiueId);
                        } else if (VuiEngineImpl.mRightPopPanelStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.mRightPopPanelStack.remove(sceneUnqiueId);
                            VuiEngineImpl.this.exitScene(str, VuiConstants.SCREEN_DISPLAY_RF, true, jc0Var);
                        } else if (VuiEngineImpl.mLeftPopPanelStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.mLeftPopPanelStack.remove(sceneUnqiueId);
                            VuiEngineImpl.this.exitScene(str, VuiConstants.SCREEN_DISPLAY_LF, true, jc0Var);
                        }
                    } else {
                        VuiEngineImpl.this.exitScene(str, sceneInfo != null ? sceneInfo.isWholeScene() : true);
                    }
                    StringBuilder a = jg.a("removeVuiSceneListener :");
                    a.append(str);
                    a.append(",isupload:");
                    a.append(z2);
                    a.append(",keepCache:");
                    a.append(z);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.removeTask(sceneUnqiueId);
                    VuiSceneManager.instance().removeVuiSceneListener(sceneUnqiueId, z2, z, jc0Var);
                }
            });
        }
    }

    public void removeVuiStateChangeListener(IUnityVuiStateListener iUnityVuiStateListener) {
        if (this.vuiStateListeners.contains(iUnityVuiStateListener)) {
            this.vuiStateListeners.remove(iUnityVuiStateListener);
        }
    }

    public void setBuildElements(String str) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        try {
            VuiScene stringConvertToVuiScene = VuiUtils.stringConvertToVuiScene(str);
            String sceneId = stringConvertToVuiScene.getSceneId();
            List<sc0> elements = stringConvertToVuiScene.getElements();
            if (elements == null) {
                elements = new ArrayList<>();
            }
            if (TextUtils.isEmpty(sceneId)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            boolean z = jSONObject.getBoolean("isMainScene");
            JSONArray jSONArray = jSONObject.getJSONArray("subSceneIds");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(getSceneUnqiueId(jSONArray.getString(i)));
            }
            LogUtils.logInfo(TAG, "sceneId:" + sceneId + "isMainScene:" + z + ",subSceneIds:" + arrayList);
            setBuildElements(stringConvertToVuiScene.getSceneId(), elements, z, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCustomDoActionTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDoAction, true);
    }

    public void setExecuteVirtualTag(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setTag(R.id.executeVirtualId, VuiConstants.VIRTUAL_LIST_ID);
            return;
        }
        int i = R.id.executeVirtualId;
        view.setTag(i, "10000_" + str);
    }

    public void setHasFeedBackTxtByViewDisable(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDisableFeedbackTTS, str);
    }

    public void setLoglevel(int i) {
        LogUtils.setLogLevel(i);
    }

    public void setProcessName(String str) {
        VuiSceneManager.instance().setProcessName(str);
    }

    public void setUpdateElementValue(final String str, final String str2, final Object obj) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                            VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                            if (sceneCache != null) {
                                StringBuilder a = jg.a("newSceneId：", sceneUnqiueId, "，elementId：");
                                a.append(str2);
                                LogUtils.i(VuiEngineImpl.TAG, a.toString());
                                sc0 vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, str2);
                                LogUtils.i(VuiEngineImpl.TAG, "targetElement：" + vuiElementById);
                                if (vuiElementById != null) {
                                    vuiElementById.setValues(obj);
                                    LogUtils.i(VuiEngineImpl.TAG, "targetElement：" + vuiElementById);
                                    List<sc0> asList = Arrays.asList(vuiElementById);
                                    LogUtils.i(VuiEngineImpl.TAG, "resultElement：" + asList);
                                    newVuiScene.setElements(asList);
                                    List<sc0> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, asList, false);
                                    sceneCache.setCache(sceneUnqiueId, fusionCache);
                                    if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                                        VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                                        newVuiScene2.setElements(fusionCache);
                                        StringBuilder a2 = jg.a("updateSceneTask full_scene_info");
                                        a2.append(VuiUtils.vuiSceneConvertToString(newVuiScene2));
                                        LogUtils.logDebug(VuiEngineImpl.TAG, a2.toString());
                                    }
                                    VuiSceneManager.instance().sendSceneData(1, true, newVuiScene);
                                }
                            }
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public void setUpdateElementVisible(final String str, final String str2, final boolean z) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.8
            @Override // java.lang.Runnable
            public void run() {
                sc0 vuiElementById;
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (sceneCache == null || (vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, str2)) != null) {
                        return;
                    }
                    vuiElementById.setVisible(Boolean.valueOf(z));
                    List<sc0> asList = Arrays.asList(vuiElementById);
                    newVuiScene.setElements(asList);
                    List<sc0> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, asList, false);
                    sceneCache.setCache(sceneUnqiueId, fusionCache);
                    if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                        VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                        newVuiScene2.setElements(fusionCache);
                        StringBuilder a = jg.a("updateSceneTask full_scene_info");
                        a.append(VuiUtils.vuiSceneConvertToString(newVuiScene2));
                        LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    }
                    VuiSceneManager.instance().sendSceneData(1, true, newVuiScene);
                }
            }
        });
    }

    public void setUpdateElements(String str, List<sc0> list) {
        setUpdateElements(str, list, VuiConstants.SCREEN_DISPLAY_LF);
    }

    public void setVirtualResourceNameTag(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(R.id.virtualResourceName, str);
    }

    public void setVuiCustomDisableControlTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDisableControl, true);
    }

    public void setVuiCustomDisableFeedbackTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDisableFeedback, true);
    }

    public void setVuiElementDefaultAction(View view, String str, Object obj) {
        if (!VuiUtils.canUseVuiFeature() || view == null || str == null || obj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            VuiUtils.generateElementValueJSON(jSONObject, str, obj);
            view.setTag(R.id.vuiElementDefaultAction, jSONObject);
        } catch (Exception e) {
            LogUtils.e(TAG, e.fillInStackTrace());
        }
    }

    public void setVuiElementTag(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        String str2 = "4657_" + str;
        view.setTag(str2);
        if (view instanceof ec0) {
            ((ec0) view).b(str2);
        }
    }

    public void setVuiElementUnSupportTag(View view, boolean z) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.vuiElementUnSupport, Boolean.valueOf(z));
    }

    public void setVuiElementVisibleTag(View view, boolean z) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.vuiElementVisible, Boolean.valueOf(z));
    }

    public void setVuiLabelUnSupportText(View... viewArr) {
        if (!VuiUtils.canUseVuiFeature() || viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            view.setTag(R.id.vuiLabelUnSupportText, true);
        }
    }

    public void setVuiStatefulButtonClick(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.vuiStatefulButtonClick, true);
    }

    public void subscribe(final String str) {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.23
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder a = jg.a("subscribe:");
                    a.append(str);
                    LogUtils.logInfo(VuiEngineImpl.TAG, a.toString());
                    VuiSceneManager.instance().subscribe(str);
                }
            });
        }
    }

    public void subscribeVuiFeature() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.24
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "subscribeVuiFeature");
                    VuiSceneManager.instance().subscribeVuiFeature();
                }
            });
        }
    }

    public void unSubscribe() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.26
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "unSubscribe");
                    VuiSceneManager.instance().unSubscribe();
                }
            });
        }
    }

    public void unSubscribeVuiFeature() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.25
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "subscribeVuiFeature");
                    VuiSceneManager.instance().unSubscribeVuiFeature();
                }
            });
        }
    }

    public void updateDisplayLocation(final String str, final String str2) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        LogUtils.i(TAG, "updateDisplayLocation");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.30
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                VuiDisplayLocationInfoCache vuiDisplayLocationInfoCache = (VuiDisplayLocationInfoCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION.getType());
                vuiDisplayLocationInfoCache.setCache(sceneUnqiueId, str2);
                if (VuiEngineImpl.this.mLFEnterSceneStack.contains(sceneUnqiueId) && VuiConstants.SCREEN_DISPLAY_RF.equals(str2)) {
                    VuiEngineImpl.this.enterScene(str, str2, true);
                }
                if (VuiEngineImpl.this.mRFEnterSceneStack.contains(sceneUnqiueId) && VuiConstants.SCREEN_DISPLAY_LF.equals(str2)) {
                    VuiEngineImpl.this.enterScene(str, str2, true);
                }
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                    newVuiScene.setDisplayLocation(str2);
                    LogUtils.i(VuiEngineImpl.TAG, "updateDisplayLocation ===    " + str2);
                    VuiSceneManager.instance().sendSceneData(5, false, newVuiScene);
                    return;
                }
                vuiDisplayLocationInfoCache.removeDisplayCache(sceneUnqiueId);
            }
        });
    }

    public void updateElementAttribute(final String str, final List<View> list) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload() || list == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateElementAttribute");
                    if (VuiEngineImpl.this.mUpdateElementAttrRun != null) {
                        if (str.equals(VuiEngineImpl.this.mUpdateElementAttrRun.getSceneId())) {
                            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateElementAttrRun);
                            HashSet hashSet = new HashSet(VuiEngineImpl.this.mUpdateElementAttrRun.getUpdateViews());
                            hashSet.addAll(list);
                            VuiEngineImpl.this.mUpdateElementAttrRun.setUpdateViews(new ArrayList(hashSet));
                            VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateElementAttrRun, 50L);
                            return;
                        }
                        VuiEngineImpl.this.mUpdateElementAttrRun.run();
                        VuiEngineImpl vuiEngineImpl = VuiEngineImpl.this;
                        vuiEngineImpl.mUpdateElementAttrRun = new UpdateElementAttrRun();
                        VuiEngineImpl.this.mUpdateElementAttrRun.setSceneId(str);
                        VuiEngineImpl.this.mUpdateElementAttrRun.setUpdateViews(list);
                        VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateElementAttrRun, 50L);
                        return;
                    }
                    VuiEngineImpl vuiEngineImpl2 = VuiEngineImpl.this;
                    vuiEngineImpl2.mUpdateElementAttrRun = new UpdateElementAttrRun();
                    VuiEngineImpl.this.mUpdateElementAttrRun.setSceneId(str);
                    VuiEngineImpl.this.mUpdateElementAttrRun.setUpdateViews(list);
                    VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateElementAttrRun, 50L);
                }
            });
        }
    }

    public void updateListIndexState() {
        if (this.vuiStateListeners != null) {
            for (int i = 0; i < this.vuiStateListeners.size(); i++) {
                IUnityVuiStateListener iUnityVuiStateListener = this.vuiStateListeners.get(i);
                if (iUnityVuiStateListener != null) {
                    if (isInSpeech()) {
                        iUnityVuiStateListener.onShowVuiListIndex();
                    } else {
                        iUnityVuiStateListener.onHideVuiListIndex();
                    }
                }
            }
        }
    }

    public void updateRecyclerViewItemView(String str, List<View> list, nf nfVar) {
        if (VuiUtils.cannotUpload() || list == null || TextUtils.isEmpty(str)) {
            return;
        }
        String sceneUnqiueId = getSceneUnqiueId(str);
        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
            LogUtils.logInfo(TAG, "updateRecyclerViewItemView:" + str);
            this.taskStructure.dispatchTask(structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATERECYCLEVIEWITEM, list, nfVar));
        }
    }

    public void updateScene(final String str, final View view) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload() || view == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene");
                    if (VuiEngineImpl.this.mUpdateSceneRun != null) {
                        if (str.equals(VuiEngineImpl.this.mUpdateSceneRun.getSceneId())) {
                            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateSceneRun);
                            HashSet hashSet = new HashSet(VuiEngineImpl.this.mUpdateSceneRun.getUpdateViews());
                            hashSet.add(view);
                            VuiEngineImpl.this.mUpdateSceneRun.setUpdateViews(new ArrayList(hashSet));
                            VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateSceneRun, 50L);
                            return;
                        }
                        VuiEngineImpl.this.mUpdateSceneRun.run();
                        VuiEngineImpl vuiEngineImpl = VuiEngineImpl.this;
                        vuiEngineImpl.mUpdateSceneRun = new UpdateSceneRun();
                        VuiEngineImpl.this.mUpdateSceneRun.setSceneId(str);
                        VuiEngineImpl.this.mUpdateSceneRun.setUpdateViews(Arrays.asList(view));
                        VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateSceneRun, 50L);
                        return;
                    }
                    VuiEngineImpl vuiEngineImpl2 = VuiEngineImpl.this;
                    vuiEngineImpl2.mUpdateSceneRun = new UpdateSceneRun();
                    VuiEngineImpl.this.mUpdateSceneRun.setSceneId(str);
                    VuiEngineImpl.this.mUpdateSceneRun.setUpdateViews(Arrays.asList(view));
                    VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateSceneRun, 50L);
                }
            });
        }
    }

    public void vuiFeedback(String str, String str2) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        VuiSceneManager.instance().vuiFeedBack(str, str2);
    }

    public void addVuiSceneListener(final String str, final View view, final jc0 jc0Var, final gc0 gc0Var, final boolean z, final boolean z2) {
        Handler handler;
        if (!VuiUtils.canUseVuiFeature() || (handler = this.mHandler) == null || str == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.27
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder a = jg.a("addVuiSceneListener :");
                a.append(str);
                LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                String str2 = str;
                if (z2) {
                    str2 = jc0Var.toString() + "-" + str;
                }
                VuiSceneManager.instance().addVuiSceneListener(VuiEngineImpl.this.getSceneUnqiueId(str2), view, jc0Var, gc0Var, z);
            }
        });
    }

    public void buildScene(final String str, final View view, final List<Integer> list, final hc0 hc0Var, final List<String> list2, final boolean z, final ISceneCallbackHandler iSceneCallbackHandler, final String str2, final jc0 jc0Var) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        if (view == null || str == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                    if (jc0Var != null && sceneInfo != null && sceneInfo.getListener() != null && !jc0Var.equals(sceneInfo.getListener())) {
                        LogUtils.w(VuiEngineImpl.TAG, "要build的场景和目前持有的场景数据不一致");
                    } else if (VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId) == VuiSceneState.INIT.getState() && z) {
                        LogUtils.e(VuiEngineImpl.TAG, str + "场景数据的创建必须在场景被激活后");
                    } else {
                        LogUtils.logDebug(VuiEngineImpl.TAG, "buildScene:" + str);
                        List list3 = null;
                        if (list2 != null) {
                            list3 = new ArrayList();
                            list3.addAll(list2);
                            int size = list3.size();
                            for (int i = 0; i < size; i++) {
                                String str3 = (String) list3.get(i);
                                list3.remove(str3);
                                list3.add(i, VuiEngineImpl.this.getSceneUnqiueId(str3));
                            }
                        }
                        VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.BUILD, list, hc0Var, list3, Arrays.asList(view), z, iSceneCallbackHandler, str2, jc0Var));
                    }
                } catch (Exception e) {
                    StringBuilder a = jg.a("e:");
                    a.append(e.fillInStackTrace());
                    LogUtils.e(VuiEngineImpl.TAG, a.toString());
                }
            }
        }, 200L);
    }

    public void enterScene(final String str, final String str2, final boolean z) {
        Handler handler;
        if (VuiUtils.canUseVuiFeature()) {
            if (TextUtils.isEmpty(str2)) {
                str2 = VuiConstants.SCREEN_DISPLAY_LF;
            }
            if (str == null || (handler = this.mHandler) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.1
                /* JADX WARN: Removed duplicated region for block: B:113:0x02f8 A[Catch: Exception -> 0x0500, TryCatch #0 {Exception -> 0x0500, blocks: (B:3:0x000a, B:5:0x0022, B:7:0x0039, B:10:0x0053, B:12:0x005b, B:14:0x007e, B:17:0x008c, B:19:0x0098, B:22:0x00ab, B:24:0x00b0, B:26:0x00ca, B:28:0x00d6, B:29:0x00df, B:31:0x00e7, B:34:0x00f0, B:36:0x00fc, B:51:0x0154, B:38:0x0107, B:40:0x0113, B:42:0x0125, B:44:0x012b, B:46:0x0131, B:47:0x013c, B:49:0x0141, B:50:0x014b, B:53:0x016f, B:55:0x017d, B:58:0x0186, B:60:0x01b8, B:63:0x01c4, B:65:0x01cc, B:67:0x01d4, B:68:0x01ec, B:70:0x01f4, B:71:0x01f9, B:73:0x0203, B:75:0x020b, B:77:0x0213, B:78:0x022b, B:80:0x0233, B:81:0x0238, B:83:0x0242, B:85:0x024a, B:87:0x0256, B:93:0x027d, B:95:0x02a3, B:97:0x02ab, B:100:0x02b4, B:102:0x02bc, B:105:0x02cb, B:107:0x02d3, B:113:0x02f8, B:115:0x0307, B:119:0x0322, B:116:0x0311, B:118:0x0319, B:120:0x032b, B:123:0x0367, B:125:0x0373, B:126:0x03b9, B:128:0x03c5, B:130:0x03d1, B:131:0x03ef, B:132:0x03f6, B:134:0x03fe, B:136:0x040a, B:138:0x0454, B:140:0x0460, B:142:0x046c, B:144:0x0478, B:145:0x048e, B:147:0x04bb, B:149:0x04c7, B:151:0x04d3, B:152:0x04f0, B:108:0x02e0, B:110:0x02e8, B:88:0x0260, B:90:0x0268, B:92:0x0274, B:153:0x04f6), top: B:158:0x000a }] */
                /* JADX WARN: Removed duplicated region for block: B:123:0x0367 A[Catch: Exception -> 0x0500, TRY_ENTER, TryCatch #0 {Exception -> 0x0500, blocks: (B:3:0x000a, B:5:0x0022, B:7:0x0039, B:10:0x0053, B:12:0x005b, B:14:0x007e, B:17:0x008c, B:19:0x0098, B:22:0x00ab, B:24:0x00b0, B:26:0x00ca, B:28:0x00d6, B:29:0x00df, B:31:0x00e7, B:34:0x00f0, B:36:0x00fc, B:51:0x0154, B:38:0x0107, B:40:0x0113, B:42:0x0125, B:44:0x012b, B:46:0x0131, B:47:0x013c, B:49:0x0141, B:50:0x014b, B:53:0x016f, B:55:0x017d, B:58:0x0186, B:60:0x01b8, B:63:0x01c4, B:65:0x01cc, B:67:0x01d4, B:68:0x01ec, B:70:0x01f4, B:71:0x01f9, B:73:0x0203, B:75:0x020b, B:77:0x0213, B:78:0x022b, B:80:0x0233, B:81:0x0238, B:83:0x0242, B:85:0x024a, B:87:0x0256, B:93:0x027d, B:95:0x02a3, B:97:0x02ab, B:100:0x02b4, B:102:0x02bc, B:105:0x02cb, B:107:0x02d3, B:113:0x02f8, B:115:0x0307, B:119:0x0322, B:116:0x0311, B:118:0x0319, B:120:0x032b, B:123:0x0367, B:125:0x0373, B:126:0x03b9, B:128:0x03c5, B:130:0x03d1, B:131:0x03ef, B:132:0x03f6, B:134:0x03fe, B:136:0x040a, B:138:0x0454, B:140:0x0460, B:142:0x046c, B:144:0x0478, B:145:0x048e, B:147:0x04bb, B:149:0x04c7, B:151:0x04d3, B:152:0x04f0, B:108:0x02e0, B:110:0x02e8, B:88:0x0260, B:90:0x0268, B:92:0x0274, B:153:0x04f6), top: B:158:0x000a }] */
                /* JADX WARN: Removed duplicated region for block: B:132:0x03f6 A[Catch: Exception -> 0x0500, TryCatch #0 {Exception -> 0x0500, blocks: (B:3:0x000a, B:5:0x0022, B:7:0x0039, B:10:0x0053, B:12:0x005b, B:14:0x007e, B:17:0x008c, B:19:0x0098, B:22:0x00ab, B:24:0x00b0, B:26:0x00ca, B:28:0x00d6, B:29:0x00df, B:31:0x00e7, B:34:0x00f0, B:36:0x00fc, B:51:0x0154, B:38:0x0107, B:40:0x0113, B:42:0x0125, B:44:0x012b, B:46:0x0131, B:47:0x013c, B:49:0x0141, B:50:0x014b, B:53:0x016f, B:55:0x017d, B:58:0x0186, B:60:0x01b8, B:63:0x01c4, B:65:0x01cc, B:67:0x01d4, B:68:0x01ec, B:70:0x01f4, B:71:0x01f9, B:73:0x0203, B:75:0x020b, B:77:0x0213, B:78:0x022b, B:80:0x0233, B:81:0x0238, B:83:0x0242, B:85:0x024a, B:87:0x0256, B:93:0x027d, B:95:0x02a3, B:97:0x02ab, B:100:0x02b4, B:102:0x02bc, B:105:0x02cb, B:107:0x02d3, B:113:0x02f8, B:115:0x0307, B:119:0x0322, B:116:0x0311, B:118:0x0319, B:120:0x032b, B:123:0x0367, B:125:0x0373, B:126:0x03b9, B:128:0x03c5, B:130:0x03d1, B:131:0x03ef, B:132:0x03f6, B:134:0x03fe, B:136:0x040a, B:138:0x0454, B:140:0x0460, B:142:0x046c, B:144:0x0478, B:145:0x048e, B:147:0x04bb, B:149:0x04c7, B:151:0x04d3, B:152:0x04f0, B:108:0x02e0, B:110:0x02e8, B:88:0x0260, B:90:0x0268, B:92:0x0274, B:153:0x04f6), top: B:158:0x000a }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 1289
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.VuiEngineImpl.AnonymousClass1.run():void");
                }
            });
        }
    }

    public void exitScene(final String str, String str2, final boolean z, final jc0 jc0Var) {
        if (!VuiUtils.canUseVuiFeature() || str == null || this.mHandler == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = VuiConstants.SCREEN_DISPLAY_LF;
        }
        final String str3 = str2;
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                    if (jc0Var != null && sceneInfo != null && sceneInfo.getListener() != null && !jc0Var.equals(sceneInfo.getListener())) {
                        LogUtils.w(VuiEngineImpl.TAG, "要退出的场景和目前持有的场景数据不一致");
                    } else if (str.endsWith(VuiEngineImpl.VUI_SCENE_TAG)) {
                        if (VuiConstants.SCREEN_DISPLAY_LF.equals(str3)) {
                            if (VuiEngineImpl.mLeftPopPanelStack.contains(sceneUnqiueId)) {
                                VuiEngineImpl.mLeftPopPanelStack.remove(sceneUnqiueId);
                                LogUtils.i(VuiEngineImpl.TAG, "exitScene:" + sceneUnqiueId + ",mLeftPopPanelStack:" + VuiEngineImpl.mLeftPopPanelStack + " mRightPopPanelStack:" + VuiEngineImpl.mRightPopPanelStack + CFCHelper.SIGNAL_CFC_SPLIT + VuiEngineImpl.mActiveSceneIds);
                                VuiSceneManager.instance().exitScene(sceneUnqiueId, VuiEngineImpl.this.mPackageName, z, str3);
                            }
                        } else if (VuiConstants.SCREEN_DISPLAY_RF.equals(str3) && VuiEngineImpl.mRightPopPanelStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.mRightPopPanelStack.remove(sceneUnqiueId);
                            LogUtils.i(VuiEngineImpl.TAG, "exitScene:" + sceneUnqiueId + ",mLeftPopPanelStack:" + VuiEngineImpl.mLeftPopPanelStack + " mRightPopPanelStack:" + VuiEngineImpl.mRightPopPanelStack + CFCHelper.SIGNAL_CFC_SPLIT + VuiEngineImpl.mActiveSceneIds);
                            VuiSceneManager.instance().exitScene(sceneUnqiueId, VuiEngineImpl.this.mPackageName, z, str3);
                        }
                    } else {
                        if (VuiConstants.SCREEN_DISPLAY_LF.equals(str3)) {
                            VuiEngineImpl.this.mLFEnterSceneStack.remove(sceneUnqiueId);
                        } else if (!VuiConstants.SCREEN_DISPLAY_RF.equals(str3)) {
                            return;
                        } else {
                            VuiEngineImpl.this.mRFEnterSceneStack.remove(sceneUnqiueId);
                        }
                        if (VuiEngineImpl.this.mBackNaviSceneStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.this.mBackNaviSceneStack.remove(sceneUnqiueId);
                        }
                        LogUtils.i(VuiEngineImpl.TAG, "exitScene:" + sceneUnqiueId + ",mLFEnterSceneStack:" + VuiEngineImpl.this.mLFEnterSceneStack + " mRFEnterSceneStack:" + VuiEngineImpl.this.mRFEnterSceneStack + CFCHelper.SIGNAL_CFC_SPLIT + VuiEngineImpl.mActiveSceneIds);
                        VuiSceneManager.instance().exitScene(sceneUnqiueId, VuiEngineImpl.this.mPackageName, z, str3);
                        if (VuiEngineImpl.mActiveSceneIds.containsValue(sceneUnqiueId)) {
                            if (VuiConstants.SCREEN_DISPLAY_LF.equals(str3)) {
                                if (VuiEngineImpl.this.mLFEnterSceneStack.size() != 0) {
                                    String str4 = (String) VuiEngineImpl.this.mLFEnterSceneStack.get(VuiEngineImpl.this.mLFEnterSceneStack.size() - 1);
                                    VuiEngineImpl.mActiveSceneIds.put(VuiConstants.SCREEN_DISPLAY_LF, str4);
                                    VuiEngineImpl.this.handlerEnterScene(str4, z, str3);
                                } else {
                                    VuiEngineImpl.mActiveSceneIds.put(VuiConstants.SCREEN_DISPLAY_LF, "");
                                }
                            } else if (VuiConstants.SCREEN_DISPLAY_RF.equals(str3)) {
                                if (VuiEngineImpl.this.mRFEnterSceneStack.size() != 0) {
                                    String str5 = (String) VuiEngineImpl.this.mRFEnterSceneStack.get(VuiEngineImpl.this.mRFEnterSceneStack.size() - 1);
                                    VuiEngineImpl.mActiveSceneIds.put(VuiConstants.SCREEN_DISPLAY_RF, str5);
                                    VuiEngineImpl.this.handlerEnterScene(str5, z, str3);
                                } else {
                                    VuiEngineImpl.mActiveSceneIds.put(VuiConstants.SCREEN_DISPLAY_RF, "");
                                }
                            }
                        }
                        Log.d(VuiEngineImpl.TAG, "exitScene:" + sceneUnqiueId + ",mLFEnterSceneStack:" + VuiEngineImpl.this.mLFEnterSceneStack + " mRFEnterSceneStack:" + VuiEngineImpl.this.mRFEnterSceneStack + CFCHelper.SIGNAL_CFC_SPLIT + VuiEngineImpl.mActiveSceneIds);
                        if (VuiEngineImpl.this.mLFEnterSceneStack.size() != 0 || VuiEngineImpl.this.mBackNaviSceneStack.size() <= 0) {
                            return;
                        }
                        for (int i = 0; i < VuiEngineImpl.this.mBackNaviSceneStack.size(); i++) {
                            VuiEngineImpl.this.mLFEnterSceneStack.add(VuiEngineImpl.this.mBackNaviSceneStack.get(i));
                        }
                        String str6 = (String) VuiEngineImpl.this.mLFEnterSceneStack.get(VuiEngineImpl.this.mLFEnterSceneStack.size() - 1);
                        VuiEngineImpl.mActiveSceneIds.put(VuiConstants.SCREEN_DISPLAY_LF, str6);
                        VuiEngineImpl.this.handlerEnterScene(str6, z, VuiConstants.SCREEN_DISPLAY_LF);
                        VuiEngineImpl.this.mBackNaviSceneStack.clear();
                    }
                } catch (Exception e) {
                    StringBuilder a = jg.a("e:");
                    a.append(e.fillInStackTrace());
                    LogUtils.e(VuiEngineImpl.TAG, a.toString());
                }
            }
        });
    }

    public void setUpdateElements(final String str, final String str2, int i) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.32
            @Override // java.lang.Runnable
            public void run() {
                VuiScene newVuiScene;
                try {
                    LogUtils.d(VuiEngineImpl.TAG, "sceneId:" + str + ",data:" + str2);
                    sc0 stringConvertToVuiElement = VuiUtils.stringConvertToVuiElement(str2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(stringConvertToVuiElement);
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                        if (sceneInfo == null) {
                            return;
                        }
                        VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, currentTimeMillis);
                        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                        if (sceneCache != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                sc0 sc0Var = (sc0) arrayList.get(i2);
                                sc0 vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, sc0Var.getId());
                                if (vuiElementById == null || !vuiElementById.equals(sc0Var)) {
                                    if (sc0Var.getElements() == null && vuiElementById != null && vuiElementById.getElements() != null) {
                                        sc0Var.setElements(vuiElementById.getElements());
                                    }
                                    arrayList2.add(sc0Var);
                                }
                            }
                            if (arrayList2.isEmpty()) {
                                return;
                            }
                            newVuiScene2.setElements(arrayList2);
                            List<sc0> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, arrayList2, false);
                            sceneCache.setCache(sceneUnqiueId, fusionCache);
                            if (sceneInfo.isWholeScene()) {
                                if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                                    VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, currentTimeMillis).setElements(fusionCache);
                                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene));
                                }
                                VuiSceneManager.instance().sendSceneData(1, true, newVuiScene2);
                                return;
                            }
                            sceneCache.setCache(sceneUnqiueId, sceneCache.getFusionCache(sceneUnqiueId, arrayList, false));
                            List<String> wholeSceneId = sceneInfo.getWholeSceneId();
                            int size = wholeSceneId == null ? 0 : wholeSceneId.size();
                            if (size > 0) {
                                String activeWholeSceneId = VuiEngineImpl.this.getActiveWholeSceneId(wholeSceneId);
                                if (!TextUtils.isEmpty(activeWholeSceneId)) {
                                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene wholeSceneIds:" + wholeSceneId);
                                    VuiScene newVuiScene3 = VuiEngineImpl.this.getNewVuiScene(activeWholeSceneId, currentTimeMillis);
                                    newVuiScene3.setElements(arrayList);
                                    VuiEngineImpl.this.setWholeSceneCache(activeWholeSceneId, sceneCache, arrayList);
                                    VuiSceneManager.instance().sendSceneData(1, true, newVuiScene3);
                                }
                                for (int i3 = 0; i3 < size; i3++) {
                                    String str3 = wholeSceneId.get(i3);
                                    if (!TextUtils.isEmpty(str3) && !VuiUtils.isActiveSceneId(str3)) {
                                        VuiScene newVuiScene4 = VuiEngineImpl.this.getNewVuiScene(str3, currentTimeMillis);
                                        newVuiScene4.setElements(arrayList);
                                        VuiEngineImpl.this.setWholeSceneCache(str3, sceneCache, arrayList);
                                        VuiSceneManager.instance().sendSceneData(1, true, newVuiScene4);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, pc0 pc0Var, TaskDispatcher.TaskType taskType, List<View> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TaskWrapper(str, pc0Var, taskType, list, z));
        return arrayList;
    }

    public void updateScene(final String str, final List<View> list) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.10
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload() || list == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene");
                    try {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                            VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, (List<Integer>) null, (hc0) null, list));
                        }
                    } catch (Exception e) {
                        LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                    }
                }
            });
        }
    }

    public void vuiFeedback(View view, VuiFeedback vuiFeedback) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        VuiSceneManager.instance().vuiFeedBack(view, vuiFeedback);
    }

    public void removeOtherRootViewFromScene(final String str) {
        Handler handler;
        if (VuiUtils.cannotUpload() || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.15
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null) {
                    return;
                }
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    StringBuilder a = jg.a("removeOtherRootViewFromScene:");
                    a.append(str);
                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.REMOVE, null));
                }
            }
        });
    }

    private List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var, List<String> list2, List<View> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        ArrayList arrayList = new ArrayList();
        if (list3 != null && list3.size() != 0) {
            if (list3.size() == 1) {
                arrayList.add(new TaskWrapper(list3.get(0), str, list3.get(0).getId(), taskType, list, hc0Var, list2, z, iSceneCallbackHandler));
            } else {
                arrayList.add(new TaskWrapper(list3, str, taskType, list, hc0Var, list2, z, iSceneCallbackHandler));
            }
        }
        return arrayList;
    }

    public void addVuiSceneListener(String str, jc0 jc0Var) {
        addVuiSceneListener(str, null, jc0Var, null, true);
    }

    public void buildScene(String str, List<View> list, List<Integer> list2, hc0 hc0Var, List<String> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        buildScene(str, list, list2, hc0Var, list3, z, iSceneCallbackHandler, VuiConstants.SCREEN_DISPLAY_LF, (jc0) null);
    }

    public void setUpdateElements(final String str, final List<sc0> list, final String str2) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.33
            @Override // java.lang.Runnable
            public void run() {
                VuiScene newVuiScene;
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                        if (sceneInfo == null) {
                            return;
                        }
                        VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, currentTimeMillis);
                        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                        if (sceneCache != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < list.size(); i++) {
                                sc0 sc0Var = (sc0) list.get(i);
                                sc0 vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, sc0Var.getId());
                                if (vuiElementById == null || !vuiElementById.equals(sc0Var)) {
                                    if (sc0Var.getElements() == null && vuiElementById != null && vuiElementById.getElements() != null) {
                                        sc0Var.setElements(vuiElementById.getElements());
                                    }
                                    arrayList.add(sc0Var);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            newVuiScene2.setElements(arrayList);
                            newVuiScene2.setDisplayLocation(str2);
                            List<sc0> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, arrayList, false);
                            sceneCache.setCache(sceneUnqiueId, fusionCache);
                            if (sceneInfo.isWholeScene()) {
                                if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                                    VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, currentTimeMillis).setElements(fusionCache);
                                    newVuiScene2.setDisplayLocation(str2);
                                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene));
                                }
                                VuiSceneManager.instance().sendSceneData(1, true, newVuiScene2);
                                return;
                            }
                            sceneCache.setCache(sceneUnqiueId, sceneCache.getFusionCache(sceneUnqiueId, list, false));
                            List<String> wholeSceneId = sceneInfo.getWholeSceneId();
                            int size = wholeSceneId == null ? 0 : wholeSceneId.size();
                            if (size > 0) {
                                String activeWholeSceneId = VuiEngineImpl.this.getActiveWholeSceneId(wholeSceneId);
                                if (!TextUtils.isEmpty(activeWholeSceneId)) {
                                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene wholeSceneIds:" + wholeSceneId);
                                    VuiScene newVuiScene3 = VuiEngineImpl.this.getNewVuiScene(activeWholeSceneId, currentTimeMillis);
                                    newVuiScene3.setElements(list);
                                    newVuiScene3.setDisplayLocation(str2);
                                    VuiEngineImpl.this.setWholeSceneCache(activeWholeSceneId, sceneCache, list);
                                    VuiSceneManager.instance().sendSceneData(1, true, newVuiScene3);
                                }
                                for (int i2 = 0; i2 < size; i2++) {
                                    String str3 = wholeSceneId.get(i2);
                                    if (!TextUtils.isEmpty(str3) && !VuiUtils.isActiveSceneId(str3)) {
                                        VuiScene newVuiScene4 = VuiEngineImpl.this.getNewVuiScene(str3, currentTimeMillis);
                                        newVuiScene4.setElements(list);
                                        newVuiScene4.setDisplayLocation(str2);
                                        VuiEngineImpl.this.setWholeSceneCache(str3, sceneCache, list);
                                        VuiSceneManager.instance().sendSceneData(1, true, newVuiScene4);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                    LogUtils.e(VuiEngineImpl.TAG, "setUpdateElements exception");
                }
            }
        });
    }

    public void updateScene(final String str, final List<View> list, final List<Integer> list2, final hc0 hc0Var) {
        if (VuiUtils.cannotUpload() || list == null || str == null) {
            return;
        }
        if (list.size() == 1) {
            updateScene(str, list.get(0), list2, hc0Var);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                            VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, list2, hc0Var, list));
                        }
                    } catch (Exception e) {
                        LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                    }
                }
            });
        }
    }

    public void vuiFeedback(String str, VuiFeedback vuiFeedback) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        VuiSceneManager.instance().vuiFeedBack(str, vuiFeedback);
    }

    public void buildScene(final String str, final List<View> list, final List<Integer> list2, final hc0 hc0Var, final List<String> list3, final boolean z, final ISceneCallbackHandler iSceneCallbackHandler, final String str2, final jc0 jc0Var) {
        if (VuiUtils.cannotUpload() || str == null || this.mMainHandler == null) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                buildScene(str, list.get(0), list2, hc0Var, list3, z, iSceneCallbackHandler, str2, jc0Var);
                return;
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                            VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                            if (jc0Var != null && sceneInfo != null && sceneInfo.getListener() != null && !jc0Var.equals(sceneInfo.getListener())) {
                                LogUtils.w(VuiEngineImpl.TAG, "要build的场景和目前持有的场景数据不一致");
                            } else if (VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId) == VuiSceneState.INIT.getState() && z) {
                                LogUtils.e(VuiEngineImpl.TAG, str + "场景数据的创建必须在场景被激活后");
                            } else {
                                LogUtils.logDebug(VuiEngineImpl.TAG, "buildScene:" + str);
                                List list4 = null;
                                if (list3 != null) {
                                    list4 = new ArrayList();
                                    list4.addAll(list3);
                                    int size = list4.size();
                                    for (int i = 0; i < size; i++) {
                                        String str3 = (String) list4.get(i);
                                        list4.remove(str3);
                                        list4.add(i, VuiEngineImpl.this.getSceneUnqiueId(str3));
                                    }
                                }
                                VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.BUILD, list2, hc0Var, list4, list, z, iSceneCallbackHandler, str2, jc0Var));
                            }
                        } catch (Exception e) {
                            LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                        }
                    }
                }, 200L);
                return;
            }
        }
        View rootView = VuiSceneManager.instance().getRootView(getSceneUnqiueId(str));
        if (rootView != null) {
            buildScene(str, rootView, list2, hc0Var, list3, z, iSceneCallbackHandler, str2, jc0Var);
        }
    }

    public void updateScene(final String str, final View view, final List<Integer> list, final hc0 hc0Var) {
        if (VuiUtils.cannotUpload() || view == null || str == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VuiEngineImpl.this.mainThreadSceneList.contains(str) && (view instanceof nf)) {
                        VuiEngineImpl.this.mMainHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                                    StringBuilder a = jg.a("updateScene:");
                                    a.append(str);
                                    LogUtils.logDebug(VuiEngineImpl.TAG, a.toString());
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(view);
                                    TaskDispatcher taskDispatcher = VuiEngineImpl.this.taskStructure;
                                    AnonymousClass12 anonymousClass122 = AnonymousClass12.this;
                                    taskDispatcher.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, list, hc0Var, arrayList));
                                }
                            }
                        });
                    } else {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (!VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            return;
                        }
                        LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view);
                        VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, list, hc0Var, arrayList));
                    }
                } catch (Exception e) {
                    LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var, List<String> list2, List<View> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler, String str2, jc0 jc0Var) {
        ArrayList arrayList = new ArrayList();
        if (list3 != null && list3.size() != 0) {
            if (list3.size() == 1) {
                arrayList.add(new TaskWrapper(list3.get(0), str, list3.get(0).getId(), taskType, list, hc0Var, list2, z, iSceneCallbackHandler, str2, jc0Var));
            } else {
                arrayList.add(new TaskWrapper(list3, str, taskType, list, hc0Var, list2, z, iSceneCallbackHandler, str2, jc0Var));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<Integer> list, hc0 hc0Var, List<View> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2 != null && !list2.isEmpty()) {
            if (list2.size() == 1) {
                View view = list2.get(0);
                if (view.getId() != -1) {
                    arrayList.add(new TaskWrapper(view, str, view.getId(), taskType, list, hc0Var));
                } else {
                    arrayList.add(new TaskWrapper(view, str, taskType, list, hc0Var));
                }
            } else {
                arrayList.add(new TaskWrapper(list2, str, taskType, list, hc0Var));
            }
        }
        return arrayList;
    }

    public void setBuildElements(String str, List<sc0> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        setBuildElements(str, list, true, null);
    }

    public void setBuildElements(final String str, final List<sc0> list, final boolean z, final List<String> list2) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    int vuiSceneState = VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId);
                    if (vuiSceneState == VuiSceneState.INIT.getState()) {
                        LogUtils.e(VuiEngineImpl.TAG, str + "场景数据的创建必须在场景被激活后");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, currentTimeMillis);
                    newVuiScene.setElements(list);
                    VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (vuiSceneBuildCache != null) {
                        vuiSceneBuildCache.setCache(sceneUnqiueId, list);
                        vuiSceneBuildCache.setDisplayLocation(sceneUnqiueId, VuiUtils.getDisplayLocation(newVuiScene.getDisplayLocation()));
                    }
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                    if (sceneInfo != null && !z) {
                        sceneInfo.setBuild(true);
                    }
                    if (z) {
                        if (list2 == null || list2.isEmpty()) {
                            VuiEngineImpl.this.setMainSceneBuildElements(sceneInfo, newVuiScene);
                        } else {
                            for (int i = 0; i < list2.size(); i++) {
                                String str2 = (String) list2.get(i);
                                if (VuiSceneManager.instance().getVuiSceneListener(str2) == null) {
                                    if (sceneInfo != null) {
                                        sceneInfo.updateAddSubSceneNum();
                                    }
                                    VuiSceneManager.instance().initSubSceneInfo(str2, sceneUnqiueId);
                                } else {
                                    if (vuiSceneBuildCache != null) {
                                        List<sc0> cache = vuiSceneBuildCache.getCache(str2);
                                        LogUtils.logDebug(VuiEngineImpl.TAG, "buildElement:" + cache);
                                        if (cache != null && !cache.isEmpty()) {
                                            if (sceneInfo != null) {
                                                sceneInfo.updateAddSubSceneNum();
                                            }
                                            list.addAll(cache);
                                        } else {
                                            VuiSceneInfo sceneInfo2 = VuiSceneManager.instance().getSceneInfo(str2);
                                            if (sceneInfo2 != null && sceneInfo != null) {
                                                if (sceneInfo2.isBuild()) {
                                                    sceneInfo.updateAddSubSceneNum();
                                                } else {
                                                    sceneInfo2.getState();
                                                    if (vuiSceneState == VuiSceneState.ACTIVE.getState()) {
                                                        LogUtils.logInfo(VuiEngineImpl.TAG, "build subScene");
                                                        jc0 listener = sceneInfo2.getListener();
                                                        if (listener != null) {
                                                            listener.onBuildScene();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    VuiSceneManager.instance().setWholeSceneId(str2, sceneUnqiueId);
                                }
                            }
                            VuiSceneManager.instance().addSubSceneIds(sceneUnqiueId, list2);
                            if (sceneInfo != null && sceneInfo.isFull()) {
                                VuiEngineImpl.this.setMainSceneBuildElements(sceneInfo, newVuiScene);
                            }
                        }
                    } else {
                        List<String> wholeSceneId = sceneInfo != null ? sceneInfo.getWholeSceneId() : null;
                        if (wholeSceneId != null) {
                            int size = wholeSceneId.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                String str3 = wholeSceneId.get(i2);
                                VuiSceneInfo sceneInfo3 = VuiSceneManager.instance().getSceneInfo(str3);
                                if (sceneInfo3 != null && sceneInfo3.isFull()) {
                                    VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(str3, currentTimeMillis);
                                    newVuiScene2.setElements(list);
                                    sceneInfo3.setBuildComplete(true);
                                    sceneInfo3.setBuild(true);
                                    VuiEngineImpl.this.setSubSceneElementToCache(str3, vuiSceneBuildCache, list);
                                    VuiSceneManager.instance().sendSceneData(1, true, newVuiScene2);
                                } else if (sceneInfo3 != null && !sceneInfo3.isFull()) {
                                    sceneInfo3.updateAddSubSceneNum();
                                    List<sc0> subSceneElementToCache = VuiEngineImpl.this.setSubSceneElementToCache(str3, vuiSceneBuildCache, list);
                                    if (sceneInfo3.isFull()) {
                                        sceneInfo3.setBuildComplete(true);
                                        sceneInfo3.setBuild(true);
                                        LogUtils.logInfo(VuiEngineImpl.TAG, str3 + " full scene build completed ");
                                        if (VuiUtils.isActiveSceneId(str3)) {
                                            VuiScene newVuiScene3 = VuiEngineImpl.this.getNewVuiScene(str3, currentTimeMillis);
                                            newVuiScene3.setElements(subSceneElementToCache);
                                            VuiSceneManager.instance().sendSceneData(0, false, newVuiScene3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    VuiSceneManager.instance().setIsWholeScene(sceneUnqiueId, z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<View> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() == 1) {
            View view = list.get(0);
            if (view.getId() != -1) {
                arrayList.add(new TaskWrapper(view, view.getId(), str, taskType));
            } else {
                arrayList.add(new TaskWrapper(str, taskType, view));
            }
        } else {
            arrayList.add(new TaskWrapper(str, taskType, list));
        }
        return arrayList;
    }

    private List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<View> list, nf nfVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() == 1) {
            View view = list.get(0);
            if (view.getId() != -1) {
                arrayList.add(new TaskWrapper(view, view.getId(), str, taskType, nfVar));
            } else {
                arrayList.add(new TaskWrapper(str, taskType, view, nfVar));
            }
        } else {
            arrayList.add(new TaskWrapper(str, taskType, list, nfVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, String str2, pc0 pc0Var, jc0 jc0Var, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        for (View view : viewArr) {
            if (view != null) {
                if (pc0Var == null) {
                    arrayList.add(new TaskWrapper(view, str, view.getId(), TaskDispatcher.TaskType.ADD, str2));
                } else {
                    arrayList.add(new TaskWrapper(view, str, view.getId(), TaskDispatcher.TaskType.ADD, pc0Var, jc0Var));
                }
            }
        }
        return arrayList;
    }
}
