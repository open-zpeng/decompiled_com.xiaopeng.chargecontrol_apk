package com.xiaopeng.lib.framework.moduleinterface.syncmodule;
/* loaded from: classes.dex */
public final class SyncSaveAllEvent {
    public long uid;

    public SyncSaveAllEvent(long uid) {
        this.uid = uid;
    }

    public String toString() {
        StringBuilder a = jg.a("SyncSaveAllEvent { uid:");
        a.append(this.uid);
        a.append("; }");
        return a.toString();
    }
}
