package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.Keep;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes.dex */
public class AppResourceResponse {
    public long mCode;
    public String mData;
    public Object mExtra;
    public String mMsg;
    public AppResourceRequest mRequest;
    public String mResult;

    public static AppResourceResponse from(String src) {
        try {
            if (TextUtils.isEmpty(src)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(src);
            AppResourceResponse appResourceResponse = new AppResourceResponse();
            appResourceResponse.mRequest = AppResourceRequest.from(jSONObject.optString("request"));
            appResourceResponse.mResult = jSONObject.optString("result");
            appResourceResponse.mData = jSONObject.optString("data");
            appResourceResponse.mCode = jSONObject.optLong("code");
            appResourceResponse.mMsg = jSONObject.optString("msg");
            return appResourceResponse;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AppResourceResponse code(long code) {
        this.mCode = code;
        return this;
    }

    public AppResourceResponse data(String data) {
        this.mData = data;
        return this;
    }

    public Object extra() {
        return this.mExtra;
    }

    public AssetFileDescriptor getFileDescriptor() {
        Object obj = this.mExtra;
        if (obj instanceof AssetFileDescriptor) {
            return (AssetFileDescriptor) obj;
        }
        return null;
    }

    public AppResourceResponse msg(String msg) {
        this.mMsg = msg;
        return this;
    }

    public AppResourceResponse request(AppResourceRequest request) {
        this.mRequest = request;
        return this;
    }

    public AppResourceResponse result(String result) {
        this.mResult = result;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request", this.mRequest);
            jSONObject.put("result", this.mResult);
            jSONObject.put("data", this.mData);
            jSONObject.put("code", this.mCode);
            jSONObject.put("msg", this.mMsg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public long code() {
        return this.mCode;
    }

    public String data() {
        return this.mData;
    }

    public AppResourceResponse extra(Object mExtra) {
        this.mExtra = mExtra;
        return this;
    }

    public String msg() {
        return this.mMsg;
    }

    public AppResourceRequest request() {
        return this.mRequest;
    }

    public String result() {
        return this.mResult;
    }
}
