package com.xiaopeng.lib.framework.moduleinterface.configurationmodule;

import java.util.List;
/* loaded from: classes.dex */
public class ConfigurationChangeEvent {
    public List<IConfigurationData> mChangeList;

    public List<IConfigurationData> getChangeList() {
        return this.mChangeList;
    }

    public void setChangeList(List<IConfigurationData> list) {
        this.mChangeList = list;
    }

    public String toString() {
        StringBuilder a = jg.a("ConfigurationChangeEvent{list size:");
        List<IConfigurationData> list = this.mChangeList;
        a.append(list != null ? list.size() : 0);
        a.append("}");
        return a.toString();
    }
}
