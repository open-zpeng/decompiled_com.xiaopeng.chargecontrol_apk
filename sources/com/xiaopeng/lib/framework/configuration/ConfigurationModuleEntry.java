package com.xiaopeng.lib.framework.configuration;

import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.IConfiguration;
/* loaded from: classes.dex */
public class ConfigurationModuleEntry implements IModuleEntry {
    public ConfigurationImpl mImpl = new ConfigurationImpl();

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == IConfiguration.class) {
            return this.mImpl;
        }
        return null;
    }
}
