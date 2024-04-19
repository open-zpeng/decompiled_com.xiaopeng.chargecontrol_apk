package com.xiaopeng.speech.vui.utils;

import android.view.View;
import java.util.Map;
/* loaded from: classes.dex */
public class XpVuiUtils {
    public static void addProps(sc0 sc0Var, Map<String, Boolean> map) {
        VuiUtils.addProps(sc0Var, map);
    }

    public static void addScrollProps(sc0 sc0Var, View view) {
        VuiUtils.addScrollProps(sc0Var, view);
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2, String str3) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, str3);
    }

    public static sc0 generateLayoutLoadableVuiElement(String str, mc0 mc0Var, String str2) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, null, true, pc0.LEVEL3);
    }

    public static sc0 generatePriorityVuiElement(String str, mc0 mc0Var, String str2, pc0 pc0Var) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, null, false, pc0Var);
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, int i2) {
        return VuiUtils.generateStatefulButtonElement(i, strArr, lc0.SETVALUE.c, jg.a("", i2), "");
    }

    public static sc0 generateVideoVuiElement(String str, mc0 mc0Var, String str2, String str3) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, str3, false, pc0.LEVEL2, VuiUtils.LIST_VEDIO_TYPE);
    }

    public static <T> T getValueByName(sc0 sc0Var, String str) {
        return (T) VuiUtils.getValueByName(sc0Var, str);
    }

    public static void setValueAttribute(View view, sc0 sc0Var) {
        VuiUtils.setValueAttribute(view, sc0Var);
    }

    public static sc0 generateCommonVuiElement(int i, mc0 mc0Var, String str, String str2) {
        return VuiUtils.generateCommonVuiElement("" + i, mc0Var, str, str2);
    }

    public static sc0 generateLayoutLoadableVuiElement(String str, mc0 mc0Var, String str2, String str3) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, str3, true, pc0.LEVEL3);
    }

    public static sc0 generatePriorityVuiElement(String str, mc0 mc0Var, String str2, String str3, pc0 pc0Var) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, str3, false, pc0Var);
    }

    public static sc0 generateCommonVuiElement(int i, mc0 mc0Var, String str) {
        return VuiUtils.generateCommonVuiElement("" + i, mc0Var, str, (String) null);
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, (String) null);
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str) {
        return VuiUtils.generateStatefulButtonElement(i, strArr, lc0.SETVALUE.c, str, "");
    }

    public static sc0 generateCommonVuiElement(String str, mc0 mc0Var, String str2, boolean z) {
        return VuiUtils.generateCommonVuiElement(str, mc0Var, str2, null, z, pc0.LEVEL3);
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str, String str2) {
        return VuiUtils.generateStatefulButtonElement(i, strArr, str, str2, "");
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str, int i2) {
        return VuiUtils.generateStatefulButtonElement(i, strArr, str, jg.a("", i2), "");
    }

    public static sc0 generateStatefulButtonElement(int i, String[] strArr, String str, String str2, String str3) {
        return VuiUtils.generateStatefulButtonElement(i, strArr, str, str2, str3);
    }
}
