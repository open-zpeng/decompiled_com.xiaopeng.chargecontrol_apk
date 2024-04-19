package com.xiaopeng.speech.vui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.event.IVuiEvent;
import com.xiaopeng.speech.vui.event.ListItemClickEvent;
import com.xiaopeng.speech.vui.event.ScrollByXEvent;
import com.xiaopeng.speech.vui.event.ScrollByYEvent;
import com.xiaopeng.speech.vui.event.ScrollToEvent;
import com.xiaopeng.speech.vui.event.SetCheckEvent;
import com.xiaopeng.speech.vui.event.SetValueEvent;
import com.xiaopeng.speech.vui.listener.IUnityVuiSceneListener;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.listener.IXpVuiSceneListener;
import com.xiaopeng.speech.vui.model.VuiEventImpl;
import com.xiaopeng.speech.vui.model.VuiEventInfo;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class EventDispatcher implements Runnable {
    public Context mContext;
    public VuiScene mEventData;
    public sc0 vuiElement;
    public WeakReference<View> weakView;
    public lu gson = new lu();
    public Handler handler = new Handler(Looper.getMainLooper());
    public Map<String, IVuiEvent> events = new HashMap();
    public String TAG = "EventDispatcher";
    public String mDispatchSceneId = null;

    public EventDispatcher(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            initEvents();
        }
    }

    private boolean callOnVuiEvent(sc0 sc0Var, final VuiEventInfo vuiEventInfo) {
        if (sc0Var == null || vuiEventInfo == null || vuiEventInfo.hitView == null) {
            return false;
        }
        if (mc0.STATEFULBUTTON.c.equals(sc0Var.getType()) && !"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
            if (vuiEventInfo.hitView.getTag(R.id.vuiStatefulButtonClick) != null) {
                sc0Var.setResultActions(Arrays.asList(lc0.CLICK.c));
                return false;
            }
            List<sc0> elements = sc0Var.getElements();
            if (elements != null && elements.size() == 2) {
                sc0Var.setResultActions(Arrays.asList(lc0.CLICK.c));
                return false;
            }
        }
        if (!vuiEventInfo.hitView.isEnabled() && !isCustomHandle(sc0Var, vuiEventInfo.hitView)) {
            LogUtils.e(this.TAG, "view 不可操作");
            if (!isCustomFeedback(sc0Var, vuiEventInfo.hitView)) {
                handleDisableFeedBack(sc0Var, vuiEventInfo.hitView);
            }
            return true;
        }
        final VuiEventImpl vuiEventImpl = new VuiEventImpl(sc0Var);
        IVuiEventListener vuiEventListener = VuiSceneManager.instance().getVuiEventListener(vuiEventInfo.sceneId);
        final jc0 vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(vuiEventInfo.sceneId);
        View view = vuiEventInfo.hitView;
        if (!(view instanceof hc0)) {
            if (vuiSceneListener != null) {
                this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.8
                    @Override // java.lang.Runnable
                    public void run() {
                        vuiSceneListener.c(vuiEventInfo.hitView, vuiEventImpl);
                    }
                });
            }
            if (vuiEventListener != null) {
                vuiEventListener.onVuiEventExecutioned();
            }
            if (vuiSceneListener != null) {
                vuiSceneListener.onVuiEventExecutioned();
            }
            return true;
        }
        boolean a = ((hc0) view).a(view, vuiEventImpl);
        if (a && vuiEventListener != null) {
            vuiEventListener.onVuiEventExecutioned();
        }
        if (a && vuiSceneListener != null) {
            vuiSceneListener.onVuiEventExecutioned();
        }
        return a;
    }

    private sc0 getHitVuiElements(List<sc0> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> resultActions = list.get(0).getResultActions();
        if (resultActions != null && !resultActions.isEmpty()) {
            return list.get(0);
        }
        if (list.get(0).getElements() != null && !list.get(0).getElements().isEmpty()) {
            sc0 sc0Var = list.get(0);
            if (sc0Var == null) {
                return null;
            }
            return isCustomView(sc0Var) ? sc0Var : getHitVuiElements(sc0Var.getElements());
        }
        return list.get(0);
    }

    private String getResultAction(sc0 sc0Var) {
        List<String> resultActions = this.vuiElement.getResultActions();
        if (resultActions == null || resultActions.isEmpty()) {
            return null;
        }
        return resultActions.get(0);
    }

    private void handleDisableFeedBack(sc0 sc0Var, View view) {
        uu props;
        if (sc0Var.getProps() == null || (props = sc0Var.getProps()) == null || !props.b(VuiConstants.PROPS_FEEDBACK) || !props.a(VuiConstants.PROPS_FEEDBACK).a()) {
            return;
        }
        VuiEngine.getInstance(this.mContext).vuiFeedback(view, new VuiFeedback.Builder().state(-1).content((view == null || view.getTag(R.id.customDisableFeedbackTTS) == null) ? "当前该功能不可用" : (String) view.getTag(R.id.customDisableFeedbackTTS)).build());
    }

    private void handleFeedback(String str, String str2, sc0 sc0Var) {
        try {
            if (sc0Var.getProps() == null || !sc0Var.getProps().b(VuiConstants.PROPS_FEEDBACK)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            VuiSceneManager.instance().storeFeedbackInfo(jSONObject.has("soundArea") ? jSONObject.getInt("soundArea") : -1, str2, sc0Var.getResourceName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initEvents() {
        if (VuiUtils.isThirdApp(VuiSceneManager.instance().getmPackageName())) {
            return;
        }
        this.events.put("scrollTo", new ScrollToEvent());
        this.events.put("Click", new ListItemClickEvent());
        this.events.put("click", new ListItemClickEvent());
        this.events.put("SetCheck", new SetCheckEvent());
        this.events.put("listItemClick", new ListItemClickEvent());
        this.events.put(lc0.SCROLLBYY.c, new ScrollByYEvent());
        this.events.put(lc0.SCROLLBYX.c, new ScrollByXEvent());
        this.events.put(lc0.SETVALUE.c, new SetValueEvent());
    }

    private boolean isCustomFeedback(sc0 sc0Var, View view) {
        return (view == null || "com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || view.getTag(R.id.customDisableFeedback) == null) ? false : true;
    }

    private boolean isCustomHandle(sc0 sc0Var, View view) {
        uu props;
        if (sc0Var.getProps() == null || (props = sc0Var.getProps()) == null || !props.b(VuiConstants.PROPS_DISABLECONTROL)) {
            return (view == null || "com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || view.getTag(R.id.customDisableControl) == null) ? false : true;
        }
        return props.a(VuiConstants.PROPS_DISABLECONTROL).a();
    }

    private boolean isCustomView(sc0 sc0Var) {
        if (sc0Var == null) {
            return false;
        }
        return mc0.XTABLAYOUT.c.equals(sc0Var.getType()) || mc0.XSLIDER.c.equals(sc0Var.getType()) || mc0.STATEFULBUTTON.c.equals(sc0Var.getType()) || mc0.CUSTOM.c.equals(sc0Var.getType());
    }

    public void dispatch(String str, String str2) {
        final jc0 vuiSceneListener;
        View view;
        Object tag;
        if (str2 == null) {
            return;
        }
        String str3 = this.TAG;
        LogUtils.logInfo(str3, Thread.currentThread().getName() + "-----result datasource =====" + str2);
        final long currentTimeMillis = System.currentTimeMillis();
        this.mEventData = (VuiScene) this.gson.a(str2, (Class<Object>) VuiScene.class);
        VuiScene vuiScene = this.mEventData;
        if (vuiScene == null) {
            LogUtils.e(this.TAG, "mEventData is Null");
        } else if (vuiScene.getSceneId() != null && VuiUtils.getPackageNameFromSceneId(this.mEventData.getSceneId()).equals(VuiSceneManager.instance().getmPackageName())) {
            if (!VuiUtils.isActiveSceneId(this.mEventData.getSceneId())) {
                LogUtils.e(this.TAG, "场景不是当前活跃场景，返回:");
                return;
            }
            this.vuiElement = getHitVuiElements(this.mEventData.getElements());
            if (this.vuiElement == null) {
                LogUtils.e(this.TAG, "事件派发Element 为空");
                return;
            }
            String str4 = this.TAG;
            StringBuilder a = jg.a("VuiElement  ===== ");
            a.append(this.vuiElement.toString());
            LogUtils.logDebug(str4, a.toString());
            if (VuiUtils.is3DUIPlatForm()) {
                handleFeedback(str2, this.mEventData.getSceneId(), this.vuiElement);
            }
            r10 = false;
            boolean z = false;
            if (VuiUtils.is3DApp(VuiSceneManager.instance().getmPackageName())) {
                try {
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(this.mEventData.getSceneId());
                    if (sceneInfo != null) {
                        List<String> subSceneList = sceneInfo.getSubSceneList();
                        String str5 = this.TAG;
                        LogUtils.logInfo(str5, "subSceneIds:" + subSceneList);
                        if (subSceneList != null) {
                            for (int i = 0; i < subSceneList.size(); i++) {
                                String str6 = subSceneList.get(i);
                                sc0 vuiElementById = ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).getVuiElementById(str6, this.vuiElement.getId());
                                String str7 = this.TAG;
                                LogUtils.logInfo(str7, "targetElement:" + vuiElementById);
                                if (vuiElementById != null && (vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str6)) != null) {
                                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            ((IUnityVuiSceneListener) vuiSceneListener).onVuiEvent(EventDispatcher.this.gson.a(EventDispatcher.this.vuiElement));
                                        }
                                    });
                                    return;
                                }
                            }
                        }
                        final jc0 listener = sceneInfo.getListener();
                        if (listener != null) {
                            this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IUnityVuiSceneListener) listener).onVuiEvent(EventDispatcher.this.gson.a(EventDispatcher.this.vuiElement));
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (VuiUtils.isThirdApp(VuiSceneManager.instance().getmPackageName())) {
                LogUtils.logInfo(this.TAG, "Event will dispatch to third app");
                final jc0 vuiSceneListener2 = VuiSceneManager.instance().getVuiSceneListener(this.mEventData.getSceneId());
                if (vuiSceneListener2 != null) {
                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.3
                        @Override // java.lang.Runnable
                        public void run() {
                            jc0 jc0Var = vuiSceneListener2;
                            if (jc0Var instanceof IUnityVuiSceneListener) {
                                ((IUnityVuiSceneListener) jc0Var).onVuiEvent(EventDispatcher.this.gson.a(EventDispatcher.this.vuiElement));
                            } else {
                                jc0Var.onVuiEvent(new VuiEventImpl(EventDispatcher.this.vuiElement));
                            }
                        }
                    });
                }
            } else {
                final jc0 vuiSceneListener3 = VuiSceneManager.instance().getVuiSceneListener(this.mEventData.getSceneId());
                String str8 = this.TAG;
                LogUtils.logInfo(str8, "Event:" + vuiSceneListener3);
                if (vuiSceneListener3 != null && (vuiSceneListener3 instanceof IXpVuiSceneListener)) {
                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.4
                        @Override // java.lang.Runnable
                        public void run() {
                            vuiSceneListener3.onVuiEvent(new VuiEventImpl(EventDispatcher.this.vuiElement));
                        }
                    });
                    return;
                }
                this.mDispatchSceneId = this.mEventData.getSceneId();
                String str9 = this.TAG;
                StringBuilder a2 = jg.a("dispatch Scene:");
                a2.append(this.mDispatchSceneId);
                LogUtils.logInfo(str9, a2.toString());
                if (!mc0.VIRTUALLIST.c.equals(this.vuiElement.getType()) && !mc0.VIRTUALLISTITEM.c.equals(this.vuiElement.getType())) {
                    final VuiEventInfo findView = VuiSceneManager.instance().findView(this.mDispatchSceneId, this.vuiElement.getId());
                    if (findView != null && findView.hitView != null) {
                        if (!"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) && (tag = findView.hitView.getTag(R.id.customDoAction)) != null) {
                            z = ((Boolean) tag).booleanValue();
                        }
                        if ((isCustomView(this.vuiElement) || z) && callOnVuiEvent(this.vuiElement, findView)) {
                            LogUtils.logInfo(this.TAG, "custom view dispatch success");
                            return;
                        } else if (TextUtils.isEmpty(this.vuiElement.getId())) {
                            return;
                        } else {
                            View view2 = findView.hitView;
                            if (view2 != null) {
                                this.weakView = new WeakReference<>(view2);
                                if (!findView.hitView.isEnabled() && !isCustomHandle(this.vuiElement, findView.hitView)) {
                                    LogUtils.e(this.TAG, "view 不可操作");
                                    if (isCustomFeedback(this.vuiElement, findView.hitView)) {
                                        return;
                                    }
                                    handleDisableFeedBack(this.vuiElement, findView.hitView);
                                    return;
                                }
                                final VuiEventImpl vuiEventImpl = new VuiEventImpl(this.vuiElement);
                                getResultAction(this.vuiElement);
                                if (this.vuiElement.getAnimation() == null) {
                                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.7
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (r2) {
                                                LogUtils.w(EventDispatcher.this.TAG, "不执行模拟点击");
                                                return;
                                            }
                                            IVuiEventListener vuiEventListener = VuiSceneManager.instance().getVuiEventListener(findView.sceneId);
                                            if (vuiEventListener != null) {
                                                vuiEventListener.onVuiEventExecutioned();
                                            }
                                            jc0 vuiSceneListener4 = VuiSceneManager.instance().getVuiSceneListener(findView.sceneId);
                                            if (vuiSceneListener4 != null) {
                                                vuiSceneListener4.onVuiEventExecutioned();
                                            }
                                            if (vuiSceneListener4 != null && vuiSceneListener4.b(findView.hitView, vuiEventImpl)) {
                                                LogUtils.i(EventDispatcher.this.TAG, "user intercept Events");
                                                return;
                                            }
                                            View view3 = findView.hitView;
                                            if ((view3 instanceof hc0) && ((hc0) view3).a(view3, vuiEventImpl)) {
                                                return;
                                            }
                                            EventDispatcher.this.run();
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            String str10 = EventDispatcher.this.TAG;
                                            StringBuilder a3 = jg.a("程序运行时间： ");
                                            a3.append(currentTimeMillis2 - currentTimeMillis);
                                            a3.append("ms");
                                            LogUtils.logInfo(str10, a3.toString());
                                        }
                                    });
                                    return;
                                }
                                throw null;
                            }
                            LogUtils.e(this.TAG, "没找到正确的执行操作的view");
                            return;
                        }
                    } else if (!this.mDispatchSceneId.endsWith("Dialog") && !this.mDispatchSceneId.endsWith("dialog")) {
                        LogUtils.e(this.TAG, "没找到正确的执行操作的view");
                        return;
                    } else {
                        final jc0 vuiSceneListener4 = VuiSceneManager.instance().getVuiSceneListener(this.mEventData.getSceneId());
                        if (vuiSceneListener4 != null) {
                            this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    vuiSceneListener4.c(null, new VuiEventImpl(EventDispatcher.this.vuiElement));
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                uu props = this.vuiElement.getProps();
                if (props.b("parentId")) {
                    VuiEventInfo findView2 = VuiSceneManager.instance().findView(this.mDispatchSceneId, props.a("parentId").d());
                    if (findView2 == null || (view = findView2.hitView) == null) {
                        return;
                    }
                    this.weakView = new WeakReference<>(view);
                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.5
                        @Override // java.lang.Runnable
                        public void run() {
                            EventDispatcher.this.run();
                        }
                    });
                    SetValueEvent setValueEvent = (SetValueEvent) this.events.get(lc0.SETVALUE.c);
                    if (setValueEvent != null) {
                        setValueEvent.setSceneId(findView2.sceneId);
                    }
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IVuiEvent iVuiEvent;
        WeakReference<View> weakReference;
        List<String> resultActions = this.vuiElement.getResultActions();
        if (resultActions == null || resultActions.isEmpty() || (iVuiEvent = this.events.get(resultActions.get(0))) == null || (weakReference = this.weakView) == null || weakReference.get() == null) {
            return;
        }
        iVuiEvent.run(this.weakView.get(), this.vuiElement);
    }
}
