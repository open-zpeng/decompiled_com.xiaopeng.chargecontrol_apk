package com.xiaopeng.lib.framework.moduleinterface.syncmodule;

import java.util.List;
/* loaded from: classes.dex */
public final class SyncRestoreEvent {
    public List<SyncData> list;
    public long uid;

    public SyncRestoreEvent(long uid, List<SyncData> list) {
        this.uid = uid;
        this.list = list;
    }

    public String toString() {
        StringBuilder a = jg.a("SyncRestoreEvent { uid:");
        a.append(this.uid);
        a.append("; list size:");
        List<SyncData> list = this.list;
        a.append(list == null ? 0 : list.size());
        a.append("; }");
        return a.toString();
    }
}
