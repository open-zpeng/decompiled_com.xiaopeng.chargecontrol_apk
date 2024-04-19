package com.xiaopeng.speech.vui.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.VuiEngineImpl;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.view.WindowManagerFactory;
import defpackage.sc0;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VuiUtils {
    public static final String CAR_PLATFORM_A1 = "A1";
    public static final String CAR_PLATFORM_A2 = "A2";
    public static final String CAR_PLATFORM_A3 = "A3";
    public static final String CAR_PLATFORM_Q1 = "Q1";
    public static final String CAR_PLATFORM_Q2 = "Q2";
    public static final String CAR_PLATFORM_Q3 = "Q3";
    public static final String CAR_PLATFORM_Q5 = "Q5";
    public static final String CAR_PLATFORM_Q6 = "Q6";
    public static final String CAR_PLATFORM_Q7 = "Q7";
    public static final String CAR_PLATFORM_Q8 = "Q8";
    public static int LIST_VEDIO_TYPE = 1;
    public static List<String> supportMultiScreenPlatform;
    public static cu mExclusionStrategy = new cu() { // from class: com.xiaopeng.speech.vui.utils.VuiUtils.1
        @Override // defpackage.cu
        public boolean shouldSkipClass(Class<?> cls) {
            return false;
        }

        @Override // defpackage.cu
        public boolean shouldSkipField(du duVar) {
            return duVar.a.getName().equals("timestamp");
        }
    };
    public static final List<String> VUI_ENABLE_APP = Arrays.asList("com.xiaopeng.montecarlo", "com.xiaopeng.musicradio", "com.xiaopeng.carcontrol", "com.xiaopeng.car.settings", "com.xiaopeng.chargecontrol", IpcConfig.App.CAR_CAMERA, IpcConfig.App.CAR_BT_PHONE, "com.xiaopeng.aiassistant", "com.xiaopeng.carspeechservice", VuiConstants.SCENEDEMO, "com.xiaopeng.vui.demo");
    public static cu mAttrExclusionStrategy = new cu() { // from class: com.xiaopeng.speech.vui.utils.VuiUtils.2
        @Override // defpackage.cu
        public boolean shouldSkipClass(Class<?> cls) {
            return false;
        }

        @Override // defpackage.cu
        public boolean shouldSkipField(du duVar) {
            return duVar.a.getName().equals(VuiConstants.SCENE_ELEMENTS);
        }
    };
    public static boolean isDisableVuiFeature = false;
    public static boolean userDisabledFeature = false;
    public static String sRegion = null;
    public static oc0 viewMode = oc0.NORMAL;
    public static String sType = null;
    public static List<String> unSupportType = new ArrayList();

    /* loaded from: classes.dex */
    public static class SceneBooleanTypeAdapter extends bv<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // defpackage.bv
        public Boolean read(gx gxVar) {
            return null;
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Boolean bool) {
            if (bool != null) {
                ixVar.a(bool.booleanValue());
            } else {
                ixVar.a((Number) null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SceneIntegerTypeAdapter extends bv<Integer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // defpackage.bv
        public Integer read(gx gxVar) {
            return null;
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Integer num) {
            if (num != null && num.intValue() != -1) {
                ixVar.a(num);
            } else {
                ixVar.a((Number) null);
            }
        }
    }

    static {
        unSupportType.add(CAR_PLATFORM_A1);
        unSupportType.add(CAR_PLATFORM_A2);
        unSupportType.add(CAR_PLATFORM_A3);
        supportMultiScreenPlatform = new ArrayList();
        supportMultiScreenPlatform.add(CAR_PLATFORM_Q7);
    }

    public static void addCanVoiceControlProp(ec0 ec0Var) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_VOICECONTROL, true);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addDefaultPriorityValue(ec0 ec0Var, int i) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_DEFAULTPRIORITY, i);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addDisableTplProp(ec0 ec0Var) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_DISABLETPL, true);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addGeneralActProp(ec0 ec0Var, String str) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_GENERALACT, str);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addHasFeedbackProp(ec0 ec0Var) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_FEEDBACK, true);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addMatchFirstProp(ec0 ec0Var) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_MATCHFIRSTPRIORITY, true);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addProps(sc0 sc0Var, Map<String, Boolean> map) {
        if (sc0Var == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                uu props = sc0Var.getProps();
                if (props == null) {
                    props = new uu();
                }
                ArrayList arrayList = new ArrayList(map.entrySet());
                for (int i = 0; i < arrayList.size(); i++) {
                    Map.Entry entry = (Map.Entry) arrayList.get(i);
                    props.a((String) entry.getKey(), (Boolean) entry.getValue());
                }
                sc0Var.setProps(props);
            }
        } catch (Exception unused) {
        }
    }

    public static void addSKipAlreadyProp(ec0 ec0Var) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_SKIPALREADY, true);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addScrollProps(sc0 sc0Var, View view) {
        if (sc0Var != null) {
            try {
                uu props = sc0Var.getProps();
                if (props == null) {
                    props = new uu();
                }
                if (view instanceof nf) {
                    nf nfVar = (nf) view;
                    if (sc0Var.getActions() != null) {
                        ArrayList arrayList = new ArrayList(sc0Var.actions.h());
                        if (!arrayList.isEmpty()) {
                            if (lc0.SCROLLBYY.c.equals(((Map.Entry) arrayList.get(0)).getKey())) {
                                props.a(VuiConstants.PROPS_SCROLLUP, Boolean.valueOf(nfVar.canScrollVertically(-1)));
                                props.a(VuiConstants.PROPS_SCROLLDOWN, Boolean.valueOf(nfVar.canScrollVertically(1)));
                            } else if (lc0.SCROLLBYX.c.equals(((Map.Entry) arrayList.get(0)).getKey())) {
                                props.a(VuiConstants.PROPS_SCROLLRIGHT, Boolean.valueOf(nfVar.canScrollVertically(1)));
                                props.a(VuiConstants.PROPS_SCROLLLEFT, Boolean.valueOf(nfVar.canScrollVertically(-1)));
                            }
                        }
                    }
                }
                sc0Var.setProps(props);
            } catch (Exception unused) {
            }
        }
    }

    public static void addUnitProp(ec0 ec0Var, String str) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_UNIT, str);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static void addUnsupportProp(ec0 ec0Var) {
        if (ec0Var != null) {
            try {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                p.put(VuiConstants.PROPS_UNSUPPORTED, true);
                ec0Var.a(p);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean canUseVuiFeature() {
        return platformIsSupport() && !userDisabledFeature;
    }

    public static boolean cannotUpload() {
        if (isFeatureDisabled()) {
            StringBuilder a = jg.a("canUseVuiFeature():");
            a.append(canUseVuiFeature());
            a.append(",isFeatureDisabled:");
            a.append(isFeatureDisabled());
            LogUtils.d("VuiUtils", a.toString());
        }
        return !canUseVuiFeature() || isFeatureDisabled();
    }

    public static JSONObject createStatefulButtonData(int i, String[] strArr, JSONObject jSONObject) {
        if (strArr == null || strArr.length == 0 || i < 0 || i > strArr.length - 1) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Object[] objArr = new String[strArr.length];
            int i2 = 0;
            while (i2 < strArr.length) {
                JSONObject jSONObject2 = new JSONObject();
                StringBuilder sb = new StringBuilder();
                sb.append("state_");
                int i3 = i2 + 1;
                sb.append(i3);
                String sb2 = sb.toString();
                objArr[i2] = sb2;
                jSONObject2.put(sb2, strArr[i2]);
                jSONArray.put(jSONObject2);
                i2 = i3;
            }
            jSONObject.put("states", jSONArray);
            jSONObject.put("curState", objArr[i]);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void disableVuiFeature() {
        isDisableVuiFeature = true;
    }

    public static void enableVuiFeature() {
        isDisableVuiFeature = false;
    }

    public static View findChildRecyclerView(nf nfVar) {
        if (nfVar != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < nfVar.getChildCount(); i++) {
                linkedList.offer(nfVar.getChildAt(i));
            }
            while (!linkedList.isEmpty()) {
                View view = (View) linkedList.poll();
                if (view instanceof nf) {
                    return view;
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt instanceof ViewGroup) {
                            linkedList.offer(childAt);
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static SoftReference<View> findRecyclerView(SoftReference<View> softReference) {
        LinkedList linkedList = new LinkedList();
        linkedList.offer(softReference);
        while (!linkedList.isEmpty()) {
            SoftReference<View> softReference2 = (SoftReference) linkedList.poll();
            if (softReference2 != null && (softReference2.get() instanceof nf)) {
                return softReference2;
            }
            if (softReference2 != null && (softReference2.get() instanceof ViewGroup)) {
                SoftReference softReference3 = new SoftReference((ViewGroup) softReference2.get());
                for (int i = 0; softReference3.get() != null && i < ((ViewGroup) softReference3.get()).getChildCount(); i++) {
                    SoftReference softReference4 = new SoftReference(((ViewGroup) softReference3.get()).getChildAt(i));
                    if (softReference4.get() instanceof ViewGroup) {
                        linkedList.offer(softReference4);
                    }
                }
            }
        }
        return null;
    }

    public static ig findViewPager(View view) {
        LinkedList linkedList = new LinkedList();
        linkedList.offer(view);
        while (!linkedList.isEmpty()) {
            View view2 = (View) linkedList.poll();
            if (view2 instanceof ig) {
                return (ig) view2;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof ViewGroup) {
                        linkedList.offer(childAt);
                    }
                }
            }
        }
        return null;
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2, String str3) {
        return generateCommonVuiElement(str, mc0Var, str2, str3, false, pc0.LEVEL3);
    }

    public static void generateElementValueJSON(JSONObject jSONObject, String str, Object obj) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("value", obj);
            jSONObject.put(str, jSONObject2);
        } catch (Exception e) {
            jg.a(e, jg.a("generateElementValueJSON e:"), "VuiUtils");
        }
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, int i2) {
        return generateStatefulButtonElement(i, strArr, lc0.SETVALUE.c, jg.a("", i2), "");
    }

    public static String getCarPlatForm() {
        String str = sType;
        if (str != null) {
            return str;
        }
        sType = getXpCduType();
        return sType;
    }

    public static Method getDeclaredMethod(Object obj, String str, Class<?>... clsArr) {
        Method declaredMethod;
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
            if (declaredMethod != null) {
                return declaredMethod;
            }
        }
        return null;
    }

    public static String getDisplayLocation(int i) {
        return (i != 0 && i == 1) ? VuiConstants.SCREEN_DISPLAY_RF : VuiConstants.SCREEN_DISPLAY_LF;
    }

    public static String getDisplayLocation(String str) {
        return "0".equals(str) ? VuiConstants.SCREEN_DISPLAY_LF : "1".equals(str) ? VuiConstants.SCREEN_DISPLAY_RF : (VuiConstants.SCREEN_DISPLAY_LF.equals(str) || VuiConstants.SCREEN_DISPLAY_RF.equals(str)) ? str : VuiConstants.SCREEN_DISPLAY_LF;
    }

    public static int getExtraPage(sc0 sc0Var) {
        uu props;
        if (sc0Var.getProps() == null || (props = sc0Var.getProps()) == null || !props.b("extraPage")) {
            return -1;
        }
        return props.a("extraPage").b();
    }

    public static String getPackageNameFromSceneId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("-")) {
            return str.split("-")[0];
        }
        if (str.contains("_")) {
            return str.split("_")[0];
        }
        return null;
    }

    public static Object getReflexMethod(View view, String str) {
        Method declaredMethod;
        if (view != null && (declaredMethod = getDeclaredMethod(view, str, null)) != null) {
            try {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(view, null);
            } catch (Exception e) {
                jg.a(e, jg.a("getReflexMethod:"), "VuiUtils");
            }
        }
        return null;
    }

    public static String getResourceName(int i) {
        int indexOf;
        try {
            String resourceName = Foo.getContext().getResources().getResourceName(i);
            return (TextUtils.isEmpty(resourceName) || (indexOf = resourceName.indexOf(":")) == -1) ? resourceName : resourceName.substring(indexOf + 1);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSourceDisplayLocation() {
        if (Foo.getContext() == null) {
            return VuiConstants.SCREEN_DISPLAY_LF;
        }
        try {
            int screenId = WindowManagerFactory.create(Foo.getContext()).getScreenId(Foo.getContext().getApplicationInfo().packageName);
            LogUtils.d("VuiUtils:  ", screenId + "");
            return String.valueOf(screenId);
        } catch (Throwable th) {
            th.printStackTrace();
            return VuiConstants.SCREEN_DISPLAY_LF;
        }
    }

    public static <T> T getValueByName(sc0 sc0Var, String str) {
        Map map;
        lu luVar = new lu();
        StringBuilder a = jg.a("name:", str, CFCHelper.SIGNAL_CFC_SPLIT);
        a.append(luVar.a(sc0Var));
        LogUtils.logDebug("getEventValueByName", a.toString());
        if (sc0Var != null && sc0Var.getResultActions() != null && !sc0Var.getResultActions().isEmpty()) {
            String str2 = sc0Var.getResultActions().get(0);
            if ((sc0Var.getValues() instanceof bw) && (map = (Map) sc0Var.getValues()) != null) {
                if (map.get(str2) instanceof bw) {
                    Map map2 = (Map) map.get(str2);
                    if (map2 != null && map2.containsKey(str) && map2.get(str) != null) {
                        return (T) map2.get(str);
                    }
                } else if (map.get(str) != null) {
                    return (T) map.get(str);
                }
            }
        }
        return null;
    }

    public static String getVersionInCountryCode() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return ("".equals(str) || str == null) ? str : str.substring(7, 9);
    }

    public static oc0 getViewMode() {
        return viewMode;
    }

    public static String getXpCduType() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return "".equals(str) ? str : str.substring(5, 7);
    }

    public static boolean is3DApp(String str) {
        return VuiConstants.UNITY.equals(str) || "com.DefaultCompany.VUIDemo".equals(str);
    }

    public static boolean is3DUIPlatForm() {
        boolean a = zb0.a(VuiConstants.UNITY);
        LogUtils.i("VuiUtils", "is3DUIPlatForm:  " + a);
        return a;
    }

    public static boolean isActiveSceneId(String str) {
        return VuiEngineImpl.mActiveSceneIds.containsValue(str) || VuiEngineImpl.mLeftPopPanelStack.contains(str) || VuiEngineImpl.mRightPopPanelStack.contains(str);
    }

    public static boolean isFeatureDisabled() {
        return isDisableVuiFeature;
    }

    public static boolean isMultiScreenPlatForm() {
        return supportMultiScreenPlatform.contains(getCarPlatForm());
    }

    public static boolean isNumer(String str) {
        try {
            return Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(new BigDecimal(str).toString()).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isOverseasVersion() {
        if (sRegion == null) {
            sRegion = getVersionInCountryCode();
            StringBuilder a = jg.a("CountryCode:");
            a.append(sRegion);
            LogUtils.i("VuiUtils", a.toString());
        }
        if (TextUtils.isEmpty(sRegion)) {
            return false;
        }
        return "EU".equals(sRegion.toUpperCase());
    }

    public static boolean isPerformVuiAction(View view) {
        if (view instanceof ec0) {
            return ((ec0) view).i();
        }
        return false;
    }

    public static boolean isThirdApp(String str) {
        if ("com.android.systemui".equals(str)) {
            return false;
        }
        return TextUtils.isEmpty(str) || !str.startsWith("com.xiaopeng") || "com.xiaopeng.xpdemo".equals(str) || "com.xiaopeng.VuiDemo".equals(str);
    }

    public static boolean platformIsSupport() {
        if (isOverseasVersion()) {
            return false;
        }
        String carPlatForm = getCarPlatForm();
        if (TextUtils.isEmpty(carPlatForm) && zb0.a(VuiConstants.VUI_SCENE_THIRD_APP)) {
            return true;
        }
        return (TextUtils.isEmpty(carPlatForm) || unSupportType.contains(carPlatForm) || !zb0.a("com.xiaopeng.carspeechservice")) ? false : true;
    }

    public static void setPropsEvent(View view, sc0 sc0Var, JSONObject jSONObject) {
        boolean z;
        lu luVar = new lu();
        if (view != null && (view instanceof CompoundButton)) {
            z = ((CompoundButton) view).isChecked();
        } else if (view != null && (view instanceof Checkable)) {
            z = ((Checkable) view).isChecked();
        } else if (view != null) {
            Object n = ((ec0) view).n();
            if (n != null && (n instanceof Boolean)) {
                z = ((Boolean) n).booleanValue();
            } else {
                z = view.isSelected();
            }
        } else {
            z = false;
        }
        generateElementValueJSON(jSONObject, lc0.SETCHECK.c, Boolean.valueOf(z));
        setVuiPriority((ec0) view, sc0Var, z);
        sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
    }

    public static void setRecyclerViewItemVuiAttr(ec0 ec0Var, int i, String str) {
        setRecyclerViewItemVuiAttr(ec0Var, i, str, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void setStatefulButtonAttr(android.view.View r16, int r17, java.lang.String[] r18, java.lang.String r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.utils.VuiUtils.setStatefulButtonAttr(android.view.View, int, java.lang.String[], java.lang.String, boolean):void");
    }

    public static void setStatefulButtonValue(View view, int i) {
        if (view instanceof ec0) {
            StringBuilder a = jg.a("state_");
            a.append(i + 1);
            ((ec0) view).a(a.toString(), view);
        }
    }

    public static void setStatefulButtonValues(int i, String[] strArr, sc0 sc0Var) {
        lu luVar = new lu();
        if (sc0Var.getActions() == null || i < 0 || i >= strArr.length) {
            return;
        }
        ArrayList arrayList = new ArrayList(sc0Var.actions.h());
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (lc0.SETVALUE.c.equalsIgnoreCase((String) ((Map.Entry) arrayList.get(i2)).getKey())) {
                String[] split = TextUtils.isEmpty(strArr[i]) ? null : strArr[i].split("-");
                if (split != null && split.length >= 1) {
                    generateElementValueJSON(jSONObject, "SetValue", split[0]);
                }
            }
        }
        sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
    }

    public static void setValueAttribute(View view, sc0 sc0Var) {
        Object n;
        lu luVar = new lu();
        if (view == null || sc0Var == null || !(view instanceof ec0)) {
            return;
        }
        String type = sc0Var.getType();
        JSONObject jSONObject = new JSONObject();
        if (type != null && type.equals(mc0.RADIOBUTTON.c)) {
            setPropsEvent(view, sc0Var, jSONObject);
        } else if (type != null && type.equals(mc0.CHECKBOX.c)) {
            setPropsEvent(view, sc0Var, jSONObject);
        } else if (type != null && type.equals(mc0.SWITCH.c)) {
            setPropsEvent(view, sc0Var, jSONObject);
        } else if (type != null && type.equals(mc0.SEEKBAR.c)) {
            if (view instanceof ProgressBar) {
                generateElementValueJSON(jSONObject, lc0.SETVALUE.c, Integer.valueOf(((ProgressBar) view).getProgress()));
            }
            sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
        } else {
            if (type != null && type.equals(mc0.XSLIDER.c)) {
                try {
                    try {
                        n = view instanceof ec0 ? ((ec0) view).n() : null;
                        if (n == null) {
                            n = getReflexMethod(view, "getIndicatorValue");
                        }
                    } catch (Throwable th) {
                        Object reflexMethod = getReflexMethod(view, "getIndicatorValue");
                        if (reflexMethod != null && (reflexMethod instanceof Float)) {
                            generateElementValueJSON(jSONObject, lc0.SETVALUE.c, Integer.valueOf(((Float) reflexMethod).intValue()));
                            sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
                        }
                        throw th;
                    }
                } catch (Throwable unused) {
                    LogUtils.e("xpui version is not correct");
                    Object reflexMethod2 = getReflexMethod(view, "getIndicatorValue");
                    if (reflexMethod2 == null || !(reflexMethod2 instanceof Float)) {
                        return;
                    }
                    generateElementValueJSON(jSONObject, lc0.SETVALUE.c, Integer.valueOf(((Float) reflexMethod2).intValue()));
                }
                if (n == null || !(n instanceof Float)) {
                    return;
                }
                generateElementValueJSON(jSONObject, lc0.SETVALUE.c, Integer.valueOf(((Float) n).intValue()));
                sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
            } else if (type == null || !type.equals(mc0.XTABLAYOUT.c)) {
            } else {
                try {
                    try {
                        n = view instanceof ec0 ? ((ec0) view).n() : null;
                        if (n == null) {
                            n = getReflexMethod(view, "getSelectedTabIndex");
                        }
                    } catch (Throwable th2) {
                        Object reflexMethod3 = getReflexMethod(view, "getSelectedTabIndex");
                        if (reflexMethod3 != null && (reflexMethod3 instanceof Integer)) {
                            generateElementValueJSON(jSONObject, lc0.SELECTTAB.c, Integer.valueOf(((Integer) reflexMethod3).intValue()));
                            sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
                        }
                        throw th2;
                    }
                } catch (Throwable unused2) {
                    LogUtils.w("xpui version is not correct");
                    Object reflexMethod4 = getReflexMethod(view, "getSelectedTabIndex");
                    if (reflexMethod4 == null || !(reflexMethod4 instanceof Integer)) {
                        return;
                    }
                    generateElementValueJSON(jSONObject, lc0.SELECTTAB.c, Integer.valueOf(((Integer) reflexMethod4).intValue()));
                }
                if (n == null || !(n instanceof Integer)) {
                    return;
                }
                generateElementValueJSON(jSONObject, lc0.SELECTTAB.c, Integer.valueOf(((Integer) n).intValue()));
                sc0Var.setValues(luVar.a(jSONObject.toString(), (Class<Object>) uu.class));
            }
        }
    }

    public static void setVuiPriority(ec0 ec0Var, sc0 sc0Var, boolean z) {
        if (ec0Var == null || sc0Var == null) {
            return;
        }
        try {
            JSONObject p = ec0Var.p();
            if (p != null && p.has(VuiConstants.PROPS_DEFAULTPRIORITY)) {
                if (z) {
                    sc0Var.setPriority(pc0.LEVEL1.c);
                } else {
                    sc0Var.setPriority(p.getInt(VuiConstants.PROPS_DEFAULTPRIORITY));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static sc0 stringConvertToVuiElement(String str) {
        lu luVar = new lu();
        if (str == null) {
            return null;
        }
        return (sc0) luVar.a(str, (Class<Object>) sc0.class);
    }

    public static VuiScene stringConvertToVuiScene(String str) {
        lu luVar = new lu();
        if (str == null) {
            return null;
        }
        return (VuiScene) luVar.a(str, (Class<Object>) VuiScene.class);
    }

    public static void test() {
        System.out.println(vuiSceneConvertToString(stringConvertToVuiScene("{\n    \"id\": \"navigation_search\",\n    \"elements\": [\n        {\n            \"type\": \"Button\",\n            \"label\": \"返回\",\n            \"id\": 10020,\n            \"position\": 2\n        },\n        {\n            \"type\": \"EditText\",\n            \"label\": \"请输入目的地\",\n            \"id\": 10030\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"重新设置家的位置\",\n            \"id\": 10050\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"添加公司位置\",\n            \"id\": 10056\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"打开收藏夹\",\n            \"id\": 10062\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"充电站\",\n            \"id\": 10098\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"美食\",\n            \"id\": 10034\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"洗手间\",\n            \"id\": 10089\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"停车场\",\n            \"id\": 10056\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"维修\",\n            \"id\": 10065\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"小鹏4S\",\n            \"id\": 10035\n        },\n        {\n            \"type\": \"Button\",\n            \"label\": \"智能洗车\",\n            \"id\": 10076\n        },\n        {\n            \"type\": \"RecycleView\",\n            \"dynamic\": true,\n            \"id\": 10056,\n            \"elements\": [\n                {\n                    \"type\": \"Button\",\n                    \"label\": \"维修\",\n                    \"id\": 10023\n                }\n            ]\n        }\n    ]\n}")));
    }

    public static void userDisableViewMode() {
        viewMode = oc0.DISABLED;
    }

    public static void userSetFeatureState(boolean z) {
        userDisabledFeature = z;
    }

    public static String vuiElementGroupConvertToString(List<sc0> list) {
        if (list == null) {
            return null;
        }
        mu muVar = new mu();
        muVar.a(Integer.class, new SceneIntegerTypeAdapter());
        muVar.a(Boolean.class, new SceneBooleanTypeAdapter());
        muVar.a(mExclusionStrategy);
        return muVar.a().a(list);
    }

    public static String vuiFeedBackConvertToString(VuiFeedback vuiFeedback) {
        if (vuiFeedback == null) {
            return null;
        }
        return new mu().a().a(vuiFeedback);
    }

    public static synchronized String vuiSceneConvertToString(VuiScene vuiScene) {
        synchronized (VuiUtils.class) {
            if (vuiScene == null) {
                return null;
            }
            mu muVar = new mu();
            muVar.a(Integer.class, new SceneIntegerTypeAdapter());
            muVar.a(Boolean.class, new SceneBooleanTypeAdapter());
            try {
                return muVar.a().a(vuiScene);
            } catch (Exception e) {
                LogUtils.e("VuiUtils", "vuiSceneConvertToString e:" + e.toString());
                return null;
            }
        }
    }

    public static synchronized String vuiUpdateSceneConvertToString(VuiScene vuiScene) {
        synchronized (VuiUtils.class) {
            if (vuiScene == null) {
                return null;
            }
            mu muVar = new mu();
            muVar.a(Integer.class, new SceneIntegerTypeAdapter());
            muVar.a(Boolean.class, new SceneBooleanTypeAdapter());
            muVar.a(mExclusionStrategy);
            try {
                return muVar.a().a(vuiScene);
            } catch (Exception e) {
                LogUtils.e("VuiUtils", "vuiSceneConvertToString e:" + e.toString());
                return null;
            }
        }
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2, String str3, boolean z, pc0 pc0Var) {
        sc0.a aVar = new sc0.a();
        aVar.c = str;
        aVar.a = mc0Var.c;
        aVar.b = str2;
        aVar.a(str3);
        aVar.d = System.currentTimeMillis();
        sc0 sc0Var = new sc0(aVar);
        if (z) {
            sc0Var.setLayoutLoadable(Boolean.valueOf(z));
        }
        if (mc0.RECYCLEVIEW.c.equals(mc0Var.c)) {
            sc0Var.setLayoutLoadable(true);
        }
        int i = pc0.LEVEL3.c;
        int i2 = pc0Var.c;
        if (i != i2) {
            sc0Var.setPriority(i2);
        }
        return sc0Var;
    }

    public static void setRecyclerViewItemVuiAttr(ec0 ec0Var, int i, String str, mc0 mc0Var) {
        setRecyclerViewItemVuiAttr(ec0Var, i, str, mc0Var, null);
    }

    public static void setRecyclerViewItemVuiAttr(ec0 ec0Var, int i, String str, mc0 mc0Var, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            VuiEngine.getInstance(Foo.getContext()).setVuiElementTag((View) ec0Var, str2 + "_" + i);
        } else {
            ec0Var.b(((View) ec0Var).getId() + "_" + i);
        }
        ec0Var.a(i);
        if (TextUtils.isEmpty(str)) {
            ec0Var.a(str);
        }
        ec0Var.a(i);
        if (mc0Var != null) {
            ec0Var.a(mc0Var);
        }
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str) {
        return generateStatefulButtonElement(i, strArr, lc0.SETVALUE.c, str, "");
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str, String str2) {
        return generateStatefulButtonElement(i, strArr, str, str2, "");
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str, int i2) {
        return generateStatefulButtonElement(i, strArr, str, jg.a("", i2), "");
    }

    public static void addProps(ec0 ec0Var, Map<String, Object> map) {
        if (ec0Var == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                JSONObject p = ec0Var.p();
                if (p == null) {
                    p = new JSONObject();
                }
                ArrayList arrayList = new ArrayList(map.entrySet());
                for (int i = 0; i < arrayList.size(); i++) {
                    Map.Entry entry = (Map.Entry) arrayList.get(i);
                    p.put((String) entry.getKey(), entry.getValue());
                }
                ec0Var.a(p);
            }
        } catch (Exception unused) {
        }
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str, String str2, String str3) {
        if (str == null) {
            str = lc0.SETVALUE.c;
        }
        long currentTimeMillis = System.currentTimeMillis();
        sc0.a aVar = new sc0.a();
        aVar.c = str2;
        aVar.a = mc0.STATEFULBUTTON.c;
        aVar.b = str3;
        aVar.d = currentTimeMillis;
        aVar.a(str);
        sc0 sc0Var = new sc0(aVar);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String[] split = TextUtils.isEmpty(strArr[i2]) ? null : strArr[i2].split("-");
            if (split != null) {
                sc0.a aVar2 = new sc0.a();
                aVar2.c = str2 + "_state_" + i2;
                aVar2.a = mc0.STATE.c;
                aVar2.b = split[0];
                aVar2.d = currentTimeMillis;
                sc0 sc0Var2 = new sc0(aVar2);
                if (split.length > 1) {
                    sc0Var2.setValues(split[1]);
                } else {
                    sc0Var2.setValues(split[0]);
                }
                arrayList.add(sc0Var2);
            }
        }
        setStatefulButtonValues(i, strArr, sc0Var);
        if (!arrayList.isEmpty()) {
            sc0Var.setElements(arrayList);
        }
        return sc0Var;
    }

    public static JSONObject createStatefulButtonData(int i, String[] strArr, JSONObject jSONObject, View view) {
        if (strArr == null || strArr.length == 0 || !(view instanceof ec0) || i < 0 || i > strArr.length - 1) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] strArr2 = new String[strArr.length];
            int i2 = 0;
            while (i2 < strArr.length) {
                JSONObject jSONObject2 = new JSONObject();
                StringBuilder sb = new StringBuilder();
                sb.append("state_");
                int i3 = i2 + 1;
                sb.append(i3);
                String sb2 = sb.toString();
                strArr2[i2] = sb2;
                jSONObject2.put(sb2, strArr[i2]);
                jSONArray.put(jSONObject2);
                i2 = i3;
            }
            jSONObject.put("states", jSONArray);
            ((ec0) view).a(strArr2[i], view);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2, String str3, boolean z, pc0 pc0Var, int i) {
        sc0.a aVar = new sc0.a();
        aVar.c = str;
        aVar.a = mc0Var.c;
        aVar.b = str2;
        aVar.a(str3);
        aVar.d = System.currentTimeMillis();
        sc0 sc0Var = new sc0(aVar);
        if (z) {
            sc0Var.setLayoutLoadable(Boolean.valueOf(z));
        }
        if (mc0.RECYCLEVIEW.c.equals(mc0Var.c)) {
            sc0Var.setLayoutLoadable(true);
            if (LIST_VEDIO_TYPE == i) {
                uu uuVar = new uu();
                new HashMap();
                uuVar.a("matchedFirstPriority", (Boolean) true);
                uuVar.a("firstPriority", (Boolean) true);
                uuVar.a("listType", "videoList");
                sc0Var.setProps(uuVar);
            }
        }
        int i2 = pc0.LEVEL3.c;
        int i3 = pc0Var.c;
        if (i2 != i3) {
            sc0Var.setPriority(i3);
        }
        return sc0Var;
    }

    public static void setStatefulButtonAttr(View view, int i, String[] strArr, String str) {
        setStatefulButtonAttr(view, i, strArr, str, false);
    }

    public static void setStatefulButtonAttr(View view, int i, String[] strArr) {
        setStatefulButtonAttr(view, i, strArr, null, false);
    }

    public static sc0 generateCommonVuiElement(int i, mc0 mc0Var, String str, String str2) {
        return generateCommonVuiElement("" + i, mc0Var, str, str2);
    }

    public static sc0 generateCommonVuiElement(int i, mc0 mc0Var, String str) {
        return generateCommonVuiElement("" + i, mc0Var, str, (String) null);
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2) {
        return generateCommonVuiElement(str, mc0Var, str2, (String) null);
    }
}
