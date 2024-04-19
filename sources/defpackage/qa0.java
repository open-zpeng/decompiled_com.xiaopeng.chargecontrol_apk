package defpackage;

import android.content.Context;
import android.os.SystemClock;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import defpackage.wa0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MoleEvent.java */
/* renamed from: qa0  reason: default package */
/* loaded from: classes.dex */
public class qa0 implements IMoleEvent {
    public Map<String, Object> a = new ConcurrentHashMap();

    /* compiled from: MoleEvent.java */
    /* renamed from: qa0$a */
    /* loaded from: classes.dex */
    public class a extends fx<Map<String, Object>> {
        public a(qa0 qa0Var) {
        }
    }

    public qa0(Context context) {
        this.a.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.a.put(IStatEvent.CUSTOM_MODULE_VERSION, ra0.b(context));
        this.a.put(IStatEvent.CUSTOM_NETWORK, ra0.a(context));
        this.a.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.a.put(IStatEvent.CUSTOM_DEVICE_MCUVER, ra0.a());
        this.a.put(IStatEvent.CUSTOM_UID, Long.valueOf(hb0.a()));
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.a.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent
    public String toJson() {
        return wa0.b.a.a.a(this.a, new a(this).b);
    }

    public void a(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.a.put(str, number);
    }

    public void a(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.a.put(str, bool);
    }

    public void a(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.a.put(str, ch);
    }
}
