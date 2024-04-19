package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
/* compiled from: DataLogModuleEntry.java */
/* renamed from: oa0  reason: default package */
/* loaded from: classes.dex */
public class oa0 implements IModuleEntry {
    public volatile IDataLog a;
    public Context b;

    public oa0(Context context) {
        this.b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == IDataLog.class) {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = new pa0(this.b);
                    }
                }
            }
            return this.a;
        }
        return null;
    }
}
