package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
/* compiled from: CounterFactory.java */
/* renamed from: sa0  reason: default package */
/* loaded from: classes.dex */
public class sa0 implements ICounterFactory {

    /* compiled from: CounterFactory.java */
    /* renamed from: sa0$b */
    /* loaded from: classes.dex */
    public static final class b {
        public static final sa0 a = new sa0(null);
    }

    public /* synthetic */ sa0(a aVar) {
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createDailyCounter(Context context, String str) {
        return new ta0(context, str, 86400000L);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createHourlyCounter(Context context, String str) {
        return new ta0(context, str, 3600000L);
    }
}
