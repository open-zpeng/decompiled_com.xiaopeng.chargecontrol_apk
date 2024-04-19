package com.xiaopeng.speech.vui;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import android.widget.ListView;
import android.widget.ScrollView;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.ClientConstants;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.cache.VuiDisplayLocationInfoCache;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.cache.VuiSceneRemoveCache;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.listener.IXpVuiSceneListener;
import com.xiaopeng.speech.vui.model.VuiEventInfo;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.model.VuiSceneState;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.ResourceUtil;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VuiSceneManager {
    public static int SEND_UPLOAD_MESSAGE = 1;
    public static final int TYPE_ADD = 2;
    public static final int TYPE_BUILD = 0;
    public static final int TYPE_DISPLAY_LOCATION = 5;
    public static final int TYPE_REMOVE = 3;
    public static final int TYPE_UPDATE = 1;
    public static final int TYPE_UPDATEATTR = 4;
    public static final int VUI_RETRY_MAX_COUNT = 3;
    public static final String VUI_SCENE_AUTHORITY = "com.xiaopeng.speech.vuiscene";
    public static final int VUI_UPDATE_FAILED_ERRO_CODE = -500;
    public final String TAG;
    public Map<String, Integer> feedbackInfo;
    public String mActiveSceneId;
    public Handler mApiRouterHandler;
    public HandlerThread mApiRouterThread;
    public Binder mBinder;
    public Context mContext;
    public Handler mHandler;
    public boolean mIsInSpeech;
    public Handler mLocalVuiRouterHandler;
    public HandlerThread mLocalVuiThread;
    public String mObserver;
    public String mPackageName;
    public String mPackageVersion;
    public String mProcessName;
    public VuiBroadCastReceiver mReceiver;
    public HandlerThread mThread;
    public ConcurrentHashMap<String, VuiSceneInfo> mVuiSceneInfoMap;
    public ConcurrentHashMap<String, VuiSceneInfo> mVuiSubSceneInfoMap;
    public List<String> sceneIds;
    public VuiEngineImpl vuiEngine;
    public static final Uri VUI_SCENE_URI = Uri.parse("content://com.xiaopeng.speech.vuiscene/scene");
    public static final Uri VUI_SCENE_DELETE_URI = Uri.parse("content://com.xiaopeng.speech.vuiscene/scene/delete/");
    public static int REMOVE_FEED_BACK = 2;

    /* loaded from: classes.dex */
    public static class Holder {
        public static final VuiSceneManager Instance = new VuiSceneManager();
    }

    /* loaded from: classes.dex */
    public class VuiSceneHandler extends Handler {
        public VuiSceneHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != VuiSceneManager.SEND_UPLOAD_MESSAGE) {
                if (message.what == VuiSceneManager.REMOVE_FEED_BACK) {
                    String str = (String) message.obj;
                    if (VuiSceneManager.this.feedbackInfo.containsKey(str)) {
                        VuiSceneManager.this.feedbackInfo.remove(str);
                        return;
                    }
                    return;
                }
                return;
            }
            int i = message.arg1;
            boolean z = message.arg2 == 1;
            if (i == 2) {
                VuiSceneManager.this.addSceneElementGroup((VuiScene) message.obj, z);
            } else if (i == 0) {
                VuiSceneManager.this.buildScene((VuiScene) message.obj, z, true);
            } else if (i == 1) {
                VuiSceneManager.this.updateDynamicScene((VuiScene) message.obj, z);
            } else if (i == 4) {
                VuiSceneManager.this.updateSceneElementAttr((VuiScene) message.obj, z);
            } else if (i == 5) {
                VuiSceneManager.this.updateDisplayLocation((VuiScene) message.obj, z);
            } else {
                String str2 = (String) message.obj;
                int indexOf = str2.indexOf(CFCHelper.SIGNAL_CFC_SPLIT);
                VuiSceneManager.this.removeSceneElementGroup(str2.substring(0, indexOf), str2.substring(indexOf + 1), z);
            }
        }

        public VuiSceneHandler(Looper looper) {
            super(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUploadScene(String str) {
        VuiSceneCache sceneCache;
        int fusionType;
        VuiDisplayLocationInfoCache vuiDisplayLocationInfoCache;
        List<sc0> cache;
        if (!isUploadScene(str) || (sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType())) == null || (fusionType = sceneCache.getFusionType(str)) == VuiSceneCacheFactory.CacheType.DEFAULT.getType()) {
            return;
        }
        VuiScene build = new VuiScene.Builder().sceneId(str).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(System.currentTimeMillis()).build();
        if (fusionType == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
            build.setElements(sceneCache.getCache(str));
            sendSceneData(1, false, build, false);
        } else if (fusionType == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
            VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            if (sceneCache2 == null || (cache = sceneCache2.getCache(str)) == null || cache.isEmpty()) {
                return;
            }
            build.setElements(sceneCache2.getCache(str));
            sendSceneData(0, false, build, false);
        } else if (fusionType == VuiSceneCacheFactory.CacheType.REMOVE.getType()) {
            VuiSceneRemoveCache vuiSceneRemoveCache = (VuiSceneRemoveCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.REMOVE.getType());
            if (vuiSceneRemoveCache != null) {
                sendSceneData(3, false, str + CFCHelper.SIGNAL_CFC_SPLIT + vuiSceneRemoveCache.getRemoveCache(str).toString().replace("[", "").replace("]", ""), false);
            }
        } else if (fusionType != VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION.getType() || (vuiDisplayLocationInfoCache = (VuiDisplayLocationInfoCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION.getType())) == null) {
        } else {
            String displayCache = vuiDisplayLocationInfoCache.getDisplayCache(build.getSceneId());
            if (TextUtils.isEmpty(displayCache)) {
                return;
            }
            build.setDisplayLocation(displayCache);
            updateDisplayLocation(build, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVuiSceneById(String str) {
        Cursor cursor;
        long j;
        ContentResolver contentResolver = this.mContext.getContentResolver();
        try {
            cursor = contentResolver.query(VUI_SCENE_URI, null, "scene_id = ?", new String[]{str}, null);
        } catch (Throwable unused) {
            cursor = null;
        }
        if (cursor != null) {
            if (cursor.moveToNext()) {
                j = cursor.getLong(cursor.getColumnIndex("_id"));
                if (contentResolver.delete(VUI_SCENE_URI, "scene_id = ?", new String[]{str}) > 0 && j != -1) {
                    contentResolver.notifyChange(ContentUris.withAppendedId(VUI_SCENE_DELETE_URI, j), null);
                }
                cursor.close();
            }
        }
        j = -1;
        if (contentResolver.delete(VUI_SCENE_URI, "scene_id = ?", new String[]{str}) > 0) {
            contentResolver.notifyChange(ContentUris.withAppendedId(VUI_SCENE_DELETE_URI, j), null);
        }
        cursor.close();
    }

    private VuiEventInfo findRootView(String str, String str2) {
        VuiSceneInfo sceneInfo;
        VuiEventInfo vuiEventInfo = null;
        if (str == null || str2 == null || (sceneInfo = getSceneInfo(str)) == null) {
            return null;
        }
        StringBuilder a = jg.a("findRootView idList:");
        a.append(sceneInfo.getIdList());
        LogUtils.logDebug("VuiSceneManager", a.toString());
        if (sceneInfo.getIdList() != null && sceneInfo.getIdList().contains(str2)) {
            return new VuiEventInfo(getRootView(str), str);
        }
        List<String> subSceneList = sceneInfo.getSubSceneList();
        if (subSceneList != null) {
            LogUtils.logDebug("VuiSceneManager", "findRootView subSceneList:" + subSceneList);
        }
        if (subSceneList != null) {
            int size = subSceneList.size();
            for (int i = 0; i < size; i++) {
                vuiEventInfo = findRootView(subSceneList.get(i), str2);
                if (vuiEventInfo != null) {
                    return vuiEventInfo;
                }
            }
            return vuiEventInfo;
        }
        return null;
    }

    private VuiEventInfo findViewFromSceneInfo(String str, String str2) {
        VuiSceneInfo sceneInfo;
        List<SoftReference<View>> notChildrenViewList;
        if (str != null && str2 != null && (sceneInfo = getSceneInfo(str)) != null && sceneInfo.isContainNotChildrenView() && (notChildrenViewList = sceneInfo.getNotChildrenViewList()) != null) {
            for (int i = 0; i < notChildrenViewList.size(); i++) {
                SoftReference<View> softReference = notChildrenViewList.get(i);
                if (softReference != null && softReference.get() != null) {
                    View findViewWithTag = softReference.get().findViewWithTag(str2);
                    if (findViewWithTag != null) {
                        return new VuiEventInfo(findViewWithTag, str);
                    }
                    View findViewWithId = findViewWithId(str2, softReference.get());
                    if (findViewWithId != null) {
                        StringBuilder a = jg.a("findViewWithId:   Tag====  ");
                        a.append(findViewWithId.getTag());
                        LogUtils.logDebug("VuiSceneManager", a.toString());
                        return new VuiEventInfo(findViewWithId, str);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAuthority() {
        return !zb0.a() ? VuiConstants.VUI_SCENE_THIRD_AUTHORITY : VuiConstants.VUI_SCENE_AUTHORITY;
    }

    private View getHitView(View view, String str) {
        if (view != null) {
            View findViewWithTag = view.findViewWithTag(str);
            if (findViewWithTag == null) {
                View findViewWithId = findViewWithId(str, view);
                if (findViewWithId != null) {
                    StringBuilder a = jg.a("findViewWithId:   Tag====  ");
                    a.append(findViewWithId.getTag());
                    LogUtils.logDebug("VuiSceneManager", a.toString());
                    return findViewWithId;
                }
                LogUtils.e("VuiSceneManager", "findViewWithId  View is null");
                return findViewWithId;
            }
            return findViewWithTag;
        }
        return null;
    }

    private View getListView(View view) {
        if (view == null || (view instanceof ListView) || (view instanceof nf)) {
            return view;
        }
        if (view.getParent() == null) {
            return null;
        }
        return view.getParent() instanceof ViewRootImpl ? view : getListView((View) view.getParent());
    }

    private View getScrollView(View view) {
        if (view == null || (view instanceof ListView) || (view instanceof ScrollView)) {
            return view;
        }
        if (view.getParent() == null) {
            return null;
        }
        return view.getParent() instanceof ViewRootImpl ? view : getScrollView((View) view.getParent());
    }

    private String getTopRunningPackageName() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return null;
        }
        return runningTasks.get(0).topActivity.getPackageName();
    }

    private void handlerActiveScene(String str, String str2) {
        jc0 vuiSceneListener;
        VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<sc0> cache = vuiSceneBuildCache.getCache(str);
        if ((cache == null || cache.isEmpty()) && (vuiSceneListener = instance().getVuiSceneListener(str)) != null) {
            vuiSceneListener.onBuildScene();
        }
        enterScene(str, this.mPackageName, true, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasProcessFeature() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertVuiSceneToProvider(String str, String str2, String str3) {
        char c;
        LogUtils.logInfo("VuiSceneManager", "insertVuiSceneToProvider:sceneId = " + str);
        ContentResolver contentResolver = this.mContext.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("scene_id", str);
            contentValues.put("scene_info", str2);
            contentValues.put("scene_type", str3);
            Uri insert = contentResolver.insert(VUI_SCENE_URI, contentValues);
            long parseId = ContentUris.parseId(insert);
            if (insert != null && parseId > 0) {
                LogUtils.d("VuiSceneManager", "insertVuiSceneToProvider" + str3 + "success");
                contentResolver.notifyChange(insert, null);
                return;
            }
            int hashCode = str3.hashCode();
            boolean z = false;
            if (hashCode == -838846263) {
                if (str3.equals("update")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 94094958) {
                if (hashCode == 1671764162 && str3.equals("display")) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (str3.equals("build")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c == 0) {
                LogUtils.d("VuiSceneManager", "insertVuiSceneToProvider build retryResult" + retryInsertVuiProvider(contentValues));
            } else if ((c == 1 || c == 2) && parseId == -500) {
                VuiScene build = new VuiScene.Builder().sceneId(str).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(System.currentTimeMillis()).build();
                VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                if (sceneCache != null) {
                    List<sc0> cache = sceneCache.getCache(str);
                    if (cache != null && !cache.isEmpty()) {
                        build.setElements(sceneCache.getCache(str));
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(build);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("scene_id", str);
                        contentValues2.put("scene_info", vuiSceneConvertToString);
                        contentValues2.put("scene_type", "build");
                        z = retryInsertVuiProvider(contentValues2);
                    }
                    if (z) {
                        LogUtils.d("VuiSceneManager", "insertVuiSceneToProvider update retryResult" + retryInsertVuiProvider(contentValues));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static final VuiSceneManager instance() {
        return Holder.Instance;
    }

    private boolean isNeedBuild(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return !sceneInfo.isBuild();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUploadScene(String str) {
        StringBuilder a = jg.a("isUploadScene sceneId:", str, ",getTopRunningPackageName:");
        a.append(getTopRunningPackageName());
        a.append(",mIsInSpeech:");
        a.append(this.mIsInSpeech);
        a.append(",VuiEngine.mLFActiveSceneId:");
        a.append(VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF));
        a.append(" VuiEngine.mRFActiveSceneId: ");
        a.append(VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF));
        a.append(",mPackageName");
        a.append(this.mPackageName);
        LogUtils.logDebug("VuiSceneManager", a.toString());
        String str2 = this.mPackageName;
        if (str2 == null || str == null) {
            return false;
        }
        if ("com.android.systemui".equals(str2)) {
            return true;
        }
        if (this.mIsInSpeech && (VuiEngineImpl.mLeftPopPanelStack.contains(str) || VuiEngineImpl.mRightPopPanelStack.contains(str))) {
            return true;
        }
        if (this.mIsInSpeech && VuiEngineImpl.mActiveSceneIds.containsValue(str) && (str.endsWith("Dialog") || str.endsWith("dialog"))) {
            return true;
        }
        if (this.mIsInSpeech && VuiEngineImpl.mActiveSceneIds.containsValue(str) && "com.xiaopeng.carspeechservice".equals(this.mPackageName)) {
            return true;
        }
        if ((this.mIsInSpeech && VuiEngineImpl.mActiveSceneIds.containsValue(str) && ("com.xiaopeng.car.settings".equals(this.mPackageName) || "com.xiaopeng.carcontrol".equals(this.mPackageName) || "com.xiaopeng.chargecontrol".equals(this.mPackageName) || VuiConstants.UNITY.equals(this.mPackageName))) || "com.xiaopeng.caraccount".equals(this.mPackageName)) {
            return true;
        }
        return this.mIsInSpeech && this.mPackageName.equals(getTopRunningPackageName()) && VuiEngineImpl.mActiveSceneIds.containsValue(str);
    }

    private void lazyInitThread() {
        if (this.mThread == null) {
            this.mThread = new HandlerThread("VuiSceneManager-Thread");
            this.mThread.start();
            this.mHandler = new VuiSceneHandler(this.mThread.getLooper());
        }
        if (this.mApiRouterThread == null) {
            this.mApiRouterThread = new HandlerThread("VuiSceneManager-Apirouter-Thread");
            this.mApiRouterThread.start();
            this.mApiRouterHandler = new Handler(this.mApiRouterThread.getLooper());
        }
        if (this.mLocalVuiThread == null) {
            this.mLocalVuiThread = new HandlerThread("VuiSceneManager-LocalVui-Thread");
            this.mLocalVuiThread.start();
            this.mLocalVuiRouterHandler = new Handler(this.mLocalVuiThread.getLooper());
        }
    }

    private void registerReceiver() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (VuiUtils.canUseVuiFeature()) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(VuiConstants.INTENT_ACTION_CARSPEECH_START);
                            intentFilter.addAction(VuiConstants.INTENT_ACTION_ENV_CHANGED);
                            intentFilter.addAction(VuiConstants.INTENT_ACTION_VUIPROVIDER_DEATH);
                            intentFilter.addAction(VuiConstants.INTENT_ACTION_LOCAL_SCENE_NOT_FOUND);
                            VuiSceneManager.this.mReceiver = new VuiBroadCastReceiver();
                            ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).registerReceiver(VuiSceneManager.this.mReceiver, intentFilter);
                        }
                    } catch (Exception e) {
                        jg.a(e, jg.a("registerReceiver e:"), "VuiSceneManager");
                    }
                }
            });
        }
    }

    private boolean retryInsertVuiProvider(ContentValues contentValues) {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        for (int i = 3; i > 0; i--) {
            Uri insert = contentResolver.insert(VUI_SCENE_URI, contentValues);
            long parseId = ContentUris.parseId(insert);
            if (insert != null && parseId > 0) {
                contentResolver.notifyChange(insert, null);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBuildCacheInOther(String str, VuiScene vuiScene, VuiSceneCache vuiSceneCache) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo == null || !sceneInfo.isBuildComplete()) {
            return;
        }
        buildScene(vuiScene, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplayLocation(final VuiScene vuiScene, final boolean z) {
        if (VuiUtils.isMultiScreenPlatForm()) {
            LogUtils.i("VuiSceneManager", "updateDisplayLocation  =======   ");
            Handler handler = this.mApiRouterHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VuiScene vuiScene2;
                        String sceneId;
                        if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || (sceneId = vuiScene2.getSceneId()) == null) {
                            return;
                        }
                        VuiDisplayLocationInfoCache vuiDisplayLocationInfoCache = (VuiDisplayLocationInfoCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.DISPLAY_LOCATION.getType());
                        if (z) {
                            vuiDisplayLocationInfoCache.setCache(sceneId, vuiScene.getDisplayLocation());
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        LogUtils.i("VuiSceneManager", "updateDisplayLocation  =======   " + vuiSceneConvertToString);
                        if (VuiSceneManager.this.isUploadScene(sceneId)) {
                            vuiDisplayLocationInfoCache.setSendState(true);
                            Uri.Builder builder = new Uri.Builder();
                            builder.authority(VuiSceneManager.this.getAuthority()).path("updateDisplayLocation").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                            try {
                                LogUtils.logDebug("VuiSceneManager", " updateDisplayLocation to CarSpeech" + sceneId);
                                String str = (String) ApiRouter.route(builder.build());
                                vuiDisplayLocationInfoCache.setSendState(false);
                                LogUtils.logInfo("VuiSceneManager", "updateDisplayLocation to CarSpeech success" + sceneId + ",result:" + str);
                                if (!TextUtils.isEmpty(str) && vuiScene.getDisplayLocation().equals(vuiDisplayLocationInfoCache.getDisplayCache(sceneId))) {
                                    vuiDisplayLocationInfoCache.removeDisplayCache(sceneId);
                                }
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                LogUtils.e("VuiSceneManager", "updateDisplayLocation " + e.fillInStackTrace());
                                vuiDisplayLocationInfoCache.setSendState(false);
                            }
                            if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                                return;
                            }
                            StringBuilder a = jg.a("updateDisplayLocation ");
                            a.append(VuiUtils.vuiSceneConvertToString(vuiScene));
                            LogUtils.logDebug("VuiSceneManager", a.toString());
                        }
                    }
                });
            }
        }
    }

    private void updateSceneState(String str, int i) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setState(i);
        }
    }

    public void addSceneElement(final VuiScene vuiScene, final String str) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.15
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (VuiUtils.cannotUpload()) {
                            return;
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        Uri.Builder builder = new Uri.Builder();
                        builder.authority(VuiSceneManager.this.getAuthority()).path("addSceneElement").appendQueryParameter(VuiConstants.SCENE_ID, vuiScene.getSceneId()).appendQueryParameter("parentId", str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                        LogUtils.logDebug("VuiSceneManager", "addSceneElement to CarSpeech " + vuiScene.getSceneId());
                        LogUtils.logInfo("VuiSceneManager", "addSceneElement to CarSpeech success" + vuiScene.getSceneId() + ",result:" + ((String) ApiRouter.route(builder.build())));
                    } catch (Exception e) {
                        e.printStackTrace();
                        StringBuilder sb = new StringBuilder();
                        sb.append("addSceneElement e:");
                        jg.a(e, sb, "VuiSceneManager");
                    }
                }
            });
        }
    }

    public void addSceneElementGroup(final VuiScene vuiScene, boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.16
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    VuiSceneRemoveCache vuiSceneRemoveCache;
                    List<sc0> elements;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || (sceneId = vuiScene2.getSceneId()) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
                    VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    int type = VuiSceneCacheFactory.CacheType.DEFAULT.getType();
                    List<sc0> list = null;
                    if (sceneCache != null) {
                        type = sceneCache.getFusionType(sceneId);
                        if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            list = sceneCache.getUpdateFusionCache(sceneId, vuiScene.getElements(), false);
                        } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            if (sceneCache2 != null) {
                                list = sceneCache2.getFusionCache(sceneId, vuiScene.getElements(), false);
                            }
                        } else if (type == VuiSceneCacheFactory.CacheType.REMOVE.getType() && (vuiSceneRemoveCache = (VuiSceneRemoveCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.REMOVE.getType())) != null && (elements = vuiScene.getElements()) != null && elements.size() == 1) {
                            vuiSceneRemoveCache.deleteRemoveIdFromCache(sceneId, vuiScene.getElements().get(0).id);
                        }
                        if (list != null) {
                            vuiScene.setElements(list);
                        }
                    }
                    if (VuiSceneManager.this.isUploadScene(sceneId)) {
                        if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            VuiSceneManager.this.sendBuildCacheInOther(sceneId, vuiScene, sceneCache2);
                            return;
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        Uri.Builder builder = new Uri.Builder();
                        builder.authority(VuiSceneManager.this.getAuthority()).path("addSceneElementGroup").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                        try {
                            LogUtils.logDebug("VuiSceneManager", "addSceneElementGroup to CarSpeech " + sceneId);
                            String str = (String) ApiRouter.route(builder.build());
                            LogUtils.logInfo("VuiSceneManager", "addSceneElementGroup to CarSpeech success " + sceneId + ",result:" + str);
                            if (TextUtils.isEmpty(str)) {
                                if (sceneCache != null) {
                                    sceneCache.setCache(sceneId, vuiScene.getElements());
                                }
                            } else if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                                sceneCache.removeCache(sceneId);
                            }
                        } catch (RemoteException e) {
                            StringBuilder a = jg.a("addSceneElementGroup ");
                            a.append(e.fillInStackTrace());
                            LogUtils.e("VuiSceneManager", a.toString());
                            e.printStackTrace();
                            if (sceneCache != null) {
                                sceneCache.setCache(sceneId, vuiScene.getElements());
                            }
                        }
                        if (sceneCache2 != null) {
                            List<sc0> fusionCache = sceneCache2.getFusionCache(sceneId, vuiScene.getElements(), false);
                            if (fusionCache != null) {
                                sceneCache2.setCache(sceneId, fusionCache);
                            }
                            vuiScene.setElements(fusionCache);
                        }
                        if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                            return;
                        }
                        StringBuilder a2 = jg.a("addSceneElementGroup full_scene_info:");
                        a2.append(VuiUtils.vuiSceneConvertToString(vuiScene));
                        LogUtils.logDebug("VuiSceneManager", a2.toString());
                        return;
                    }
                    if (type != VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                        if (sceneCache != null) {
                            sceneCache.setCache(sceneId, vuiScene.getElements());
                        }
                        if (sceneCache2 != null) {
                            List<sc0> fusionCache2 = sceneCache2.getFusionCache(sceneId, vuiScene.getElements(), false);
                            if (fusionCache2 != null) {
                                sceneCache2.setCache(sceneId, fusionCache2);
                            }
                            vuiScene.setElements(fusionCache2);
                        }
                    } else if (sceneCache2 != null) {
                        sceneCache2.setCache(sceneId, vuiScene.getElements());
                    }
                    if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                        return;
                    }
                    StringBuilder a3 = jg.a("addSceneElementGroup from full_scene_info:");
                    a3.append(VuiUtils.vuiSceneConvertToString(vuiScene));
                    LogUtils.logDebug("VuiSceneManager", a3.toString());
                }
            });
        }
    }

    public void addSubSceneIds(String str, List<String> list) {
        VuiSceneInfo vuiSceneInfo;
        if (this.mVuiSceneInfoMap.containsKey(str) && (vuiSceneInfo = this.mVuiSceneInfoMap.get(str)) != null) {
            List<String> subSceneList = vuiSceneInfo.getSubSceneList();
            if (subSceneList == null) {
                subSceneList = new ArrayList<>();
            }
            subSceneList.addAll(list);
            vuiSceneInfo.setSubSceneList(subSceneList);
            this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
        }
    }

    public void addVuiEventListener(String str, IVuiEventListener iVuiEventListener) {
        VuiSceneInfo sceneInfo;
        LogUtils.logInfo("VuiSceneManager", "addVuiEventListener-- " + str);
        if (!VuiUtils.canUseVuiFeature() || str == null || iVuiEventListener == null || (sceneInfo = getSceneInfo(str)) == null) {
            return;
        }
        sceneInfo.setEventListener(iVuiEventListener);
    }

    public void addVuiSceneListener(String str, View view, jc0 jc0Var, gc0 gc0Var, boolean z) {
        LogUtils.logInfo("VuiSceneManager", "addVuiSceneListener-- " + str + ",needBuild:" + z);
        if (VuiUtils.canUseVuiFeature()) {
            LogUtils.logInfo("VuiSceneManager", "sceneId-- " + str + ",listener:" + jc0Var);
            if (!TextUtils.isEmpty(str) && jc0Var != null) {
                if (view == null && !(jc0Var instanceof IXpVuiSceneListener) && !VuiUtils.is3DApp(this.mPackageName) && !VuiUtils.isThirdApp(this.mPackageName) && !str.endsWith("Dialog") && !str.endsWith("dialog")) {
                    LogUtils.e("VuiSceneManager", "场景注册时所需变量不能为空");
                    return;
                }
                if (z && (this.mVuiSceneInfoMap.containsKey(str) || this.sceneIds.contains(str))) {
                    if (jc0Var.equals(getVuiSceneListener(str))) {
                        LogUtils.w("VuiSceneManager", "上次场景撤销未调用removeVuiSceneListener或重复创建场景");
                    }
                    VuiSceneCacheFactory.instance().removeAllCache(str);
                }
                VuiSceneInfo vuiSceneInfo = new VuiSceneInfo();
                boolean z2 = true;
                if (this.mVuiSubSceneInfoMap.containsKey(str)) {
                    vuiSceneInfo = this.mVuiSubSceneInfoMap.get(str);
                    this.mVuiSubSceneInfoMap.remove(str);
                } else {
                    if (this.mVuiSceneInfoMap.containsKey(str)) {
                        vuiSceneInfo = this.mVuiSceneInfoMap.get(str);
                        if (z) {
                            vuiSceneInfo.reset(true);
                        }
                    }
                    z2 = false;
                }
                vuiSceneInfo.setListener(jc0Var);
                vuiSceneInfo.setRootView(view);
                vuiSceneInfo.setElementChangedListener(gc0Var);
                if (z) {
                    vuiSceneInfo.setState(VuiSceneState.INIT.getState());
                } else if (vuiSceneInfo.isBuildComplete()) {
                    vuiSceneInfo.setState(VuiSceneState.UNACTIVE.getState());
                } else {
                    vuiSceneInfo.reset(false);
                    VuiSceneCacheFactory.instance().removeAllCache(str);
                }
                StringBuilder a = jg.a("build:");
                a.append(vuiSceneInfo.isBuild());
                LogUtils.logDebug("VuiSceneManager", a.toString());
                this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
                if (z2) {
                    LogUtils.i("VuiSceneManager", "onBuildScene");
                    jc0Var.onBuildScene();
                }
                if (this.sceneIds.contains(str)) {
                    return;
                }
                this.sceneIds.add(str);
                return;
            }
            LogUtils.logInfo("VuiSceneManager", "sceneId-- " + str + ",listener:" + jc0Var);
            LogUtils.e("VuiSceneManager", "场景注册时所需变量不能为空");
        }
    }

    public void buildScene(final VuiScene vuiScene, final boolean z, final boolean z2) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.14
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || vuiScene2.getElements() == null || vuiScene.getElements().size() < 0 || (sceneId = vuiScene.getSceneId()) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (z || z2 || !sceneCache.getUploadedState(sceneId)) {
                        if (sceneCache != null && z) {
                            List<sc0> cache = sceneCache.getCache(sceneId);
                            if (cache != null && !cache.isEmpty()) {
                                vuiScene.setElements(sceneCache.getUpdateFusionCache(sceneId, vuiScene.getElements(), false));
                            }
                            sceneCache.setCache(sceneId, vuiScene.getElements());
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneId);
                        if (sceneInfo != null && sceneInfo.isWholeScene() && sceneInfo.isFull()) {
                            sceneInfo.setLastAddStr(null);
                            sceneInfo.setLastUpdateStr(null);
                            LogUtils.logDebug("VuiSceneManager", "build full_scene_info:" + vuiSceneConvertToString);
                            if (VuiSceneManager.this.isUploadScene(sceneId)) {
                                Uri.Builder builder = new Uri.Builder();
                                builder.authority(VuiSceneManager.this.getAuthority()).path("buildScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                                try {
                                    LogUtils.logDebug("VuiSceneManager", " send buildScene to CarSpeech" + sceneId);
                                    if (sceneCache != null) {
                                        sceneCache.setUploadedState(sceneId, false);
                                    }
                                    String str = (String) ApiRouter.route(builder.build());
                                    if (!TextUtils.isEmpty(str) && sceneCache != null) {
                                        sceneCache.setUploadedState(sceneId, true);
                                    }
                                    LogUtils.logInfo("VuiSceneManager", " send buildScene to CarSpeech success" + sceneId + ",result:" + str);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                    if (sceneCache != null) {
                                        sceneCache.setUploadedState(sceneId, false);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public boolean canRunUpdateSceneTask(String str) {
        List<sc0> cache;
        if (str == null || (cache = ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).getCache(str)) == null || cache.isEmpty()) {
            return false;
        }
        if (getVuiSceneState(str) == VuiSceneState.IDLE.getState()) {
            LogUtils.logDebug("VuiSceneManager", str + "场景数据的build必须在场景被激活后");
            return false;
        }
        return true;
    }

    public boolean canUpdateScene(String str) {
        if (str == null) {
            return false;
        }
        if (!getVuiSceneBuild(str)) {
            LogUtils.logDebug("VuiSceneManager", str + "场景数据的update必须在场build后");
            return false;
        } else if (getVuiSceneState(str) == VuiSceneState.IDLE.getState()) {
            LogUtils.logDebug("VuiSceneManager", str + "场景数据的build必须在场景被激活后");
            return false;
        } else {
            return true;
        }
    }

    public String checkScrollSubViewIsVisible(String str, String str2) {
        View view;
        if (str == null || str2 == null || VuiUtils.cannotUpload()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray optJSONArray = jSONObject.optJSONArray(VuiConstants.SCENE_ELEMENTS);
            if (optJSONArray != null || optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                if (!VuiUtils.is3DApp(VuiUtils.getPackageNameFromSceneId(str))) {
                    JSONObject jSONObject2 = null;
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("elementId");
                            String optString2 = optJSONObject.optString("scrollViewId");
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("elementId", optString);
                            VuiEventInfo findView = findView(str, optString);
                            VuiEventInfo findView2 = findView(str, optString2);
                            if (findView != null && findView.hitView != null) {
                                if (findView2 != null && (view = findView2.hitView) != null) {
                                    if (view instanceof ScrollView) {
                                        Rect rect = new Rect();
                                        findView2.hitView.getHitRect(rect);
                                        if (findView.hitView.getLocalVisibleRect(rect)) {
                                            jSONObject3.put(VuiConstants.ELEMENT_VISIBLE, true);
                                        } else {
                                            jSONObject3.put(VuiConstants.ELEMENT_VISIBLE, false);
                                        }
                                    }
                                } else {
                                    jSONObject3.put(VuiConstants.ELEMENT_VISIBLE, true);
                                }
                            }
                            jSONObject2 = jSONObject3;
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put(VuiConstants.SCENE_ELEMENTS, jSONArray);
                return String.valueOf(jSONObject);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void cleanExpiredSceneTime(final String str) {
        Handler handler;
        if (str == null || (handler = this.mApiRouterHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.24
            @Override // java.lang.Runnable
            public void run() {
                Uri.Builder builder = new Uri.Builder();
                builder.authority(VuiSceneManager.this.getAuthority()).path("cleanExpiredSceneTime").appendQueryParameter(VuiConstants.SCENE_ID, str);
                LogUtils.logDebug("VuiSceneManager", "cleanExpiredSceneTime-------------- " + str);
                try {
                    ApiRouter.route(builder.build());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void destroyScene(final String str) {
        Handler handler;
        if (str == null || (handler = this.mApiRouterHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.23
            @Override // java.lang.Runnable
            public void run() {
                VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                if (vuiSceneBuildCache != null && vuiSceneBuildCache.getUploadedState(str) && !VuiUtils.cannotUpload()) {
                    try {
                        Uri.Builder builder = new Uri.Builder();
                        if (!VuiSceneManager.this.hasProcessFeature()) {
                            builder.authority(VuiSceneManager.this.getAuthority()).path("destroyScene").appendQueryParameter("sceneIds", str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion);
                        } else {
                            builder.authority(VuiSceneManager.this.getAuthority()).path("destroyProcessScene").appendQueryParameter("sceneIds", str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName());
                        }
                        LogUtils.logDebug("VuiSceneManager", "destroyScene-------------- " + str);
                        ApiRouter.route(builder.build());
                        LogUtils.logDebug("VuiSceneManager", "destroyScene--------------success " + str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                StringBuilder a = jg.a("destory removeAllCache--------------");
                a.append(str);
                LogUtils.logDebug("VuiSceneManager", a.toString());
                VuiSceneCacheFactory.instance().removeAllCache(str);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
        if (isNeedBuild(r6) != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String enterScene(final java.lang.String r6, final java.lang.String r7, boolean r8, final java.lang.String r9) {
        /*
            r5 = this;
            java.lang.String r0 = "VuiSceneManager"
            java.lang.String r1 = ""
            if (r6 == 0) goto Lde
            if (r7 != 0) goto La
            goto Lde
        La:
            boolean r2 = com.xiaopeng.speech.vui.utils.VuiUtils.canUseVuiFeature()     // Catch: java.lang.Exception -> Lbd
            if (r2 != 0) goto L11
            return r1
        L11:
            int r2 = r5.getVuiSceneState(r6)     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbd
            r3.<init>()     // Catch: java.lang.Exception -> Lbd
            java.lang.String r4 = "enterScene: sceneState:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lbd
            r3.append(r2)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r4 = ",sceneId:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lbd
            r3.append(r6)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lbd
            com.xiaopeng.speech.vui.utils.LogUtils.logInfo(r0, r3)     // Catch: java.lang.Exception -> Lbd
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.INIT     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            r4 = 0
            if (r2 != r3) goto L49
            if (r8 == 0) goto L3f
            r5.cleanExpiredSceneTime(r6)     // Catch: java.lang.Exception -> Lbd
        L3f:
            com.xiaopeng.speech.vui.model.VuiSceneState r2 = com.xiaopeng.speech.vui.model.VuiSceneState.ACTIVE     // Catch: java.lang.Exception -> Lbd
            int r2 = r2.getState()     // Catch: java.lang.Exception -> Lbd
            r5.updateSceneState(r6, r2)     // Catch: java.lang.Exception -> Lbd
            goto L81
        L49:
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.UNACTIVE     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            if (r2 != r3) goto L63
            boolean r2 = r5.isNeedBuild(r6)     // Catch: java.lang.Exception -> Lbd
            if (r2 == 0) goto L58
            goto L59
        L58:
            r4 = r1
        L59:
            com.xiaopeng.speech.vui.model.VuiSceneState r2 = com.xiaopeng.speech.vui.model.VuiSceneState.ACTIVE     // Catch: java.lang.Exception -> Lbb
            int r2 = r2.getState()     // Catch: java.lang.Exception -> Lbb
            r5.updateSceneState(r6, r2)     // Catch: java.lang.Exception -> Lbb
            goto L81
        L63:
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.IDLE     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            if (r2 != r3) goto L71
            java.lang.String r2 = "未注册场景信息，场景数据将不能使用"
            com.xiaopeng.speech.vui.utils.LogUtils.e(r0, r2)     // Catch: java.lang.Exception -> Lbd
            goto L80
        L71:
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.ACTIVE     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            if (r2 != r3) goto L80
            boolean r2 = r5.isNeedBuild(r6)     // Catch: java.lang.Exception -> Lbd
            if (r2 == 0) goto L80
            goto L81
        L80:
            r4 = r1
        L81:
            java.lang.String r2 = "com.xiaopeng.montecarlo"
            java.lang.String r3 = r5.mPackageName     // Catch: java.lang.Exception -> Lbb
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lbb
            if (r2 == 0) goto L9f
            java.lang.String r2 = r5.mPackageName     // Catch: java.lang.Exception -> Lbb
            java.lang.String r3 = r5.getTopRunningPackageName()     // Catch: java.lang.Exception -> Lbb
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lbb
            if (r2 != 0) goto L9f
            boolean r6 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()     // Catch: java.lang.Exception -> Lbb
            if (r6 == 0) goto L9e
            return r1
        L9e:
            return r4
        L9f:
            if (r8 == 0) goto Ld6
            boolean r8 = r5.isUploadScene(r6)     // Catch: java.lang.Exception -> Lbb
            if (r8 == 0) goto Lb0
            boolean r8 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()     // Catch: java.lang.Exception -> Lbb
            if (r8 != 0) goto Lb0
            r5.sendSceneData(r6)     // Catch: java.lang.Exception -> Lbb
        Lb0:
            android.os.Handler r8 = r5.mApiRouterHandler     // Catch: java.lang.Exception -> Lbb
            com.xiaopeng.speech.vui.VuiSceneManager$22 r2 = new com.xiaopeng.speech.vui.VuiSceneManager$22     // Catch: java.lang.Exception -> Lbb
            r2.<init>()     // Catch: java.lang.Exception -> Lbb
            r8.post(r2)     // Catch: java.lang.Exception -> Lbb
            goto Ld6
        Lbb:
            r6 = move-exception
            goto Lbf
        Lbd:
            r6 = move-exception
            r4 = r1
        Lbf:
            java.lang.String r7 = "enterScene--------------e: "
            java.lang.StringBuilder r7 = defpackage.jg.a(r7)
            java.lang.Throwable r8 = r6.fillInStackTrace()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.xiaopeng.speech.vui.utils.LogUtils.e(r0, r7)
            r6.printStackTrace()
        Ld6:
            boolean r6 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()
            if (r6 == 0) goto Ldd
            return r1
        Ldd:
            return r4
        Lde:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.VuiSceneManager.enterScene(java.lang.String, java.lang.String, boolean, java.lang.String):java.lang.String");
    }

    public void exitScene(final String str, final String str2, final boolean z, final String str3, boolean z2) {
        if (str == null || str2 == null || !VuiUtils.canUseVuiFeature()) {
            return;
        }
        if (!z2) {
            if (getVuiSceneState(str) == VuiSceneState.ACTIVE.getState()) {
                updateSceneState(str, VuiSceneState.UNACTIVE.getState());
            } else {
                LogUtils.e("VuiSceneManager", "场景未激活不能执行退出");
                return;
            }
        }
        this.mApiRouterHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z) {
                        Uri.Builder builder = new Uri.Builder();
                        if (!VuiUtils.is3DUIPlatForm()) {
                            builder.authority(VuiSceneManager.this.getAuthority()).path("exitScene").appendQueryParameter(VuiConstants.SCENE_ID, str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, str2).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion);
                        } else {
                            builder.authority(VuiSceneManager.this.getAuthority()).path("exitDisplayLocationScene").appendQueryParameter(VuiConstants.SCENE_ID, str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, str2).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("displayLocation", str3);
                        }
                        LogUtils.logDebug("VuiSceneManager", "exitScene-------------- " + str + ",displayLocation:" + str3);
                        ApiRouter.route(builder.build());
                        StringBuilder sb = new StringBuilder();
                        sb.append("exitScene---success---------- ");
                        sb.append(str);
                        LogUtils.logDebug("VuiSceneManager", sb.toString());
                    }
                } catch (Exception e) {
                    StringBuilder a = jg.a("exitScene--e: ");
                    a.append(e.fillInStackTrace());
                    LogUtils.e("VuiSceneManager", a.toString());
                    Uri.Builder builder2 = new Uri.Builder();
                    if (VuiUtils.is3DUIPlatForm()) {
                        builder2.authority(VuiSceneManager.this.getAuthority()).path("exitScene").appendQueryParameter(VuiConstants.SCENE_ID, str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, str2).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion);
                    }
                    try {
                        ApiRouter.route(builder2.build());
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public VuiEventInfo findView(String str, String str2) {
        View hitView;
        View view;
        if (str != null && str2 != null) {
            try {
                VuiEventInfo findViewFromSceneInfo = findViewFromSceneInfo(str, str2);
                if (findViewFromSceneInfo != null) {
                    LogUtils.logDebug("VuiSceneManager", "findViewFromSceneInfo elementId:" + str2 + ",view:" + findViewFromSceneInfo.hitView + ",sceneId:" + findViewFromSceneInfo.sceneId);
                    return findViewFromSceneInfo;
                }
                VuiEventInfo findRootView = findRootView(str, str2);
                StringBuilder sb = new StringBuilder();
                sb.append("findView elementId:");
                sb.append(str2);
                sb.append(",rootView:");
                sb.append(findRootView != null ? findRootView.hitView : null);
                sb.append(",sceneId:");
                sb.append(findRootView != null ? findRootView.sceneId : "");
                LogUtils.logDebug("VuiSceneManager", sb.toString());
                if (findRootView != null && (view = findRootView.hitView) != null) {
                    return new VuiEventInfo(getHitView(view, str2), findRootView.sceneId);
                }
                VuiSceneInfo sceneInfo = getSceneInfo(str);
                LogUtils.logInfo("VuiSceneManager", "findView view by rootview");
                View rootView = sceneInfo == null ? null : sceneInfo.getRootView();
                if (rootView != null) {
                    View hitView2 = getHitView(rootView, str2);
                    if (hitView2 == null) {
                        List<String> subSceneList = sceneInfo.getSubSceneList();
                        int size = subSceneList == null ? 0 : subSceneList.size();
                        for (int i = 0; i < size; i++) {
                            String str3 = subSceneList.get(i);
                            VuiSceneInfo sceneInfo2 = TextUtils.isEmpty(str3) ? null : getSceneInfo(str3);
                            View rootView2 = sceneInfo2 == null ? null : sceneInfo2.getRootView();
                            if (rootView2 != null && (hitView = getHitView(rootView2, str2)) != null) {
                                return new VuiEventInfo(hitView, str3);
                            }
                        }
                        return findViewFromSceneInfo;
                    }
                    return new VuiEventInfo(hitView2, str);
                }
                return findViewFromSceneInfo;
            } catch (Exception e) {
                jg.a(e, jg.a("findView e:"), "VuiSceneManager");
            }
        }
        return null;
    }

    public View findViewWithId(String str, View view) {
        String substring;
        LogUtils.logInfo("VuiSceneManager", "findViewWithId  ===  " + str);
        if (view == null || str == null) {
            return view;
        }
        if (str.indexOf("_") != -1) {
            String substring2 = str.substring(0, str.indexOf("_"));
            if (TextUtils.isEmpty(substring2)) {
                return null;
            }
            if (substring2.length() > 4) {
                String[] split = str.split("_");
                if (split.length <= 2) {
                    substring = split[1];
                } else {
                    substring = str.substring(str.indexOf("_", 1) + 1, str.indexOf("_", str.indexOf("_") + 1));
                }
                if (substring.length() < 4) {
                    int id = ResourceUtil.getId(this.mContext, substring2);
                    StringBuilder a = jg.a("findViewWithId view tag: ");
                    a.append(view.findViewById(id).getTag());
                    LogUtils.logInfo("VuiSceneManager", a.toString());
                    View listView = getListView(view.findViewById(id));
                    if (listView == null) {
                        return null;
                    }
                    if (listView instanceof nf) {
                        view = ((nf) listView).getLayoutManager().d(Integer.valueOf(substring).intValue()).findViewById(id);
                    }
                    return split.length <= 2 ? view : findViewWithId(str.substring(str.indexOf("_", str.indexOf("_") + 1) + 1), view);
                }
                return findViewWithId(str.substring(str.indexOf("_") + 1), view.findViewById(ResourceUtil.getId(this.mContext, substring2)));
            }
            return findViewWithId(str.substring(str.indexOf("_") + 1), view);
        }
        return view.findViewById(ResourceUtil.getId(this.mContext, str));
    }

    public String getElementState(String str, String str2) {
        sc0 vuiElementById;
        View view;
        View view2;
        View view3;
        View view4;
        ig igVar;
        View view5;
        String str3;
        JSONObject p;
        VuiEventInfo vuiEventInfo = null;
        if (str == null || str2 == null || VuiUtils.cannotUpload() || (vuiElementById = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType()).getVuiElementById(str, str2)) == null) {
            return null;
        }
        boolean is3DApp = VuiUtils.is3DApp(VuiUtils.getPackageNameFromSceneId(str));
        jc0 vuiSceneListener = instance().getVuiSceneListener(str);
        if (!VuiUtils.isThirdApp(VuiUtils.getPackageNameFromSceneId(str)) && !is3DApp && (vuiSceneListener == null || !(vuiSceneListener instanceof IXpVuiSceneListener))) {
            vuiEventInfo = findView(str, str2);
        }
        if (!mc0.RECYCLEVIEW.c.equals(vuiElementById.getType())) {
            if (mc0.VIEWPAGER.c.equals(vuiElementById.getType())) {
                if (VuiUtils.getExtraPage(vuiElementById) != -1) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(VuiConstants.PROPS_SCROLLLEFT, true);
                        jSONObject.put(VuiConstants.PROPS_SCROLLRIGHT, true);
                        LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject.toString() + ",sceneId:" + str + ",elementId:" + str2);
                        return jSONObject.toString();
                    } catch (JSONException e) {
                        StringBuilder a = jg.a("getElementState e:");
                        a.append(e.getMessage());
                        LogUtils.e("VuiSceneManager", a.toString());
                        return null;
                    }
                } else if (vuiEventInfo == null || (view4 = vuiEventInfo.hitView) == null) {
                    return null;
                } else {
                    if (!(view4 instanceof ig)) {
                        igVar = VuiUtils.findViewPager(view4);
                    } else {
                        igVar = (ig) view4;
                    }
                    if (igVar != null) {
                        try {
                            boolean canScrollHorizontally = igVar.canScrollHorizontally(-1);
                            boolean canScrollHorizontally2 = igVar.canScrollHorizontally(1);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(VuiConstants.PROPS_SCROLLLEFT, canScrollHorizontally);
                            jSONObject2.put(VuiConstants.PROPS_SCROLLRIGHT, canScrollHorizontally2);
                            LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject2.toString() + ",sceneId:" + str + ",elementId:" + str2);
                            return jSONObject2.toString();
                        } catch (JSONException e2) {
                            StringBuilder a2 = jg.a("getElementState e:");
                            a2.append(e2.getMessage());
                            LogUtils.e("VuiSceneManager", a2.toString());
                            return null;
                        }
                    }
                    return null;
                }
            }
            boolean z = false;
            if (mc0.SCROLLVIEW.c.equals(vuiElementById.getType())) {
                if (vuiElementById.getActions() != null) {
                    ArrayList arrayList = new ArrayList(vuiElementById.actions.h());
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    if (!lc0.SCROLLBYY.c.equals(((Map.Entry) arrayList.get(0)).getKey())) {
                        if (!lc0.SCROLLBYX.c.equals(((Map.Entry) arrayList.get(0)).getKey()) || vuiEventInfo == null || (view2 = vuiEventInfo.hitView) == null || (view2 instanceof ScrollView)) {
                            return null;
                        }
                        View view6 = (View) view2.getParent();
                        if (view6.getWidth() < vuiEventInfo.hitView.getWidth()) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                int scrollX = view6.getScrollX();
                                LogUtils.e("VuiSceneManager", "view width:" + vuiEventInfo.hitView.getWidth() + ",parent:" + view6.getWidth() + ",scrollX:" + scrollX);
                                jSONObject3.put(VuiConstants.PROPS_SCROLLLEFT, scrollX != 0);
                                if (scrollX + view6.getWidth() < vuiEventInfo.hitView.getWidth()) {
                                    z = true;
                                }
                                jSONObject3.put(VuiConstants.PROPS_SCROLLRIGHT, z);
                                LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject3.toString() + ",sceneId:" + str + ",elementId:" + str2);
                                return jSONObject3.toString();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                StringBuilder sb = new StringBuilder();
                                sb.append("getElementState e:");
                                jg.a(e3, sb, "VuiSceneManager");
                                return null;
                            }
                        }
                        return null;
                    } else if (vuiEventInfo == null || (view3 = vuiEventInfo.hitView) == null) {
                        return null;
                    } else {
                        if (view3 instanceof ScrollView) {
                            View childAt = ((ViewGroup) view3).getChildAt(0);
                            if (childAt == null) {
                                return null;
                            }
                            try {
                                JSONObject jSONObject4 = new JSONObject();
                                int scrollY = vuiEventInfo.hitView.getScrollY();
                                jSONObject4.put(VuiConstants.PROPS_SCROLLUP, scrollY != 0);
                                if (scrollY + vuiEventInfo.hitView.getHeight() != childAt.getMeasuredHeight()) {
                                    z = true;
                                }
                                jSONObject4.put(VuiConstants.PROPS_SCROLLDOWN, z);
                                LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject4.toString() + ",sceneId:" + str + ",elementId:" + str2);
                                return jSONObject4.toString();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("getElementState e:");
                                jg.a(e4, sb2, "VuiSceneManager");
                                return null;
                            }
                        }
                        Rect rect = new Rect();
                        vuiEventInfo.hitView.getGlobalVisibleRect(rect);
                        try {
                            JSONObject jSONObject5 = new JSONObject();
                            int scrollY2 = vuiEventInfo.hitView.getScrollY();
                            jSONObject5.put(VuiConstants.PROPS_SCROLLUP, scrollY2 != 0);
                            if (scrollY2 + rect.height() < vuiEventInfo.hitView.getMeasuredHeight()) {
                                z = true;
                            }
                            jSONObject5.put(VuiConstants.PROPS_SCROLLDOWN, z);
                            LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject5.toString() + ",sceneId:" + str + ",elementId:" + str2);
                            return jSONObject5.toString();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("getElementState e:");
                            jg.a(e5, sb3, "VuiSceneManager");
                            return null;
                        }
                    }
                }
                return null;
            }
            if (vuiEventInfo != null && (view = vuiEventInfo.hitView) != null) {
                vuiElementById.setEnabled(view.isEnabled() ? null : false);
            }
            String a3 = new lu().a(vuiElementById);
            LogUtils.logInfo("VuiSceneManager", "getElementState:  result:  " + a3);
            return a3;
        } else if (vuiEventInfo != null && (view5 = vuiEventInfo.hitView) != null && (view5 instanceof nf)) {
            nf nfVar = (nf) view5;
            if ((nfVar instanceof ec0) && (p = ((ec0) nfVar).p()) != null && p.has(VuiConstants.PROPS_DISABLETPL)) {
                try {
                    if (p.getBoolean(VuiConstants.PROPS_DISABLETPL)) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put(VuiConstants.PROPS_SCROLLUP, true);
                        jSONObject6.put(VuiConstants.PROPS_SCROLLDOWN, true);
                        return jSONObject6.toString();
                    }
                } catch (Exception unused) {
                }
            }
            boolean canScrollVertically = nfVar.canScrollVertically(-1);
            boolean canScrollVertically2 = nfVar.canScrollVertically(1);
            boolean canScrollHorizontally3 = nfVar.canScrollHorizontally(-1);
            boolean canScrollHorizontally4 = nfVar.canScrollHorizontally(1);
            try {
                JSONObject jSONObject7 = new JSONObject();
                try {
                    if (((ec0) nfVar).o().equals(lc0.SCROLLBYY.c)) {
                        jSONObject7.put(VuiConstants.PROPS_SCROLLUP, canScrollVertically);
                        jSONObject7.put(VuiConstants.PROPS_SCROLLDOWN, canScrollVertically2);
                    } else {
                        jSONObject7.put(VuiConstants.PROPS_SCROLLLEFT, canScrollHorizontally3);
                        jSONObject7.put(VuiConstants.PROPS_SCROLLRIGHT, canScrollHorizontally4);
                    }
                    str3 = "VuiSceneManager";
                    try {
                        LogUtils.logInfo(str3, "getElementState jsonObject: " + jSONObject7.toString() + ",sceneId:" + str + ",elementId:" + str2);
                        return jSONObject7.toString();
                    } catch (JSONException e6) {
                        e = e6;
                        StringBuilder a4 = jg.a("getElementState e:");
                        a4.append(e.getMessage());
                        LogUtils.e(str3, a4.toString());
                        return null;
                    }
                } catch (JSONException e7) {
                    e = e7;
                    str3 = "VuiSceneManager";
                }
            } catch (JSONException e8) {
                e = e8;
                str3 = "VuiSceneManager";
            }
        } else if (vuiElementById.getProps() != null) {
            return vuiElementById.getProps().toString();
        } else {
            try {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put(VuiConstants.PROPS_SCROLLUP, true);
                jSONObject8.put(VuiConstants.PROPS_SCROLLDOWN, true);
                LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject8.toString() + ",sceneId:" + str + ",elementId:" + str2);
                return jSONObject8.toString();
            } catch (JSONException e9) {
                StringBuilder a5 = jg.a("getElementState e:");
                a5.append(e9.getMessage());
                LogUtils.e("VuiSceneManager", a5.toString());
                return null;
            }
        }
    }

    public String getProcessName() {
        BufferedReader bufferedReader;
        String str = "main";
        if (!TextUtils.isEmpty(this.mProcessName)) {
            return this.mProcessName;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
                try {
                    try {
                        String trim = bufferedReader.readLine().trim();
                        try {
                            if (trim.startsWith(this.mPackageName)) {
                                trim = trim.replace(this.mPackageName, "");
                            }
                            if (!TextUtils.isEmpty(trim)) {
                                str = trim.substring(1);
                            }
                            this.mProcessName = str + ",pid_" + Process.myPid();
                            String str2 = this.mProcessName;
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return str2;
                        } catch (Exception e2) {
                            e = e2;
                            str = trim;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
    }

    public View getRootView(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getRootView();
        }
        return null;
    }

    public List<String> getSceneIdList(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getIdList();
        }
        return null;
    }

    public VuiSceneInfo getSceneInfo(String str) {
        ConcurrentHashMap<String, VuiSceneInfo> concurrentHashMap;
        if (str == null || (concurrentHashMap = this.mVuiSceneInfoMap) == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.mVuiSceneInfoMap.get(str);
    }

    public IVuiEventListener getVuiEventListener(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo == null) {
            return null;
        }
        return sceneInfo.getEventListener();
    }

    public boolean getVuiSceneBuild(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.isBuild();
        }
        return false;
    }

    public jc0 getVuiSceneListener(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getListener();
        }
        return null;
    }

    public int getVuiSceneState(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getState();
        }
        return VuiSceneState.IDLE.getState();
    }

    public String getmPackageName() {
        return this.mPackageName;
    }

    public String getmPackageVersion() {
        return this.mPackageVersion;
    }

    public void handleAllSceneCache(boolean z) {
        try {
            if (this.sceneIds == null) {
                return;
            }
            for (int i = 0; i < this.sceneIds.size(); i++) {
                String str = this.sceneIds.get(i);
                if (z) {
                    VuiSceneCacheFactory.instance().removeAllCache(str);
                    VuiSceneInfo vuiSceneInfo = this.mVuiSceneInfoMap.get(str);
                    if (vuiSceneInfo != null) {
                        vuiSceneInfo.reset(false);
                        this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
                    }
                } else {
                    ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).setUploadedState(str, false);
                    VuiSceneCacheFactory.instance().removeOtherCache(str);
                }
            }
        } catch (Exception e) {
            jg.a(e, jg.a("handleAllSceneCache e:"), "VuiSceneManager");
        }
    }

    public void handleSceneDataInfo() {
        if (VuiEngineImpl.mActiveSceneIds.size() > 0) {
            String str = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF);
            String str2 = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF);
            if (!TextUtils.isEmpty(str2)) {
                enterScene(str2, this.mPackageName, true, VuiConstants.SCREEN_DISPLAY_LF);
            }
            if (!TextUtils.isEmpty(str)) {
                enterScene(str, this.mPackageName, true, VuiConstants.SCREEN_DISPLAY_RF);
            }
        }
        if (VuiEngineImpl.mLeftPopPanelStack.size() > 0) {
            Iterator<String> it = VuiEngineImpl.mLeftPopPanelStack.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    enterScene(next, this.mPackageName, true, VuiConstants.SCREEN_DISPLAY_LF);
                }
            }
        }
        if (VuiEngineImpl.mRightPopPanelStack.size() > 0) {
            Iterator<String> it2 = VuiEngineImpl.mRightPopPanelStack.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!TextUtils.isEmpty(next2)) {
                    enterScene(next2, this.mPackageName, true, VuiConstants.SCREEN_DISPLAY_RF);
                }
            }
        }
    }

    public void initSubSceneInfo(String str, String str2) {
        LogUtils.d("VuiSceneManager", "initSubSceneInfo subSceneId:" + str + ",sceneId:" + str2);
        VuiSceneInfo vuiSceneInfo = new VuiSceneInfo();
        if (this.mVuiSubSceneInfoMap.containsKey(str)) {
            vuiSceneInfo = this.mVuiSubSceneInfoMap.get(str);
        }
        vuiSceneInfo.setWholeScene(false);
        vuiSceneInfo.setWholeSceneId(str2);
        this.mVuiSubSceneInfoMap.put(str, vuiSceneInfo);
    }

    public synchronized void insertVuiProviderWhenDeath() {
        LogUtils.d("VuiSceneManager", "insertVuiProviderWhenDeath");
        String str = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF);
        String str2 = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF);
        if (!TextUtils.isEmpty(str)) {
            reBuildSceneToVuiProvider(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            reBuildSceneToVuiProvider(str2);
        }
        if (VuiEngineImpl.mLeftPopPanelStack.size() > 0) {
            Iterator<String> it = VuiEngineImpl.mLeftPopPanelStack.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    reBuildSceneToVuiProvider(next);
                }
            }
        }
        if (VuiEngineImpl.mRightPopPanelStack.size() > 0) {
            Iterator<String> it2 = VuiEngineImpl.mRightPopPanelStack.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!TextUtils.isEmpty(next2)) {
                    reBuildSceneToVuiProvider(next2);
                }
            }
        }
    }

    public boolean isInSpeech() {
        return this.mIsInSpeech;
    }

    public boolean isNaviTop() {
        try {
            Uri.Builder builder = new Uri.Builder();
            builder.authority(getAuthority()).path("isNaviTop");
            return ((Boolean) ApiRouter.route(builder.build())).booleanValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void onVuiQueryCallBack(final String str, final String str2, final String str3) {
        Handler handler;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (handler = this.mApiRouterHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.3
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder a = jg.a("onVuiQueryCallBack:");
                a.append(str);
                a.append(",event:");
                a.append(str2);
                a.append(",result:");
                a.append(str3);
                LogUtils.logInfo("VuiSceneManager", a.toString());
                Uri.Builder builder = new Uri.Builder();
                builder.authority(VuiSceneManager.this.getAuthority()).path("onVuiQueryCallBack").appendQueryParameter(VuiConstants.SCENE_ID, str).appendQueryParameter("event", str2).appendQueryParameter("result", str3);
                try {
                    LogUtils.logDebug("VuiSceneManager", "onVuiQueryCallBack ");
                    String str4 = (String) ApiRouter.route(builder.build());
                    LogUtils.logInfo("VuiSceneManager", "onVuiQueryCallBack success");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public synchronized void reBuildSceneToVuiProvider(final String str) {
        try {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.1
                @Override // java.lang.Runnable
                public void run() {
                    List<sc0> cache;
                    VuiScene build = new VuiScene.Builder().sceneId(str).appVersion(VuiSceneManager.this.mPackageVersion).packageName(VuiSceneManager.this.mPackageName).timestamp(System.currentTimeMillis()).build();
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (sceneCache == null || (cache = sceneCache.getCache(str)) == null || cache.isEmpty()) {
                        return;
                    }
                    build.setElements(sceneCache.getCache(str));
                    VuiSceneManager.this.sendSceneData(0, false, build, false);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void reSetBinder() {
        this.mBinder = null;
    }

    public void removeSceneElementGroup(final String str, final String str2, final boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.17
                /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x0232  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 741
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.VuiSceneManager.AnonymousClass17.run():void");
                }
            });
        }
    }

    public void removeSubSceneIds(String str, String str2) {
        VuiSceneInfo vuiSceneInfo;
        if (this.mVuiSceneInfoMap.containsKey(str) && (vuiSceneInfo = this.mVuiSceneInfoMap.get(str)) != null) {
            List<String> subSceneList = vuiSceneInfo.getSubSceneList();
            if (subSceneList == null) {
                subSceneList = new ArrayList<>();
            }
            if (subSceneList.contains(str2)) {
                subSceneList.remove(str2);
            }
            vuiSceneInfo.setSubSceneList(subSceneList);
            this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
        }
    }

    public void removeVuiSceneListener(String str, boolean z, boolean z2, jc0 jc0Var) {
        if (VuiUtils.canUseVuiFeature()) {
            if (str == null) {
                LogUtils.e("VuiSceneManager", "销毁场景时SceneId不能为空");
                return;
            }
            if (!this.mVuiSceneInfoMap.containsKey(str) || !this.sceneIds.contains(str)) {
                LogUtils.w("VuiSceneManager", "销毁场景前请先注册场景，重复销毁信息");
            }
            if (this.mVuiSceneInfoMap.containsKey(str)) {
                VuiSceneInfo vuiSceneInfo = this.mVuiSceneInfoMap.get(str);
                if (jc0Var != null && vuiSceneInfo.getListener() != null && !jc0Var.equals(vuiSceneInfo.getListener())) {
                    LogUtils.w("VuiSceneManager", "要销毁的场景和目前持有的场景数据不一致");
                    return;
                } else if (z2) {
                    LogUtils.logInfo("VuiSceneManager", "removeVuiSceneListener-------------- " + z2 + ",info:" + vuiSceneInfo);
                    vuiSceneInfo.resetViewInfo();
                    this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
                } else {
                    List<String> subSceneList = vuiSceneInfo.getSubSceneList();
                    if (subSceneList != null) {
                        for (String str2 : subSceneList) {
                            VuiSceneInfo vuiSceneInfo2 = this.mVuiSceneInfoMap.get(str2);
                            if (vuiSceneInfo2 != null && vuiSceneInfo2.getWholeSceneId() != null && vuiSceneInfo2.getWholeSceneId().contains(str)) {
                                vuiSceneInfo2.getWholeSceneId().remove(str);
                                this.mVuiSceneInfoMap.put(str2, vuiSceneInfo2);
                            }
                        }
                    }
                    vuiSceneInfo.reset(true);
                    this.mVuiSceneInfoMap.remove(str);
                    if (this.sceneIds.contains(str)) {
                        this.sceneIds.remove(str);
                    }
                }
            }
            if (z2) {
                return;
            }
            if (z) {
                destroyScene(str);
            } else {
                VuiSceneCacheFactory.instance().removeAllCache(str);
            }
        }
    }

    public void sendBroadCast() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.7
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiSceneManager.this.mBinder == null) {
                        VuiSceneManager.this.mBinder = new Binder();
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    intent.setAction("com.xiaopeng.speech.vuiengine.start");
                    intent.setPackage("com.xiaopeng.carspeechservice");
                    bundle.putBinder("client", VuiSceneManager.this.mBinder);
                    bundle.putString(ClientConstants.ALIAS.P_NAME, VuiSceneManager.this.mPackageName);
                    bundle.putString("version", VuiSceneManager.this.mPackageVersion);
                    if (VuiSceneManager.this.hasProcessFeature()) {
                        bundle.putString("processName", VuiSceneManager.this.getProcessName());
                    }
                    intent.putExtra("bundle", bundle);
                    VuiSceneManager.this.mContext.sendBroadcast(intent);
                }
            });
        }
    }

    public synchronized void sendSceneData(final String str) {
        try {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.12
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload()) {
                        return;
                    }
                    String str2 = str;
                    if (!TextUtils.isEmpty(str2)) {
                        VuiSceneManager.this.checkUploadScene(str2);
                        return;
                    }
                    String str3 = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF);
                    String str4 = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF);
                    LogUtils.i("VuiSceneManager", "sendSceneData   ========   " + str3 + "   ::::  " + str4);
                    if (!TextUtils.isEmpty(str3)) {
                        VuiSceneManager.this.checkUploadScene(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        VuiSceneManager.this.checkUploadScene(str4);
                    }
                    if (VuiEngineImpl.mLeftPopPanelStack.size() > 0) {
                        Iterator<String> it = VuiEngineImpl.mLeftPopPanelStack.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!TextUtils.isEmpty(next)) {
                                VuiSceneManager.this.checkUploadScene(next);
                            }
                        }
                    }
                    if (VuiEngineImpl.mRightPopPanelStack.size() > 0) {
                        Iterator<String> it2 = VuiEngineImpl.mRightPopPanelStack.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2)) {
                                VuiSceneManager.this.checkUploadScene(next2);
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.fillInStackTrace();
            LogUtils.e("VuiSceneManager", "sendSceneData e:" + e.getMessage());
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setEngine(VuiEngineImpl vuiEngineImpl) {
        this.vuiEngine = vuiEngineImpl;
    }

    public void setFeatureState(boolean z) {
        try {
            if (VuiUtils.isFeatureDisabled() != z) {
                if (z) {
                    VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (VuiEngineImpl.mActiveSceneIds.size() > 0 && this.mPackageName != null && this.mPackageName.equals(getTopRunningPackageName())) {
                        handlerActiveScene(VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF), VuiConstants.SCREEN_DISPLAY_LF);
                        handlerActiveScene(VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF), VuiConstants.SCREEN_DISPLAY_RF);
                    }
                    if (VuiEngineImpl.mLeftPopPanelStack.size() > 0) {
                        Iterator<String> it = VuiEngineImpl.mLeftPopPanelStack.iterator();
                        while (it.hasNext()) {
                            handlerActiveScene(it.next(), VuiConstants.SCREEN_DISPLAY_LF);
                        }
                    }
                    if (VuiEngineImpl.mRightPopPanelStack.size() > 0) {
                        Iterator<String> it2 = VuiEngineImpl.mRightPopPanelStack.iterator();
                        while (it2.hasNext()) {
                            handlerActiveScene(it2.next(), VuiConstants.SCREEN_DISPLAY_RF);
                        }
                        return;
                    }
                    return;
                }
                handleAllSceneCache(true);
                handleSceneDataInfo();
            }
        } catch (Exception unused) {
        }
    }

    public void setInSpeech(boolean z) {
        this.mIsInSpeech = z;
        if (this.mIsInSpeech) {
            sendSceneData(null);
        }
    }

    public void setIsWholeScene(String str, boolean z) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setWholeScene(z);
            this.mVuiSceneInfoMap.put(str, sceneInfo);
        }
    }

    public void setProcessName(String str) {
        this.mProcessName = str + ",pid_" + Process.myPid();
    }

    public void setSceneIdList(String str, List<String> list) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setIdList(list);
            this.mVuiSceneInfoMap.put(str, sceneInfo);
        }
    }

    public void setWholeSceneId(String str, String str2) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setWholeSceneId(str2);
            this.mVuiSceneInfoMap.put(str, sceneInfo);
        }
    }

    public void setmPackageName(String str) {
        this.mPackageName = str;
    }

    public void setmPackageVersion(String str) {
        this.mPackageVersion = str;
    }

    public void storeFeedbackInfo(int i, String str, String str2) {
        LogUtils.logInfo("VuiSceneManager", "storeFeedbackInfo:" + str2 + ",soundArea:" + i);
        this.feedbackInfo.put(str2, Integer.valueOf(i));
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = REMOVE_FEED_BACK;
        obtainMessage.obj = str2;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void subscribe(String str) {
        if (!zb0.a(this.mPackageName, str)) {
            LogUtils.e("VuiSceneManager", "注册observer不合法,observer是app的包名加observer的类名组成");
            return;
        }
        this.mObserver = str;
        if (VuiUtils.canUseVuiFeature()) {
            subscribe(false);
            sendBroadCast();
            registerReceiver();
        }
    }

    public void subscribeVuiFeature() {
        if (VuiUtils.canUseVuiFeature()) {
            subscribe(false);
            sendBroadCast();
            registerReceiver();
        }
    }

    public void unSubscribe() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.10
                @Override // java.lang.Runnable
                public void run() {
                    VuiSceneManager.this.unsubscribe();
                }
            });
        }
    }

    public void unSubscribeVuiFeature() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("unsubscribeVuiFeatureProcess").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void unsubscribe() {
        if (TextUtils.isEmpty(this.mObserver)) {
            LogUtils.e("VuiSceneManager", "mObserver == null");
            return;
        }
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.11
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiSceneManager.this.hasProcessFeature()) {
                        try {
                            ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("unsubscribeProcess").appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            LogUtils.e("VuiSceneManager", "unsubscribe e:" + th.getMessage());
                            return;
                        }
                    }
                    try {
                        ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("unsubscribe").appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).build());
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        LogUtils.e("VuiSceneManager", "unsubscribe e:" + th2.getMessage());
                    }
                }
            });
        }
    }

    public void updateDynamicScene(final VuiScene vuiScene, final boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.21
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || vuiScene2.getElements() == null || vuiScene.getElements().size() < 0 || (sceneId = vuiScene.getSceneId()) == null || VuiSceneManager.this.getSceneInfo(sceneId) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
                    if (!z) {
                        if (VuiSceneManager.this.isUploadScene(sceneId) && sceneCache2.getFusionType(sceneId) == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                            Uri.Builder builder = new Uri.Builder();
                            builder.authority(VuiSceneManager.this.getAuthority()).path("updateScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                            try {
                                LogUtils.logDebug("VuiSceneManager", " updateScene to CarSpeech " + sceneId);
                                String str = (String) ApiRouter.route(builder.build());
                                if (TextUtils.isEmpty(str)) {
                                    sceneCache2.setCache(sceneId, vuiScene.getElements());
                                } else {
                                    sceneCache2.removeCache(sceneId);
                                }
                                LogUtils.logInfo("VuiSceneManager", " updateScene to CarSpeech success" + sceneId + ",result:" + str);
                                return;
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                LogUtils.e("VuiSceneManager", "updateScene " + e.fillInStackTrace());
                                sceneCache2.setCache(sceneId, vuiScene.getElements());
                                return;
                            }
                        }
                        return;
                    }
                    int type = VuiSceneCacheFactory.CacheType.DEFAULT.getType();
                    List<sc0> list = null;
                    if (sceneCache2 != null) {
                        type = sceneCache2.getFusionType(sceneId);
                        if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            list = sceneCache2.getUpdateFusionCache(sceneId, vuiScene.getElements(), false);
                        } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType() && sceneCache != null) {
                            list = sceneCache.getCache(sceneId);
                        }
                        if (list != null) {
                            vuiScene.setElements(list);
                        }
                    }
                    if (VuiSceneManager.this.isUploadScene(sceneId)) {
                        if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            VuiSceneManager.this.sendBuildCacheInOther(sceneId, vuiScene, sceneCache);
                            return;
                        }
                        String vuiSceneConvertToString2 = VuiUtils.vuiSceneConvertToString(vuiScene);
                        Uri.Builder builder2 = new Uri.Builder();
                        builder2.authority(VuiSceneManager.this.getAuthority()).path("updateScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString2);
                        try {
                            LogUtils.logDebug("VuiSceneManager", " updateScene to CarSpeech" + sceneId);
                            String str2 = (String) ApiRouter.route(builder2.build());
                            LogUtils.logInfo("VuiSceneManager", "updateScene to CarSpeech success" + sceneId + ",result:" + str2);
                            if (TextUtils.isEmpty(str2)) {
                                if (sceneCache2 != null) {
                                    sceneCache2.setCache(sceneId, vuiScene.getElements());
                                }
                            } else if (sceneCache2 != null) {
                                sceneCache2.removeCache(sceneId);
                            }
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            LogUtils.e("VuiSceneManager", "updateScene " + e2.fillInStackTrace());
                            if (sceneCache2 != null) {
                                sceneCache2.setCache(sceneId, vuiScene.getElements());
                            }
                        }
                    } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType() || sceneCache2 == null) {
                    } else {
                        sceneCache2.setCache(sceneId, vuiScene.getElements());
                    }
                }
            });
        }
    }

    public void updateListIndexState() {
        VuiEngineImpl vuiEngineImpl = this.vuiEngine;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.updateListIndexState();
        }
    }

    public void updateSceneElementAttr(final VuiScene vuiScene, boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.20
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || vuiScene2.getElements() == null || vuiScene.getElements().size() < 0 || (sceneId = vuiScene.getSceneId()) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
                    int type = VuiSceneCacheFactory.CacheType.DEFAULT.getType();
                    List<sc0> list = null;
                    if (sceneCache2 != null) {
                        type = sceneCache2.getFusionType(sceneId);
                        if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            list = sceneCache2.getUpdateFusionCache(sceneId, vuiScene.getElements(), true);
                        } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType() && sceneCache != null) {
                            list = sceneCache.getFusionCache(sceneId, vuiScene.getElements(), true);
                        }
                        if (list != null) {
                            vuiScene.setElements(list);
                        }
                    }
                    String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                    if (VuiSceneManager.this.isUploadScene(sceneId)) {
                        if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            VuiSceneManager.this.sendBuildCacheInOther(sceneId, vuiScene, sceneCache);
                            return;
                        }
                        Uri.Builder builder = new Uri.Builder();
                        builder.authority(VuiSceneManager.this.getAuthority()).path("updateScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                        try {
                            LogUtils.logDebug("VuiSceneManager", " updateSceneElementAttr to CarSpeech" + sceneId);
                            String str = (String) ApiRouter.route(builder.build());
                            LogUtils.logInfo("VuiSceneManager", "updateSceneElementAttr to CarSpeech success" + sceneId + ",result:" + str);
                            if (TextUtils.isEmpty(str)) {
                                if (sceneCache2 != null) {
                                    sceneCache2.setCache(sceneId, vuiScene.getElements());
                                }
                            } else if (sceneCache2 != null) {
                                sceneCache2.removeCache(sceneId);
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            LogUtils.e("VuiSceneManager", "updateSceneElementAttr " + e.fillInStackTrace());
                            if (sceneCache2 != null) {
                                sceneCache2.setCache(sceneId, vuiScene.getElements());
                            }
                        }
                        if (sceneCache != null) {
                            List<sc0> fusionCache = sceneCache.getFusionCache(sceneId, vuiScene.getElements(), true);
                            if (fusionCache != null) {
                                sceneCache.setCache(sceneId, fusionCache);
                            }
                            vuiScene.setElements(fusionCache);
                        }
                        if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                            return;
                        }
                        StringBuilder a = jg.a("updateSceneElementAttr ");
                        a.append(VuiUtils.vuiSceneConvertToString(vuiScene));
                        LogUtils.logDebug("VuiSceneManager", a.toString());
                        return;
                    }
                    if (type != VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                        if (sceneCache2 != null) {
                            sceneCache2.setCache(sceneId, ((VuiScene) new lu().a(vuiSceneConvertToString, (Class<Object>) VuiScene.class)).getElements());
                        }
                        if (sceneCache != null) {
                            List<sc0> fusionCache2 = sceneCache.getFusionCache(sceneId, vuiScene.getElements(), true);
                            if (fusionCache2 != null) {
                                sceneCache.setCache(sceneId, fusionCache2);
                            }
                            vuiScene.setElements(fusionCache2);
                        }
                    } else if (sceneCache != null) {
                        sceneCache.setCache(sceneId, vuiScene.getElements());
                    }
                    if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                        return;
                    }
                    StringBuilder a2 = jg.a("updateSceneElementAttr cache");
                    a2.append(VuiUtils.vuiSceneConvertToString(vuiScene));
                    LogUtils.logDebug("VuiSceneManager", a2.toString());
                }
            });
        }
    }

    public void vuiFeedBack(final String str, final String str2) {
        if (this.mApiRouterHandler == null || !this.feedbackInfo.containsKey(str)) {
            return;
        }
        final int intValue = this.feedbackInfo.get(str).intValue();
        this.feedbackInfo.remove(str);
        LogUtils.logInfo("VuiSceneManager", "vuiFeedBack:" + str + ",soundArea:" + intValue + ",content:" + str2);
        this.mApiRouterHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.2
            @Override // java.lang.Runnable
            public void run() {
                Uri.Builder builder = new Uri.Builder();
                Uri.Builder appendQueryParameter = builder.authority(VuiSceneManager.this.getAuthority()).path("vuiSoundAreaFeedback").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("resourceName", str).appendQueryParameter("state", "-1").appendQueryParameter(VuiConstants.ELEMENT_TYPE, nc0.TTS.c).appendQueryParameter(ClientConstants.BINDER.SCHEME, str2);
                StringBuilder a = jg.a("");
                a.append(intValue);
                appendQueryParameter.appendQueryParameter("soundArea", a.toString());
                try {
                    LogUtils.logDebug("VuiSceneManager", "vuiSoundAreaFeedback ");
                    String str3 = (String) ApiRouter.route(builder.build());
                    LogUtils.logInfo("VuiSceneManager", "vuiSoundAreaFeedback success");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VuiSceneManager() {
        this.TAG = "VuiSceneManager";
        this.mIsInSpeech = false;
        this.mBinder = null;
        this.mReceiver = null;
        this.feedbackInfo = new HashMap();
        this.mProcessName = null;
        this.sceneIds = new ArrayList();
        this.mVuiSceneInfoMap = new ConcurrentHashMap<>();
        this.mVuiSubSceneInfoMap = new ConcurrentHashMap<>();
        lazyInitThread();
    }

    public void sendSceneData(int i, boolean z, Object obj) {
        sendSceneData(i, z, obj, true);
    }

    public void sendSceneData(final int i, boolean z, final Object obj, boolean z2) {
        Handler handler;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.what = SEND_UPLOAD_MESSAGE;
        obtainMessage.arg2 = z ? 1 : 0;
        obtainMessage.obj = obj;
        this.mHandler.sendMessage(obtainMessage);
        if (VuiUtils.is3DUIPlatForm() && z2 && (handler = this.mLocalVuiRouterHandler) != null && obj != null && (obj instanceof VuiScene)) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.13
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = i;
                    if (i2 == 0) {
                        VuiScene vuiScene = (VuiScene) obj;
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        if (TextUtils.isEmpty(vuiSceneConvertToString)) {
                            return;
                        }
                        VuiSceneManager.this.insertVuiSceneToProvider(vuiScene.getSceneId(), vuiSceneConvertToString, "build");
                    } else if (i2 == 1) {
                        VuiScene vuiScene2 = (VuiScene) obj;
                        String vuiSceneConvertToString2 = VuiUtils.vuiSceneConvertToString(vuiScene2);
                        if (TextUtils.isEmpty(vuiSceneConvertToString2)) {
                            return;
                        }
                        VuiSceneManager.this.insertVuiSceneToProvider(vuiScene2.getSceneId(), vuiSceneConvertToString2, "update");
                    } else if (i2 == 3) {
                        VuiScene vuiScene3 = (VuiScene) obj;
                        if (vuiScene3 == null || TextUtils.isEmpty(vuiScene3.getSceneId())) {
                            return;
                        }
                        VuiSceneManager.this.deleteVuiSceneById(vuiScene3.getSceneId());
                    } else if (i2 != 5) {
                    } else {
                        VuiScene vuiScene4 = (VuiScene) obj;
                        String vuiSceneConvertToString3 = VuiUtils.vuiSceneConvertToString(vuiScene4);
                        if (TextUtils.isEmpty(vuiSceneConvertToString3)) {
                            return;
                        }
                        VuiSceneManager.this.insertVuiSceneToProvider(vuiScene4.getSceneId(), vuiSceneConvertToString3, "display");
                    }
                }
            });
        }
    }

    public void exitScene(String str, String str2, boolean z, String str3) {
        exitScene(str, str2, z, str3, false);
    }

    public void vuiFeedBack(final View view, final VuiFeedback vuiFeedback) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.18
                @Override // java.lang.Runnable
                public void run() {
                    View view2;
                    if (vuiFeedback == null || (view2 = view) == null) {
                        return;
                    }
                    String str = null;
                    if (view2 != null && view2.getId() != -1 && view.getId() != 0) {
                        str = VuiUtils.getResourceName(view.getId());
                    }
                    if (VuiUtils.is3DUIPlatForm()) {
                        VuiSceneManager.this.vuiFeedBack(str, vuiFeedback.content);
                        return;
                    }
                    Uri.Builder builder = new Uri.Builder();
                    Uri.Builder appendQueryParameter = builder.authority(VuiSceneManager.this.getAuthority()).path("vuiFeedback").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("resourceName", str);
                    StringBuilder a = jg.a("");
                    a.append(vuiFeedback.state);
                    appendQueryParameter.appendQueryParameter("state", a.toString()).appendQueryParameter(VuiConstants.ELEMENT_TYPE, vuiFeedback.getFeedbackType().c).appendQueryParameter(ClientConstants.BINDER.SCHEME, vuiFeedback.content);
                    try {
                        LogUtils.logDebug("VuiSceneManager", "vuiFeedBack ");
                        String str2 = (String) ApiRouter.route(builder.build());
                        LogUtils.logInfo("VuiSceneManager", "vuiFeedBack success");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void subscribe(final boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.9
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.canUseVuiFeature()) {
                        StringBuilder a = jg.a("subscribe：");
                        a.append(VuiSceneManager.this.mObserver);
                        LogUtils.logInfo("VuiSceneManager", a.toString());
                        if (TextUtils.isEmpty(VuiSceneManager.this.mObserver)) {
                            LogUtils.e("VuiSceneManager", "mObserver == null");
                            try {
                                String str = (String) ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("subscribeVuiFeatureProcess").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                                LogUtils.logDebug("VuiSceneManager", "subscribeVuiFeature：" + str);
                                if (!TextUtils.isEmpty(str)) {
                                    if (str.contains("dm_start")) {
                                        VuiSceneManager.this.mIsInSpeech = true;
                                    } else if (str.contains("dm_end")) {
                                        VuiSceneManager.this.mIsInSpeech = false;
                                    } else if (str.contains("vui_disabled")) {
                                        VuiSceneManager.this.setFeatureState(false);
                                        VuiUtils.disableVuiFeature();
                                    } else if (str.contains("vui_enable")) {
                                        VuiSceneManager.this.setFeatureState(true);
                                        VuiUtils.enableVuiFeature();
                                    }
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        new String[]{"command://scene.control"};
                        try {
                            if (VuiSceneManager.this.hasProcessFeature()) {
                                ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("subscribeProcess").appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter("param", "").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("sceneList", VuiSceneManager.this.sceneIds.toString()).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                            } else {
                                ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("subscribe").appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter("param", "").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("sceneList", VuiSceneManager.this.sceneIds.toString()).build());
                            }
                            if (z) {
                                VuiSceneManager.this.handleSceneDataInfo();
                            }
                        } catch (Exception e) {
                            StringBuilder a2 = jg.a("subscribe e:");
                            a2.append(e.fillInStackTrace());
                            LogUtils.e("VuiSceneManager", a2.toString());
                            VuiSceneManager.this.subscribe(z);
                        }
                    }
                }
            });
        }
    }

    public void vuiFeedBack(final String str, final VuiFeedback vuiFeedback) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.19
                @Override // java.lang.Runnable
                public void run() {
                    if (vuiFeedback == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    String str2 = "";
                    if (VuiUtils.is3DUIPlatForm()) {
                        int intValue = Integer.valueOf(str).intValue();
                        if (intValue != -1 && intValue != 0) {
                            str2 = VuiUtils.getResourceName(intValue);
                        }
                        VuiSceneManager.this.vuiFeedBack(str2, vuiFeedback.content);
                        return;
                    }
                    Uri.Builder builder = new Uri.Builder();
                    Uri.Builder appendQueryParameter = builder.authority(VuiSceneManager.this.getAuthority()).path("vuiFeedback").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("resourceName", "");
                    StringBuilder a = jg.a("");
                    a.append(vuiFeedback.state);
                    appendQueryParameter.appendQueryParameter("state", a.toString()).appendQueryParameter(VuiConstants.ELEMENT_TYPE, vuiFeedback.getFeedbackType().c).appendQueryParameter(ClientConstants.BINDER.SCHEME, vuiFeedback.content);
                    try {
                        LogUtils.logDebug("VuiSceneManager", "vuiFeedBack ");
                        String str3 = (String) ApiRouter.route(builder.build());
                        LogUtils.logInfo("VuiSceneManager", "vuiFeedBack success");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
