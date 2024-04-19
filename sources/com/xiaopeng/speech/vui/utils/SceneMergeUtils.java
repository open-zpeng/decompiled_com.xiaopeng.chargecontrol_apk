package com.xiaopeng.speech.vui.utils;

import android.text.TextUtils;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SceneMergeUtils {
    public static List<sc0> duplicateRemoval(List<sc0> list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        sc0 sc0Var = new sc0();
        sc0Var.setElements(list);
        sc0Var.setId("-1");
        findNode(sc0Var, null, hashMap, hashMap2);
        return sc0Var.getElements();
    }

    public static void findNode(sc0 sc0Var, sc0 sc0Var2, Map<String, sc0> map, Map<String, sc0> map2) {
        if (sc0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(sc0Var.getId())) {
            if (map.containsKey(sc0Var.getId())) {
                sc0 sc0Var3 = map.get(sc0Var.getId());
                if (sc0Var3 == null) {
                    return;
                }
                if (sc0Var.getTimestamp() >= sc0Var3.getTimestamp()) {
                    sc0 sc0Var4 = map2.get(sc0Var.getId());
                    if (sc0Var4 == null) {
                        return;
                    }
                    if (sc0Var4.getElements() != null && !sc0Var4.getElements().isEmpty()) {
                        sc0Var4.getElements().remove(map.get(sc0Var.getId()));
                    }
                    map.put(sc0Var.getId(), sc0Var);
                    map2.put(sc0Var.getId(), sc0Var2);
                }
            } else {
                map.put(sc0Var.getId(), sc0Var);
                map2.put(sc0Var.getId(), sc0Var2);
            }
        }
        List<sc0> elements = sc0Var.getElements();
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                findNode(elements.get(i), sc0Var, map, map2);
            }
        }
    }

    public static synchronized List<sc0> merge(List<sc0> list, List<sc0> list2, boolean z) {
        synchronized (SceneMergeUtils.class) {
            if (list2 != null) {
                if (!list2.isEmpty()) {
                    if (list != null && !list.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (sc0 sc0Var : list2) {
                            mergeElement(list, sc0Var, arrayList, z);
                        }
                        if (list2.size() != arrayList.size() && list2.size() > arrayList.size()) {
                            for (sc0 sc0Var2 : list2) {
                                if (sc0Var2.getId() != null && !arrayList.contains(sc0Var2.getId())) {
                                    list.add(sc0Var2);
                                }
                            }
                        }
                        return list;
                    }
                    return list2;
                }
            }
            return list;
        }
    }

    public static void mergeElement(List<sc0> list, sc0 sc0Var, List<String> list2, boolean z) {
        if (sc0Var == null || list == null || sc0Var.getId() == null) {
            return;
        }
        for (sc0 sc0Var2 : list) {
            if (sc0Var.getId().equals(sc0Var2.getId())) {
                int indexOf = list.indexOf(sc0Var2);
                if (z && sc0Var.getElements() == null && sc0Var2.getElements() != null) {
                    sc0Var.setElements(sc0Var2.getElements());
                }
                list.set(indexOf, sc0Var);
                list2.add(sc0Var.getId());
                return;
            } else if (sc0Var2.getElements() != null && !sc0Var2.getElements().isEmpty()) {
                mergeElement(sc0Var2.getElements(), sc0Var, list2, z);
            }
        }
    }

    public static void removeElement(List<sc0> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            sc0 sc0Var = list.get(i);
            if (sc0Var != null) {
                if (str.equals(sc0Var.getId())) {
                    list.remove(i);
                    return;
                } else if (sc0Var.getElements() != null && !sc0Var.getElements().isEmpty()) {
                    removeElement(sc0Var.getElements(), str);
                }
            }
        }
    }

    public static synchronized List<sc0> removeElementById(List<sc0> list, List<String> list2) {
        synchronized (SceneMergeUtils.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    if (list2 != null && !list2.isEmpty()) {
                        for (String str : list2) {
                            removeElement(list, str);
                        }
                        return list;
                    }
                    return list;
                }
            }
            return list;
        }
    }

    public static synchronized List<sc0> updateMerge(List<sc0> list, List<sc0> list2, boolean z) {
        synchronized (SceneMergeUtils.class) {
            List<sc0> merge = merge(list, list2, z);
            if (merge != null && !merge.isEmpty()) {
                return duplicateRemoval(merge);
            }
            return merge;
        }
    }

    public static void removeElement(JSONArray jSONArray, String str) {
        if (str == null || jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null && jSONObject.has("id")) {
                if (!TextUtils.isEmpty(jSONObject.optString("id")) && jSONObject.optString("id").equals(str)) {
                    jSONArray.remove(i);
                    return;
                } else if (jSONObject.has(VuiConstants.SCENE_ELEMENTS) && jSONObject.optJSONArray(VuiConstants.SCENE_ELEMENTS).length() > 0) {
                    removeElement(jSONObject.optJSONArray(VuiConstants.SCENE_ELEMENTS), str);
                }
            }
        }
    }

    public static String removeElementById(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(VuiConstants.SCENE_ELEMENTS)) {
                JSONArray jSONArray = jSONObject.getJSONArray(VuiConstants.SCENE_ELEMENTS);
                for (String str2 : list) {
                    removeElement(jSONArray, str2);
                }
                return String.valueOf(jSONArray);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
