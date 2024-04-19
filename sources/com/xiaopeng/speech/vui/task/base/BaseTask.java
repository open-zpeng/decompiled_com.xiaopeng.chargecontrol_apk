package com.xiaopeng.speech.vui.task.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaopeng.speech.vui.VuiEngineImpl;
import com.xiaopeng.speech.vui.VuiSceneManager;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.task.TaskWrapper;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.ResourceUtil;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseTask implements Task, fc0 {
    public String mPackageName;
    public String mPackageVersion;
    public String sceneId;
    public TaskWrapper wrapper;
    public String TAG = "BaseTask";
    public String mSceneIdPrefix = null;
    public String[] bizTypeEnum = {"Address", "Navi", "Route", "Waypoint", "Pic", "Charge", "Connect", "Disconnect", "Null"};
    public lu mGson = new lu();

    public BaseTask(TaskWrapper taskWrapper) {
        this.wrapper = taskWrapper;
        TaskWrapper taskWrapper2 = this.wrapper;
        this.sceneId = taskWrapper2 != null ? taskWrapper2.getSceneId() : "";
        init();
    }

    private void addChildElement(SoftReference<View> softReference, List<sc0> list, List<String> list2, List<Integer> list3, SoftReference<hc0> softReference2, List<String> list4, long j, List<String> list5, String str, int i, boolean z, boolean z2, gc0 gc0Var) {
        sc0 buildView = buildView(softReference, list, list3, softReference2, list4, j, list5, list2, str, i, z, z2, gc0Var);
        if (buildView == null || buildView.getId() == null) {
            return;
        }
        String id = buildView.getId();
        list.add(buildView);
        buildView.setTimestamp(j);
        if ((softReference.get() instanceof ViewGroup) && buildView.getType() != null && buildView.getType().equals(mc0.STATEFULBUTTON.c)) {
            getChildElements(softReference, list, list3, softReference2, list4, j, list5, list2, id, z, z2, gc0Var);
        }
    }

    private sc0 buildVuiElement(SoftReference<View> softReference, List<String> list, List<String> list2, String str, int i, long j, boolean z, boolean z2) {
        if (softReference == null || !(softReference.get() instanceof ec0)) {
            return null;
        }
        sc0 buildVuiElementAttr = buildVuiElementAttr(softReference);
        if (buildVuiElementAttr != null) {
            ec0 ec0Var = (ec0) softReference.get();
            handleId(getElementId(softReference, VuiConstants.ATTRS_ELEMENT_ID), buildVuiElementAttr, list, list2, softReference, str, i, z, z2);
            boolean z3 = ec0Var.f() || (z && !mc0.XGROUPHEADER.c.equals(buildVuiElementAttr.getType()));
            if (z3) {
                buildVuiElementAttr.setLayoutLoadable(Boolean.valueOf(z3));
            }
            JSONObject p = ec0Var.p();
            if (p != null) {
                if (!mc0.STATEFULBUTTON.c.equals(buildVuiElementAttr.getType()) && !mc0.RECYCLEVIEW.c.equals(buildVuiElementAttr.getType())) {
                    if (p.keys().hasNext()) {
                        buildVuiElementAttr.setProps((uu) this.mGson.a(p.toString(), (Class<Object>) uu.class));
                    }
                } else {
                    createElementByProps(softReference, buildVuiElementAttr, p, j, z3, false);
                }
            }
            if (softReference.get() != null && (softReference.get() instanceof ViewGroup) && softReference.get().getVisibility() == 0 && !ec0Var.m() && softReference.get() != null && mc0.GROUP.c.equals(buildVuiElementAttr.getType()) && TextUtils.isEmpty(buildVuiElementAttr.getLabel()) && TextUtils.isEmpty(ec0Var.o())) {
                if (softReference.get().getId() != -1) {
                    if (VuiUtils.getViewMode() != null && VuiUtils.getViewMode().equals(oc0.DISABLED)) {
                        String str2 = this.TAG;
                        StringBuilder a = jg.a("ViewGroup is ignored:");
                        a.append(softReference.get());
                        LogUtils.d(str2, a.toString());
                        if (!isContainsInAllCache(buildVuiElementAttr.getId())) {
                            removeId(softReference, buildVuiElementAttr.getId(), list, list2);
                            return null;
                        }
                    }
                } else {
                    String str3 = this.TAG;
                    StringBuilder a2 = jg.a("ViewGroup is ignored:");
                    a2.append(softReference.get());
                    LogUtils.d(str3, a2.toString());
                    removeId(softReference, buildVuiElementAttr.getId(), list, list2);
                    return null;
                }
            }
        }
        return buildVuiElementAttr;
    }

    private sc0 buildVuiElementGroup(SoftReference<View> softReference, String str, List<Integer> list, SoftReference<hc0> softReference2, List<String> list2, long j, List<String> list3, List<String> list4, int i, List<sc0> list5, boolean z, boolean z2, gc0 gc0Var) {
        sc0 buildVuiElement = buildVuiElement(softReference, list2, list3, str, i, j, z, z2);
        if (buildVuiElement == null || buildVuiElement.getId() == null || buildVuiElement.getType() == null || buildVuiElement.getType().equals(mc0.XSLIDER.c)) {
            return buildVuiElement;
        }
        String id = buildVuiElement.getId();
        if (buildVuiElement.getType().equals(mc0.UNKNOWN.c)) {
            String str2 = this.TAG;
            StringBuilder a = jg.a("element type is unknown");
            a.append(buildVuiElement.getLabel());
            LogUtils.d(str2, a.toString());
            removeId(softReference, buildVuiElement.getId(), list2, list3);
            return null;
        } else if (buildVuiElement.getType().equals(mc0.STATEFULBUTTON.c)) {
            return buildVuiElement;
        } else {
            if (softReference != null && (softReference.get() instanceof ec0)) {
                if (((ec0) softReference.get()).f() && softReference.get().getVisibility() != 0) {
                    return buildVuiElement;
                }
                if (!"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) && softReference.get().getTag(R.id.disableChildVuiAttrsWhenInvisible) != null && softReference.get().getVisibility() != 0) {
                    return buildVuiElement;
                }
            }
            List<sc0> elements = buildVuiElement.getElements();
            if (elements == null) {
                elements = new ArrayList<>();
            }
            List<sc0> list6 = elements;
            getChildElements(softReference, list6, list, softReference2, list2, j, list3, list4, id, buildVuiElement.isLayoutLoadable() != null ? buildVuiElement.isLayoutLoadable().booleanValue() : false, z2, gc0Var);
            if (list6.size() > 0) {
                buildVuiElement.setElements(list6);
                return buildVuiElement;
            }
            return buildVuiElement;
        }
    }

    private String escapeQueryChars(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                sb.append(" ");
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private void getChildElements(SoftReference<View> softReference, List<sc0> list, List<Integer> list2, SoftReference<hc0> softReference2, List<String> list3, long j, List<String> list4, List<String> list5, String str, boolean z, boolean z2, gc0 gc0Var) {
        int i;
        SoftReference softReference3;
        int i2;
        String str2;
        String l;
        BaseTask baseTask = this;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        if (softReference.get() != null && (softReference.get() instanceof ec0) && (l = ((ec0) softReference.get()).l()) != null) {
            if (list5.contains(l)) {
                return;
            }
            list5.add(l);
        }
        if (softReference.get() != null && (softReference.get() instanceof nf)) {
            if (((nf) softReference.get()).getAdapter() == null) {
                return;
            }
            SoftReference softReference4 = new SoftReference((nf) softReference.get());
            int childCount = ((nf) softReference4.get()).getChildCount();
            if (softReference4.get() != null && ((nf) softReference4.get()).getChildCount() == 0) {
                String str3 = baseTask.TAG;
                StringBuilder a = jg.a("RecyclerView 的child count 为0,view：");
                a.append(softReference.get());
                LogUtils.e(str3, a.toString());
            }
            String str4 = baseTask.TAG;
            StringBuilder a2 = jg.a("RecyclerView 的child count:");
            a2.append(((nf) softReference4.get()).getChildCount());
            String str5 = ",view：";
            a2.append(",view：");
            a2.append(softReference4.get());
            LogUtils.d(str4, a2.toString());
            int i3 = 0;
            while (softReference4.get() != null && i3 < ((nf) softReference4.get()).getChildCount() && i3 < ((nf) softReference4.get()).getAdapter().a()) {
                SoftReference<View> softReference5 = new SoftReference<>(((nf) softReference4.get()).getChildAt(i3));
                if (softReference5.get() == null) {
                    LogUtils.e(baseTask.TAG, "RecyclerView 的child 为null,postion:" + i3);
                }
                int i4 = i3;
                String str6 = str5;
                int i5 = childCount;
                SoftReference softReference6 = softReference4;
                addChildElement(softReference5, list, list5, list2, softReference2, list3, j, list4, str, i4, z, true, gc0Var);
                if (softReference6.get() == null || ((nf) softReference6.get()).getChildCount() == i5) {
                    i2 = i5;
                    str2 = str6;
                    baseTask = this;
                } else {
                    i2 = i5;
                    baseTask = this;
                    String str7 = baseTask.TAG;
                    StringBuilder a3 = jg.a("RecyclerView is not same child count:");
                    a3.append(((nf) softReference6.get()).getChildCount());
                    str2 = str6;
                    a3.append(str2);
                    a3.append(softReference6.get());
                    a3.append(",len:");
                    a3.append(i2);
                    LogUtils.w(str7, a3.toString());
                }
                i3 = i4 + 1;
                childCount = i2;
                str5 = str2;
                softReference4 = softReference6;
            }
        } else if (softReference.get() instanceof ListView) {
            SoftReference softReference7 = new SoftReference((ListView) softReference.get());
            int i6 = 0;
            while (softReference7.get() != null && i6 < ((ListView) softReference7.get()).getCount()) {
                if (((ListView) softReference7.get()).getAdapter() != null) {
                    i = i6;
                    softReference3 = softReference7;
                    addChildElement(new SoftReference<>(((ListView) softReference7.get()).getAdapter().getView(i6, null, (ViewGroup) softReference7.get())), list, list5, list2, softReference2, list3, j, list4, str, i6, z, z2, gc0Var);
                } else {
                    i = i6;
                    softReference3 = softReference7;
                }
                i6 = i + 1;
                softReference7 = softReference3;
            }
        } else if (softReference.get() instanceof ViewGroup) {
            int i7 = 0;
            for (SoftReference softReference8 = new SoftReference((ViewGroup) softReference.get()); softReference8.get() != null && i7 < ((ViewGroup) softReference8.get()).getChildCount(); softReference8 = softReference8) {
                addChildElement(new SoftReference<>(((ViewGroup) softReference8.get()).getChildAt(i7)), list, list5, list2, softReference2, list3, j, list4, str, i7, z, z2, gc0Var);
                i7++;
            }
        }
    }

    private String getElementId(SoftReference<View> softReference, String str) {
        String g;
        if (softReference == null || !(softReference.get() instanceof ec0)) {
            return null;
        }
        ec0 ec0Var = (ec0) softReference.get();
        if (str.equals(VuiConstants.ATTRS_ELEMENT_ID) && softReference.get() != null && softReference.get().getTag() != null && (softReference.get().getTag() instanceof String)) {
            String str2 = (String) softReference.get().getTag();
            if (str2.startsWith("4657")) {
                String str3 = this.TAG;
                LogUtils.d(str3, "client has set Tag" + str2);
                return str2;
            }
        }
        if (str.equals(VuiConstants.ATTRS_ELEMENT_FATHER_ID)) {
            g = ec0Var.q();
        } else {
            g = str.equals(VuiConstants.ATTRS_ELEMENT_ID) ? ec0Var.g() : null;
        }
        if (g != null && !TextUtils.isEmpty(g)) {
            if (isNumber(g)) {
                return g;
            }
            StringBuilder a = jg.a("");
            a.append(ResourceUtil.getId(Foo.getContext(), g));
            return a.toString();
        } else if (str.contains(VuiConstants.ATTRS_ELEMENT_FATHER_ID) || softReference.get() == null || softReference.get().getId() == -1) {
            return null;
        } else {
            StringBuilder a2 = jg.a("");
            a2.append(softReference.get().getId());
            return a2.toString();
        }
    }

    private String getElementLabel(ec0 ec0Var) {
        String h = ec0Var.h();
        CharSequence charSequence = null;
        if (h != null) {
            if (!h.contains("|") || h.split("\\|").length <= 5) {
                return h;
            }
            LogUtils.e(this.TAG, "label 不能超过5个");
            return null;
        }
        if (!"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
            Object tag = ((View) ec0Var).getTag(R.id.vuiLabelUnSupportText);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                return h == null ? "" : h;
            }
        }
        if (ec0Var instanceof TextView) {
            if (!(ec0Var instanceof EditText)) {
                charSequence = ((TextView) ec0Var).getText();
            } else {
                EditText editText = (EditText) ec0Var;
                charSequence = editText.getHint();
                if (charSequence == null) {
                    charSequence = editText.getText();
                }
            }
        }
        return !TextUtils.isEmpty(charSequence) ? charSequence.toString() : "";
    }

    private sc0 getStateFulBtnCurr(String str, List<sc0> list) {
        String[] split;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty() || TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length <= 1 || !VuiUtils.isNumeric(split[1])) {
            return null;
        }
        return list.get(Integer.parseInt(split[1]) - 1);
    }

    private void init() {
        PackageInfo packageInfo;
        this.mPackageName = Foo.getContext().getApplicationInfo().packageName;
        try {
            packageInfo = Foo.getContext().getPackageManager().getPackageInfo(this.mPackageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        this.mPackageVersion = packageInfo.versionName;
        this.mSceneIdPrefix = this.mPackageName + "-" + this.mPackageVersion;
    }

    private boolean isContainsInAllCache(String str) {
        sc0 vuiElementById = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType()).getVuiElementById(this.sceneId, str);
        if (vuiElementById == null) {
            LogUtils.e(this.TAG, "缓存中没有此元素");
            return false;
        } else if (mc0.GROUP.c.equals(vuiElementById.getType())) {
            return true;
        } else {
            LogUtils.e(this.TAG, "缓存中没有此元素");
            return false;
        }
    }

    private boolean isNumber(String str) {
        return Pattern.compile("[0-9]+(_[0-9]+)*").matcher(str).matches();
    }

    private void removeId(SoftReference<View> softReference, String str, List<String> list, List<String> list2) {
        if (softReference == null || softReference.get() == null) {
            return;
        }
        if (list.contains(str)) {
            list.remove(str);
        }
        if (list2 != null && list2.contains(str)) {
            list2.remove(str);
        }
        if ("com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || TextUtils.isEmpty((String) softReference.get().getTag(R.id.vuiElementId))) {
            return;
        }
        softReference.get().setTag(R.id.vuiElementId, "");
        softReference.get().setTag(null);
    }

    private void setVuiElementChangedListener(SoftReference<View> softReference, gc0 gc0Var, String str) {
        if (gc0Var == null || !(softReference.get() instanceof ec0)) {
            return;
        }
        ec0 ec0Var = (ec0) softReference.get();
        if (TextUtils.isEmpty(ec0Var.g())) {
            ec0Var.b(str);
        }
        if (ec0Var.d() == null) {
            ((ec0) softReference.get()).a(gc0Var);
        }
    }

    private void showToast(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.xiaopeng.speech.vui.task.base.BaseTask.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(Foo.getContext(), str, 1).show();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fd, code lost:
        if (r1.equals(defpackage.oc0.SILENT) != false) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.sc0 buildView(java.lang.ref.SoftReference<android.view.View> r24, java.util.List<defpackage.sc0> r25, java.util.List<java.lang.Integer> r26, java.lang.ref.SoftReference<defpackage.hc0> r27, java.util.List<java.lang.String> r28, long r29, java.util.List<java.lang.String> r31, java.util.List<java.lang.String> r32, java.lang.String r33, int r34, boolean r35, boolean r36, defpackage.gc0 r37) {
        /*
            Method dump skipped, instructions count: 1024
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.task.base.BaseTask.buildView(java.lang.ref.SoftReference, java.util.List, java.util.List, java.lang.ref.SoftReference, java.util.List, long, java.util.List, java.util.List, java.lang.String, int, boolean, boolean, gc0):sc0");
    }

    public List<sc0> buildVuiElement(View view) {
        return null;
    }

    public List<sc0> buildVuiElement(List<View> list) {
        return null;
    }

    public sc0 buildVuiElementAttr(SoftReference<View> softReference) {
        JSONObject jSONObject;
        if (softReference == null || !(softReference.get() instanceof ec0)) {
            return null;
        }
        ec0 ec0Var = (ec0) softReference.get();
        if (VuiUtils.getViewMode() != null && VuiUtils.getViewMode().equals(oc0.DISABLED) && !(softReference.get() instanceof ViewGroup) && !ec0Var.m()) {
            SoftReference softReference2 = new SoftReference((View) softReference.get().getParent());
            if (((softReference2.get() instanceof ec0) && ((ec0) softReference2.get()).c() == mc0.XTABLAYOUT) ? false : true) {
                return null;
            }
        }
        oc0 k = ec0Var.k();
        if ((k == null || k.equals(oc0.DISABLED) || k.equals(oc0.SILENT)) ? false : true) {
            sc0 sc0Var = new sc0();
            String o = ec0Var.o();
            if (o != null) {
                sc0Var.setActions(o);
            }
            String elementLabel = getElementLabel(ec0Var);
            if (elementLabel == null) {
                LogUtils.e(this.TAG, "label 不合法");
                return null;
            }
            if (elementLabel.contains("'")) {
                elementLabel = escapeQueryChars(elementLabel);
            }
            sc0Var.setLabel(elementLabel);
            sc0Var.setFatherLabel(ec0Var.b());
            String elementId = getElementId(softReference, VuiConstants.ATTRS_ELEMENT_FATHER_ID);
            if (elementId != null) {
                sc0Var.setFatherElementId(elementId);
            }
            String str = mc0.UNKNOWN.c;
            if (softReference.get() instanceof nf) {
                sc0Var.setType(mc0.RECYCLEVIEW.c);
            } else if (softReference.get() != null) {
                mc0 c = ec0Var.c();
                if (c != null) {
                    str = c.c;
                }
                sc0Var.setType(str);
            }
            int i = ec0Var.e().c;
            if (i != pc0.LEVEL3.c) {
                sc0Var.setPriority(i);
            }
            JSONObject p = ec0Var.p();
            if (!"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
                if (softReference.get() != null && softReference.get().getTag(R.id.vuiElementUnSupport) != null) {
                    if (((Boolean) softReference.get().getTag(R.id.vuiElementUnSupport)).booleanValue()) {
                        if (p == null) {
                            try {
                                p = new JSONObject();
                            } catch (Exception unused) {
                            }
                        }
                        p.put(VuiConstants.PROPS_UNSUPPORTED, true);
                    } else if (p != null && p.has(VuiConstants.PROPS_UNSUPPORTED)) {
                        p.remove(VuiConstants.PROPS_UNSUPPORTED);
                    }
                }
                if (softReference.get() != null && softReference.get().getTag(R.id.vuiElementDefaultAction) != null && (jSONObject = (JSONObject) softReference.get().getTag(R.id.vuiElementDefaultAction)) != null) {
                    if (p == null) {
                        try {
                            p = new JSONObject();
                        } catch (Exception unused2) {
                        }
                    }
                    p.put(VuiConstants.PROPS_DEFAULTACTION, jSONObject);
                }
            }
            if (p != null) {
                if (p.has(VuiConstants.PROPS_VOICECONTROL)) {
                    try {
                        if (!p.getBoolean(VuiConstants.PROPS_VOICECONTROL)) {
                            p.remove(VuiConstants.PROPS_VOICECONTROL);
                        }
                    } catch (JSONException unused3) {
                        p.remove(VuiConstants.PROPS_VOICECONTROL);
                    }
                }
                if (p.length() > 0) {
                    ec0Var.a(p);
                }
            }
            sc0Var.setPosition(ec0Var.j());
            if (sc0Var.getValues() == null) {
                VuiUtils.setValueAttribute(softReference.get(), sc0Var);
            }
            if (softReference.get() != null) {
                if (!"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
                    Boolean bool = (Boolean) softReference.get().getTag(R.id.vuiElementVisible);
                    if (bool != null) {
                        if (!bool.booleanValue()) {
                            sc0Var.setVisible(false);
                        }
                    } else if (softReference.get().getVisibility() != 0) {
                        sc0Var.setVisible(false);
                    }
                } else if (softReference.get().getVisibility() != 0) {
                    sc0Var.setVisible(false);
                }
            }
            if (softReference.get() != null && softReference.get().getId() != -1 && softReference.get().getId() != 0) {
                String resourceName = VuiUtils.getResourceName(softReference.get().getId());
                if (!TextUtils.isEmpty(resourceName)) {
                    sc0Var.setResourceName(resourceName);
                }
            } else if (softReference.get() != null && !"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
                Object tag = softReference.get().getTag(R.id.virtualResourceName);
                String str2 = this.TAG;
                LogUtils.d(str2, "resourceTag:" + tag);
                if (tag != null) {
                    sc0Var.setResourceName((String) tag);
                }
            }
            if (k != null && k.equals(oc0.UNDERSTOOD)) {
                sc0Var.setMode(k.c);
            }
            return sc0Var;
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:6|(2:176|(9:181|(3:183|(4:185|(8:187|188|189|190|191|192|(1:228)(5:198|199|(12:203|204|205|206|207|208|209|210|211|212|200|201)|220|221)|222)|232|219)(1:233)|216)(1:234)|112|113|(2:(4:117|(2:123|124)|125|115)|129)(2:143|(2:(4:147|(2:167|168)(2:153|(2:155|(2:157|(2:159|160)(1:162))(2:163|164))(2:165|166))|161|145)|169))|130|(4:132|133|134|136)|140|141))(2:10|(1:175)(5:(4:15|(7:18|19|(3:21|(10:24|25|26|27|28|29|30|(13:32|33|34|35|(5:37|38|39|40|(7:42|43|44|45|(1:47)|48|49))(1:68)|56|(6:61|62|45|(0)|48|49)|63|62|45|(0)|48|49)(2:72|73)|50|22)|80)|81|82|55|16)|86|87)(1:174)|88|(1:90)(2:171|(1:173))|91|(4:93|(4:96|(2:98|99)(2:101|(2:105|106))|100|94)|109|110)))|111|112|113|(0)(0)|130|(0)|140|141) */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0335 A[Catch: Exception -> 0x03d6, LOOP:3: B:144:0x0335->B:153:0x0358, LOOP_START, PHI: r16 
      PHI: (r16v2 java.lang.Object) = (r16v1 java.lang.Object), (r16v3 java.lang.Object) binds: [B:143:0x0333, B:153:0x0358] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {Exception -> 0x03d6, blocks: (B:142:0x031e, B:144:0x0335, B:146:0x033b, B:148:0x0345, B:150:0x034b, B:152:0x0351, B:175:0x03b8, B:154:0x035b, B:156:0x0369, B:158:0x036f, B:160:0x0377, B:162:0x037d, B:164:0x0383, B:166:0x038b, B:168:0x0393, B:170:0x039b), top: B:199:0x031e }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x035b A[Catch: Exception -> 0x03d6, TryCatch #5 {Exception -> 0x03d6, blocks: (B:142:0x031e, B:144:0x0335, B:146:0x033b, B:148:0x0345, B:150:0x034b, B:152:0x0351, B:175:0x03b8, B:154:0x035b, B:156:0x0369, B:158:0x036f, B:160:0x0377, B:162:0x037d, B:164:0x0383, B:166:0x038b, B:168:0x0393, B:170:0x039b), top: B:199:0x031e }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6 A[Catch: Exception -> 0x00f2, TryCatch #8 {Exception -> 0x00f2, blocks: (B:40:0x0094, B:52:0x00bf, B:54:0x00e6, B:55:0x00ee, B:44:0x00a6, B:46:0x00ae, B:49:0x00b2, B:51:0x00bc, B:50:0x00b9), top: B:205:0x0094 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createElementByProps(java.lang.ref.SoftReference<android.view.View> r24, defpackage.sc0 r25, org.json.JSONObject r26, long r27, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.task.base.BaseTask.createElementByProps(java.lang.ref.SoftReference, sc0, org.json.JSONObject, long, boolean, boolean):void");
    }

    public String getActiveWholeSceneId(List<String> list) {
        if (list == null) {
            return "";
        }
        String str = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_LF);
        String str2 = VuiEngineImpl.mActiveSceneIds.get(VuiConstants.SCREEN_DISPLAY_RF);
        return (TextUtils.isEmpty(str) || !list.contains(str)) ? (TextUtils.isEmpty(str2) || !list.contains(str2)) ? "" : str2 : str;
    }

    public VuiScene getNewVuiScene(String str, long j) {
        return new VuiScene.Builder().sceneId(str).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(j).build();
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getSceneUnqiueId(String str) {
        return this.mSceneIdPrefix + "-" + str;
    }

    public String handleId(String str, sc0 sc0Var, List<String> list, List<String> list2, SoftReference<View> softReference, String str2, int i, boolean z, boolean z2) {
        if ("com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
            if (list != null && !list.contains(str)) {
                list.add(str);
                if (sc0Var != null) {
                    sc0Var.setId(str);
                }
            }
            if (list2 != null && !list2.contains(str)) {
                list2.add(str);
            }
            return str;
        }
        if ((!z && !z2 && (str == null || str.equals("0") || !str.contains("_"))) || (softReference != null && (softReference.get() instanceof nf))) {
            String str3 = softReference.get() != null ? (String) softReference.get().getTag(R.id.vuiElementId) : null;
            if (!TextUtils.isEmpty(str3)) {
                if (!list.contains(str3)) {
                    list.add(str3);
                } else {
                    LogUtils.w(this.TAG, "更新不合法");
                }
                if (list2 != null && !list2.contains(str3)) {
                    list2.add(str3);
                }
                if (sc0Var != null) {
                    sc0Var.setId(str3);
                }
                return str3;
            }
        }
        if (str == null || str.equals("0")) {
            if (str2 == null) {
                str = jg.a("4657_", i);
            } else {
                str = str2 + "_" + i;
            }
        } else if (list != null && list.contains(str)) {
            if (str2 == null) {
                str = str + "_" + i;
            } else {
                str = jg.b(str2, "_", str);
                if (list.contains(str)) {
                    str = str + "_" + i;
                }
            }
        }
        if (list != null && !list.contains(str)) {
            list.add(str);
            if (sc0Var != null) {
                sc0Var.setId(str);
            }
            setVuiTag(softReference, str);
            if (list2 != null && !list2.contains(str)) {
                list2.add(str);
            }
            return str;
        }
        LogUtils.w(this.TAG, "容错失败：" + str);
        return str + "_error";
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        execute();
    }

    public void setVuiTag(SoftReference<View> softReference, String str) {
        if ("com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || softReference == null || softReference.get() == null) {
            return;
        }
        if (softReference.get().getTag() == null) {
            softReference.get().setTag(str);
            softReference.get().setTag(R.id.vuiElementId, str);
            return;
        }
        String str2 = (String) softReference.get().getTag(R.id.vuiElementId);
        if (str2 == null || str2.equals(str)) {
            return;
        }
        softReference.get().setTag(str);
        softReference.get().setTag(R.id.vuiElementId, str);
    }
}
