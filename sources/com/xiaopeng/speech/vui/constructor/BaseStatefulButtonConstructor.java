package com.xiaopeng.speech.vui.constructor;

import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.utils.LogUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseStatefulButtonConstructor implements IStatefulButtonConstructor {
    public String TAG = BaseStatefulButtonConstructor.class.getSimpleName();
    public String[] stateNames;

    public void setStatefulButtonData(ec0 ec0Var, int i, String... strArr) {
        if (ec0Var == null) {
            LogUtils.e(this.TAG, "vuiFriendly is null");
        } else if (strArr != null && strArr.length != 0) {
            if (i >= 0 && i <= strArr.length - 1) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    this.stateNames = new String[strArr.length];
                    int i2 = 0;
                    while (i2 < strArr.length) {
                        JSONObject jSONObject2 = new JSONObject();
                        StringBuilder sb = new StringBuilder();
                        sb.append("state_");
                        int i3 = i2 + 1;
                        sb.append(i3);
                        String sb2 = sb.toString();
                        this.stateNames[i2] = sb2;
                        jSONObject2.put(sb2, strArr[i2]);
                        jSONArray.put(jSONObject2);
                        i2 = i3;
                    }
                    jSONObject.put("states", jSONArray);
                    jSONObject.put("curState", this.stateNames[i]);
                    ec0Var.a(jSONObject);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    String str = this.TAG;
                    StringBuilder a = jg.a("e:");
                    a.append(e.getMessage());
                    LogUtils.e(str, a.toString());
                    return;
                }
            }
            LogUtils.e(this.TAG, "currIndex 超过vuilabels数组边界");
        } else {
            LogUtils.e(this.TAG, "vuilabels  is empty");
        }
    }

    public void setStatefulButtonData(ec0 ec0Var, int i, int i2, int i3, float f, String... strArr) {
        if (ec0Var == null) {
            LogUtils.e(this.TAG, "vuiFriendly is null");
        } else if (strArr != null && strArr.length != 0) {
            if (i >= 0 && i <= strArr.length - 1) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    this.stateNames = new String[strArr.length];
                    int i4 = 0;
                    while (i4 < strArr.length) {
                        JSONObject jSONObject2 = new JSONObject();
                        StringBuilder sb = new StringBuilder();
                        sb.append("state_");
                        int i5 = i4 + 1;
                        sb.append(i5);
                        String sb2 = sb.toString();
                        this.stateNames[i4] = sb2;
                        jSONObject2.put(sb2, strArr[i4]);
                        jSONArray.put(jSONObject2);
                        i4 = i5;
                    }
                    jSONObject.put(VuiConstants.PROPS_MINVALUE, i2);
                    jSONObject.put(VuiConstants.PROPS_MAXVALUE, i3);
                    jSONObject.put(VuiConstants.PROPS_INTERVAL, f);
                    jSONObject.put("states", jSONArray);
                    jSONObject.put("curState", this.stateNames[i]);
                    ec0Var.a(jSONObject);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    String str = this.TAG;
                    StringBuilder a = jg.a("e:");
                    a.append(e.getMessage());
                    LogUtils.e(str, a.toString());
                    return;
                }
            }
            LogUtils.e(this.TAG, "currIndex 超过vuilabels数组边界");
        } else {
            LogUtils.e(this.TAG, "vuilabels  is empty");
        }
    }
}
