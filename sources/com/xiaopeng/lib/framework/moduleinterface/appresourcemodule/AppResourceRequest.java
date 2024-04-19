package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import android.text.TextUtils;
import androidx.annotation.Keep;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes.dex */
public class AppResourceRequest {
    public static long longInc = -1;
    public boolean mCheckUpdate;
    public long mEffectiveDate;
    public long mId;
    public String mLocalPath;
    public String mOperate;
    public String mRemoteUri;
    public boolean mUnzip;
    public int mUpdatePolicy;
    public String mUriPath;
    public String mShared = "SHARED";
    public boolean mCoverRecord = true;

    public AppResourceRequest() {
        long j = longInc + 1;
        longInc = j;
        this.mId = j;
    }

    public static AppResourceRequest from(String src) {
        try {
            if (TextUtils.isEmpty(src)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(src);
            AppResourceRequest appResourceRequest = new AppResourceRequest();
            appResourceRequest.mId = jSONObject.optLong("id");
            appResourceRequest.mUpdatePolicy = jSONObject.optInt("update_policy");
            appResourceRequest.mLocalPath = jSONObject.optString("local_path");
            appResourceRequest.mUriPath = jSONObject.optString("uri_path");
            appResourceRequest.mRemoteUri = jSONObject.optString("remote_uri");
            appResourceRequest.mShared = jSONObject.optString("shared", "SHARED");
            appResourceRequest.mEffectiveDate = jSONObject.optLong("effective");
            appResourceRequest.mUnzip = jSONObject.optBoolean("unzip");
            appResourceRequest.mOperate = jSONObject.optString("operate");
            appResourceRequest.mCoverRecord = jSONObject.optBoolean("cover_record", true);
            appResourceRequest.mCheckUpdate = jSONObject.optBoolean("check_update");
            return appResourceRequest;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean stringEqual(String le, String ri) {
        if (TextUtils.isEmpty(le) && TextUtils.isEmpty(ri)) {
            return true;
        }
        return le != null && le.equals(ri);
    }

    public AppResourceRequest checkUpdate(boolean check) {
        this.mCheckUpdate = check;
        return this;
    }

    public AppResourceRequest coverRecord(boolean replace) {
        this.mCoverRecord = replace;
        return this;
    }

    public AppResourceRequest effectiveDate(long date) {
        this.mEffectiveDate = date;
        return this;
    }

    public boolean equals(Object o) {
        if (o instanceof AppResourceRequest) {
            AppResourceRequest appResourceRequest = (AppResourceRequest) o;
            return this.mUpdatePolicy == appResourceRequest.updatePolicy() && this.mEffectiveDate == appResourceRequest.mEffectiveDate && stringEqual(this.mLocalPath, appResourceRequest.mLocalPath) && stringEqual(this.mUriPath, appResourceRequest.mUriPath) && stringEqual(this.mRemoteUri, appResourceRequest.mRemoteUri) && stringEqual(this.mOperate, appResourceRequest.mOperate) && stringEqual(this.mShared, appResourceRequest.mShared) && this.mCheckUpdate == appResourceRequest.mCheckUpdate && this.mCoverRecord == appResourceRequest.mCoverRecord && this.mUnzip == appResourceRequest.mUnzip && this.mId == appResourceRequest.mId;
        }
        return false;
    }

    public boolean isCoverRecord() {
        return this.mCoverRecord;
    }

    public boolean isUnzip() {
        return this.mUnzip;
    }

    public AppResourceRequest localPath(String path) {
        this.mLocalPath = path;
        return this;
    }

    public String operate() {
        return this.mOperate;
    }

    public AppResourceRequest remoteUri(String uri) {
        this.mRemoteUri = uri;
        return this;
    }

    public AppResourceRequest shared(String shared) {
        this.mShared = shared;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("update_policy", this.mUpdatePolicy);
            jSONObject.put("local_path", this.mLocalPath);
            jSONObject.put("uri_path", this.mUriPath);
            jSONObject.put("remote_uri", this.mRemoteUri);
            jSONObject.put("effective", this.mEffectiveDate);
            jSONObject.put("unzip", this.mUnzip);
            jSONObject.put("shared", this.mShared);
            jSONObject.put("operate", this.mOperate);
            jSONObject.put("id", this.mId);
            jSONObject.put("check_update", this.mCheckUpdate);
            jSONObject.put("cover_record", this.mCoverRecord);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public AppResourceRequest unzip(boolean unzip) {
        this.mUnzip = unzip;
        return this;
    }

    public AppResourceRequest updatePolicy(int policy) {
        this.mUpdatePolicy = policy;
        return this;
    }

    public AppResourceRequest uriPath(String uriPath) {
        this.mUriPath = uriPath;
        return this;
    }

    public boolean checkUpdate() {
        return this.mCheckUpdate;
    }

    public long effectiveDate() {
        return this.mEffectiveDate;
    }

    public String localPath() {
        return this.mLocalPath;
    }

    public AppResourceRequest operate(String op) {
        this.mOperate = op;
        return this;
    }

    public String remoteUri() {
        return this.mRemoteUri;
    }

    public String shared() {
        return this.mShared;
    }

    public int updatePolicy() {
        return this.mUpdatePolicy;
    }

    public String uriPath() {
        return this.mUriPath;
    }
}
