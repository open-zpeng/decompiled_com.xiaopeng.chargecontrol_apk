package com.xiaopeng.lib.apirouter;

import android.util.Pair;
import java.util.List;
/* loaded from: classes.dex */
public class RemoteMethod {
    public int mId;
    public String mMethodName;
    public List<Pair<String, String>> mParamsList;

    public RemoteMethod(String str, int i, List<Pair<String, String>> list) {
        this.mMethodName = str;
        this.mId = i;
        this.mParamsList = list;
    }

    public int getId() {
        return this.mId;
    }

    public String getMethodName() {
        return this.mMethodName;
    }

    public List<Pair<String, String>> getParamsList() {
        return this.mParamsList;
    }
}
