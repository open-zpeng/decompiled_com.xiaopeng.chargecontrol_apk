package com.xiaopeng.lib.framework.moduleinterface.syncmodule;
/* loaded from: classes.dex */
public class SyncData {
    public String key;
    public String value;

    public SyncData() {
    }

    public String toString() {
        StringBuilder a = jg.a("SyncData { key:");
        a.append(this.key);
        a.append("; value:");
        return jg.a(a, this.value, "; }");
    }

    public SyncData(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
