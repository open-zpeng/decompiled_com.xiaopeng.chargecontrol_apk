package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import defpackage.wa0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: StatEvent.java */
/* renamed from: ra0  reason: default package */
/* loaded from: classes.dex */
public class ra0 implements IStatEvent {
    public static String c;
    public static String d;
    public String a;
    public Map<String, Object> b = new ConcurrentHashMap();

    /* compiled from: StatEvent.java */
    /* renamed from: ra0$a */
    /* loaded from: classes.dex */
    public class a extends fx<Map<String, Object>> {
        public a(ra0 ra0Var) {
        }
    }

    public ra0(Context context) {
        this.b.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.b.put(IStatEvent.CUSTOM_MODULE_VERSION, b(context));
        this.b.put(IStatEvent.CUSTOM_NETWORK, a(context));
        this.b.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.b.put(IStatEvent.CUSTOM_DEVICE_MCUVER, a());
        this.b.put(IStatEvent.CUSTOM_UID, Long.valueOf(hb0.a()));
    }

    public static String a(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length <= 0) ? "" : split[0];
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(d)) {
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                Log.w("StatEvent", "getVersion fail!", e);
                return "Unknown";
            }
        }
        return d;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String getEventName() {
        return this.a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.b.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void setEventName(String str) {
        this.a = str;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String toJson() {
        this.b.put(IStatEvent.CUSTOM_MODULE, a(this.a));
        this.b.put(IStatEvent.CUSTOM_EVENT, this.a);
        return wa0.b.a.a.a(this.b, new a(this).b);
    }

    public String toString() {
        StringBuilder a2 = jg.a("StatEvent{eventName='");
        a2.append(this.a);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.b.put(str, number);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.b.put(str, bool);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.b.put(str, ch);
    }

    public static String a() {
        if (TextUtils.isEmpty(c)) {
            c = SystemProperties.get("persist.sys.mcu.version");
        }
        if (TextUtils.isEmpty(c)) {
            c = SystemProperties.get("sys.mcu.version");
        }
        return c;
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getType() == 1 ? "WIFI" : "";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 11:
                default:
                    return "";
                case 13:
                    return "4G";
            }
        }
        return "";
    }
}
